import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vmw
  extends uhw<vmu, wdq>
{
  vmw(vmu paramvmu)
  {
    super(paramvmu);
  }
  
  public void a(@NonNull vmu paramvmu, @NonNull wdq paramwdq)
  {
    if ((!paramwdq.jdField_a_of_type_JavaLangString.equals(vmu.a(paramvmu))) || (paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (vmu.a(paramvmu) == null)) {
      wsv.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramwdq.toString());
    }
    vnd localvnd;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        wsv.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramwdq.toString());
        bool2 = paramvmu.a();
        bool1 = true;
        if (paramwdq.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        vmu.a(paramvmu).a(bool1);
        vmu.a(paramvmu).a(bool1, paramwdq.b);
        vmu.a(paramvmu).a(bool1, paramwdq.jdField_a_of_type_Boolean);
        vmu.a(paramvmu).a(paramwdq.jdField_a_of_type_JavaUtilList, paramwdq.c, bool1);
      } while (bool2 != bool1);
      localvnd = paramvmu.a();
    } while (localvnd == null);
    localvnd.a(vmu.a(paramvmu), paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return wdq.class;
  }
  
  public void b(@NonNull vmu paramvmu, @NonNull wdq paramwdq)
  {
    boolean bool2 = paramvmu.a();
    boolean bool1 = true;
    if (paramwdq.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramwdq = paramvmu.a();
      if (paramwdq != null) {
        paramwdq.a(vmu.a(paramvmu), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmw
 * JD-Core Version:    0.7.0.1
 */