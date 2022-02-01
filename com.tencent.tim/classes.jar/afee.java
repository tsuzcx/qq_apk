import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doutu.combo.ComboEggView;
import com.tencent.mobileqq.doutu.combo.ComboResource.1;
import com.tencent.mobileqq.doutu.combo.ComboResource.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@TargetApi(12)
public class afee
{
  public static final String LOCAL_PATH = aoqr.oz(afdw.bDf + "combo" + File.separator);
  public static final String bDj = afdw.bDf;
  public static boolean bXJ;
  public static final String[] eS = { "ribbon0.png", "ribbon1.png", "ribbon2.png", "ribbon3.png", "ribbon4.png", "ribbon5.png", "ribbon6.png", "ribbon7.png", "ribbon8.png", "ribbon9.png" };
  public static final String[] eT = { "0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png" };
  public static final String[] eU;
  public static final String[] eV = { bDj + "bonus_8" + File.separator + "doutuX8_", bDj + "bonus_18" + File.separator + "doutuX18_", bDj + "bonus_88" + File.separator + "doutuX88_", bDj + "bonus_888" + File.separator + "doutuX888_" };
  private static LruCache<String, afee.a> t = new LruCache(15);
  public static float vW = 2.0F;
  
  static
  {
    eU = new String[] { "1bitX.png", "2bitX.png", "3bitX.png" };
  }
  
  public static afee.a a()
  {
    return a(LOCAL_PATH + "dui.png", 2);
  }
  
  public static afee.a a(int paramInt)
  {
    return a(LOCAL_PATH + eS[paramInt], 2);
  }
  
  public static afee.a a(String paramString, int paramInt)
  {
    int i = 0;
    Object localObject1 = (afee.a)t.get(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, "resource missing: " + paramString);
      }
      if (!bXJ)
      {
        bXJ = true;
        ThreadManager.post(new ComboResource.1(), 5, null, false);
      }
      return null;
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    localObject1 = BaseApplicationImpl.sApplication.getResources();
    int j = ((BitmapFactory.Options)localObject2).outHeight;
    int k = ((BitmapFactory.Options)localObject2).outWidth;
    try
    {
      localObject2 = Drawable.createFromPath(paramString);
      if ((k == 0) || (j == 0) || (localObject2 == null))
      {
        if (!bXJ)
        {
          bXJ = true;
          ThreadManager.post(new ComboResource.2(), 5, null, false);
        }
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, "load resource oom: " + paramString);
      }
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      afee.a locala = new afee.a();
      locala.width = i;
      locala.height = paramInt;
      locala.drawable = ((Drawable)localObject2);
      t.put(paramString, locala);
      return locala;
      i = wja.dp2px(k / vW, locala);
      paramInt = wja.dp2px(j / vW, locala);
      continue;
      paramInt = wja.dp2px(32.0F, locala);
      i = (int)(paramInt / j * k);
      continue;
      paramInt = wja.dp2px(24.0F, locala);
      i = (int)(paramInt / j * k);
    }
  }
  
  public static File[] a(int paramInt)
  {
    int i = 0;
    String str = null;
    while (i < ComboEggView.kV.length)
    {
      if (paramInt == ComboEggView.kV[i]) {
        str = eV[i];
      }
      i += 1;
    }
    if (str == null) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramInt = 1;
      while (paramInt <= 31)
      {
        File localFile = new File(str + paramInt + ".png");
        if (localFile.exists()) {
          localArrayList.add(localFile);
        }
        paramInt += 1;
      }
    } while (localArrayList.size() <= 0);
    return (File[])localArrayList.toArray(new File[localArrayList.size()]);
  }
  
  public static afee.a b()
  {
    return a(LOCAL_PATH + "ribbonX.png", 3);
  }
  
  public static afee.a b(int paramInt)
  {
    return a(LOCAL_PATH + eT[paramInt], 1);
  }
  
  public static afee.a c(int paramInt)
  {
    return a(LOCAL_PATH + eU[(paramInt - 1)], 1);
  }
  
  public static void cleanCache()
  {
    t.evictAll();
  }
  
  public static class a
  {
    public Drawable drawable;
    public int height;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afee
 * JD-Core Version:    0.7.0.1
 */