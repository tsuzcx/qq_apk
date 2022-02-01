package com.tencent.mobileqq.activity.contacts.troop;

import abgc;
import abge;
import abge.a;
import abge.c;
import abge.e;
import accc;
import acdt;
import acdu;
import acfp;
import acnd;
import acxw;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import anov;
import aqcl;
import aqfp;
import ausj;
import auss;
import auvd.b;
import auve;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.c;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.c;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import wja;
import yzr.b;
import zam.a;
import zch.a;
import zci;
import zcj;
import zck;
import zcl;
import zcm;
import zcn;

public class ContactsTroopAdapter
  extends abgc
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.d, ExpandableListView.c, SwipPinnedHeaderExpandableListView.c
{
  protected auve a;
  protected HashSet<Integer> aJ = new HashSet(5);
  protected acdu b;
  public int bKH = -2;
  private boolean bqm = true;
  private int ccX;
  private int ccY;
  public int[] iY = new int[6];
  protected int[] iZ = new int[6];
  acnd j = new zcn(this);
  protected int[] ja = new int[6];
  public QQAppInterface mApp;
  public Context mContext;
  protected List<Integer> oW = new ArrayList(4);
  protected List<Entity> tI = new ArrayList();
  protected List<abge.e> tJ = new ArrayList();
  protected List<abge.e> tK = new ArrayList();
  protected List<abge.e> tL = new ArrayList();
  protected List<abge.e> tM = new ArrayList();
  protected List<abge.e> tN = new ArrayList();
  
  public ContactsTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.ccX = wja.dp2px(56.0F, paramContext.getResources());
    this.ccY = wja.dp2px(44.0F, paramContext.getResources());
    this.a = new zci(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296993) }, -1, new int[] { 2131371299, 2131371299 }, new int[] { 2131694514, 2131694512 }, new int[] { 2130839770, 2130839770 });
    this.mApp.addObserver(this.j);
    this.jdField_b_of_type_Acdu = ((acdu)paramQQAppInterface.getManager(53));
    this.jdField_b_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
  }
  
  private View D(int paramInt)
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131563253, null);
    TextView localTextView = (TextView)localView.findViewById(2131367488);
    String str = acfp.m(2131704450) + this.ja[paramInt] + ")";
    localTextView.setText(str);
    localView.setOnClickListener(new zcj(this, paramInt));
    localView.setOnTouchListener(new zck(this, localTextView));
    localView.setContentDescription(str + acfp.m(2131704423));
    return localView;
  }
  
  private void Fa(int paramInt)
  {
    int k = 0;
    if ((paramInt >= 0) && (paramInt < this.oW.size())) {}
    int i;
    label107:
    int m;
    switch (((Integer)this.oW.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      if (k <= 10)
      {
        this.iY[paramInt] = 3;
        if (k > 10) {
          break label286;
        }
        m = k;
      }
      break;
    }
    for (;;)
    {
      this.iZ[paramInt] = m;
      this.ja[paramInt] = (k - m);
      return;
      k = this.tI.size();
      this.iY[paramInt] = 3;
      i = 0;
      break;
      k = this.tJ.size();
      i = m(this.tJ);
      break;
      k = this.tK.size();
      i = m(this.tK);
      break;
      k = this.tL.size();
      i = m(this.tL);
      break;
      k = this.tM.size();
      i = m(this.tM);
      break;
      k = this.tN.size();
      i = m(this.tN);
      break;
      if (this.iY[paramInt] != 0) {
        break label107;
      }
      this.iY[paramInt] = 1;
      break label107;
      label286:
      m = i;
      if (i < 10) {
        m = 10;
      }
    }
  }
  
  private Entity a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.oW.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return null;
    case 0: 
      return (Entity)this.tI.get(paramInt2);
    case 4: 
      return ((abge.e)this.tJ.get(paramInt2)).d;
    case 6: 
      return ((abge.e)this.tK.get(paramInt2)).d;
    case 2: 
      return ((abge.e)this.tL.get(paramInt2)).d;
    case 8: 
      return ((abge.e)this.tM.get(paramInt2)).d;
    }
    return ((abge.e)this.tN.get(paramInt2)).d;
  }
  
  private void a(DiscussionInfo paramDiscussionInfo, zch.a parama, int paramInt1, int paramInt2, View paramView)
  {
    parama.uin = paramDiscussionInfo.uin;
    parama.item = paramDiscussionInfo;
    parama.type = 101;
    parama.uT.setVisibility(4);
    parama.uV.setVisibility(8);
    parama.uU.setVisibility(8);
    parama.BM.setText(paramDiscussionInfo.discussionName);
    int i = this.jdField_b_of_type_Acdu.cn(paramDiscussionInfo.uin);
    if ((!paramDiscussionInfo.hasRenamed()) && (i > 0))
    {
      parama.Mt.setVisibility(0);
      parama.Mt.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "DiscussionInfo hasRenamed:" + paramDiscussionInfo.hasRenamed() + " | memberNum:" + i + " | uin:" + paramDiscussionInfo.uin + "  discussionName:" + paramDiscussionInfo.discussionName);
      }
      if ((paramDiscussionInfo.lastMsgTime != 0L) || (AppSetting.enableTalkBack)) {
        parama.Lz.setContentDescription(parama.BM.getText());
      }
      a(parama, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, parama, this, paramDiscussionInfo);
      return;
      parama.Mt.setVisibility(8);
    }
  }
  
  private void a(TroopInfo paramTroopInfo, zch.a parama, int paramInt1, int paramInt2, View paramView)
  {
    parama.uin = paramTroopInfo.troopuin;
    parama.item = paramTroopInfo;
    parama.type = 4;
    parama.bqG = aB(paramInt1, paramInt2);
    int i = this.mApp.cs(paramTroopInfo.troopuin);
    String str;
    if (i == 3)
    {
      parama.uT.setVisibility(0);
      parama.uT.setImageResource(2130851446);
      TextView localTextView = parama.BM;
      if (TextUtils.isEmpty(paramTroopInfo.getTroopName())) {
        break label374;
      }
      str = paramTroopInfo.getTroopName();
      label88:
      localTextView.setText(str);
      if ((paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.wMemberNumClient <= 0)) {
        break label383;
      }
      parama.Mt.setVisibility(0);
      parama.Mt.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
      label144:
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "TroopInfo hasSetTroopName:" + paramTroopInfo.hasSetTroopName() + " | memberNum:" + paramTroopInfo.wMemberNumClient);
      }
      if ((paramTroopInfo.lastMsgTime == 0L) && ((paramTroopInfo.dwGroupFlagExt & 0x800) == 0L)) {
        break label437;
      }
      if (paramTroopInfo.dwAuthGroupType != 2L) {
        break label395;
      }
      parama.uV.setVisibility(0);
      parama.uV.setBackgroundResource(2130844648);
      label244:
      if (paramTroopInfo.troopCreditLevel != 2L) {
        break label449;
      }
      parama.uU.setVisibility(0);
      parama.uT.setVisibility(0);
      parama.uT.setImageResource(2130851449);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        parama.Lz.setContentDescription(parama.BM.getText());
      }
      a(parama, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, parama, this, paramTroopInfo);
      return;
      if (i == 1)
      {
        parama.uT.setVisibility(4);
        break;
      }
      parama.uT.setVisibility(0);
      parama.uT.setImageResource(2130839743);
      break;
      label374:
      str = paramTroopInfo.troopuin;
      break label88;
      label383:
      parama.Mt.setVisibility(8);
      break label144;
      label395:
      if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        parama.uV.setVisibility(0);
        parama.uV.setBackgroundResource(2130844648);
        break label244;
      }
      parama.uV.setVisibility(8);
      break label244;
      label437:
      parama.uV.setVisibility(8);
      break label244;
      label449:
      if (paramTroopInfo.troopCreditLevel == 1L)
      {
        parama.uU.setVisibility(0);
        parama.uT.setVisibility(0);
        parama.uT.setImageResource(2130851447);
      }
      else
      {
        parama.uU.setVisibility(4);
      }
    }
  }
  
  private void a(zam.a parama)
  {
    int m = 0;
    int i;
    if (this.oW.size() == 1)
    {
      i = 0;
      if (!this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i)) {
        break label100;
      }
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.aJ.remove(this.oW.get(i));
      i = m;
    }
    for (;;)
    {
      if (i >= this.iY.length) {
        return;
      }
      if (this.iY[i] == 2) {
        this.iY[i] = 1;
      }
      i += 1;
      continue;
      i = parama.aTO;
      break;
      label100:
      int k = 0;
      while (k < this.oW.size())
      {
        if (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(k))
        {
          this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(k);
          this.aJ.remove(this.oW.get(k));
        }
        k += 1;
      }
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
      this.aJ.add(this.oW.get(i));
      i = m;
    }
  }
  
  private void a(zam.a parama, int paramInt, boolean paramBoolean)
  {
    int i;
    String str1;
    int k;
    int m;
    label118:
    String str2;
    label132:
    label189:
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (parama != null)
    {
      if ((paramInt >= 0) && (paramInt < this.oW.size())) {}
      switch (((Integer)this.oW.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      default: 
        i = 0;
        str1 = "";
        k = 0;
        if (k <= 10)
        {
          m = k;
          if (k > 10) {
            break label609;
          }
          this.iY[paramInt] = 3;
          this.iZ[paramInt] = m;
          this.ja[paramInt] = (k - m);
          if (this.iY[paramInt] != 1) {
            break label632;
          }
          str2 = m + "/" + k;
          localStringBuilder1 = parama.H;
          localStringBuilder2 = localStringBuilder1;
          if (AppSetting.enableTalkBack)
          {
            if (localStringBuilder1 != null) {
              break label658;
            }
            localStringBuilder1 = new StringBuilder(24);
            label221:
            localStringBuilder1.append(str1 + " 分组");
            localStringBuilder2 = localStringBuilder1;
          }
          parama.aTO = paramInt;
          parama.n.setText(str1);
          parama.o.setVisibility(8);
          parama.k.setVisibility(8);
          parama.C.setVisibility(0);
          parama.c.setText(str2);
          if (AppSetting.enableTalkBack) {
            localStringBuilder2.append("共" + k + "个" + str1);
          }
          parama.C.setChecked(paramBoolean);
          if (AppSetting.enableTalkBack)
          {
            if (!parama.C.isChecked()) {
              break label673;
            }
            localStringBuilder2.append(" 已展开");
          }
        }
        break;
      }
    }
    for (;;)
    {
      parama.c.setContentDescription(localStringBuilder2.toString());
      aqcl.Q(parama.C, false);
      return;
      str1 = acfp.m(2131704462);
      k = this.tI.size();
      this.iY[paramInt] = 3;
      i = 0;
      break;
      str1 = acfp.m(2131716176);
      k = this.tJ.size();
      i = m(this.tJ);
      break;
      str1 = acfp.m(2131716179);
      k = this.tK.size();
      i = m(this.tK);
      break;
      str1 = acfp.m(2131716172);
      k = this.tL.size();
      i = m(this.tL);
      break;
      str1 = acfp.m(2131716177);
      k = this.tM.size();
      i = m(this.tM);
      break;
      str1 = acfp.m(2131704478);
      k = this.tN.size();
      i = m(this.tN);
      break;
      m = i;
      if (i >= 10) {
        break label118;
      }
      m = 10;
      break label118;
      label609:
      if (this.iY[paramInt] != 0) {
        break label132;
      }
      this.iY[paramInt] = 1;
      notifyDataSetChanged();
      break label132;
      label632:
      str2 = "" + k;
      break label189;
      label658:
      localStringBuilder1.delete(0, localStringBuilder1.length());
      break label221;
      label673:
      localStringBuilder2.append(" 已折叠");
    }
  }
  
  private void a(zch.a parama)
  {
    if ((parama.item instanceof DiscussionInfo))
    {
      a(parama, (DiscussionInfo)parama.item);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)parama.item;
    a(parama, localTroopInfo);
    aqfp.Sz(true);
    parama = wja.a(new Intent(this.mContext, SplashActivity.class), null);
    parama.putExtra("uin", localTroopInfo.troopuin);
    if (localTroopInfo.troopcode != null) {
      parama.putExtra("troop_uin", localTroopInfo.troopcode);
    }
    parama.putExtra("uintype", 1);
    parama.putExtra("uinname", localTroopInfo.getTroopName());
    parama.putExtra("open_chatfragment_withanim", true);
    parama.putExtra("isFromContactTab", true);
    this.mContext.startActivity(parama);
  }
  
  private void a(zch.a parama, DiscussionInfo paramDiscussionInfo)
  {
    aqfp.Sz(true);
    Intent localIntent = wja.a(new Intent(this.mContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.mContext.startActivity(localIntent);
    int i;
    switch (((Integer)this.oW.get(parama.ccW)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i) }).report();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private void a(zch.a parama, TroopInfo paramTroopInfo)
  {
    int i;
    int k;
    switch (((Integer)this.oW.get(parama.ccW)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      switch (this.mApp.cs(paramTroopInfo.troopuin))
      {
      default: 
        k = 0;
      }
      break;
    }
    for (;;)
    {
      if (parama.bqG) {
        new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).report();
      }
      anot.a(this.mApp, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(i), k + "", "");
      new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).report();
      if (i == 5) {
        new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramTroopInfo.troopuin }).report();
      }
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
      k = 0;
      continue;
      k = 2;
      continue;
      k = 3;
      continue;
      k = 1;
    }
  }
  
  private boolean aB(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 < this.iZ.length) && (paramInt2 > this.iZ[paramInt1]);
  }
  
  private void b(DiscussionInfo paramDiscussionInfo)
  {
    ausj localausj = (ausj)auss.a(this.mContext, null);
    acdt localacdt = (acdt)this.mApp.getBusinessHandler(6);
    boolean bool = localacdt.a(paramDiscussionInfo);
    if (bool) {}
    for (int i = 2131694512;; i = 2131694514)
    {
      localausj.addButton(i);
      localausj.addCancelButton(2131721058);
      localausj.a(new zcm(this, localacdt, paramDiscussionInfo, bool, localausj));
      try
      {
        localausj.show();
        return;
      }
      catch (Exception paramDiscussionInfo) {}
    }
  }
  
  private void b(zam.a parama)
  {
    a(parama);
    Fa(parama.aTO);
    if ((parama.aTO >= 0) && (parama.aTO < this.iY.length)) {
      if (this.oW.size() != 1) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = parama.aTO)
    {
      if ((this.iY[parama.aTO] == 1) && (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i)))
      {
        i = fB(parama.aTO);
        new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i) }).report();
      }
      return;
    }
  }
  
  private void cnw()
  {
    if (this.oW.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.aJ.add(this.oW.get(0));
      return;
    }
    Object localObject = this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    label170:
    int i;
    label172:
    int k;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_troop_expanded")) {
      if (this.oW.size() > 0)
      {
        localHashSet.add(this.oW.get(0));
        i = 0;
        if (i < this.oW.size()) {
          if (localHashSet.contains(this.oW.get(i)))
          {
            this.aJ.add(this.oW.get(i));
            if (this.oW.size() != 1) {
              break label430;
            }
            k = 0;
          }
        }
      }
    }
    for (;;)
    {
      if ((i > 0) && (i < this.iY.length)) {
        Fa(i);
      }
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
      if ((i < this.iY.length) && (this.iY[i] == 1) && (this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(k)))
      {
        k = fB(i);
        new anov(this.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(k) }).report();
      }
      i += 1;
      break label172;
      break;
      this.bqm = true;
      break label170;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label170;
      }
      localObject = ((String)localObject).split("_");
      k = localObject.length;
      i = 0;
      label397:
      if (i >= k) {
        break label170;
      }
      String str = localObject[i];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label423:
        i += 1;
        break label397;
        label430:
        k = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label423;
      }
    }
  }
  
  private void cnx()
  {
    if (this.oW.size() > 1)
    {
      localStringBuffer = new StringBuffer();
      localIterator = this.aJ.iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append((Integer)localIterator.next());
        localStringBuffer.append("_");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
      }
      this.mApp.getApp().getSharedPreferences(this.mApp.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
    }
    while (!QLog.isColorLevel())
    {
      StringBuffer localStringBuffer;
      Iterator localIterator;
      return;
    }
    QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
  }
  
  private void cod()
  {
    LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new LoadTroopDiscussInfoSubRunnable(null);
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.mApp.getManager(52));
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_Acxw = this.mApp.a().a();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  private void coe()
  {
    boolean bool = false;
    Object localObject = new abge.c();
    Collections.sort(this.tJ, (Comparator)localObject);
    Collections.sort(this.tK, (Comparator)localObject);
    Collections.sort(this.tL, (Comparator)localObject);
    Collections.sort(this.tM, (Comparator)localObject);
    Collections.sort(this.tN, (Comparator)localObject);
    if (!this.tI.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.oW.add(Integer.valueOf(0));
      }
      if (this.tM.size() > 0) {
        this.oW.add(Integer.valueOf(8));
      }
      if (this.tJ.size() > 0) {
        this.oW.add(Integer.valueOf(4));
      }
      if (this.tK.size() > 0) {
        this.oW.add(Integer.valueOf(6));
      }
      if (this.tL.size() > 0) {
        this.oW.add(Integer.valueOf(2));
      }
      if (this.tN.size() > 0) {
        this.oW.add(Integer.valueOf(10));
      }
      localObject = new HashSet(5);
      Iterator localIterator = this.aJ.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (this.oW.contains(localInteger)) {
          ((HashSet)localObject).add(localInteger);
        }
      }
    }
    this.aJ = ((HashSet)localObject);
    c(this);
    if (this.bqm)
    {
      this.bqm = false;
      cnw();
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
      {
        localObject = (PinnedHeaderExpandableListView)this.jdField_b_of_type_ComTencentWidgetExpandableListView;
        if (this.oW.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.oW.size() != 1) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.aJ.add(this.oW.get(0));
    }
    i = 0;
    label393:
    if (i < this.oW.size())
    {
      if (!this.aJ.contains(this.oW.get(i))) {
        break label442;
      }
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    }
    for (;;)
    {
      i += 1;
      break label393;
      break;
      label442:
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
    }
  }
  
  private void e(TroopInfo paramTroopInfo)
  {
    boolean bool = ((TroopManager)this.mApp.getManager(52)).kv(paramTroopInfo.troopuin);
    Object localObject1 = (accc)this.mApp.getBusinessHandler(22);
    int i;
    label62:
    Object localObject2;
    if (bool)
    {
      i = 1;
      if (((accc)localObject1).N(paramTroopInfo.troopcode, i))
      {
        if (!bool) {
          break label191;
        }
        localObject1 = "Clk_uncommgrp";
        anot.a(this.mApp, "P_CliOper", "Grp_set", "", "Grp_contactlist", (String)localObject1, 0, 0, paramTroopInfo.troopuin, "", "", "");
        localObject2 = new anov(this.mApp).a("dc00899").b("Grp_set").c("Grp_contactlist");
        if (!bool) {
          break label199;
        }
        localObject1 = "Clk_unstick";
        label138:
        localObject1 = ((anov)localObject2).d((String)localObject1);
        localObject2 = paramTroopInfo.troopuin;
        if (!paramTroopInfo.hasSetTroopHead()) {
          break label207;
        }
      }
    }
    label191:
    label199:
    label207:
    for (paramTroopInfo = "1";; paramTroopInfo = "0")
    {
      ((anov)localObject1).a(new String[] { localObject2, paramTroopInfo }).report();
      return;
      i = 0;
      break;
      localObject1 = "Clk_setcommgrp";
      break label62;
      localObject1 = "Clk_stick";
      break label138;
    }
  }
  
  private void f(TroopInfo paramTroopInfo)
  {
    ausj localausj = (ausj)auss.a(this.mContext, null);
    boolean bool = ((TroopManager)this.mApp.getManager(52)).kv(paramTroopInfo.troopuin);
    if (bool) {}
    for (int i = 2131694512;; i = 2131694514)
    {
      localausj.addButton(i);
      localausj.addCancelButton(2131721058);
      localausj.a(new zcl(this, bool, paramTroopInfo, localausj));
      try
      {
        localausj.show();
        return;
      }
      catch (Exception paramTroopInfo) {}
    }
  }
  
  private int fB(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.oW.size())) {
      return 0;
    }
    switch (((Integer)this.oW.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return 0;
    case 0: 
      return 0;
    case 4: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 10: 
      return 4;
    }
    return 5;
  }
  
  private int m(List<abge.e> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      abge.e locale = (abge.e)paramList.next();
      if ((locale.d == null) || (!(locale.d instanceof TroopInfo)) || (((TroopInfo)locale.d).lastMsgTime <= 0L)) {
        break label102;
      }
      i += 1;
    }
    label102:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "getActiveTroopCount activeTroopCount:" + i);
      }
      return i;
    }
  }
  
  public boolean O(View paramView)
  {
    return true;
  }
  
  public boolean Pw()
  {
    return true;
  }
  
  public void a(int paramInt, auvd.b[] paramArrayOfb, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfb.length < 0) {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.tI.contains(paramObject))
          {
            paramInt = 1;
            paramArrayOfb[0].dOf = paramInt;
            paramArrayOfb[0].dOe = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfb.length) {
          break label97;
        }
        paramArrayOfb[paramInt].dOf = -1;
        paramArrayOfb[paramInt].dOe = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(View paramView, int paramInt, yzr.b paramb, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.a != null) {}
    for (int i = this.a.a(this.mContext, paramView, paramInt, paramObject, paramb, paramOnClickListener);; i = 0)
    {
      if (this.bKH != -1)
      {
        if (paramInt != this.bKH) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, acxw paramacxw)
  {
    if (this.mApp.cs(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.mApp.b().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramacxw.a(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof zam.a)) {
      a((zam.a)paramExpandableListView);
    }
    return true;
  }
  
  public void al(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.EO(paramBoolean);
      return;
    }
  }
  
  public void cnv()
  {
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.5(this));
  }
  
  public void cof()
  {
    if (this.oW.size() <= 1) {
      return;
    }
    int i = 0;
    int k = this.oW.size();
    while (i < k)
    {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      i += 1;
    }
    this.aJ.clear();
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.bKH = i;
      return;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.mApp.removeObserver(this.j);
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView != null)
    {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(null);
      int k = this.jdField_b_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView = this.jdField_b_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null)
        {
          localView.setOnClickListener(null);
          localView.setOnLongClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.iY[paramInt1] == 1)) {
      paramViewGroup = D(paramInt1);
    }
    Object localObject;
    do
    {
      return paramViewGroup;
      if ((paramView == null) || (!(paramView.getTag() instanceof zch.a)))
      {
        localObject = LayoutInflater.from(this.mContext).inflate(2131563254, null);
        ((View)localObject).setMinimumHeight(this.ccX);
        paramViewGroup = new zch.a();
        paramView = this.a.a(this.mContext, (View)localObject, paramViewGroup, -1);
        paramViewGroup.Lz = ((View)localObject);
        paramViewGroup.BM = ((TextView)paramView.findViewById(2131379402));
        paramViewGroup.Mt = ((TextView)paramView.findViewById(2131379404));
        paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
        if ((paramViewGroup.pQ instanceof ThemeImageView)) {
          ((ThemeImageView)paramViewGroup.pQ).setSupportMaskView(false);
        }
        paramViewGroup.uU = ((ImageView)paramView.findViewById(2131371159));
        paramViewGroup.uT = ((ImageView)paramView.findViewById(2131378715));
        paramViewGroup.Mu = ((TextView)paramView.findViewById(2131372035));
        paramViewGroup.uV = ((ImageView)paramView.findViewById(2131380238));
        localObject = paramView.getResources().getColorStateList(2131167311);
        paramViewGroup.BM.setTextColor((ColorStateList)localObject);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.ccW = paramInt1;
        localObject = a(paramInt1, paramInt2);
        if ((localObject == null) || (!(localObject instanceof TroopInfo))) {
          break;
        }
        a((TroopInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
        paramViewGroup = (zch.a)paramView.getTag();
      }
      if ((localObject != null) && ((localObject instanceof DiscussionInfo)))
      {
        a((DiscussionInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
      }
      paramViewGroup = paramView;
    } while (!QLog.isColorLevel());
    QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + localObject + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt >= this.oW.size()))
    {
      i = 0;
      return i;
    }
    switch (((Integer)this.oW.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      int k = i;
      if (this.iY[paramInt] == 1)
      {
        k = i;
        if (this.iZ[paramInt] < i) {
          k = this.iZ[paramInt] + 1;
        }
      }
      i = k;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount count:" + k + "  groupPosition:" + paramInt);
      return k;
      i = this.tI.size();
      this.iY[paramInt] = 3;
      continue;
      i = this.tJ.size();
      continue;
      i = this.tK.size();
      continue;
      i = this.tL.size();
      continue;
      i = this.tM.size();
      continue;
      i = this.tN.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount mGroups.size():" + this.oW.size());
    }
    return this.oW.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559068, paramViewGroup, false);
      paramViewGroup = new zam.a();
      paramViewGroup.n = ((SingleLineTextView)paramView.findViewById(2131368187));
      paramViewGroup.n.setDefaultTextColor(-8355712);
      paramViewGroup.C = ((CheckBox)paramView.findViewById(2131369742));
      paramViewGroup.c = ((SimpleTextView)paramView.findViewById(2131365243));
      paramViewGroup.c.setDefaultTextColor(1711276032);
      paramViewGroup.k = ((ProgressBar)paramView.findViewById(2131369847));
      paramViewGroup.o = ((SingleLineTextView)paramView.findViewById(2131380888));
      paramView.setTag(paramViewGroup);
    }
    while (this.oW.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (zam.a)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.ccY));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.mApp, false)) {
      paramViewGroup.c.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this);
      return paramView;
      ColorStateList localColorStateList = this.mContext.getResources().getColorStateList(2131167383);
      paramViewGroup.c.setTextColor(localColorStateList);
    }
  }
  
  public int gj()
  {
    return 2131559068;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hi() {}
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void j(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (this.oW.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof zam.a))
    {
      localObject = new zam.a();
      ((zam.a)localObject).C = ((CheckBox)paramView.findViewById(2131369742));
      ((zam.a)localObject).n = ((SingleLineTextView)paramView.findViewById(2131368187));
      ((zam.a)localObject).n.setDefaultTextColor(-8355712);
      ((zam.a)localObject).o = ((SingleLineTextView)paramView.findViewById(2131380888));
      ((zam.a)localObject).c = ((SimpleTextView)paramView.findViewById(2131365243));
      ((zam.a)localObject).c.setDefaultTextColor(1711276032);
      ((zam.a)localObject).k = ((ProgressBar)paramView.findViewById(2131369847));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.mApp, false)) {
        break label180;
      }
      paramView.c.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
      paramView = (zam.a)paramView.getTag();
      break;
      label180:
      localObject = this.mContext.getResources().getColorStateList(2131167383);
      paramView.c.setTextColor((ColorStateList)localObject);
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (((TroopManager)this.mApp.getManager(52)).eq == null)
    {
      ThreadManager.postImmediately(new ContactsTroopAdapter.4(this), null, false);
      return;
    }
    cod();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof zam.a)) {
      b((zam.a)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof zch.a)) {
        a((zch.a)localObject);
      } else if ((localObject instanceof TroopInfo)) {
        e((TroopInfo)localObject);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    HeaderScrollView localHeaderScrollView = null;
    while ((localViewParent != null) && (localHeaderScrollView == null)) {
      if ((localViewParent instanceof HeaderScrollView)) {
        localHeaderScrollView = (HeaderScrollView)localViewParent;
      } else if ((localViewParent instanceof View)) {
        localViewParent = ((View)localViewParent).getParent();
      } else {
        localViewParent = null;
      }
    }
    if ((localHeaderScrollView != null) && (localHeaderScrollView.bpY)) {
      return false;
    }
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof yzr.b)))
    {
      paramView = ((yzr.b)paramView).item;
      if (paramView != null) {
        if ((paramView instanceof TroopInfo)) {
          f((TroopInfo)paramView);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (!(paramView instanceof DiscussionInfo)) {
        break;
      }
      b((DiscussionInfo)paramView);
      break;
    }
  }
  
  public void pause()
  {
    cnx();
  }
  
  public void resetData()
  {
    this.bqm = true;
    this.aJ.clear();
    notifyDataSetChanged();
  }
  
  class LoadTroopDiscussInfoSubRunnable
    implements Runnable
  {
    acxw jdField_a_of_type_Acxw;
    TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
    
    private LoadTroopDiscussInfoSubRunnable() {}
    
    public void run()
    {
      TroopManager localTroopManager = (TroopManager)ContactsTroopAdapter.this.mApp.getManager(52);
      acxw localacxw = ContactsTroopAdapter.this.mApp.a().a();
      ArrayList localArrayList1 = localTroopManager.cE();
      Object localObject = ((acdu)ContactsTroopAdapter.this.mApp.getManager(53)).getDiscussList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        int j = i;
        if (localDiscussionInfo != null)
        {
          j = i;
          if (!TextUtils.isEmpty(localDiscussionInfo.uin))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactsTroopAdapter", 2, "load data asyncLoadTroopListAndNotifyUi discussion : " + localDiscussionInfo);
            }
            if (!TextUtils.isEmpty(localDiscussionInfo.discussionName)) {
              localArrayList2.add(localDiscussionInfo);
            }
          }
        }
        for (;;)
        {
          break;
          if (i >= 40)
          {
            localArrayList2.add(localDiscussionInfo);
          }
          else if (ContactsTroopAdapter.this.b.cn(localDiscussionInfo.uin) > 0)
          {
            localArrayList2.add(localDiscussionInfo);
            i += 1;
          }
          else
          {
            j = i + 1;
            QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + localDiscussionInfo);
            i = j;
          }
        }
      }
      QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i + "  org_discussions.size:" + ((List)localObject).size() + "  discussions.size:" + localArrayList2.size());
      localObject = new ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable(ContactsTroopAdapter.this, null);
      ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).jdField_a_of_type_ComTencentMobileqqAppTroopManager = localTroopManager;
      ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).jdField_a_of_type_Acxw = localacxw;
      ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).ry = localArrayList1;
      ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).tO = localArrayList2;
      ThreadManager.getUIHandler().post((Runnable)localObject);
    }
  }
  
  class UpdateAfterLoadDataUIRunnable
    implements Runnable
  {
    acxw jdField_a_of_type_Acxw;
    TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
    ArrayList<Entity> ry;
    List<DiscussionInfo> tO;
    
    private UpdateAfterLoadDataUIRunnable() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "load data troopListInfo.size: " + this.ry.size() + " discussions.size:" + this.tO.size());
      }
      ContactsTroopAdapter.this.oW.clear();
      ContactsTroopAdapter.this.tJ.clear();
      ContactsTroopAdapter.this.tL.clear();
      ContactsTroopAdapter.this.tK.clear();
      ContactsTroopAdapter.this.tI.clear();
      ContactsTroopAdapter.this.tN.clear();
      ContactsTroopAdapter.this.tM.clear();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.eg();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getCommonlyUsedTroopList troops size= ");
        if (localObject1 != null)
        {
          i = ((List)localObject1).size();
          QLog.d("ContactsTroopAdapter", 2, i);
        }
      }
      else
      {
        if (localObject1 == null) {
          break label327;
        }
        Collections.sort((List)localObject1, new abge.a());
        localObject1 = ((List)localObject1).iterator();
      }
      Object localObject3;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label327;
        }
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject3 != null)
        {
          ContactsTroopAdapter.this.a((TroopInfo)localObject3, this.jdField_a_of_type_Acxw);
          ContactsTroopAdapter.this.tI.add(localObject3);
          continue;
          i = 0;
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactsTroopAdapter", 2, "findTroopInfo troopInfo==null item.troopUin:" + ((CommonlyUsedTroop)localObject2).troopUin);
        }
      }
      label327:
      int i = ContactsTroopAdapter.this.tI.size();
      localObject1 = ContactsTroopAdapter.this.mApp.getCurrentUin();
      Object localObject2 = this.ry.iterator();
      label602:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopInfo)((Iterator)localObject2).next();
        ContactsTroopAdapter.this.a((TroopInfo)localObject3, this.jdField_a_of_type_Acxw);
        int j = abge.fS(ContactsTroopAdapter.this.mApp.cs(((TroopInfo)localObject3).troopuin));
        if (((TroopInfo)localObject3).isQidianPrivateTroop())
        {
          ContactsTroopAdapter.this.tN.add(new abge.e(j, (Entity)localObject3));
        }
        else
        {
          if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(localObject1)))) {
            ContactsTroopAdapter.this.tJ.add(new abge.e(j, (Entity)localObject3));
          }
          for (;;)
          {
            if (((TroopInfo)localObject3).hasSetTroopName()) {
              break label602;
            }
            ContactsTroopAdapter.this.tM.add(new abge.e(j, (Entity)localObject3));
            break;
            if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
              ContactsTroopAdapter.this.tK.add(new abge.e(j, (Entity)localObject3));
            } else {
              ContactsTroopAdapter.this.tL.add(new abge.e(j, (Entity)localObject3));
            }
          }
        }
      }
      localObject1 = this.tO.iterator();
      label788:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_Acxw.a(((DiscussionInfo)localObject2).uin, 3000);
        ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
        if (((RecentUser)localObject3).showUpTime != 0L) {
          ContactsTroopAdapter.this.tI.add(localObject2);
        }
        if (ContactsTroopAdapter.this.mApp.getCurrentUin().equals(((DiscussionInfo)localObject2).ownerUin)) {
          ContactsTroopAdapter.this.tJ.add(new abge.e(1, (Entity)localObject2));
        }
        for (;;)
        {
          if (((DiscussionInfo)localObject2).hasRenamed()) {
            break label788;
          }
          ContactsTroopAdapter.this.tM.add(new abge.e(1, (Entity)localObject2));
          break;
          ContactsTroopAdapter.this.tL.add(new abge.e(1, (Entity)localObject2));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "mSetTopTroopList size1= " + i + " size2:" + ContactsTroopAdapter.this.tI.size());
      }
      ContactsTroopAdapter.b(ContactsTroopAdapter.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter
 * JD-Core Version:    0.7.0.1
 */