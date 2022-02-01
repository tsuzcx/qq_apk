import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class yac
  implements ardq.a<oidb_0x8ed.RspBody>
{
  yac(yab paramyab) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.TAG, 2, "exitRoom: errorCode = " + paramInt);
    }
    if ((paramInt == 0) || (paramInt == 1285))
    {
      if ((this.a.this$0.A != null) && (this.a.this$0.A.isShowing())) {
        this.a.this$0.A.dismiss();
      }
      new Intent().putExtra("isNeedFinish", true);
      aqmj.o(this.a.this$0.a(), this.a.this$0.app.getCurrentAccountUin(), false);
      ajry.a().dyZ();
      this.a.this$0.bkS = true;
      this.a.this$0.fV(1);
      return;
    }
    if ((this.a.this$0.A != null) && (this.a.this$0.A.isShowing())) {
      this.a.this$0.A.dismiss();
    }
    QQToast.a(this.a.this$0.a(), 1, acfp.m(2131706770), 0).show(this.a.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yac
 * JD-Core Version:    0.7.0.1
 */