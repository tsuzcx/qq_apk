import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xae
  implements View.OnClickListener
{
  xae(xad paramxad, int paramInt, ArkViewImplement.ArkViewInterface paramArkViewInterface) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (this.val$menuType == 2) {
      if (i == 0) {
        this.a.doInputCommand(5);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 1)
      {
        this.a.doInputCommand(4);
      }
      else if (i == 2)
      {
        this.a.doInputCommand(3);
        continue;
        if (this.val$menuType == 1)
        {
          if (i == 0) {
            this.a.doInputCommand(1);
          } else if (i == 1) {
            this.a.doInputCommand(2);
          } else if (i == 2) {
            this.a.doInputCommand(3);
          }
        }
        else {
          this.a.doInputCommand(3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xae
 * JD-Core Version:    0.7.0.1
 */