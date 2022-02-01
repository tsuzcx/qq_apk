import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TableLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aaws
  extends Handler
{
  public aaws(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      CreateFaceToFaceDiscussionActivity.a(this.this$0, 3);
      paramMessage = this.this$0.mHandler.obtainMessage(0);
      this.this$0.mHandler.sendMessageDelayed(paramMessage, this.this$0.mInterval);
    }
    do
    {
      do
      {
        return;
        if (1 != paramMessage.what) {
          break;
        }
      } while (this.this$0.bAB);
      this.this$0.j.delete(0, this.this$0.j.length());
      this.this$0.c.setContentDescription(this.this$0.getDescription());
      this.this$0.wz.setImageResource(2130846142);
      this.this$0.wA.setImageResource(2130846142);
      this.this$0.wB.setImageResource(2130846142);
      this.this$0.wC.setImageResource(2130846142);
      this.this$0.wD.setEnabled(true);
      this.this$0.wE.setEnabled(true);
      this.this$0.wF.setEnabled(true);
      this.this$0.wG.setEnabled(true);
      this.this$0.wH.setEnabled(true);
      this.this$0.wI.setEnabled(true);
      this.this$0.wJ.setEnabled(true);
      this.this$0.wK.setEnabled(true);
      this.this$0.wL.setEnabled(true);
      this.this$0.wM.setEnabled(true);
      this.this$0.ku.setEnabled(true);
      return;
    } while (2 != paramMessage.what);
    QQToast.a(BaseApplicationImpl.getContext(), paramMessage.arg1, paramMessage.arg2, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaws
 * JD-Core Version:    0.7.0.1
 */