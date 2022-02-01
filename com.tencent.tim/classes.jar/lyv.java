import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.widget.AbsListView.LayoutParams;

public class lyv
  extends lwm
{
  public lyv(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  public lwm a()
  {
    this.alM = true;
    return g().h();
  }
  
  public lwm d()
    throws Exception
  {
    if (!this.alM) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(wja.dp2px(220.0F, this.context.getResources()), -2));
    if ((this.jdField_a_of_type_Lwl != null) && ((this.jdField_a_of_type_Lwl instanceof ComponentContentBig))) {
      localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_Lwl);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
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
    this.jdField_a_of_type_Lwl = new ComponentContentBig(this.context);
    return this;
  }
  
  public lwm o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lyv
 * JD-Core Version:    0.7.0.1
 */