import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.10;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.5;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.6;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.7;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.9;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class anjo
  implements Manager
{
  private static anjo b;
  public static volatile boolean bXy;
  private static boolean cFX;
  public static boolean cHu;
  private static boolean cHz;
  public static final String ceq = acbn.SDCARD_PATH + "VideoRedbagRes" + File.separator;
  public static String cer = "TemplateTips";
  public static String ces = "OutRedIconVer";
  public static String cet = "OutRedIconAIO";
  public static String ceu = "OutRedIconPreview";
  public static String cev = "OutRedIconPlus1";
  public static String cew = "OutRedIconPlus2";
  public static String cex = "OutRedIconClose";
  public static int dIE;
  public static int dIF = 1;
  private ImageView DG;
  private ImageView DH;
  private ImageView DI;
  public MqqHandler M;
  private HandlerThread W;
  private TextView Zv;
  private String aWf;
  private AIOShortVideoData c;
  private boolean cHv;
  private boolean cHw;
  private boolean cHx;
  private boolean cHy;
  private AIOShortVideoData d;
  int i = 0;
  private BroadcastReceiver mBroadcastReceiver = new anjp(this);
  private Activity mContext;
  private long mCurTime;
  private Handler mHandler;
  private long mLastTime;
  
  public anjo(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof PeakAppInterface))
    {
      ((PeakAppInterface)paramAppInterface).bIG = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      paramAppInterface.getApp().registerReceiver(this.mBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static void QD(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    String str = localAppRuntime.getAccount();
    localAppRuntime.getApplication().getSharedPreferences(cer, 4).edit().putBoolean(paramString + str, true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoManager", 4, new Object[] { "updateRedBagEntranceStat, entranceType:", paramString });
    }
  }
  
  public static void R(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((!paramBoolean) && (cHu)) {
      return;
    }
    cHu = true;
    ThreadManager.post(new RedBagVideoManager.2(paramQQAppInterface), 5, null, true);
  }
  
  private static boolean S(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label39:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label39;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  private RelativeLayout.LayoutParams a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    if ((paramCustomFrameAnimationDrawable != null) && (this.mContext != null))
    {
      int j = paramCustomFrameAnimationDrawable.getIntrinsicWidth();
      int k = paramCustomFrameAnimationDrawable.getIntrinsicHeight();
      paramCustomFrameAnimationDrawable = new RelativeLayout.LayoutParams(wja.dp2px(j / 2, this.mContext.getResources()), wja.dp2px(k / 2, this.mContext.getResources()));
      paramCustomFrameAnimationDrawable.addRule(12);
      paramCustomFrameAnimationDrawable.addRule(14);
      return paramCustomFrameAnimationDrawable;
    }
    return null;
  }
  
  public static anjo a(AppInterface paramAppInterface)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new anjo(paramAppInterface);
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  private CustomFrameAnimationDrawable a(String paramString)
  {
    // Byte code:
    //   0: new 78	java/io/File
    //   3: dup
    //   4: new 62	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 87	anjo:ceq	Ljava/lang/String;
    //   14: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 235	java/io/File:exists	()Z
    //   32: ifeq +220 -> 252
    //   35: aload_1
    //   36: invokevirtual 318	java/io/File:listFiles	()[Ljava/io/File;
    //   39: astore_1
    //   40: new 320	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 321	java/util/ArrayList:<init>	()V
    //   47: astore 4
    //   49: aload_1
    //   50: ifnull +202 -> 252
    //   53: aload_1
    //   54: arraylength
    //   55: ifle +197 -> 252
    //   58: aload_1
    //   59: arraylength
    //   60: istore_3
    //   61: iconst_0
    //   62: istore_2
    //   63: iload_2
    //   64: iload_3
    //   65: if_icmpge +26 -> 91
    //   68: aload_1
    //   69: iload_2
    //   70: aaload
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +179 -> 254
    //   78: aload 4
    //   80: aload 5
    //   82: invokeinterface 327 2 0
    //   87: pop
    //   88: goto +166 -> 254
    //   91: aload 4
    //   93: invokeinterface 330 1 0
    //   98: iconst_1
    //   99: if_icmple +129 -> 228
    //   102: aload 4
    //   104: invokestatic 336	java/util/Collections:sort	(Ljava/util/List;)V
    //   107: new 338	android/graphics/BitmapFactory$Options
    //   110: dup
    //   111: invokespecial 339	android/graphics/BitmapFactory$Options:<init>	()V
    //   114: astore_1
    //   115: aload_1
    //   116: iconst_1
    //   117: putfield 342	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   120: aload_1
    //   121: iconst_1
    //   122: putfield 345	android/graphics/BitmapFactory$Options:inMutable	Z
    //   125: aload 4
    //   127: ifnull +125 -> 252
    //   130: aload 4
    //   132: invokeinterface 330 1 0
    //   137: ifle +115 -> 252
    //   140: aload 4
    //   142: iconst_0
    //   143: invokeinterface 349 2 0
    //   148: checkcast 78	java/io/File
    //   151: invokevirtual 352	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: aload_1
    //   155: invokestatic 357	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore_1
    //   159: new 275	com/tencent/mobileqq/activity/aio/item/CustomFrameAnimationDrawable
    //   162: dup
    //   163: invokestatic 360	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   166: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   169: aload_1
    //   170: aload_0
    //   171: getfield 363	anjo:M	Lmqq/os/MqqHandler;
    //   174: invokespecial 366	com/tencent/mobileqq/activity/aio/item/CustomFrameAnimationDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lmqq/os/MqqHandler;)V
    //   177: astore_1
    //   178: iconst_0
    //   179: istore_2
    //   180: iload_2
    //   181: aload 4
    //   183: invokeinterface 330 1 0
    //   188: if_icmpge +62 -> 250
    //   191: aload 4
    //   193: iload_2
    //   194: invokeinterface 349 2 0
    //   199: checkcast 78	java/io/File
    //   202: astore 5
    //   204: aload 5
    //   206: ifnull +15 -> 221
    //   209: aload_1
    //   210: iload_2
    //   211: bipush 40
    //   213: aload 5
    //   215: invokevirtual 352	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 370	com/tencent/mobileqq/activity/aio/item/CustomFrameAnimationDrawable:u	(IILjava/lang/String;)V
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -45 -> 180
    //   228: invokestatic 373	anjo:dQY	()V
    //   231: goto -124 -> 107
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_1
    //   238: aload 4
    //   240: invokevirtual 376	java/lang/Exception:printStackTrace	()V
    //   243: aload_1
    //   244: areturn
    //   245: astore 4
    //   247: goto -9 -> 238
    //   250: aload_1
    //   251: areturn
    //   252: aconst_null
    //   253: areturn
    //   254: iload_2
    //   255: iconst_1
    //   256: iadd
    //   257: istore_2
    //   258: goto -195 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	anjo
    //   0	261	1	paramString	String
    //   62	196	2	j	int
    //   60	6	3	k	int
    //   47	145	4	localArrayList	ArrayList
    //   234	5	4	localException1	Exception
    //   245	1	4	localException2	Exception
    //   71	143	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	49	234	java/lang/Exception
    //   53	61	234	java/lang/Exception
    //   78	88	234	java/lang/Exception
    //   91	107	234	java/lang/Exception
    //   107	125	234	java/lang/Exception
    //   130	178	234	java/lang/Exception
    //   228	231	234	java/lang/Exception
    //   180	204	245	java/lang/Exception
    //   209	221	245	java/lang/Exception
  }
  
  public static void a(Intent paramIntent, Activity paramActivity)
  {
    if ((paramIntent == null) || (paramActivity == null)) {}
    while (!paramIntent.getBooleanExtra("open_chatfragment", false)) {
      return;
    }
    aalb.w(paramActivity, paramIntent);
  }
  
  public static void a(View paramView, ShortVideoRealItemBuilder.a parama, ChatMessage paramChatMessage, Context paramContext)
  {
    if ((paramView == null) || (paramChatMessage == null) || (!(paramView instanceof RelativeLayout)) || (!(paramChatMessage instanceof MessageForShortVideo))) {}
    label213:
    label510:
    for (;;)
    {
      return;
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      int j;
      if (paramChatMessage.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
        if (paramChatMessage.isSend()) {
          if (paramChatMessage.redBagStat == 0) {
            j = 1;
          }
        }
      }
      for (;;)
      {
        if (parama.bVB == j) {
          break label510;
        }
        parama.bVB = j;
        if (j != 0)
        {
          if (paramView.findViewById(2131374841) != null)
          {
            paramView.findViewById(2131374840).setVisibility(0);
            parama = (ImageView)paramView.findViewById(2131374841);
            if (j == 1) {
              parama.setImageResource(2130850745);
            }
            for (;;)
            {
              parama.setVisibility(0);
              paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131374840)).getLayoutParams();
              if (!paramChatMessage.isSend()) {
                break label213;
              }
              paramView.rightMargin = wja.dp2px(6.0F, paramContext.getResources());
              paramView.leftMargin = 0;
              return;
              j = 2;
              break;
              j = 3;
              break;
              if (j == 2) {
                parama.setImageResource(2130850746);
              } else if (j == 3) {
                parama.setImageResource(2130850744);
              }
            }
            paramView.rightMargin = 0;
            paramView.leftMargin = wja.dp2px(6.0F, paramContext.getResources());
            return;
          }
          parama = new ImageView(paramContext);
          parama.setBackgroundDrawable(paramContext.getResources().getDrawable(2130850743));
          parama.setId(2131374840);
          parama.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(70.0F, paramContext.getResources()));
          localLayoutParams.addRule(7, 2131373231);
          localLayoutParams.addRule(8, 2131373231);
          if (paramChatMessage.isSend())
          {
            localLayoutParams.rightMargin = wja.dp2px(6.0F, paramContext.getResources());
            localLayoutParams.leftMargin = 0;
            ((RelativeLayout)paramView).addView(parama, localLayoutParams);
            parama = new ImageView(paramContext);
            if (j != 1) {
              break label441;
            }
            parama.setImageResource(2130850745);
          }
          for (;;)
          {
            parama.setId(2131374841);
            parama.setVisibility(0);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(8, 2131373231);
            paramChatMessage.addRule(14);
            ((RelativeLayout)paramView).addView(parama, paramChatMessage);
            return;
            localLayoutParams.rightMargin = 0;
            localLayoutParams.leftMargin = wja.dp2px(6.0F, paramContext.getResources());
            break;
            if (j == 2) {
              parama.setImageResource(2130850746);
            } else if (j == 3) {
              parama.setImageResource(2130850744);
            }
          }
        }
        if (paramView.findViewById(2131374841) == null) {
          break;
        }
        paramView.findViewById(2131374841).setVisibility(4);
        paramView.findViewById(2131374840).setVisibility(4);
        return;
        j = 0;
      }
    }
  }
  
  public static boolean axB()
  {
    if (!cFX)
    {
      cFX = true;
      bool1 = alwy.auJ();
      boolean bool2 = ankq.axZ();
      if ((!bool1) || (!bool2)) {
        break label61;
      }
    }
    label61:
    for (boolean bool1 = true;; bool1 = false)
    {
      cHz = bool1;
      QLog.d("RedBagVideoManager", 1, new Object[] { "RedBagVideoManager init, support: ", Boolean.valueOf(cHz) });
      return cHz;
    }
  }
  
  public static void bB(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      String str = ((AppRuntime)localObject).getAccount();
      localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences(cer, 4);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      if ((paramJSONObject.has("outRedIconShow")) && (paramJSONObject.has("outRedIconVer")) && (paramJSONObject.getInt("outRedIconShow") == 1))
      {
        int j = ((SharedPreferences)localObject).getInt(ces, -1);
        int k = paramJSONObject.getInt("outRedIconVer");
        if (k > j)
        {
          localEditor.putBoolean(cet + str, false);
          localEditor.putBoolean(ceu + str, false);
          localEditor.putBoolean(cev + str, false);
          localEditor.putBoolean(cew + str, false);
          localEditor.putInt(ces + str, k);
          localEditor.putInt(ces, k);
          localEditor.remove(cex);
          localEditor.commit();
        }
      }
      else if (((SharedPreferences)localObject).getInt(ces, -1) > -1)
      {
        localEditor.putBoolean(cex, true);
        localEditor.commit();
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("RedBagVideoManager", 1, "checkRedBagEntranceConfig, ", paramJSONObject);
    }
  }
  
  private void d(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData == null) {
      return;
    }
    if (paramAIOShortVideoData.redBagStat == 0)
    {
      this.d = paramAIOShortVideoData;
      new anjo.a().execute(new String[] { paramAIOShortVideoData.shortVideoId });
    }
    for (;;)
    {
      this.DG.setVisibility(0);
      return;
      if (!this.cHx) {
        dQX();
      }
    }
  }
  
  private void dQM()
  {
    if ((this.c == null) || (this.Zv == null)) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = this.Zv.getText().toString().trim();
        if (!acfp.m(2131713777).trim().equals(localObject)) {
          break;
        }
        if (this.c.isSend == 0) {
          aaqi.ec("", "0X8008CEE");
        }
        while (this.mContext != null)
        {
          localObject = new Intent(this.mContext, QQBrowserActivity.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://mqq.tenpay.com/mqq/hongbao/video.html?fid=");
          localStringBuilder.append(this.c.shortVideoId);
          localStringBuilder.append("&_wv=2098179&_wvNb=e62555&_wvNt=FFFFFF&_wvSb=1");
          ((Intent)localObject).putExtra("url", localStringBuilder.toString());
          this.mContext.startActivity((Intent)localObject);
          return;
          aaqi.ec("", "0X8008CEF");
        }
      }
    } while (!acfp.m(2131713775).trim().equals(localObject));
    aaqi.ec("", "0X80088E6");
    dQS();
    dQN();
  }
  
  private void dQO()
  {
    if (this.DH == null) {
      return;
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("host_lights");
    if (localCustomFrameAnimationDrawable != null)
    {
      this.DH.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.DH.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      this.DH.setVisibility(0);
      localCustomFrameAnimationDrawable.start();
      return;
    }
    dQY();
  }
  
  private void dQP()
  {
    if ((this.Zv != null) && (this.mContext != null))
    {
      this.Zv.setText(acfp.m(2131713774));
      this.Zv.setBackgroundResource(0);
      this.Zv.setTextColor(this.mContext.getResources().getColorStateList(2131167265));
      this.Zv.setTextSize(14.0F);
      this.Zv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850748, 0);
      this.Zv.setCompoundDrawablePadding(5);
      this.Zv.setVisibility(0);
      this.Zv.bringToFront();
      ObjectAnimator.ofFloat(this.Zv, "alpha", new float[] { 0.0F, 1.0F }).setDuration(180L).start();
    }
  }
  
  private void dQQ()
  {
    if ((this.Zv != null) && (this.mContext != null))
    {
      this.Zv.setText(acfp.m(2131713778));
      this.Zv.setBackgroundResource(0);
      this.Zv.setTextColor(Color.parseColor("#FFF68987"));
      this.Zv.setTextSize(14.0F);
      this.Zv.setVisibility(0);
      this.Zv.bringToFront();
      ObjectAnimator.ofFloat(this.Zv, "alpha", new float[] { 0.0F, 1.0F }).setDuration(180L).start();
    }
  }
  
  private void dQR()
  {
    this.cHv = true;
    if (this.DG == null) {
      return;
    }
    if (this.DI != null)
    {
      this.DI.setBackgroundResource(2130850747);
      this.DI.getBackground().setAlpha(255);
      this.DI.setVisibility(0);
      ObjectAnimator.ofFloat(this.DI.getBackground(), "alpha", new float[] { 0.53F, 1.0F }).setDuration(180L).start();
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_chuchang");
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.cdJ();
      this.DG.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.DG.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.start();
      localCustomFrameAnimationDrawable.a(new anjv(this));
      if (this.mHandler == null) {
        this.mHandler = new Handler();
      }
      this.mHandler.postDelayed(new RedBagVideoManager.9(this), 880L);
    }
    for (;;)
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler();
      }
      this.mHandler.postDelayed(new RedBagVideoManager.10(this), 1120L);
      this.DG.setVisibility(0);
      return;
      this.DG.setImageResource(2130850751);
      dQT();
      dQY();
    }
  }
  
  private void dQS()
  {
    this.cHv = true;
    this.DG.setImageResource(2130850751);
    dQT();
    dQV();
  }
  
  private void dQT()
  {
    if ((this.Zv == null) || (this.mContext == null)) {
      return;
    }
    this.Zv.setText(acfp.m(2131713776));
    this.Zv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.Zv.setTextColor(this.mContext.getResources().getColorStateList(2131167266));
    this.Zv.setTextSize(16.0F);
    this.Zv.setPadding(wja.dp2px(12.0F, this.mContext.getResources()), wja.dp2px(5.0F, this.mContext.getResources()), wja.dp2px(12.0F, this.mContext.getResources()), wja.dp2px(5.0F, this.mContext.getResources()));
    this.Zv.setBackgroundResource(2130850752);
    this.Zv.bringToFront();
    this.Zv.setVisibility(0);
    ObjectAnimator.ofFloat(this.Zv, "alpha", new float[] { 0.0F, 1.0F }).setDuration(180L).start();
  }
  
  private void dQU()
  {
    if (this.DG == null) {
      return;
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_changzhu");
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.cdJ();
      this.DG.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.DG.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.start();
      this.i = 0;
      localCustomFrameAnimationDrawable.a(new anjq(this, localCustomFrameAnimationDrawable));
      return;
    }
    this.DG.setImageResource(2130850751);
    dQY();
  }
  
  private void dQV()
  {
    if (this.DH == null) {
      return;
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_lights");
    if (localCustomFrameAnimationDrawable != null)
    {
      this.DH.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.DH.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      this.DH.setVisibility(0);
      localCustomFrameAnimationDrawable.start();
      return;
    }
    dQY();
  }
  
  private void dQX()
  {
    if (this.DG == null) {
      return;
    }
    if (this.DI != null)
    {
      this.DI.setBackgroundResource(2130850747);
      this.DI.getBackground().setAlpha(255);
      this.DI.setVisibility(0);
    }
    this.cHx = true;
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_yidashang");
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.cdJ();
      localCustomFrameAnimationDrawable.cdG();
      this.DG.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.DG.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.start();
    }
    for (;;)
    {
      this.DG.setVisibility(0);
      dQQ();
      return;
      this.DG.setImageResource(2130850755);
      dQY();
    }
  }
  
  public static void dQY()
  {
    try
    {
      if (!bXy) {
        aqmj.M(BaseApplication.getContext(), true);
      }
      return;
    }
    finally {}
  }
  
  public static void dS(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), anjw.class);
    localNewIntent.putExtra("action", 1);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private static String dU(String paramString)
  {
    try
    {
      str1 = alab.getFileMD5String(paramString);
      paramString = str1;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str1;
      paramString = new File(paramString);
      bool = paramString.exists();
      if (!bool) {
        break label81;
      }
      for (;;)
      {
        try
        {
          paramString = aszr.getFileMD5String(paramString);
          if (paramString == null) {
            continue;
          }
        }
        catch (IOException paramString)
        {
          paramString = null;
          continue;
        }
        str2 = paramString;
        if (paramString != null) {
          break;
        }
        return "";
        paramString = "";
      }
    }
    finally
    {
      if (0 != 0) {
        break label79;
      }
      return "";
      label79:
      return null;
    }
    return str1;
    for (;;)
    {
      boolean bool;
      String str2;
      label81:
      paramString = null;
    }
  }
  
  private void e(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData == null) {
      return;
    }
    this.cHw = true;
    if (this.DI != null)
    {
      this.DI.setBackgroundResource(2130850747);
      this.DI.getBackground().setAlpha(255);
      this.DI.setVisibility(0);
    }
    if (paramAIOShortVideoData.redBagStat == 0)
    {
      if (this.DG != null)
      {
        this.DG.setImageResource(2130850756);
        this.DG.setVisibility(0);
      }
      if (this.DH != null) {
        this.DH.setVisibility(4);
      }
      dQP();
      return;
    }
    if (this.DG != null)
    {
      paramAIOShortVideoData = a("host_shang");
      if (paramAIOShortVideoData == null) {
        break label207;
      }
      paramAIOShortVideoData.cdJ();
      paramAIOShortVideoData.cdG();
      this.DG.setImageDrawable(paramAIOShortVideoData);
      if (a(paramAIOShortVideoData) != null) {
        this.DG.setLayoutParams(a(paramAIOShortVideoData));
      }
      paramAIOShortVideoData.start();
    }
    for (;;)
    {
      this.DG.setVisibility(0);
      if (this.mHandler == null) {
        this.mHandler = new Handler();
      }
      this.mHandler.postDelayed(new RedBagVideoManager.7(this), 120L);
      break;
      label207:
      this.DG.setImageResource(2130850757);
      dQY();
    }
  }
  
  private void hideAllViews()
  {
    if (this.Zv != null) {
      this.Zv.setVisibility(4);
    }
    if (this.DI != null) {
      this.DI.setVisibility(4);
    }
    if (this.DG != null) {
      this.DG.setVisibility(4);
    }
    if (this.DH != null) {
      this.DH.setVisibility(4);
    }
  }
  
  private static boolean j(String paramString, QQAppInterface paramQQAppInterface)
  {
    File localFile = new File(ceq);
    if (localFile.exists())
    {
      if (!localFile.isDirectory()) {
        localFile.delete();
      }
    }
    else {
      return false;
    }
    if (aqmj.ca(paramQQAppInterface.getApp()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkLocalResFiles : isResDamaged !");
      }
      aqhq.delete(ceq, false);
      return false;
    }
    if ((localFile.listFiles() == null) || (localFile.listFiles().length == 0))
    {
      aqhq.delete(ceq, false);
      return false;
    }
    paramQQAppInterface = new File(ceq + "videoRedbagResInfo");
    if ((paramQQAppInterface.exists()) && (!paramQQAppInterface.isDirectory()))
    {
      try
      {
        paramQQAppInterface = aqhq.readFileToString(paramQQAppInterface);
        if ((QLog.isColorLevel()) && (paramString != null) && (paramQQAppInterface != null)) {
          QLog.d("RedBagVideoManager", 2, "checkLocalResFiles: md5Record = " + paramQQAppInterface + ", md5 = " + paramString);
        }
        if ((paramQQAppInterface == null) || (paramString == null) || (paramQQAppInterface.length() == 0) || (paramString.length() == 0) || (!paramString.equals(paramQQAppInterface)))
        {
          aqhq.delete(ceq, false);
          return false;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        aqhq.delete(ceq, false);
        return false;
      }
      return true;
    }
    aqhq.delete(ceq, false);
    return false;
  }
  
  public static boolean lC(int paramInt)
  {
    return (paramInt == 10000) || (paramInt == 10007) || (paramInt == 10003) || (paramInt == 10004);
  }
  
  public static boolean pl(String paramString)
  {
    if (!axB()) {
      QLog.d("RedBagVideoManager", 1, "checkRedBagEntranceConfig, not support");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return true;
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      localSharedPreferences = ((AppRuntime)localObject).getApplication().getSharedPreferences(cer, 4);
    } while (localSharedPreferences.contains(cex));
    Object localObject = ((AppRuntime)localObject).getAccount();
    int j = localSharedPreferences.getInt(ces, -1);
    if (localSharedPreferences.getInt(ces + (String)localObject, -1) != j)
    {
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putBoolean(cet + (String)localObject, false);
      localEditor.putBoolean(ceu + (String)localObject, false);
      localEditor.putBoolean(cev + (String)localObject, false);
      localEditor.putBoolean(cew + (String)localObject, false);
      localEditor.putInt(ces + (String)localObject, j);
      localEditor.commit();
    }
    return localSharedPreferences.getBoolean(paramString + (String)localObject, true);
  }
  
  private static void sv(String paramString)
  {
    String str = ceq;
    try
    {
      aqhq.W(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RedBagVideoManager", 2, "[unzip]", paramString);
    }
  }
  
  public void C(AppInterface paramAppInterface)
  {
    if (this.mBroadcastReceiver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 4, "onDestroy");
      }
      paramAppInterface.getApp().unregisterReceiver(this.mBroadcastReceiver);
    }
  }
  
  public void Va(int paramInt)
  {
    if (paramInt == -1)
    {
      this.cHy = true;
      aaqi.ec("", "0X80088E7");
      if (this.Zv != null) {
        this.Zv.setVisibility(4);
      }
      if (this.DH != null) {
        this.DH.setVisibility(4);
      }
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_send");
      if ((localCustomFrameAnimationDrawable == null) || (this.DG == null)) {
        break label131;
      }
      localCustomFrameAnimationDrawable.cdJ();
      this.DG.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.DG.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.start();
      localCustomFrameAnimationDrawable.a(new anjr(this));
    }
    for (;;)
    {
      ThreadManager.post(new RedBagVideoManager.13(this), 5, null, true);
      return;
      label131:
      if (this.DG != null) {
        this.DG.setImageResource(2130850755);
      }
      this.cHy = false;
      dQY();
    }
  }
  
  public ImageView a(Activity paramActivity, ViewGroup paramViewGroup, String paramString)
  {
    this.mContext = paramActivity;
    this.aWf = paramString;
    this.W = new HandlerThread("RedBagVideoManager");
    this.W.start();
    this.M = new MqqHandler(this.W.getLooper());
    paramString = new ImageView(paramActivity);
    paramString.setId(2131374894);
    Object localObject = new RelativeLayout.LayoutParams(-1, wja.dp2px(180.0F, paramActivity.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramViewGroup.addView(paramString, (ViewGroup.LayoutParams)localObject);
    this.DI = paramString;
    paramString = new ImageView(paramActivity);
    paramString.setId(2131374897);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    paramViewGroup.addView(paramString, (ViewGroup.LayoutParams)localObject);
    this.DG = paramString;
    paramString.setOnTouchListener(new anjt(this));
    localObject = new ImageView(paramActivity);
    ((ImageView)localObject).setId(2131374896);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    paramViewGroup.addView((View)localObject, localLayoutParams);
    this.DH = ((ImageView)localObject);
    localObject = new TextView(paramActivity);
    ((TextView)localObject).setId(2131374895);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    localLayoutParams.bottomMargin = wja.dp2px(10.0F, paramActivity.getResources());
    paramViewGroup.addView((View)localObject, localLayoutParams);
    this.Zv = ((TextView)localObject);
    ((TextView)localObject).bringToFront();
    this.Zv.setOnClickListener(new anju(this));
    hideAllViews();
    return paramString;
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    String str1 = ((AppRuntime)localObject).getAccount();
    String str2 = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(str1);
    if (str2 == null)
    {
      QLog.e("RedBagVideoManager", 1, "gotoRedbag, skey is null");
      return;
    }
    int j;
    if (paramInt == 1) {
      j = 3;
    }
    for (;;)
    {
      localObject = new JSONObject();
      for (;;)
      {
        try
        {
          ((JSONObject)localObject).put("skey", str2);
          ((JSONObject)localObject).put("skey_type", 2);
          if ((paramInt != 1) && (paramInt != 3000)) {
            continue;
          }
          ((JSONObject)localObject).put("recv_uin", paramString5);
          ((JSONObject)localObject).put("grab_uin_list", paramString1);
          ((JSONObject)localObject).put("recv_name", paramString2);
          ((JSONObject)localObject).put("bus_type", 1);
          ((JSONObject)localObject).put("channel", 32768);
          ((JSONObject)localObject).put("feedsid", paramString4);
          ((JSONObject)localObject).put("recv_type", j);
          ((JSONObject)localObject).put("hb_from", "video_reward");
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          continue;
          j = 1;
        }
        paramString1 = new Intent(paramActivity, SendHbActivity.class);
        paramString1.putExtra("userId", str1);
        if (paramString3 != null) {
          paramString1.putExtra("userName", paramString3);
        }
        paramString1.putExtra("app_info", "appid#0|bargainor_id#0|channel#spredpacket");
        paramString1.putExtra("come_from", 2);
        paramString1.putExtra("extra_data", ((JSONObject)localObject).toString());
        paramString1.setFlags(536870912);
        paramActivity.startActivityForResult(paramString1, 10002);
        return;
        if (paramInt != 3000) {
          continue;
        }
        j = 2;
        break;
        ((JSONObject)localObject).put("recv_uin", paramString1);
      }
    }
  }
  
  public void aa(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      paramString2 = VideoRedbagData.queryRewardMsgUniseq(paramString2);
      if (!paramString2.isEmpty())
      {
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          long l = ((Long)paramString2.next()).longValue();
          MessageRecord localMessageRecord = ((QQAppInterface)localObject).b().b(paramString1, paramInt, l);
          if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
            if (localMessageForShortVideo.redBagStat == 0)
            {
              localMessageForShortVideo.redBagStat = 1;
              localMessageForShortVideo.serial();
              ((QQAppInterface)localObject).b().c(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
            }
          }
        }
      }
    }
  }
  
  public void c(AIOShortVideoData paramAIOShortVideoData)
  {
    if (this.Zv != null) {
      this.Zv.setText(null);
    }
    hideAllViews();
    if (paramAIOShortVideoData != null) {
      this.c = paramAIOShortVideoData;
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.cHv = false;
    this.cHw = false;
    this.cHx = false;
    this.cHy = false;
  }
  
  public void ce(Activity paramActivity)
  {
    if (axB())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedBagVideoManager", 2, "jumpToVideoPreview");
      }
      Bundle localBundle = awrp.a(null, paramActivity.getClass().getName(), 10004, 8);
      rnq.a().a(paramActivity, localBundle, 9010);
    }
  }
  
  public void d(AIORichMediaData paramAIORichMediaData)
  {
    if ((this.DG == null) || (paramAIORichMediaData == null)) {}
    do
    {
      do
      {
        return;
        if (!(paramAIORichMediaData instanceof AIOShortVideoData)) {
          break label73;
        }
        paramAIORichMediaData = (AIOShortVideoData)paramAIORichMediaData;
        if (paramAIORichMediaData.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
          break label73;
        }
        if (paramAIORichMediaData.isSend != 0) {
          break;
        }
      } while ((paramAIORichMediaData.redBagStat == 0) || (this.cHx));
      dQX();
      return;
    } while (this.cHw);
    e(paramAIORichMediaData);
    return;
    label73:
    hideAllViews();
  }
  
  public void dQN()
  {
    ThreadManager.post(new RedBagVideoManager.5(this), 5, null, true);
  }
  
  public void dQW()
  {
    hideAllViews();
    try
    {
      if (this.M != null) {
        this.M.removeCallbacksAndMessages(null);
      }
      if (this.W != null) {
        this.W.quit();
      }
      if (this.mHandler != null) {
        this.mHandler.removeCallbacksAndMessages(null);
      }
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    this.W = null;
    this.M = null;
    this.mContext = null;
    this.aWf = null;
    this.d = null;
    this.mHandler = null;
    this.DG = null;
    this.Zv = null;
    this.DH = null;
    this.DI = null;
    this.cHw = false;
    this.cHv = false;
    this.cHx = false;
    this.cHy = false;
  }
  
  public void e(AIORichMediaData paramAIORichMediaData)
  {
    if ((this.DG == null) || (paramAIORichMediaData == null)) {}
    while (this.cHy) {
      return;
    }
    if ((paramAIORichMediaData instanceof AIOShortVideoData))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramAIORichMediaData;
      if (localAIOShortVideoData.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        if (localAIOShortVideoData.isSend > 0) {
          e(localAIOShortVideoData);
        }
        for (;;)
        {
          if (this.mHandler == null) {
            this.mHandler = new Handler();
          }
          this.mHandler.postDelayed(new RedBagVideoManager.6(this, paramAIORichMediaData), localAIOShortVideoData.bqB * 1000);
          return;
          d(localAIOShortVideoData);
        }
      }
    }
    hideAllViews();
  }
  
  public void onDestroy() {}
  
  class a
    extends AsyncTask<String, Integer, Boolean>
  {
    a() {}
    
    protected Boolean doInBackground(String... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      if (paramVarArgs == null) {
        paramVarArgs = Boolean.valueOf(false);
      }
      Object localObject;
      do
      {
        do
        {
          return paramVarArgs;
          localObject = new Bundle();
          ((Bundle)localObject).putString("VALUE_MSG_VIDEO_ID", paramVarArgs);
          paramVarArgs = anjx.a().b("CMD_QUERY_VIDEO_REDBAG_STAT", (Bundle)localObject);
          if (paramVarArgs == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RedBagVideoManager", 2, "QueryRewardedTask VideoPlayIPCClient.callServer value=null");
            }
            return Boolean.valueOf(false);
          }
          localObject = Boolean.valueOf(paramVarArgs.getBoolean("VALUE_MSG_REDBAG_STAT"));
          paramVarArgs = (String[])localObject;
        } while (!((Boolean)localObject).booleanValue());
        paramVarArgs = (String[])localObject;
      } while (anjo.b(anjo.this) == null);
      anjo.b(anjo.this).redBagStat = 1;
      return localObject;
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      if (paramBoolean.booleanValue()) {
        anjo.c(anjo.this);
      }
      while (anjo.a(anjo.this)) {
        return;
      }
      anjo.d(anjo.this);
    }
  }
  
  class b
    extends AsyncTask<String, Integer, Boolean>
  {
    b() {}
    
    protected Boolean doInBackground(String... paramVarArgs)
    {
      if (anjo.a(anjo.this) != null)
      {
        anjo.a(anjo.this).redBagStat = 1;
        long l = anjo.a(anjo.this).uniseq;
        paramVarArgs = anjo.a(anjo.this).friendUin;
        int i = anjo.a(anjo.this).istroop;
        Bundle localBundle = new Bundle();
        localBundle.putLong("VALUE_MSG_UINSEQ", l);
        localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
        localBundle.putInt("VALUE_MSG_ISTROOP", i);
        localBundle.putString("VALUE_MSG_VIDEO_ID", anjo.a(anjo.this).shortVideoId);
        anjx.a().b("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
      }
      return Boolean.valueOf(true);
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      anjo.this.e(anjo.a(anjo.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjo
 * JD-Core Version:    0.7.0.1
 */