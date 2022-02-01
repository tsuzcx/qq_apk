import android.os.Handler;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class arpq
  extends jqk
{
  public arpq(BindGroupActivity paramBindGroupActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID.toString());
    }
    if ((this.this$0.isFinishing()) || (this.this$0.aRg)) {}
    do
    {
      return;
      this.this$0.a.hide();
      if (this.this$0.bJ != null) {
        this.this$0.bJ.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "openIdObserver success");
        }
        this.this$0.cBu = paramOpenID.openID;
        if (!paramOpenID.openID.equals(this.this$0.mOpenId))
        {
          this.this$0.bFG();
          return;
        }
        this.this$0.ekZ();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupActivity", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpq
 * JD-Core Version:    0.7.0.1
 */