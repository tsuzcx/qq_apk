import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class afqh
  extends afmi
{
  private String TAG = "SmallEmoticonInfo";
  public Emoticon e;
  private Drawable ev;
  private Drawable ew;
  private ColorDrawable i = new ColorDrawable();
  public int imageType;
  public boolean isAPNG;
  private int reqHeight;
  private int reqWidth;
  private String uin;
  
  public afqh(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "currentAccountUin:" + paramString);
    }
    this.uin = paramString;
    if ((this.ev == null) || (this.ew == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.ev = paramString.getDrawable(2130838097);
      this.ew = paramString.getDrawable(2130844558);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, paramString.getMessage());
    }
  }
  
  public String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.e == null)
    {
      aqrm.b("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e(this.TAG, 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int j = Integer.parseInt(this.e.eId);
      int k = Integer.parseInt(this.e.epId);
      ((ajdg)paramQQAppInterface.getManager(14)).a(String.valueOf(k), new afqi(this, k, j, paramEditText, paramQQAppInterface));
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      aqrm.b("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e(this.TAG, 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    if (this.e != null) {
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", a(this.e));
        paramContext = URLDrawable.getDrawable(paramContext, this.ev, this.ew, false);
        paramContext.setTag(this.e);
        paramContext.addHeader("my_uin", this.uin);
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "getDrawable ,", paramContext);
        }
        return this.ev;
      }
    }
    return this.ev;
  }
  
  public Drawable c(Context paramContext, float paramFloat)
  {
    paramContext = null;
    if (this.e == null) {}
    do
    {
      for (;;)
      {
        return paramContext;
        try
        {
          Object localObject = new URL("emotion_pic", "fromAIO", a(this.e));
          paramContext = this.ev;
          paramContext = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramContext instanceof QQAppInterface)) {
            paramContext = (QQAppInterface)paramContext;
          }
          paramContext = this.ew;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = paramContext;
          localURLDrawableOptions.mLoadingDrawable = this.ev;
          localURLDrawableOptions.mPlayGifImage = true;
          if (this.isAPNG)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "getBigDrawable: APNG so loaded use apng image");
            }
            localURLDrawableOptions.mUseApngImage = true;
            localURLDrawableOptions.mPlayGifImage = false;
            localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
          }
          localURLDrawableOptions.mRequestWidth = this.reqWidth;
          localURLDrawableOptions.mRequestHeight = this.reqHeight;
          localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
          paramContext = (Context)localObject;
          if (((URLDrawable)localObject).getStatus() != 1)
          {
            ((URLDrawable)localObject).setTag(this.e);
            ((URLDrawable)localObject).addHeader("my_uin", this.uin);
            ((URLDrawable)localObject).addHeader("emo_big", "true");
            paramContext = (Context)localObject;
            if (QLog.isColorLevel())
            {
              QLog.d(this.TAG, 2, "b.getStatus=" + ((URLDrawable)localObject).getStatus() + " e.epId=" + this.e.epId + " e.eId=" + this.e.eId);
              return localObject;
            }
          }
        }
        catch (MalformedURLException localMalformedURLException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getDrawable ,", localMalformedURLException);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqh
 * JD-Core Version:    0.7.0.1
 */