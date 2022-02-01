import com.tencent.qphone.base.util.QLog;

class ltu
  extends lce
{
  ltu(ltp paramltp) {}
  
  public void qC(int paramInt)
  {
    boolean bool;
    if (paramInt < 3)
    {
      bool = true;
      QLog.d(ltp.a(this.this$0), 1, "visibility changed, visible :  " + bool);
      if (!bool) {
        break label66;
      }
      ltp.b(this.this$0);
    }
    for (;;)
    {
      if (paramInt == 5) {
        lcc.a().c(this);
      }
      return;
      bool = false;
      break;
      label66:
      if (ltp.a(this.this$0) != null) {
        ltp.a(this.this$0).stopLoop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltu
 * JD-Core Version:    0.7.0.1
 */