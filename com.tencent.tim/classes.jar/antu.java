import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class antu
  extends anqv
{
  public static ArrayList<AdExposureChecker> AT = new ArrayList();
  public static AdExposureChecker.ExposureCallback a;
  private static final int aoz = Color.parseColor("#C7C7C7");
  private int bAr;
  private int dwW;
  
  private void C(RelativeLayout paramRelativeLayout)
  {
    int i = paramRelativeLayout.getPaddingTop();
    int j = paramRelativeLayout.getPaddingBottom();
    paramRelativeLayout.setBackgroundResource(2130838396);
    paramRelativeLayout.setPadding(this.bAr, i, this.dwW, j);
  }
  
  @NotNull
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aqnm.dip2px(2.0F));
    localGradientDrawable.setStroke(aqnm.dpToPx(0.25F), aoz);
    return localGradientDrawable;
  }
  
  @NotNull
  private ImageView a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(2131375500);
    int i = aqnm.dpToPx(50.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i * 16 / 9, i);
    localLayoutParams.addRule(15);
    localImageView.setImageDrawable(paramContext.getResources().getDrawable(2130848223));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramRelativeLayout.addView(localImageView, localLayoutParams);
    return localImageView;
  }
  
  @NotNull
  private LinearLayout a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setId(2131375501);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(8, 2131375500);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
    return paramContext;
  }
  
  @NotNull
  private TextView a(Context paramContext, CharSequence paramCharSequence)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131375502);
    paramContext.setText(paramCharSequence);
    paramContext.setTextColor(aoz);
    paramContext.setTextSize(1, 10.0F);
    paramContext.setBackgroundDrawable(a());
    paramContext.setPadding(aqnm.dpToPx(0.8F), 0, 0, aqnm.dpToPx(0.8F));
    return paramContext;
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, int paramInt)
  {
    if (paramInt == 12) {
      paramLinearLayout.addView(a(paramContext, paramContext.getResources().getText(2131717569)));
    }
    paramContext = a(paramContext, paramContext.getResources().getText(2131717568));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = aqnm.dpToPx(2.0F);
    paramLinearLayout.addView(paramContext, localLayoutParams);
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    if ((paramContext instanceof BaseActivity)) {}
    for (zyd localzyd = (zyd)((BaseActivity)paramContext).app.getManager(341);; localzyd = null)
    {
      Object localObject = new AdExposureChecker(null, new WeakReference(paramRelativeLayout));
      if ((localzyd != null) && (localzyd.a() != null) && (localzyd.a().getImageData() != null))
      {
        GdtAd localGdtAd = localzyd.a();
        int i = localGdtAd.getProductType();
        tgg localtgg = localGdtAd.getImageData();
        ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
        if ((localtgg.width != 0) && (localtgg.height != 0)) {
          localLayoutParams.width = ((int)(Math.min(Math.max(localtgg.width * 1.0F / localtgg.height, 1.0F), 1.777778F) * localLayoutParams.height));
        }
        localObject = paramContext.getResources().getDrawable(2130848223);
        if (localtgg.width == localtgg.height) {
          localObject = paramContext.getResources().getDrawable(2130848222);
        }
        paramImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(localtgg.url, (Drawable)localObject, (Drawable)localObject));
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager_StructMsgItemLayout31", 2, "adInfo:,text:" + localGdtAd.getText() + ",url:" + localtgg.url + ",width:" + localtgg.width + ",height:" + localtgg.height + ",paramsWidth:" + localLayoutParams.width + ",paramsHeight:" + localLayoutParams.height + ",productType:" + i);
        }
        paramImageView.requestLayout();
        paramTextView.setText(localGdtAd.getText());
        a(paramContext, paramLinearLayout, i);
        paramImageView = new AdExposureChecker(localGdtAd, new WeakReference(paramRelativeLayout));
        if (a == null) {
          a = new antv(this, localzyd, paramContext, localGdtAd);
        }
        paramImageView.setCallback(new WeakReference(a));
        paramRelativeLayout.setOnClickListener(new antw(this, localGdtAd, paramContext, localzyd));
        if (QLog.isColorLevel()) {
          QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "updateAdInfo....startCheck view:" + this);
        }
      }
      for (paramContext = paramImageView;; paramContext = (Context)localObject)
      {
        paramContext.startCheck();
        AT.add(paramContext);
        if (QLog.isColorLevel()) {
          QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "updateAdInfo....adExposureCheckers size:" + AT.size());
        }
        return;
        paramRelativeLayout.setOnClickListener(new antx(this, paramContext));
      }
    }
  }
  
  @NotNull
  private TextView b(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setId(2131375498);
    localTextView.setText(paramContext.getResources().getText(2131717540));
    localTextView.setSingleLine(false);
    localTextView.setMaxLines(2);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131375500);
    localLayoutParams.addRule(0, 2131375501);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(aqnm.dip2px(12.0F), 0, aqnm.dip2px(12.0F), 0);
    paramRelativeLayout.addView(localTextView, localLayoutParams);
    c(paramContext, localTextView);
    return localTextView;
  }
  
  private void c(Context paramContext, TextView paramTextView)
  {
    TextPaint localTextPaint;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (aaai)((BaseActivity)paramContext).app.getManager(245);
      localTextPaint = paramTextView.getPaint();
      if (paramContext.a("common", 0, new String[] { "pub_ad_control", "gdt_content_bold" }) != 1) {
        break label143;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localTextPaint.setFakeBoldText(bool);
      paramTextView.setTextSize(1, Math.min(Math.max(paramContext.a("common", 24, new String[] { "pub_ad_control", "gdt_content_size" }), 24), 36) >> 1);
      try
      {
        paramTextView.setTextColor(Color.parseColor(paramContext.a("common", "#000000", new String[] { "pub_ad_control", "gdt_content_color" })));
        return;
      }
      catch (Throwable paramContext)
      {
        label143:
        QLog.e("QWalletGdtAdManager_StructMsgItemLayout31", 1, paramContext, new Object[0]);
        paramTextView.setTextColor(Color.parseColor("#000000"));
      }
    }
  }
  
  private RelativeLayout e(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aqnm.dpToPx(74.0F));
    paramContext.setPadding(this.bAr, 0, this.dwW, 0);
    paramContext.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager_StructMsgItemLayout31", 2, "getItemRootView...left:" + this.bAr + ",right:" + this.dwW + ",top:" + 0 + ",bottom:" + 0);
    }
    return paramContext;
  }
  
  protected int IX()
  {
    return 31;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        if (!paramBundle.getBoolean("isShowQWalletPubAd")) {
          return new View(paramContext);
        }
        this.bAr = (paramContext.getResources().getDimensionPixelSize(2131299517) - aqnm.dip2px(3.0F));
        this.dwW = (paramContext.getResources().getDimensionPixelSize(2131299518) - aqnm.dip2px(3.0F));
        if ((paramView instanceof RelativeLayout))
        {
          paramView = (RelativeLayout)paramView;
          paramView.removeAllViews();
          C(paramView);
          a(paramContext, paramView, a(paramContext, paramView), a(paramContext, paramView), b(paramContext, paramView));
          return paramView;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("QWalletGdtAdManager_StructMsgItemLayout31", 1, paramContext, new Object[0]);
        return null;
      }
      paramView = e(paramContext);
    }
  }
  
  public String getName()
  {
    return "Layout31";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antu
 * JD-Core Version:    0.7.0.1
 */