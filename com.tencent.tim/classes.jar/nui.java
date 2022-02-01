import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaInitDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.d;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.e;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class nui
{
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private nui.a jdField_a_of_type_Nui$a;
  private String anN;
  private ViolaFragment c;
  private ViewGroup cd;
  
  public nui(ViolaFragment paramViolaFragment)
  {
    this.c = paramViolaFragment;
  }
  
  private ViolaBaseView.d a(JSONObject paramJSONObject)
  {
    return new ViolaBaseView.d(this.anN, paramJSONObject, fe(this.anN));
  }
  
  public static String fe(String paramString)
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
      paramString = aqhq.o("viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
      return null;
    }
    return null;
  }
  
  private void x(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this.c.getActivity(), this.c.getArguments());
    HashMap localHashMap = this.c.v();
    if (localHashMap.containsKey(nuk.aob)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setBorderRadius(((Integer)localHashMap.get(nuk.aob)).intValue());
    }
    if (localHashMap.containsKey(nuk.aoc)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentMarginTop(((Integer)localHashMap.get(nuk.aoc)).intValue());
    }
    if (localHashMap.containsKey(nuk.aoi)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setTitleBarHeight(((Integer)localHashMap.get(nuk.aoi)).intValue());
    }
    if (localHashMap.containsKey(nuk.aod)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsShowGrayBar(((Boolean)localHashMap.get(nuk.aod)).booleanValue());
    }
    if (localHashMap.containsKey(nuk.aof)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedShowBackView(((Boolean)localHashMap.get(nuk.aof)).booleanValue());
    }
    if (localHashMap.containsKey(nuk.aoe)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(((Boolean)localHashMap.get(nuk.aoe)).booleanValue());
    }
    if (localHashMap.containsKey(nuk.aog)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(((Boolean)localHashMap.get(nuk.aog)).booleanValue());
    }
    if (localHashMap.containsKey(nuk.aom)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContainerColor(Color.parseColor((String)localHashMap.get(nuk.aom)));
    }
    if (localHashMap.containsKey(nuk.anX)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(((Boolean)localHashMap.get(nuk.anX)).booleanValue());
    }
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131381997);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new nuj(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this.c.getActivity(), -1, -1, true);
  }
  
  public boolean Gi()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gi();
    }
    return false;
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  }
  
  public void a(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, ViolaBaseView.e parame)
  {
    this.cd = ((ViewGroup)paramViewGroup.findViewById(2131381996));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(this.c.getActivity());
    if (!paramBoolean) {
      this.cd.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(parame);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.anN, this.c, a(paramJSONObject));
  }
  
  public void a(ViolaBaseView.e parame)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b(parame);
  }
  
  public void a(nui.a parama)
  {
    this.jdField_a_of_type_Nui$a = parama;
  }
  
  public void aL(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.anN = paramBundle.getString("url");
    }
  }
  
  public void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.Gc()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.Gd())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.dr(0, 4);
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.Gc()) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.bbl();
      this.c.getActivity().doOnBackPressed();
    } while (!paramBoolean);
    this.c.getActivity().overridePendingTransition(2130772288, 2130772291);
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.dr(0, 4);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.doOnBackPressed();
    }
  }
  
  public String kN()
  {
    return this.anN;
  }
  
  public void oE(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.updateInstance(paramString);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
    throws Exception
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      qg(false);
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      qg(true);
    }
  }
  
  public void qg(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gm())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.qg(paramBoolean);
    }
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setCanCloseFromBottom(paramBoolean);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      qg(true);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startSession", 1);
      oE(localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("ViolaInitDelegate", 1, "setUserVisibleHint Exception " + localException.getMessage());
    }
    qg(false);
    return;
  }
  
  public void w(ViewGroup paramViewGroup)
  {
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setLayerType(2, null);
    x(paramViewGroup);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInitDelegate.1(this), 150L);
  }
  
  public static abstract interface a
  {
    public abstract void mT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */