import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class aiht
  implements arle
{
  private long iu;
  
  aiht(aihr paramaihr, Context paramContext) {}
  
  public boolean MM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (aihr.a(this.b) == null) {
      return true;
    }
    if (aihr.a(this.b).isIsAdm())
    {
      aihl.i(this.val$context, 5, aihr.a(this.b).getCurUin());
      return true;
    }
    anot.a(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, aihr.a(this.b).getCurUin(), "", "", "");
    this.b.dst();
    return true;
  }
  
  public boolean ap(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((aihr.a(this.b) == null) || (aihr.a(this.b) == null)) {
      return false;
    }
    if (System.currentTimeMillis() - this.iu < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.iu));
      }
      return true;
    }
    this.iu = System.currentTimeMillis();
    paramInt1 = aihr.a(this.b).FC();
    if (paramInt1 == 1)
    {
      aoij.a(this.val$context, 1, aihr.a(this.b).getBigUrl(), null, new Bundle(), aihr.a(this.b).getCurType());
      this.b.p(aihr.a(this.b).getCurUin(), aihr.a(this.b).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        aihr.a(this.b).Le(aihr.a(this.b).getSmallUrl());
        anot.a(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, aihr.a(this.b).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiht
 * JD-Core Version:    0.7.0.1
 */