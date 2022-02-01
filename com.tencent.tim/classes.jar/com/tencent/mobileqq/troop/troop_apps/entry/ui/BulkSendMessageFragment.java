package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import acff;
import acfp;
import acms;
import acms.i;
import acnd;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import apqf;
import apqg;
import apqh;
import apqi;
import apqj;
import aprp;
import aqdf;
import aqdf.a;
import aqfr;
import aqgv;
import aqhu;
import aqiw;
import ausj;
import auss;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import jnn;
import jnn.a;
import org.json.JSONObject;
import rpq;
import rpq.b;
import tencent.im.troop.homework.ReqSend1V1Msg;

public class BulkSendMessageFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, aqdf.a, jnn.a
{
  protected View IN;
  public View IO;
  public List<String> Ig = new ArrayList();
  protected a a;
  public jnn a;
  public rpq.b a;
  protected TextView abb;
  protected TextView abc;
  private acnd b = new apqf(this);
  protected aqdf d;
  protected MyGridView d;
  protected int dVn = 10;
  public Runnable hJ = new BulkSendMessageFragment.1(this);
  protected Button hr;
  public ClearableEditText k;
  public QQAppInterface mApp;
  public Handler mHandler;
  public String mTroopUin = "";
  
  public BulkSendMessageFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a = new a();
  }
  
  private void Qq()
  {
    if ((this.Ig == null) || (this.Ig.size() == 0)) {
      return;
    }
    ausj localausj = (ausj)auss.a(getActivity(), null);
    Iterator localIterator = this.Ig.iterator();
    while (localIterator.hasNext()) {
      localausj.addButton((String)localIterator.next());
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new apqj(this, localausj));
    localausj.show();
  }
  
  private void ebi()
  {
    int i = this.k.getText().length();
    if (i > 300) {}
    for (ColorStateList localColorStateList = getResources().getColorStateList(2131167439);; localColorStateList = getResources().getColorStateList(2131167385))
    {
      String str = i + "/" + 300;
      if (localColorStateList != null) {
        this.abc.setTextColor(localColorStateList);
      }
      this.abc.setText(str);
      return;
    }
  }
  
  private void ebj()
  {
    int m = 8;
    boolean bool2 = true;
    int j = this.k.length();
    int n = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci.size();
    int i;
    label52:
    label59:
    Object localObject;
    if (n > 0)
    {
      i = 1;
      if ((j < 1) || (j > 300) || (i == 0)) {
        break label193;
      }
      bool1 = true;
      if (n <= 0) {
        break label199;
      }
      j = 1;
      localObject = String.format(Locale.getDefault(), "（%d个）", new Object[] { Integer.valueOf(n) });
      this.abb.setText((CharSequence)localObject);
      localObject = this.abb;
      if (j == 0) {
        break label204;
      }
      j = 0;
      label102:
      ((TextView)localObject).setVisibility(j);
      this.hr.setEnabled(bool1);
      this.hr.setClickable(bool1);
      localObject = this.IN;
      j = m;
      if (i != 0) {
        j = 0;
      }
      ((View)localObject).setVisibility(j);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci.size() >= this.dVn) {
        break label210;
      }
    }
    label193:
    label199:
    label204:
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).cRV = bool1;
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.notifyDataSetChanged();
      return;
      i = 0;
      break;
      bool1 = false;
      break label52;
      j = 0;
      break label59;
      j = 8;
      break label102;
    }
  }
  
  private void initUI()
  {
    this.k = ((ClearableEditText)this.mContentView.findViewById(2131366257));
    this.k.setClearButtonStyle(1);
    Object localObject = this.k.getLayoutParams();
    this.k.setSingleLine(false);
    this.k.setFilters(new InputFilter[] { new InputFilter.LengthFilter(300) });
    int i = this.k.getText().length();
    this.k.setSelection(i, i);
    this.k.setGravity(48);
    this.k.addTextChangedListener(this);
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = ((int)(150.0F * this.mDensity));
      this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.k.setHint(acfp.m(2131703284));
    this.k.setOnTouchListener(new apqg(this));
    this.mContentView.setOnTouchListener(new apqh(this));
    this.IN = this.mContentView.findViewById(2131363850);
    this.IN.setOnClickListener(this);
    this.abb = ((TextView)this.mContentView.findViewById(2131381082));
    this.jdField_d_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)this.mContentView.findViewById(2131381394));
    this.jdField_d_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a);
    this.hr = ((Button)this.mContentView.findViewById(2131363985));
    this.hr.setText(acfp.m(2131703292));
    this.hr.setOnClickListener(this);
    this.hr.setEnabled(false);
    this.IO = this.mContentView.findViewById(2131370282);
    this.mContentView.findViewById(2131363988).setOnClickListener(this);
    this.abc = ((TextView)this.mContentView.findViewById(2131381093));
    if (this.Ig.size() == 0) {
      this.mContentView.findViewById(2131378301).setVisibility(8);
    }
    for (;;)
    {
      setTitle(acfp.m(2131703278));
      ebj();
      ebi();
      localObject = aqfr.r(this.mApp, this.mTroopUin);
      aqfr.b("Grp_edu", "MassMessage", "CreateMessage_Show", 0, 0, new String[] { this.mTroopUin, localObject });
      return;
      this.mContentView.findViewById(2131378301).setOnClickListener(new apqi(this));
    }
  }
  
  public static void p(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.start(paramActivity, localIntent, BulkSendMessageFragment.class);
    paramActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  protected void a(b paramb, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramb.imageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_d_of_type_Aqdf.b(1, paramb.uin, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = aqhu.G();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_d_of_type_Aqdf.isPausing())
        {
          this.jdField_d_of_type_Aqdf.i(paramb.uin, 1, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramb.imageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    ebj();
    ebi();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mTroopUin = getActivity().getIntent().getStringExtra("extra.GROUP_UIN");
    this.mApp = QQStoryContext.a();
    this.jdField_d_of_type_Aqdf = new aqdf(getActivity(), this.mApp);
    this.jdField_d_of_type_Aqdf.a(this);
    this.mHandler = new Handler();
    paramLayoutInflater = ((aprp)this.mApp.getManager(109)).u("BulkChatMessageConfig");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "ReadConfig: ", String.valueOf(paramLayoutInflater) });
    }
    if (paramLayoutInflater != null)
    {
      this.dVn = paramLayoutInflater.optInt("user_limit", this.dVn);
      if (paramLayoutInflater.optJSONArray("hints") == null) {}
    }
    initUI();
    this.mApp.addObserver(this.b);
    this.jdField_a_of_type_Jnn = new jnn(this.mContentView, this, ImmersiveUtils.getStatusBarHeight(getActivity()) + 160);
  }
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.mHandler.removeCallbacks(this.hJ);
      this.IO.setVisibility(8);
      return;
    }
    this.mHandler.postDelayed(this.hJ, 10L);
  }
  
  public int getContentLayoutId()
  {
    return 2131560768;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if ((paramInt2 != -1) || (paramIntent == null)) {
          break;
        }
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
        if (QLog.isColorLevel())
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext()) {
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", ((ResultRecord)paramIntent.next()).uin });
          }
        }
      }
      QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null!", new NullPointerException());
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringArrayListExtra("extra_member_uin_list");
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = paramIntent.iterator();
          while (((Iterator)localObject).hasNext()) {
            QLog.d(".troop.troop_app.BulkSendMessageFragment.VASH", 2, new Object[] { "select uin: ", (String)((Iterator)localObject).next() });
          }
        }
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci.size() - paramIntent.size();
        if ((paramInt1 == 2) && (paramInt2 != 0))
        {
          localObject = aqfr.r(this.mApp, this.mTroopUin);
          aqfr.b("Grp_edu", "MassMessage", "MemberEdit_Complete", 0, 0, new String[] { this.mTroopUin, localObject, String.valueOf(paramInt2) });
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci = new ArrayList(paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.notifyDataSetChanged();
        ebj();
        return;
      }
      if (paramInt2 != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(".troop.troop_app.BulkSendMessageFragment", 1, new Object[] { "SelectMember canceled! requestCode: ", Integer.valueOf(paramInt1), new NullPointerException() });
    return;
    QLog.e(".troop.troop_app.BulkSendMessageFragment", 1, "Error! SelectMember return null! requestCode: " + paramInt1, new NullPointerException());
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    getActivity().overridePendingTransition(0, 2130772013);
    return bool;
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
      Object localObject = TroopMemberListActivity.c(getActivity(), this.mTroopUin, 21);
      ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci);
      ((Intent)localObject).putStringArrayListExtra("param_delete_filter_member_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci);
      ((Intent)localObject).putExtra("param_pick_max_num", this.dVn);
      ((Intent)localObject).putExtra("param_pick_title_string", acfp.m(2131703289));
      startActivityForResult((Intent)localObject, 2);
      getActivity().overridePendingTransition(2130772367, 2130772002);
      aqfr.b("Grp_edu", "MassMessage", "Member_Edit", 0, 0, new String[] { this.mTroopUin });
      continue;
      localObject = this.k.getText().toString();
      if (((String)localObject).length() < 4)
      {
        localObject = String.format(Locale.getDefault(), acfp.m(2131703283), new Object[] { Integer.valueOf(4) });
        QQToast.a(getActivity(), 1, (CharSequence)localObject, 1).show();
      }
      else if (!aqiw.isNetworkAvailable(getActivity()))
      {
        localObject = String.format(Locale.getDefault(), acfp.m(2131703287), new Object[0]);
        QQToast.a(getActivity(), 1, (CharSequence)localObject, 1).show();
      }
      else
      {
        acms localacms;
        homework.ReqSend1V1Msg localReqSend1V1Msg;
        int i;
        String str1;
        try
        {
          localacms = (acms)this.mApp.getBusinessHandler(20);
          localReqSend1V1Msg = new homework.ReqSend1V1Msg();
          i = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
          Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci.iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            localReqSend1V1Msg.to_uins.add(Long.valueOf(Long.parseLong(str2)));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          str1 = acfp.m(2131703290);
          QQToast.a(getActivity(), 1, str1, 1).show();
        }
        localReqSend1V1Msg.text.set(ByteStringMicro.copyFromUtf8(str1));
        localReqSend1V1Msg.int32_time_zone.set(i);
        localReqSend1V1Msg.group_id.set(Long.parseLong(this.mTroopUin));
        if (this.jdField_a_of_type_Rpq$b != null)
        {
          this.jdField_a_of_type_Rpq$b.dismiss();
          this.jdField_a_of_type_Rpq$b = null;
        }
        this.jdField_a_of_type_Rpq$b = rpq.a(getActivity(), acfp.m(2131703291));
        acms.i.a(localacms, localReqSend1V1Msg);
        continue;
        if (this.k.length() == 0) {
          QQToast.a(getActivity(), 1, String.format(Locale.getDefault(), acfp.m(2131703282), new Object[0]), 1).show();
        } else if (this.k.length() < 4) {
          QQToast.a(getActivity(), 1, String.format(Locale.getDefault(), acfp.m(2131703280), new Object[] { Integer.valueOf(4) }), 1).show();
        } else if (this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment$a.Ci.isEmpty()) {
          QQToast.a(getActivity(), 1, String.format(Locale.getDefault(), acfp.m(2131703288), new Object[0]), 1).show();
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_d_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_d_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof b)))
        {
          localObject = (b)localObject;
          if (paramString != null) {
            break label72;
          }
          a((b)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((b)localObject).uin))
        {
          paramInt1 += 1;
          break;
        }
        ((b)localObject).imageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mApp.removeObserver(this.b);
    this.jdField_d_of_type_Aqdf.a(null);
    this.k.removeTextChangedListener(this);
    this.jdField_a_of_type_Jnn.destroy();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  class a
    extends BaseAdapter
    implements View.OnClickListener
  {
    public ArrayList<String> Ci = new ArrayList();
    public boolean cRV = true;
    
    public a() {}
    
    public int getCount()
    {
      int j = this.Ci.size();
      if (this.cRV) {}
      for (int i = 1;; i = 0) {
        return i + j;
      }
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(this.Ci.size());
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      BulkSendMessageFragment.b localb;
      TextView localTextView;
      ImageView localImageView;
      Object localObject3;
      String str;
      Object localObject2;
      Object localObject1;
      if (paramView == null)
      {
        localView = LayoutInflater.from(BulkSendMessageFragment.this.getActivity()).inflate(2131558933, null);
        localb = new BulkSendMessageFragment.b(localView);
        localb.imageView = ((ImageView)localView.findViewById(2131368698));
        localb.textView = ((TextView)localView.findViewById(2131372190));
        localView.setTag(localb);
        localView.setVisibility(0);
        localView.setFocusable(false);
        localTextView = localb.textView;
        localImageView = localb.imageView;
        localObject3 = (acff)BulkSendMessageFragment.this.mApp.getManager(51);
        if (paramInt >= this.Ci.size()) {
          break label430;
        }
        localImageView.setImageResource(2130845854);
        localTextView.setTextColor(BulkSendMessageFragment.this.getResources().getColor(2131167393));
        str = (String)this.Ci.get(paramInt) + "";
        localb.uin = str;
        localObject2 = aqgv.h(BulkSendMessageFragment.this.mApp, BulkSendMessageFragment.this.mTroopUin, str);
        if (!TextUtils.isEmpty(str)) {
          break label310;
        }
        if (localObject2 != null) {
          break label303;
        }
        localObject1 = "";
        label224:
        localTextView.setText((CharSequence)localObject1);
        localImageView.setImageDrawable(aqhu.at());
        label239:
        localb.rootView.setTag(2131379194, null);
        localb.rootView.setOnClickListener(null);
      }
      for (;;)
      {
        if (AppSetting.enableTalkBack) {
          ViewCompat.setImportantForAccessibility(localImageView, 2);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        localb = (BulkSendMessageFragment.b)paramView.getTag();
        localView = paramView;
        break;
        label303:
        localObject1 = localObject2;
        break label224;
        label310:
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((acff)localObject3).e(str);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((Friends)localObject3).isFriend()) {
                localObject1 = aqgv.s(BulkSendMessageFragment.this.mApp, str);
              }
            }
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = acfp.m(2131703286);
        }
        localTextView.setText((CharSequence)localObject2);
        BulkSendMessageFragment.this.a(localb, null, true);
        localImageView.setTag(2131379222, str);
        localImageView.setTag(null);
        break label239;
        label430:
        localTextView.setText(BulkSendMessageFragment.this.getString(2131721053));
        localTextView.setTextColor(BulkSendMessageFragment.this.getResources().getColorStateList(2131166738));
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageResource(2130839348);
        localImageView.setEnabled(true);
        localImageView.setTag(Integer.valueOf(0));
        localb.rootView.setTag(2131379194, Integer.valueOf(0));
        localb.rootView.setOnClickListener(this);
      }
    }
    
    public void notifyDataSetChanged()
    {
      super.notifyDataSetChanged();
    }
    
    public void onClick(View paramView)
    {
      Object localObject = (Integer)paramView.getTag(2131379194);
      if (localObject == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (((Integer)localObject).intValue() == 0)
        {
          localObject = TroopMemberListActivity.c(BulkSendMessageFragment.this.getActivity(), BulkSendMessageFragment.this.mTroopUin, 20);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(BulkSendMessageFragment.this.mApp.getCurrentAccountUin());
          ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", BulkSendMessageFragment.this.a.Ci);
          ((Intent)localObject).putStringArrayListExtra("param_hide_filter_member_list", localArrayList);
          ((Intent)localObject).putExtra("param_pick_max_num", BulkSendMessageFragment.this.dVn);
          ((Intent)localObject).putExtra("param_pick_max_num_exceeds_wording", 2131699799);
          ((Intent)localObject).putExtra("param_pick_title_string", acfp.m(2131703279));
          BulkSendMessageFragment.this.startActivityForResult((Intent)localObject, 1);
          BulkSendMessageFragment.this.getActivity().overridePendingTransition(2130772367, 2130772002);
        }
      }
    }
  }
  
  public static class b
  {
    ImageView imageView;
    public View rootView;
    TextView textView;
    String uin;
    
    public b(View paramView)
    {
      this.rootView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment
 * JD-Core Version:    0.7.0.1
 */