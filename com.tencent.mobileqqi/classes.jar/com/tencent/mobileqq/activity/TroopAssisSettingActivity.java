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
import doa;
import dob;
import doc;
import dod;
import doe;
import dof;
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
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new doa(this);
  public TroopMessageSettingAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new doe(this);
  private XExpandableListView jdField_a_of_type_ComTencentWidgetXExpandableListView;
  public String a;
  public List a;
  public Map a;
  
  private View c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = e();
    Object localObject2 = a().getLayoutInflater().inflate(2130903134, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2130903263, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.b((View)localObject2);
    localObject1 = (ContactFacade)this.b.getManager(49);
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
    this.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.b, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter = new TroopMessageSettingAdapter(this, this.b, localArrayList, this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter);
    g();
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(true);
    return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
  }
  
  private View e()
  {
    View localView = View.inflate(this, 2130903262, null);
    Object localObject = (Switch)localView.findViewById(2131231864);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131231865);
    if (TroopAssistantManager.a().d(this.b)) {
      TroopAssistantManager.a().g(this.b);
    }
    ((TextView)localObject).setText(2131563342);
    return localView;
  }
  
  private void f()
  {
    if (this.b != null)
    {
      Handler localHandler = this.b.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.b.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  @TargetApi(8)
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnItemClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new doc(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new dod(this));
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
    int j = DBUtils.a().a(paramTroopInfo.troopuin, this.b);
    String str2 = getString(2131561533, new Object[] { StringUtil.a(getBaseContext(), j) });
    String str1;
    if (TextUtils.isEmpty(paramTroopInfo.troopname))
    {
      str1 = paramTroopInfo.troopuin;
      localActionSheet.a(getString(2131561519, new Object[] { str1 }));
      localActionSheet.b(str2);
      if (i != 1) {
        break label232;
      }
      bool1 = true;
      label123:
      localActionSheet.a(2131560651, bool1);
      if (i != 4) {
        break label238;
      }
      bool1 = true;
      label141:
      localActionSheet.a(2131560652, bool1);
      if (i != 2) {
        break label244;
      }
      bool1 = true;
      label159:
      localActionSheet.a(2131560653, bool1);
      if (i != 3) {
        break label250;
      }
    }
    label232:
    label238:
    label244:
    label250:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localActionSheet.a(2131560654, bool1);
      localActionSheet.d(getString(2131561746));
      localActionSheet.a(new dob(this, i, paramTroopInfo, localActionSheet));
      localActionSheet.show();
      return;
      str1 = paramTroopInfo.troopname;
      break;
      bool1 = false;
      break label123;
      bool1 = false;
      break label141;
      bool1 = false;
      break label159;
    }
  }
  
  public void d()
  {
    int i;
    if (this.k != null)
    {
      QQMessageFacade localQQMessageFacade = this.b.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.f();
        if (i <= 0) {
          break label124;
        }
        if (i <= 99) {
          break label80;
        }
        this.k.setText(getString(2131561807) + "(" + "99+" + ")");
      }
    }
    return;
    label80:
    this.k.setText(getString(2131561807) + "(" + i + ")");
    return;
    label124:
    this.k.setText(getString(2131561807));
  }
  
  public void e()
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
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(c());
    j(2130837729);
    setTitle(2131562895);
    e();
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.b.a().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      d();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (this.b.a() != null)) {
      this.b.a().deleteObserver(this);
    }
  }
  
  protected void onPause()
  {
    f();
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
      runOnUiThread(new dof(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */