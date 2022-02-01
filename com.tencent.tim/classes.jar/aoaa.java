import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeSettingActivity;

public class aoaa
  implements ausj.a
{
  public aoaa(TeamWorkAuthorizeSettingActivity paramTeamWorkAuthorizeSettingActivity, SparseArray paramSparseArray, ausj paramausj) {}
  
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
      TeamWorkAuthorizeSettingActivity.a(this.a, 1);
      continue;
      TeamWorkAuthorizeSettingActivity.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoaa
 * JD-Core Version:    0.7.0.1
 */