import android.view.View;
import java.util.ArrayList;

class wrv
  extends wna
{
  wrv(wrh paramwrh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    boolean bool;
    switch (paramView.getId())
    {
    default: 
      if (wrh.a(this.a).a().size() <= 0) {
        break label149;
      }
      paramView = this.a;
      if (!wrh.a(this.a))
      {
        bool = true;
        wrh.a(paramView, bool);
        wrh.a(this.a);
        if (!wrh.a(this.a)) {
          break label143;
        }
      }
      break;
    }
    label143:
    for (paramView = "1";; paramView = "2")
    {
      wta.a("mystory", "clk_fold", 0, 0, new String[] { paramView, "2" });
      wta.a("home_page", "exp_share_day", 0, 0, new String[0]);
      return;
      wrh.a(this.a, wrh.a(this.a), paramView);
      return;
      bool = false;
      break;
    }
    label149:
    wrh.a(this.a, wrh.a(this.a), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrv
 * JD-Core Version:    0.7.0.1
 */