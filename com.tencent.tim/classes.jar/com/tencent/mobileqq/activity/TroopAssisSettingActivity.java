package com.tencent.mobileqq.activity;

import abgi;
import acfd;
import acxw;
import aizp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import aqlz;
import ausj;
import auss;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.Switch;
import com.tencent.widget.XExpandableListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import vxt;
import vxu;
import vxv;
import vxw;
import vxx;
import vxy;

public class TroopAssisSettingActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public abgi a;
  protected acfd a;
  public aqlz a;
  protected XExpandableListView a;
  protected Runnable ea = new TroopAssisSettingActivity.1(this);
  public Map<String, Integer> hp;
  String mFrom;
  protected Handler mHandler = new vxt(this, Looper.getMainLooper());
  public List<String> rj;
  protected CompoundButton.OnCheckedChangeListener v = new vxu(this);
  
  public TroopAssisSettingActivity()
  {
    this.jdField_a_of_type_Acfd = new vxy(this);
  }
  
  private View aN()
  {
    Object localObject1 = l();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2131559027, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2131559477, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addHeaderView((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addFooterView((View)localObject2);
    localObject1 = (TroopManager)this.app.getManager(52);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).cE();; localObject1 = null)
    {
      this.rj = new ArrayList();
      if (localObject1 != null)
      {
        localObject2 = this.app.a().a();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          this.rj.add(localTroopInfo.troopuin);
          if (this.app.cs(localTroopInfo.troopuin) == 2) {
            localTroopInfo.lastMsgTime = this.app.b().a(localTroopInfo.troopuin, 1).time;
          } else {
            localTroopInfo.lastMsgTime = ((acxw)localObject2).a(localTroopInfo.troopuin, 1).lastmsgtime;
          }
        }
      }
      this.jdField_a_of_type_Abgi = new abgi(this, this.app, (List)localObject1, null);
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_Abgi);
      initList();
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(true);
      ThreadManager.post(this.ea, 8, null, true);
      return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
    }
  }
  
  private void bKG()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  @TargetApi(8)
  private void initList()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnItemClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new vxw(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new vxx(this));
  }
  
  private View l()
  {
    View localView = View.inflate(this, 2131559476, null);
    localView.findViewById(2131378299).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131378298);
    ((Switch)localObject).setChecked(aizp.a().aqd());
    ((Switch)localObject).setOnCheckedChangeListener(this.v);
    localObject = (TextView)localView.findViewById(2131379248);
    if (aizp.a().aZ(this.app)) {
      aizp.a().dm(this.app);
    }
    for (int i = 2131694519;; i = 2131694518)
    {
      ((TextView)localObject).setText(i);
      ((TextView)localObject).setFocusable(true);
      return localView;
    }
  }
  
  void aQ()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.b();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.bl();
        if (i <= 0) {
          break label112;
        }
        if (i <= 99) {
          break label68;
        }
        this.leftView.setText(getString(2131720735) + "(99+)");
      }
    }
    return;
    label68:
    this.leftView.setText(getString(2131720735) + "(" + i + ")");
    return;
    label112:
    this.leftView.setText(getString(2131720735));
  }
  
  public void bWo()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Abgi.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.expandGroup(i);
      i += 1;
    }
  }
  
  public void d(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramTroopInfo != null)
    {
      localObject = (Boolean)this.jdField_a_of_type_Aqlz.jb.get(paramTroopInfo.troopuin);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {}
    }
    else
    {
      return;
    }
    ausj localausj = (ausj)auss.a(this, null);
    int i = ((Integer)this.hp.get(paramTroopInfo.troopuin)).intValue();
    if (TextUtils.isEmpty(paramTroopInfo.getTroopName()))
    {
      localObject = paramTroopInfo.troopuin;
      localausj.setMainTitle(getString(2131720791, new Object[] { localObject }));
      if (i != 1) {
        break label216;
      }
      bool1 = true;
      label114:
      localausj.addRadioButton(2131699863, bool1);
      if (i != 4) {
        break label221;
      }
      bool1 = true;
      label130:
      localausj.addRadioButton(2131699868, bool1);
      if (i != 2) {
        break label226;
      }
      bool1 = true;
      label146:
      localausj.addRadioButton(2131699864, bool1);
      if (i != 3) {
        break label231;
      }
    }
    label216:
    label221:
    label226:
    label231:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localausj.addRadioButton(2131699860, bool1);
      localausj.addCancelButton(getString(2131721058));
      localausj.a(new vxv(this, i, paramTroopInfo, localausj));
      localausj.show();
      return;
      localObject = paramTroopInfo.getTroopName();
      break;
      bool1 = false;
      break label114;
      bool1 = false;
      break label130;
      bool1 = false;
      break label146;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(aN());
    setContentBackgroundResource(2130838900);
    setTitle(2131694516);
    addObserver(this.jdField_a_of_type_Acfd);
    this.app.b().addObserver(this);
    this.mFrom = getIntent().getStringExtra("from");
    if ((this.mFrom != null) && (this.mFrom.equals("conversation"))) {
      aQ();
    }
    this.jdField_a_of_type_Aqlz = ((aqlz)this.app.getManager(31));
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (this.app.b() != null)) {
      this.app.b().deleteObserver(this);
    }
  }
  
  public void doOnPause()
  {
    bKG();
    super.doOnPause();
  }
  
  public void finish()
  {
    removeObserver(this.jdField_a_of_type_Acfd);
    super.finish();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new TroopAssisSettingActivity.8(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */