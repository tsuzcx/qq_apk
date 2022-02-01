package com.tencent.mobileqq.activity;

import abex.c;
import abfm;
import achg;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import vqv;
import vqw;
import vqx;

public class RecommendFriendActivity
  extends BaseActivity
{
  private TextView BC;
  abex.c jdField_a_of_type_Abex$c = new vqv(this);
  private abfm jdField_a_of_type_Abfm;
  private achg jdField_a_of_type_Achg;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  SwipListView.a b = new vqx(this);
  private TextView bI;
  private LinearLayout dK;
  private SwipListView e;
  private TextView mTitleTextView;
  ArrayList<MayKnowRecommend> pw = new ArrayList();
  
  private void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void a(Intent paramIntent, int paramInt, List<MayKnowRecommend> paramList)
  {
    if ((paramInt == 9) || (paramInt == 8))
    {
      paramIntent = (ArrayList)this.pw.clone();
      Object localObject;
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        localObject = new ArrayList(paramIntent.size());
        Iterator localIterator1 = paramIntent.iterator();
        while (localIterator1.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend1 = (MayKnowRecommend)localIterator1.next();
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext())
          {
            MayKnowRecommend localMayKnowRecommend2 = (MayKnowRecommend)localIterator2.next();
            if (localMayKnowRecommend2.uin.equalsIgnoreCase(localMayKnowRecommend1.uin)) {
              ((List)localObject).add(localMayKnowRecommend2);
            }
          }
          if (paramInt == 9) {
            localMayKnowRecommend1.bHighLight = true;
          }
        }
        paramList.removeAll((Collection)localObject);
        paramList.addAll(0, paramIntent);
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder("handlePushFrds");
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (MayKnowRecommend)paramIntent.next();
            paramList.append(" ").append(((MayKnowRecommend)localObject).uin);
          }
        }
        QLog.i("qqBaseActivity", 2, paramList.toString());
      }
    }
  }
  
  private void wn(String paramString)
  {
    int i = getIntent().getIntExtra("EntranceId", 0);
    if ((i == 9) || (i == 8))
    {
      Object localObject = (ArrayList)this.pw.clone();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject).next();
          if (paramString.equals(localMayKnowRecommend.uin)) {
            this.pw.remove(localMayKnowRecommend);
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558510);
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("EntranceId", 0);
    paramBundle = localIntent.getStringExtra("uin");
    this.dK = ((LinearLayout)findViewById(2131377546));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.dK.setFitsSystemWindows(true);
      this.dK.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.bI = ((TextView)findViewById(2131366420));
    this.e = ((SwipListView)findViewById(2131376927));
    this.e.setDragEnable(true);
    this.e.setRightIconMenuListener(this.b);
    this.jdField_a_of_type_Abfm = new abfm(this, this.app, this.e, i, this.jdField_a_of_type_Abex$c);
    int j = getResources().getDimensionPixelSize(2131297808);
    this.jdField_a_of_type_Abfm.GY(j);
    this.jdField_a_of_type_Abfm.Bu(paramBundle);
    this.mTitleTextView = ((TextView)findViewById(2131369627));
    this.mTitleTextView.setVisibility(0);
    this.mTitleTextView.setText(2131695683);
    setTitle(getString(2131695683));
    this.BC = ((TextView)findViewById(2131369579));
    this.BC.setVisibility(0);
    this.BC.setText("");
    this.BC.setOnClickListener(new vqw(this));
    this.jdField_a_of_type_Achg = ((achg)this.app.getManager(159));
    ArrayList localArrayList = this.jdField_a_of_type_Achg.cw();
    try
    {
      paramBundle = (ArrayList)localIntent.getSerializableExtra("may_know_recmmds");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.pw.addAll(paramBundle);
        a(localIntent, i, localArrayList);
      }
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_Abfm.gJ(localArrayList);
        this.bI.setVisibility(8);
        return true;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, paramBundle.getMessage(), paramBundle);
        }
        paramBundle = null;
      }
      this.bI.setVisibility(0);
      this.jdField_a_of_type_Achg.iu(4);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Abfm != null) {
      this.jdField_a_of_type_Abfm.destroy();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Abfm != null) {
      this.jdField_a_of_type_Abfm.cli();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Abfm != null) {
      this.jdField_a_of_type_Abfm.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendFriendActivity
 * JD-Core Version:    0.7.0.1
 */