import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class yhd
  extends ygj
{
  private String aXK;
  public Emoticon f;
  
  public yhd(Emoticon paramEmoticon)
  {
    this.f = paramEmoticon;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (this.f.isAPNG)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecLocalData", 2, "getURLDrawableOptions: APNG so loaded use apng image");
      }
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
    }
    return localURLDrawableOptions;
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      paramURL = null;
    }
    do
    {
      return paramURL;
      paramURLDrawableOptions = URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
      paramURL = paramURLDrawableOptions;
    } while (paramURLDrawableOptions.getStatus() == 1);
    paramURLDrawableOptions.setTag(this.f);
    return paramURLDrawableOptions;
  }
  
  public void be(QQAppInterface paramQQAppInterface)
  {
    ((ajdg)paramQQAppInterface.getManager(14)).b(this);
  }
  
  public URL e()
  {
    try
    {
      URL localURL1 = new URL("emotion_pic", "fromAIO", this.f.epId + "_" + this.f.eId);
      if (localURL1 == null)
      {
        QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url = null");
        return null;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      URL localURL2;
      for (;;)
      {
        QLog.e("StickerRecLocalData", 1, "StickerLocalRecData getURL url exception e = " + localMalformedURLException.getMessage());
        localURL2 = null;
      }
      return localURL2;
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super.e(paramQQAppInterface, paramContext, paramSessionInfo);
    ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, this.f);
    if ((this.f != null) && (this.f.isNewSoundEmoticon())) {
      ajdg.e(paramQQAppInterface, "0X800A932", paramSessionInfo.cZ, this.f.epId);
    }
    ((ajdg)paramQQAppInterface.getManager(14)).i(this.f);
  }
  
  public boolean isNewVoiceType()
  {
    return (this.f.parseSoundPrintString() != null) && (!this.f.parseSoundPrintString().isEmpty());
  }
  
  public String pA()
  {
    if (isNewVoiceType()) {
      return "d-";
    }
    return "b-";
  }
  
  public String pz()
  {
    if (this.aXK != null) {
      return this.aXK;
    }
    if (this.f.isAPNG) {}
    for (Object localObject = afnu.bEw.replace("[epId]", this.f.epId).replace("[eId]", this.f.eId);; localObject = afnu.bEv.replace("[epId]", this.f.epId).replace("[eId]", this.f.eId))
    {
      localObject = MD5.getFileMd5((String)localObject);
      if (localObject == null) {
        break;
      }
      this.aXK = MD5.toMD5((byte[])localObject);
      if (this.aXK != null) {
        this.aXK = this.aXK.toLowerCase();
      }
      return this.aXK;
    }
    return null;
  }
  
  public int wH()
  {
    return this.f.exposeNum;
  }
  
  public int wI()
  {
    return this.f.clickNum;
  }
  
  public int wJ()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhd
 * JD-Core Version:    0.7.0.1
 */