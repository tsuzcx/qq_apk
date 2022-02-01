import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.a;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public abstract class npy
  implements ReadInJoyXListView.a
{
  private static final String TAG = npy.class.getSimpleName();
  public son a;
  protected SlideActiveAnimController b;
  protected npy.a b;
  protected npy.b b;
  protected int baU;
  protected Context mContext;
  
  public npy(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void a(npy.b paramb)
  {
    this.jdField_b_of_type_Npy$b = paramb;
  }
  
  public void aCB() {}
  
  public void aZZ() {}
  
  public void ag(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(TAG, 4, "onPullRefreshing percent:" + paramInt + " isTopRefreshing:" + paramBoolean);
    }
  }
  
  public void c(SlideActiveAnimController paramSlideActiveAnimController)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = paramSlideActiveAnimController;
  }
  
  public void dn(int paramInt1, int paramInt2)
  {
    this.baU = paramInt1;
    if (this.jdField_b_of_type_Npy$a != null) {
      this.jdField_b_of_type_Npy$a.cq(paramInt1, paramInt2);
    }
  }
  
  public void onDestroy() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void pY(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Npy$b != null) {
      this.jdField_b_of_type_Npy$b.lQ(paramBoolean);
    }
  }
  
  public void setRefreshPullDistanceListener(npy.a parama)
  {
    this.jdField_b_of_type_Npy$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cq(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void lQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npy
 * JD-Core Version:    0.7.0.1
 */