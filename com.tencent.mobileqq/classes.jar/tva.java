import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaInitDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class tva
{
  private int jdField_a_of_type_Int;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ViolaBaseView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private tvf jdField_a_of_type_Tvf;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public tva(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = paramViolaFragment;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Uri.parse(paramString).getQueryParameter("_ckey");
    if (!TextUtils.isEmpty(paramString))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null) {
        return null;
      }
      paramString = FileUtils.readObject("viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
      return null;
    }
    return null;
  }
  
  private ucp a(JSONObject paramJSONObject)
  {
    return new ucp(this.jdField_a_of_type_JavaLangString, paramJSONObject, a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString);
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getArguments());
    HashMap localHashMap = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getSusConfigMap();
    if (localHashMap.containsKey(tvg.n)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setBorderRadius(((Integer)localHashMap.get(tvg.n)).intValue());
    }
    if (localHashMap.containsKey(tvg.o)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentMarginTop(((Integer)localHashMap.get(tvg.o)).intValue());
    }
    if (localHashMap.containsKey(tvg.u)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setTitleBarHeight(((Integer)localHashMap.get(tvg.u)).intValue());
    }
    if (localHashMap.containsKey(tvg.p)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsShowGrayBar(((Boolean)localHashMap.get(tvg.p)).booleanValue());
    }
    if (localHashMap.containsKey(tvg.r)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedShowBackView(((Boolean)localHashMap.get(tvg.r)).booleanValue());
    }
    if (localHashMap.containsKey(tvg.q)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(((Boolean)localHashMap.get(tvg.q)).booleanValue());
    }
    if (localHashMap.containsKey(tvg.s)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(((Boolean)localHashMap.get(tvg.s)).booleanValue());
    }
    if (localHashMap.containsKey(tvg.y)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContainerColor(Color.parseColor((String)localHashMap.get(tvg.y)));
    }
    if (localHashMap.containsKey(tvg.j)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(((Boolean)localHashMap.get(tvg.j)).booleanValue());
    }
    if (localHashMap.containsKey(tvg.B)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedChangeTitleAlpha(((Boolean)localHashMap.get(tvg.B)).booleanValue());
    }
    if (localHashMap.containsKey(tvg.C)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedGrayBarFloat(((Boolean)localHashMap.get(tvg.C)).booleanValue());
    }
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131381218);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new tve(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), -1, -1, true);
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  }
  
  public ViolaBaseView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("url");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("colorBallData");
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setLayerType(2, null);
    b(paramViewGroup);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInitDelegate.1(this), 150L);
  }
  
  public void a(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, ucq paramucq)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131381217));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(paramucq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, a(paramJSONObject));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity().doOnBackPressed();
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity().overridePendingTransition(2130772221, 2130772224);
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, String paramString) {}
  
  public void a(String paramString)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString).equals(ViolaUtils.getPageName(paramString))) {}
    }
    for (paramString = (ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i);; paramString = null)
    {
      if (paramString != null) {
        paramString.a(tzr.c().toString());
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str;
    int j;
    int i;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("url"))))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(true);
      }
      str = paramJSONObject.optString("url");
      j = paramJSONObject.optInt("position", 0);
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label272;
      }
      if (!ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString).equals(ViolaUtils.getPageName(str))) {
        break label141;
      }
    }
    label141:
    label272:
    for (Object localObject = (ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i);; localObject = null)
    {
      if (localObject != null)
      {
        if (j != this.jdField_b_of_type_Int)
        {
          ((ViolaBaseView)localObject).a(tzr.a(paramJSONObject).toString());
          this.jdField_b_of_type_Int = j;
          this.c = str;
        }
        return;
        i += 1;
        break;
      }
      paramJSONObject = new ViolaBaseView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), Boolean.valueOf(true));
      paramJSONObject.setListener(new tvd(this));
      localObject = str + "&firstCreated=1";
      paramJSONObject.setPageStartTime(System.currentTimeMillis());
      paramJSONObject.a((String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, new ucp((String)localObject, new JSONObject(), a((String)localObject), 0, null));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramJSONObject);
      if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
      }
      this.c = ((String)localObject);
      return;
    }
  }
  
  public void a(tvf paramtvf)
  {
    this.jdField_a_of_type_Tvf = paramtvf;
  }
  
  public void a(ucq paramucq)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramucq);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      b(true);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startSession", 1);
      b(localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("ViolaInitDelegate", 1, "setUserVisibleHint Exception " + localException.getMessage());
    }
    b(false);
    return;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null;
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = new ViewPagerCompat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new tvb(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new tvc(this));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      b(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setCanCloseFromBottom(paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      b(false);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) instanceof ViolaBaseView)) {
        ((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroy();
      }
      i += 1;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem();
      if (i >= 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(i - 1);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity().doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tva
 * JD-Core Version:    0.7.0.1
 */