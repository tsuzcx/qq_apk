import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alyh
  implements View.OnClickListener
{
  alyh(alyg paramalyg) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.an.isShowing())
    {
      this.this$0.an.cancel();
      this.this$0.an.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyh
 * JD-Core Version:    0.7.0.1
 */