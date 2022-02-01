import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.SystemFaceData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class affm
  extends afeu
  implements Handler.Callback
{
  public static final String TAG = SystemFaceData.class.getSimpleName();
  private Handler handler = new Handler(Looper.getMainLooper(), this);
  private ArrayList<String> wb;
  
  public affm(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.face.gifv14", paramQQAppInterface);
  }
  
  private void HP(String paramString)
  {
    int j = 0;
    int i = j;
    try
    {
      int m = Integer.parseInt(paramString);
      i = j;
      int k = aoff.ol[m];
      i = j;
      j = aoff.om[m];
      i = j;
      localURL = new URL("emotion", BaseApplicationImpl.getContext().getResources().getResourceEntryName(k), "");
      i = j;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          URL localURL;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reloadFaceOnUI() ", localMalformedURLException);
          }
          localObject = null;
        }
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(i);
        localObject = URLDrawable.getDrawable((URL)localObject, localDrawable, localDrawable, true);
        if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reloadFaceOnUI() idx=" + paramString + " d.status!=successed||loading. go to restartDownload");
          }
          ((URLDrawable)localObject).addHeader("faceIdx", paramString);
          ((URLDrawable)localObject).restartDownload();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "reloadFaceOnUI() idx=" + paramString + " d.status=" + ((URLDrawable)localObject).getStatus() + " do nothing..");
    }
    if (localURL == null) {
      return;
    }
  }
  
  public void HO(String paramString)
  {
    try
    {
      File localFile = BaseApplicationImpl.getContext().getDir("systemface", 0);
      aqhq.W(paramString, localFile.getAbsolutePath(), true);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "doOnDownloadFinish() uncompressZip to:" + localFile.getAbsolutePath());
      }
      super.HO(paramString);
      this.handler.sendEmptyMessage(196864);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void HQ(String paramString)
  {
    afem.lock.lock();
    try
    {
      if (this.wb == null) {
        this.wb = new ArrayList();
      }
      if (!this.wb.contains(paramString))
      {
        this.wb.add(0, paramString);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "addWaittingFace idx=" + paramString);
        }
      }
      return;
    }
    finally
    {
      afem.lock.unlock();
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return SystemFaceData.class;
  }
  
  public int getBusinessId()
  {
    return 10055;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = null;
      if ((this.wb == null) || (this.wb.size() <= 0)) {
        continue;
      }
      afem.lock.lock();
      try
      {
        if (this.wb.size() > 0) {
          paramMessage = (String)this.wb.remove(0);
        }
        afem.lock.unlock();
        if ((paramMessage == null) || (paramMessage.length() <= 0)) {
          continue;
        }
        HP(paramMessage);
        if (this.wb.size() <= 0) {
          continue;
        }
        this.handler.sendEmptyMessageDelayed(196864, 2000L);
        return false;
      }
      finally
      {
        afem.lock.unlock();
      }
    }
  }
  
  public String un()
  {
    return "actEarlySysFaceGif";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affm
 * JD-Core Version:    0.7.0.1
 */