package com.tencent.biz.pubaccount.readinjoy.view;

import aczy;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class AlbumPermissionView
  extends LinearLayout
  implements View.OnClickListener
{
  private QQPermissionCallback a;
  private Context context;
  private View mh;
  private TextView tipsView;
  
  public AlbumPermissionView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AlbumPermissionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AlbumPermissionView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    LayoutInflater.from(paramContext).inflate(2131560176, this, true);
    setOrientation(1);
    setGravity(17);
    this.mh = findViewById(2131380680);
    this.tipsView = ((TextView)findViewById(2131380973));
    this.mh.setOnClickListener(this);
  }
  
  public boolean Fk()
  {
    if (Build.VERSION.SDK_INT > 23) {
      return aczy.bd(BaseApplication.getContext());
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380680) {
      aczy.a((AppActivity)this.context, 10000, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCallback(QQPermissionCallback paramQQPermissionCallback)
  {
    this.a = paramQQPermissionCallback;
  }
  
  public void setContextStyleBlack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.tipsView.setTextColor(this.context.getResources().getColor(2131167666));
      return;
    }
    this.tipsView.setTextColor(this.context.getResources().getColor(2131165395));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView
 * JD-Core Version:    0.7.0.1
 */