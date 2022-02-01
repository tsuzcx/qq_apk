import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class yhg
  extends wjm<yhc, yff>
{
  yhg(yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull yff paramyff)
  {
    if ((!paramyff.jdField_a_of_type_JavaLangString.equals(yhc.a(paramyhc))) || (paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (yhc.a(paramyhc) == null)) {
      yuk.b(this.TAG, "ignore this comment list event. %s.", paramyff.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      yuk.a(this.TAG, "receive comment list event. %s.", paramyff.toString());
      bool2 = yhc.a(paramyhc);
      bool1 = true;
      if (paramyff.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      yhc.a(paramyhc).a(bool1);
      yhc.a(paramyhc).a(bool1, paramyff.b);
      yhc.a(paramyhc).a(bool1, paramyff.jdField_a_of_type_Boolean);
      yhc.a(paramyhc).a(paramyff.jdField_a_of_type_JavaUtilList, paramyff.c, bool1);
    } while (bool2 != bool1);
    paramyhc.b(paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return yff.class;
  }
  
  public void b(@NonNull yhc paramyhc, @NonNull yff paramyff) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhg
 * JD-Core Version:    0.7.0.1
 */