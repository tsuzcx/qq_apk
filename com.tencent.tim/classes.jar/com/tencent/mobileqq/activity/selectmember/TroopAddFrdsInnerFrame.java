package com.tencent.mobileqq.activity.selectmember;

import aayk;
import aayl;
import abdw;
import abeg.a;
import acfd;
import acff;
import acfp;
import acms;
import acnd;
import aldj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aptw;
import apuh;
import apwn;
import aqgv;
import aqiw;
import asgx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import wja;

public class TroopAddFrdsInnerFrame
  extends SelectMemberInnerFrame
  implements Handler.Callback, View.OnClickListener, SelectMemberActivity.a, IndexView.a, PinnedDividerListView.b, AbsListView.e
{
  private static int bLR = 1000;
  protected static double bx = 10.0D;
  public static int cmB;
  public static int cmC = 1;
  protected TextView Gl;
  long MS = 0L;
  TextView OL;
  public Long U;
  acfd jdField_a_of_type_Acfd = new aayk(this);
  b jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b;
  private String aKI;
  int[] ad = new int[0];
  private EditText aw;
  acnd jdField_b_of_type_Acnd = new aayl(this);
  private TroopInfo jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
  private IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  boolean bBh = false;
  Set<String> bD = new HashSet();
  boolean bbq = false;
  String beF = "";
  private String beG;
  protected double bw = 0.0D;
  PinnedDividerListView c;
  private int cmA;
  int cmD = cmC;
  int cmx = 0;
  int cmy = 0;
  int cmz = 0;
  TroopManager f;
  acff i;
  Map<String, List<TroopMemberInfo>> iL = Collections.synchronizedMap(new LinkedHashMap());
  protected RelativeLayout iV;
  String[] k = new String[0];
  public Handler mHandler;
  protected ProgressBar mProgressBar;
  private int mSceneType;
  public Handler mSubHandler;
  private String mTroopName;
  public String mTroopUin;
  private View se;
  
  public TroopAddFrdsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Bh(String paramString)
  {
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = this.f.b(paramString);
      str = "0";
      if (localObject != null) {
        str = ((TroopInfo)localObject).troopcode;
      }
      if ((str != null) && (str.length() > 0))
      {
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label91;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.hg();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131693404), 0).show(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mTitleBar.getHeight());
      }
    }
    return;
    label91:
    this.bbq = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    Object localObject = (acms)this.e.getBusinessHandler(20);
    this.MS = System.currentTimeMillis();
    ((acms)localObject).a(true, paramString, str, true, 7, this.MS, 0);
  }
  
  public static void a(Context paramContext, TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = aqgv.h(localQQAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
    int m = 16;
    int j = m;
    if ((paramContext instanceof Activity))
    {
      int n = ((Activity)paramContext).getIntent().getIntExtra("batch_addfrd_scene_type", 0);
      j = m;
      if (n != 0) {
        j = apwn.jT(n);
      }
    }
    paramString = AddFriendLogicActivity.a(paramContext, 1, paramTroopMemberInfo.memberuin, paramString, 3004, j, str, null, null, null, null);
    paramString.putExtra("need_result_uin", true);
    paramString.putExtra("select_multi_mode", paramBoolean);
    paramString.putExtra("troop_uin", paramTroopMemberInfo.troopuin);
    ((Activity)paramContext).startActivityForResult(paramString, 11);
    ThreadManager.post(new TroopAddFrdsInnerFrame.6(paramBoolean, localQQAppInterface, paramTroopMemberInfo), 5, null, true);
  }
  
  private void aa(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (aptw)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(203);
    Object localObject2 = (asgx)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(165);
    boolean bool = apuh.f(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin());
    int n;
    Object localObject3;
    label110:
    List localList;
    int m;
    label134:
    int j;
    if ((!apuh.g(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin())) && (!bool))
    {
      n = 1;
      localObject3 = paramMap.values().iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label267;
      }
      localList = (List)((Iterator)localObject3).next();
      m = 0;
      if (m < localList.size())
      {
        if (localList.get(m) != null) {
          break label182;
        }
        localList.remove(m);
        j = m - 1;
      }
    }
    for (;;)
    {
      m = j + 1;
      break label134;
      break label110;
      n = 0;
      break;
      label182:
      if (((asgx)localObject2).sM(((TroopMemberInfo)localList.get(m)).memberuin))
      {
        localList.remove(m);
        j = m - 1;
      }
      else
      {
        j = m;
        if (n != 0)
        {
          j = m;
          if (((aptw)localObject1).gM(((TroopMemberInfo)localList.get(m)).memberuin))
          {
            localList.remove(m);
            j = m - 1;
          }
        }
      }
    }
    label267:
    localObject1 = new HashMap();
    localObject2 = paramMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (((List)paramMap.get(localObject3)).size() == 0) {
        ((Map)localObject1).put(localObject3, Integer.valueOf(1));
      }
    }
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramMap.remove((String)((Iterator)localObject1).next());
    }
  }
  
  private void au(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.iV.setVisibility(8);
    if (paramMessage.length == 3)
    {
      this.iL = ((Map)paramMessage[0]);
      this.ad = ((int[])paramMessage[1]);
      this.k = ((String[])paramMessage[2]);
      this.OL.setVisibility(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.iL = Collections.synchronizedMap(new LinkedHashMap());
      this.ad = new int[0];
      this.k = new String[0];
      this.OL.setVisibility(0);
    }
  }
  
  private int bZ(String paramString)
  {
    boolean bool2 = this.i.isFriend(paramString);
    boolean bool1 = false;
    if (!bool2) {
      bool1 = this.i.kd(paramString);
    }
    if (bool2) {
      return 4;
    }
    if (bool1) {
      return 3;
    }
    return 2;
  }
  
  private void cAn()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin(), this.mTroopUin }), 0L);
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.e.getManager(52)).b(this.mTroopUin);
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.cmx = (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum - 1);
      if (this.cmx > 0)
      {
        this.bw = 0.0D;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
      }
    }
    if (l == 0L)
    {
      Bh(this.mTroopUin);
      return;
    }
    TroopAddFrdsInnerFrame.3 local3 = new TroopAddFrdsInnerFrame.3(this);
    this.e.execute(local3);
  }
  
  private Object[] e()
  {
    Object localObject1 = this.iL.keySet().iterator();
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) && (QLog.isColorLevel())) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "sortMembers: mTroopInfo not exist");
    }
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.iL.get(localObject2), new c(null));
    }
    localObject1 = this.iL;
    this.iL = Collections.synchronizedMap(new LinkedHashMap());
    if (this.cmD == cmB)
    {
      for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
        if (((Map)localObject1).get(String.valueOf(c1)) != null) {
          this.iL.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
        }
      }
      if (((Map)localObject1).get("#") != null) {
        this.iL.put("#", ((Map)localObject1).get("#"));
      }
      ((Map)localObject1).clear();
    }
    for (;;)
    {
      localObject1 = new int[this.iL.keySet().size()];
      localObject2 = new String[this.iL.keySet().size()];
      localIterator = this.iL.keySet().iterator();
      if (localObject1.length != 0) {
        break;
      }
      return new Object[0];
      if (this.cmD == cmC)
      {
        j = 1;
        while (j < 5)
        {
          if (((Map)localObject1).get(String.valueOf(j)) != null) {
            this.iL.put(String.valueOf(j), ((Map)localObject1).get(String.valueOf(j)));
          }
          j += 1;
        }
        ((Map)localObject1).clear();
      }
    }
    localObject1[0] = 0;
    int j = 1;
    while (j < localObject1.length)
    {
      int m = localObject1[j];
      int n = localObject1[(j - 1)];
      localObject1[j] = (((List)this.iL.get(localIterator.next())).size() + n + 1 + m);
      j += 1;
    }
    Iterator localIterator = this.iL.keySet().iterator();
    j = 0;
    while (localIterator.hasNext())
    {
      localObject2[j] = ((String)localIterator.next());
      j += 1;
    }
    return new Object[] { this.iL, localObject1, localObject2 };
  }
  
  private void initUI()
  {
    this.c = ((PinnedDividerListView)findViewById(2131364452));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369142));
    if (this.cmD == cmB)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    }
    for (;;)
    {
      this.c.setSelector(2131167595);
      this.c.setOnLayoutListener(this);
      this.OL = ((TextView)findViewById(2131380823));
      this.iV = ((RelativeLayout)findViewById(2131380335));
      this.mProgressBar = ((ProgressBar)findViewById(2131368614));
      this.Gl = ((TextView)findViewById(2131370818));
      this.se = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity).inflate(2131563007, this.c, false);
      this.se.findViewById(2131363801).setVisibility(8);
      this.aw = ((EditText)this.se.findViewById(2131366542));
      this.aw.setFocusableInTouchMode(false);
      this.aw.setCursorVisible(false);
      this.aw.setOnClickListener(this);
      this.c.addHeaderView(this.se);
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  private void z(String paramString, List<TroopMemberInfo> paramList)
  {
    Object localObject;
    label118:
    ArrayList localArrayList;
    String str;
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (paramList != null) {
          break;
        }
        localObject = this.e.a().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (!QLog.isColorLevel()) {
          break label441;
        }
        localObject = new StringBuilder().append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=").append(paramString).append(",");
        if (paramList != null) {
          break label198;
        }
        j = 0;
        QLog.d("TroopMemberListInnerFrame.thread", 2, j);
      }
      finally {}
      localObject = Collections.synchronizedMap(new LinkedHashMap());
      localArrayList = new ArrayList();
      ((TroopManager)this.e.getManager(52)).c(this.mTroopUin);
      str = this.e.getCurrentAccountUin();
      if (paramList != null) {
        break label274;
      }
      paramString = this.mHandler.obtainMessage(3);
      this.mHandler.sendMessage(paramString);
      continue;
      label198:
      j = paramList.size();
    }
    label274:
    int m;
    int n;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getTroopMemberFromDB, troopuin=").append(paramString).append(",");
      if (paramList == null) {}
      for (j = 0;; j = paramList.size())
      {
        QLog.d("TroopMemberListInnerFrame.thread", 2, j);
        break;
      }
      m = paramList.size();
      this.cmx = (m - 1);
      if (m > 0)
      {
        n = m / bLR;
        if (m % bLR != 0) {
          break label452;
        }
      }
    }
    label441:
    label450:
    label452:
    for (int j = 0;; j = 1)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(j + n);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + localAtomicInteger.get());
      }
      for (;;)
      {
        if (j >= m) {
          break label450;
        }
        ThreadManager.post(new TroopAddFrdsInnerFrame.4(this, paramList, j, Math.min(bLR + j - 1, m), paramString, str, (Map)localObject, localArrayList, localAtomicInteger), 8, null, false);
        j += bLR;
        continue;
        paramString = this.mHandler.obtainMessage(3);
        this.mHandler.sendMessage(paramString);
        break;
        break label118;
        break label118;
        j = 0;
      }
      break;
    }
  }
  
  public void Bg(String paramString)
  {
    TroopMemberInfo localTroopMemberInfo = null;
    Iterator localIterator = this.iL.keySet().iterator();
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (List)this.iL.get(localObject);
      j = 0;
      label58:
      if (j >= ((List)localObject).size()) {
        break label130;
      }
      if (paramString.equals(((TroopMemberInfo)((List)localObject).get(j)).memberuin)) {
        localTroopMemberInfo = (TroopMemberInfo)((List)localObject).get(j);
      }
    }
    label130:
    for (;;)
    {
      break;
      j += 1;
      break label58;
      if (localTroopMemberInfo != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, localTroopMemberInfo, this.aKI, true);
      }
      return;
    }
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.c.setSelection(0);
    }
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b.m(paramString);
    } while (j == -1);
    this.c.setSelection(j + this.c.getHeaderViewsCount());
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(24, 1048576, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void b(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (paramResultRecord != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b.c(paramResultRecord, paramBoolean);
    }
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.bbq = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.bVm();
    this.mTroopUin = paramBundle.getString("group_uin");
    this.mTroopName = paramBundle.getString("group_name");
    this.aKI = paramBundle.getString("param_groupcode");
    this.beG = paramBundle.getString("batch_addfrd_recommand_uin");
    if (((this.mTroopName == null) || (this.mTroopName.length() == 0)) && (this.mTroopUin != null) && (this.mTroopUin.length() > 0) && (this.f != null))
    {
      paramBundle = this.f.b(this.mTroopUin);
      if (paramBundle != null) {
        this.mTroopName = paramBundle.getTroopName();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAO) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, "", this.mTroopName);
    }
    for (;;)
    {
      this.iV.setVisibility(8);
      if ((this.mTroopUin == null) || (this.mTroopUin.length() <= 0)) {
        break label282;
      }
      if (this.mTroopUin.equals(this.beF)) {
        break;
      }
      this.iL = Collections.synchronizedMap(new LinkedHashMap());
      this.ad = new int[0];
      this.k = new String[0];
      notifyDataSetChanged();
      this.OL.setVisibility(8);
      cAn();
      this.c.setSelection(0);
      this.beF = this.mTroopUin;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, acfp.m(2131715510), this.mTroopName);
    }
    notifyDataSetChanged();
    return;
    label282:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.finish();
  }
  
  public void bp(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!this.bBh)
      {
        paramBoolean2 = true;
        this.bBh = paramBoolean2;
      }
    }
    else
    {
      if (!this.bBh) {
        break label78;
      }
      this.c.removeHeaderView(this.se);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b.vG.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XG();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b.Dl(this.bBh);
      return;
      paramBoolean2 = false;
      break;
      label78:
      this.c.addHeaderView(this.se);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    label512:
    int j;
    int m;
    label730:
    String str;
    int n;
    switch (paramMessage.what)
    {
    default: 
    case 9: 
    case 10: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
    case 6: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return false;
                  } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
                  paramMessage = (List)paramMessage.obj;
                  this.bD.addAll(paramMessage);
                } while (this.mSubHandler.hasMessages(10));
                this.mSubHandler.sendEmptyMessageDelayed(10, 300L);
                return false;
              } while (this.bD.size() <= 0);
              paramMessage = new HashMap(this.bD.size());
              localObject1 = this.bD.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                paramMessage.put(localObject2, Integer.valueOf(bZ((String)localObject2)));
              }
              this.bD.clear();
              localObject1 = this.mHandler.obtainMessage(7);
              ((Message)localObject1).obj = paramMessage;
              ((Message)localObject1).sendToTarget();
              return false;
              au(paramMessage);
              return false;
              this.bw += bx;
            } while ((this.bw >= 90.0D) || (this.cmx <= 0));
            if (this.iV.getVisibility() == 8) {
              this.iV.setVisibility(0);
            }
            this.mProgressBar.setProgress((int)this.bw);
            this.Gl.setText(String.format(acfp.m(2131715508), new Object[] { Integer.valueOf(Math.min((int)(this.cmx * this.bw / 100.0D), this.cmx)), Integer.valueOf(this.cmx) }));
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4), 800L);
            return false;
            this.cmA = paramMessage.arg1;
            this.mHandler.removeMessages(4);
            if (!(paramMessage.obj instanceof Object[])) {
              break label512;
            }
            localObject1 = (Object[])paramMessage.obj;
            if (localObject1.length <= 0) {
              break label512;
            }
            localObject2 = (String)localObject1[1];
            if (((String)localObject2).equals(this.mTroopUin)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + (String)localObject2 + "," + this.mTroopUin);
          return false;
          this.iL = ((Map)localObject1[0]);
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + this.iL.size());
          }
          aa(this.iL);
          paramMessage.obj = e();
          au(paramMessage);
          return false;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
        paramMessage = (List)paramMessage.obj;
        localObject1 = (acms)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getBusinessHandler(20);
        this.U = Long.valueOf(System.currentTimeMillis());
        ((acms)localObject1).a(this.mTroopUin, paramMessage, 0, this.U, 0, false);
        return false;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HashMap)));
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = this.iL.keySet().iterator();
      j = 0;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label827;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (List)this.iL.get(localObject2);
        m = 0;
        if (m >= ((List)localObject2).size()) {
          break label1034;
        }
        str = ((TroopMemberInfo)((List)localObject2).get(m)).memberuin;
        n = j;
        if (!paramMessage.containsKey(str)) {
          break;
        }
        j += 1;
        n = ((Integer)paramMessage.get(str)).intValue();
        ((TroopMemberInfo)((List)localObject2).get(m)).commonFrdCnt = n;
        n = j;
      } while (j >= paramMessage.size());
    }
    label1031:
    label1034:
    for (;;)
    {
      m += 1;
      j = n;
      break label730;
      label827:
      notifyDataSetChanged();
      return false;
      this.c.setSelectionFromTop(0, 0);
      return false;
      if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HashMap))) {
        break;
      }
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = this.iL.keySet().iterator();
      j = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (List)this.iL.get(localObject2);
        n = 0;
        label928:
        if (n >= ((List)localObject2).size()) {
          break label1031;
        }
        str = ((TroopMemberInfo)((List)localObject2).get(n)).memberuin;
        m = j;
        if (paramMessage.containsKey(str))
        {
          m = j + 1;
          j = ((Integer)paramMessage.get(str)).intValue();
          ((TroopMemberInfo)((List)localObject2).get(n)).addState = j;
        }
        if (m >= paramMessage.size()) {
          j = m;
        }
      }
      for (;;)
      {
        break;
        n += 1;
        j = m;
        break label928;
        notifyDataSetChanged();
        return false;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b.notifyDataSetChanged();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10) && (paramIntent != null) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("VERIFY_MSG");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.dx();
          FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getBusinessHandler(1);
          paramInt1 = apwn.jS(this.mSceneType);
          localFriendListHandler.a(this.mTroopUin, this.aKI, (String)localObject, paramIntent, true, 3093, paramInt1);
          localObject = this.mSubHandler.obtainMessage(9);
          ((Message)localObject).obj = paramIntent;
          ((Message)localObject).sendToTarget();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bp(true, false);
          this.mHandler.removeMessages(8);
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(8), 120L);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719506), 0).show();
          notifyDataSetChanged();
          localObject = this.mTroopUin;
        } while (TextUtils.isEmpty((CharSequence)localObject));
        ThreadManager.post(new TroopAddFrdsInnerFrame.5(this, (String)localObject, paramIntent), 5, null, true);
        return;
      } while ((paramInt1 != 11) || (paramIntent == null) || (paramInt2 != -1));
      localObject = paramIntent.getStringExtra("uin");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramIntent = new ArrayList(1);
    paramIntent.add(localObject);
    if (this.bBh)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bp(true, false);
      this.mHandler.removeMessages(8);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(8), 120L);
    }
    Object localObject = this.mSubHandler.obtainMessage(9);
    ((Message)localObject).obj = paramIntent;
    ((Message)localObject).sendToTarget();
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
      Bundle localBundle = new Bundle();
      localBundle.putInt("batch_addfrd_scene_type", this.mSceneType);
      ContactSearchComponentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, null, this.mTroopUin, 23, 1048576, 561243, localBundle);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563053);
    this.f = ((TroopManager)this.e.getManager(52));
    this.i = ((acff)this.e.getManager(51));
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mSceneType = paramBundle.getInt("batch_addfrd_scene_type", 0);
    initUI();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b = new b();
    this.c.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b);
    this.c.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Acfd);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_b_of_type_Acnd);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$b.destroy();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mSubHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_Acfd);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_b_of_type_Acnd);
    super.onDestroy();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public String qN()
  {
    return this.mTroopUin;
  }
  
  public static class a
    extends abeg.a
  {
    public View Am;
    public View An;
    public TextView Gn;
    public TextView LF;
    public TextView OM;
    public TroopMemberInfo c;
    public Button er;
    public CheckBox mCheckBox;
    public TextView nickname;
    public TextView summary;
  }
  
  class b
    extends abdw
    implements View.OnClickListener
  {
    boolean aOc = false;
    acff j = (acff)TroopAddFrdsInnerFrame.this.e.getManager(51);
    public List<ResultRecord> vG = new ArrayList();
    
    public b()
    {
      super(TroopAddFrdsInnerFrame.this.e, TroopAddFrdsInnerFrame.this.c, true);
      TroopAddFrdsInnerFrame.this.cmy = TroopAddFrdsInnerFrame.this.a.getResources().getDimensionPixelOffset(2131298589);
      TroopAddFrdsInnerFrame.this.cmz = TroopAddFrdsInnerFrame.this.a.getResources().getDimensionPixelOffset(2131298590);
    }
    
    private boolean b(TroopMemberInfo paramTroopMemberInfo)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.vG.size())
        {
          ResultRecord localResultRecord = (ResultRecord)this.vG.get(i);
          if (TextUtils.equals(paramTroopMemberInfo.memberuin, localResultRecord.uin)) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
    }
    
    public void Dl(boolean paramBoolean)
    {
      this.aOc = paramBoolean;
      notifyDataSetChanged();
    }
    
    public int ag()
    {
      if (TroopAddFrdsInnerFrame.this.k.length > 0) {
        return 2131559496;
      }
      return 0;
    }
    
    public void b(View paramView, int paramInt)
    {
      Arrays.binarySearch(TroopAddFrdsInnerFrame.this.ad, paramInt);
    }
    
    public void c(ResultRecord paramResultRecord, boolean paramBoolean)
    {
      int i = 0;
      if (i < this.vG.size())
      {
        ResultRecord localResultRecord = (ResultRecord)this.vG.get(i);
        if (!TextUtils.equals(paramResultRecord.uin, localResultRecord.uin)) {}
      }
      for (;;)
      {
        if (paramBoolean) {
          if (i == -1)
          {
            this.vG.add(paramResultRecord);
            notifyDataSetChanged();
          }
        }
        while (i == -1)
        {
          return;
          i += 1;
          break;
        }
        this.vG.remove(i);
        notifyDataSetChanged();
        return;
        i = -1;
      }
    }
    
    public int getCount()
    {
      if ((TroopAddFrdsInnerFrame.this.ad == null) || (TroopAddFrdsInnerFrame.this.iL == null)) {}
      while (TroopAddFrdsInnerFrame.this.ad.length == 0) {
        return 0;
      }
      int i = TroopAddFrdsInnerFrame.this.ad[(TroopAddFrdsInnerFrame.this.ad.length - 1)];
      return ((List)TroopAddFrdsInnerFrame.this.iL.get(TroopAddFrdsInnerFrame.this.k[(TroopAddFrdsInnerFrame.this.k.length - 1)])).size() + i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      int i = Arrays.binarySearch(TroopAddFrdsInnerFrame.this.ad, paramInt);
      if (i >= 0) {
        return null;
      }
      i = -(i + 1) - 1;
      return (TroopMemberInfo)((List)TroopAddFrdsInnerFrame.this.iL.get(TroopAddFrdsInnerFrame.this.k[i])).get(paramInt - TroopAddFrdsInnerFrame.this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(TroopAddFrdsInnerFrame.this.ad, paramInt);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (paramView == null)
      {
        paramView = TroopAddFrdsInnerFrame.this.mLayoutInflater.inflate(2131561278, paramViewGroup, false);
        localObject1 = new TroopAddFrdsInnerFrame.a();
        ((TroopAddFrdsInnerFrame.a)localObject1).Am = paramView.findViewById(2131377207);
        ((TroopAddFrdsInnerFrame.a)localObject1).Am.setId(2131380240);
        localObject2 = paramView.findViewById(2131379115);
        localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131380240);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = wja.dp2px(10.0F, TroopAddFrdsInnerFrame.this.getResources());
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((TroopAddFrdsInnerFrame.a)localObject1).pQ = ((ImageView)paramView.findViewById(2131361802));
        ((TroopAddFrdsInnerFrame.a)localObject1).summary = ((TextView)paramView.findViewById(2131377214));
        ((TroopAddFrdsInnerFrame.a)localObject1).nickname = ((TextView)paramView.findViewById(2131372384));
        ((TroopAddFrdsInnerFrame.a)localObject1).OM = ((TextView)paramView.findViewById(2131378586));
        ((TroopAddFrdsInnerFrame.a)localObject1).er = ((Button)paramView.findViewById(2131377201));
        ((TroopAddFrdsInnerFrame.a)localObject1).LF = ((TextView)paramView.findViewById(2131377211));
        ((TroopAddFrdsInnerFrame.a)localObject1).mCheckBox = ((CheckBox)paramView.findViewById(2131364585));
        ((TroopAddFrdsInnerFrame.a)localObject1).Gn = ((TextView)paramView.findViewById(2131380761));
        ((TroopAddFrdsInnerFrame.a)localObject1).An = paramView.findViewById(2131374872);
        ((TroopAddFrdsInnerFrame.a)localObject1).Gn.setFocusableInTouchMode(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).An.setFocusableInTouchMode(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).Gn.setFocusable(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).An.setFocusable(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).Am.setDuplicateParentStateEnabled(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).er.setDuplicateParentStateEnabled(true);
        ((TroopAddFrdsInnerFrame.a)localObject1).LF.setDuplicateParentStateEnabled(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).er.setClickable(false);
        ((TroopAddFrdsInnerFrame.a)localObject1).summary.setPadding(0, wja.dp2px(2.0F, TroopAddFrdsInnerFrame.this.getResources()), 0, 0);
        if ((TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this) != null) && (TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this).getVisibility() == 0))
        {
          paramView.findViewById(2131380240).setPadding(0, 0, TroopAddFrdsInnerFrame.this.cmy, 0);
          paramView.setTag(localObject1);
        }
      }
      for (;;)
      {
        TroopAddFrdsInnerFrame.a locala = (TroopAddFrdsInnerFrame.a)paramView.getTag();
        label483:
        int m;
        label796:
        int k;
        label841:
        label980:
        boolean bool;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localObject3 = (TroopMemberInfo)((List)TroopAddFrdsInnerFrame.this.iL.get(TroopAddFrdsInnerFrame.this.k[i])).get(paramInt - TroopAddFrdsInnerFrame.this.ad[i] - 1);
          locala.c = ((TroopMemberInfo)localObject3);
          if (TroopAddFrdsInnerFrame.this.a.iX(((TroopMemberInfo)localObject3).memberuin))
          {
            locala.mCheckBox.setChecked(true);
            localObject1 = null;
            if (AppSetting.enableTalkBack)
            {
              localObject1 = new StringBuilder(256);
              ((StringBuilder)localObject1).append("群成员");
            }
            locala.An.setVisibility(0);
            locala.Gn.setVisibility(8);
            locala.pQ.setImageBitmap(getFaceBitmap(((TroopMemberInfo)localObject3).memberuin));
            Object localObject4 = aqgv.h(TroopAddFrdsInnerFrame.this.e, ((TroopMemberInfo)localObject3).troopuin, ((TroopMemberInfo)localObject3).memberuin);
            localObject2 = localObject4;
            if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).recommendRemark))
            {
              localObject2 = localObject4;
              if (!TextUtils.equals(((TroopMemberInfo)localObject3).recommendRemark, ((TroopMemberInfo)localObject3).memberuin))
              {
                localObject2 = localObject4;
                if (!TextUtils.equals(((TroopMemberInfo)localObject3).recommendRemark, (CharSequence)localObject4))
                {
                  localObject2 = localObject4;
                  if (!this.j.isFriend(((TroopMemberInfo)localObject3).memberuin)) {
                    localObject2 = (String)localObject4 + " (" + ((TroopMemberInfo)localObject3).recommendRemark + ")";
                  }
                }
              }
            }
            locala.nickname.setText((CharSequence)localObject2);
            locala.uin = ((TroopMemberInfo)localObject3).memberuin;
            locala.OM.setVisibility(8);
            if (AppSetting.enableTalkBack) {
              ((StringBuilder)localObject1).append((String)localObject2);
            }
            if (((TroopMemberInfo)localObject3).commonFrdCnt <= 0) {
              break label1117;
            }
            locala.summary.setText(TroopAddFrdsInnerFrame.this.getResources().getString(2131689912, new Object[] { Integer.valueOf(((TroopMemberInfo)localObject3).commonFrdCnt) }));
            locala.summary.setVisibility(0);
            if (AppSetting.enableTalkBack) {
              ((StringBuilder)localObject1).append(locala.summary.getText());
            }
            if (!this.aOc) {
              locala.An.setEnabled(true);
            }
            m = 0;
            k = 0;
            if (((TroopMemberInfo)localObject3).addState != 1) {
              break label1130;
            }
            i = TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this, ((TroopMemberInfo)localObject3).memberuin);
            if (i != 4) {
              break label1140;
            }
            locala.er.setVisibility(8);
            locala.LF.setVisibility(0);
            locala.LF.setText(acfp.m(2131715509));
            if (this.aOc)
            {
              locala.An.setEnabled(false);
              locala.mCheckBox.setEnabled(false);
              locala.mCheckBox.setChecked(false);
            }
            i = k;
            if (AppSetting.enableTalkBack)
            {
              locala.LF.setContentDescription(acfp.m(2131715511));
              i = k;
            }
            label942:
            localObject4 = locala.Am;
            if (i == 0) {
              break label1377;
            }
            localObject2 = localObject3;
            label958:
            ((View)localObject4).setTag(localObject2);
            localObject3 = locala.Am;
            if (i == 0) {
              break label1383;
            }
            localObject2 = this;
            ((View)localObject3).setOnClickListener((View.OnClickListener)localObject2);
            localObject2 = locala.Am;
            if (i == 0) {
              break label1389;
            }
            bool = true;
            label1002:
            ((View)localObject2).setClickable(bool);
            localObject2 = locala.mCheckBox;
            if (!this.aOc) {
              break label1395;
            }
            i = 0;
            label1026:
            ((CheckBox)localObject2).setVisibility(i);
            locala.An.setOnClickListener(this);
            locala.An.setTag(locala);
            if (AppSetting.enableTalkBack) {
              paramView.setContentDescription(((StringBuilder)localObject1).toString());
            }
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          paramView.findViewById(2131380240).setPadding(0, 0, TroopAddFrdsInnerFrame.this.cmz, 0);
          break;
          locala.mCheckBox.setChecked(false);
          break label483;
          label1117:
          locala.summary.setVisibility(8);
          break label796;
          label1130:
          i = ((TroopMemberInfo)localObject3).addState;
          break label841;
          label1140:
          if (i == 3)
          {
            locala.er.setVisibility(8);
            locala.LF.setVisibility(0);
            locala.LF.setText(acfp.m(2131715507));
            if (this.aOc)
            {
              locala.An.setEnabled(false);
              locala.mCheckBox.setEnabled(false);
              locala.mCheckBox.setChecked(false);
            }
            i = k;
            if (!AppSetting.enableTalkBack) {
              break label942;
            }
            locala.LF.setContentDescription(acfp.m(2131715506));
            i = k;
            break label942;
          }
          if (this.aOc)
          {
            locala.An.setEnabled(true);
            locala.er.setVisibility(8);
            locala.mCheckBox.setEnabled(true);
            locala.mCheckBox.setChecked(b((TroopMemberInfo)localObject3));
            locala.mCheckBox.setTag(locala);
            i = m;
          }
          for (;;)
          {
            locala.LF.setVisibility(8);
            break;
            locala.er.setVisibility(0);
            locala.er.setText(acfp.m(2131721053));
            k = 1;
            i = k;
            if (AppSetting.enableTalkBack)
            {
              locala.er.setContentDescription(acfp.m(2131721053));
              i = k;
            }
          }
          label1377:
          localObject2 = null;
          break label958;
          label1383:
          localObject2 = null;
          break label980;
          label1389:
          bool = false;
          break label1002;
          label1395:
          i = 8;
          break label1026;
          locala.An.setVisibility(8);
          if (TroopAddFrdsInnerFrame.this.cmD == TroopAddFrdsInnerFrame.cmB)
          {
            locala.Gn.setVisibility(0);
            localObject1 = String.valueOf(TroopAddFrdsInnerFrame.this.k[i]);
            locala.Gn.setText((CharSequence)localObject1);
            locala.Gn.setContentDescription(String.format(TroopAddFrdsInnerFrame.this.a.getString(2131692906), new Object[] { ((String)localObject1).toLowerCase() }));
          }
          else
          {
            locala.Gn.setVisibility(8);
            paramView.setBackgroundResource(0);
          }
        }
      }
    }
    
    public int m(String paramString)
    {
      int i;
      if (TroopAddFrdsInnerFrame.this.k != null)
      {
        i = 0;
        if (i >= TroopAddFrdsInnerFrame.this.k.length) {
          break label65;
        }
        if (!TroopAddFrdsInnerFrame.this.k[i].equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0)
        {
          return TroopAddFrdsInnerFrame.this.ad[i];
          i += 1;
          break;
        }
        return -1;
        return -1;
        label65:
        i = -1;
      }
    }
    
    public void onClick(View paramView)
    {
      Object localObject1 = paramView.getTag();
      if (localObject1 == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject2;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131374872: 
          if (this.aOc)
          {
            localObject1 = (TroopAddFrdsInnerFrame.a)localObject1;
            boolean bool = b(((TroopAddFrdsInnerFrame.a)localObject1).c);
            localObject2 = new ResultRecord();
            ((ResultRecord)localObject2).uin = ((TroopAddFrdsInnerFrame.a)localObject1).c.memberuin;
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(localObject2);
            if (!bool) {
              TroopAddFrdsInnerFrame.this.a.e(localArrayList, false);
            }
          }
        case 2131380240: 
          for (;;)
          {
            notifyDataSetChanged();
            break;
            localObject1 = (TroopMemberInfo)localObject1;
            TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this.a, (TroopMemberInfo)localObject1, TroopAddFrdsInnerFrame.b(TroopAddFrdsInnerFrame.this), false);
            break;
            TroopAddFrdsInnerFrame.this.a.Bd(((TroopAddFrdsInnerFrame.a)localObject1).c.memberuin);
            TroopAddFrdsInnerFrame.this.a.a((ResultRecord)localObject2, false);
            TroopAddFrdsInnerFrame.this.a.a.cz(false);
            TroopAddFrdsInnerFrame.this.a.cAc();
          }
          localObject1 = ((TroopAddFrdsInnerFrame.a)localObject1).c;
          localObject2 = new Intent(TroopAddFrdsInnerFrame.this.a, FriendProfileCardActivity.class);
          ((Intent)localObject2).putExtra("troopUin", ((TroopMemberInfo)localObject1).troopuin);
          ((Intent)localObject2).putExtra("memberUin", ((TroopMemberInfo)localObject1).memberuin);
          ((Intent)localObject2).putExtra("fromFlag", 1);
          ((Intent)localObject2).putExtra("selfSet_leftViewText", TroopAddFrdsInnerFrame.this.a.getString(2131721410));
          ((Intent)localObject2).putExtra("custom_leftbackbutton_name", TroopAddFrdsInnerFrame.this.a.getString(2131691039));
          aldj.a(TroopAddFrdsInnerFrame.this.a, TroopAddFrdsInnerFrame.this.e, (Intent)localObject2, 9);
        }
      }
    }
    
    public boolean t(int paramInt)
    {
      return Arrays.binarySearch(TroopAddFrdsInnerFrame.this.ad, paramInt) >= 0;
    }
  }
  
  class c
    implements Comparator<TroopMemberInfo>
  {
    private c() {}
    
    public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
    {
      int j = 0;
      int k = 0;
      int i;
      if (TroopAddFrdsInnerFrame.this.cmD == TroopAddFrdsInnerFrame.cmC)
      {
        i = paramTroopMemberInfo1.addState - paramTroopMemberInfo2.addState;
        if (i == 0) {
          if (paramTroopMemberInfo1.commonFrdCnt == -2147483648)
          {
            i = 0;
            if (paramTroopMemberInfo2.commonFrdCnt != -2147483648) {
              break label189;
            }
            j = 0;
            label56:
            if ((i != 0) || (j != 0) || (TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this) == null)) {
              break label257;
            }
            if ((!TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this).isTroopAdmin(paramTroopMemberInfo1.memberuin)) && (!TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this).isTroopOwner(paramTroopMemberInfo1.memberuin))) {
              break label252;
            }
            i = 1;
            label111:
            if (!TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this).isTroopAdmin(paramTroopMemberInfo2.memberuin))
            {
              j = k;
              if (!TroopAddFrdsInnerFrame.a(TroopAddFrdsInnerFrame.this).isTroopOwner(paramTroopMemberInfo2.memberuin)) {}
            }
            else
            {
              j = 1;
            }
            j -= i;
            i = j;
            if (j == 0) {
              i = Long.signum(paramTroopMemberInfo2.last_active_time - paramTroopMemberInfo1.last_active_time);
            }
          }
        }
      }
      for (;;)
      {
        return i;
        i = paramTroopMemberInfo1.commonFrdCnt;
        break;
        label189:
        j = paramTroopMemberInfo2.commonFrdCnt;
        break label56;
        return i;
        i = j;
        if (TroopAddFrdsInnerFrame.this.cmD == TroopAddFrdsInnerFrame.cmB)
        {
          i = j;
          if (paramTroopMemberInfo1 != null)
          {
            i = j;
            if (paramTroopMemberInfo1.displayedNamePinyinFirst != null)
            {
              i = j;
              if (paramTroopMemberInfo2 != null)
              {
                return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
                label252:
                i = 0;
                break label111;
                label257:
                i = j - i;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame
 * JD-Core Version:    0.7.0.1
 */