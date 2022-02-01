import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

final class awpe
  implements ahal.a
{
  awpe(ArrayList paramArrayList1, QQAppInterface paramQQAppInterface, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, MqqHandler paramMqqHandler, int paramInt) {}
  
  public void aD()
  {
    Iterator localIterator = this.Fx.iterator();
    while (localIterator.hasNext())
    {
      MessageForFile localMessageForFile = (MessageForFile)localIterator.next();
      ahav.a(this.val$app, localMessageForFile, BaseActivity.sTopActivity, true);
    }
    if (awpd.a(this.val$app, this.Fy, this.Fz, this.FA, this.a, this.zK)) {
      QQToast.a(this.val$app.getApp(), 2131694101, 0).show(this.zK);
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpe
 * JD-Core Version:    0.7.0.1
 */