import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uqz
  extends ste<uqv, uoy>
{
  uqz(uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull uoy paramuoy)
  {
    if ((!paramuoy.jdField_a_of_type_JavaLangString.equals(uqv.a(paramuqv))) || (paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uqv.a(paramuqv) == null)) {
      ved.b(this.TAG, "ignore this comment list event. %s.", paramuoy.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      ved.a(this.TAG, "receive comment list event. %s.", paramuoy.toString());
      bool2 = uqv.a(paramuqv);
      bool1 = true;
      if (paramuoy.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      uqv.a(paramuqv).a(bool1);
      uqv.a(paramuqv).a(bool1, paramuoy.b);
      uqv.a(paramuqv).a(bool1, paramuoy.jdField_a_of_type_Boolean);
      uqv.a(paramuqv).a(paramuoy.jdField_a_of_type_JavaUtilList, paramuoy.c, bool1);
    } while (bool2 != bool1);
    paramuqv.b(paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return uoy.class;
  }
  
  public void b(@NonNull uqv paramuqv, @NonNull uoy paramuoy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqz
 * JD-Core Version:    0.7.0.1
 */