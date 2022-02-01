import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.GetFileListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class znq
{
  private static volatile znq jdField_a_of_type_Znq;
  private MQLruCache<String, AnimationDrawable> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(10);
  private final ConcurrentHashMap<String, RFWDownloader.GetFileListener> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private MQLruCache<String, QQAnimationDrawable> b;
  
  private Bitmap a(File paramFile)
  {
    QLog.i("AnimationDrawableFactory", 2, "getBitMapFromFile fileName:" + paramFile.getName());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFile.exists())
    {
      localObject1 = localObject2;
      if (paramFile.isFile()) {
        localObject1 = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      }
    }
    return localObject1;
  }
  
  private QQAnimationDrawable a(String paramString)
  {
    if ((this.b != null) && (!StringUtil.isEmpty(paramString))) {
      return (QQAnimationDrawable)this.b.get(paramString);
    }
    return null;
  }
  
  private static List<File> a(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles(new znt());
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = paramFile[i];
        if (!localFile.exists()) {}
        for (;;)
        {
          i += 1;
          break;
          if (localFile.isDirectory()) {
            localLinkedList.addAll(a(localFile));
          } else {
            localLinkedList.add(localFile);
          }
        }
      }
    }
    return localLinkedList;
  }
  
  public static znq a()
  {
    if (jdField_a_of_type_Znq == null) {}
    try
    {
      if (jdField_a_of_type_Znq == null) {
        jdField_a_of_type_Znq = new znq();
      }
      return jdField_a_of_type_Znq;
    }
    finally {}
  }
  
  private void a(String paramString, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if (this.b == null) {
      this.b = new MQLruCache(10);
    }
    this.b.put(paramString, paramQQAnimationDrawable);
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
      paramString = a(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (File[])paramString.toArray(new File[paramString.size()]);
        if ((paramString != null) && (paramString.length > 0))
        {
          Arrays.sort(paramString, new znu());
          ArrayList localArrayList = new ArrayList();
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(paramString[i].getPath());
            i += 1;
          }
          return (String[])localArrayList.toArray(new String[localArrayList.size()]);
        }
      }
    }
    return null;
  }
  
  private static String[] a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length > 0) && (paramInt > 1))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        localArrayList.add(paramString[i]);
        i += paramInt;
      }
      if (paramString.length % paramInt != 0) {
        localArrayList.add(paramString[(paramString.length - 1)]);
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return paramString;
  }
  
  public static String[] a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (DeviceInfoUtil.isLowPerfDevice())) {}
    for (int i = 2;; i = 1) {
      return a(paramString, i);
    }
  }
  
  public void a(int paramInt, znn paramznn, znw paramznw)
  {
    String str = paramInt + "@" + paramznn.a();
    QLog.d("AnimationDrawableFactory", 1, "createFromUrl" + str);
    if (paramznn.a()) {}
    for (QQAnimationDrawable localQQAnimationDrawable = a(paramznn.a());; localQQAnimationDrawable = null)
    {
      if (localQQAnimationDrawable != null)
      {
        QLog.d("AnimationDrawableFactory", 1, "getAnimationDrawable from cache success");
        paramznw.a(true, localQQAnimationDrawable);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        QLog.d("AnimationDrawableFactory", 1, "drawable is creating" + str);
        paramznw.a(false, null);
        return;
      }
      paramznw = new znr(this, System.currentTimeMillis(), paramznn, str, paramznw);
      QLog.d("AnimationDrawableFactory", 1, "addKey" + str);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramznw);
      RFWDownloaderFactory.getDownloader(paramznn.a()).getZipFile(paramznn.a(), paramznw);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString) != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
  }
  
  @Deprecated
  public void a(String paramString, int paramInt, znv paramznv, boolean paramBoolean)
  {
    QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + paramString + " allDuration=" + paramInt + " useCache=" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (paramznv != null) {
        paramznv.a(false, null);
      }
    }
    ThreadManagerV2.executeOnSubThread(new AnimationDrawableFactory.2(this, paramBoolean, paramString, paramInt, paramznv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znq
 * JD-Core Version:    0.7.0.1
 */