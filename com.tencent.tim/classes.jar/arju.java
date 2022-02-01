import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import mqq.util.WeakReference;

public class arju
{
  protected WebViewProgressBar a;
  private int mAlpha = 255;
  private float mCurrAlphaRate;
  private float mCurrWidth;
  private float mCurrentProgress;
  private boolean mFinishAllWidth;
  private Handler mHandler = new arju.b(this);
  public boolean mIsVisible = true;
  private int mProgressBarWidth;
  private float mProgressRate;
  private long mStartLoadingTime;
  private float mStartWidth;
  private byte mStatus = -1;
  private byte mStep = 6;
  
  private long smoothUseTime(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 30L) {
      l = 30L;
    }
    return l;
  }
  
  public void a(WebViewProgressBar paramWebViewProgressBar)
  {
    this.a = paramWebViewProgressBar;
  }
  
  public void enterStatus(byte paramByte)
  {
    if (!this.mIsVisible) {}
    do
    {
      return;
      switch (paramByte)
      {
      default: 
        return;
      }
    } while (this.mStatus == 0);
    this.mStatus = 0;
    performLoadingStart();
    return;
    performPartOneFinish();
    return;
    if ((this.mStatus == 0) || (this.mStatus == 1)) {
      performLoadingFinish();
    }
    this.mStatus = 2;
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public byte getCurStatus()
  {
    return this.mStatus;
  }
  
  public float getCurrWidth()
  {
    return this.mCurrWidth;
  }
  
  public byte getLoadingStep()
  {
    return this.mStep;
  }
  
  public void performLoadingFinish()
  {
    arju.a.a(1).recordFinish();
    this.mStartLoadingTime = System.currentTimeMillis();
    this.mStep = 5;
    this.mProgressRate = 0.1333333F;
    if (this.mCurrentProgress <= 60.0F) {
      this.mProgressRate = ((40.0F + (60.0F - this.mCurrentProgress) * 0.5F) / 300.0F);
    }
    for (this.mCurrAlphaRate = 0.8166667F;; this.mCurrAlphaRate = (245.0F * this.mProgressRate / (100.0F - this.mCurrentProgress)))
    {
      refreshUI();
      return;
    }
  }
  
  public void performLoadingStart()
  {
    int j = arju.a.a(0).recordStart();
    int i = j;
    if (j <= 0) {
      i = arju.a.a(0).getDefaultDuration();
    }
    this.mProgressRate = (20.0F / i);
    this.mCurrentProgress = 0.0F;
    this.mStep = 0;
    this.mCurrWidth = this.mStartWidth;
    this.mAlpha = 255;
    this.mStartLoadingTime = System.currentTimeMillis();
    if (this.a != null) {
      this.a.setVisibility(0);
    }
    refreshUI();
  }
  
  public void performPartOneFinish()
  {
    arju.a.a(0).recordFinish();
    int j = arju.a.a(1).recordStart();
    int i = j;
    if (j <= 0) {
      i = arju.a.a(1).getDefaultDuration();
    }
    this.mProgressRate = (60.0F / i);
    this.mStartLoadingTime = System.currentTimeMillis();
    this.mStep = 2;
    this.mStatus = 1;
    refreshUI();
  }
  
  public void refreshUI()
  {
    long l1;
    if (this.mStep != 6)
    {
      l1 = System.currentTimeMillis();
      if (this.mCurrentProgress < 100.0F) {
        break label66;
      }
      reset();
    }
    for (;;)
    {
      this.mHandler.removeMessages(200);
      this.mHandler.sendEmptyMessageDelayed(200, 20L);
      if (this.a != null) {
        this.a.invalidate();
      }
      return;
      label66:
      long l2;
      float f;
      switch (this.mStep)
      {
      default: 
        break;
      case 0: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 20.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 1;
          this.mProgressRate /= 5.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 1: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 98.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 4;
          this.mCurrentProgress = 98.0F;
          this.mProgressRate = 0.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 2: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 80.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 3;
          this.mProgressRate /= 20.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 3: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 98.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 4;
          this.mProgressRate = 0.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 5: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        this.mCurrentProgress += (float)l2 * this.mProgressRate;
        this.mStartLoadingTime = l1;
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        if (this.mFinishAllWidth)
        {
          if (this.mCurrWidth >= this.mProgressBarWidth) {
            this.mCurrWidth = this.mProgressBarWidth;
          }
        }
        else
        {
          this.mAlpha -= (int)((float)l2 * this.mCurrAlphaRate);
          if (this.mAlpha <= 0)
          {
            reset();
            this.mAlpha = 0;
          }
        }
        break;
      case 4: 
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
      }
    }
  }
  
  public void reset()
  {
    this.mStep = 6;
    this.mCurrentProgress = 0.0F;
    this.mStartWidth = ((int)(this.mCurrentProgress * this.mProgressBarWidth / 100.0F));
    this.mAlpha = 255;
    this.mStartLoadingTime = System.currentTimeMillis();
  }
  
  public void setProgressBarWidth(int paramInt)
  {
    this.mProgressBarWidth = paramInt;
  }
  
  public void xW(boolean paramBoolean)
  {
    if (paramBoolean == this.mIsVisible) {}
    while (paramBoolean) {
      return;
    }
    if (this.mStatus != 2) {
      enterStatus((byte)2);
    }
    this.a.setVisibility(8);
    this.mIsVisible = false;
  }
  
  static class a
  {
    private static a a;
    private static a b;
    private int m2GDuration = 9000;
    private int mLastSampleIndex;
    private int mNetType = 0;
    private int mNon2GDuration = 1800;
    private int mPhaseType = 0;
    private int[] mSampleDuration;
    private long mStartingTime;
    
    public a(int paramInt)
    {
      this.mPhaseType = paramInt;
      this.mNetType = 0;
      if (this.mPhaseType == 0) {
        this.m2GDuration = 9000;
      }
      for (this.mNon2GDuration = 1800;; this.mNon2GDuration = 1200)
      {
        this.mStartingTime = 0L;
        this.mLastSampleIndex = 0;
        this.mSampleDuration = new int[3];
        paramInt = 0;
        while (paramInt < 3)
        {
          this.mSampleDuration[paramInt] = 0;
          paramInt += 1;
        }
        this.m2GDuration = 6000;
      }
    }
    
    public static a a(int paramInt)
    {
      if (paramInt == 0)
      {
        if (a == null) {
          a = new a(0);
        }
        return a;
      }
      if (b == null) {
        b = new a(1);
      }
      return b;
    }
    
    private void clearSampleDuration()
    {
      int i = 0;
      while (i < 3)
      {
        this.mSampleDuration[i] = 0;
        i += 1;
      }
      this.mLastSampleIndex = 0;
    }
    
    private int getSampleDuration()
    {
      int i = 0;
      int j = 0;
      int m;
      for (int k = 0; i < 3; k = m)
      {
        int n = j;
        m = k;
        if (this.mSampleDuration[i] > 0)
        {
          m = k + 1;
          n = j + this.mSampleDuration[i];
        }
        i += 1;
        j = n;
      }
      if (k > 0) {
        return j / k;
      }
      return 0;
    }
    
    public int getDefaultDuration()
    {
      if (2 == this.mNetType) {
        return this.m2GDuration;
      }
      return this.mNon2GDuration;
    }
    
    public void recordFinish()
    {
      int j = (int)(System.currentTimeMillis() - this.mStartingTime);
      int k = getSampleDuration();
      int i;
      if (this.mNetType == 2)
      {
        i = this.m2GDuration;
        if (k != 0) {
          break label90;
        }
        i *= 3;
        label36:
        if (j > 100) {
          if (j <= i) {
            break label97;
          }
        }
      }
      for (;;)
      {
        this.mSampleDuration[this.mLastSampleIndex] = ((int)(i * 1.2F));
        i = this.mLastSampleIndex + 1;
        this.mLastSampleIndex = i;
        this.mLastSampleIndex = (i % 3);
        return;
        i = this.mNon2GDuration;
        break;
        label90:
        i = k * 3;
        break label36;
        label97:
        i = j;
      }
    }
    
    public int recordStart()
    {
      this.mStartingTime = System.currentTimeMillis();
      int j = jqc.getNetWorkType();
      int i;
      if (this.mNetType != j)
      {
        i = 1;
        this.mNetType = j;
        if (i == 0) {
          break label62;
        }
        if (this.mNetType != 2) {
          break label54;
        }
        i = this.m2GDuration;
        label43:
        clearSampleDuration();
      }
      label54:
      label62:
      do
      {
        return i;
        i = 0;
        break;
        i = this.mNon2GDuration;
        break label43;
        j = getSampleDuration();
        i = j;
      } while (j > 0);
      return 0;
    }
  }
  
  static class b
    extends Handler
  {
    final WeakReference<arju> j;
    
    public b(arju paramarju)
    {
      super();
      this.j = new WeakReference(paramarju);
    }
    
    public void handleMessage(Message paramMessage)
    {
      arju localarju = (arju)this.j.get();
      if (localarju == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      localarju.refreshUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arju
 * JD-Core Version:    0.7.0.1
 */