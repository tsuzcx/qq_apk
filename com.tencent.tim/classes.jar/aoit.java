import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.ui.RoundRectView;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

public class aoit
  extends PopupWindow
  implements View.OnClickListener, AtPanelTouchController.a
{
  aoit.a jdField_a_of_type_Aoit$a;
  RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  AtPanelTouchController jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController;
  aoif jdField_c_of_type_Aoif = new aoiu(this);
  TroopChatPie jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  View.OnClickListener df = new aoiv(this);
  BaseActivity mActivity;
  XListView mListView;
  TextView mTitleTv;
  private Animation t;
  
  public aoit(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.mActivity = paramBaseActivity;
    this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
  }
  
  private View a(aoit paramaoit, Activity paramActivity, int paramInt)
  {
    View localView = paramaoit.getContentView();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController = ((AtPanelTouchController)localView.findViewById(2131365360));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setControlLitTongue(false);
    ((RelativeLayout)localView.findViewById(2131370576)).setPadding(0, 0, 0, aqnm.dpToPx(24.0F) + getNavigationBarHeight(paramActivity));
    localView.findViewById(2131380119).setOnClickListener(this);
    this.mTitleTv = ((TextView)localView.findViewById(2131372845));
    this.mTitleTv.setText(2131701812);
    if ((paramActivity instanceof BaseActivity))
    {
      if (ThemeUtil.isNowThemeIsNight(((BaseActivity)paramActivity).app, false, null)) {
        this.mTitleTv.setTextColor(-1);
      }
    }
    else
    {
      this.mListView = ((XListView)localView.findViewById(2131365384));
      this.mListView.getLayoutParams();
      this.mListView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setAtPanelTouchListener(paramaoit);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setMode(paramInt);
      this.jdField_a_of_type_Aoit$a = new aoit.a(this.mActivity, this.df);
      this.mListView.setAdapter(this.jdField_a_of_type_Aoit$a);
      paramaoit = (aeog)aeif.a().o(553);
      if ((paramaoit == null) || (paramaoit.vL.size() <= 0)) {
        break label451;
      }
      this.jdField_a_of_type_Aoit$a.setData(paramaoit.vL);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)localView.findViewById(2131363287));
      paramaoit = aohy.a(this.mActivity.app).a();
      if (paramaoit != null)
      {
        paramActivity = URLDrawable.URLDrawableOptions.obtain();
        paramActivity = URLDrawable.getDrawable(paramaoit.pic, paramActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(aqnm.dpToPx(16.0F));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable(paramActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setEnableEffect(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setTag(paramaoit);
        if (AppSetting.enableTalkBack) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setContentDescription(this.mActivity.getString(2131697388));
        }
        aohy.a(this.mActivity.app).ac(this.mActivity.app.getCurrentUin(), 101, paramaoit.a.iAdId.get() + "");
      }
      this.mActivity.app.addObserver(this.jdField_c_of_type_Aoif);
      return localView;
      this.mTitleTv.setTextColor(paramActivity.getResources().getColor(2131167286));
      break;
      label451:
      this.jdField_a_of_type_Aoit$a.setData(aoie.dP());
    }
  }
  
  public static aoit a(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131561549, null);
    paramTroopChatPie = new aoit(paramTroopChatPie, paramBaseActivity, localView, paramInt1, paramInt2);
    paramTroopChatPie.a(paramTroopChatPie, paramBaseActivity, 1);
    localView.findViewById(2131370576).setBackgroundColor(localView.getResources().getColor(2131167278));
    paramTroopChatPie.setFocusable(false);
    localView.setOnClickListener(paramTroopChatPie);
    ((RelativeLayout)localView.findViewById(2131372846)).setOnClickListener(paramTroopChatPie);
    paramTroopChatPie.setInputMethodMode(1);
    paramTroopChatPie.setSoftInputMode(16);
    paramTroopChatPie.setClippingEnabled(false);
    paramTroopChatPie.setOutsideTouchable(true);
    if (AppSetting.enableTalkBack) {
      a(paramTroopChatPie);
    }
    return paramTroopChatPie;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!localMethod.getName().equals("setTouchModal")) {}
      }
      else
      {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  private int d(Resources paramResources)
  {
    int i = paramResources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public void QR(boolean paramBoolean) {}
  
  void RT(String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mActivity.app.getManager(52)).c(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL());
    if (localTroopInfo == null) {}
    Bundle localBundle;
    do
    {
      return;
      aohy localaohy = (aohy)this.mActivity.app.getManager(339);
      localBundle = aoij.a(true, localTroopInfo.isTroopOwner(this.mActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL(), 0);
      if (!localaohy.a(this.mActivity, 2, localTroopInfo.troopuin, 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    aoij.a(this.mActivity.app, 1, paramString, null, localBundle, 1);
  }
  
  public void VO(int paramInt)
  {
    dismiss();
  }
  
  public void dUL()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.scrollTo(0, 0);
    if ((this.t != null) && (!this.t.hasEnded())) {
      return;
    }
    if (this.t == null) {
      this.t = AnimationUtils.loadAnimation(this.mActivity, 2130772009);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.startAnimation(this.t);
    this.jdField_a_of_type_Aoit$a.onShow();
  }
  
  void dUM()
  {
    aiob.b(this.mActivity.app, this.mActivity, 1, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL(), 0);
    anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_music", 0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl, "", "" + apuh.o(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl)), "");
  }
  
  void dUN()
  {
    aeof localaeof = (aeof)aeif.a().o(535);
    if ((localaeof == null) || (localaeof.a == null)) {
      QQToast.a(this.mActivity, 0, 2131694552, 0).show();
    }
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((TroopManager)this.mActivity.app.getManager(52)).c(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL());
    } while (localTroopInfo == null);
    aohy localaohy = (aohy)this.mActivity.app.getManager(339);
    boolean bool = localaohy.e(2, 1, localTroopInfo.uin);
    Bundle localBundle = aoij.a(true, localTroopInfo.isTroopOwner(this.mActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL(), 0);
    switch (localaeof.a.getVersion())
    {
    default: 
      if (localaohy.a(this.mActivity, 2, localTroopInfo.troopuin, 0)) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
        }
      }
      break;
    }
    for (;;)
    {
      anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_video", 0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl, "", "" + apuh.o(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl)), "");
      return;
      QQToast.a(this.mActivity, 0, 2131694552, 0).show();
      continue;
      if (!localTroopInfo.isAdmin())
      {
        if (bool) {
          localaohy.b(this.mActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        } else {
          localaohy.a(this.mActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        }
      }
      else if (bool)
      {
        localaohy.b(this.mActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
      }
      else
      {
        localaohy.a(this.mActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        continue;
        aoij.a(this.mActivity.app, localaeof.a.getJumpType(), localaeof.a.getJumpUrl(), localaeof.a.tC(), localBundle, 1);
      }
    }
  }
  
  void dUO()
  {
    new Bundle();
    Object localObject = ((TroopManager)this.mActivity.app.getManager(52)).c(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL());
    if (localObject == null) {
      return;
    }
    aohy localaohy = (aohy)this.mActivity.app.getManager(339);
    boolean bool = localaohy.e(4, 1, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL());
    localObject = aoij.a(bool, ((TroopInfo)localObject).isTroopOwner(this.mActivity.app.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL(), 0);
    if (bool) {
      localaohy.b(this.mActivity, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL(), 1, 4, 0, (Bundle)localObject);
    }
    for (;;)
    {
      anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_sing", 0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl, "", "" + apuh.o(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl)), "");
      return;
      localaohy.a(this.mActivity, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL(), 1, 4, 0, (Bundle)localObject);
    }
  }
  
  void dUP()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.oL();
        String str = URLEncoder.encode("pages/index/index?mode=qun&gid=" + (String)localObject, "UTF-8");
        str = "https://m.q.qq.com/a/p/1108291530?via=2010_1&referer=2010&s=" + str;
        str = "mqqapi://microapp/open?url=" + URLEncoder.encode(str, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.d("TogetherPopupDialog", 2, "handleMiniAIOEntry : " + str);
        }
        localTroopInfo = ((TroopManager)this.mActivity.app.getManager(52)).b((String)localObject);
        if (localTroopInfo != null) {
          continue;
        }
        bool = false;
        localObject = new EntryModel(1, Long.parseLong((String)localObject), this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTn, bool);
        MiniAppLauncher.startMiniApp(this.mActivity, str, 2010, (EntryModel)localObject, null);
      }
      catch (Exception localException)
      {
        TroopInfo localTroopInfo;
        boolean bool;
        QLog.e("TogetherPopupDialog", 1, localException, new Object[0]);
        continue;
      }
      anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_play", 0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl, "", "" + apuh.o(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.app, String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl)), "");
      return;
      bool = localTroopInfo.isAdmin();
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_Aoit$a.onDismiss();
  }
  
  @RequiresApi(api=17)
  public int getNavigationBarHeight(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getResources();
      Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 15)
      {
        localObject = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics);
        localDisplay.getRealMetrics((DisplayMetrics)localObject);
        if (localDisplayMetrics.heightPixels != ((DisplayMetrics)localObject).heightPixels) {
          return d(paramContext.getResources());
        }
      }
      else
      {
        int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
        if ((i > 0) && (((Resources)localObject).getBoolean(i)))
        {
          i = d((Resources)localObject);
          return i;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("TogetherPopupDialog", 1, paramContext, new Object[0]);
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    aohy.b localb;
    Intent localIntent;
    if (paramView.getId() == 2131363287)
    {
      localb = (aohy.b)paramView.getTag();
      if (localb != null)
      {
        if (("1".equals(localb.type)) && (!TextUtils.isEmpty(localb.url)))
        {
          localIntent = new Intent(this.mActivity, QQBrowserDelegationActivity.class);
          localIntent.putExtra("url", localb.url);
          localIntent.putExtra("fromOneCLickCLose", true);
          this.mActivity.startActivity(localIntent);
        }
      }
      else {
        aohy.a(this.mActivity.app).ac(this.mActivity.app.getCurrentUin(), 102, localb.a.iAdId.get() + "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (("2".equals(localb.type)) && (!TextUtils.isEmpty(localb.url)))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(localb.url));
        this.mActivity.startActivity(localIntent);
        break;
      }
      if ((!"3".equals(localb.type)) || (TextUtils.isEmpty(localb.url))) {
        break;
      }
      RT(localb.url);
      break;
      if (paramView.getId() == 2131380119) {
        dismiss();
      } else {
        dismiss();
      }
    }
  }
  
  public void onDestroy()
  {
    this.mActivity.app.removeObserver(this.jdField_c_of_type_Aoif);
    this.jdField_a_of_type_Aoit$a.onDestroy();
  }
  
  public void scrollToTop() {}
  
  public static class a
    extends BaseAdapter
  {
    ArrayList<aoit.a.a> Bk = new ArrayList();
    ArrayList<aoie> iM = new ArrayList(4);
    Context mContext;
    LayoutInflater mLayoutInflater;
    View.OnClickListener x;
    
    public a(Context paramContext, View.OnClickListener paramOnClickListener)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = LayoutInflater.from(paramContext);
      this.x = paramOnClickListener;
    }
    
    public int getCount()
    {
      return this.iM.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.iM.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      aoit.b localb;
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131561550, paramViewGroup, false);
        localb = new aoit.b();
        localb.a = ((RoundRectView)paramView.findViewById(2131363242));
        localb.titleView = ((TextView)paramView.findViewById(2131369532));
        localb.tD = ((TextView)paramView.findViewById(2131378922));
        localb.bM = ((URLImageView)paramView.findViewById(2131369459));
        localb.ki = ((RelativeLayout)paramView.findViewById(2131368415));
        localb.b = new aoim();
        if (localb.b.getRootView() != null)
        {
          localb.ki.removeAllViews();
          localb.ki.addView(localb.b.getRootView());
        }
        this.Bk.add(new aoiw(this, localb));
        paramView.setTag(localb);
        localb.a.setAllRadius(aqnm.dpToPx(16.0F));
        localb.a.setBgColor(((aoie)this.iM.get(paramInt)).bgColor);
        localb.a.setTag(this.iM.get(paramInt));
        localb.a.setOnClickListener(this.x);
        if (AppSetting.enableTalkBack) {
          localb.a.setContentDescription(((aoie)this.iM.get(paramInt)).title);
        }
        localb.titleView.setText(((aoie)this.iM.get(paramInt)).title);
        ((aoie)this.iM.get(paramInt)).b(aohy.a(((BaseActivity)this.mContext).app).a(((aoie)this.iM.get(paramInt)).id));
        if (!((aoie)this.iM.get(paramInt)).cLF) {
          break label523;
        }
        localb.ki.setVisibility(0);
        localb.b.setUinList(((aoie)this.iM.get(paramInt)).Bj);
        label371:
        localb.tD.setText(((aoie)this.iM.get(paramInt)).getSubTitle());
        if (TextUtils.isEmpty(((aoie)this.iM.get(paramInt)).imgUrl)) {
          break label536;
        }
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoie.a(this.mContext, (aoie)this.iM.get(paramInt));
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoie.a(this.mContext, (aoie)this.iM.get(paramInt));
        localObject = URLDrawable.getDrawable(((aoie)this.iM.get(paramInt)).imgUrl, (URLDrawable.URLDrawableOptions)localObject);
        localb.bM.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localb = (aoit.b)paramView.getTag();
        break;
        label523:
        localb.ki.setVisibility(8);
        break label371;
        label536:
        localb.bM.setImageResource(((aoie)this.iM.get(paramInt)).dOB);
      }
    }
    
    public void onDestroy()
    {
      Iterator localIterator = this.Bk.iterator();
      while (localIterator.hasNext())
      {
        aoit.a.a locala = (aoit.a.a)localIterator.next();
        if (locala != null) {
          locala.onDestroy();
        }
      }
    }
    
    public void onDismiss()
    {
      Iterator localIterator = this.Bk.iterator();
      while (localIterator.hasNext())
      {
        aoit.a.a locala = (aoit.a.a)localIterator.next();
        if (locala != null) {
          locala.onDismiss();
        }
      }
    }
    
    public void onShow()
    {
      Iterator localIterator = this.Bk.iterator();
      while (localIterator.hasNext())
      {
        aoit.a.a locala = (aoit.a.a)localIterator.next();
        if (locala != null) {
          locala.onShow();
        }
      }
    }
    
    public void setData(ArrayList<aoie> paramArrayList)
    {
      this.iM.clear();
      this.iM.addAll(paramArrayList);
      notifyDataSetChanged();
    }
    
    public static abstract interface a
    {
      public abstract void onDestroy();
      
      public abstract void onDismiss();
      
      public abstract void onShow();
    }
  }
  
  public static class b
  {
    RoundRectView a;
    aoim b;
    URLImageView bM;
    RelativeLayout ki;
    TextView tD;
    TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoit
 * JD-Core Version:    0.7.0.1
 */