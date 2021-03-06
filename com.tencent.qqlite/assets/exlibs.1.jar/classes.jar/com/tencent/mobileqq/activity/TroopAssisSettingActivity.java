package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import blo;
import blp;
import blq;
import blr;
import bls;
import blt;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XExpandableListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class TroopAssisSettingActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new blo(this);
  public TroopMessageSettingAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bls(this);
  private XExpandableListView jdField_a_of_type_ComTencentWidgetXExpandableListView;
  public String a;
  public List a;
  public Map a;
  
  private View d()
  {
    ArrayList localArrayList = null;
    Object localObject1 = e();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2130903113, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2130903220, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.b((View)localObject2);
    localObject1 = (ContactFacade)this.app.getManager(46);
    if (localObject1 != null) {
      localArrayList = ((ContactFacade)localObject1).a("-1003");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (localArrayList != null)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(((TroopInfo)localObject2).troopuin);
      }
    }
    this.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.app, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter = new TroopMessageSettingAdapter(this, this.app, localArrayList, this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter);
    f();
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setHeaderDividersEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(false);
    return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
  }
  
  private View e()
  {
    View localView = View.inflate(this, 2130903219, null);
    localView.findViewById(2131297235).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131297236);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131297237);
    if (TroopAssistantManager.a().d(this.app)) {
      TroopAssistantManager.a().g(this.app);
    }
    for (int i = 2131363865;; i = 2131363864)
    {
      ((TextView)localObject).setText(i);
      ((TextView)localObject).setFocusable(true);
      return localView;
    }
  }
  
  private void e()
  {
    if (this.app != null)
    {
      Handler localHandler = this.app.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.app.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  @TargetApi(8)
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnItemClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new blq(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new blr(this));
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624120);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
    int j = DBUtils.a().a(paramTroopInfo.troopuin, this.app);
    String str2 = getString(2131363869, new Object[] { StringUtil.a(getBaseContext(), j) });
    String str1;
    if (TextUtils.isEmpty(paramTroopInfo.troopname))
    {
      str1 = paramTroopInfo.troopuin;
      localActionSheet.a(getString(2131363868, new Object[] { str1 }));
      localActionSheet.b(str2);
      if (i != 1) {
        break label217;
      }
      bool1 = true;
      label126:
      localActionSheet.a(2131362534, bool1);
      if (i != 2) {
        break label223;
      }
      bool1 = true;
      label144:
      localActionSheet.a(2131362535, bool1);
      if (i != 3) {
        break label229;
      }
    }
    label217:
    label223:
    label229:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localActionSheet.a(2131362536, bool1);
      localActionSheet.d(getString(2131362801));
      localActionSheet.a(new blp(this, i, paramTroopInfo, localActionSheet));
      localActionSheet.show();
      return;
      str1 = paramTroopInfo.troopname;
      break;
      bool1 = false;
      break label126;
      bool1 = false;
      break label144;
    }
  }
  
  public void c()
  {
    int i;
    if (this.h != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.e();
        if (i <= 0) {
          break label124;
        }
        if (i <= 99) {
          break label80;
        }
        this.h.setText(getString(2131362957) + "(" + "99+" + ")");
      }
    }
    return;
    label80:
    this.h.setText(getString(2131362957) + "(" + i + ")");
    return;
    label124:
    this.h.setText(getString(2131362957));
  }
  
  public void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.c(i);
      i += 1;
    }
  }
  
  public void finish()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(d());
    d(2130837660);
    setTitle(2131363859);
    d();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      c();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  protected void onPause()
  {
    e();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new blt(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */