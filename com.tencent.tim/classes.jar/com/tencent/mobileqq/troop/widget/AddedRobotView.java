package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aprg;
import aptv;
import aptw;
import apuq;
import apur;
import aqdf;
import aqdf.a;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class AddedRobotView
  extends LinearLayout
{
  private aqdf.a jdField_a_of_type_Aqdf$a = new apuq(this);
  private a jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$a;
  private TextView abd;
  private TextView abe;
  private GridLayoutManager c;
  private aqdf d;
  private Context mContext;
  private RecyclerView mRecyclerView;
  private RecyclerView.OnScrollListener mScrollListener = new apur(this);
  private String mTroopUin;
  private RelativeLayout mq;
  
  public AddedRobotView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AddedRobotView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AddedRobotView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    setOrientation(1);
    paramContext = LayoutInflater.from(this.mContext);
    setBackgroundResource(2130851428);
    paramContext = paramContext.inflate(2131561749, null);
    this.abd = ((TextView)paramContext.findViewById(2131370343));
    this.abe = ((TextView)paramContext.findViewById(2131377270));
    addView(paramContext);
    this.mRecyclerView = new RecyclerView(this.mContext);
    this.c = new GridLayoutManager(this.mContext, 5);
    this.mRecyclerView.setLayoutManager(this.c);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.mRecyclerView.setLayoutParams(paramContext);
    this.mRecyclerView.setOverScrollMode(2);
    addView(this.mRecyclerView);
    paramContext = new TextView(this.mContext);
    paramContext.setText(getResources().getString(2131696325));
    paramContext.setTextSize(2, 14.0F);
    paramContext.setTextColor(getResources().getColor(2131167379));
    paramContext.setContentDescription(getResources().getString(2131696325));
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.mq = new RelativeLayout(this.mContext);
    this.mq.setBackgroundResource(2130851428);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299322));
    this.mq.setLayoutParams(localLayoutParams);
    this.mq.setGravity(17);
    this.mq.addView(paramContext);
    addView(this.mq);
    paramContext = new RelativeLayout(this.mContext);
    paramContext.setBackgroundResource(2130838900);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299323)));
    addView(paramContext);
    this.d = new aqdf((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.d.a(this.jdField_a_of_type_Aqdf$a);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$a = new a(this.mContext);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$a);
    this.mRecyclerView.addOnScrollListener(this.mScrollListener);
  }
  
  public void Destroy()
  {
    QLog.i("AddedRobotView", 1, "onDestroy.");
    if (this.d != null) {
      this.d.destory();
    }
    this.mContext = null;
  }
  
  public void setAddList(ArrayList<aptv> paramArrayList, int paramInt, String paramString)
  {
    if (this.abe != null) {
      if (paramArrayList == null) {
        break label216;
      }
    }
    label216:
    for (int i = paramArrayList.size();; i = 0)
    {
      String str = i + "/" + paramInt;
      this.abe.setText(str);
      this.abe.setVisibility(0);
      this.abe.setContentDescription(str);
      if (this.abd != null)
      {
        this.abd.setText(this.mContext.getResources().getText(2131689925));
        this.abd.setContentDescription(this.mContext.getResources().getText(2131689925));
      }
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        this.mq.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        QLog.d("AddedRobotView", 2, "setAddList 0");
      }
      for (;;)
      {
        this.mTroopUin = paramString;
        return;
        this.mRecyclerView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView$a.setDatas(paramArrayList);
        this.mq.setVisibility(8);
        QLog.d("AddedRobotView", 2, "setAddList " + paramArrayList.size());
      }
    }
  }
  
  public class a
    extends RecyclerView.Adapter<a>
    implements View.OnClickListener
  {
    private ArrayList<aptv> iM = new ArrayList();
    private Context mContext;
    LayoutInflater mLayoutInflater;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = ((LayoutInflater)AddedRobotView.this.getContext().getSystemService("layout_inflater"));
    }
    
    public a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(this.mLayoutInflater.inflate(2131561751, paramViewGroup, false));
    }
    
    public void a(a parama, int paramInt)
    {
      aptv localaptv;
      Object localObject2;
      Object localObject1;
      if ((this.iM != null) && (paramInt < this.iM.size()))
      {
        localaptv = (aptv)this.iM.get(paramInt);
        if (localaptv != null)
        {
          String str = String.valueOf(localaptv.getUin());
          localObject2 = AddedRobotView.a(AddedRobotView.this).b(1, str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = aqhu.G();
            localObject1 = localObject2;
            if (!AddedRobotView.a(AddedRobotView.this).isPausing())
            {
              AddedRobotView.a(AddedRobotView.this).i(str, 1, false);
              localObject1 = localObject2;
            }
          }
          parama.E.setImageBitmap((Bitmap)localObject1);
          parama.name.setText(localaptv.getName());
          parama.uin = String.valueOf(localaptv.getUin());
          parama.EJ.setOnClickListener(this);
          parama.EJ.setTag(localaptv);
          parama.name.setOnClickListener(this);
          parama.name.setTag(localaptv);
          parama.EJ.setContentDescription(localaptv.getName());
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject1 != null)
          {
            localObject2 = (aptw)((QQAppInterface)localObject1).getManager(203);
            if (localObject2 == null) {
              break label351;
            }
          }
        }
      }
      label320:
      label351:
      for (boolean bool = ((aptw)localObject2).e((QQAppInterface)localObject1, String.valueOf(localaptv.getUin()), AddedRobotView.a(AddedRobotView.this));; bool = false)
      {
        if (bool)
        {
          parama.xn.setVisibility(0);
          if (!localaptv.isOffline()) {
            break label320;
          }
          parama.EJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847091));
          parama.abf.setVisibility(0);
        }
        for (;;)
        {
          EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
          return;
          parama.xn.setVisibility(8);
          break;
          parama.EJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847072));
          parama.abf.setVisibility(8);
        }
      }
    }
    
    public int getItemCount()
    {
      if (this.iM != null) {
        return this.iM.size();
      }
      return 0;
    }
    
    public void onClick(View paramView)
    {
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof aptv)))
      {
        localObject = (aptv)localObject;
        aprg.H(this.mContext, AddedRobotView.a(AddedRobotView.this), String.valueOf(((aptv)localObject).getUin()));
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localQQAppInterface != null)
        {
          aptw localaptw = (aptw)localQQAppInterface.getManager(203);
          if ((localaptw != null) && (localaptw.e(localQQAppInterface, String.valueOf(((aptv)localObject).getUin()), AddedRobotView.a(AddedRobotView.this)))) {
            localaptw.ba(localQQAppInterface, String.valueOf(((aptv)localObject).getUin()));
          }
        }
        anot.a(localQQAppInterface, "dc00898", "", "", "", "0X8009F9E", 0, 0, String.valueOf(((aptv)localObject).getUin()), "", "", "");
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void setDatas(ArrayList<aptv> paramArrayList)
    {
      if (paramArrayList != null)
      {
        this.iM.clear();
        this.iM.addAll(paramArrayList);
      }
      notifyDataSetChanged();
    }
    
    public class a
      extends RecyclerView.ViewHolder
    {
      public ImageView E;
      protected ImageView EJ;
      protected TextView abf;
      protected TextView name;
      public String uin;
      protected ImageView xn;
      
      public a(View paramView)
      {
        super();
        this.abf = ((TextView)paramView.findViewById(2131365636));
        this.E = ((ImageView)paramView.findViewById(2131368375));
        this.name = ((TextView)paramView.findViewById(2131372190));
        this.EJ = ((ImageView)paramView.findViewById(2131368393));
        this.xn = ((ImageView)paramView.findViewById(2131377002));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView
 * JD-Core Version:    0.7.0.1
 */