import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class wbz
  implements wbo
{
  private String a = "SimplePreloadListener";
  
  public wbz(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, wbk paramwbk) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wbk paramwbk)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      ykq.b(this.a, "download ignore because no mask pic url");
      return;
    }
    ykq.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, wbk paramwbk)
  {
    paramString = ((wjp)wjs.a(5)).a(paramString);
    if (paramString != null) {
      wbl.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, wbk paramwbk) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wbk paramwbk)
  {
    ykq.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, vzh.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((wjp)wjs.a(5)).a(paramString);
    if (paramString != null) {
      wbl.a(paramString, paramFile.getAbsolutePath(), paramInt1, ykv.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, wbk paramwbk)
  {
    ykq.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbz
 * JD-Core Version:    0.7.0.1
 */