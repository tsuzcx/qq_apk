package com.tencent.mobileqq.location.ui;

import aiqs;
import aira;
import airi;
import aitg;
import aitz;
import aiun;
import aiuq;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import auvj;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class JavaHeadSetView
  extends LinearLayout
{
  private ImageView AV;
  private ImageView AW;
  private TextView Up;
  airi jdField_a_of_type_Airi;
  private aiun jdField_a_of_type_Aiun;
  private final QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private final Context context;
  private View rootView;
  private HorizontalListView t;
  
  public JavaHeadSetView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.jdField_a_of_type_Airi = new airi(paramContext);
    initViews();
    due();
    dud();
  }
  
  public static Drawable a(Context paramContext, Drawable paramDrawable)
  {
    Object localObject;
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    Resources localResources;
    if (!(paramDrawable instanceof SkinnableBitmapDrawable))
    {
      localObject = paramDrawable;
      if (!(paramDrawable instanceof BitmapDrawable)) {}
    }
    else
    {
      localBitmap1 = null;
      if (!(paramDrawable instanceof SkinnableBitmapDrawable)) {
        break label140;
      }
      localBitmap1 = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      localBitmap2 = Bitmap.createBitmap(localBitmap1);
      localResources = paramContext.getResources();
      localObject = paramDrawable;
      if (localResources != null)
      {
        if ((localBitmap1 == null) || (localBitmap2 != null)) {
          break label158;
        }
        paramContext = localBitmap1;
      }
    }
    label140:
    label158:
    do
    {
      do
      {
        paramDrawable = new BitmapDrawable(localResources, localBitmap1);
        paramContext = new BitmapDrawable(localResources, paramContext);
        paramContext.setAlpha(127);
        localObject = new StateListDrawable();
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { 16842908 }, paramDrawable);
        ((StateListDrawable)localObject).addState(new int[0], paramDrawable);
        return localObject;
        if (!(paramDrawable instanceof BitmapDrawable)) {
          break;
        }
        localBitmap1 = ((BitmapDrawable)paramDrawable).getBitmap();
        break;
        paramContext = localBitmap2;
      } while (localBitmap1 != null);
      paramContext = localBitmap2;
    } while (localBitmap2 != null);
    return paramDrawable;
  }
  
  private void dud()
  {
    View localView = $(2131377546);
    if (auvj.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void due()
  {
    if ((this.context instanceof Activity))
    {
      ayxa.initLiuHaiProperty((Activity)this.context);
      if (ayxa.sHasNotch)
      {
        View localView = $(2131372480);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        localLayoutParams.height = ayxa.sNotchHeight;
        localView.setLayoutParams(localLayoutParams);
        localView.setVisibility(0);
      }
    }
  }
  
  private void initListView()
  {
    this.t.setAdapter(this.jdField_a_of_type_Aiun);
    this.jdField_a_of_type_Airi.a(this.jdField_a_of_type_Aiun);
    this.jdField_a_of_type_Airi.I(this.Up);
  }
  
  private void initViews()
  {
    this.rootView = inflate(getContext(), 2131559469, this);
    this.t = ((HorizontalListView)$(2131370574));
    this.AV = ((ImageView)$(2131364238));
    this.AV.setOnClickListener(this.jdField_a_of_type_Airi);
    try
    {
      this.AV.setImageDrawable(a(this.context, this.context.getResources().getDrawable(2130846274)));
      aitz.p(this.AV, "退出位置共享");
      this.AW = ((ImageView)$(2131371523));
      this.AW.setOnClickListener(this.jdField_a_of_type_Airi);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.AW.setImageDrawable(a(this.context, this.context.getResources().getDrawable(2130846275)));
        aitz.p(this.AW, "最小化位置共享");
        this.Up = ((TextView)$(2131379540));
        initListView();
        return;
        localThrowable1 = localThrowable1;
        QLog.e("HeadSetView", 1, "initViews: failed. ", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e("HeadSetView", 1, "initViews: failed. ", localThrowable2);
        }
      }
    }
  }
  
  protected final <T extends View> T $(int paramInt)
  {
    return this.rootView.findViewById(paramInt);
  }
  
  public void setLocationController(aitg paramaitg, LocationRoom.b paramb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aiun.d(paramaitg);
    this.jdField_a_of_type_Airi.f(paramb);
    int i;
    if (!aiqs.a(this.app).a.b(paramb))
    {
      paramaitg = new ArrayList();
      paramaitg.add(this.app.getCurrentUin());
      this.jdField_a_of_type_Aiun.lm(paramaitg);
      if ((!paramBoolean) || (aiuq.g(this.app, paramb.getSessionType(), paramb.xc()))) {
        break label108;
      }
      i = 1;
      paramb = this.Up;
      if (i == 0) {
        break label114;
      }
    }
    label108:
    label114:
    for (paramaitg = "正在发起...";; paramaitg = "正在加入...")
    {
      paramb.setText(paramaitg);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.JavaHeadSetView
 * JD-Core Version:    0.7.0.1
 */