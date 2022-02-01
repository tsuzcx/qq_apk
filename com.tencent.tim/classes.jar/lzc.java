import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class lzc<T extends View>
  extends lwm
{
  private Class<T> m;
  
  lzc(Context paramContext, aqdf paramaqdf, ndi paramndi, Class<T> paramClass)
  {
    super(paramContext, paramaqdf, paramndi);
    this.m = paramClass;
  }
  
  public lwm a()
  {
    this.alM = true;
    return g().l().n();
  }
  
  public lwm d()
    throws Exception
  {
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Lwl != null) && (this.jdField_a_of_type_Lwl.getClass().equals(this.m))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Lwl);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public lwm e()
    throws Exception
  {
    return this;
  }
  
  public lwm g()
  {
    try
    {
      this.jdField_a_of_type_Lwl = ((lwl)this.m.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.context }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public lwm o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lzc
 * JD-Core Version:    0.7.0.1
 */