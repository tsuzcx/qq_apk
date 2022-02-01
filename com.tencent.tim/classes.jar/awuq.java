import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class awuq
  implements MessageQueue.IdleHandler
{
  awuq(awuo paramawuo, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "load Scroll Position,index:" + this.val$scrollIndex + " top:" + this.val$scrollY);
    }
    this.a.mListView.setSelectionFromTop(this.val$scrollIndex, this.val$scrollY);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuq
 * JD-Core Version:    0.7.0.1
 */