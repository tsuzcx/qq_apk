import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class xqu
  extends xrj
  implements vqp<xqv, xqw>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    xvv.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    xqv localxqv = new xqv();
    vqn.a().a(localxqv, this);
  }
  
  public void a(@NonNull xqv paramxqv, @Nullable xqw paramxqw, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramxqw != null))
    {
      xvv.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramxqv = (vuq)vux.a(10);
      paramxqw = paramxqw.a;
      if ((paramxqw != null) && (paramxqw.size() > 0)) {
        paramxqv.b("StorySvc.get_photography_guide.word", paramxqw.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramxqv.b("StorySvc.get_photography_guide.word", amtj.a(2131704386));
      }
    }
    xvv.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramxqv });
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
 * Qualified Name:     xqu
 * JD-Core Version:    0.7.0.1
 */