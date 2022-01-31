import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class wko
  extends SimpleObserver<T>
{
  public wko(wkj paramwkj) {}
  
  public void a(T paramT)
  {
    super.onNext(paramT);
    this.a.b();
    wsv.b("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data finish %s", paramT);
    paramT.d = this.a.jdField_a_of_type_Boolean;
    this.a.a(paramT.a, paramT.c);
    this.a.jdField_a_of_type_Wkl.b();
    this.a.jdField_a_of_type_Wkn.a(paramT);
    this.a.a("Q.qqstory.home.data.FeedListPageLoaderBase");
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("Q.qqstory.home.data.FeedListPageLoaderBase", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    paramError = (ErrorMessage)paramError;
    paramError = this.a.a(paramError);
    paramError.d = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_Wkn.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */