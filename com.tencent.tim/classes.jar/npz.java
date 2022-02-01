import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class npz
  extends npy
{
  private RefreshAnimView a;
  
  public npz(Context paramContext)
  {
    super(paramContext);
  }
  
  public void aCB()
  {
    super.aCB();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.eT(1000L);
  }
  
  public void aXf()
  {
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    this.jdField_a_of_type_Son.S(0L);
    this.jdField_a_of_type_Son.pn();
  }
  
  public void ag(int paramInt, boolean paramBoolean)
  {
    super.ag(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Son.R(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Son.pn();
      return;
    }
    this.jdField_a_of_type_Son.Q(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.u(paramInt / 100.0D);
  }
  
  public View d(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Son == null)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131562923, paramViewGroup, false);
      paramViewGroup.findViewById(2131377036).getLayoutParams().width = -2;
      this.jdField_a_of_type_Son = ((son)paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_Son).findViewById(2131377029));
    }
    return (View)this.jdField_a_of_type_Son;
  }
  
  public void pY(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    this.jdField_a_of_type_Son.S(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.bae();
  }
  
  public int qC()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299205);
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Son == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.A(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npz
 * JD-Core Version:    0.7.0.1
 */