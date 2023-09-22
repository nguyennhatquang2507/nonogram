package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum ScorePointStatus {
    TRUE,
    FALSE,
    BLANK;

}

public class NonogramAlgorithms {

    private static List<Integer> SCORE_LIST;

    public static List<Integer> getScoreList(NonogramNumber nonogramNumber, int size) {
        SCORE_LIST = new ArrayList<>(size);
        List<ScorePoint> scorePointList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            SCORE_LIST.add(0);
            scorePointList.add(new ScorePoint(i));
        }
        calculateNumber(nonogramNumber, size, scorePointList);
        return SCORE_LIST;
    }

    private static void calculateNumber(NonogramNumber nonogramNumber, int moveSize, List<ScorePoint> scorePointList) {
        int moveTime = moveSize - nonogramNumber.getMinimumSpaceQuantity() + 1;
        if (nonogramNumber.size() > 1) {
            for (int move = 0; move < moveTime; move++) {
                List<ScorePoint> scorePointListNew = addNumberForScorePointList(nonogramNumber.first(), scorePointList, move);
                int childMoveSpace = moveSize - nonogramNumber.first() - 1 - move;
                calculateNumber(nonogramNumber.child(), childMoveSpace, scorePointListNew);
            }
        } else {
            for (int move = 0; move < moveTime; move++) {
                List<ScorePoint> scorePointListNew = addNumberForScorePointList(nonogramNumber.first(), scorePointList, move);
                accumulateScore(scorePointListNew);
            }
        }
    }

    private static List<ScorePoint> addNumberForScorePointList(int number, List<ScorePoint> scorePointList, int moveTime) {
        List<ScorePoint> scorePointListsTemp = scorePointList.stream().map(ScorePoint::clone).collect(Collectors.toList());
        int countNumber = number;
        for (int i = 0; i < scorePointListsTemp.size(); i++) {
            ScorePoint scorePointTemp = scorePointListsTemp.get(i);
            if (scorePointTemp.status.equals(ScorePointStatus.BLANK)) {
                if (moveTime > 0) {
                    moveTime--;
                    scorePointTemp.status = ScorePointStatus.FALSE;
                    scorePointListsTemp.set(i, scorePointTemp);
                } else {
                    if (countNumber > 0) {
                        scorePointTemp.score = number;
                        scorePointTemp.status = ScorePointStatus.TRUE;
                        scorePointListsTemp.set(i, scorePointTemp);
                        countNumber--;
                    } else {
                        scorePointTemp.status = ScorePointStatus.FALSE;
                        scorePointListsTemp.set(i, scorePointTemp);
                        break;
                    }
                }
            }
        }
        return scorePointListsTemp;
    }

    public static void accumulateScore(List<ScorePoint> scorePointList) {
        for (ScorePoint scorePoint : scorePointList) {
            switch (scorePoint.status) {
                case TRUE -> SCORE_LIST.set(scorePoint.index, SCORE_LIST.get(scorePoint.index) + scorePoint.score);
                case BLANK -> {
                    return;
                }
            }

        }
    }


}

class ScorePoint implements Cloneable {
    public int score;
    public ScorePointStatus status;
    public int index;

    public ScorePoint(int index) {
        this.index = index;
        score = 0;
        status = ScorePointStatus.BLANK;
    }

    public ScorePoint(int score, ScorePointStatus status, int index) {
        super();
        this.score = score;
        this.status = status;
        this.index = index;
    }

    @Override
    protected ScorePoint clone() {
        ScorePoint clone = null;
        try {
            clone = (ScorePoint) super.clone();
            //Copy new date object to cloned method
            clone.status = this.status;
            clone.score = this.score;
            clone.index = this.index;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
        return clone;
    }

    @Override
    public String toString() {
        return "[Score: " + score + " Index: " + index + " Status: " + status + "]";
    }
}

