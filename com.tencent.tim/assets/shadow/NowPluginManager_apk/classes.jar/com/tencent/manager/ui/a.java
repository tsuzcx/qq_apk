package com.tencent.manager.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.manager.c.g;

public class a
  extends FrameLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private RoundProgressBar d;
  private ProgressBar e;
  private ImageView f;
  private int g = 0;
  private a h;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.d.setProgress(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.b.setVisibility(8);
    this.a.setVisibility(0);
    this.a.setText("直播插件加载失败");
    this.f.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (this.g > 0)
    {
      i = paramInt;
      if (this.g < 100)
      {
        i = paramInt;
        if (paramInt > 0) {
          i = this.g * paramInt / 100;
        }
      }
    }
    if (this.d == null) {
      return;
    }
    this.d.invalidate();
    this.d.setCircleColor(-1);
    this.d.setRoundWidth(g.a(getContext(), 5.0F));
    this.d.setCircleProgressColor(Color.parseColor("#787bff"));
    this.d.setProgress(i);
    this.d.setNeedShowProgreeText(false);
    this.d.setVisibility(0);
    this.b.setText(String.valueOf(i) + "%");
    this.a.setVisibility(0);
    this.a.setText(getContext().getString(2131034113));
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void a(Context paramContext, Bitmap paramBitmap, int paramInt, String paramString)
  {
    c.a(LayoutInflater.from(paramContext), paramContext, paramString).inflate(2130968576, this);
    com.tencent.util.e.a.a("LoadingViewController", "NowLoadingActivity    onCreate ");
    this.d = ((RoundProgressBar)findViewById(2130903040));
    this.e = ((ProgressBar)findViewById(2130903042));
    this.f = ((ImageView)findViewById(2130903041));
    this.e.setVisibility(8);
    paramString = (ImageView)findViewById(2130903046);
    this.g = paramInt;
    paramString.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBitmap != null) {
      paramString.setImageBitmap(paramBitmap);
    }
    for (;;)
    {
      findViewById(2130903046).setVisibility(0);
      this.d.setVisibility(8);
      this.a = ((TextView)findViewById(2130903043));
      this.c = ((TextView)findViewById(2130903047));
      this.b = ((TextView)findViewById(2130903045));
      findViewById(2130903046).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a(a.this).setVisibility(8);
          a.b(a.this).setVisibility(8);
          a.c(a.this).setVisibility(8);
          if (a.d(a.this) != null) {
            a.d(a.this).a();
          }
        }
      });
      return;
      paramString.setImageDrawable(paramContext.getResources().getDrawable(2130837504));
    }
  }
  
  public void b()
  {
    this.a.setVisibility(0);
    this.a.setText("直播组件加载中");
    this.e.setVisibility(0);
    this.d.setVisibility(8);
  }
  
  public void setOprListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.ui.a
 * JD-Core Version:    0.7.0.1
 */