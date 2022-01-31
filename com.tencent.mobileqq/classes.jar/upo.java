import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class upo
  extends ulp
{
  upo(upm paramupm) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if ((paramView == paramunw.a(2131307579)) || (paramView == paramunw.a(2131307580)) || (paramView == paramunw.a(2131307583))) {
      if (upm.a(this.a)) {
        urk.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramunw.a(2131307578))
    {
      return;
      upm.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (upm.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        vjq.a().a((Activity)upm.a(this.a), paramObject, 20000);
        urp.a("home_page", "clk_smartalbum", 0, 0, new String[] { upm.a(this.a, upm.a(this.a)) });
        return;
        if (upm.a(this.a) == 2)
        {
          if (upm.a(this.a) != null) {}
          for (paramView = String.valueOf(upm.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (upm.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    urp.a("home_page", "close_smartalbum", 0, 0, new String[] { upm.a(this.a, upm.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upo
 * JD-Core Version:    0.7.0.1
 */