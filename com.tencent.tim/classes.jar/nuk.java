import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate.2;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.HashMap;
import java.util.Map;

public class nuk
{
  public static String anO = "title_name";
  public static String anP = "title_hide";
  public static String anQ = "title_nav_background_color";
  public static String anR = "title_nav_text_color";
  public static String anS = "title_nav_center_text_color";
  public static String anT = "title_nav_alpha";
  public static String anU = "title_status_bar_color";
  public static String anV = "title_status_color";
  public static String anW = "title_status_font_color";
  public static String anX = "title_status_immersive";
  public static String anY = "title_full_screen";
  public static String anZ = "title_hide_nav_bar";
  public static String aoa = "title_suspension";
  public static String aob = "title_border_radius";
  public static String aoc = "title_margin_top";
  public static String aod = "title_default_gray_bar";
  public static String aoe = "title_default_pop_anim";
  public static String aof = "title_default_back_bar";
  public static String aog = "title_default_auto_top";
  public static String aoh = "title_default_interrupt_back";
  public static String aoi = "title_default_title_height";
  public static String aoj = "bundle_is_splash_activity";
  public static String aok = "bundle_is_suspension_anyplace";
  public static String aol = "bundle_is_bid_anyplace";
  public static String aom = "title_content_color";
  public static String aon = "title_status_visiable";
  public static String aoo = "content_full_screen";
  public static String aop = "statusBarStyle=2";
  public static String aoq = "v_content_full=1";
  private boolean VU;
  private int ZY;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private ReadInJoyChannelActivity.SerializableMap jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private nuk.a jdField_a_of_type_Nuk$a;
  private FrameLayout au;
  private boolean auN;
  private boolean auO;
  private boolean auP = true;
  private boolean auQ = true;
  private boolean auR;
  private boolean auS;
  private boolean auT;
  private int bcJ = -1;
  private ViolaFragment d;
  private LinearLayout et;
  private HashMap ex = new HashMap();
  private ImageView id;
  private View jH;
  private arju mProgressBarController;
  private TextView oa;
  
