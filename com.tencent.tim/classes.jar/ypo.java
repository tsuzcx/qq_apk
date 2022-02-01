import android.content.Context;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopRTLW.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class ypo
  extends yvg
{
  static int MAX_SIZE = 50;
  public ypo.a a;
  boolean bob;
  boolean boc = false;
  public int itemType;
  String keyWord;
  ArrayList<RecommendTroopItem> kr = new ArrayList();
  int uo;
  
  public ypo(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, yvg.a parama, int paramInt, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mListView = paramXListView;
    this.jdField_a_of_type_Yvg$a = parama;
    this.itemType = paramInt;
    this.keyWord = paramString;
    this.bpg = false;
    init();
  }
  
  protected void As(boolean paramBoolean)
  {
    super.As(paramBoolean);
  }
  
  public void At(boolean paramBoolean)
  {
    boolean bool2 = false;
    acms localacms = (acms)this.mApp.getBusinessHandler(20);
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList ,itemType = " + this.itemType + ",keyWord = " + this.keyWord + ",loadMore = " + paramBoolean + ",this = " + this);
    }
    if (!paramBoolean)
    {
      this.uo = -1;
      this.bob = false;
    }
    aPA();
    boolean bool1;
    if (this.itemType == 1)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label288;
      }
      bool1 = bool2;
      if (this.mContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1)
      {
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1) {
          break label283;
        }
        bool1 = bool2;
      }
      bool2 = bool1;
      if (QLog.isColorLevel()) {
        QLog.w("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList  >= M, canRequestLocation = " + bool1);
      }
    }
    label283:
    label288:
    for (bool2 = bool1;; bool2 = true)
    {
      if (bool2)
      {
        SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a("recommend_troop");
        if (QLog.isColorLevel()) {
          QLog.i("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList  >= M, info = " + localSosoLbsInfo);
        }
        if (localSosoLbsInfo == null) {
          aczc.a(new ypp(this, "recommend_troop", localacms, paramBoolean));
        }
      }
      else
      {
        return;
      }
      localacms.a(1, this.uo, 25, paramBoolean, a());
      return;
      localacms.b(this.itemType, this.keyWord, this.uo, 25, paramBoolean);
      return;
      bool1 = true;
      break;
    }
  }
  
  protected boolean Uf()
  {
    return this.bob;
  }
  
  protected yvb a()
  {
    return new yve(this.mContext, this.mApp, false);
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.kr.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopNearbyTroopList isSuccess = " + paramBoolean1 + ",itemType = " + paramInt1 + ",this.itemType = " + this.itemType + ",serverPageID = " + paramInt2 + ",dataListSize = " + i + ",newDataListSize = " + j);
    }
    if (paramInt1 == this.itemType)
    {
      this.bob = paramBoolean2;
      if (paramBoolean1)
      {
        if (!paramBoolean3)
        {
          this.boc = true;
          this.kr.clear();
        }
        i = this.kr.size();
        if (i + j < MAX_SIZE) {
          break label358;
        }
        this.kr.addAll(paramArrayList.subList(0, MAX_SIZE - i));
        this.bob = true;
        if (QLog.isColorLevel()) {
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = " + this.kr.size());
        }
      }
    }
    for (;;)
    {
      i = this.kr.size();
      ckE();
      if (QLog.isColorLevel()) {
        QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopNearbyTroopList do update Data,itemType = " + paramInt1 + ",this.itemType = " + this.itemType + ",serverPageID = " + paramInt2 + ",dataListSize = " + i + ",newDataListSize = " + j);
      }
      if (this.kr.size() > 0)
      {
        this.LV.setVisibility(0);
        if (this.bob) {
          this.LV.setText("没有更多内容了");
        }
      }
      this.uo = paramInt2;
      if (this.jdField_a_of_type_Ypo$a != null) {
        this.jdField_a_of_type_Ypo$a.aE(paramBoolean1, i);
      }
      return;
      label358:
      this.kr.addAll(paramArrayList);
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.kr.size();
    int j = paramArrayList.size();
    this.bob = paramBoolean2;
    if ((paramInt1 == this.itemType) && (paramString.equals(this.keyWord))) {
      if (paramBoolean1)
      {
        if (!paramBoolean3)
        {
          this.boc = true;
          this.kr.clear();
        }
        i = this.kr.size();
        if (i + j < MAX_SIZE) {
          break label320;
        }
        this.kr.addAll(paramArrayList.subList(0, MAX_SIZE - i));
        this.bob = true;
        if (QLog.isColorLevel()) {
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = " + this.kr.size());
        }
      }
    }
    for (;;)
    {
      i = this.kr.size();
      ckE();
      if (QLog.isColorLevel()) {
        QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopRecommendTroopList,do update Data ,itemType = " + paramInt1 + ",this.itemType = " + this.itemType + ",keyWord = " + paramString + ",this.keyWord = " + this.keyWord + ",serverPageID = " + paramInt2 + ",dataListSize = " + i + ",newDataListSize = " + j + ",this = " + this);
      }
      if (this.kr.size() > 0)
      {
        this.LV.setVisibility(0);
        if (this.bob) {
          this.LV.setText("没有更多内容了");
        }
      }
      this.uo = paramInt2;
      if (this.jdField_a_of_type_Ypo$a != null) {
        this.jdField_a_of_type_Ypo$a.aE(paramBoolean1, i);
      }
      return;
      label320:
      this.kr.addAll(paramArrayList);
    }
  }
  
  void aPA()
  {
    if (this.LV.getVisibility() != 0) {
      this.LV.post(new AddContactFindTroopRTLW.2(this));
    }
  }
  
  protected void ckE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "refreshListView,this.dataList.size() = " + this.kr.size() + ",needResetListViewPostion = " + this.boc);
    }
    this.b.bF(this.kr);
    this.b.notifyDataSetChanged();
    if (this.boc)
    {
      this.mListView.setSelection(0);
      this.boc = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.kr != null) {
      this.kr.clear();
    }
  }
  
  public void zc(String paramString)
  {
    this.keyWord = paramString;
    At(false);
  }
  
  public static abstract interface a
  {
    public abstract void aE(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypo
 * JD-Core Version:    0.7.0.1
 */