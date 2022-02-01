import android.content.Intent;
import android.os.Message;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity.a;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.widget.MyGridView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class uuz
  extends MqqHandler
{
  public uuz(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label424:
    do
    {
      do
      {
        do
        {
          return;
          if ((DiscussionInfoCardActivity.a(this.this$0) != null) && (DiscussionInfoCardActivity.a(this.this$0).isShowing())) {
            DiscussionInfoCardActivity.a(this.this$0).dismiss();
          }
          paramMessage = new Intent();
          paramMessage.putExtra("isNeedFinish", true);
          this.this$0.setResult(-1, paramMessage);
          this.this$0.finish();
          return;
        } while ((DiscussionInfoCardActivity.a(this.this$0) == null) || (!DiscussionInfoCardActivity.a(this.this$0).isShowing()) || (this.this$0.isFinishing()));
        DiscussionInfoCardActivity.a(this.this$0).dismiss();
        return;
        if (DiscussionInfoCardActivity.a(this.this$0) == 3000)
        {
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
            DiscussionInfoCardActivity.a(this.this$0, DiscussionInfoCardActivity.b(this.this$0));
          }
        }
        else
        {
          paramMessage = (ArrayList)paramMessage.obj;
          int i = paramMessage.size();
          DiscussionInfoCardActivity.a(this.this$0).setText(acfp.m(2131705137) + i + acfp.m(2131705138));
          DiscussionInfoCardActivity.a(this.this$0).setPadding(DiscussionInfoCardActivity.b(this.this$0), DiscussionInfoCardActivity.c(this.this$0), DiscussionInfoCardActivity.d(this.this$0), DiscussionInfoCardActivity.e(this.this$0));
          DiscussionInfoCardActivity.a(this.this$0, paramMessage);
          if (DiscussionInfoCardActivity.a(this.this$0) != null) {
            break label424;
          }
          DiscussionInfoCardActivity.a(this.this$0, new DiscussionInfoCardActivity.a(this.this$0));
          DiscussionInfoCardActivity.a(this.this$0).setAdapter(DiscussionInfoCardActivity.a(this.this$0));
        }
        for (;;)
        {
          removeMessages(0);
          return;
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setText(this.this$0.getString(2131696112));
          if (!AppSetting.enableTalkBack) {
            break;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView.setContentDescription(acfp.m(2131705143) + this.this$0.getString(2131696112) + acfp.m(2131705135));
          break;
          DiscussionInfoCardActivity.a(this.this$0).notifyDataSetChanged();
        }
      } while (DiscussionInfoCardActivity.a(this.this$0) != 0);
      paramMessage = (String)paramMessage.obj;
    } while ((DiscussionInfoCardActivity.a(this.this$0) == null) || (paramMessage == null) || (!DiscussionInfoCardActivity.a(this.this$0).equals(paramMessage)));
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuz
 * JD-Core Version:    0.7.0.1
 */