import com.tencent.qphone.base.util.QLog;

final class aqmg
  extends achq
{
  public void a(boolean paramBoolean, long paramLong, achq.a parama)
  {
    if (parama != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + parama.appSeq);
      localStringBuilder.append("errCode: " + parama.errCode);
      localStringBuilder.append("retryCount: " + parama.retryCount);
      localStringBuilder.append("detailErrorReason: " + parama.Qw);
      localStringBuilder.append("timeoutReason: " + parama.timeoutReason);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmg
 * JD-Core Version:    0.7.0.1
 */