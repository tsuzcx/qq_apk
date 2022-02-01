public class ukv
  implements ujv
{
  private uhk a;
  
  public void a(uif paramuif)
  {
    if ((paramuif instanceof uhk)) {
      this.a = ((uhk)paramuif);
    }
  }
  
  public void a(ukb paramukb) {}
  
  public void a(ukb paramukb, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(ukb paramukb, int paramInt, boolean paramBoolean) {}
  
  public void a(ukb paramukb, long paramLong1, long paramLong2) {}
  
  public void a(ukb paramukb, boolean paramBoolean) {}
  
  public void a(ukb paramukb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a != null) && (paramBoolean1) && (paramBoolean2)) {
      this.a.a(8, 400);
    }
    upe.e("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + paramukb.jdField_a_of_type_Ukf.d + "\nisPreOutputFirstFrame:" + paramBoolean1 + ", isFirstFrameDrawSuccess:" + paramBoolean2 + "\nmFollowPlayableHolder:" + this.a);
  }
  
  public boolean a(ukb paramukb)
  {
    return false;
  }
  
  public void b(ukb paramukb) {}
  
  public void c(ukb paramukb)
  {
    if ((this.a != null) && (paramukb != null) && (paramukb.jdField_a_of_type_Uke != null))
    {
      boolean bool = paramukb.jdField_a_of_type_Uke.b();
      this.a.a(bool);
      if (paramukb.jdField_a_of_type_Uke.b()) {
        this.a.a(8, 0);
      }
    }
    else
    {
      return;
    }
    this.a.a(0, 0);
  }
  
  public void d(ukb paramukb)
  {
    if (this.a != null)
    {
      this.a.a(true);
      this.a.a(8, 400);
      upe.a("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramukb.jdField_a_of_type_Ukf.d);
    }
  }
  
  public void e(ukb paramukb)
  {
    if (this.a != null) {
      this.a.a(false);
    }
  }
  
  public void f(ukb paramukb)
  {
    if (this.a != null) {
      this.a.a(true);
    }
  }
  
  public void g(ukb paramukb)
  {
    if (this.a != null)
    {
      this.a.a(false);
      this.a.a(0, 0);
    }
  }
  
  public void h(ukb paramukb) {}
  
  public void i(ukb paramukb) {}
  
  public void j(ukb paramukb)
  {
    if (this.a != null) {
      this.a.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukv
 * JD-Core Version:    0.7.0.1
 */