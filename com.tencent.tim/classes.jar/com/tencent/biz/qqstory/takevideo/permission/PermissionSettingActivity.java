package com.tencent.biz.qqstory.takevideo.permission;

import acff;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import pmb;
import ram;
import rar;
import rkd;
import rkd.a;
import rkd.b;
import rkf;
import rkg;
import rkh;
import rki;
import rkj;
import rpq;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private rkg a;
  private String mCurrentUin;
  private ListView n;
  
  private void E(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      ram.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((pmb)this.app.getManager(181)).e(true);
    Object localObject4 = new ArrayList();
    this.mCurrentUin = this.app.getCurrentUin();
    ram.b("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.mCurrentUin);
    ((List)localObject4).add(this.mCurrentUin);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject4).add(((QQStoryUserInfo)((Iterator)localObject1).next()).uin);
      }
    }
    localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject5 = (acff)this.app.getManager(51);
    Object localObject6 = ((acff)localObject5).cr();
    if (localObject6 != null)
    {
      ram.b("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((acff)localObject5).B(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((rkd.b)localObject7).tB() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((rkd.b)localObject8).tB() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    ram.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new rkf(this, "", rpq.dip2px(this, 20.0F));
    ((rkf)localObject4).av(false, true);
    localObject5 = new rkj(this, getString(2131701766), 10004);
    ((rkj)localObject5).tS(true);
    localObject6 = new rkj(this, getString(2131701758), 10000);
    ((rkj)localObject6).tS(true);
    Object localObject7 = new rkj(this, getString(2131701762), 10001);
    ((rkj)localObject7).tS(false);
    Object localObject8 = new rkf(this, "", rpq.dip2px(this, 20.0F));
    ((rkf)localObject8).av(true, true);
    localObject3 = new rkd(this, getString(2131701765), 10002, (List)localObject3, this.app);
    localObject2 = new rkd(this, getString(2131701764), 10003, (List)localObject2, this.app);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((List)localObject1).add(localObject4);
      ((List)localObject1).add(localObject5);
      ((List)localObject1).add(localObject6);
      ((List)localObject1).add(localObject7);
      ((List)localObject1).add(localObject8);
      ((List)localObject1).add(localObject3);
      ((List)localObject1).add(localObject2);
      paramList = this.n;
      localObject1 = new rkg((List)localObject1);
      this.a = ((rkg)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.n.setOnItemClickListener(this.a);
      return;
      ((rkj)localObject5).setSelect(true);
      continue;
      ((rkj)localObject6).setSelect(true);
      continue;
      ((rkj)localObject7).setSelect(true);
      continue;
      ((rkd)localObject3).setSelect(true);
      ((rkd)localObject3).eV(paramList);
      continue;
      ((rkd)localObject2).setSelect(true);
      ((rkd)localObject2).eV(paramList);
    }
  }
  
  private rkd.b a(Groups paramGroups, List<Entity> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new rkd.a(localFriends));
        }
      }
    }
    return new rkd.b(paramGroups, localArrayList);
  }
  
  private void b(@Nonnull rkh paramrkh)
  {
    int i = paramrkh.tC();
    Intent localIntent = new Intent();
    ram.b("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
    localIntent.putExtra("PERMISSION_TYPE_KEY", i);
    localIntent.putExtra("PERMISSION_CURRENT_UIN_KEY", this.mCurrentUin);
    switch (i)
    {
    }
    for (;;)
    {
      setResult(1, localIntent);
      return;
      ArrayList localArrayList = new ArrayList();
      paramrkh = ((rkd)paramrkh).cf();
      if (paramrkh.isEmpty())
      {
        ram.w("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this, acfp.m(2131709438), 0).show();
        return;
      }
      paramrkh = paramrkh.iterator();
      while (paramrkh.hasNext()) {
        localArrayList.add(((rkd.a)paramrkh.next()).getUin());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      ram.b("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    rar.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561940);
    super.setTitle(acfp.m(2131709433));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(acfp.m(2131709444));
    this.rightViewText.setContentDescription(acfp.m(2131709440));
    this.rightViewText.setOnClickListener(new rki(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.n = ((ListView)findViewById(2131372998));
      E(i, paramBundle);
      ((ViewGroup)this.n.getParent()).setBackgroundColor(getResources().getColor(2131167363));
      rar.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */