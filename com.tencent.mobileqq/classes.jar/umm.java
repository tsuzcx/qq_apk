import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class umm
  extends umy
{
  private umo jdField_a_of_type_Umo;
  private boolean jdField_a_of_type_Boolean;
  
  public umm(umo paramumo)
  {
    this.jdField_a_of_type_Umo = paramumo;
  }
  
  public String a()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void a()
  {
    urk.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    ump localump = new ump();
    slv.a().a(localump, new umn(this));
  }
  
  public void a(@NonNull ump paramump, @Nullable umq paramumq, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (b())
    {
      urk.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      urk.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramumq));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umm
 * JD-Core Version:    0.7.0.1
 */