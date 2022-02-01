import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akrb
  implements View.OnClickListener
{
  akrb(akqx paramakqx) {}
  
  public void onClick(View paramView)
  {
    PopupMenu localPopupMenu = new PopupMenu(akqx.a(this.c), paramView);
    this.c.a(akqx.a(this.c).app, localPopupMenu);
    localPopupMenu.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrb
 * JD-Core Version:    0.7.0.1
 */