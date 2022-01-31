import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

class zqm
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  zqm(zqk paramzqk) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      zqk.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqm
 * JD-Core Version:    0.7.0.1
 */