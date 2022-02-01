package com.tencent.mobileqq.activity;

import abel;
import abel.b;
import abel.c;
import acff;
import acfp;
import ahgg.a;
import ahgq;
import amsf.a;
import amxk;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdf;
import aqdj;
import aqha;
import aqla;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.ResultRecord.a;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import svx;
import uxa;
import uxb;
import uxc;
import uxd;
import uxe;
import uxf;
import uxg;
import wja;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  private TextView Dh;
  private TextView Di;
  private TextView Dj;
  private Dialog N;
  private abel.b jdField_a_of_type_Abel$b = new uxf(this);
  private abel jdField_a_of_type_Abel;
  private aqdf jdField_a_of_type_Aqdf;
  private SelectedAndSearchBar.b jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b = new uxd(this);
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private FrameLayout aS;
  private boolean aVZ;
  private int actionType;
  private acff jdField_b_of_type_Acff;
  private amsf.a jdField_b_of_type_Amsf$a = new uxe(this);
  private ContactSearchFragment jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private int bGP;
  private svx c;
  RelativeLayout fD;
  LinearLayout fY;
  private Map<String, ResultRecord> hi = new LinkedHashMap();
  private View kY;
  private Handler mHandler = new Handler();
  private InputMethodManager mImm;
  private TextView oq;
  private ImageView pW;
  
  private void AI(int paramInt)
  {
    int i = 561243;
    if (paramInt == 11) {
      i = 561245;
    }
    for (;;)
    {
      ContactSearchComponentActivity.b(this, null, paramInt, 1, i);
      return;
      if (paramInt == 6) {
        i = 561244;
      } else if (paramInt == 16) {
        i = 561251;
      } else if (paramInt == 18) {
        i = 561252;
      }
    }
  }
  
  private boolean E(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.hi.containsKey(R(paramString, paramInt));
  }
  
  private String R(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    String str = R(paramResultRecord.uin, paramResultRecord.lk());
    ResultRecord localResultRecord = (ResultRecord)this.hi.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.MO = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.hi.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramResultRecord, false);
      return false;
    }
    if (this.hi.size() == 9)
    {
      bNV();
      return false;
    }
    ResultRecord.a(paramResultRecord).MO = SystemClock.elapsedRealtime();
    this.hi.put(str, ResultRecord.a(paramResultRecord));
    bNR();
    paramResultRecord = new ArrayList(this.hi.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramResultRecord, true);
    return true;
  }
  
  @TargetApi(14)
  private void aC()
  {
    this.fY = ((LinearLayout)findViewById(2131377546));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
    {
      this.fY.setFitsSystemWindows(true);
      this.fY.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.fD = ((RelativeLayout)findViewById(2131377498));
    this.oq = ((TextView)findViewById(2131369627));
    this.oq.setText(acfp.m(2131706465));
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("isForConfessDirectFriendsTitle");
      if (!TextUtils.isEmpty(str)) {
        this.oq.setText(str);
      }
    }
    this.Di = ((TextView)findViewById(2131369579));
    if (this.bGP == 2)
    {
      this.Di.setVisibility(8);
      this.Dh = ((TextView)findViewById(2131369581));
      this.Dh.setVisibility(8);
      this.Dj = ((TextView)findViewById(2131369612));
      if (this.actionType != 6) {
        break label427;
      }
      this.Dj.setVisibility(0);
      this.Dj.setText(acfp.m(2131706464));
      this.Dj.setContentDescription(acfp.m(2131706466));
      this.Dj.setOnClickListener(this);
    }
    for (;;)
    {
      this.Dj.setMaxWidth(wja.dp2px(260.0F, getResources()));
      this.pW = ((ImageView)findViewById(2131369594));
      this.pW.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.pW);
      IphoneTitleBarActivity.setLayerType(this.Dh);
      if (AppSetting.enableTalkBack) {
        this.Di.setContentDescription(acfp.m(2131706454));
      }
      return;
      this.Di.setVisibility(0);
      this.Di.setOnClickListener(this);
      if (getIntent().getIntExtra("forward_type", 2147483647) == 23)
      {
        this.Di.setText(acfp.m(2131706467));
        this.Di.setMaxWidth(wja.dp2px(120.0F, getResources()));
        break;
      }
      if (this.actionType == 4)
      {
        this.Di.setText(acfp.m(2131706457));
        this.Di.setBackgroundResource(0);
        break;
      }
      this.Di.setText(2131691039);
      break;
      label427:
      if ((this.actionType != 4) && (this.actionType != 5))
      {
        this.Dj.setVisibility(0);
        this.Dj.setText(2131721058);
        this.Dj.setContentDescription(acfp.m(2131706463));
        this.Dj.setOnClickListener(this);
      }
    }
  }
  
  private void bNP()
  {
    if (this.app != null)
    {
      String str1 = this.app.getAccount();
      String str2 = this.app.getCurrentNickname();
      View localView = LayoutInflater.from(getActivity()).inflate(2131562959, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131368698);
      TextView localTextView = (TextView)localView.findViewById(2131379402);
      if (localImageView != null) {
        localImageView.setBackgroundDrawable(aqdj.a(this.app, 3, str1));
      }
      if (localTextView != null) {
        localTextView.setText(str2);
      }
      localView.setOnClickListener(new uxa(this));
      if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView != null) {
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(localView);
      }
    }
  }
  
  private void bNQ()
  {
    if (this.c == null) {
      this.c = svx.a(this, acfp.m(2131706455), "", 2131721058, 2131721079, new uxb(this), new uxc(this));
    }
    if (!this.c.isShowing())
    {
      this.c.show();
      eH(this.c.getEditText());
    }
  }
  
  private void bNR()
  {
    if (this.hi.isEmpty())
    {
      this.Dj.setText(acfp.m(2131706468));
      this.Dj.setClickable(false);
      this.Dj.setTextColor(855836698);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        this.Dj.setContentDescription(this.Dj.getText());
      }
      return;
      this.Dj.setText(String.format(acfp.m(2131706461), new Object[] { Integer.valueOf(this.hi.size()) }));
      this.Dj.setClickable(true);
      this.Dj.setTextColor(getResources().getColor(2131167311));
    }
  }
  
  private void bNS()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.setVisibility(0);
    this.Di.setVisibility(0);
    this.Di.setText("");
    this.jdField_a_of_type_Aqdf = new aqdf(this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Aqdf, this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Dj.getLayoutParams();
    localLayoutParams.height = wja.dp2px(29.0F, getResources());
    localLayoutParams.rightMargin = wja.dp2px(10.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      localLayoutParams.width = wja.dp2px(75.0F, getResources());
    }
    this.Dj.setLayoutParams(localLayoutParams);
    this.Dj.setPadding(wja.dp2px(7.0F, getResources()), 0, wja.dp2px(7.0F, getResources()), 0);
    this.Dj.setBackgroundResource(2130846112);
    this.Dj.setTextSize(1, 14.0F);
    this.Dj.setVisibility(0);
    this.Dj.setOnClickListener(this);
    bNR();
    if (AppSetting.enableTalkBack) {
      this.Dj.setContentDescription(this.Dj.getText());
    }
  }
  
  private void bNT()
  {
    this.mImm = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131377961));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.setVisibility(8);
  }
  
  private void bNU()
  {
    this.mImm.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVl();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVm();
    this.aS.setVisibility(8);
  }
  
  private void bNV()
  {
    if (this.N == null) {
      this.N = aqha.a(this, getString(2131701227), 0, 2131696701, null, new uxg(this));
    }
    if (!isFinishing()) {
      this.N.show();
    }
  }
  
  private void bNW()
  {
    if (this.jdField_a_of_type_Ahgq == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardFriendListActivity", 2, "forwardOption is null, return.");
      }
    }
    do
    {
      return;
      if (!this.hi.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ForwardFriendListActivity", 2, "forward2MultiTargets map is empty !");
    return;
    ArrayList localArrayList = new ArrayList(this.hi.values());
    Collections.sort(localArrayList, new ResultRecord.a());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_Ahgq.H(ahgg.a.R.intValue(), localBundle);
    this.jdField_a_of_type_Ahgq.cph();
  }
  
  private void cl(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = R(paramString, paramInt);
    this.hi.remove(paramString);
    bNR();
    paramString = new ArrayList(this.hi.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramString, true);
  }
  
  private void eG(View paramView)
  {
    Object localObject = (abel.c)paramView.getTag();
    if (localObject != null)
    {
      localObject = ((abel.c)localObject).item;
      if ((localObject != null) && ((localObject instanceof Friends)))
      {
        localObject = (Friends)localObject;
        if (((this.actionType != 1) && (this.actionType != 4) && (this.actionType != 3) && (this.actionType != 6) && (this.actionType != 7)) || (localObject == null)) {
          break label266;
        }
        if (this.bGP != 2) {
          break label199;
        }
        if (this.jdField_b_of_type_Acff.a(((Friends)localObject).uin) == null) {
          break label122;
        }
        QQToast.a(this, getString(2131701720), 0).show(getTitleBarHeight());
      }
    }
    return;
    label122:
    if (this.app.getCurrentUin().equals(((Friends)localObject).uin))
    {
      QQToast.a(this, getString(2131691261), 0).show(getTitleBarHeight());
      return;
    }
    paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
    paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("key_is_from_friendsforward_activity", true);
    startActivity(paramView);
    return;
    label199:
    paramView = new Intent();
    paramView.putExtras(getIntent().getExtras());
    paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
    paramView.putExtra("extraChooseFriendRemark", ((Friends)localObject).remark);
    setResult(-1, paramView);
    finish();
    return;
    label266:
    paramView = (TextView)paramView.findViewById(2131379402);
    if (paramView != null) {
      if (paramView.getText() != null) {
        paramView = paramView.getText().toString();
      }
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", ((Friends)localObject).uin);
      localBundle.putInt("uintype", 0);
      localBundle.putString("uinname", paramView);
      localBundle.putString("uinname", paramView);
      localBundle.putInt("chooseFriendFrom", aqla.at.intValue());
      if (getIntent() != null) {}
      for (boolean bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);; bool = false)
      {
        if (bool)
        {
          paramView = getIntent().getStringExtra("choose_friend_confirmTitle");
          localObject = getIntent().getStringExtra("choose_friend_confirmContent");
          localBundle.putBoolean("choose_friend_needConfirm", bool);
          localBundle.putString("choose_friend_confirmTitle", paramView);
          localBundle.putString("choose_friend_confirmContent", (String)localObject);
        }
        this.jdField_a_of_type_Ahgq.H(ahgg.a.S.intValue(), localBundle);
        return;
        paramView = null;
        break;
      }
      paramView = "Ta";
    }
  }
  
  private void eH(View paramView)
  {
    this.mHandler.post(new ForwardFriendListActivity.4(this, paramView));
  }
  
  private void eI(View paramView)
  {
    this.mHandler.post(new ForwardFriendListActivity.5(this, paramView));
  }
  
  private void eJ(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).b;
    if (E(paramView.uin, paramView.lk())) {
      cl(paramView.uin, paramView.lk());
    }
    for (;;)
    {
      this.jdField_a_of_type_Abel.notifyDataSetChanged();
      return;
      a(paramView);
    }
  }
  
  private void fQ(List<ResultRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ResultRecord)paramList.next());
      }
    }
  }
  
  private void initData()
  {
    Pu();
    if (this.aVZ) {
      fQ(getIntent().getParcelableArrayListExtra("selected_target_list"));
    }
  }
  
  private void initUI()
  {
    aC();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131367689));
    Object localObject = LayoutInflater.from(this);
    this.aS = ((FrameLayout)findViewById(2131377207));
    bNT();
    if (this.aVZ) {
      bNS();
    }
    for (;;)
    {
      if ((this.actionType == 6) || (this.actionType == 7)) {
        bNP();
      }
      return;
      this.kY = ((LayoutInflater)localObject).inflate(2131563007, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      this.kY.findViewById(2131363801).setVisibility(8);
      localObject = (EditText)this.kY.findViewById(2131366542);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(this.kY);
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(12.0F, getResources())));
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView((View)localObject);
    }
  }
  
  protected boolean Pu()
  {
    if (this.jdField_b_of_type_Acff == null) {
      this.jdField_b_of_type_Acff = ((acff)this.app.getManager(51));
    }
    if (!this.jdField_b_of_type_Acff.aae()) {
      return false;
    }
    ArrayList localArrayList1 = this.jdField_b_of_type_Acff.cr();
    ArrayList localArrayList2 = new ArrayList();
    Groups localGroups = new Groups();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      abel.GX(1003);
      localGroups.group_id = abel.zv();
      localGroups.group_name = acfp.m(2131706460);
      localArrayList2.add(0, localGroups);
      localArrayList2.addAll(localArrayList1);
      if (this.jdField_a_of_type_Abel != null) {
        break label183;
      }
      this.jdField_a_of_type_Abel = new abel(this, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, this.app, localArrayList2, this.jdField_a_of_type_Abel$b, this.aVZ);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Abel);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.expandGroup(0);
    }
    for (;;)
    {
      return true;
      abel.GX(0);
      localGroups.group_id = abel.zv();
      break;
      label183:
      this.jdField_a_of_type_Abel.ae(localArrayList2, true);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (getIntent() != null) {
            bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
          }
          if (bool)
          {
            localObject = getIntent().getStringExtra("choose_friend_confirmTitle");
            String str = getIntent().getStringExtra("choose_friend_confirmContent");
            paramIntent.putExtra("choose_friend_needConfirm", bool);
            paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject);
            paramIntent.putExtra("choose_friend_confirmContent", str);
          }
          amxk.a(paramIntent, this.jdField_a_of_type_Ahgq);
          return;
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("contactSearchResultUin");
        localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
        ((Intent)localObject).putExtra("key_friend_uin", paramIntent);
        ((Intent)localObject).putExtra("key_is_from_friendsforward_activity", true);
        startActivity((Intent)localObject);
        return;
      } while (paramIntent == null);
      localObject = new Intent();
      ((Intent)localObject).putExtras(getIntent().getExtras());
      ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
      ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultName"));
      setResult(-1, (Intent)localObject);
      finish();
      return;
    } while (paramIntent == null);
    Object localObject = new Intent();
    ((Intent)localObject).putExtras(getIntent().getExtras());
    ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
    ((Intent)localObject).putExtra("extraChooseFriendRemark", paramIntent.getStringExtra("contactSearchResultName"));
    ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultNick"));
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    setTheme(2131755343);
    this.bGP = getIntent().getIntExtra("extra_add_special_friend", 0);
    this.actionType = getIntent().getIntExtra("extra_choose_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    super.setContentView(2131559343);
    if (!getIntent().getBooleanExtra("only_single_selection", true)) {
      bool = true;
    }
    this.aVZ = bool;
    initUI();
    initData();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Abel != null)
    {
      this.jdField_a_of_type_Abel.destroy();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((PinnedHeaderExpandableListView.a)null);
    }
    if (this.c != null) {
      this.c.dismiss();
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.bGP == 2) || (this.actionType == 4))
    {
      overridePendingTransition(2130771989, 2130771990);
      return;
    }
    overridePendingTransition(0, 2130771990);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.aS.getVisibility() != 8)
    {
      bNU();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.QG()) {
      bNU();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.actionType == 1)
      {
        AI(11);
      }
      else if ((this.actionType == 3) || (this.actionType == 6) || (this.actionType == 7))
      {
        AI(16);
      }
      else if (this.actionType == 4)
      {
        AI(18);
      }
      else
      {
        AI(6);
        continue;
        if (this.aVZ)
        {
          Intent localIntent = new Intent();
          localIntent.putParcelableArrayListExtra("selected_target_list", new ArrayList(this.hi.values()));
          setResult(0, localIntent);
        }
        finish();
        continue;
        if (this.actionType == 6)
        {
          bNQ();
        }
        else if (this.aVZ)
        {
          bNW();
        }
        else
        {
          if (this.jdField_a_of_type_Ahgq != null)
          {
            this.jdField_a_of_type_Ahgq.Kp(false);
            com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
          }
          setResult(1);
          finish();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */