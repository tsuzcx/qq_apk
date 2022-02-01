import com.tencent.mobileqq.data.TroopInfo;

class jmq
  extends acnd
{
  jmq(jmo paramjmo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != this.this$0.qp) {
      return;
    }
    this.this$0.qp = 0L;
    jmo.a(this.this$0, false);
    if (paramBoolean)
    {
      jmo.a(this.this$0, paramTroopInfo);
      return;
    }
    jmo.a(this.this$0, 2131719483, 1);
    this.this$0.a.error();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmq
 * JD-Core Version:    0.7.0.1
 */