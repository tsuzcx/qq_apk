import common.config.service.QzoneConfig;

public class avce
{
  private static volatile avce a;
  private static final Object mLock = new Object();
  
  public static avce a()
  {
    if (a == null) {}
    synchronized (mLock)
    {
      if (a == null) {
        a = new avce();
      }
      return a;
    }
  }
  
  public int PA()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avce
 * JD-Core Version:    0.7.0.1
 */