import UserGrowth.stSimpleGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;

class tmt
  implements tgt
{
  tmt(tms paramtms, tmr paramtmr) {}
  
  public void a(the paramthe)
  {
    if (!paramthe.a())
    {
      tlo.d("WSVerticalDataManagerLog", "fetchVerticalListData failed code:" + paramthe.jdField_a_of_type_Int + ", msg:" + paramthe.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Tmr != null) {
        this.jdField_a_of_type_Tmr.a(paramthe.jdField_a_of_type_Int, paramthe.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (!(paramthe.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) {
          break;
        }
        stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject;
        localObject = localstSimpleGetFeedListRsp.feeds;
        localObject = this.jdField_a_of_type_Tms.a((ArrayList)localObject);
        if (paramthe.jdField_a_of_type_Tgu != null) {
          tee.a().a(localstSimpleGetFeedListRsp.trace_id, paramthe.jdField_a_of_type_Tgu.a);
        }
      } while (this.jdField_a_of_type_Tmr == null);
      this.jdField_a_of_type_Tmr.a((List)localObject);
      return;
    } while (this.jdField_a_of_type_Tmr == null);
    this.jdField_a_of_type_Tmr.a(paramthe.b, paramthe.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmt
 * JD-Core Version:    0.7.0.1
 */