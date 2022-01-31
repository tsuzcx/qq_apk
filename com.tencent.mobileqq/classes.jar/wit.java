class wit
  implements wtk
{
  wit(wis paramwis, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_Wis.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0}" });
      if (wis.a(this.jdField_a_of_type_Wis) == null)
      {
        wis.a(this.jdField_a_of_type_Wis, wxu.a());
        wis.a(this.jdField_a_of_type_Wis).a();
      }
      wis.a(this.jdField_a_of_type_Wis).i(paramString, this.b);
      xhe.a(paramString, "auth_follow", "clk_unfollow", 0, 0, new String[] { "", "", this.b });
      return;
    }
    xhe.a(paramString, "auth_follow", "clk_cancel", 0, 0, new String[] { "", "", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wit
 * JD-Core Version:    0.7.0.1
 */