import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;

public class arql
  implements ausj.a
{
  public arql(CreateVirtualAccountFragment paramCreateVirtualAccountFragment, ausj paramausj) {}
  
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
      paramView = new Intent();
      paramInt = aqep.w(this.this$0.getActivity());
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramView.putExtra("Business_Origin", 103);
      paramView.putExtra("BUSINESS_ORIGIN_NEW", 103);
      paramView.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      paramView.putExtra("fromWhereClick", 11);
      PhotoUtils.a(paramView, this.this$0.getActivity(), PublicFragmentActivityForOpenSDK.class.getName(), paramInt, paramInt, 1080, 1080, aqep.BR());
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.this$0.getActivity().checkSelfPermission("android.permission.CAMERA") != 0)
        {
          paramInt = 1;
          if (paramInt != 0) {
            this.this$0.getActivity().requestPermissions(new arqm(this), 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else
        {
          paramInt = 0;
          continue;
        }
        this.this$0.x = ProfileActivity.a(this.this$0.getActivity(), 257);
      }
      else
      {
        this.this$0.x = ProfileActivity.a(this.this$0.getActivity(), 257);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arql
 * JD-Core Version:    0.7.0.1
 */