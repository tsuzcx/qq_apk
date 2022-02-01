package wf7;

import android.content.Context;
import android.os.Environment;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class hc$a
  implements Runnable
{
  private String sG;
  private String sH;
  private gm sI;
  private hc.b sJ;
  private AtomicBoolean sK = new AtomicBoolean(false);
  
  public hc$a(hc paramhc, String paramString1, String paramString2, hc.b paramb)
  {
    this.sG = paramString1;
    this.sH = paramString2;
    this.sJ = paramb;
  }
  
  public void run()
  {
    try
    {
      this.sK.set(true);
      this.sI = new gm(hc.a(this.sL).getApplicationContext());
      if ((Environment.getExternalStorageState().equals("mounted")) && (dj.f(gv.dE())))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(hc.sF);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        this.sI.M((String)localObject1);
      }
      else
      {
        this.sI.M(hc.a(this.sL).getFilesDir().getAbsolutePath());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.sH);
      ((StringBuilder)localObject1).append(".apk");
      localObject1 = ((StringBuilder)localObject1).toString();
      this.sI.N((String)localObject1);
      this.sI.a(new hc.a.1(this));
      Object localObject2 = this.sI;
      Object localObject3 = this.sH;
      Object localObject4 = this.sG;
      localObject1 = null;
      if (((gm)localObject2).a((String)localObject3, (String)localObject4, false, null) != 0) {
        break label364;
      }
      localObject2 = this.sI.eX();
      localObject3 = gq.T((String)localObject2);
      if (localObject3 != null)
      {
        localObject1 = new File((String)localObject2);
        localObject4 = new DisplayMetrics();
        ((DisplayMetrics)localObject4).setToDefaults();
        localObject1 = gq.a(localObject3, (File)localObject1, (String)localObject2, (DisplayMetrics)localObject4, 0);
      }
      if (localObject1 == null)
      {
        localObject1 = new File((String)localObject2);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        if (this.sJ != null) {
          this.sJ.ay(-207);
        }
      }
      else if (this.sJ != null)
      {
        this.sJ.aa(this.sI.eX());
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label346:
      label364:
      break label346;
    }
    localObject1 = this.sJ;
    if (localObject1 != null) {
      ((hc.b)localObject1).ay(-999);
    }
    this.sK.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hc.a
 * JD-Core Version:    0.7.0.1
 */