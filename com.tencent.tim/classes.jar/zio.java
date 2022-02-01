import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zio
  implements View.OnClickListener
{
  public zio(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.bbp) && (!ChatHistoryTroopMemberFragment.a(this.this$0))) {
      if (((this.this$0.mFrom == 11) && (this.this$0.bLG > 0)) || (this.this$0.mFrom == 3))
      {
        Intent localIntent = this.this$0.getActivity().getIntent();
        localIntent.putExtra("member_uin", "0");
        localIntent.putExtra("member_display_name", this.val$name);
        this.this$0.getActivity().setResult(-1, localIntent);
        this.this$0.getActivity().finish();
        if (this.this$0.mFrom == 11) {
          anot.a(this.this$0.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.this$0.getActivity(), acfp.m(2131703682), 0).show(this.this$0.mTitleBar.getHeight());
      continue;
      if (!TextUtils.isEmpty(this.this$0.aQL)) {
        QQToast.a(this.this$0.getActivity(), this.this$0.aQL, 0).show(this.this$0.mTitleBar.getHeight());
      } else {
        QQToast.a(this.this$0.getActivity(), acfp.m(2131703620), 0).show(this.this$0.mTitleBar.getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zio
 * JD-Core Version:    0.7.0.1
 */