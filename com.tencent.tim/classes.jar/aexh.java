public abstract class aexh<DATA, CONFIG extends aext>
  extends aexe<DATA, CONFIG>
{
  private float am;
  private float an = -1.0F;
  private float[] cv;
  private float eX;
  
  public aexh(aexj paramaexj)
  {
    super(paramaexj);
  }
  
  protected float a(long paramLong)
  {
    long l = this.WZ;
    return getScreenWidth() - (float)(paramLong - l) * this.eX;
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (!isTimeOut(paramLong1))
    {
      aeyw.i("BaseDanmaku", "onLayout, Y = " + paramFloat2 + ", danmaku = " + toString());
      this.am = a(paramLong2);
      if (!isShown())
      {
        this.an = paramFloat2;
        setVisibility(true);
      }
      return;
    }
    setVisibility(false);
  }
  
  public void aG(float paramFloat)
  {
    this.am = paramFloat;
  }
  
  public void aH(float paramFloat)
  {
    this.an = paramFloat;
  }
  
  public void cXW()
  {
    super.cXW();
    this.eX = ((int)(getScreenWidth() + this.mPaintWidth) / (float)this.a.value());
  }
  
  public float getBottom()
  {
    return this.an + this.mPaintHeight;
  }
  
  public float[] getCollisionRectAtTime(long paramLong)
  {
    if (!isMeasured()) {
      return null;
    }
    float f = a(paramLong);
    if (this.cv == null) {
      this.cv = new float[4];
    }
    this.cv[0] = (f - aexj.a().aY());
    this.cv[1] = this.an;
    this.cv[2] = (f + this.mPaintWidth + this.vT);
    this.cv[3] = (this.an + this.mPaintHeight);
    return this.cv;
  }
  
  public float getLeft()
  {
    return this.am;
  }
  
  public float[] getRectAtTime(long paramLong)
  {
    if (!isMeasured()) {
      return null;
    }
    float f = a(paramLong);
    if (this.cv == null) {
      this.cv = new float[4];
    }
    this.cv[0] = f;
    this.cv[1] = this.an;
    this.cv[2] = (f + this.mPaintWidth);
    this.cv[3] = (this.an + this.mPaintHeight);
    return this.cv;
  }
  
  public float getRight()
  {
    return this.am + this.mPaintWidth;
  }
  
  public float getSpeedX()
  {
    return -this.eX;
  }
  
  public float getTop()
  {
    return this.an;
  }
  
  public void iZ(long paramLong)
  {
    this.am = a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexh
 * JD-Core Version:    0.7.0.1
 */