import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xkq
  extends wfr<xko, ybk>
{
  xkq(xko paramxko)
  {
    super(paramxko);
  }
  
  public void a(@NonNull xko paramxko, @NonNull ybk paramybk)
  {
    if ((!paramybk.jdField_a_of_type_JavaLangString.equals(xko.a(paramxko))) || (paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xko.a(paramxko) == null)) {
      yqp.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramybk.toString());
    }
    xkx localxkx;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        yqp.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramybk.toString());
        bool2 = paramxko.a();
        bool1 = true;
        if (paramybk.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        xko.a(paramxko).a(bool1);
        xko.a(paramxko).a(bool1, paramybk.b);
        xko.a(paramxko).a(bool1, paramybk.jdField_a_of_type_Boolean);
        xko.a(paramxko).a(paramybk.jdField_a_of_type_JavaUtilList, paramybk.c, bool1);
      } while (bool2 != bool1);
      localxkx = paramxko.a();
    } while (localxkx == null);
    localxkx.a(xko.a(paramxko), paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return ybk.class;
  }
  
  public void b(@NonNull xko paramxko, @NonNull ybk paramybk)
  {
    boolean bool2 = paramxko.a();
    boolean bool1 = true;
    if (paramybk.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramybk = paramxko.a();
      if (paramybk != null) {
        paramybk.a(xko.a(paramxko), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkq
 * JD-Core Version:    0.7.0.1
 */