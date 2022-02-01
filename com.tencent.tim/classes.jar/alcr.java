import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alcr
  implements AdapterView.OnItemClickListener
{
  alcr(alcp paramalcp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (alcp.a(this.this$0).isShowing()) {
      alcp.a(this.this$0).dismiss();
    }
    int i = -1;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      if (alcp.a(this.this$0) != null) {
        alcp.a(this.this$0).bj(i, alcp.a(this.this$0));
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      alcp.a(this.this$0);
      i = 0;
      continue;
      alcp.b(this.this$0);
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcr
 * JD-Core Version:    0.7.0.1
 */