import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vrf
  extends umf<vrd, whz>
{
  vrf(vrd paramvrd)
  {
    super(paramvrd);
  }
  
  public void a(@NonNull vrd paramvrd, @NonNull whz paramwhz)
  {
    if ((!paramwhz.jdField_a_of_type_JavaLangString.equals(vrd.a(paramvrd))) || (paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (vrd.a(paramvrd) == null)) {
      wxe.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramwhz.toString());
    }
    vrm localvrm;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        wxe.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramwhz.toString());
        bool2 = paramvrd.a();
        bool1 = true;
        if (paramwhz.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        vrd.a(paramvrd).a(bool1);
        vrd.a(paramvrd).a(bool1, paramwhz.b);
        vrd.a(paramvrd).a(bool1, paramwhz.jdField_a_of_type_Boolean);
        vrd.a(paramvrd).a(paramwhz.jdField_a_of_type_JavaUtilList, paramwhz.c, bool1);
      } while (bool2 != bool1);
      localvrm = paramvrd.a();
    } while (localvrm == null);
    localvrm.a(vrd.a(paramvrd), paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return whz.class;
  }
  
  public void b(@NonNull vrd paramvrd, @NonNull whz paramwhz)
  {
    boolean bool2 = paramvrd.a();
    boolean bool1 = true;
    if (paramwhz.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramwhz = paramvrd.a();
      if (paramwhz != null) {
        paramwhz.a(vrd.a(paramvrd), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */