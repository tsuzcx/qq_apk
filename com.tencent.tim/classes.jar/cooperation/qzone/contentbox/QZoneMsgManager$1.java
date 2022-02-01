package cooperation.qzone.contentbox;

import afaf;
import avto;
import avtu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QzoneCommonIntent;

public class QZoneMsgManager$1
  implements Runnable
{
  public QZoneMsgManager$1(avto paramavto, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    avtu localavtu = new avtu(this.val$app.getLongAccountUin(), "", this.this$0.lw(1), 2);
    localavtu.setType(1);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(this.val$app.getApplication(), afaf.class);
    localQzoneCommonIntent.setRequest(localavtu);
    localQzoneCommonIntent.setObserver(this.this$0);
    this.val$app.startServlet(localQzoneCommonIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.1
 * JD-Core Version:    0.7.0.1
 */