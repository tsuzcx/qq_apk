package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yzn;
import yzu;
import zad;

public class ContactsViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements ContactsBaseFragment.a
{
  protected ContactsBaseFragment.b b;
  protected SparseArray<ContactsBaseFragment> bH = new SparseArray();
  protected int cbY = -1;
  protected int cbZ = -1;
  protected ArrayList<zad> iM = new ArrayList();
  protected BaseActivity mActivity;
  protected QQAppInterface mApp;
  protected ArrayList<yzn> rq = new ArrayList();
  
  public ContactsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<zad> paramArrayList)
  {
    super(paramFragmentManager);
    this.mApp = paramQQAppInterface;
    this.mActivity = paramBaseActivity;
    this.iM.clear();
    this.iM.addAll(paramArrayList);
  }
  
  public void Bi(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onThemeChange:" + paramBoolean);
    }
    int i = 0;
    while (i < this.iM.size())
    {
      Object localObject = a(i);
      if (localObject != null)
      {
        localObject = b(((zad)localObject).id);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).Bi(paramBoolean);
        }
      }
      i += 1;
    }
  }
  
  public void ER(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, "remove fragment cache :" + paramInt);
      }
      ContactsBaseFragment localContactsBaseFragment = b(paramInt);
      if (localContactsBaseFragment != null)
      {
        localContactsBaseFragment.doOnDestroy();
        this.bH.delete(paramInt);
        this.rq.remove(localContactsBaseFragment);
      }
    }
  }
  
  public void ES(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onFrameTabClick:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.bMf();
    }
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    zad localzad = a(paramInt);
    Object localObject = null;
    if (localzad != null)
    {
      ContactsBaseFragment localContactsBaseFragment = b(localzad.id);
      localObject = localContactsBaseFragment;
      if (localContactsBaseFragment == null)
      {
        localObject = localContactsBaseFragment;
        if (paramBoolean)
        {
          localObject = yzu.a(localzad.id);
          ((ContactsBaseFragment)localObject).setActivity(this.mActivity);
          ((ContactsBaseFragment)localObject).setApp(this.mApp);
          ((ContactsBaseFragment)localObject).a(this);
          ((ContactsBaseFragment)localObject).a(this.b);
          ((ContactsBaseFragment)localObject).setPos(paramInt);
          if ((localObject instanceof yzn)) {
            this.rq.add((yzn)localObject);
          }
          this.bH.put(localzad.id, localObject);
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getFragment ..... create " + paramInt + "  " + localzad.id);
        }
      }
    }
    if (localObject != null) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getFragment ..... pos:" + paramInt + "  id:" + ((ContactsBaseFragment)localObject).xY() + "  isDetached: " + ((ContactsBaseFragment)localObject).isDetached() + " contactsViewPager:" + this.mActivity.findViewById(2131365261) + "  isAdd: " + ((ContactsBaseFragment)localObject).isAdded() + " " + localObject);
    }
    if ((localObject != null) && ((localObject instanceof yzn)) && (this.cbZ > 0)) {
      ((yzn)localObject).fX(this.cbY, this.cbZ);
    }
    return localObject;
  }
  
  protected zad a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.iM.size())) {
      return (zad)this.iM.get(paramInt);
    }
    return null;
  }
  
  public void a(ContactsBaseFragment.b paramb)
  {
    this.b = paramb;
  }
  
  public void aU(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnResume:" + paramInt + " tabChange:" + paramBoolean);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.Av(false);
    }
  }
  
  protected ContactsBaseFragment b(int paramInt)
  {
    return (ContactsBaseFragment)this.bH.get(paramInt, null);
  }
  
  public void bMe()
  {
    int i = 0;
    while (i < this.iM.size())
    {
      Object localObject = a(i);
      if (localObject != null)
      {
        localObject = b(((zad)localObject).id);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).bMe();
        }
      }
      i += 1;
    }
  }
  
  public void bl(QQAppInterface paramQQAppInterface)
  {
    if (this.mApp != paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
      int i = 0;
      while (i < this.iM.size())
      {
        Object localObject = a(i);
        if (localObject != null)
        {
          localObject = b(((zad)localObject).id);
          if (localObject != null)
          {
            ((ContactsBaseFragment)localObject).setApp(paramQQAppInterface);
            ((ContactsBaseFragment)localObject).resetData();
          }
        }
        i += 1;
      }
    }
  }
  
  public void dd(ArrayList<zad> paramArrayList)
  {
    this.iM.clear();
    this.iM.addAll(paramArrayList);
    cleanCache();
    if (QLog.isColorLevel()) {
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, "tabDatasUpdated. size:" + this.iM.size());
    }
    notifyDataSetChanged();
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = " + this.bH.size());
    }
    int i = 0;
    while (i < this.bH.size())
    {
      ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.bH.valueAt(i);
      if (localContactsBaseFragment != null) {
        localContactsBaseFragment.doOnDestroy();
      }
      i += 1;
    }
    this.bH.clear();
    this.rq.clear();
  }
  
  public void fY(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, "headViewScrollChanged currentY:" + paramInt1 + "  maxY:" + paramInt2);
    }
    int i = 0;
    while (i < this.rq.size())
    {
      ((yzn)this.rq.get(i)).fX(paramInt1, paramInt2);
      i += 1;
    }
    this.cbY = paramInt1;
    this.cbZ = paramInt2;
  }
  
  public void fZ(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onPageSelected. curPos:" + paramInt1 + " prePos:" + paramInt2);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt1, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.pH(true);
    }
    localContactsBaseFragment = a(paramInt2, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.pH(false);
    }
  }
  
  protected int fz(int paramInt)
  {
    int i = 0;
    while (i < this.iM.size())
    {
      if (((zad)this.iM.get(i)).id == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, "getCount. size:" + this.iM.size());
    }
    return this.iM.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt, true);
  }
  
  public int getItemPosition(Object paramObject)
  {
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition " + paramObject);
    paramObject = (ContactsBaseFragment)paramObject;
    if (paramObject != null)
    {
      int i = fz(paramObject.xY());
      if (i >= 0)
      {
        if (paramObject.xZ() == i)
        {
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition newPos" + i + " oldPos:" + paramObject.xZ());
        paramObject.setPos(i);
        return i;
      }
    }
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
  
  public void refresh(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "refresh:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.refresh();
    }
  }
  
  public void sx(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnPause:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.Aw(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */