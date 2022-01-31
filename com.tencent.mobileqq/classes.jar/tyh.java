import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tyh
  extends sth<tyf, upb>
{
  tyh(tyf paramtyf)
  {
    super(paramtyf);
  }
  
  public void a(@NonNull tyf paramtyf, @NonNull upb paramupb)
  {
    if ((!paramupb.jdField_a_of_type_JavaLangString.equals(tyf.a(paramtyf))) || (paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (tyf.a(paramtyf) == null)) {
      veg.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramupb.toString());
    }
    tyo localtyo;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        veg.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramupb.toString());
        bool2 = paramtyf.a();
        bool1 = true;
        if (paramupb.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        tyf.a(paramtyf).a(bool1);
        tyf.a(paramtyf).a(bool1, paramupb.b);
        tyf.a(paramtyf).a(bool1, paramupb.jdField_a_of_type_Boolean);
        tyf.a(paramtyf).a(paramupb.jdField_a_of_type_JavaUtilList, paramupb.c, bool1);
      } while (bool2 != bool1);
      localtyo = paramtyf.a();
    } while (localtyo == null);
    localtyo.a(tyf.a(paramtyf), paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return upb.class;
  }
  
  public void b(@NonNull tyf paramtyf, @NonNull upb paramupb)
  {
    boolean bool2 = paramtyf.a();
    boolean bool1 = true;
    if (paramupb.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramupb = paramtyf.a();
      if (paramupb != null) {
        paramupb.a(tyf.a(paramtyf), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyh
 * JD-Core Version:    0.7.0.1
 */