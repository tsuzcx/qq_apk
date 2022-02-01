package com.tencent.widget;

import android.annotation.TargetApi;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import autm;
import autn;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collections;

public class ExpandableListConnector
  extends BaseAdapter
  implements Filterable
{
  private ArrayList<GroupMetadata> Eq = new ArrayList();
  private ExpandableListAdapter a;
  private int esS;
  private int esT = 2147483647;
  private final DataSetObserver mDataSetObserver = new a();
  
  public ExpandableListConnector(ExpandableListAdapter paramExpandableListAdapter)
  {
    a(paramExpandableListAdapter);
  }
  
  private void cJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    ArrayList localArrayList = this.Eq;
    int i = localArrayList.size();
    this.esS = 0;
    int j = i;
    int n;
    int k;
    GroupMetadata localGroupMetadata;
    int m;
    if (paramBoolean2)
    {
      n = i - 1;
      k = 0;
      if (n >= 0)
      {
        localGroupMetadata = (GroupMetadata)localArrayList.get(n);
        int i2 = g(localGroupMetadata.aza, localGroupMetadata.esW);
        m = i;
        if (i2 == localGroupMetadata.esW) {
          break label289;
        }
        j = i;
        if (i2 == -1)
        {
          localArrayList.remove(n);
          j = i - 1;
        }
        localGroupMetadata.esW = i2;
        m = j;
        if (k != 0) {
          break label289;
        }
        k = 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      n -= 1;
      k = j;
      break;
      j = i;
      if (k != 0)
      {
        Collections.sort(localArrayList);
        j = i;
      }
      k = 0;
      m = 0;
      i = i1;
      if (i < j)
      {
        localGroupMetadata = (GroupMetadata)localArrayList.get(i);
        if ((localGroupMetadata.esV == -1) || (paramBoolean1)) {}
        for (n = this.a.getChildrenCount(localGroupMetadata.esW);; n = localGroupMetadata.esV - localGroupMetadata.esU)
        {
          this.esS += n;
          m += localGroupMetadata.esW - k;
          k = localGroupMetadata.esW;
          localGroupMetadata.esU = m;
          m = n + m;
          localGroupMetadata.esV = m;
          i += 1;
          break;
        }
      }
      return;
      label289:
      j = k;
      i = m;
    }
  }
  
  ExpandableListAdapter a()
  {
    return this.a;
  }
  
  b a(int paramInt)
  {
    int k = 0;
    Object localObject = this.Eq;
    int i = ((ArrayList)localObject).size();
    if (i == 0) {
      return b.a(paramInt, 2, paramInt, -1, null, 0);
    }
    for (;;)
    {
      int j;
      if (i <= j)
      {
        int m = (j - i) / 2 + i;
        GroupMetadata localGroupMetadata = (GroupMetadata)((ArrayList)localObject).get(m);
        if (paramInt > localGroupMetadata.esV)
        {
          i = m + 1;
          k = m;
        }
        else if (paramInt < localGroupMetadata.esU)
        {
          j = m - 1;
          k = m;
        }
        else
        {
          if (paramInt == localGroupMetadata.esU) {
            return b.a(paramInt, 2, localGroupMetadata.esW, -1, localGroupMetadata, m);
          }
          k = m;
          if (paramInt <= localGroupMetadata.esV)
          {
            i = localGroupMetadata.esU;
            return b.a(paramInt, 1, localGroupMetadata.esW, paramInt - (i + 1), localGroupMetadata, m);
          }
        }
      }
      else
      {
        if (i > k)
        {
          localObject = (GroupMetadata)((ArrayList)localObject).get(i - 1);
          k = paramInt - ((GroupMetadata)localObject).esV + ((GroupMetadata)localObject).esW;
          j = i;
        }
        for (i = k;; i = ((GroupMetadata)localObject).esW - (((GroupMetadata)localObject).esU - paramInt))
        {
          return b.a(paramInt, 2, i, -1, null, j);
          if (j >= k) {
            break;
          }
          j += 1;
          localObject = (GroupMetadata)((ArrayList)localObject).get(j);
        }
        throw new RuntimeException("Unknown state");
        j = i - 1;
        i = 0;
      }
    }
  }
  
  b a(autn paramautn)
  {
    int j = 0;
    Object localObject2 = null;
    ArrayList localArrayList = this.Eq;
    int i = localArrayList.size();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = b.a(paramautn.ccW, paramautn.type, paramautn.ccW, paramautn.cWL, null, 0);
      return localObject1;
    }
    for (;;)
    {
      if (k <= i)
      {
        int m = (i - k) / 2 + k;
        GroupMetadata localGroupMetadata = (GroupMetadata)localArrayList.get(m);
        if (paramautn.ccW > localGroupMetadata.esW)
        {
          k = m + 1;
          j = m;
          continue;
        }
        if (paramautn.ccW < localGroupMetadata.esW)
        {
          i = m - 1;
          j = m;
          continue;
        }
        j = m;
        if (paramautn.ccW != localGroupMetadata.esW) {
          continue;
        }
        if (paramautn.type == 2) {
          return b.a(localGroupMetadata.esU, paramautn.type, paramautn.ccW, paramautn.cWL, localGroupMetadata, m);
        }
        localObject1 = localObject2;
        if (paramautn.type != 1) {
          break;
        }
        return b.a(localGroupMetadata.esU + paramautn.cWL + 1, paramautn.type, paramautn.ccW, paramautn.cWL, localGroupMetadata, m);
      }
      localObject1 = localObject2;
      if (paramautn.type != 2) {
        break;
      }
      if (k > j)
      {
        localObject1 = (GroupMetadata)localArrayList.get(k - 1);
        i = ((GroupMetadata)localObject1).esV;
        return b.a(paramautn.ccW - ((GroupMetadata)localObject1).esW + i, paramautn.type, paramautn.ccW, paramautn.cWL, null, k);
      }
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      i += 1;
      localObject1 = (GroupMetadata)localArrayList.get(i);
      return b.a(((GroupMetadata)localObject1).esU - (((GroupMetadata)localObject1).esW - paramautn.ccW), paramautn.type, paramautn.ccW, paramautn.cWL, null, i);
      i -= 1;
      int k = 0;
    }
  }
  
  public void a(ExpandableListAdapter paramExpandableListAdapter)
  {
    if (this.a != null) {
      this.a.unregisterDataSetObserver(this.mDataSetObserver);
    }
    this.a = paramExpandableListAdapter;
    paramExpandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
  }
  
  boolean a(b paramb)
  {
    if (paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata == null) {
      return false;
    }
    this.Eq.remove(paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata);
    cJ(false, false);
    notifyDataSetChanged();
    this.a.onGroupCollapsed(paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esW);
    return true;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }
  
  boolean b(b paramb)
  {
    if (paramb.jdField_a_of_type_Autn.ccW < 0) {
      throw new RuntimeException("Need group");
    }
    if (this.esT == 0) {
      return false;
    }
    if (paramb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata != null) {
      return false;
    }
    if (this.Eq.size() >= this.esT)
    {
      localGroupMetadata = (GroupMetadata)this.Eq.get(0);
      int i = this.Eq.indexOf(localGroupMetadata);
      collapseGroup(localGroupMetadata.esW);
      if (paramb.esX > i) {
        paramb.esX -= 1;
      }
    }
    GroupMetadata localGroupMetadata = GroupMetadata.a(-1, -1, paramb.jdField_a_of_type_Autn.ccW, this.a.getGroupId(paramb.jdField_a_of_type_Autn.ccW));
    this.Eq.add(paramb.esX, localGroupMetadata);
    cJ(false, false);
    notifyDataSetChanged();
    this.a.onGroupExpanded(localGroupMetadata.esW);
    return true;
  }
  
  boolean collapseGroup(int paramInt)
  {
    b localb = a(autn.a(2, paramInt, -1, -1));
    if (localb == null) {
      return false;
    }
    boolean bool = a(localb);
    localb.recycle();
    return bool;
  }
  
  ArrayList<GroupMetadata> ev()
  {
    return this.Eq;
  }
  
  void fo(ArrayList<GroupMetadata> paramArrayList)
  {
    if ((paramArrayList == null) || (this.a == null)) {
      return;
    }
    int j = this.a.getGroupCount();
    int i = paramArrayList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label55;
      }
      if (((GroupMetadata)paramArrayList.get(i)).esW >= j) {
        break;
      }
      i -= 1;
    }
    label55:
    this.Eq = paramArrayList;
    cJ(true, false);
  }
  
  int g(long paramLong, int paramInt)
  {
    int i1 = this.a.getGroupCount();
    int m;
    if (i1 == 0)
    {
      m = -1;
      return m;
    }
    if (paramLong == -9223372036854775808L) {
      return -1;
    }
    paramInt = Math.min(i1 - 1, Math.max(0, paramInt));
    long l = SystemClock.uptimeMillis();
    int i = 0;
    ExpandableListAdapter localExpandableListAdapter = a();
    label66:
    int n;
    int j;
    if (localExpandableListAdapter == null)
    {
      return -1;
      if ((n != 0) || ((i != 0) && (m == 0)))
      {
        j += 1;
        i = 0;
        paramInt = j;
      }
    }
    for (;;)
    {
      int k;
      if (SystemClock.uptimeMillis() <= l + 100L)
      {
        m = paramInt;
        if (localExpandableListAdapter.getGroupId(paramInt) == paramLong) {
          break;
        }
        if (j != i1 - 1) {
          break label154;
        }
        m = 1;
        if (k != 0) {
          break label160;
        }
      }
      label154:
      label160:
      for (n = 1;; n = 0)
      {
        if ((m == 0) || (n == 0)) {
          break label164;
        }
        return -1;
        m = 0;
        break;
      }
      label164:
      break label66;
      if ((m != 0) || ((i == 0) && (n == 0)))
      {
        k -= 1;
        i = 1;
        paramInt = k;
        continue;
        k = paramInt;
        m = paramInt;
        j = paramInt;
        paramInt = m;
      }
    }
  }
  
  public int getCount()
  {
    return this.a.getGroupCount() + this.esS;
  }
  
  public Filter getFilter()
  {
    ExpandableListAdapter localExpandableListAdapter = a();
    if ((localExpandableListAdapter instanceof Filterable)) {
      return ((Filterable)localExpandableListAdapter).getFilter();
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    b localb = a(paramInt);
    if (localb.jdField_a_of_type_Autn.type == 2) {}
    for (Object localObject = this.a.getGroup(localb.jdField_a_of_type_Autn.ccW);; localObject = this.a.getChild(localb.jdField_a_of_type_Autn.ccW, localb.jdField_a_of_type_Autn.cWL))
    {
      localb.recycle();
      return localObject;
      if (localb.jdField_a_of_type_Autn.type != 1) {
        break;
      }
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  public long getItemId(int paramInt)
  {
    b localb = a(paramInt);
    long l1 = this.a.getGroupId(localb.jdField_a_of_type_Autn.ccW);
    if (localb.jdField_a_of_type_Autn.type == 2) {}
    long l2;
    for (l1 = this.a.getCombinedGroupId(l1);; l1 = this.a.getCombinedChildId(l1, l2))
    {
      localb.recycle();
      return l1;
      if (localb.jdField_a_of_type_Autn.type != 1) {
        break;
      }
      l2 = this.a.getChildId(localb.jdField_a_of_type_Autn.ccW, localb.jdField_a_of_type_Autn.cWL);
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getItemViewType(int paramInt)
  {
    autn localautn = a(paramInt).jdField_a_of_type_Autn;
    HeterogeneousExpandableList localHeterogeneousExpandableList;
    if ((VersionUtils.isrFroyo()) && ((this.a instanceof HeterogeneousExpandableList)))
    {
      localHeterogeneousExpandableList = (HeterogeneousExpandableList)this.a;
      if (localautn.type == 2) {
        paramInt = localHeterogeneousExpandableList.getGroupType(localautn.ccW);
      }
    }
    for (;;)
    {
      localautn.recycle();
      return paramInt;
      paramInt = localHeterogeneousExpandableList.getChildType(localautn.ccW, localautn.cWL);
      paramInt = localHeterogeneousExpandableList.getGroupTypeCount() + paramInt;
      continue;
      if (localautn.type == 2) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    b localb = a(paramInt);
    View localView;
    if (localb.jdField_a_of_type_Autn.type == 2)
    {
      localView = this.a.getGroupView(localb.jdField_a_of_type_Autn.ccW, localb.isExpanded(), paramView, paramViewGroup);
      localb.recycle();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    if (localb.jdField_a_of_type_Autn.type == 1)
    {
      if (localb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata.esV == paramInt) {}
      for (;;)
      {
        localView = this.a.getChildView(localb.jdField_a_of_type_Autn.ccW, localb.jdField_a_of_type_Autn.cWL, bool, paramView, paramViewGroup);
        break;
        bool = false;
      }
    }
    throw new RuntimeException("Flat list position is of unknown type");
  }
  
  @TargetApi(8)
  public int getViewTypeCount()
  {
    if ((VersionUtils.isrFroyo()) && ((this.a instanceof HeterogeneousExpandableList)))
    {
      HeterogeneousExpandableList localHeterogeneousExpandableList = (HeterogeneousExpandableList)this.a;
      int i = localHeterogeneousExpandableList.getGroupTypeCount();
      return localHeterogeneousExpandableList.getChildTypeCount() + i;
    }
    return 2;
  }
  
  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    ExpandableListAdapter localExpandableListAdapter = a();
    if (localExpandableListAdapter != null) {
      return localExpandableListAdapter.isEmpty();
    }
    return true;
  }
  
  public boolean isEnabled(int paramInt)
  {
    boolean bool = true;
    autn localautn = a(paramInt).jdField_a_of_type_Autn;
    if (localautn.type == 1) {
      bool = this.a.isChildSelectable(localautn.ccW, localautn.cWL);
    }
    localautn.recycle();
    return bool;
  }
  
  public boolean isGroupExpanded(int paramInt)
  {
    int i = this.Eq.size() - 1;
    while (i >= 0)
    {
      if (((GroupMetadata)this.Eq.get(i)).esW == paramInt) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public static class GroupMetadata
    implements Parcelable, Comparable<GroupMetadata>
  {
    public static final Parcelable.Creator<GroupMetadata> CREATOR = new autm();
    long aza;
    int esU;
    int esV;
    int esW;
    
    public static GroupMetadata a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      GroupMetadata localGroupMetadata = new GroupMetadata();
      localGroupMetadata.esU = paramInt1;
      localGroupMetadata.esV = paramInt2;
      localGroupMetadata.esW = paramInt3;
      localGroupMetadata.aza = paramLong;
      return localGroupMetadata;
    }
    
    public int a(GroupMetadata paramGroupMetadata)
    {
      if (paramGroupMetadata == null) {
        throw new IllegalArgumentException();
      }
      return this.esW - paramGroupMetadata.esW;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.esU);
      paramParcel.writeInt(this.esV);
      paramParcel.writeInt(this.esW);
      paramParcel.writeLong(this.aza);
    }
  }
  
  public class a
    extends DataSetObserver
  {
    protected a() {}
    
    public void onChanged()
    {
      ExpandableListConnector.a(ExpandableListConnector.this, true, true);
      ExpandableListConnector.this.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      ExpandableListConnector.a(ExpandableListConnector.this, true, true);
      ExpandableListConnector.this.notifyDataSetInvalidated();
    }
  }
  
  public static class b
  {
    private static ArrayList<b> Er = new ArrayList(5);
    public autn a;
    public ExpandableListConnector.GroupMetadata a;
    public int esX;
    
    private static b a()
    {
      synchronized (Er)
      {
        if (Er.size() > 0)
        {
          localb = (b)Er.remove(0);
          localb.resetState();
          return localb;
        }
        b localb = new b();
        return localb;
      }
    }
    
    static b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
    {
      b localb = a();
      localb.jdField_a_of_type_Autn = autn.a(paramInt2, paramInt3, paramInt4, paramInt1);
      localb.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = paramGroupMetadata;
      localb.esX = paramInt5;
      return localb;
    }
    
    private void resetState()
    {
      this.jdField_a_of_type_Autn = null;
      this.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata = null;
      this.esX = 0;
    }
    
    public boolean isExpanded()
    {
      return this.jdField_a_of_type_ComTencentWidgetExpandableListConnector$GroupMetadata != null;
    }
    
    public void recycle()
    {
      synchronized (Er)
      {
        if (Er.size() < 5) {
          Er.add(this);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector
 * JD-Core Version:    0.7.0.1
 */