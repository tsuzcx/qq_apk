package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bez;
import bfa;
import bfb;
import bfd;
import bff;
import bfh;
import bfl;
import bfm;
import bfn;
import bfp;
import bfq;
import bfr;
import bfs;
import bft;
import bfu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.plugin.IPluginManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingMe
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "QQSettingRedesign";
  private static final int jdField_b_of_type_Int = 1;
  static String jdField_b_of_type_JavaLangString = "http://m.qzone.com/l?g=755";
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private static final int e = 4;
  private static final int f = 5;
  protected long a;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bfm(this);
  protected View a;
  protected ViewGroup a;
  public ImageView a;
  protected TextView a;
  public BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new bff(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new bfd(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bfh(this);
  public QQAppInterface a;
  private VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new bfb(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new bfa(this);
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new bfl(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new bez(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  protected RedDotTextView a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  protected boolean a;
  protected View[] a;
  protected View b;
  public ImageView b;
  protected TextView b;
  public boolean b;
  protected View c;
  protected ImageView c;
  public TextView c;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private final String jdField_d_of_type_JavaLangString;
  
  public QQSettingMe(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.d = "http://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json";
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903548, null));
  }
  
  private Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramInt1);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramInt2);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramInt3);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject1, new Object[] { paramString });; paramString = (String)localObject1)
    {
      localObject1 = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624119);
      ((Dialog)localObject1).setContentView(2130903135);
      TextView localTextView = (TextView)((Dialog)localObject1).findViewById(2131296915);
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = (TextView)((Dialog)localObject1).findViewById(2131296470);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(paramString);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131296918);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131296919);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return localObject1;
    }
  }
  
  private String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364289);
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 8);
    return paramString.substring(0, 8);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localCalendar.setTimeInMillis(paramLong1);
    int m = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    return (i != m) || (j + 1 != n + 1) || (k != i1);
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInfo != null)
    {
      bool1 = bool2;
      if (paramAppInfo.iNewFlag != null)
      {
        bool1 = bool2;
        if (paramAppInfo.iNewFlag.get() != 0)
        {
          bool1 = bool2;
          if (paramAppInfo.type.has())
          {
            bool1 = bool2;
            if (paramAppInfo.type.get() == 3) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = "http://mc.vip.qq.com?platform=1&sid=" + paramString + "&_bid=138";; paramString = "http://mc.vip.qq.com?platform=1&_bid=138")
    {
      Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(String.valueOf(100400));
      paramString = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(paramString, (BusinessInfoCheckUpdate.AppInfo)localObject);
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362895));
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 256L, (Intent)localObject, false, -1);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).b(String.valueOf(100400));
      CustomWidgetUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131298477), 0, 0, 0);
      return;
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir(), "http://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json");
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(new DownloadTask("http://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json", localFile), this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    if (!this.jdField_c_of_type_Boolean) {
      f();
    }
    q();
    h();
    g();
    j();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((str != null) && (str.equals(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(Resources paramResources, ImageView paramImageView, String paramString)
  {
    try
    {
      Object localObject = paramResources.getDrawable(2130839061);
      localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject, false);
      if (localObject != null)
      {
        int i = (int)(paramResources.getDisplayMetrics().density * 35.0F);
        ((URLDrawable)localObject).setBounds(0, 0, i, i);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMe", 2, "red icon load fail, iconUrl=" + paramString);
      }
      paramImageView.setImageDrawable(paramResources.getDrawable(2130839061));
      paramImageView.setVisibility(0);
      localException.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      e();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onAccountChanged(paramQQAppInterface);
      h();
      q();
      t();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new bfn(this, paramString));
  }
  
  public void a(String paramString, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->updateLevelAndVip!");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    Object localObject4 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1;
    Object localObject3;
    boolean bool1;
    boolean bool2;
    int i;
    float f1;
    label228:
    int j;
    if (localObject4 == null)
    {
      localObject1 = null;
      localObject3 = new SpannableStringBuilder();
      bool1 = false;
      bool2 = false;
      i = 0;
      if (localObject1 != null)
      {
        bool1 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
        bool2 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
        i = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "updateOpenCenterInfo:level:" + i + " isVip:" + bool2 + " isSvip:" + bool1);
        }
        if (((bool1) || (bool2)) && (i > 0)) {
          ((SpannableStringBuilder)localObject3).append(QQSettingUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, (Resources)localObject2, bool1, bool2, i));
        }
      }
      if (QQSettingUtil.a <= 0)
      {
        localObject1 = ((Resources)localObject2).getDisplayMetrics();
        float f2 = ((Resources)localObject2).getDimension(2131492939);
        if (!bool1) {
          break label723;
        }
        f1 = ((DisplayMetrics)localObject1).density * 46.0F;
        float f3 = ((Resources)localObject2).getDimension(2131493080);
        float f4 = ((Resources)localObject2).getDimension(2131493075);
        float f5 = ((Resources)localObject2).getDimension(2131493077);
        float f6 = ((Resources)localObject2).getDimension(2131493070);
        float f7 = ((DisplayMetrics)localObject1).widthPixels;
        if (f2 > 1.0F) {
          break label1095;
        }
        f2 = 1.0F;
        QQSettingUtil.a = (int)((f7 - (f3 + f4 + f5 + f6) - f1) / f2);
        if (QLog.isDevelopLevel()) {
          QLog.i("QQSettingRedesign", 4, "MAX_LEVEL_ICON_SIZE = " + QQSettingUtil.a);
        }
      }
      if (localObject4 != null) {
        break label736;
      }
      paramString = null;
      label350:
      if (paramString != null) {
        break label748;
      }
      j = 0;
      label357:
      ((SpannableStringBuilder)localObject3).append(QQSettingUtil.a((Resources)localObject2, j));
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      paramString = new File(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir(), "http://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json");
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localObject2 = null;
      if (!paramString.exists()) {
        break label880;
      }
    }
    int k;
    label478:
    long l;
    try
    {
      paramString = FileUtils.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingRedesign", 2, "-->json:" + paramString);
      }
      localObject1 = new JSONArray(paramString);
      if (localObject1 == null) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        int m;
        localObject1 = null;
        paramString = null;
      }
    }
    catch (Exception localException1)
    {
      label515:
      label535:
      label565:
      paramString = null;
      localObject2 = localException1;
    }
    try
    {
      if (((JSONArray)localObject1).length() <= 0) {
        break label766;
      }
      k = 0;
      if (k >= ((JSONArray)localObject1).length()) {
        break label1090;
      }
      paramString = ((JSONArray)localObject1).getJSONObject(k);
      if (paramString == null) {
        break label757;
      }
      m = paramString.getInt("id");
      if (m != 1) {
        break label757;
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        String str;
        paramString = str;
      }
      paramString = null;
      break label515;
    }
    if (localObject3 != null)
    {
      l = ((SharedPreferences)localObject3).getLong("vip_center_last_update_time", -1L);
      localObject2 = paramString;
      localObject3 = localObject1;
      if (a(l, NetConnInfoCenter.getServerTimeMillis()))
      {
        s();
        localObject3 = localObject1;
        localObject2 = paramString;
      }
      paramString = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131298476);
      localObject4 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131298475);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364289);
      if (!bool1) {
        break label914;
      }
    }
    for (;;)
    {
      try
      {
        ((ImageView)localObject4).setImageResource(2130838952);
        if (localObject2 == null) {
          continue;
        }
        paramString.setText(a(((JSONObject)localObject2).getString("svip")));
      }
      catch (Exception localException2)
      {
        label646:
        label685:
        label723:
        label736:
        label748:
        label757:
        label766:
        paramString.setText(str);
        label880:
        continue;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setContentDescription(paramString.getText().toString());
      if (!bool1) {
        break label1066;
      }
      paramStringBuilder.append("你是尊贵的超级会员");
      if (j > 0) {
        paramStringBuilder.append(" 等级").append(j).append("级");
      }
      return;
      localObject1 = ((FriendManager)localObject4).c(paramString);
      break;
      f1 = ((DisplayMetrics)localObject1).density * 42.0F;
      break label228;
      paramString = ((FriendManager)localObject4).a(paramString);
      break label350;
      j = paramString.iQQLevel;
      break label357;
      k += 1;
      break label478;
      paramString = (String)localObject2;
      if (!QLog.isColorLevel()) {
        break label515;
      }
      QLog.e("QQSettingRedesign", 2, "-->vipInfo.length=" + ((JSONArray)localObject1).length());
      paramString = (String)localObject2;
      break label515;
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingRedesign", 2, "-->" + ((Exception)localObject2).toString());
      }
      str = paramString;
      paramString = null;
      break label515;
      l = -1L;
      break label535;
      s();
      localObject2 = null;
      localObject3 = null;
      break label565;
      paramString.setText(2131364291);
      continue;
      label914:
      if (!bool2) {
        break label961;
      }
      ((ImageView)localObject4).setImageResource(2130838933);
      if (localException2 != null) {
        paramString.setText(a(localException2.getString("vip")));
      } else {
        paramString.setText(2131364290);
      }
    }
    label961:
    ((ImageView)localObject4).setImageResource(2130838933);
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (localObject4 != null) {
      k = ((SharedPreferences)localObject4).getInt("key_selfvip_growthvalue", 0);
    }
    label1033:
    label1066:
    label1090:
    label1095:
    label1115:
    for (;;)
    {
      if (localException2 != null)
      {
        paramString.setText(a(localException2.getString("outdatedVip")));
        break label646;
      }
      paramString.setText(2131364292);
      break label646;
      if (localObject3 != null)
      {
        paramString.setText(a(localException2.getString("notVip")));
        break label646;
      }
      paramString.setText(2131364289);
      break label646;
      if (!bool2) {
        break label685;
      }
      paramStringBuilder.append("你是尊贵的会员");
      break label685;
      break;
      for (;;)
      {
        if (i > 0) {
          break label1115;
        }
        if (k <= 0) {
          break label1033;
        }
        break;
        k = 0;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.destroy();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      t();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.registerModeCallback(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.jdField_c_of_type_Boolean);
    }
    if (true == this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298458);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription("进入我的资料卡");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297589));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296532));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298459));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298461);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[5];
      int[] arrayOfInt = new int[5];
      int[] tmp211_209 = arrayOfInt;
      tmp211_209[0] = 2131364289;
      int[] tmp216_211 = tmp211_209;
      tmp216_211[1] = 2131364288;
      int[] tmp222_216 = tmp216_211;
      tmp222_216[2] = 2131364293;
      int[] tmp228_222 = tmp222_216;
      tmp228_222[3] = 2131364286;
      int[] tmp234_228 = tmp228_222;
      tmp234_228[4] = 2131364287;
      tmp234_228;
      int i = 0;
      while (i < 5)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i] = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(new int[] { 2131298470, 2131298472, 2131298474, 2131298473, 2131298471 }[i]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setFocusable(true);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setOnClickListener(this);
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i].findViewById(2131298475)).setImageResource(new int[] { 2130838933, 2130838950, 2130838953, 2130838954, 2130838955 }[i]);
        ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i].findViewById(2131298476)).setText(arrayOfInt[i]);
        ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i].findViewById(2131298477)).setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setContentDescription(((Resources)localObject).getString(arrayOfInt[i]));
        i += 1;
      }
      localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298464);
      ((View)localObject).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)((View)localObject).findViewById(2131298465));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298466);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297223));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298467));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131298478));
      e();
      h();
      q();
      g();
      j();
      p();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("QQSettingRedesign", 4, "init, cosume: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "initUpdateVipInfoReceiver:" + localException.toString());
          }
        }
      }
    }
  }
  
  public void g()
  {
    l();
    n();
    o();
    r();
    m();
  }
  
  public void h()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (TextUtils.isEmpty(str2))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    a(str2);
    String str3 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3.trim())) {}
    }
    else
    {
      str1 = str2;
    }
    if (!Utils.a(str1, this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = str1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    a(str2, this.jdField_a_of_type_JavaLangStringBuilder);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onPostThemeChanged();
    }
  }
  
  public void j()
  {
    String str = null;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i = this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.getNightModeStatus();
    Drawable localDrawable;
    if (i == 1)
    {
      localDrawable = localResources.getDrawable(2130838943);
      str = localResources.getString(2131364295);
    }
    for (;;)
    {
      if (localDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      if (str != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      if (i == 2)
      {
        localDrawable = localResources.getDrawable(2130838942);
        str = localResources.getString(2131364295);
      }
      else
      {
        localDrawable = null;
      }
    }
  }
  
  public void k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("&sid=");
    try
    {
      ((StringBuilder)localObject).append(URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), "UTF-8"));
      ((StringBuilder)localObject).append("&res_uin=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class).putExtra("url", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public void l()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label96;
        }
        bool1 = true;
        if (!bool1) {
          break label106;
        }
        if (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp)) {
          break label101;
        }
        bool1 = bool2;
      }
    }
    label96:
    label101:
    label106:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  protected void m()
  {
    try
    {
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("QQLite", 0).getBoolean("favorites_new_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("QQLite", 0).getBoolean("favorites_click_red_point_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo.path.set(String.valueOf(100016));
      localAppInfo.num.set(0);
      localAppInfo.type.set(0);
      if ((!bool1) && (!bool2)) {
        localAppInfo.iNewFlag.set(1);
      }
      QQSettingUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131298477), localAppInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void n()
  {
    for (;;)
    {
      TextView localTextView;
      try
      {
        Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(String.valueOf(100005));
        if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0)) {
          break label215;
        }
        i = 1;
        String str = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131298479);
        localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131298477);
        if ((str != null) && (i == 0))
        {
          localURLImageView.setImageDrawable(URLDrawable.getDrawable(str, new ColorDrawable(0), new ColorDrawable(0)));
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localTextView.setVisibility(8);
          localURLImageView.setVisibility(0);
          return;
        }
        localURLImageView.setVisibility(8);
        if (a((BusinessInfoCheckUpdate.AppInfo)localObject))
        {
          localObject = ((BusinessInfoCheckUpdate.AppInfo)localObject).icon_url.get();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_c_of_type_AndroidWidgetImageView, (String)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      QQSettingUtil.a(localTextView, localException, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label215:
      int i = 0;
    }
  }
  
  protected void o()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(String.valueOf(100400));
      QQSettingUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131298477), localAppInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    long l;
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        case 2131298459: 
        case 2131298460: 
        case 2131298462: 
        case 2131298463: 
        case 2131298465: 
        case 2131298467: 
        case 2131298468: 
        case 2131298469: 
        default: 
          return;
        case 2131298458: 
          paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          paramView.f = 1;
          paramView.g = 8;
          ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
          return;
        case 2131298472: 
          if (IPluginManager.a())
          {
            this.jdField_a_of_type_AndroidAppDialog = a(2131363265, 2131363266, 2131362790, 2131363447, (float)Math.round(21.014881134033203D) / 100.0F + "", new bfp(this), new bfq(this));
            this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new bfr(this));
            this.jdField_a_of_type_AndroidAppDialog.show();
            return;
          }
          QfavHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1);
          QfavReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("QQLite", 0);
          localObject = "favorites_click_red_point_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        }
      } while (paramView.getBoolean((String)localObject, false));
      paramView.edit().putBoolean((String)localObject, true).commit();
      return;
      k();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
      return;
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).b(String.valueOf(100005));
      CustomWidgetUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131298477), 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (1 == ClubContentJsonTask.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, IndividuationSetActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting_native", 0, 0, "", "", "", "");
        return;
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, VasWebviewConstants.PERSONALITY_QQ_INDIVIDUATION_URL, 1048576L, paramView, false, -1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting_web", 0, 0, "", "", "", "");
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
        ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
      return;
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_c_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.startNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if (!this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.isCurrentNightMode()) {}
      for (paramView = "切换夜间模式    切换按钮   打开";; paramView = "切换夜间模式    切换按钮    关闭 ")
      {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(paramView);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, EditActivity.class);
        paramView.putExtra("k_source", 0);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004036", "0X8004036", 0, 0, "", "", "", "");
      return;
      l = System.currentTimeMillis();
    } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l));
    this.jdField_a_of_type_Long = l;
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
    return;
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QfileFileAssistantActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
    paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    Object localObject = paramView.a(String.valueOf(100160));
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)) {
      paramView.b(String.valueOf(100160));
    }
    CustomWidgetUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131298477), 0, 0, 0);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateVipInfo");
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str1);
    ((VipInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(str2, str1);
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new bfs(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new bft(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new bfu(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    Object localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298462);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298463);
    StringBuilder localStringBuilder = new StringBuilder(100);
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a();
    if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.jdField_c_of_type_JavaLangString)))
    {
      ((ImageView)localObject).setBackgroundResource(2130838944);
      ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.b, 200));
      localStringBuilder.append(localRichStatus.jdField_c_of_type_JavaLangString);
      if (!TextUtils.isEmpty(localRichStatus.d)) {
        localStringBuilder.append(localRichStatus.d);
      }
      localStringBuilder.append(' ');
      if ((localRichStatus != null) && (localRichStatus.a != null))
      {
        if (localRichStatus.a.size() <= 0) {
          break label364;
        }
        localObject = (String)localRichStatus.a.get(0);
        label271:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localStringBuilder.append((String)localObject);
        }
      }
      localObject = localStringBuilder.toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label369;
      }
      localTextView.setText("编辑个性签名");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append((String)localObject);
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setPadding(0, 0, 0, 0);
      ((ImageView)localObject).setImageResource(2130838945);
      break;
      label364:
      localObject = null;
      break label271;
      label369:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  protected void r()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).a(String.valueOf(100160));
      QQSettingUtil.a((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131298477), localAppInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */