package com.tencent.mobileqq.search.fragment;

import acfp;
import amlt;
import amms;
import ampv;
import amwd;
import amwe;
import amwt;
import amwu;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqdf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.List;

public abstract class BaseSearchFragment<M extends ampv>
  extends Fragment
  implements amwe<M>, Handler.Callback
{
  public List<M> FM;
  public View GV;
  protected View Ha;
  public View Hb;
  protected View Hc;
  protected TextView YL;
  public TextView YM;
  protected TextView YN;
  public amlt a;
  public amwd a;
  protected ListView a;
  public aqdf c;
  protected boolean cDk;
  public boolean cDx;
  public volatile boolean cDy;
  protected QQAppInterface d;
  protected int dCT;
  public Handler handler = new Handler(this);
  public boolean isReported;
  public volatile String keyword;
  protected LinearLayout ko;
  private long lastUpdateTime;
  public List<M> rc;
  
  protected boolean DS()
  {
    return true;
  }
  
  protected int IT()
  {
    return 0;
  }
  
  public void Id(String paramString)
  {
    VADHelper.PZ("voice_search_als_cost");
    fO(paramString, 1);
  }
  
  protected void Jn(boolean paramBoolean)
  {
    String str;
    int j;
    if (paramBoolean)
    {
      str = this.keyword;
      if (!TextUtils.isEmpty(this.keyword)) {
        break label149;
      }
      str = getString(2131719292);
      j = getResources().getColor(2131167383);
    }
    for (int i = 8;; i = 0)
    {
      this.ko.setVisibility(0);
      this.ko.findViewById(2131372441).setVisibility(i);
      this.ko.findViewById(2131372438).setVisibility(i);
      this.ko.findViewById(2131372442).setVisibility(i);
      TextView localTextView = (TextView)this.ko.findViewById(2131372439);
      localTextView.setText(str);
      localTextView.setTextColor(j);
      this.Hc.setVisibility(8);
      this.Ha.setVisibility(8);
      Jp(false);
      return;
      this.ko.setVisibility(8);
      return;
      label149:
      j = -16734752;
    }
  }
  
  public void Jp(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.YN != null)
    {
      localTextView = this.YN;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void Ps(boolean paramBoolean)
  {
    if (this.cDk != paramBoolean)
    {
      this.cDk = paramBoolean;
      if ((this.jdField_a_of_type_Amwd != null) && ((this.jdField_a_of_type_Amwd instanceof GroupSearchEngine))) {
        ((GroupSearchEngine)this.jdField_a_of_type_Amwd).Ps(paramBoolean);
      }
    }
  }
  
  protected abstract amlt a();
  
  protected abstract amwd a();
  
  public void a(List<M> paramList, amwu paramamwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with respData:", paramamwu.toString() });
    }
    if (paramamwu.oI(this.keyword)) {
      s(paramList, paramamwu.status);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramamwu.keyword, " keyword2:", this.keyword });
  }
  
  protected void b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "startSearch, key: " + paramString + getClass());
    }
    FragmentActivity localFragmentActivity = super.getActivity();
    boolean bool;
    if ((localFragmentActivity instanceof BaseSearchActivity))
    {
      bool = ((BaseSearchActivity)localFragmentActivity).cDh;
      Jp(false);
      if ((!TextUtils.isEmpty(paramString)) || (bool) || (this.jdField_a_of_type_Amlt == null)) {
        break label188;
      }
      this.YL.setVisibility(8);
      this.Hc.setVisibility(8);
      this.Hb.setVisibility(8);
      this.YM.setVisibility(8);
      Jp(false);
      Jn(false);
      this.Ha.setVisibility(8);
      this.jdField_a_of_type_Amwd.cancel();
      removeAllMessage();
      if (this.jdField_a_of_type_Amlt != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_Amlt;
        this.rc = null;
        paramArrayOfByte.cS(null);
      }
      this.keyword = paramString;
    }
    label188:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.keyword = paramString;
      } while (this.jdField_a_of_type_ComTencentWidgetListView == null);
      switch (paramInt)
      {
      default: 
        removeAllMessage();
        showLoading();
        this.YL.setVisibility(8);
      }
    } while (!this.cDy);
    this.dCT += 1;
    if ((localFragmentActivity instanceof BaseSearchActivity)) {}
    for (String str = ((BaseSearchActivity)localFragmentActivity).caK;; str = null)
    {
      if (str != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("search_restrict_mem", str);
        localBundle.putString("search_restrict_uin", ((BaseSearchActivity)localFragmentActivity).caL);
        localBundle.putBoolean("search_restrict_empty", bool);
        localBundle.putInt("search_restrict_uintype", ((BaseSearchActivity)localFragmentActivity).dCF);
        this.jdField_a_of_type_Amwd.a(new amwt(paramString, paramArrayOfByte, localBundle), this);
        return;
        this.jdField_a_of_type_Amwd.cancel();
        break;
        this.jdField_a_of_type_Amwd.pause();
        break;
      }
      this.jdField_a_of_type_Amwd.a(new amwt(paramString, paramArrayOfByte), this);
      return;
    }
  }
  
  public void cR(List<M> paramList)
  {
    this.rc = paramList;
    long l = System.currentTimeMillis();
    if (l - this.lastUpdateTime >= 300L)
    {
      this.handler.removeMessages(1);
      this.handler.sendEmptyMessage(1);
      return;
    }
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessageDelayed(1, 300L - (l - this.lastUpdateTime));
  }
  
  protected void fO(String paramString, int paramInt)
  {
    b(paramString, null, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.lastUpdateTime = System.currentTimeMillis();
      mf(this.rc);
      continue;
      mg(this.rc);
      continue;
      mh(this.rc);
    }
  }
  
  public void hideLoading()
  {
    View localView = this.Ha;
    if (DS()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.Hc.setVisibility(8);
      Jn(false);
      return;
    }
  }
  
  protected void mf(List<M> paramList)
  {
    hideLoading();
    this.jdField_a_of_type_Amlt.cS(paramList);
    this.YL.setVisibility(0);
  }
  
  protected void mg(List<M> paramList)
  {
    hideLoading();
    this.jdField_a_of_type_Amlt.cS(paramList);
    this.YL.setVisibility(8);
    if (this.jdField_a_of_type_Amlt.getCount() <= 0) {
      if ((getActivity() instanceof PublicAcntSearchActivity)) {
        Jn(false);
      }
    }
    for (;;)
    {
      VADHelper.eR(getActivity());
      return;
      Jn(true);
      continue;
      Jp(true);
    }
  }
  
  protected void mh(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.jdField_a_of_type_Amlt.getCount() <= 0)
    {
      hideLoading();
      Jn(true);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof BaseActivity))
    {
      this.d = ((BaseActivity)paramActivity).app;
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Amwd = a();
    if ((this.cDk) && (this.jdField_a_of_type_Amwd != null) && ((this.jdField_a_of_type_Amwd instanceof GroupSearchEngine))) {
      ((GroupSearchEngine)this.jdField_a_of_type_Amwd).Ps(true);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561651, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup.findViewById(2131370527));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new amms(this));
    this.Ha = paramViewGroup.findViewById(2131368466);
    paramBundle = this.Ha;
    int i;
    if (DS())
    {
      i = 0;
      paramBundle.setVisibility(i);
      ((TextView)paramViewGroup.findViewById(2131368427)).setText(vn());
      this.Hc = paramViewGroup.findViewById(2131364393);
      this.ko = ((LinearLayout)paramViewGroup.findViewById(2131372440));
      paramBundle = (TextView)this.ko.findViewById(2131372442);
      if (!(paramLayoutInflater.getContext() instanceof ContactSearchActivity)) {
        break label355;
      }
      paramBundle.setText(acfp.m(2131703148));
    }
    for (;;)
    {
      paramBundle = paramLayoutInflater.inflate(2131561428, null, false);
      this.YL = ((TextView)paramBundle.findViewById(2131367460));
      this.YL.setText(acfp.m(2131703149));
      this.YL.setVisibility(8);
      this.YN = ((TextView)paramBundle.findViewById(2131372427));
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramBundle = paramLayoutInflater.inflate(2131560603, null, false);
      this.Hb = paramBundle.findViewById(2131367460);
      this.Hb.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramBundle);
      paramLayoutInflater = paramLayoutInflater.inflate(2131561428, null, false);
      this.YM = ((TextView)paramLayoutInflater.findViewById(2131367460));
      this.YM.setText(acfp.m(2131703154));
      this.YM.setTextSize(16.0F);
      this.YM.setTextColor(getActivity().getResources().getColor(2131167385));
      this.YM.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(paramLayoutInflater);
      this.GV = paramViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
      i = 8;
      break;
      label355:
      if (((paramLayoutInflater.getContext() instanceof MessageSearchActivity)) || ((paramLayoutInflater.getContext() instanceof FTSEntitySearchActivity))) {
        paramBundle.setText(acfp.m(2131703150));
      } else if ((paramLayoutInflater.getContext() instanceof FunctionSearchActivity)) {
        paramBundle.setText(vn());
      } else if ((paramLayoutInflater.getContext() instanceof FileSearchActivity)) {
        paramBundle.setText(acfp.m(2131703147));
      } else if ((paramLayoutInflater.getContext() instanceof FavoriteSearchActivity)) {
        paramBundle.setText(acfp.m(2131703151));
      } else if ((paramLayoutInflater.getContext() instanceof PublicAcntSearchActivity)) {
        paramBundle.setText(acfp.m(2131703152));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this instanceof GroupSearchFragment)) {}
    do
    {
      return;
      if (this.c != null) {
        this.c.destory();
      }
      anot.a(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", IT(), 0, String.valueOf(this.dCT), "", this.keyword, "");
    } while (!this.cDy);
    this.cDy = false;
    this.jdField_a_of_type_Amwd.destroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.c = new aqdf(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Amlt = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Amlt);
    hideLoading();
    if ((super.getActivity() instanceof BaseSearchActivity)) {}
    for (boolean bool = ((BaseSearchActivity)super.getActivity()).cDh;; bool = false)
    {
      ThreadManager.postImmediately(new BaseSearchFragment.2(this, bool), null, true);
      return;
    }
  }
  
  protected void removeAllMessage()
  {
    this.handler.removeMessages(4);
    this.handler.removeMessages(1);
  }
  
  public void s(List<M> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    VADHelper.Qa("voice_search_als_cost");
    VADHelper.Qa("voice_search_all_cost");
    this.rc = paramList;
    Ps(false);
    removeAllMessage();
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessage(4);
  }
  
  public void showLoading()
  {
    if ((this.jdField_a_of_type_Amlt == null) || (this.jdField_a_of_type_Amlt.getCount() == 0))
    {
      this.Hc.setVisibility(0);
      this.Ha.setVisibility(8);
    }
  }
  
  protected String vn()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.BaseSearchFragment
 * JD-Core Version:    0.7.0.1
 */