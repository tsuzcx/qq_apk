import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideoRefreshMenuUIUtils;", "", "()V", "drawAdTag", "", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter$ADVideoItemHolder;", "listener", "Landroid/view/View$OnClickListener;", "isTiktokStyle", "", "clickableSpan", "Landroid/text/style/ClickableSpan;", "fillDpaTags", "activity", "Landroid/app/Activity;", "fillDpaUIData", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "drawable", "Landroid/graphics/drawable/Drawable;", "fillUIData", "fillUIDataForAllAdType", "fillUIDataForAllAdTypeWithBusiType", "fillUIDataForTypeNewVideo", "fillUIDataForTypeVideo", "getExtraJson", "Lorg/json/JSONObject;", "setIcon", "imageView", "Landroid/widget/ImageView;", "width", "", "radius", "mDefaultFaceDrawable", "setRealClickListener", "view", "Landroid/view/View;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tpj
{
  public static final tpj a = new tpj();
  
  private final JSONObject a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.v;
        if (paramVideoInfo != null) {
          return new JSONObject(paramVideoInfo);
        }
      }
    }
    return null;
  }
  
  private final void a(View paramView, rog paramrog, View.OnClickListener paramOnClickListener)
  {
    if (paramView != null) {
      paramView.setTag(paramrog);
    }
    if (paramView != null) {
      paramView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private final void b(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, rog paramrog, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    int j = 0;
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      return;
    }
    label56:
    label79:
    label102:
    int i;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.l;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setVisibility(0);
        }
      }
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.l;
        a((View)paramQQAppInterface, paramrog, paramOnClickListener);
        if (paramrog == null) {
          break label397;
        }
        paramQQAppInterface = paramrog.jdField_a_of_type_AndroidWidgetLinearLayout;
        a((View)paramQQAppInterface, paramrog, paramOnClickListener);
      }
    }
    else
    {
      if (paramrog == null) {
        break label402;
      }
      paramQQAppInterface = paramrog.jdField_a_of_type_AndroidWidgetRelativeLayout;
      a((View)paramQQAppInterface, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.jdField_c_of_type_AndroidWidgetTextView;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramContext.getResources();
          if (paramDrawable == null) {
            break label407;
          }
          paramDrawable = paramDrawable.getDisplayMetrics();
          if (paramDrawable == null) {
            break label407;
          }
          i = MathKt.roundToInt(paramDrawable.widthPixels * 0.7D);
          label161:
          paramQQAppInterface.setMaxWidth(i);
        }
      }
      if (paramVideoInfo == null) {
        break label413;
      }
      paramQQAppInterface = paramVideoInfo.c;
      if (paramQQAppInterface == null) {
        break label413;
      }
      label182:
      if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
        break label440;
      }
      paramQQAppInterface = paramContext.getResources();
      if (paramQQAppInterface == null) {
        break label419;
      }
      paramQQAppInterface = paramQQAppInterface.getText(2131717340);
      if (paramQQAppInterface == null) {
        break label419;
      }
      paramQQAppInterface = paramQQAppInterface.toString();
      if (paramQQAppInterface == null) {
        break label419;
      }
    }
    label397:
    label402:
    label407:
    label413:
    label419:
    label431:
    label437:
    label438:
    label440:
    for (;;)
    {
      label221:
      if (paramrog != null)
      {
        paramDrawable = paramrog.jdField_b_of_type_AndroidWidgetTextView;
        if (paramDrawable != null) {
          paramDrawable.setText((CharSequence)paramQQAppInterface);
        }
      }
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.jdField_b_of_type_AndroidWidgetTextView;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramContext.getResources();
          i = j;
          if (paramDrawable != null)
          {
            paramDrawable = paramDrawable.getDisplayMetrics();
            i = j;
            if (paramDrawable != null) {
              i = MathKt.roundToInt(paramDrawable.widthPixels * 0.224D);
            }
          }
          paramQQAppInterface.setMaxWidth(i);
        }
      }
      if (paramVideoInfo != null)
      {
        paramQQAppInterface = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.l;
          if (paramQQAppInterface != null)
          {
            label329:
            if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
              break label437;
            }
            paramQQAppInterface = paramContext.getResources();
            if (paramQQAppInterface == null) {
              break label431;
            }
            paramQQAppInterface = paramQQAppInterface.getText(2131717339);
            if (paramQQAppInterface == null) {
              break label431;
            }
            paramQQAppInterface = paramQQAppInterface.toString();
            if (paramQQAppInterface == null) {
              break label431;
            }
          }
        }
      }
      for (;;)
      {
        if (paramrog == null) {
          break label438;
        }
        paramContext = paramrog.jdField_b_of_type_AndroidWidgetTextView;
        if (paramContext == null) {
          break;
        }
        paramContext.setText((CharSequence)paramQQAppInterface);
        return;
        paramQQAppInterface = null;
        break label56;
        paramQQAppInterface = null;
        break label79;
        paramQQAppInterface = null;
        break label102;
        i = 0;
        break label161;
        paramQQAppInterface = "";
        break label182;
        paramQQAppInterface = "";
        break label221;
        paramQQAppInterface = "";
        break label329;
        paramQQAppInterface = "";
      }
      break;
    }
  }
  
  private final void c(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, rog paramrog, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      return;
    }
    boolean bool = tqa.a(paramVideoInfo);
    Object localObject2;
    label221:
    float f;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      if (paramrog != null)
      {
        localObject1 = paramrog.l;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(8);
        }
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_a_of_type_AndroidWidgetTextView;
        a((View)localObject1, paramrog, paramOnClickListener);
      }
    }
    else
    {
      localObject1 = a(paramVideoInfo);
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((JSONObject)localObject1).has("down_time") == true) {
          i = ((JSONObject)localObject1).optInt("down_time") * 1000;
        }
      }
      if ((i > 0) && (paramrog != null))
      {
        localObject1 = paramrog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView;
        if (localObject1 != null) {
          ((CircleCountdownView)localObject1).setDuration(i);
        }
      }
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(6.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#FF00CAFC"));
      if (Build.VERSION.SDK_INT < 16) {
        break label1116;
      }
      if (paramrog != null)
      {
        localObject2 = paramrog.k;
        if (localObject2 != null) {
          ((TextView)localObject2).setBackground((Drawable)localObject1);
        }
      }
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(2.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#12B7F6"));
      if (Build.VERSION.SDK_INT < 16) {
        break label1146;
      }
      if (paramrog != null)
      {
        localObject2 = paramrog.h;
        if (localObject2 != null) {
          ((View)localObject2).setBackground((Drawable)localObject1);
        }
      }
      label278:
      if (!paramBoolean) {
        break label1176;
      }
      f = Utils.dp2px(10.0D);
      label292:
      ((GradientDrawable)localObject1).setCornerRadius(f);
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFFFFF"));
      if (Build.VERSION.SDK_INT < 16) {
        break label1188;
      }
      if (paramrog != null)
      {
        localObject2 = paramrog.jdField_n_of_type_AndroidViewView;
        if (localObject2 != null) {
          ((View)localObject2).setBackground((Drawable)localObject1);
        }
      }
      label345:
      if (bool) {}
      j = 2;
      i = j;
      if (bool)
      {
        i = j;
        if (paramBoolean) {
          i = 12;
        }
      }
      if (paramrog == null) {
        break label1218;
      }
      localObject1 = paramrog.jdField_e_of_type_AndroidWidgetImageView;
      label387:
      a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramrog, 60, i, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramrog == null) {
        break label1224;
      }
      localObject1 = paramrog.jdField_d_of_type_AndroidWidgetImageView;
      label419:
      a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramrog, 70, 11, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_i_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (paramrog == null) {
        break label1230;
      }
      localObject1 = paramrog.jdField_j_of_type_AndroidViewView;
      label475:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_m_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (paramrog == null) {
        break label1236;
      }
      localObject1 = paramrog.jdField_m_of_type_AndroidViewView;
      label521:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_m_of_type_AndroidViewView;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getParent();
          if (localObject1 != null) {
            ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
          }
        }
      }
      if (paramrog == null) {
        break label1242;
      }
      localObject1 = paramrog.jdField_o_of_type_AndroidViewView;
      label580:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog == null) {
        break label1248;
      }
      localObject1 = paramrog.k;
      label602:
      a((View)localObject1, paramrog, paramOnClickListener);
      tph.a(paramContext, paramrog);
      if (paramrog != null)
      {
        localObject2 = paramrog.jdField_i_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          if (paramVideoInfo == null) {
            break label1254;
          }
          localObject1 = paramVideoInfo.k;
          if (localObject1 == null) {
            break label1254;
          }
          localObject1 = (CharSequence)localObject1;
          label662:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramrog == null) {
        break label1264;
      }
      localObject1 = paramrog.jdField_i_of_type_AndroidWidgetTextView;
      label681:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        localObject2 = paramrog.jdField_j_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          if (paramVideoInfo == null) {
            break label1270;
          }
          localObject1 = paramVideoInfo.c;
          if (localObject1 == null) {
            break label1270;
          }
          localObject1 = (CharSequence)localObject1;
          label735:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramrog == null) {
        break label1280;
      }
      localObject1 = paramrog.jdField_j_of_type_AndroidWidgetTextView;
      label754:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_b_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
      }
      if (paramrog == null) {
        break label1286;
      }
      localObject1 = paramrog.jdField_e_of_type_AndroidViewView;
      label826:
      if ((localObject1 != null) && (paramrog != null))
      {
        localObject1 = paramrog.jdField_e_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(null);
        }
      }
      if (paramrog != null)
      {
        localObject2 = paramrog.jdField_f_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          if (paramVideoInfo == null) {
            break label1292;
          }
          localObject1 = paramVideoInfo.k;
          if (localObject1 == null) {
            break label1292;
          }
          localObject1 = (CharSequence)localObject1;
          label895:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramrog == null) {
        break label1302;
      }
      localObject1 = paramrog.jdField_f_of_type_AndroidWidgetTextView;
      label914:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_g_of_type_AndroidWidgetTextView;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setText((CharSequence)anzj.a(2131714931));
          i = agej.a(12.0F, paramContext.getResources());
          localObject2 = paramContext.getResources().getDrawable(2130843063);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
      }
      if (paramrog == null) {
        break label1308;
      }
      localObject1 = paramrog.jdField_g_of_type_AndroidViewView;
      label1015:
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog == null) {
        break label1314;
      }
    }
    label1176:
    label1308:
    label1314:
    for (Object localObject1 = paramrog.h;; localObject1 = null)
    {
      a((View)localObject1, paramrog, paramOnClickListener);
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_d_of_type_AndroidWidgetRelativeLayout;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_c_of_type_AndroidWidgetLinearLayout;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
      }
      d(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramrog, paramOnClickListener, paramBoolean);
      return;
      localObject1 = null;
      break;
      label1116:
      if (paramrog == null) {
        break label221;
      }
      localObject2 = paramrog.k;
      if (localObject2 == null) {
        break label221;
      }
      ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      break label221;
      label1146:
      if (paramrog == null) {
        break label278;
      }
      localObject2 = paramrog.h;
      if (localObject2 == null) {
        break label278;
      }
      ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
      break label278;
      f = Utils.dp2px(6.0D);
      break label292;
      label1188:
      if (paramrog == null) {
        break label345;
      }
      localObject2 = paramrog.jdField_n_of_type_AndroidViewView;
      if (localObject2 == null) {
        break label345;
      }
      ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
      break label345;
      label1218:
      localObject1 = null;
      break label387;
      label1224:
      localObject1 = null;
      break label419;
      label1230:
      localObject1 = null;
      break label475;
      label1236:
      localObject1 = null;
      break label521;
      label1242:
      localObject1 = null;
      break label580;
      label1248:
      localObject1 = null;
      break label602;
      label1254:
      localObject1 = (CharSequence)"";
      break label662;
      label1264:
      localObject1 = null;
      break label681;
      label1270:
      localObject1 = (CharSequence)"";
      break label735;
      localObject1 = null;
      break label754;
      localObject1 = null;
      break label826;
      localObject1 = (CharSequence)"";
      break label895;
      localObject1 = null;
      break label914;
      localObject1 = null;
      break label1015;
    }
  }
  
  private final void d(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, rog paramrog, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!tqa.a(paramVideoInfo))) {}
    Object localObject1;
    VideoAdInfo localVideoAdInfo;
    do
    {
      do
      {
        return;
        if (paramrog != null)
        {
          localObject1 = paramrog.jdField_d_of_type_AndroidWidgetRelativeLayout;
          if (localObject1 != null) {
            ((RelativeLayout)localObject1).setVisibility(0);
          }
        }
        if (paramrog != null)
        {
          localObject1 = paramrog.jdField_c_of_type_AndroidWidgetLinearLayout;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setVisibility(8);
          }
        }
      } while (paramVideoInfo == null);
      localVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    } while (localVideoAdInfo == null);
    if (paramrog != null)
    {
      localObject2 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = localVideoAdInfo.G;
        if (localObject1 == null) {
          break label702;
        }
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
    }
    Object localObject2 = a;
    label141:
    label237:
    label497:
    int i;
    if (paramrog != null)
    {
      localObject1 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
      ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
      if (!paramBoolean) {
        break label724;
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextSize(18.0F);
        }
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#FF6404"));
        }
      }
      if (paramrog == null) {
        break label718;
      }
      localObject1 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        break label718;
      }
      localObject1 = ((TextView)localObject1).getLayoutParams();
      localObject2 = localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject2;
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = agej.a(10.0F, paramContext.getResources());
      }
      if (paramrog != null)
      {
        localObject2 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
        if (localObject2 != null) {
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      label306:
      if (!TextUtils.isEmpty((CharSequence)localVideoAdInfo.H)) {
        break label752;
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_n_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localVideoAdInfo.F))
      {
        if (paramrog != null)
        {
          localObject1 = paramrog.p;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.F);
          }
        }
        localObject2 = a;
        if (paramrog == null) {
          break label845;
        }
        localObject1 = paramrog.p;
        label405:
        ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
        if (paramrog != null)
        {
          localObject1 = paramrog.jdField_m_of_type_AndroidWidgetTextView;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.F);
          }
        }
        localObject2 = a;
        if (paramrog == null) {
          break label851;
        }
        localObject1 = paramrog.jdField_m_of_type_AndroidWidgetTextView;
        label466:
        ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
      }
      localObject2 = a;
      if (paramrog == null) {
        break label857;
      }
      localObject1 = paramrog.q;
      ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
      localObject2 = a;
      if (paramrog == null) {
        break label863;
      }
      localObject1 = paramrog.jdField_f_of_type_AndroidWidgetImageView;
      label528:
      ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
      localObject2 = a;
      if (paramrog == null) {
        break label869;
      }
      localObject1 = paramrog.jdField_e_of_type_AndroidWidgetRelativeLayout;
      label559:
      ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
      if (!paramBoolean) {
        break label875;
      }
      i = 5;
      label581:
      localObject2 = a;
      if (paramrog == null) {
        break label882;
      }
      localObject1 = paramrog.jdField_f_of_type_AndroidWidgetImageView;
      label598:
      ((tpj)localObject2).a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramrog, 32, i, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramBoolean)
      {
        if (paramrog == null) {
          break label888;
        }
        paramQQAppInterface = paramrog.jdField_d_of_type_AndroidWidgetRelativeLayout;
        if (paramQQAppInterface == null) {
          break label888;
        }
      }
    }
    label702:
    label718:
    label724:
    label752:
    label882:
    label888:
    for (paramQQAppInterface = paramQQAppInterface.getLayoutParams();; paramQQAppInterface = null)
    {
      paramDrawable = paramQQAppInterface;
      if (!(paramQQAppInterface instanceof LinearLayout.LayoutParams)) {
        paramDrawable = null;
      }
      paramQQAppInterface = (LinearLayout.LayoutParams)paramDrawable;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.leftMargin = agej.a(10.0F, paramContext.getResources());
      }
      if (paramrog != null)
      {
        paramContext = paramrog.jdField_d_of_type_AndroidWidgetRelativeLayout;
        if (paramContext != null) {
          paramContext.setLayoutParams((ViewGroup.LayoutParams)paramQQAppInterface);
        }
      }
      return;
      localObject1 = (CharSequence)"";
      break;
      localObject1 = null;
      break label141;
      localObject1 = null;
      break label237;
      if (paramrog == null) {
        break label306;
      }
      localObject1 = paramrog.jdField_o_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        break label306;
      }
      ((TextView)localObject1).setTextSize(15.0F);
      break label306;
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_n_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
      }
      if (paramrog != null)
      {
        localObject1 = paramrog.jdField_n_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.H);
        }
      }
      localObject2 = a;
      if (paramrog != null) {}
      for (localObject1 = paramrog.jdField_n_of_type_AndroidWidgetTextView;; localObject1 = null)
      {
        ((tpj)localObject2).a((View)localObject1, paramrog, paramOnClickListener);
        break;
      }
      localObject1 = null;
      break label405;
      localObject1 = null;
      break label466;
      localObject1 = null;
      break label497;
      localObject1 = null;
      break label528;
      localObject1 = null;
      break label559;
      i = 6;
      break label581;
      localObject1 = null;
      break label598;
    }
  }
  
  private final void e(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, rog paramrog, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    RelativeLayout localRelativeLayout;
    label138:
    if (paramrog != null)
    {
      localRelativeLayout = paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout;
      a((View)localRelativeLayout, paramrog, paramOnClickListener);
      if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
        break label233;
      }
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.l;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setVisibility(8);
        }
      }
      label68:
      if (paramBoolean)
      {
        if (paramrog != null)
        {
          paramQQAppInterface = paramrog.l;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setVisibility(0);
          }
        }
        if (paramrog == null) {
          break label251;
        }
        paramQQAppInterface = paramrog.l;
        label104:
        a((View)paramQQAppInterface, paramrog, paramOnClickListener);
        if (paramrog == null) {
          break label256;
        }
        paramQQAppInterface = paramrog.jdField_a_of_type_Rlm;
        if (paramQQAppInterface == null) {
          break label256;
        }
        paramQQAppInterface = paramQQAppInterface.a();
        a(paramQQAppInterface, paramrog, paramOnClickListener);
        if (paramrog == null) {
          break label261;
        }
        paramQQAppInterface = paramrog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
        if (paramQQAppInterface == null) {
          break label261;
        }
      }
    }
    label256:
    label261:
    for (paramQQAppInterface = paramQQAppInterface.getLayoutParams();; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)paramQQAppInterface).leftMargin = agej.a(15.0F, paramContext.getResources());
      }
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.jdField_c_of_type_AndroidWidgetTextView;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setTextSize(14.0F);
        }
      }
      tqa.a(paramVideoInfo, paramrog);
      tph.a(false, paramrog);
      return;
      localRelativeLayout = null;
      break;
      label233:
      f(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramrog, paramOnClickListener, paramBoolean);
      break label68;
      label251:
      paramQQAppInterface = null;
      break label104;
      paramQQAppInterface = null;
      break label138;
    }
  }
  
  private final void f(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, rog paramrog, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramrog != null)
    {
      paramQQAppInterface = paramrog.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setImagePlaceHolder(paramDrawable);
      }
    }
    if (paramrog != null)
    {
      paramContext = paramrog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
      if (paramContext != null)
      {
        if (paramVideoInfo == null) {
          break label172;
        }
        paramQQAppInterface = paramVideoInfo.k;
        if (paramQQAppInterface == null) {
          break label172;
        }
        paramQQAppInterface = (CharSequence)paramQQAppInterface;
        paramContext.setText(paramQQAppInterface);
      }
    }
    label72:
    label95:
    long l;
    if (paramrog != null)
    {
      paramQQAppInterface = paramrog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
      a((View)paramQQAppInterface, paramrog, paramOnClickListener);
      if (paramVideoInfo == null) {
        break label186;
      }
      paramQQAppInterface = paramVideoInfo.j;
      if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
        break label197;
      }
      if (paramrog != null)
      {
        paramQQAppInterface = paramrog.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
        if (paramQQAppInterface != null)
        {
          if (paramVideoInfo == null) {
            break label191;
          }
          paramContext = paramVideoInfo.j;
          if (paramContext == null) {
            break label191;
          }
          l = Long.parseLong(paramContext);
          label141:
          paramQQAppInterface.setHeadImgByUin(l, false);
        }
      }
      label148:
      if (paramrog == null) {
        break label262;
      }
    }
    label257:
    label262:
    for (paramQQAppInterface = paramrog.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;; paramQQAppInterface = null)
    {
      a((View)paramQQAppInterface, paramrog, paramOnClickListener);
      return;
      label172:
      paramQQAppInterface = (CharSequence)"";
      break;
      paramQQAppInterface = null;
      break label72;
      label186:
      paramQQAppInterface = null;
      break label95;
      label191:
      l = 0L;
      break label141;
      label197:
      if (paramVideoInfo != null)
      {
        paramQQAppInterface = paramVideoInfo.p;
        label208:
        if ((TextUtils.isEmpty((CharSequence)paramQQAppInterface)) || (paramrog == null)) {
          break label255;
        }
        paramContext = paramrog.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
        if (paramContext == null) {
          break label148;
        }
        if (paramVideoInfo == null) {
          break label257;
        }
      }
      for (paramQQAppInterface = paramVideoInfo.p;; paramQQAppInterface = null)
      {
        paramContext.setImageSrc(paramQQAppInterface);
        break;
        paramQQAppInterface = null;
        break label208;
        label255:
        break;
      }
    }
  }
  
  public final void a(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, @Nullable rog paramrog, @Nullable View.OnClickListener paramOnClickListener)
  {
    if ((paramActivity != null) && (paramVideoInfo != null))
    {
      if (paramrog == null) {
        break label24;
      }
      localObject1 = paramrog.jdField_d_of_type_AndroidWidgetLinearLayout;
      if (localObject1 != null) {
        break label30;
      }
    }
    label24:
    label30:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      } while (localObject1 == null);
      localObject1 = ((VideoAdInfo)localObject1).h;
    } while (localObject1 == null);
    paramrog.jdField_d_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject2 = paramrog.jdField_n_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "videoHolder.dpaReducedTab");
    int j = ((TextView)localObject2).getWidth();
    localObject2 = (Iterable)localObject1;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label167:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label167;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    int i = j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = tpi.a((Context)paramActivity, paramVideoInfo, (String)localObject2);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(paramOnClickListener);
      }
      j = ozs.a(paramActivity)[0];
      int k = agej.a(125.0F, paramActivity.getResources());
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "dpaTagTextView");
      int m = (int)((TextView)localObject3).getPaint().measureText((String)localObject2);
      if (i + m >= j - k) {
        break label314;
      }
      paramrog.jdField_d_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
      i = m + 6 + i;
    }
    label314:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public final void a(@NotNull Context paramContext, @Nullable VideoInfo paramVideoInfo, @Nullable rog paramrog, @Nullable View.OnClickListener paramOnClickListener, boolean paramBoolean, @NotNull ClickableSpan paramClickableSpan)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClickableSpan, "clickableSpan");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramVideoInfo != null)
    {
      localObject = paramVideoInfo.c;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localSpannableStringBuilder.append((CharSequence)ozs.a((String)localObject, 72));
          localSpannableStringBuilder.append((CharSequence)"  ");
        }
        anzj.a(2131715015);
        paramVideoInfo = a(paramVideoInfo);
        if (paramVideoInfo == null) {
          break label130;
        }
      }
    }
    label130:
    for (paramVideoInfo = paramVideoInfo.optString("AdsIconText");; paramVideoInfo = null)
    {
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo)) {
        break label135;
      }
      tpx.a("Q.pubaccount.video.feeds.VideoFeedsAdapter", "detail ad  video in new style adsIconText: null");
      return;
      localObject = "";
      break;
    }
    label135:
    Object localObject = new Paint();
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    ((Paint)localObject).setTextSize(agej.a(10.0F, paramContext.getResources()));
    ((Paint)localObject).setColor((int)3003121663L);
    float f = ((Paint)localObject).measureText(paramVideoInfo);
    int i;
    label200:
    Bitmap localBitmap;
    Canvas localCanvas;
    if (paramBoolean)
    {
      i = 10;
      int j = agej.a(i, paramContext.getResources());
      j = (int)f + j;
      int k = agej.a(1.0F, paramContext.getResources()) / 2;
      int m = agej.a(14.0F, paramContext.getResources());
      localBitmap = Bitmap.createBitmap(j, m, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localCanvas.drawText(paramVideoInfo, agej.a(i / 2.0F, paramContext.getResources()), m / 2 - (((Paint)localObject).descent() + ((Paint)localObject).ascent()) / 2, (Paint)localObject);
      paramVideoInfo = new RectF(0.0F, k, j, m - k);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setStrokeWidth(0.5F);
      if (!paramBoolean) {
        break label488;
      }
      localCanvas.drawRoundRect(paramVideoInfo, 19.0F, 19.0F, (Paint)localObject);
    }
    for (;;)
    {
      localSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(paramContext, localBitmap), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.setSpan(paramClickableSpan, localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
      if (paramrog == null) {
        break;
      }
      paramVideoInfo = paramrog.jdField_c_of_type_AndroidWidgetTextView;
      if (paramVideoInfo == null) {
        break;
      }
      paramVideoInfo.setPadding(paramVideoInfo.getPaddingLeft(), paramVideoInfo.getPaddingTop(), paramVideoInfo.getPaddingRight(), agej.a(1.0F, paramContext.getResources()));
      paramVideoInfo.setMovementMethod(LinkMovementMethod.getInstance());
      paramVideoInfo.setText((CharSequence)localSpannableStringBuilder);
      a.a((View)paramVideoInfo, paramrog, paramOnClickListener);
      return;
      i = 6;
      break label200;
      label488:
      localCanvas.drawRoundRect(paramVideoInfo, 2.0F, 2.0F, (Paint)localObject);
    }
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @Nullable Drawable paramDrawable, @Nullable VideoInfo paramVideoInfo, @Nullable rog paramrog, @Nullable View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      return;
    }
    Integer localInteger;
    if (paramrog != null)
    {
      localInteger = Integer.valueOf(paramrog.jdField_a_of_type_Int);
      if (localInteger != null) {
        break label66;
      }
      label29:
      c(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramrog, paramOnClickListener, paramBoolean);
    }
    for (;;)
    {
      e(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramrog, paramOnClickListener, paramBoolean);
      return;
      localInteger = null;
      break;
      label66:
      if (localInteger.intValue() != 4) {
        break label29;
      }
      b(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramrog, paramOnClickListener, paramBoolean);
    }
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable ImageView paramImageView, @Nullable VideoInfo paramVideoInfo, @Nullable rog paramrog, int paramInt1, int paramInt2, @Nullable View.OnClickListener paramOnClickListener, @Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramImageView == null) || (paramVideoInfo == null) || (paramrog == null)) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j))
    {
      paramImageView.setImageDrawable((Drawable)aoot.a((AppInterface)paramQQAppInterface, 1, paramVideoInfo.j, 1, paramDrawable, paramDrawable));
      return;
    }
    Context localContext = paramImageView.getContext();
    paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
    float f;
    boolean bool;
    if (paramQQAppInterface != null)
    {
      f = paramInt1;
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramQQAppInterface.mRequestWidth = agej.a(f, localContext.getResources());
      paramQQAppInterface.mRequestHeight = agej.a(paramInt1, localContext.getResources());
      paramQQAppInterface.mLoadingDrawable = paramDrawable;
      paramQQAppInterface.mFailedDrawable = paramDrawable;
      paramDrawable = paramQQAppInterface;
      bool = tqa.a(paramVideoInfo);
    }
    for (paramQQAppInterface = (URL)null;; paramQQAppInterface = localURL)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)paramVideoInfo.p))
          {
            localURL = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
            paramQQAppInterface = localURL;
            if (!bool) {
              continue;
            }
          }
        }
        catch (Exception paramVideoInfo)
        {
          URL localURL;
          continue;
          paramVideoInfo = null;
          continue;
          if (paramQQAppInterface == null) {
            continue;
          }
          paramQQAppInterface.setDecodeHandler(bhez.j);
          continue;
          continue;
        }
        try
        {
          paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
          if (paramVideoInfo == null) {
            continue;
          }
          paramVideoInfo = paramVideoInfo.E;
          if (TextUtils.isEmpty((CharSequence)paramVideoInfo)) {
            continue;
          }
          paramVideoInfo = new URL(paramVideoInfo);
          paramQQAppInterface = paramVideoInfo;
        }
        catch (Exception paramVideoInfo) {}
      }
      paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, paramDrawable);
      if (paramQQAppInterface != null)
      {
        f = paramInt1;
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        paramQQAppInterface.setTag(bhez.b(agej.a(f, localContext.getResources()), agej.a(paramInt1, localContext.getResources()), agej.a(paramInt2, localContext.getResources())));
      }
      if ((!bool) || (paramBoolean) || (paramrog.jdField_f_of_type_AndroidWidgetImageView == null) || (paramrog.jdField_f_of_type_AndroidWidgetImageView != paramImageView)) {
        break label394;
      }
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setTag(new int[] { 0, 0, paramInt2, 3 });
      }
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setDecodeHandler(bhez.k);
      }
      if (paramQQAppInterface != null) {
        paramImageView.setImageDrawable((Drawable)paramQQAppInterface);
      }
      a((View)paramImageView, paramrog, paramOnClickListener);
      return;
      paramDrawable = null;
      break;
      localURL = new URL(paramVideoInfo.p);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpj
 * JD-Core Version:    0.7.0.1
 */