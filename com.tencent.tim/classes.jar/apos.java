import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class apos
  extends yvg
{
  View IL;
  TextView PG;
  boolean bob = false;
  ArrayList<RecommendTroopItem> kr = new ArrayList();
  long troopUin;
  int uo;
  
  public apos(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, yvg.a parama, String paramString, boolean paramBoolean, TextView paramTextView, View paramView)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mListView = paramXListView;
    this.a = parama;
    this.bph = false;
    this.bpf = paramBoolean;
    this.PG = paramTextView;
    this.IL = paramView;
    try
    {
      this.troopUin = Long.parseLong(paramString);
      init();
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        QLog.d("TroopDataCardRecomTroopListWrapper", 1, "TroopDataCardRecomTroopListWrapper NumberFormatException ", paramQQAppInterface);
      }
    }
  }
  
  protected void At(boolean paramBoolean)
  {
    ((acms)this.mApp.getBusinessHandler(20)).H(this.troopUin, this.uo, 25);
  }
  
  protected boolean Uf()
  {
    return this.bob;
  }
  
  protected yvb a()
  {
    return new apor(this.mContext, this.mApp, true);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList)
  {
    int i = this.kr.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, "onGetTroopDataCardRecommendTroopList isSuccess = " + paramBoolean1 + ",troopUIN = " + paramLong + ",serverPageID = " + paramInt + ",dataListSize = " + i + ",newDataListSize = " + j);
    }
    this.bob = paramBoolean2;
    if ((paramBoolean1) && (this.troopUin == paramLong))
    {
      if (j + i < 50) {
        break label221;
      }
      this.kr.addAll(paramArrayList.subList(0, 50 - i));
      this.bob = true;
      if (QLog.isColorLevel()) {
        QLog.d("TroopDataCardRecomTroopListWrapper", 2, "onGetTroopDataCardRecommendTroopList reach limit,this.dataList.size() = " + this.kr.size());
      }
    }
    for (;;)
    {
      ckE();
      if (this.kr.size() > 0)
      {
        this.LV.setVisibility(0);
        if (this.bob) {
          this.LV.setText("没有更多内容了");
        }
      }
      this.uo = paramInt;
      return;
      label221:
      this.kr.addAll(paramArrayList);
    }
  }
  
  protected void ckE()
  {
    this.b.bF(this.kr);
    this.b.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, "refreshListView,this.dataList.size() = " + this.kr.size());
    }
    if (this.kr.size() > 0)
    {
      this.mListView.setVisibility(0);
      this.PG.setVisibility(0);
      return;
    }
    this.PG.setVisibility(8);
    this.LV.setVisibility(8);
  }
  
  protected void init()
  {
    super.init();
    if (this.bpf)
    {
      this.mListView.addHeaderView(this.PG);
      this.PG.setVisibility(8);
    }
    this.mListView.addFooterView(this.IL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apos
 * JD-Core Version:    0.7.0.1
 */