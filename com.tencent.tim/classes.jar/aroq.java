import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aroq
  implements View.OnClickListener
{
  public aroq(AuthorityAccountView paramAuthorityAccountView) {}
  
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
 * Qualified Name:     aroq
 * JD-Core Version:    0.7.0.1
 */