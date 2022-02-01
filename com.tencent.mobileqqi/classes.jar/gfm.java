import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import java.util.ArrayList;
import java.util.List;

public class gfm
  implements Runnable
{
  public gfm(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    ArrayList localArrayList;
    if (QCallDetailActivity.a(this.a) != null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      synchronized (QCallDetailActivity.a(this.a))
      {
        List localList = QCallDetailActivity.a(this.a).a(QCallDetailActivity.a(this.a), QCallDetailActivity.a(this.a));
        if ((QCallDetailActivity.a(this.a) != null) && (localList != null) && (!localList.isEmpty()))
        {
          int i = 20;
          int j = 0;
          if ((j >= i) || (j >= localList.size())) {
            break label191;
          }
          if (((QCallRecord)localList.get(j)).type == QCallRecord.TYPE_DATE)
          {
            i += 1;
            localArrayList.add(localList.get(j));
            j += 1;
            continue;
            this.a.b.runOnUiThread(new gfn(this, localArrayList, bool));
          }
        }
        else
        {
          bool = true;
        }
      }
      continue;
      label191:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfm
 * JD-Core Version:    0.7.0.1
 */