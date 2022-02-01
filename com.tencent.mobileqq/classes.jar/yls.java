import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class yls
  extends SimpleObserver<yff>
{
  yls(ylr paramylr) {}
  
  public void a(yff paramyff)
  {
    super.onNext(paramyff);
    if (paramyff.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wse localwse = (wse)wth.a(17);
      localwse.a(paramyff.jdField_a_of_type_JavaUtilList, paramyff.jdField_a_of_type_JavaLangString, false, false);
      paramyff.jdField_a_of_type_JavaUtilList.addAll(localwse.b(paramyff.jdField_a_of_type_JavaLangString, false));
    }
    wjj.a().dispatch(paramyff);
    this.a.b();
    yuk.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    yuk.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yls
 * JD-Core Version:    0.7.0.1
 */