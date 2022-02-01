import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class ymd
  extends SimpleObserver<T>
{
  public ymd(yly paramyly) {}
  
  public void a(T paramT)
  {
    super.onNext(paramT);
    this.a.b();
    yuk.b("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data finish %s", paramT);
    paramT.d = this.a.jdField_a_of_type_Boolean;
    this.a.a(paramT.a, paramT.c);
    this.a.jdField_a_of_type_Yma.b();
    this.a.jdField_a_of_type_Ymc.a(paramT);
    this.a.a("Q.qqstory.home.data.FeedListPageLoaderBase");
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    paramError = (ErrorMessage)paramError;
    paramError = this.a.a(paramError);
    paramError.d = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_Ymc.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymd
 * JD-Core Version:    0.7.0.1
 */