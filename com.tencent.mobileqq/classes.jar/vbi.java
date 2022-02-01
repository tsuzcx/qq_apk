import UserGrowth.stFollowRsp;

class vbi
  implements vfg
{
  vbi(vbg paramvbg, int paramInt, String paramString) {}
  
  public void a(vfr paramvfr)
  {
    if (!(paramvfr.a instanceof stFollowRsp))
    {
      if (this.jdField_a_of_type_Int == 2) {
        vbg.a(this.jdField_a_of_type_Vbg, this.jdField_a_of_type_JavaLangString, 1);
      }
      for (;;)
      {
        vmp.b("WSUserBusiness", "[getServiceListenerWrapper] data error: " + paramvfr.a);
        return;
        vbg.a(this.jdField_a_of_type_Vbg, this.jdField_a_of_type_JavaLangString, 2);
      }
    }
    int i = ((stFollowRsp)paramvfr.a).isFollow;
    vmp.b("WSUserBusiness", "[getServiceListenerWrapper] isFollow : " + i);
    if (this.jdField_a_of_type_Int == 1)
    {
      if (i == 1)
      {
        bjkv.a().a(2131720132);
        return;
      }
      bjkv.a().a(2131720130);
      vbg.a(this.jdField_a_of_type_Vbg, this.jdField_a_of_type_JavaLangString, 2);
      return;
    }
    if (i == 0)
    {
      bjkv.a().a(2131720134);
      return;
    }
    bjkv.a().a(2131720135);
    vbg.a(this.jdField_a_of_type_Vbg, this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbi
 * JD-Core Version:    0.7.0.1
 */