class rzc
  implements shk.c
{
  rzc(rzb paramrzb, String paramString1, String paramString2) {}
  
  public void g(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.this$0.callJs(this.val$callback, new String[] { "{\"result\":0}" });
      if (rzb.a(this.this$0) == null)
      {
        rzb.a(this.this$0, skj.a());
        rzb.a(this.this$0).bzj();
      }
      rzb.a(this.this$0).cL(paramString, this.val$nick);
      sqn.b(paramString, "auth_follow", "clk_unfollow", 0, 0, new String[] { "", "", this.val$nick });
      return;
    }
    sqn.b(paramString, "auth_follow", "clk_cancel", 0, 0, new String[] { "", "", this.val$nick });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzc
 * JD-Core Version:    0.7.0.1
 */