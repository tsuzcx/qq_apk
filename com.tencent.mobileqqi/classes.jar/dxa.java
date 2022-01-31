import android.app.Dialog;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class dxa
  extends DiscussionObserver
{
  public dxa(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      TroopMemberListActivity.a(this.a, 0L);
      this.a.c = null;
      this.a.c(paramLong2 + "");
      if (this.a.jdField_a_of_type_Dxo != null) {
        this.a.jdField_a_of_type_Dxo.a();
      }
      if (TroopMemberListActivity.a(this.a))
      {
        this.a.b(paramLong2 + "");
        if (this.a.jdField_a_of_type_Dxu != null) {
          this.a.jdField_a_of_type_Dxu.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      QQToast.a(this.a, 1, this.a.getString(2131562054), 0).b(this.a.d());
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    this.a.runOnUiThread(new dxb(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2));
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxa
 * JD-Core Version:    0.7.0.1
 */