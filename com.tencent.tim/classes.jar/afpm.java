import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class afpm
  extends afmi
{
  static long lastTime;
  public EmotionSearchItem a;
  protected String bDq;
  protected int cTa;
  protected int mPageType;
  
  public afpm(int paramInt1, int paramInt2, String paramString, EmotionSearchItem paramEmotionSearchItem)
  {
    this.mPageType = paramInt1;
    this.bDq = paramString;
    this.a = paramEmotionSearchItem;
    this.cTa = paramInt2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    do
    {
      return;
      lastTime = l;
      if (((paramContext instanceof BaseActivity)) && (ajpd.O(paramSessionInfo.cZ, paramSessionInfo.aTl)))
      {
        paramContext = (BaseActivity)paramContext;
        QQToast.a(paramQQAppInterface.getApp(), acfp.m(2131703361), 0).show(paramContext.getTitleBarHeight());
        return;
      }
    } while (!(paramContext instanceof BaseActivity));
    int j = 0;
    paramEditText = null;
    Object localObject = ahyv.f(this.a.originalUrl);
    int i;
    if ((localObject != null) && (aqhq.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath())))
    {
      localObject = ((File)localObject).getAbsolutePath();
      j = 1;
      paramEditText = (EditText)localObject;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPicOringinal = " + this.a.originalUrl + ", paths = " + (String)localObject);
        i = j;
        paramEditText = (EditText)localObject;
      }
    }
    while ((paramEditText == null) && (paramSessionInfo.cZ != 1008))
    {
      QQToast.a(paramContext, 2131701267, 0).show();
      return;
      i = j;
      if (HotPicPageView.a(this.a) == 0)
      {
        localObject = ahyv.f(this.a.url).getAbsolutePath();
        paramEditText = (EditText)localObject;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPic = " + this.a.url + ", paths = " + (String)localObject);
          paramEditText = (EditText)localObject;
          i = j;
        }
      }
    }
    cO(paramQQAppInterface);
    paramQQAppInterface = new Intent();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramEditText);
    paramQQAppInterface.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    paramQQAppInterface.putExtra("uin", paramSessionInfo.aTl);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.cZ);
    paramQQAppInterface.putExtra("troop_uin", paramSessionInfo.troopUin);
    paramQQAppInterface.putExtra("key_confess_topicid", paramSessionInfo.topicId);
    paramQQAppInterface.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramQQAppInterface.putExtra("send_in_background", true);
    paramQQAppInterface.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject);
    paramQQAppInterface.putExtra("PicContants.NEED_COMPRESS", false);
    if (i == 0)
    {
      paramQQAppInterface.putExtra("quick_send_original_md5", this.a.originalMD5);
      paramQQAppInterface.putExtra("quick_send_original_size", this.a.oringinalSize);
      paramQQAppInterface.putExtra("quick_send_thumb_md5", this.a.md5);
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
    }
    for (;;)
    {
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramQQAppInterface, null), 8, null, false);
      return;
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mLoadingDrawable = HotPicPageView.cF;
    paramContext.mFailedDrawable = HotPicPageView.cF;
    paramContext.mPlayGifImage = true;
    paramContext.mExtraInfo = this.a;
    URL localURL = ahyv.getURL(this.a.url);
    if (localURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(localURL, paramContext);
  }
  
  public Drawable c(Context paramContext, float paramFloat)
  {
    return b(paramContext, paramFloat);
  }
  
  protected void cO(QQAppInterface paramQQAppInterface)
  {
    if (this.mPageType == 1) {
      if (!aqmr.isEmpty(this.bDq)) {
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X800AE2E", "0X800AE2E", 0, 0, this.cTa + "", "", this.a.getEmoMd5(), "");
      }
    }
    while (this.mPageType != 2)
    {
      return;
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800AE20", "0X800AE20", 0, 0, this.cTa + "", "", this.a.getEmoMd5(), "");
      return;
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, this.cTa + "", "", this.a.getEmoMd5(), "");
  }
  
  public String toString()
  {
    return String.format("HotPicSearchEmoticonInfo, SearchItem %s", new Object[] { this.a.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpm
 * JD-Core Version:    0.7.0.1
 */