import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class pws
  extends pwp
{
  public pws(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561902);
  }
  
  public void bey()
  {
    this.a.setTag(2131375232, null);
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    this.a.setDisplayState(2);
    ru(parampuh.headerUrl);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(parampuh.recommandNameIconUrl))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(parampuh.title))
      {
        str = acfp.m(2131713762);
        localStoryMsgNodeFrameLayout.setNodeName(str, parampuh.recommandNameIconUrl);
        if ((parampuh.iO == null) || (parampuh.iO.isEmpty())) {
          this.a.dR(1, 1 - parampuh.unreadCount);
        }
        str = (String)this.a.getTag(2131375232);
        if (!TextUtils.equals(parampuh.unionId, str)) {
          switch (parampuh.nodeType)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      rar.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { parampuh.unionId, str });
      this.a.setTag(2131375232, parampuh.unionId);
      return;
      str = parampuh.title;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(parampuh.title)) {}
      for (str = acfp.m(2131713766);; str = parampuh.title)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, false);
        break;
      }
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pws
 * JD-Core Version:    0.7.0.1
 */