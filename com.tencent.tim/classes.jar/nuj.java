import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.b;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;

class nuj
  implements CommonSuspensionGestureLayout.b
{
  nuj(nui paramnui, FrameLayout paramFrameLayout) {}
  
  public void W(boolean paramBoolean, int paramInt) {}
  
  public void aZl() {}
  
  public void aZm()
  {
    if (this.W.getVisibility() != 0) {
      this.W.setVisibility(0);
    }
  }
  
  public void aZn() {}
  
  public void h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      nui.a(this.this$0).getActivity().sendBroadcast(localIntent);
    }
    nui.a(this.this$0).getActivity().doOnBackPressed();
    nui.a(this.this$0).getActivity().overridePendingTransition(0, 0);
  }
  
  public void mT(int paramInt)
  {
    if (nui.a(this.this$0) != null) {
      nui.a(this.this$0).mT(paramInt);
    }
  }
  
  public void tM(int paramInt)
  {
    if ((paramInt == 2) && (nui.a(this.this$0).isCreated()) && (this.W.getVisibility() != 8)) {
      this.W.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nuj
 * JD-Core Version:    0.7.0.1
 */