import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class abgi
  extends BaseExpandableListAdapter
{
  public static final String bfA = UUID.randomUUID().toString();
  private aqlz a;
  private SparseArray<List<TroopInfo>> bT = new SparseArray();
  private int cok;
  private int col;
  private int com;
  private int con;
  private Map<String, Integer> hp;
  private ArrayList<Integer> lj = new ArrayList();
  private QQAppInterface mApp;
  private Context mContext;
  private List<Entity> vY;
  
  public abgi(Context paramContext, QQAppInterface paramQQAppInterface, List<Entity> paramList, Map<String, Integer> paramMap)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.cok = this.mContext.getResources().getDimensionPixelSize(2131296941);
    this.col = this.mContext.getResources().getDimensionPixelSize(2131296938);
    this.com = this.mContext.getResources().getDimensionPixelSize(2131296937);
    this.con = this.mContext.getResources().getDimensionPixelSize(2131296938);
    this.lj.add(Integer.valueOf(1));
    this.lj.add(Integer.valueOf(4));
    this.lj.add(Integer.valueOf(2));
    this.lj.add(Integer.valueOf(3));
    this.a = ((aqlz)paramQQAppInterface.getManager(31));
    paramContext = paramList;
    if (paramList == null) {
      paramContext = new ArrayList();
    }
    paramQQAppInterface = paramMap;
    if (paramMap == null) {
      paramQQAppInterface = new HashMap();
    }
    this.vY = paramContext;
    this.hp = paramQQAppInterface;
    hU(this.vY);
  }
  
  private void hU(List<Entity> paramList)
  {
    int i = 0;
    Object localObject1;
    if (i < paramList.size())
    {
      if (paramList.get(i) == null) {
        break label147;
      }
      localObject1 = (TroopInfo)paramList.get(i);
      if (localObject1 != null) {}
    }
    else
    {
      paramList = new abgi.c();
      localObject1 = this.lj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        if (this.bT.get(i) != null)
        {
          localObject2 = (List)this.bT.get(i);
          Collections.sort((List)localObject2, paramList);
          this.bT.put(i, localObject2);
        }
      }
    }
    Object localObject2 = (Integer)this.hp.get(((TroopInfo)localObject1).troopuin);
    if (localObject2 == null) {}
    for (;;)
    {
      label147:
      i += 1;
      break;
      int j = ((Integer)localObject2).intValue();
      if (this.bT.get(j) == null) {
        this.bT.put(j, new ArrayList());
      }
      ((List)this.bT.get(j)).add(localObject1);
    }
    paramList = this.lj.iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      if (this.bT.get(i) == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = bfA;
        ((TroopInfo)localObject1).troopname = this.mContext.getString(2131721350);
        this.bT.put(i, new ArrayList());
        ((List)this.bT.get(i)).add(localObject1);
      }
    }
  }
  
  private void v(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130839682);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130839701);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130839689);
      return;
    }
    paramView.setBackgroundResource(2130839695);
  }
  
  public TroopInfo a(int paramInt1, int paramInt2)
  {
    return (TroopInfo)((List)this.bT.get(e(paramInt1).intValue())).get(paramInt2);
  }
  
  public void ac(Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.hp = paramMap;
    hU(this.vY);
  }
  
  public Integer e(int paramInt)
  {
    return (Integer)this.lj.get(paramInt);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  @TargetApi(8)
  public int getChildType(int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    if ((localTroopInfo != null) && (bfA.equals(localTroopInfo.troopuin))) {
      return 1;
    }
    return 0;
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    int i = getChildType(paramInt1, paramInt2);
    Object localObject;
    if (TextUtils.isEmpty(localTroopInfo.getTroopName()))
    {
      paramViewGroup = localTroopInfo.troopuin;
      if (i != 1) {
        break label136;
      }
      if (paramView == null) {
        break label84;
      }
      localObject = (abgi.b)paramView.getTag();
      label55:
      ((abgi.b)localObject).PF.setText(paramViewGroup);
    }
    for (;;)
    {
      paramView.setFocusable(true);
      return paramView;
      paramViewGroup = localTroopInfo.getTroopName();
      break;
      label84:
      paramView = LayoutInflater.from(this.mContext).inflate(2131563080, null);
      localObject = new abgi.b();
      ((abgi.b)localObject).PF = ((TextView)paramView.findViewById(2131368211));
      paramView.setTag(localObject);
      break label55;
      label136:
      if (paramView != null) {
        localObject = (abgi.a)paramView.getTag();
      }
      for (;;)
      {
        aqdj localaqdj = aqdj.a(this.mApp, 4, localTroopInfo.troopuin);
        ((abgi.a)localObject).nN.setImageDrawable(localaqdj);
        ((abgi.a)localObject).PD.setText(paramViewGroup);
        ((abgi.a)localObject).PE.setVisibility(0);
        v(paramView, paramInt2, getChildrenCount(paramInt1));
        paramViewGroup = (Boolean)this.a.jb.get(localTroopInfo.troopuin);
        if ((paramViewGroup == null) || (!paramViewGroup.booleanValue())) {
          break label352;
        }
        ((abgi.a)localObject).xr.setVisibility(0);
        break;
        paramView = LayoutInflater.from(this.mContext).inflate(2131563079, null);
        localObject = new abgi.a();
        ((abgi.a)localObject).nN = ((ImageView)paramView.findViewById(2131368159));
        ((abgi.a)localObject).PD = ((TextView)paramView.findViewById(2131368211));
        ((abgi.a)localObject).PE = ((TextView)paramView.findViewById(2131368175));
        ((abgi.a)localObject).xr = ((ImageView)paramView.findViewById(2131377180));
        paramView.setTag(localObject);
      }
      label352:
      ((abgi.a)localObject).xr.setVisibility(8);
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.bT.get(e(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.lj.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupType(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupTypeCount()
  {
    return this.lj.size();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (int i = ((Integer)paramView.getTag()).intValue();; i = -1)
    {
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (i != -1)
        {
          localView = paramView;
          if (i == e(paramInt).intValue()) {}
        }
      }
      else
      {
        i = 0;
        switch (e(paramInt).intValue())
        {
        }
      }
      for (;;)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(i, null);
        localView.setFocusable(true);
        localView.setTag(e(paramInt));
        return localView;
        i = 2131563236;
        continue;
        i = 2131563239;
        continue;
        i = 2131563237;
        continue;
        i = 2131563238;
      }
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    this.bT.clear();
    hU(this.vY);
    super.notifyDataSetChanged();
  }
  
  public class a
  {
    public TextView PD;
    public TextView PE;
    public ImageView nN;
    public ImageView xr;
    
    protected a() {}
  }
  
  public class b
  {
    public TextView PF;
    
    protected b() {}
  }
  
  public static class c
    implements Comparator<TroopInfo>
  {
    public int a(TroopInfo paramTroopInfo1, TroopInfo paramTroopInfo2)
    {
      if (paramTroopInfo1.lastMsgTime > paramTroopInfo2.lastMsgTime) {
        return -1;
      }
      if (paramTroopInfo1.lastMsgTime < paramTroopInfo2.lastMsgTime) {
        return 1;
      }
      return acdb.a(paramTroopInfo1.mComparePartInt, paramTroopInfo1.mCompareSpell, paramTroopInfo2.mComparePartInt, paramTroopInfo2.mCompareSpell);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgi
 * JD-Core Version:    0.7.0.1
 */