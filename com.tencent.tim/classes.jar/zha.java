import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import java.util.ArrayList;
import java.util.List;

public class zha
  implements ausj.a
{
  public zha(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ChatHistoryTroopFileFragment.a(this.this$0).gy();
    if ((paramView == null) || (paramView.isEmpty())) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramView);
      ChatHistoryTroopFileFragment.a(this.this$0).a(localArrayList, 3, new zhb(this));
      ChatHistoryTroopFileFragment.a(this.this$0).setSelectMode(false);
      this.this$0.coI();
    } while (!this.aa.isShowing());
    this.aa.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zha
 * JD-Core Version:    0.7.0.1
 */