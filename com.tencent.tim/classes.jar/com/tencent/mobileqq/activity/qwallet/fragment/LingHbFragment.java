package com.tencent.mobileqq.activity.qwallet.fragment;

import aaai;
import aaap;
import aaaq;
import aaar;
import aaas;
import aaat;
import aaay;
import aabk;
import aagd;
import acfp;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avor;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class LingHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private ChooseItemView a;
  private int cfS = 5;
  private RelativeLayout iH;
  private List<String> uX = new ArrayList();
  
  private void ctn()
  {
    if (!Wb()) {}
    int i;
    String str1;
    String str2;
    do
    {
      return;
      i = avor.c(this.numTxt.getText().toString(), 1);
      str1 = avor.hX(String.valueOf(avor.h(this.aV.getText().toString())));
      if (TextUtils.isEmpty(str1))
      {
        QQToast.a(getActivity(), 2131694575, 0).show();
        return;
      }
      str2 = qh();
    } while (TextUtils.isEmpty(str2));
    combineUploadData(this.jdField_a_of_type_Avox$a, this.channel, i, str1, "hongbao.wrap.go");
    Map localMap = this.mActivity.Y();
    localMap.put("channel", String.valueOf(this.channel));
    localMap.put("type", "1");
    localMap.put("wishing", str2);
    localMap.put("total_num", i + "");
    localMap.put("total_amount", str1);
    this.mLogic.Z(localMap);
  }
  
  public boolean Wa()
  {
    if ((super.Wa()) && (TextUtils.isEmpty(qg()))) {
      this.cU.setEnabled(false);
    }
    return this.cU.isEnabled();
  }
  
  public void ao(Bundle paramBundle)
  {
    super.ao(paramBundle);
    QLog.i("LingHbFragment", 2, "init view...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(this.mActivity);
    this.iH = ((RelativeLayout)this.view.findViewById(2131370211));
    this.cU.setOnClickListener(this);
    this.aW.addTextChangedListener(this.mTextWatcher);
    if (this.channel == 65536) {
      ((TextView)this.view.findViewById(2131380751)).setText(2131694579);
    }
  }
  
  public void ctm()
  {
    Object localObject = ((aaai)getActivity().app.getManager(245)).getConfig("hb_recommend");
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("control");
        if (localJSONObject != null)
        {
          this.cfS = localJSONObject.optInt("num_per_page", 5);
          if (this.cfS <= 0) {
            this.cfS = 5;
          }
        }
        long l1 = NetConnInfoCenter.getServerTimeMillis();
        localObject = ((JSONObject)localObject).optJSONArray("recommends");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label315;
            }
            long l2 = aagd.g(localJSONObject.optString("begintime"), -1L);
            long l3 = aagd.g(localJSONObject.optString("endtime"), 9223372036854775807L);
            if ((l1 < l2) || (l1 > l3)) {
              break label315;
            }
            String str = localJSONObject.optString("text");
            int j = localJSONObject.optInt("flag", 0);
            if ((TextUtils.isEmpty(str)) || (str.length() > 18)) {
              break label315;
            }
            if (this.channel == 32)
            {
              if ((j & 0x1) != 0)
              {
                QLog.i("LingHbFragment", 2, "ling txt = " + str);
                this.uX.add(str);
              }
            }
            else if ((j & 0x2) != 0)
            {
              QLog.i("LingHbFragment", 2, "ling voice = " + str);
              this.uX.add(str);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label315:
      i += 1;
    }
  }
  
  public int getLayout()
  {
    return 2131562114;
  }
  
  public void initData()
  {
    super.initData();
    ctm();
    this.view.setOnClickListener(new aaap(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(this.uX, new aaaq(this), new aaar(this), new aaas(this));
    this.aW.setFocusable(true);
    this.aW.setOnFocusChangeListener(new aaat(this));
    this.iH.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
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
      ctn();
    }
  }
  
  protected String qf()
  {
    if (32 == this.channel) {
      return acfp.m(2131707746);
    }
    return acfp.m(2131707745);
  }
  
  public String qg()
  {
    return this.aW.getText().toString();
  }
  
  public String qh()
  {
    String str1 = qg();
    if (65536 == this.channel)
    {
      if (aabk.bS(str1) < 4)
      {
        QQToast.a(getActivity(), 2131699360, 0).show();
        return null;
      }
      String str2 = aabk.hY(str1);
      if (str2.length() > 0)
      {
        QQToast.a(getActivity(), String.format(getString(2131699358), new Object[] { Character.valueOf(str2.charAt(0)) }), 0).show();
        return null;
      }
    }
    return str1;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      addUploadData("hongbao.wrap.hopngbaokey", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment
 * JD-Core Version:    0.7.0.1
 */