import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

class ajqv
  extends ajvj
{
  ajqv(ajqp paramajqp, SubMsgType0x27.AppointmentNotify paramAppointmentNotify) {}
  
  protected void dyL()
  {
    if (QLog.isColorLevel()) {
      ajrk.m("hasOnLinePush", new Object[] { "onNearbyProcStart" });
    }
    ajqp.a(this.this$0, 4101, new Object[] { this.a.toByteArray() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqv
 * JD-Core Version:    0.7.0.1
 */