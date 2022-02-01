import UserGrowth.stBlockRecommPersonRsp;

class ugq
  implements ukd
{
  ugq(ugp paramugp) {}
  
  public void a(uko paramuko)
  {
    if (!(paramuko.a instanceof stBlockRecommPersonRsp)) {
      uqf.b("WSUserBusiness", "[actionBlockRecommendPerson] data error: " + paramuko.a);
    }
    do
    {
      return;
      paramuko = (stBlockRecommPersonRsp)paramuko.a;
    } while (paramuko == null);
    uqf.b("WSUserBusiness", "[actionBlockRecommendPerson] data success resultBean.ret:" + paramuko.ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugq
 * JD-Core Version:    0.7.0.1
 */