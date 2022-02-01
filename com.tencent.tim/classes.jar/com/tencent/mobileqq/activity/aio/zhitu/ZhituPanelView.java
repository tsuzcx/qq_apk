package com.tencent.mobileqq.activity.aio.zhitu;

import acfp;
import aheq;
import ahyb;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqnm;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wja;
import wki;
import ykm;
import ykt;
import ykv;
import ykw;

public class ZhituPanelView
  extends RichTextPanelView
{
  private static String NAME = acfp.m(2131716996);
  private static String TAG = "ZhituManager.PanelView";
  public static int bZH = 6;
  TextView KN;
  private ahyb jdField_a_of_type_Ahyb;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private int adw;
  private c b;
  private ykv c;
  private Button ef;
  private ColorDrawable i = new ColorDrawable();
  private int imgWidth;
  BaseChatPie mBaseChatPie;
  GridLayoutManager mLayoutManager;
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, ahyb paramahyb, Button paramButton)
  {
    super(paramContext);
    this.mBaseChatPie = paramBaseChatPie;
    this.ef = paramButton;
    setClipToPadding(false);
    this.adw = (aqnm.getScreenWidth() / 3);
    this.imgWidth = (this.adw - aqnm.dpToPx(2.0F));
    this.jdField_a_of_type_Ahyb = paramahyb;
    init();
  }
  
  private View aS()
  {
    aheq localaheq = aheq.a(this.mBaseChatPie.getApp());
    NAME = localaheq.wg();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localaheq.and())
    {
      this.KN = new TextView(getContext());
      this.KN.setId(2131382439);
      this.KN.setText(localaheq.wh());
      this.KN.setTextColor(-8947849);
      this.KN.setTextSize(2, 14.0F);
      this.KN.setPadding(0, wja.dp2px(8.0F, getResources()), 0, wja.dp2px(6.0F, getResources()));
      this.KN.setGravity(1);
      localLinearLayout.addView(this.KN);
    }
    localLinearLayout.addView(c(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  private View c(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131382437);
    localTextView.setText(paramString);
    localTextView.setTextColor(Color.parseColor("#878B99"));
    localTextView.setTextSize(2, 14.0F);
    localTextView.setGravity(17);
    localTextView.setVisibility(8);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    return localTextView;
  }
  
  public void Af(boolean paramBoolean)
  {
    ykm localykm = ykm.a(this.mBaseChatPie.app);
    if (paramBoolean)
    {
      localykm.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localykm.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c = this.b;
      localykm.a(this.mBaseChatPie.app, this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), this.mBaseChatPie.jdField_a_of_type_Wki.getList(), this.mBaseChatPie.getCurType(), false);
      return;
    }
    localykm.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localykm.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c = null;
  }
  
  public Button b()
  {
    return this.ef;
  }
  
  public void ciZ()
  {
    ykv localykv = this.c;
    if ((localykv == null) || (localykv.url == null) || (localykv.a == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localykv), 8, null, false);
    ykm.a(this.mBaseChatPie.app).b(localykv);
    anot.a(this.mBaseChatPie.app, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.mBaseChatPie.aey();
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public void init()
  {
    View localView = aS();
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView = new RichTextPanelRecyclerView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setOverScrollMode(0);
    this.mLayoutManager = new GridLayoutManager(getContext(), 3);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setLayoutManager(this.mLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131382439);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.b = new c();
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.b);
    if (localView != null) {
      this.b.setHeaderView(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.addOnScrollListener(new b());
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Ahyb);
  }
  
  public int wQ()
  {
    int j = 0;
    if (this.mBaseChatPie != null) {
      j = aheq.a(this.mBaseChatPie.getApp()).wQ();
    }
    return j;
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
  }
  
  public class b
    extends RecyclerView.OnScrollListener
  {
    public boolean bna;
    
    public b() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
        if ((localGridLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == localGridLayoutManager.getItemCount()) && (this.bna)) {
          ((ZhituPanelView.c)paramRecyclerView.getAdapter()).cja();
        }
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (paramInt2 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bna = bool;
        return;
      }
    }
  }
  
  public class c
    extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  {
    public String aYu;
    public int bZI;
    public boolean bnb = true;
    public List<ykv> jl = new ArrayList();
    public View mHeaderView;
    public List<ykv> sL = new ArrayList();
    
    public c()
    {
      int i = 0;
      while (i < ZhituPanelView.bZH)
      {
        this.sL.add(new ykv());
        i += 1;
      }
      this.jl.addAll(this.sL);
    }
    
    public void bt(int paramInt, String paramString)
    {
      int i = 0;
      if (QLog.isColorLevel()) {
        QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = " + paramInt + ",mReqKey = " + paramString + ",this.mReqKey =" + this.aYu);
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramInt > 0)
      {
        if (!paramString.equals(this.aYu))
        {
          this.jl.clear();
          anot.a(ZhituPanelView.this.mBaseChatPie.app, "dc00898", "", "", "0X8008C71", "0X8008C71", ykm.fq(ykm.a(ZhituPanelView.this.mBaseChatPie.app).getCurType()), 0, "", "", "", "");
        }
        this.aYu = paramString;
        while (i < paramInt)
        {
          this.jl.add(new ykv());
          i += 1;
        }
        this.bZI = -1;
        this.bnb = true;
        notifyDataSetChanged();
        return;
      }
      this.bnb = false;
      notifyDataSetChanged();
    }
    
    public void cja()
    {
      if (QLog.isColorLevel()) {
        QLog.d(ZhituPanelView.TAG, 2, "loadMorePic");
      }
      int i = this.jl.size();
      if ((i == 0) || (TextUtils.isEmpty(((ykv)this.jl.get(i - 1)).aYv))) {}
      while (i <= this.bZI) {
        return;
      }
      this.bZI = i;
      ykm.a(ZhituPanelView.this.mBaseChatPie.app).bs(this.jl.size(), this.aYu);
    }
    
    public int getItemCount()
    {
      if (this.jl == null) {}
      for (int j = 0;; j = this.jl.size())
      {
        int i = j;
        if (this.bnb) {
          i = j + 1;
        }
        j = i;
        if (this.mHeaderView != null) {
          j = i + 1;
        }
        return j;
      }
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((this.mHeaderView != null) && (paramInt == 0)) {
        return 3;
      }
      if ((this.bnb) && (paramInt + 1 == getItemCount())) {
        return 2;
      }
      return 1;
    }
    
    public void j(ykv paramykv)
    {
      int i;
      ykv localykv;
      if (paramykv != null)
      {
        i = paramykv.bZJ;
        if ((i >= 0) && (i < this.jl.size()))
        {
          localykv = (ykv)this.jl.get(i);
          localykv.k(paramykv);
          if (ZhituPanelView.this.wQ() != 1) {
            break label98;
          }
        }
      }
      for (;;)
      {
        notifyDataSetChanged();
        if ((ZhituPanelView.this.wQ() != 1) && (i == 0))
        {
          ZhituPanelView.a(ZhituPanelView.this).setEnabled(true);
          ZhituPanelView.a(ZhituPanelView.this).setVisibility(0);
        }
        return;
        label98:
        if (localykv.isChecked)
        {
          if ((ZhituPanelView.a(ZhituPanelView.this) != null) && (ZhituPanelView.a(ZhituPanelView.this) != localykv)) {
            ZhituPanelView.a(ZhituPanelView.this).isChecked = false;
          }
          ZhituPanelView.a(ZhituPanelView.this, localykv);
        }
      }
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
    {
      super.onAttachedToRecyclerView(paramRecyclerView);
      ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new ykt(this));
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (getItemViewType(paramInt) == 3) {}
      while (!(paramViewHolder instanceof ZhituPanelView.d))
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
      }
      int i;
      label39:
      ZhituPanelView.d locald;
      ykv localykv;
      Object localObject3;
      Object localObject1;
      if (this.mHeaderView == null)
      {
        i = paramInt;
        locald = (ZhituPanelView.d)paramViewHolder;
        localykv = (ykv)this.jl.get(i);
        locald.ez = new WeakReference(localykv);
        locald.progressBar.setVisibility(0);
        locald.k.setChecked(localykv.isChecked);
        if (!localykv.bnc) {
          break label707;
        }
        localObject3 = ykm.a(ZhituPanelView.this.mBaseChatPie.app).b(localykv);
        localObject1 = ykm.a((String)localObject3);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          ykm.a(ZhituPanelView.this.mBaseChatPie.app).e(localykv);
          localObject2 = localObject1;
          if (QLog.isColorLevel()) {
            QLog.d(ZhituPanelView.TAG, 2, "get gif image from cache fail, " + (String)localObject3);
          }
        }
      }
      label701:
      label704:
      label707:
      for (Object localObject2 = localObject1;; localObject2 = null)
      {
        locald.hA.getLayoutParams().height = ZhituPanelView.a(ZhituPanelView.this);
        if (ZhituPanelView.this.wQ() == 1) {
          if ((localykv.drawable != null) || (localObject2 != null))
          {
            QLog.d(ZhituPanelView.TAG, 2, "ZhituTest has a drawable data is " + localykv.toString());
            localObject1 = localykv.drawable;
            locald.n.setTag(localykv.url + localykv.pic_md5);
            if (localObject2 == null) {
              break label704;
            }
            localObject1 = new GifDrawable(localObject2);
          }
        }
        for (;;)
        {
          locald.n.setImageDrawable((Drawable)localObject1);
          locald.n.setBackgroundDrawable(null);
          locald.progressBar.setVisibility(8);
          for (;;)
          {
            locald.hA.getLayoutParams().width = ZhituPanelView.a(ZhituPanelView.this);
            if ((localykv.a == null) || (localykv.a.isReported)) {
              break;
            }
            ykm.a(ZhituPanelView.this.mBaseChatPie.app).c(localykv);
            localykv.a.isReported = true;
            break;
            i = paramInt - 1;
            break label39;
            QLog.d(ZhituPanelView.TAG, 2, "ZhituTest has no drawable data is " + localykv.toString());
            locald.n.setImageDrawable(ZhituPanelView.a(ZhituPanelView.this));
            locald.progressBar.setVisibility(0);
            locald.k.setVisibility(8);
          }
          if ((localykv.drawable != null) || (localObject2 != null))
          {
            locald.hA.setMinimumWidth(0);
            localObject3 = localykv.drawable;
            locald.n.setTag(localykv.url + localykv.pic_md5);
            localObject1 = localObject3;
            if (!localykv.isChecked)
            {
              localObject1 = localObject3;
              if (!localykv.bne)
              {
                localObject1 = localObject3;
                if (localykv.ea != null) {
                  localObject1 = localykv.ea;
                }
              }
            }
            if (localObject2 == null) {
              break label701;
            }
            localObject1 = new GifDrawable(localObject2);
          }
          for (;;)
          {
            locald.n.setImageDrawable((Drawable)localObject1);
            locald.n.setBackgroundDrawable(null);
            locald.progressBar.setVisibility(8);
            locald.k.setVisibility(0);
            break;
            locald.n.setImageDrawable(ZhituPanelView.a(ZhituPanelView.this));
            locald.progressBar.setVisibility(0);
            locald.k.setVisibility(8);
            break;
          }
        }
      }
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        paramViewGroup = LayoutInflater.from(ZhituPanelView.this.getContext()).inflate(2131563400, paramViewGroup, false);
        return new ZhituPanelView.d(ZhituPanelView.this, paramViewGroup);
      case 2: 
        paramViewGroup = LayoutInflater.from(ZhituPanelView.this.getContext()).inflate(2131563399, paramViewGroup, false);
        return new ZhituPanelView.a(ZhituPanelView.this, paramViewGroup);
      }
      return new ZhituPanelView.a(ZhituPanelView.this, this.mHeaderView);
    }
    
    public void resetData()
    {
      if (QLog.isColorLevel()) {
        QLog.d(ZhituPanelView.TAG, 2, "[ZhituPicAdapter]-resetData");
      }
      this.jl.clear();
      if (this.mHeaderView != null)
      {
        Object localObject = (TextView)this.mHeaderView.findViewById(2131382437);
        if (localObject != null)
        {
          ((TextView)localObject).setVisibility(8);
          localObject = this.mHeaderView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = -2;
          this.mHeaderView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      this.jl.addAll(this.sL);
      this.aYu = "";
      this.bZI = -1;
      notifyDataSetChanged();
    }
    
    public void setHeaderView(View paramView)
    {
      this.mHeaderView = paramView;
      notifyItemInserted(0);
    }
    
    public void yN(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ZhituPanelView.TAG, 2, "[ZhituPicAdapter]-setEmptyAndShowMsg, errorMsg is " + paramString);
      }
      this.jl.clear();
      if (this.mHeaderView != null)
      {
        TextView localTextView = (TextView)this.mHeaderView.findViewById(2131382437);
        if (localTextView != null)
        {
          this.bnb = false;
          localTextView.setVisibility(0);
          localTextView.setText(paramString);
          paramString = this.mHeaderView.getLayoutParams();
          paramString.height = -1;
          this.mHeaderView.setLayoutParams(paramString);
        }
      }
      notifyDataSetChanged();
    }
  }
  
  public class d
    extends RecyclerView.ViewHolder
    implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
  {
    public WeakReference<ykv> ez;
    public RelativeLayout hA;
    public RadioButton k;
    public BubbleImageView n;
    public ProgressBar progressBar;
    
    public d(View paramView)
    {
      super();
      this.hA = ((RelativeLayout)paramView);
      this.n = ((BubbleImageView)paramView.findViewById(2131377267));
      this.n.TE(false);
      this.n.setRadius(5.0F);
      this.n.bgJ = false;
      this.progressBar = ((ProgressBar)paramView.findViewById(2131377268));
      paramView.setOnClickListener(this);
      this.k = ((RadioButton)paramView.findViewById(2131377269));
      this.k.setOnCheckedChangeListener(this);
      if (ZhituPanelView.this.wQ() == 1)
      {
        this.k.setVisibility(8);
        return;
      }
      this.k.setVisibility(0);
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (ZhituPanelView.this.wQ() == 1) {}
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        if (paramBoolean) {
          onClick(paramCompoundButton);
        }
      }
    }
    
    public void onClick(View paramView)
    {
      Object localObject = (ykv)this.ez.get();
      if ((localObject == null) || (((ykv)localObject).url == null) || (((ykv)localObject).a == null) || (ZhituPanelView.a(ZhituPanelView.this).jl == null)) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (ZhituPanelView.this.wQ() == 1)
        {
          ZhituPanelView.a(ZhituPanelView.this, (ykv)localObject);
          localObject = ykm.a(ZhituPanelView.this.mBaseChatPie.app);
          if ((localObject != null) && (((ykm)localObject).a != null))
          {
            ((ykm)localObject).a.ciZ();
            anot.a(ZhituPanelView.this.mBaseChatPie.app, "dc00898", "", "", "0X800ACA1", "0X800ACA1", ZhituPanelView.this.mBaseChatPie.sessionInfo.cZ, 0, "", "", "", "");
          }
        }
        else if (ZhituPanelView.a(ZhituPanelView.this) != localObject)
        {
          Iterator localIterator = ZhituPanelView.a(ZhituPanelView.this).jl.iterator();
          while (localIterator.hasNext()) {
            ((ykv)localIterator.next()).isChecked = false;
          }
          ((ykv)localObject).isChecked = true;
          ZhituPanelView.a(ZhituPanelView.this).setVisibility(0);
          ZhituPanelView.a(ZhituPanelView.this).setEnabled(true);
          if (!((ykv)localObject).isGif)
          {
            ZhituPanelView.a(ZhituPanelView.this, (ykv)localObject);
            ZhituPanelView.a(ZhituPanelView.this).notifyDataSetChanged();
          }
          else
          {
            ykm.a(ZhituPanelView.this.mBaseChatPie.app).f((ykv)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */