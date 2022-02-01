package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arqo;
import artl;
import artp;
import artp.a;
import artr;
import arwt;
import com.tencent.mobileqq.activity.TroopMemberListActivity.i;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class DeviceFriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, artp.a, IndexView.a, PinnedDividerListView.b, AdapterView.c
{
  protected static final String TAG = DeviceFriendListOpenFrame.class.getName();
  public a a;
  protected EditText ax;
  protected IndexView b;
  protected PinnedDividerListView g;
  public RelativeLayout gW;
  protected Handler mHandler = new arqo(this);
  
  public DeviceFriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
      i = this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a.m(paramString);
    } while (i == -1);
    this.g.setSelection(i + this.g.getHeaderViewsCount());
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    arwt.d(TAG, "-->onImageLoaded() url = " + paramString1);
    this.mHandler.post(new DeviceFriendListOpenFrame.2(this, paramString1, paramBitmap));
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.g.getFirstVisiblePosition() > 0) || ((this.g.getFirstVisiblePosition() == 0) && (this.g.getChildCount() < this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a.getCount() + this.g.getHeaderViewsCount()))) && (!this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.bBe))
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
    arwt.d(TAG, "-->onStart()");
    super.be(paramBundle);
    this.g.setSelection(0);
    this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.a(true, true, this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.getString(2131691820), this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.getString(2131692832), this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.getString(2131691040));
    if (this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a = new a();
      this.g.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a);
    }
    this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a.bSJ();
  }
  
  protected void initUI()
  {
    this.g = ((PinnedDividerListView)super.findViewById(2131364452));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131369142));
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.g.setSelector(2131167595);
    this.g.setOnItemClickListener(this);
    this.g.setOnLayoutListener(this);
    this.gW = ((RelativeLayout)this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2131563007, this.g, false));
    this.ax = ((EditText)this.gW.findViewById(2131366542));
    this.ax.setOnTouchListener(this);
    ((Button)this.gW.findViewById(2131363801)).setVisibility(8);
    this.g.addHeaderView(this.gW);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a.bSJ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131563053);
    initUI();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (b)paramView.getTag();
    if ((paramAdapterView != null) && (paramAdapterView.checkBox != null))
    {
      paramInt -= this.g.getHeaderViewsCount();
      if (paramInt >= 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      paramView = (Friend)this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$a.getItem(paramInt);
    } while ((paramView == null) || ((this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.so != null) && (this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.so.contains(paramView.openId))));
    this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.a(paramView);
    if (this.jdField_a_of_type_Artl.so(paramView.openId))
    {
      paramAdapterView.checkBox.setChecked(true);
      return;
    }
    paramAdapterView.checkBox.setChecked(false);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_b_of_type_ComTencentOpenAgentFriendChooser.cq();
    }
    return true;
  }
  
  public class a
    extends PinnedDividerListView.a
  {
    protected LinkedHashMap<String, List<Friend>> D = new LinkedHashMap();
    protected int[] ad = new int[0];
    protected String[] k = new String[0];
    
    public a()
    {
      bNq();
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
      if ((paramInt < 0) || (paramInt >= this.k.length)) {
        return;
      }
      ((TextView)paramView).setText(this.k[paramInt]);
    }
    
    protected void bNq()
    {
      this.D.clear();
      Object localObject1 = DeviceFriendListOpenFrame.this.a.gS();
      arwt.d(DeviceFriendListOpenFrame.TAG, "-->start constructHashStruct()");
      Object localObject2 = ((List)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Friend localFriend = (Friend)((Iterator)localObject2).next();
        if ((localFriend.cCi == null) || (localFriend.cCi.length() == 0))
        {
          localObject1 = "#";
          label81:
          i = ((String)localObject1).charAt(0);
          if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
            break label186;
          }
        }
        label186:
        for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
        {
          if (this.D.get(localObject1) == null) {
            this.D.put(localObject1, new ArrayList());
          }
          ((List)this.D.get(localObject1)).add(localFriend);
          break;
          localObject1 = localFriend.cCi.substring(0, 1);
          break label81;
        }
      }
      localObject1 = this.D;
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
      if (this.ad.length == 0) {
        return;
      }
      this.ad[0] = 0;
      int i = 1;
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
      arwt.d(DeviceFriendListOpenFrame.TAG, "-->end constructHashStruct()");
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
      View localView;
      Object localObject;
      label192:
      label234:
      Bitmap localBitmap;
      if (paramView == null)
      {
        localView = DeviceFriendListOpenFrame.this.mLayoutInflater.inflate(2131563063, paramViewGroup, false);
        paramView = new DeviceFriendListOpenFrame.b();
        paramView.hk = ((RelativeLayout)localView.findViewById(2131377444));
        paramView.Gn = ((TextView)localView.findViewById(2131380761));
        paramView.checkBox = ((CheckBox)localView.findViewById(2131364587));
        paramView.pQ = ((ImageView)localView.findViewById(2131368698));
        paramView.fe = ((TextView)localView.findViewById(2131372190));
        localView.setTag(paramView);
        if (i >= 0) {
          break label465;
        }
        i = -(i + 1) - 1;
        localObject = (Friend)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
        if (!DeviceFriendListOpenFrame.this.a.so(((Friend)localObject).openId)) {
          break label416;
        }
        paramView.checkBox.setChecked(true);
        if ((DeviceFriendListOpenFrame.this.b.so == null) || (!DeviceFriendListOpenFrame.this.b.so.contains(((Friend)localObject).openId))) {
          break label427;
        }
        paramView.checkBox.setEnabled(false);
        if ((((Friend)localObject).cCh == null) || ("".equals(((Friend)localObject).cCh))) {
          ((Friend)localObject).cCh = artr.cg(DeviceFriendListOpenFrame.this.b.getAppid(), ((Friend)localObject).openId);
        }
        paramView.avatar = ((Friend)localObject).cCh;
        paramView.hk.setVisibility(0);
        paramView.Gn.setVisibility(8);
        localBitmap = artp.a().Q(((Friend)localObject).cCh);
        if (localBitmap != null) {
          break label438;
        }
        paramView.pQ.setImageResource(2130840645);
        artp.a().a(((Friend)localObject).cCh, DeviceFriendListOpenFrame.this);
        label347:
        if ((((Friend)localObject).label != null) && (!"".equals(((Friend)localObject).label))) {
          break label450;
        }
        paramView.fe.setText(((Friend)localObject).nickName);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (DeviceFriendListOpenFrame.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label416:
        paramView.checkBox.setChecked(false);
        break label192;
        label427:
        paramView.checkBox.setEnabled(true);
        break label234;
        label438:
        paramView.pQ.setImageBitmap(localBitmap);
        break label347;
        label450:
        paramView.fe.setText(((Friend)localObject).label);
        continue;
        label465:
        paramView.hk.setVisibility(8);
        paramView.Gn.setVisibility(0);
        paramView.Gn.setText(String.valueOf(this.k[i]));
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
  
  public static class b
    extends TroopMemberListActivity.i
  {
    public TextView Gn;
    public String avatar;
    public CheckBox checkBox;
    public TextView fe;
    public RelativeLayout hk;
    public ImageView pQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */