import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class uvo
  extends SimpleObserver<upb>
{
  uvo(uvn paramuvn) {}
  
  public void a(upb paramupb)
  {
    super.onNext(paramupb);
    if (paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      tbz localtbz = (tbz)tdc.a(17);
      localtbz.a(paramupb.jdField_a_of_type_JavaUtilList, paramupb.jdField_a_of_type_JavaLangString, false, false);
      paramupb.jdField_a_of_type_JavaUtilList.addAll(localtbz.b(paramupb.jdField_a_of_type_JavaLangString, false));
    }
    ste.a().dispatch(paramupb);
    this.a.b();
    veg.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    veg.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvo
 * JD-Core Version:    0.7.0.1
 */