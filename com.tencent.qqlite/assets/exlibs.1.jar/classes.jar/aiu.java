import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.List;

public class aiu
  extends Handler
{
  public aiu(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label419:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing())) {
                DiscussionInfoCardActivity.a(this.a).dismiss();
              }
              paramMessage = new Intent();
              paramMessage.putExtra("isNeedFinish", true);
              this.a.setResult(-1, paramMessage);
              this.a.finish();
              return;
            } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
            DiscussionInfoCardActivity.a(this.a).dismiss();
            return;
            if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a) == 3000)) {
              DiscussionInfoCardActivity.a(this.a).setText(DiscussionInfoCardActivity.b(this.a));
            }
          } while (DiscussionInfoCardActivity.a(this.a) == null);
          int i = DiscussionInfoCardActivity.a(this.a).size();
          if (i + 1 > DiscussionInfoCardActivity.b(this.a) * 3)
          {
            DiscussionInfoCardActivity.a(this.a).setRightText(i + "人");
            DiscussionInfoCardActivity.a(this.a).setOnClickListener(new aiv(this));
            DiscussionInfoCardActivity.a(this.a).setPadding(DiscussionInfoCardActivity.c(this.a), DiscussionInfoCardActivity.d(this.a), DiscussionInfoCardActivity.e(this.a), DiscussionInfoCardActivity.f(this.a));
            if (DiscussionInfoCardActivity.a(this.a) != null) {
              break label419;
            }
            DiscussionInfoCardActivity.a(this.a, new aje(this.a));
            DiscussionInfoCardActivity.a(this.a).setAdapter(DiscussionInfoCardActivity.a(this.a));
          }
          for (;;)
          {
            removeMessages(0);
            return;
            if (DiscussionInfoCardActivity.a(this.a) == null) {
              break;
            }
            DiscussionInfoCardActivity.a(this.a).setVisibility(8);
            DiscussionInfoCardActivity.a(this.a).setVisibility(8);
            break;
            DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
          }
        } while (DiscussionInfoCardActivity.a(this.a) != 0);
        paramMessage = (String)paramMessage.obj;
      } while ((DiscussionInfoCardActivity.a(this.a) == null) || (paramMessage == null) || (!DiscussionInfoCardActivity.a(this.a).equals(paramMessage)));
      this.a.finish();
      return;
    } while (paramMessage.obj == null);
    paramMessage = (List)paramMessage.obj;
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aiu
 * JD-Core Version:    0.7.0.1
 */