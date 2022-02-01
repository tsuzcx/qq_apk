package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import laq;
import lav;
import law;
import lax;
import lbe;
import lbf;
import lbg;
import lbk;
import lbm;

public class ReadInJoyCGIDynamicChannelFragment
  extends ReadInJoyDynamicChannelBaseFragment
{
  private XRecyclerView.a jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a = new lax(this);
  private lbf jdField_a_of_type_Lbf = new law(this);
  private lav b;
  
  public static ReadInJoyCGIDynamicChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoyCGIDynamicChannelFragment localReadInJoyCGIDynamicChannelFragment = new ReadInJoyCGIDynamicChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoyCGIDynamicChannelFragment.setArguments(localBundle);
    return localReadInJoyCGIDynamicChannelFragment;
  }
  
  private void b(ConcurrentHashMap<String, DynamicChannelDataModel> paramConcurrentHashMap)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyCGIDynamicChannelFragment.3(this, paramConcurrentHashMap));
  }
  
  private void n(int paramInt, List<lbm> paramList)
  {
    if (paramInt != this.mChannelID) {}
    for (;;)
    {
      return;
      aIs();
      if ((paramList != null) && (paramList.size() != 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          lbm locallbm = (lbm)paramList.next();
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "channelID = ", Integer.valueOf(paramInt), ", styleID = ", locallbm.styleID, ", proteusData = ", locallbm.proteusData });
          if ((!TextUtils.isEmpty(locallbm.styleID)) && (!TextUtils.isEmpty(locallbm.proteusData)))
          {
            ProteusItemView localProteusItemView = laq.a(this.b.getVafContext(), getServiceId(), laq.d(locallbm.proteusData));
            laq.a(localProteusItemView, this.b.getVafContext(), getServiceId(), locallbm.proteusData);
            co(localProteusItemView);
          }
        }
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = lbk.a();
    if (localObject != null)
    {
      localObject = ((lbk)localObject).q(this.mChannelID);
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (lbm)((List)localObject).get(paramInt);
        paramViewHolder = (ProteusItemView)paramViewHolder.itemView;
        if ((localObject != null) && (paramViewHolder != null)) {
          laq.a(paramViewHolder, this.b.getVafContext(), getServiceId(), ((lbm)localObject).proteusData);
        }
      }
    }
  }
  
  public void aCe()
  {
    super.aCe();
    if (this.b != null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "reportExposureAndClear, mChannelID = ", Integer.valueOf(this.mChannelID) });
      b(this.b.e());
      this.b.aIo();
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "mAdapter is null.");
  }
  
  public void aIn()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a);
  }
  
  public void ie()
  {
    if (!this.aeK)
    {
      this.aeK = true;
      Object localObject = lbg.a();
      if (localObject != null) {
        ((lbg)localObject).cB(this.mChannelID, 10);
      }
      localObject = lbk.a();
      if (localObject != null)
      {
        ((lbk)localObject).qg(this.mChannelID);
        n(this.mChannelID, ((lbk)localObject).q(this.mChannelID));
        ((lbk)localObject).qh(this.mChannelID);
      }
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "has loaded data, mChannelID = ", Integer.valueOf(this.mChannelID) });
  }
  
  public void initAdapter()
  {
    this.b = new lav(getActivity(), this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(), this.mChannelID);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setAdapter(this.b);
  }
  
  public void notifyDataSetChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    lbe.a().a(this.jdField_a_of_type_Lbf);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    lbe.a().b(this.jdField_a_of_type_Lbf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment
 * JD-Core Version:    0.7.0.1
 */