import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wga
  extends uhw<wfn, wel>
{
  wga(wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull wel paramwel)
  {
    if ((!paramwel.jdField_a_of_type_Boolean) || (!paramwel.jdField_a_of_type_JavaLangString.equals(wfn.a(paramwfn))) || (paramwel.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wfn.a(paramwfn) == null))
    {
      wsv.b(this.TAG, "ignore this like list event. %s.", paramwel.toString());
      return;
    }
    wsv.a(this.TAG, "receive like list event. %s.", paramwel.toString());
    boolean bool2 = wfn.a(paramwfn);
    if (paramwel.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      wfn.a(paramwfn).b(bool1, paramwel.b);
      wfn.a(paramwfn).b(paramwel.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramwfn.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wel.class;
  }
  
  public void b(@NonNull wfn paramwfn, @NonNull wel paramwel) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */