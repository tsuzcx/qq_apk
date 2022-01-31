import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

class uxm
  extends uxf
{
  public uxm(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561491);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(utx paramutx)
  {
    super.a(paramutx);
    wsv.a("Q.qqstory.msgTab.WeiShiRecommendNodeViewHolder", "bindData %s", paramutx);
    a(xoa.b(paramutx.g));
    this.a.setNodeName(paramutx.c, 2130846129);
  }
  
  protected void b(utx paramutx)
  {
    this.a.setDisplayState(6);
    this.a.a(paramutx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxm
 * JD-Core Version:    0.7.0.1
 */