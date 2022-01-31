import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class umj
  extends umy
  implements slx<umk, uml>
{
  private boolean a;
  
  public String a()
  {
    return "GetPhotographyGuideInfoStep";
  }
  
  public void a()
  {
    urk.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "run");
    umk localumk = new umk();
    slv.a().a(localumk, this);
  }
  
  public void a(@NonNull umk paramumk, @Nullable uml paramuml, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramuml != null))
    {
      urk.b("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond success.");
      paramumk = (spz)sqg.a(10);
      paramuml = paramuml.a;
      if ((paramuml != null) && (paramuml.size() > 0)) {
        paramumk.b("StorySvc.get_photography_guide.word", paramuml.get(0));
      }
      for (;;)
      {
        d();
        return;
        paramumk.b("StorySvc.get_photography_guide.word", ajjy.a(2131639475));
      }
    }
    urk.d("Q.qqstory.home.GetPhotographyGuideInfoStep", "onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramumk });
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
 * Qualified Name:     umj
 * JD-Core Version:    0.7.0.1
 */