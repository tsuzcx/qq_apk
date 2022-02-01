import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class acad
  extends abzy
{
  public Drawable ev;
  public Drawable ew;
  
  public acad(String paramString)
  {
    this.mUin = paramString;
    if ((this.ev == null) || (this.ew == null)) {
      try
      {
        paramString = BaseApplication.getContext().getResources();
        if (paramString != null)
        {
          Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("apolloMainInfoDef");
          Bitmap localBitmap2 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("apolloMainInfoFail");
          if (localBitmap1 != null) {
            this.ev = new BitmapDrawable(localBitmap1);
          }
          while (localBitmap2 != null)
          {
            this.ew = new BitmapDrawable(localBitmap2);
            return;
            this.ev = paramString.getDrawable(2130838097);
            BaseApplicationImpl.sImageHashMap.put("apolloMainInfoDef", BitmapFactory.decodeResource(paramString, 2130838097));
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloMainInfo", 2, paramString.getMessage());
          return;
          this.ew = paramString.getDrawable(2130844558);
          BaseApplicationImpl.sImageHashMap.put("apolloMainInfoFail", BitmapFactory.decodeResource(paramString, 2130844558));
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloMainInfo", 2, paramString.getMessage());
        }
      }
    }
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    Object localObject = null;
    paramContext = null;
    if (this.c == null) {}
    String str;
    do
    {
      do
      {
        return paramContext;
        if (this.c.status == 0) {
          return this.ev;
        }
        str = Integer.toString(1);
        if (TextUtils.isEmpty(this.bkj)) {
          break;
        }
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        localObject = new abtn.a();
        ((abtn.a)localObject).dQ = (abxi.bip + this.c.actionId + File.separator + "txtImg.png");
        ((abtn.a)localObject).mDownloadUrl = this.c.textImg;
        paramContext.mExtraInfo = localObject;
        paramContext.mRequestHeight = ApolloLinearLayout.cug;
        paramContext.mRequestWidth = ApolloLinearLayout.cug;
        localObject = abtn.a(true, ((abtn.a)localObject).dQ, paramContext, this.c.textImg);
        paramContext = (Context)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.c.actionName + " mActionText:" + this.bkj);
      return localObject;
      try
      {
        paramContext = new URL("apollo_pic", null, a(this.c));
        if (paramContext == null) {
          return this.ev;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloMainInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloMainInfo", 2, "decode panel action name =" + this.c.actionName);
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.ew;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.ev;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ApolloLinearLayout.cug;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ApolloLinearLayout.cug;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
        localObject = URLDrawable.getDrawable(paramContext, (URLDrawable.URLDrawableOptions)localObject);
        paramContext = (Context)localObject;
      }
    } while (((URLDrawable)localObject).getStatus() == 1);
    ((URLDrawable)localObject).setTag(this.c);
    ((URLDrawable)localObject).addHeader("apollo_uin", this.mUin);
    ((URLDrawable)localObject).addHeader("apollo_tasks", str);
    return localObject;
  }
  
  public String a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return "action";
    }
    return paramApolloActionData.actionId + "_" + paramApolloActionData.actionName;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if ((this.c == null) || (paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    label320:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMainInfo", 2, "send apolloInfo actionid=" + this.c.actionId + " input =" + paramEditText.getText().toString());
      }
      ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, this);
      paramContext = "";
      if (TextUtils.isEmpty(this.c.inputText))
      {
        paramEditText = "2";
        paramContext = paramEditText;
        if (!TextUtils.isEmpty(this.bkj))
        {
          if (this.cue == 0) {
            paramContext = "6";
          }
        }
        else
        {
          if (paramSessionInfo.cZ != 0) {
            continue;
          }
          paramEditText = paramSessionInfo.aTl;
          i = Integer.parseInt(paramContext);
          paramSessionInfo = "" + this.c.actionId;
          str = "655_" + this.cud;
          if (!TextUtils.isEmpty(this.bkj)) {
            break label320;
          }
        }
      }
      for (paramContext = "0";; paramContext = this.bkj)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "action_sent", paramEditText, i, 0, new String[] { paramSessionInfo, str, paramContext, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramContext = paramEditText;
        if (this.cue != 1) {
          break;
        }
        paramContext = "7";
        break;
        if (TextUtils.isEmpty(this.bkj))
        {
          paramContext = "3";
          break;
        }
        if (this.cue == 0)
        {
          paramContext = "4";
          break;
        }
        if (this.cue != 1) {
          break;
        }
        paramContext = "5";
        break;
      }
    } while (((paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000)) || (this.c.personNum != 0));
    paramEditText = paramSessionInfo.aTl;
    int i = Integer.parseInt(paramContext);
    int j = ApolloUtil.gi(paramSessionInfo.cZ);
    paramSessionInfo = "" + this.c.actionId;
    String str = "655_" + this.cud;
    if (TextUtils.isEmpty(this.bkj)) {}
    for (paramContext = "0";; paramContext = this.bkj)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_action_single_sent", paramEditText, i, j, new String[] { paramSessionInfo, str, paramContext, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acad
 * JD-Core Version:    0.7.0.1
 */