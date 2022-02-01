package com.tencent.mobileqq.confess;

import acbn;
import acxw;
import aegp;
import aegs;
import aegt;
import aegu;
import aegv;
import aehb;
import anaz;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import mqq.os.MqqHandler;

public class ConfessMsgListFragment
  extends BaseMsgListFragment
  implements View.OnClickListener
{
  aegs a;
  aegv b = new aegt(this);
  View hY;
  View mEntryView;
  public ImageView yw;
  public ImageView yx;
  
  public static void an(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uintype", 1032);
    localIntent.putExtra("uin", acbn.blK);
    localIntent.addFlags(335544320);
    PublicFragmentActivity.start(paramContext, localIntent, ConfessMsgListFragment.class);
  }
  
  private void cWR()
  {
    int i = 0;
    String str = null;
    if (this.mEntryView == null) {
      return;
    }
    boolean bool2 = aegp.B(this.mApp, "redpoint_box_show");
    boolean bool1;
    label40:
    Object localObject1;
    label60:
    label76:
    Object localObject3;
    Object localObject2;
    if (this.mEntryView.findViewById(2131377020).getVisibility() == 0)
    {
      bool1 = true;
      if (bool2 != bool1)
      {
        localObject1 = this.mEntryView.findViewById(2131377020);
        if (!bool2) {
          break label223;
        }
        ((View)localObject1).setVisibility(i);
      }
      if (this.a != null) {
        break label229;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label254;
      }
      localObject3 = ((aegp)localObject1).title;
      str = ((aegp)localObject1).getSubTitle();
      localObject2 = ((aegp)localObject1).bxa;
    }
    for (;;)
    {
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = aegp.bwM;
      }
      if (TextUtils.isEmpty(str)) {
        str = aegp.bwN;
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject2 = aegp.bwO;
        }
        for (;;)
        {
          localObject3 = (TextView)this.mHeaderView.findViewById(2131365360);
          TextView localTextView = (TextView)this.mHeaderView.findViewById(2131365721);
          if (bool2) {}
          for (;;)
          {
            if (!TextUtils.equals((CharSequence)localObject2, ((TextView)localObject3).getText())) {
              ((TextView)localObject3).setText((CharSequence)localObject2);
            }
            if (TextUtils.equals(str, localTextView.getText())) {
              break;
            }
            localTextView.setText(str);
            return;
            bool1 = false;
            break label40;
            label223:
            i = 8;
            break label60;
            label229:
            localObject1 = this.a.b();
            break label76;
            localObject2 = localObject1;
          }
        }
      }
      label254:
      localObject2 = null;
      localObject3 = null;
    }
  }
  
  protected boolean X(String paramString, int paramInt)
  {
    try
    {
      Iterator localIterator = this.yT.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentItemConfessMsg)))
        {
          RecentItemConfessMsg localRecentItemConfessMsg = (RecentItemConfessMsg)localRecentBaseData;
          if (localRecentItemConfessMsg.mType != 1034)
          {
            if ((((paramInt & 0x1) == 1) || ((paramInt & 0x2) == 2)) && (localRecentItemConfessMsg.mType == 1033) && (TextUtils.equals(localRecentBaseData.qx(), paramString))) {
              return true;
            }
            if (((paramInt & 0x2) == 2) && (localRecentItemConfessMsg.mType == 1032) && (localRecentItemConfessMsg.mMsg != null))
            {
              boolean bool = TextUtils.equals(localRecentItemConfessMsg.mMsg.senderuin, paramString);
              if (bool) {
                return true;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      return false;
    }
    return false;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataClick [type: %s, uin: %s, uinName: %s, needRefresh: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.ng()), paramRecentBaseData.qx(), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg))
    {
      paramView = (RecentItemConfessMsg)paramRecentBaseData;
      if ((paramView.mType != 1033) && (paramView.mType != 1034)) {
        break label272;
      }
      paramString = new Bundle();
      paramString.putInt("key_confessor_sex", paramView.mConfessInfo.confessorSex);
      paramString.putString("key_confessor_nick", paramView.mConfessInfo.confessorNick);
      paramString.putString("key_confess_desc", paramView.mConfessInfo.topic);
      paramString.putLong("key_confess_time", paramView.mConfessInfo.confessTime);
      aegu.a(this.mContext, paramView.qx(), paramView.mType, paramView.mConfessInfo.topicId, paramView.mTitleName, paramString);
      if (paramView.mType != 1033) {
        break label233;
      }
      anot.a(this.mApp, "dc00898", "", "", "0X8008F4D", "0X8008F4D", 2, 0, "", "", "", "");
    }
    label233:
    while ((paramView.mType != 1032) || (!TextUtils.equals(paramView.mUin, acbn.blL))) {
      for (;;)
      {
        aegu.a(this.mApp, (RecentItemConfessMsg)paramRecentBaseData, false);
        return;
        anot.a(this.mApp, "dc00898", "", "", "0X8008F4E", "0X8008F4E", 2, 0, "", "", "", "");
      }
    }
    label272:
    if (this.a == null)
    {
      paramView = null;
      label304:
      if (paramView != null) {
        break label412;
      }
    }
    label412:
    for (paramView = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";; paramView = paramView.bwW)
    {
      paramString = new Intent(this.mContext, QQBrowserActivity.class);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("url", paramView);
      this.mContext.startActivity(paramString);
      anot.a(this.mApp, "dc00898", "", "", "0X8008F4F", "0X8008F4F", 2, 0, "", "", "", "");
      break;
      paramView = this.a.b();
      break label304;
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onRecentBaseDataDelete [type: %s, uin: %s, r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.ng()), paramRecentBaseData.qx(), paramString }));
    }
    if ((paramRecentBaseData instanceof RecentItemConfessMsg)) {
      aegu.a(this.mApp, (RecentItemConfessMsg)paramRecentBaseData, true);
    }
    cWP();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onMenuItemClick [type: %s, uin: %s, menuItem: %s,  r4: %s]", new Object[] { Integer.valueOf(paramRecentBaseData.ng()), paramRecentBaseData.qx(), paramString1, paramString2 }));
    }
  }
  
  protected List<RecentBaseData> aV(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    String str = this.mApp.getAccount();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord != null)
      {
        paramList = c();
        if ((paramList instanceof RecentItemConfessMsg)) {}
        for (paramList = (RecentItemConfessMsg)paramList;; paramList = new RecentItemConfessMsg())
        {
          paramList.a(this.mApp, str, localMessageRecord);
          paramList.c(this.mApp, this.mContext);
          localArrayList.add(paramList);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  protected void cWQ()
  {
    aQ();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContext.getString(2131700847));
    paramViewGroup = this.mContext.getResources();
    this.a = ((aegs)this.mApp.getManager(269));
    paramBundle = this.a.b();
    if ((paramBundle != null) && (paramBundle.cMH == 1))
    {
      Drawable localDrawable1 = getResources().getDrawable(2130851417);
      Drawable localDrawable2 = getResources().getDrawable(2130845900);
      if ((this.yx != null) && (this.yw != null))
      {
        this.yx.setVisibility(0);
        this.yx.setImageDrawable(localDrawable1);
        this.yw.setVisibility(0);
        this.yw.setImageDrawable(localDrawable2);
        this.yx.setOnClickListener(this);
        this.yw.setOnClickListener(this);
        this.yx.setContentDescription(getString(2131700844));
        this.yw.setContentDescription(getString(2131695651));
      }
      if ((paramBundle == null) || ((paramBundle != null) && (paramBundle.cMI >= 1)) || (aegp.B(this.mApp, "redpoint_box_show")))
      {
        this.mEntryView = paramLayoutInflater.inflate(2131561267, this.mHeaderView, false);
        if ((LinearLayout.LayoutParams)this.mEntryView.getLayoutParams() != null) {
          break label396;
        }
        paramBundle = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131298585));
        paramBundle.topMargin = paramViewGroup.getDimensionPixelSize(2131298586);
        paramBundle.bottomMargin = paramViewGroup.getDimensionPixelOffset(2131298586);
        this.mHeaderView.addView(this.mEntryView, paramBundle);
        label289:
        this.mEntryView.setOnClickListener(this);
        cWR();
        this.hY = paramLayoutInflater.inflate(2131561274, this.mHeaderView, false);
        if ((LinearLayout.LayoutParams)this.hY.getLayoutParams() != null) {
          break label410;
        }
        paramLayoutInflater = new LinearLayout.LayoutParams(-1, paramViewGroup.getDimensionPixelSize(2131298587));
        this.mHeaderView.addView(this.hY, paramLayoutInflater);
      }
    }
    for (;;)
    {
      this.mApp.addObserver(this.b, true);
      ThreadManager.post(new ConfessMsgListFragment.1(this), 5, null, true);
      return;
      setRightButton(2131719875, this);
      break;
      label396:
      this.mHeaderView.addView(this.mEntryView);
      break label289;
      label410:
      this.mHeaderView.addView(this.hY);
    }
  }
  
  protected void jM(List<MessageRecord> paramList)
  {
    int k = 0;
    Object localObject1 = this.a.a();
    int i;
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = paramList.size();
      j = paramList.size() - 1;
      if (j >= 0)
      {
        localObject2 = (MessageRecord)paramList.get(j);
        if (localObject2 == null)
        {
          paramList.remove(j);
          i -= 1;
        }
        for (;;)
        {
          j -= 1;
          break;
          if (TextUtils.isEmpty(((MessageRecord)localObject2).getExtInfoFromExtStr("ext_key_confess_info")))
          {
            paramList.remove(j);
            i -= 1;
          }
          else
          {
            if ((localObject1 == null) || (((aehb)localObject1).Wd <= ((MessageRecord)localObject2).time)) {
              break label590;
            }
            i = j;
          }
        }
      }
    }
    for (int j = i;; j = 0)
    {
      label258:
      boolean bool;
      long l1;
      if (j < 0)
      {
        i = 0;
        if ((localObject1 != null) && (((aehb)localObject1).agG()) && (paramList != null))
        {
          localObject2 = new MessageRecord();
          ((MessageRecord)localObject2).istroop = 1032;
          ((MessageRecord)localObject2).frienduin = acbn.blL;
          ((MessageRecord)localObject2).time = ((aehb)localObject1).Wd;
          ((MessageRecord)localObject2).senderuin = ((aehb)localObject1).bxr;
          ((MessageRecord)localObject2).msg = ((aehb)localObject1).bxt;
          ((MessageRecord)localObject2).msg2 = ((aehb)localObject1).bxs;
          ((MessageRecord)localObject2).longMsgCount = ((aehb)localObject1).cMU;
          paramList.add(i, localObject2);
        }
        if ((paramList != null) && (!paramList.isEmpty())) {
          break label435;
        }
        j = 1;
        localObject1 = this.mApp.a().a();
        localObject2 = ((acxw)localObject1).b(acbn.blK, 1032);
        bool = aegp.B(this.mApp, "redpoint_box_show");
        l1 = aegp.c(this.mApp, "redpoint_box_show");
        long l2 = aegp.c(this.mApp, "redpoint_clear_time");
        long l3 = anaz.gQ();
        if ((j == 0) || (localObject2 == null) || (bool) || (Math.abs(l3 - l2) <= 259200000L)) {
          break label440;
        }
        ((acxw)localObject1).f((RecentUser)localObject2);
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramList = this.mApp.getHandler(Conversation.class);
          if (paramList != null) {
            paramList.sendEmptyMessage(1009);
          }
        }
        return;
        if ((paramList != null) && (paramList.isEmpty()))
        {
          i = 0;
          break;
        }
        i = j;
        if (paramList == null) {
          break;
        }
        i = j;
        if (j <= paramList.size()) {
          break;
        }
        i = paramList.size();
        break;
        label435:
        j = 0;
        break label258;
        label440:
        if ((j == 0) && (localObject2 == null))
        {
          localObject2 = new RecentUser();
          ((RecentUser)localObject2).uin = acbn.blK;
          ((RecentUser)localObject2).setType(1032);
          if (bool) {}
          for (l1 = Math.max(((MessageRecord)paramList.get(0)).time, l1);; l1 = ((MessageRecord)paramList.get(0)).time)
          {
            ((RecentUser)localObject2).lastmsgtime = l1;
            ((acxw)localObject1).e((RecentUser)localObject2);
            i = 1;
            break;
          }
        }
        i = k;
        if (j != 0)
        {
          i = k;
          if (localObject2 == null)
          {
            paramList = new RecentUser();
            paramList.uin = acbn.blK;
            paramList.setType(1032);
            paramList.lastmsgtime = l1;
            ((acxw)localObject1).e(paramList);
            i = 1;
          }
        }
      }
      label590:
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    label25:
    Object localObject2;
    if (paramView == this.mEntryView) {
      if (this.a == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label199;
        }
        localObject1 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          ((Intent)localObject2).putExtra("hide_operation_bar", true);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          this.mContext.startActivity((Intent)localObject2);
        }
        localObject2 = this.mEntryView.findViewById(2131377020);
        if (((View)localObject2).getVisibility() != 8) {
          ((View)localObject2).setVisibility(8);
        }
        aegu.A(this.mApp, false);
        anot.a(this.mApp, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 2, 0, "", "", "", "");
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
        }
      }
    }
    label199:
    label224:
    label375:
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = this.a.b();
      break;
      localObject1 = ((aegp)localObject1).bwU;
      break label25;
      if (paramView == this.rightViewText)
      {
        if (this.a == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label350;
          }
        }
        for (localObject1 = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";; localObject1 = ((aegp)localObject1).bwY)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.mContext.startActivity((Intent)localObject2);
          }
          anot.a(this.mApp, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
          break;
          localObject1 = this.a.b();
          break label224;
        }
      }
      if (paramView == this.yx)
      {
        if (this.a == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label501;
          }
        }
        for (localObject1 = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";; localObject1 = ((aegp)localObject1).bwZ)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.mContext.startActivity((Intent)localObject2);
          }
          anot.a(this.mApp, "dc00898", "", "", "0X800948C", "0X800948C", 0, 0, "", "", "", "");
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
          break;
          localObject1 = this.a.b();
          break label375;
        }
      }
    } while (paramView != this.yw);
    label350:
    label501:
    if (this.a == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label652;
      }
    }
    label526:
    for (Object localObject1 = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";; localObject1 = ((aegp)localObject1).bwY)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.mContext.startActivity((Intent)localObject2);
      }
      anot.a(this.mApp, "dc00898", "", "", "0X80091A1", "0X80091A1", 0, 0, "", "", "", "");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "click entry url: %s", new Object[] { localObject1 }));
      break;
      localObject1 = this.a.b();
      break label526;
    }
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgListFragment", 4, String.format(Locale.getDefault(), "onClick [view: %s, data: %s]", new Object[] { paramView, paramObject }));
    }
  }
  
  public View onCreateLeftView()
  {
    View localView = super.onCreateLeftView();
    this.leftView.setText("  ");
    return localView;
  }
  
  public View onCreateRightView()
  {
    this.rightViewText = ((TextView)this.titleRoot.findViewById(2131369612));
    this.yw = ((ImageView)this.titleRoot.findViewById(2131369594));
    this.yx = ((ImageView)this.titleRoot.findViewById(2131369595));
    setLayerType(this.yw);
    setLayerType(this.yx);
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public void onDestroyView()
  {
    this.mApp.removeObserver(this.b);
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    cWR();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgListFragment", 2, "onWindowFocusChanged " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().postDelayed(new ConfessMsgListFragment.2(this), 200L);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.bTI) && (!TextUtils.isEmpty(paramObservable.senderuin))) {
        break label36;
      }
    }
    label36:
    while ((paramObservable.istroop != 1032) && (paramObservable.istroop != 1033) && (paramObservable.istroop != 1034)) {
      return;
    }
    cWP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgListFragment
 * JD-Core Version:    0.7.0.1
 */