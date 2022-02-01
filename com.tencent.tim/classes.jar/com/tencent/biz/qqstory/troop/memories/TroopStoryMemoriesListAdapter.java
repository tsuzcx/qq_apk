package com.tencent.biz.qqstory.troop.memories;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqbn;
import aqdj;
import aqho;
import aqhu;
import auvd.a;
import auvd.b;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import psx;
import ptf;
import pxk;
import qem;
import rob;
import roc;
import rod;
import roe;
import rof;
import rog;
import roh;
import roq;
import rpq;
import rsy;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] an = { 2131718824, 2131692505 };
  private static final int[] ao = { 2131165858, 2131165745 };
  private static final int[] ap = { 2131377159, 2131371284 };
  public c a;
  e a;
  boolean aJd;
  ArrayList<TroopStoryItemInfo> ed;
  QQAppInterface f;
  final float jG;
  Context mContext;
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = aqhu.at();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((ptf)psx.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(qem.d((QQUserUIItem)localObject2));
        qem.n(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        qem.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)aqho.convertDpToPixel(this.mContext, 35.0F));
        paramTextView.setText(qem.d((QQUserUIItem)localObject2));
        qem.a(this.mContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = aqdj.a(this.f, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      qem.n(paramTextView);
      return;
      localObject1 = localObject2;
    }
  }
  
  private View d(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561990, paramViewGroup, false);
      paramViewGroup.setTag(new i(paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561986, paramViewGroup, false);
      paramViewGroup.setTag(new a(paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561988, paramViewGroup, false);
      paramViewGroup.setTag(new d(paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561987, paramViewGroup, false);
      paramViewGroup.setTag(new b(paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.mContext).inflate(2131561989, paramViewGroup, false);
      paramViewGroup = new h(localView);
      localView = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$e.a(this.mContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.mContext).inflate(2131561989, paramViewGroup, false);
      paramViewGroup = new g(localView);
      localView = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$e.a(this.mContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.mContext).inflate(2131561989, paramViewGroup, false);
    paramViewGroup = new f(localView);
    localView = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$e.a(this.mContext, localView, paramViewGroup, -1);
    localView.setTag(paramViewGroup);
    return localView;
  }
  
  private void m(int paramInt, View paramView)
  {
    int i = getItemViewType(paramInt);
    TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.ed.get(paramInt);
    switch (i)
    {
    default: 
      return;
    case 0: 
      ((i)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((a)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((d)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((b)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (g)paramView.getTag();
      ((g)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new rob(this, paramInt));
      this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$e.a(this.mContext, paramView, paramInt, this.ed.get(paramInt), (auvd.a)localObject, this);
      return;
    case 6: 
      localObject = (f)paramView.getTag();
      ((f)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new roc(this, paramInt));
      this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$e.a(this.mContext, paramView, paramInt, this.ed.get(paramInt), (auvd.a)localObject, this);
      return;
    }
    Object localObject = (h)paramView.getTag();
    ((h)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new rod(this, paramInt));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$e.a(this.mContext, paramView, paramInt, this.ed.get(paramInt), (auvd.a)localObject, this);
  }
  
  public int getCount()
  {
    return this.ed.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.ed.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((TroopStoryItemInfo)this.ed.get(paramInt)).itemType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = d(paramInt, paramViewGroup);
    }
    for (;;)
    {
      m(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopStoryMemoriesListAdapter", 2, localException, new Object[0]);
        }
        int i = -1;
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$c != null)
        {
          TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.ed.get(i);
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131371284: 
            this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$c.a(paramView, i, localTroopStoryItemInfo, 2);
            break;
          case 2131377159: 
            this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter$c.a(paramView, localTroopStoryItemInfo, 2);
          }
        }
      }
    }
  }
  
  public static class GetFeedFeatureHelper
    implements Runnable
  {
    final int btM = 500;
    Handler handler = new Handler(ThreadManager.getSubThreadLooper());
    List<String> pc = new ArrayList();
    
    public void run()
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopStoryMemoriesListAdapter", 2, "start to send GetFeedFeature request: " + this.pc);
      }
      pxk.ei(this.pc);
      this.pc = new ArrayList();
    }
  }
  
  class a
  {
    public View oZ;
    public View pa;
    public View pb;
    public View pc;
    public TextView xM;
    public TextView yU;
    public TextView yV;
    public TextView yW;
    
    public a(View paramView)
    {
      this.yU = ((TextView)paramView.findViewById(2131379955));
      this.xM = ((TextView)paramView.findViewById(2131365621));
      this.yV = ((TextView)paramView.findViewById(2131371906));
      this.yW = ((TextView)paramView.findViewById(2131381643));
      this.oZ = paramView.findViewById(2131370473);
      this.pa = paramView.findViewById(2131370475);
      this.pc = paramView.findViewById(2131370476);
      this.pb = paramView.findViewById(2131370474);
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
    {
      Object localObject = roq.b(paramTroopStoryItemInfo.publishTime);
      if (TextUtils.isEmpty(localObject[0]))
      {
        this.yU.setText(localObject[1]);
        this.xM.setVisibility(8);
        this.yV.setVisibility(8);
        this.yU.setVisibility(0);
        this.pc.setVisibility(8);
        this.pb.setVisibility(8);
        if ((paramInt > 0) && (((TroopStoryItemInfo)TroopStoryMemoriesListAdapter.this.ed.get(paramInt - 1)).itemType == 0))
        {
          this.pa.setVisibility(8);
          this.oZ.setVisibility(0);
        }
        while (paramTroopStoryItemInfo.publishCount == 0)
        {
          this.yW.setText(acfp.m(2131716145));
          return;
          this.pa.setVisibility(0);
          this.oZ.setVisibility(8);
        }
      }
      this.xM.setText(localObject[1]);
      this.yV.setText(localObject[0]);
      this.xM.setVisibility(0);
      this.yV.setVisibility(0);
      this.yU.setVisibility(8);
      if ((paramInt > 0) && (((TroopStoryItemInfo)TroopStoryMemoriesListAdapter.this.ed.get(paramInt - 1)).itemType == 0))
      {
        this.pc.setVisibility(8);
        this.pb.setVisibility(0);
      }
      for (;;)
      {
        this.pa.setVisibility(8);
        this.oZ.setVisibility(8);
        break;
        this.pc.setVisibility(0);
        this.pb.setVisibility(8);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTroopStoryItemInfo.publishCount).append("个小视频");
      if (paramTroopStoryItemInfo.dayCommentCount > 0)
      {
        ((StringBuilder)localObject).append(" 评论").append(paramTroopStoryItemInfo.dayCommentCount);
        if (paramTroopStoryItemInfo.dayLikeCount > 0) {
          ((StringBuilder)localObject).append("·");
        }
      }
      if (paramTroopStoryItemInfo.dayLikeCount > 0)
      {
        if (paramTroopStoryItemInfo.dayCommentCount <= 0) {
          ((StringBuilder)localObject).append(" ");
        }
        ((StringBuilder)localObject).append("赞").append(paramTroopStoryItemInfo.dayLikeCount);
      }
      this.yW.setText(((StringBuilder)localObject).toString());
    }
  }
  
  class b
  {
    public View convertView;
    public View gk;
    
    public b(View paramView)
    {
      this.convertView = paramView;
      this.gk = paramView.findViewById(2131370458);
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
    {
      Iterator localIterator = TroopStoryMemoriesListAdapter.this.ed.iterator();
      float f = 0.0F;
      if (localIterator.hasNext())
      {
        switch (((TroopStoryItemInfo)localIterator.next()).itemType)
        {
        }
        for (;;)
        {
          break;
          if ((roq.isToday(paramTroopStoryItemInfo.publishTime)) || (roq.bb(paramTroopStoryItemInfo.publishTime)))
          {
            f = rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 44.0F) + f;
          }
          else
          {
            f = rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 71.0F) + f;
            continue;
            f = rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 95.0F) + f;
            continue;
            f = rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 70.0F) + f;
            continue;
            f = rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 95.0F) + f;
          }
        }
      }
      int i = (int)(TroopStoryMemoriesListAdapter.this.jG - f);
      paramTroopStoryItemInfo = (LinearLayout.LayoutParams)this.gk.getLayoutParams();
      if (i <= 0)
      {
        paramTroopStoryItemInfo.height = 0;
        this.gk.setLayoutParams(paramTroopStoryItemInfo);
        this.convertView.setVisibility(8);
        return;
      }
      paramTroopStoryItemInfo.height = i;
      this.gk.setLayoutParams(paramTroopStoryItemInfo);
      this.convertView.setVisibility(0);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt1, TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt2);
    
    public abstract void a(View paramView, TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt);
    
    public abstract void bvJ();
    
    public abstract boolean e(View paramView, int paramInt);
    
    public abstract void n(int paramInt, View paramView);
  }
  
  public class d
  {
    public View convertView;
    public View pd;
    
    public d(View paramView)
    {
      this.convertView = paramView;
      this.pd = paramView.findViewById(2131381646);
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
    {
      this.convertView.setOnClickListener(new roe(this));
    }
  }
  
  class e
    extends rsy
  {
    public View a(Context paramContext, View paramView, auvd.a parama, int paramInt)
    {
      parama.b = new auvd.b[this.euG];
      paramInt = 0;
      while (paramInt < this.euG)
      {
        parama.b[paramInt] = new auvd.b();
        parama.b[paramInt].dOe = -1;
        parama.b[paramInt].euH = 0;
        parama.b[paramInt].LA = null;
        paramInt += 1;
      }
      parama.Lz = paramView.findViewById(2131370144);
      return paramView;
    }
    
    public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
    {
      paramArrayOfb[0].dOe = 0;
      paramArrayOfb[0].dOf = 0;
      paramArrayOfb[1].dOe = -1;
      paramArrayOfb[1].dOf = -1;
      String str = QQStoryContext.a().mi();
      if ((this.a.aJd) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
      {
        paramArrayOfb[1].dOe = 1;
        paramArrayOfb[1].dOf = 1;
      }
    }
    
    public void a(ViewGroup paramViewGroup, View paramView, auvd.b paramb, int paramInt)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null) {
        paramView.setLayoutParams(new LinearLayout.LayoutParams(paramb.euH, paramb.euI));
      }
      for (;;)
      {
        paramViewGroup.addView(paramView, paramInt);
        return;
        localLayoutParams.width = paramb.euH;
        localLayoutParams.height = paramb.euI;
      }
    }
  }
  
  public class f
    extends TroopStoryMemoriesListAdapter.h
  {
    public f(View paramView)
    {
      super(paramView);
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
    {
      TroopStoryMemoriesListAdapter.a(TroopStoryMemoriesListAdapter.this, paramTroopStoryItemInfo, this.X, this.nameTV);
      Drawable localDrawable = TroopStoryMemoriesListAdapter.this.mContext.getResources().getDrawable(2130847768);
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "troop_story_message";
        localObject = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(aqbn.d(rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 50.0F), rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 70.0F), rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 3.0F)));
        ((URLDrawable)localObject).setDecodeHandler(aqbn.a);
        this.Y.setImageDrawable((Drawable)localObject);
        localDrawable = TroopStoryMemoriesListAdapter.this.mContext.getResources().getDrawable(2130847765);
        localDrawable.setBounds(0, 0, 26, 26);
        this.yX.setCompoundDrawablePadding(10);
        this.yX.setCompoundDrawables(localDrawable, null, null, null);
        this.yX.setText(acfp.m(2131716146));
        this.yX.setTextColor(-65536);
        this.convertView.setOnClickListener(new rof(this, paramTroopStoryItemInfo));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.Y.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public class g
    extends TroopStoryMemoriesListAdapter.h
  {
    public g(View paramView)
    {
      super(paramView);
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
    {
      TroopStoryMemoriesListAdapter.a(TroopStoryMemoriesListAdapter.this, paramTroopStoryItemInfo, this.X, this.nameTV);
      this.yX.setText(roq.aK(paramTroopStoryItemInfo.publishTime));
      Drawable localDrawable = TroopStoryMemoriesListAdapter.this.mContext.getResources().getDrawable(2130847768);
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
        paramTroopStoryItemInfo = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), localURLDrawableOptions);
        paramTroopStoryItemInfo.setTag(aqbn.d(rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 50.0F), rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 70.0F), rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 3.0F)));
        paramTroopStoryItemInfo.setDecodeHandler(aqbn.a);
        this.Y.setImageDrawable(paramTroopStoryItemInfo);
        paramTroopStoryItemInfo = TroopStoryMemoriesListAdapter.this.mContext.getResources().getDrawable(2130839651);
        paramTroopStoryItemInfo.setBounds(0, 0, 26, 26);
        this.yX.setCompoundDrawables(paramTroopStoryItemInfo, null, null, null);
        this.yX.setCompoundDrawablePadding(10);
        this.yX.setText(acfp.m(2131716147));
        ((Animatable)paramTroopStoryItemInfo).start();
        this.convertView.setOnClickListener(new rog(this));
        return;
      }
      catch (Exception paramTroopStoryItemInfo)
      {
        for (;;)
        {
          this.Y.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public class h
    extends auvd.a
  {
    public URLImageView X;
    public URLImageView Y;
    public View convertView;
    public TextView nameTV;
    public TextView yX;
    
    public h(View paramView)
    {
      this.convertView = paramView;
      this.X = ((URLImageView)paramView.findViewById(2131363175));
      this.nameTV = ((TextView)paramView.findViewById(2131372190));
      this.yX = ((TextView)paramView.findViewById(2131379661));
      this.Y = ((URLImageView)paramView.findViewById(2131381830));
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
    {
      TroopStoryMemoriesListAdapter.a(TroopStoryMemoriesListAdapter.this, paramTroopStoryItemInfo, this.X, this.nameTV);
      this.yX.setText(roq.aK(paramTroopStoryItemInfo.publishTime));
      Drawable localDrawable = TroopStoryMemoriesListAdapter.this.mContext.getResources().getDrawable(2130847768);
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "troop_story_message";
        paramTroopStoryItemInfo = URLDrawable.getDrawable(paramTroopStoryItemInfo.videoThumbUrl, localURLDrawableOptions);
        paramTroopStoryItemInfo.setTag(aqbn.d(rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 50.0F), rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 70.0F), rpq.dip2px(TroopStoryMemoriesListAdapter.this.mContext, 3.0F)));
        paramTroopStoryItemInfo.setDecodeHandler(aqbn.a);
        this.Y.setImageDrawable(paramTroopStoryItemInfo);
        this.convertView.setOnClickListener(new roh(this, paramInt));
        return;
      }
      catch (Exception paramTroopStoryItemInfo)
      {
        for (;;)
        {
          this.Y.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  class i
  {
    public TextView yW;
    public TextView yY;
    
    public i(View paramView)
    {
      this.yY = ((TextView)paramView.findViewById(2131382399));
      this.yW = ((TextView)paramView.findViewById(2131381643));
    }
    
    public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
    {
      this.yY.setText(roq.aJ(paramTroopStoryItemInfo.publishTime));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */