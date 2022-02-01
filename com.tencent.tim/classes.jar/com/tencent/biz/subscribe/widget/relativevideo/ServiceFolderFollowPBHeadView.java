package com.tencent.biz.subscribe.widget.relativevideo;

import aajx;
import aalh.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqdf.a;
import aute;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import nyi;
import rze;
import sjn;
import sjo;
import sqn;

public class ServiceFolderFollowPBHeadView
  extends RelativeFeedBaseHeaderView
{
  private static String TAG = "ServiceFolderFollowPBHeadView";
  private TextView Ap;
  private TextView Aq;
  private a a;
  private String aEo;
  private boolean avA;
  private StatusView c;
  private LinearLayout fr;
  private LinearLayoutManager mLayoutManager;
  private RecyclerView mRecyclerView;
  
  public ServiceFolderFollowPBHeadView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void P(Object paramObject) {}
  
  public void bzf()
  {
    if (this.a != null) {
      this.a.release();
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.avA = rze.Mp();
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131378070));
    this.fr = ((LinearLayout)paramView.findViewById(2131378067));
    this.Ap = ((TextView)paramView.findViewById(2131378068));
    this.Aq = ((TextView)paramView.findViewById(2131378063));
    this.a = new a(getContext(), this.mRecyclerView);
    this.a.setInNightMode(this.avA);
    this.mRecyclerView.setAdapter(this.a);
    this.mLayoutManager = new LinearLayoutManager(getContext());
    this.mLayoutManager.setOrientation(0);
    this.mRecyclerView.setLayoutManager(this.mLayoutManager);
    ((GradientDrawable)this.fr.getBackground()).setColor(Color.parseColor("#00cafc"));
    this.fr.setOnClickListener(new sjn(this));
    this.c = ((StatusView)paramView.findViewById(2131378071));
    if (this.avA) {
      this.Aq.setTextColor(-10132123);
    }
  }
  
  public int getLayoutId()
  {
    return 2131559845;
  }
  
  public void setData(Object paramObject)
  {
    paramObject = (List)paramObject;
    if (this.a != null) {
      this.a.cS(paramObject);
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    if (this.a != null) {
      this.a.setDragHost(paramDragFrameLayout);
    }
  }
  
  public void setJumpWebMessageListUrl(String paramString)
  {
    this.aEo = paramString;
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mRecyclerView.getVisibility() == 8)
      {
        this.mRecyclerView.setVisibility(0);
        sqn.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.mRecyclerView.getVisibility() != 0) {
      return;
    }
    this.mRecyclerView.setVisibility(8);
  }
  
  public void uN(boolean paramBoolean)
  {
    if (this.c != null)
    {
      if (!paramBoolean) {
        break label38;
      }
      this.c.byP();
      if (this.c.getVisibility() == 8) {
        this.c.bkU();
      }
    }
    label38:
    while (this.c.getVisibility() != 0) {
      return;
    }
    this.c.bkV();
  }
  
  public void us(int paramInt)
  {
    this.Ap.post(new ServiceFolderFollowPBHeadView.2(this, paramInt));
  }
  
  static class a
    extends RecyclerView.Adapter
    implements aqdf.a
  {
    private aajx a;
    private boolean avA;
    private DragFrameLayout b;
    private HashMap<String, Bitmap> eA = new HashMap();
    private Context mContext;
    private List<nyi> mDataList;
    private RecyclerView mRecycleView;
    
    a(Context paramContext, RecyclerView paramRecyclerView)
    {
      this.mContext = paramContext;
      this.mRecycleView = paramRecyclerView;
      this.mDataList = new ArrayList();
      this.a = new aajx(((BaseActivity)paramContext).app, this, false);
    }
    
    private void bim()
    {
      if (this.mRecycleView != null)
      {
        if (this.mRecycleView.isComputingLayout()) {
          ThreadManager.getUIHandler().post(new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.1(this));
        }
      }
      else {
        return;
      }
      notifyDataSetChanged();
    }
    
    public void cS(List<nyi> paramList)
    {
      this.mDataList.clear();
      this.mDataList.addAll(paramList);
      bim();
    }
    
    public int getItemCount()
    {
      return this.mDataList.size();
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      ((ServiceFolderFollowPBHeadView.b)paramViewHolder).setIsInNightMode(this.avA);
      ((ServiceFolderFollowPBHeadView.b)paramViewHolder).b((nyi)this.mDataList.get(paramInt), paramInt);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new ServiceFolderFollowPBHeadView.b(LayoutInflater.from(this.mContext).inflate(2131559842, paramViewGroup, false), this.a, this.eA, this.b);
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
      for (;;)
      {
        return;
        this.eA.put(paramString, paramBitmap);
        paramBitmap = (LinearLayoutManager)this.mRecycleView.getLayoutManager();
        paramInt1 = 0;
        while (paramInt1 < getItemCount())
        {
          Object localObject = paramBitmap.findViewByPosition(paramInt1);
          if (localObject != null)
          {
            localObject = this.mRecycleView.getChildViewHolder((View)localObject);
            if (((localObject instanceof ServiceFolderFollowPBHeadView.b)) && (paramString.equals(((ServiceFolderFollowPBHeadView.b)localObject).c.mUin)))
            {
              ((ServiceFolderFollowPBHeadView.b)localObject).f(ServiceFolderFollowPBHeadView.b.a((ServiceFolderFollowPBHeadView.b)localObject), paramString);
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
    
    public void release()
    {
      if (this.eA != null) {
        this.eA.clear();
      }
      if (this.a != null) {
        this.a.onDestory();
      }
    }
    
    public void setDragHost(DragFrameLayout paramDragFrameLayout)
    {
      this.b = paramDragFrameLayout;
    }
    
    public void setInNightMode(boolean paramBoolean)
    {
      this.avA = paramBoolean;
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
  {
    private aalh.a a;
    private URLImageView aa;
    private boolean avA;
    public nyi c;
    private DragTextView e;
    private HashMap<String, Bitmap> eA;
    private aajx mFaceDecoder;
    private TextView mName;
    
    public b(View paramView, aajx paramaajx, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
    {
      super();
      this.mFaceDecoder = paramaajx;
      this.eA = paramHashMap;
      this.a = paramDragFrameLayout;
      this.aa = ((URLImageView)paramView.findViewById(2131378061));
      this.mName = ((TextView)paramView.findViewById(2131378066));
      this.e = ((DragTextView)paramView.findViewById(2131378069));
    }
    
    private boolean a(nyi paramnyi1, nyi paramnyi2)
    {
      if ((paramnyi1 != null) && (paramnyi2 != null)) {
        if ((!paramnyi1.mUin.equals(paramnyi2.mUin)) || (paramnyi1.mUnreadNum != paramnyi2.mUnreadNum) || (paramnyi1.mUnreadFlag != paramnyi2.mUnreadFlag) || (!paramnyi1.mTitleName.equals(paramnyi2.mTitleName))) {
          break label88;
        }
      }
      label88:
      for (boolean bool = true;; bool = false)
      {
        QLog.d(ServiceFolderFollowPBHeadView.access$100(), 4, "isSameServiceData:" + bool);
        return false;
      }
    }
    
    public void b(nyi paramnyi, int paramInt)
    {
      if ((paramnyi == null) || (a(this.c, paramnyi))) {
        return;
      }
      this.c = paramnyi;
      this.itemView.setTag(this.c);
      this.e.setTag(2131378063, this.c);
      this.e.setTag(2131378061, Integer.valueOf(paramInt));
      this.mName.setText(paramnyi.mTitleName);
      if (this.avA) {
        this.mName.setTextColor(-5723992);
      }
      f(this.aa, paramnyi.mUin);
      int j = paramnyi.mUnreadNum;
      int i = paramnyi.mUnreadFlag;
      int k;
      if (j > 0) {
        if (i == 0)
        {
          this.e.setDragViewType(-1, this.itemView);
          this.e.setOnModeChangeListener(null);
          j = 0;
          k = 0;
          i = 0;
        }
      }
      for (;;)
      {
        aute.updateCustomNoteTxt(this.e, i, j, k, 99, null);
        this.itemView.setOnClickListener(new sjo(this, paramnyi, paramInt));
        sqn.b(paramnyi.mUin, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramnyi.mTitleName, paramnyi.v.toString() });
        return;
        if (i == 2)
        {
          this.e.setDragViewType(-1, this.itemView);
          this.e.setOnModeChangeListener(null);
          j = 0;
          k = 0;
          i = 1;
        }
        else
        {
          i = 3;
          k = 2130851404;
          this.e.setDragViewType(0, this.itemView);
          this.e.setOnModeChangeListener(this.a);
          continue;
          j = 0;
          k = 0;
          i = 0;
        }
      }
    }
    
    @RequiresApi(api=8)
    public void f(ImageView paramImageView, String paramString)
    {
      Bitmap localBitmap = (Bitmap)this.eA.get(paramString);
      if (localBitmap == null) {
        paramImageView.setImageDrawable(this.mFaceDecoder.a(1008, paramString));
      }
      for (;;)
      {
        if (this.avA) {
          paramImageView.setColorFilter(1711276032);
        }
        return;
        paramImageView.setImageBitmap(localBitmap);
      }
    }
    
    public void setIsInNightMode(boolean paramBoolean)
    {
      this.avA = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView
 * JD-Core Version:    0.7.0.1
 */