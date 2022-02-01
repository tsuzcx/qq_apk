public class ult
  implements ukp
{
  private uhz jdField_a_of_type_Uhz;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if ((this.jdField_a_of_type_Uhz != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Uhz.c();
    }
  }
  
  public void a(uiu paramuiu)
  {
    if ((paramuiu instanceof uhz)) {
      this.jdField_a_of_type_Uhz = ((uhz)paramuiu);
    }
  }
  
  public void a(ukz paramukz) {}
  
  public void a(ukz paramukz, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(ukz paramukz, int paramInt, boolean paramBoolean) {}
  
  public void a(ukz paramukz, long paramLong1, long paramLong2)
  {
    if (paramLong1 > 2000L) {
      a();
    }
  }
  
  public void a(ukz paramukz, boolean paramBoolean) {}
  
  public void a(ukz paramukz, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Uhz != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Uhz.a(8, 400);
    }
    uqf.e("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + paramukz.jdField_a_of_type_Uld.d + "\nisPreOutputFirstFrame:" + paramBoolean1 + ", isFirstFrameDrawSuccess:" + paramBoolean2 + "\nmFollowPlayableHolder:" + this.jdField_a_of_type_Uhz);
  }
  
  public boolean a(ukz paramukz)
  {
    return false;
  }
  
  public void b(ukz paramukz) {}
  
  public void c(ukz paramukz)
  {
    if ((this.jdField_a_of_type_Uhz != null) && (paramukz != null) && (paramukz.jdField_a_of_type_Ulc != null))
    {
      boolean bool = paramukz.jdField_a_of_type_Ulc.b();
      this.jdField_a_of_type_Uhz.b(bool);
      paramukz = this.jdField_a_of_type_Uhz;
      if (!bool) {
        break label57;
      }
    }
    label57:
    for (int i = 8;; i = 0)
    {
      paramukz.a(i, 0);
      a();
      return;
    }
  }
  
  public void d(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uhz != null)
    {
      this.jdField_a_of_type_Uhz.b(true);
      this.jdField_a_of_type_Uhz.a(8, 400);
      this.jdField_a_of_type_Uhz.c(true);
      uqf.a("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramukz.jdField_a_of_type_Uld.d);
    }
  }
  
  public void e(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uhz != null)
    {
      this.jdField_a_of_type_Uhz.b(false);
      this.jdField_a_of_type_Uhz.d(true);
    }
  }
  
  public void f(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uhz != null)
    {
      this.jdField_a_of_type_Uhz.b(true);
      this.jdField_a_of_type_Uhz.d(false);
    }
  }
  
  public void g(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uhz != null)
    {
      this.jdField_a_of_type_Uhz.b(false);
      this.jdField_a_of_type_Uhz.a(0, 0);
      this.jdField_a_of_type_Uhz.c(false);
    }
    a();
  }
  
  public void h(ukz paramukz) {}
  
  public void i(ukz paramukz) {}
  
  public void j(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uhz != null) {
      this.jdField_a_of_type_Uhz.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ult
 * JD-Core Version:    0.7.0.1
 */