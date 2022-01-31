import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import java.util.ArrayList;

public class xaj
  extends xao
{
  public xaj(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, azpi paramazpi)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131298865);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, paramazpi);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839047);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755329);
      MoveFileActivity.a(this.a).i(paramazpi);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      axqy.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", paramazpi.b, "", "");
      bcql.a(this.a.getActivity(), 2, ajya.a(2131706910), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramazpi = this.a.getString(2131696381);
      bcql.a(this.a.getActivity(), 1, paramazpi, 0).b(i);
      return;
    case -313: 
      paramazpi = this.a.getString(2131697627);
      axqy.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697792), null, this.a.jdField_a_of_type_JavaLangString, paramazpi);
      return;
      paramazpi = this.a.getString(2131697632);
      axqy.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      paramazpi = this.a.getString(2131697630);
      bcql.a(this.a.getActivity(), 1, paramazpi, 0).b(i);
      return;
      paramazpi = this.a.getString(2131697629);
      bcql.a(this.a.getActivity(), 1, paramazpi, 0).b(i);
      return;
      paramazpi = this.a.getString(2131697633);
      bcql.a(this.a.getActivity(), 1, paramazpi, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xaj
 * JD-Core Version:    0.7.0.1
 */