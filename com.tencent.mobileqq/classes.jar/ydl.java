import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ydl
  extends wfr<ydh, ybk>
{
  ydl(ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull ybk paramybk)
  {
    if ((!paramybk.jdField_a_of_type_JavaLangString.equals(ydh.a(paramydh))) || (paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (ydh.a(paramydh) == null)) {
      yqp.b(this.TAG, "ignore this comment list event. %s.", paramybk.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      yqp.a(this.TAG, "receive comment list event. %s.", paramybk.toString());
      bool2 = ydh.a(paramydh);
      bool1 = true;
      if (paramybk.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      ydh.a(paramydh).a(bool1);
      ydh.a(paramydh).a(bool1, paramybk.b);
      ydh.a(paramydh).a(bool1, paramybk.jdField_a_of_type_Boolean);
      ydh.a(paramydh).a(paramybk.jdField_a_of_type_JavaUtilList, paramybk.c, bool1);
    } while (bool2 != bool1);
    paramydh.b(paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return ybk.class;
  }
  
  public void b(@NonNull ydh paramydh, @NonNull ybk paramybk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydl
 * JD-Core Version:    0.7.0.1
 */