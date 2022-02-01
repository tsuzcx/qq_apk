package cooperation.qzone;

import acfp;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import anfv;
import angp.a;
import aqiw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;

public class QzoneVideoSoDownloadModule
  extends QIPCModule
{
  private static QzoneVideoSoDownloadModule a;
  
  private QzoneVideoSoDownloadModule(String paramString)
  {
    super(paramString);
  }
  
  public static ResultReceiver a(a parama)
  {
    Object localObject = new QzoneVideoSoDownloadResultReceiver(parama);
    parama = Parcel.obtain();
    ((QzoneVideoSoDownloadResultReceiver)localObject).writeToParcel(parama, 0);
    parama.setDataPosition(0);
    localObject = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parama);
    parama.recycle();
    return localObject;
  }
  
  public static QzoneVideoSoDownloadModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QzoneVideoSoDownloadModule("QzoneVideoSoDownloadModule");
      }
      return a;
    }
    finally {}
  }
  
  private void a(ResultReceiver paramResultReceiver, int paramInt, String paramString)
  {
    if (paramResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_error_message", paramString);
      paramResultReceiver.send(paramInt, localBundle);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoSoDownloadModule", 2, "action = " + paramString);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVideoSoDownloadModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("action_download_avcodec".equals(paramString))
    {
      QLog.i("QzoneVideoSoDownloadModule", 1, "try download libavcodec");
      if ((aqiw.isNetworkAvailable(null)) && (paramBundle != null))
      {
        paramString = (ResultReceiver)paramBundle.getParcelable("key_download_result_receiver");
        if (paramString == null)
        {
          QLog.e("QzoneVideoSoDownloadModule", 1, "receiver == null");
          return EIPCResult.createResult(-1, null);
        }
        ShortVideoResourceManager.b((QQAppInterface)localObject, new b((QQAppInterface)localObject, paramString));
        return EIPCResult.createResult(0, new Bundle());
      }
      return EIPCResult.createResult(-1, null);
    }
    if ("action_check_avcodec_is_ok".equals(paramString))
    {
      boolean bool = VideoEnvironment.r((AppInterface)localObject);
      paramString = new Bundle();
      paramString.putBoolean("key_is_avcodec_ok", bool);
      return EIPCResult.createResult(0, paramString);
    }
    return null;
  }
  
  public static class QzoneVideoSoDownloadResultReceiver
    extends ResultReceiver
  {
    private QzoneVideoSoDownloadModule.a a;
    
    public QzoneVideoSoDownloadResultReceiver(QzoneVideoSoDownloadModule.a parama)
    {
      super();
      this.a = parama;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (this.a != null) {
        this.a.callback(paramInt, paramBundle);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void callback(int paramInt, Bundle paramBundle);
  }
  
  class b
    implements angp.a
  {
    private QQAppInterface app;
    private ResultReceiver v;
    
    public b(QQAppInterface paramQQAppInterface, ResultReceiver paramResultReceiver)
    {
      this.app = paramQQAppInterface;
      this.v = paramResultReceiver;
    }
    
    public void cu(int paramInt1, int paramInt2)
    {
      VideoEnvironment.k("QzoneVideoSoDownloadModule", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
      if ((paramInt1 == 1) || (paramInt1 == 0))
      {
        if (paramInt2 != 0)
        {
          QzoneVideoSoDownloadModule.a(QzoneVideoSoDownloadModule.this, this.v, -2, acfp.m(2131713485) + paramInt2 + "]");
          anfv.jx(1, paramInt2);
          return;
        }
        ArrayList localArrayList = new ArrayList(1);
        paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
        if (paramInt1 == 0)
        {
          ShortVideoResourceManager.a(this.app, localArrayList, new QzoneVideoSoDownloadModule.c(QzoneVideoSoDownloadModule.this, this.v));
          return;
        }
        QzoneVideoSoDownloadModule.a(QzoneVideoSoDownloadModule.this, this.v, -2, acfp.m(2131713529) + paramInt1 + "]");
        anfv.jx(1, paramInt1);
        return;
      }
      QzoneVideoSoDownloadModule.a(QzoneVideoSoDownloadModule.this, this.v, -2, acfp.m(2131713472) + paramInt2 + "]");
      anfv.jx(1, paramInt2);
    }
  }
  
  class c
    implements ShortVideoResourceManager.c
  {
    ResultReceiver v;
    
    public c(ResultReceiver paramResultReceiver)
    {
      this.v = paramResultReceiver;
    }
    
    public void aFW()
    {
      QLog.e("QzoneVideoSoDownloadModule", 1, "onNetWorkNone");
      QzoneVideoSoDownloadModule.a(QzoneVideoSoDownloadModule.this, this.v, -3, acfp.m(2131713462));
    }
    
    public void f(String paramString, long paramLong1, long paramLong2)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneVideoSoDownloadModule", 4, "onUpdateProgress: name=" + paramString + " curOffset=" + paramLong1 + " totalLen=" + paramLong2);
      }
    }
    
    public void o(String paramString1, int paramInt, String paramString2)
    {
      QLog.i("QzoneVideoSoDownloadModule", 1, "onDownloadFinish name=" + paramString1 + " result=" + paramInt + " filePath=" + paramString2);
      if (paramString1.startsWith("new_qq_android_native_short_video_"))
      {
        if (paramInt == 0) {
          break label111;
        }
        QzoneVideoSoDownloadModule.a(QzoneVideoSoDownloadModule.this, this.v, -3, acfp.m(2131713469) + paramInt + "]");
        anfv.jx(2, paramInt);
      }
      for (;;)
      {
        if (paramString1.startsWith("new_qq_android_native_short_filter_")) {}
        return;
        label111:
        if (this.v != null)
        {
          paramString2 = new Bundle();
          this.v.send(0, paramString2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneVideoSoDownloadModule
 * JD-Core Version:    0.7.0.1
 */