import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import mqq.os.MqqHandler;

public class yfr
{
  private Stream<yfw> jdField_a_of_type_ComTribeAsyncReactiveStream;
  private String jdField_a_of_type_JavaLangString;
  private yfu jdField_a_of_type_Yfu;
  private yfw jdField_a_of_type_Yfw = new yfw();
  public boolean a;
  private boolean b = true;
  
  public yfr(@NonNull String paramString, @NonNull yfu paramyfu, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Yfu = paramyfu;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(yfw paramyfw, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new DetailFeedAllInfoPuller.2(this, paramyfw, paramBoolean, paramErrorMessage));
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new DetailFeedAllInfoPuller.1(this), 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.detail.DetailFeedAllInfoPuller", 2)).map(new yfs(this, this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = this.jdField_a_of_type_ComTribeAsyncReactiveStream.map(new yfh());
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new yfv(this));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfr
 * JD-Core Version:    0.7.0.1
 */