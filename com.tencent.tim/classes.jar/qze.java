import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class qze
  extends qwo
{
  qze(qzc paramqzc) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if ((paramView == paramqyd.get(2131375176)) || (paramView == paramqyd.get(2131375177)) || (paramView == paramqyd.get(2131375180))) {
      if (qzc.a(this.this$0)) {
        ram.w("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramqyd.get(2131375175))
    {
      return;
      qzc.a(this.this$0, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (qzc.a(this.this$0) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        rnq.a().a((Activity)qzc.a(this.this$0), paramObject, 20000);
        rar.a("home_page", "clk_smartalbum", 0, 0, new String[] { qzc.a(this.this$0, qzc.a(this.this$0)) });
        return;
        if (qzc.a(this.this$0) == 2)
        {
          if (qzc.a(this.this$0) != null) {}
          for (paramView = String.valueOf(qzc.a(this.this$0).getID());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (qzc.a(this.this$0) != 3) {}
      }
    }
    this.this$0.a.n("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.this$0.D(null, 4);
    rar.a("home_page", "close_smartalbum", 0, 0, new String[] { qzc.a(this.this$0, qzc.a(this.this$0)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qze
 * JD-Core Version:    0.7.0.1
 */