import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;

public class ldr
  implements ViewTreeObserver.OnPreDrawListener
{
  public ldr(ReadInJoyChannelPanelFragment.a parama, ReadInJoyStaticGridView paramReadInJoyStaticGridView) {}
  
  public boolean onPreDraw()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getChildAt(0);
    Object localObject2 = new int[2];
    ((View)localObject1).getLocationOnScreen((int[])localObject2);
    localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a.this$0.a(ReadInJoyChannelPanelFragment.a.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment$a), (int[])localObject2);
    ReadInJoyChannelPanelFragment.a(localObject2[0], 0.0F, localObject2[1], 0.0F, (View)localObject1);
    localObject1 = (ViewTreeObserver.OnPreDrawListener)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getTag(2131376702);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)localObject1);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.setTag(2131376702, null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldr
 * JD-Core Version:    0.7.0.1
 */