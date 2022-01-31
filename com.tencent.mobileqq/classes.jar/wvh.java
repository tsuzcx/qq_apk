import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TribeUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;

public class wvh
  implements View.OnClickListener
{
  public wvh(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.a.f = ((String)this.a.jdField_b_of_type_JavaUtilArrayList.get(0));
      if (this.a.f != null)
      {
        ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (this.a.w) {
          ReportController.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
        }
        new Intent();
        if (!this.a.h) {
          break label463;
        }
        if (!this.a.jdField_b_of_type_Boolean) {
          break label372;
        }
        paramView = EditPicActivity.a(this.a, this.a.f, true, true, true, true, true, 8);
        label152:
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.e);
        if (!PhotoPreviewActivity.a(this.a)) {
          break label490;
        }
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        label186:
        this.a.startActivity(paramView);
        this.a.overridePendingTransition(2131034165, 2131034167);
        this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramView = this.a.getIntent();
        if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
        {
          paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
          if (paramView != null) {
            ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
        }
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
        {
          if (!TroopBarPublishActivity.class.getSimpleName().equals(this.a.jdField_a_of_type_JavaLangString)) {
            break label507;
          }
          TribeUtils.a("pub_page_new", "clk_photo_edit", 0, 0, new String[0]);
        }
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 4, 1);
      return;
      int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.getFirstVisiblePosition();
      if (i >= this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      this.a.f = ((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i));
      break;
      label372:
      paramView = new HashMap(1);
      if ((this.a.jdField_b_of_type_JavaUtilHashMap != null) && (this.a.jdField_b_of_type_JavaUtilHashMap.get(this.a.f) != null)) {
        paramView.put("param_localmediainfo", this.a.jdField_b_of_type_JavaUtilHashMap.get(this.a.f));
      }
      paramView = EditPicActivity.a(this.a, this.a.f, true, true, true, true, true, 3, 99, 4, paramView);
      break label152;
      label463:
      paramView = EditPicActivity.a(this.a, this.a.f, true, true, true, true, true, 2, 99, 4);
      break label152;
      label490:
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", PhotoPreviewActivity.b(this.a));
      break label186;
      label507:
      if (TroopBarReplyActivity.class.getSimpleName().equals(this.a.jdField_a_of_type_JavaLangString)) {
        TribeUtils.a("reply", "clk_photo_edit", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvh
 * JD-Core Version:    0.7.0.1
 */