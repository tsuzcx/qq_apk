package dov.com.tencent.biz.qqstory.takevideo.permission;

import acff;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aypr;
import aypr.a;
import aypr.b;
import aypt;
import aypu;
import aypw;
import aypx;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pmb;
import ram;
import rar;
import rpq;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener
{
  private aypu a;
  private String mCurrentUin;
  private boolean mHasTag;
  private ListView y;
  
  private void E(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      ram.e("Q.qqstory.QQStoryBaseActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((pmb)this.app.getManager(181)).e(true);
    Object localObject4 = new ArrayList();
    this.mCurrentUin = this.app.getCurrentUin();
    ram.b("Q.qqstory.QQStoryBaseActivity", "my uin:%s", this.mCurrentUin);
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
      ram.b("Q.qqstory.QQStoryBaseActivity", "friends groups:%s", localObject6.toString());
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
            if (((aypr.b)localObject7).tB() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((aypr.b)localObject8).tB() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    ram.e("Q.qqstory.QQStoryBaseActivity", "friends group list is null! ");
    localObject4 = new aypt(this, rpq.dip2px(this, 20.0F));
    ((aypt)localObject4).av(false, true);
    localObject5 = new aypx(this, getString(2131701766), "", 10004);
    ((aypx)localObject5).tS(true);
    localObject6 = new aypx(this, getString(2131701758), "", 10000);
    ((aypx)localObject6).tS(true);
    Object localObject7 = new aypx(this, getString(2131701762), "", 10001);
    ((aypx)localObject7).tS(false);
    Object localObject8 = new aypt(this, rpq.dip2px(this, 20.0F));
    ((aypt)localObject8).av(true, true);
    localObject3 = new aypr(this, getString(2131701765), "", 10002, (List)localObject3, this.app);
    localObject2 = new aypr(this, getString(2131701764), "", 10003, (List)localObject2, this.app);
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
      paramList = this.y;
      localObject1 = new aypu((List)localObject1);
      this.a = ((aypu)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.y.setOnItemClickListener(this.a);
      return;
      ((aypx)localObject5).setSelect(true);
      continue;
      ((aypx)localObject6).setSelect(true);
      continue;
      ((aypx)localObject7).setSelect(true);
      continue;
      ((aypr)localObject3).setSelect(true);
      ((aypr)localObject3).eV(paramList);
      continue;
      ((aypr)localObject2).setSelect(true);
      ((aypr)localObject2).eV(paramList);
    }
  }
  
  private aypr.b a(Groups paramGroups, List<Entity> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new aypr.a(localFriends));
        }
      }
    }
    return new aypr.b(paramGroups, localArrayList);
  }
  
  private void aft(int paramInt)
  {
    ram.d("Q.qqstory.QQStoryBaseActivity", "permissionReport type:" + paramInt);
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      rar.a("qim_pub", "clk_set_suc", 0, 0, new String[] { str });
      return;
      str = "0";
      continue;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  private void initTitle()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131377361);
    super.setTitle(acfp.m(2131709442));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(acfp.m(2131709435));
    this.rightViewText.setContentDescription(acfp.m(2131709437));
    this.rightViewText.setOnClickListener(new aypw(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null)) {}
  }
  
  public boolean onBackEvent()
  {
    rar.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559263);
    initTitle();
    Intent localIntent = getIntent();
    int i;
    if (localIntent != null)
    {
      i = localIntent.getIntExtra("PERMISSION_TYPE_KEY", 10000);
      paramBundle = localIntent.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");
      this.mHasTag = localIntent.getBooleanExtra("PERMISSION_HAS_TAG_KEY", false);
    }
    for (;;)
    {
      this.y = ((ListView)findViewById(2131372998));
      E(i, paramBundle);
      ((ViewGroup)this.y.getParent()).setBackgroundColor(getResources().getColor(2131167363));
      rar.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */