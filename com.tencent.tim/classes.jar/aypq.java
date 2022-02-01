import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.CodecDecodeRunnable;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.DecodeRunnable;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.DecodeRunnable.a;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.3;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aypq
  implements DecodeRunnable.a
{
  private List<Bitmap> NC = new ArrayList();
  private DecodeRunnable a;
  private ayym b;
  private boolean dAp;
  private boolean dzr;
  private Context mContext;
  private long mEndTime;
  private int mFrameCount;
  private int mFrameHeight;
  private int mFrameWidth;
  private boolean mIsLandscape;
  private WeakReference<aypq.a> mListenerRef;
  private int mRotation;
  private long mStartTime;
  private String mVideoPath;
  
  public aypq(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mContext = paramContext;
    this.dzr = paramBoolean1;
    this.mIsLandscape = paramBoolean2;
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i;
    int j;
    if (paramBoolean)
    {
      i = paramBitmap.getHeight();
      if (!paramBoolean) {
        break label181;
      }
      j = paramBitmap.getWidth();
      label26:
      int k = ayyh.eNn;
      if (j <= k) {
        break label226;
      }
      i = (int)(i * k / j);
      j = k;
    }
    label181:
    label226:
    for (;;)
    {
      i = alwy.iN(i);
      j = alwy.iN(j);
      GaussianBlurFilter localGaussianBlurFilter = new GaussianBlurFilter();
      localGaussianBlurFilter.init(paramBitmap.getWidth(), paramBitmap.getHeight());
      Object localObject;
      if (localGaussianBlurFilter.isInitSucc())
      {
        localObject = aqhu.a(paramContext, aqhu.U(paramBitmap), 0.4F, 25.0F);
        paramContext = (Context)localObject;
        if (localObject != null)
        {
          paramContext = new Canvas();
          paramContext.setBitmap((Bitmap)localObject);
          paramContext.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramContext = (Context)localObject;
        }
      }
      for (;;)
      {
        paramContext = rop.b(rop.b(paramContext, i, j, true), paramBitmap);
        localGaussianBlurFilter.destroy();
        return paramContext;
        i = paramBitmap.getWidth();
        break;
        j = paramBitmap.getHeight();
        break label26;
        paramContext = Bitmap.createBitmap(paramBitmap);
        localObject = new Canvas();
        ((Canvas)localObject).setBitmap(paramContext);
        ((Canvas)localObject).drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
      }
    }
  }
  
  public void ZJ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeEnd, finish:" + paramBoolean);
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.3(this));
  }
  
  public void a(int paramInt, long paramLong, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDecodeFrame, index:").append(paramInt).append(" ltimeus:").append(paramLong).append(" bitmap:");
      if (paramBitmap == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VideoFrameLoader", 2, bool);
      if ((paramInt >= 0) && (paramInt < this.mFrameCount)) {
        ThreadManager.getUIHandler().post(new VideoFrameLoader.2(this, paramInt, paramBitmap));
      }
      return;
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt, aypq.a parama)
  {
    this.mListenerRef = new WeakReference(parama);
    this.mStartTime = paramLong1;
    this.mRotation = paramInt;
    this.mEndTime = paramLong2;
    this.mVideoPath = paramString;
    if ((TextUtils.isEmpty(this.mVideoPath)) || (this.mEndTime - this.mStartTime <= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "init error, path:" + this.mVideoPath + " time:" + this.mStartTime + "-" + this.mEndTime);
      }
      return false;
    }
    return true;
  }
  
  public void afs(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeError , code:" + paramInt);
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.4(this));
  }
  
  public void oR(List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeKeyFrameList");
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.5(this, paramList));
  }
  
  public void onDecodeStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeStart， useretriever:" + this.dAp);
    }
    if (this.dAp) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.1(this));
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "stop， mListItems: :" + this.NC.size() + " useRetriever:" + this.dAp);
    }
    if (this.a != null)
    {
      this.a.stop();
      this.a = null;
    }
  }
  
  public void u(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "start， nCount:" + paramInt1 + " nFrameWidth:" + this.mFrameWidth + " nFrameHeight:" + paramInt3);
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt3 <= 0)) {
      return;
    }
    this.mFrameCount = paramInt1;
    this.mFrameWidth = paramInt2;
    this.mFrameHeight = paramInt3;
    this.a = new CodecDecodeRunnable(this.mVideoPath, this.mFrameWidth, this.mFrameHeight, this.mFrameCount, this.mRotation, this.mStartTime, this.mEndTime, this);
    ThreadManager.post(this.a, 10, null, true);
    this.dAp = false;
  }
  
  public void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "uinit..");
    }
    stop();
    this.NC.clear();
    this.mListenerRef = null;
    if (this.b != null) {
      this.b.destory();
    }
  }
  
  public static abstract interface a
  {
    public abstract void eTj();
    
    public abstract void g(int paramInt, Bitmap paramBitmap);
    
    public abstract void oT(List<Long> paramList);
    
    public abstract void onLoadStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypq
 * JD-Core Version:    0.7.0.1
 */