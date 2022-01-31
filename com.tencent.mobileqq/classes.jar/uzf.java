import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class uzf
  extends uzr
{
  private uzh jdField_a_of_type_Uzh;
  private boolean jdField_a_of_type_Boolean;
  
  public uzf(uzh paramuzh)
  {
    this.jdField_a_of_type_Uzh = paramuzh;
  }
  
  public String a()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void a()
  {
    ved.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    uzi localuzi = new uzi();
    syo.a().a(localuzi, new uzg(this));
  }
  
  public void a(@NonNull uzi paramuzi, @Nullable uzj paramuzj, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (b())
    {
      ved.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      ved.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramuzj));
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
 * Qualified Name:     uzf
 * JD-Core Version:    0.7.0.1
 */