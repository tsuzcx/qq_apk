package net.openid.appauth;

class SystemClock
  implements Clock
{
  public static final SystemClock INSTANCE = new SystemClock();
  
  public long getCurrentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.SystemClock
 * JD-Core Version:    0.7.0.1
 */