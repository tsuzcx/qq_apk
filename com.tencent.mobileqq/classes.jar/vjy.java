import UserGrowth.stWeishiReportRsp;

final class vjy
  implements vfg
{
  vjy(String paramString) {}
  
  public void a(vfr paramvfr)
  {
    vmp.b("weishi-report", "report " + this.a + " start...");
    if ((paramvfr != null) && (paramvfr.a != null) && ((paramvfr.a instanceof stWeishiReportRsp)))
    {
      paramvfr = (stWeishiReportRsp)paramvfr.a;
      vmp.b("weishi-report", "report" + this.a + "end: " + paramvfr.code + paramvfr.msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjy
 * JD-Core Version:    0.7.0.1
 */