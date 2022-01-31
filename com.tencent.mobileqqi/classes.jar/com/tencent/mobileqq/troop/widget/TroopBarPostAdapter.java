package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.data.TroopBarPostAbsLayout;
import com.tencent.mobileqq.troop.data.TroopBarPostLayoutFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class TroopBarPostAdapter
  extends BaseAdapter
{
  protected LayoutInflater a;
  protected TroopBarPageEntity a;
  protected HashMap a;
  protected List a;
  protected WeakReference a;
  
  public TroopBarPostAdapter(WeakReference paramWeakReference, TroopBarPageEntity paramTroopBarPageEntity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)paramWeakReference.get());
    if (paramTroopBarPageEntity != null) {
      a(paramTroopBarPageEntity);
    }
  }
  
  public void a(TroopBarPageEntity paramTroopBarPageEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity = paramTroopBarPageEntity;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        TroopBarAbsDataEntity localTroopBarAbsDataEntity = (TroopBarAbsDataEntity)paramArrayList.get(i);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localTroopBarAbsDataEntity.id))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localTroopBarAbsDataEntity.id, Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
          this.jdField_a_of_type_JavaUtilList.add(localTroopBarAbsDataEntity);
        }
        i += 1;
      }
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        TroopBarAbsDataEntity localTroopBarAbsDataEntity = (TroopBarAbsDataEntity)paramList.get(i);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localTroopBarAbsDataEntity.id))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localTroopBarAbsDataEntity.id, Integer.valueOf(localArrayList.size()));
          localArrayList.add(localTroopBarAbsDataEntity);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return i + 4;
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return -1001;
    }
    if (paramInt == 1) {
      return -1002;
    }
    if (paramInt == 2) {
      return -1003;
    }
    if (paramInt == 3) {
      return -1004;
    }
    Object localObject = (TroopBarAbsDataEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt - 4);
    if ((localObject instanceof TroopBarPostEntity))
    {
      localObject = (TroopBarPostEntity)localObject;
      if ((((TroopBarPostEntity)localObject).layout == 1) || (((TroopBarPostEntity)localObject).layout == 2) || (((TroopBarPostEntity)localObject).layout == 3)) {
        return ((TroopBarPostEntity)localObject).layout;
      }
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l = System.currentTimeMillis();
    int i = getItemViewType(paramInt);
    if ((i == -1001) || (i == -1002) || (i == -1003) || (i == -1004))
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity;
      TroopBarPostAbsLayout localTroopBarPostAbsLayout = TroopBarPostLayoutFactory.a(i);
      if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
        break label168;
      }
      paramView = localTroopBarPostAbsLayout.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_AndroidViewLayoutInflater, paramView, paramViewGroup);
      paramViewGroup = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopBar", 2, "0 position: " + paramInt + ", layoutType = " + i + ", time = " + (System.currentTimeMillis() - l));
        paramViewGroup = paramView;
      }
    }
    label168:
    do
    {
      return paramViewGroup;
      paramViewGroup = (TroopBarAbsDataEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt - 4);
      break;
      paramViewGroup = paramView;
    } while (!QLog.isColorLevel());
    QLog.d("TroopBar", 2, "1 position: " + paramInt + ", time = " + (System.currentTimeMillis() - l));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopBarPostAdapter
 * JD-Core Version:    0.7.0.1
 */