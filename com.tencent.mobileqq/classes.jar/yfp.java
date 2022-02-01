import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class yfp
  extends yge
  implements wfk<yfq, yfr>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    ykq.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    yfq localyfq = new yfq();
    wfi.a().a(localyfq, this);
  }
  
  public void a(@NonNull yfq paramyfq, @Nullable yfr paramyfr, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramyfr != null))
    {
      ykq.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramyfq = (wjl)wjs.a(10);
      paramyfr = paramyfr.a;
      if ((paramyfr != null) && (paramyfr.size() > 0)) {
        paramyfq.b("StorySvc.get_photography_guide.word", paramyfr.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramyfq.b("StorySvc.get_photography_guide.word", anvx.a(2131704737));
      }
    }
    ykq.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramyfq });
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
 * Qualified Name:     yfp
 * JD-Core Version:    0.7.0.1
 */