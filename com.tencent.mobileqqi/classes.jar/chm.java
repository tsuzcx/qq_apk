import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyGridView;
import java.util.List;

public class chm
  extends Handler
{
  public chm(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a) == 3000)) {
        DiscussionInfoCardActivity.a(this.a).setRightText(DiscussionInfoCardActivity.b(this.a));
      }
    } while (DiscussionInfoCardActivity.a(this.a) == null);
    int i = DiscussionInfoCardActivity.a(this.a).size();
    if (i + 1 > DiscussionInfoCardActivity.b(this.a) * 3)
    {
      DiscussionInfoCardActivity.b(this.a).setRightText(this.a.getString(2131559045, new Object[] { Integer.valueOf(i) }));
      DiscussionInfoCardActivity.b(this.a).setOnClickListener(new chn(this));
      DiscussionInfoCardActivity.a(this.a).setPadding(DiscussionInfoCardActivity.c(this.a), DiscussionInfoCardActivity.d(this.a), DiscussionInfoCardActivity.e(this.a), DiscussionInfoCardActivity.f(this.a));
      if (DiscussionInfoCardActivity.a(this.a) != null) {
        break label266;
      }
      DiscussionInfoCardActivity.a(this.a, new chs(this.a));
      DiscussionInfoCardActivity.a(this.a).setAdapter(DiscussionInfoCardActivity.a(this.a));
    }
    for (;;)
    {
      removeMessages(0);
      return;
      if (DiscussionInfoCardActivity.b(this.a) == null) {
        break;
      }
      DiscussionInfoCardActivity.b(this.a).setVisibility(8);
      break;
      label266:
      DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chm
 * JD-Core Version:    0.7.0.1
 */