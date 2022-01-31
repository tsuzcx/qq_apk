import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

class uis
  extends SimpleObserver<ucf>
{
  uis(uir paramuir) {}
  
  public void a(ucf paramucf)
  {
    super.onNext(paramucf);
    if (paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      spd localspd = (spd)sqg.a(17);
      localspd.a(paramucf.jdField_a_of_type_JavaUtilList, paramucf.jdField_a_of_type_JavaLangString, false, false);
      paramucf.jdField_a_of_type_JavaUtilList.addAll(localspd.b(paramucf.jdField_a_of_type_JavaLangString, false));
    }
    sgi.a().dispatch(paramucf);
    this.a.b();
    urk.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    urk.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uis
 * JD-Core Version:    0.7.0.1
 */