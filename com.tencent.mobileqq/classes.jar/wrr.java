import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class wrr
  implements Runnable
{
  wrr(wrq paramwrq, ArrayList paramArrayList, List paramList) {}
  
  public void run()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "load data: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.c.clear();
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.e.clear();
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.d.clear();
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.b.clear();
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.g.clear();
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.f.clear();
    Object localObject1 = this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new TroopListAdapter2.CommonlyUsedTroopCompator());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.a((TroopInfo)localObject2, this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy);
          this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.b.add(localObject2);
        }
      }
    }
    localObject1 = this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject3;
    label548:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.a((TroopInfo)localObject3, this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy);
      i = TroopListAdapter2.a(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject3).troopuin));
      if (((TroopInfo)localObject3).isQidianPrivateTroop())
      {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.g.add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject3));
      }
      else
      {
        if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(localObject1)))) {
          this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.c.add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject3));
        }
        for (;;)
        {
          if (((TroopInfo)localObject3).hasSetTroopName()) {
            break label548;
          }
          this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.f.add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject3));
          break;
          if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
            this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.d.add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject3));
          } else {
            this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.e.add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject3));
          }
        }
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    label752:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.b.add(localObject2);
      }
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.c.add(new TroopListAdapter2.TroopListItemWithMask(1, (Entity)localObject2));
      }
      for (;;)
      {
        if (((DiscussionInfo)localObject2).hasRenamed()) {
          break label752;
        }
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.f.add(new TroopListAdapter2.TroopListItemWithMask(1, (Entity)localObject2));
        break;
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.e.add(new TroopListAdapter2.TroopListItemWithMask(1, (Entity)localObject2));
      }
    }
    localObject1 = new TroopListAdapter2.TroopCompator();
    Collections.sort(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.c, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.d, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.e, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.f, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.g, (Comparator)localObject1);
    if (!this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.b.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.f.size() > 0) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      }
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.c.size() > 0) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
      }
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.d.size() > 0) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
      }
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.e.size() > 0) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      }
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.g.size() > 0) {
        this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10));
      }
      localObject1 = new HashSet(5);
      localObject2 = this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    ContactsTroopAdapter.b(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter);
    if (ContactsTroopAdapter.a(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter))
    {
      ContactsTroopAdapter.a(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter, false);
      ContactsTroopAdapter.c(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter);
    }
    for (;;)
    {
      if ((ContactsTroopAdapter.d(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter) instanceof PinnedHeaderExpandableListView))
      {
        localObject1 = (PinnedHeaderExpandableListView)ContactsTroopAdapter.e(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter);
        if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject1).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.size() != 1) {
        break;
      }
      ContactsTroopAdapter.a(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter).a(0);
      this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.get(0));
    }
    i = 0;
    label1332:
    if (i < this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter.jdField_a_of_type_JavaUtilList.get(i))) {
        break label1405;
      }
      ContactsTroopAdapter.b(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter).a(i);
    }
    for (;;)
    {
      i += 1;
      break label1332;
      break;
      label1405:
      ContactsTroopAdapter.c(this.jdField_a_of_type_Wrq.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */