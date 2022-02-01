import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;

public class aocj
  implements ausj.a
{
  public aocj(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, SparseArray paramSparseArray, ausj paramausj) {}
  
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
      TeamWorkAuthorizeSettingFragment.a(this.a);
      if (this.val$sheet.isShowing()) {
        this.val$sheet.dismiss();
      }
      return;
      paramInt = ((Integer)this.dt.get(paramInt)).intValue();
      break;
      TeamWorkAuthorizeSettingFragment.a(this.a, 2);
      continue;
      TeamWorkAuthorizeSettingFragment.a(this.a, 1);
      continue;
      TeamWorkAuthorizeSettingFragment.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocj
 * JD-Core Version:    0.7.0.1
 */