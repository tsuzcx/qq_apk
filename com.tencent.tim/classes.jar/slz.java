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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
public class slz
  extends aqju
  implements View.OnClickListener, Observer
{
  TextView Au;
  TextView Av;
  TextView Aw;
  public apbo.b a;
  protected apbo.c a;
  protected apbo a;
  apmp jdField_a_of_type_Apmp;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  boolean aLW = false;
  protected boolean aLX;
  protected boolean aLY;
  boolean aLZ;
  public boolean aMa = false;
  protected URLImageView ab;
  public QQAppInterface app;
  BounceScrollView b = null;
  int bsi = 0;
  int bxG = 0;
  Button cE;
  Button cF;
  TextView jdField_do;
  LinearLayout fw;
  boolean hasImage = false;
  boolean isInit = false;
  boolean isRead = false;
  boolean isSet = false;
  BaseActivity mContext;
  protected String mDesc = "";
  View mRoot;
  TextView mTitle;
  public Handler mUIHandler = new smb(this);
  ImageView ny;
  ImageView ou;
  View qg;
  View qh;
  View qi;
  protected View qj;
  public String troopUin;
  
  public slz(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, apmp paramapmp, String paramString)
  {
    super(paramBaseActivity, 2131756467);
    this.mContext = paramBaseActivity;
    if (((paramBaseActivity instanceof SplashActivity)) || ((paramBaseActivity instanceof ChatActivity)))
    {
      paramBaseActivity = ((FragmentActivity)paramBaseActivity).getChatFragment();
      if ((paramBaseActivity != null) && ((paramBaseActivity.a() instanceof TroopChatPie))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = ((TroopChatPie)paramBaseActivity.a());
      }
      this.jdField_a_of_type_Apmp = paramapmp;
      this.app = paramQQAppInterface;
      paramBaseActivity = (ajdr)paramQQAppInterface.getManager(37);
    }
    try
    {
      this.jdField_a_of_type_Apbo = paramBaseActivity.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.troopUin = paramString;
      if (vp()) {
        this.isInit = true;
      }
      setOnDismissListener(new sma(this));
      this.aLZ = TroopInfo.isHomeworkTroop(paramQQAppInterface, paramString);
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
          break label240;
        }
        paramLong = 0L;
        if (paramLong >= 60L) {
          break label255;
        }
        return acfp.m(2131716038);
        if (paramLong >= l2) {
          break label312;
        }
        l1 = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l1;
        if (l1 != 0L) {
          break label288;
        }
        paramLong = 1L;
        return paramLong + acfp.m(2131716033);
        if (paramLong >= l3) {
          break label451;
        }
        if (localDate.getDate() == localException1.getDate()) {
          break label379;
        }
        if (!paramBoolean1) {
          break label372;
        }
        return acfp.m(2131716034) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return acfp.m(2131716036);
        if (!paramBoolean3) {
          break label414;
        }
        return acfp.m(2131716037) + ((SimpleDateFormat)localObject4).format(localDate);
        paramLong = ((float)paramLong / (float)l2 + 0.5D);
        return paramLong + acfp.m(2131716035);
        if ((!paramBoolean2) || (paramLong >= 72L * l2) || (localObject3.getTime() - localDate.getTime() > 1000L * l3)) {
          break label534;
        }
        if (!paramBoolean1) {
          break label527;
        }
        return acfp.m(2131716029) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return acfp.m(2131716032);
        if ((paramLong >= 48L * l2) || (localException1.getTime() - localDate.getTime() > 1000L * l3)) {
          break label613;
        }
        if (!paramBoolean1) {
          break label606;
        }
        return acfp.m(2131716030) + " " + ((SimpleDateFormat)localObject4).format(localDate);
        return acfp.m(2131716040);
        if (localCalendar1.get(1) != localCalendar2.get(1)) {
          break label689;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
        if (!paramBoolean1) {
          break label681;
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
    label240:
    label255:
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static String aP(long paramLong)
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
  
  private boolean b(JSONObject paramJSONObject, int paramInt)
  {
    if (!this.isInit)
    {
      this.jdField_a_of_type_Apbo.deleteObserver(this);
      return false;
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Apbo$b != null) {
        break label52;
      }
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
    }
    while (this.jdField_a_of_type_Apbo$b == null)
    {
      dismiss();
      return false;
      label52:
      QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify" + this.jdField_a_of_type_Apbo$b.toString());
    }
    this.jdField_a_of_type_Apbo$b.mType = paramInt;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Apbo$b.cnX)) {
      this.ou.setVisibility(0);
    }
    this.jdField_do.setText(new aofk(Html.fromHtml(this.jdField_a_of_type_Apbo$b.content), 8));
    this.Aw.setText(this.jdField_a_of_type_Apbo$b.dTf + acfp.m(2131716031));
    this.Av.setText(aP(this.jdField_a_of_type_Apbo$b.time));
    this.aLW = this.jdField_a_of_type_Apbo$b.aLW;
    if (this.aLW)
    {
      this.cF.setVisibility(0);
      this.cF.setOnClickListener(this);
      anot.a(this.app, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.troopUin, "", "", "");
      if (this.jdField_a_of_type_Apbo$b.cPK)
      {
        this.mTitle.setText(2131699858);
        this.cE.setText(2131699847);
        this.cE.setContentDescription(this.mContext.getString(2131699847));
      }
      this.Av.getViewTreeObserver().addOnGlobalLayoutListener(new smd(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Apbo$b.picPath)) {
        setImage(this.jdField_a_of_type_Apbo$b.picPath);
      }
      if (AppSetting.enableTalkBack) {
        this.mDesc = this.mContext.getString(2131699856, new Object[] { Html.fromHtml(this.jdField_a_of_type_Apbo$b.title).toString(), this.jdField_a_of_type_Apbo$b.cnZ, a(this.jdField_a_of_type_Apbo$b.time, true, true, false), Html.fromHtml(this.jdField_a_of_type_Apbo$b.content).toString() });
      }
      if ((this.jdField_a_of_type_Apbo == null) || (this.jdField_a_of_type_Apbo.dTb != 1)) {
        break label469;
      }
      bzv();
    }
    for (;;)
    {
      return true;
      this.cF.setVisibility(8);
      break;
      label469:
      this.mUIHandler.sendEmptyMessage(1001);
    }
  }
  
  public static String gF(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).getString(paramString, "");
  }
  
  private void setImage(String paramString)
  {
    localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    i = (int)(localDisplayMetrics.widthPixels - aqho.convertDpToPixel(this.mContext, 60.0F));
    int j = (int)aqho.convertDpToPixel(this.mContext, 150.0F);
    if (!TextUtils.isEmpty(paramString))
    {
      this.hasImage = true;
      this.ny.setVisibility(0);
      this.qg.setVisibility(0);
    }
    try
    {
      URL localURL = new URL(paramString);
      String str2 = gF(localURL.getHost());
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
        paramString.setURLDrawableListener(new sme(this, localDisplayMetrics));
        continue;
        i = 0;
      }
    }
    paramString = URLDrawable.getDrawable((String)localObject, i, j);
    if (paramString.getStatus() == 1)
    {
      f1 = paramString.getIntrinsicHeight();
      f2 = paramString.getIntrinsicWidth();
      localObject = this.ny.getLayoutParams();
      if (f2 == 0.0F) {
        break label293;
      }
      if (f1 > aqho.convertDpToPixel(this.mContext, 150.0F))
      {
        i = (int)aqho.convertDpToPixel(this.mContext, 150.0F);
        if (i > 0)
        {
          ((ViewGroup.LayoutParams)localObject).height = i;
          this.ny.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.ny.setImageDrawable(paramString);
        this.ny.setContentDescription(this.mContext.getString(2131699851));
        return;
      }
    }
  }
  
  public static void tp(String paramString)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.11(paramString), 5, null, false);
  }
  
  public void I(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.qj.setVisibility(0);
    }
    for (;;)
    {
      QLog.i("zivonchen", 2, "changAdLayoutVisible show = " + paramBoolean + ", from = " + paramString);
      return;
      this.qj.setVisibility(8);
    }
  }
  
  public void a(apbo.c paramc)
  {
    if ((paramc != null) && (!TextUtils.isEmpty(paramc.img)) && (!TextUtils.isEmpty(paramc.rl)))
    {
      this.qj.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(paramc.img, (URLDrawable.URLDrawableOptions)localObject);
      this.ab.setImageDrawable((Drawable)localObject);
      this.ab.setURLDrawableDownListener(new smg(this));
      this.ab.setOnClickListener(new smh(this, paramc));
      return;
    }
    I(false, "json data null------");
  }
  
  public void b(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.4(this, paramJSONObject, paramBoolean, paramInt), 8, null, true);
  }
  
  void bzu()
  {
    if ((this.mContext.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.isDestroy())) {
      return;
    }
    Object localObject1 = this.mContext.getResources().getDisplayMetrics();
    Object localObject2 = this.mRoot.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - aqho.convertDpToPixel(this.mContext, 30.0F)));
    this.mRoot.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).gravity = 17;
    int i = (int)aqho.convertDpToPixel(this.mContext, 10.0F);
    ((WindowManager.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - aqho.convertDpToPixel(this.mContext, 30.0F)));
    this.mRoot.getViewTreeObserver().addOnGlobalLayoutListener(new smf(this, i));
    if ((!this.mContext.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.isDestroy())) {
      super.show();
    }
    report("exp_bulletin");
    if (this.jdField_a_of_type_Apbo$b.mType == 2) {
      anot.a(this.app, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.troopUin, "", "", "");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Apbo$b.cnX)) {
      report("exp_vid");
    }
    for (;;)
    {
      try
      {
        localObject1 = (aofk)this.jdField_do.getText();
        localObject1 = (aofk.b[])((aofk)localObject1).getSpans(0, ((aofk)localObject1).length(), aofk.b.class);
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break;
        }
        report("exp_link");
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Apbo$b.picPath)) {
        report("exp_pic");
      }
    }
  }
  
  public void bzv()
  {
    apbo.a(this.mContext, this.app, 0, new smi(this));
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Apbo != null) {
      this.jdField_a_of_type_Apbo.deleteObserver(this);
    }
    apqk localapqk = (apqk)this.app.getManager(223);
    if (localapqk != null) {}
    for (boolean bool = localapqk.qH(this.troopUin);; bool = false)
    {
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.isDestroy()))
      {
        apqk.cRX = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.wi(true);
      }
      super.dismiss();
      return;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(this.mDesc)) && (!this.isRead))
    {
      aqcl.speak(this.mRoot, this.mDesc);
      this.isRead = true;
    }
    return true;
  }
  
  public void eF(int paramInt1, int paramInt2)
  {
    this.bxG = paramInt1;
    this.bsi = (this.mContext.getResources().getDisplayMetrics().heightPixels - this.bxG * 2);
  }
  
  public void onClick(View paramView)
  {
    Object localObject4;
    Object localObject5;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131371880: 
      localObject3 = "";
      localObject4 = (TroopManager)this.app.getManager(52);
      localObject5 = ((TroopManager)localObject4).b(this.troopUin, this.app.getCurrentUin());
      localObject1 = localObject3;
      if (localObject5 != null)
      {
        localObject1 = localObject3;
        if (((TroopMemberInfo)localObject5).troopColorNick != null) {
          localObject1 = ((TroopMemberInfo)localObject5).troopColorNick;
        }
      }
      localObject3 = ((TroopManager)localObject4).b(this.troopUin);
      if (localObject3 == null) {
        break;
      }
    }
    for (Object localObject3 = "" + ((TroopInfo)localObject3).dwGroupClassExt;; localObject3 = "")
    {
      localObject4 = new Intent(getContext(), EditInfoActivity.class);
      ((Intent)localObject4).putExtra("edit_type", 0);
      ((Intent)localObject4).putExtra("title", getContext().getResources().getString(2131699789));
      ((Intent)localObject4).putExtra("default_text", (String)localObject1);
      ((Intent)localObject4).putExtra("isTroopNick", true);
      ((Intent)localObject4).putExtra("troopUin", this.troopUin);
      ((Intent)localObject4).putExtra("uin", this.app.getAccount());
      ((Intent)localObject4).putExtra("max_num", 60);
      ((Intent)localObject4).putExtra("from", 0);
      getContext().startActivity((Intent)localObject4);
      anot.a(this.app, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.troopUin, "", "", "");
      localObject1 = this.app;
      localObject4 = this.troopUin;
      if (this.jdField_a_of_type_Apbo$b.cPK) {}
      for (int i = 2;; i = 1)
      {
        anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800AACA", "0X800AACA", 0, 0, (String)localObject4, (String)localObject3, String.valueOf(i), "");
        dismiss();
        break;
      }
      localObject4 = new Intent(this.mContext, QQBrowserActivity.class);
      localObject5 = ((TroopManager)this.app.getManager(52)).b(this.troopUin);
      localObject3 = "";
      String str = this.app.getCurrentAccountUin();
      localObject1 = localObject3;
      if (localObject5 != null)
      {
        localObject1 = localObject3;
        if (str != null)
        {
          if (!str.equals(((TroopInfo)localObject5).troopowneruin)) {
            break label656;
          }
          label477:
          localObject1 = "" + ((TroopInfo)localObject5).dwGroupClassExt;
        }
      }
      ((Intent)localObject4).putExtra("url", "https://web.qun.qq.com/mannounce/detail.html?_bid=148&_wv=1031#fid=" + this.jdField_a_of_type_Apbo$b.feedId + "&gc=" + this.troopUin);
      ((Intent)localObject4).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.mContext.startActivity((Intent)localObject4);
      report("clk_history");
      if (this.jdField_a_of_type_Apbo$b.cPK)
      {
        localObject3 = this.app;
        localObject4 = this.troopUin;
        if (this.aMa)
        {
          i = 2;
          label620:
          anot.a((QQAppInterface)localObject3, "dc00898", "", "", "0X800AAC9", "0X800AAC9", 0, 0, (String)localObject4, (String)localObject1, "", String.valueOf(i));
        }
      }
      for (;;)
      {
        dismiss();
        break;
        label656:
        if ((((TroopInfo)localObject5).Administrator == null) || (!((TroopInfo)localObject5).Administrator.contains(str))) {
          break label477;
        }
        break label477;
        i = 1;
        break label620;
        anot.a(this.app, "dc00898", "", "", "0X800AAC8", "0X800AAC8", 0, 0, this.troopUin, (String)localObject1, "", "");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Apbo$b.cnX))
      {
        localObject1 = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_Apbo$b.cnX);
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        this.mContext.startActivity((Intent)localObject1);
        report("clk_vid");
        break;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Apbo$b.cnW)) {
        break;
      }
      localObject4 = new ArrayList();
      localObject3 = this.jdField_a_of_type_Apbo$b.cnW;
      try
      {
        localObject5 = new URL((String)localObject3);
        str = gF(((URL)localObject5).getHost());
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(str)) {
          localObject1 = new URL("http", str, ((URL)localObject5).getFile()).toString();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject2 = localObject3;
        }
      }
      ((ArrayList)localObject4).add(localObject1);
      apmj.a(this.mContext, 0, (ArrayList)localObject4, true, "", -1);
      report("clk_pic");
      break;
    }
  }
  
  void report(String paramString)
  {
    anot.a(this.app, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, this.troopUin, "" + this.jdField_a_of_type_Apbo$b.mType, "", "");
  }
  
  public void show(int paramInt)
  {
    if (!this.isInit) {}
    aptq localaptq;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Apbo.addObserver(this);
          if (this.aLZ) {
            aqfr.a(this.app, this.troopUin, "Grp_notice", "AioNotice_Show", 0, 0, new String[] { this.troopUin, "", "", "" });
          }
          switch (paramInt)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_Apbo == null);
        localaptq = aptr.a(this.app, this.troopUin);
      } while (localaptq == null);
      if (localaptq.dVP != 1) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 1");
      }
      this.jdField_a_of_type_Apbo.dO(1007, localaptq.crj);
      return;
    } while (this.jdField_a_of_type_Apbo == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "show. GET_NEW_GUIDE_NOTICE_REQUEST_CODE");
    }
    this.jdField_a_of_type_Apbo.WA(1003);
    return;
    if (localaptq.dVP == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 2");
      }
      this.jdField_a_of_type_Apbo.WA(1003);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "show. GET_NOR_NOTICE, type = 0");
    }
    this.jdField_a_of_type_Apbo.WA(1004);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.isDestroy())) {}
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
            if (this.jdField_a_of_type_Apbo.bR != null)
            {
              b(this.jdField_a_of_type_Apbo.bR, 2, false);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopTipsPopWindow", 2, "mNewGuideNotice = null!");
          return;
          if (paramObservable.intValue() != 1007) {
            break;
          }
          if (this.jdField_a_of_type_Apbo.bS != null)
          {
            b(this.jdField_a_of_type_Apbo.bS, 1, false);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
        return;
        if (paramObservable.intValue() != 1011) {
          break;
        }
        if (this.jdField_a_of_type_Apbo.bS != null)
        {
          b(this.jdField_a_of_type_Apbo.bS, 1, true);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
      return;
    } while (paramObservable.intValue() != 1012);
    aptr.aZ(this.app, this.troopUin);
  }
  
  public boolean vp()
  {
    long l = (aqgz.getSystemTotalMemory() * 3L + aqgz.getSystemAvaialbeMemory() * 7L) / 10L;
    if (l < 3136512L)
    {
      hide();
      QLog.i("TroopTipsPopWindow", 1, "availMemSize is " + l + " , smaller than 3M , TroopNewGuidePopWindow can't show ");
      return false;
    }
    try
    {
      this.mRoot = LayoutInflater.from(this.mContext).inflate(2131560870, null);
      this.qh = this.mRoot.findViewById(2131365382);
      this.qi = this.mRoot.findViewById(2131379823);
      this.qi.setOnClickListener(this);
      this.b = ((BounceScrollView)this.mRoot.findViewById(2131377757));
      if (Build.VERSION.SDK_INT > 8) {
        this.b.setOverScrollMode(2);
      }
      this.b.setOnScrollChangedListener(new smc(this));
      this.mTitle = ((TextView)this.mRoot.findViewById(2131372521));
      this.cE = ((Button)this.mRoot.findViewById(2131364687));
      this.cF = ((Button)this.mRoot.findViewById(2131371880));
      this.ny = ((ImageView)this.mRoot.findViewById(2131379714));
      this.ny.setOnClickListener(this);
      this.jdField_do = ((TextView)this.mRoot.findViewById(2131379712));
      this.jdField_do.setEditableFactory(aofr.a);
      this.jdField_do.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_do.setOnClickListener(this);
      this.fw = ((LinearLayout)this.mRoot.findViewById(2131369236));
      this.Au = ((TextView)this.mRoot.findViewById(2131369240));
      this.Av = ((TextView)this.mRoot.findViewById(2131369252));
      this.Aw = ((TextView)this.mRoot.findViewById(2131369239));
      this.cE.setOnClickListener(this);
      this.cE.setContentDescription(this.mContext.getString(2131699855));
      this.ou = ((ImageView)this.mRoot.findViewById(2131381757));
      this.ou.setOnClickListener(this);
      this.qg = this.mRoot.findViewById(2131369041);
      this.qj = this.mRoot.findViewById(2131380365);
      this.ab = ((URLImageView)this.qj.findViewById(2131380364));
      setContentView(this.mRoot);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slz
 * JD-Core Version:    0.7.0.1
 */