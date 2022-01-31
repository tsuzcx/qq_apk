import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
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
public class ytb
  extends bdjz
  implements View.OnClickListener, Observer
{
  int jdField_a_of_type_Int = 0;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bbru a;
  public bbry a;
  protected bbrz a;
  bcgx jdField_a_of_type_Bcgx;
  protected URLImageView a;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
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
  public boolean g = false;
  boolean h = false;
  boolean i = false;
  
  public ytb(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, bcgx parambcgx, String paramString)
  {
    super(paramBaseActivity, 2131755801);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new ytd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity)))
    {
      paramBaseActivity = ((FragmentActivity)paramBaseActivity).getChatFragment();
      if ((paramBaseActivity != null) && ((paramBaseActivity.a() instanceof TroopChatPie))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = ((TroopChatPie)paramBaseActivity.a());
      }
      this.jdField_a_of_type_Bcgx = parambcgx;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      paramBaseActivity = (auga)paramQQAppInterface.getManager(37);
    }
    try
    {
      this.jdField_a_of_type_Bbru = paramBaseActivity.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.jdField_b_of_type_JavaLangString = paramString;
      if (a()) {
        this.jdField_e_of_type_Boolean = true;
      }
      setOnDismissListener(new ytc(this));
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
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong * 1000L);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(localDate);
    try
    {
      paramLong = NetConnInfoCenter.getServerTime();
      Object localObject2 = new Date(paramLong * 1000L);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime((Date)localObject2);
      localObject2 = new SimpleDateFormat("HH:mm");
      if (((Calendar)localObject1).get(1) == localCalendar.get(1))
      {
        localObject1 = new SimpleDateFormat("M月d日");
        return ((SimpleDateFormat)localObject1).format(localDate) + " " + ((SimpleDateFormat)localObject2).format(localDate);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong = System.currentTimeMillis() / 1000L;
      }
    }
    return new SimpleDateFormat("yyyy年M月d日").format(localDate);
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
        return alud.a(2131716075);
        if (paramLong >= l2) {
          break label308;
        }
        l1 = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l1;
        if (l1 != 0L) {
          break label285;
        }
        paramLong = 1L;
        return paramLong + alud.a(2131716070);
        if (paramLong >= l3) {
          break label446;
        }
        if (localDate.getDate() == localException1.getDate()) {
          break label374;
        }
        if (!paramBoolean1) {
          break label367;
        }
        return alud.a(2131716071) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return alud.a(2131716073);
        if (!paramBoolean3) {
          break label409;
        }
        return alud.a(2131716074) + ((SimpleDateFormat)localObject4).format(localDate);
        paramLong = ((float)paramLong / (float)l2 + 0.5D);
        return paramLong + alud.a(2131716072);
        if ((!paramBoolean2) || (paramLong >= 72L * l2) || (localObject3.getTime() - localDate.getTime() > 1000L * l3)) {
          break label528;
        }
        if (!paramBoolean1) {
          break label521;
        }
        return alud.a(2131716066) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return alud.a(2131716069);
        if ((paramLong >= 48L * l2) || (localException1.getTime() - localDate.getTime() > 1000L * l3)) {
          break label606;
        }
        if (!paramBoolean1) {
          break label599;
        }
        return alud.a(2131716067) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return alud.a(2131716077);
        if (localCalendar1.get(1) != localCalendar2.get(1)) {
          break label681;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
        if (!paramBoolean1) {
          break label673;
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
      this.jdField_a_of_type_Bbru.deleteObserver(this);
      return false;
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Bbry != null) {
        break label52;
      }
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
    }
    while (this.jdField_a_of_type_Bbry == null)
    {
      dismiss();
      return false;
      label52:
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify" + this.jdField_a_of_type_Bbry.toString());
    }
    this.jdField_a_of_type_Bbry.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbry.f)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(new bamp(Html.fromHtml(this.jdField_a_of_type_Bbry.jdField_c_of_type_JavaLangString), 8));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Bbry.jdField_b_of_type_Int + alud.a(2131716068));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Bbry.jdField_a_of_type_Long));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bbry.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      if (this.jdField_a_of_type_Bbry.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698073);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131698062);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698062));
      }
      this.jdField_d_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ytf(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbry.d)) {
        c(this.jdField_a_of_type_Bbry.d);
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698071, new Object[] { Html.fromHtml(this.jdField_a_of_type_Bbry.jdField_b_of_type_JavaLangString).toString(), this.jdField_a_of_type_Bbry.h, a(this.jdField_a_of_type_Bbry.jdField_a_of_type_Long, true, true, false), Html.fromHtml(this.jdField_a_of_type_Bbry.jdField_c_of_type_JavaLangString).toString() });
      }
      if ((this.jdField_a_of_type_Bbru == null) || (this.jdField_a_of_type_Bbru.jdField_a_of_type_Int != 1)) {
        break label469;
      }
      b();
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label469:
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
    j = (int)(localDisplayMetrics.widthPixels - bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F));
    int k = (int)bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
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
        float f3 = j;
        j = (int)(f1 / f2 * f3);
        continue;
        paramString.setURLDrawableListener(new ytg(this, localDisplayMetrics));
        continue;
        j = 0;
      }
    }
    paramString = URLDrawable.getDrawable((String)localObject, j, k);
    if (paramString.getStatus() == 1)
    {
      f1 = paramString.getIntrinsicHeight();
      f2 = paramString.getIntrinsicWidth();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (f2 == 0.0F) {
        break label293;
      }
      if (f1 > bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F))
      {
        j = (int)bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
        if (j > 0)
        {
          ((ViewGroup.LayoutParams)localObject).height = j;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698066));
        return;
      }
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.E())) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).gravity = 17;
    int j = (int)bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10.0F);
    ((WindowManager.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - bdgz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new yth(this, j));
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.E())) {
      super.show();
    }
    a("exp_bulletin");
    if (this.jdField_a_of_type_Bbry.jdField_a_of_type_Int == 2) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbry.f)) {
      a("exp_vid");
    }
    for (;;)
    {
      try
      {
        localObject1 = (bamp)this.jdField_b_of_type_AndroidWidgetTextView.getText();
        localObject1 = (bamx[])((bamp)localObject1).getSpans(0, ((bamp)localObject1).length(), bamx.class);
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
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbry.d)) {
        a("exp_pic");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {}
    bcoz localbcoz;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Bbru.addObserver(this);
          if (this.f) {
            bdes.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Grp_notice", "AioNotice_Show", 0, 0, new String[] { this.jdField_b_of_type_JavaLangString, "", "", "" });
          }
          switch (paramInt)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_Bbru == null);
        localbcoz = bcpa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      } while (localbcoz == null);
      if (localbcoz.jdField_a_of_type_Int != 1) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 1");
      }
      this.jdField_a_of_type_Bbru.a(1007, localbcoz.jdField_a_of_type_JavaLangString);
      return;
    } while (this.jdField_a_of_type_Bbru == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "show. GET_NEW_GUIDE_NOTICE_REQUEST_CODE");
    }
    this.jdField_a_of_type_Bbru.b(1003);
    return;
    if (localbcoz.jdField_a_of_type_Int == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 2");
      }
      this.jdField_a_of_type_Bbru.b(1003);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "show. GET_NOR_NOTICE, type = 0");
    }
    this.jdField_a_of_type_Bbru.b(1004);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().heightPixels - this.jdField_a_of_type_Int * 2);
  }
  
  public void a(bbrz parambbrz)
  {
    if ((parambbrz != null) && (!TextUtils.isEmpty(parambbrz.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambbrz.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(parambbrz.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new yti(this));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new ytj(this, parambbrz));
      return;
    }
    a(false, "json data null------");
  }
  
  void a(String paramString)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, this.jdField_b_of_type_JavaLangString, "" + this.jdField_a_of_type_Bbry.jdField_a_of_type_Int, "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.4(this, paramJSONObject, paramBoolean, paramInt), 8, null, true);
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
    long l = (bdgk.d() * 3L + bdgk.e() * 7L) / 10L;
    if (l < 3136512L)
    {
      hide();
      QLog.i("TroopTipsPopWindow", 1, "availMemSize is " + l + " , smaller than 3M , TroopNewGuidePopWindow can't show ");
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560512, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364788);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377989);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376200));
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new yte(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371272));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364337));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370677));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377889));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377887));
      this.jdField_b_of_type_AndroidWidgetTextView.setEditableFactory(bamz.a);
      this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368313));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368315));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368319));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368314));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698070));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379769));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368131);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378471);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131378470));
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
    bbru.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, new ytk(this));
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Bbru != null) {
      this.jdField_a_of_type_Bbru.deleteObserver(this);
    }
    bcka localbcka = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
    if (localbcka != null) {}
    for (boolean bool = localbcka.a(this.jdField_b_of_type_JavaLangString);; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.E()))
      {
        bcka.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.o(true);
      }
      super.dismiss();
      return;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.i))
    {
      bczz.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangString);
      this.i = true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject3;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370677: 
      localObject1 = "";
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject3 = ((TroopManager)localObject2).b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      paramView = (View)localObject1;
      if (localObject3 != null)
      {
        paramView = (View)localObject1;
        if (((TroopMemberInfo)localObject3).troopColorNick != null) {
          paramView = ((TroopMemberInfo)localObject3).troopColorNick;
        }
      }
      localObject1 = ((TroopManager)localObject2).b(this.jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        break;
      }
    }
    for (Object localObject1 = "" + ((TroopInfo)localObject1).dwGroupClassExt;; localObject1 = "")
    {
      localObject2 = new Intent(getContext(), EditInfoActivity.class);
      ((Intent)localObject2).putExtra("edit_type", 0);
      ((Intent)localObject2).putExtra("title", getContext().getResources().getString(2131698004));
      ((Intent)localObject2).putExtra("default_text", paramView);
      ((Intent)localObject2).putExtra("isTroopNick", true);
      ((Intent)localObject2).putExtra("troopUin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((Intent)localObject2).putExtra("max_num", 60);
      ((Intent)localObject2).putExtra("from", 0);
      getContext().startActivity((Intent)localObject2);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bbry.jdField_c_of_type_Boolean) {}
      for (int j = 2;; j = 1)
      {
        azqs.b(paramView, "dc00898", "", "", "0X800AACA", "0X800AACA", 0, 0, (String)localObject2, (String)localObject1, String.valueOf(j), "");
        dismiss();
        return;
      }
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localObject3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_b_of_type_JavaLangString);
      localObject1 = "";
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramView = (View)localObject1;
      if (localObject3 != null)
      {
        paramView = (View)localObject1;
        if (str != null)
        {
          if (!str.equals(((TroopInfo)localObject3).troopowneruin)) {
            break label632;
          }
          paramView = "" + ((TroopInfo)localObject3).dwGroupClassExt;
        }
      }
      ((Intent)localObject2).putExtra("url", "http://web.qun.qq.com/mannounce/detail.html?_bid=148&_wv=1031#fid=" + this.jdField_a_of_type_Bbry.i + "&gc=" + this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      a("clk_history");
      if (this.jdField_a_of_type_Bbry.jdField_c_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = this.jdField_b_of_type_JavaLangString;
        if (this.g)
        {
          j = 2;
          label599:
          azqs.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800AAC9", "0X800AAC9", 0, 0, (String)localObject2, paramView, "", String.valueOf(j));
        }
      }
      for (;;)
      {
        dismiss();
        return;
        label632:
        if ((((TroopInfo)localObject3).Administrator == null) || (!((TroopInfo)localObject3).Administrator.contains(str))) {
          break;
        }
        break;
        j = 1;
        break label599;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AAC8", "0X800AAC8", 0, 0, this.jdField_b_of_type_JavaLangString, paramView, "", "");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbry.f))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_Bbry.f);
        paramView.putExtra("webStyle", "noBottomBar");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        a("clk_vid");
        return;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Bbry.e)) {
        break;
      }
      localObject2 = new ArrayList();
      localObject1 = this.jdField_a_of_type_Bbry.e;
      try
      {
        localObject3 = new URL((String)localObject1);
        str = a(((URL)localObject3).getHost());
        paramView = (View)localObject1;
        if (!TextUtils.isEmpty(str)) {
          paramView = new URL("http", str, ((URL)localObject3).getFile()).toString();
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
      bcgq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, (ArrayList)localObject2, true, "", -1);
      a("clk_pic");
      return;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.E())) {}
    label17:
    do
    {
      do
      {
        do
        {
          do
          {
            break label17;
            break label17;
            do
            {
              return;
            } while (!(paramObject instanceof Integer));
            paramObservable = (Integer)paramObject;
            if (QLog.isColorLevel()) {
              QLog.d("TroopTipsPopWindow", 2, "update, notifyType = " + paramObservable);
            }
            if (paramObservable.intValue() != 106) {
              break;
            }
            if (this.jdField_a_of_type_Bbru.jdField_a_of_type_OrgJsonJSONObject != null)
            {
              a(this.jdField_a_of_type_Bbru.jdField_a_of_type_OrgJsonJSONObject, 2, false);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopTipsPopWindow", 2, "mNewGuideNotice = null!");
          return;
          if (paramObservable.intValue() != 1007) {
            break;
          }
          if (this.jdField_a_of_type_Bbru.b != null)
          {
            a(this.jdField_a_of_type_Bbru.b, 1, false);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
        return;
        if (paramObservable.intValue() != 1011) {
          break;
        }
        if (this.jdField_a_of_type_Bbru.b != null)
        {
          a(this.jdField_a_of_type_Bbru.b, 1, true);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
      return;
    } while (paramObservable.intValue() != 1012);
    bcpa.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytb
 * JD-Core Version:    0.7.0.1
 */