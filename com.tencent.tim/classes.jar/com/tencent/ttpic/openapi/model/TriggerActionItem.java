package com.tencent.ttpic.openapi.model;

public class TriggerActionItem
{
  public String id;
  public long mActionDelay;
  public TriggerExpression mTriggerExpression;
  
  public TriggerActionItem() {}
  
  public TriggerActionItem(long paramLong)
  {
    this.mTriggerExpression = new TriggerExpression(1);
    this.mActionDelay = paramLong;
  }
  
  public TriggerActionItem(TriggerExpression paramTriggerExpression, long paramLong)
  {
    this.mTriggerExpression = paramTriggerExpression;
    this.mActionDelay = paramLong;
  }
  
  public int getTriggerType()
  {
    if (this.mTriggerExpression != null) {
      return this.mTriggerExpression.mTriggerType;
    }
    return -1;
  }
  
  public boolean isTriggered()
  {
    if (this.mTriggerExpression != null) {
      return this.mTriggerExpression.isTriggered();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerActionItem
 * JD-Core Version:    0.7.0.1
 */