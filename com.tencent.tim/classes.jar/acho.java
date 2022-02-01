import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acho
  extends acfd
{
  public acho(MessageHandler paramMessageHandler) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3) && (!TextUtils.isEmpty(paramString))) {
      this.this$0.app.b().bEH();
    }
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateAnswerAddedFriend isSuccess = " + paramBoolean + ", uin = " + paramString + ", flag = " + paramInt);
    }
    if (paramBoolean) {
      this.this$0.app.b().bEH();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateFriendList isSuccess = " + paramBoolean1 + ", isComplete = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.this$0.app.b().bEH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acho
 * JD-Core Version:    0.7.0.1
 */