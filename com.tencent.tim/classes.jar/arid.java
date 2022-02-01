import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToast.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arid
  implements View.OnClickListener
{
  public arid(QQToast paramQQToast, QQToast.b paramb, Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    if (this.b.onClickListener != null)
    {
      this.val$toast.cancel();
      this.b.onClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arid
 * JD-Core Version:    0.7.0.1
 */