import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aucl
  implements View.OnClickListener
{
  aucl(aucj paramaucj) {}
  
  public void onClick(View paramView)
  {
    audx.a(this.a.mContext, this.a.a.getFilePath(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucl
 * JD-Core Version:    0.7.0.1
 */