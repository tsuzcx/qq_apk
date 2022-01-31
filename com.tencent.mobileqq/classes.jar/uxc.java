import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class uxc
  extends axxg
{
  public uxc(ArtFilterManager paramArtFilterManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4)
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
    batr localbatr = ((bato)ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager).getManager(47)).a(1);
    batm localbatm = new batm(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    localbatm.n = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("md5", this.c);
    localBundle.putString("path", this.b);
    localbatr.a(localbatm, ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */