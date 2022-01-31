public class tif
  implements thf
{
  private tfk a;
  
  public void a(tgd paramtgd)
  {
    if ((paramtgd instanceof tfk)) {
      this.a = ((tfk)paramtgd);
    }
  }
  
  public void a(thl paramthl) {}
  
  public void a(thl paramthl, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(thl paramthl, int paramInt, boolean paramBoolean) {}
  
  public void a(thl paramthl, long paramLong1, long paramLong2) {}
  
  public void a(thl paramthl, boolean paramBoolean) {}
  
  public void a(thl paramthl, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a != null) && (paramBoolean1) && (paramBoolean2)) {
      this.a.a(8, 400);
    }
    tlo.e("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + paramthl.jdField_a_of_type_Thp.d + "\nisPreOutputFirstFrame:" + paramBoolean1 + ", isFirstFrameDrawSuccess:" + paramBoolean2 + "\nmFollowPlayableHolder:" + this.a);
  }
  
  public boolean a(thl paramthl)
  {
    return false;
  }
  
  public void b(thl paramthl) {}
  
  public void c(thl paramthl)
  {
    if (this.a != null) {
      if ((paramthl == null) || (paramthl.jdField_a_of_type_Tho == null) || (!paramthl.jdField_a_of_type_Tho.b())) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.a.a(bool);
      this.a.a(8, 0);
      return;
    }
  }
  
  public void d(thl paramthl)
  {
    if (this.a != null)
    {
      this.a.a(true);
      this.a.a(8, 400);
      tlo.a("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramthl.jdField_a_of_type_Thp.d);
    }
  }
  
  public void e(thl paramthl)
  {
    if (this.a != null) {
      this.a.a(false);
    }
  }
  
  public void f(thl paramthl)
  {
    if (this.a != null) {
      this.a.a(true);
    }
  }
  
  public void g(thl paramthl)
  {
    if (this.a != null)
    {
      this.a.a(false);
      this.a.a(0, 0);
    }
  }
  
  public void h(thl paramthl) {}
  
  public void i(thl paramthl) {}
  
  public void j(thl paramthl)
  {
    if (this.a != null) {
      this.a.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tif
 * JD-Core Version:    0.7.0.1
 */