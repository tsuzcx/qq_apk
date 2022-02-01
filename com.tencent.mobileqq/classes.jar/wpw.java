import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wpw
  extends vll<wpu, xgq>
{
  wpw(wpu paramwpu)
  {
    super(paramwpu);
  }
  
  public void a(@NonNull wpu paramwpu, @NonNull xgq paramxgq)
  {
    if ((!paramxgq.jdField_a_of_type_JavaLangString.equals(wpu.a(paramwpu))) || (paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (wpu.a(paramwpu) == null)) {
      xvv.b("Q.qqstory.player.CommentFloatDialogController", "ignore this comment list event. %s.", paramxgq.toString());
    }
    wqd localwqd;
    do
    {
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        xvv.a("Q.qqstory.player.CommentFloatDialogController", "receive comment list event. %s.", paramxgq.toString());
        bool2 = paramwpu.a();
        bool1 = true;
        if (paramxgq.jdField_a_of_type_Int == 0) {
          bool1 = false;
        }
        wpu.a(paramwpu).a(bool1);
        wpu.a(paramwpu).a(bool1, paramxgq.b);
        wpu.a(paramwpu).a(bool1, paramxgq.jdField_a_of_type_Boolean);
        wpu.a(paramwpu).a(paramxgq.jdField_a_of_type_JavaUtilList, paramxgq.c, bool1);
      } while (bool2 != bool1);
      localwqd = paramwpu.a();
    } while (localwqd == null);
    localwqd.a(wpu.a(paramwpu), paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return xgq.class;
  }
  
  public void b(@NonNull wpu paramwpu, @NonNull xgq paramxgq)
  {
    boolean bool2 = paramwpu.a();
    boolean bool1 = true;
    if (paramxgq.jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    if (bool2 == bool1)
    {
      paramxgq = paramwpu.a();
      if (paramxgq != null) {
        paramxgq.a(wpu.a(paramwpu), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpw
 * JD-Core Version:    0.7.0.1
 */