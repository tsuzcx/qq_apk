import com.tencent.qphone.base.util.QLog;

class kfi
  extends lce
{
  kfi(kfa paramkfa) {}
  
  public void lO(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] " + paramBoolean);
    if (!paramBoolean)
    {
      if ((kfa.a(this.this$0) == -1) || (kfa.a(this.this$0) == 0))
      {
        kfa.a(this.this$0, 0);
        return;
      }
      kfa.a(this.this$0, 4);
      return;
    }
    kfa.a(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfi
 * JD-Core Version:    0.7.0.1
 */