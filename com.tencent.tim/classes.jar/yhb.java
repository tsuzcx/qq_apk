import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class yhb
  extends ygj
{
  public CustomEmotionData a;
  private Emoticon e;
  private String path;
  
  public yhb(QQAppInterface paramQQAppInterface, CustomEmotionData paramCustomEmotionData)
  {
    this.a = paramCustomEmotionData;
    this.path = ((afhu)paramQQAppInterface.getManager(149)).a(paramCustomEmotionData);
    if (paramCustomEmotionData.isMarkFace) {
      this.e = ((ajdg)paramQQAppInterface.getManager(14)).a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId);
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.path);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", "[图片]");
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", paramString);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)anre.a(localBundle), paramSessionInfo.aTl, paramSessionInfo.cZ, paramSessionInfo.troopUin, 0);
    paramSessionInfo = xtj.i(paramString);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      avdb.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], xtj.hA(paramString) });
    }
  }
  
  public boolean Tz()
  {
    return true;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    if ((this.a.isMarkFace) && (this.e != null))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (this.e.isAPNG)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecFavoriteData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
        }
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mPlayGifImage = false;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
      }
      return localURLDrawableOptions;
    }
    return super.a();
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if ((this.a.isMarkFace) && (this.e != null))
    {
      paramURL = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
      if (paramURL.getStatus() != 1) {
        paramURL.setTag(this.e);
      }
      return paramURL;
    }
    return super.a(paramURL, paramURLDrawableOptions);
  }
  
  public void be(QQAppInterface paramQQAppInterface)
  {
    ((afhv)paramQQAppInterface.getManager(103)).b(this.a);
  }
  
  public URL e()
  {
    if (!this.a.isMarkFace) {}
    URL localURL3;
    for (;;)
    {
      URL localURL2;
      try
      {
        URL localURL1 = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
        if (localURL1 != null) {
          break;
        }
        QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url = null");
        return null;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        QLog.e("StickerRecFavoriteData", 1, "StickerRecFavoriteData getURL url exception e = " + localMalformedURLException1.getMessage());
        localURL2 = null;
        continue;
      }
      try
      {
        localURL2 = new URL("emotion_pic", "fromAIO", this.a.emoPath + "_" + this.a.eId);
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        QLog.e("StickerRecFavoriteData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException2.getMessage());
        localURL3 = null;
      }
    }
    return localURL3;
  }
  
  public void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    super.e(paramQQAppInterface, paramContext, paramSessionInfo);
    if ((this.a.isMarkFace) && (this.e != null))
    {
      ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, this.e);
      if (this.e.isNewSoundEmoticon()) {
        ajdg.e(paramQQAppInterface, "0X800A932", paramSessionInfo.cZ, this.e.epId);
      }
      ((afhv)paramQQAppInterface.getManager(103)).a(this.a);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (ajpd.O(paramSessionInfo.cZ, paramSessionInfo.aTl)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), "热聊暂不支持发送自定义表情", 0).show(paramContext.getTitleBarHeight());
      return;
    }
    if (!this.a.isMarkFace) {}
    for (String str = afpg.c(((afim)paramQQAppInterface.getManager(141)).al(), this.a.md5);; str = null)
    {
      if (xtj.hQ(str))
      {
        d(paramQQAppInterface, paramSessionInfo, str);
        break;
      }
      str = this.path;
      if (!TextUtils.isEmpty(this.a.eId)) {
        bool = true;
      }
      ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, str, true, bool, this.a.eId, null);
      break;
    }
  }
  
  public boolean isNewVoiceType()
  {
    return (this.e != null) && (this.e.parseSoundPrintString() != null) && (!this.e.parseSoundPrintString().isEmpty());
  }
  
  public String pA()
  {
    return "c-";
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
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhb
 * JD-Core Version:    0.7.0.1
 */