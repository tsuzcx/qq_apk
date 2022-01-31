import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ead
  implements TransFileController.OnCancelListener
{
  public ead(PicItemBuilder paramPicItemBuilder) {}
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      PicItemBuilder.a(this.a).a().a(localMessageRecord, false);
      if (QLog.isColorLevel()) {
        QLog.d("cancelpic", 2, "remove pic:" + localMessageRecord.uniseq);
      }
    }
    ((ChatActivity)PicItemBuilder.a(this.a)).a(196612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ead
 * JD-Core Version:    0.7.0.1
 */