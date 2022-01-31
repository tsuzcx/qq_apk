import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;

class vpc
  implements Runnable
{
  vpc(vpb paramvpb, boolean paramBoolean) {}
  
  public void run()
  {
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a, this.jdField_a_of_type_Vpb.a.findViewById(2131369478));
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setBackgroundResource(2130845806);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setVisibility(0);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a, (CheckBox)this.jdField_a_of_type_Vpb.a.findViewById(2131370184));
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a, (TextView)this.jdField_a_of_type_Vpb.a.findViewById(2131370186));
    PhotoListPanel.b(this.jdField_a_of_type_Vpb.a, (TextView)this.jdField_a_of_type_Vpb.a.findViewById(2131370185));
    PhotoListPanel.b(this.jdField_a_of_type_Vpb.a, this.jdField_a_of_type_Vpb.a.findViewById(2131370183));
    PhotoListPanel.c(this.jdField_a_of_type_Vpb.a, this.jdField_a_of_type_Vpb.a.findViewById(2131370187));
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setOnClickListener(this.jdField_a_of_type_Vpb.a);
    PhotoListPanel.b(this.jdField_a_of_type_Vpb.a).setOnClickListener(this.jdField_a_of_type_Vpb.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setOnClickListener(this.jdField_a_of_type_Vpb.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setOnClickListener(this.jdField_a_of_type_Vpb.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a, PhotoListPanel.a(this.jdField_a_of_type_Vpb.a), PhotoListPanel.b(this.jdField_a_of_type_Vpb.a));
    Object localObject = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject).a = Long.valueOf(this.jdField_a_of_type_Vpb.a.a).longValue();
    ((QZoneClickReport.ReportInfo)localObject).c = "459";
    ((QZoneClickReport.ReportInfo)localObject).d = "1";
    QZoneClickReport.report(this.jdField_a_of_type_Vpb.a.a, (QZoneClickReport.ReportInfo)localObject, true);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setOnCheckedChangeListener(null);
    PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setChecked(this.jdField_a_of_type_Boolean);
    CheckBox localCheckBox;
    StringBuilder localStringBuilder;
    if (AppSetting.b)
    {
      localCheckBox = PhotoListPanel.a(this.jdField_a_of_type_Vpb.a);
      localStringBuilder = new StringBuilder().append("上传到").append(PhotoListPanel.b(this.jdField_a_of_type_Vpb.a)).append(" ");
      if (!this.jdField_a_of_type_Boolean) {
        break label493;
      }
    }
    label493:
    for (localObject = "已选中";; localObject = "未选中")
    {
      localCheckBox.setContentDescription((String)localObject);
      PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setOnCheckedChangeListener(this.jdField_a_of_type_Vpb.a);
      PhotoListPanel.a(this.jdField_a_of_type_Vpb.a).setOnClickListener(this.jdField_a_of_type_Vpb.a);
      this.jdField_a_of_type_Vpb.a.h();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpc
 * JD-Core Version:    0.7.0.1
 */