import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class ygu
  extends ygj
{
  private CameraEmotionData a;
  private boolean bmB;
  private String path;
  
  public ygu(QQAppInterface paramQQAppInterface, CameraEmotionData paramCameraEmotionData)
  {
    this.a = paramCameraEmotionData;
    this.path = ((afhc)paramQQAppInterface.getManager(333)).a(paramCameraEmotionData);
  }
  
  public boolean TA()
  {
    return true;
  }
  
  public boolean Tz()
  {
    return true;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mExtraInfo = this.a.url;
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public void be(QQAppInterface paramQQAppInterface)
  {
    ((afgw)paramQQAppInterface.getManager(334)).c(this.a);
  }
  
  public URL e()
  {
    try
    {
      URL localURL1 = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
      if (localURL1 == null)
      {
        QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url = null");
        return null;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      URL localURL2;
      for (;;)
      {
        QLog.e("StickerRecCameraData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException.getMessage());
        localURL2 = null;
      }
      return localURL2;
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (((paramContext instanceof BaseActivity)) && (ajpd.O(paramSessionInfo.cZ, paramSessionInfo.aTl)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), acfp.m(2131714810), 0).show(paramContext.getTitleBarHeight());
      return;
    }
    this.bmB = true;
    ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, this.path, true, this.a.strContext, null);
    ((afgw)paramQQAppInterface.getManager(334)).b(this.a);
  }
  
  public String getImgUrl()
  {
    return null;
  }
  
  public boolean isClicked()
  {
    return this.bmB;
  }
  
  public String pA()
  {
    return "a-";
  }
  
  public String pz()
  {
    String str = this.a.md5;
    if (str != null) {
      return str.toLowerCase();
    }
    return null;
  }
  
  public int wH()
  {
    return this.a.exposeNum;
  }
  
  public int wI()
  {
    return this.a.clickNum;
  }
  
  public int wJ()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygu
 * JD-Core Version:    0.7.0.1
 */