class aoka
  extends achq
{
  aoka(aojz paramaojz) {}
  
  public void a(boolean paramBoolean, long paramLong, achq.a parama)
  {
    this.this$0.hM("sendMsgFinish", "success:" + paramBoolean);
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
 * Qualified Name:     aoka
 * JD-Core Version:    0.7.0.1
 */