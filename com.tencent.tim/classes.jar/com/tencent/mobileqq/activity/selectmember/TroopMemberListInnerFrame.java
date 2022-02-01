package com.tencent.mobileqq.activity.selectmember;

import aagd;
import aayv;
import aayw;
import aayx;
import aayy;
import aayz;
import abdw;
import acfp;
import acms;
import acnd;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import apdg;
import apdg.a;
import aprg;
import aptw;
import apuh;
import aqcl;
import aqgv;
import aqha;
import aqho;
import aqiw;
import asgx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.TroopMemberListActivity.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.a, PinnedDividerListView.b
{
  private static int bLR = 1000;
  public static double bx = 10.0D;
  int CP = 1;
  public CheckBox F;
  public TextView Gl;
  long MS = 0L;
  TextView OL;
  public TextView OP;
  public TextView OQ;
  public b a;
  int[] ad = new int[0];
  List<TroopMemberInfo> at = new ArrayList();
  private acnd jdField_b_of_type_Acnd = new aayz(this);
  private TroopInfo jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
  private IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  public boolean bAF;
  boolean bBi = false;
  private boolean bBj;
  private boolean bBk = true;
  boolean bbq = false;
  String beF = "";
  public double bw = 0.0D;
  private int cmA;
  public int cmx = 0;
  TroopMemberInfo d;
  TroopManager g;
  PinnedDividerListView h;
  public Map<String, List<TroopMemberInfo>> iL = Collections.synchronizedMap(new LinkedHashMap());
  public RelativeLayout iT;
  public RelativeLayout iV;
  String[] k = new String[0];
  public Handler mHandler = new aayv(this);
  public ProgressBar mProgressBar;
  private String mTroopName;
  public String mTroopUin;
  
  public TroopMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Bh(String paramString)
  {
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = this.g.b(paramString);
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
      QLog.d("TroopMemberListInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    Object localObject = (acms)this.e.getBusinessHandler(20);
    this.MS = System.currentTimeMillis();
    ((acms)localObject).a(true, paramString, str, true, 7, this.MS, 0);
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.notifyDataSetChanged();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
      if (this.CP != 2) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.aN(bool, this.cmA);
      return;
      this.iL = Collections.synchronizedMap(new LinkedHashMap());
      this.ad = new int[0];
      this.k = new String[0];
      this.OL.setVisibility(0);
      break;
    }
  }
  
  private int b(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (aptw)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(203);
    Object localObject2 = (asgx)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(165);
    boolean bool = apuh.f(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin());
    int m;
    Object localObject3;
    if ((!apuh.g(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin())) && (!bool))
    {
      m = 1;
      localObject3 = paramMap.values().iterator();
    }
    List localList;
    for (int n = 0;; n = localList.size() + n)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label285;
      }
      localList = (List)((Iterator)localObject3).next();
      int j = 0;
      label137:
      if (j < localList.size())
      {
        int i;
        if (localList.get(j) == null)
        {
          localList.remove(j);
          i = j - 1;
        }
        for (;;)
        {
          j = i + 1;
          break label137;
          m = 0;
          break;
          if (((asgx)localObject2).sM(((TroopMemberInfo)localList.get(j)).memberuin))
          {
            localList.remove(j);
            i = j - 1;
          }
          else
          {
            i = j;
            if (m != 0)
            {
              i = j;
              if (((aptw)localObject1).gM(((TroopMemberInfo)localList.get(j)).memberuin))
              {
                localList.remove(j);
                i = j - 1;
              }
            }
          }
        }
      }
    }
    label285:
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
    return n;
  }
  
  private void bt(String paramString, boolean paramBoolean)
  {
    if ((this.iT != null) && (this.iT.getVisibility() == 0))
    {
      if ((paramString == null) || (paramBoolean) || (!this.F.isChecked())) {
        break label46;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.F.setChecked(paramBoolean);
      return;
      label46:
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.getCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label105;
        }
        paramString = (TroopMemberInfo)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.getItem(i);
        if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.iX(paramString.memberuin)))
        {
          paramBoolean = false;
          break;
        }
        i += 1;
      }
      label105:
      paramBoolean = true;
    }
  }
  
  private void cAn()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.e.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.mTroopUin, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "getTroopMembers, lastUpdateTime=" + l1 + ", curTime=" + l2 + ", diff=" + l3 + ", " + hashCode());
    }
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.e.getManager(52)).b(this.mTroopUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK != 21) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      this.cmx = (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum - 1);
      if (this.cmx > 0)
      {
        this.bw = 0.0D;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
      }
    }
    if ((l1 == 0L) || ((l1 > 0L) && (l3 > 300000L)))
    {
      Bh(this.mTroopUin);
      return;
    }
    TroopMemberListInnerFrame.4 local4 = new TroopMemberListInnerFrame.4(this);
    this.e.execute(local4);
  }
  
  /* Error */
  private Bitmap e(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 519	android/view/View:getWidth	()I
    //   4: istore_2
    //   5: aload_1
    //   6: invokevirtual 206	android/view/View:getHeight	()I
    //   9: istore_3
    //   10: iload_2
    //   11: ifeq +43 -> 54
    //   14: iload_3
    //   15: ifeq +39 -> 54
    //   18: iload_2
    //   19: iload_3
    //   20: getstatic 525	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 531	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore 4
    //   28: aload_1
    //   29: new 533	android/graphics/Canvas
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 536	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   38: invokevirtual 540	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   41: aload 4
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: areturn
    //   47: astore_1
    //   48: aconst_null
    //   49: areturn
    //   50: astore_1
    //   51: aload 4
    //   53: areturn
    //   54: aconst_null
    //   55: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	TroopMemberListInnerFrame
    //   0	56	1	paramView	View
    //   4	15	2	i	int
    //   9	11	3	j	int
    //   26	26	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	10	44	java/lang/Exception
    //   18	28	44	java/lang/Exception
    //   28	41	44	java/lang/Exception
    //   0	10	47	java/lang/OutOfMemoryError
    //   18	28	47	java/lang/OutOfMemoryError
    //   28	41	50	java/lang/OutOfMemoryError
  }
  
  private Object[] e()
  {
    Object localObject1 = this.iL.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.iL.get(localObject2), new a(null));
    }
    localObject1 = this.iL;
    this.iL = Collections.synchronizedMap(new LinkedHashMap());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAV) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bBa) && (this.d != null))
    {
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(this.d);
      this.iL.put(acfp.m(2131715950), localObject2);
    }
    for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
      if (((Map)localObject1).get(String.valueOf(c)) != null) {
        this.iL.put(String.valueOf(c), ((Map)localObject1).get(String.valueOf(c)));
      }
    }
    if (((Map)localObject1).get("#") != null) {
      this.iL.put("#", ((Map)localObject1).get("#"));
    }
    ((Map)localObject1).clear();
    localObject1 = new int[this.iL.keySet().size()];
    Object localObject2 = new String[this.iL.keySet().size()];
    Iterator localIterator = this.iL.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
    }
    localObject1[0] = 0;
    int i = 1;
    while (i < localObject1.length)
    {
      int j = localObject1[i];
      int m = localObject1[(i - 1)];
      localObject1[i] = (((List)this.iL.get(localIterator.next())).size() + m + 1 + j);
      i += 1;
    }
    localIterator = this.iL.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject2[i] = ((String)localIterator.next());
      i += 1;
    }
    return new Object[] { this.iL, localObject1, localObject2 };
  }
  
  private void initUI()
  {
    this.h = ((PinnedDividerListView)findViewById(2131364452));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369142));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.h.setSelector(2131167595);
    this.h.setOnLayoutListener(this);
    this.OL = ((TextView)findViewById(2131380823));
    this.iT = ((RelativeLayout)findViewById(2131377479));
    Object localObject1 = (LinearLayout)this.iT.findViewById(2131370731);
    this.F = ((CheckBox)findViewById(2131364357));
    ((LinearLayout)localObject1).setOnClickListener(this);
    this.iV = ((RelativeLayout)findViewById(2131380335));
    this.mProgressBar = ((ProgressBar)findViewById(2131368614));
    this.Gl = ((TextView)findViewById(2131370818));
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 21)
    {
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getWindow().getDecorView();
      this.OP = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-2, (int)aqho.convertDpToPixel(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 17.0F));
      this.OP.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int i = (int)aqho.convertDpToPixel(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 4.0F);
      this.OP.setPadding(i, 0, i, 0);
      this.OP.setTextColor(getResources().getColor(2131167363));
      this.OP.setTextSize(1, 12.0F);
      this.OP.setText(acfp.m(2131715903));
      localObject2 = apdg.a().a(301, false, false, true);
      if (localObject2 != null) {
        apdg.i(this.OP, ((apdg.a)localObject2).bgColor);
      }
      this.OP.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.OP);
      this.OQ = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localObject2 = new LinearLayout.LayoutParams(-2, (int)aqho.convertDpToPixel(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 17.0F));
      this.OQ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.OQ.setPadding(i, 0, i, 0);
      this.OQ.setTextColor(getResources().getColor(2131167363));
      this.OQ.setTextSize(1, 12.0F);
      this.OQ.setText(acfp.m(2131715947));
      localObject2 = apdg.a().a(300, false, true, false);
      if (localObject2 != null) {
        apdg.i(this.OQ, ((apdg.a)localObject2).bgColor);
      }
      this.OQ.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.OQ);
      this.OP.getViewTreeObserver().addOnGlobalLayoutListener(new aayw(this, (ViewGroup)localObject1));
      this.OQ.getViewTreeObserver().addOnGlobalLayoutListener(new aayx(this, (ViewGroup)localObject1));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mType == 9654) && (bL() != null)) {
      this.h.addHeaderView(bL());
    }
  }
  
  private void z(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        Object localObject = this.e.a().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=").append(paramString).append(",");
          TroopInfo localTroopInfo;
          String str;
          if (paramList == null)
          {
            i = 0;
            QLog.d("TroopMemberListInnerFrame.thread", 2, i);
            break label419;
            localObject = Collections.synchronizedMap(new LinkedHashMap());
            localTroopInfo = ((TroopManager)this.e.getManager(52)).c(this.mTroopUin);
            str = this.e.getCurrentAccountUin();
            if (paramList == null)
            {
              paramString = this.mHandler.obtainMessage(3);
              this.mHandler.sendMessage(paramString);
            }
          }
          else
          {
            i = paramList.size();
            continue;
            if (!QLog.isColorLevel()) {
              break label422;
            }
            localObject = new StringBuilder().append("getTroopMemberFromDB, troopuin=").append(paramString).append(",");
            if (paramList == null)
            {
              i = 0;
              QLog.d("TroopMemberListInnerFrame.thread", 2, i);
              break label422;
            }
            i = paramList.size();
            continue;
          }
          int j = paramList.size();
          this.cmx = (j - 1);
          if (j > 0)
          {
            int m = j / bLR;
            if (j % bLR != 0) {
              break label430;
            }
            i = 0;
            AtomicInteger localAtomicInteger = new AtomicInteger(i + m);
            if (!QLog.isColorLevel()) {
              break label425;
            }
            QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + localAtomicInteger.get());
            break label425;
            if (i < j)
            {
              ThreadManager.post(new TroopMemberListInnerFrame.5(this, paramList, i, Math.min(bLR + i - 1, j), paramString, str, localTroopInfo, (Map)localObject, localAtomicInteger), 8, null, false);
              i += bLR;
              continue;
            }
            continue;
          }
          paramString = this.mHandler.obtainMessage(3);
          this.mHandler.sendMessage(paramString);
          continue;
        }
        continue;
      }
      finally {}
      label419:
      label422:
      continue;
      label425:
      int i = 0;
      continue;
      label430:
      i = 1;
    }
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.h.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.m(paramString);
    } while (i == -1);
    this.h.setSelection(i + this.h.getHeaderViewsCount());
  }
  
  public ContactSearchFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK != 21) {
      return ContactSearchFragment.a(-1, 8192, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    }
    return ContactSearchFragment.a(-1, 262144, this.mTroopUin, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.h.getFirstVisiblePosition() > 0) || ((this.h.getFirstVisiblePosition() == 0) && (this.h.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.getCount() + this.h.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XH()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.bbq = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.bVm();
    this.mTroopUin = paramBundle.getString("group_uin");
    this.mTroopName = paramBundle.getString("group_name");
    this.CP = paramBundle.getInt("param_member_show_type", 1);
    this.bBj = paramBundle.getBoolean("param_set_all_select_selected", false);
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.iT;
    int i;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      if (((this.mTroopName == null) || (this.mTroopName.length() == 0)) && (this.mTroopUin != null) && (this.mTroopUin.length() > 0) && (this.g != null))
      {
        paramBundle = this.g.b(this.mTroopUin);
        if (paramBundle != null) {
          this.mTroopName = paramBundle.getTroopName();
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAO) {
        break label308;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, "", this.mTroopName);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_b_of_type_Acnd);
      this.iV.setVisibility(8);
      if ((this.mTroopUin != null) && (this.mTroopUin.length() > 0))
      {
        if (this.mTroopUin.equals(this.beF)) {
          break label325;
        }
        this.iL = Collections.synchronizedMap(new LinkedHashMap());
        this.ad = new int[0];
        this.k = new String[0];
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.notifyDataSetChanged();
        this.OL.setVisibility(8);
        this.bBi = false;
        cAn();
        this.h.setSelection(0);
        this.beF = this.mTroopUin;
      }
      return;
      i = 8;
      break;
      label308:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, "", this.mTroopName);
    }
    label325:
    this.bBi = true;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.notifyDataSetChanged();
    bt(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131364357 == paramCompoundButton.getId())
    {
      if (!paramBoolean) {
        break label217;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.getCount();
      int i = 0;
      while (i < j)
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.getItem(i);
        if (localTroopMemberInfo != null)
        {
          SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
          localArrayList.add(SelectMemberActivity.a(localTroopMemberInfo.memberuin, this.g.b(localTroopMemberInfo), 1, this.mTroopUin));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 31) {
          anot.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 35) {
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "CliOper", "", "", "0X8009E2C", "0X8009E2C", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.notifyDataSetChanged();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label217:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XG();
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 35) {
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "CliOper", "", "", "0X8009E2D", "0X8009E2D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    boolean bool;
    if (2131370731 != paramView.getId())
    {
      localObject1 = (c)paramView.getTag();
      if ((localObject1 != null) && (((c)localObject1).checkBox != null) && (((c)localObject1).fe != null) && (((c)localObject1).checkBox.isEnabled()))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((c)localObject1).uin, ((c)localObject1).fe.getText().toString(), 1, this.mTroopUin);
        ((c)localObject1).checkBox.setChecked(bool);
        bt(((c)localObject1).uin, bool);
        if (AppSetting.enableTalkBack)
        {
          if (!((c)localObject1).checkBox.isChecked()) {
            break label177;
          }
          paramView.setContentDescription(((c)localObject1).fe.getText().toString() + acfp.m(2131715979));
          if (!((c)localObject1).checkBox.isChecked()) {
            break label218;
          }
          localObject1 = acfp.m(2131715945);
          label163:
          aqcl.speak(paramView, (String)localObject1);
        }
      }
    }
    label177:
    label218:
    label353:
    label370:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        paramView.setContentDescription(((c)localObject1).fe.getText().toString() + acfp.m(2131715963));
        break;
        localObject1 = acfp.m(2131715930);
        break label163;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK != 32) || (this.F.isChecked()) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.cms >= this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.zr())) {
          break label353;
        }
        localObject1 = new aayy(this);
        String str = MessageFormat.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719449), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.cms) });
        localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 232, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getString(2131721103), str, 2131721058, 2131701239, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
        try
        {
          ((Dialog)localObject1).show();
        }
        catch (Throwable localThrowable) {}
      }
      localObject2 = this.F;
      if (this.F.isChecked()) {
        break label424;
      }
      bool = true;
      ((CheckBox)localObject2).setChecked(bool);
      onCheckedChanged(this.F, this.F.isChecked());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK != 32);
    if (this.F.isChecked()) {}
    for (Object localObject2 = "friendsfinder.all.confirm";; localObject2 = "friendsfinder.all.cancel")
    {
      aagd.bD(0, (String)localObject2);
      break;
      label424:
      bool = false;
      break label370;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563053);
    this.g = ((TroopManager)this.e.getManager(52));
    initUI();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b = new b();
    this.h.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$b.destroy();
    }
    if ((this.OP != null) && (this.OP.getTag() != null))
    {
      ((Bitmap)this.OP.getTag()).recycle();
      this.OP.setTag(null);
    }
    if ((this.OQ != null) && (this.OQ.getTag() != null))
    {
      ((Bitmap)this.OQ.getTag()).recycle();
      this.OQ.setTag(null);
    }
    super.onDestroy();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_b_of_type_Acnd);
  }
  
  public String qN()
  {
    return this.mTroopUin;
  }
  
  class a
    implements Comparator<TroopMemberInfo>
  {
    private a() {}
    
    public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
    {
      if ((paramTroopMemberInfo1 != null) && (paramTroopMemberInfo1.displayedNamePinyinFirst != null) && (paramTroopMemberInfo2 != null)) {
        return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
      }
      return 0;
    }
  }
  
  public class b
    extends abdw
  {
    public b()
    {
      super(TroopMemberListInnerFrame.this.e, TroopMemberListInnerFrame.this.h, true);
    }
    
    public int ag()
    {
      if (TroopMemberListInnerFrame.this.k.length > 0) {
        return 2131559496;
      }
      return 0;
    }
    
    public void b(View paramView, int paramInt)
    {
      Arrays.binarySearch(TroopMemberListInnerFrame.this.ad, paramInt);
    }
    
    public int getCount()
    {
      if ((TroopMemberListInnerFrame.this.ad == null) || (TroopMemberListInnerFrame.this.iL == null)) {}
      while (TroopMemberListInnerFrame.this.ad.length == 0) {
        return 0;
      }
      int i = TroopMemberListInnerFrame.this.ad[(TroopMemberListInnerFrame.this.ad.length - 1)];
      return ((List)TroopMemberListInnerFrame.this.iL.get(TroopMemberListInnerFrame.this.k[(TroopMemberListInnerFrame.this.k.length - 1)])).size() + i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      int i = Arrays.binarySearch(TroopMemberListInnerFrame.this.ad, paramInt);
      if (i >= 0) {
        return null;
      }
      i = -(i + 1) - 1;
      return (TroopMemberInfo)((List)TroopMemberListInnerFrame.this.iL.get(TroopMemberListInnerFrame.this.k[i])).get(paramInt - TroopMemberListInnerFrame.this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(TroopMemberListInnerFrame.this.ad, paramInt);
      View localView;
      if (paramView == null)
      {
        localView = TroopMemberListInnerFrame.this.mLayoutInflater.inflate(2131563063, paramViewGroup, false);
        paramView = new TroopMemberListInnerFrame.c(TroopMemberListInnerFrame.this, null);
        localView.setTag(paramView);
        paramView.hk = ((RelativeLayout)localView.findViewById(2131377444));
        paramView.Gn = ((TextView)localView.findViewById(2131380761));
        paramView.checkBox = ((CheckBox)localView.findViewById(2131364587));
        paramView.pQ = ((ImageView)localView.findViewById(2131368698));
        paramView.fe = ((TextView)localView.findViewById(2131372190));
        paramView.lo = localView.findViewById(2131380904);
      }
      for (;;)
      {
        TroopMemberListInnerFrame.c localc = (TroopMemberListInnerFrame.c)localView.getTag();
        TroopMemberInfo localTroopMemberInfo;
        String str;
        Object localObject;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localTroopMemberInfo = (TroopMemberInfo)((List)TroopMemberListInnerFrame.this.iL.get(TroopMemberListInnerFrame.this.k[i])).get(paramInt - TroopMemberListInnerFrame.this.ad[i] - 1);
          if (TroopMemberListInnerFrame.this.a.iX(localTroopMemberInfo.memberuin))
          {
            localc.checkBox.setChecked(true);
            localc.hk.setVisibility(0);
            localc.Gn.setVisibility(8);
            localc.pQ.setImageBitmap(getFaceBitmap(localTroopMemberInfo.memberuin));
            str = aqgv.h(TroopMemberListInnerFrame.this.e, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin);
            if (TroopMemberListInnerFrame.this.a.eK != 21) {
              break label732;
            }
            localObject = null;
            if ((TroopMemberListInnerFrame.a(TroopMemberListInnerFrame.this) == null) || (!TroopMemberListInnerFrame.a(TroopMemberListInnerFrame.this).isTroopOwner(localTroopMemberInfo.memberuin)) || (TroopMemberListInnerFrame.this.OQ == null) || (TroopMemberListInnerFrame.this.OQ.getTag() == null)) {
              break label628;
            }
            paramView = new SpannableString("[tag]" + " " + str);
            paramView.setSpan(new ImageSpan(TroopMemberListInnerFrame.this.a, (Bitmap)TroopMemberListInnerFrame.this.OQ.getTag()), 0, "[tag]".length(), 18);
            label432:
            localc.fe.setText(paramView);
            label441:
            localc.uin = localTroopMemberInfo.memberuin;
            if (localc.lo != null)
            {
              if (!aprg.V(TroopMemberListInnerFrame.this.a.app, localTroopMemberInfo.memberuin)) {
                break label763;
              }
              localc.lo.setVisibility(0);
            }
            label489:
            if ((TroopMemberListInnerFrame.this.a.so == null) || (!TroopMemberListInnerFrame.this.a.so.contains(localTroopMemberInfo.memberuin))) {
              break label776;
            }
            localc.checkBox.setEnabled(false);
            label532:
            if ((!AppSetting.enableTalkBack) || (!localc.checkBox.isEnabled())) {
              break label820;
            }
            if (!localc.checkBox.isChecked()) {
              break label788;
            }
            localView.setContentDescription(str + acfp.m(2131715904));
            label589:
            localView.setOnClickListener(TroopMemberListInnerFrame.this);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
          localc.checkBox.setChecked(false);
          break;
          label628:
          paramView = localObject;
          if (TroopMemberListInnerFrame.this.OP == null) {
            break label432;
          }
          paramView = localObject;
          if (TroopMemberListInnerFrame.this.OP.getTag() == null) {
            break label432;
          }
          paramView = new SpannableString("[tag]" + " " + str);
          paramView.setSpan(new ImageSpan(TroopMemberListInnerFrame.this.a, (Bitmap)TroopMemberListInnerFrame.this.OP.getTag()), 0, "[tag]".length(), 18);
          break label432;
          label732:
          localc.fe.setText(aqgv.h(TroopMemberListInnerFrame.this.e, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin));
          break label441;
          label763:
          localc.lo.setVisibility(8);
          break label489;
          label776:
          localc.checkBox.setEnabled(true);
          break label532;
          label788:
          localView.setContentDescription(str + acfp.m(2131715928));
          break label589;
          label820:
          if ((TroopMemberListInnerFrame.this.a.eK != 14) || (localc.checkBox.isEnabled())) {
            break label589;
          }
          localView.setContentDescription(str + acfp.m(2131715917));
          break label589;
          localc.hk.setVisibility(8);
          localc.Gn.setVisibility(0);
          paramView = String.valueOf(TroopMemberListInnerFrame.this.k[i]);
          localc.Gn.setText(paramView);
          localc.Gn.setContentDescription(String.format(TroopMemberListInnerFrame.this.a.getString(2131692906), new Object[] { paramView.toLowerCase() }));
        }
        localView = paramView;
      }
    }
    
    public int m(String paramString)
    {
      int i;
      if (TroopMemberListInnerFrame.this.k != null)
      {
        i = 0;
        if (i >= TroopMemberListInnerFrame.this.k.length) {
          break label65;
        }
        if (!TroopMemberListInnerFrame.this.k[i].equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0)
        {
          return TroopMemberListInnerFrame.this.ad[i];
          i += 1;
          break;
        }
        return -1;
        return -1;
        label65:
        i = -1;
      }
    }
    
    public boolean t(int paramInt)
    {
      return Arrays.binarySearch(TroopMemberListInnerFrame.this.ad, paramInt) >= 0;
    }
    
    public int zr()
    {
      Iterator localIterator = TroopMemberListInnerFrame.this.iL.keySet().iterator();
      for (int i = 0; localIterator.hasNext(); i = ((List)TroopMemberListInnerFrame.this.iL.get(localIterator.next())).size() + i) {}
      return i;
    }
  }
  
  class c
    extends TroopMemberListActivity.i
  {
    public CheckBox checkBox;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */