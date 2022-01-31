import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class wsd
  extends wss
  implements urr<wse, wsf>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    wxe.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    wse localwse = new wse();
    urp.a().a(localwse, this);
  }
  
  public void a(@NonNull wse paramwse, @Nullable wsf paramwsf, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramwsf != null))
    {
      wxe.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramwse = (uvt)uwa.a(10);
      paramwsf = paramwsf.a;
      if ((paramwsf != null) && (paramwsf.size() > 0)) {
        paramwse.b("StorySvc.get_photography_guide.word", paramwsf.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramwse.b("StorySvc.get_photography_guide.word", alud.a(2131705655));
      }
    }
    wxe.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwse });
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
 * Qualified Name:     wsd
 * JD-Core Version:    0.7.0.1
 */