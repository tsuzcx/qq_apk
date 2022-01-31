import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wnx
  extends woj
{
  private wnz jdField_a_of_type_Wnz;
  private boolean jdField_a_of_type_Boolean;
  
  public wnx(wnz paramwnz)
  {
    this.jdField_a_of_type_Wnz = paramwnz;
  }
  
  public String a()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void a()
  {
    wsv.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    woa localwoa = new woa();
    ung.a().a(localwoa, new wny(this));
  }
  
  public void a(@NonNull woa paramwoa, @Nullable wob paramwob, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (b())
    {
      wsv.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      wsv.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramwob));
    d();
  }
  
  public void b() {}
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnx
 * JD-Core Version:    0.7.0.1
 */