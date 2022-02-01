import UserGrowth.stUserConfigRsp;

final class ukr
  implements uqy
{
  public void a(urj paramurj)
  {
    if (paramurj.a())
    {
      if ((paramurj.a instanceof stUserConfigRsp))
      {
        paramurj = (stUserConfigRsp)paramurj.a;
        uya.a("WSUserAuthDialog", "doTask: UserConfig response :  code = " + paramurj.code);
        return;
      }
      uya.a("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
      return;
    }
    uya.a("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukr
 * JD-Core Version:    0.7.0.1
 */