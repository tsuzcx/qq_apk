import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ypm
  extends ypy
{
  private ypo jdField_a_of_type_Ypo;
  private boolean jdField_a_of_type_Boolean;
  
  public ypm(ypo paramypo)
  {
    this.jdField_a_of_type_Ypo = paramypo;
  }
  
  public String a()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void a()
  {
    yuk.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    ypp localypp = new ypp();
    wow.a().a(localypp, new ypn(this));
  }
  
  public void a(@NonNull ypp paramypp, @Nullable ypq paramypq, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (b())
    {
      yuk.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      yuk.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramypq));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypm
 * JD-Core Version:    0.7.0.1
 */