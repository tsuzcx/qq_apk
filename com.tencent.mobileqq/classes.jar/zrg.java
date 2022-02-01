import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class zrg
  extends zrp
{
  public zrg(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, bebc parambebc)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131299076);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, parambebc);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130839347);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755343);
      MoveFileActivity.a(this.a).i(parambebc);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      bcef.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.jdField_a_of_type_Long + "", parambebc.b, "", "");
      QQToast.a(this.a.getActivity(), 2, amtj.a(2131706022), 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      parambebc = this.a.getString(2131695563);
      QQToast.a(this.a.getActivity(), 1, parambebc, 0).b(i);
      return;
    case -313: 
      parambebc = this.a.getString(2131696836);
      bcef.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131697005), null, this.a.jdField_a_of_type_JavaLangString, parambebc);
      return;
      parambebc = this.a.getString(2131696841);
      bcef.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "1", "", "");
      continue;
      parambebc = this.a.getString(2131696839);
      QQToast.a(this.a.getActivity(), 1, parambebc, 0).b(i);
      return;
      parambebc = this.a.getString(2131696838);
      QQToast.a(this.a.getActivity(), 1, parambebc, 0).b(i);
      return;
      parambebc = this.a.getString(2131696842);
      QQToast.a(this.a.getActivity(), 1, parambebc, 0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrg
 * JD-Core Version:    0.7.0.1
 */