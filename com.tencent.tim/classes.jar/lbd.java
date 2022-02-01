import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.a;

public class lbd
  implements XRecyclerView.a
{
  public lbd(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "startLoadMore.");
    if (ReadInJoyDynamicChannelFragment.h(this.this$0) == 40830) {}
    for (paramInt = ReadInJoyDynamicChannelFragment.i(this.this$0);; paramInt = 1)
    {
      lbz.a().b(ReadInJoyDynamicChannelFragment.j(this.this$0), ReadInJoyDynamicChannelFragment.k(this.this$0), 2, 0, paramInt);
      return;
    }
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "startTopRefresh.");
    if (paramBoolean) {}
    for (int i = 1;; i = 3)
    {
      this.this$0.qd(i);
      return;
    }
  }
  
  public void aCB()
  {
    QLog.d("ReadInJoyDynamicChannelFragment", 2, "endRefresh.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbd
 * JD-Core Version:    0.7.0.1
 */