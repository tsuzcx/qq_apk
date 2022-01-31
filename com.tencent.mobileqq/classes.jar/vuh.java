import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

class vuh
  implements Runnable
{
  vuh(vug paramvug, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a, this.jdField_a_of_type_Vug.a.findViewById(2131369487));
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setBackgroundResource(2130845887);
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setVisibility(0);
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a, (CheckBox)this.jdField_a_of_type_Vug.a.findViewById(2131370193));
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a, (TextView)this.jdField_a_of_type_Vug.a.findViewById(2131370195));
    PhotoListPanel.b(this.jdField_a_of_type_Vug.a, (TextView)this.jdField_a_of_type_Vug.a.findViewById(2131370194));
    PhotoListPanel.b(this.jdField_a_of_type_Vug.a, this.jdField_a_of_type_Vug.a.findViewById(2131370192));
    PhotoListPanel.c(this.jdField_a_of_type_Vug.a, this.jdField_a_of_type_Vug.a.findViewById(2131370196));
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setOnClickListener(this.jdField_a_of_type_Vug.a);
    PhotoListPanel.b(this.jdField_a_of_type_Vug.a).setOnClickListener(this.jdField_a_of_type_Vug.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setOnClickListener(this.jdField_a_of_type_Vug.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setOnClickListener(this.jdField_a_of_type_Vug.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vug.a, PhotoListPanel.a(this.jdField_a_of_type_Vug.a), PhotoListPanel.b(this.jdField_a_of_type_Vug.a), this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new LpReportInfo_pf00064(723, 1, 1);
      LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      PhotoListPanel.a(this.jdField_a_of_type_Vug.a, "aio_sync_qzone", "operation_type", "panel_expose");
    }
    for (;;)
    {
      PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setOnCheckedChangeListener(null);
      PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setChecked(this.b);
      if (AppSetting.b)
      {
        CheckBox localCheckBox = PhotoListPanel.a(this.jdField_a_of_type_Vug.a);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject = "同步上传至";
        localCheckBox.setContentDescription((CharSequence)localObject);
      }
      PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setOnCheckedChangeListener(this.jdField_a_of_type_Vug.a);
      PhotoListPanel.a(this.jdField_a_of_type_Vug.a).setOnClickListener(this.jdField_a_of_type_Vug.a);
      this.jdField_a_of_type_Vug.a.h();
      return;
      localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).a = Long.valueOf(this.jdField_a_of_type_Vug.a.a).longValue();
      ((QZoneClickReport.ReportInfo)localObject).c = "459";
      ((QZoneClickReport.ReportInfo)localObject).d = "1";
      QZoneClickReport.report(this.jdField_a_of_type_Vug.a.a, (QZoneClickReport.ReportInfo)localObject, true);
    }
    StringBuilder localStringBuilder = new StringBuilder().append("上传到").append(PhotoListPanel.b(this.jdField_a_of_type_Vug.a)).append(" ");
    if (this.b) {}
    for (Object localObject = "已选中";; localObject = "未选中")
    {
      localObject = (String)localObject;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuh
 * JD-Core Version:    0.7.0.1
 */