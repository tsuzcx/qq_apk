import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;

class vma
  implements Runnable
{
  vma(vlz paramvlz, boolean paramBoolean) {}
  
  public void run()
  {
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a, this.jdField_a_of_type_Vlz.a.findViewById(2131369412));
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setBackgroundResource(2130845678);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setVisibility(0);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a, (CheckBox)this.jdField_a_of_type_Vlz.a.findViewById(2131370073));
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a, (TextView)this.jdField_a_of_type_Vlz.a.findViewById(2131370075));
    PhotoListPanel.b(this.jdField_a_of_type_Vlz.a, (TextView)this.jdField_a_of_type_Vlz.a.findViewById(2131370074));
    PhotoListPanel.b(this.jdField_a_of_type_Vlz.a, this.jdField_a_of_type_Vlz.a.findViewById(2131370072));
    PhotoListPanel.c(this.jdField_a_of_type_Vlz.a, this.jdField_a_of_type_Vlz.a.findViewById(2131370076));
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setOnClickListener(this.jdField_a_of_type_Vlz.a);
    PhotoListPanel.b(this.jdField_a_of_type_Vlz.a).setOnClickListener(this.jdField_a_of_type_Vlz.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setOnClickListener(this.jdField_a_of_type_Vlz.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setOnClickListener(this.jdField_a_of_type_Vlz.a);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a, PhotoListPanel.a(this.jdField_a_of_type_Vlz.a), PhotoListPanel.b(this.jdField_a_of_type_Vlz.a));
    Object localObject = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject).a = Long.valueOf(this.jdField_a_of_type_Vlz.a.a).longValue();
    ((QZoneClickReport.ReportInfo)localObject).c = "459";
    ((QZoneClickReport.ReportInfo)localObject).d = "1";
    QZoneClickReport.report(this.jdField_a_of_type_Vlz.a.a, (QZoneClickReport.ReportInfo)localObject, true);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setOnCheckedChangeListener(null);
    PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setChecked(this.jdField_a_of_type_Boolean);
    CheckBox localCheckBox;
    StringBuilder localStringBuilder;
    if (AppSetting.b)
    {
      localCheckBox = PhotoListPanel.a(this.jdField_a_of_type_Vlz.a);
      localStringBuilder = new StringBuilder().append("上传到").append(PhotoListPanel.b(this.jdField_a_of_type_Vlz.a)).append(" ");
      if (!this.jdField_a_of_type_Boolean) {
        break label493;
      }
    }
    label493:
    for (localObject = "已选中";; localObject = "未选中")
    {
      localCheckBox.setContentDescription((String)localObject);
      PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setOnCheckedChangeListener(this.jdField_a_of_type_Vlz.a);
      PhotoListPanel.a(this.jdField_a_of_type_Vlz.a).setOnClickListener(this.jdField_a_of_type_Vlz.a);
      this.jdField_a_of_type_Vlz.a.h();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vma
 * JD-Core Version:    0.7.0.1
 */