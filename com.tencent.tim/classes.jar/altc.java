import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.b;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.c;

public class altc
  extends RecyclerView.OnScrollListener
{
  public altc(ReceiptMessageReadMemberListFragment.b paramb) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    ReceiptMessageReadMemberListFragment.b.a(this.a, paramInt);
    if (ReceiptMessageReadMemberListFragment.b.a(this.a) == 0)
    {
      if (ReceiptMessageReadMemberListFragment.b.a(this.a).isPausing()) {
        ReceiptMessageReadMemberListFragment.b.a(this.a).resume();
      }
      int i = ReceiptMessageReadMemberListFragment.b.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = ReceiptMessageReadMemberListFragment.b.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (ReceiptMessageReadMemberListFragment.c)ReceiptMessageReadMemberListFragment.b.a(this.a).getChildViewHolder(paramRecyclerView);
        ReceiptMessageReadMemberListFragment.c.a(paramRecyclerView).setImageBitmap(ReceiptMessageReadMemberListFragment.b.a(this.a, ReceiptMessageReadMemberListFragment.c.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    ReceiptMessageReadMemberListFragment.b.a(this.a).edu();
    ReceiptMessageReadMemberListFragment.b.a(this.a).pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altc
 * JD-Core Version:    0.7.0.1
 */