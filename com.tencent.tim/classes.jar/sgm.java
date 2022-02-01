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

public class sgm
{
  private static volatile sgm a;
  private Set<String> aR = Collections.synchronizedSet(new HashSet());
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<sgm.a>>> cv = new ConcurrentHashMap();
  private MQLruCache<String, AnimationDrawable> h = new MQLruCache(10);
  private MQLruCache<String, QQAnimationDrawable> i = new MQLruCache(10);
  
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
  
  public static sgm a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new sgm();
      }
      return a;
    }
    finally {}
  }
  
  public static String[] g(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        Arrays.sort(paramString, new sgo());
        ArrayList localArrayList = new ArrayList();
        int k = paramString.length;
        int j = 0;
        while (j < k)
        {
          localArrayList.add(paramString[j].getPath());
          j += 1;
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
    }
    return null;
  }
  
  public void a(String paramString, int paramInt, sgm.a parama, boolean paramBoolean)
  {
    QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + paramString + " allDuration=" + paramInt + " useCache=" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (parama != null) {
        parama.bxN();
      }
    }
    ThreadManagerV2.executeOnSubThread(new AnimationDrawableFactory.2(this, paramBoolean, paramString, paramInt, parama));
  }
  
  public void tf(String paramString)
  {
    if ((this.h != null) && (this.h.get(paramString) != null)) {
      this.h.remove(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AnimationDrawable paramAnimationDrawable);
    
    public abstract void a(QQAnimationDrawable paramQQAnimationDrawable);
    
    public abstract void bxN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgm
 * JD-Core Version:    0.7.0.1
 */