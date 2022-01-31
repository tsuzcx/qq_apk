import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xcw
  extends bazx
{
  public xcw(ArtFilterManager paramArtFilterManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4)
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
    beaj localbeaj = ((beag)ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager).getManager(47)).a(1);
    beae localbeae = new beae(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
    localbeae.n = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("md5", this.c);
    localBundle.putString("path", this.b);
    localbeaj.a(localbeae, ArtFilterManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterManager), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcw
 * JD-Core Version:    0.7.0.1
 */