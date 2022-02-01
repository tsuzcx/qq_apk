import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.a;

public class lax
  implements XRecyclerView.a
{
  public lax(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startLoadMore.");
    paramXRecyclerView = lbg.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.l(ReadInJoyCGIDynamicChannelFragment.f(this.this$0), ReadInJoyCGIDynamicChannelFragment.a(this.this$0).cs(), 10);
    }
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "startTopRefresh.");
    paramXRecyclerView = lbg.a();
    if (paramXRecyclerView != null) {
      paramXRecyclerView.qe(ReadInJoyCGIDynamicChannelFragment.e(this.this$0));
    }
  }
  
  public void aCB()
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "endOfRefresh.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lax
 * JD-Core Version:    0.7.0.1
 */