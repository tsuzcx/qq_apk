import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class wom
  extends SimpleObserver<whz>
{
  wom(wol paramwol) {}
  
  public void a(whz paramwhz)
  {
    super.onNext(paramwhz);
    if (paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      uux localuux = (uux)uwa.a(17);
      localuux.a(paramwhz.jdField_a_of_type_JavaUtilList, paramwhz.jdField_a_of_type_JavaLangString, false, false);
      paramwhz.jdField_a_of_type_JavaUtilList.addAll(localuux.b(paramwhz.jdField_a_of_type_JavaLangString, false));
    }
    umc.a().dispatch(paramwhz);
    this.a.b();
    wxe.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    wxe.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wom
 * JD-Core Version:    0.7.0.1
 */