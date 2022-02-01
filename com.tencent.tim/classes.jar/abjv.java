import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.StaticLayout;

public class abjv
{
  private abjr a;
  private RectF ar;
  public boolean bDt;
  private boolean baj;
  public String bgG;
  public int btH = 20000;
  public StaticLayout d;
  private Bitmap eE;
  public float ek;
  public float jU;
  public float jV;
  public float jW;
  public int mActionId;
  public int mAlpha = 255;
  public int mHeight;
  public long mLastUpdateTime;
  public int mLeftPadding;
  public boolean mMeasured;
  public float mScale = 1.0F;
  public long mStartTime;
  public float mStartX;
  public float mStartY;
  public CharSequence mText;
  public int mTextColor = -16777216;
  public float mTextSize = 24.0F;
  public int mTopPadding;
  public String mUin;
  public int mWidth;
  
  public abjv(abjr paramabjr, float paramFloat1, float paramFloat2, float paramFloat3, String paramString1, String paramString2)
  {
    this.mText = paramString2;
    this.bgG = paramString1;
    this.baj = true;
    this.mLeftPadding = ((int)(12.0F * paramFloat1));
    this.mTopPadding = ((int)(6.0F * paramFloat1));
    this.ar = new RectF(0.0F, 0.0F, paramFloat2, paramFloat3);
    long l = System.currentTimeMillis();
    this.mStartTime = l;
    this.mLastUpdateTime = l;
    this.a = paramabjr;
  }
  
  public void cCu()
  {
    if (this.a != null)
    {
      this.a.a(this);
      this.eE = this.a.a(this);
    }
  }
  
  public Bitmap getDrawingCache()
  {
    if ((this.eE != null) && (!this.eE.isRecycled())) {
      return this.eE;
    }
    if (this.a != null) {
      this.eE = this.a.a(this);
    }
    return this.eE;
  }
  
  public boolean isValidate()
  {
    return this.baj;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsAlive: ").append(this.baj).append(" mText: ").append(this.mText).append(" mMeasured: ").append(this.mMeasured).append(" mBgFilePath: ").append(this.bgG).append(" mActionId: ").append(this.mActionId).append(" mStartX: ").append(this.mStartX).append(" mStartY: ").append(this.mStartY).append(" mSpeedX: ").append(this.jV).append(" mSpeedY: ").append(this.jW).append(" mCurrentX: ").append(this.jU).append(" mCurrentY: ").append(this.ek).append(" mTextColor: ").append(this.mTextColor).append(" mTextSize: ").append(this.mTextSize).append(" mStartTime: ").append(this.mStartTime).append(" mAlpha: ").append(this.mAlpha).append(" mWidth: ").append(this.mWidth).append(" mHeight: ").append(this.mHeight).append(" mLeftPadding: ").append(this.mLeftPadding).append(" mTopPadding: ").append(this.mTopPadding).append(" mViewRect: ").append(this.ar);
    return localStringBuilder.toString();
  }
  
  public void updateState()
  {
    long l = System.currentTimeMillis();
    this.jU += this.jV * (float)(l - this.mLastUpdateTime);
    this.ek += this.jW * (float)(l - this.mLastUpdateTime);
    this.mLastUpdateTime = l;
    if (this.jU + this.mWidth >= 0.0F) {
      this.baj = true;
    }
    for (;;)
    {
      if (System.currentTimeMillis() - this.mStartTime >= this.btH) {
        this.baj = false;
      }
      return;
      if (this.bDt)
      {
        this.jU = this.ar.width();
        this.baj = true;
      }
      else
      {
        this.baj = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjv
 * JD-Core Version:    0.7.0.1
 */