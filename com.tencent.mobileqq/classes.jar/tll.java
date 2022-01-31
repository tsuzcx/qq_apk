import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tll
  extends sgl<tlj, ucf>
{
  tll(tlj paramtlj)
  {
    super(paramtlj);
  }
  
  public void a(@NonNull tlj paramtlj, @NonNull ucf paramucf)
  {
    if ((!paramucf.jdField_a_of_type_JavaLangString.equals(tlj.a(paramtlj))) || (paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (tlj.a(paramtlj) == null)) {
      urk.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramucf.toString());
    }
    tls localtls;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        urk.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramucf.toString());
        bool2 = paramtlj.a();
        bool1 = true;
        if (paramucf.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        tlj.a(paramtlj).a(bool1);
        tlj.a(paramtlj).a(bool1, paramucf.b);
        tlj.a(paramtlj).a(bool1, paramucf.jdField_a_of_type_Boolean);
        tlj.a(paramtlj).a(paramucf.jdField_a_of_type_JavaUtilList, paramucf.c, bool1);
      } while (bool2 != bool1);
      localtls = paramtlj.a();
    } while (localtls == null);
    localtls.a(tlj.a(paramtlj), paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return ucf.class;
  }
  
  public void b(@NonNull tlj paramtlj, @NonNull ucf paramucf)
  {
    boolean bool2 = paramtlj.a();
    boolean bool1 = true;
    if (paramucf.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramucf = paramtlj.a();
      if (paramucf != null) {
        paramucf.a(tlj.a(paramtlj), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tll
 * JD-Core Version:    0.7.0.1
 */