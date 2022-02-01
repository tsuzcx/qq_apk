import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.a;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.a;

public class kio
  implements BaseTabbar.a
{
  public kio(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      odv.qx(false);
    }
    if (paramInt2 == 1) {
      this.this$0.getIntent().putExtra("channel_from", 7);
    }
    if ((paramInt1 == paramInt2) && (paramInt2 == 0) && ((this.this$0.a() instanceof ReadInJoySubChannelFragment)))
    {
      this.this$0.a().aIq();
      return;
    }
    this.this$0.a(paramInt2, 256, null, true);
  }
  
  public void pc(int paramInt)
  {
    if ((ReadInJoyNewFeedsActivity.a(this.this$0).a(paramInt) != null) && (ReadInJoyNewFeedsActivity.a(this.this$0).a(paramInt).c() != null)) {
      ReadInJoyNewFeedsActivity.a(this.this$0).a(paramInt).c().aKD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kio
 * JD-Core Version:    0.7.0.1
 */