import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xer
  extends wag<xep, xvl>
{
  xer(xep paramxep)
  {
    super(paramxep);
  }
  
  public void a(@NonNull xep paramxep, @NonNull xvl paramxvl)
  {
    if ((!paramxvl.jdField_a_of_type_JavaLangString.equals(xep.a(paramxep))) || (paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (xep.a(paramxep) == null)) {
      ykq.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramxvl.toString());
    }
    xey localxey;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        ykq.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramxvl.toString());
        bool2 = paramxep.a();
        bool1 = true;
        if (paramxvl.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        xep.a(paramxep).a(bool1);
        xep.a(paramxep).a(bool1, paramxvl.b);
        xep.a(paramxep).a(bool1, paramxvl.jdField_a_of_type_Boolean);
        xep.a(paramxep).a(paramxvl.jdField_a_of_type_JavaUtilList, paramxvl.c, bool1);
      } while (bool2 != bool1);
      localxey = paramxep.a();
    } while (localxey == null);
    localxey.a(xep.a(paramxep), paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return xvl.class;
  }
  
  public void b(@NonNull xep paramxep, @NonNull xvl paramxvl)
  {
    boolean bool2 = paramxep.a();
    boolean bool1 = true;
    if (paramxvl.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramxvl = paramxep.a();
      if (paramxvl != null) {
        paramxvl.a(xep.a(paramxep), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xer
 * JD-Core Version:    0.7.0.1
 */