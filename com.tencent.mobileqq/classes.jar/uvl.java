import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class uvl
  extends SimpleObserver<uoy>
{
  uvl(uvk paramuvk) {}
  
  public void a(uoy paramuoy)
  {
    super.onNext(paramuoy);
    if (paramuoy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      tbw localtbw = (tbw)tcz.a(17);
      localtbw.a(paramuoy.jdField_a_of_type_JavaUtilList, paramuoy.jdField_a_of_type_JavaLangString, false, false);
      paramuoy.jdField_a_of_type_JavaUtilList.addAll(localtbw.b(paramuoy.jdField_a_of_type_JavaLangString, false));
    }
    stb.a().dispatch(paramuoy);
    this.a.b();
    ved.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    ved.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvl
 * JD-Core Version:    0.7.0.1
 */