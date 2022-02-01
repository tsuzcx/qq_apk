import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class yhp
  extends wjm<yhc, yga>
{
  yhp(yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull yga paramyga)
  {
    if ((!paramyga.jdField_a_of_type_Boolean) || (!paramyga.jdField_a_of_type_JavaLangString.equals(yhc.a(paramyhc))) || (paramyga.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (yhc.a(paramyhc) == null))
    {
      yuk.b(this.TAG, "ignore this like list event. %s.", paramyga.toString());
      return;
    }
    yuk.a(this.TAG, "receive like list event. %s.", paramyga.toString());
    boolean bool2 = yhc.a(paramyhc);
    if (paramyga.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      yhc.a(paramyhc).b(bool1, paramyga.b);
      yhc.a(paramyhc).b(paramyga.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramyhc.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return yga.class;
  }
  
  public void b(@NonNull yhc paramyhc, @NonNull yga paramyga) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhp
 * JD-Core Version:    0.7.0.1
 */