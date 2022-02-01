package com.tencent.mobileqq.activity;

import acfd;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqgv;
import aqho;
import aqhu;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jqc;
import vuj;

public class ShieldFriendsListActivity
  extends IphoneTitleBarActivity
  implements aqdf.a
{
  private TextView FK;
  acfd jdField_a_of_type_Acfd = new vuj(this);
  private aqdf jdField_a_of_type_Aqdf;
  private b jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$b;
  private XListView mListView;
  
  private void bVu()
  {
    ThreadManager.excute(new ShieldFriendsListActivity.1(this), 16, null, true);
  }
  
  private boolean j(long paramLong, boolean paramBoolean)
  {
    int j = this.mListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.mListView.getChildAt(i);
      if (localObject != null)
      {
        localObject = (a)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((a)localObject).uin).longValue()))
        {
          if (((a)localObject).A.isChecked() != paramBoolean)
          {
            ((a)localObject).A.setOnCheckedChangeListener(null);
            ((a)localObject).A.setChecked(paramBoolean);
            ((a)localObject).A.setOnCheckedChangeListener(((a)localObject).listener);
          }
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void updateUI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$b.getCount() <= 0)
    {
      this.mListView.setVisibility(8);
      this.FK.setVisibility(0);
      return;
    }
    this.mListView.setVisibility(0);
    this.FK.setVisibility(8);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561710);
    super.setTitle(2131701669);
    this.mListView = ((XListView)super.findViewById(2131370573));
    this.FK = ((TextView)super.findViewById(2131367143));
    this.FK.setText(2131701670);
    this.FK.setBackgroundDrawable(null);
    this.FK.setTextSize(2, 17.0F);
    this.FK.setTextColor(getResources().getColor(2131167506));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13);
    this.FK.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_Aqdf.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$b = new b(this, this.jdField_a_of_type_Aqdf, this.app);
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$b);
    paramBundle = (RelativeLayout.LayoutParams)this.mListView.getLayoutParams();
    paramBundle.topMargin = ((int)aqho.convertDpToPixel(this, 12.0F));
    this.mListView.setLayoutParams(paramBundle);
    bVu();
    addObserver(this.jdField_a_of_type_Acfd);
    if (AppSetting.enableTalkBack) {
      this.leftView.setContentDescription(acfp.m(2131714434));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldFriendsListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.mListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (a)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((a)localObject).uin)))
          {
            ((a)localObject).I.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public static class a
  {
    public Switch A;
    public URLImageView I;
    public CompoundButton.OnCheckedChangeListener listener;
    public TextView name;
    public String uin;
  }
  
  public static class b
    extends BaseAdapter
    implements CompoundButton.OnCheckedChangeListener
  {
    private aqdf a;
    private QQAppInterface mApp;
    private Context mContext;
    private List<Friends> re;
    
    public b(Context paramContext, aqdf paramaqdf, QQAppInterface paramQQAppInterface)
    {
      this.mContext = paramContext;
      this.re = new ArrayList(0);
      this.a = paramaqdf;
      this.mApp = paramQQAppInterface;
    }
    
    public void a(Friends paramFriends)
    {
      if ((this.re == null) || (paramFriends == null)) {
        this.re = new ArrayList(1);
      }
      this.re.add(paramFriends);
      notifyDataSetChanged();
    }
    
    public void fZ(List<Friends> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return;
      }
      this.re = paramList;
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.re == null) {
        return 0;
      }
      return this.re.size();
    }
    
    public Object getItem(int paramInt)
    {
      if (this.re == null) {
        return null;
      }
      return (Friends)this.re.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ShieldFriendsListActivity.a locala;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(2131561692, paramViewGroup, false);
        locala = new ShieldFriendsListActivity.a();
        locala.I = ((URLImageView)paramView.findViewById(2131378246));
        locala.name = ((TextView)paramView.findViewById(2131378247));
        locala.A = ((Switch)paramView.findViewById(2131378248));
        locala.A.setTag(locala);
        paramView.setTag(locala);
      }
      Object localObject;
      for (;;)
      {
        localObject = (Friends)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        locala = (ShieldFriendsListActivity.a)paramView.getTag();
      }
      locala.uin = ((Friends)localObject).uin;
      locala.A.setOnCheckedChangeListener(null);
      locala.A.setChecked(((Friends)localObject).isShield());
      locala.A.setOnCheckedChangeListener(this);
      locala.listener = this;
      Bitmap localBitmap = this.a.a(1, ((Friends)localObject).uin, 0);
      if (localBitmap == null)
      {
        if (!this.a.isPausing()) {
          this.a.i(((Friends)localObject).uin, 1, true);
        }
        locala.I.setBackgroundDrawable((BitmapDrawable)aqhu.aU());
      }
      for (;;)
      {
        localObject = aqgv.d(this.mApp, ((Friends)localObject).uin, 0);
        locala.name.setText((CharSequence)localObject);
        break;
        locala.I.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
    }
    
    public boolean isExist(String paramString)
    {
      if ((this.re == null) || (this.re.isEmpty())) {
        return false;
      }
      Iterator localIterator = this.re.iterator();
      while (localIterator.hasNext()) {
        if (((Friends)localIterator.next()).uin.equals(paramString)) {
          return true;
        }
      }
      return false;
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      Object localObject = this.mApp;
      int i;
      if (paramBoolean)
      {
        i = 1;
        anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8009DD1", "0X8009DD1", 0, i, "0", "0", "", "");
        i = jqc.getNetWorkType();
        if (i != -1) {
          break label163;
        }
        i = 2;
      }
      label163:
      for (;;)
      {
        localObject = (ShieldFriendsListActivity.a)paramCompoundButton.getTag();
        boolean bool;
        if (i == 0)
        {
          QQToast.a(this.mContext, 1, 2131698346, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          paramCompoundButton.setOnCheckedChangeListener(null);
          if (!paramBoolean)
          {
            bool = true;
            label99:
            paramCompoundButton.setChecked(bool);
            paramCompoundButton.setOnCheckedChangeListener(((ShieldFriendsListActivity.a)localObject).listener);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
          i = 2;
          break;
          bool = false;
          break label99;
          ((FriendListHandler)this.mApp.getBusinessHandler(1)).ai(Long.valueOf(((ShieldFriendsListActivity.a)localObject).uin).longValue(), paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity
 * JD-Core Version:    0.7.0.1
 */