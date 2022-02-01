package com.tencent.mobileqq.location.ui;

import aiqs;
import aira;
import airh;
import airi;
import aitg;
import aitz;
import aiun;
import aiuq;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import auvj;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import jll;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/location/ui/HeadSetView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "cancelShare", "Landroid/widget/ImageView;", "headAdapter", "Lcom/tencent/mobileqq/location/ui/headset/HeadAdapter;", "headSetViewModule", "Lcom/tencent/mobileqq/location/ui/HeadSetViewModule;", "listViewHeadSet", "Lcom/tencent/widget/HorizontalListView;", "minShare", "rootLayoutView", "Landroid/view/View;", "textSharingCount", "Landroid/widget/TextView;", "adjustForNotchScreen", "", "adjustNightMode", "findView", "T", "id", "", "(I)Landroid/view/View;", "init", "initHeadSetViewModule", "initListView", "initViews", "maxShownAvatarCount", "onResume", "setLocationController", "controller", "Lcom/tencent/mobileqq/location/ui/LocationShareController;", "roomKey", "Lcom/tencent/mobileqq/location/data/LocationRoom$RoomKey;", "fromPlusPanel", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class HeadSetView
  extends LinearLayout
{
  private ImageView AV;
  private ImageView AW;
  private View DN;
  private TextView Up;
  @JvmField
  @Nullable
  public airi a;
  private aiun a;
  private final QQAppInterface app;
  private HorizontalListView t;
  
  public HeadSetView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "BaseApplicationImpl.getApplication()");
    paramContext = paramContext.getRuntime();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    this.app = ((QQAppInterface)paramContext);
  }
  
  private final <T extends View> T C(int paramInt)
  {
    View localView = this.DN;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  private final void duc()
  {
    this.jdField_a_of_type_Airi = new airi(getContext());
  }
  
  private final void dud()
  {
    View localView = C(2131377546);
    boolean bool = auvj.isNightMode();
    if (bool == true) {
      localView.setBackgroundColor(Color.parseColor("#CC000000"));
    }
    while (bool) {
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private final void due()
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = getContext();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ayxa.initLiuHaiProperty((Activity)localObject);
      if (ayxa.sHasNotch)
      {
        localObject = C(2131372480);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.height = ayxa.sNotchHeight;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  private final void initListView()
  {
    this.jdField_a_of_type_Aiun = new aiun(this.app, getContext(), this.t, this);
    Object localObject = this.t;
    if (localObject != null) {
      ((HorizontalListView)localObject).setAdapter((ListAdapter)this.jdField_a_of_type_Aiun);
    }
    localObject = this.jdField_a_of_type_Airi;
    if (localObject != null)
    {
      ((airi)localObject).a(this.jdField_a_of_type_Aiun);
      ((airi)localObject).I(this.Up);
    }
  }
  
  private final void initViews()
  {
    this.DN = View.inflate(getContext(), 2131559469, (ViewGroup)this);
    this.t = ((HorizontalListView)C(2131370574));
    this.AV = ((ImageView)C(2131364238));
    ImageView localImageView = this.AV;
    Context localContext;
    Object localObject;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Airi);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130846274);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…able.qq_loc_cancel_share)");
      localImageView.setImageDrawable(airh.a(localContext, (Drawable)localObject));
    }
    aitz.p((View)this.AV, "退出位置共享");
    this.AW = ((ImageView)C(2131371523));
    localImageView = this.AW;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Airi);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130846275);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…rawable.qq_loc_min_share)");
      localImageView.setImageDrawable(airh.a(localContext, (Drawable)localObject));
    }
    aitz.p((View)this.AW, "最小化位置共享");
    this.Up = ((TextView)C(2131379540));
    initListView();
  }
  
  public final int FW()
  {
    View localView = C(2131370586);
    float f1 = jll.dp2px(getContext(), 40.0F);
    f1 = localView.getWidth() - f1;
    float f2 = jll.dp2px(getContext(), 48.0F);
    double d = Math.floor(f1 / f2);
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetView", 2, new Object[] { "maxShownAvatarCount: invoked. ", " floor: " + d + " avatarWidth: " + f2 + " listViewContainerWidth: " + f1 });
    }
    if (d > 4) {
      return 4;
    }
    return (int)d;
  }
  
  public final void init()
  {
    duc();
    initViews();
    due();
    dud();
  }
  
  public final void onResume()
  {
    aiun localaiun = this.jdField_a_of_type_Aiun;
    if (localaiun != null) {
      localaiun.notifyDataSetChanged();
    }
  }
  
  public final void setLocationController(@Nullable aitg paramaitg, @NotNull LocationRoom.b paramb, boolean paramBoolean)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramb, "roomKey");
    aiun localaiun = this.jdField_a_of_type_Aiun;
    if (localaiun != null) {
      localaiun.d(paramaitg);
    }
    paramaitg = this.jdField_a_of_type_Airi;
    if (paramaitg != null) {
      paramaitg.f(paramb);
    }
    int i;
    if (!aiqs.a(this.app).a.b(paramb))
    {
      i = 1;
      if (i == 1)
      {
        paramaitg = CollectionsKt.mutableListOf(new String[] { this.app.getCurrentUin() });
        localaiun = this.jdField_a_of_type_Aiun;
        if (localaiun != null) {
          localaiun.lm(paramaitg);
        }
        if ((!paramBoolean) || (aiuq.g(this.app, paramb.getSessionType(), paramb.xc()))) {
          break label161;
        }
        i = j;
        label128:
        paramb = this.Up;
        if (paramb != null) {
          if (i == 0) {
            break label167;
          }
        }
      }
    }
    label161:
    label167:
    for (paramaitg = (CharSequence)"正在发起...";; paramaitg = (CharSequence)"正在加入...")
    {
      paramb.setText(paramaitg);
      return;
      i = 0;
      break;
      i = 0;
      break label128;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetView
 * JD-Core Version:    0.7.0.1
 */