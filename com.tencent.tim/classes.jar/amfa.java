import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class amfa
{
  private amfa.b a;
  private volatile long aiA;
  private String bZW;
  private HashSet<String> bv;
  
  public amfa(String paramString, amfa.b paramb)
  {
    paramString = this.bZW;
    this.a = paramb;
  }
  
  public static File H()
  {
    if (aqfo.isExistSDCard()) {
      return new File(acbn.SDCARD_PATH + "status_ic");
    }
    return null;
  }
  
  private boolean b(String paramString, File paramFile)
  {
    int i = HttpDownloadUtil.a(null, paramString, paramFile);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.img", 2, "download " + paramString + "result " + i);
    }
    paramFile = anpc.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", String.valueOf(i));
    localHashMap.put("url", paramString);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramFile.collectPerformance("", "RichStatusIcon", bool, 0L, 0L, localHashMap, "");
      if (i != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    Bitmap localBitmap = getBitmap(paramString1);
    if (localBitmap == null)
    {
      if (this.bv == null) {
        this.bv = new HashSet();
      }
      if (!this.bv.contains(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.img", 2, "decodeBitmap " + paramString1 + ", " + paramString2 + ", " + paramString3);
        }
        this.bv.add(paramString1);
        new amfa.a(paramString1, paramString2, paramString3).execute((Void[])null);
      }
    }
    return localBitmap;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    return (Bitmap)BaseApplicationImpl.sImageCache.get(this.bZW + paramString);
  }
  
  public void reset()
  {
    this.bv.clear();
  }
  
  class a
    extends AsyncTask<Void, Bitmap, Bitmap>
  {
    private String bZX;
    private String bZY;
    private String mDownloadUrl;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.bZX = paramString1;
      this.bZY = paramString2;
      this.mDownloadUrl = paramString3;
    }
    
    private Bitmap c(File paramFile)
    {
      Bitmap localBitmap1 = null;
      Bitmap localBitmap2 = null;
      if (paramFile.exists()) {
        localBitmap2 = localBitmap1;
      }
      try
      {
        localBitmap1 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
        localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap2 = localBitmap1;
          paramFile.delete();
          localBitmap2 = localBitmap1;
        }
        return localBitmap2;
      }
      catch (OutOfMemoryError paramFile) {}
      return localBitmap2;
    }
    
    protected Bitmap b(Void... paramVarArgs)
    {
      Object localObject1 = null;
      paramVarArgs = null;
      boolean bool2 = true;
      Object localObject2 = amfa.H();
      if (localObject2 != null)
      {
        localObject1 = new File((File)localObject2, this.bZX);
        boolean bool1 = bool2;
        if (!((File)localObject1).exists())
        {
          if (!TextUtils.isEmpty(this.bZY))
          {
            localObject2 = c(new File((File)localObject2, this.bZY));
            if (localObject2 != null) {
              publishProgress(new Bitmap[] { localObject2 });
            }
          }
          bool1 = bool2;
          if (this.mDownloadUrl != null)
          {
            if ((amfa.a(amfa.this) > 3L) && (Math.abs(SystemClock.uptimeMillis() - amfa.a(amfa.this)) > 60000L)) {
              amfa.a(amfa.this, 0L);
            }
            bool1 = bool2;
            if (amfa.a(amfa.this) < 3L) {
              bool1 = amfa.a(amfa.this, this.mDownloadUrl, (File)localObject1);
            }
          }
        }
        if (bool1) {
          paramVarArgs = c((File)localObject1);
        }
        if ((!bool1) || (paramVarArgs == null)) {
          break label253;
        }
        amfa.a(amfa.this, 0L);
        localObject1 = paramVarArgs;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.img", 2, "decodeBitmap finish with " + localObject1 + ", " + amfa.a(amfa.this));
        }
        return localObject1;
        label253:
        localObject1 = paramVarArgs;
        if (!TextUtils.isEmpty(this.mDownloadUrl))
        {
          localObject1 = paramVarArgs;
          if (amfa.b(amfa.this) == 3L)
          {
            amfa.a(amfa.this, SystemClock.uptimeMillis());
            localObject1 = paramVarArgs;
          }
        }
      }
    }
    
    protected void b(Bitmap... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      BaseApplicationImpl.sImageCache.put(amfa.a(amfa.this) + this.bZY, paramVarArgs, (byte)0);
      if (amfa.a(amfa.this) != null) {
        amfa.a(amfa.this).a(this.bZX, this.mDownloadUrl, paramVarArgs, 0);
      }
    }
    
    protected void o(Bitmap paramBitmap)
    {
      if (paramBitmap != null) {
        BaseApplicationImpl.sImageCache.put(amfa.a(amfa.this) + this.bZX, paramBitmap, (byte)0);
      }
      amfa.a(amfa.this).remove(this.bZX);
      if (amfa.a(amfa.this) != null) {
        amfa.a(amfa.this).a(this.bZX, this.mDownloadUrl, paramBitmap, 1);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfa
 * JD-Core Version:    0.7.0.1
 */