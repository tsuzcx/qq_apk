package com.tencent.mobileqq.hiboom;

import acfp;
import acle;
import aclh;
import ahxg;
import ahxk;
import ahxl;
import ahxm;
import ahyb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.taf.jce.JceStruct;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import wja;

public class FontBubblePanelView<T extends JceStruct>
  extends RichTextPanelView
  implements View.OnClickListener
{
  private static boolean[] s = new boolean[5];
  private ahxg jdField_a_of_type_Ahxg;
  private ahyb jdField_a_of_type_Ahyb;
  private a<T> jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$a;
  private FontBubblePanelView<T>.b jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$b;
  private RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private long abe;
  private aclh e = new ahxm(this);
  private Drawable eS;
  private BaseChatPie mBaseChatPie;
  private List<FontBubble> mDatas = new ArrayList();
  private int mType;
  
  public FontBubblePanelView(Context paramContext, BaseChatPie paramBaseChatPie, ahyb paramahyb, a<T> parama)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$a = parama;
    this.mType = parama.getType();
    this.mBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Ahxg = ahxg.a(paramBaseChatPie.app);
    this.eS = paramContext.getResources().getDrawable(2130848024);
    this.jdField_a_of_type_Ahyb = paramahyb;
    init();
  }
  
  public static String bW(int paramInt)
  {
    if (paramInt == 3) {
      return "1";
    }
    return "2";
  }
  
  private void d(ImageView paramImageView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 2130848030;
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      Resources localResources = getResources();
      Drawable localDrawable = localResources.getDrawable(paramInt);
      paramInt = localDrawable.getIntrinsicWidth();
      int i = localDrawable.getIntrinsicHeight();
      paramImageView.setImageDrawable(localDrawable);
      paramImageView = paramImageView.getLayoutParams();
      paramImageView.height = wja.dp2px(10.0F, localResources);
      paramImageView.width = (paramImageView.height * paramInt / i);
      return;
      paramInt = 2130847804;
      continue;
      paramInt = 2130851889;
      continue;
      paramInt = 2130851502;
      continue;
      paramInt = 2130848325;
      continue;
      paramInt = 2130848324;
    }
  }
  
  public static void dqF()
  {
    int i = 0;
    while (i < s.length)
    {
      s[i] = false;
      i += 1;
    }
  }
  
  private void e(T paramT)
  {
    new QueryTask(new ahxk(this), new ahxl(this)).bq(paramT);
  }
  
  private void init()
  {
    Object localObject1 = new FontBubble();
    ((FontBubble)localObject1).viewType = 0;
    this.mDatas.add(localObject1);
    Object localObject2 = getContext();
    localObject1 = ((Context)localObject2).getResources();
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView = new RichTextPanelRecyclerView((Context)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setOverScrollMode(2);
    localObject2 = new GridLayoutManager((Context)localObject2, 4);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$b = new b();
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$b);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Ahyb);
    setClipToPadding(false);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = wja.dp2px(8.0F, (Resources)localObject1);
    int j = wja.dp2px(8.0F, (Resources)localObject1);
    int k = wja.dp2px(3.0F, (Resources)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPadding(j, i, k, 0);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, (ViewGroup.LayoutParams)localObject2);
  }
  
  public void Af(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBaseChatPie.app.addObserver(this.e);
      if (s[this.mType] == 0)
      {
        s[this.mType] = true;
        acle localacle = (acle)this.mBaseChatPie.app.getBusinessHandler(13);
        this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$a.a(localacle);
      }
      return;
    }
    this.mBaseChatPie.app.removeObserver(this.e);
  }
  
  public void a(FontBubblePanelView<T>.c paramFontBubblePanelView, FontBubble paramFontBubble)
  {
    if (paramFontBubble.viewType == 1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramFontBubble.picUrl)) {
          break label207;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$a.a(paramFontBubble);
        localObject1 = new URL("protocol_vas_extension_image", "FONT_BUBBLE", (String)localObject1);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.eS;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          QLog.e("FontBubblePanelView", 1, "updateView: ", localException);
          localObject2 = null;
        }
      }
      paramFontBubblePanelView.q.setScaleType(ImageView.ScaleType.FIT_XY);
      paramFontBubblePanelView.q.setImageDrawable((Drawable)localObject1);
      d(paramFontBubblePanelView.AE, paramFontBubble.feeType);
      i = wja.dp2px(0.7F, getResources());
      paramFontBubblePanelView.mName.setPadding(0, i, 0, 0);
      paramFontBubblePanelView.mName.setText(paramFontBubble.name);
    }
    for (;;)
    {
      paramFontBubblePanelView.q.setImageScale(0.92F, 0.0F);
      paramFontBubblePanelView.q.setTag(paramFontBubble);
      paramFontBubblePanelView.q.setBackgroundDrawable(this.eS);
      paramFontBubblePanelView.q.setOnClickListener(this);
      paramFontBubblePanelView.q.setRoundRect(wja.dp2px(5.0F, getResources()));
      return;
      label207:
      localObject1 = paramFontBubble.picUrl;
      break;
      Object localObject2;
      paramFontBubblePanelView.q.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramFontBubblePanelView.q.setImageResource(2130848031);
      paramFontBubblePanelView.AE.setVisibility(8);
      paramFontBubblePanelView.mName.setVisibility(8);
    }
  }
  
  public String getName()
  {
    if (this.mType == 3) {
      return acfp.m(2131706390);
    }
    return acfp.m(2131706389);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = (FontBubble)paramView.getTag();
    if (((FontBubble)localObject).viewType == 1)
    {
      if (this.mBaseChatPie.a.getText().length() > 0)
      {
        l = SystemClock.uptimeMillis();
        if (this.abe + 1000L < l) {
          this.jdField_a_of_type_Ahxg.a((FontBubble)localObject);
        }
        this.abe = l;
      }
      if (this.mType == 3) {}
      for (int i = ((FontBubble)localObject).fontId;; i = ((FontBubble)localObject).bubbleId)
      {
        VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "aio_iconA", "Clickitem", "", 1, 0, 0, "", Integer.toString(i), bW(this.mType));
        break;
      }
    }
    localObject = getContext();
    String str = this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubblePanelView$a.aD((Context)localObject);
    if (this.mType == 3) {}
    for (long l = 4096L;; l = 64L)
    {
      VasWebviewUtil.openQQBrowserWithoutAD((Context)localObject, str, l, null, false, -1);
      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "aio_iconA", "ClickPlus", "", 1, 0, 0, "", "", bW(this.mType));
      break;
    }
  }
  
  public void reportShow()
  {
    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "aio_iconA", "PanelPageView", "", 1, 0, 0, "", "", bW(this.mType));
  }
  
  public static abstract interface a<T>
  {
    public abstract String a(FontBubble paramFontBubble);
    
    public abstract List<FontBubble> a(QQAppInterface paramQQAppInterface, T paramT);
    
    public abstract void a(acle paramacle);
    
    public abstract String aD(Context paramContext);
    
    public abstract int getType();
  }
  
  public class b
    extends RecyclerView.Adapter<FontBubblePanelView<T>.c>
  {
    public b() {}
    
    public FontBubblePanelView<T>.c a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(FontBubblePanelView.this.getContext()).inflate(2131563324, paramViewGroup, false);
      return new FontBubblePanelView.c(FontBubblePanelView.this, paramViewGroup);
    }
    
    public void a(FontBubblePanelView<T>.c paramFontBubblePanelView, int paramInt)
    {
      if (paramInt < FontBubblePanelView.a(FontBubblePanelView.this).size()) {
        FontBubblePanelView.this.a(paramFontBubblePanelView, (FontBubble)FontBubblePanelView.a(FontBubblePanelView.this).get(paramInt));
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramFontBubblePanelView, paramInt, getItemId(paramInt));
    }
    
    public int getItemCount()
    {
      return FontBubblePanelView.a(FontBubblePanelView.this).size();
    }
    
    public int getItemViewType(int paramInt)
    {
      return ((FontBubble)FontBubblePanelView.a(FontBubblePanelView.this).get(paramInt)).viewType;
    }
  }
  
  public class c
    extends RecyclerView.ViewHolder
  {
    public ImageView AE;
    public TextView mName;
    public SquareImageView q;
    
    public c(View paramView)
    {
      super();
      this.q = ((SquareImageView)paramView.findViewById(2131367450));
      this.mName = ((TextView)paramView.findViewById(2131372190));
      this.AE = ((ImageView)paramView.findViewById(2131381174));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView
 * JD-Core Version:    0.7.0.1
 */