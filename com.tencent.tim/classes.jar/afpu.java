import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.os.MqqHandler;

public class afpu
  extends afmi
  implements afpn
{
  public static final int cTb = Color.parseColor("#21d9c6");
  public static final int cTc = Color.parseColor("#ffffff");
  public String bDZ;
  public boolean cae;
  public Emoticon e;
  private Drawable eM;
  private Drawable eN;
  private Drawable ev;
  private Drawable ew;
  private ColorDrawable i = new ColorDrawable();
  public int imageType;
  public boolean isAPNG;
  public int reqHeight;
  public int reqWidth;
  private String uin;
  
  public afpu(String paramString)
  {
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
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
    }
  }
  
  public static String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    ThreadManager.post(new PicEmoticonInfo.5(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon), 5, null, true);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
    paramSessionInfo = "";
    int k = -1;
    paramContext = ((FragmentActivity)paramContext).getChatFragment();
    int j = k;
    if (paramContext != null)
    {
      paramContext = paramContext.a().a();
      j = k;
      if (paramContext != null) {
        j = paramContext.cN(paramEmoticon.epId);
      }
    }
    paramContext = paramSessionInfo;
    if (j >= 0) {
      paramContext = Integer.toString(j);
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, paramEmoticon.epId, "", paramContext, paramEmoticon.eId);
  }
  
  private void a(QQAppInterface paramQQAppInterface, URL paramURL, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (ajdg)paramQQAppInterface.getManager(14);
      if ((paramEmoticonPackage == null) && (!paramBoolean) && (this.e != null) && (!(paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        paramURL = paramURL.toString();
        paramQQAppInterface.a(this.e.epId, new afpv(this, paramURL));
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      aqrm.b("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send emotion + 1:emotion == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "emotion mall,epid=" + paramEmoticon.epId + ";jobtype=" + paramEmoticon.jobType);
    }
    if (paramEmoticon.isNewSoundEmoticon()) {
      ajdg.e(paramQQAppInterface, "0X800A932", paramSessionInfo.cZ, paramEmoticon.epId);
    }
    if ((paramEmoticon.jobType == 2) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      c(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    if ((paramEmoticon.jobType == 4) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      d(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    afke localafke = (afke)paramQQAppInterface.getManager(43);
    anot.a(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, paramEmoticon.epId, "", "", "");
    ((ajdg)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId, -1, new afpy(paramContext, paramQQAppInterface, paramEmoticon, localafke, paramSessionInfo, paramStickerInfo));
  }
  
  private static void d(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    Object localObject = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
    localObject = (afke)paramQQAppInterface.getManager(43);
    ((ajdg)paramQQAppInterface.getManager(14)).a(paramEmoticon.epId, 0, new afqa(paramContext, paramQQAppInterface, paramEmoticon, (afke)localObject, paramSessionInfo));
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private void dbt()
  {
    if ((this.e.extensionWidth == 0) || (this.e.extensionHeight == 0) || ((this.eM == null) || (this.eN == null))) {}
    try
    {
      Resources localResources = BaseApplication.getContext().getResources();
      this.eM = localResources.getDrawable(2130847982);
      this.eN = localResources.getDrawable(2130847983);
      this.ev = this.eM;
      this.ew = this.eN;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, localException.getMessage());
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, localOutOfMemoryError.getMessage());
        }
      }
    }
  }
  
  public static void o(URLDrawable paramURLDrawable)
  {
    Object localObject;
    if (paramURLDrawable != null)
    {
      localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject == null) || (!(localObject instanceof afqz))) {
          break label73;
        }
        ((afqz)localObject).stop();
        ((afqz)localObject).start();
        paramURLDrawable.invalidateSelf();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
        }
      }
    }
    label73:
    do
    {
      do
      {
        return;
      } while ((localObject == null) || (!(localObject instanceof afra)));
      ((afra)localObject).stop();
      ((afra)localObject).start();
      paramURLDrawable.invalidateSelf();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
  }
  
  public static void p(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable == null) || (!(paramURLDrawable instanceof afqz))) {
          break label62;
        }
        ((afqz)paramURLDrawable).stop();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
        }
      }
    }
    label62:
    do
    {
      do
      {
        return;
      } while ((paramURLDrawable == null) || (!(paramURLDrawable instanceof afra)));
      ((afra)paramURLDrawable).stop();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
  }
  
  public int Dg()
  {
    return this.emoId;
  }
  
  public int Ds()
  {
    return 0;
  }
  
  public int Dt()
  {
    if ((this.e != null) && (this.e.backColor != null)) {}
    int k;
    for (int j = 1;; j = 0)
    {
      k = cTb;
      if (j == 0) {
        return k;
      }
      try
      {
        j = Color.parseColor(this.e.backColor);
        return j;
      }
      catch (Exception localException)
      {
        QLog.e("PicEmoticonInfo", 2, localException, new Object[0]);
      }
    }
    return k;
  }
  
  public int Du()
  {
    if ((this.e != null) && (this.e.volumeColor != null)) {}
    int k;
    for (int j = 1;; j = 0)
    {
      k = cTc;
      if (j == 0) {
        return k;
      }
      try
      {
        j = Color.parseColor(this.e.volumeColor);
        return j;
      }
      catch (Exception localException)
      {
        QLog.e("PicEmoticonInfo", 2, localException, new Object[0]);
      }
    }
    return k;
  }
  
  public void HR(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public int[] P()
  {
    if ((this.e != null) && (this.e.parseSoundPrintString() != null) && (!this.e.parseSoundPrintString().isEmpty()))
    {
      int[] arrayOfInt = new int[this.e.parseSoundPrintString().size()];
      int j = 0;
      while (j < this.e.parseSoundPrintString().size())
      {
        arrayOfInt[j] = ((Integer)this.e.parseSoundPrintString().get(j)).intValue();
        j += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return b(paramContext, paramFloat);
  }
  
  public URLDrawable a(Context paramContext, float paramFloat)
  {
    return a("fromAIO", true);
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, false, null);
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, MarketFaceItemBuilder.b paramb)
  {
    if (this.e == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new URL("emotion_pic", paramString, a(this.e));
        if (paramString == null) {
          continue;
        }
        dbt();
        localObject1 = this.ev;
        localObject1 = this.ew;
        if (paramb != null)
        {
          localObject1 = paramb.image.getDrawable();
          paramb = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramb instanceof QQAppInterface))
          {
            paramb = (QQAppInterface)paramb;
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.ev;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            if (paramb != null)
            {
              localObject1 = (ajdg)paramb.getManager(14);
              if (this.e != null)
              {
                localObject1 = ((ajdg)localObject1).b(this.e.epId, 0);
                if (((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) || (this.isAPNG) || (this.e.isAPNG))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                  }
                  ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
                  ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
                  paramBoolean1 = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.e.extensionWidth;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.e.extensionHeight;
                  localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
                  if (((URLDrawable)localObject2).getStatus() != 1)
                  {
                    ((URLDrawable)localObject2).setTag(this.e);
                    ((URLDrawable)localObject2).addHeader("my_uin", this.uin);
                    ((URLDrawable)localObject2).addHeader("emo_type", String.valueOf(this.imageType));
                    if (paramBoolean2)
                    {
                      ((URLDrawable)localObject2).addHeader("2g_use_gif", "true");
                      if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
                        ((URLDrawable)localObject2).restartDownload();
                      }
                      return localObject2;
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          ((URLDrawable)localObject2).addHeader("2g_use_gif", "false");
          continue;
          a(paramb, paramString, (EmoticonPackage)localObject1, paramBoolean1, (URLDrawable)localObject2);
          continue;
          paramBoolean1 = false;
          continue;
          Object localObject1 = null;
          continue;
          paramb = null;
        }
      }
    }
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, MarketFaceItemBuilder.b paramb, int paramInt1, int paramInt2)
  {
    if (this.e == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new URL("emotion_pic", paramString, a(this.e));
        if (paramString == null) {
          continue;
        }
        dbt();
        localObject1 = this.ev;
        localObject1 = this.ew;
        if (paramb != null)
        {
          localObject1 = paramb.image.getDrawable();
          paramb = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramb instanceof QQAppInterface))
          {
            paramb = (QQAppInterface)paramb;
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.ev;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            if (paramb != null)
            {
              localObject1 = (ajdg)paramb.getManager(14);
              if (this.e != null)
              {
                localObject1 = ((ajdg)localObject1).b(this.e.epId, 0);
                if (((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) || (this.isAPNG) || (this.e.isAPNG))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                  }
                  ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
                  ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
                  paramBoolean1 = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.reqWidth;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.reqHeight;
                  localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
                  if (((URLDrawable)localObject2).getStatus() != 1)
                  {
                    ((URLDrawable)localObject2).setTag(this.e);
                    ((URLDrawable)localObject2).addHeader("my_uin", this.uin);
                    ((URLDrawable)localObject2).addHeader("emo_type", String.valueOf(this.imageType));
                    if (paramBoolean2)
                    {
                      ((URLDrawable)localObject2).addHeader("2g_use_gif", "true");
                      if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
                        ((URLDrawable)localObject2).restartDownload();
                      }
                      return localObject2;
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          ((URLDrawable)localObject2).addHeader("2g_use_gif", "false");
          continue;
          a(paramb, paramString, (EmoticonPackage)localObject1, paramBoolean1, (URLDrawable)localObject2);
          continue;
          paramBoolean1 = false;
          continue;
          Object localObject1 = null;
          continue;
          paramb = null;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    b(paramQQAppInterface, paramContext, paramSessionInfo, this.e, this.stickerInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    if (this.e == null)
    {
      aqrm.b("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send isFroward emotion = null");
    }
    label226:
    label362:
    label380:
    do
    {
      do
      {
        return;
        paramEditText = (afke)paramQQAppInterface.getManager(43);
        if ((this.e.jobType != 2) || (!paramBoolean) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) || (!aiyr.apU())) {
          break label226;
        }
        if (paramEditText.a(this.e.epId, Boolean.valueOf(false))) {
          break;
        }
        ChatActivityUtils.h(paramContext, 2131690208, 0);
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      paramQQAppInterface.obtainMessage(21).sendToTarget();
      return;
      paramInt = aiyh.a(this.e, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "forward,【maxInt:】" + paramInt);
      }
      paramInt = aixo.il(paramInt);
      ((ajdg)paramQQAppInterface.getManager(14)).a(this.e.epId, new afpw(this, paramQQAppInterface, paramInt, paramContext, paramSessionInfo));
      return;
      if ((this.e.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (!paramEditText.d(this.e.epId, true, true)) {
          break label380;
        }
        if (!paramEditText.ajs()) {
          break label362;
        }
        a(paramContext, paramQQAppInterface, paramSessionInfo, this.e);
      }
      for (;;)
      {
        ujt.a(paramQQAppInterface, paramContext, paramSessionInfo, this.e, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "forward not support h5magic");
        }
      }
      ChatActivityUtils.h(paramContext, 2131690208, 0);
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
  }
  
  public boolean ajH()
  {
    return (this.e != null) && (this.e.isSound);
  }
  
  public boolean ajI()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.e == null) || (this.e.jobType == 1))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject = afnu.bEv.replace("[epId]", this.e.epId).replace("[eId]", this.e.eId);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((this.e.isSound) && (bool1))
      {
        localObject = afnu.bEr.replace("[epId]", this.e.epId).replace("[eId]", this.e.eId);
        if (localObject == null) {
          break label165;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists())
        {
          bool1 = bool2;
          if (((File)localObject).isFile()) {
            break;
          }
        }
        return false;
        bool1 = false;
        continue;
      }
      return bool1;
      label165:
      return false;
      bool1 = false;
    }
  }
  
  public boolean ajJ()
  {
    boolean bool = true;
    if (this.e == null) {
      return false;
    }
    Object localObject;
    if (this.e.jobType == 1)
    {
      localObject = afnu.bEs.replace("[epId]", this.e.epId).replace("[eId]", this.e.eId);
      label52:
      if (localObject == null) {
        break label112;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label114;
      }
    }
    for (;;)
    {
      return bool;
      localObject = afnu.bEt.replace("[epId]", this.e.epId).replace("[eId]", this.e.eId);
      break label52;
      label112:
      break;
      label114:
      bool = false;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    if (this.e != null)
    {
      Object localObject = null;
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", a(this.e));
        if (paramContext != null)
        {
          ColorDrawable localColorDrawable = this.i;
          if (this.ew != null)
          {
            localObject = this.ew;
            paramContext = URLDrawable.getDrawable(paramContext, localColorDrawable, (Drawable)localObject, false);
            paramContext.setTag(this.e);
            paramContext.addHeader("my_uin", this.uin);
            return paramContext;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject;
            continue;
            localObject = this.i;
          }
        }
      }
    }
    return this.ev;
  }
  
  public URLDrawable c()
  {
    Object localObject4 = null;
    Object localObject1;
    if (this.e == null) {
      localObject1 = localObject4;
    }
    for (;;)
    {
      return localObject1;
      String str = afnu.bEt.replace("[epId]", this.e.epId).replace("[eId]", this.e.eId);
      localObject1 = localObject4;
      if (str == null) {
        continue;
      }
      try
      {
        localObject3 = new URL("emotion_pic", "fromAIO", a(this.e));
        localObject1 = localObject4;
        if (localObject3 == null) {
          continue;
        }
        dbt();
        localObject3 = URLDrawable.getDrawable((URL)localObject3, this.ev, this.ew, false);
        localObject1 = localObject3;
        if (((URLDrawable)localObject3).getStatus() == 1) {
          continue;
        }
        ((URLDrawable)localObject3).setTag(this.e);
        ((URLDrawable)localObject3).addHeader("my_uin", this.uin);
        localObject1 = localObject3;
        if (!ahbj.isFileExists(str)) {
          continue;
        }
        try
        {
          ((URLDrawable)localObject3).downloadImediatly();
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localObject3;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.drawableId);
        return localObject3;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
        }
      }
    }
  }
  
  public String getPath()
  {
    return "";
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isNewSoundType()
  {
    return (this.e != null) && (this.e.parseSoundPrintString() != null) && (!this.e.parseSoundPrintString().isEmpty());
  }
  
  public String toString()
  {
    if (this.e != null) {
      return String.format("PicEmoticonInfo, name %s, eId %s, epId %s", new Object[] { this.e.name, this.e.eId, this.e.epId });
    }
    return "PicEmoticonInfo TYPE_BIG_EMOTICON and no emoticon";
  }
  
  public String uy()
  {
    return this.bDZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpu
 * JD-Core Version:    0.7.0.1
 */