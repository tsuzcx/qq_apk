import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uep
  extends sgl<uec, uda>
{
  uep(uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull uda paramuda)
  {
    if ((!paramuda.jdField_a_of_type_Boolean) || (!paramuda.jdField_a_of_type_JavaLangString.equals(uec.a(paramuec))) || (paramuda.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uec.a(paramuec) == null))
    {
      urk.b(this.TAG, "ignore this like list event. %s.", paramuda.toString());
      return;
    }
    urk.a(this.TAG, "receive like list event. %s.", paramuda.toString());
    boolean bool2 = uec.a(paramuec);
    if (paramuda.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      uec.a(paramuec).b(bool1, paramuda.b);
      uec.a(paramuec).b(paramuda.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramuec.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return uda.class;
  }
  
  public void b(@NonNull uec paramuec, @NonNull uda paramuda) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uep
 * JD-Core Version:    0.7.0.1
 */