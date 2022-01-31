import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class ujp
  implements uje
{
  private String a = "SimplePreloadListener";
  
  public ujp(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, uja paramuja) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, uja paramuja)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      wsv.b(this.a, "download ignore because no mask pic url");
      return;
    }
    wsv.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, uja paramuja)
  {
    paramString = ((uro)urr.a(5)).a(paramString);
    if (paramString != null) {
      ujb.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, uja paramuja) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, uja paramuja)
  {
    wsv.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, ugx.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((uro)urr.a(5)).a(paramString);
    if (paramString != null) {
      ujb.a(paramString, paramFile.getAbsolutePath(), paramInt1, wta.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, uja paramuja)
  {
    wsv.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */