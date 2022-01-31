import UserGrowth.stWeishiReportRsp;

final class tjs
  implements tgt
{
  tjs(String paramString) {}
  
  public void a(the paramthe)
  {
    tlo.b("weishi-report", "report " + this.a + " start...");
    if ((paramthe != null) && (paramthe.a != null) && ((paramthe.a instanceof stWeishiReportRsp)))
    {
      paramthe = (stWeishiReportRsp)paramthe.a;
      tlo.b("weishi-report", "report" + this.a + "end: " + paramthe.code + paramthe.msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjs
 * JD-Core Version:    0.7.0.1
 */