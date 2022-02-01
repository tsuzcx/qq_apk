class zbf
  implements zkl
{
  zbf(zbe paramzbe, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_Zbe.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0}" });
      if (zbe.a(this.jdField_a_of_type_Zbe) == null)
      {
        zbe.a(this.jdField_a_of_type_Zbe, zon.a());
        zbe.a(this.jdField_a_of_type_Zbe).a();
      }
      zbe.a(this.jdField_a_of_type_Zbe).i(paramString, this.b);
      zxp.a(paramString, "auth_follow", "clk_unfollow", 0, 0, new String[] { "", "", this.b });
      return;
    }
    zxp.a(paramString, "auth_follow", "clk_cancel", 0, 0, new String[] { "", "", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbf
 * JD-Core Version:    0.7.0.1
 */