import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class vne
  implements vmt
{
  private String a = "SimplePreloadListener";
  
  public vne(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, vmp paramvmp) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, vmp paramvmp)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      xvv.b(this.a, "download ignore because no mask pic url");
      return;
    }
    xvv.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, vmp paramvmp)
  {
    paramString = ((vuu)vux.a(5)).a(paramString);
    if (paramString != null) {
      vmq.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, vmp paramvmp) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, vmp paramvmp)
  {
    xvv.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, vkm.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((vuu)vux.a(5)).a(paramString);
    if (paramString != null) {
      vmq.a(paramString, paramFile.getAbsolutePath(), paramInt1, xwa.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, vmp paramvmp)
  {
    xvv.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vne
 * JD-Core Version:    0.7.0.1
 */