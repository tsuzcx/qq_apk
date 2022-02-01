import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.RainView;
import com.tencent.biz.pubaccount.readinjoy.view.RainView.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kgp
{
  private boolean Zm = true;
  private RainView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView;
  private kgp.b jdField_a_of_type_Kgp$b;
  private Context mContext;
  private ViewGroup mRootView;
  
  public kgp(ViewGroup paramViewGroup, Context paramContext)
  {
    this.mRootView = paramViewGroup;
    this.mContext = paramContext;
    this.jdField_a_of_type_Kgp$b = new kgp.b(this);
  }
  
  public void destroy()
  {
    this.Zm = false;
  }
  
  public void hide()
  {
    if ((isShow()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRainAnimationController", 2, "rain animation hide");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.dTU();
      this.mRootView.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView);
    }
  }
  
  public boolean isShow()
  {
    return this.mRootView.findViewWithTag("ReadInJoyRainAnimationController") != null;
  }
  
  public boolean isValidate()
  {
    return this.Zm;
  }
  
  public void show(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRainAnimationController", 2, "rain animation show");
    }
    if (this.mRootView.findViewWithTag("ReadInJoyRainAnimationController") == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView = new RainView(this.mContext);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      this.mRootView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView, localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.setTag("ReadInJoyRainAnimationController");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.setAnimationEndListener(new kgp.a(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.k(this.mRootView.getWidth(), this.mRootView.getTop(), this.mRootView.getBottom(), paramString);
  }
  
  static class a
    implements RainView.a
  {
    private WeakReference<kgp> C;
    
    public a(kgp paramkgp)
    {
      this.C = new WeakReference(paramkgp);
    }
    
    public void onAnimationEnd()
    {
      kgp localkgp = (kgp)this.C.get();
      if ((localkgp == null) || (!localkgp.isValidate())) {
        return;
      }
      kgp.a(localkgp).sendEmptyMessage(1);
    }
  }
  
  static class b
    extends Handler
  {
    private WeakReference<kgp> C;
    
    public b(kgp paramkgp)
    {
      this.C = new WeakReference(paramkgp);
    }
    
    public void handleMessage(Message paramMessage)
    {
      kgp localkgp = (kgp)this.C.get();
      if ((localkgp == null) || (!localkgp.isValidate())) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      localkgp.hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgp
 * JD-Core Version:    0.7.0.1
 */