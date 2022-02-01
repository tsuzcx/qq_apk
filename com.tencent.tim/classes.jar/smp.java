import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.biz.troop.file.MoveFileActivity.a;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class smp
  extends smq.a
{
  public smp(MoveFileActivity paramMoveFileActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, apbr paramapbr)
  {
    if (this.this$0.getActivity().isFinishing()) {
      return;
    }
    this.this$0.ath();
    int i = this.this$0.getActivity().getResources().getDimensionPixelSize(2131299627);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.this$0).add(0, paramapbr);
      MoveFileActivity.c(this.this$0, 0);
      MoveFileActivity.a(this.this$0).setEnabled(true);
      MoveFileActivity.a(this.this$0).setBackgroundResource(2130839545);
      MoveFileActivity.a(this.this$0).setTextAppearance(this.this$0.getActivity(), 2131755587);
      MoveFileActivity.a(this.this$0).t(paramapbr);
      MoveFileActivity.a(this.this$0).notifyDataSetChanged();
      anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.this$0.CV + "", paramapbr.mFileId, "", "");
      QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131708476), 0).show(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramapbr = this.this$0.getString(2131698310);
      QQToast.a(this.this$0.getActivity(), 1, paramapbr, 0).show(i);
      return;
    case -313: 
      paramapbr = this.this$0.getString(2131699585);
      anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.this$0.CV + "", "1", "", "");
    }
    for (;;)
    {
      this.this$0.r(this.this$0.getResources().getString(2131699754), null, this.this$0.aEH, paramapbr);
      return;
      paramapbr = this.this$0.getString(2131699590);
      anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.this$0.CV + "", "1", "", "");
      continue;
      paramapbr = this.this$0.getString(2131699588);
      QQToast.a(this.this$0.getActivity(), 1, paramapbr, 0).show(i);
      return;
      paramapbr = this.this$0.getString(2131699587);
      QQToast.a(this.this$0.getActivity(), 1, paramapbr, 0).show(i);
      return;
      paramapbr = this.this$0.getString(2131699591);
      QQToast.a(this.this$0.getActivity(), 1, paramapbr, 0).show(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smp
 * JD-Core Version:    0.7.0.1
 */