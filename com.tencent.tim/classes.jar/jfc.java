import android.content.Intent;
import com.tencent.av.ui.QavPanel.d;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;

class jfc
  implements QavPanel.d
{
  jfc(jfb paramjfb, long paramLong) {}
  
  public void iB(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jfb.a(this.a)) {
        return;
      }
      if (this.a.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        this.a.report("0X80051FE");
      }
      for (;;)
      {
        QLog.w("VideoInviteUILock", 1, "SlideAcceptListener, seq[" + this.kQ + "]");
        this.a.a.WU = true;
        this.a.a.dP(this.kQ);
        return;
        if (this.a.a.VL) {
          this.a.report("0X8004201");
        } else {
          this.a.report("0X8004205");
        }
      }
    }
    if (this.a.a.VL)
    {
      this.a.report("0X800439E");
      return;
    }
    this.a.report("0X80043FD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfc
 * JD-Core Version:    0.7.0.1
 */