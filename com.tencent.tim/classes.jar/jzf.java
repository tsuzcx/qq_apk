import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class jzf
  implements Manager, nox
{
  private noz a;
  private final Object aD = new Object();
  private ArrayList<String> jH = new ArrayList();
  private int mScreenHeight;
  private int mScreenWidth;
  
  public jzf(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (WindowManager)paramQQAppInterface.getApplication().getSystemService("window");
    if (paramQQAppInterface != null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramQQAppInterface.getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.mScreenWidth = localDisplayMetrics.widthPixels;
      this.mScreenHeight = localDisplayMetrics.heightPixels;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "createManager width:" + localDisplayMetrics.widthPixels + ", height:" + localDisplayMetrics.heightPixels);
      }
    }
    aryy.a();
  }
  
  private void aAU()
  {
    for (;;)
    {
      synchronized (this.aD)
      {
        String str1;
        if ((this.a == null) && (this.jH != null) && (this.jH.size() > 0)) {
          str1 = (String)this.jH.remove(0);
        }
        try
        {
          Object localObject2 = new URL(str1);
          if (noy.a().a((URL)localObject2))
          {
            aAU();
            if (QLog.isColorLevel()) {
              QLog.d("NativeAdPreloadManager", 2, "startImageDownload url:" + str1 + ", file exist!");
            }
            return;
          }
          this.a = new noz();
          this.a.url = ((URL)localObject2);
          this.a.reqWidth = this.mScreenWidth;
          this.a.reqHeight = this.mScreenHeight;
          localObject2 = noy.a().a(this.a);
          if (localObject2 != null)
          {
            ((nov)localObject2).close();
            this.a = null;
            aAU();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("NativeAdPreloadManager", 2, "startImageDownload url:" + str1 + ", bitmap cached!");
            continue;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
      }
      noy.a().a(this.a, this);
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "startImageDownload url:" + str2 + ", begin load!");
      }
    }
  }
  
  public void a(noz paramnoz, int paramInt) {}
  
  public void a(noz paramnoz, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdPreloadManager", 2, "onFail url:" + paramnoz.url.toString());
    }
    if (paramnoz.equals(this.a))
    {
      this.a = null;
      aAU();
    }
  }
  
  public void a(noz paramnoz, nov paramnov)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdPreloadManager", 2, "onSuccess url:" + paramnoz.url.toString());
    }
    if (paramnoz.equals(this.a))
    {
      this.a = null;
      aAU();
    }
  }
  
  public void aBr()
  {
    synchronized (this.aD)
    {
      if (this.jH != null)
      {
        this.jH.clear();
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdPreloadManager", 2, "clearPreloadList");
        }
      }
      return;
    }
  }
  
  public void bM(ArrayList<String> paramArrayList)
  {
    for (;;)
    {
      String str;
      synchronized (this.aD)
      {
        if ((this.jH == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
          break label158;
        }
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        str = (String)paramArrayList.next();
        if ((!TextUtils.isEmpty(str)) && (!this.jH.contains(str)))
        {
          this.jH.add(str);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("NativeAdPreloadManager", 2, "addImagesToPreload url:" + str);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "addImagesToPreload url:" + str + ", skip");
      }
    }
    aAU();
    label158:
  }
  
  public void lz(String paramString)
  {
    synchronized (this.aD)
    {
      if ((this.jH != null) && (!TextUtils.isEmpty(paramString)) && (!this.jH.contains(paramString)))
      {
        this.jH.add(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdPreloadManager", 2, "addImageToPreload url:" + paramString);
        }
        aAU();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("NativeAdPreloadManager", 2, "addImageToPreload url:" + paramString + ", skip");
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.aD)
    {
      this.a = null;
      this.jH.clear();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdPreloadManager", 2, "onDestroy");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzf
 * JD-Core Version:    0.7.0.1
 */