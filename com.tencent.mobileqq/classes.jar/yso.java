import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class yso
  extends yop
{
  yso(ysm paramysm) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if ((paramView == paramyqw.a(2131374633)) || (paramView == paramyqw.a(2131374634)) || (paramView == paramyqw.a(2131374637))) {
      if (ysm.a(this.a)) {
        yuk.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramyqw.a(2131374632))
    {
      return;
      ysm.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (ysm.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        zmq.a().a((Activity)ysm.a(this.a), paramObject, 20000);
        yup.a("home_page", "clk_smartalbum", 0, 0, new String[] { ysm.a(this.a, ysm.a(this.a)) });
        return;
        if (ysm.a(this.a) == 2)
        {
          if (ysm.a(this.a) != null) {}
          for (paramView = String.valueOf(ysm.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (ysm.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    yup.a("home_page", "close_smartalbum", 0, 0, new String[] { ysm.a(this.a, ysm.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yso
 * JD-Core Version:    0.7.0.1
 */