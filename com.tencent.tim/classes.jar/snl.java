import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.widget.QQToast;

public class snl
  extends apsy
{
  public snl(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void aU(int paramInt, String paramString)
  {
    super.aU(paramInt, paramString);
    QQToast.a(this.this$0.mContext, acfp.m(2131715748), 0).show(this.this$0.getResources().getDimensionPixelSize(2131299627));
    TroopGiftPanel.p(true);
  }
  
  public void onError(int paramInt, String paramString)
  {
    super.onError(paramInt, paramString);
    QQToast.a(this.this$0.mContext, acfp.m(2131715781), 0).show(this.this$0.getResources().getDimensionPixelSize(2131299627));
    TroopGiftPanel.p(true);
  }
  
  public void yH(int paramInt)
  {
    super.yH(paramInt);
    this.this$0.cG.setText(TroopGiftPanel.a(this.this$0));
    TroopGiftPanel.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snl
 * JD-Core Version:    0.7.0.1
 */