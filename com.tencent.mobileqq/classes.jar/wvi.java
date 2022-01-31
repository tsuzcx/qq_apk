import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class wvi
  extends wrj
{
  wvi(wvg paramwvg) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if ((paramView == paramwtq.a(2131373794)) || (paramView == paramwtq.a(2131373795)) || (paramView == paramwtq.a(2131373798))) {
      if (wvg.a(this.a)) {
        wxe.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramwtq.a(2131373793))
    {
      return;
      wvg.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (wvg.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        xpk.a().a((Activity)wvg.a(this.a), paramObject, 20000);
        wxj.a("home_page", "clk_smartalbum", 0, 0, new String[] { wvg.a(this.a, wvg.a(this.a)) });
        return;
        if (wvg.a(this.a) == 2)
        {
          if (wvg.a(this.a) != null) {}
          for (paramView = String.valueOf(wvg.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (wvg.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    wxj.a("home_page", "close_smartalbum", 0, 0, new String[] { wvg.a(this.a, wvg.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvi
 * JD-Core Version:    0.7.0.1
 */