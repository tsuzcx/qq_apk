import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class pwo
  extends pwp
{
  public pwo(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561902);
  }
  
  private void t(puh parampuh)
  {
    parampuh.firstExp = false;
    puy.a(QQStoryContext.a()).j(parampuh);
    pvh localpvh = new pvh();
    localpvh.unionId = parampuh.unionId;
    localpvh.nodeType = parampuh.nodeType;
    localpvh.operation = 4;
    localpvh.recommendId = parampuh.recommendId;
    ppv.a().a(localpvh, null);
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    if (!TextUtils.isEmpty(parampuh.videoCover)) {
      ru(parampuh.videoCover);
    }
    if (!TextUtils.isEmpty(parampuh.recommandNameIconUrl))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(parampuh.title)) {}
      for (str = acfp.m(2131708520);; str = parampuh.title)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, parampuh.recommandNameIconUrl);
        if (parampuh.firstExp) {
          t(parampuh);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(parampuh.title)) {}
    for (String str = acfp.m(2131708519);; str = parampuh.title)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void s(puh parampuh)
  {
    this.a.setDisplayState(6);
    this.a.n(parampuh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwo
 * JD-Core Version:    0.7.0.1
 */