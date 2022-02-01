import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class lau
  extends lao<DynamicChannelDataModel>
{
  public int a(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    if (paramDynamicChannelDataModel == null) {
      return aMQ;
    }
    paramDynamicChannelDataModel = (Integer)this.ed.get(paramDynamicChannelDataModel.styleID);
    if (paramDynamicChannelDataModel == null)
    {
      QLog.d("DynamicItemViewHelperCompatCGI", 2, "getType, type is null");
      return aMQ;
    }
    if ((paramDynamicChannelDataModel.intValue() < aMQ) || (paramDynamicChannelDataModel.intValue() >= this.aLq))
    {
      QLog.d("DynamicItemViewHelperCompatCGI", 2, "getType, type is out of range");
      return aMQ;
    }
    return paramDynamicChannelDataModel.intValue();
  }
  
  protected TemplateBean a(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    if (paramDynamicChannelDataModel == null)
    {
      QLog.d("DynamicItemViewHelperCompatCGI", 1, "getTemplateBean, data is null.");
      return null;
    }
    QLog.d("DynamicItemViewHelperCompatCGI", 2, new Object[] { "styleID = ", paramDynamicChannelDataModel.styleID, ", channelID = ", Integer.valueOf(paramDynamicChannelDataModel.channelID) });
    if ((paramDynamicChannelDataModel.mTemplateBean != null) && (!((npi)this.c.getTemplateFactory()).a(paramDynamicChannelDataModel.mTemplateBean))) {
      return paramDynamicChannelDataModel.mTemplateBean;
    }
    JSONObject localJSONObject;
    TemplateBean localTemplateBean;
    if (!TextUtils.isEmpty(paramDynamicChannelDataModel.proteusData))
    {
      localJSONObject = laq.d(paramDynamicChannelDataModel.proteusData);
      localTemplateBean = laq.a(this.c, localJSONObject, ReadInJoyDynamicChannelBaseFragment.bl(paramDynamicChannelDataModel.channelID));
      paramDynamicChannelDataModel.mTemplateBean = localTemplateBean;
      paramDynamicChannelDataModel = localTemplateBean;
      if (localTemplateBean != null)
      {
        paramDynamicChannelDataModel = localTemplateBean;
        if (localTemplateBean.getViewBean() != null)
        {
          paramDynamicChannelDataModel = localTemplateBean;
          if (localJSONObject != null)
          {
            paramDynamicChannelDataModel = localTemplateBean;
            if (!localJSONObject.has("report_feeds_type")) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localTemplateBean.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
        paramDynamicChannelDataModel = localTemplateBean;
      }
      catch (JSONException paramDynamicChannelDataModel)
      {
        QLog.d("DynamicItemViewHelperCompatCGI", 1, new Object[] { "getTemplateBean exception, ", paramDynamicChannelDataModel.toString() });
        paramDynamicChannelDataModel = localTemplateBean;
        continue;
      }
      return paramDynamicChannelDataModel;
      paramDynamicChannelDataModel = null;
    }
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, DynamicChannelDataModel paramDynamicChannelDataModel, VafContext paramVafContext, int paramInt2)
  {
    auvk.traceBegin("bindData");
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      auvk.traceEnd();
      if (QLog.isColorLevel()) {
        QLog.d("DynamicItemViewHelperCompatCGI", 2, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1) });
      }
      if (paramProteusItemView != null) {
        paramProteusItemView.setVisibility(8);
      }
      return;
    }
    if (paramInt1 == aMQ)
    {
      paramProteusItemView.setVisibility(8);
      return;
    }
    QLog.d("DynamicItemViewHelperCompatCGI", 1, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1), ", data = ", paramDynamicChannelDataModel });
    Object localObject = paramProteusItemView.getTemplateBean();
    TemplateBean localTemplateBean = a(paramDynamicChannelDataModel);
    paramDynamicChannelDataModel = (DynamicChannelDataModel)localObject;
    if (localObject != null)
    {
      paramDynamicChannelDataModel = (DynamicChannelDataModel)localObject;
      if (localTemplateBean != null)
      {
        paramDynamicChannelDataModel = (DynamicChannelDataModel)localObject;
        if (!localTemplateBean.equals(localObject))
        {
          paramDynamicChannelDataModel = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
          if (paramDynamicChannelDataModel != null)
          {
            paramDynamicChannelDataModel.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842544));
            paramProteusItemView.aMU();
            paramProteusItemView.e(paramDynamicChannelDataModel);
          }
          paramDynamicChannelDataModel = null;
        }
      }
    }
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    if (localTemplateBean != null) {
      kvx.bindDynamicValueWithoutRecursion((Container)localObject, paramDynamicChannelDataModel, localTemplateBean);
    }
    kvx.a((Container)localObject, paramVafContext, localTemplateBean);
    auvk.traceEnd();
  }
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    super.a(paramVafContext, paramInt);
  }
  
  public boolean a(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    return (paramDynamicChannelDataModel != null) && (!TextUtils.isEmpty(paramDynamicChannelDataModel.styleID));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lau
 * JD-Core Version:    0.7.0.1
 */