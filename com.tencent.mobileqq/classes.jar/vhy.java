public class vhy
  implements vfs
{
  private vcu jdField_a_of_type_Vcu;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if ((this.jdField_a_of_type_Vcu != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Vcu.c();
    }
  }
  
  public void a(vdq paramvdq)
  {
    if ((paramvdq instanceof vcu)) {
      this.jdField_a_of_type_Vcu = ((vcu)paramvdq);
    }
  }
  
  public void a(vgb paramvgb) {}
  
  public void a(vgb paramvgb, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(vgb paramvgb, int paramInt, boolean paramBoolean) {}
  
  public void a(vgb paramvgb, long paramLong1, long paramLong2)
  {
    if (paramLong1 > 2000L) {
      a();
    }
  }
  
  public void a(vgb paramvgb, boolean paramBoolean) {}
  
  public void a(vgb paramvgb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Vcu != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Vcu.a(8, 400);
    }
    vmp.e("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + paramvgb.jdField_a_of_type_Vgi.d + "\nisPreOutputFirstFrame:" + paramBoolean1 + ", isFirstFrameDrawSuccess:" + paramBoolean2 + "\nmFollowPlayableHolder:" + this.jdField_a_of_type_Vcu);
  }
  
  public boolean a(vgb paramvgb)
  {
    return false;
  }
  
  public void b(vgb paramvgb) {}
  
  public void c(vgb paramvgb)
  {
    if ((this.jdField_a_of_type_Vcu != null) && (paramvgb != null) && (paramvgb.jdField_a_of_type_Vgh != null))
    {
      boolean bool = paramvgb.jdField_a_of_type_Vgh.b();
      this.jdField_a_of_type_Vcu.b(bool);
      paramvgb = this.jdField_a_of_type_Vcu;
      if (!bool) {
        break label57;
      }
    }
    label57:
    for (int i = 8;; i = 0)
    {
      paramvgb.a(i, 0);
      a();
      return;
    }
  }
  
  public void d(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vcu != null)
    {
      this.jdField_a_of_type_Vcu.b(true);
      this.jdField_a_of_type_Vcu.a(8, 400);
      this.jdField_a_of_type_Vcu.c(true);
      vmp.a("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + paramvgb.jdField_a_of_type_Vgi.d);
    }
  }
  
  public void e(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vcu != null)
    {
      this.jdField_a_of_type_Vcu.b(false);
      this.jdField_a_of_type_Vcu.d(true);
    }
  }
  
  public void f(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vcu != null)
    {
      this.jdField_a_of_type_Vcu.b(true);
      this.jdField_a_of_type_Vcu.d(false);
    }
  }
  
  public void g(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vcu != null)
    {
      this.jdField_a_of_type_Vcu.b(false);
      this.jdField_a_of_type_Vcu.a(0, 0);
      this.jdField_a_of_type_Vcu.c(false);
    }
    a();
  }
  
  public void h(vgb paramvgb) {}
  
  public void i(vgb paramvgb) {}
  
  public void j(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vcu != null) {
      this.jdField_a_of_type_Vcu.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhy
 * JD-Core Version:    0.7.0.1
 */