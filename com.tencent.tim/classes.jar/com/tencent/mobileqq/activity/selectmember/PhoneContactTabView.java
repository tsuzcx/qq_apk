package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aaxh;
import aaxi;
import aaxj;
import aaxk;
import aaxn;
import abdw;
import abeg.a;
import acfp;
import ajdo;
import akwl;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class PhoneContactTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener, View.OnTouchListener, IndexView.a, PinnedDividerListView.b
{
  private TextView OF;
  ContactFriendInnerFrame jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame;
  private a jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a;
  private ajdo jdField_b_of_type_Ajdo;
  private IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new aaxi(this);
  private String bez;
  PinnedDividerListView f;
  private akwl m;
  List<PhoneContact> mContacts;
  
  public PhoneContactTabView(SelectMemberActivity paramSelectMemberActivity, ContactFriendInnerFrame paramContactFriendInnerFrame)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame = paramContactFriendInnerFrame;
  }
  
  private void czR()
  {
    if (this.jdField_b_of_type_Ajdo == null) {
      this.jdField_b_of_type_Ajdo = ((ajdo)this.e.getManager(11));
    }
    if (this.m == null) {
      this.m = new aaxj(this);
    }
    this.e.registObserver(this.m);
  }
  
  private void czS() {}
  
  private void initUI()
  {
    this.f = ((PinnedDividerListView)findViewById(2131364452));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369142));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.f.setSelector(2131167595);
    this.f.setOnLayoutListener(this);
    this.OF = ((TextView)findViewById(2131380985));
    this.OF.setOnClickListener(new aaxh(this));
  }
  
  private void showEmptyView()
  {
    this.f.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.f.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a.m(paramString);
    } while (i == -1);
    this.f.setSelection(i + this.f.getHeaderViewsCount());
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.f.getFirstVisiblePosition() > 0) || ((this.f.getFirstVisiblePosition() == 0) && (this.f.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a.getCount() + this.f.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XH()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setContentView(2131563053);
    this.jdField_b_of_type_Ajdo = ((ajdo)this.e.getManager(11));
    this.e.setHandler(PhoneContactTabView.class, this.jdField_b_of_type_MqqOsMqqHandler);
    initUI();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a = new a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.f, false);
    this.f.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719436), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mTitleString);
    int i = this.jdField_b_of_type_Ajdo.xy();
    if (QLog.isColorLevel()) {
      QLog.i("ContactsInnerFrame", 2, "onStart state:" + i);
    }
    switch (i)
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      czR();
      return;
    case 9: 
      showListView();
      return;
    case 0: 
    case 1: 
    case 5: 
    case 7: 
      showEmptyView();
      return;
    }
    if (this.jdField_b_of_type_Ajdo.a().lastUsedFlag == 2L)
    {
      showListView();
      return;
    }
    showEmptyView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(3);
    this.e.removeHandler(PhoneContactTabView.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a.destroy();
    }
    this.e.unRegistObserver(this.m);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    return true;
  }
  
  public void showListView()
  {
    this.mContacts = this.jdField_b_of_type_Ajdo.db();
    if (this.mContacts == null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
    }
    for (;;)
    {
      this.f.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.OF.setVisibility(8);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a = new a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.f, false);
        this.f.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView$a.bSJ();
    }
  }
  
  public class a
    extends abdw
  {
    private LinkedHashMap<String, List<PhoneContact>> D = new LinkedHashMap();
    private int[] ad = new int[0];
    View.OnClickListener dB = new aaxk(this);
    private String[] k = new String[0];
    
    public a(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
    {
      super(paramQQAppInterface, paramXListView, paramBoolean);
    }
    
    @SuppressLint({"DefaultLocale"})
    private void bNq()
    {
      this.D.clear();
      if (PhoneContactTabView.this.mContacts == null) {}
      for (;;)
      {
        return;
        Object localObject2 = PhoneContactTabView.this.mContacts.iterator();
        label69:
        int i;
        if (((Iterator)localObject2).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
          if (TextUtils.isEmpty(localPhoneContact.pinyinFirst))
          {
            localObject1 = "#";
            i = ((String)localObject1).charAt(0);
            if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
              break label174;
            }
          }
          label174:
          for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
          {
            if (this.D.get(localObject1) == null) {
              this.D.put(localObject1, new ArrayList());
            }
            ((List)this.D.get(localObject1)).add(localPhoneContact);
            break;
            localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
            break label69;
          }
        }
        Object localObject1 = this.D;
        this.D = new LinkedHashMap();
        localObject2 = (List)((LinkedHashMap)localObject1).get("@");
        if (localObject2 != null) {
          this.D.put(PhoneContactTabView.a(PhoneContactTabView.this), localObject2);
        }
        for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
          if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
            this.D.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
          }
        }
        if (((LinkedHashMap)localObject1).get("#") != null) {
          this.D.put("#", ((LinkedHashMap)localObject1).get("#"));
        }
        ((LinkedHashMap)localObject1).clear();
        this.ad = new int[this.D.keySet().size()];
        this.k = new String[this.ad.length];
        localObject1 = this.D.keySet().iterator();
        if (this.ad.length != 0)
        {
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
    }
    
    public boolean a(abeg.a parama)
    {
      boolean bool2 = super.a(parama);
      boolean bool1 = bool2;
      if ((parama instanceof aaxn))
      {
        parama = (aaxn)parama;
        if ((bool2) && (!parama.bAI)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      return false;
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
      paramInt = Arrays.binarySearch(this.ad, paramInt);
      if (paramInt < 0) {
        paramInt = -(paramInt + 1);
      }
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
      return (PhoneContact)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      if (paramView == null) {
        paramView = aaxn.a(paramViewGroup, PhoneContactTabView.this.mLayoutInflater, 2131559082);
      }
      for (;;)
      {
        aaxn localaaxn = (aaxn)paramView.getTag();
        Object localObject;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localObject = (PhoneContact)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
          aaxn.a(this, localaaxn, (PhoneContact)localObject);
          localaaxn.fe.setText(((PhoneContact)localObject).name);
          localaaxn.OH.setText(((PhoneContact)localObject).mobileNo);
          localaaxn.OH.setVisibility(0);
          if (PhoneContactTabView.this.a.iX(localaaxn.uin))
          {
            localaaxn.checkBox.setChecked(true);
            localaaxn.checkBox.setEnabled(true);
            if ((AppSetting.enableTalkBack) && (localaaxn.checkBox.isEnabled()))
            {
              if (!localaaxn.checkBox.isChecked()) {
                break label291;
              }
              paramView.setContentDescription(((PhoneContact)localObject).name + acfp.m(2131709497));
            }
            label226:
            localaaxn.c = ((PhoneContact)localObject);
            localaaxn.Ag.setVisibility(8);
            localaaxn.Ag.setOnClickListener(this.dB);
            paramView.setOnClickListener(this.dB);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localaaxn.checkBox.setChecked(false);
          break;
          label291:
          paramView.setContentDescription(((PhoneContact)localObject).name + acfp.m(2131709495));
          break label226;
          localaaxn.hk.setVisibility(8);
          localaaxn.Gn.setVisibility(0);
          localObject = String.valueOf(this.k[i]);
          localaaxn.Gn.setText((CharSequence)localObject);
          localaaxn.Gn.setContentDescription(String.format(PhoneContactTabView.this.a.getString(2131692906), new Object[] { ((String)localObject).toLowerCase() }));
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.PhoneContactTabView
 * JD-Core Version:    0.7.0.1
 */