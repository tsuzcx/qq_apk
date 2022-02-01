import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.qphone.base.util.QLog;

public class neo
  implements ndi.e
{
  public neo(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void azP()
  {
    if (ReadInJoyDailyXListView.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyXListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", this.this$0.aDC + " mNoMoreData : " + this.this$0.arG });
      }
      if ((this.this$0.aDC == 0) && ((!odv.aT(this.this$0.mChannelId)) || (!this.this$0.arG)))
      {
        this.this$0.ts(4);
        QLog.d("ReadInJoyDailyXListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     neo
 * JD-Core Version:    0.7.0.1
 */