import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;

public class ahsx
{
  private static ahsx a;
  private GameCenterVideoViewController b;
  
  public static ahsx a()
  {
    try
    {
      if (a == null) {
        a = new ahsx();
      }
      ahsx localahsx = a;
      return localahsx;
    }
    finally {}
  }
  
  public GameCenterVideoViewController a()
  {
    return this.b;
  }
  
  public void a(GameCenterVideoViewController paramGameCenterVideoViewController)
  {
    if ((this.b != null) && (this.b != null) && (this.b != paramGameCenterVideoViewController) && (this.b != null))
    {
      this.b.stop();
      this.b.release();
    }
    this.b = paramGameCenterVideoViewController;
  }
  
  public void cOC()
  {
    if (this.b != null)
    {
      this.b.stop();
      this.b.release();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsx
 * JD-Core Version:    0.7.0.1
 */