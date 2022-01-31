package com.tencent.mobileqq.pb;

public abstract class PBPrimitiveField<T>
  extends PBField<T>
{
  private boolean hasFlag = false;
  
  public final boolean has()
  {
    return this.hasFlag;
  }
  
  public final void setHasFlag(boolean paramBoolean)
  {
    this.hasFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBPrimitiveField
 * JD-Core Version:    0.7.0.1
 */