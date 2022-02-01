import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class pnn
  implements pni.a
{
  private String mTag = "SimplePreloadListener";
  
  public pnn(String paramString)
  {
    this.mTag = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, png parampng) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, png parampng)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      ram.d(this.mTag, "download ignore because no mask pic url");
      return;
    }
    ram.w(this.mTag, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng)
  {
    paramString = ((psu)psx.a(5)).a(paramString);
    if (paramString != null) {
      pnh.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, png parampng) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, png parampng)
  {
    ram.a(this.mTag, "download success! vid = %s , fileType = %s , file path = %s", paramString, plr.bR(paramInt1), paramFile.getAbsolutePath());
    paramString = ((psu)psx.a(5)).a(paramString);
    if (paramString != null) {
      pnh.a(paramString, paramFile.getAbsolutePath(), paramInt1, rar.getNetworkType(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, png parampng)
  {
    ram.b(this.mTag, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnn
 * JD-Core Version:    0.7.0.1
 */