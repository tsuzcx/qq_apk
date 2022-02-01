import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.qphone.base.util.QLog;

public class nek
  implements ndi.e
{
  public nek(ReadInJoyBaseListView paramReadInJoyBaseListView) {}
  
  public void azP()
  {
    if (kxf.aI(kxf.co()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", Integer.valueOf(this.c.aDC) });
      }
      if ((this.c.aDC == 0) && ((!odv.aT(this.c.mChannelId)) || (!this.c.arG)))
      {
        this.c.ts(4);
        QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch OFF, mCurrentStatus = ", Integer.valueOf(this.c.aDC) });
      }
    } while ((odv.aT(this.c.mChannelId)) && ((this.c.aDC != 0) || (this.c.arG)));
    this.c.ts(4);
    QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch OFF, loadingMore()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nek
 * JD-Core Version:    0.7.0.1
 */