public class arvq
{
  private android.webkit.CookieManager a = android.webkit.CookieManager.getInstance();
  private com.tencent.smtt.sdk.CookieManager c = com.tencent.smtt.sdk.CookieManager.getInstance();
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.setAcceptCookie(paramBoolean);
    }
    if (this.a != null) {
      this.a.setAcceptCookie(paramBoolean);
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    if (this.c != null) {
      this.c.setCookie(paramString1, paramString2);
    }
    if (this.a != null) {
      this.a.setCookie(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvq
 * JD-Core Version:    0.7.0.1
 */