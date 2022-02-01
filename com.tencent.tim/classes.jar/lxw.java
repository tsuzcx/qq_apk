import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.widget.AbsListView.LayoutParams;

public class lxw
  extends lwm
{
  public lxw(Context paramContext, aqdf paramaqdf, ndi paramndi)
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
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(wja.dp2px(150.0F, this.context.getResources()), -2));
    if ((this.a != null) && ((this.a instanceof ComponentContentHotQuestion))) {
      localLinearLayout.addView((ComponentContentHotQuestion)this.a);
    }
    a(localLinearLayout);
    return this;
  }
  
  public lwm e()
    throws Exception
  {
    return null;
  }
  
  public lwm g()
  {
    this.a = new ComponentContentHotQuestion(this.context);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lxw
 * JD-Core Version:    0.7.0.1
 */