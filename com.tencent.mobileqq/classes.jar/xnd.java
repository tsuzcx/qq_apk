import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class xnd
  extends SimpleObserver<xgq>
{
  xnd(xnc paramxnc) {}
  
  public void a(xgq paramxgq)
  {
    super.onNext(paramxgq);
    if (paramxgq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      vtu localvtu = (vtu)vux.a(17);
      localvtu.a(paramxgq.jdField_a_of_type_JavaUtilList, paramxgq.jdField_a_of_type_JavaLangString, false, false);
      paramxgq.jdField_a_of_type_JavaUtilList.addAll(localvtu.b(paramxgq.jdField_a_of_type_JavaLangString, false));
    }
    vli.a().dispatch(paramxgq);
    this.a.b();
    xvv.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    xvv.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnd
 * JD-Core Version:    0.7.0.1
 */