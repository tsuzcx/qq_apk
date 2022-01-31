import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import java.util.ArrayList;

public class wlk
  extends wlp
{
  public wlk(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, ayoq paramayoq)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131167766);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, paramayoq);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839019);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131689792);
      MoveFileActivity.a(this.a).i(paramayoq);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      awqx.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", paramayoq.b, "", "");
      bbmy.a(this.a.getActivity(), 2, ajjy.a(2131641114), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramayoq = this.a.getString(2131630677);
      bbmy.a(this.a.getActivity(), 1, paramayoq, 0).b(i);
      return;
    case -313: 
      paramayoq = this.a.getString(2131631912);
      awqx.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131632062), null, this.a.jdField_a_of_type_JavaLangString, paramayoq);
      return;
      paramayoq = this.a.getString(2131631917);
      awqx.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      paramayoq = this.a.getString(2131631915);
      bbmy.a(this.a.getActivity(), 1, paramayoq, 0).b(i);
      return;
      paramayoq = this.a.getString(2131631914);
      bbmy.a(this.a.getActivity(), 1, paramayoq, 0).b(i);
      return;
      paramayoq = this.a.getString(2131631918);
      bbmy.a(this.a.getActivity(), 1, paramayoq, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wlk
 * JD-Core Version:    0.7.0.1
 */