  public nuk(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public nuk(ViolaFragment paramViolaFragment)
  {
    this.d = paramViolaFragment;
  }
  
  private void A(ViewGroup paramViewGroup)
  {
    this.et = ((LinearLayout)paramViewGroup.findViewById(2131374329));
    this.et.setVisibility(0);
  }
  
  private boolean Gk()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof ReadInJoyViolaChannelFragment)) {}
    while ((ReadinjoyTabFrame.Dx()) && (this.auR)) {
      return true;
    }
    return false;
  }
  
  private void bbA()
  {
    if ((this.et != null) && (this.et.getVisibility() != 8)) {
      this.et.setVisibility(8);
    }
  }
  
  private void bbx()
  {
    if (this.jdField_a_of_type_Nuk$a == null) {
      this.jdField_a_of_type_Nuk$a = new num(this);
    }
  }
  
  private void bbz()
  {
    if ((this.et != null) && (this.et.getVisibility() != 0)) {
      this.et.setVisibility(0);
    }
  }
  
  private Activity getActivity()
  {
    if (this.d != null) {
      return this.d.getActivity();
    }
    return this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
  }
  
  private static HashMap<String, Object> i(String paramString)
  {
    boolean bool2 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = new HashMap();
      String str = anP;
      int i;
      if (paramString.contains("hideNav=1"))
      {
        i = 1;
        localHashMap.put(str, Integer.valueOf(i));
        localHashMap.put(anV, Boolean.valueOf(paramString.contains("statusColor=1")));
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_nav_bgclr"))) {
          localHashMap.put(anQ, ntp.Y(paramString, "v_nav_bgclr"));
        }
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_nav_txtclr"))) {
          localHashMap.put(anR, ntp.Y(paramString, "v_nav_txtclr"));
        }
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_nav_titleclr"))) {
          localHashMap.put(anS, ntp.Y(paramString, "v_nav_titleclr"));
        }
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_nav_alpha"))) {
          localHashMap.put(anT, ntp.Y(paramString, "v_nav_alpha"));
        }
        localHashMap.put(anW, Boolean.valueOf(paramString.contains("statusBarStyle=1")));
        if (!TextUtils.isEmpty(ntp.Y(paramString, "statusBarColor"))) {
          localHashMap.put(anU, ntp.Y(paramString, "statusBarColor"));
        }
        localHashMap.put(anX, Boolean.valueOf(paramString.contains("v_nav_immer=1")));
        localHashMap.put(anY, Boolean.valueOf(paramString.contains("v_full_screen=1")));
        localHashMap.put(anZ, Boolean.valueOf(paramString.contains("v_hide_nav=1")));
        str = aoa;
        if ((!paramString.contains("v_present=2")) && (!paramString.contains("v_present=1"))) {
          break label696;
        }
        bool1 = true;
        label314:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_present_radius"))) {
          localHashMap.put(aob, ntp.Y(paramString, "v_present_radius"));
        }
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_present_top"))) {
          localHashMap.put(aoc, ntp.Y(paramString, "v_present_top"));
        }
        if (!TextUtils.isEmpty(ntp.Y(paramString, "v_present_titleHeight"))) {
          localHashMap.put(aoi, ntp.Y(paramString, "v_present_titleHeight"));
        }
        localHashMap.put(aoj, Boolean.valueOf(paramString.contains("from_splash_activity=1")));
        localHashMap.put(aok, Boolean.valueOf(paramString.contains("v_present=2")));
        localHashMap.put(aol, Boolean.valueOf(paramString.contains("&v_bid_apply_anywhere=0")));
        str = aod;
        if (paramString.contains("v_present_bar=0")) {
          break label701;
        }
        bool1 = true;
        label487:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = aoe;
        if (paramString.contains("v_present_pop=0")) {
          break label706;
        }
      }
      label696:
      label701:
      label706:
      for (boolean bool1 = true;; bool1 = false)
      {
        localHashMap.put(str, Boolean.valueOf(bool1));
        localHashMap.put(aof, Boolean.valueOf(paramString.contains("v_present_back_bar=1")));
        str = aog;
        bool1 = bool2;
        if (!paramString.contains("v_present_auto_top=0")) {
          bool1 = true;
        }
        localHashMap.put(str, Boolean.valueOf(bool1));
        localHashMap.put(aoh, Boolean.valueOf(paramString.contains("v_present_interrupt_back=1")));
        if (paramString.contains("v_bg_color")) {
          localHashMap.put(aom, "#" + ntp.Y(paramString, "v_bg_color"));
        }
        if (paramString.contains(aop)) {
          localHashMap.put(aon, Boolean.valueOf(true));
        }
        if (paramString.contains(aoq)) {
          localHashMap.put(aoo, Boolean.valueOf(true));
        }
        return localHashMap;
        i = 0;
        break;
        bool1 = false;
        break label314;
        bool1 = false;
        break label487;
      }
    }
    return null;
  }
  
  public boolean Gh()
  {
    return (this.auP) && ((Gk()) || (this.auS)) && (!this.auT);
  }
  
  public boolean Gj()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jH != null)
    {
      bool1 = bool2;
      if (this.jH.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void L(boolean paramBoolean)
  {
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && (getActivity() != null))
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      localObject = null;
      i = 0;
      if (i >= localViewGroup.getChildCount()) {
        break label120;
      }
      View localView = localViewGroup.getChildAt(i);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if (!(localObject instanceof TopGestureLayout)) {
        break label113;
      }
    }
    label113:
    label120:
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public nuk.a a()
  {
    return this.jdField_a_of_type_Nuk$a;
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if (!Gh())
    {
      this.au = ((FrameLayout)paramViewGroup.findViewById(2131381997));
      if (this.au.getVisibility() != 0) {
        this.au.setVisibility(0);
      }
    }
    if (this.jH == null)
    {
      this.jH = ((ViewStub)paramViewGroup.findViewById(2131381998)).inflate();
      if (this.bcJ != -1) {
        this.jH.setBackgroundColor(this.bcJ);
      }
      this.oa = ((TextView)this.jH.findViewById(2131376708));
      this.id = ((ImageView)this.jH.findViewById(2131376707));
    }
    this.oa.setText(paramViewGroup.getResources().getString(2131718494));
    this.jH.setOnClickListener(paramOnClickListener);
    if (this.bcJ == -1) {
      this.id.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839516));
    }
    for (;;)
    {
      this.oa.setTextColor(paramViewGroup.getResources().getColor(2131167155));
      ((LinearLayout.LayoutParams)this.oa.getLayoutParams()).topMargin = wja.dp2px(10.0F, paramViewGroup.getResources());
      return;
      this.id.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839733));
    }
  }
  
  public void a(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      L(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(paramOnGestureListener);
    }
  }
  
  public void aM(Bundle paramBundle)
  {
    boolean bool2 = true;
    if (paramBundle != null)
    {
      if (paramBundle.getInt(anP, 0) != 1) {
        break label401;
      }
      bool1 = true;
      this.auN = bool1;
      if (this.auN) {
        this.d.hideTitleBar();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap = ((ReadInJoyChannelActivity.SerializableMap)paramBundle.getSerializable(ViolaFragment.anG));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap != null) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(anP)) {
          if (((Integer)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anP)).intValue() != 1) {
            break label406;
          }
        }
      }
    }
    label401:
    label406:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.auN = bool1;
      if (this.auN) {
        this.d.hideTitleBar();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(anV))
      {
        this.auO = ((Boolean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anV)).booleanValue();
        if (this.auO) {
          this.d.oI("#ffffff");
        }
      }
      if (!this.auN)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(anQ))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anQ);
          this.d.oK(paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(anR))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anR);
          this.d.oL(paramBundle);
          this.d.oN(paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(anS))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anS);
          this.d.oM(paramBundle);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(anT)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anT) != null))
        {
          paramBundle = (Float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(anT);
          this.d.X(paramBundle.floatValue());
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void b(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    String str;
    Object localObject;
    boolean bool;
    if (paramHashMap != null)
    {
      if (paramHashMap.containsKey(anX))
      {
        this.VU = ((Boolean)paramHashMap.get(anX)).booleanValue();
        if (this.VU)
        {
          this.d.bcg();
          if ((paramHashMap.containsKey(anZ)) && (((Boolean)paramHashMap.get(anZ)).booleanValue())) {
            this.d.bcl();
          }
        }
      }
      if (!this.VU)
      {
        if (paramHashMap.containsKey(anV))
        {
          this.auO = ((Boolean)paramHashMap.get(anV)).booleanValue();
          if (this.auO) {
            this.d.oI("#ffffff");
          }
        }
        if (paramHashMap.containsKey(anU))
        {
          str = (String)paramHashMap.get(anU);
          if (!str.startsWith("0x")) {
            break label861;
          }
          localObject = str.replace("0x", "#");
          this.d.oI((String)localObject);
        }
      }
      if ((paramHashMap.containsKey(anY)) && (((Boolean)paramHashMap.get(anY)).booleanValue())) {
        this.d.bck();
      }
      if (paramHashMap.containsKey(anW))
      {
        localObject = (Boolean)paramHashMap.get(anW);
        this.d.h((Boolean)localObject);
      }
      if (paramHashMap.containsKey(anP))
      {
        if (((Integer)paramHashMap.get(anP)).intValue() != 1) {
          break label892;
        }
        bool = true;
        label278:
        this.auN = bool;
      }
      if (!this.auN) {
        break label898;
      }
      this.d.hideTitleBar();
    }
    for (;;)
    {
      bbx();
      if (paramHashMap.containsKey(aoa)) {
        this.auP = ((Boolean)paramHashMap.get(aoa)).booleanValue();
      }
      int i;
      if ((paramHashMap.containsKey(aob)) && (paramViewGroup != null))
      {
        i = Integer.valueOf((String)paramHashMap.get(aob)).intValue();
        this.ex.put(aob, Integer.valueOf(i));
      }
      if ((paramHashMap.containsKey(aoi)) && (paramViewGroup != null))
      {
        i = Integer.valueOf((String)paramHashMap.get(aoi)).intValue();
        this.ex.put(aoi, Integer.valueOf(i));
      }
      if ((paramHashMap.containsKey(aoc)) && (paramViewGroup != null))
      {
        i = Integer.valueOf((String)paramHashMap.get(aoc)).intValue();
        this.ZY = wja.dp2px(i, paramViewGroup.getResources());
        this.ex.put(aoc, Integer.valueOf(i));
      }
      if (paramHashMap.containsKey(aod)) {
        this.ex.put(aod, paramHashMap.get(aod));
      }
      if (paramHashMap.containsKey(aoe)) {
        this.ex.put(aoe, paramHashMap.get(aoe));
      }
      if (paramHashMap.containsKey(aof)) {
        this.ex.put(aof, paramHashMap.get(aof));
      }
      if (paramHashMap.containsKey(anX)) {
        this.ex.put(anX, paramHashMap.get(anX));
      }
      if (paramHashMap.containsKey(aog)) {
        this.ex.put(aog, paramHashMap.get(aog));
      }
      if (paramHashMap.containsKey(aoh)) {
        this.ex.put(aoh, paramHashMap.get(aoh));
      }
      if (paramHashMap.containsKey(aom))
      {
        this.ex.put(aom, paramHashMap.get(aom));
        this.bcJ = Color.parseColor((String)paramHashMap.get(aom));
      }
      if (paramHashMap.containsKey(aoj)) {
        this.auR = ((Boolean)paramHashMap.get(aoj)).booleanValue();
      }
      if (paramHashMap.containsKey(aok)) {
        this.auS = ((Boolean)paramHashMap.get(aok)).booleanValue();
      }
      if (paramHashMap.containsKey(aol)) {
        this.auT = ((Boolean)paramHashMap.get(aol)).booleanValue();
      }
      if (Gh()) {
        this.d.h(Boolean.valueOf(true));
      }
      if (paramHashMap.containsKey(aom)) {
        this.d.oP((String)paramHashMap.get(aom));
      }
      if (paramHashMap.containsKey(aon)) {
        this.d.bci();
      }
      if (paramHashMap.containsKey(aoo)) {
        this.d.bcm();
      }
      this.d.bbu();
      return;
      label861:
      localObject = str;
      if (!str.startsWith("0X")) {
        break;
      }
      localObject = str.replace("0X", "#");
      break;
      label892:
      bool = false;
      break label278;
      label898:
      if (paramHashMap.containsKey(anQ))
      {
        localObject = (String)paramHashMap.get(anQ);
        this.d.oK((String)localObject);
      }
      if (paramHashMap.containsKey(anR))
      {
        localObject = (String)paramHashMap.get(anR);
        this.d.oL((String)localObject);
        this.d.oN((String)localObject);
      }
      if (paramHashMap.containsKey(anS))
      {
        localObject = (String)paramHashMap.get(anS);
        this.d.oM((String)localObject);
      }
      if ((paramHashMap.containsKey(anT)) && (paramHashMap.get(anT) != null))
      {
        localObject = (String)paramHashMap.get(anT);
        this.d.X(Float.valueOf((String)localObject).floatValue());
      }
      this.d.bcj();
    }
  }
  
  public void bbB()
  {
    if ((Gh()) && (this.auQ)) {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaUiDelegate.2(this), 350L);
    }
    while (this.jH == null) {
      return;
    }
    this.jH.setVisibility(0);
  }
  
  public void bbC()
  {
    if (this.jH != null) {
      this.jH.setVisibility(8);
    }
  }
  
  public void bby()
  {
    if (Gh()) {
      bbz();
    }
    while ((this.mProgressBarController == null) || (this.mProgressBarController.getCurStatus() == 0)) {
      return;
    }
    this.mProgressBarController.enterStatus((byte)0);
  }
  
  public void hideProgressBar()
  {
    if (Gh()) {
      bbA();
    }
    while ((this.mProgressBarController == null) || (this.mProgressBarController.getCurStatus() == 2)) {
      return;
    }
    this.mProgressBarController.enterStatus((byte)2);
  }
  
  public int qY()
  {
    return this.ZY;
  }
  
  public HashMap w()
  {
    return this.ex;
  }
  
  public void w(ViewGroup paramViewGroup)
  {
    if (Gh())
    {
      this.au = ((FrameLayout)paramViewGroup.findViewById(2131381997));
      if (this.au.getVisibility() != 0) {
        this.au.setVisibility(0);
      }
      L(true);
    }
  }
  
  public void y(ViewGroup paramViewGroup)
  {
    b(i(this.d.getUrl()), paramViewGroup);
  }
  
  public void z(ViewGroup paramViewGroup)
  {
    if (Gh()) {
      A(paramViewGroup);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = new WebViewProgressBar(paramViewGroup.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setId(2131373669);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.mProgressBarController = new arju();
      this.mProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.mProgressBarController);
    } while ((nwl.el(this.d.getUrl())) && (affn.ajd()) && (affo.ajd()));
    bby();
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, View.OnClickListener paramOnClickListener);
    
    public abstract void c(String paramString, View.OnClickListener paramOnClickListener);
    
    public abstract void qh(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nuk
 * JD-Core Version:    0.7.0.1
 */