import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class vwu
  implements ausj.a
{
  public vwu(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.c(this.this$0, true);
      this.b.dismiss();
      this.this$0.wC(this.this$0.getShareUrl());
      return;
    }
    this.b.dismiss();
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwu
 * JD-Core Version:    0.7.0.1
 */