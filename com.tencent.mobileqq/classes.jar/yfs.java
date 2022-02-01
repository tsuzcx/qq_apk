import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class yfs
  extends yge
{
  private yfu jdField_a_of_type_Yfu;
  private boolean jdField_a_of_type_Boolean;
  
  public yfs(yfu paramyfu)
  {
    this.jdField_a_of_type_Yfu = paramyfu;
  }
  
  public String a()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void a()
  {
    ykq.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    yfv localyfv = new yfv();
    wfi.a().a(localyfv, new yft(this));
  }
  
  public void a(@NonNull yfv paramyfv, @Nullable yfw paramyfw, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (b())
    {
      ykq.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      ykq.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramyfw));
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
 * Qualified Name:     yfs
 * JD-Core Version:    0.7.0.1
 */