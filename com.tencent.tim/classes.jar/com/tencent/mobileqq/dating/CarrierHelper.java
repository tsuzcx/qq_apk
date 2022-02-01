package com.tencent.mobileqq.dating;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aoop;
import aqhq;
import aqhv;
import aqik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.widget.CarrierADView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BorderTextView;
import com.tencent.widget.SingleLineTextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class CarrierHelper
  implements View.OnClickListener
{
  private static final String[] eP = { acfp.m(2131703509), acfp.m(2131703512), acfp.m(2131703515), acfp.m(2131703513), acfp.m(2131703510), acfp.m(2131703509), acfp.m(2131703514) };
  private CarrierADView a;
  private Activity activity;
  private boolean amp;
  private QQAppInterface app;
  private int cQb;
  private View.OnClickListener eO;
  float mDensity;
  private int mFromType;
  int mScreenWidth;
  private ArrayList<EntranceConfig> vX;
  private List<AdData> zk;
  
  public void B(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.a == null) || (!(paramObject instanceof Boolean)));
        if (((Boolean)paramObject).booleanValue())
        {
          this.a.setVisibility(0);
          return;
        }
        this.a.setVisibility(8);
        return;
      } while ((this.a == null) || (!(paramObject instanceof Boolean)));
      if (((Boolean)paramObject).booleanValue())
      {
        this.a.ehE();
        return;
      }
      this.a.ehF();
      return;
    } while ((this.a == null) || (this.zk == null) || (this.cQb == -1));
    this.a.setCarrierData(this.zk, this.cQb, this);
  }
  
  public void HF(String paramString)
  {
    if ((this.zk.size() == 0) || (this.a == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = this.a.getCurrentScreen();
    aqhq.x(paramString, new Object[] { this.zk, Integer.valueOf(i), this.vX });
  }
  
  public void Zg()
  {
    if ((this.amp) || (this.a == null) || (this.a.getVisibility() != 0)) {}
    while (this.zk.size() == 0) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.zk.iterator();
    while (localIterator.hasNext())
    {
      AdData localAdData = (AdData)localIterator.next();
      if ((localAdData != null) && (!localLinkedList.contains(Integer.valueOf(localAdData.ad_source)))) {
        localLinkedList.add(Integer.valueOf(localAdData.ad_source));
      }
    }
    ThreadManager.getSubThreadHandler().post(new CarrierHelper.1(this, localLinkedList));
  }
  
  public EntranceConfig a()
  {
    if (this.vX != null)
    {
      Iterator localIterator;
      EntranceConfig localEntranceConfig;
      if (this.mFromType == 2)
      {
        localIterator = this.vX.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localEntranceConfig = (EntranceConfig)localIterator.next();
        } while (localEntranceConfig.type != 2);
        return localEntranceConfig;
      }
      if (this.mFromType == 1)
      {
        localIterator = this.vX.iterator();
        while (localIterator.hasNext())
        {
          localEntranceConfig = (EntranceConfig)localIterator.next();
          if (localEntranceConfig.type == 1) {
            return localEntranceConfig;
          }
        }
      }
    }
    return null;
  }
  
  public void a(View paramView, AdData paramAdData)
  {
    Object localObject = (ImageView)paramView.findViewById(2131362112);
    BorderTextView localBorderTextView = (BorderTextView)paramView.findViewById(2131362129);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131362148);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131362128);
    TextView localTextView1 = (TextView)paramView.findViewById(2131362070);
    TextView localTextView2 = (TextView)paramView.findViewById(2131362072);
    View localView = paramView.findViewById(2131364337);
    localBorderTextView.setTextSize(1, 11.0F);
    localBorderTextView.setBorderWidth(Math.round(localBorderTextView.getResources().getDisplayMetrics().density * 1.0F));
    ((ImageView)localObject).setImageDrawable(aoop.getDrawable(paramAdData.img_url));
    int i;
    if ((paramAdData.wording != null) && (paramAdData.wording.length() > 0))
    {
      localBorderTextView.setText(paramAdData.wording);
      localBorderTextView.setTextColor(paramAdData.bgColor);
      localBorderTextView.setBorderColor(paramAdData.bgColor);
      localBorderTextView.setVisibility(0);
      if (TextUtils.isEmpty(paramAdData.distance)) {
        break label341;
      }
      localSingleLineTextView2.setText(paramAdData.distance);
      localSingleLineTextView2.setVisibility(0);
      i = Math.round(localBorderTextView.getPaint().measureText(paramAdData.distance)) + 5 + 89;
      label211:
      localSingleLineTextView1.setMaxWidth((int)(this.mScreenWidth - i * this.mDensity));
      localSingleLineTextView1.setText(paramAdData.title);
      localTextView1.setText(paramAdData.content);
      localTextView2.setText(paramAdData.content2);
      if ((paramAdData.ad_source < 0) || (paramAdData.ad_source >= eP.length)) {
        break label354;
      }
    }
    label341:
    label354:
    for (localObject = eP[paramAdData.ad_source];; localObject = eP[0])
    {
      paramView.setContentDescription((CharSequence)localObject);
      localView.setContentDescription((CharSequence)localObject);
      localView.setTag(paramAdData.jump_url);
      localView.setTag(2131374878, Integer.valueOf(paramAdData.ad_source));
      localView.setOnClickListener(this.eO);
      return;
      localBorderTextView.setVisibility(4);
      break;
      localSingleLineTextView2.setVisibility(8);
      i = 89;
      break label211;
    }
  }
  
  public void b(List<AdData> paramList, int paramInt, ArrayList<EntranceConfig> paramArrayList)
  {
    this.zk.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.zk.addAll(paramList);
    }
    this.cQb = paramInt;
    this.vX = paramArrayList;
  }
  
  public boolean isShowing()
  {
    if (this.a == null) {}
    while (this.a.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (Integer)paramView.getTag(2131374878);
    String str = (String)paramView.getTag();
    if ((localObject1 == null) || (str == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.mFromType == 2) || (this.mFromType == 1)) {
        anot.a(this.app, "CliOper", "", "", "0X80050D1", "0X80050D1", this.mFromType, 0, String.valueOf(localObject1), "", "", "");
      }
      if (((Integer)localObject1).intValue() == 5) {
        anot.a(this.app, "CliOper", "", "", "0X80052A3", "0X80052A3", this.mFromType, 0, "", "", "", "");
      }
      if (this.activity == null) {}
      for (localObject1 = BaseApplicationImpl.getContext();; localObject1 = this.activity)
      {
        localObject2 = aqik.c(this.app, (Context)localObject1, str);
        if (localObject2 == null) {
          break label182;
        }
        ((aqhv)localObject2).ace();
        break;
      }
      label182:
      Object localObject2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", URLUtil.guessUrl(str));
      ((Context)localObject1).startActivity((Intent)localObject2);
    }
  }
  
  public static class EntranceConfig
    implements Serializable
  {
    public String iconUrl;
    public String jumpUrl;
    public int type;
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper
 * JD-Core Version:    0.7.0.1
 */