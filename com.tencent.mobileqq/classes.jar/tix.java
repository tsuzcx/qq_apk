import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

class tix
  extends tiq
{
  public tix(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561302);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    veg.a("Q.qqstory.msgTab.WeiShiRecommendNodeViewHolder", "bindData %s", paramtfi);
    a(vzl.b(paramtfi.g));
    this.a.setNodeName(paramtfi.c, 2130845744);
  }
  
  protected void b(tfi paramtfi)
  {
    this.a.setDisplayState(6);
    this.a.a(paramtfi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tix
 * JD-Core Version:    0.7.0.1
 */