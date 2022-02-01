import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity.a;

public class ayux
  extends rpz
{
  public ayux(SaveVideoActivity.a parama, String paramString1, PeakActivity paramPeakActivity, String paramString2, String paramString3, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    SaveVideoActivity.a.a(this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, 1, this.jdField_b_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "combine music finish: " + paramBoolean);
    }
    aqhq.deleteFile(this.val$targetPath);
    if (paramBoolean)
    {
      SaveVideoActivity.a.a(this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, this.a, this.val$outputPath, this.cXX, this.jdField_b_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    SaveVideoActivity.a.a(this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$a, 1, this.jdField_b_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayux
 * JD-Core Version:    0.7.0.1
 */