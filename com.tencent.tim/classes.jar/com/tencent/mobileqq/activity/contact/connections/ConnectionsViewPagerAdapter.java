package com.tencent.mobileqq.activity.contact.connections;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.SimpleArrayMap;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yrh;

public class ConnectionsViewPagerAdapter
  extends FragmentStatePagerAdapter
{
  private SimpleArrayMap<Integer, ConnectionsExplorationClidFragment> c = new SimpleArrayMap(10);
  private ArrayList<yrh> iM = new ArrayList();
  protected QQAppInterface mApp;
  
  public ConnectionsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, ArrayList<yrh> paramArrayList)
  {
    super(paramFragmentManager);
    this.mApp = paramQQAppInterface;
    if (paramArrayList != null) {
      this.iM.addAll(paramArrayList);
    }
  }
  
  private yrh a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.iM.size())) {
      return (yrh)this.iM.get(paramInt);
    }
    return null;
  }
  
  public ConnectionsExplorationClidFragment a(int paramInt)
  {
    yrh localyrh = a(paramInt);
    ConnectionsExplorationClidFragment localConnectionsExplorationClidFragment = new ConnectionsExplorationClidFragment();
    if (localyrh != null)
    {
      localConnectionsExplorationClidFragment.Ev(localyrh.tab_id);
      localConnectionsExplorationClidFragment.setPos(paramInt);
      if (localyrh.tab_id != 23) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localConnectionsExplorationClidFragment.AG(bool);
      this.c.put(Integer.valueOf(paramInt), localConnectionsExplorationClidFragment);
      return localConnectionsExplorationClidFragment;
    }
  }
  
  public void dd(ArrayList<yrh> paramArrayList)
  {
    this.iM.clear();
    this.iM.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsViewPagerAdapter", 2, "tabDatasUpdated. size:" + this.iM.size());
    }
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    this.c.remove(Integer.valueOf(paramInt));
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = ");
    }
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConnectionsViewPagerAdapter", 2, "getCount. size:" + this.iM.size());
    }
    return this.iM.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt);
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((ConnectionsExplorationClidFragment)this.c.get(Integer.valueOf(paramInt)) != null) {
      ((ConnectionsExplorationClidFragment)this.c.get(Integer.valueOf(paramInt))).ckW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */