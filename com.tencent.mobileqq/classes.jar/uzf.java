import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class uzf
  extends uzu
  implements syt<uzg, uzh>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    veg.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    uzg localuzg = new uzg();
    syr.a().a(localuzg, this);
  }
  
  public void a(@NonNull uzg paramuzg, @Nullable uzh paramuzh, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramuzh != null))
    {
      veg.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramuzg = (tcv)tdc.a(10);
      paramuzh = paramuzh.a;
      if ((paramuzh != null) && (paramuzh.size() > 0)) {
        paramuzg.b("StorySvc.get_photography_guide.word", paramuzh.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramuzg.b("StorySvc.get_photography_guide.word", ajyc.a(2131705260));
      }
    }
    veg.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramuzg });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzf
 * JD-Core Version:    0.7.0.1
 */