import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.widget.AbsListView.LayoutParams;

public class lyw
  extends lwm
{
  public lyw(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  public lwm a()
  {
    this.alM = true;
    return g();
  }
  
  public lwm d()
    throws Exception
  {
    if (!this.alM) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.a;
    Pair localPair;
    if ((this.aN != null) && ((this.aN instanceof lis)))
    {
      localPair = kwz.a(((lis)this.aN).getTotal(), ((lis)this.aN).nh());
      if (!kxm.B(((lis)this.aN).a())) {
        break label105;
      }
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    }
    for (;;)
    {
      a(localComponentContentVerticalSmallVideo);
      return this;
      label105:
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue()));
    }
  }
  
  public lwm e()
    throws Exception
  {
    return null;
  }
  
  public lwm g()
  {
    this.a = new ComponentContentVerticalSmallVideo(this.context);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lyw
 * JD-Core Version:    0.7.0.1
 */