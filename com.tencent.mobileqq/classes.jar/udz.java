import UserGrowth.stUserConfigRsp;

final class udz
  implements ujj
{
  public void a(uju paramuju)
  {
    if (paramuju.a())
    {
      if ((paramuju.a instanceof stUserConfigRsp))
      {
        paramuju = (stUserConfigRsp)paramuju.a;
        upe.a("WSUserAuthDialog", "doTask: UserConfig response :  code = " + paramuju.code);
        return;
      }
      upe.a("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
      return;
    }
    upe.a("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udz
 * JD-Core Version:    0.7.0.1
 */