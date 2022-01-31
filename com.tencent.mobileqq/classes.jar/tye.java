import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tye
  extends ste<tyc, uoy>
{
  tye(tyc paramtyc)
  {
    super(paramtyc);
  }
  
  public void a(@NonNull tyc paramtyc, @NonNull uoy paramuoy)
  {
    if ((!paramuoy.jdField_a_of_type_JavaLangString.equals(tyc.a(paramtyc))) || (paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (tyc.a(paramtyc) == null)) {
      ved.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramuoy.toString());
    }
    tyl localtyl;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        ved.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramuoy.toString());
        bool2 = paramtyc.a();
        bool1 = true;
        if (paramuoy.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        tyc.a(paramtyc).a(bool1);
        tyc.a(paramtyc).a(bool1, paramuoy.b);
        tyc.a(paramtyc).a(bool1, paramuoy.jdField_a_of_type_Boolean);
        tyc.a(paramtyc).a(paramuoy.jdField_a_of_type_JavaUtilList, paramuoy.c, bool1);
      } while (bool2 != bool1);
      localtyl = paramtyc.a();
    } while (localtyl == null);
    localtyl.a(tyc.a(paramtyc), paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return uoy.class;
  }
  
  public void b(@NonNull tyc paramtyc, @NonNull uoy paramuoy)
  {
    boolean bool2 = paramtyc.a();
    boolean bool1 = true;
    if (paramuoy.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramuoy = paramtyc.a();
      if (paramuoy != null) {
        paramuoy.a(tyc.a(paramtyc), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tye
 * JD-Core Version:    0.7.0.1
 */