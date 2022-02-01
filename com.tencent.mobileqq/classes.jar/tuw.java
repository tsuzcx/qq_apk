import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class tuw
  implements VRefreshLayout.onRefreshStateChangeListener
{
  tuw(tuv paramtuv, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!tuv.a(this.jdField_a_of_type_Tuv)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / i);
    }
  }
  
  public void onStateEnd()
  {
    tuv.a(this.jdField_a_of_type_Tuv, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    tuv.a(this.jdField_a_of_type_Tuv, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    tuv.a(this.jdField_a_of_type_Tuv, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */