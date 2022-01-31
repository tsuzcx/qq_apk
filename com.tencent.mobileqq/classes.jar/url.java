import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class url
  extends sth<uqy, upw>
{
  url(uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull upw paramupw)
  {
    if ((!paramupw.jdField_a_of_type_Boolean) || (!paramupw.jdField_a_of_type_JavaLangString.equals(uqy.a(paramuqy))) || (paramupw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uqy.a(paramuqy) == null))
    {
      veg.b(this.TAG, "ignore this like list event. %s.", paramupw.toString());
      return;
    }
    veg.a(this.TAG, "receive like list event. %s.", paramupw.toString());
    boolean bool2 = uqy.a(paramuqy);
    if (paramupw.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      uqy.a(paramuqy).b(bool1, paramupw.b);
      uqy.a(paramuqy).b(paramupw.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramuqy.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return upw.class;
  }
  
  public void b(@NonNull uqy paramuqy, @NonNull upw paramupw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     url
 * JD-Core Version:    0.7.0.1
 */