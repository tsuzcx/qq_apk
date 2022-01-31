import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class zov
  extends FriendListObserver
{
  public zov(NewFriendManager paramNewFriendManager) {}
  
  protected void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = this.a.b();
    } while (((ArrayList)localObject).isEmpty());
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)((Iterator)localObject).next();
      if ((localNewFriendMessage instanceof FriendSystemMessage))
      {
        int i = ((FriendSystemMessage)localNewFriendMessage).a.structMsg.msg.sub_type.get();
        String str = ((FriendSystemMessage)localNewFriendMessage).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          NewFriendManager.a(this.a).a().b(AppConstants.K, 0, ((FriendSystemMessage)localNewFriendMessage).a.uniseq, false);
        }
      }
    }
    NewFriendManager.a(this.a).sendEmptyMessage(2);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    NewFriendManager.a(this.a).runOnUiThread(new zow(this, paramBoolean));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zov
 * JD-Core Version:    0.7.0.1
 */