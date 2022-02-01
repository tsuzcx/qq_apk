import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ydu
  extends wfr<ydh, ycf>
{
  ydu(ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull ycf paramycf)
  {
    if ((!paramycf.jdField_a_of_type_Boolean) || (!paramycf.jdField_a_of_type_JavaLangString.equals(ydh.a(paramydh))) || (paramycf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (ydh.a(paramydh) == null))
    {
      yqp.b(this.TAG, "ignore this like list event. %s.", paramycf.toString());
      return;
    }
    yqp.a(this.TAG, "receive like list event. %s.", paramycf.toString());
    boolean bool2 = ydh.a(paramydh);
    if (paramycf.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ydh.a(paramydh).b(bool1, paramycf.b);
      ydh.a(paramydh).b(paramycf.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramydh.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return ycf.class;
  }
  
  public void b(@NonNull ydh paramydh, @NonNull ycf paramycf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydu
 * JD-Core Version:    0.7.0.1
 */