import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips.1;
import com.tencent.qphone.base.util.QLog;

public class aoda
  extends aocs
{
  public aoda(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, aocw paramaocw)
  {
    super(paramQQAppInterface, paramChatMessage, paramaocw);
  }
  
  protected String AB()
  {
    return ((MessageForTroopFile)this.q).fileName;
  }
  
  protected void a(aocs.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new TroopFileAIOMsgTips.1(this, parama), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoda
 * JD-Core Version:    0.7.0.1
 */