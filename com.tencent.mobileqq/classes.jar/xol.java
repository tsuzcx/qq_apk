import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xol
  extends wjm<xoj, yff>
{
  xol(xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull yff paramyff)
  {
    if ((!paramyff.jdField_a_of_type_JavaLangString.equals(xoj.a(paramxoj))) || (paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xoj.a(paramxoj) == null)) {
      yuk.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramyff.toString());
    }
    xos localxos;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        yuk.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramyff.toString());
        bool2 = paramxoj.a();
        bool1 = true;
        if (paramyff.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        xoj.a(paramxoj).a(bool1);
        xoj.a(paramxoj).a(bool1, paramyff.b);
        xoj.a(paramxoj).a(bool1, paramyff.jdField_a_of_type_Boolean);
        xoj.a(paramxoj).a(paramyff.jdField_a_of_type_JavaUtilList, paramyff.c, bool1);
      } while (bool2 != bool1);
      localxos = paramxoj.a();
    } while (localxos == null);
    localxos.a(xoj.a(paramxoj), paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return yff.class;
  }
  
  public void b(@NonNull xoj paramxoj, @NonNull yff paramyff)
  {
    boolean bool2 = paramxoj.a();
    boolean bool1 = true;
    if (paramyff.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramyff = paramxoj.a();
      if (paramyff != null) {
        paramyff.a(xoj.a(paramxoj), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xol
 * JD-Core Version:    0.7.0.1
 */