import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;

public abstract class tln
  implements View.OnClickListener
{
  public int a;
  protected Context a;
  protected ViewGroup a;
  public AdvertisementInfo a;
  public AdData a;
  public tkv a;
  protected tle a;
  public boolean a;
  public boolean b;
  
  public tln(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a(), this.jdField_a_of_type_AndroidViewViewGroup);
    a();
    b();
  }
  
  public abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public abstract void a();
  
  public void a(AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = tqb.a(paramAdData);
  }
  
  public void a(tkv paramtkv)
  {
    this.jdField_a_of_type_Tkv = paramtkv;
  }
  
  public void a(tle paramtle)
  {
    this.jdField_a_of_type_Tle = paramtle;
  }
  
  public void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      i += 1;
    }
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public void d()
  {
    this.b = true;
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tln
 * JD-Core Version:    0.7.0.1
 */