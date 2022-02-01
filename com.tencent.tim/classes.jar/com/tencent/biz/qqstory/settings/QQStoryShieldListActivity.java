package com.tencent.biz.qqstory.settings;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqdf;
import aqdf.a;
import aqho;
import aqhu;
import aqiw;
import arib;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import plr;
import pma;
import pmb;
import pmd;
import qov;
import qwq;
import rar;
import wja;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aqdf.a
{
  aqdf jdField_a_of_type_Aqdf;
  public arib a;
  a jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$a;
  private String axT;
  public pma b;
  public int bnq;
  int bnr;
  public pmb c;
  protected DisplayMetrics dm;
  pmd e = new qov(this);
  View jT;
  View mContentView;
  XListView mListView;
  TextView my;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131721066));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", acfp.m(2131712427));
    localIntent.putExtra("is_support_select_from_friend_groups", true);
    localIntent.putExtra("isExpandFirst", false);
    localIntent.putExtra("is_story_not_see", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 1001);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1001))
    {
      localObject = paramIntent.getParcelableArrayListExtra("friendsSelected");
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {}
    }
    else
    {
      return;
    }
    paramIntent = new ArrayList();
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.b;
    if (this.bnq == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((pma)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_Arib.aq(0, 2131718674, 0);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.bnq = getIntent().getIntExtra("sheild_type", 1);
    label110:
    boolean bool;
    if (this.bnq == 2)
    {
      paramBundle = acfp.m(2131712407) + plr.asZ;
      super.setContentView(2131561963);
      super.setTitle(paramBundle);
      this.my = ((TextView)super.findViewById(2131379724));
      if (this.bnq != 2) {
        break label481;
      }
      paramBundle = acfp.m(2131712411) + plr.asZ;
      this.my.setText(paramBundle);
      this.mListView = ((XListView)super.findViewById(2131378250));
      this.jdField_a_of_type_Arib = new arib(this, 2131561628);
      this.c = ((pmb)this.app.getManager(181));
      this.b = ((pma)this.app.getBusinessHandler(98));
      this.axT = String.valueOf(hashCode());
      paramBundle = this.c;
      if (this.bnq != 2) {
        break label534;
      }
      bool = true;
      label204:
      paramBundle = new ArrayList(paramBundle.e(bool));
      if (aqiw.isNetworkAvailable(this)) {
        break label539;
      }
      QQToast.a(this, 1, acfp.m(2131712431), 0).show(getTitleBarHeight());
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$a = new a(paramBundle);
      this.mListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$a);
      this.mContentView = super.findViewById(2131370541);
      this.jT = super.findViewById(2131372426);
      if ((paramBundle != null) && (paramBundle.size() != 0)) {
        break label590;
      }
      this.mContentView.setVisibility(8);
      this.jT.setVisibility(0);
      label320:
      if (this.bnq != 2) {
        break label610;
      }
    }
    label481:
    label610:
    for (paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的" + plr.asZ;; paramBundle = "把好友添加到这里后\r\n将不会看到该好友的" + plr.asZ)
    {
      ((TextView)this.jT.findViewById(2131372414)).setText(paramBundle);
      this.bnr = ((int)aqho.convertDpToPixel(this, 20.0F));
      setLeftViewName(2131690700);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText(acfp.m(2131721053));
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_Aqdf = new aqdf(this.app);
      this.jdField_a_of_type_Aqdf.a(this);
      this.dm = getResources().getDisplayMetrics();
      return true;
      paramBundle = acfp.m(2131712436) + plr.asZ;
      break;
      paramBundle = acfp.m(2131712428) + plr.asZ + acfp.m(2131712440) + plr.asY + acfp.m(2131712438);
      break label110;
      bool = false;
      break label204;
      this.app.addObserver(this.e);
      pma localpma = this.b;
      if (this.bnq == 2) {}
      for (bool = true;; bool = false)
      {
        localpma.a(null, 10, bool, this.axT);
        super.startTitleProgress();
        break;
      }
      this.mContentView.setVisibility(0);
      this.jT.setVisibility(8);
      break label320;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    this.jdField_a_of_type_Arib.dismiss();
    this.app.removeObserver(this.e);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    rar.R(14, this.currentActivityStayTime);
  }
  
  public void es(List<QQStoryUserInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.mContentView.setVisibility(8);
      this.jT.setVisibility(0);
      return;
    }
    this.mContentView.setVisibility(0);
    this.jT.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$a.eu(paramList);
  }
  
  public void finish()
  {
    qwq.aB(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this.rightViewText)
      {
        if (aqiw.isNetworkAvailable(this)) {
          break label256;
        }
        QQToast.a(this, 1, acfp.m(2131712432), 0).show(getTitleBarHeight());
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!aqiw.isNetworkAvailable(this))
      {
        QQToast.a(this, 1, acfp.m(2131712445), 0).show(getTitleBarHeight());
      }
      else
      {
        Object localObject = (QQStoryUserInfo)paramView.getTag();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((QQStoryUserInfo)localObject).uin);
        localObject = this.b;
        if (this.bnq == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((pma)localObject).a(localArrayList, bool, false);
          this.jdField_a_of_type_Arib.aq(0, 2131718674, 0);
          if (this.bnq != 2) {
            break label214;
          }
          rar.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label214:
        rar.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
        break;
        label256:
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localObject = this.c;
        if (this.bnq == 2) {}
        for (bool = true;; bool = false)
        {
          localObject = ((pmb)localObject).e(bool);
          if (localObject == null) {
            break;
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((QQStoryUserInfo)((Iterator)localObject).next()).uin);
          }
        }
        if (this.bnq == 1) {}
        for (bool = true;; bool = false)
        {
          a(this, localArrayList, bool);
          if (this.bnq != 2) {
            break label421;
          }
          rar.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label421:
        rar.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$a.notifyDataSetChanged();
  }
  
  class a
    extends BaseAdapter
  {
    List<QQStoryUserInfo> mDatas = new ArrayList();
    
    public a()
    {
      Collection localCollection;
      if (localCollection != null)
      {
        this.mDatas = new ArrayList(localCollection);
        Collections.sort(this.mDatas);
      }
    }
    
    public void eu(List<QQStoryUserInfo> paramList)
    {
      this.mDatas = new ArrayList(paramList);
      if (this.mDatas != null) {
        Collections.sort(this.mDatas);
      }
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.mDatas.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mDatas.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = LayoutInflater.from(QQStoryShieldListActivity.this).inflate(2131561964, null);
        paramView = new a();
        paramView.mD = ((ImageView)localView.findViewById(2131366624));
        paramView.name = ((TextView)localView.findViewById(2131372190));
        paramView.name.setMaxWidth(QQStoryShieldListActivity.this.dm.widthPixels - wja.dp2px(175.0F, QQStoryShieldListActivity.this.getResources()));
        paramView.delBtn = ((Button)localView.findViewById(2131365704));
        paramView.delBtn.setOnClickListener(QQStoryShieldListActivity.this);
        localView.setTag(paramView);
        localObject = (QQStoryUserInfo)this.mDatas.get(paramInt);
        paramView.uin = ((QQStoryUserInfo)localObject).uin;
        paramView.name.setText(((QQStoryUserInfo)localObject).nick);
        paramView.delBtn.setTag(localObject);
        if (this.mDatas.size() <= 2) {
          break label289;
        }
        if (paramInt != 0) {
          break label254;
        }
        localView.setBackgroundResource(2130839701);
        label186:
        localObject = QQStoryShieldListActivity.this.app.getFaceBitmap(((QQStoryUserInfo)localObject).uin, true);
        if (localObject == null) {
          break label349;
        }
        paramView.mD.setImageBitmap((Bitmap)localObject);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label254:
        if (paramInt == this.mDatas.size() - 1)
        {
          localView.setBackgroundResource(2130839689);
          break label186;
        }
        localView.setBackgroundResource(2130839695);
        break label186;
        label289:
        if (this.mDatas.size() == 2)
        {
          if (paramInt == 0)
          {
            localView.setBackgroundResource(2130839701);
            break label186;
          }
          localView.setBackgroundResource(2130839689);
          break label186;
        }
        if (this.mDatas.size() != 1) {
          break label186;
        }
        localView.setBackgroundResource(2130839689);
        break label186;
        label349:
        paramView.mD.setImageBitmap(aqhu.G());
      }
    }
    
    class a
    {
      Button delBtn;
      ImageView mD;
      TextView name;
      String uin;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */