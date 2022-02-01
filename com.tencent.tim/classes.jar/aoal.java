import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class aoal
{
  public static void M(Activity paramActivity, String paramString)
  {
    c(paramActivity, paramString, false);
  }
  
  public static FileManagerEntity a(ForwardFileInfo paramForwardFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.fileName = paramForwardFileInfo.getFileName();
    localFileManagerEntity.nFileType = ahav.getFileType(localFileManagerEntity.fileName);
    localFileManagerEntity.nSessionId = paramForwardFileInfo.fR();
    localFileManagerEntity.cloudType = paramForwardFileInfo.Ev();
    return localFileManagerEntity;
  }
  
  public static ForwardFileInfo a(String paramString)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.Oj(9);
    localForwardFileInfo.setType(10001);
    localForwardFileInfo.setFileName(paramString);
    localForwardFileInfo.p(ahav.d().longValue());
    return localForwardFileInfo;
  }
  
  public static void a(Activity paramActivity, ForwardFileInfo paramForwardFileInfo, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, FileBrowserActivity.class);
    if (paramForwardFileInfo != null) {
      localIntent.putExtra("fileinfo", paramForwardFileInfo);
    }
    if (paramBundle != null) {
      localIntent.putExtra("file_browser_extra_params", paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, 102);
  }
  
  public static void c(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isMiniProgram", paramBoolean);
    a(paramActivity, paramString, localBundle);
  }
  
  public static String fr(int paramInt)
  {
    String str = acfp.m(2131715189);
    if (paramInt == 3) {
      str = "word";
    }
    do
    {
      return str;
      if (paramInt == 6) {
        return "excel";
      }
      if (paramInt == 7) {
        return "ppt";
      }
    } while (paramInt != 9);
    return "pdf";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoal
 * JD-Core Version:    0.7.0.1
 */