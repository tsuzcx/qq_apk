import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class wqz
  extends wna
{
  wqz(wqx paramwqx) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if ((paramView == paramwph.a(2131373743)) || (paramView == paramwph.a(2131373744)) || (paramView == paramwph.a(2131373747))) {
      if (wqx.a(this.a)) {
        wsv.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramwph.a(2131373742))
    {
      return;
      wqx.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (wqx.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        xlb.a().a((Activity)wqx.a(this.a), paramObject, 20000);
        wta.a("home_page", "clk_smartalbum", 0, 0, new String[] { wqx.a(this.a, wqx.a(this.a)) });
        return;
        if (wqx.a(this.a) == 2)
        {
          if (wqx.a(this.a) != null) {}
          for (paramView = String.valueOf(wqx.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (wqx.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    wta.a("home_page", "close_smartalbum", 0, 0, new String[] { wqx.a(this.a, wqx.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqz
 * JD-Core Version:    0.7.0.1
 */