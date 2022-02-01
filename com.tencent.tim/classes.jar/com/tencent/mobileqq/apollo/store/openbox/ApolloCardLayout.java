package com.tencent.mobileqq.apollo.store.openbox;

import abtn;
import abtn.a;
import abud.a;
import acfp;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoop;
import aqhu;
import aqmu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import wja;

public class ApolloCardLayout
  extends RelativeLayout
{
  private Path E;
  private Path F;
  private Path G;
  private TextView PY;
  private TextView PZ;
  private TextView Qa;
  private TextView Qb;
  private abud.a jdField_a_of_type_Abud$a;
  private AnimationableProgressView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView;
  private MultiURLImageView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView;
  private URLImageView aJ;
  private URLImageView aK;
  private URLImageView aL;
  private URLImageView aM;
  private int aYl;
  private Paint bw;
  private PorterDuffXfermode d;
  private RelativeLayout js;
  private int mHeight;
  private int mWidth;
  
  public ApolloCardLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ApolloCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.bw = new Paint();
    this.bw.setAntiAlias(true);
    this.bw.setColor(-1);
    this.bw.setStyle(Paint.Style.FILL);
    this.d = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  }
  
  public void a(int paramInt1, abud.a parama, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Abud$a = parama;
    if (this.jdField_a_of_type_Abud$a == null) {
      return;
    }
    this.aYl = paramInt1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView == null)
    {
      parama = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView = new AnimationableProgressView(getContext());
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView, parama);
    }
    if (this.Qb == null)
    {
      parama = new RelativeLayout.LayoutParams(-2, wja.dp2px(48.0F, getResources()));
      this.Qb = new TextView(getContext());
      parama.addRule(3, 2131362772);
      this.Qb.setTextColor(Color.parseColor("#777777"));
      parama.topMargin = wja.dp2px(9.0F, getResources());
      this.Qb.setTextSize(1, 14.0F);
      this.Qb.setGravity(49);
      this.Qb.setMaxLines(2);
      this.Qb.setEllipsize(TextUtils.TruncateAt.END);
      super.addView(this.Qb, parama);
    }
    label486:
    int k;
    int j;
    label602:
    Object localObject;
    if (this.aYl == 1)
    {
      parama = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.getLayoutParams();
      parama.width = ((int)(paramInt2 * 0.535F));
      parama.height = ((int)(paramInt2 * 0.113F));
      parama.addRule(14);
      parama.addRule(12);
      parama.bottomMargin = ((int)(paramInt3 * 0.129F));
      parama = (RelativeLayout.LayoutParams)this.Qb.getLayoutParams();
      parama.width = ((int)(paramInt2 * 0.78F));
      parama.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
      this.Qb.setVisibility(0);
      if (this.PY == null)
      {
        this.PY = new TextView(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        parama.addRule(14);
        parama.addRule(10);
        parama.topMargin = ((int)(paramInt3 * 0.703F));
        this.PY.setTextSize(18.0F);
        this.PY.setId(2131362772);
        this.PY.setTextColor(-16777216);
        this.PY.setEllipsize(TextUtils.TruncateAt.END);
        this.PY.setSingleLine(true);
        super.addView(this.PY, parama);
      }
      this.PY.setText(this.jdField_a_of_type_Abud$a.mName);
      parama = (RelativeLayout.LayoutParams)this.PY.getLayoutParams();
      this.PY.setMaxWidth((int)(paramInt2 * 0.8F));
      if (this.jdField_a_of_type_Abud$a.csm != 1) {
        break label1647;
      }
      this.PY.setText(acfp.m(2131702450));
      this.PY.setTextSize(14.0F);
      this.PY.setTextColor(-16777216);
      parama.topMargin = ((int)(paramInt3 * 0.806F));
      if (this.aL == null)
      {
        this.aL = new URLImageView(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        this.aL.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.aL, parama);
      }
      if (this.jdField_a_of_type_Abud$a.csm != 1) {
        break label1966;
      }
      parama = getContext().getResources().getDrawable(2130838548);
      k = parama.getIntrinsicWidth();
      j = parama.getIntrinsicHeight();
      if (this.aYl != 2) {
        break label1899;
      }
      i = (int)(k * 0.55F);
      paramInt1 = (int)(j * 0.55F);
      localObject = new RelativeLayout.LayoutParams(i, paramInt1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.588F) - paramInt1 / 2);
      this.aL.setImageDrawable(parama);
      this.aL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      if (this.aK == null)
      {
        this.aK = new URLImageView(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        this.aK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.aK, parama);
      }
      paramInt1 = (int)(paramInt2 * 0.2F);
      i = (int)(paramInt2 * 0.252F);
      parama = (RelativeLayout.LayoutParams)this.aK.getLayoutParams();
      parama.addRule(11);
      parama.addRule(10);
      parama.rightMargin = ((int)(0.103F * paramInt2));
      parama.topMargin = ((int)(0.074F * paramInt3));
      parama.width = paramInt1;
      parama.height = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Abud$a.bhP)) {
        break label2492;
      }
      parama = abtn.a(Utils.Crc64String(this.jdField_a_of_type_Abud$a.bhP), null, this.jdField_a_of_type_Abud$a.bhP);
      label824:
      this.aK.setBackgroundDrawable(parama);
      if (this.js == null)
      {
        this.js = new RelativeLayout(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        super.addView(this.js, parama);
      }
      parama = (RelativeLayout.LayoutParams)this.js.getLayoutParams();
      parama.addRule(14);
      parama.addRule(12);
      parama.bottomMargin = ((int)(paramInt3 * 0.073F));
      if (this.aM == null)
      {
        this.aM = new URLImageView(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        this.aM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.js.addView(this.aM, parama);
      }
      if (this.aYl == 1)
      {
        paramInt1 = (int)(paramInt2 * 0.15F);
        parama = (RelativeLayout.LayoutParams)this.aM.getLayoutParams();
        parama.addRule(15);
        parama.addRule(9);
        parama.width = paramInt1;
        parama.height = paramInt1;
        this.aM.setBackgroundResource(2130838570);
        this.aM.setImageDrawable(null);
        this.aM.setPadding(1, 1, 1, 1);
      }
      if ((!this.jdField_a_of_type_Abud$a.bFD) && (!TextUtils.isEmpty(this.jdField_a_of_type_Abud$a.aGE)))
      {
        parama = URLDrawable.URLDrawableOptions.obtain();
        parama.mLoadingDrawable = aqhu.at();
        parama.mFailedDrawable = parama.mLoadingDrawable;
        localObject = new abtn.a();
        ((abtn.a)localObject).crD = abtn.crA;
        parama.mExtraInfo = localObject;
        parama = abtn.a(Utils.Crc64String(this.jdField_a_of_type_Abud$a.aGE), parama, this.jdField_a_of_type_Abud$a.aGE);
        this.aM.setImageDrawable(parama);
      }
      if (this.PZ == null)
      {
        this.PZ = new TextView(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        this.PZ.setTextSize(14.0F);
        this.PZ.setTextColor(-16777216);
        this.PZ.setSingleLine(true);
        this.PZ.setEllipsize(TextUtils.TruncateAt.END);
        this.PZ.setIncludeFontPadding(false);
        this.js.addView(this.PZ, parama);
      }
      if (this.aYl == 1)
      {
        this.PZ.setMaxWidth((int)(paramInt2 * 0.5F));
        parama = (RelativeLayout.LayoutParams)this.PZ.getLayoutParams();
        parama.addRule(9);
        parama.addRule(10);
        parama.topMargin = ((int)(paramInt3 * 0.017F));
        parama.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.Qa == null)
      {
        this.Qa = new TextView(getContext());
        parama = new RelativeLayout.LayoutParams(-2, -2);
        this.Qa.setTextSize(10.0F);
        this.Qa.setIncludeFontPadding(false);
        this.Qa.setTextColor(-16777216);
        this.js.addView(this.Qa, parama);
      }
      if (this.aYl == 1)
      {
        parama = (RelativeLayout.LayoutParams)this.Qa.getLayoutParams();
        parama.addRule(9);
        parama.addRule(10);
        parama.topMargin = ((int)(paramInt3 * 0.065F));
        parama.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.aJ == null)
      {
        this.aJ = new URLImageView(getContext());
        super.addView(this.aJ);
      }
      parama = (RelativeLayout.LayoutParams)this.aJ.getLayoutParams();
      parama.addRule(11);
      parama.addRule(10);
      parama.width = (paramInt3 * 130 / 760);
      parama.height = (paramInt3 * 142 / 760);
      parama.topMargin = ((int)(paramInt3 * 0.45F));
      parama.rightMargin = (paramInt3 * 25 / 760);
      if (this.jdField_a_of_type_Abud$a.csm != 1) {
        break label2669;
      }
      if (this.aYl != 1) {
        break label2657;
      }
      this.PY.setVisibility(0);
      label1557:
      this.aJ.setVisibility(8);
      this.aK.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.Qb.setVisibility(8);
      this.js.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
      }
      this.aL.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.Qb.setVisibility(8);
      break;
      label1647:
      if (this.jdField_a_of_type_Abud$a.csm == 2)
      {
        this.PY.setText(this.jdField_a_of_type_Abud$a.csl + acfp.m(2131702456));
        this.PY.setTextSize(18.0F);
        this.PY.setTextColor(-1);
        parama.topMargin = ((int)(paramInt3 * 0.697F));
        break label486;
      }
      if (this.jdField_a_of_type_Abud$a.csm == 3)
      {
        this.PY.setText(this.jdField_a_of_type_Abud$a.csl + acfp.m(2131702451));
        this.PY.setTextSize(18.0F);
        this.PY.setTextColor(-1);
        parama.topMargin = ((int)(paramInt3 * 0.697F));
        break label486;
      }
      parama.topMargin = ((int)(paramInt3 * 0.703F));
      this.PY.setTextColor(-16777216);
      if (this.aYl == 1)
      {
        this.PY.setTextSize(18.0F);
        break label486;
      }
      if (this.aYl == 2)
      {
        this.PY.setTextSize(14.0F);
        break label486;
      }
      if (this.aYl == 3)
      {
        this.PY.setTextSize(10.0F);
        break label486;
      }
      this.PY.setTextSize(8.0F);
      break label486;
      label1899:
      if (this.aYl == 3)
      {
        i = (int)(k * 0.38F);
        paramInt1 = (int)(j * 0.38F);
        break label602;
      }
      paramInt1 = j;
      i = k;
      if (this.aYl != 4) {
        break label602;
      }
      i = (int)(k * 0.28F);
      paramInt1 = (int)(j * 0.28F);
      break label602;
      label1966:
      if (this.jdField_a_of_type_Abud$a.csm == 2)
      {
        parama = abtn.a("apollo_card_gold_icon.png", null, abtn.iG("apollo_card_gold_icon.png"));
        paramInt1 = (int)(paramInt3 * 0.38F);
        localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.aL.setImageDrawable(parama);
        this.aL.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else
      {
        if (this.jdField_a_of_type_Abud$a.csm != 3) {
          break label2169;
        }
        parama = abtn.a("apollo_card_crystal_image.png", null, abtn.iG("apollo_card_crystal_image.png"));
        parama.startDownload();
        paramInt1 = (int)(paramInt3 * 0.363F);
        localObject = new RelativeLayout.LayoutParams((int)(paramInt3 * 0.3F), paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.aL.setImageDrawable(parama);
        this.aL.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label2169:
    paramInt1 = (int)(paramInt2 * 0.488F);
    int i = (int)(paramInt3 * 0.531F);
    if ((this.jdField_a_of_type_Abud$a.O == 3) || (this.jdField_a_of_type_Abud$a.csn == 1))
    {
      paramInt1 = (int)(paramInt2 * 0.714F);
      i = (int)(paramInt3 * 0.497F);
    }
    for (;;)
    {
      parama = (RelativeLayout.LayoutParams)this.aL.getLayoutParams();
      parama.addRule(12);
      parama.addRule(14);
      parama.width = paramInt1;
      parama.height = i;
      parama.bottomMargin = ((int)(paramInt3 * 0.373F));
      if ((3 == this.jdField_a_of_type_Abud$a.O) || ((this.jdField_a_of_type_Abud$a.bhO != null) && (this.jdField_a_of_type_Abud$a.bhO.endsWith(".gif"))))
      {
        parama = URLDrawable.URLDrawableOptions.obtain();
        parama.mLoadingDrawable = aoop.TRANSPARENT;
        parama.mFailedDrawable = aoop.TRANSPARENT;
        parama.mExtraInfo = null;
        parama.mPlayGifImage = true;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Abud$a.bhO))
        {
          localObject = parama;
          if (parama == null) {
            localObject = URLDrawable.URLDrawableOptions.obtain();
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
          }
        }
        for (parama = URLDrawable.getDrawable(this.jdField_a_of_type_Abud$a.bhO, (URLDrawable.URLDrawableOptions)localObject);; parama = abtn.a("task_detail" + String.valueOf(this.jdField_a_of_type_Abud$a.O) + "_" + String.valueOf(this.jdField_a_of_type_Abud$a.mId), parama, abtn.w(this.jdField_a_of_type_Abud$a.O, this.jdField_a_of_type_Abud$a.mId)))
        {
          this.aL.setImageDrawable(parama);
          break;
        }
        label2492:
        if ("A".equals(this.jdField_a_of_type_Abud$a.bhN))
        {
          parama = abtn.a("apollo_box_card_a_2016_09_20.png", null, abtn.iG("apollo_box_card_a_2016_09_20.png"));
          break label824;
        }
        if ("B".equals(this.jdField_a_of_type_Abud$a.bhN))
        {
          parama = abtn.a("apollo_box_card_b_2016_09_20.png", null, abtn.iG("apollo_box_card_b_2016_09_20.png"));
          break label824;
        }
        if ("C".equals(this.jdField_a_of_type_Abud$a.bhN))
        {
          parama = abtn.a("apollo_box_card_c_2016_09_20.png", null, abtn.iG("apollo_box_card_c_2016_09_20.png"));
          break label824;
        }
        if ("S".equals(this.jdField_a_of_type_Abud$a.bhN))
        {
          parama = abtn.a("apollo_box_card_s_2016_09_20.png", null, abtn.iG("apollo_box_card_s_2016_09_20.png"));
          break label824;
        }
        if ("V".equals(this.jdField_a_of_type_Abud$a.bhN))
        {
          parama = abtn.a("apollo_box_card_v_2017_11_03.png", null, abtn.iG("apollo_box_card_v_2017_11_03.png"));
          break label824;
          label2657:
          this.PY.setVisibility(8);
          break label1557;
          label2669:
          if ((this.jdField_a_of_type_Abud$a.csm == 2) || (this.jdField_a_of_type_Abud$a.csm == 3))
          {
            if (this.aYl == 1) {
              if (this.jdField_a_of_type_Abud$a.bFD)
              {
                this.PY.setVisibility(0);
                if (!this.jdField_a_of_type_Abud$a.bFD) {
                  break label3413;
                }
                this.aL.setVisibility(0);
                this.aK.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.Qb.setVisibility(8);
                if ((this.jdField_a_of_type_Abud$a.bFD) || (this.aYl != 1)) {
                  break label3435;
                }
                this.js.setVisibility(0);
                this.Qa.setText(aqmu.bQ(this.jdField_a_of_type_Abud$a.OA * 1000L));
                localObject = this.PZ;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Abud$a.aGC)) {
                  break label3424;
                }
                parama = String.valueOf(this.jdField_a_of_type_Abud$a.Oy);
                ((TextView)localObject).setText(parama);
                this.aJ.setVisibility(0);
                if (!this.jdField_a_of_type_Abud$a.bFD) {
                  break label3458;
                }
                if (this.jdField_a_of_type_Abud$a.Oz == this.jdField_a_of_type_Abud$a.Oy) {
                  break label3447;
                }
                parama = abtn.a("apollo_self_stolen_got_2016_9_22.png", null, abtn.iG("apollo_self_stolen_got_2016_9_22.png"));
                this.aJ.setBackgroundDrawable(parama);
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView = new MultiURLImageView(getContext());
                  super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView);
                }
                parama = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.getLayoutParams();
                parama.addRule(11);
                parama.addRule(12);
                parama.rightMargin = (paramInt3 * 155 / 760);
                parama.bottomMargin = (paramInt3 * 320 / 760);
                parama = new ArrayList();
                localObject = new MultiURLImageView.a();
                ((MultiURLImageView.a)localObject).mWidth = (paramInt3 * 46 / 760);
                ((MultiURLImageView.a)localObject).mHeight = (paramInt3 * 68 / 760);
                ((MultiURLImageView.a)localObject).mScaleType = ImageView.ScaleType.FIT_END;
                if (this.jdField_a_of_type_Abud$a.csm != 2) {
                  break label3483;
                }
                ((MultiURLImageView.a)localObject).bhU = "apollo_card_gold_add.png";
                label3056:
                ((MultiURLImageView.a)localObject).mUrl = abtn.iG(((MultiURLImageView.a)localObject).bhU);
                parama.add(localObject);
                if (this.jdField_a_of_type_Abud$a.csl >= 10)
                {
                  paramInt1 = this.jdField_a_of_type_Abud$a.csl % 100 / 10;
                  localObject = new MultiURLImageView.a();
                  if (paramInt1 != 1) {
                    break label3505;
                  }
                  ((MultiURLImageView.a)localObject).mWidth = (paramInt3 * 35 / 760);
                  ((MultiURLImageView.a)localObject).mHeight = (paramInt3 * 80 / 760);
                  if (this.jdField_a_of_type_Abud$a.csm != 2) {
                    break label3536;
                  }
                  ((MultiURLImageView.a)localObject).bhU = ("apollo_card_gold_" + paramInt1 + ".png");
                  label3188:
                  ((MultiURLImageView.a)localObject).bAr = (-paramInt3 * 4 / 760);
                  ((MultiURLImageView.a)localObject).mUrl = abtn.iG(((MultiURLImageView.a)localObject).bhU);
                  parama.add(localObject);
                }
                paramInt1 = this.jdField_a_of_type_Abud$a.csl % 10;
                localObject = new MultiURLImageView.a();
                ((MultiURLImageView.a)localObject).bAr = (-paramInt3 * 4 / 760);
                if (paramInt1 != 1) {
                  break label3581;
                }
                ((MultiURLImageView.a)localObject).mWidth = (paramInt3 * 35 / 760);
                ((MultiURLImageView.a)localObject).mHeight = (paramInt3 * 80 / 760);
                if (this.jdField_a_of_type_Abud$a.csm != 2) {
                  break label3612;
                }
                ((MultiURLImageView.a)localObject).bhU = ("apollo_card_gold_" + paramInt1 + ".png");
              }
            }
            for (;;)
            {
              ((MultiURLImageView.a)localObject).mUrl = abtn.iG(((MultiURLImageView.a)localObject).bhU);
              parama.add(localObject);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setOrientation(0);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setViewLayoutDatas(parama);
              if (!this.jdField_a_of_type_Abud$a.bFD) {
                break label3657;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(0);
              return;
              this.PY.setVisibility(4);
              break;
              this.PY.setVisibility(8);
              break;
              this.aL.setVisibility(4);
              break label2735;
              parama = this.jdField_a_of_type_Abud$a.aGC;
              break label2839;
              this.js.setVisibility(8);
              break label2845;
              label3447:
              this.aJ.setBackgroundDrawable(null);
              break label2903;
              parama = abtn.a("apollo_other_stolen_got_2016_9_22.png", null, abtn.iG("apollo_other_stolen_got_2016_9_22.png"));
              this.aJ.setBackgroundDrawable(parama);
              break label2903;
              if (this.jdField_a_of_type_Abud$a.csm != 3) {
                break label3056;
              }
              ((MultiURLImageView.a)localObject).bhU = "apollo_card_crystal_add.png";
              break label3056;
              ((MultiURLImageView.a)localObject).mWidth = (paramInt3 * 55 / 760);
              ((MultiURLImageView.a)localObject).mHeight = (paramInt3 * 80 / 760);
              break label3146;
              if (this.jdField_a_of_type_Abud$a.csm != 3) {
                break label3188;
              }
              ((MultiURLImageView.a)localObject).bhU = ("apollo_card_crystal_" + paramInt1 + ".png");
              break label3188;
              label3581:
              ((MultiURLImageView.a)localObject).mWidth = (paramInt3 * 55 / 760);
              ((MultiURLImageView.a)localObject).mHeight = (paramInt3 * 80 / 760);
              break label3291;
              if (this.jdField_a_of_type_Abud$a.csm == 3) {
                ((MultiURLImageView.a)localObject).bhU = ("apollo_card_crystal_" + paramInt1 + ".png");
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
            return;
          }
          label2735:
          label2903:
          label3291:
          label3424:
          label3435:
          this.aL.setVisibility(0);
          label2839:
          label2845:
          label3146:
          label3413:
          this.PY.setVisibility(0);
          label3458:
          label3483:
          label3505:
          label3536:
          this.aJ.setVisibility(0);
          label3612:
          label3657:
          this.aK.setVisibility(0);
          if (this.jdField_a_of_type_Abud$a.bFD)
          {
            if (this.jdField_a_of_type_Abud$a.Oz != this.jdField_a_of_type_Abud$a.Oy)
            {
              parama = abtn.a("apollo_self_stolen_got_2016_9_22.png", null, abtn.iG("apollo_self_stolen_got_2016_9_22.png"));
              this.aJ.setBackgroundDrawable(parama);
              if (this.aYl == 1)
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.f(this.jdField_a_of_type_Abud$a.csj, this.jdField_a_of_type_Abud$a.csi, this.jdField_a_of_type_Abud$a.Ou, this.jdField_a_of_type_Abud$a.Ov);
                if (TextUtils.isEmpty(this.jdField_a_of_type_Abud$a.mDesc)) {
                  break label3879;
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.Qb.setVisibility(0);
                this.Qb.setText(this.jdField_a_of_type_Abud$a.mDesc);
              }
            }
            for (;;)
            {
              this.js.setVisibility(8);
              label3852:
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null) {
                break label4004;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
              return;
              this.aJ.setBackgroundDrawable(null);
              break;
              label3879:
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
              this.Qb.setVisibility(8);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
          if (this.aYl == 1)
          {
            this.js.setVisibility(0);
            label3924:
            this.Qa.setText(aqmu.bQ(this.jdField_a_of_type_Abud$a.OA * 1000L));
            localObject = this.PZ;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Abud$a.aGC)) {
              break label4018;
            }
          }
          label4004:
          label4018:
          for (parama = String.valueOf(this.jdField_a_of_type_Abud$a.Oy);; parama = this.jdField_a_of_type_Abud$a.aGC)
          {
            ((TextView)localObject).setText(parama);
            parama = abtn.a("apollo_other_stolen_got_2016_9_22.png", null, abtn.iG("apollo_other_stolen_got_2016_9_22.png"));
            this.aJ.setBackgroundDrawable(parama);
            break label3852;
            break;
            this.js.setVisibility(8);
            break label3924;
          }
        }
        parama = null;
        break label824;
        parama = null;
      }
    }
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(21)
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.mWidth, this.mHeight, null);
      if (this.jdField_a_of_type_Abud$a != null)
      {
        if ((this.jdField_a_of_type_Abud$a.csm != 2) && (this.jdField_a_of_type_Abud$a.csm != 3)) {
          break label436;
        }
        if (!this.jdField_a_of_type_Abud$a.bFD) {
          break label317;
        }
        if (this.E != null)
        {
          this.bw.setColor(-2147483648);
          this.bw.setXfermode(null);
          paramCanvas.drawPath(this.E, this.bw);
          this.bw.setColor(654311423);
          this.bw.setXfermode(null);
          paramCanvas.drawPath(this.E, this.bw);
        }
      }
      label138:
      super.dispatchDraw(paramCanvas);
      if ((this.jdField_a_of_type_Abud$a != null) && (!this.jdField_a_of_type_Abud$a.bFD) && (this.jdField_a_of_type_Abud$a.csm == 0))
      {
        this.bw.setXfermode(this.d);
        if (this.jdField_a_of_type_Abud$a.csk == -1) {
          break label475;
        }
        this.bw.setColor(this.jdField_a_of_type_Abud$a.csk);
        label207:
        if (this.aYl != 1) {
          break label488;
        }
        paramCanvas.drawRect(0.0F, 0.0F, this.mWidth, this.mHeight * 0.78F, this.bw);
      }
    }
    for (;;)
    {
      super.drawChild(paramCanvas, this.aJ, getDrawingTime());
      paramCanvas.restoreToCount(i);
      if (QLog.isColorLevel()) {
        QLog.e("ApolloCardWindow", 2, "ApolloCardLayout onDraw use" + (System.currentTimeMillis() - l));
      }
      return;
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.mWidth, this.mHeight, null, 1);
      break;
      label317:
      super.drawChild(paramCanvas, this.aL, getDrawingTime());
      super.drawChild(paramCanvas, this.PY, getDrawingTime());
      super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView, getDrawingTime());
      if (this.F != null)
      {
        this.bw.setColor(-1778384896);
        this.bw.setXfermode(null);
        paramCanvas.drawPath(this.F, this.bw);
      }
      if (this.G == null) {
        break label138;
      }
      this.bw.setColor(-1);
      this.bw.setXfermode(null);
      paramCanvas.drawPath(this.G, this.bw);
      break label138;
      label436:
      if (this.E == null) {
        break label138;
      }
      this.bw.setColor(-1);
      this.bw.setXfermode(null);
      paramCanvas.drawPath(this.E, this.bw);
      break label138;
      label475:
      this.bw.setColor(-1728053248);
      break label207;
      label488:
      paramCanvas.drawRect(0.0F, 0.0F, this.mWidth, this.mHeight, this.bw);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.mWidth) || (paramInt2 != this.mHeight))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      if (this.E == null) {
        this.E = new Path();
      }
      paramInt1 = (int)(this.mWidth * 0.037F);
      paramInt2 = (int)(this.mWidth * 0.047F);
      paramInt3 = (int)(this.mHeight * 0.026F);
      this.E.reset();
      this.E.moveTo(paramInt2 + paramInt1, this.mHeight - paramInt3);
      this.E.arcTo(new RectF(paramInt2, this.mHeight - paramInt1 * 2 - paramInt3, paramInt1 * 2 + paramInt2, this.mHeight - paramInt3), 90.0F, 90.0F);
      this.E.arcTo(new RectF(paramInt2, paramInt3, paramInt1 * 2 + paramInt2, paramInt1 * 2 + paramInt3), 180.0F, 90.0F);
      this.E.arcTo(new RectF(this.mWidth - paramInt1 * 2 - paramInt2, paramInt3, this.mWidth - paramInt2, paramInt1 * 2 + paramInt3), -90.0F, 90.0F);
      this.E.arcTo(new RectF(this.mWidth - paramInt1 * 2 - paramInt2, this.mHeight - paramInt1 * 2 - paramInt3, this.mWidth - paramInt2, this.mHeight - paramInt3), 0.0F, 90.0F);
      this.E.close();
      if (this.F == null) {
        this.F = new Path();
      }
      this.F.reset();
      paramInt4 = (int)(this.mHeight * 0.78F);
      this.F.moveTo(paramInt2, paramInt4);
      this.F.arcTo(new RectF(paramInt2, paramInt3, paramInt1 * 2 + paramInt2, paramInt1 * 2 + paramInt3), 180.0F, 90.0F);
      this.F.arcTo(new RectF(this.mWidth - paramInt1 * 2 - paramInt2, paramInt3, this.mWidth - paramInt2, paramInt1 * 2 + paramInt3), -90.0F, 90.0F);
      this.F.lineTo(this.mWidth - paramInt2, paramInt4);
      this.F.close();
      if (this.G == null) {
        this.G = new Path();
      }
      this.G.reset();
      this.G.moveTo(paramInt2 + paramInt1, this.mHeight - paramInt3);
      this.G.arcTo(new RectF(paramInt2, this.mHeight - paramInt1 * 2 - paramInt3, paramInt1 * 2 + paramInt2, this.mHeight - paramInt3), 90.0F, 90.0F);
      this.G.lineTo(paramInt2, paramInt4);
      this.G.lineTo(this.mWidth - paramInt2, paramInt4);
      this.G.arcTo(new RectF(this.mWidth - paramInt1 * 2 - paramInt2, this.mHeight - paramInt1 * 2 - paramInt3, this.mWidth - paramInt2, this.mHeight - paramInt3), 0.0F, 90.0F);
      this.G.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardLayout
 * JD-Core Version:    0.7.0.1
 */