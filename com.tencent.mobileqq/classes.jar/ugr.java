import UserGrowth.stFollowRsp;

class ugr
  implements ukd
{
  ugr(ugp paramugp, int paramInt, String paramString) {}
  
  public void a(uko paramuko)
  {
    if (!(paramuko.a instanceof stFollowRsp))
    {
      if (this.jdField_a_of_type_Int == 2) {
        ugp.a(this.jdField_a_of_type_Ugp, this.jdField_a_of_type_JavaLangString, 1);
      }
      for (;;)
      {
        uqf.b("WSUserBusiness", "[getServiceListenerWrapper] data error: " + paramuko.a);
        return;
        ugp.a(this.jdField_a_of_type_Ugp, this.jdField_a_of_type_JavaLangString, 2);
      }
    }
    int i = ((stFollowRsp)paramuko.a).isFollow;
    uqf.b("WSUserBusiness", "[getServiceListenerWrapper] isFollow : " + i);
    if (this.jdField_a_of_type_Int == 1)
    {
      if (i == 1)
      {
        bjuh.a().a(2131719361);
        return;
      }
      bjuh.a().a(2131719359);
      ugp.a(this.jdField_a_of_type_Ugp, this.jdField_a_of_type_JavaLangString, 2);
      return;
    }
    if (i == 0)
    {
      bjuh.a().a(2131719363);
      return;
    }
    bjuh.a().a(2131719364);
    ugp.a(this.jdField_a_of_type_Ugp, this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugr
 * JD-Core Version:    0.7.0.1
 */