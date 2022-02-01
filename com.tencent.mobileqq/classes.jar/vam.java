import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.ResponseThrowable;
import rx.Subscriber;

public class vam
  extends Subscriber<vao>
{
  public vam(WSVerticalDataManager paramWSVerticalDataManager, vaa paramvaa) {}
  
  public void a(vao paramvao)
  {
    if (paramvao == null) {}
    do
    {
      return;
      if ((paramvao.b) && (ukq.a())) {
        unw.a().a(new WSUserAuthEvent());
      }
    } while (this.jdField_a_of_type_Vaa == null);
    this.jdField_a_of_type_Vaa.a(paramvao.jdField_a_of_type_JavaUtilList, paramvao.jdField_a_of_type_Boolean, paramvao.b, paramvao.jdField_a_of_type_JavaLangObject);
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((this.jdField_a_of_type_Vaa != null) && ((paramThrowable instanceof WSVerticalDataManager.ResponseThrowable)))
    {
      paramThrowable = (WSVerticalDataManager.ResponseThrowable)paramThrowable;
      this.jdField_a_of_type_Vaa.a(paramThrowable.mErrorCode, paramThrowable.mErrorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vam
 * JD-Core Version:    0.7.0.1
 */