import com.tencent.qphone.base.util.QLog;

class aoky
  extends achq
{
  aoky(aokv paramaokv) {}
  
  public void a(boolean paramBoolean, long paramLong, achq.a parama)
  {
    if ((this.this$0.h.mUinType == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.this$0.hM("sendMsgFinish", "success:" + paramBoolean);
    this.this$0.a(this.this$0.c, false, paramBoolean, parama);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    if (parama != null) {
      this.this$0.dPf = parama.cwV;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoky
 * JD-Core Version:    0.7.0.1
 */