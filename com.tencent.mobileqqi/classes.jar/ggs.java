import PersonalState.HotRishState;
import android.os.Handler;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ggs
  extends StatusObserver
{
  public ggs(EditActivity paramEditActivity) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("get_hot_rich_status", 2, "EditActivity.mHotRichStatusObserver.onGetHotStatus, isSuccess:" + paramBoolean);
    }
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0) && (!EditActivity.c(this.a)))
    {
      EditActivity.a(this.a).removeMessages(1);
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(Integer.valueOf(((HotRishState)paramArrayList.next()).iActId));
      }
      EditActivity.a(this.a).clear();
      EditActivity.a(this.a).addAll(localArrayList);
      EditActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ggs
 * JD-Core Version:    0.7.0.1
 */