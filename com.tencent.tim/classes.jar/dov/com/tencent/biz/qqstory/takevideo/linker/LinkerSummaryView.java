package dov.com.tencent.biz.qqstory.takevideo.linker;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aygu;
import aypi;
import aypi.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jpa;
import ram;

public class LinkerSummaryView
  extends FrameLayout
  implements View.OnClickListener, aypi.a
{
  private ImageView IW;
  private ImageView IX;
  private URLDrawable U;
  public aypi a;
  private TextView aic;
  private TextView aid;
  aygu b;
  public String cXM;
  public String cXN;
  private ViewGroup fp;
  private ImageView ir;
  boolean isEditing = false;
  boolean isShowShare = false;
  private Context mContext;
  private TextView mDesc;
  boolean mReadOnly = false;
  private TextView mTitle;
  private TextView mg;
  
  public LinkerSummaryView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131559268, this);
    this.fp = ((ViewGroup)findViewById(2131366239));
    this.IW = ((ImageView)findViewById(2131366240));
    this.mTitle = ((TextView)findViewById(2131366241));
    this.mDesc = ((TextView)findViewById(2131366236));
    this.aic = ((TextView)findViewById(2131366235));
    this.aid = ((TextView)findViewById(2131366242));
    this.ir = ((ImageView)findViewById(2131366234));
    this.IX = ((ImageView)findViewById(2131366238));
    this.mg = ((TextView)findViewById(2131366237));
    this.ir.setOnClickListener(this);
    this.IX.setOnClickListener(this);
    this.fp.setOnClickListener(this);
    this.mContext = paramContext;
  }
  
  private void dtH()
  {
    Object localObject2;
    if ((this.a != null) && (this.a.mUrl != null))
    {
      localObject2 = this.a.mUrl;
      localObject1 = null;
      int i = ((String)localObject2).lastIndexOf("#");
      if (i > 0) {
        localObject1 = ((String)localObject2).substring(i);
      }
      localObject2 = URLUtil.guessUrl((String)localObject2);
      if (localObject1 == null) {
        break label122;
      }
    }
    label122:
    for (Object localObject1 = (String)localObject2 + (String)localObject1;; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (((String)localObject1).lastIndexOf("&_wv=") == -1) {
        localObject2 = jpa.r((String)localObject1, "&_wv=2");
      }
      localObject1 = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      this.mContext.startActivity((Intent)localObject1);
      return;
    }
  }
  
  public void a(aypi paramaypi, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.2(this, paramaypi));
  }
  
  public void b(aypi paramaypi)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.1(this, paramaypi));
  }
  
  void c(aypi paramaypi)
  {
    this.a = paramaypi;
    String str1 = paramaypi.mUrl;
    String str2 = paramaypi.auf;
    str2 = paramaypi.zc;
    paramaypi = paramaypi.aue;
    if (!this.isShowShare) {
      this.IW.setImageResource(2130840151);
    }
    if (!TextUtils.isEmpty(str2))
    {
      this.mTitle.setText(str2);
      if (!TextUtils.isEmpty(paramaypi))
      {
        paramaypi = Html.fromHtml(paramaypi);
        ram.d(getClass().getName(), "result:" + paramaypi);
        this.mDesc.setText(paramaypi);
      }
      this.aid.setVisibility(8);
      this.mTitle.setVisibility(0);
      this.mDesc.setVisibility(0);
      this.aic.setVisibility(0);
      return;
    }
    this.aid.setVisibility(0);
    this.aid.setText(str1);
    this.mTitle.setVisibility(8);
    this.mDesc.setVisibility(8);
    this.aic.setVisibility(8);
  }
  
  void eTh()
  {
    if (this.isShowShare)
    {
      if (this.cXN != null)
      {
        this.mg.setVisibility(0);
        this.mg.setText(this.cXN);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      if ((this.U == null) && (this.cXM != null))
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130847502);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130840151);
      }
      try
      {
        this.U = URLDrawable.getDrawable(this.cXM, localURLDrawableOptions);
        this.IW.setImageDrawable(this.U);
        ram.d(getClass().getName(), "setIconURlDrawable:" + this.cXM);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return;
      }
    }
    this.mg.setVisibility(8);
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
      if (this.b != null) {
        this.b.eRC();
      }
      this.a = null;
      this.b = null;
      aygu.r("clk_linkdelete", this.mContext);
      continue;
      if (this.mReadOnly)
      {
        dtH();
      }
      else if (this.isEditing)
      {
        if (this.b != null)
        {
          this.b.Zn(true);
          anot.a(null, "dc00899", "grp_story", "", "video_edit", "edit_linkbar", 0, 0, "2", "1", "", "");
        }
      }
      else
      {
        setEditing(true);
        aygu.r("clk_linkbar", this.mContext);
        continue;
        dtH();
        aygu.r("clk_linkgo", this.mContext);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.mReadOnly) && (this.isEditing) && (this.b != null))
    {
      setEditing(false);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEditVideoLinker(aygu paramaygu)
  {
    this.b = paramaygu;
  }
  
  public void setEditing(boolean paramBoolean)
  {
    if (this.mReadOnly) {
      return;
    }
    this.isEditing = paramBoolean;
    if (paramBoolean)
    {
      this.ir.setVisibility(0);
      this.IX.setVisibility(0);
      return;
    }
    this.ir.setVisibility(8);
    this.IX.setVisibility(8);
  }
  
  public void setLinkerObject(aypi paramaypi)
  {
    eTh();
    if (paramaypi.jQ())
    {
      c(paramaypi);
      return;
    }
    this.a = paramaypi;
    String str = paramaypi.mUrl;
    this.aid.setVisibility(0);
    this.aid.setText(str);
    this.mTitle.setVisibility(8);
    this.mDesc.setVisibility(8);
    this.aic.setVisibility(8);
    if (!this.isShowShare) {
      this.IW.setImageResource(2130847502);
    }
    paramaypi.a(this);
    paramaypi.parseUrl(str);
  }
  
  public void setReadOnly()
  {
    this.mReadOnly = true;
  }
  
  public void setShowShare(boolean paramBoolean)
  {
    this.isShowShare = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView
 * JD-Core Version:    0.7.0.1
 */