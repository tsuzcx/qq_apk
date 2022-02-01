import android.util.SparseArray;
import android.view.View;
import com.tencent.tim.teamwork.TeamWorkAuthorizeSettingActivity;

public class auki
  implements ausj.a
{
  public auki(TeamWorkAuthorizeSettingActivity paramTeamWorkAuthorizeSettingActivity, SparseArray paramSparseArray, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.dt.get(paramInt) == null)
    {
      paramInt = -1;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingActivity.a(this.a);
      if (this.val$sheet.isShowing()) {
        this.val$sheet.dismiss();
      }
      return;
      paramInt = ((Integer)this.dt.get(paramInt)).intValue();
      break;
      TeamWorkAuthorizeSettingActivity.a(this.a, 2);
      continue;
      TeamWorkAuthorizeSettingActivity.a(this.a, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auki
 * JD-Core Version:    0.7.0.1
 */