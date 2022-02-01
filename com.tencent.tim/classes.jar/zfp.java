import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import java.util.ArrayList;
import java.util.List;

public class zfp
  implements ausj.a
{
  public zfp(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new ArrayList();
    paramView.addAll(ChatHistoryC2CFileFragment.a(this.this$0));
    ChatHistoryC2CFileFragment.a(this.this$0).a(paramView, 3, new zfq(this));
    this.this$0.coI();
    ChatHistoryC2CFileFragment.b(this.this$0, false);
    ChatHistoryC2CFileFragment.b(this.this$0);
    if (this.aa.isShowing()) {
      this.aa.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfp
 * JD-Core Version:    0.7.0.1
 */