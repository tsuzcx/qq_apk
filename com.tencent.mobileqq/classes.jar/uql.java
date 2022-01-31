import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uql
  extends QQUIEventReceiver<upw, spl>
{
  public uql(@NonNull upw paramupw)
  {
    super(paramupw);
  }
  
  public void a(@NonNull upw paramupw, @NonNull spl paramspl)
  {
    if (paramspl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      urk.d(this.TAG, "deleted story failed");
      paramupw.a(5, paramspl.jdField_a_of_type_JavaLangString);
      return;
    }
    paramupw.a(paramspl.jdField_a_of_type_JavaLangString);
    paramupw.a(new unf[] { new una(umi.a(upw.a(paramupw).a.jdField_a_of_type_JavaLangString)), (unf)paramupw.c.a() });
  }
  
  public Class acceptEventClass()
  {
    return spl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uql
 * JD-Core Version:    0.7.0.1
 */