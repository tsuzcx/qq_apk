package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anjo;
import axpa.a;
import axxj;
import ayzs;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import rpw;
import wja;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  ImageView De;
  ImageView Df;
  ImageView Ja;
  public URLImageView aD;
  axpa.a b;
  boolean bnq;
  QIMCommonLoadingView d;
  RelativeLayout el;
  Context mContext;
  int mPosition;
  RelativeLayout nR;
  
  public PtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public PtvTemplateItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void a(int paramInt1, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, axpa.a parama, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.mPosition = paramInt1;
      this.b = parama;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.el.getVisibility() == 4);
    this.el.setVisibility(4);
    return;
    if (this.el.getVisibility() != 0) {
      this.el.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateItemView", 2, "bindData: invoked. info: info = " + paramPtvTemplateInfo);
    }
    paramInt1 = ayzs.dyy;
    boolean bool;
    if ((paramPtvTemplateInfo.funcType == PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) && (anjo.lC(paramInt1)))
    {
      bool = true;
      this.bnq = bool;
      if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
        break label495;
      }
      parama = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = wja.dp2px(60.0F, getResources());
      Drawable localDrawable = getResources().getDrawable(2130845452);
      parama.mRequestWidth = paramInt1;
      parama.mRequestHeight = paramInt1;
      parama.mFailedDrawable = localDrawable;
      parama.mLoadingDrawable = localDrawable;
      parama.mRetryCount = 3;
      parama = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, parama);
      if (parama.getStatus() == 2) {
        parama.restartDownload();
      }
      this.aD.setImageDrawable(parama);
      if ((!paramPtvTemplateInfo.id.equals(paramString)) || (!paramPtvTemplateInfo.usable)) {
        break label439;
      }
      this.De.setVisibility(0);
      paramPtvTemplateInfo.editablewatermark = paramBoolean;
      if (!paramPtvTemplateInfo.editablewatermark) {
        break label428;
      }
      this.nR.setVisibility(0);
      label268:
      if (!this.bnq) {
        break label458;
      }
      this.De.setImageResource(2130846854);
      this.d.setBgColor(2145789269);
      this.d.Yq(false);
      label301:
      if (!this.bnq) {
        break label563;
      }
      this.Df.setImageResource(2130850737);
      this.Df.setVisibility(0);
      if ((!paramPtvTemplateInfo.id.equals(paramString)) || (!paramPtvTemplateInfo.usable)) {
        break label551;
      }
      this.d.setVisibility(0);
      this.d.setBgColor(2130706432);
      this.d.Yq(true);
      label369:
      this.el.setOnClickListener(this);
      if (!paramPtvTemplateInfo.isWsBanner()) {
        break label633;
      }
      this.Df.setVisibility(8);
      this.Ja.setVisibility(0);
      if (!paramPtvTemplateInfo.isDovItem()) {
        break label621;
      }
      this.Ja.setImageResource(2130846843);
    }
    for (;;)
    {
      rpw.aq(paramPtvTemplateInfo);
      return;
      bool = false;
      break;
      label428:
      this.nR.setVisibility(4);
      break label268;
      label439:
      this.De.setVisibility(4);
      this.nR.setVisibility(4);
      break label268;
      label458:
      this.De.setImageResource(2130845519);
      this.d.setBgColor(-1);
      this.d.setProgressColor(-16725252);
      this.d.Yq(false);
      break label301;
      label495:
      if (!"0".equals(paramPtvTemplateInfo.id)) {
        break label301;
      }
      this.De.setVisibility(4);
      if (paramPtvTemplateInfo.id.equals(paramString))
      {
        this.aD.setImageResource(2130846851);
        break label301;
      }
      this.aD.setImageResource(2130846852);
      break label301;
      label551:
      this.d.setVisibility(8);
      break label369;
      label563:
      if ((paramPtvTemplateInfo.usable) || (paramPtvTemplateInfo.id.equals("0")))
      {
        this.Df.setVisibility(8);
        break label369;
      }
      if (paramPtvTemplateInfo.downloading) {
        break label369;
      }
      this.Df.setImageResource(2130845453);
      this.Df.setVisibility(0);
      break label369;
      label621:
      this.Ja.setImageResource(2130846856);
    }
    label633:
    if (paramPtvTemplateInfo.needDisplayType())
    {
      this.Ja.setVisibility(0);
      this.Ja.setImageResource(paramPtvTemplateInfo.getDisplayIconByType());
    }
    for (;;)
    {
      this.d.a(axxj.a(paramPtvTemplateInfo));
      return;
      this.Ja.setVisibility(8);
    }
  }
  
  public void initViews()
  {
    int i = wja.dp2px(60.0F, getResources());
    int j = wja.dp2px(60.0F, getResources());
    int k = wja.dp2px(16.0F, getResources());
    int m = wja.dp2px(6.0F, getResources());
    int n = wja.dp2px(2.0F, getResources());
    setLayoutParams(new AbsListView.LayoutParams(j, j));
    setGravity(17);
    this.el = new RelativeLayout(this.mContext);
    this.aD = new URLImageView(this.mContext);
    Object localObject = new RelativeLayout.LayoutParams(j, j);
    this.aD.setMinimumWidth(j);
    this.aD.setMinimumHeight(j);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.el.addView(this.aD, (ViewGroup.LayoutParams)localObject);
    this.nR = new RelativeLayout(this.mContext);
    localObject = new ImageView(this.mContext);
    ((ImageView)localObject).setImageResource(2130837944);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(80, 80);
    localLayoutParams.addRule(13);
    this.nR.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.nR.setBackgroundResource(2130845566);
    this.el.addView(this.nR, (ViewGroup.LayoutParams)localObject);
    this.nR.setVisibility(4);
    this.De = new ImageView(this.mContext);
    this.De.setImageResource(2130845519);
    this.De.setMinimumWidth(i);
    this.De.setMinimumHeight(i);
    this.De.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.De.setVisibility(4);
    this.el.addView(this.De, (ViewGroup.LayoutParams)localObject);
    this.d = new QIMCommonLoadingView(this.mContext);
    localObject = new RelativeLayout.LayoutParams(k, k);
    this.d.setBgCorner(k / 2);
    this.d.setMinimumHeight(k);
    this.d.setMinimumWidth(k);
    this.d.setProgressSizeAndMode(m, n, false);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.el.addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.Df = new ImageView(this.mContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.el.addView(this.Df, (ViewGroup.LayoutParams)localObject);
    this.Ja = new ImageView(this.mContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.Ja.setVisibility(8);
    this.el.addView(this.Ja, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    addView(this.el, (ViewGroup.LayoutParams)localObject);
  }
  
  public void mE(int paramInt)
  {
    this.d.setVisibility(0);
    if (paramInt >= 100) {
      if (!this.bnq) {
        this.Df.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt >= 0) {
          break;
        }
      } while (this.bnq);
      this.Df.setImageResource(2130845453);
      this.Df.setVisibility(0);
      return;
    } while (this.bnq);
    this.Df.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      this.b.Gr(this.mPosition);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */