import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

class wvh
  extends wva
{
  public wvh(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561744);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(wrs paramwrs)
  {
    super.a(paramwrs);
    yqp.a("Q.qqstory.msgTab.WeiShiRecommendNodeViewHolder", "bindData %s", paramwrs);
    a(zlu.b(paramwrs.g));
    this.a.setNodeName(paramwrs.c, 2130846641);
  }
  
  protected void b(wrs paramwrs)
  {
    this.a.setDisplayState(6);
    this.a.a(paramwrs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvh
 * JD-Core Version:    0.7.0.1
 */