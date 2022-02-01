import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aocu
  extends aocs
{
  public aocu(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, aocw paramaocw)
  {
    super(paramQQAppInterface, paramChatMessage, paramaocw);
  }
  
  protected String AB()
  {
    return ((MessageForFile)this.q).fileName;
  }
  
  protected void a(aocs.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuddyFileAIOMsgTips", 1, "getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.getUIHandler().post(new BuddyFileAIOMsgTips.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocu
 * JD-Core Version:    0.7.0.1
 */