import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wyn
  extends bavo
{
  public wyn(ArtFilterManager paramArtFilterManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realCancel download url:" + this.jdField_a_of_type_JavaLangString + " path:" + this.b);
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterManager", 2, "realStart download url:" + this.jdField_a_of_type_JavaLangString + " path:" + this.b);
    }
    bdwa localbdwa = ((bdvx)ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager).getManager(47)).a(1);
    bdvv localbdvv = new bdvv(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    localbdvv.n = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("md5", this.c);
    localBundle.putString("path", this.b);
    localbdwa.a(localbdvv, ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyn
 * JD-Core Version:    0.7.0.1
 */