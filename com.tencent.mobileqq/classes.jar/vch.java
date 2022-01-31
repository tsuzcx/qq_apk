import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class vch
  extends uyi
{
  vch(vcf paramvcf) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if ((paramView == paramvap.a(2131373294)) || (paramView == paramvap.a(2131373295)) || (paramView == paramvap.a(2131373298))) {
      if (vcf.a(this.a)) {
        ved.d("Q.qqstory.home.LocalVideoPushSegment", "now is opening the new page, so ignore the click");
      }
    }
    while (paramView != paramvap.a(2131373293))
    {
      return;
      vcf.a(this.a, true);
      paramObject = new Bundle();
      paramObject.putInt("capture_intent_mode", 3);
      if (vcf.a(this.a) == 1) {
        paramObject.putString("story_capture_album_id", "default_id");
      }
      for (;;)
      {
        vwj.a().a((Activity)vcf.a(this.a), paramObject, 20000);
        vei.a("home_page", "clk_smartalbum", 0, 0, new String[] { vcf.a(this.a, vcf.a(this.a)) });
        return;
        if (vcf.a(this.a) == 2)
        {
          if (vcf.a(this.a) != null) {}
          for (paramView = String.valueOf(vcf.a(this.a).a());; paramView = "default_id")
          {
            paramObject.putString("story_capture_album_id", paramView);
            break;
          }
        }
        if (vcf.a(this.a) != 3) {}
      }
    }
    this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    this.a.a(null, 4);
    vei.a("home_page", "close_smartalbum", 0, 0, new String[] { vcf.a(this.a, vcf.a(this.a)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vch
 * JD-Core Version:    0.7.0.1
 */