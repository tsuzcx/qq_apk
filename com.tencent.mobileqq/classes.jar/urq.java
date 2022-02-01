import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.ResponseThrowable;
import rx.Subscriber;

public class urq
  extends Subscriber<urs>
{
  public urq(WSVerticalDataManager paramWSVerticalDataManager, ure paramure) {}
  
  public void a(urs paramurs)
  {
    if (paramurs == null) {}
    do
    {
      return;
      if ((paramurs.b) && (udy.a())) {
        uhd.a().a(new WSUserAuthEvent());
      }
    } while (this.jdField_a_of_type_Ure == null);
    this.jdField_a_of_type_Ure.a(paramurs.jdField_a_of_type_JavaUtilList, paramurs.jdField_a_of_type_Boolean, paramurs.b, paramurs.jdField_a_of_type_JavaLangObject);
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((this.jdField_a_of_type_Ure != null) && ((paramThrowable instanceof WSVerticalDataManager.ResponseThrowable)))
    {
      paramThrowable = (WSVerticalDataManager.ResponseThrowable)paramThrowable;
      this.jdField_a_of_type_Ure.a(paramThrowable.mErrorCode, paramThrowable.mErrorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urq
 * JD-Core Version:    0.7.0.1
 */