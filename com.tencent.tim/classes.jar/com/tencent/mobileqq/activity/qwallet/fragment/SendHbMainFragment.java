package com.tencent.mobileqq.activity.qwallet.fragment;

import aaai;
import aaaz;
import aaba;
import aabb;
import aabk;
import aadm;
import aagd;
import acfp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import avor;
import avox;
import avox.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SendHbMainFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  public static final String bch = acfp.m(2131714299);
  private avox.a jdField_a_of_type_Avox$a = new avox.a();
  private ViewPagerTabLayout jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout;
  private String bbD;
  private List<a> uY = new ArrayList();
  private ImageView vP;
  
  private BaseHbFragment a(aadm paramaadm, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = null;
    JSONArray localJSONArray = null;
    Bundle localBundle = new Bundle(paramBundle);
    int i = paramaadm.type;
    if (RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(i)) == null) {
      localObject = localJSONArray;
    }
    do
    {
      return localObject;
      localBundle.putString("channel", String.valueOf(RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(i))));
      paramBundle = (Bundle)localObject;
      switch (i)
      {
      default: 
        paramBundle = (Bundle)localObject;
      }
      while (paramBundle != null)
      {
        paramBundle.setArguments(localBundle);
        return paramBundle;
        paramBundle = new UsualHbFragment();
        localBundle.putString("bus_type", "1");
        continue;
        if (!paramBoolean)
        {
          paramBundle = (Bundle)localObject;
          if (!avox.LJ.contains(this.bbD)) {}
        }
        else
        {
          paramBundle = new UsualHbFragment();
          localBundle.putString("bus_type", "2");
          continue;
          if (!paramBoolean)
          {
            paramBundle = (Bundle)localObject;
            if (avox.LL.contains(this.bbD)) {}
          }
          else
          {
            paramBundle = new LingHbFragment();
            continue;
            localObject = new KSongFragment();
            paramBundle = (Bundle)localObject;
            if (paramaadm.params != null)
            {
              localBundle.putString("pick_entry", paramaadm.params.optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket"));
              paramBundle = (Bundle)localObject;
              continue;
              if (!paramBoolean)
              {
                paramBundle = (Bundle)localObject;
                if (!RedPacketManager.verifyEmojiHbParams(paramaadm)) {}
              }
              else
              {
                localObject = new EmojiFragment();
                localBundle.putString("prefix", paramaadm.params.optString("prefix"));
                localJSONArray = paramaadm.params.optJSONArray("heartList");
                paramBundle = (Bundle)localObject;
                if (localJSONArray != null)
                {
                  localBundle.putString("heartList", localJSONArray.toString());
                  paramBundle = (Bundle)localObject;
                  continue;
                  localObject = new WordChainHbFragment();
                  paramBundle = (Bundle)localObject;
                  if (paramaadm.params != null)
                  {
                    localBundle.putString("skinId", paramaadm.params.optString("skinId"));
                    paramBundle = (Bundle)localObject;
                    continue;
                    if (!paramBoolean)
                    {
                      paramBundle = (Bundle)localObject;
                      if (!RedPacketManager.verifyDrawHbParams(paramaadm)) {}
                    }
                    else
                    {
                      paramBundle = new DrawHbFragment();
                      localBundle.putString("skinId", paramaadm.params.optString("skinId"));
                      localBundle.putString("drawParam", paramaadm.params.optString("subjects"));
                      continue;
                      if (!paramBoolean)
                      {
                        paramBundle = (Bundle)localObject;
                        if (!avox.LK.contains(this.bbD)) {}
                      }
                      else
                      {
                        paramBundle = new ExclusiveHbFragment();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      localObject = paramBundle;
    } while (!QLog.isColorLevel());
    QLog.i("SendHbMainFragment", 2, "buildHbFragment...fragment is null,panelData:" + paramaadm.toString());
    return paramBundle;
  }
  
  private String a(aadm paramaadm)
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (paramaadm != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramaadm.name))
      {
        i = paramaadm.name.indexOf(bch);
        if (i == -1) {
          break label65;
        }
      }
    }
    label65:
    for (str1 = paramaadm.name.substring(0, i);; str1 = paramaadm.name)
    {
      paramaadm = str1;
      if (TextUtils.isEmpty(str1)) {
        paramaadm = bch;
      }
      return paramaadm;
    }
  }
  
  private void fV(View paramView)
  {
    paramView = (TipsBar)paramView.findViewById(2131368355);
    paramView.setVisibility(8);
    Object localObject1;
    String str1;
    try
    {
      localObject1 = aagd.getQQAppInterface();
      if (localObject1 == null) {
        return;
      }
      localObject1 = (aaai)((QQAppInterface)localObject1).getManager(245);
      if ((localObject1 == null) || (((aaai)localObject1).p("common") == null)) {
        return;
      }
      localObject1 = ((aaai)localObject1).p("common").getJSONObject("make_hb_bulletin");
      if (localObject1 == null) {
        return;
      }
      str1 = ((JSONObject)localObject1).optString("content_text");
      localObject2 = ((JSONObject)localObject1).optString("begintime");
      String str2 = ((JSONObject)localObject1).optString("endtime");
      if (TextUtils.isEmpty(str1.trim())) {
        return;
      }
      if (!RedPacketManager.isBulletinValidDate((String)localObject2, str2))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w("SendHbMainFragment", 2, "isBulletinValidDate:false,start_time:" + (String)localObject2 + " end_time:" + str2);
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("SendHbMainFragment", 1, paramView, new Object[0]);
      return;
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("red_packet", 0);
    int i = ((JSONObject)localObject1).optInt("bulletin_id");
    if (i != ((SharedPreferences)localObject2).getInt("red_packet_bulletin", -1))
    {
      paramView.setBarType(2);
      paramView.setTipsIcon(getResources().getDrawable(2130839515));
      if (paramView.F() != null) {
        paramView.F().setVisibility(0);
      }
      paramView.setVisibility(0);
      paramView.setTipsText(str1);
      paramView.setEnabled(true);
      paramView.setOnClickListener(new aaaz(this, (JSONObject)localObject1));
      paramView.setCloseListener(new aaba(this, paramView, (SharedPreferences)localObject2, i));
    }
  }
  
  private void fW(View paramView)
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      if (i == 1)
      {
        paramView = paramView.findViewById(2131381465);
        paramView.getLayoutParams().height = j;
        paramView.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.i("SendHbMainFragment", 2, "initImmersive:" + i + " barHeight: " + j);
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("SendHbMainFragment", 1, paramView, new Object[0]);
    }
  }
  
  private void initView(View paramView, Bundle paramBundle)
  {
    avox.a(paramBundle, this.jdField_a_of_type_Avox$a);
    this.bbD = this.jdField_a_of_type_Avox$a.recv_type;
    this.vP = ((ImageView)paramView.findViewById(2131369765));
    fW(paramView);
    n(paramView, paramBundle.getString("hbTitle", getString(2131698996)));
    if (!y(paramBundle))
    {
      QLog.i("SendHbMainFragment", 1, "initHbData failed...");
      QQToast.a(this.mActivity, acfp.m(2131714296), 0).show();
      this.mActivity.finish();
      return;
    }
    paramBundle = (ViewPager)paramView.findViewById(2131381458);
    paramBundle.setOffscreenPageLimit(1);
    paramBundle.setAdapter(new aabb(this, getChildFragmentManager()));
    paramBundle.setCurrentItem(fJ(yx()), false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout = ((ViewPagerTabLayout)paramView.findViewById(2131379154));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setBoldStyle(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setScrollOnTabClick(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setViewPager(paramBundle);
    ThreadManagerV2.getUIHandlerV2().post(new SendHbMainFragment.4(this));
    fV(paramView);
  }
  
  private boolean y(Bundle paramBundle)
  {
    boolean bool2 = false;
    int i = paramBundle.getInt("tabMask", 0);
    boolean bool1 = paramBundle.getBoolean("isFromPanel");
    this.uY.clear();
    if (QLog.isColorLevel()) {
      QLog.i("SendHbMainFragment", 2, "initHbData... isFromPanel:" + bool1 + " tabMask:" + i);
    }
    Object localObject2;
    if (i != 0)
    {
      if ((i & 0x2) == 2)
      {
        localObject1 = new Bundle(paramBundle);
        ((Bundle)localObject1).putString("bus_type", "2");
        localObject2 = new UsualHbFragment();
        ((UsualHbFragment)localObject2).setArguments((Bundle)localObject1);
        localObject1 = new a(1, acfp.m(2131714297), (BaseHbFragment)localObject2);
        this.uY.add(localObject1);
      }
      if ((i & 0x1) == 1)
      {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("bus_type", "1");
        localObject1 = new UsualHbFragment();
        ((UsualHbFragment)localObject1).setArguments(paramBundle);
        paramBundle = new a(0, acfp.m(2131714298), (BaseHbFragment)localObject1);
        this.uY.add(paramBundle);
      }
      bool1 = bool2;
      if (!this.uY.isEmpty()) {
        bool1 = true;
      }
      return bool1;
    }
    Object localObject1 = new ArrayList();
    if (bool1) {
      if ((RedPacketManager.CURRENT_PANEL_DATA != null) && (RedPacketManager.CURRENT_PANEL_DATA.size() != 0)) {
        ((List)localObject1).addAll(RedPacketManager.CURRENT_PANEL_DATA);
      }
    }
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aadm)((Iterator)localObject1).next();
        if (localObject2 != null) {
          try
          {
            if (!TextUtils.isEmpty(((aadm)localObject2).name))
            {
              BaseHbFragment localBaseHbFragment = a((aadm)localObject2, paramBundle, bool1);
              if (localBaseHbFragment != null) {
                this.uY.add(new a(((aadm)localObject2).type, a((aadm)localObject2), localBaseHbFragment));
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
          }
        }
      }
      break;
      QLog.e("SendHbMainFragment", 1, "isFromPanel but cacheData isEmpty");
      ((List)localObject1).addAll(((RedPacketManager)RedPacketManager.getInstance()).getPanelList(null));
      bool1 = false;
      continue;
      ((List)localObject1).addAll(((RedPacketManager)RedPacketManager.getInstance()).getPanelList(null));
    }
  }
  
  private int yx()
  {
    return aabk.an(this.channel, avor.c(this.bundle.getString("bus_type"), 2));
  }
  
  public BaseHbFragment a()
  {
    try
    {
      BaseHbFragment localBaseHbFragment = ((a)this.uY.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.getCurrentTab())).a;
      return localBaseHbFragment;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return null;
  }
  
  public void ctr()
  {
    int i = getCurType();
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbMainFragment", 2, "reportHbBack,curType:" + i);
      }
      return;
      this.mActivity.zY("idiom.wrappacket.back");
      continue;
      this.mActivity.zY("ksong.wrappacket.back");
      continue;
      this.mActivity.zY("draw.wrappacket.back");
      continue;
      this.mActivity.zY("phiz.wrappacket.back");
      continue;
      this.mActivity.zY("only.wrappacket.back");
    }
  }
  
  public int fJ(int paramInt)
  {
    Iterator localIterator = this.uY.iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
    } while (locala.type != paramInt);
    for (int i = this.uY.indexOf(locala);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbMainFragment", 2, "findPositionByType, type:" + paramInt + " pos:" + i);
      }
      return i;
    }
  }
  
  public int getCurType()
  {
    try
    {
      int i = ((a)this.uY.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.getCurrentTab())).type;
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return 1;
  }
  
  public void n(View paramView, String paramString)
  {
    paramView.findViewById(2131369612).setVisibility(4);
    ((TextView)paramView.findViewById(2131369627)).setText(paramString);
    paramView.findViewById(2131369579).setOnClickListener(this);
    paramView.findViewById(2131377361).setBackgroundColor(this.mActivity.getResources().getColor(2131166473));
    paramView = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { Color.parseColor("#FF6D6D"), Color.parseColor("#FF2151") });
    this.vP.setBackgroundDrawable(paramView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    BaseHbFragment localBaseHbFragment = a();
    if (localBaseHbFragment != null) {
      localBaseHbFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SendHbMainFragment", 2, "onActivityResult, requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " curFragment:" + localBaseHbFragment);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369579)
    {
      ctr();
      this.mActivity.csV();
      this.mActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562115, null);
    initView(paramLayoutInflater, getArguments());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public static class a
  {
    public BaseHbFragment a;
    public String title;
    public int type;
    
    a(int paramInt, String paramString, BaseHbFragment paramBaseHbFragment)
    {
      this.type = paramInt;
      this.title = paramString;
      this.a = paramBaseHbFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment
 * JD-Core Version:    0.7.0.1
 */