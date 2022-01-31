import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
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

public class xea
  implements View.OnClickListener
{
  public xea(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = PresendPicMgr.a(null);
    if (this.a.jdField_c_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.a.r)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int i = this.a.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.r));
      if (i >= 0)
      {
        this.a.jdField_b_of_type_JavaUtilArrayList.remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r));
        this.a.jdField_c_of_type_JavaUtilArrayList.remove(i);
        if (PhotoPreviewActivity.a(this.a) != null) {
          PhotoPreviewActivity.a(this.a).remove(this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r));
        }
        if (paramView != null) {
          paramView.b((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r), 1014);
        }
      }
      this.a.e();
      if ((this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (!PhotoPreviewActivity.a(this.a))) {
        PhotoPreviewActivity.a(this.a, false);
      }
    }
    for (;;)
    {
      if (((this.a.k) || (this.a.l)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager != null))
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager.a(this.a.jdField_b_of_type_JavaUtilArrayList);
        PhotoPreviewActivity.a(this.a, (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r));
      }
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
      if ((this.a.e == 2) && (this.a.r < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.r >= 0) && (new File((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r)).length() > 19922944L))
      {
        QQToast.a(this.a, this.a.getResources().getString(2131435938), 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      Object localObject;
      if ((this.a.s) && (this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.r < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.r >= 0) && (this.a.r < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.r >= 0))
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r);
        LocalMediaInfo localLocalMediaInfo = PhotoPreviewActivity.a(this.a, (String)localObject);
        if ((PhotoPreviewActivity.a(this.a, (String)localObject) == 1) && (!AlbumUtil.a(this.a, PhotoPreviewActivity.a(this.a), localLocalMediaInfo, this.a.j)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
      }
      if (this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false))
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r);
        if ((Utils.a((String)localObject)) && (FileUtils.a((String)localObject) > 3145728L))
        {
          QQToast.a(this.a, "图片文件过大", 0).b(this.a.d);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          return;
        }
      }
      if ((paramView != null) && (this.a.r < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.r >= 0) && (!PhotoPreviewActivity.a(this.a))) {
        paramView.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r), this.a.m);
      }
      paramView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.r);
      if ((this.a.r < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (this.a.r >= 0))
      {
        this.a.jdField_b_of_type_JavaUtilArrayList.add(paramView);
        this.a.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(this.a.r));
        if (this.a.s)
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
      PhotoPreviewActivity.a(this.a, this.a.jdField_c_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(this.a.r)) + 1);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xea
 * JD-Core Version:    0.7.0.1
 */