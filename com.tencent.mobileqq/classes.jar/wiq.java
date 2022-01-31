class wiq
  implements wth
{
  wiq(wip paramwip, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_Wip.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0}" });
      if (wip.a(this.jdField_a_of_type_Wip) == null)
      {
        wip.a(this.jdField_a_of_type_Wip, wxr.a());
        wip.a(this.jdField_a_of_type_Wip).a();
      }
      wip.a(this.jdField_a_of_type_Wip).i(paramString, this.b);
      xhb.a(paramString, "auth_follow", "clk_unfollow", 0, 0, new String[] { "", "", this.b });
      return;
    }
    xhb.a(paramString, "auth_follow", "clk_cancel", 0, 0, new String[] { "", "", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wiq
 * JD-Core Version:    0.7.0.1
 */