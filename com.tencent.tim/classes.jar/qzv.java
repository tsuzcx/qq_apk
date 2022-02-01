import android.view.View;
import java.util.ArrayList;

class qzv
  extends qwo
{
  qzv(qzh paramqzh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    boolean bool;
    switch (paramView.getId())
    {
    default: 
      if (qzh.a(this.this$0).bu().size() <= 0) {
        break label149;
      }
      paramView = this.this$0;
      if (!qzh.a(this.this$0))
      {
        bool = true;
        qzh.a(paramView, bool);
        qzh.a(this.this$0);
        if (!qzh.a(this.this$0)) {
          break label143;
        }
      }
      break;
    }
    label143:
    for (paramView = "1";; paramView = "2")
    {
      rar.a("mystory", "clk_fold", 0, 0, new String[] { paramView, "2" });
      rar.a("home_page", "exp_share_day", 0, 0, new String[0]);
      return;
      qzh.a(this.this$0, qzh.a(this.this$0), paramView);
      return;
      bool = false;
      break;
    }
    label149:
    qzh.a(this.this$0, qzh.a(this.this$0), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzv
 * JD-Core Version:    0.7.0.1
 */