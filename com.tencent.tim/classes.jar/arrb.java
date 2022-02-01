import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arrb
  implements View.OnClickListener
{
  public arrb(OpenAuthorityAccountView paramOpenAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof String))) {
      this.this$0.WL((String)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrb
 * JD-Core Version:    0.7.0.1
 */