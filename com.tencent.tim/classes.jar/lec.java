import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.6.1;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.c;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.f;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.i;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lec
  implements ReadInJoyPicWaterFallFragment.f
{
  public lec(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public boolean BY()
  {
    return this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.getItemCount() == 0;
  }
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean)
  {
    Map localMap = odv.a(this.this$0.nh());
    String str = kxm.bf(this.this$0.nh());
    ThreadManager.post(new ReadInJoyPicWaterFallFragment.6.1(this, this.this$0.zl(), paramMap, paramBoolean, localMap, str), 5, null, false);
  }
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean, Map<Long, odv.b> paramMap1, String paramString)
  {
    this.this$0.a(paramMap, paramBoolean, paramMap1, paramString);
  }
  
  public List<BaseArticleInfo> aG()
  {
    return this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.mData;
  }
  
  public void aGI()
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.aXk();
  }
  
  public BaseArticleInfo b(int paramInt)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.mData.size() > 0) && (paramInt < this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.mData.size())) {
      return (BaseArticleInfo)this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.mData.get(paramInt);
    }
    return null;
  }
  
  public void b(Set<Long> paramSet, Map<Long, mgu> paramMap)
  {
    this.this$0.U = paramSet;
    this.this$0.ek = paramMap;
  }
  
  public void cg(List<BaseArticleInfo> paramList)
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.mData.removeAll(paramList);
  }
  
  public void ch(List<ChannelCoverInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, "refreshSubChannelData channelList size:" + paramList.size());
      QLog.d("ReadInJoyFragmentWithSubChannel", 2, "refreshSubChannelData mClassificationListView =" + this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView + ",showSub = " + this.this$0.ajE);
    }
    if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      this.this$0.kz.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        this.this$0.kz.add(new ReadInJoyPicWaterFallFragment.c(localChannelCoverInfo, localChannelCoverInfo.mChannelCoverName, String.valueOf(localChannelCoverInfo.mChannelCoverId)));
      }
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.notifyDataSetChanged();
    }
  }
  
  public boolean e(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.ad(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public void f(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    ReadInJoyPicWaterFallFragment.b(this.this$0);
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.mData.remove(paramBaseArticleInfo);
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.notifyItemRemoved(paramInt);
  }
  
  public void notifyDataChange()
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.notifyDataSetChanged();
  }
  
  public void nq(boolean paramBoolean) {}
  
  public void nr(boolean paramBoolean)
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.pn(paramBoolean);
  }
  
  public void refreshData()
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.aXj();
  }
  
  public void setData(List<BaseArticleInfo> paramList)
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$i.setData(paramList);
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.t(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lec
 * JD-Core Version:    0.7.0.1
 */