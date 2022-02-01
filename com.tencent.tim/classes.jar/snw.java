import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.biz.troopgift.GridListViewPager;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.9.1;
import com.tencent.biz.troopgift.TroopGiftPanel.d;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class snw
  extends apsy
{
  public snw(TroopGiftPanel paramTroopGiftPanel, TroopGiftPanel.d paramd) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<apsz.a> paramList)
  {
    int i = 0;
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, onGetStockResult: count = " + paramInt1 + ", giveCount=" + paramInt2 + ", info=" + paramString + ", giveGifts.size=" + paramList.size());
    this.this$0.byq = (paramInt1 + paramInt2);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      this.this$0.AM.setText(paramInt1 + "");
      if (paramInt2 > 0)
      {
        this.this$0.AN.setText("+" + paramInt2);
        this.this$0.AN.setVisibility(0);
        if (this.a == null) {
          break label269;
        }
        this.a.fj(paramList);
      }
    }
    for (paramInt1 = i;; paramInt1 = i)
    {
      label269:
      try
      {
        while (paramInt1 < TroopGiftPanel.byl)
        {
          if (this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[paramInt1] != null) {
            this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[paramInt1].refreshUI();
          }
          paramInt1 += 1;
        }
        this.this$0.AN.setText("");
        this.this$0.AN.setVisibility(8);
      }
      catch (Exception paramString) {}
      new Handler(Looper.getMainLooper()).post(new TroopGiftPanel.9.1(this, paramInt1, paramInt2));
      break;
      this.this$0.jdField_a_of_type_Snf.fh(paramList);
    }
    try
    {
      if (this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.byl] != null) {
        this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.byl].refreshUI();
      }
      try
      {
        label316:
        if (this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.bym] != null) {
          this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.bym].refreshUI();
        }
        return;
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      break label316;
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    QLog.d("TroopGiftPanel", 1, "getGiftStorage, onError: errorCode = " + paramInt + ", errorMsg = " + paramString);
    if (this.a != null) {
      this.a.onError(paramInt);
    }
    anot.a(null, "dc00899", "Grp_flower", "", "video_mall", "fail_expbean", 0, 0, this.this$0.nD(), "", this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snw
 * JD-Core Version:    0.7.0.1
 */