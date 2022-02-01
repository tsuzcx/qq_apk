package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kxm;
import lbz;
import lcc;
import lce;
import mon;
import mox;
import org.json.JSONObject;

public class ReadInJoySelectMemberAQFragment
  extends ReadInJoySelectMemberFragment
{
  private int aTK = 10000;
  public boolean afc;
  private String aju = "";
  private boolean ant;
  lce e = new mon(this);
  protected arhz j;
  private int mResultCode = -1;
  private int mTitleBarHeight;
  
  private String a(ResultRecord paramResultRecord, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ask_rowkey", paramString);
      localJSONObject.put("uin", String.valueOf(kxm.getLongAccountUin()));
      localJSONObject.put("invite_uin", paramResultRecord.getUin());
      localJSONObject.put("invite_type", paramResultRecord.getType());
      return localJSONObject.toString();
    }
    catch (Exception paramResultRecord)
    {
      for (;;)
      {
        paramResultRecord.printStackTrace();
      }
    }
  }
  
  private void nV(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.executeOnSubThread(new ReadInJoySelectMemberAQFragment.3(this, this.b, this.a.getRowKey()));
    }
  }
  
  protected void R(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.j != null)
    {
      this.j.setMessage(paramInt1);
      if (!this.j.isShowing())
      {
        this.j.show();
        this.rightViewText.postDelayed(new ReadInJoySelectMemberAQFragment.1(this, paramInt2), paramInt3);
      }
    }
  }
  
  public void aAt()
  {
    if ((this.j != null) && (this.j.isShowing())) {
      this.j.dismiss();
    }
  }
  
  protected void aQN()
  {
    if (getActivity() == null) {}
    do
    {
      return;
      aQS();
      if (aqiw.isNetworkAvailable(getActivity())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarFragment", 2, "network error!");
    return;
    R(2131718507, 2131718504, this.aTK);
    lbz.a().a(this.b, kxm.getLongAccountUin(), this.a.getRowKey());
  }
  
  public void aQO()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_callback", this.a.kh());
    localIntent.putExtra("result_msg", this.aju);
    localIntent.putExtra("result_code", this.mResultCode);
    getActivity().setResult(-1, localIntent);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mTitleBarHeight = getActivity().getResources().getDimensionPixelSize(2131299627);
    if (this.j == null)
    {
      this.j = new arhz(getActivity(), this.mTitleBarHeight);
      this.j.setCanceledOnTouchOutside(true);
    }
    lcc.a().b(this.e);
  }
  
  public boolean onBackEvent()
  {
    this.mResultCode = 1;
    if (this.ant) {
      this.mResultCode = 2;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.j != null)
    {
      this.j.dismiss();
      this.j = null;
    }
    lcc.a().c(this.e);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment
 * JD-Core Version:    0.7.0.1
 */