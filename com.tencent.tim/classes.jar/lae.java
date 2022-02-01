import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class lae
  extends LottieDrawable
{
  private static final String adU = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/resource/lottie_background_res");
  private static LruCache<String, Bitmap> c = new LruCache(5242880);
  private static LruCache<String, LottieComposition> d = new LruCache(1048576);
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  private static long G(String paramString)
  {
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      l = (l + paramString.charAt(i)) * 131L % 53497342331L;
      i += 1;
    }
    return l;
  }
  
  @Nullable
  private File a(File[] paramArrayOfFile, String paramString)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      if (localFile.getName().equals(paramString)) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
  
  public static lae a(String paramString)
  {
    lae locallae = new lae();
    long l = G(paramString);
    String str = adU + File.separator + l;
    File localFile1 = new File(str);
    if (q(localFile1)) {
      locallae.k(localFile1);
    }
    for (;;)
    {
      return locallae;
      aqvc localaqvc = ((aqva)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
      File localFile2 = new File(adU);
      if (!localFile2.exists()) {}
      for (boolean bool = localFile2.mkdirs(); bool; bool = true)
      {
        str = str + ".zip";
        localFile2 = new File(str);
        paramString = new aquz(paramString, localFile2);
        paramString.retryCount = 3;
        paramString.atW = 60L;
        Bundle localBundle = new Bundle();
        localBundle.putLong("bgLottieResId", l);
        localBundle.putString("bgLottieResPath", str);
        localaqvc.a(paramString, new laj(l, str, localFile2, localFile1, new WeakReference(locallae)), localBundle);
        return locallae;
      }
    }
  }
  
  private void k(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation " + paramFile.getName());
    }
    File[] arrayOfFile = paramFile.listFiles(new laf(this));
    Object localObject = paramFile.listFiles(new lag(this));
    if ((arrayOfFile == null) || (localObject == null) || (localObject.length == 0)) {}
    do
    {
      return;
      localObject = new ReadInJoyLottieDrawable.3(this, paramFile, (File[])localObject);
    } while (arrayOfFile.length <= 0);
    if ((LottieComposition)d.get(paramFile.getAbsolutePath()) == null)
    {
      ThreadManager.excute(new ReadInJoyLottieDrawable.4(this, arrayOfFile, paramFile, (Runnable)localObject), 64, null, true);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  private static boolean q(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles(new lak());
      bool1 = bool2;
      if (paramFile != null)
      {
        bool1 = bool2;
        if (paramFile.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      cancelAnimation();
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lae
 * JD-Core Version:    0.7.0.1
 */