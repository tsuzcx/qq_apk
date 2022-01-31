import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wfr
  extends uhw<wfn, wdq>
{
  wfr(wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull wdq paramwdq)
  {
    if ((!paramwdq.jdField_a_of_type_JavaLangString.equals(wfn.a(paramwfn))) || (paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wfn.a(paramwfn) == null)) {
      wsv.b(this.TAG, "ignore this comment list event. %s.", paramwdq.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      wsv.a(this.TAG, "receive comment list event. %s.", paramwdq.toString());
      bool2 = wfn.a(paramwfn);
      bool1 = true;
      if (paramwdq.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      wfn.a(paramwfn).a(bool1);
      wfn.a(paramwfn).a(bool1, paramwdq.b);
      wfn.a(paramwfn).a(bool1, paramwdq.jdField_a_of_type_Boolean);
      wfn.a(paramwfn).a(paramwdq.jdField_a_of_type_JavaUtilList, paramwdq.c, bool1);
    } while (bool2 != bool1);
    paramwfn.b(paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return wdq.class;
  }
  
  public void b(@NonNull wfn paramwfn, @NonNull wdq paramwdq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfr
 * JD-Core Version:    0.7.0.1
 */