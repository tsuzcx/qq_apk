import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wkj
  extends umf<wjw, wiu>
{
  wkj(wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull wiu paramwiu)
  {
    if ((!paramwiu.jdField_a_of_type_Boolean) || (!paramwiu.jdField_a_of_type_JavaLangString.equals(wjw.a(paramwjw))) || (paramwiu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wjw.a(paramwjw) == null))
    {
      wxe.b(this.TAG, "ignore this like list event. %s.", paramwiu.toString());
      return;
    }
    wxe.a(this.TAG, "receive like list event. %s.", paramwiu.toString());
    boolean bool2 = wjw.a(paramwjw);
    if (paramwiu.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      wjw.a(paramwjw).b(bool1, paramwiu.b);
      wjw.a(paramwjw).b(paramwiu.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramwjw.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wiu.class;
  }
  
  public void b(@NonNull wjw paramwjw, @NonNull wiu paramwiu) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkj
 * JD-Core Version:    0.7.0.1
 */