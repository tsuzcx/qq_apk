import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView.f;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mji
  implements ReadInJoyNinePicDeliverDynamicGridView.f
{
  public mji(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void aY(int paramInt1, int paramInt2)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.this$0) != 0)
    {
      Integer localInteger = (Integer)ReadInJoyDeliverUGCActivity.a(this.this$0).remove(paramInt1);
      ReadInJoyDeliverUGCActivity.a(this.this$0).add(paramInt2, localInteger);
      kbp.a(null, "", "0X800953F", "0X800953F", 0, 0, "", "", "", kxm.iS(), false);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "change position old position=" + paramInt1 + " new position" + paramInt2);
      }
    }
  }
  
  public void qM(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startDrag!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mji
 * JD-Core Version:    0.7.0.1
 */