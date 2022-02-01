public class utn
  implements urk
{
  private uou jdField_a_of_type_Uou;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if ((this.jdField_a_of_type_Uou != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Uou.c();
    }
  }
  
  public void a(upp paramupp)
  {
    if ((paramupp instanceof uou)) {
      this.jdField_a_of_type_Uou = ((uou)paramupp);
    }
  }
  
  public void a(urt paramurt) {}
  
  public void a(urt paramurt, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(urt paramurt, int paramInt, boolean paramBoolean) {}
  
  public void a(urt paramurt, long paramLong1, long paramLong2)
  {
    if (paramLong1 > 2000L) {
      a();
    }
  }
  
  public void a(urt paramurt, boolean paramBoolean) {}
  
  public void a(urt paramurt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Uou != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Uou.a(8, 400);
    }
    uya.e("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + paramurt.jdField_a_of_type_Urx.d + "\nisPreOutputFirstFrame:" + paramBoolean1 + ", isFirstFrameDrawSuccess:" + paramBoolean2 + "\nmFollowPlayableHolder:" + this.jdField_a_of_type_Uou);
  }
  
  public boolean a(urt paramurt)
  {
    return false;
  }
  
  public void b(urt paramurt) {}
  
  public void c(urt paramurt)
  {
    if ((this.jdField_a_of_type_Uou != null) && (paramurt != null) && (paramurt.jdField_a_of_type_Urw != null))
    {
      boolean bool = paramurt.jdField_a_of_type_Urw.b();
      this.jdField_a_of_type_Uou.b(bool);
      paramurt = this.jdField_a_of_type_Uou;
      if (!bool) {
        break label57;
      }
    }
    label57:
    for (int i = 8;; i = 0)
    {
      paramurt.a(i, 0);
      a();
      return;
    }
  }
  
  public void d(urt paramurt)
  {
    if (this.jdField_a_of_type_Uou != null)
    {
      this.jdField_a_of_type_Uou.b(true);
      this.jdField_a_of_type_Uou.a(8, 400);
      this.jdField_a_of_type_Uou.c(true);
      uya.a("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramurt.jdField_a_of_type_Urx.d);
    }
  }
  
  public void e(urt paramurt)
  {
    if (this.jdField_a_of_type_Uou != null)
    {
      this.jdField_a_of_type_Uou.b(false);
      this.jdField_a_of_type_Uou.d(true);
    }
  }
  
  public void f(urt paramurt)
  {
    if (this.jdField_a_of_type_Uou != null)
    {
      this.jdField_a_of_type_Uou.b(true);
      this.jdField_a_of_type_Uou.d(false);
    }
  }
  
  public void g(urt paramurt)
  {
    if (this.jdField_a_of_type_Uou != null)
    {
      this.jdField_a_of_type_Uou.b(false);
      this.jdField_a_of_type_Uou.a(0, 0);
      this.jdField_a_of_type_Uou.c(false);
    }
    a();
  }
  
  public void h(urt paramurt) {}
  
  public void i(urt paramurt) {}
  
  public void j(urt paramurt)
  {
    if (this.jdField_a_of_type_Uou != null) {
      this.jdField_a_of_type_Uou.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utn
 * JD-Core Version:    0.7.0.1
 */