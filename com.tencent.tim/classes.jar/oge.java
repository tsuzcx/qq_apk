import UserGrowth.stUserConfigRsp;

final class oge
  implements oko
{
  public void a(okz paramokz)
  {
    if (paramokz.succeeded())
    {
      if ((paramokz.bb instanceof stUserConfigRsp))
      {
        paramokz = (stUserConfigRsp)paramokz.bb;
        ooz.i("WSUserAuthDialog", "doTask: UserConfig response :  code = " + paramokz.code);
        return;
      }
      ooz.i("WSUserAuthDialog", "doTask: UserConfig response : response is not instanceof stUserConfigRsp");
      return;
    }
    ooz.i("WSUserAuthDialog", "doTask: UserConfig response : !task.succeeded()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oge
 * JD-Core Version:    0.7.0.1
 */