import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class uoc
  implements armm.a
{
  public uoc(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, aghw paramaghw) {}
  
  public void callback(int paramInt)
  {
    if (paramInt == 2)
    {
      ahao.JG(this.this$0.getString(2131694101));
      Iterator localIterator = this.qv.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            this.a.a(localFileManagerEntity.getFilePath(), "", this.this$0.app.getCurrentAccountUin(), 0, false);
          } else {
            this.a.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoc
 * JD-Core Version:    0.7.0.1
 */