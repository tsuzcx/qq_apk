import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class yhx
  extends SimpleObserver<ybk>
{
  yhx(yhw paramyhw) {}
  
  public void a(ybk paramybk)
  {
    super.onNext(paramybk);
    if (paramybk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      woj localwoj = (woj)wpm.a(17);
      localwoj.a(paramybk.jdField_a_of_type_JavaUtilList, paramybk.jdField_a_of_type_JavaLangString, false, false);
      paramybk.jdField_a_of_type_JavaUtilList.addAll(localwoj.b(paramybk.jdField_a_of_type_JavaLangString, false));
    }
    wfo.a().dispatch(paramybk);
    this.a.b();
    yqp.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    yqp.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhx
 * JD-Core Version:    0.7.0.1
 */