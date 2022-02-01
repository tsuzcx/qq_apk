import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class yxv
  extends MqqHandler
{
  public yxv(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
        if (this.this$0.jdField_b_of_type_Ywk != null)
        {
          this.this$0.jdField_b_of_type_Ywk.unreadMsgNum = anze.a().af(this.this$0.app);
          this.this$0.jdField_b_of_type_Ywk.notifyDataSetChanged();
          this.this$0.jdField_b_of_type_Ackn.cxG = anze.a().af(this.this$0.app);
          this.this$0.gV(this.this$0.ty);
          this.this$0.gU(this.this$0.tz);
          this.this$0.aK(false, 1);
          this.this$0.aK(false, 2);
        }
      } while (TroopNotifyAndRecommendView.a(this.this$0) == null);
      TroopNotifyAndRecommendView.a(this.this$0).notifyDataSetChanged();
      return;
    case 1014: 
      this.this$0.cmG();
      return;
    }
    paramMessage = paramMessage.obj;
    try
    {
      this.this$0.gT((List)paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("TroopNotifyAndRecommendView", 1, "handleRecommendData wrong");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxv
 * JD-Core Version:    0.7.0.1
 */