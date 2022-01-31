import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import java.util.ArrayList;

public class xam
  extends xar
{
  public xam(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, azpg paramazpg)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131298865);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, paramazpg);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839047);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755329);
      MoveFileActivity.a(this.a).i(paramazpg);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      axqw.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", paramazpg.b, "", "");
      bcpw.a(this.a.getActivity(), 2, ajyc.a(2131706899), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramazpg = this.a.getString(2131696380);
      bcpw.a(this.a.getActivity(), 1, paramazpg, 0).b(i);
      return;
    case -313: 
      paramazpg = this.a.getString(2131697626);
      axqw.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697782), null, this.a.jdField_a_of_type_JavaLangString, paramazpg);
      return;
      paramazpg = this.a.getString(2131697631);
      axqw.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      paramazpg = this.a.getString(2131697629);
      bcpw.a(this.a.getActivity(), 1, paramazpg, 0).b(i);
      return;
      paramazpg = this.a.getString(2131697628);
      bcpw.a(this.a.getActivity(), 1, paramazpg, 0).b(i);
      return;
      paramazpg = this.a.getString(2131697632);
      bcpw.a(this.a.getActivity(), 1, paramazpg, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xam
 * JD-Core Version:    0.7.0.1
 */