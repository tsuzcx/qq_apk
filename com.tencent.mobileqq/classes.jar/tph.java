import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;

public class tph
  implements Runnable
{
  public tph(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void run()
  {
    long l1 = SdCardUtil.a();
    long l2 = SdCardUtil.a(this.a);
    long l3 = SdCardUtil.b();
    long l4 = SdCardUtil.b(this.a);
    this.a.b = (l1 + l2);
    this.a.e = (l3 + l4);
    tpi localtpi = new tpi(this);
    this.a.c = StorageReport.a().a(localtpi, 0, 98);
    this.a.d = StorageReport.a().a(QQSettingCleanActivity.jdField_a_of_type_JavaUtilArrayList);
    this.a.c -= this.a.d;
    localtpi.a(100);
    QLog.d("QQCleanActivity", 1, "SpaceInfo total: " + this.a.b + " ava: " + this.a.e + " qq: " + this.a.c + " file: " + this.a.d);
    QLog.d("QQCleanActivity", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.setFinish(this.a.c, this.a.d, this.a.b - this.a.c - this.a.d - this.a.e, this.a.e, 3.0F);
    this.a.runOnUiThread(new tpj(this.a, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tph
 * JD-Core Version:    0.7.0.1
 */