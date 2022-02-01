import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class lav
  extends lar<String, DynamicChannelDataModel>
{
  public final String TAG = "ReadInJoyCGIDynamicChannelAdapter";
  private lau a = new lau();
  
  public lav(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.a.a(this.mVafContext, 0);
  }
  
  public auwn a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a.dx(paramInt))
    {
      Object localObject = (String)this.ee.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = laq.a(this.mVafContext, getServiceId(), (String)localObject);
        if ((paramInt == lao.aMQ) && (paramViewGroup != null)) {
          paramViewGroup.setVisibility(8);
        }
        QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID = ", localObject });
        localObject = paramViewGroup;
        if (paramViewGroup == null)
        {
          localObject = new ProteusItemView(this.mVafContext.getContext());
          QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "proteusItemView is null");
        }
        return new lav.a((View)localObject);
      }
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
    }
    for (;;)
    {
      paramViewGroup = null;
      break;
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder not the right type");
    }
  }
  
  public void a(auwn paramauwn, int paramInt)
  {
    DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)g(paramInt);
    int i = paramauwn.getItemViewType();
    ProteusItemView localProteusItemView = (ProteusItemView)paramauwn.itemView;
    if (localDynamicChannelDataModel != null)
    {
      if (!this.a.dx(i)) {
        break label156;
      }
      if (i != lao.aMQ) {
        break label136;
      }
      localProteusItemView.setVisibility(8);
    }
    for (;;)
    {
      c(localDynamicChannelDataModel.uniqueID, localDynamicChannelDataModel);
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, dataModel = ", localDynamicChannelDataModel, ", proteusItemView = ", localProteusItemView, " , position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
      EventCollector.getInstance().onRecyclerBindViewHolder(paramauwn, paramInt, getItemId(paramInt));
      return;
      label136:
      this.a.a(localProteusItemView, i, localDynamicChannelDataModel, this.mVafContext, paramInt);
      continue;
      label156:
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
    }
  }
  
  public long cs()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.mData != null)
    {
      l1 = l2;
      if (this.mData.size() > 0)
      {
        Iterator localIterator = this.mData.iterator();
        l1 = -1L;
        if (localIterator.hasNext())
        {
          DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)localIterator.next();
          if (localDynamicChannelDataModel.recommendSeq <= l1) {
            break label85;
          }
          l1 = localDynamicChannelDataModel.recommendSeq;
        }
      }
    }
    label85:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = (DynamicChannelDataModel)g(paramInt);
    int i = lao.aMQ;
    paramInt = i;
    if (localObject != null)
    {
      paramInt = i;
      if (this.a.a((DynamicChannelDataModel)localObject))
      {
        i = this.a.a((DynamicChannelDataModel)localObject);
        localObject = ((DynamicChannelDataModel)localObject).styleID;
        paramInt = i;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.ee.put(Integer.valueOf(i), localObject);
          paramInt = i;
        }
      }
    }
    return paramInt;
  }
  
  class a
    extends auwn
  {
    a(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lav
 * JD-Core Version:    0.7.0.1
 */