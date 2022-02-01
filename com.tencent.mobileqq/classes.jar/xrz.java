import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.reactive.SimpleObserver;

public class xrz<T>
  extends SimpleObserver<T>
{
  private xrz(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d(this.b.jdField_a_of_type_JavaLangString, "stream : [%s]  CANCEL", new Object[] { this.b.b });
    this.b.jdField_a_of_type_ComTribeAsyncReactiveStream = null;
    this.b.b = null;
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.d(this.b.jdField_a_of_type_JavaLangString, "stream : [%s]  ERROR", new Object[] { this.b.b });
    this.b.jdField_a_of_type_ComTribeAsyncReactiveStream = null;
    this.b.b = null;
  }
  
  public void onNext(T paramT)
  {
    super.onNext(paramT);
    yuk.d(this.b.jdField_a_of_type_JavaLangString, "stream : [%s] DONE", new Object[] { this.b.b });
    this.b.jdField_a_of_type_ComTribeAsyncReactiveStream = null;
    this.b.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrz
 * JD-Core Version:    0.7.0.1
 */