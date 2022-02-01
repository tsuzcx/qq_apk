import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class yby
  extends SimpleObserver<xvl>
{
  yby(ybx paramybx) {}
  
  public void a(xvl paramxvl)
  {
    super.onNext(paramxvl);
    if (paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wip localwip = (wip)wjs.a(17);
      localwip.a(paramxvl.jdField_a_of_type_JavaUtilList, paramxvl.jdField_a_of_type_JavaLangString, false, false);
      paramxvl.jdField_a_of_type_JavaUtilList.addAll(localwip.b(paramxvl.jdField_a_of_type_JavaLangString, false));
    }
    wad.a().dispatch(paramxvl);
    this.a.b();
    ykq.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    ykq.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yby
 * JD-Core Version:    0.7.0.1
 */