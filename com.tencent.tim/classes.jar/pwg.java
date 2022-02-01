import android.database.DataSetObserver;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class pwg
  extends DataSetObserver
{
  pwg(pvz parampvz) {}
  
  public void onChanged()
  {
    if (this.this$0.mLastScrollState == 0) {
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwg
 * JD-Core Version:    0.7.0.1
 */