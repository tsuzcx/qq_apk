import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.23.1;
import com.tencent.qphone.base.util.QLog;

public class nih
  extends lce
{
  public nih(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "onLocationChanged changeType = " + paramInt);
    }
    ReadinjoyTabFrame.a(this.this$0, paramInt, paramPositionData);
  }
  
  public void aJI()
  {
    super.aJI();
    if (ReadinjoyTabFrame.a(this.this$0) != null) {
      ReadinjoyTabFrame.a(this.this$0).post(new ReadinjoyTabFrame.23.1(this));
    }
  }
  
  public void aJJ()
  {
    QLog.d("ReadInJoyTabFrame", 2, "onHideChannel");
  }
  
  public void nd(boolean paramBoolean)
  {
    if ((paramBoolean) && (RIJRedPacketManager.a().Dt())) {
      ReadinjoyTabFrame.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nih
 * JD-Core Version:    0.7.0.1
 */