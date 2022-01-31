import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class urc
  extends sth<uqy, upb>
{
  urc(uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull upb paramupb)
  {
    if ((!paramupb.jdField_a_of_type_JavaLangString.equals(uqy.a(paramuqy))) || (paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uqy.a(paramuqy) == null)) {
      veg.b(this.TAG, "ignore this comment list event. %s.", paramupb.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      veg.a(this.TAG, "receive comment list event. %s.", paramupb.toString());
      bool2 = uqy.a(paramuqy);
      bool1 = true;
      if (paramupb.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      uqy.a(paramuqy).a(bool1);
      uqy.a(paramuqy).a(bool1, paramupb.b);
      uqy.a(paramuqy).a(bool1, paramupb.jdField_a_of_type_Boolean);
      uqy.a(paramuqy).a(paramupb.jdField_a_of_type_JavaUtilList, paramupb.c, bool1);
    } while (bool2 != bool1);
    paramuqy.b(paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return upb.class;
  }
  
  public void b(@NonNull uqy paramuqy, @NonNull upb paramupb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */