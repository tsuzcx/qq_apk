import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class vck
  extends uyl
{
  vck(vci paramvci) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if ((paramView == paramvas.a(2131373292)) || (paramView == paramvas.a(2131373293)) || (paramView == paramvas.a(2131373296))) {
      if (vci.a(this.a)) {
        veg.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramvas.a(2131373291))
    {
      return;
      vci.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (vci.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        vwm.a().a((Activity)vci.a(this.a), paramObject, 20000);
        vel.a("home_page", "clk_smartalbum", 0, 0, new String[] { vci.a(this.a, vci.a(this.a)) });
        return;
        if (vci.a(this.a) == 2)
        {
          if (vci.a(this.a) != null) {}
          for (paramView = String.valueOf(vci.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (vci.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    vel.a("home_page", "close_smartalbum", 0, 0, new String[] { vci.a(this.a, vci.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vck
 * JD-Core Version:    0.7.0.1
 */