import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class ylo
  extends ymd
  implements wld<ylp, ylq>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    yqp.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    ylp localylp = new ylp();
    wlb.a().a(localylp, this);
  }
  
  public void a(@NonNull ylp paramylp, @Nullable ylq paramylq, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramylq != null))
    {
      yqp.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramylp = (wpf)wpm.a(10);
      paramylq = paramylq.a;
      if ((paramylq != null) && (paramylq.size() > 0)) {
        paramylp.b("StorySvc.get_photography_guide.word", paramylq.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramylp.b("StorySvc.get_photography_guide.word", anni.a(2131704050));
      }
    }
    yqp.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramylp });
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
 * Qualified Name:     ylo
 * JD-Core Version:    0.7.0.1
 */