import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class nuh
  implements VRefreshLayout.onRefreshStateChangeListener
{
  nuh(nug paramnug, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!nug.a(this.jdField_a_of_type_Nug)))
    {
      this.b.reset();
      this.b.u(paramInt / i);
    }
  }
  
  public void onStateEnd()
  {
    nug.a(this.jdField_a_of_type_Nug, false);
    this.b.eT(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.b.A(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    nug.a(this.jdField_a_of_type_Nug, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    nug.a(this.jdField_a_of_type_Nug, true);
    this.b.reset();
    this.b.bae();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nuh
 * JD-Core Version:    0.7.0.1
 */