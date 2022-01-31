import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.11;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

@TargetApi(9)
public class wku
  extends bafb
  implements View.OnClickListener, Observer
{
  int jdField_a_of_type_Int = 0;
  aejb jdField_a_of_type_Aejb;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ayok a;
  public ayoo a;
  protected ayop a;
  azct jdField_a_of_type_Azct;
  protected URLImageView a;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = null;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  protected boolean b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  protected boolean d;
  protected View e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  boolean f;
  boolean g = false;
  boolean h = false;
  
  public wku(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azct paramazct, String paramString)
  {
    super(paramBaseActivity, 2131690181);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new wkw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity)))
    {
      paramBaseActivity = ((FragmentActivity)paramBaseActivity).getChatFragment();
      if ((paramBaseActivity != null) && ((paramBaseActivity.a() instanceof aejb))) {
        this.jdField_a_of_type_Aejb = ((aejb)paramBaseActivity.a());
      }
      this.jdField_a_of_type_Azct = paramazct;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramBaseActivity = (arom)paramQQAppInterface.getManager(37);
    }
    try
    {
      this.jdField_a_of_type_Ayok = paramBaseActivity.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.jdField_b_of_type_JavaLangString = paramString;
      if (a()) {
        this.jdField_e_of_type_Boolean = true;
      }
      setOnDismissListener(new wkv(this));
      this.f = TroopInfo.isHomeworkTroop(paramQQAppInterface, paramString);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopTipsPopWindow", 2, paramQQAppInterface.toString());
    }
    dismiss();
    return;
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l2 = 60L * 60L;
    long l3 = 24L * l2;
    Date localDate = new Date(1000L * paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate);
    long l1;
    Calendar localCalendar2;
    Object localObject4;
    try
    {
      l1 = NetConnInfoCenter.getServerTime();
      Object localObject1 = new Date(1000L * l1);
      localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime((Date)localObject1);
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      localObject4 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
      localObject1 = null;
      try
      {
        localObject2 = ((SimpleDateFormat)localObject2).parse((String)localObject4);
        localObject1 = localObject2;
        localObject4 = new Date(((Date)localObject2).getTime() - 1000L * l3);
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "get today failed! msg = " + localException2.getMessage());
          }
          localObject3 = null;
        }
        localObject4 = new SimpleDateFormat("HH:mm");
        l1 -= paramLong;
        paramLong = l1;
        if (l1 >= 0L) {
          break label239;
        }
        paramLong = 0L;
        if (paramLong >= 60L) {
          break label253;
        }
        return ajjy.a(2131649889);
        if (paramLong >= l2) {
          break label308;
        }
        l1 = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l1;
        if (l1 != 0L) {
          break label285;
        }
        paramLong = 1L;
        return paramLong + ajjy.a(2131649884);
        if (paramLong >= l3) {
          break label442;
        }
        if (localDate.getDate() == localException1.getDate()) {
          break label372;
        }
        if (!paramBoolean1) {
          break label366;
        }
        return ajjy.a(2131649885) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return ajjy.a(2131649887);
        if (!paramBoolean3) {
          break label406;
        }
        return ajjy.a(2131649888) + ((SimpleDateFormat)localObject4).format(localDate);
        paramLong = ((float)paramLong / (float)l2 + 0.5D);
        return paramLong + ajjy.a(2131649886);
        if ((!paramBoolean2) || (paramLong >= 72L * l2) || (localObject3.getTime() - localDate.getTime() > 1000L * l3)) {
          break label524;
        }
        if (!paramBoolean1) {
          break label517;
        }
        return ajjy.a(2131649880) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return ajjy.a(2131649883);
        if ((paramLong >= 48L * l2) || (localException1.getTime() - localDate.getTime() > 1000L * l3)) {
          break label602;
        }
        if (!paramBoolean1) {
          break label595;
        }
        return ajjy.a(2131649881) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return ajjy.a(2131649891);
        if (localCalendar1.get(1) != localCalendar2.get(1)) {
          break label677;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
        if (!paramBoolean1) {
          break label669;
        }
        return localSimpleDateFormat.format(localDate) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return localSimpleDateFormat.format(localDate);
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        return "unknown";
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l1 = System.currentTimeMillis() / 1000L;
      }
    }
    label239:
    label253:
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).getString(paramString, "");
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_Ayok.deleteObserver(this);
      return false;
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Ayoo != null) {
        break label52;
      }
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
    }
    while (this.jdField_a_of_type_Ayoo == null)
    {
      dismiss();
      return false;
      label52:
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify" + this.jdField_a_of_type_Ayoo.toString());
    }
    this.jdField_a_of_type_Ayoo.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.e)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new axkd(Html.fromHtml(this.jdField_a_of_type_Ayoo.jdField_b_of_type_JavaLangString), 8));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ayoo.jdField_b_of_type_Int + ajjy.a(2131649882));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Ayoo.jdField_a_of_type_Long, true, true, false));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Ayoo.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      this.jdField_c_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new wky(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.c)) {
        c(this.jdField_a_of_type_Ayoo.c);
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632159, new Object[] { Html.fromHtml(this.jdField_a_of_type_Ayoo.jdField_a_of_type_JavaLangString).toString(), this.jdField_a_of_type_Ayoo.g, a(this.jdField_a_of_type_Ayoo.jdField_a_of_type_Long, true, true, false), Html.fromHtml(this.jdField_a_of_type_Ayoo.jdField_b_of_type_JavaLangString).toString() });
      }
      if ((this.jdField_a_of_type_Ayok == null) || (this.jdField_a_of_type_Ayok.jdField_a_of_type_Int != 1)) {
        break label461;
      }
      b();
    }
    for (;;)
    {
      if (paramInt == 2) {
        BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(this.jdField_b_of_type_JavaLangString, false).commit();
      }
      return true;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label461:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  public static void b(String paramString)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.11(paramString), 5, null, false);
  }
  
  private void c(String paramString)
  {
    localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    i = (int)(localDisplayMetrics.widthPixels - bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F));
    int j = (int)bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    try
    {
      URL localURL = new URL(paramString);
      String str2 = a(localURL.getHost());
      localObject = paramString;
      if (!TextUtils.isEmpty(str2)) {
        localObject = new URL("http", str2, localURL.getFile()).toString();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject;
        float f1;
        float f2;
        localMalformedURLException.printStackTrace();
        String str1 = paramString;
        continue;
        float f3 = i;
        i = (int)(f1 / f2 * f3);
        continue;
        paramString.setURLDrawableListener(new wkz(this, localDisplayMetrics));
        continue;
        i = 0;
      }
    }
    paramString = URLDrawable.getDrawable((String)localObject, i, j);
    if (paramString.getStatus() == 1)
    {
      f1 = paramString.getIntrinsicHeight();
      f2 = paramString.getIntrinsicWidth();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (f2 == 0.0F) {
        break label293;
      }
      if (f1 > bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F))
      {
        i = (int)bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
        if (i > 0)
        {
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632155));
        return;
      }
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_Aejb.D())) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).gravity = 48;
    int i = (int)bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10.0F);
    ((WindowManager.LayoutParams)localObject2).y = (this.jdField_a_of_type_Int + i);
    ((WindowManager.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - bacc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new wla(this, i));
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (!this.jdField_a_of_type_Aejb.D())) {
      super.show();
    }
    a("exp_bulletin");
    if (this.jdField_a_of_type_Ayoo.jdField_a_of_type_Int == 2) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.e)) {
      a("exp_vid");
    }
    for (;;)
    {
      try
      {
        localObject1 = (axkd)this.jdField_a_of_type_AndroidWidgetTextView.getText();
        localObject1 = (axkl[])((axkd)localObject1).getSpans(0, ((axkd)localObject1).length(), axkl.class);
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break;
        }
        a("exp_link");
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.c)) {
        a("exp_pic");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Ayok.addObserver(this);
        if (this.f) {
          azzx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Grp_notice", "AioNotice_Show", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString, "", "", "" });
        }
        switch (paramInt)
        {
        default: 
          return;
        }
      } while (this.jdField_a_of_type_Ayok == null);
      this.jdField_a_of_type_Ayok.b(1004);
      return;
    } while (this.jdField_a_of_type_Ayok == null);
    this.jdField_a_of_type_Ayok.b(1003);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().heightPixels - this.jdField_a_of_type_Int * 2);
  }
  
  public void a(ayop paramayop)
  {
    if ((paramayop != null) && (!TextUtils.isEmpty(paramayop.c)) && (!TextUtils.isEmpty(paramayop.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(paramayop.c, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new wlb(this));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new wlc(this, paramayop));
      return;
    }
    a(false, "json data null------");
  }
  
  void a(String paramString)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, this.jdField_b_of_type_JavaLangString, "" + this.jdField_a_of_type_Ayoo.jdField_a_of_type_Int, "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.4(this, paramJSONObject, paramInt), 8, null, true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      QLog.i("zivonchen", 2, "changAdLayoutVisible show = " + paramBoolean + ", from = " + paramString);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a()
  {
    long l = (babp.d() * 3L + babp.e() * 7L) / 10L;
    if (l < 3136512L)
    {
      hide();
      QLog.i("TroopTipsPopWindow", 1, "availMemSize is " + l + " , smaller than 3M , TroopNewGuidePopWindow can't show ");
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131494833, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299149);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131311586);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309893));
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new wkx(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298711));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131304697));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311493));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311491));
      this.jdField_a_of_type_AndroidWidgetTextView.setEditableFactory(axkn.a);
      this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302536));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302538));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302542));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302537));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311593));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632150));
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131632158));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313196));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131302363);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131312045);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131312044));
      setContentView(this.jdField_a_of_type_AndroidViewView);
      setCancelable(true);
      return true;
    }
    catch (InflateException localInflateException)
    {
      hide();
      QLog.e("TroopTipsPopWindow", 2, "InflateException, OutOfMemoryError, hide TroopNewGuidePopWindow");
    }
    return false;
  }
  
  public void b()
  {
    ayok.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, new wld(this));
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Ayok != null) {
      this.jdField_a_of_type_Ayok.deleteObserver(this);
    }
    azfo localazfo = (azfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
    if (localazfo != null) {}
    for (boolean bool = localazfo.a(this.jdField_b_of_type_JavaLangString);; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_Aejb != null) && (!this.jdField_a_of_type_Aejb.D()))
      {
        azfo.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Aejb.o(true);
      }
      super.dismiss();
      return;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.h))
    {
      azve.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangString);
      this.h = true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298711: 
      a("clk_iKnow");
      if (this.jdField_a_of_type_Ayoo.jdField_a_of_type_Int == 2) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "Clk_iknow", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.f) {
        azzx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Grp_notice", "AioNotice_Clk", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString, "", "", "" });
      }
      dismiss();
      return;
    case 2131304697: 
      paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      if ((paramView == null) || (paramView.troopColorNick == null)) {
        break;
      }
    }
    for (paramView = paramView.troopColorNick;; paramView = "")
    {
      Object localObject1 = new Intent(getContext(), EditInfoActivity.class);
      ((Intent)localObject1).putExtra("edit_type", 0);
      ((Intent)localObject1).putExtra("title", getContext().getResources().getString(2131632095));
      ((Intent)localObject1).putExtra("default_text", paramView);
      ((Intent)localObject1).putExtra("isTroopNick", true);
      ((Intent)localObject1).putExtra("troopUin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((Intent)localObject1).putExtra("max_num", 60);
      ((Intent)localObject1).putExtra("from", 0);
      getContext().startActivity((Intent)localObject1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      dismiss();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_b_of_type_JavaLangString);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((localObject1 != null) && (localObject2 != null)) {
        if (!((String)localObject2).equals(((TroopInfo)localObject1).troopowneruin)) {}
      }
      for (;;)
      {
        paramView.putExtra("url", "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=" + this.jdField_b_of_type_JavaLangString + "&role=" + i + "&actionIcon=1");
        paramView.putExtra("webStyle", "noBottomBar");
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        a("clk_history");
        return;
        if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2)))
        {
          i = 1;
          continue;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.e))
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            paramView.putExtra("url", this.jdField_a_of_type_Ayoo.e);
            paramView.putExtra("webStyle", "noBottomBar");
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
            a("clk_vid");
            return;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.d)) {
            break;
          }
          localObject2 = new ArrayList();
          localObject1 = this.jdField_a_of_type_Ayoo.d;
          try
          {
            URL localURL = new URL((String)localObject1);
            String str = a(localURL.getHost());
            paramView = (View)localObject1;
            if (!TextUtils.isEmpty(str)) {
              paramView = new URL("http", str, localURL.getFile()).toString();
            }
          }
          catch (MalformedURLException paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
              paramView = (View)localObject1;
            }
          }
          ((ArrayList)localObject2).add(paramView);
          azcm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, (ArrayList)localObject2, true, "", -1);
          a("clk_pic");
          return;
        }
        i = 2;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((this.jdField_a_of_type_Aejb == null) || (this.jdField_a_of_type_Aejb.D())) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof Integer));
        paramObservable = (Integer)paramObject;
        if (paramObservable.intValue() != 106) {
          break;
        }
      } while (this.jdField_a_of_type_Ayok.jdField_a_of_type_OrgJsonJSONObject == null);
      a(this.jdField_a_of_type_Ayok.jdField_a_of_type_OrgJsonJSONObject, 2);
      return;
    } while ((paramObservable.intValue() != 1007) || (this.jdField_a_of_type_Ayok.b == null));
    a(this.jdField_a_of_type_Ayok.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wku
 * JD-Core Version:    0.7.0.1
 */