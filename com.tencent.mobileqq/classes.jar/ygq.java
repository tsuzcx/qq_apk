import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ygq
{
  private static volatile ygq jdField_a_of_type_Ygq;
  private MQLruCache<String, AnimationDrawable> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(10);
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<ygu>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private MQLruCache<String, QQAnimationDrawable> b = new MQLruCache(10);
  
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
  
  public static ygq a()
  {
    if (jdField_a_of_type_Ygq == null) {}
    try
    {
      if (jdField_a_of_type_Ygq == null) {
        jdField_a_of_type_Ygq = new ygq();
      }
      return jdField_a_of_type_Ygq;
    }
    finally {}
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        Arrays.sort(paramString, new ygs());
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
    return null;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString) != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, ygu paramygu, boolean paramBoolean)
  {
    QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + paramString + " allDuration=" + paramInt + " useCache=" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (paramygu != null) {
        paramygu.a();
      }
    }
    ThreadManagerV2.executeOnSubThread(new AnimationDrawableFactory.2(this, paramBoolean, paramString, paramInt, paramygu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygq
 * JD-Core Version:    0.7.0.1
 */