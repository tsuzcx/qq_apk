public class ols
  implements ola
{
  private oiy b;
  
  public void a(ole paramole, int paramInt, boolean paramBoolean) {}
  
  public void a(ole paramole, long paramLong1, long paramLong2) {}
  
  public void a(ole paramole, boolean paramBoolean) {}
  
  public boolean a(ole paramole)
  {
    return false;
  }
  
  public void b(ole paramole) {}
  
  public void c(ole paramole)
  {
    if (this.b != null) {
      if ((paramole == null) || (paramole.c == null) || (!paramole.c.isPlaying())) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.b.qK(bool);
      this.b.dB(8, 0);
      return;
    }
  }
  
  public void d(ole paramole)
  {
    if (this.b != null)
    {
      this.b.qK(true);
      this.b.dB(8, 400);
      ooz.i("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramole.a.mTitle);
    }
  }
  
  public void e(ojm paramojm)
  {
    if ((paramojm instanceof oiy)) {
      this.b = ((oiy)paramojm);
    }
  }
  
  public void e(ole paramole)
  {
    if (this.b != null) {
      this.b.qK(false);
    }
  }
  
  public void f(ole paramole)
  {
    if (this.b != null) {
      this.b.qK(true);
    }
  }
  
  public void g(ole paramole)
  {
    if (this.b != null)
    {
      this.b.qK(false);
      this.b.dB(0, 0);
    }
  }
  
  public void h(ole paramole) {}
  
  public void i(ole paramole) {}
  
  public void j(ole paramole)
  {
    if (this.b != null) {
      this.b.dB(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ols
 * JD-Core Version:    0.7.0.1
 */