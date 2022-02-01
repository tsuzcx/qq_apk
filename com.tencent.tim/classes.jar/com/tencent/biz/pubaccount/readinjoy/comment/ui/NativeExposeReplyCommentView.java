package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import ksm;
import kta;
import ktm;

public class NativeExposeReplyCommentView
  extends FrameLayout
  implements View.OnClickListener, IView
{
  private static String TAG = "NativeExposeReplyCommentView";
  private ksm b;
  private LinearLayout dB;
  private LinearLayout dC;
  private LinearLayout dD;
  private ktm e;
  private View kc;
  private View kd;
  private Context mContext;
  private TextView oT;
  private TextView oU;
  private TextView oV;
  private TextView oW;
  private TextView oX;
  
  public NativeExposeReplyCommentView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initView();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initView();
  }
  
  public NativeExposeReplyCommentView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
  }
  
  private SubCommentData a(ktm paramktm, int paramInt)
  {
    if ((paramktm != null) && ((paramktm.a instanceof CommentData)))
    {
      paramktm = (CommentData)paramktm.a;
      if ((paramktm.subCommentList != null) && (paramktm.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramktm.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  private void aHs()
  {
    if (!(this.e.a instanceof CommentData)) {}
    while (((CommentData)this.e.a).subCommentNum < 3) {
      return;
    }
    this.dB.setOnTouchListener(new a(this.mContext, this.dB));
    this.oU.setOnTouchListener(new a(this.mContext, this.dB));
    this.dC.setOnTouchListener(new a(this.mContext, this.dC));
    this.oW.setOnTouchListener(new a(this.mContext, this.dC));
  }
  
  private void initView()
  {
    inflate(this.mContext, 2131560362, this);
    this.dB = ((LinearLayout)findViewById(2131367117));
    this.oT = ((TextView)findViewById(2131367128));
    this.oU = ((TextView)findViewById(2131367129));
    this.dC = ((LinearLayout)findViewById(2131377887));
    this.oV = ((TextView)findViewById(2131377897));
    this.oW = ((TextView)findViewById(2131377898));
    this.dD = ((LinearLayout)findViewById(2131377151));
    this.oX = ((TextView)findViewById(2131377150));
    this.kc = findViewById(2131367130);
    this.kd = findViewById(2131377899);
  }
  
  private void pT(int paramInt)
  {
    int i = 4;
    int j = 0;
    if (paramInt > 1) {
      if (paramInt > 2)
      {
        i = 0;
        paramInt = j;
      }
    }
    for (;;)
    {
      this.kc.setVisibility(i);
      this.kd.setVisibility(paramInt);
      return;
      i = 0;
      paramInt = 4;
      continue;
      paramInt = 4;
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    if ((this.b == null) || (this.e == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.e.a instanceof CommentData)) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131367117: 
        case 2131367129: 
          this.dB.setBackgroundResource(2130843779);
          this.b.a(this.e, a(this.e, 0));
          break;
        case 2131377887: 
        case 2131377898: 
          this.dC.setBackgroundResource(2130843779);
          this.b.a(this.e, a(this.e, 1));
          break;
        case 2131377151: 
          this.b.a(this.e, null);
        }
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void r(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null)) {}
    while (!(paramktm.a instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)paramktm.a;
    if (!paramktm.AA())
    {
      setVisibility(8);
      return;
    }
    this.e = paramktm;
    setVisibility(0);
    List localList = paramktm.gw;
    this.dB.setVisibility(8);
    this.dC.setVisibility(8);
    this.dC.setOnClickListener(null);
    this.dB.setOnClickListener(null);
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      if (i == 0)
      {
        this.oT.setText((CharSequence)paramktm.gw.get(i));
        this.oT.setMovementMethod(kta.a());
        this.oU.setText((CharSequence)paramktm.gx.get(i));
        this.oU.setMovementMethod(kta.a());
        this.dB.setVisibility(0);
        this.oU.setOnClickListener(this);
        this.dB.setOnClickListener(this);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 1)
        {
          this.oV.setText((CharSequence)paramktm.gw.get(i));
          this.oV.setMovementMethod(kta.a());
          this.oW.setText((CharSequence)paramktm.gx.get(i));
          this.oW.setMovementMethod(kta.a());
          this.dC.setVisibility(0);
          this.oW.setOnClickListener(this);
          this.dC.setOnClickListener(this);
        }
      }
    }
    if (localCommentData.subCommentNum > 2)
    {
      this.dD.setVisibility(0);
      this.dD.setOnClickListener(this);
    }
    for (;;)
    {
      aHs();
      pT(localCommentData.subCommentNum);
      return;
      this.dD.setVisibility(8);
      this.dD.setOnClickListener(null);
    }
  }
  
  public void setAdapter(ksm paramksm)
  {
    this.b = paramksm;
  }
  
  public static class a
    implements View.OnTouchListener
  {
    private View cH;
    private Context context;
    
    public a(Context paramContext, View paramView)
    {
      this.context = paramContext;
      this.cH = paramView;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((this.context == null) || (this.cH == null)) {
        return false;
      }
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        this.cH.setBackgroundDrawable(this.context.getResources().getDrawable(2130850221));
        return false;
      }
      this.cH.setBackgroundDrawable(this.context.getResources().getDrawable(2130850244));
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeExposeReplyCommentView
 * JD-Core Version:    0.7.0.1
 */