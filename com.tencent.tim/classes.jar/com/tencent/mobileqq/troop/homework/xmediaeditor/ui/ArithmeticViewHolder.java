package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apkl;
import apkl.a;
import apkx;
import aplc.a;
import aqfr;
import awjs.b;
import awjs.c;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithmeticCaptureTransferFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qem;
import raj.a;
import rpq;
import wja;

public class ArithmeticViewHolder
  extends aplc.a<apkl>
  implements View.OnClickListener
{
  private View IC;
  private apkl a;
  private TextView aaQ;
  private LinearLayout dE;
  private int dUU;
  private XMediaEditor e;
  private LinearLayout kV;
  private LinearLayout kW;
  private Drawable mDefaultDrawable = new ColorDrawable(-2631721);
  private List<ArithmeticImageView> mImageViewList = new ArrayList(6);
  private String mTroopUin;
  private HashMap<apkl.a, ArithmeticImageView> ok = new HashMap();
  
  public ArithmeticViewHolder(XMediaEditor paramXMediaEditor, View paramView)
  {
    super(paramView);
    this.IC = paramView;
    this.e = paramXMediaEditor;
    this.mTroopUin = this.e.oG("troopuin");
    this.kV = ((LinearLayout)paramView.findViewById(2131368074));
    this.dE = ((LinearLayout)paramView.findViewById(2131365382));
    this.kW = ((LinearLayout)paramView.findViewById(2131369041));
    this.aaQ = ((TextView)paramView.findViewById(2131365401));
    int i = 0;
    while (i < 6)
    {
      paramXMediaEditor = new ArithmeticImageView(this.dE.getContext());
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.setMargins(0, 10, 0, 0);
      this.kW.addView(paramXMediaEditor, paramView);
      this.mImageViewList.add(paramXMediaEditor);
      i += 1;
    }
    this.kV.setOnClickListener(this);
    this.aaQ.setOnClickListener(this);
  }
  
  private void a(ArithmeticImageView paramArithmeticImageView, apkl.a parama)
  {
    switch (parama.mUploadStatus)
    {
    default: 
      return;
    case 1: 
      paramArithmeticImageView.EA.setVisibility(8);
      paramArithmeticImageView.c.setVisibility(0);
      paramArithmeticImageView.c.setDrawStatus(1);
      paramArithmeticImageView.c.setAnimProgress(parama.dUQ, parama.dQ);
      return;
    case 2: 
      paramArithmeticImageView.c.setVisibility(8);
      paramArithmeticImageView.EA.setVisibility(0);
      return;
    }
    paramArithmeticImageView.c.setVisibility(8);
    paramArithmeticImageView.EA.setVisibility(8);
  }
  
  private void buP()
  {
    if (this.a != null) {
      this.e.getAdapter().notifyItemChanged(this.a.mPosition);
    }
  }
  
  public void RQ(boolean paramBoolean)
  {
    Iterator localIterator = this.a.gz().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (apkl.a)localIterator.next();
      if ((((apkl.a)localObject).mUploadStatus == -1) || (((apkl.a)localObject).mUploadStatus == 0) || ((paramBoolean) && (((apkl.a)localObject).mUploadStatus == 2)))
      {
        localObject = (ArithmeticImageView)this.ok.get(localObject);
        if (localObject != null) {
          ((ArithmeticImageView)localObject).upload();
        }
      }
    }
  }
  
  public void a(apkl paramapkl, int paramInt)
  {
    if (paramInt != 2)
    {
      this.IC.setVisibility(8);
      return;
    }
    this.IC.setVisibility(0);
    this.a = paramapkl;
    int i = paramapkl.Lu();
    HashMap localHashMap = new HashMap();
    if (i == 0)
    {
      this.dE.setVisibility(8);
      this.kV.setVisibility(0);
      return;
    }
    this.dE.setVisibility(0);
    this.kV.setVisibility(8);
    i = 0;
    for (;;)
    {
      apkl.a locala;
      ArithmeticImageView localArithmeticImageView;
      if (i < 6)
      {
        locala = paramapkl.a(i);
        localArithmeticImageView = (ArithmeticImageView)this.mImageViewList.get(i);
        if (locala != null) {}
      }
      else
      {
        paramInt = i;
        while (paramInt < 6)
        {
          ((ArithmeticImageView)this.mImageViewList.get(paramInt)).hide();
          paramInt += 1;
        }
      }
      localArithmeticImageView.a(locala, paramInt);
      localHashMap.put(locala, localArithmeticImageView);
      i += 1;
    }
    this.ok = localHashMap;
    if (i < 6) {
      this.aaQ.setVisibility(0);
    }
    for (;;)
    {
      this.a.eax();
      RQ(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArithmeticViewHolder", 2, "bind view , picture size = " + i);
      return;
      this.aaQ.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqfr.b("Grp_edu", "Grp_oral", "Oral_Clk", 0, 0, new String[] { this.mTroopUin, "" });
      ArithmeticCaptureTransferFragment.c(this.kV.getContext(), this.a.k(1).toString(), this.a.mPosition, this.mTroopUin);
      continue;
      aqfr.b("Grp_edu", "Grp_oral", "Finish_Oral_Again", 0, 0, new String[] { this.mTroopUin, "" });
      ArithmeticCaptureTransferFragment.c(paramView.getContext(), this.a.k(1).toString(), this.a.mPosition, this.mTroopUin);
    }
  }
  
  public class ArithmeticImageView
    extends RelativeLayout
    implements View.OnClickListener, URLDrawable.URLDrawableListener
  {
    public ImageView EA;
    private ImageView Ez;
    private URLDrawable M;
    private apkl.a a;
    public MessageProgressView c;
    private RoundCornerImageView i;
    
    public ArithmeticImageView(Context paramContext)
    {
      super();
      init();
    }
    
    public ArithmeticImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init();
    }
    
    private void init()
    {
      inflate(getContext(), 2131561741, this);
      this.i = ((RoundCornerImageView)findViewById(2131368962));
      this.Ez = ((ImageView)findViewById(2131365708));
      this.c = ((MessageProgressView)findViewById(2131381337));
      this.EA = ((ImageView)findViewById(2131377226));
      this.i.setCorner(rpq.dip2px(getContext(), 4.0F));
      this.Ez.setOnClickListener(this);
      this.EA.setOnClickListener(this);
      this.c.setRadius(0.0F, true);
      this.c.setShowCorner(false);
      this.c.setDisplayInTextView(wja.dp2px(17.0F, ArithmeticViewHolder.this.itemView.getResources()), -1);
      this.c.setAnimRunnableListener(new apkx(this));
      hide();
    }
    
    public void a(apkl.a parama, int paramInt)
    {
      this.a = parama;
      if (TextUtils.isEmpty(parama.dQ)) {}
      for (String str = parama.cpN;; str = raj.a.gb(parama.dQ))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ArithmeticViewHolder.a(ArithmeticViewHolder.this);
        localURLDrawableOptions.mFailedDrawable = ArithmeticViewHolder.a(ArithmeticViewHolder.this);
        localURLDrawableOptions.mUseAutoScaleParams = true;
        this.M = URLDrawable.getDrawable(str, localURLDrawableOptions);
        this.M.setURLDrawableListener(this);
        if (this.M.getStatus() == 1) {
          onLoadSuccessed(this.M);
        }
        this.i.setImageDrawable(this.M);
        ArithmeticViewHolder.a(ArithmeticViewHolder.this, this, parama);
        setVisibility(0);
        return;
      }
    }
    
    public void hide()
    {
      setVisibility(8);
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ArithmeticViewHolder.a(ArithmeticViewHolder.this).b(this.a);
        ArithmeticViewHolder.a(ArithmeticViewHolder.this);
        if (QLog.isColorLevel())
        {
          QLog.d("ArithmeticViewHolder", 2, "delete picture");
          continue;
          upload();
        }
      }
    }
    
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      if (ArithmeticViewHolder.a(ArithmeticViewHolder.this) == 0) {
        ArithmeticViewHolder.a(ArithmeticViewHolder.this, (int)(ArithmeticViewHolder.a(ArithmeticViewHolder.this).getMeasuredWidth() - 2.0F * TypedValue.applyDimension(1, 18.0F, ArithmeticViewHolder.a(ArithmeticViewHolder.this).getContext().getResources().getDisplayMetrics())));
      }
      int j = paramURLDrawable.getIntrinsicWidth();
      j = (int)(paramURLDrawable.getIntrinsicHeight() / j * ArithmeticViewHolder.a(ArithmeticViewHolder.this));
      paramURLDrawable = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
      paramURLDrawable.width = ArithmeticViewHolder.a(ArithmeticViewHolder.this);
      paramURLDrawable.height = j;
      this.i.setLayoutParams(paramURLDrawable);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.width = ArithmeticViewHolder.a(ArithmeticViewHolder.this);
      localLayoutParams.height = j;
      this.c.setLayoutParams(paramURLDrawable);
    }
    
    public void upload()
    {
      if ((this.a.mUploadStatus == 1) || (this.a.mUploadStatus == 3)) {}
      do
      {
        return;
        this.a.mUploadStatus = 1;
        this.a.dUQ = 0;
        ArithmeticViewHolder.a(ArithmeticViewHolder.this, this, this.a);
        awjs.c localc = new awjs.c(qem.getQQAppInterface(), this.a.dQ, ArithmeticViewHolder.a(ArithmeticViewHolder.this));
        localc.a(new ArithmeticViewHolder.a(ArithmeticViewHolder.this, this.a));
        ThreadManager.post(new ArithmeticViewHolder.ArithmeticImageView.2(this, localc), 8, null, true);
      } while (!QLog.isColorLevel());
      QLog.d("ArithmeticViewHolder", 2, "upload picture , local path = " + this.a.dQ);
    }
  }
  
  class a
    implements awjs.b
  {
    private apkl.a a;
    
    public a(apkl.a parama)
    {
      this.a = parama;
    }
    
    private void d(apkl.a parama)
    {
      ThreadManager.getUIHandler().post(new ArithmeticViewHolder.ImageUploadHandler.1(this, parama));
    }
    
    public void onComplete(String paramString)
    {
      this.a.mUploadStatus = 3;
      this.a.cpN = paramString;
      this.a.dUQ = 100;
      ArithmeticViewHolder.a(ArithmeticViewHolder.this).c(this.a);
      d(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ArithmeticViewHolder", 2, "update success , url = " + paramString);
      }
    }
    
    public void onError(int paramInt)
    {
      this.a.mUploadStatus = 2;
      d(this.a);
      QLog.w("ArithmeticViewHolder", 2, "upload error , code = " + paramInt + " ;local path = " + this.a.dQ);
    }
    
    public void onProgress(int paramInt)
    {
      this.a.mUploadStatus = 1;
      this.a.dUQ = paramInt;
      ArithmeticViewHolder.a(ArithmeticViewHolder.this).c(this.a);
      d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder
 * JD-Core Version:    0.7.0.1
 */