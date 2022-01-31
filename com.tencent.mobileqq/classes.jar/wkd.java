import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class wkd
  extends SimpleObserver<wdq>
{
  wkd(wkc paramwkc) {}
  
  public void a(wdq paramwdq)
  {
    super.onNext(paramwdq);
    if (paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      uqo localuqo = (uqo)urr.a(17);
      localuqo.a(paramwdq.jdField_a_of_type_JavaUtilList, paramwdq.jdField_a_of_type_JavaLangString, false, false);
      paramwdq.jdField_a_of_type_JavaUtilList.addAll(localuqo.b(paramwdq.jdField_a_of_type_JavaLangString, false));
    }
    uht.a().dispatch(paramwdq);
    this.a.b();
    wsv.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    wsv.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkd
 * JD-Core Version:    0.7.0.1
 */