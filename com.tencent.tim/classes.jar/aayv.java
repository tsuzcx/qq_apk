import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aayv
  extends Handler
{
  public aayv(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object[] arrayOfObject;
    String str;
    do
    {
      do
      {
        return;
        TroopMemberListInnerFrame.a(this.this$0, paramMessage);
        return;
        paramMessage = this.this$0;
        paramMessage.bw += TroopMemberListInnerFrame.bx;
      } while ((this.this$0.bw >= 90.0D) || (this.this$0.cmx <= 0));
      if (this.this$0.iV.getVisibility() == 8) {
        this.this$0.iV.setVisibility(0);
      }
      this.this$0.mProgressBar.setProgress((int)this.this$0.bw);
      this.this$0.Gl.setText(String.format(acfp.m(2131715970), new Object[] { Integer.valueOf(Math.min((int)(this.this$0.cmx * this.this$0.bw / 100.0D), this.this$0.cmx)), Integer.valueOf(this.this$0.cmx) }));
      this.this$0.mHandler.sendMessageDelayed(this.this$0.mHandler.obtainMessage(4), 800L);
      return;
      TroopMemberListInnerFrame.a(this.this$0, paramMessage.arg1);
      this.this$0.mHandler.removeMessages(4);
      if (!(paramMessage.obj instanceof Object[])) {
        break label366;
      }
      arrayOfObject = (Object[])paramMessage.obj;
      if (arrayOfObject.length <= 0) {
        break label366;
      }
      str = (String)arrayOfObject[1];
      if (str.equals(this.this$0.mTroopUin)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + str + "," + this.this$0.mTroopUin);
    return;
    this.this$0.iL = ((Map)arrayOfObject[0]);
    label366:
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + this.this$0.iL.size());
    }
    if ((this.this$0.a.bGG == 1) || (this.this$0.a.bGG == 0) || (this.this$0.a.bGG == 5))
    {
      int i = TroopMemberListInnerFrame.a(this.this$0, this.this$0.iL);
      this.this$0.a.GP(i);
    }
    paramMessage.obj = TroopMemberListInnerFrame.a(this.this$0);
    TroopMemberListInnerFrame.a(this.this$0, paramMessage);
    if ((!this.this$0.bAF) && (this.this$0.a.bAW))
    {
      this.this$0.bAF = true;
      paramMessage = this.this$0.F;
      if (this.this$0.F.isChecked()) {
        break label685;
      }
    }
    label685:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.setChecked(bool);
      this.this$0.onCheckedChanged(this.this$0.F, this.this$0.F.isChecked());
      if ((this.this$0.a.mType != 9654) || (TroopMemberListInnerFrame.a(this.this$0) + 1 > 50) || (!TroopMemberListInnerFrame.a(this.this$0)) || (!TroopMemberListInnerFrame.b(this.this$0)) || (this.this$0.iT.getVisibility() != 0)) {
        break;
      }
      this.this$0.F.setChecked(true);
      this.this$0.onCheckedChanged(this.this$0.F, this.this$0.F.isChecked());
      TroopMemberListInnerFrame.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayv
 * JD-Core Version:    0.7.0.1
 */