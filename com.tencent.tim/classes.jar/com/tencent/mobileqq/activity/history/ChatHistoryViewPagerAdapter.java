package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.CustomFragmentStatePagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zer;
import zgs;
import zgs.a;
import ziy;

public class ChatHistoryViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements ContactsBaseFragment.a
{
  private zer jdField_a_of_type_Zer;
  private zgs jdField_a_of_type_Zgs;
  private ArrayList<zgs.a> iM = new ArrayList();
  private BaseActivity mActivity;
  private String mUin;
  protected ArrayList<ChatHistoryBaseFragment> rD = new ArrayList();
  
  public ChatHistoryViewPagerAdapter(FragmentManager paramFragmentManager, BaseActivity paramBaseActivity, zer paramzer, zgs paramzgs, String paramString)
  {
    super(paramFragmentManager);
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_Zer = paramzer;
    this.jdField_a_of_type_Zgs = paramzgs;
    this.iM.clear();
    this.iM.addAll(this.jdField_a_of_type_Zgs.mList);
    this.mUin = paramString;
  }
  
  private zgs.a a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.iM.size())) {
      return (zgs.a)this.iM.get(paramInt);
    }
    return null;
  }
  
  private ChatHistoryBaseFragment b(int paramInt)
  {
    int i = 0;
    while (i < this.rD.size())
    {
      ChatHistoryBaseFragment localChatHistoryBaseFragment = (ChatHistoryBaseFragment)this.rD.get(i);
      if ((localChatHistoryBaseFragment != null) && (localChatHistoryBaseFragment.yf() == paramInt)) {
        return localChatHistoryBaseFragment;
      }
      i += 1;
    }
    return null;
  }
  
  private int fz(int paramInt)
  {
    int i = 0;
    while (i < this.iM.size())
    {
      if (((zgs.a)this.iM.get(i)).mId == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void ER(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "remove fragment cache :" + paramInt);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = b(paramInt);
    if (localChatHistoryBaseFragment != null)
    {
      localChatHistoryBaseFragment.doOnDestroy();
      this.rD.remove(localChatHistoryBaseFragment);
    }
  }
  
  public void Fm(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "doOnResume:" + paramInt);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.doOnResume();
    }
  }
  
  public ChatHistoryBaseFragment a(int paramInt, boolean paramBoolean)
  {
    zgs.a locala = a(paramInt);
    Object localObject1 = null;
    if (locala != null)
    {
      Object localObject2 = b(locala.mId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = ziy.a(locala.mId);
          ((ChatHistoryBaseFragment)localObject1).setActivity(this.mActivity);
          ((ChatHistoryBaseFragment)localObject1).setApp(this.mActivity.app);
          ((ChatHistoryBaseFragment)localObject1).setPos(paramInt);
          ((ChatHistoryBaseFragment)localObject1).setUin(this.mUin);
          ((ChatHistoryBaseFragment)localObject1).Fe(locala.mId);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_Zer);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("should_restore_from_kill", false);
          ((ChatHistoryBaseFragment)localObject1).setArguments((Bundle)localObject2);
          this.rD.add(localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = " + this.rD.size());
    }
    int i = 0;
    while (i < this.rD.size())
    {
      ChatHistoryBaseFragment localChatHistoryBaseFragment = (ChatHistoryBaseFragment)this.rD.get(i);
      if (localChatHistoryBaseFragment != null) {
        localChatHistoryBaseFragment.doOnDestroy();
      }
      i += 1;
    }
    this.rD.clear();
  }
  
  public void fZ(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "onPageSelected. curPos:" + paramInt1 + " prePos:" + paramInt2);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt1, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.pH(true);
    }
    localChatHistoryBaseFragment = a(paramInt2, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.pH(false);
    }
  }
  
  public int getCount()
  {
    return this.iM.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt, true);
  }
  
  public int getItemPosition(Object paramObject)
  {
    QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition " + paramObject);
    paramObject = (ContactsBaseFragment)paramObject;
    if (paramObject != null)
    {
      int i = fz(paramObject.xY());
      if (i >= 0)
      {
        if (paramObject.xZ() == i)
        {
          QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition newPos" + i + " oldPos:" + paramObject.xZ());
        paramObject.setPos(i);
        return i;
      }
    }
    QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
  
  public void sx(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "doOnPause:" + paramInt);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.doOnPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */