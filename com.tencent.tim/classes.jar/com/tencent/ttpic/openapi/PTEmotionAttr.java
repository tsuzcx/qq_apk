package com.tencent.ttpic.openapi;

import java.util.List;

public class PTEmotionAttr
{
  public static final int EMOTION_TYPE_SMILE = 14;
  public static final String EXPRESSION_DETECT_FOR_EVERY_FACE = "expressionDetectForEveryFace";
  private boolean isCurrentFrameSmile = false;
  private boolean isSmile = false;
  private List<Boolean> isSmiles;
  private List<Integer> smileValues;
  private int value = 0;
  
  public List<Boolean> getIsSmiles()
  {
    return this.isSmiles;
  }
  
  public List<Integer> getSmileValues()
  {
    return this.smileValues;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public boolean isSmile()
  {
    if (this.isCurrentFrameSmile) {
      return true;
    }
    return this.isSmile;
  }
  
  public void setCurrentFrameSmile(boolean paramBoolean)
  {
    this.isCurrentFrameSmile = paramBoolean;
  }
  
  public void setIsSmiles(List<Boolean> paramList)
  {
    this.isSmiles = paramList;
  }
  
  public void setSmile(boolean paramBoolean)
  {
    this.isSmile = paramBoolean;
  }
  
  public void setSmileValues(List<Integer> paramList)
  {
    this.smileValues = paramList;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTEmotionAttr
 * JD-Core Version:    0.7.0.1
 */