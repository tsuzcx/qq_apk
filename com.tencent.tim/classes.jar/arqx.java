import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.open.agent.GroupListOpenFrame.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arqx
  implements View.OnClickListener
{
  public arqx(GroupListOpenFrame.a parama, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("group_index", this.val$position);
    localBundle.putString("group_name", this.bGV);
    this.b.a.a.k(1, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqx
 * JD-Core Version:    0.7.0.1
 */