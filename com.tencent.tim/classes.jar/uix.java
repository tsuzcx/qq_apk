import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class uix
  extends accn
{
  public uix(BaseChatPie paramBaseChatPie) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.d(this.this$0, paramBoolean, paramObject);
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.this$0.bIH();
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    ((wtn)this.this$0.a(70)).cbJ();
    if (paramBoolean)
    {
      this.this$0.mActivity.showDialog(232);
      return;
    }
    this.this$0.mActivity.showDialog(233);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.this$0.bIH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uix
 * JD-Core Version:    0.7.0.1
 */