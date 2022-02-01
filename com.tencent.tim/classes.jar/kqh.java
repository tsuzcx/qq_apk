import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

public class kqh
  implements angp.a, ShortVideoResourceManager.c
{
  private kqh.a a;
  private boolean aha = true;
  private boolean ahb;
  private boolean ahc;
  private QQAppInterface mApp;
  private Context mContext;
  
  public kqh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    if (ankq.aB(paramContext) != 0) {}
    for (;;)
    {
      this.aha = bool;
      return;
      bool = false;
    }
  }
  
  private void aFX()
  {
    if (this.mApp != null)
    {
      ShortVideoResourceManager.a(this.mApp, this);
      ShortVideoResourceManager.b(this.mApp, this);
    }
  }
  
  private void aFY()
  {
    if ((this.ahb) && ((this.ahc) || (!this.aha))) {
      py(1);
    }
  }
  
  private void py(int paramInt)
  {
    aFX();
    if (this.a != null) {
      this.a.N(paramInt);
    }
  }
  
  public void a(kqh.a parama)
  {
    this.a = parama;
  }
  
  public void aFW()
  {
    VideoEnvironment.k("ReadInJoyCameraCaptureSoManager", "onNetWorkNone", null);
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    int j = 1;
    VideoEnvironment.k("ReadInJoyCameraCaptureSoManager", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    int k = 0;
    int i;
    if (paramInt1 != 1)
    {
      i = j;
      if (paramInt1 != 0) {}
    }
    else
    {
      if (paramInt2 == 0) {
        break label69;
      }
      i = j;
    }
    if (i != 0) {
      py(3);
    }
    return;
    label69:
    ArrayList localArrayList = new ArrayList(1);
    if (ShortVideoResourceManager.a(this.mApp, localArrayList) == 0)
    {
      ShortVideoResourceManager.a(this.mApp, localArrayList, this);
      if (ankq.aB(VideoEnvironment.getContext()) == 2)
      {
        ShortVideoResourceManager.b(this.mApp, localArrayList, this);
        paramInt1 = k;
      }
    }
    for (;;)
    {
      i = paramInt1;
      break;
      this.ahc = true;
      VideoEnvironment.k("ReadInJoyCameraCaptureSoManager", "onConfigResult| getFilterSoState != 2", null);
      paramInt1 = k;
      continue;
      paramInt1 = 1;
    }
  }
  
  public void f(String paramString, long paramLong1, long paramLong2) {}
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0) {
        py(3);
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_short_filter_"))
    {
      if (paramInt == 0) {
        break label92;
      }
      py(3);
    }
    for (;;)
    {
      VideoEnvironment.k("ReadInJoyCameraCaptureSoManager", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.ahb = true;
      aFY();
      break;
      label92:
      this.ahc = true;
      aFY();
    }
  }
  
  public void start()
  {
    ShortVideoResourceManager.b(this.mApp, this);
  }
  
  public static abstract interface a
  {
    public abstract void N(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqh
 * JD-Core Version:    0.7.0.1
 */