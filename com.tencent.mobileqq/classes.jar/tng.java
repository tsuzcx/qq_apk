import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class tng
  extends tnd
{
  private RefreshAnimView a;
  
  public tng(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298762);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aakn == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562746, paramViewGroup, false);
      paramViewGroup.findViewById(2131376460).getLayoutParams().width = -2;
      this.jdField_a_of_type_Aakn = ((aakn)paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_Aakn).findViewById(2131376452));
    }
    return (View)this.jdField_a_of_type_Aakn;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aakn == null) {
      return;
    }
    this.jdField_a_of_type_Aakn.a(0L);
    this.jdField_a_of_type_Aakn.ai_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Aakn == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Aakn.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aakn.ai_();
      return;
    }
    this.jdField_a_of_type_Aakn.c(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / 100.0D);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aakn == null) {
      return;
    }
    this.jdField_a_of_type_Aakn.a(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Aakn == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tng
 * JD-Core Version:    0.7.0.1
 */