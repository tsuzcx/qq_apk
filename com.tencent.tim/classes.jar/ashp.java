import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ashp
  implements View.OnClickListener
{
  public ashp(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = QidianProfileCardActivity.a(this.this$0);
    int i;
    if (QidianProfileCardActivity.a(this.this$0))
    {
      i = 1;
      ((TextView)localObject).setMaxLines(i);
      localObject = this.this$0;
      if (QidianProfileCardActivity.a(this.this$0)) {
        break label65;
      }
    }
    for (;;)
    {
      QidianProfileCardActivity.a((QidianProfileCardActivity)localObject, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 3;
      break;
      label65:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashp
 * JD-Core Version:    0.7.0.1
 */