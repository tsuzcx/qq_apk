import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class acaj
  implements abhs.a
{
  public acaj(ApolloPanel paramApolloPanel) {}
  
  public void p(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.this$0.Qr.setText(String.valueOf(paramInt));
    if (this.this$0.jz.getVisibility() == 0)
    {
      if ((!paramBoolean2) || (paramInt >= 5)) {
        break label110;
      }
      this.this$0.im.setVisibility(8);
      if (!paramBoolean1) {
        break label94;
      }
      this.this$0.Qq.setVisibility(0);
      ThreadManager.getUIHandler().removeCallbacks(ApolloPanel.a(this.this$0));
    }
    label94:
    label110:
    do
    {
      ThreadManager.getUIHandler().postDelayed(ApolloPanel.a(this.this$0), 5000L);
      do
      {
        return;
      } while (paramInt <= 0);
      this.this$0.im.setVisibility(0);
      return;
      this.this$0.im.setVisibility(0);
    } while ((paramInt != 0) || (!paramBoolean1));
    this.this$0.Qq.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acaj
 * JD-Core Version:    0.7.0.1
 */