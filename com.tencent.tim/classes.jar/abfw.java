import com.tencent.qphone.base.util.QLog;

class abfw
  extends acnd
{
  abfw(abfr paramabfr) {}
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((str != null) && (str.equals(abfr.a(this.this$0))))
    {
      abfr.a(this.this$0, String.valueOf(paramLong2), paramBoolean, paramInt);
      QLog.d("RobotAdapter", 2, "onAddRobot  success" + paramBoolean + " resultCode " + paramInt);
      return;
    }
    QLog.i("RobotAdapter", 2, "onAddRobot  troop" + paramLong1 + " cur " + abfr.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfw
 * JD-Core Version:    0.7.0.1
 */