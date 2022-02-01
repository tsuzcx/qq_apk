import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class sni
  implements TroopGiftPanel.e
{
  public sni(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(List<apsz.b> paramList, snf.b paramb)
  {
    if (this.this$0.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.this$0.a.fi(paramList);
    this.this$0.a.a(paramb);
    if ((this.this$0.a != null) && (this.this$0.a.on != null) && (this.this$0.a.on.size() > 0) && (this.this$0.a.bh.size() > 0) && (this.this$0.a.byi != -1))
    {
      this.this$0.c = ((sne)this.this$0.a.on.get(this.this$0.a.byi));
      TroopGiftPanel.a(this.this$0, this.this$0.c);
    }
    if (this.this$0.Nb())
    {
      paramList = this.this$0;
      if ((!TextUtils.isEmpty(this.this$0.aFj)) && (TroopGiftPanel.a(this.this$0))) {}
      for (boolean bool = true;; bool = false)
      {
        paramList.setSendGiftBtnEnabled(bool);
        return;
      }
    }
    this.this$0.setSendGiftBtnEnabled(TroopGiftPanel.a(this.this$0));
  }
  
  public void onError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sni
 * JD-Core Version:    0.7.0.1
 */