import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.VerifyPwdView;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class atnx
  implements AdapterView.OnItemSelectedListener
{
  public atnx(FMActivity paramFMActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = -1;
    if (this.a.Se != null) {
      this.a.Se.setVisibility(8);
    }
    this.a.deM();
    this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView != null)
    {
      this.a.kk.removeAllViews();
      this.a.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView.finish();
      this.a.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView = null;
      this.a.kk.addView(this.a.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileTabBarView);
      this.a.kk.addView(this.a.KD);
    }
    if (FMActivity.Eh.indexOf(FMActivity.cHO) == paramInt)
    {
      this.a.a().dlc();
      FMActivity.c(this.a);
      i = 0;
    }
    if (FMActivity.Eh.indexOf(FMActivity.cHP) == paramInt)
    {
      FMActivity.d(this.a);
      i = 0;
    }
    for (;;)
    {
      paramAdapterView = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      paramAdapterView.putInt("last_select_tab_type", i);
      paramAdapterView.commit();
      return;
      if (FMActivity.Eh.indexOf(FMActivity.cHQ) == paramInt)
      {
        this.a.a().dlb();
        FMActivity.e(this.a);
        i = 1;
      }
      else if (FMActivity.Eh.indexOf(FMActivity.cHR) == paramInt)
      {
        this.a.a().dla();
        FMActivity.a(this.a, 2);
        i = 2;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnx
 * JD-Core Version:    0.7.0.1
 */