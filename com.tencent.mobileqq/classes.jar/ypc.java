import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ypc
  extends yph
{
  public ypc(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, bbnr parambbnr)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131298914);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, parambbnr);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839128);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755335);
      MoveFileActivity.a(this.a).i(parambbnr);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      azmj.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", parambbnr.b, "", "");
      QQToast.a(this.a.getActivity(), 2, alpo.a(2131707282), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      parambbnr = this.a.getString(2131696553);
      QQToast.a(this.a.getActivity(), 1, parambbnr, 0).b(i);
      return;
    case -313: 
      parambbnr = this.a.getString(2131697802);
      azmj.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697969), null, this.a.jdField_a_of_type_JavaLangString, parambbnr);
      return;
      parambbnr = this.a.getString(2131697807);
      azmj.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      parambbnr = this.a.getString(2131697805);
      QQToast.a(this.a.getActivity(), 1, parambbnr, 0).b(i);
      return;
      parambbnr = this.a.getString(2131697804);
      QQToast.a(this.a.getActivity(), 1, parambbnr, 0).b(i);
      return;
      parambbnr = this.a.getString(2131697808);
      QQToast.a(this.a.getActivity(), 1, parambbnr, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ypc
 * JD-Core Version:    0.7.0.1
 */