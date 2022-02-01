import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class ajny
{
  WeakReference<aopo> aP;
  boolean mDestroyed = false;
  ArrayList<String> xS = new ArrayList();
  ArrayList<ajny.a> xT = new ArrayList();
  
  private static void Gu(String paramString)
  {
    aqhq.delete(paramString, false);
  }
  
  private void a(String paramString1, String arg2, boolean paramBoolean, ajny.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, "onDownloadEnd url:" + paramString1 + " success:" + paramBoolean + " mDestroyed:" + this.mDestroyed);
    }
    if (this.mDestroyed) {
      return;
    }
    synchronized (this.xS)
    {
      this.xS.remove(paramString1);
      if (paramb != null) {
        paramb.yG(paramBoolean);
      }
    }
    synchronized (this.xT)
    {
      int i = this.xT.size() - 1;
      while (i >= 0)
      {
        paramb = (ajny.a)this.xT.get(i);
        if ((paramb != null) && (TextUtils.equals(paramString1, paramb.url)))
        {
          if (paramb.b != null) {
            paramb.b.yG(paramBoolean);
          }
          this.xT.remove(i);
        }
        i -= 1;
        continue;
        paramString1 = finally;
        throw paramString1;
      }
      return;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return b(paramString1, paramString2, paramArrayOfString);
  }
  
  private static boolean aU(String paramString1, String paramString2)
  {
    try
    {
      aden.fn(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ZipResourcesDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = bn(paramString1, paramString2);
      if (isFileExist(paramString1)) {}
    }
    else
    {
      return false;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = paramArrayOfString[i];
        paramString2 = paramString1 + "/" + paramString2;
        if (!isFileExist(paramString2))
        {
          QLog.e("ZipResourcesDownloader", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { paramString2 }));
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static String bn(String paramString1, String paramString2)
  {
    return ml(paramString2);
  }
  
  private static boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  private static String kH(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { uJ(), paramString });
  }
  
  private static String ml(String paramString)
  {
    return String.format("%s/%s", new Object[] { uJ(), paramString });
  }
  
  private static String uJ()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/common_resources";
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private static boolean x(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
    {
      paramString1 = alab.getFileMD5String(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a(QQAppInterface arg1, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ajny.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource url=%s md5=%s callback=%s", new Object[] { paramString2, paramString3, paramb }));
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (??? == null)) {
      QLog.e("ZipResourcesDownloader", 1, "downloadResource invalid parameters.");
    }
    label359:
    boolean bool1;
    do
    {
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        return;
        localObject1 = null;
        if (this.aP != null) {
          localObject1 = (aopo)this.aP.get();
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = (aopo)???.getManager(193);
          this.aP = new WeakReference(localObject2);
        }
        if (localObject2 != null)
        {
          localObject1 = kH(paramString3);
          if (x((String)localObject1, paramString3)) {
            break label359;
          }
          int i = 0;
          synchronized (this.xS)
          {
            if (this.xS.contains(paramString2)) {
              i = 1;
            }
            if (i != 0)
            {
              if (paramb == null) {
                continue;
              }
              synchronized (this.xT)
              {
                this.xT.add(new ajny.a(paramString2, paramb));
                return;
              }
            }
          }
        }
      }
      Gu((String)localObject1);
      ??? = new aoll();
      ((aoll)???).f = new ajnz(this);
      ((aoll)???).bZ = paramString2;
      ((aoll)???).mHttpMethod = 0;
      ((aoll)???).atY = ((String)localObject1);
      ((aoll)???).dPo = 0;
      ((aoll)???).a = new ajoa(this);
      ((aopo)localObject2).a(paramInt, paramString1, paramString3, 0, paramString2, (String)localObject1, 2, 0, false, new aopn(???, paramString3, new ajob(this, paramString3, paramArrayOfString, paramb), (aoll)???));
      synchronized (this.xS)
      {
        this.xS.add(paramString2);
        return;
      }
      boolean bool2 = b(paramString2, paramString3, paramArrayOfString);
      bool1 = bool2;
      if (!bool2)
      {
        boolean bool3 = aU((String)localObject1, ml(paramString3));
        bool2 = b(paramString2, paramString3, paramArrayOfString);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
          bool1 = bool2;
        }
      }
    } while (paramb == null);
    paramb.yG(bool1);
  }
  
  public void onDestroy()
  {
    this.mDestroyed = true;
    synchronized (this.xS)
    {
      this.xS.clear();
    }
    synchronized (this.xT)
    {
      this.xT.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  class a
  {
    public ajny.b b;
    public String url;
    
    public a(String paramString, ajny.b paramb)
    {
      this.url = paramString;
      this.jdField_b_of_type_Ajny$b = paramb;
    }
  }
  
  public static abstract interface b
  {
    public abstract void yG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajny
 * JD-Core Version:    0.7.0.1
 */