import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class rfe
  extends aopm
{
  public rfe(ArtFilterManager paramArtFilterManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realCancel download url:" + this.val$url + " path:" + this.val$outputPath);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realStart download url:" + this.val$url + " path:" + this.val$outputPath);
    }
    aqvc localaqvc = ((aqva)ArtFilterManager.a(this.this$0).getManager(47)).a(1);
    aquz localaquz = new aquz(this.val$url, this.I);
    localaquz.cWw = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.val$url);
    localBundle.putString("md5", this.val$md5);
    localBundle.putString("path", this.val$outputPath);
    localaqvc.a(localaquz, ArtFilterManager.a(this.this$0), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfe
 * JD-Core Version:    0.7.0.1
 */