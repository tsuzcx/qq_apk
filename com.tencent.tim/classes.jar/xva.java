import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.1;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.2;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xva
{
  private static xva a;
  private static final String aWA = acfp.m(2131711266);
  public static String aWx = "qim_need_show_text_bubble";
  private static final String aWy = acbn.bnF + "icons/";
  private static final String aWz = acbn.bnF + "zip/";
  private String aWB = "";
  private String aWC = "";
  private String aWD = "";
  private String aWE = aWA;
  private String aWF = "";
  private volatile int bXu;
  private int bXv = 0;
  private int bXw = 0;
  private int bXx = 0;
  private boolean bjW = false;
  private boolean bjX;
  private boolean bjY;
  
  public static xva a()
  {
    if (a == null) {
      a = new xva();
    }
    return a;
  }
  
  private void bc(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!this.bjX) || (!this.aWF.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (paramQQAppInterface.contains(str + "_" + "qim_user_special_config_version"))
        {
          this.bXv = paramQQAppInterface.getInt(str + "_" + "qim_user_special_config_avatar_switch", 0);
          this.bXw = paramQQAppInterface.getInt(str + "_" + "qim_user_special_config_title_bg_switch", 0);
          this.bXx = paramQQAppInterface.getInt(str + "_" + "qim_user_special_config_bubble_switch", 0);
          this.aWB = paramQQAppInterface.getString(str + "_" + "qim_user_special_config_resources_url", "");
          this.aWD = paramQQAppInterface.getString(str + "_" + "qim_user_special_config_resources_md5", "");
          this.aWC = paramQQAppInterface.getString(str + "_" + "qim_user_special_config_qim_website", "");
          this.aWE = paramQQAppInterface.getString(str + "_" + "qim_user_special_config_online_wording", aWA);
          this.bjY = paramQQAppInterface.getBoolean("qim_user_special_need_force_download", false);
        }
        this.aWF = str;
        this.bjX = true;
        if (QLog.isColorLevel()) {
          QLog.d("QIMUserManager", 2, String.format("readAllConfigFromSp, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, mQimWebsite:%s", new Object[] { Integer.valueOf(this.bXv), Integer.valueOf(this.bXw), Integer.valueOf(this.bXw), this.aWB, this.aWD, this.aWE, Boolean.valueOf(this.bjY), this.aWC }));
        }
      }
    }
  }
  
  private List<String> cM()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("qim_theme_icon_names_sp", 0).getString("android_qim_theme_icon_names", "");
    String[] arrayOfString = null;
    if (!TextUtils.isEmpty(str)) {
      arrayOfString = str.split("\\|");
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      while (i < arrayOfString.length)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void cfg()
  {
    int i = 0;
    Object localObject = new File(aWy);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qim_theme_icon_names_sp", 0).edit();
      localObject = ((File)localObject).list();
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < localObject.length)
      {
        String str = localObject[i].substring(localObject[i].lastIndexOf("/") + 1);
        localStringBuilder.append(str + "|");
        i += 1;
      }
      localEditor.putString("android_qim_theme_icon_names", localStringBuilder.toString());
      localEditor.apply();
    }
  }
  
  private void cfh()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qim_theme_icon_names_sp", 0).edit().remove("android_qim_theme_icon_names");
  }
  
  /* Error */
  private boolean hU(String paramString)
  {
    // Byte code:
    //   0: new 247	java/io/File
    //   3: dup
    //   4: new 35	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 59	xva:aWz	Ljava/lang/String;
    //   14: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 295
    //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokespecial 250	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 253	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_2
    //   40: invokevirtual 298	java/io/File:getPath	()Ljava/lang/String;
    //   43: invokestatic 304	aqhq:px	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_3
    //   48: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne -14 -> 37
    //   54: aload_3
    //   55: aload_1
    //   56: invokevirtual 307	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   59: ifeq -22 -> 37
    //   62: getstatic 55	xva:aWy	Ljava/lang/String;
    //   65: invokestatic 310	aqhq:cm	(Ljava/lang/String;)V
    //   68: aload_2
    //   69: getstatic 55	xva:aWy	Ljava/lang/String;
    //   72: invokestatic 316	jqp:b	(Ljava/io/File;Ljava/lang/String;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: astore_1
    //   78: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq -44 -> 37
    //   84: aload_1
    //   85: invokevirtual 319	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_1
    //   91: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -57 -> 37
    //   97: aload_1
    //   98: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   101: iconst_0
    //   102: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	xva
    //   0	103	1	paramString	String
    //   29	40	2	localFile	File
    //   46	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   39	47	77	java/lang/UnsatisfiedLinkError
    //   62	75	90	java/lang/Exception
  }
  
  private int r(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMUserManager", 2, " doDowndLoadQimThemeZip zipUrl " + paramString1);
    }
    File localFile = new File(aWy);
    paramString2 = new File(aWz);
    if (!localFile.exists())
    {
      localFile.mkdirs();
      localFile = new File(aWy + ".nomedia");
    }
    for (;;)
    {
      try
      {
        localFile.createNewFile();
        if (paramString2.exists()) {
          break label188;
        }
        paramString2.mkdirs();
        paramString1 = new aquz(paramString1, new File(aWz + "android_qim_theme_icons.zip"));
        paramString1.cxX = "profileCardDownload";
        paramString1.cxW = "VIP_profilecard";
        return aqva.a(paramString1, null);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      aqhq.cm(aWy);
      continue;
      label188:
      aqhq.cm(aWz);
    }
  }
  
  public boolean D(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.bjY;
  }
  
  public boolean SR()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.bXu == 2)
    {
      bool2 = bool1;
      return bool2;
    }
    if ((this.bXu == 1) || (this.bXu == 3) || (this.bXu == 4)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMUserManager", 2, "isQimIconsOk QimIconsState " + this.bXu);
    }
    Object localObject2 = new File(aWy);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
    {
      Object localObject1 = cM();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).list();
      bool1 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (localObject2.length > 0)
        {
          int i = 0;
          while (i < localObject2.length)
          {
            localArrayList.add(localObject2[i].substring(localObject2[i].lastIndexOf("/") + 1));
            i += 1;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            if (!localArrayList.contains((String)((Iterator)localObject1).next())) {
              bool1 = bool2;
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.bXu = 2;
      return bool1;
      bool1 = false;
      continue;
      bool1 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.bjX = true;
    this.bXv = paramInt1;
    this.bXw = paramInt2;
    this.aWB = paramString1;
    this.aWC = paramString2;
    this.aWD = paramString3;
    this.aWE = paramString4;
    this.bjY = paramBoolean;
    this.bXx = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("QIMUserManager", 2, String.format("setQimUserSpecial, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, qimWebsite:%s", new Object[] { Integer.valueOf(this.bXv), Integer.valueOf(this.bXw), Integer.valueOf(this.bXw), this.aWB, this.aWD, this.aWE, Boolean.valueOf(this.bjY), paramString2 }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.bXu == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMUserManager", 2, "startDownLoadQimTheme QimIconsState " + this.bXu);
    }
    this.bXu = 1;
    cfh();
    if (paramBoolean)
    {
      ThreadManager.post(new QIMUserManager.1(this, paramString1, paramString2, paramQQAppInterface, paramBoolean), 8, null, true);
      return;
    }
    if (hU(paramString2))
    {
      cfg();
      this.bXu = 2;
      return;
    }
    ThreadManager.post(new QIMUserManager.2(this, paramString1, paramString2, paramBoolean), 8, null, true);
  }
  
  public boolean a(Object paramObject, SessionInfo paramSessionInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSessionInfo.beq)
    {
      bool1 = bool2;
      if (paramSessionInfo.bew) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool3 = "2".equals(paramChatMessage.getExtInfoFromExtStr("app_qim_tail_id"));
    boolean bool1 = bool2;
    if (a().q(paramQQAppInterface) == 1)
    {
      bool1 = bool2;
      if (!paramChatMessage.isSend()) {
        if (!bool3)
        {
          bool1 = bool2;
          if (!a().r(paramQQAppInterface, paramChatMessage.senderuin)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if ((!paramBoolean) && ((!(paramObject instanceof xov)) || ((paramObject instanceof xpc)))) {}
    do
    {
      return false;
      paramBoolean = "2".equals(paramChatMessage.getExtInfoFromExtStr("app_qim_tail_id"));
    } while ((a().r(paramQQAppInterface) != 1) || (paramChatMessage.isSend()) || ((!paramBoolean) && (!a().r(paramQQAppInterface, paramChatMessage.senderuin))));
    return true;
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = l(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("QIMUserManager", 2, "jumpToQimWebsite: invoked. info: qimWebsiteUrl = " + paramQQAppInterface);
    }
    if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramContext != null)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramQQAppInterface);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QIMUserManager", 2, "jumpToQimWebsite: Failed. info: exception = ", paramQQAppInterface);
    }
  }
  
  public void j(ArrayList<xva.a> paramArrayList, ArrayList<int[]> paramArrayList1)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList1.size())
      {
        localArrayList.add(((int[])paramArrayList1.get(i)).clone());
        i += 1;
      }
      ThreadManager.postImmediately(new QIMUserManager.5(this, paramArrayList, localArrayList), null, true);
    }
  }
  
  public String k(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.aWB;
  }
  
  public void k(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool2 = true;
    Object localObject = (acff)paramQQAppInterface.getManager(51);
    if (localObject != null)
    {
      localObject = ((acff)localObject).e(paramSessionInfo.aTl);
      if ((localObject != null) && (((Friends)localObject).netTypeIconId == 11))
      {
        paramSessionInfo.beq = true;
        if (paramSessionInfo.beq)
        {
          paramSessionInfo.isNightMode = ThemeUtil.isInNightMode(paramQQAppInterface);
          if ((s(paramQQAppInterface) == 1) || (q(paramQQAppInterface) == 1))
          {
            if (!D(paramQQAppInterface)) {
              break label178;
            }
            a(paramQQAppInterface, true, k(paramQQAppInterface), m(paramQQAppInterface));
          }
          boolean bool3 = SR();
          if ((s(paramQQAppInterface) != 1) || (!bool3)) {
            break label204;
          }
          bool1 = true;
          label129:
          paramSessionInfo.bes = bool1;
          if ((q(paramQQAppInterface) != 1) || (!bool3)) {
            break label209;
          }
          bool1 = true;
          label150:
          paramSessionInfo.beu = bool1;
          if ((r(paramQQAppInterface) != 1) || (!bool3)) {
            break label214;
          }
        }
      }
    }
    label178:
    label204:
    label209:
    label214:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramSessionInfo.bew = bool1;
      return;
      if (SR()) {
        break;
      }
      a(paramQQAppInterface, false, k(paramQQAppInterface), m(paramQQAppInterface));
      break;
      bool1 = false;
      break label129;
      bool1 = false;
      break label150;
    }
  }
  
  public String l(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.aWC;
  }
  
  public String m(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.aWD;
  }
  
  public Drawable n(int paramInt)
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    switch (paramInt)
    {
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      localDrawable = (Drawable)BaseApplicationImpl.sImageCache.get("skin_header_bar.png");
      localObject = localDrawable;
    } while (localDrawable != null);
    localObject = aqhu.d(aWy + "skin_header_bar.png", localOptions);
    if (localObject != null)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      BaseApplicationImpl.sImageCache.put("skin_header_bar.png", localObject);
      return localObject;
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
  }
  
  public Drawable o(int paramInt)
  {
    Object localObject2 = null;
    Bitmap localBitmap = null;
    Object localObject3 = new BitmapFactory.Options();
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      localObject2 = (Drawable)BaseApplicationImpl.sImageCache.get("skin_aio_qim_header_flag.png");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localBitmap = aqhu.d(aWy + "skin_aio_qim_header_flag.png", (BitmapFactory.Options)localObject3);
        localObject1 = localObject2;
        if (localBitmap != null)
        {
          localObject1 = new BitmapDrawable(localBitmap);
          BaseApplicationImpl.sImageCache.put("skin_aio_qim_header_flag.png", localObject1);
          continue;
          localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get("title_bg_round.9.png");
          if (localBitmap == null)
          {
            localObject1 = aqhu.d(aWy + "title_bg_round.9.png", (BitmapFactory.Options)localObject3);
            if (localObject1 == null) {
              break;
            }
            BaseApplicationImpl.sImageCache.put("title_bg_round.9.png", localObject1);
            localObject2 = ((Bitmap)localObject1).getNinePatchChunk();
            if ((localObject2 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject2))) {
              break label501;
            }
            localObject1 = new NinePatchDrawable((Bitmap)localObject1, (byte[])localObject2, new Rect(), null);
            continue;
          }
          localObject3 = localBitmap.getNinePatchChunk();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (NinePatch.isNinePatchChunk((byte[])localObject3)) {
              localObject1 = new NinePatchDrawable(localBitmap, (byte[])localObject3, new Rect(), null);
            }
          }
          continue;
          localObject2 = (Drawable)BaseApplicationImpl.sImageCache.get("aio_qim_online_icon.png");
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localBitmap = aqhu.d(aWy + "aio_qim_online_icon.png", (BitmapFactory.Options)localObject3);
            localObject1 = localObject2;
            if (localBitmap != null)
            {
              localObject1 = new BitmapDrawable(localBitmap);
              BaseApplicationImpl.sImageCache.put("skin_aio_qim_header_flag.png", localObject1);
              continue;
              localObject1 = localBitmap;
              if ((Drawable)BaseApplicationImpl.sImageCache.get("qim_title_immersive_bar.png") == null)
              {
                localObject2 = aqhu.d(aWy + "qim_title_immersive_bar.png", (BitmapFactory.Options)localObject3);
                localObject1 = localBitmap;
                if (localObject2 != null)
                {
                  return new BitmapDrawable((Bitmap)localObject2);
                  localObject2 = (Drawable)BaseApplicationImpl.sImageCache.get("aio_qim_user_online_title_icon.png");
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    localObject1 = aqhu.d(aWy + "aio_qim_user_online_title_icon.png", (BitmapFactory.Options)localObject3);
                    localObject1 = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject1);
                    ((Drawable)localObject1).setBounds(0, 0, ankt.dip2px(13.0F), ankt.dip2px(13.0F));
                    continue;
                    label501:
                    localObject1 = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int q(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.bXv;
  }
  
  public int r(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.bXx;
  }
  
  public boolean r(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.netTypeIconId == 11;
    }
    return false;
  }
  
  public int s(QQAppInterface paramQQAppInterface)
  {
    bc(paramQQAppInterface);
    return this.bXw;
  }
  
  public void zD(boolean paramBoolean)
  {
    this.bjW = paramBoolean;
  }
  
  public static class a
  {
    public RedDotImageView c;
    public Drawable icon;
    public int index;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xva
 * JD-Core Version:    0.7.0.1
 */