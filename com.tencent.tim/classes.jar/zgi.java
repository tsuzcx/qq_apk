import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zgi
  implements ausj.a
{
  public zgi(ChatHistoryMediaBaseFragment paramChatHistoryMediaBaseFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new ArrayList();
    if ((this.a.rA != null) && (this.a.a != null))
    {
      List localList = this.a.a.cG();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ChatMessage)localIterator.next();
        if (((ChatMessage)localObject).msgtype == -2005)
        {
          localObject = this.a.mApp.a().a(((ChatMessage)localObject).uniseq, ((ChatMessage)localObject).frienduin, ((ChatMessage)localObject).istroop);
          if (localObject != null) {
            this.a.mApp.a().ca(((FileManagerEntity)localObject).nSessionId);
          }
        }
      }
      paramView.addAll(localList);
    }
    if (paramView.size() > 0) {
      ThreadManager.post(new ChatHistoryMediaBaseFragment.1.1(this, paramView), 8, null, true);
    }
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgi
 * JD-Core Version:    0.7.0.1
 */