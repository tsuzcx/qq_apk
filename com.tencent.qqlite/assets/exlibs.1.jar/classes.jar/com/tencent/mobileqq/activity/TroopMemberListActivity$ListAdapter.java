package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class TroopMemberListActivity$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public int a;
  public String a;
  public LinkedHashMap a;
  public int[] a;
  public String[] a;
  public int b = 0;
  
  public TroopMemberListActivity$ListAdapter(TroopMemberListActivity paramTroopMemberListActivity)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.q == 1) {}
    for (paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131363128);; paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131362868))
    {
      this.jdField_a_of_type_JavaLangString = paramTroopMemberListActivity;
      return;
    }
  }
  
  public int a()
  {
    return 2130903225;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)getItem(paramInt);
    CharDividedFacePreloadBaseAdapter.FaceInfo localFaceInfo = new CharDividedFacePreloadBaseAdapter.FaceInfo(this);
    if (localATroopMember != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public String a(String[] paramArrayOfString, double paramDouble)
  {
    Calendar.getInstance();
    if (paramDouble == -100.0D) {
      return paramArrayOfString[8];
    }
    if (paramDouble <= 5000.0D) {
      return paramArrayOfString[0];
    }
    if (paramDouble <= 10000.0D) {
      return paramArrayOfString[1];
    }
    if (paramDouble <= 50000.0D) {
      return paramArrayOfString[2];
    }
    if (paramDouble <= 500000.0D) {
      return paramArrayOfString[3];
    }
    if (paramDouble <= 1000000.0D) {
      return paramArrayOfString[4];
    }
    if (paramDouble <= 2000000.0D) {
      return paramArrayOfString[5];
    }
    if (paramDouble <= 10000000.0D) {
      return paramArrayOfString[6];
    }
    return paramArrayOfString[7];
  }
  
  public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    if (paramLong == 0L) {
      return paramArrayOfString[7];
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (i <= 0) {
      return paramArrayOfString[0];
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    return paramArrayOfString[6];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "mAdapter.notifyDataSetChanged2()");
    }
    Object[] arrayOfObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList);
    if (arrayOfObject.length >= 3)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
      super.notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1) - 1;
    }
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if ((localList != null) && (localList.size() > 1))
      {
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131362870, new Object[] { Integer.valueOf(localList.size()) }));
        return;
      }
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Object[] a(List paramList)
  {
    long l1 = System.currentTimeMillis();
    Object localObject4 = new LinkedHashMap();
    Object localObject6;
    ArrayList localArrayList;
    Object localObject5;
    TroopMemberListActivity.ATroopMember localATroopMember;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v != 0) {
        break label740;
      }
      localObject6 = new ArrayList();
      localArrayList = new ArrayList();
      localObject5 = new ArrayList();
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label373;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator.next();
        if (localATroopMember.jdField_a_of_type_Boolean) {
          ((List)localObject6).add(localATroopMember);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Boolean) && (!localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a())) && (localATroopMember.d == 1L)) {
          localArrayList.add(localATroopMember);
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j.equals(localATroopMember.jdField_a_of_type_JavaLangString))) && ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k.contains(localATroopMember.jdField_a_of_type_JavaLangString)))) {
          break;
        }
        ((List)localObject5).add(localATroopMember);
      }
      if (localATroopMember.c == null) {
        break label2011;
      }
    }
    finally {}
    if (localATroopMember.c.length() == 0) {
      break label2011;
    }
    int i;
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1.length() == 1)
      {
        i = localObject1.charAt(0);
        if ((65 > i) || (i > 90)) {
          break label2019;
        }
        label295:
        localObject3 = localObject1.toUpperCase();
      }
      label302:
      if (((LinkedHashMap)localObject4).get(localObject3) == null) {
        ((LinkedHashMap)localObject4).put(localObject3, new ArrayList());
      }
      this.b += 1;
      ((List)((LinkedHashMap)localObject4).get(localObject3)).add(localATroopMember);
      break;
      localObject2 = localATroopMember.c.substring(0, 1);
    }
    label373:
    Object localObject3 = new TroopMemberListActivity.MyComparator(0, true);
    Object localObject2 = new LinkedHashMap();
    if (((List)localObject6).size() > 0)
    {
      Collections.sort((List)localObject6, (Comparator)localObject3);
      ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131363731), localObject6);
    }
    if (localArrayList.size() > 0)
    {
      Collections.sort(localArrayList, (Comparator)localObject3);
      ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131362877), localArrayList);
    }
    int j = ((List)localObject5).size();
    label486:
    char c;
    if (j > 0)
    {
      Collections.sort((List)localObject5, (Comparator)localObject3);
      i = 0;
      if (i < j)
      {
        localObject6 = (TroopMemberListActivity.ATroopMember)((List)localObject5).get(i);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j.equals(((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_JavaLangString))) {
          break label2056;
        }
        ((List)localObject5).remove(i);
        ((List)localObject5).add(0, localObject6);
      }
      ((LinkedHashMap)localObject2).put(this.jdField_a_of_type_JavaLangString, localObject5);
      break label2042;
      label567:
      if (c <= 'Z')
      {
        if (((LinkedHashMap)localObject4).get(String.valueOf(c)) == null) {
          break label2048;
        }
        this.jdField_a_of_type_Int += 1;
        Collections.sort((List)((LinkedHashMap)localObject4).get(String.valueOf(c)), (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put(String.valueOf(c), ((LinkedHashMap)localObject4).get(String.valueOf(c)));
        break label2048;
      }
      if (((LinkedHashMap)localObject4).get("#") != null)
      {
        this.jdField_a_of_type_Int += 1;
        Collections.sort((List)((LinkedHashMap)localObject4).get("#"), (Comparator)localObject3);
        ((LinkedHashMap)localObject2).put("#", ((LinkedHashMap)localObject4).get("#"));
      }
      ((LinkedHashMap)localObject4).clear();
      label693:
      label740:
      do
      {
        for (;;)
        {
          localObject3 = new int[((LinkedHashMap)localObject2).keySet().size()];
          localObject4 = new String[localObject3.length];
          localObject5 = ((LinkedHashMap)localObject2).keySet().iterator();
          if (localObject3.length != 0) {
            break label1804;
          }
          return new Object[0];
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v == 1)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230730);
            localObject2 = Calendar.getInstance();
            ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject5 = paramList.iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).q)) {
                ((TroopMemberListActivity.ATroopMember)localObject6).q = a((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject6).b, (Calendar)localObject2);
              }
              if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).q) == null) {
                ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).q, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).q)).add(localObject6);
            }
            localObject2 = new LinkedHashMap();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g)
            {
              i = 0;
              if (i < localObject3.length)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label2063;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(1, true));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label2063;
              }
            }
            else
            {
              i = localObject3.length - 1;
              if (i >= 0)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label2070;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(1, false));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label2070;
              }
            }
            ((LinkedHashMap)localObject4).clear();
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v != 4) {
              break;
            }
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230731);
            localObject2 = Calendar.getInstance();
            ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
            localObject5 = paramList.iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
              if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).p)) {
                ((TroopMemberListActivity.ATroopMember)localObject6).p = b((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_Long, (Calendar)localObject2);
              }
              if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).p) == null) {
                ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).p, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).p)).add(localObject6);
            }
            localObject2 = new LinkedHashMap();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g)
            {
              i = 0;
              if (i < localObject3.length)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label2077;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(4, true));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label2077;
              }
            }
            else
            {
              i = localObject3.length - 1;
              if (i >= 0)
              {
                if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
                  break label2084;
                }
                Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(4, false));
                ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
                break label2084;
              }
            }
            ((LinkedHashMap)localObject4).clear();
          }
        }
        localObject2 = localObject4;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v != 2);
      label918:
      label989:
      localObject2 = null;
      label1237:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopLevelMap();
      }
      label1308:
      if ((localObject2 == null) || (((HashMap)localObject2).size() == 0))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131230733);
        localObject2 = new HashMap();
        i = 0;
        while (i < localObject3.length)
        {
          ((HashMap)localObject2).put(Integer.valueOf(i + 1), localObject3[i]);
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break label2091;
        }
        QLog.d("TroopMemberListActivity", 2, "constructHashStruct, SORT_BY_LEVEL, mTroopInfo.getTroopLevelMap is empty, use default");
        break label2091;
        label1505:
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject3).next();
          if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject5).r)) {
            ((TroopMemberListActivity.ATroopMember)localObject5).r = ((String)((HashMap)localObject2).get(Integer.valueOf(((TroopMemberListActivity.ATroopMember)localObject5).jdField_a_of_type_Int)));
          }
          if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject5).r) == null) {
            ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject5).r, new ArrayList());
          }
          ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject5).r)).add(localObject5);
        }
        localObject3 = new LinkedHashMap();
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g) {
          break label2101;
        }
        i = 19;
        label1644:
        if (i >= 0)
        {
          localObject5 = (String)((HashMap)localObject2).get(Integer.valueOf(i));
          if ((localObject5 == null) || (((LinkedHashMap)localObject4).get(localObject5) == null)) {
            break label2094;
          }
          Collections.sort((List)((LinkedHashMap)localObject4).get(localObject5), new TroopMemberListActivity.MyComparator(2, false));
          ((LinkedHashMap)localObject3).put(localObject5, ((LinkedHashMap)localObject4).get(localObject5));
          break label2094;
        }
      }
    }
    for (;;)
    {
      if (i < 20)
      {
        localObject5 = (String)((HashMap)localObject2).get(Integer.valueOf(i));
        if ((localObject5 != null) && (((LinkedHashMap)localObject4).get(localObject5) != null))
        {
          Collections.sort((List)((LinkedHashMap)localObject4).get(localObject5), new TroopMemberListActivity.MyComparator(2, true));
          ((LinkedHashMap)localObject3).put(localObject5, ((LinkedHashMap)localObject4).get(localObject5));
        }
      }
      else
      {
        ((LinkedHashMap)localObject4).clear();
        localObject2 = localObject3;
        break label693;
        label1804:
        localObject3[0] = 0;
        i = 1;
        while (i < localObject3.length)
        {
          j = localObject3[i];
          int k = localObject3[(i - 1)];
          localObject3[i] = (((List)((LinkedHashMap)localObject2).get(((Iterator)localObject5).next())).size() + k + 1 + j);
          i += 1;
        }
        localObject5 = ((LinkedHashMap)localObject2).keySet().iterator();
        i = 0;
        while (((Iterator)localObject5).hasNext())
        {
          localObject4[i] = ((String)((Iterator)localObject5).next());
          i += 1;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.v + ", listSize:" + paramList.size());
        }
        return new Object[] { localObject2, localObject3, localObject4 };
        break label1505;
        label2011:
        localObject2 = "#";
        break;
        label2019:
        if ((97 <= i) && (i <= 122)) {
          break label295;
        }
        localObject3 = "#";
        break label302;
        label2042:
        c = 'A';
        break label567;
        label2048:
        c = (char)(c + '\001');
        break label567;
        label2056:
        i += 1;
        break label486;
        label2063:
        i += 1;
        break label918;
        label2070:
        i -= 1;
        break label989;
        label2077:
        i += 1;
        break label1237;
        label2084:
        i -= 1;
        break label1308;
        label2091:
        break label1505;
        label2094:
        i -= 1;
        break label1644;
        label2101:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public String b(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L) {
      localCalendar.setTimeInMillis(1000L * paramLong);
    }
    int i;
    for (;;)
    {
      i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
      if (i > 0) {
        break;
      }
      return paramArrayOfString[0];
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    if (i <= 730) {
      return paramArrayOfString[6];
    }
    if (i <= 1095) {
      return paramArrayOfString[7];
    }
    if (i <= 1825) {
      return paramArrayOfString[8];
    }
    if (i <= 2555) {
      return paramArrayOfString[9];
    }
    if (i <= 3650) {
      return paramArrayOfString[10];
    }
    return paramArrayOfString[11];
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903697, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.TmViewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    while (i < 0)
    {
      i = -(i + 1) - 1;
      localObject = (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramViewGroup.f.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.b.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, a(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString), false);
      return paramView;
      paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.f.setTag("");
    paramViewGroup.b.setTag("");
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
    Object localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    if ((localObject != null) && (((List)localObject).size() > 1)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]) + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131362870, new Object[] { Integer.valueOf(((List)localObject).size()) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setContentDescription("");
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */