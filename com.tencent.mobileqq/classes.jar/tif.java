import android.database.DataSetObserver;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tif
  extends DataSetObserver
{
  tif(thy paramthy) {}
  
  public void onChanged()
  {
    if (this.a.a == 0) {
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tif
 * JD-Core Version:    0.7.0.1
 */