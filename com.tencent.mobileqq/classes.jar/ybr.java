class ybr
  implements ymm
{
  ybr(ybq paramybq, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_Ybq.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0}" });
      if (ybq.a(this.jdField_a_of_type_Ybq) == null)
      {
        ybq.a(this.jdField_a_of_type_Ybq, yqz.a());
        ybq.a(this.jdField_a_of_type_Ybq).a();
      }
      ybq.a(this.jdField_a_of_type_Ybq).i(paramString, this.b);
      zaj.a(paramString, "auth_follow", "clk_unfollow", 0, 0, new String[] { "", "", this.b });
      return;
    }
    zaj.a(paramString, "auth_follow", "clk_cancel", 0, 0, new String[] { "", "", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybr
 * JD-Core Version:    0.7.0.1
 */