import UserGrowth.stBlockRecommPersonRsp;

class vbh
  implements vfg
{
  vbh(vbg paramvbg) {}
  
  public void a(vfr paramvfr)
  {
    if (!(paramvfr.a instanceof stBlockRecommPersonRsp)) {
      vmp.b("WSUserBusiness", "[actionBlockRecommendPerson] data error: " + paramvfr.a);
    }
    do
    {
      return;
      paramvfr = (stBlockRecommPersonRsp)paramvfr.a;
    } while (paramvfr == null);
    vmp.b("WSUserBusiness", "[actionBlockRecommendPerson] data success resultBean.ret:" + paramvfr.ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbh
 * JD-Core Version:    0.7.0.1
 */