package com.tencent.mobileqq.multicard;

import acff;
import acms;
import acnd;
import ajkd;
import ajke;
import ajkf;
import ajkg;
import ajkh;
import ajkm;
import ajkm.a;
import ajkm.a.a;
import ajkm.c;
import ajkm.c.a;
import ajkn;
import ajkq;
import ajkr;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aqdf;
import aqdf.a;
import aqgv;
import aqhu;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import wja;

public class MultiCardRecommendFragment
  extends PublicBaseFragment
{
  acnd jdField_a_of_type_Acnd = new ajkg(this);
  private ajkm jdField_a_of_type_Ajkm;
  ajkr jdField_a_of_type_Ajkr = new ajkf(this);
  private aqdf jdField_a_of_type_Aqdf;
  private acff b;
  private String bRE;
  aqdf.a c = new ajke(this);
  private RelativeLayout kV;
  private QQAppInterface mApp;
  private RecyclerView mRecyclerView;
  private String mTroopUin;
  public MqqHandler q = new ajkh(this);
  
  private void MB(String paramString)
  {
    if ((this.mRecyclerView == null) || (this.jdField_a_of_type_Ajkm == null) || (this.jdField_a_of_type_Ajkm.ma == null)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.jdField_a_of_type_Ajkm.ma);
    Object[] arrayOfObject = localHashMap.keySet().toArray();
    int j = 0;
    int i = 0;
    label66:
    if (j < localHashMap.size())
    {
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label220;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label220:
    for (;;)
    {
      List localList = (List)localHashMap.get(Integer.valueOf(i));
      int k = 0;
      while (k < localList.size())
      {
        RecommendPerson localRecommendPerson = (RecommendPerson)localList.get(k);
        if ((localRecommendPerson != null) && (paramString.equals(localRecommendPerson.uin))) {
          localList.remove(localRecommendPerson);
        }
        k += 1;
      }
      if (localList.size() == 0) {
        this.jdField_a_of_type_Ajkm.ma.remove(Integer.valueOf(i));
      }
      j += 1;
      break label66;
      break;
    }
  }
  
  private Object a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    Object localObject1;
    if ((this.mRecyclerView == null) || (this.jdField_a_of_type_Ajkm == null) || (this.jdField_a_of_type_Ajkm.ma == null))
    {
      localObject1 = null;
      return localObject1;
    }
    Object[] arrayOfObject = this.jdField_a_of_type_Ajkm.ma.keySet().toArray();
    int j = 0;
    int i = 0;
    label55:
    if (j < this.jdField_a_of_type_Ajkm.ma.size())
    {
      if (this.mRecyclerView.getChildAt(j) == null) {
        return null;
      }
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label357;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label166:
    label357:
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_Ajkm.ma.get(Integer.valueOf(i));
      RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.getChildViewHolder(this.mRecyclerView.getChildAt(j));
      if (localViewHolder != null)
      {
        int k = 0;
        if (k < localList.size())
        {
          localObject1 = (RecommendPerson)localList.get(k);
          Object localObject2;
          if ((localObject1 != null) && (paramString.equals(((RecommendPerson)localObject1).uin)))
          {
            localObject1 = (RecyclerView.ViewHolder)localViewHolder;
            if (!paramBoolean) {
              break;
            }
            if (!(localViewHolder instanceof ajkm.a)) {
              break label286;
            }
            localObject2 = (ajkm.a.a)((ajkm.a)localViewHolder).Do.get(k);
            localObject1 = localObject2;
            if (paramBitmap == null) {
              break;
            }
            localObject1 = localObject2;
            if (((ajkm.a.a)localObject2).E == null) {
              break;
            }
            ((ajkm.a.a)localObject2).E.setImageBitmap(paramBitmap);
          }
          for (;;)
          {
            k += 1;
            break label166;
            if ((localViewHolder instanceof ajkm.c))
            {
              localObject2 = (ajkm.c.a)((ajkm.c)localViewHolder).Do.get(k);
              localObject1 = localObject2;
              if (paramBitmap == null) {
                break;
              }
              localObject1 = localObject2;
              if (((ajkm.c.a)localObject2).E == null) {
                break;
              }
              ((ajkm.c.a)localObject2).E.setImageBitmap(paramBitmap);
            }
          }
        }
      }
      j += 1;
      break label55;
      return null;
    }
  }
  
  private void cG(View paramView)
  {
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131377512));
    this.kV = ((RelativeLayout)paramView.findViewById(2131377517));
    this.jdField_a_of_type_Ajkm = new ajkm(this, this.mApp);
    paramView = new LinearLayoutManager(getActivity());
    paramView.setOrientation(1);
    this.mRecyclerView.setLayoutManager(paramView);
    paramView = new a(null);
    this.mRecyclerView.addItemDecoration(paramView);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_Ajkm);
    this.mRecyclerView.addOnScrollListener(new ajkd(this));
    this.mApp.addObserver(this.jdField_a_of_type_Ajkr);
    this.mApp.addObserver(this.jdField_a_of_type_Acnd);
    this.jdField_a_of_type_Aqdf = new aqdf(getActivity(), this.mApp);
    this.jdField_a_of_type_Aqdf.a(this.c);
    this.b = ((acff)this.mApp.getManager(51));
    paramView = (ajkq)this.mApp.getManager(347);
    if (paramView != null) {
      paramView.h(this.mTroopUin, 11, null);
    }
    ((acms)this.mApp.getBusinessHandler(20)).b(false, this.mTroopUin + "", "0", 9);
  }
  
  private void ckT()
  {
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.edu();
      this.jdField_a_of_type_Aqdf.pause();
    }
  }
  
  private void ckU()
  {
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.resume();
    }
  }
  
  private void dxZ()
  {
    if ((this.mRecyclerView == null) || (this.jdField_a_of_type_Ajkm == null) || (this.jdField_a_of_type_Ajkm.ma == null)) {
      return;
    }
    Object[] arrayOfObject = this.jdField_a_of_type_Ajkm.ma.keySet().toArray();
    int j = 0;
    int i = 0;
    label48:
    if ((j < this.jdField_a_of_type_Ajkm.ma.size()) && (this.mRecyclerView.getChildAt(j) != null))
    {
      if ((arrayOfObject[j] == null) || (!(arrayOfObject[j] instanceof Integer))) {
        break label356;
      }
      i = ((Integer)arrayOfObject[j]).intValue();
    }
    label356:
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_Ajkm.ma.get(Integer.valueOf(i));
      RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.getChildViewHolder(this.mRecyclerView.getChildAt(j));
      if (localViewHolder != null)
      {
        int k = 0;
        if (k < localList.size())
        {
          Object localObject1;
          Object localObject2;
          if ((localViewHolder instanceof ajkm.a))
          {
            localObject1 = (ajkm.a)localViewHolder;
            if ((((ajkm.a)localObject1).Do != null) && (k < ((ajkm.a)localObject1).Do.size()))
            {
              localObject2 = (ajkm.a.a)((ajkm.a)localObject1).Do.get(k);
              if (((ajkm.a.a)localObject2).E != null) {
                ((ajkm.a.a)localObject2).E.setImageBitmap(getFaceBitmap(((RecommendPerson)((ajkm.a)localObject1).Dn.get(k)).uin));
              }
            }
          }
          for (;;)
          {
            k += 1;
            break;
            if ((localViewHolder instanceof ajkm.c))
            {
              localObject1 = (ajkm.c)localViewHolder;
              if ((((ajkm.c)localObject1).Do != null) && (k < ((ajkm.c)localObject1).Do.size()))
              {
                localObject2 = (ajkm.c.a)((ajkm.c)localObject1).Do.get(k);
                if (((ajkm.c.a)localObject2).E != null) {
                  ((ajkm.c.a)localObject2).E.setImageBitmap(getFaceBitmap(((RecommendPerson)((ajkm.c)localObject1).Dp.get(k)).uin));
                }
              }
            }
          }
        }
      }
      j += 1;
      break label48;
      break;
    }
  }
  
  private void dyb()
  {
    if ((this.jdField_a_of_type_Ajkm == null) || (this.jdField_a_of_type_Ajkm.ma == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.mRecyclerView.getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        localObject = (LinearLayoutManager)localObject;
        int j = ((LinearLayoutManager)localObject).findLastCompletelyVisibleItemPosition();
        int i = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
        localObject = this.jdField_a_of_type_Ajkm.ma.keySet().toArray();
        while (i <= j)
        {
          if ((i >= 0) && (i < this.jdField_a_of_type_Ajkm.ma.size()) && (localObject[i] != null) && ((localObject[i] instanceof Integer)))
          {
            int k = ((Integer)localObject[i]).intValue();
            List localList = (List)this.jdField_a_of_type_Ajkm.ma.get(Integer.valueOf(k));
            if ((localList != null) && (localList.size() > 0)) {
              ajkn.a(this.mApp, ((RecommendPerson)localList.get(0)).cardTypeID, i, localList);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private boolean nq(String paramString)
  {
    return this.b.kd(paramString);
  }
  
  private void refreshData()
  {
    if ((this.jdField_a_of_type_Ajkm != null) && (this.jdField_a_of_type_Ajkm.ma != null))
    {
      if (this.jdField_a_of_type_Ajkm.ma.size() == 0)
      {
        this.mRecyclerView.setVisibility(8);
        this.kV.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mRecyclerView.setVisibility(0);
    this.kV.setVisibility(8);
    Map localMap = this.jdField_a_of_type_Ajkm.ma;
    this.jdField_a_of_type_Ajkm = new ajkm(this, this.mApp);
    this.jdField_a_of_type_Ajkm.ma = localMap;
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_Ajkm);
    this.jdField_a_of_type_Ajkm.notifyDataSetChanged();
  }
  
  public int a(RecommendPerson paramRecommendPerson)
  {
    if (paramRecommendPerson.cardTypeID == 101) {
      return 18;
    }
    if (paramRecommendPerson.cardTypeID == 102) {
      return 19;
    }
    if (paramRecommendPerson.cardTypeID == 103) {
      return 20;
    }
    if (paramRecommendPerson.cardTypeID == 104) {
      return 21;
    }
    return 22;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    int i = 0;
    if (paramViewHolder != null) {
      i = paramViewHolder.getAdapterPosition();
    }
    paramViewHolder = new ProfileActivity.AllInOne(paramRecommendPerson.uin, 113);
    paramViewHolder.data.putSerializable("key_troop_recommend_person", paramRecommendPerson);
    paramViewHolder.data.putInt("key_troop_recommend_position", i);
    paramViewHolder.subSourceId = a(paramRecommendPerson);
    paramViewHolder.bJa = 122;
    ProfileActivity.a(getActivity(), paramViewHolder, 110);
    ajkn.a(this.mApp, i, paramRecommendPerson);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, RecommendPerson paramRecommendPerson)
  {
    if (paramViewHolder != null) {}
    for (int i = paramViewHolder.getAdapterPosition();; i = 0)
    {
      this.bRE = paramRecommendPerson.uin;
      int j = a(paramRecommendPerson);
      paramViewHolder = aqgv.h(this.mApp, this.mTroopUin, paramRecommendPerson.uin);
      startActivityForResult(AddFriendLogicActivity.a(getActivity(), 1, paramRecommendPerson.uin, this.mTroopUin, 3004, j, paramViewHolder, null, null, getString(2131721053), null), 111);
      ajkn.a(this.mApp, i, 1, paramRecommendPerson);
      return;
    }
  }
  
  public void dya()
  {
    Object localObject;
    if ((!TextUtils.isEmpty(this.bRE)) && ((nq(this.bRE)) || (this.b.isFriend(this.bRE))))
    {
      localObject = a(this.bRE, true, null);
      if (localObject != null)
      {
        if (!(localObject instanceof ajkm.a.a)) {
          break label126;
        }
        localObject = (ajkm.a.a)localObject;
        if ((localObject != null) && (((ajkm.a.a)localObject).gN != null)) {
          ((ajkm.a.a)localObject).gN.setText(2131720176);
        }
      }
    }
    for (;;)
    {
      this.q.sendEmptyMessageDelayed(2, 1200L);
      localObject = (ajkq)this.mApp.getManager(347);
      if (localObject != null) {
        ((ajkq)localObject).gJ(this.mTroopUin, this.bRE);
      }
      return;
      label126:
      if ((localObject instanceof ajkm.c.a))
      {
        localObject = (ajkm.c.a)localObject;
        if ((localObject != null) && (((ajkm.c.a)localObject).gN != null)) {
          ((ajkm.c.a)localObject).gN.setText(2131720176);
        }
      }
    }
  }
  
  public Bitmap getFaceBitmap(String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(1, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "getFaceBitmap（） uin =  " + paramString + " bitmap =" + localBitmap);
    }
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing())
    {
      this.jdField_a_of_type_Aqdf.i(paramString, 1, true);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "requestDecodeFace（） uin =  " + paramString);
      }
    }
    return aqhu.G();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      refreshData();
      continue;
      if (paramInt2 == -1) {
        dya();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563283, paramViewGroup, false);
    cG(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.removeObserver(this.jdField_a_of_type_Ajkr);
    this.mApp.removeObserver(this.jdField_a_of_type_Acnd);
    this.jdField_a_of_type_Aqdf.a(null);
    this.jdField_a_of_type_Aqdf.destory();
    this.b = null;
    this.jdField_a_of_type_Ajkm.destroy();
    this.jdField_a_of_type_Ajkm = null;
    this.mApp = null;
    this.jdField_a_of_type_Ajkr = null;
    this.jdField_a_of_type_Acnd = null;
  }
  
  public void onResume()
  {
    super.onResume();
    ckU();
  }
  
  public void onStop()
  {
    super.onStop();
    ckT();
  }
  
  class a
    extends RecyclerView.ItemDecoration
  {
    private final int top = wja.dp2px(12.0F, MultiCardRecommendFragment.this.getResources());
    
    private a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.top = this.top;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment
 * JD-Core Version:    0.7.0.1
 */