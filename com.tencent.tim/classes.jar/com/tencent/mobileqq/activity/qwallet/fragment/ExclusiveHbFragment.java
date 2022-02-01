package com.tencent.mobileqq.activity.qwallet.fragment;

import aaan;
import aaay;
import aabk;
import aagd;
import acdu;
import acff;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqdj;
import aqgx;
import aqnm;
import avor;
import avox;
import avox.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ExclusiveHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private TextView NE;
  private avox.a a = new avox.a();
  private EditText aX;
  private EditText aY;
  private String bbD;
  private String bbE;
  private String bcb = "";
  private Button cU;
  private int cfR;
  private LinearLayout hS;
  private int mNum;
  protected TextWatcher mTextWatcher = new aaan(this);
  private long mlastInvalidatetime;
  private ArrayList<String> rV = new ArrayList();
  
  private void Ca(boolean paramBoolean)
  {
    this.cU.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.cU.setText(getString(2131699008));
    }
  }
  
  private ArrayList<ArrayList<String>> b(Intent paramIntent)
  {
    if (this.mActivity == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    QQAppInterface localQQAppInterface;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ResultRecord localResultRecord;
    Object localObject2;
    try
    {
      localQQAppInterface = (QQAppInterface)this.mActivity.getAppInterface();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      if (paramIntent == null) {
        return localArrayList1;
      }
      Object localObject1 = paramIntent.getParcelableArrayListExtra("result_set");
      if (localObject1 != null)
      {
        paramIntent = (acff)this.mActivity.getAppInterface().getManager(51);
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localResultRecord = (ResultRecord)((Iterator)localObject1).next();
            if (!TextUtils.isEmpty(localResultRecord.uin))
            {
              localArrayList2.add(localResultRecord.uin);
              if (TextUtils.isEmpty(localResultRecord.name))
              {
                if (!this.bbD.equals("1")) {
                  break;
                }
                localObject2 = paramIntent.e(localResultRecord.uin);
                if (localObject2 != null) {
                  localResultRecord.name = ((Friends)localObject2).getFriendNick();
                }
              }
              if (!TextUtils.isEmpty(localResultRecord.name))
              {
                localArrayList3.add(localResultRecord.name);
                continue;
                return localArrayList1;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e("ExclusiveHbFragment", 1, paramIntent, new Object[0]);
    }
    for (;;)
    {
      if (this.bbD.equals("2"))
      {
        localObject2 = ((acdu)localQQAppInterface.getManager(53)).a(this.bbE, localResultRecord.uin);
        if (localObject2 == null) {
          break;
        }
        localResultRecord.name = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
        break;
      }
      if (!this.bbD.equals("3")) {
        break;
      }
      localObject2 = aqgx.a().a(localQQAppInterface, this.bbE, localResultRecord.uin);
      if (localObject2 == null) {
        break;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark))
      {
        localResultRecord.name = ((TroopMemberInfo)localObject2).autoremark;
        break;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))
      {
        localResultRecord.name = ((TroopMemberInfo)localObject2).troopnick;
        break;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick))
      {
        localResultRecord.name = ((TroopMemberInfo)localObject2).friendnick;
        break;
      }
      localResultRecord.name = ((TroopMemberInfo)localObject2).memberuin;
      break;
      localArrayList1.add(localArrayList2);
      localArrayList1.add(localArrayList3);
    }
  }
  
  private void cti()
  {
    int i;
    label38:
    TextView localTextView;
    if (this.cfR == 1)
    {
      i = 2130848029;
      this.NE.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
      localObject = this.NE;
      if (this.cfR != 1) {
        break label100;
      }
      i = 2131699001;
      ((TextView)localObject).setText(i);
      localTextView = this.NE;
      if (this.cfR != 1) {
        break label106;
      }
    }
    label100:
    label106:
    for (Object localObject = acfp.m(2131705970) + getString(2131699001);; localObject = acfp.m(2131705962) + getString(2131699000))
    {
      localTextView.setContentDescription((CharSequence)localObject);
      freshConfirmBtn();
      return;
      i = 2130848028;
      break;
      i = 2131699000;
      break label38;
    }
  }
  
  private void ctj()
  {
    this.rV.clear();
    this.hS.removeAllViews();
    this.hS.setContentDescription(acfp.m(2131705963));
    TextView localTextView = new TextView(getActivity());
    localTextView.setText(acfp.m(2131705964));
    localTextView.setSingleLine();
    localTextView.setTextSize(15.0F);
    localTextView.setTextColor(getActivity().getResources().getColor(2131166450));
    aagd.k(this.hS, 0.6F);
    this.hS.addView(localTextView);
    freshConfirmBtn();
  }
  
  private void freshConfirmBtn()
  {
    if ((this.rV.isEmpty()) || (TextUtils.isEmpty(this.aX.getText().toString())))
    {
      Ca(false);
      return;
    }
    this.bcb = String.valueOf(getAmount());
    Ca(true);
    String str = getString(2131699008) + this.bcb + acfp.m(2131705965);
    this.cU.setText(str);
  }
  
  private void initData()
  {
    this.cfR = 2;
    cti();
    ctj();
  }
  
  private void initView(View paramView, Bundle paramBundle)
  {
    avox.a(paramBundle, this.a);
    this.bbD = this.a.recv_type;
    this.bbE = paramBundle.getString("recv_uin");
    this.aX = ((EditText)paramView.findViewById(2131362698));
    this.aX.addTextChangedListener(this.mTextWatcher);
    this.cU = ((Button)paramView.findViewById(2131363826));
    this.aY = ((EditText)paramView.findViewById(2131366550));
    this.NE = ((TextView)paramView.findViewById(2131380748));
    this.NE.setOnClickListener(this);
    this.hS = ((LinearLayout)paramView.findViewById(2131370631));
    this.hS.setOnClickListener(this);
    this.cU.setOnClickListener(this);
    this.aY.setHint(aabk.a(this.channel, this.a, this.mActivity.a(), acfp.m(2131705967)));
    paramView.findViewById(2131369703).setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.i("ExclusiveHbFragment", 2, "bizParams:" + this.a.biz_params);
    }
  }
  
  private String o(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label75;
      }
      try
      {
        localStringBuffer.append((String)paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuffer.append("|");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    label75:
    return localStringBuffer.toString();
  }
  
  private void onConfirmClick()
  {
    long l = System.currentTimeMillis();
    if (this.mlastInvalidatetime + 1000L > l) {
      return;
    }
    this.mlastInvalidatetime = l;
    Map localMap = this.mActivity.Y();
    String str;
    try
    {
      str = o(this.rV);
      if ((this.rV.isEmpty()) || (TextUtils.isEmpty(str)))
      {
        this.mActivity.l(acfp.m(2131705966));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ExclusiveHbFragment", 1, localException, new Object[0]);
      return;
    }
    localException.put("grab_uin_list", str);
    this.bcb = String.valueOf(getAmount());
    combineUploadData(this.a, this.channel, this.mNum, avor.hX(this.bcb), "only.wrappacket.wrap");
    localException.put("type", String.valueOf(1));
    localException.put("wishing", aabk.c(this.aY));
    localException.put("bus_type", this.cfR + "");
    localException.put("total_num", this.mNum + "");
    localException.put("total_amount", avor.hX(this.bcb));
    localException.put("channel", String.valueOf(this.channel));
    this.mLogic.Z(localException);
  }
  
  public void dm(ArrayList<ArrayList<String>> paramArrayList)
  {
    if ((isDetached()) || (this.hS == null)) {
      return;
    }
    ArrayList localArrayList;
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      localArrayList = (ArrayList)paramArrayList.get(0);
      paramArrayList = (ArrayList)paramArrayList.get(1);
    }
    for (;;)
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.rV.clear();
        this.rV.addAll(localArrayList);
        this.hS.removeAllViews();
        int j = localArrayList.size();
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              String str = (String)localArrayList.get(i);
              ImageView localImageView = new ImageView(getActivity());
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqnm.dpToPx(32.0F), aqnm.dpToPx(32.0F));
              localLayoutParams.setMargins(-aqnm.dip2px(5.0F), 0, 0, 0);
              localImageView.setLayoutParams(localLayoutParams);
              localImageView.setImageDrawable(aqdj.a((QQAppInterface)getActivity().getAppRuntime(), 1, str));
              this.hS.addView(localImageView);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i = 0;
          while (i < paramArrayList.size())
          {
            if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i))) {
              localStringBuffer.append((String)paramArrayList.get(i));
            }
            localStringBuffer.append(" ,");
            i += 1;
          }
        }
        if (!TextUtils.isEmpty(localStringBuffer)) {
          this.hS.setContentDescription(acfp.m(2131705969) + j + acfp.m(2131705968) + localStringBuffer.toString());
        }
        freshConfirmBtn();
        return;
      }
      ctj();
      return;
      paramArrayList = null;
      localArrayList = null;
    }
  }
  
  protected float getAmount()
  {
    this.mNum = this.rV.size();
    float f2 = avor.h(this.aX.getText().toString());
    float f1 = f2;
    if (this.cfR == 1) {
      f1 = f2 * this.mNum;
    }
    return f1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1) && (paramIntent != null)) {
      dm(b(paramIntent));
    }
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
      this.mActivity.zY("only.wrappacket.wrap");
      onConfirmClick();
      continue;
      if (this.cfR == 1) {}
      for (this.cfR = 2;; this.cfR = 1)
      {
        cti();
        break;
      }
      long l = System.currentTimeMillis();
      if (this.mlastInvalidatetime + 1200L <= l)
      {
        this.mlastInvalidatetime = l;
        this.mActivity.s(this.a.recv_type, this.rV);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562110, null);
    initView(paramLayoutInflater, getArguments());
    initData();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("ExclusiveHbFragment", 2, "ExclusiveHb enter...");
      if (this.mActivity != null) {
        this.mActivity.zY("only.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ExclusiveHbFragment
 * JD-Core Version:    0.7.0.1
 */