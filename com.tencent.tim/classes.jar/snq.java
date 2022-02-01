import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.troopgift.GridListViewPager;
import com.tencent.biz.troopgift.RadioViewPager;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class snq
  extends apsy
{
  public snq(TroopGiftPanel paramTroopGiftPanel, TroopGiftPanel.e parame) {}
  
  public void b(List<apsz.b> paramList, snf.b paramb)
  {
    boolean bool2 = true;
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, onGetPackageGiftList giveGifts.size=" + paramList.size());
    if (this.this$0.jdField_a_of_type_Snf == null) {
      return;
    }
    boolean bool1;
    label170:
    int i;
    if (this.a != null)
    {
      this.a.a(paramList, paramb);
      if ((this.this$0.q[TroopGiftPanel.bym] instanceof RadioViewPager))
      {
        if (this.this$0.jdField_a_of_type_Snf.a != null)
        {
          ((RadioViewPager)this.this$0.q[TroopGiftPanel.bym]).setEmptyInfo(this.this$0.jdField_a_of_type_Snf.a.wording, this.this$0.jdField_a_of_type_Snf.a.aFb);
          paramList = (RadioViewPager)this.this$0.q[TroopGiftPanel.bym];
          if (this.this$0.jdField_a_of_type_Snf.a.enable != 1) {
            break label412;
          }
          bool1 = true;
          paramList.setIsShowJumpInfo(bool1, this.this$0.jdField_a_of_type_Snf.a.jumpUrl, this.this$0.mContext);
        }
        if ((this.this$0.jdField_a_of_type_Snf.on == null) || (this.this$0.jdField_a_of_type_Snf.on.size() <= 0)) {
          break label418;
        }
        i = 1;
        label227:
        paramList = (RadioViewPager)this.this$0.q[TroopGiftPanel.bym];
        if (i != 0) {
          break label423;
        }
        bool1 = true;
        label249:
        paramList.setIsListEmpty(bool1);
        if (this.this$0.Nb())
        {
          paramList = this.this$0.qv;
          if (i == 0) {
            break label429;
          }
          i = 0;
          label279:
          paramList.setVisibility(i);
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.bym] != null)
        {
          this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.bym].setData(this.this$0.jdField_a_of_type_Snf.on);
          this.this$0.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[TroopGiftPanel.bym].refreshUI();
        }
        if (!this.this$0.Nb()) {
          break label440;
        }
        paramList = this.this$0;
        if ((TextUtils.isEmpty(this.this$0.aFj)) || (!TroopGiftPanel.a(this.this$0))) {
          break label434;
        }
        bool1 = bool2;
        paramList.setSendGiftBtnEnabled(bool1);
        return;
      }
      catch (Exception paramList)
      {
        return;
      }
      this.this$0.jdField_a_of_type_Snf.fi(paramList);
      this.this$0.jdField_a_of_type_Snf.a(paramb);
      break;
      label412:
      bool1 = false;
      break label170;
      label418:
      i = 0;
      break label227;
      label423:
      bool1 = false;
      break label249;
      label429:
      i = 4;
      break label279;
      label434:
      bool1 = false;
    }
    label440:
    this.this$0.setSendGiftBtnEnabled(TroopGiftPanel.a(this.this$0));
  }
  
  public void onError(int paramInt, String paramString)
  {
    QLog.d("TroopGiftPanel", 1, "getPackGiftStorage, onError: errorCode = " + paramInt + ", errorMsg = " + paramString);
    if (this.a != null) {
      this.a.onError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snq
 * JD-Core Version:    0.7.0.1
 */