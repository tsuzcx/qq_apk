package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aawm;
import aawn;
import aaxn;
import abdw;
import abeg.a;
import acfp;
import ajdo;
import akwl;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.a, PinnedDividerListView.b
{
  private a a;
  private ajdo jdField_b_of_type_Ajdo;
  private IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new aawm(this);
  PinnedDividerListView f;
  private akwl m;
  List<PhoneContact> mContacts;
  
  public ContactsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void czR()
  {
    if (this.jdField_b_of_type_Ajdo == null) {
      this.jdField_b_of_type_Ajdo = ((ajdo)this.e.getManager(11));
    }
    if (this.m == null) {
      this.m = new aawn(this);
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
  }
  
  private void showListView()
  {
    this.mContacts = this.jdField_b_of_type_Ajdo.da();
    if (this.mContacts == null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a = new a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.f, false);
      this.f.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a.bSJ();
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
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a.m(paramString);
    } while (i == -1);
    this.f.setSelection(i + this.f.getHeaderViewsCount());
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 768, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.f.getFirstVisiblePosition() > 0) || ((this.f.getFirstVisiblePosition() == 0) && (this.f.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a.getCount() + this.f.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XH()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719450), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131696819));
    switch (this.jdField_b_of_type_Ajdo.xy())
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      czR();
      return;
    case 0: 
    case 7: 
    case 9: 
      showListView();
      return;
    case 1: 
    case 5: 
      czS();
      return;
    }
    if (this.jdField_b_of_type_Ajdo.a().lastUsedFlag == 2L)
    {
      showListView();
      return;
    }
    czS();
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    aaxn localaaxn = (aaxn)paramView.getTag();
    PhoneContact localPhoneContact;
    boolean bool;
    if ((localaaxn != null) && (localaaxn.checkBox != null) && (localaaxn.c != null))
    {
      localPhoneContact = localaaxn.c;
      if (localaaxn.checkBox.isEnabled())
      {
        if (!localaaxn.bAI) {
          break label158;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaaxn.uin, localPhoneContact.name, 5, "-1");
        localaaxn.checkBox.setChecked(bool);
        if (AppSetting.enableTalkBack)
        {
          if (!localaaxn.checkBox.isChecked()) {
            break label264;
          }
          if (!localaaxn.bAI) {
            break label222;
          }
          paramView.setContentDescription(localaaxn.fe.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719454));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label158:
      if (localaaxn.uin.startsWith("+"))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaaxn.uin, localPhoneContact.name, 4, "-1");
        break;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaaxn.uin, localPhoneContact.name, 0, "-1");
      break;
      label222:
      paramView.setContentDescription(localaaxn.fe.getText().toString() + acfp.m(2131704451));
    }
    label264:
    if (localaaxn.bAI) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bY(localaaxn.uin);; i = 0)
    {
      if ((localaaxn.bAI) && (i != 0))
      {
        paramView.setContentDescription(localaaxn.fe.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(i));
        break;
      }
      paramView.setContentDescription(localaaxn.fe.getText().toString() + acfp.m(2131704445));
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563053);
    this.jdField_b_of_type_Ajdo = ((ajdo)this.e.getManager(11));
    this.e.setHandler(ContactsInnerFrame.class, this.jdField_b_of_type_MqqOsMqqHandler);
    initUI();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a = new a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.f, false);
    this.f.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(3);
    this.e.removeHandler(ContactsInnerFrame.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$a.destroy();
    }
    this.e.unRegistObserver(this.m);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public String qN()
  {
    return "-1";
  }
  
  class a
    extends abdw
  {
    private LinkedHashMap<String, List<PhoneContact>> D = new LinkedHashMap();
    private int[] ad = new int[0];
    private String[] k = new String[0];
    
    public a(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
    {
      super(paramQQAppInterface, paramXListView, paramBoolean);
    }
    
    @SuppressLint({"DefaultLocale"})
    private void bNq()
    {
      this.D.clear();
      if (ContactsInnerFrame.this.mContacts == null) {}
      for (;;)
      {
        return;
        Object localObject2 = ContactsInnerFrame.this.mContacts.iterator();
        label77:
        int i;
        if (((Iterator)localObject2).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
          if ((localPhoneContact.pinyinFirst == null) || (localPhoneContact.pinyinFirst.length() == 0))
          {
            localObject1 = "#";
            i = ((String)localObject1).charAt(0);
            if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
              break label182;
            }
          }
          label182:
          for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
          {
            if (this.D.get(localObject1) == null) {
              this.D.put(localObject1, new ArrayList());
            }
            ((List)this.D.get(localObject1)).add(localPhoneContact);
            break;
            localObject1 = localPhoneContact.pinyinFirst.substring(0, 1);
            break label77;
          }
        }
        Object localObject1 = this.D;
        this.D = new LinkedHashMap();
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
      PhoneContact localPhoneContact1 = null;
      int i = Arrays.binarySearch(this.ad, paramInt);
      if (paramView == null) {
        paramView = aaxn.a(paramViewGroup, ContactsInnerFrame.this.mLayoutInflater, 2131563063);
      }
      for (;;)
      {
        aaxn localaaxn = (aaxn)paramView.getTag();
        List localList;
        PhoneContact localPhoneContact2;
        Object localObject;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localList = (List)this.D.get(this.k[i]);
          i = paramInt - this.ad[i] - 1;
          localPhoneContact2 = (PhoneContact)localList.get(i);
          aaxn.a(this, localaaxn, localPhoneContact2);
          if (i - 1 < 0)
          {
            localObject = null;
            if (i + 1 <= localList.size() - 1) {
              break label383;
            }
            label134:
            if (((localObject == null) || (((PhoneContact)localObject).contactID != localPhoneContact2.contactID)) && ((localPhoneContact1 == null) || (localPhoneContact1.contactID != localPhoneContact2.contactID))) {
              break label402;
            }
            localaaxn.OH.setVisibility(0);
            localaaxn.OH.setText(localPhoneContact2.mobileNo);
            label192:
            localaaxn.fe.setText(localPhoneContact2.name);
            if (!ContactsInnerFrame.this.a.iX(localaaxn.uin)) {
              break label415;
            }
            localaaxn.checkBox.setChecked(true);
            label232:
            if ((ContactsInnerFrame.this.a.so == null) || (!ContactsInnerFrame.this.a.so.contains(localPhoneContact2.uin))) {
              break label427;
            }
            localaaxn.checkBox.setEnabled(false);
            label275:
            if ((AppSetting.enableTalkBack) && (localaaxn.checkBox.isEnabled()))
            {
              if (!localaaxn.checkBox.isChecked()) {
                break label439;
              }
              paramView.setContentDescription(localPhoneContact2.name + acfp.m(2131704463));
            }
            label333:
            localaaxn.c = localPhoneContact2;
            paramView.setOnClickListener(ContactsInnerFrame.this);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localObject = (PhoneContact)localList.get(i - 1);
          break;
          label383:
          localPhoneContact1 = (PhoneContact)localList.get(i + 1);
          break label134;
          label402:
          localaaxn.OH.setVisibility(8);
          break label192;
          label415:
          localaaxn.checkBox.setChecked(false);
          break label232;
          label427:
          localaaxn.checkBox.setEnabled(true);
          break label275;
          label439:
          paramView.setContentDescription(localPhoneContact2.name + acfp.m(2131704435));
          break label333;
          localaaxn.hk.setVisibility(8);
          localaaxn.Gn.setVisibility(0);
          localObject = String.valueOf(this.k[i]);
          localaaxn.Gn.setText((CharSequence)localObject);
          localaaxn.Gn.setContentDescription(String.format(ContactsInnerFrame.this.a.getString(2131692906), new Object[] { ((String)localObject).toLowerCase() }));
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
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */