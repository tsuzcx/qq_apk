import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class zdm
  implements View.OnClickListener
{
  zdm(zdf paramzdf, int paramInt, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (!zdf.a(this.this$0))
    {
      if (this.cdb != 1) {
        break label48;
      }
      SDKSetEmotionPreviewFragment.a((String)this.val$list.get(0), zdf.a(this.this$0), null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("path_list", this.val$list);
      PublicFragmentActivity.start(zdf.a(this.this$0), localIntent, SDKSetEmotionPreviewFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdm
 * JD-Core Version:    0.7.0.1
 */