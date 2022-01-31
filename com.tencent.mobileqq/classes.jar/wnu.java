import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class wnu
  extends woj
  implements uni<wnv, wnw>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    wsv.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    wnv localwnv = new wnv();
    ung.a().a(localwnv, this);
  }
  
  public void a(@NonNull wnv paramwnv, @Nullable wnw paramwnw, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramwnw != null))
    {
      wsv.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramwnv = (urk)urr.a(10);
      paramwnw = paramwnw.a;
      if ((paramwnw != null) && (paramwnw.size() > 0)) {
        paramwnv.b("StorySvc.get_photography_guide.word", paramwnw.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramwnv.b("StorySvc.get_photography_guide.word", alpo.a(2131705643));
      }
    }
    wsv.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwnv });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnu
 * JD-Core Version:    0.7.0.1
 */