import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.Iterator;
import java.util.List;

public class gxc
  extends BizTroopObserver
{
  public gxc(VideoPlayLogic paramVideoPlayLogic) {}
  
  protected void a(String paramString, List paramList, int paramInt)
  {
    VideoPlayLogic.a(this.a, paramInt);
    if (paramString.compareToIgnoreCase(VideoPlayLogic.a(this.a)) != 0) {}
    do
    {
      return;
      if ((paramString.compareToIgnoreCase(VideoPlayLogic.a(this.a)) != 0) || (paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      VideoPlayLogic.a(this.a).clear();
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        if (!TextUtils.isEmpty(paramList)) {
          VideoPlayLogic.a(this.a).add(paramList);
        }
      }
      if (VideoPlayLogic.a(this.a).size() <= 0)
      {
        if ((VideoPlayLogic.a(this.a) != null) && (VideoPlayLogic.a(this.a).isShowing() == true)) {
          VideoPlayLogic.a(this.a).dismiss();
        }
        if (VideoPlayLogic.a(this.a))
        {
          new StructMsgForGeneralShare.GeneralClickHandler(VideoPlayLogic.a(this.a), VideoPlayLogic.a(this.a), VideoPlayLogic.a(this.a)).a(VideoPlayLogic.a(this.a));
          return;
        }
        this.a.a(VideoPlayLogic.a(this.a));
        return;
      }
      VideoPlayLogic.b(this.a, 0);
    } while ((VideoPlayLogic.a(this.a) == null) || (!VideoPlayLogic.a(this.a).isShowing()));
    VideoPlayLogic.a(this.a).dismiss();
    this.a.d();
    if (VideoPlayLogic.a(this.a) == null)
    {
      VideoPlayLogic.a(this.a, new RelativeLayout(VideoPlayLogic.a(this.a)));
      VideoPlayLogic.b(this.a).addView(VideoPlayLogic.a(this.a), -1, 0);
    }
    if (VideoPlayLogic.a(this.a) == null)
    {
      VideoPlayLogic.a(this.a, new VideoViewX(VideoPlayLogic.a(this.a)));
      VideoPlayLogic.a(this.a).addView(VideoPlayLogic.a(this.a), -1, -1);
    }
    if (VideoPlayLogic.a(this.a) == null)
    {
      VideoPlayLogic.a(this.a, new MessageSubtitleView(VideoPlayLogic.a(this.a)));
      paramString = new RelativeLayout.LayoutParams(-1, -2);
      paramString.leftMargin = VideoPlayLogic.a(this.a).getResources().getDimensionPixelSize(2131427578);
      paramString.rightMargin = VideoPlayLogic.a(this.a).getResources().getDimensionPixelSize(2131427579);
      paramString.topMargin = VideoPlayLogic.a(this.a).getResources().getDimensionPixelSize(2131427581);
      paramString.addRule(10);
      VideoPlayLogic.a(this.a).addView(VideoPlayLogic.a(this.a), paramString);
    }
    if (!this.a.c()) {
      VideoPlayLogic.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      VideoPlayLogic.a(this.a, true);
      return;
      VideoPlayLogic.a(this.a).getWindow().addFlags(1024);
    }
    if ((VideoPlayLogic.a(this.a) != null) && (VideoPlayLogic.a(this.a).isShowing() == true)) {
      VideoPlayLogic.a(this.a).dismiss();
    }
    if (VideoPlayLogic.a(this.a))
    {
      new StructMsgForGeneralShare.GeneralClickHandler(VideoPlayLogic.a(this.a), VideoPlayLogic.a(this.a), VideoPlayLogic.a(this.a)).a(VideoPlayLogic.a(this.a));
      return;
    }
    this.a.a(VideoPlayLogic.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxc
 * JD-Core Version:    0.7.0.1
 */