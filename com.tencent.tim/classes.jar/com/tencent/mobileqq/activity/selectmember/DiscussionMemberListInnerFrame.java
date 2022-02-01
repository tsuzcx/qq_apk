package com.tencent.mobileqq.activity.selectmember;

import aagd;
import aaww;
import aawx;
import abdw;
import acdu;
import acfp;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqgv;
import aqha;
import asgx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.TroopMemberListActivity.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class DiscussionMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.a, PinnedDividerListView.b
{
  public CheckBox F;
  private a a;
  private String aMM;
  private String aNK;
  acdu jdField_b_of_type_Acdu;
  private IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  boolean bAF;
  private String bex = "";
  PinnedDividerListView d;
  RelativeLayout iT;
  private Handler mHandler = new aawx(this);
  List<DiscussionMemberInfo> qG = new ArrayList();
  
  public DiscussionMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bNp()
  {
    this.qG.clear();
    Object localObject = ((acdu)this.e.getManager(53)).z(this.aMM);
    if (localObject != null)
    {
      String str = this.e.getCurrentAccountUin();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
        if ((localDiscussionMemberInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAV) || (!str.equalsIgnoreCase(localDiscussionMemberInfo.memberUin))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(localDiscussionMemberInfo.memberUin)))
        {
          localDiscussionMemberInfo.displayedNamePinyinFirst = ChnToSpell.aJ(aqgv.a(localDiscussionMemberInfo, this.e), 2);
          this.qG.add(localDiscussionMemberInfo);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.GP(this.qG.size());
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
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.getCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label105;
        }
        paramString = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.getItem(i);
        if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.iX(paramString.memberUin)))
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
  
  private void initUI()
  {
    this.d = ((PinnedDividerListView)findViewById(2131364452));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369142));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.d.setSelector(2131167595);
    this.d.setOnLayoutListener(this);
    this.iT = ((RelativeLayout)findViewById(2131377479));
    LinearLayout localLinearLayout = (LinearLayout)this.iT.findViewById(2131370731);
    this.F = ((CheckBox)findViewById(2131364357));
    localLinearLayout.setOnClickListener(this);
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.d.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.m(paramString);
    } while (i == -1);
    this.d.setSelection(i + this.d.getHeaderViewsCount());
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 4096, this.aMM, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.d.getFirstVisiblePosition() > 0) || ((this.d.getFirstVisiblePosition() == 0) && (this.d.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.getCount() + this.d.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XH()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.mHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.mHandler.sendEmptyMessage(2);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.bVm();
    this.aMM = paramBundle.getString("group_uin");
    this.aNK = paramBundle.getString("group_name");
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.iT;
    int i;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      if ((TextUtils.isEmpty(this.aNK)) && (!TextUtils.isEmpty(this.aMM)) && (this.jdField_b_of_type_Acdu != null))
      {
        paramBundle = this.jdField_b_of_type_Acdu.a(this.aMM);
        if (paramBundle != null) {
          this.aNK = paramBundle.discussionName;
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAP) {
        break label240;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, "", this.aNK);
      label137:
      if ((TextUtils.isEmpty(this.aMM)) || (this.aMM.equals(this.bex))) {
        break label261;
      }
      bNp();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.bSJ();
      this.d.setSelection(0);
      this.bex = this.aMM;
    }
    for (;;)
    {
      if ((!this.bAF) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAW))
      {
        this.bAF = true;
        this.F.setChecked(true);
        onCheckedChanged(this.F, this.F.isChecked());
      }
      return;
      i = 8;
      break;
      label240:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, acfp.m(2131705159), this.aNK);
      break label137;
      label261:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.notifyDataSetChanged();
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.notifyDataSetChanged();
    bt(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131364357 == paramCompoundButton.getId())
    {
      if (!paramBoolean) {
        break label172;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.getCount();
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.getItem(i);
        if (localDiscussionMemberInfo != null)
        {
          SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
          localArrayList.add(SelectMemberActivity.a(localDiscussionMemberInfo.memberUin, aqgv.a(localDiscussionMemberInfo, this.e), 2, this.aMM));
        }
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 31) {
        anot.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.notifyDataSetChanged();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label172:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XG();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject1;
    if (2131370731 != paramView.getId())
    {
      localObject1 = (b)paramView.getTag();
      if ((localObject1 != null) && (((b)localObject1).checkBox != null) && (((b)localObject1).fe != null) && (((b)localObject1).checkBox.isEnabled()))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((b)localObject1).uin, ((b)localObject1).fe.getText().toString(), 2, this.aMM);
        ((b)localObject1).checkBox.setChecked(bool);
        bt(((b)localObject1).uin, bool);
        if (AppSetting.enableTalkBack)
        {
          if (!((b)localObject1).checkBox.isChecked()) {
            break label156;
          }
          paramView.setContentDescription(((b)localObject1).fe.getText().toString() + acfp.m(2131705132));
        }
      }
    }
    label156:
    label337:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        paramView.setContentDescription(((b)localObject1).fe.getText().toString() + acfp.m(2131705148));
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK != 32) || (this.F.isChecked()) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.cms >= this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.zr())) {
          break;
        }
        localObject1 = new aaww(this);
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
        break;
      }
      ((CheckBox)localObject2).setChecked(bool);
      onCheckedChanged(this.F, this.F.isChecked());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK != 32);
    if (this.F.isChecked()) {}
    for (Object localObject2 = "friendsfinder.all.confirm";; localObject2 = "friendsfinder.all.cancel")
    {
      aagd.bD(0, (String)localObject2);
      break;
      bool = false;
      break label337;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563053);
    this.jdField_b_of_type_Acdu = ((acdu)this.e.getManager(53));
    initUI();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a = new a();
    this.d.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberDiscussionMemberListInnerFrame$a.destroy();
    }
    super.onDestroy();
  }
  
  public String qN()
  {
    return this.aMM;
  }
  
  class a
    extends abdw
  {
    private LinkedHashMap<String, List<DiscussionMemberInfo>> D = new LinkedHashMap();
    private int[] ad = new int[0];
    private String[] k = new String[0];
    
    public a()
    {
      super(DiscussionMemberListInnerFrame.this.e, DiscussionMemberListInnerFrame.this.d, true);
      bNq();
    }
    
    @SuppressLint({"DefaultLocale"})
    private void bNq()
    {
      this.D.clear();
      asgx localasgx = (asgx)DiscussionMemberListInnerFrame.this.a.app.getManager(165);
      String str = DiscussionMemberListInnerFrame.this.e.getCurrentAccountUin();
      Iterator localIterator = DiscussionMemberListInnerFrame.this.qG.iterator();
      Object localObject1 = null;
      Object localObject3;
      label163:
      int i;
      while (localIterator.hasNext())
      {
        localObject3 = (DiscussionMemberInfo)localIterator.next();
        if ((localObject3 == null) || (!localasgx.sM(((DiscussionMemberInfo)localObject3).memberUin))) {
          if ((localObject3 != null) && (DiscussionMemberListInnerFrame.this.a.bBa) && (str != null) && (str.equals(((DiscussionMemberInfo)localObject3).memberUin)))
          {
            localObject1 = localObject3;
          }
          else
          {
            if ((((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst == null) || (((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst.length() == 0))
            {
              localObject2 = "#";
              i = ((String)localObject2).charAt(0);
              if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
                break label268;
              }
            }
            label268:
            for (localObject2 = ((String)localObject2).toUpperCase();; localObject2 = "#")
            {
              if (this.D.get(localObject2) == null) {
                this.D.put(localObject2, new ArrayList());
              }
              ((List)this.D.get(localObject2)).add(localObject3);
              break;
              localObject2 = ((DiscussionMemberInfo)localObject3).displayedNamePinyinFirst.substring(0, 1);
              break label163;
            }
          }
        }
      }
      Object localObject2 = this.D;
      this.D = new LinkedHashMap();
      if ((DiscussionMemberListInnerFrame.this.a.bBa) && (localObject1 != null))
      {
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        this.D.put(acfp.m(2131705152), localObject3);
      }
      for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
        if (((LinkedHashMap)localObject2).get(String.valueOf(c)) != null) {
          this.D.put(String.valueOf(c), ((LinkedHashMap)localObject2).get(String.valueOf(c)));
        }
      }
      if (((LinkedHashMap)localObject2).get("#") != null) {
        this.D.put("#", ((LinkedHashMap)localObject2).get("#"));
      }
      ((LinkedHashMap)localObject2).clear();
      this.ad = new int[this.D.keySet().size()];
      this.k = new String[this.ad.length];
      localObject1 = this.D.keySet().iterator();
      if (this.ad.length == 0) {}
      for (;;)
      {
        return;
        this.ad[0] = 0;
        i = 1;
        while (i < this.ad.length)
        {
          localObject2 = this.ad;
          int j = localObject2[i];
          int m = this.ad[(i - 1)];
          localObject2[i] = (((List)this.D.get(((Iterator)localObject1).next())).size() + m + 1 + j);
          i += 1;
        }
        localObject1 = this.D.keySet().iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          this.k[i] = ((String)((Iterator)localObject1).next());
          i += 1;
        }
      }
    }
    
    public int ag()
    {
      if (this.k.length > 0) {
        return 2131559496;
      }
      return 0;
    }
    
    public void b(View paramView, int paramInt)
    {
      Arrays.binarySearch(this.ad, paramInt);
    }
    
    public void bSJ()
    {
      bNq();
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.ad.length == 0) {
        return 0;
      }
      int i = this.ad[(this.ad.length - 1)];
      return ((List)this.D.get(this.k[(this.k.length - 1)])).size() + i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      if (i >= 0) {
        return null;
      }
      i = -(i + 1) - 1;
      return (DiscussionMemberInfo)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      DiscussionMemberListInnerFrame.b localb;
      if (paramView == null)
      {
        paramView = DiscussionMemberListInnerFrame.this.mLayoutInflater.inflate(2131563063, paramViewGroup, false);
        localb = new DiscussionMemberListInnerFrame.b(DiscussionMemberListInnerFrame.this, null);
        paramView.setTag(localb);
        localb.hk = ((RelativeLayout)paramView.findViewById(2131377444));
        localb.Gn = ((TextView)paramView.findViewById(2131380761));
        localb.checkBox = ((CheckBox)paramView.findViewById(2131364587));
        localb.pQ = ((ImageView)paramView.findViewById(2131368698));
        localb.fe = ((TextView)paramView.findViewById(2131372190));
      }
      for (;;)
      {
        localb = (DiscussionMemberListInnerFrame.b)paramView.getTag();
        Object localObject;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localObject = (DiscussionMemberInfo)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
          if (DiscussionMemberListInnerFrame.this.a.iX(((DiscussionMemberInfo)localObject).memberUin))
          {
            localb.checkBox.setChecked(true);
            localb.hk.setVisibility(0);
            localb.Gn.setVisibility(8);
            localb.pQ.setImageBitmap(getFaceBitmap(((DiscussionMemberInfo)localObject).memberUin));
            localb.fe.setText(aqgv.a((DiscussionMemberInfo)localObject, DiscussionMemberListInnerFrame.this.e));
            localb.uin = ((DiscussionMemberInfo)localObject).memberUin;
            if ((DiscussionMemberListInnerFrame.this.a.so == null) || (!DiscussionMemberListInnerFrame.this.a.so.contains(((DiscussionMemberInfo)localObject).memberUin))) {
              break label418;
            }
            localb.checkBox.setEnabled(false);
            label316:
            if ((AppSetting.enableTalkBack) && (localb.checkBox.isEnabled()))
            {
              if (!localb.checkBox.isChecked()) {
                break label430;
              }
              paramView.setContentDescription(aqgv.a((DiscussionMemberInfo)localObject, DiscussionMemberListInnerFrame.this.e) + acfp.m(2131705158));
            }
            label382:
            paramView.setOnClickListener(DiscussionMemberListInnerFrame.this);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localb.checkBox.setChecked(false);
          break;
          label418:
          localb.checkBox.setEnabled(true);
          break label316;
          label430:
          paramView.setContentDescription(aqgv.a((DiscussionMemberInfo)localObject, DiscussionMemberListInnerFrame.this.e) + acfp.m(2131705141));
          break label382;
          localb.hk.setVisibility(8);
          localb.Gn.setVisibility(0);
          localObject = String.valueOf(this.k[i]);
          localb.Gn.setText((CharSequence)localObject);
          localb.Gn.setContentDescription(String.format(DiscussionMemberListInnerFrame.this.a.getString(2131692906), new Object[] { ((String)localObject).toLowerCase() }));
        }
      }
    }
    
    public int m(String paramString)
    {
      int i;
      if (this.k != null)
      {
        i = 0;
        if (i >= this.k.length) {
          break label53;
        }
        if (!this.k[i].equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0)
        {
          return this.ad[i];
          i += 1;
          break;
        }
        return -1;
        return -1;
        label53:
        i = -1;
      }
    }
    
    public boolean t(int paramInt)
    {
      return Arrays.binarySearch(this.ad, paramInt) >= 0;
    }
    
    public int zr()
    {
      Iterator localIterator = this.D.keySet().iterator();
      for (int i = 0; localIterator.hasNext(); i = ((List)this.D.get(localIterator.next())).size() + i) {}
      return i;
    }
  }
  
  class b
    extends TroopMemberListActivity.i
  {
    public CheckBox checkBox;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */