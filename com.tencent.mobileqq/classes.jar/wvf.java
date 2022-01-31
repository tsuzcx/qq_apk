import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class wvf
  implements View.OnClickListener
{
  public wvf(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = PresendPicMgr.a(null);
    if (this.a.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.jdField_r_of_type_Int)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int i = this.a.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.jdField_r_of_type_Int));
      if (i >= 0)
      {
        this.a.jdField_b_of_type_JavaUtilArrayList.remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int));
        this.a.jdField_c_of_type_JavaUtilArrayList.remove(i);
        if (PhotoPreviewActivity.a(this.a) != null) {
          PhotoPreviewActivity.a(this.a).remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int));
        }
        if (paramView != null) {
          paramView.b((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int), 1014);
        }
      }
      this.a.e();
      if ((this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (!PhotoPreviewActivity.a(this.a))) {
        PhotoPreviewActivity.a(this.a, false);
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 2);
      return;
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() >= this.a.jdField_c_of_type_Int)
      {
        long l = System.currentTimeMillis();
        if (l - this.a.jdField_a_of_type_Long >= 700L)
        {
          QQToast.a(this.a, this.a.a(), 1000).b(this.a.d);
          this.a.jdField_a_of_type_Long = l;
          if (PhotoPreviewActivity.b(this.a)) {
            ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((this.a.e == 2) && (this.a.jdField_r_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.jdField_r_of_type_Int >= 0) && (new File((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int)).length() > 19922944L))
      {
        QQToast.a(this.a, this.a.getResources().getString(2131435903), 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      Object localObject;
      if ((this.a.jdField_r_of_type_Boolean) && (this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_r_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.jdField_r_of_type_Int >= 0) && (this.a.jdField_r_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.jdField_r_of_type_Int >= 0))
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int);
        LocalMediaInfo localLocalMediaInfo = PhotoPreviewActivity.a(this.a, (String)localObject);
        if ((PhotoPreviewActivity.a(this.a, (String)localObject) == 1) && (!AlbumUtil.a(this.a, PhotoPreviewActivity.a(this.a), localLocalMediaInfo, this.a.j)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
      }
      if (this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false))
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int);
        if ((Utils.a((String)localObject)) && (FileUtils.a((String)localObject) > 3145728L))
        {
          QQToast.a(this.a, "图片文件过大", 0).b(this.a.d);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
      }
      if ((paramView != null) && (this.a.jdField_r_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.jdField_r_of_type_Int >= 0) && (!PhotoPreviewActivity.a(this.a))) {
        paramView.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int), this.a.m);
      }
      paramView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_r_of_type_Int);
      if ((this.a.jdField_r_of_type_Int < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.jdField_r_of_type_Int >= 0))
      {
        this.a.jdField_b_of_type_JavaUtilArrayList.add(paramView);
        this.a.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(this.a.jdField_r_of_type_Int));
        if (this.a.jdField_r_of_type_Boolean)
        {
          if (this.a.jdField_b_of_type_JavaUtilHashMap == null) {
            this.a.jdField_b_of_type_JavaUtilHashMap = new HashMap();
          }
          localObject = PhotoPreviewActivity.a(this.a, paramView);
          this.a.jdField_b_of_type_JavaUtilHashMap.put(paramView, localObject);
          if (PhotoPreviewActivity.a(this.a) == null) {
            PhotoPreviewActivity.a(this.a, new HashMap());
          }
          if (localObject != null) {
            PhotoPreviewActivity.a(this.a).put(paramView, Integer.valueOf(((LocalMediaInfo)localObject).panoramaPhotoType));
          }
        }
      }
      PhotoPreviewActivity.a(this.a, this.a.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.jdField_r_of_type_Int)) + 1);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvf
 * JD-Core Version:    0.7.0.1
 */