import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ytr
  extends ytw
{
  public ytr(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, bbsa parambbsa)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131298914);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, parambbsa);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839129);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755335);
      MoveFileActivity.a(this.a).i(parambbsa);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      azqs.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", parambbsa.b, "", "");
      QQToast.a(this.a.getActivity(), 2, alud.a(2131707294), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      parambbsa = this.a.getString(2131696555);
      QQToast.a(this.a.getActivity(), 1, parambbsa, 0).b(i);
      return;
    case -313: 
      parambbsa = this.a.getString(2131697804);
      azqs.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697971), null, this.a.jdField_a_of_type_JavaLangString, parambbsa);
      return;
      parambbsa = this.a.getString(2131697809);
      azqs.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      parambbsa = this.a.getString(2131697807);
      QQToast.a(this.a.getActivity(), 1, parambbsa, 0).b(i);
      return;
      parambbsa = this.a.getString(2131697806);
      QQToast.a(this.a.getActivity(), 1, parambbsa, 0).b(i);
      return;
      parambbsa = this.a.getString(2131697810);
      QQToast.a(this.a.getActivity(), 1, parambbsa, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytr
 * JD-Core Version:    0.7.0.1
 */