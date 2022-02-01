package wf7;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.wifisdk.services.common.api.IThreadPool;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class hc
{
  public static final String TAG = hc.class.getSimpleName();
  public static String sF = "tencent" + File.separator + "apdl" + File.separator;
  private Context mContext;
  private a sE;
  private IThreadPool sd;
  
  public hc(Context paramContext, IThreadPool paramIThreadPool)
  {
    this.mContext = paramContext;
    this.sd = paramIThreadPool;
  }
  
  public String a(String paramString1, String paramString2, b paramb)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    String str2 = ha.Z(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString1;
    }
    this.sE = new a(paramString1, paramString2, paramb);
    this.sd.addTask(this.sE, "startDownloadTask", 4);
    return str1;
  }
  
  public void release() {}
  
  class a
    implements Runnable
  {
    private String sG;
    private String sH;
    private gm sI;
    private hc.b sJ;
    private AtomicBoolean sK = new AtomicBoolean(false);
    
    public a(String paramString1, String paramString2, hc.b paramb)
    {
      this.sG = paramString1;
      this.sH = paramString2;
      this.sJ = paramb;
    }
    
    public void run()
    {
      Object localObject1 = null;
      for (;;)
      {
        try
        {
          this.sK.set(true);
          this.sI = new gm(hc.a(hc.this).getApplicationContext());
          if ((!Environment.getExternalStorageState().equals("mounted")) || (!dj.f(gv.dE()))) {
            continue;
          }
          String str = Environment.getExternalStorageDirectory().getPath() + File.separator + hc.sF;
          Object localObject2 = new File(str);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          this.sI.M(str);
          str = this.sH + ".apk";
          this.sI.N(str);
          this.sI.a(new hc.a.1(this));
          if (this.sI.a(this.sH, this.sG, false, null) == 0)
          {
            str = this.sI.eX();
            localObject2 = gq.T(str);
            if (localObject2 != null)
            {
              localObject1 = new File(str);
              DisplayMetrics localDisplayMetrics = new DisplayMetrics();
              localDisplayMetrics.setToDefaults();
              localObject1 = gq.a(localObject2, (File)localObject1, str, localDisplayMetrics, 0);
            }
            if (localObject1 != null) {
              continue;
            }
            localObject1 = new File(str);
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            if (this.sJ != null) {
              this.sJ.ay(-207);
            }
          }
        }
        catch (Exception localException)
        {
          if (this.sJ == null) {
            continue;
          }
          this.sJ.ay(-999);
          continue;
          if (this.sJ == null) {
            continue;
          }
          this.sJ.aa(this.sI.eX());
          continue;
        }
        this.sK.set(false);
        return;
        this.sI.M(hc.a(hc.this).getFilesDir().getAbsolutePath());
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void aa(String paramString);
    
    public abstract void ay(int paramInt);
    
    public abstract void onProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.hc
 * JD-Core Version:    0.7.0.1
 */