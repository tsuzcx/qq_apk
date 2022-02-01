import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;

class ltv
  implements auwv.c
{
  ltv(ltp paramltp) {}
  
  public void onFooterRebound() {}
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = ltp.a(this.this$0).dp(ltp.a(this.this$0).getCurrentPosition());
    paramViewHolder = ltp.a(this.this$0).getEventCallback();
    if (paramViewHolder != null) {
      paramViewHolder.onPagerChange(i);
    }
    this.this$0.ru(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltv
 * JD-Core Version:    0.7.0.1
 */