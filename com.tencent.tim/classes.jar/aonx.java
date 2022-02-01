import com.tencent.mobileqq.data.MessageRecord;

class aonx
  extends achq
{
  aonx(aonu paramaonu) {}
  
  public void a(boolean paramBoolean, long paramLong, achq.a parama)
  {
    this.this$0.hM("sendMsgFinish", "success:" + paramBoolean);
    aqip.bj(String.valueOf(this.this$0.h.mUniseq), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.this$0.h.F.toString());
    this.this$0.a(this.this$0.c, false, paramBoolean, parama);
    if (paramBoolean)
    {
      this.this$0.onSuccess();
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonx
 * JD-Core Version:    0.7.0.1
 */