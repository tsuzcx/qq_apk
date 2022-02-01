import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public abstract class agzk
{
  protected agzl b;
  protected QQAppInterface mApp;
  protected ChatMessage v;
  
  public agzk(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.mApp = paramQQAppInterface;
    this.v = paramChatMessage;
  }
  
  public static agzk a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is null");
      return null;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return new agzf(paramQQAppInterface, paramChatMessage);
    }
    if ((paramChatMessage instanceof MessageForTroopFile)) {
      return new agzn(paramQQAppInterface, paramChatMessage);
    }
    QLog.e("QFileSaveModel<QFile>", 1, "buildFileSaveModel: message is not support. messageType[" + paramChatMessage.getClass().getName() + "]");
    return null;
  }
  
  public abstract agzi a();
  
  public abstract boolean amG();
  
  public abstract boolean amH();
  
  public void b(agzl paramagzl)
  {
    this.b = paramagzl;
  }
  
  public abstract boolean cu();
  
  public abstract long getFileSize();
  
  public abstract String getLocalFilePath();
  
  public abstract String vV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzk
 * JD-Core Version:    0.7.0.1
 */