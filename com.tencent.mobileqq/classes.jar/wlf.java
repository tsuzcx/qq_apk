import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class wlf
  implements wku
{
  private String a = "SimplePreloadListener";
  
  public wlf(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, wkq paramwkq) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wkq paramwkq)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      yuk.b(this.a, "download ignore because no mask pic url");
      return;
    }
    yuk.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, wkq paramwkq)
  {
    paramString = ((wte)wth.a(5)).a(paramString);
    if (paramString != null) {
      wkr.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, wkq paramwkq) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wkq paramwkq)
  {
    yuk.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, win.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((wte)wth.a(5)).a(paramString);
    if (paramString != null) {
      wkr.a(paramString, paramFile.getAbsolutePath(), paramInt1, yup.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, wkq paramwkq)
  {
    yuk.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlf
 * JD-Core Version:    0.7.0.1
 */