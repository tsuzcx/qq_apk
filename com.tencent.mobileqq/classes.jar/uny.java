import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class uny
  implements unn
{
  private String a = "SimplePreloadListener";
  
  public uny(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, unj paramunj) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, unj paramunj)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      wxe.b(this.a, "download ignore because no mask pic url");
      return;
    }
    wxe.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, unj paramunj)
  {
    paramString = ((uvx)uwa.a(5)).a(paramString);
    if (paramString != null) {
      unk.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, unj paramunj) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, unj paramunj)
  {
    wxe.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, ulg.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((uvx)uwa.a(5)).a(paramString);
    if (paramString != null) {
      unk.a(paramString, paramFile.getAbsolutePath(), paramInt1, wxj.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, unj paramunj)
  {
    wxe.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uny
 * JD-Core Version:    0.7.0.1
 */