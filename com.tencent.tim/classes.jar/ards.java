import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class ards
  implements ardq.a<oidb_0x8ed.RspBody>
{
  ards(ardq paramardq, ardq.a parama) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WerewolvesHandler", 2, "startAnotherRound, quitFailed: errorCode :" + paramInt);
    }
    this.a.v(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ards
 * JD-Core Version:    0.7.0.1
 */