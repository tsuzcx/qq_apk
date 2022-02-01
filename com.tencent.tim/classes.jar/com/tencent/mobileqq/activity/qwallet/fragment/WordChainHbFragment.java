package com.tencent.mobileqq.activity.qwallet.fragment;

import aaay;
import aabg;
import aabh;
import aabj;
import aabk;
import aabt;
import aabu;
import aabv;
import aaby;
import acfp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import aqfo;
import aqiw;
import aqmr;
import avor;
import avox;
import avox.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import zxj;

public class WordChainHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static final CopyOnWriteArrayList<String> C = new CopyOnWriteArrayList();
  private static long LL;
  private static SharedPreferences sp = BaseApplicationImpl.getApplication().getSharedPreferences("red_packet", 0);
  private TextView NL;
  private TextView NM;
  private TextView NN;
  private aabt jdField_a_of_type_Aabt;
  private IdiomHbBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo = new IdiomHbBundleInfo();
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  private SparseArray<String> bM = new SparseArray();
  private String bcn;
  private boolean buU = true;
  public boolean buV;
  private zxj c;
  private long iu;
  private ArrayList<b> labels = new ArrayList();
  
  private void FO(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_Aabt != null))
    {
      InputFilter[] arrayOfInputFilter = this.jdField_a_of_type_Aabt.a(paramInt);
      this.aW.setFilters(arrayOfInputFilter);
    }
  }
  
  private aabt a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new aabu();
    case 1: 
      return new aaby();
    }
    return new aabv();
  }
  
  private void a(TextView paramTextView, b paramb)
  {
    paramTextView.setBackgroundDrawable(getResources().getDrawable(2130848162));
    paramTextView.setTextColor(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && ((paramTextView.getTag() instanceof b)))
    {
      b localb = (b)paramTextView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = localb.subChannel;
      this.jdField_a_of_type_Aabt = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
      this.NL.setText("");
      this.NL.setText(this.NL.getText() + paramTextView.getText().toString());
      if (this.buU) {
        sp.edit().putInt("sp_key_last_selete_label", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel).apply();
      }
      FO(paramb.maxLength);
      C.clear();
      if (this.aW != null)
      {
        this.aW.setText((CharSequence)this.bM.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
        if (!TextUtils.isEmpty(paramb.hint)) {
          this.aW.setHint(paramb.hint);
        }
      }
    }
  }
  
  private void a(a parama)
  {
    int i = 2;
    for (;;)
    {
      try
      {
        if (this.buV) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WordChainHbFragment", 2, "is getIdiomListFromSSO...");
        }
        this.buV = true;
        if (!avox.LI.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type)) {
          break label113;
        }
        if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
        {
          if (this.c == null) {
            break;
          }
          this.c.a(new aabh(this, parama), i, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
          return;
        }
      }
      catch (Throwable parama)
      {
        QLog.e("WordChainHbFragment", 1, parama, new Object[0]);
        return;
      }
      i = 1;
      continue;
      label113:
      i = 0;
    }
  }
  
  private void ctA()
  {
    if (this.NN != null)
    {
      this.NN.setBackgroundDrawable(getResources().getDrawable(2130848161));
      this.NN.setTextColor(Color.parseColor("#03081A"));
    }
  }
  
  private void ctB()
  {
    ctz();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new WordChainHbFragment.1(this));
  }
  
  private void ctC()
  {
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout != null)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.getChildCount();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.getChildAt(i);
        if ((localObject instanceof TextView))
        {
          localObject = (TextView)localObject;
          b localb = (b)((TextView)localObject).getTag();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel == localb.subChannel))
          {
            a((TextView)localObject, localb);
            this.NN = ((TextView)localObject);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void ctD()
  {
    j = 0;
    i = j;
    if (!aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params)) {}
    try
    {
      this.buU = false;
      localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      String str = ((JSONObject)localObject).optString("idiom", "");
      int k = ((JSONObject)localObject).optInt("sub_channel", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = k;
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        this.aW.setText(str);
        this.bM.put(k, str);
        i = 1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        localJSONException.printStackTrace();
        i = j;
      }
    }
    if (i == 0)
    {
      localObject = aabk.a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo, this.mActivity.a(), qf());
      this.aW.setHint((CharSequence)localObject);
    }
  }
  
  private void ctz()
  {
    if ((this.mActivity != null) && (this.mActivity.a() != null)) {
      this.labels = this.mActivity.a().a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    }
    if ((this.labels == null) || (this.labels.isEmpty()))
    {
      b localb = new b();
      localb.name = acfp.m(2131721903);
      localb.subChannel = 0;
      localb.maxLength = 4;
      this.labels.add(localb);
    }
  }
  
  private String n(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_Aabt != null))
      {
        String str = this.jdField_a_of_type_Aabt.a(C, paramBoolean);
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WordChainHbFragment", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void onConfirmClick()
  {
    long l = System.currentTimeMillis();
    if (this.iu + 1000L > l) {
      return;
    }
    this.iu = l;
    String str1 = this.numTxt.getText().toString();
    String str2 = this.aV.getText().toString();
    Map localMap = this.mActivity.Y();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.bcn);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", avor.hX(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId);
    }
    localMap.put("subchannel", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel + "");
    this.mLogic.Z(localMap);
  }
  
  public boolean Wa()
  {
    if (super.Wa())
    {
      this.bcn = this.aW.getText().toString().trim();
      if (this.jdField_a_of_type_Aabt != null) {
        this.cU.setEnabled(this.jdField_a_of_type_Aabt.iJ(this.bcn));
      }
    }
    return this.cU.isEnabled();
  }
  
  public void ao(Bundle paramBundle)
  {
    super.ao(paramBundle);
    avox.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("WordChainHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
    }
    if (avox.LH.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
    {
      this.numTxt.setText("1");
      this.view.findViewById(2131380131).setVisibility(8);
    }
    for (;;)
    {
      this.view.findViewById(2131369699).setOnClickListener(this);
      this.cU.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.view.findViewById(2131367208));
      this.NL = ((TextView)this.view.findViewById(2131380923));
      this.NM = ((TextView)this.view.findViewById(2131380751));
      if (QLog.isColorLevel())
      {
        QLog.i("WordChainHbFragment", 2, "isFlyMe: " + aqfo.isFlyme() + " isMeizu:" + aqfo.isMeizu());
        QLog.i("WordChainHbFragment", 2, "biz_params: " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num)) {
        this.numTxt.setHint(acfp.m(2131707369) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num + acfp.m(2131707373));
      }
      this.numTxt.addTextChangedListener(this.mTextWatcher);
    }
  }
  
  public int getLayout()
  {
    return 2131562112;
  }
  
  public void initData()
  {
    this.aW.addTextChangedListener(this.mTextWatcher);
    ctD();
    cth();
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
      this.mActivity.zY("idiom.wrappacket.wrap");
      onConfirmClick();
      continue;
      this.mActivity.zY("idiom.wrappacket.random");
      long l = System.currentTimeMillis();
      if (this.iu + 100L <= l)
      {
        this.iu = l;
        String str = n(false);
        if (TextUtils.isEmpty(str))
        {
          if (!aqiw.isNetworkAvailable(this.mActivity))
          {
            str = n(true);
            this.aW.setText(str);
            this.bM.put(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, str);
            this.aW.setSelection(this.aW.getText().length());
          }
          else
          {
            a(new aabg(this));
          }
        }
        else
        {
          this.aW.setText(str);
          this.bM.put(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, str);
          this.aW.setSelection(this.aW.getText().length());
        }
      }
    }
  }
  
  protected void onLazyLoad()
  {
    super.onLazyLoad();
    this.c = ((zxj)this.mQApp.getManager(125));
    if ((C.isEmpty()) || (System.currentTimeMillis() - LL > 86400000L)) {
      a(null);
    }
    ctB();
  }
  
  protected String qf()
  {
    return acfp.m(2131707365);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("WordChainHbFragment", 2, "idiom enter...");
      if (this.mActivity != null) {
        this.mActivity.zY("idiom.wrappacket.show");
      }
    }
  }
  
  public static class IdiomHbBundleInfo
    extends avox.a
  {
    public int currSelectedSubChannel = WordChainHbFragment.m().getInt("sp_key_last_selete_label", 0);
    public String skinId;
  }
  
  public static abstract interface a
  {
    public abstract void G(boolean paramBoolean, List<String> paramList);
  }
  
  public static class b
  {
    public String hint;
    public int maxLength;
    public String name;
    public int subChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment
 * JD-Core Version:    0.7.0.1
 */