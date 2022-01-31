import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

class bda
  implements ActionSheet.OnButtonClickListener
{
  bda(bcz parambcz) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (QfavBuilder.a((float)this.a.a.jdField_a_of_type_Double, (float)this.a.a.b, this.a.a.o, this.a.a.l, null).c(this.a.a.getIntent().getStringExtra("uin")).a(this.a.a, this.a.a.getIntent().getStringExtra("uin"), 1, null))
      {
        paramInt = QQMapActivity.d(this.a.a).getDimensionPixelSize(2131492887);
        QQToast.a(this.a.a, 2, this.a.a.getString(2131362663), 1).b(paramInt);
      }
      QfavReport.a(null, 65, 7);
      ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_collect", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bda
 * JD-Core Version:    0.7.0.1
 */