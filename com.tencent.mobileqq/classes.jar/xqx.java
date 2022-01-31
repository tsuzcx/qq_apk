import android.app.Activity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class xqx
  implements FFmpegExecuteResponseCallback
{
  long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  xqx(xqu paramxqu, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a()
  {
    SaveVideoActivity.a(true);
  }
  
  public void a(String paramString)
  {
    com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), new File(this.b));
    com.tencent.mobileqq.utils.FileUtils.d(new File(this.jdField_a_of_type_JavaLangString).getParent());
  }
  
  public void a(boolean paramBoolean)
  {
    double d = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D;
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "generate files|third step cost:" + d);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("generate_video_cost", this.jdField_a_of_type_Xqu.a + "");
    ((HashMap)localObject).put("watermark_cost", d + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject, null);
    com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_JavaLangString);
    SaveVideoActivity.a(false);
    if (xqu.a(this.jdField_a_of_type_Xqu).get() != null)
    {
      localObject = (Activity)xqu.a(this.jdField_a_of_type_Xqu).get();
      if (xqu.b(this.jdField_a_of_type_Xqu).get() != null) {
        SaveVideoActivity.a((AppInterface)xqu.b(this.jdField_a_of_type_Xqu).get(), this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      }
      if (!paramBoolean) {
        break label238;
      }
    }
    label238:
    for (int i = xqu.a(this.jdField_a_of_type_Xqu, -1);; i = xqu.a(this.jdField_a_of_type_Xqu, 1))
    {
      ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
      ((Activity)localObject).finish();
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "generate files|third step fail:" + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqx
 * JD-Core Version:    0.7.0.1
 */