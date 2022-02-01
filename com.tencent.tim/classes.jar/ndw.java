import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.26.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.b;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class ndw
  implements ReadInJoyBaseListView.b
{
  ndw(ndi paramndi) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    ndi.d(this.this$0, false);
    if (!ndi.c(this.this$0)) {
      return;
    }
    ndi.a(this.this$0, false);
    if ((this.this$0.Fo()) && (ndi.a(this.this$0) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!ndi.a(this.this$0).Ef()) {
        break label122;
      }
      ndi.a(this.this$0).postDelayed(new ReadInJoyBaseAdapter.26.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      ndi.a(this.this$0, this.this$0.a.getLastVisiblePosition() + 1, ndi.access$900());
      return;
      label122:
      this.this$0.j(paramReadInJoyBaseListView, ndi.aYc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndw
 * JD-Core Version:    0.7.0.1
 */