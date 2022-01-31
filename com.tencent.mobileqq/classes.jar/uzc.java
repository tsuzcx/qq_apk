import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class uzc
  extends uzr
  implements syq<uzd, uze>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    ved.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    uzd localuzd = new uzd();
    syo.a().a(localuzd, this);
  }
  
  public void a(@NonNull uzd paramuzd, @Nullable uze paramuze, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramuze != null))
    {
      ved.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramuzd = (tcs)tcz.a(10);
      paramuze = paramuze.a;
      if ((paramuze != null) && (paramuze.size() > 0)) {
        paramuzd.b("StorySvc.get_photography_guide.word", paramuze.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramuzd.b("StorySvc.get_photography_guide.word", ajya.a(2131705271));
      }
    }
    ved.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramuzd });
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
 * Qualified Name:     uzc
 * JD-Core Version:    0.7.0.1
 */