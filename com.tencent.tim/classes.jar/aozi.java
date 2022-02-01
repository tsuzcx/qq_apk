import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.1;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.2;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.3;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aozi
{
  private ArrayList<Entity> BI = new ArrayList();
  private ArrayList<Entity> BJ = new ArrayList();
  private aozi.a a;
  public PinnedFooterExpandableListView a;
  public aozf b;
  private String cny = "";
  QQAppInterface mApp;
  private int mFromType = -1;
  private HashMap<String, Long> oc = new HashMap();
  
  public aozi(QQAppInterface paramQQAppInterface, PinnedFooterExpandableListView paramPinnedFooterExpandableListView, aozi.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = paramPinnedFooterExpandableListView;
    this.jdField_a_of_type_Aozi$a = parama;
    this.b = new aozf(paramQQAppInterface);
  }
  
  private int Lb()
  {
    if (this.mFromType == 3) {
      return 3;
    }
    if (this.mFromType == 2) {
      return 2;
    }
    if (this.mFromType == 1) {
      return 1;
    }
    if (this.mFromType == 4) {
      return 4;
    }
    return 0;
  }
  
  private void SD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationFriends");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new RelationFriendsTroopViewHelper.3(this, paramString));
  }
  
  private void dYa()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationTroops");
    }
    apbc localapbc = (apbc)this.mApp.getManager(32);
    if (localapbc != null)
    {
      ArrayList localArrayList1 = this.jdField_a_of_type_Aozi$a.ce();
      if (localArrayList1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationTroops records size:" + localArrayList1.size());
        }
        ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
        localArrayList2.addAll(localArrayList1);
        localapbc.a(localArrayList2, new aozj(this));
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131560607, paramViewGroup, false);
      paramViewGroup = new aoyo.e();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131372190));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131364587));
      paramViewGroup.lo = paramView.findViewById(2131380904);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131380761).setVisibility(8);
      paramView.setTag(paramViewGroup);
      paramViewGroup.checkBox.setVisibility(8);
      paramViewGroup.lo.setVisibility(8);
      paramViewGroup.item = paramRelationTroopEntity;
      paramViewGroup.uin = paramRelationTroopEntity.troopInfo.troopuin;
      if (!paramRelationTroopEntity.troopInfo.hasSetTroopHead()) {
        break label246;
      }
    }
    label246:
    for (paramInt1 = 4;; paramInt1 = 113)
    {
      paramContext = aqdj.a(this.mApp, paramInt1, paramRelationTroopEntity.troopInfo.troopuin, 1, aqdj.g(4, 1), aqdj.g(4, 1));
      paramViewGroup.pQ.setImageDrawable(paramContext);
      paramContext = paramRelationTroopEntity.troopInfo.getTroopName();
      paramViewGroup.rc.setText(paramContext);
      return paramView;
      paramViewGroup = (aoyo.e)paramView.getTag();
      paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
    }
  }
  
  public void a(ArrayList<Groups> paramArrayList, SparseArray<ArrayList<Entity>> paramSparseArray)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "loadData");
    }
    Object localObject1;
    int i;
    Object localObject2;
    if (!this.BJ.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationtroop");
      }
      this.oc.clear();
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.BJ.size())
      {
        localObject2 = (RelationTroopEntity)this.BJ.get(i);
        ((ArrayList)localObject1).add(localObject2);
        this.oc.put(((RelationTroopEntity)localObject2).troopInfo.troopuin, Long.valueOf(i + 1L));
        i += 1;
      }
      localObject2 = new Groups();
      ((Groups)localObject2).group_id = 1008;
      ((Groups)localObject2).group_name = acfp.m(2131718733);
      ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
      ((Groups)localObject2).seqid = 0;
      paramArrayList.add(localObject2);
      paramSparseArray.put(((Groups)localObject2).group_id, localObject1);
    }
    if (!this.BI.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationfriends");
      }
      localObject1 = new Groups();
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.BI.size())
      {
        ((ArrayList)localObject2).add(this.BI.get(i));
        i += 1;
      }
      ((Groups)localObject1).group_id = 1007;
      ((Groups)localObject1).group_name = acfp.m(2131718732);
      ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
      ((Groups)localObject1).seqid = 0;
      paramArrayList.add(localObject1);
      paramSparseArray.put(((Groups)localObject1).group_id, localObject2);
    }
  }
  
  public View b(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131560607, paramViewGroup, false);
      paramViewGroup = new aayg.e();
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.rc = ((TextView)paramView.findViewById(2131372190));
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131364587));
      paramViewGroup.lo = paramView.findViewById(2131380904);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131380761).setVisibility(8);
      paramView.setTag(paramViewGroup);
      paramViewGroup.checkBox.setVisibility(8);
      paramViewGroup.lo.setVisibility(8);
      paramViewGroup.item = paramRelationTroopEntity;
      paramViewGroup.uin = paramRelationTroopEntity.troopInfo.troopuin;
      if (!paramRelationTroopEntity.troopInfo.hasSetTroopHead()) {
        break label246;
      }
    }
    label246:
    for (paramInt1 = 4;; paramInt1 = 113)
    {
      paramContext = aqdj.a(this.mApp, paramInt1, paramRelationTroopEntity.troopInfo.troopuin, 1, aqdj.g(4, 1), aqdj.g(4, 1));
      paramViewGroup.pQ.setImageDrawable(paramContext);
      paramContext = paramRelationTroopEntity.troopInfo.getTroopName();
      paramViewGroup.rc.setText(paramContext);
      return paramView;
      paramViewGroup = (aayg.e)paramView.getTag();
      paramViewGroup.rc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
    }
  }
  
  public Long b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (Long)this.oc.get(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "getRelationTroopChildId troopUin empty");
    }
    return Long.valueOf(-1L);
  }
  
  public void b(ResultRecord paramResultRecord)
  {
    this.mFromType = 1;
    if (paramResultRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult:,currentRelationUin:" + this.cny + ",lastrecordUIN:" + paramResultRecord.uin);
      }
      if (!this.cny.equals(paramResultRecord.uin))
      {
        this.cny = paramResultRecord.uin;
        if (!TextUtils.isEmpty(this.cny))
        {
          SD(this.cny);
          dYa();
        }
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult lastRecord null");
      }
      this.cny = "";
    } while (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView == null);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.2(this));
  }
  
  public void b(ResultRecord paramResultRecord, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult:,param_entrance:" + paramInt);
    }
    if ((paramInt == 38) || (paramInt == 29) || (paramInt == 39))
    {
      if (paramInt != 38) {
        break label170;
      }
      this.mFromType = 3;
      if (paramResultRecord == null) {
        break label192;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult:,currentRelationUin:" + this.cny + ",lastrecordUIN:" + paramResultRecord.uin);
      }
      if (!this.cny.equals(paramResultRecord.uin))
      {
        this.cny = paramResultRecord.uin;
        if (!TextUtils.isEmpty(this.cny))
        {
          SD(this.cny);
          if ((paramInt == 29) || (paramInt == 39)) {
            dYa();
          }
        }
      }
    }
    label170:
    label192:
    while (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView == null)
    {
      return;
      if (paramInt == 39)
      {
        this.mFromType = 4;
        break;
      }
      this.mFromType = 2;
      break;
    }
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.1(this));
  }
  
  public void dYb()
  {
    anot.a(this.mApp, "dc00899", "Grp_create", "", "grptab", "friendlist_exp", Lb(), 0, "", "", "", "");
  }
  
  public void dYc()
  {
    anot.a(this.mApp, "dc00899", "Grp_create", "", "grptab", "friendlist_clk", Lb(), 0, "", "", "", "");
  }
  
  public void dYd()
  {
    anot.a(this.mApp, "dc00899", "Grp_create", "", "grptab", "grplist_exp", Lb(), 0, "", "", "", "");
  }
  
  public void dYe()
  {
    anot.a(this.mApp, "dc00899", "Grp_create", "", "grptab", "grplist_clk", Lb(), 0, "", "", "", "");
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<ResultRecord> ce();
    
    public abstract ArrayList<String> cf();
    
    public abstract void czX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozi
 * JD-Core Version:    0.7.0.1
 */