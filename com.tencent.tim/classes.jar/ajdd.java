import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.ChatBackgroundManager.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Vector;

public class ajdd
  implements ChatBackgroundManager.a
{
  public ajdd(ChatBackgroundManager paramChatBackgroundManager, Context paramContext) {}
  
  public void a(boolean paramBoolean, Vector<Integer> paramVector)
  {
    if ((paramBoolean) && (this.I != null) && ((this.I instanceof FragmentActivity)))
    {
      paramVector = ((FragmentActivity)this.I).getChatFragment();
      if ((paramVector != null) && (paramVector.a() != null) && (paramVector.a().b != null))
      {
        ChatXListView localChatXListView = paramVector.a().b;
        int i = localChatXListView.getFirstVisiblePosition();
        int j = localChatXListView.getLastVisiblePosition();
        while (i <= j)
        {
          Object localObject = wja.a(localChatXListView, i);
          if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseBubbleBuilder.e)))
          {
            localObject = (BaseBubbleBuilder.e)((View)localObject).getTag();
            if ((((BaseBubbleBuilder.e)localObject).b != null) && (!((BaseBubbleBuilder.e)localObject).b.hasStroke) && (((BaseBubbleBuilder.e)localObject).b.bRF))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatBackgroundManager", 2, "BgThemeColorExtractListener.onBgThemeColorExtracted: success=true, refresh AIO.");
              }
              paramVector.a().b(((BaseBubbleBuilder.e)localObject).mMessage, 1);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdd
 * JD-Core Version:    0.7.0.1
 */