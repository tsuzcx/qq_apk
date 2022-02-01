import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class xtz
  extends xqa
{
  xtz(xtx paramxtx) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if ((paramView == paramxsh.a(2131374401)) || (paramView == paramxsh.a(2131374402)) || (paramView == paramxsh.a(2131374405))) {
      if (xtx.a(this.a)) {
        xvv.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramxsh.a(2131374400))
    {
      return;
      xtx.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (xtx.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        ynm.a().a((Activity)xtx.a(this.a), paramObject, 20000);
        xwa.a("home_page", "clk_smartalbum", 0, 0, new String[] { xtx.a(this.a, xtx.a(this.a)) });
        return;
        if (xtx.a(this.a) == 2)
        {
          if (xtx.a(this.a) != null) {}
          for (paramView = String.valueOf(xtx.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (xtx.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    xwa.a("home_page", "close_smartalbum", 0, 0, new String[] { xtx.a(this.a, xtx.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtz
 * JD-Core Version:    0.7.0.1
 */