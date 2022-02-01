package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import ypn;
import yzn;
import zad;

public class AddContactFindTroopViewPagerAdapter
  extends ContactsViewPagerAdapter
{
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<zad> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    zad localzad = a(paramInt);
    Object localObject;
    if ((localzad != null) && ((localzad instanceof ypn)))
    {
      ypn localypn = (ypn)localzad;
      localObject = b(localzad.id);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).itemType = localypn.itemType;
        ((AddContactViewPagerTroopFragment)localObject).aZu = localypn.itemName;
        ((AddContactViewPagerTroopFragment)localObject).keyWord = localypn.keyword;
        ((ContactsBaseFragment)localObject).setActivity(this.mActivity);
        ((ContactsBaseFragment)localObject).setApp(this.mApp);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.b);
        ((ContactsBaseFragment)localObject).setPos(paramInt);
        if ((localObject instanceof yzn)) {
          this.rq.add((yzn)localObject);
        }
        this.bH.put(localzad.id, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof yzn)) && (this.cbZ > 0)) {
        ((yzn)localObject).fX(this.cbY, this.cbZ);
      }
      return localObject;
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */