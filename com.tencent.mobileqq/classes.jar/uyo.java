import UserGrowth.stUserConfigRsp;

final class uyo
  implements vfg
{
  public void a(vfr paramvfr)
  {
    if (paramvfr.a())
    {
      if ((paramvfr.a instanceof stUserConfigRsp))
      {
        paramvfr = (stUserConfigRsp)paramvfr.a;
        vmp.a("WSUserAuthDialog", "doTask: UserConfig response :  code = " + paramvfr.code);
        return;
      }
      vmp.a("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
      return;
    }
    vmp.a("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyo
 * JD-Core Version:    0.7.0.1
 */