import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class whk
  implements wgz
{
  private String a = "SimplePreloadListener";
  
  public whk(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, wgv paramwgv) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, wgv paramwgv)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      yqp.b(this.a, "download ignore because no mask pic url");
      return;
    }
    yqp.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, wgv paramwgv)
  {
    paramString = ((wpj)wpm.a(5)).a(paramString);
    if (paramString != null) {
      wgw.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, wgv paramwgv) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, wgv paramwgv)
  {
    yqp.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, wes.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((wpj)wpm.a(5)).a(paramString);
    if (paramString != null) {
      wgw.a(paramString, paramFile.getAbsolutePath(), paramInt1, yqu.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, wgv paramwgv)
  {
    yqp.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whk
 * JD-Core Version:    0.7.0.1
 */