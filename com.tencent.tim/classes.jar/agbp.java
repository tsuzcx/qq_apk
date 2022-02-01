import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.1;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView.a;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class agbp
  implements FileWebView.a
{
  public agbp(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void loadFinish(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label56;
      }
      this.this$0.i(bool, paramInt2, paramString);
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish process Over");
      this.this$0.ccR = true;
      this.this$0.NR(1000);
      return;
      bool = false;
      break;
      label56:
      if (paramInt1 == 1) {
        this.this$0.j(bool, paramInt2, paramString);
      }
    }
  }
  
  public void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt2 == 0)
    {
      bool1 = true;
      this.this$0.runOnUiThread(new FilePreviewActivity.16.2(this, paramInt1, bool1, paramInt2, paramString));
      paramString = this.this$0;
      if (paramBoolean) {
        break label67;
      }
    }
    label67:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramString.ccR = paramBoolean;
      this.this$0.NR(1000);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void openFile(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = new Intent(this.this$0, FilePreviewActivity.class);
      ((Intent)localObject1).putExtra("offline_file_type", 1);
      ((Intent)localObject1).putExtra("offline_file_name", this.this$0.bGq);
      ((Intent)localObject1).putExtra("offline_file_url", this.this$0.bGp);
      ((Intent)localObject1).putExtra("offline_file_bZip", this.this$0.ccL);
      ((Intent)localObject1).putExtra("offline_file_domain", this.this$0.bGu);
      ((Intent)localObject1).putExtra("offline_file_port", this.this$0.bGv);
      ((Intent)localObject1).putExtra("offline_file_domain_key", this.this$0.bGt);
      ((Intent)localObject1).putExtra("offline_file_type_key", this.this$0.nFileType);
      ((Intent)localObject1).putExtra("OfflinePreZipPath", paramString2);
      ((Intent)localObject1).putExtra("OfflinePreZipDirName", paramString1);
      ((Intent)localObject1).putExtra("OfflinePreZipUUID", this.this$0.mUuid);
      if (!TextUtils.isEmpty(this.this$0.strCookie)) {
        ((Intent)localObject1).putExtra("COOKIE", this.this$0.strCookie);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "open zip dic,open new activity");
      this.this$0.startActivityForResult((Intent)localObject1, 0);
      return;
    }
    Object localObject1 = null;
    if (TextUtils.isEmpty(this.this$0.mUuid)) {}
    Object localObject3;
    do
    {
      Object localObject2;
      do
      {
        localObject2 = aglz.a();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("_filename_from_dlg", paramString1);
        ((Bundle)localObject3).putLong("_filesize_from_dlg", paramLong);
        ((Bundle)localObject3).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_file_preview");
        ((Bundle)localObject3).putString("big_brother_source_key", "biz_src_file_preview");
        Bundle localBundle = new Bundle();
        localBundle.putString("FILE_TMP_SERVER_PATH", (String)localObject1);
        localBundle.putInt("FILE_FROM", 190);
        if (!TextUtils.isEmpty(this.this$0.strCookie)) {
          localBundle.putString("COOKIE", this.this$0.strCookie);
        }
        if (QLog.isColorLevel()) {
          QLog.i("<FileAssistant>FilePreviewActivity", 1, "set cookies:" + this.this$0.strCookie);
        }
        ((Bundle)localObject3).putBundle("_user_data", localBundle);
        aqha.a(this.this$0, 233, this.this$0.getString(2131719001), "是否下载文件:\n" + paramString1 + "(" + ahbj.g(paramLong) + ")", new agbq(this, paramString2, (aglz)localObject2, (Bundle)localObject3), new agbr(this)).show();
        return;
        localObject2 = MD5.toMD5(this.this$0.mUuid + paramString2 + paramString1);
        localObject3 = this.this$0.app.a().b((String)localObject2);
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (!ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject3).getFilePath()));
    paramString1 = new ahau.a();
    paramString1.bJE = "file_viewer_in";
    paramString1.cYX = 73;
    paramString1.bJF = ahbj.getExtension(((FileManagerEntity)localObject3).fileName);
    paramString1.nFileSize = ((FileManagerEntity)localObject3).fileSize;
    ahau.a(this.this$0.app.getCurrentAccountUin(), paramString1);
    ahau.JH("0X8004AE4");
    paramString1 = new ForwardFileInfo();
    paramString1.Oj(((FileManagerEntity)localObject3).getCloudType());
    paramString1.setType(10000);
    paramString1.p(((FileManagerEntity)localObject3).nSessionId);
    paramString1.jB(((FileManagerEntity)localObject3).uniseq);
    paramString1.setFileName(((FileManagerEntity)localObject3).fileName);
    paramString1.setFileSize(((FileManagerEntity)localObject3).fileSize);
    paramString1.setUuid(((FileManagerEntity)localObject3).Uuid);
    paramString1.setLocalPath(((FileManagerEntity)localObject3).getFilePath());
    paramString2 = new ArrayList();
    try
    {
      paramString2.add(new FileInfo(((FileManagerEntity)localObject3).getFilePath()));
      if ((((FileManagerEntity)localObject3).nFileType == 0) || (((FileManagerEntity)localObject3).nFileType == 1)) {
        agmz.en(paramString2);
      }
      paramString2 = new Intent(this.this$0.getActivity(), FileBrowserActivity.class);
      paramString2.putExtra("fileinfo", paramString1);
      this.this$0.getActivity().startActivityForResult(paramString2, 102);
      ahau.JH("0X80052CD");
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public void updatePage(int paramInt1, int paramInt2)
  {
    this.this$0.runOnUiThread(new FilePreviewActivity.16.1(this, paramInt1, paramInt2));
  }
  
  public void webLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity_interfacePage", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbp
 * JD-Core Version:    0.7.0.1
 */