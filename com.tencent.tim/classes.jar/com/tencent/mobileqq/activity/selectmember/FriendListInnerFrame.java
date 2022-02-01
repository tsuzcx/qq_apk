package com.tencent.mobileqq.activity.selectmember;

import aawy;
import abdw;
import acdb;
import acff;
import acfp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.TroopMemberListActivity.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class FriendListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.a, PinnedDividerListView.b
{
  private a a;
  private EditText ax;
  private IndexView b;
  private String bey;
  private int cmo = -2147483648;
  private int cmp;
  PinnedDividerListView g;
  public RelativeLayout gW;
  private Handler mHandler = new aawy(this);
  List<Friends> oX = new ArrayList();
  
  public FriendListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void czV()
  {
    this.oX.clear();
    Object localObject1 = (acff)this.e.getManager(51);
    String str;
    if (localObject1 != null)
    {
      str = this.e.getCurrentAccountUin();
      Object localObject2 = ((acff)localObject1).B(String.valueOf(this.cmp));
      Object localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Entity)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject3 = (Friends)localObject3;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAV) || (!((Friends)localObject3).uin.equals(str))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr.contains(((Friends)localObject3).uin))) {
              this.oX.add(localObject3);
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAV) && (this.cmp == 0))
      {
        localObject2 = ((acff)localObject1).cr();
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label339;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        do
        {
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = ((acff)localObject1).B(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
            } while ((localObject3 == null) || (((List)localObject3).size() <= 0));
            localObject3 = ((List)localObject3).iterator();
          }
        } while (!((Friends)((Iterator)localObject3).next()).uin.equals(str));
      }
    }
    label339:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = str;
        ((Friends)localObject1).name = this.e.getCurrentNickname();
        ((Friends)localObject1).mCompareSpell = ChnToSpell.aJ(acdb.a((Friends)localObject1), 1);
        this.oX.add(localObject1);
      }
      return;
    }
  }
  
  private void initUI()
  {
    this.g = ((PinnedDividerListView)findViewById(2131364452));
    this.b = ((IndexView)findViewById(2131369142));
    this.b.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.b.setOnIndexChangedListener(this);
    this.g.setSelector(2131167595);
    this.g.setOnLayoutListener(this);
    this.gW = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131563007, this.g, false));
    this.ax = ((EditText)this.gW.findViewById(2131366542));
    ((Button)this.gW.findViewById(2131363801)).setVisibility(8);
    this.g.addHeaderView(this.gW);
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.g.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a.m(paramString);
    } while (i == -1);
    this.g.setSelection(i + this.g.getHeaderViewsCount());
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.g.getFirstVisiblePosition() > 0) || ((this.g.getFirstVisiblePosition() == 0) && (this.g.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a.getCount() + this.g.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.XH()))
    {
      this.b.setVisibility(0);
      this.mHandler.sendEmptyMessage(1);
      return;
    }
    this.b.setVisibility(4);
    this.mHandler.sendEmptyMessage(2);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.cmp = paramBundle.getInt("friend_team_id");
    this.bey = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719450), this.bey);
    if (this.cmp != this.cmo)
    {
      czV();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a.bSJ();
      this.g.setSelection(0);
      this.cmo = this.cmp;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a.notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    b localb = (b)paramView.getTag();
    if ((localb != null) && (localb.checkBox != null) && (localb.fe != null) && (localb.checkBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localb.uin, localb.fe.getText().toString(), 0, "-1");
      localb.checkBox.setChecked(bool);
      if (AppSetting.enableTalkBack)
      {
        if (!localb.checkBox.isChecked()) {
          break label134;
        }
        paramView.setContentDescription(localb.fe.getText().toString() + acfp.m(2131706580));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label134:
      paramView.setContentDescription(localb.fe.getText().toString() + acfp.m(2131706583));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563053);
    initUI();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a = new a();
    this.g.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame$a.destroy();
    }
    super.onDestroy();
  }
  
  public String qN()
  {
    return "-1";
  }
  
  class a
    extends abdw
  {
    private LinkedHashMap<String, List<Friends>> D = new LinkedHashMap();
    private int[] ad = new int[0];
    private String[] k = new String[0];
    
    public a()
    {
      super(FriendListInnerFrame.this.e, FriendListInnerFrame.this.g, true);
      bNq();
    }
    
    @SuppressLint({"DefaultLocale"})
    private void bNq()
    {
      this.D.clear();
      Object localObject2 = FriendListInnerFrame.this.oX.iterator();
      label66:
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject2).next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
        {
          localObject1 = "#";
          i = ((String)localObject1).charAt(0);
          if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
            break label171;
          }
        }
        label171:
        for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
        {
          if (this.D.get(localObject1) == null) {
            this.D.put(localObject1, new ArrayList());
          }
          ((List)this.D.get(localObject1)).add(localFriends);
          break;
          localObject1 = localFriends.mCompareSpell.substring(0, 1);
          break label66;
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
      return 2131559496;
    }
    
    public void b(View paramView, int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      paramInt = i;
      if (i < 0) {
        paramInt = -(i + 1) - 1;
      }
      ((TextView)paramView).setText(this.k[paramInt]);
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
      List localList = (List)this.D.get(this.k[i]);
      paramInt = paramInt - this.ad[i] - 1;
      if ((paramInt >= 0) && (paramInt < localList.size())) {
        return localList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      FriendListInnerFrame.b localb;
      if (paramView == null)
      {
        paramView = FriendListInnerFrame.this.mLayoutInflater.inflate(2131563063, paramViewGroup, false);
        localb = new FriendListInnerFrame.b(FriendListInnerFrame.this, null);
        paramView.setTag(localb);
        localb.hk = ((RelativeLayout)paramView.findViewById(2131377444));
        localb.Gn = ((TextView)paramView.findViewById(2131380761));
        localb.checkBox = ((CheckBox)paramView.findViewById(2131364587));
        localb.pQ = ((ImageView)paramView.findViewById(2131368698));
        localb.fe = ((TextView)paramView.findViewById(2131372190));
      }
      for (;;)
      {
        localb = (FriendListInnerFrame.b)paramView.getTag();
        Object localObject;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localObject = (Friends)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
          if (FriendListInnerFrame.this.a.iX(((Friends)localObject).uin))
          {
            localb.checkBox.setChecked(true);
            localb.hk.setVisibility(0);
            localb.Gn.setVisibility(8);
            localb.pQ.setImageBitmap(getFaceBitmap(((Friends)localObject).uin));
            localb.fe.setText(((Friends)localObject).getFriendNick());
            localb.uin = ((Friends)localObject).uin;
            if ((FriendListInnerFrame.this.a.so == null) || (!FriendListInnerFrame.this.a.so.contains(((Friends)localObject).uin))) {
              break label404;
            }
            localb.checkBox.setEnabled(false);
            label309:
            if ((AppSetting.enableTalkBack) && (localb.checkBox.isEnabled()))
            {
              if (!localb.checkBox.isChecked()) {
                break label416;
              }
              paramView.setContentDescription(((Friends)localObject).getFriendNick() + acfp.m(2131706579));
            }
            label368:
            paramView.setOnClickListener(FriendListInnerFrame.this);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localb.checkBox.setChecked(false);
          break;
          label404:
          localb.checkBox.setEnabled(true);
          break label309;
          label416:
          paramView.setContentDescription(((Friends)localObject).getFriendNick() + acfp.m(2131706582));
          break label368;
          localb.hk.setVisibility(8);
          localb.Gn.setVisibility(0);
          localObject = String.valueOf(this.k[i]);
          localb.Gn.setText((CharSequence)localObject);
          localb.Gn.setContentDescription(String.format(FriendListInnerFrame.this.a.getString(2131692906), new Object[] { ((String)localObject).toLowerCase() }));
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
  
  class b
    extends TroopMemberListActivity.i
  {
    public CheckBox checkBox;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame
 * JD-Core Version:    0.7.0.1
 */