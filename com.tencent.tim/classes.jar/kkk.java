import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;

public abstract class kkk
  implements View.OnClickListener
{
  public AdData a;
  public kjt a;
  protected kkb a;
  private AdvertisementInfo advertisementInfo;
  public boolean afW;
  public boolean afX;
  protected Context context;
  protected ViewGroup rootView;
  public int type;
  
  public kkk(Context paramContext, int paramInt)
  {
    this.type = paramInt;
    this.context = paramContext;
    this.rootView = new FrameLayout(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(nn(), this.rootView);
    aDR();
    Nx();
  }
  
  public abstract void Nx();
  
  public void a(AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    this.advertisementInfo = kne.a(paramAdData);
  }
  
  public void a(kjt paramkjt)
  {
    this.jdField_a_of_type_Kjt = paramkjt;
  }
  
  public void a(kkb paramkkb)
  {
    this.jdField_a_of_type_Kkb = paramkkb;
  }
  
  public abstract void aDR();
  
  public void aDT() {}
  
  public void aaV()
  {
    this.afX = true;
  }
  
  public View ah()
  {
    return this.rootView;
  }
  
  public void b(View... paramVarArgs)
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
  
  public abstract void close();
  
  public abstract int nn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkk
 * JD-Core Version:    0.7.0.1
 */