import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class yot
  extends yku
{
  yot(yor paramyor) {}
  
  public void a(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if ((paramView == paramynb.a(2131374496)) || (paramView == paramynb.a(2131374497)) || (paramView == paramynb.a(2131374500))) {
      if (yor.a(this.a)) {
        yqp.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramynb.a(2131374495))
    {
      return;
      yor.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (yor.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        ziv.a().a((Activity)yor.a(this.a), paramObject, 20000);
        yqu.a("home_page", "clk_smartalbum", 0, 0, new String[] { yor.a(this.a, yor.a(this.a)) });
        return;
        if (yor.a(this.a) == 2)
        {
          if (yor.a(this.a) != null) {}
          for (paramView = String.valueOf(yor.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (yor.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    yqu.a("home_page", "close_smartalbum", 0, 0, new String[] { yor.a(this.a, yor.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yot
 * JD-Core Version:    0.7.0.1
 */