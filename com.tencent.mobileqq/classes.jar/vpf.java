import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.ResponseThrowable;
import rx.Subscriber;

public class vpf
  extends Subscriber<vph>
{
  public vpf(WSVerticalDataManager paramWSVerticalDataManager, vos paramvos) {}
  
  public void a(vph paramvph)
  {
    if (paramvph == null) {}
    do
    {
      return;
      if ((paramvph.b) && (uyn.a())) {
        vbw.a().a(new WSUserAuthEvent());
      }
    } while (this.jdField_a_of_type_Vos == null);
    this.jdField_a_of_type_Vos.a(paramvph.jdField_a_of_type_JavaUtilList, paramvph.jdField_a_of_type_Boolean, paramvph.b, paramvph.jdField_a_of_type_JavaLangObject);
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((this.jdField_a_of_type_Vos != null) && ((paramThrowable instanceof WSVerticalDataManager.ResponseThrowable)))
    {
      paramThrowable = (WSVerticalDataManager.ResponseThrowable)paramThrowable;
      this.jdField_a_of_type_Vos.a(paramThrowable.mErrorCode, paramThrowable.mErrorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpf
 * JD-Core Version:    0.7.0.1
 */