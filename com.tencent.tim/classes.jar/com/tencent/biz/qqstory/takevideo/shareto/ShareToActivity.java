package com.tencent.biz.qqstory.takevideo.shareto;

import acfp;
import acxw;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import qem;
import rar;
import rlo;
import rlo.a;
import rlo.b;

public class ShareToActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.c, rlo.a
{
  protected rlo a;
  protected XListView j;
  
  private ArrayList<TroopInfo> bv()
  {
    QQAppInterface localQQAppInterface = qem.getQQAppInterface();
    Object localObject2 = (TroopManager)localQQAppInterface.getManager(52);
    Object localObject1 = ((TroopManager)localObject2).cE();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject1).size());
    Object localObject4 = localQQAppInterface.a().a().q(false);
    Object localObject3 = new ArrayList();
    localObject4 = ((List)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject4).next();
      if (localRecentUser.getType() == 1) {
        ((ArrayList)localObject3).add(localRecentUser);
      }
    }
    Collections.sort((List)localObject3, new a());
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((TroopManager)localObject2).c(((RecentUser)((Iterator)localObject3).next()).uin);
      if ((((TroopInfo)localObject4).troopuin != null) && (!((TroopInfo)localObject4).isQidianPrivateTroop())) {
        localArrayList.add(localObject4);
      }
    }
    localObject2 = new ArrayList();
    localObject3 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (TroopInfo)((Iterator)localObject1).next();
      if ((localObject4 != null) && (!localArrayList.contains(localObject4)) && (!((TroopInfo)localObject4).isQidianPrivateTroop()))
      {
        int i = localQQAppInterface.cs(((TroopInfo)localObject4).troopuin);
        if (i == 3) {
          ((ArrayList)localObject2).add(localObject4);
        } else if (i == 2) {
          ((ArrayList)localObject3).add(localObject4);
        } else {
          localArrayList.add(localObject4);
        }
      }
    }
    localArrayList.addAll((Collection)localObject3);
    localArrayList.addAll((Collection)localObject2);
    return localArrayList;
  }
  
  private void cs(ArrayList<String> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = this.a.bw();
    }
    int i = ((ArrayList)localObject).size();
    if (i > 0)
    {
      this.rightViewText.setText(acfp.m(2131714419) + i + ")");
      return;
    }
    this.rightViewText.setText(acfp.m(2131714420));
  }
  
  public boolean a(ArrayList<String> paramArrayList, rlo.b paramb)
  {
    if ((!paramb.isCheck) && (paramArrayList.size() >= 10))
    {
      QQToast.a(qem.getApplicationContext(), 0, "最多只能选择10个群", 0).show();
      return false;
    }
    return true;
  }
  
  public boolean onBackEvent()
  {
    rar.a("story_grp", "share_return", 0, 0, new String[] { "", "", "", "" });
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    rar.a("story_grp", "share_suc", 0, 0, new String[] { String.valueOf(this.a.bw().size()), "", "", "" });
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("share_to_group_key", this.a.bw());
    setResult(1, localIntent);
    finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561942);
    this.j = ((XListView)findViewById(2131378182));
    paramBundle = getLayoutInflater().inflate(2131561943, null);
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      paramBundle.setBackgroundColor(-16444373);
      this.j.setBackgroundColor(-16444373);
    }
    this.j.addHeaderView(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("share_to_group_key");
    ArrayList localArrayList = bv();
    this.a = new rlo(getBaseContext(), localArrayList, paramBundle);
    this.a.a(this);
    this.j.setAdapter(this.a);
    this.j.setOnItemClickListener(this);
    super.setTitle(acfp.m(2131714421));
    super.e(acfp.m(2131714418), this);
    cs(null);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (paramBundle = "2";; paramBundle = "1")
    {
      rar.a("story_grp", "exp_share", 0, 0, new String[] { paramBundle, "", "", "" });
      return;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong <= -1L) {}
    do
    {
      return;
      paramInt = (int)paramLong;
      paramAdapterView = (rlo.b)this.a.getItem(paramInt);
    } while (paramAdapterView == null);
    this.a.a(paramAdapterView);
    rar.a("story_grp", "clk_share", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void z(ArrayList<String> paramArrayList)
  {
    cs(paramArrayList);
  }
  
  public class a
    implements Comparator<RecentUser>
  {
    protected a() {}
    
    public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
    {
      if (paramRecentUser1.lastmsgtime > paramRecentUser2.lastmsgtime) {
        return -1;
      }
      if (paramRecentUser1.lastmsgtime < paramRecentUser2.lastmsgtime) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity
 * JD-Core Version:    0.7.0.1
 */