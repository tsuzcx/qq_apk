import UserGrowth.stUserConfigRsp;

final class ueb
  implements ukd
{
  public void a(uko paramuko)
  {
    if (paramuko.a())
    {
      if ((paramuko.a instanceof stUserConfigRsp))
      {
        paramuko = (stUserConfigRsp)paramuko.a;
        uqf.a("WSUserAuthDialog", "doTask: UserConfig response :  code = " + paramuko.code);
        return;
      }
      uqf.a("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
      return;
    }
    uqf.a("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ueb
 * JD-Core Version:    0.7.0.1
 */