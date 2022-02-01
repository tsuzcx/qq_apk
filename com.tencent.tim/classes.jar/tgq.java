import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.adbox.GdtAdBoxDialog.3;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class tgq
  extends ReportDialog
  implements tha
{
  protected GridLayout a;
  protected tgo a;
  protected tgy a;
  protected tgz a;
  protected Activity mActivity;
  protected View mContentView;
  
  public tgq(@NonNull Context paramContext)
  {
    super(paramContext, 2131756467);
    this.mActivity = ((Activity)paramContext);
  }
  
  private void initData()
  {
    this.jdField_a_of_type_Tgy = new tgy();
    this.jdField_a_of_type_Tgz = new tgz(this, this.jdField_a_of_type_Tgy);
    this.jdField_a_of_type_Tgz.onCreate();
  }
  
  private void initView()
  {
    Object localObject = getWindow();
    ((Window)localObject).setDimAmount(0.3F);
    localObject = (FrameLayout)((Window)localObject).getDecorView();
    this.mContentView = getLayoutInflater().inflate(2131559388, (ViewGroup)localObject, false);
    setContentView(this.mContentView);
    setOnDismissListener(new tgr(this));
    this.jdField_a_of_type_AndroidWidgetGridLayout = ((GridLayout)((FrameLayout)localObject).findViewById(2131368068));
    bCU();
    localObject = findViewById(2131381449);
    ((View)localObject).setOnClickListener(new tgs(this));
    ((View)localObject).setContentDescription(acfp.m(2131721059));
    setCanceledOnTouchOutside(false);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, LinearLayout paramLinearLayout)
  {
    Object localObject1 = this.jdField_a_of_type_Tgo.a().getAds();
    paramInt5 = paramInt7 * paramInt1 + paramInt8;
    if (paramInt5 >= ((List)localObject1).size()) {
      return;
    }
    localObject1 = (GdtAd)((List)localObject1).get(paramInt5);
    ImageView localImageView = (ImageView)paramLinearLayout.findViewById(2131368698);
    Object localObject2 = ((GdtAd)localObject1).info.display_info.basic_info.img.get();
    tkw.d("GdtAdBoxDialog", "bindView() i = [" + paramInt7 + "], j = [" + paramInt8 + "], url = [" + (String)localObject2 + "]");
    try
    {
      localImageView.setImageDrawable(MiniAppUtils.getIcon(localImageView.getContext(), (String)localObject2, true, 2130841971, 65));
      localObject2 = (TextView)paramLinearLayout.findViewById(2131372190);
      String str = ((GdtAd)localObject1).info.display_info.mini_program_name.get().trim();
      ((TextView)localObject2).setText(str);
      localImageView.setContentDescription(str);
      ((TextView)localObject2).setContentDescription(str);
      localObject2 = new GridLayout.LayoutParams();
      ((GridLayout.LayoutParams)localObject2).rowSpec = GridLayout.spec(paramInt7, 1, GridLayout.LEFT);
      ((GridLayout.LayoutParams)localObject2).columnSpec = GridLayout.spec(paramInt8, 1, GridLayout.TOP);
      ((GridLayout.LayoutParams)localObject2).width = paramInt4;
      ((GridLayout.LayoutParams)localObject2).rightMargin = paramInt6;
      ((GridLayout.LayoutParams)localObject2).bottomMargin = paramInt6;
      if (paramInt7 == 0) {
        ((GridLayout.LayoutParams)localObject2).topMargin = paramInt3;
      }
      if (paramInt8 % paramInt1 == 0) {
        ((GridLayout.LayoutParams)localObject2).leftMargin = paramInt2;
      }
      paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localImageView.setOnClickListener(new tgt(this));
      localImageView.setTag(2131367901, localObject1);
      localImageView.setTag(2131381958, localObject1);
      localImageView.setTag(2131381957, new tgu(this));
      localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new tgv(this, localImageView));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        tkw.e("GdtAdBoxDialog", "bad url params", localException);
      }
    }
  }
  
  public void a(tgo paramtgo)
  {
    this.jdField_a_of_type_Tgo = paramtgo;
  }
  
  protected void a(tgy paramtgy)
  {
    tkw.d("GdtAdBoxDialog", "bindData() called with: model = [" + paramtgy + "]");
    int i = this.jdField_a_of_type_Tgo.a().getAds().size();
    if (i == 0)
    {
      tkw.d("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
      this.mContentView.post(new GdtAdBoxDialog.3(this));
      return;
    }
    if (i > 9) {
      i = 9;
    }
    for (;;)
    {
      int m = (int)Math.ceil(i * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = tls.dp2px(23.0F, this.mActivity.getResources());
      int i1 = tls.dp2px(21.0F, this.mActivity.getResources());
      int i2 = tls.dp2px(5.0F, this.mActivity.getResources());
      int i3 = tls.dp2px(0.0F, this.mActivity.getResources());
      int i4 = tls.dp2px(65.0F, this.mActivity.getResources());
      int i5 = i4 + tls.dp2px(24.0F, this.mActivity.getResources());
      int i6 = tls.dp2px(22.0F, this.mActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramtgy = LayoutInflater.from(this.mActivity);
      int j = 0;
      if (j < m)
      {
        int k = 0;
        for (;;)
        {
          if ((k >= 3) || (3 * j + k >= i))
          {
            j += 1;
            break;
          }
          LinearLayout localLinearLayout = (LinearLayout)paramtgy.inflate(2131559382, null);
          a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramtgy = this.mContentView.getLayoutParams();
      paramtgy.width = (3 * (i4 + i6) + n + i2);
      paramtgy.height = ((i5 + i6) * m + i1 + i3);
      this.mContentView.setLayoutParams(paramtgy);
      return;
    }
  }
  
  public void b(tgy paramtgy)
  {
    a(paramtgy);
  }
  
  protected void bCU() {}
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Tgz.onBackEvent()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    initData();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Tgz.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Tgz.onPause();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    tkw.d("GdtAdBoxDialog", "onWindowFocusChanged() called with: hasFocus = [" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgq
 * JD-Core Version:    0.7.0.1
 */