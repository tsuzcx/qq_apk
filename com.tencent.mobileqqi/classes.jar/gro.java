import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class gro
  implements AdapterView.OnItemSelectedListener
{
  public gro(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    this.a.jdField_a_of_type_Int = paramInt;
    if (this.a.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.a.b, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.j, "0", "", "");
      return;
    }
    ReportController.b(this.a.b, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.j, "1", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gro
 * JD-Core Version:    0.7.0.1
 */