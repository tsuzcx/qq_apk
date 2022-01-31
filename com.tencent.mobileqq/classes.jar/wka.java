import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wka
  extends umf<wjw, whz>
{
  wka(wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull whz paramwhz)
  {
    if ((!paramwhz.jdField_a_of_type_JavaLangString.equals(wjw.a(paramwjw))) || (paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wjw.a(paramwjw) == null)) {
      wxe.b(this.TAG, "ignore this comment list event. %s.", paramwhz.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      wxe.a(this.TAG, "receive comment list event. %s.", paramwhz.toString());
      bool2 = wjw.a(paramwjw);
      bool1 = true;
      if (paramwhz.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      wjw.a(paramwjw).a(bool1);
      wjw.a(paramwjw).a(bool1, paramwhz.b);
      wjw.a(paramwjw).a(bool1, paramwhz.jdField_a_of_type_Boolean);
      wjw.a(paramwjw).a(paramwhz.jdField_a_of_type_JavaUtilList, paramwhz.c, bool1);
    } while (bool2 != bool1);
    paramwjw.b(paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return whz.class;
  }
  
  public void b(@NonNull wjw paramwjw, @NonNull whz paramwhz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wka
 * JD-Core Version:    0.7.0.1
 */