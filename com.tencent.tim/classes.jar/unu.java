import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.widget.TabBarView.a;

public class unu
  implements TabBarView.a
{
  public unu(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    uou localuou = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.this$0.a != null)
      {
        this.this$0.a.bJX();
        this.this$0.mRoot.removeView(this.this$0.a.aI());
      }
      if (localuou == null) {
        break;
      }
      localuou.At(ChatHistoryFileActivity.a(this.this$0));
      localuou.bJW();
      this.this$0.a = localuou;
      this.this$0.a.a = this.this$0;
      this.this$0.mRoot.addView(this.this$0.a.aI(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.this$0.aTX) {
        break label326;
      }
      this.this$0.a.bJY();
      return;
      localuou = ChatHistoryFileActivity.a(this.this$0, 0);
      continue;
      localuou = ChatHistoryFileActivity.a(this.this$0, 4);
      continue;
      localuou = ChatHistoryFileActivity.a(this.this$0, 1);
      anot.a(this.this$0.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localuou = ChatHistoryFileActivity.a(this.this$0, 2);
      anot.a(this.this$0.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localuou = ChatHistoryFileActivity.a(this.this$0, 3);
      anot.a(this.this$0.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.this$0.a.bJZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unu
 * JD-Core Version:    0.7.0.1
 */