import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class yqe
  extends AbsPreDownloadTask
{
  public yqe(ArtFilterManager paramArtFilterManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  public void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realCancel download url:" + this.jdField_a_of_type_JavaLangString + " path:" + this.b);
    }
  }
  
  public void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realStart download url:" + this.jdField_a_of_type_JavaLangString + " path:" + this.b);
    }
    bhyt localbhyt = ((bhyq)ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    bhyo localbhyo = new bhyo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    localbhyo.n = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("md5", this.c);
    localBundle.putString("path", this.b);
    localbhyt.a(localbhyo, ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqe
 * JD-Core Version:    0.7.0.1
 */