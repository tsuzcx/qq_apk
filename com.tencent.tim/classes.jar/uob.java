import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class uob
  implements ahal.a
{
  public uob(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, aghw paramaghw) {}
  
  public void aD()
  {
    Iterator localIterator = this.qv.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.a.l(localFileManagerEntity);
      }
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uob
 * JD-Core Version:    0.7.0.1
 */