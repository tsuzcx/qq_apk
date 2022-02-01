import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import java.util.List;

public class ajup
  extends Handler
{
  public ajup(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4097: 
      ChooseInterestTagActivity.a(this.this$0).e(ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.c(this.this$0), 30, 0, 0);
      return;
    case 4098: 
      ChooseInterestTagActivity.a(this.this$0).setVisibility(8);
      paramMessage = (List)paramMessage.obj;
      if (paramMessage != null) {
        ChooseInterestTagActivity.a(this.this$0, paramMessage);
      }
      if (ChooseInterestTagActivity.a(this.this$0) == null)
      {
        ChooseInterestTagActivity.a(this.this$0, new ajuv(this.this$0, ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0)));
        ChooseInterestTagActivity.a(this.this$0).setAdapter(ChooseInterestTagActivity.a(this.this$0));
        paramMessage = this.this$0;
        if (ChooseInterestTagActivity.b(this.this$0) == -1) {
          break label219;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ChooseInterestTagActivity.a(paramMessage, false, bool);
        return;
        ChooseInterestTagActivity.a(this.this$0).aw(ChooseInterestTagActivity.a(this.this$0), true);
        break;
      }
    case 4100: 
      label219:
      ChooseInterestTagActivity.a(this.this$0, false);
      return;
    }
    ChooseInterestTagActivity.a(this.this$0, acfp.m(2131703824));
    ChooseInterestTagActivity.a(this.this$0).setText("");
    ChooseInterestTagActivity.a(this.this$0).setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajup
 * JD-Core Version:    0.7.0.1
 */