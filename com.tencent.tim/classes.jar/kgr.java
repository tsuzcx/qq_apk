import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class kgr
{
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private npi jdField_a_of_type_Npi;
  private JSONObject mData;
  private FrameLayout mRootView;
  private TemplateBean mTemplateBean;
  private VafContext mVafContext = new VafContext();
  
  public kgr(Activity paramActivity, FrameLayout paramFrameLayout)
  {
    this.mVafContext.setContext(paramActivity);
    this.mVafContext.setCurActivity(paramActivity);
    this.jdField_a_of_type_Npi = npi.a("default_feeds", true);
    kvx.a(this.mVafContext, "default_feeds");
    this.mVafContext.setTemplateFactory(this.jdField_a_of_type_Npi);
    this.mRootView = paramFrameLayout;
    aCH();
  }
  
  private void aCH()
  {
    try
    {
      String str = (String)awit.f("readinjoy_follow_subscribed_list_data_key", "");
      if (!TextUtils.isEmpty(str)) {
        M(new JSONObject(str));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void M(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (this.mRootView == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Npi != null)
        {
          localTemplateBean = this.jdField_a_of_type_Npi.getTemplateBean(paramJSONObject);
          if (localTemplateBean == null)
          {
            QLog.d("SubscribedListHeaderController", 1, "templateBean is null");
            return;
          }
          if (this.mData == null)
          {
            Container localContainer = this.mVafContext.getViewFactory().inflate(this.mVafContext, localTemplateBean);
            if (localContainer == null) {
              break;
            }
            localContainer.setBackgroundResource(2130842544);
            this.mRootView.addView(localContainer, -1, -1);
            this.mRootView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = localContainer;
          }
          kvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.mVafContext, localTemplateBean);
          ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new kgs(this, localTemplateBean));
          kvx.bindDynamicValueWithoutRecursion(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.mTemplateBean, localTemplateBean);
          this.mData = paramJSONObject;
          this.mTemplateBean = localTemplateBean;
          kvx.a(localTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), "expose_T");
          QLog.d("SubscribedListHeaderController", 1, "update subscribed list data : " + this.mData);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        return;
      }
      TemplateBean localTemplateBean = null;
    }
  }
  
  public boolean isVisible()
  {
    return this.mRootView.getVisibility() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgr
 * JD-Core Version:    0.7.0.1
 */