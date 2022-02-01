package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.ListView;
import wja;

public class QFileSendBottomView
  extends RelativeLayout
{
  private QQBlurView a;
  private RelativeLayout kw;
  private ListView v;
  
  public QFileSendBottomView(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561027, this);
    Jd();
  }
  
  public QFileSendBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561027, this, true);
    Jd();
  }
  
  private void Jd()
  {
    this.kw = ((RelativeLayout)findViewById(2131377980));
  }
  
  public View M(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  protected void dmF()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.kw.setBackgroundResource(2130845100);
      return;
    }
    this.a = ((QQBlurView)findViewById(2131381443));
    this.a.setVisibility(0);
    this.a.iD(this.v);
    this.a.iE(this.a);
    this.a.YJ(-1);
    this.a.ae(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.a.YI(0);
    this.a.bg(8.0F);
    this.a.YK(8);
    this.a.onCreate();
    this.a.onResume();
  }
  
  public void t(ListView paramListView)
  {
    this.v = paramListView;
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.addView(new View(getContext()), new RelativeLayout.LayoutParams(-1, wja.dp2px(50.0F, getResources())));
    paramListView.addFooterView(localRelativeLayout);
    dmF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileSendBottomView
 * JD-Core Version:    0.7.0.1
 */