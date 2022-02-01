import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.c;
import com.tencent.widget.immersive.ImmersiveUtils;

public class lew
  implements BounceScrollView.c
{
  public lew(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = ReadInJoySelfFragment.a(this.this$0).getScrollY();
    if ((this.this$0.getActivity() != null) && ((this.this$0.getActivity() instanceof ReadInJoyNewFeedsActivity))) {}
    do
    {
      return;
      if (paramInt1 >= ReadInJoySelfFragment.a(this.this$0))
      {
        ReadInJoySelfFragment.a(this.this$0).setBackgroundColor(Color.parseColor("#FFFFFF"));
        if (paramInt1 >= ReadInJoySelfFragment.a(this.this$0) * 3) {}
        for (float f = 1.0F;; f = paramInt1 * 0.33F / ReadInJoySelfFragment.a(this.this$0))
        {
          ReadInJoySelfFragment.a(this.this$0).setAlpha(f);
          ReadInJoySelfFragment.a(this.this$0).setBackgroundResource(2130843809);
          ReadInJoySelfFragment.a(this.this$0).setVisibility(0);
          if ((this.this$0.getActivity() == null) || (!(this.this$0.getActivity() instanceof ReadInJoySelfActivity))) {
            break;
          }
          ImmersiveUtils.setStatusTextColor(true, this.this$0.getActivity().getWindow());
          return;
        }
      }
      ReadInJoySelfFragment.a(this.this$0).setBackgroundColor(Color.parseColor("#00FFFFFF"));
      ReadInJoySelfFragment.a(this.this$0).setBackgroundResource(2130843810);
      ReadInJoySelfFragment.a(this.this$0).setVisibility(8);
    } while ((this.this$0.getActivity() == null) || (!(this.this$0.getActivity() instanceof ReadInJoySelfActivity)));
    ImmersiveUtils.setStatusTextColor(false, this.this$0.getActivity().getWindow());
  }
  
  public void w(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lew
 * JD-Core Version:    0.7.0.1
 */