import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.extendfriend.wiget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class afth
  extends RecyclerView.ViewHolder
{
  private TextView RF;
  private afth.a jdField_a_of_type_Afth$a;
  private afyv jdField_a_of_type_Afyv;
  
  public afth(View paramView, afth.a parama)
  {
    super(paramView);
    this.jdField_a_of_type_Afth$a = parama;
  }
  
  private void a(aftg paramaftg, int paramInt)
  {
    a(paramaftg, paramInt, "0X800A9B1");
    a(this.itemView.getContext(), paramaftg);
  }
  
  private void a(aftg paramaftg, int paramInt, String paramString)
  {
    if ((paramaftg != null) && (paramaftg.type != 0))
    {
      String str1 = paramaftg.title;
      String str2 = paramaftg.subTitle;
      long l = paramaftg.appId;
      anot.a(null, "dc00898", "", "", "qq_kuolie", paramString, 0, 0, paramInt + "", "", l + ";" + str1, str2);
    }
  }
  
  private void a(Context paramContext, aftg paramaftg)
  {
    if ((paramaftg == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("FeedBannerViewHolder", 2, "jumpUrl bannerTabItem or context null ");
      }
    }
    label196:
    do
    {
      do
      {
        String str;
        int i;
        do
        {
          do
          {
            do
            {
              return;
              str = paramaftg.jumpUrl;
              i = paramaftg.type;
              if (QLog.isColorLevel()) {
                QLog.d("FeedBannerViewHolder", 2, "parse banner jumpUrl " + str + ", type =" + i);
              }
              if (i != 0) {
                break;
              }
            } while (this.jdField_a_of_type_Afth$a == null);
            this.jdField_a_of_type_Afth$a.dca();
            return;
            if (i != 1) {
              break;
            }
            if (MiniAppLauncher.isMiniAppUrl(str))
            {
              MiniAppLauncher.startMiniApp(this.itemView.getContext(), str, 2065, null);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not scheme ");
          return;
          if (i != 2) {
            break label196;
          }
          if (!TextUtils.isEmpty(str)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FeedBannerViewHolder", 2, "web jumpUrl is null ");
        return;
        paramaftg = new Intent(paramContext, QQBrowserActivity.class);
        paramaftg.putExtra("url", str);
        paramContext.startActivity(paramaftg);
        return;
        if (i != 3) {
          break;
        }
        try
        {
          paramaftg = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
          paramaftg.setData(Uri.parse(str));
          paramContext.startActivity(paramaftg);
          paramContext = new Bundle();
          paramContext.putString("action", "click");
          paramContext.putString("page", "kuolie");
          paramContext.putString("module", "selfstudy");
          anxg.jdMethod_do(paramContext);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("FeedBannerViewHolder", 2, "click studyroom", paramContext);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
  }
  
  private void a(View paramView, aftg paramaftg, int paramInt1, int paramInt2)
  {
    int i = aqnm.dip2px(5.0F);
    ((RoundCorneredRelativeLayout)paramView).setRadius(i, i, i, i);
    Object localObject2 = (ImageView)paramView.findViewById(2131368698);
    TextView localTextView1 = (TextView)paramView.findViewById(2131379769);
    TextView localTextView2 = (TextView)paramView.findViewById(2131378902);
    if (!TextUtils.isEmpty(paramaftg.title)) {
      localTextView1.setText(paramaftg.title);
    }
    if (!TextUtils.isEmpty(paramaftg.subTitle)) {
      localTextView2.setText(paramaftg.subTitle);
    }
    Object localObject1 = (FeedBannerItemGradientLinearLayout)paramView.findViewById(2131368103);
    if (paramInt2 == 1)
    {
      i = 24;
      ((FeedBannerItemGradientLinearLayout)localObject1).aO(aqnm.dip2px(i), paramaftg.cUj, paramaftg.cUk);
      localObject1 = (FrameLayout)paramView.findViewById(2131368701);
      if (paramaftg.type != 0) {
        break label393;
      }
      ((ImageView)localObject2).setVisibility(8);
      this.RF = localTextView2;
      localObject2 = paramView.getContext().getResources().getDrawable(2130846013);
      ((Drawable)localObject2).setBounds(aqnm.dip2px(1.0F), 0, aqnm.dip2px(7.0F), aqnm.dip2px(6.0F));
      localTextView2.setCompoundDrawablePadding(aqnm.dip2px(3.0F));
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      if (paramInt2 != 2) {
        break label345;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).rightMargin = aqnm.dip2px(80.0F);
      label250:
      b((FrameLayout)localObject1, paramInt2);
      a(paramaftg);
    }
    for (;;)
    {
      localObject2 = (ImageView)paramView.findViewById(2131365479);
      Object localObject3 = Drawable.createFromPath(afwv.ed(paramInt2));
      if (localObject3 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
      paramView.setOnTouchListener(new aftj(this, paramView.findViewById(2131373555), (FrameLayout)localObject1, localTextView1, localTextView2, paramaftg, paramInt1));
      return;
      if (paramInt2 == 2)
      {
        i = 22;
        break;
      }
      i = 40;
      break;
      label345:
      if (paramInt2 != 1) {
        break label250;
      }
      localTextView1.setTextSize(25.0F);
      localTextView2.setTextSize(12.0F);
      localTextView2.setPadding(0, aqnm.dip2px(2.0F), 0, 0);
      paramView.findViewById(2131362994).setVisibility(0);
      break label250;
      label393:
      if (paramaftg.iconUrl != null)
      {
        try
        {
          localObject3 = new URL(paramaftg.iconUrl);
          ColorDrawable localColorDrawable1 = new ColorDrawable(0);
          ColorDrawable localColorDrawable2 = new ColorDrawable(0);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable1;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable2;
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions));
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (QLog.isColorLevel()) {
          QLog.e("FeedBannerViewHolder", 2, "setImageUrl error " + localMalformedURLException.toString());
        }
      }
    }
  }
  
  private void b(FrameLayout paramFrameLayout, int paramInt)
  {
    int j = 3;
    if (this.jdField_a_of_type_Afyv != null) {
      this.jdField_a_of_type_Afyv.onDestroy();
    }
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt == 1)
    {
      i = 4;
      this.jdField_a_of_type_Afyv = new afyv(i);
      if (this.jdField_a_of_type_Afyv.getRootView() != null)
      {
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (paramInt != 1) {
          break label129;
        }
        localLayoutParams.bottomMargin = aqnm.dip2px(20.0F);
        localLayoutParams.topMargin = aqnm.dip2px(16.0F);
        if (paramInt != 1) {
          break label166;
        }
      }
    }
    label129:
    label166:
    for (paramInt = j;; paramInt = 5)
    {
      localLayoutParams.gravity = paramInt;
      paramFrameLayout.addView(this.jdField_a_of_type_Afyv.getRootView(), localLayoutParams);
      return;
      if (paramInt <= 2)
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      if (paramInt <= 2) {}
      for (i = aqnm.dip2px(16.0F);; i = aqnm.dip2px(22.0F))
      {
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        break;
      }
    }
  }
  
  public void a(aftg paramaftg)
  {
    if ((this.RF != null) && (paramaftg.subTitle != null)) {
      this.RF.setText(paramaftg.subTitle);
    }
    if ((this.jdField_a_of_type_Afyv != null) && (paramaftg.wu != null)) {
      this.jdField_a_of_type_Afyv.setUinList(paramaftg.wu);
    }
  }
  
  public void a(afua paramafua, int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (((paramafua instanceof aftf)) && ((this.itemView instanceof TabLayout)))
    {
      localObject = (aftf)paramafua;
      paramafua = (TabLayout)this.itemView;
      paramafua.setPadding(paramafua.getPaddingLeft(), paramInt, paramafua.getPaddingRight(), paramafua.getPaddingBottom());
      localObject = ((aftf)localObject).wt;
      localLayoutParams = paramafua.getLayoutParams();
      i = ((ArrayList)localObject).size();
      if (i != 1) {
        break label129;
      }
      i = 122;
    }
    for (;;)
    {
      i = aqnm.dip2px(i);
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + paramInt);
      }
      paramafua.j().setMinimumHeight(i);
      paramafua.a(new afti(this, (ArrayList)localObject, aqnm.dip2px(120.0F), aqnm.dip2px(4.0F)));
      return;
      label129:
      if (i == 2) {
        i = 108;
      } else {
        i = 168;
      }
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Afyv != null) {
      this.jdField_a_of_type_Afyv.onDestroy();
    }
  }
  
  public static abstract interface a
  {
    public abstract void dca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afth
 * JD-Core Version:    0.7.0.1
 */