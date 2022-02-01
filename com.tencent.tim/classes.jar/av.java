import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class av
  implements DialogInterface.OnClickListener
{
  public av(LiteActivity paramLiteActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    acde localacde = (acde)this.this$0.app.getBusinessHandler(8);
    localacde.F(113);
    localacde.report(116);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
        cu.f(this.this$0.app);
      }
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    }
    localacde.af(localArrayList);
    this.this$0.a.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     av
 * JD-Core Version:    0.7.0.1
 */