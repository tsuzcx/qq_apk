import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption.7;
import com.tencent.mobileqq.forward.ForwardBaseOption.8;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ahgq
  implements ahgg, ahgg.a, ahhg, DialogInterface.OnDismissListener
{
  public static String bKy = "key_thumb_style_centerinside";
  static int cZR;
  static SimpleDateFormat y;
  DialogInterface.OnClickListener L;
  DialogInterface.OnClickListener M;
  DialogInterface.OnClickListener N;
  protected arhz a;
  protected String aNa;
  protected boolean aWf;
  public QQAppInterface app;
  public long appid;
  protected swh b;
  protected String bKu;
  protected String bKv;
  String bKw;
  String bKx;
  public Bundle bf;
  acdv c;
  protected arhz c;
  protected int cZS = 11;
  protected int cZT;
  public boolean cgO;
  protected boolean cgP;
  public boolean cgQ;
  boolean cgR = false;
  protected boolean cgS = false;
  protected boolean cgT;
  protected Set<Integer> cs;
  private swe d;
  public aqju e;
  View.OnClickListener fh;
  public boolean isSdkShare;
  public Activity mActivity;
  public Context mAppContext;
  float mDensity;
  protected Intent mIntent;
  private ArrayList<ResultRecord> wR;
  private ArrayList<ResultRecord> wS;
  private ArrayList<ResultRecord> wT;
  
  public ahgq(Intent paramIntent)
  {
    this.jdField_c_of_type_Acdv = new ahgt(this);
    this.mIntent = paramIntent;
    if (paramIntent.getExtras() != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = new Bundle())
    {
      this.bf = paramIntent;
      this.mAppContext = BaseApplicationImpl.getApplication().getApplicationContext();
      this.cgP = false;
      return;
    }
  }
  
  public static boolean B(Bundle paramBundle)
  {
    int i = paramBundle.getInt("forward_source_uin_type", -1);
    return (i == 1004) || (i == 1000);
  }
  
  private int EV()
  {
    if (anp()) {
      return 2;
    }
    return 0;
  }
  
  @Deprecated
  public static void P(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent, ForwardRecentActivity.class, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2, paramString);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, paramString);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt)
  {
    a(paramActivity, paramIntent, paramClass, paramInt, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    paramIntent.putExtra("forward_source_business_type", paramInt2);
    paramIntent.putExtra("forward_source_sub_business_type", paramString);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramIntent, ForwardRecentActivity.class, paramInt1, paramInt2);
  }
  
  private static void a(Activity paramActivity, String paramString, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    paramIntent.setClass(paramActivity, paramClass);
    if (TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    }
    for (;;)
    {
      paramIntent.putExtra("forward_source_business_type", paramInt2);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.putExtra("caller_name", paramString);
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, Intent paramIntent, Class<?> paramClass)
  {
    a(paramContext, paramIntent, paramClass, -1, "");
  }
  
  private static void a(Context paramContext, Intent paramIntent, Class<?> paramClass, int paramInt, String paramString)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, paramClass);
      paramIntent.putExtra("forward_source_business_type", paramInt);
      paramIntent.putExtra("forward_source_sub_business_type", paramString);
      paramContext.startActivity(paramIntent);
    }
  }
  
  private void a(Bundle paramBundle, int paramInt, String paramString)
  {
    long l = paramBundle.getLong("req_share_id", 0L);
    boolean bool;
    if (l == 0L)
    {
      paramBundle = paramBundle.getString("forward_ark_app_meta");
      if (TextUtils.isEmpty(paramBundle)) {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend arkAppId is empty");
        }
      }
      label88:
      do
      {
        return;
        try
        {
          paramBundle = new JSONObject(paramBundle).optJSONObject("news");
          if (paramBundle == null) {
            break;
          }
          paramBundle = paramBundle.optString("appid");
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            paramBundle.printStackTrace();
            paramBundle = null;
          }
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          break label207;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend ,isForwardC2cOrGroup = " + bool);
        }
      } while ((!"101492711".equals(paramBundle)) || (!bool));
      if (paramInt != 1) {
        break label213;
      }
    }
    label207:
    label213:
    for (String str = "c2c_AIO";; str = "Grp_AIO")
    {
      anot.a(null, "dc00899", str, "", "video_tab", "videoark_share", 0, 0, paramString, paramBundle, "", "");
      return;
      paramBundle = l + "";
      break;
      bool = false;
      break label88;
    }
  }
  
  private void a(aqku paramaqku)
  {
    if (paramaqku == null) {}
    String str2;
    int i;
    boolean bool;
    String str1;
    do
    {
      return;
      localObject = ff();
      if (localObject != null) {
        break;
      }
      str2 = this.bf.getString("uin");
      i = this.bf.getInt("uintype", 0);
      bool = this.bf.getBoolean("new_create_troop", false);
      str1 = wo();
    } while ((!jR(i)) || (TextUtils.isEmpty(str1)));
    String str3 = acfp.m(2131706445);
    Object localObject = str1;
    if (str1.startsWith(str3)) {
      localObject = str1.substring(str3.length());
    }
    localObject = ((String)localObject).trim();
    paramaqku.a(this.app, this.mActivity, str2, i, (String)localObject, bool);
    return;
    if (((List)localObject).size() == 1)
    {
      localObject = (ResultRecord)((List)localObject).get(0);
      paramaqku.a(this.app, this.mActivity, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).lk(), ((ResultRecord)localObject).name, false);
      return;
    }
    paramaqku.a(this.app, this.mActivity, (List)localObject, true);
  }
  
  private void a(MessageForPic paramMessageForPic, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startToAioImagePreview: uniseq=");
      if (paramMessageForPic == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = Long.valueOf(paramMessageForPic.uniseq);; localObject = "")
    {
      QLog.d("ForwardOption.ForwardBaseOption", 2, localObject);
      if (paramMessageForPic != null)
      {
        paramString = new AIOImageProviderService(this.app.getCurrentUin(), paramString, 0, paramMessageForPic);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
        a((Bundle)localObject, paramString, xtm.a(paramMessageForPic));
        dnZ();
      }
      return;
    }
  }
  
  private Drawable aJ()
  {
    if ((this.bKx != null) && (aoiz.hasFile(this.bKx))) {}
    for (Object localObject1 = this.bKx; localObject1 != null; localObject1 = this.bKw)
    {
      Object localObject2 = k((String)localObject1, "file:");
      Object localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (((File)localObject2).exists())
        {
          localObject3 = ((File)localObject2).getAbsolutePath();
          this.bf.putString("EditImagePath", (String)localObject3);
          localObject2 = aomz.a((String)localObject3, ankt.dip2px(100.0F), ankt.dip2px(300.0F));
          if (localObject2 != null) {
            localObject1 = ((URL)localObject2).toString();
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localObject3;
          }
          localObject3 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardBaseOption", 2, "getURLDrawable updateImageView  fixedUrlString=" + (String)localObject2);
            localObject3 = localObject2;
          }
        }
      }
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject3);
        return localObject1;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label207;
        }
        QLog.d("ForwardOption.ForwardBaseOption", 2, "getURLDrawable fixedUrlString url is illegal = " + localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardBaseOption", 2, "getURLDrawable isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
    }
    return null;
    label207:
    return null;
  }
  
  private boolean anp()
  {
    int i = this.bf.getInt("uintype", 0);
    int j = this.bf.getInt("key_forward_ability_type");
    if (jR(i)) {}
    while ((j == W.intValue()) || (j == ab.intValue()) || (i == 1024) || (i == 1025)) {
      return true;
    }
    return false;
  }
  
  private void c(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startToAioImagePreview: msgId=");
      if (paramAIORichMediaData == null) {
        break label99;
      }
    }
    label99:
    for (Object localObject = Long.valueOf(paramAIORichMediaData.id);; localObject = "")
    {
      QLog.d("ForwardOption.ForwardBaseOption", 2, localObject);
      if (paramAIORichMediaData != null)
      {
        paramString = new AIOImageProviderService(this.app.getCurrentUin(), paramString, 0, null);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
        a((Bundle)localObject, paramString, paramAIORichMediaData);
        dnZ();
      }
      return;
    }
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    boolean bool;
    String str;
    if ((paramInt == 1) || (paramInt == 2))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend ,isAudioReqType = " + paramBoolean1 + ",isMusicArkView = " + paramBoolean2 + ",isForwardC2cOrGroup = " + bool);
      }
      if (((paramBoolean1) || (paramBoolean2)) && (bool))
      {
        if (paramInt != 1) {
          break label133;
        }
        str = "c2c_AIO";
        label90:
        if (paramInt != 1) {
          break label141;
        }
        paramString = "";
      }
    }
    label133:
    label141:
    for (;;)
    {
      anot.a(null, "dc00899", str, "", "music_tab", "musicark_share", 0, 0, paramString, "", "", "");
      return;
      bool = false;
      break;
      str = "Grp_AIO";
      break label90;
    }
  }
  
  private void dnC()
  {
    int i = this.bf.getInt("req_type");
    Object localObject1;
    if ((this.bf.getBoolean("is_ark_display_share", false)) && (i != 5))
    {
      this.e = aqha.a(this.mActivity, wo(), this.bf, this.mActivity.getResources().getInteger(2131427345));
      localObject1 = this.bf.getString("shareArkInfo");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("app");
      String str = ((JSONObject)localObject2).optString("view");
      localObject2 = ((JSONObject)localObject2).optString("meta");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        adqu.a(this.app, (String)localObject1, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, str, "");
      }
      label162:
      this.e.setMessage("");
      this.e.setNegativeButton(2131721058, c());
      this.e.setPositiveButton(2131691441, b());
      this.e.show();
      boolean bool;
      do
      {
        return;
        this.e = aqha.a(this.mActivity, wo(), wn(), null, b(), c(), this.mActivity.getResources().getInteger(2131427345));
        i = this.bf.getInt("key_forward_ability_type");
        bool = this.mIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
      } while ((i != V.intValue()) || (!bool));
      localObject1 = (aqkk)this.e;
      ((aqkk)localObject1).eed();
      ((aqkk)localObject1).getEditText().setHint(acfp.m(2131706439));
      return;
    }
    catch (JSONException localJSONException)
    {
      break label162;
    }
  }
  
  private void dnD()
  {
    dnF();
    if ((this.bf.getBoolean("is_ark_display_share")) && (this.bf.getBoolean("forward_ark_from_h5_parse_meta_success")))
    {
      this.e = aqha.a(this.mActivity, wo(), this.bf, this.mActivity.getResources().getInteger(2131427345));
      this.e.setMessage("");
      this.e.setNegativeButton(2131721058, c());
      this.e.setPositiveButton(2131691441, b());
      this.e.show();
      return;
    }
    this.e = aqha.a(this.mActivity, wo(), wn(), null, b(), c());
  }
  
  private void dnE()
  {
    int i = this.bf.getInt("forward_type");
    if ((i == 27) || (i == 39))
    {
      this.e = aqha.a(this.mActivity, wo(), this.bf, this.mActivity.getResources().getInteger(2131427345));
      this.e.setMessage("");
      this.e.setNegativeButton(2131721058, c());
      this.e.setPositiveButton(2131691441, b());
      this.e.show();
      return;
    }
    this.e = aqha.a(this.mActivity, wo(), wn(), wp(), ES(), ET(), b(), c());
  }
  
  private void dnG()
  {
    int i = this.bf.getInt("key_forward_ability_type");
    if ((i == X.intValue()) || (i == aa.intValue()) || (i == ad.intValue()) || (i == V.intValue())) {
      this.bf.putBoolean("is_ark_display_share", false);
    }
  }
  
  private void dnH()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardBaseOption", 2, " qbShowShareResultDialog error mActivity = null");
      }
      return;
    }
    if (this.d == null) {
      this.d = new swe(this.mActivity);
    }
    Object localObject2 = this.app.getApplication().getString(2131720024);
    String str = this.bf.getString("app_name");
    Object localObject1 = localObject2;
    if (str != null) {
      localObject1 = (String)localObject2 + str;
    }
    localObject2 = new ahgr(this);
    this.d.c((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    this.d.a((DialogInterface.OnClickListener)localObject2);
    this.d.show();
  }
  
  private void dnI()
  {
    int i = -1;
    if (anq())
    {
      localObject = ff().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        eM(localResultRecord.uin, localResultRecord.lk());
      }
    }
    if (this.bf != null) {}
    for (Object localObject = this.bf.getString("uin");; localObject = "")
    {
      if (this.bf != null) {
        i = this.bf.getInt("uintype", -1);
      }
      eM((String)localObject, i);
      return;
    }
  }
  
  private void dnJ()
  {
    Bundle localBundle = new Bundle();
    if (anq())
    {
      Iterator localIterator = ff().iterator();
      while (localIterator.hasNext())
      {
        localBundle.putLong("key_receiver_type", ((ResultRecord)localIterator.next()).lk());
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
      }
    }
    if (this.bf != null) {}
    for (long l = this.bf.getInt("uintype", -1);; l = -1L)
    {
      localBundle.putLong("key_receiver_type", l);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", localBundle, null);
      return;
    }
  }
  
  private void dnR()
  {
    ahio localahio = new ahio(this.mActivity);
    this.e = localahio;
    if (!anp()) {}
    for (boolean bool = true;; bool = false)
    {
      localahio.Kr(bool);
      localahio.Pf(210);
      localahio.addContentView(cc());
      localahio.setCanceledOnTouchOutside(false);
      localahio.a(wo(), wp(), this.mActivity.getResources().getString(ES()), this.mActivity.getResources().getString(ET()), b(), c());
      a(localahio);
      if (!this.mActivity.isFinishing()) {
        localahio.show();
      }
      this.e.setOnDismissListener(this);
      return;
    }
  }
  
  private void dny()
  {
    if (cZR <= 0)
    {
      Display localDisplay = ((WindowManager)this.mAppContext.getSystemService("window")).getDefaultDisplay();
      int i = this.mAppContext.getResources().getDimensionPixelSize(2131297812);
      int j = this.mAppContext.getResources().getDimensionPixelSize(2131297814);
      cZR = (localDisplay.getWidth() - i * 2 - j * 3) / 4;
    }
  }
  
  private void eM(String paramString, int paramInt)
  {
    if ((this.mIntent != null) && (("ChatActivity".equals(this.mIntent.getStringExtra("caller_name"))) || ("SplashActivity".equals(this.mIntent.getStringExtra("caller_name"))))) {
      xkl.a(this.app, paramInt, this.mIntent.getStringExtra("forward_photo_sender_uin"), this.mIntent.getStringExtra("forward_photo_md5"), "0X8009F55", paramString);
    }
    while ((this.mIntent == null) || (!"PublicTransFragmentActivity".equals(this.mIntent.getStringExtra("caller_name")))) {
      return;
    }
    xkl.a(this.app, paramInt, this.mIntent.getStringExtra("forward_photo_sender_uin"), this.mIntent.getStringExtra("forward_photo_md5"), "0X8009F56", paramString);
  }
  
  @Deprecated
  public static void f(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, ForwardRecentActivity.class, paramInt, -1, "");
  }
  
  private void fY(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "startToAioImagePreviewWithPath: path=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      AIOImageData localAIOImageData = new AIOImageData();
      localAIOImageData.aVW = paramString1;
      localAIOImageData.aVX = paramString1;
      localAIOImageData.aVY = paramString1;
      localAIOImageData.bjd = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      a(paramString1, new AIOImageProviderService(this.app.getCurrentUin(), paramString2, 0, null), localAIOImageData);
      dnZ();
    }
  }
  
  private boolean jR(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0) || (paramInt == 1006) || (paramInt == 3000) || (paramInt == 1000)) {}
    while (anq()) {
      return true;
    }
    return false;
  }
  
  private File k(String paramString1, String paramString2)
  {
    if (paramString1.toLowerCase(Locale.US).startsWith(paramString2)) {}
    for (;;)
    {
      try
      {
        if (!paramString1.substring(0, paramString2.length()).equalsIgnoreCase(paramString2)) {
          break label111;
        }
        paramString1 = new File(paramString1.substring(paramString2.length()));
        boolean bool1 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean bool2 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if ((bool1) || (bool2)) {
          paramString1 = new File(this.bKw);
        }
        return paramString1;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        paramString1 = null;
        continue;
      }
      paramString1 = aoiz.getFile(aoiz.on(paramString1));
      continue;
      label111:
      paramString1 = null;
    }
  }
  
  private Drawable o(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    String str = "";
    if (paramString == null) {
      localObject1 = localObject3;
    }
    URL localURL;
    do
    {
      do
      {
        return localObject1;
        localURL = aomz.a(paramString, ankt.dip2px(100.0F), ankt.dip2px(300.0F));
        localObject1 = localObject3;
      } while (localURL == null);
      localObject1 = localObject3;
    } while (!aoiz.hasFile(localURL.toString()));
    Object localObject1 = str;
    if (localURL != null) {
      localObject1 = localURL.toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = paramString;
    }
    for (;;)
    {
      paramString = localObject2;
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        paramString = (String)localObject1;
        aoop.a((URLDrawable)localObject1, null, false);
        return localObject1;
      }
      catch (Exception localException)
      {
        localObject1 = paramString;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ForwardOption.ForwardBaseOption", 2, "getNormalDrawable urlString url is illegal = " + localException);
      return paramString;
    }
  }
  
  private void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  public static int x(Bundle paramBundle)
  {
    int m = paramBundle.getInt("forward_source_business_type", -1);
    int j = -11;
    int i = m;
    int k;
    if (m == -1)
    {
      k = paramBundle.getInt("forward_source_uin_type", -1);
      if (k != 0) {
        break label84;
      }
      i = 100101;
      j = k;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "getForwardSrcBusinessType, srcBusinessType = " + i + ",sourceUinType = " + j);
      }
      return i;
      label84:
      if (k == 1)
      {
        i = 100100;
        j = k;
      }
      else
      {
        j = k;
        i = m;
        if (k == 3000)
        {
          i = 100300;
          j = k;
        }
      }
    }
  }
  
  public float B(float paramFloat)
  {
    Display localDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int i = this.mActivity.getResources().getDimensionPixelSize(2131297117);
    float f1 = paramFloat;
    if (i > f2 * paramFloat)
    {
      f2 = i / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public Set<Integer> E()
  {
    if (this.cs == null)
    {
      this.cs = new HashSet();
      dnr();
    }
    return this.cs;
  }
  
  public int ES()
  {
    return 2131721058;
  }
  
  public int ET()
  {
    return 2131691441;
  }
  
  protected int EU()
  {
    return this.bf.getInt("emoInputType", EV());
  }
  
  protected int EW()
  {
    return -1;
  }
  
  public int EX()
  {
    return x(this.bf);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (!ano()) {
      return;
    }
    if (paramInt >= 0) {
      this.bf.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null)
    {
      this.cgT = paramBundle.getBoolean("from_outside_share", false);
      this.aWf = paramBundle.getBoolean("from_dataline_aio", false);
      this.aNa = paramBundle.getString("caller_name", "");
      this.bf.putAll(paramBundle);
    }
    this.wR = this.bf.getParcelableArrayList("forward_multi_target");
    this.wS = new ArrayList();
    this.wT = new ArrayList();
    if (this.wR != null)
    {
      paramBundle = this.wR.iterator();
      while (paramBundle.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramBundle.next();
        if ((localResultRecord.uinType != 6000) && (localResultRecord.uinType != 6003)) {
          this.wS.add(localResultRecord);
        } else {
          this.wT.add(localResultRecord);
        }
      }
    }
    dnB();
  }
  
  public void JZ(String paramString)
  {
    if (this.bf != null) {
      this.bf.remove(paramString);
    }
  }
  
  protected void Ka(String paramString) {}
  
  protected void Kb(String paramString)
  {
    Object localObject1 = (syw)this.app.getBusinessHandler(51);
    Object localObject2 = ((syw)localObject1).a(Long.parseLong(paramString));
    ((syw)localObject1).a(this.mActivity, (DeviceInfo)localObject2, false);
    if (this.mIntent.getBooleanExtra("sendMultiple", false)) {
      localObject1 = this.mIntent.getStringExtra("forward_filepath");
    }
    for (;;)
    {
      localObject2 = (RouterHandler)this.app.getBusinessHandler(48);
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(new FileInfo((String)localObject1));
        label93:
        ((RouterHandler)localObject2).a(localArrayList, null, null, Long.parseLong(paramString));
        return;
        localObject1 = this.mIntent.getStringExtra("forward_filepath");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label93;
      }
    }
  }
  
  public void Kc(String paramString)
  {
    if (!this.mIntent.getBooleanExtra("key_forward_share", false)) {}
    String str;
    int i;
    do
    {
      return;
      str = this.mIntent.getStringExtra("key_forward_share_title");
      i = this.mIntent.getIntExtra("key_forward_image_share_uin_type", 0);
      anot.a(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 0, paramString, ForwardUtils.cy(i), str, "");
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "图文或者音乐转发=0X800A631, type=", paramString, ", title=", str, ", uinType=", ForwardUtils.cy(i) });
  }
  
  public void Kp(boolean paramBoolean) {}
  
  public void Pa(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine--type = " + paramInt);
    }
    boolean bool1 = this.mIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if ((bool1) || (bool2) || (bool3))
    {
      if ((bool2) || (bool3))
      {
        this.bf.remove("PhotoConst.SEND_FLAG");
        this.mIntent.removeExtra("PhotoConst.SEND_FLAG");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->forwardToDataLine jumpAIO ");
      }
      Pb(paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    String str = acbn.bkw;
    if (paramInt == ab.intValue()) {
      str = acbn.bkx;
    }
    for (;;)
    {
      localBundle.putAll(this.bf);
      Intent localIntent = new Intent();
      ahha localahha = new ahha(this);
      acde localacde = (acde)this.app.getBusinessHandler(8);
      if (this.mIntent.getBooleanExtra("sendMultiple", false))
      {
        dt(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localacde.a().a(str, localBundle, localahha);
        a(localBundle, str, null);
        label259:
        if ((anq()) || (paramInt != 0)) {
          break label361;
        }
        ci.k(this.mActivity, paramInt);
        this.mIntent.putExtra("NOCANCEL4DATALIN", true);
        if (EX() != 100200) {
          break label363;
        }
        this.mActivity.setResult(-1, this.mIntent);
      }
      for (;;)
      {
        this.mActivity.finish();
        return;
        du(localIntent);
        localBundle.putAll(localIntent.getExtras());
        paramInt = localacde.a().b(str, localBundle, localahha);
        a(localBundle, str, null);
        break label259;
        label361:
        break;
        label363:
        this.mActivity.setResult(0, this.mIntent);
      }
    }
  }
  
  protected void Pb(int paramInt)
  {
    Intent localIntent = new Intent(this.mActivity, LiteActivity.class);
    if (paramInt == ab.intValue())
    {
      localIntent.putExtra("targetUin", acbn.bkx);
      localIntent.putExtra("device_type", 1);
      if (this.mIntent.getBooleanExtra("isFromShare", false))
      {
        this.bf.putString("leftBackText", acfp.m(2131706437));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.bf.putBoolean("isBack2Root", true);
      }
      localIntent.putExtras(this.bf);
      localIntent.putExtra("MigSdkShareNotDone", false);
      if (!this.mIntent.getBooleanExtra("sendMultiple", false)) {
        break label207;
      }
      dt(localIntent);
    }
    for (;;)
    {
      this.mActivity.startActivity(localIntent);
      this.bf.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.bf);
      this.mActivity.setResult(0, localIntent);
      this.mActivity.finish();
      return;
      localIntent.putExtra("targetUin", acbn.bkw);
      localIntent.putExtra("device_type", 0);
      break;
      label207:
      du(localIntent);
    }
  }
  
  protected void Pc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--code = " + paramInt);
    }
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    hideProgressDialog();
    ahgs localahgs = new ahgs(this);
    if (this.b == null) {
      this.b = new swh(this.mActivity);
    }
    for (;;)
    {
      String str = this.mActivity.getString(2131691039);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.bf.getString("app_name"))) {
        localObject = str + this.bf.getString("app_name");
      }
      this.b.c((String)localObject, localahgs);
      this.b.yT(2131693313);
      localObject = this.b;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        ((swh)localObject).setResult(bool);
        this.b.yT(2131720178);
        this.b.yU(0);
        this.b.yV(2131720179);
        this.b.d(this.mActivity.getString(2131696652), localahgs);
      }
      try
      {
        this.b.show();
        return;
        this.b.dismiss();
        continue;
        bool = false;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->showQfavResultDialog--resultDlg.show() failed");
      }
    }
  }
  
  int Y(String paramString, int paramInt)
  {
    if (acbn.bkw.equals(paramString)) {
      paramInt = 4;
    }
    do
    {
      return paramInt;
      if ("-1010".equals(paramString)) {
        return 6;
      }
      switch (paramInt)
      {
      default: 
        return 100;
      case 0: 
        paramInt = 1;
      }
    } while (!this.app.getCurrentAccountUin().equals(paramString));
    return 5;
    return 2;
    return 3;
    return 7;
  }
  
  protected View.OnClickListener a(ahgq.a parama)
  {
    String str = this.bf.getString("uin");
    if (this.fh == null) {
      this.fh = new ahgx(this, str, parama);
    }
    return this.fh;
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    a(paramDrawable, paramBoolean, paramInt, false);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.mActivity.runOnUiThread(new ForwardBaseOption.7(this, paramDrawable, paramBoolean1, paramInt, paramBoolean2));
  }
  
  protected void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    avfp.a(this.mActivity, paramBundle, paramAIOImageProviderService, paramAIORichMediaData, 19001, 4);
  }
  
  protected void a(Bundle paramBundle, String paramString, ci.a parama)
  {
    acde localacde = (acde)this.app.getBusinessHandler(8);
    paramBundle = "";
    if ((this.e instanceof aqkk)) {
      paramBundle = ((aqkk)this.e).getInputValue();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramBundle))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardBaseOption", 2, "sendDataLineMessage: invoked.  textAndEmoji: " + paramBundle);
        }
        du(new Intent());
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("sendMultiple", false);
        localBundle.putInt("dataline_forward_type", 102);
        localBundle.putString("dataline_forward_text", paramBundle);
        int i = localacde.a().b(paramString, localBundle, parama);
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardBaseOption", 2, "sendDataLineMessage: invoked.  noteRet: " + i);
        }
      }
      return;
      if ((this.e instanceof ahio)) {
        paramBundle = ((ahio)this.e).getInputValue();
      }
    }
  }
  
  protected boolean a(aqju paramaqju)
  {
    return true;
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    boolean bool = true;
    if (paramLightAppSettingInfo == null) {}
    do
    {
      return false;
      paramLightAppSettingInfo = paramLightAppSettingInfo.oA;
    } while ((paramLightAppSettingInfo == null) || (this.bf == null));
    switch (this.bf.getInt("req_type"))
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
        break;
      }
      continue;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        break;
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    return null;
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    boolean bool = anA();
    ArrayList localArrayList = new ArrayList();
    RecentUser localRecentUser;
    if ((bool) && (this.cZT == 2))
    {
      localRecentUser = new RecentUser(acbn.bkw, 6000);
      localRecentUser.displayName = acfp.m(2131696154);
      localArrayList.add(localRecentUser);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localRecentUser = (RecentUser)paramList.next();
      if ((bool) && (this.cZT == 1) && (localRecentUser != null) && (TextUtils.equals(localRecentUser.uin, acbn.bkw))) {
        localArrayList.add(localRecentUser);
      } else if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 1032) && (localRecentUser.getType() != 1033) && (localRecentUser.getType() != 1034) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))) {
        localArrayList.add(localRecentUser);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardBaseOption", 2, "getForwardRecentList result size is: " + localArrayList.size());
    }
    return localArrayList;
  }
  
  protected boolean aa(Intent paramIntent)
  {
    boolean bool2 = this.bf.getBoolean("isFromFavorites");
    boolean bool1 = bool2;
    if (!bool2)
    {
      String str = this.bf.getString("app_name");
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(this.mActivity.getString(2131693429))) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      this.bf.putBoolean("isBack2Root", true);
      this.bf.putString("leftBackText", this.mActivity.getString(2131720735));
      paramIntent.putExtras(this.bf);
    }
    bool2 = this.bf.getBoolean("isFromAIOPlus");
    return (bool1) && (bool2);
  }
  
  public void am(int paramInt)
  {
    if (this.a == null) {
      this.a = new arhz(this.mActivity, this.mAppContext.getResources().getDimensionPixelSize(2131299627));
    }
    this.a.setMessage(paramInt);
    if (!this.mActivity.isFinishing()) {
      this.a.show();
    }
  }
  
  public boolean anA()
  {
    if (this.mIntent == null) {}
    int i;
    do
    {
      return false;
      i = this.mIntent.getIntExtra("key_req", -1);
    } while ((i != ForwardRecentActivity.bGS) && (i != ForwardRecentActivity.bGT));
    return true;
  }
  
  public boolean anj()
  {
    this.bKv = this.mIntent.getStringExtra("forward_thumb");
    this.cgO = this.mIntent.getBooleanExtra("forward_urldrawable", false);
    this.bKw = this.mIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.bKx = this.mIntent.getStringExtra("forward_urldrawable_big_url");
    this.bKu = this.mIntent.getStringExtra("forward_text");
    this.cgS = this.mIntent.getBooleanExtra("forward_from_jump", false);
    this.cZT = this.mIntent.getIntExtra("key_share_data_line_support_type", 0);
    if (this.bf != null)
    {
      if (this.bf.getInt("forward_type", -1) == 11) {
        this.isSdkShare = true;
      }
      this.appid = this.bf.getLong("req_share_id", 0L);
    }
    dny();
    return true;
  }
  
  protected boolean anl()
  {
    if (anq()) {
      return be(false);
    }
    return be(true);
  }
  
  public boolean ann()
  {
    return false;
  }
  
  protected boolean ano()
  {
    if ((this.e != null) && (this.e.isShowing())) {
      return false;
    }
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    hideProgressDialog();
    return true;
  }
  
  protected boolean anq()
  {
    List localList = ff();
    return (localList != null) && (!localList.isEmpty());
  }
  
  protected boolean anr()
  {
    return true;
  }
  
  protected boolean ans()
  {
    return false;
  }
  
  public boolean ant()
  {
    return true;
  }
  
  protected boolean anu()
  {
    ajdo localajdo = (ajdo)this.app.getManager(11);
    if ((localajdo != null) && (localajdo.Ur())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowPhoneContactAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  protected boolean anv()
  {
    Object localObject = (acdu)this.app.getManager(53);
    if (localObject != null)
    {
      localObject = ((acdu)localObject).getDiscussList();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowDiscussAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  protected boolean anw()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).cE();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowTroopAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  protected boolean anx()
  {
    Object localObject = (acff)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((acff)localObject).cr();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((Groups)((Iterator)localObject).next()).group_friend_count <= 0);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowFriendAbility--allow = " + bool);
      }
      return bool;
    }
  }
  
  protected boolean any()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowQZoneAbility--allow = false");
    }
    return false;
  }
  
  protected boolean anz()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = this.mIntent.getBooleanExtra("sendMultiple", false);
    int i;
    if (ajlc.a().getCheckedItemCount() > 1)
    {
      i = 1;
      int j = this.bf.getInt("from_busi_type");
      if ((!bool3) && (i == 0) && (j != 2)) {
        break label85;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = false");
        bool2 = bool1;
      }
    }
    label85:
    do
    {
      return bool2;
      i = 0;
      break;
      Object localObject = (syw)this.app.getBusinessHandler(51);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((syw)localObject).Nz())
        {
          localObject = ((syw)localObject).b();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (localObject.length > 0) {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "-->allowSmartDeviceAbility--allow = " + bool1);
    return bool1;
  }
  
  protected final DialogInterface.OnClickListener b()
  {
    if (this.L == null) {
      this.L = new ahgu(this);
    }
    return this.L;
  }
  
  public void b(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      aoop.a((URLDrawable)paramDrawable, this.app.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {}
    while (paramBoolean) {
      return;
    }
    paramDrawable.setBounds(aqhu.a(paramDrawable, 36, 100, this.mDensity));
  }
  
  public void b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.app = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.mDensity = this.mActivity.getResources().getDisplayMetrics().density;
  }
  
  protected final void b(String paramString, aqju paramaqju)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "addSourceNameView start! sourceName =" + paramString);
    }
    if ((paramString == null) || ("".equals(paramString)) || (paramaqju == null)) {
      return;
    }
    TextView localTextView = new TextView(this.mActivity);
    localTextView.setText(paramString);
    localTextView.setTextSize(12.0F);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setIncludeFontPadding(false);
    localTextView.setTextColor(-8355712);
    paramaqju.addView(localTextView);
  }
  
  public void b(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.cgQ = true;
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", 1);
    localBundle.putBoolean("new_create_troop", true);
    localBundle.putString("uinname", acfp.m(2131706444) + paramString2);
    H(ahgg.a.U.intValue(), localBundle);
  }
  
  protected boolean be(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.bf);
    this.mActivity.setResult(-1, localIntent);
    if (paramBoolean) {
      this.mActivity.finish();
    }
    return false;
  }
  
  protected final DialogInterface.OnClickListener c()
  {
    if (this.M == null) {
      this.M = new ahgv(this);
    }
    return this.M;
  }
  
  protected final void c(String paramString, aqju paramaqju)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView: filepath=" + paramString);
    }
    ThreadManager.post(new ForwardBaseOption.8(this, paramString, paramaqju), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView end! ");
    }
  }
  
  protected View cc()
  {
    return null;
  }
  
  public void ccu()
  {
    anot.a(this.app, "dc00898", "", "", "0X8009BEA", "0X8009BEA", this.cZS, 0, "", "", "", "");
    dnY();
  }
  
  public void cph()
  {
    if ((this.bf != null) && (this.bf.getBoolean("k_forward_show_direct_share_tips", false))) {
      anot.a(this.app, "dc00898", "", "", "0X800A220", "0X800A220", 0, 0, "0", "", "", "");
    }
    dnX();
  }
  
  protected final DialogInterface.OnClickListener d()
  {
    if (this.N == null) {
      this.N = new ahgw(this);
    }
    return this.N;
  }
  
  public void d(aqju paramaqju) {}
  
  protected void dnA()
  {
    if (this.mIntent.getBooleanExtra("k_favorites", true)) {
      this.cs.add(X);
    }
  }
  
  @TargetApi(11)
  public final void dnB()
  {
    if (ans())
    {
      dnR();
      return;
    }
    dnG();
    int i = EU();
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->buildConfirmDialog--editTextType = " + i);
    }
    if (i == 0) {
      dnE();
    }
    for (;;)
    {
      if ((this.e instanceof aqku)) {
        a((aqku)this.e);
      }
      Object localObject1 = wp();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.e.setEditLint((String)localObject1);
      }
      if (this.bf.getBoolean("miniAppNeedOnlyPreview", false))
      {
        ((aqjn)this.e).UN(wo());
        ((aqjn)this.e).eeb();
      }
      this.e.setOnDismissListener(this);
      this.e.adjustTitle();
      dns();
      this.e.setMsgMaxLineWithEnd(this.bKu, 3);
      if (a(this.e)) {
        c(this.bKv, this.e);
      }
      if (this.bf.getInt(bKy, 0) == 1) {
        this.e.setPreviewImageScaleType(true);
      }
      if (this.mActivity.isFinishing()) {
        break;
      }
      this.e.show();
      return;
      if (i == 1)
      {
        dnD();
      }
      else if (i == 2)
      {
        dnC();
      }
      else if (i == 3)
      {
        this.e = aqha.a(this.mActivity, wo(), wn(), null, b(), c(), this.mActivity.getResources().getInteger(2131427345), false);
      }
      else
      {
        Object localObject2;
        if (i == 4)
        {
          localObject1 = this.bf.getString("choose_friend_content");
          localObject2 = this.bf.getString("choose_friend_subcontent");
          ArrayList localArrayList = this.bf.getStringArrayList("choose_friend_feedbacks");
          this.e = aqha.a(this.mActivity, wo(), (String)localObject1, (String)localObject2, localArrayList, null, b(), c(), this.mActivity.getResources().getInteger(2131427345), false);
        }
        else if (i == 5)
        {
          i = this.bf.getInt("key_hiboom_id");
          this.e = aqha.a(this.mActivity, wo(), "", null, b(), c(), this.mActivity.getResources().getInteger(2131427345), false);
          localObject1 = new HiBoomTextView(this.mActivity);
          ((HiBoomTextView)localObject1).setHiBoom(i, 0, ahxs.b);
          ((HiBoomTextView)localObject1).setText(this.bKu);
          ((HiBoomTextView)localObject1).setMaxSize(ahxs.dbR);
          localObject2 = new LinearLayout.LayoutParams(500, 500);
          ((LinearLayout.LayoutParams)localObject2).gravity = 17;
          this.e.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
        }
        else
        {
          this.e = aqha.a(this.mActivity, wo(), wn(), null, b(), c(), this.mActivity.getResources().getInteger(2131427345), false);
        }
      }
    }
  }
  
  public void dnF()
  {
    boolean bool = true;
    String str = this.bf.getString("forward_ark_app_meta");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        new JSONObject(str);
        this.bf.putBoolean("forward_ark_from_h5_parse_meta_success", bool);
        return;
      }
      catch (Exception localException)
      {
        ArkAppCenter.r("ForwardOption.ForwardBaseOption", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { localException.getMessage() }));
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  protected void dnK() {}
  
  protected void dnL() {}
  
  public void dnM()
  {
    dnv();
  }
  
  protected void dnN()
  {
    int i = 1;
    String str1 = this.bf.getString("uin");
    String str2 = this.bf.getString("troop_uin");
    int j = this.bf.getInt("uintype");
    if (h(str1, str2, j)) {
      if (j != 0) {
        break label82;
      }
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8009AAE", "0X8009AAE", i, 0, "", "", "", "");
      return;
      label82:
      if (j == 1) {
        i = 2;
      } else if (j == 3000) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  protected void dnO()
  {
    this.cgQ = false;
    if (this.bf.getBoolean("miniAppNeedOnlyPreview", false)) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_direct_share_fail", null, null);
    }
  }
  
  public void dnP() {}
  
  protected void dnQ()
  {
    this.e.setImageOnClickListener(a(new ahgz(this)));
  }
  
  public void dnS()
  {
    int i = EW();
    if (this.mActivity.isFinishing()) {
      return;
    }
    Pc(i);
  }
  
  protected void dnT()
  {
    this.bf.putBoolean("isBack2Root", true);
    if (this.bf.getInt("uintype") == 6002) {
      Kb(this.bf.getString("uin"));
    }
    while (anl()) {
      return;
    }
    anot.a(this.app, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
  }
  
  protected void dnU() {}
  
  protected void dnV() {}
  
  public void dnW()
  {
    int i = EX();
    String str = this.bf.getString("forward_source_sub_business_type", "");
    int j = hR(this.bf.getInt("forward_type", 2147483647));
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "reportShowForwardRecent srcBusinessType = " + i + ",srcSubBusinessType = " + str);
    }
    anot.a(this.app, "dc00898", "", "", "0X800A7EB", "0X800A7EB", i, 0, "", "", String.valueOf(j), str);
  }
  
  public void dnX()
  {
    if (y == null) {
      y = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int i = EX();
    String str1 = this.bf.getString("forward_source_sub_business_type", "");
    String str2 = y.format(Long.valueOf(System.currentTimeMillis()));
    int k = this.bf.getInt("forward_type", 2147483647);
    int j = hR(k);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets srcBusinessType = " + i + ",srcSubBusinessType = " + str1 + ",forwardType = " + k + ",forwardMsgType = " + j + ",operateTime = " + str2);
    }
    Object localObject;
    if ((this.wR != null) && (this.wR.size() > 0)) {
      localObject = this.wR.iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str3 = localResultRecord.uin;
      k = localResultRecord.uinType;
      int m = Y(str3, k);
      anot.a(this.app, "dc00898", "", str3, "0X800A7EC", "0X800A7EC", i, 0, str2, String.valueOf(m), String.valueOf(j), str1);
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets multi,,targetUin = " + str3 + ",targetUinType = " + k + ",forwardTargetType = " + m + ",srcSubBusinessType = " + str1);
        continue;
        k = this.bf.getInt("uintype");
        localObject = this.bf.getString("uin");
        m = Y((String)localObject, k);
        anot.a(this.app, "dc00898", "", (String)localObject, "0X800A7EC", "0X800A7EC", i, 0, str2, String.valueOf(m), String.valueOf(j), str1);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportFinalSelectedTargets single,,targetUin = " + (String)localObject + ",targetUinType = " + k + ",forwardTargetType = " + m + ",srcSubBusinessType = " + str1);
        }
      }
    }
  }
  
  public void dnY()
  {
    if (y == null) {
      y = new SimpleDateFormat("yyyyMMddHHmmss");
    }
    int j = EX();
    String str2 = this.bf.getString("forward_source_sub_business_type", "");
    String str1 = "";
    Object localObject2 = y.format(Long.valueOf(System.currentTimeMillis()));
    int i = this.bf.getInt("forward_type", 2147483647);
    int k = hR(i);
    Object localObject1 = "";
    if ((this.e instanceof aqkk))
    {
      localObject1 = ((aqkk)this.e).getInputValue();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label658;
      }
    }
    label644:
    label658:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend srcBusinessType = " + j + ",srcSubBusinessType = " + str2 + ",forwardType = " + i + ",forwardMsgType = " + k + ",hasLeftAMessage = " + bool + ",operateTime = " + (String)localObject2);
      }
      label230:
      int m;
      if ((this.wR != null) && (this.wR.size() > 0))
      {
        localObject2 = this.wR.iterator();
        i = -1;
        localObject1 = str1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ResultRecord)((Iterator)localObject2).next();
          str1 = ((ResultRecord)localObject1).uin;
          m = ((ResultRecord)localObject1).uinType;
          i = Y(str1, m);
          QQAppInterface localQQAppInterface = this.app;
          if (bool) {}
          for (localObject1 = "1";; localObject1 = "2")
          {
            anot.a(localQQAppInterface, "dc00898", "", str1, "0X800A7ED", "0X800A7ED", j, 0, (String)localObject1, String.valueOf(i), String.valueOf(k), str2);
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend multi,,targetUin = " + str1 + ",targetUinType = " + m + ",forwardTargetType = " + i + ",srcSubBusinessType = " + str2);
            }
            localObject1 = str1;
            break label230;
            if (!(this.e instanceof ahio)) {
              break;
            }
            localObject1 = ((ahio)this.e).getInputValue();
            break;
          }
        }
      }
      else
      {
        this.bf.getInt("forward_source_uin_type");
        m = this.bf.getInt("uintype");
        str1 = this.bf.getString("uin");
        i = Y(str1, m);
        localObject2 = this.app;
        if (!bool) {
          break label644;
        }
        localObject1 = "1";
        anot.a((QQAppInterface)localObject2, "dc00898", "", str1, "0X800A7ED", "0X800A7ED", j, 0, (String)localObject1, String.valueOf(i), String.valueOf(k), str2);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "reportClickSend single,,targetUin = " + str1 + ",targetUinType = " + m + ",forwardTargetType = " + i + ",srcSubBusinessType = " + str2);
        }
        localObject1 = str1;
      }
      if (2 == this.bf.getInt("req_type")) {}
      for (bool = true;; bool = false)
      {
        c(bool, "music".equals(this.bf.getString("forward_ark_app_view")), i, (String)localObject1);
        a(this.bf, i, (String)localObject1);
        return;
        localObject1 = "2";
        break;
      }
    }
  }
  
  public void dnZ()
  {
    anot.a(this.app, "dc00898", "", "", "0X8009BE9", "0X8009BE9", this.cZS, 0, "", "", "", "");
  }
  
  protected void dnr()
  {
    if (anx()) {
      this.cs.add(S);
    }
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anu()) {
      this.cs.add(Y);
    }
    if (any()) {
      this.cs.add(V);
    }
    this.cs.add(Z);
  }
  
  protected void dns()
  {
    if (TextUtils.isEmpty(this.bKu)) {
      return;
    }
    this.e.setMessageWithEmo(this.bKu, this.mDensity);
  }
  
  public void dnt()
  {
    anot.a(this.app, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
  }
  
  protected void dnv()
  {
    int i = 0;
    if (anq())
    {
      List localList = fg();
      if ((localList != null) && (!localList.isEmpty()))
      {
        int j = localList.size();
        while (i < j)
        {
          ResultRecord localResultRecord = (ResultRecord)localList.get(i);
          if (anr()) {
            h(localResultRecord.uin, localResultRecord.QD, localResultRecord.lk());
          }
          i += 1;
        }
        this.bf.putBoolean("isBack2Root", true);
        anl();
      }
      return;
    }
    ccu();
    if (this.cgQ)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.cgQ = false;
    }
    if (anr()) {
      dnN();
    }
    dnT();
  }
  
  public void dnx() {}
  
  public void dnz()
  {
    this.cs = new HashSet();
    dnr();
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_forward_base_option_bundle");
    if (paramBundle != null) {
      H(paramBundle.getInt("key_forward_ability_type", ahgg.a.R.intValue()), paramBundle);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if ((this.e != null) && (this.e.isShowing())) {
      paramBundle.putBundle("key_forward_base_option_bundle", this.bf);
    }
  }
  
  public void doa()
  {
    if (!this.mIntent.getBooleanExtra("key_forward_image_share", false)) {}
    String str;
    do
    {
      do
      {
        return;
        str = this.mIntent.getStringExtra("key_forward_image_share_appid");
      } while (TextUtils.isEmpty(str));
      int i = this.mIntent.getIntExtra("key_forward_image_share_uin_type", 0);
      anot.a(null, "dc00898", "", "", "0X800A27", "0X800A27", 0, 0, "", ForwardUtils.cx(this.bf.getInt("uintype")), str, ForwardUtils.cy(i));
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "大图转发=0X800A27, appid" + str);
  }
  
  protected void dt(Intent paramIntent) {}
  
  protected void du(Intent paramIntent) {}
  
  public boolean e(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt2 == W.intValue()) || (paramInt2 == ab.intValue())) {}
    boolean bool1;
    do
    {
      do
      {
        return false;
      } while ((this.isSdkShare) || ((this instanceof ahle)) || ((this instanceof ahhc)) || (this.bf.getInt("cmshow_game_id") > 0));
      bool1 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
      bool2 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    } while ((bool1) || (bool2));
    if (paramInt1 == 1) {
      if (((apsw)this.app.getManager(48)).a(paramString, true).cSk)
      {
        bool1 = false;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if ((this instanceof ahhq))
          {
            paramString = (ahhq)this;
            bool2 = bool1;
            if (paramString.b != null)
            {
              bool2 = bool1;
              if (paramString.b.getType() != 10006) {}
            }
          }
        }
      }
    }
    for (boolean bool2 = false;; bool2 = true)
    {
      return bool2;
      bool1 = true;
      break;
    }
  }
  
  public boolean e(Integer paramInteger)
  {
    if (ahgg.a.V.equals(paramInteger)) {}
    while ((this.cs == null) || (!this.cs.contains(paramInteger))) {
      return false;
    }
    return true;
  }
  
  protected List<ResultRecord> ff()
  {
    return this.wR;
  }
  
  protected List<ResultRecord> fg()
  {
    return this.wS;
  }
  
  public Bundle getExtras()
  {
    return this.bf;
  }
  
  public String getTitle()
  {
    String str2 = this.mIntent.getStringExtra("k_forward_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131706447);
    }
    return str1;
  }
  
  protected boolean h(String paramString1, String paramString2, int paramInt)
  {
    String str = "";
    int i;
    Object localObject;
    if ((this.e instanceof aqkk))
    {
      str = ((aqkk)this.e).getInputValue();
      if (TextUtils.isEmpty(str)) {
        break label271;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardBaseOption", 2, "sendMessageOnConfirm: invoked.  textAndEmoji: " + str);
      }
      this.bf.putString("share_comment_message", str);
      i = wte.a().we();
      if (!anq()) {
        break label256;
      }
      int[] arrayOfInt = this.bf.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
      this.bf.remove("KEY_MSG_FORWARD_ID_ARRAY");
      if (arrayOfInt == null) {
        break label242;
      }
      localObject = new int[arrayOfInt.length + 1];
      if (arrayOfInt.length > 0) {
        System.arraycopy(arrayOfInt, 0, localObject, 0, arrayOfInt.length);
      }
      localObject[arrayOfInt.length] = i;
      label157:
      this.bf.putIntArray("KEY_MSG_FORWARD_ID_ARRAY", (int[])localObject);
    }
    for (;;)
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).cZ = paramInt;
      ((SessionInfo)localObject).aTl = paramString1;
      ((SessionInfo)localObject).troopUin = paramString2;
      if (!(this instanceof ahlr)) {
        wte.a().a((SessionInfo)localObject, str, i);
      }
      return true;
      if (!(this.e instanceof ahio)) {
        break;
      }
      str = ((ahio)this.e).getInputValue();
      break;
      label242:
      localObject = new int[1];
      localObject[0] = i;
      break label157;
      label256:
      this.bf.putInt("KEY_MSG_FORWARD_ID", i);
    }
    label271:
    return false;
  }
  
  int hR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 100;
    case -1: 
      return 1;
    case 1: 
      return 2;
    case 8: 
      return 3;
    case 21: 
      return 4;
    case 3: 
      return 5;
    case -5: 
      return 6;
    case 14: 
      return 7;
    case 20: 
    case 23: 
      return 8;
    case 24: 
      return 9;
    case -3: 
    case 1001: 
      return 10;
    }
    return 11;
  }
  
  public void hideProgressDialog()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public boolean kj(String paramString)
  {
    HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
    return (localHotChatManager != null) && (localHotChatManager.kj(paramString));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onDestroy()
  {
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    this.app.removeObserver(this.jdField_c_of_type_Acdv);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    int j = 0;
    int i;
    if ((!(this.mActivity instanceof DirectForwardActivity)) && ((this.mActivity.getIntent() == null) || (!this.mActivity.getIntent().getBooleanExtra("key_share_from_screen_need_finish", false))))
    {
      i = j;
      if (this.mActivity.getIntent() != null)
      {
        i = j;
        if (this.mActivity.getIntent().getIntExtra("key_req", -1) != ForwardRecentActivity.bGS) {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      this.mActivity.finish();
    }
    if ((this.e instanceof aqjn)) {
      QLog.d("ForwardOption.ForwardBaseOption", 1, "QQCustomArkDialog dismiss");
    }
  }
  
  public void onPause()
  {
    if ((this.e instanceof aqjn)) {
      ((aqjn)this.e).Xw(0);
    }
  }
  
  public void onResume()
  {
    if ((this.e instanceof aqjn)) {
      ((aqjn)this.e).Xw(1);
    }
    if ((this.jdField_c_of_type_Arhz != null) && (this.jdField_c_of_type_Arhz.isShowing())) {
      this.jdField_c_of_type_Arhz.dismiss();
    }
  }
  
  public String wn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DialogContent:mForwardText=" + this.bKu);
    }
    return this.bKu;
  }
  
  public String wo()
  {
    int i = this.bf.getInt("key_forward_ability_type");
    String str1;
    if (i == V.intValue()) {
      str1 = "QQ空间";
    }
    for (;;)
    {
      String str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        str2 = acfp.m(2131706443) + str1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "dialogTitle=" + str2);
      }
      return str2;
      if (i == W.intValue()) {
        str1 = acfp.m(2131696154);
      } else if (i == ab.intValue()) {
        str1 = "我的iPad";
      } else if (i == X.intValue()) {
        str1 = acfp.m(2131706438);
      } else if (i == ad.intValue()) {
        str1 = plr.asY;
      } else {
        str1 = this.bf.getString("uinname");
      }
    }
  }
  
  protected String wp()
  {
    int i = this.bf.getInt("uintype", 0);
    int j = this.bf.getInt("key_forward_ability_type");
    if (jR(i)) {
      return acfp.m(2131706441);
    }
    if ((j == W.intValue()) || (j == ab.intValue())) {
      return acfp.m(2131706446);
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void onDownloadFinish();
    
    public abstract void onDownloadStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahgq
 * JD-Core Version:    0.7.0.1
 */