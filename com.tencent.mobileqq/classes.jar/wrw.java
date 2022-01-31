import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrw
  extends QQUIEventReceiver<wrh, uqw>
{
  public wrw(@NonNull wrh paramwrh)
  {
    super(paramwrh);
  }
  
  public void a(@NonNull wrh paramwrh, @NonNull uqw paramuqw)
  {
    if (paramuqw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      wsv.d(this.TAG, "deleted story failed");
      paramwrh.a(5, paramuqw.jdField_a_of_type_JavaLangString);
      return;
    }
    paramwrh.a(paramuqw.jdField_a_of_type_JavaLangString);
    paramwrh.a(new woq[] { new wol(wnt.a(wrh.a(paramwrh).a.jdField_a_of_type_JavaLangString)), (woq)paramwrh.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return uqw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */