package wf7;

public class bl
{
  private int eE;
  protected int fl = -1;
  private d fm = null;
  private bl.a fn = null;
  private int fo;
  private String fp;
  private int fq = 1;
  private float fr = 1.0F;
  private boolean fs = false;
  private boolean ft = false;
  private boolean fu = false;
  private boolean fv = false;
  private c fw = null;
  
  public int I()
  {
    return this.fl;
  }
  
  public int J()
  {
    return this.fq;
  }
  
  public float K()
  {
    return this.fr;
  }
  
  public int L()
  {
    return this.eE;
  }
  
  public int M()
  {
    return this.fo;
  }
  
  public String N()
  {
    return this.fp;
  }
  
  public boolean O()
  {
    return this.fu;
  }
  
  public boolean P()
  {
    return this.fs;
  }
  
  public boolean Q()
  {
    return this.ft;
  }
  
  public d R()
  {
    return this.fm;
  }
  
  public boolean S()
  {
    return I() >= 2;
  }
  
  public void a(float paramFloat)
  {
    this.fr = paramFloat;
  }
  
  public void a(c paramc)
  {
    this.fw = paramc;
  }
  
  public void a(d paramd)
  {
    this.fm = paramd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.fs = paramBoolean;
    if ((paramBoolean) && (this.fu)) {
      this.fu = false;
    }
    if ((paramBoolean) && (this.fv)) {
      this.fv = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.ft = paramBoolean;
  }
  
  public void d(String paramString)
  {
    this.fp = paramString;
  }
  
  public void t(int paramInt)
  {
    this.fl = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WifiCloudInfo{mFreeWifiLevel=");
    localStringBuilder.append(this.fl);
    localStringBuilder.append(", mWifiType=");
    localStringBuilder.append(this.eE);
    localStringBuilder.append(", mSubWifiType=");
    localStringBuilder.append(this.fo);
    localStringBuilder.append(", mPoiDesc='");
    localStringBuilder.append(this.fp);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mReviewMarks=");
    localStringBuilder.append(this.fq);
    localStringBuilder.append(", mSortMarks=");
    localStringBuilder.append(this.fr);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void u(int paramInt)
  {
    this.fq = paramInt;
  }
  
  public void v(int paramInt)
  {
    this.eE = paramInt;
  }
  
  public void w(int paramInt)
  {
    this.fo = paramInt;
  }
  
  public boolean x(int paramInt)
  {
    int i = I();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 1)
    {
      bool1 = bool2;
      if (this.eE == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.bl
 * JD-Core Version:    0.7.0.1
 */