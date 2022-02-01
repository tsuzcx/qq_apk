import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auck
  implements View.OnClickListener
{
  auck(aucj paramaucj) {}
  
  public void onClick(View paramView)
  {
    audx.a(this.a.mContext, this.a.a.getFilePath(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auck
 * JD-Core Version:    0.7.0.1
 */