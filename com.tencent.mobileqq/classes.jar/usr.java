import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.ResponseThrowable;
import rx.Subscriber;

public class usr
  extends Subscriber<ust>
{
  public usr(WSVerticalDataManager paramWSVerticalDataManager, usf paramusf) {}
  
  public void a(ust paramust)
  {
    if (paramust == null) {}
    do
    {
      return;
      if ((paramust.b) && (uea.a())) {
        uhf.a().a(new WSUserAuthEvent());
      }
    } while (this.jdField_a_of_type_Usf == null);
    this.jdField_a_of_type_Usf.a(paramust.jdField_a_of_type_JavaUtilList, paramust.jdField_a_of_type_Boolean, paramust.b, paramust.jdField_a_of_type_JavaLangObject);
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((this.jdField_a_of_type_Usf != null) && ((paramThrowable instanceof WSVerticalDataManager.ResponseThrowable)))
    {
      paramThrowable = (WSVerticalDataManager.ResponseThrowable)paramThrowable;
      this.jdField_a_of_type_Usf.a(paramThrowable.mErrorCode, paramThrowable.mErrorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */