import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.gamecenter.common.util.ScreenshotManager.1;
import com.tencent.gamecenter.common.util.ScreenshotManager.2;
import com.tencent.gamecenter.common.util.ScreenshotManager.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

public class tbl
{
  public static final String aIY = aqul.getSDKPrivatePath("Tencent/MobileQQ/gamecenter" + File.separator);
  public static final String aIZ = aqul.getSDKPrivatePath(aIY + "gamecenter_screenshot");
  private boolean aOD = tbb.gv("gamecenter_shot_switch");
  private boolean aOE;
  private Bitmap dh;
  private ImageView oU;
  
  public static tbl a()
  {
    return tbl.a.b();
  }
  
  private void a(Context paramContext, String paramString, tbl.b paramb)
  {
    if (ahbj.isFileExists(aIZ + paramString)) {
      ThreadManagerV2.executeOnFileThread(new ScreenshotManager.1(this, paramString, paramb));
    }
  }
  
  public boolean NG()
  {
    return (this.oU != null) && (this.oU.getVisibility() == 0);
  }
  
  public void a(WebView paramWebView, String paramString, tbl.b paramb)
  {
    if (!a(paramb)) {
      return;
    }
    paramWebView.setDrawingCacheEnabled(true);
    paramWebView.buildDrawingCache();
    this.dh = Bitmap.createBitmap(paramWebView.getDrawingCache());
    if (this.oU == null)
    {
      this.oU = new ImageView(paramWebView.getContext());
      this.oU.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    this.oU.setImageBitmap(this.dh);
    ThreadManagerV2.executeOnSubThread(new ScreenshotManager.2(this, paramString, paramb));
  }
  
  public void a(WebView paramWebView, tbl.b paramb)
  {
    if (!a(paramb)) {
      return;
    }
    this.aOE = true;
    if ((this.oU == null) || (this.oU.getVisibility() != 0))
    {
      paramb.onResponse(0, "removeShotMask no visible");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenshotManager", 2, "removeShotMask call");
    }
    try
    {
      ((ViewGroup)paramWebView.getParent()).removeView(this.oU);
      this.oU.setVisibility(4);
      paramb.onResponse(0, "removeShotMask succ");
      return;
    }
    catch (Throwable paramWebView)
    {
      paramb.onResponse(-400, "removeShotMask fail");
    }
  }
  
  public void a(String paramString, tbl.b paramb)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("switch", tbb.gv("gamecenter_shot_switch"));
      localJSONObject.put("fileExist", ahbj.isFileExists(aIY + paramString));
      paramb.onResponse(0, localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramb.onResponse(-700, "queryShotInfo error");
    }
  }
  
  public void a(tbl.b paramb)
  {
    if (ahbj.deleteFile(aIY))
    {
      paramb.onResponse(0, "delShotFile succ");
      return;
    }
    paramb.onResponse(-500, "delShotFile fail");
  }
  
  public boolean a(tbl.b paramb)
  {
    if (!tbb.gv("gamecenter_shot_switch"))
    {
      if (paramb != null) {
        paramb.onResponse(-1, "shot switch is false");
      }
      return false;
    }
    return true;
  }
  
  public void b(WebView paramWebView, String paramString, tbl.b paramb)
  {
    if (!a(paramb)) {
      return;
    }
    if (this.dh == null)
    {
      paramb.onResponse(-300, "preloadMask not init");
      a(paramWebView.getContext(), paramString, paramb);
      QLog.e("ScreenshotManager", 1, "preloadMask not init");
      return;
    }
    this.oU = new ImageView(paramWebView.getContext());
    this.oU.setScaleType(ImageView.ScaleType.FIT_XY);
    this.oU.setImageBitmap(this.dh);
    this.aOE = false;
    try
    {
      bCs();
      paramString = new FrameLayout.LayoutParams(this.dh.getWidth(), this.dh.getHeight());
      ((ViewGroup)paramWebView.getParent()).addView(this.oU, paramString);
      this.oU.setVisibility(0);
      paramb.onResponse(0, "succ");
      return;
    }
    catch (Throwable paramWebView)
    {
      QLog.e("ScreenshotManager", 1, "addShot error =" + paramWebView.toString());
      paramb.onResponse(-301, "add view error");
    }
  }
  
  public void b(tbl.b paramb)
  {
    QLog.i("ScreenshotManager", 1, "closeShot");
    if (tbb.t("gamecenter_shot_switch", false))
    {
      this.aOD = false;
      paramb.onResponse(0, "closeShot succ");
      return;
    }
    paramb.onResponse(-600, "closeShot fail");
  }
  
  public void bCs()
  {
    try
    {
      if (this.oU.getParent() != null)
      {
        ((ViewGroup)this.oU.getParent()).removeView(this.oU);
        this.oU.setVisibility(4);
        QLog.i("ScreenshotManager", 1, "forceRemoveMask call");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScreenshotManager", 1, "forceRemoveMask e=" + localThrowable.toString());
    }
  }
  
  public void bCt()
  {
    this.oU = null;
  }
  
  public void c(tbl.b paramb)
  {
    QLog.i("ScreenshotManager", 1, "open");
    if (tbb.t("gamecenter_shot_switch", true))
    {
      this.aOD = true;
      paramb.onResponse(0, "openShot succ");
      return;
    }
    paramb.onResponse(-600, "openShot fail");
  }
  
  public void e(WebView paramWebView)
  {
    if (!a(null)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ScreenshotManager.3(this, paramWebView));
  }
  
  public boolean e(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null) {
      try
      {
        paramString = aIZ + paramString;
        rox.checkDirAndCreate(aIY);
        paramString = new FileOutputStream(new File(paramString));
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
        paramString.flush();
        paramString.close();
        return true;
      }
      catch (Exception paramBitmap)
      {
        QLog.e("ScreenshotManager", 1, "screenShot saveBitmap error=" + paramBitmap.toString());
        return false;
      }
    }
    return false;
  }
  
  static class a
  {
    private static tbl a = new tbl();
  }
  
  public static abstract interface b
  {
    public abstract void onResponse(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbl
 * JD-Core Version:    0.7.0.1
 */