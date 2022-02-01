import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class yiu
  extends yev
{
  yiu(yis paramyis) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramView == paramyhc.a(2131374639)) || (paramView == paramyhc.a(2131374640)) || (paramView == paramyhc.a(2131374643))) {
      if (yis.a(this.a)) {
        ykq.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramyhc.a(2131374638))
    {
      return;
      yis.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (yis.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        zcf.a().a((Activity)yis.a(this.a), paramObject, 20000);
        ykv.a("home_page", "clk_smartalbum", 0, 0, new String[] { yis.a(this.a, yis.a(this.a)) });
        return;
        if (yis.a(this.a) == 2)
        {
          if (yis.a(this.a) != null) {}
          for (paramView = String.valueOf(yis.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (yis.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    ykv.a("home_page", "close_smartalbum", 0, 0, new String[] { yis.a(this.a, yis.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiu
 * JD-Core Version:    0.7.0.1
 */