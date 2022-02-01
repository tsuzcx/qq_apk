import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class ypj
  extends ypy
  implements woy<ypk, ypl>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    yuk.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    ypk localypk = new ypk();
    wow.a().a(localypk, this);
  }
  
  public void a(@NonNull ypk paramypk, @Nullable ypl paramypl, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramypl != null))
    {
      yuk.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramypk = (wta)wth.a(10);
      paramypl = paramypl.a;
      if ((paramypl != null) && (paramypl.size() > 0)) {
        paramypk.b("StorySvc.get_photography_guide.word", paramypl.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramypk.b("StorySvc.get_photography_guide.word", anzj.a(2131704157));
      }
    }
    yuk.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramypk });
    b(paramErrorMessage);
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      this.a = true;
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
 * Qualified Name:     ypj
 * JD-Core Version:    0.7.0.1
 */