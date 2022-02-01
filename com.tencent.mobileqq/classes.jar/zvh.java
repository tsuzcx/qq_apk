import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class zvh
{
  private static volatile zvh jdField_a_of_type_Zvh;
  private MQLruCache<String, AnimationDrawable> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(10);
  private final ConcurrentHashMap<String, zwi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
    if ((this.b != null) && (!bgsp.a(paramString))) {
      return (QQAnimationDrawable)this.b.get(paramString);
    }
    return null;
  }
  
  private static List<File> a(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles(new zvk());
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
  
  public static zvh a()
  {
    if (jdField_a_of_type_Zvh == null) {}
    try
    {
      if (jdField_a_of_type_Zvh == null) {
        jdField_a_of_type_Zvh = new zvh();
      }
      return jdField_a_of_type_Zvh;
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
          Arrays.sort(paramString, new zvl());
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
    if ((paramBoolean) && (bgln.g())) {}
    for (int i = 2;; i = 1) {
      return a(paramString, i);
    }
  }
  
  public void a(int paramInt, zve paramzve, zvn paramzvn)
  {
    String str = paramInt + "@" + paramzve.a();
    QLog.d("AnimationDrawableFactory", 1, "createFromUrl" + str);
    if (paramzve.a()) {}
    for (QQAnimationDrawable localQQAnimationDrawable = a(paramzve.a());; localQQAnimationDrawable = null)
    {
      if (localQQAnimationDrawable != null)
      {
        QLog.d("AnimationDrawableFactory", 1, "getAnimationDrawable from cache success");
        paramzvn.a(true, localQQAnimationDrawable);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        QLog.d("AnimationDrawableFactory", 1, "drawable is creating" + str);
        paramzvn.a(false, null);
        return;
      }
      paramzvn = new zvi(this, System.currentTimeMillis(), paramzve, str, paramzvn);
      QLog.d("AnimationDrawableFactory", 1, "addKey" + str);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramzvn);
      zwj.a(paramzve.a()).b(paramzve.a(), paramzvn);
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
  public void a(String paramString, int paramInt, zvm paramzvm, boolean paramBoolean)
  {
    QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + paramString + " allDuration=" + paramInt + " useCache=" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (paramzvm != null) {
        paramzvm.a(false, null);
      }
    }
    ThreadManagerV2.executeOnSubThread(new AnimationDrawableFactory.2(this, paramBoolean, paramString, paramInt, paramzvm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvh
 * JD-Core Version:    0.7.0.1
 */