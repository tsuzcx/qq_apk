package com.tencent.ttpic.model;

public class GenderRange
{
  public float max = 10.0F;
  public float min = -10.0F;
  public float value = -2.0F;
  
  public void clearStatus()
  {
    this.value = -2.0F;
  }
  
  public boolean isHit()
  {
    return (this.min <= this.value) && (this.value < this.max);
  }
  
  public void setValue(float paramFloat)
  {
    if (this.value < 0.0F) {}
    for (;;)
    {
      this.value = paramFloat;
      return;
      paramFloat = this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.GenderRange
 * JD-Core Version:    0.7.0.1
 */