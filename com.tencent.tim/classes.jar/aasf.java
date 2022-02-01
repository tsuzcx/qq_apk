import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.d;

class aasf
  implements HorizontalListView.d
{
  aasf(aasb paramaasb) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "ptv template listview onScrollStateChanged state: " + paramInt);
    }
    if (paramInt == 4097)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "ptv template listview onScrollStateChanged state is idle.");
      }
      this.b.cjt = this.b.mListView.getFirstVisiblePosition();
      this.b.mHandler.removeMessages(1001);
      this.b.mHandler.sendEmptyMessageDelayed(1001, 400L);
    }
    this.b.mHandler.removeMessages(1000);
    this.b.mHandler.sendEmptyMessage(1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasf
 * JD-Core Version:    0.7.0.1
 */