import android.text.TextUtils;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class avsw
{
  private avsw.a a;
  private int eyp;
  private int eyq;
  private final String mName;
  private AtomicInteger mStorageCounter = new AtomicInteger(0);
  private int version;
  
  public avsw(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.mName = paramString;
    this.version = paramInt1;
    this.eyp = paramInt2;
    this.eyq = paramInt3;
  }
  
  private void Ns()
  {
    if (this.mStorageCounter.getAndIncrement() < 5) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          this.mStorageCounter.set(0);
          str = sD();
        } while (TextUtils.isEmpty(str));
        for (localObject = new File(str); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
      } while (!avsx.tA(((File)localObject).getAbsolutePath()));
      localObject = this.a;
    } while (localObject == null);
    if (!avsu.tz(str)) {}
    for (boolean bool = true;; bool = false)
    {
      ((avsw.a)localObject).a(this, bool);
      return;
    }
  }
  
  private File createFile(String paramString)
  {
    paramString = getPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (isFileValid(paramString)) {
      FileUtils.delete(paramString);
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QLog.e("CacheManager", 1, "", localIOException);
    }
    return paramString;
  }
  
  public static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  public void H(String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (!localFile.setLastModified(System.currentTimeMillis())) && (QLog.isDevelopLevel())) {
      QLog.w("FileCacheService", 2, "更新缓存文件的lru文件时间失败. path=" + paramString);
    }
    Ns();
  }
  
  public void a(avsw.a parama)
  {
    this.a = parama;
  }
  
  public int getCapacity(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.eyp;
    }
    return this.eyq;
  }
  
  public File getFile(String paramString)
  {
    return getFile(paramString, false);
  }
  
  public File getFile(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = getPath(paramString);
    Object localObject;
    if (str == null)
    {
      localObject = null;
      if (!isFileValid((File)localObject)) {
        break label59;
      }
      H(str, false);
      label37:
      if (!isFileValid((File)localObject)) {
        break label92;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = new File(str);
      break;
      label59:
      if (!paramBoolean) {
        break label37;
      }
      paramString = createFile(paramString);
      localObject = paramString;
      if (!isFileValid(paramString)) {
        break label37;
      }
      H(paramString.getAbsolutePath(), true);
      localObject = paramString;
      break label37;
      label92:
      localObject = null;
    }
  }
  
  public String getPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = sD();
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public String sD()
  {
    return avsu.aW(this.mName, this.version);
  }
  
  public static abstract interface a
  {
    public abstract void a(avsw paramavsw, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsw
 * JD-Core Version:    0.7.0.1
 */