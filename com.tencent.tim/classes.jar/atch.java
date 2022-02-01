import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.tim.activity.profile.host.HostProfileFragment;

public class atch
  implements ausj.a
{
  public atch(HostProfileFragment paramHostProfileFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      HostProfileFragment.b(this.this$0);
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.this$0.getActivity().checkSelfPermission("android.permission.CAMERA") != 0)
        {
          paramInt = 1;
          if (paramInt != 0) {
            this.this$0.getActivity().requestPermissions(new atci(this), 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else
        {
          paramInt = 0;
          continue;
        }
        HostProfileFragment.a(this.this$0, ProfileActivity.a(this.this$0.getActivity(), 5));
      }
      else
      {
        HostProfileFragment.a(this.this$0, ProfileActivity.a(this.this$0.getActivity(), 5));
        continue;
        aqep.a(HostProfileFragment.a(this.this$0), this.this$0.getActivity(), HostProfileFragment.a(this.this$0), HostProfileFragment.a(this.this$0).e.uin, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atch
 * JD-Core Version:    0.7.0.1
 */