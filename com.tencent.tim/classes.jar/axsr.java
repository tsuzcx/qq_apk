import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;

public class axsr
  extends axpn
{
  private PtvTemplateManager.b a = new axss(this);
  private ayzs b = (ayzs)axov.a(3);
  private PtvTemplateManager.PtvTemplateInfo e = this.b.b(paramString);
  private AppInterface mApp = axov.d();
  private float mProgress = 0.0F;
  private int mState = 2;
  
  public axsr(String paramString)
  {
    super(null);
    if ((this.e != null) && (this.e.usable)) {
      this.mState = 3;
    }
    while (this.e != null) {
      return;
    }
    this.mState = 3;
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    paramActivity = (EffectsCameraCaptureView)paramActivity.findViewById(2131364201);
    if ((paramActivity != null) && (!paramActivity.auY()))
    {
      paramActivity.setFaceEffect("");
      this.b.aq("0", 0, "");
      axpa.eGt = 0;
    }
  }
  
  public int Rq()
  {
    for (;;)
    {
      try
      {
        int i;
        if (this.e == null)
        {
          this.mState = 3;
          i = this.mState;
          return i;
        }
        if (!this.e.usable)
        {
          this.b.a(this.mApp, this.e, this.a);
          eNI();
          this.mState = 1;
          i = this.mState;
          continue;
        }
        if (this.e.downloading)
        {
          this.mState = 1;
          continue;
        }
        this.mProgress = 1.0F;
      }
      finally {}
      this.mState = 3;
      eNJ();
    }
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    paramActivity = (EffectsCameraCaptureView)paramActivity.findViewById(2131364201);
    if ((this.e != null) && (this.e.usable) && (paramActivity != null))
    {
      String str = ayzs.bYM + this.e.name;
      paramActivity.setFaceEffect(str);
      this.b.c(this.e, 111);
      this.b.aq(this.e.id, this.e.categoryId, str);
      return 0;
    }
    return -1;
  }
  
  public float getProgress()
  {
    try
    {
      float f = this.mProgress;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getState()
  {
    try
    {
      int i = this.mState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsr
 * JD-Core Version:    0.7.0.1
 */