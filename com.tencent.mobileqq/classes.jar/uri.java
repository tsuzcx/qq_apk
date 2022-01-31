import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uri
  extends ste<uqv, upt>
{
  uri(uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull upt paramupt)
  {
    if ((!paramupt.jdField_a_of_type_Boolean) || (!paramupt.jdField_a_of_type_JavaLangString.equals(uqv.a(paramuqv))) || (paramupt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uqv.a(paramuqv) == null))
    {
      ved.b(this.TAG, "ignore this like list event. %s.", paramupt.toString());
      return;
    }
    ved.a(this.TAG, "receive like list event. %s.", paramupt.toString());
    boolean bool2 = uqv.a(paramuqv);
    if (paramupt.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      uqv.a(paramuqv).b(bool1, paramupt.b);
      uqv.a(paramuqv).b(paramupt.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramuqv.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return upt.class;
  }
  
  public void b(@NonNull uqv paramuqv, @NonNull upt paramupt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uri
 * JD-Core Version:    0.7.0.1
 */