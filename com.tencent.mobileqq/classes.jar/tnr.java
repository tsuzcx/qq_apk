import UserGrowth.stSimpleGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.List;

class tnr
  implements tgt
{
  tnr(tnq paramtnq, tmr paramtmr) {}
  
  public void a(the paramthe)
  {
    if (!paramthe.a())
    {
      tlo.d("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramthe.jdField_a_of_type_Int + ", msg:" + paramthe.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Tmr != null) {
        this.jdField_a_of_type_Tmr.a(paramthe.jdField_a_of_type_Int, paramthe.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (!(paramthe.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedDetailRsp)) {
            break;
          }
          paramthe = ((stSimpleGetFeedDetailRsp)paramthe.jdField_a_of_type_JavaLangObject).feed;
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramthe);
          paramthe = tms.a().a((ArrayList)localObject);
        } while ((this.jdField_a_of_type_Tnq.a == null) || (this.jdField_a_of_type_Tnq.a.a() == null) || (this.jdField_a_of_type_Tnq.a.a().a() == null));
        localObject = this.jdField_a_of_type_Tnq.a.a().a().a;
      } while (!(localObject instanceof tnk));
      ((tnk)localObject).b((tmv)paramthe.get(0));
      return;
    } while (this.jdField_a_of_type_Tmr == null);
    this.jdField_a_of_type_Tmr.a(paramthe.b, paramthe.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnr
 * JD-Core Version:    0.7.0.1
 */