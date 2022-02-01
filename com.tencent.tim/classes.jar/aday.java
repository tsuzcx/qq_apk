import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.ar.ARLBSPOIDialog.1;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class aday
  extends ReportDialog
{
  View Ba;
  View Bb;
  View Bc;
  View Bd;
  TextView QA;
  TextView Qy;
  TextView Qz;
  adhf.a jdField_a_of_type_Adhf$a;
  private ARScanEntryView jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView;
  MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView;
  URLImageView aV;
  URLImageView aW;
  Activity activity;
  public boolean bKO;
  Context context;
  RelativeLayout el;
  Button fM;
  RelativeLayout jC;
  RelativeLayout jD;
  public ProgressBar u;
  int x;
  int y;
  ImageView yg;
  
  public aday(Activity paramActivity, MapView paramMapView, ARScanEntryView paramARScanEntryView)
  {
    super(paramActivity, 2131756467);
    this.activity = paramActivity;
    this.context = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView = paramARScanEntryView;
    initView();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView = paramMapView;
    paramMapView = getWindow();
    paramARScanEntryView = paramMapView.getAttributes();
    paramARScanEntryView.width = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramARScanEntryView.height = paramActivity.getResources().getDisplayMetrics().heightPixels;
    paramMapView.setAttributes(paramARScanEntryView);
    this.u.postDelayed(new ARLBSPOIDialog.1(this), 1500L);
  }
  
  private void a(adhf.a parama)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getParent() == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap() == null)) {
      return;
    }
    Object localObject1 = new RelativeLayout.LayoutParams(-1, wja.dp2px(210.0F, this.context.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131369255);
    this.jD.addView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView, (ViewGroup.LayoutParams)localObject1);
    this.Bd = getLayoutInflater().inflate(2131561231, null);
    localObject1 = (TextView)this.Bd.findViewById(2131373449);
    Object localObject3 = (TextView)this.Bd.findViewById(2131365982);
    Object localObject2 = (TextView)this.Bd.findViewById(2131373448);
    ((TextView)localObject1).setText(acfp.m(2131702858));
    if (parama.cFQ < 1000)
    {
      ((TextView)localObject3).setText(this.context.getString(2131700731, new Object[] { String.valueOf(parama.cFQ) }));
      localObject3 = new StringBuilder().append(parama.name).append("|");
      if (!TextUtils.isEmpty(parama.Tr)) {
        break label551;
      }
      localObject1 = "";
      label204:
      localObject1 = (String)localObject1;
      if (TextUtils.isEmpty(parama.name)) {
        break label559;
      }
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, parama.name.length(), 17);
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.Bd.setOnClickListener(new adba(this));
      localObject1 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap();
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.zoomTo(16.0F));
      parama = new LatLng(parama.latitude * 1.0D / 1000000.0D, parama.longitude * 1.0D / 1000000.0D);
      ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(parama));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.Bd)).position(parama));
      if ((this.activity != null) && (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView != null) && (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.bPv))
      {
        parama = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getMap().getProjection();
        if ((parama != null) && (((TencentMap)localObject1).getCameraPosition() != null))
        {
          localObject2 = parama.toScreenLocation(((TencentMap)localObject1).getCameraPosition().target);
          ((Point)localObject2).offset(0, wja.dp2px(60.0F, this.context.getResources()) * -1);
          ((TencentMap)localObject1).moveCamera(CameraUpdateFactory.newLatLng(parama.fromScreenLocation((Point)localObject2)));
        }
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.onResume();
      this.Bc.setVisibility(8);
      this.Bb.setVisibility(8);
      this.Ba.setVisibility(8);
      this.jD.setVisibility(0);
      return;
      float f = Math.round(parama.cFQ / 1000.0F * 100.0F) / 100.0F;
      ((TextView)localObject3).setText(this.context.getString(2131700729, new Object[] { String.valueOf(f) }));
      break;
      label551:
      localObject1 = parama.Tr;
      break label204;
      label559:
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
  }
  
  private void initView()
  {
    setContentView(2131561227);
    this.jC = ((RelativeLayout)findViewById(2131369255));
    this.aV = ((URLImageView)findViewById(2131373451));
    this.Qy = ((TextView)findViewById(2131373461));
    this.Qz = ((TextView)findViewById(2131379258));
    this.yg = ((ImageView)findViewById(2131366985));
    this.aW = ((URLImageView)findViewById(2131373611));
    this.QA = ((TextView)findViewById(2131373612));
    this.u = ((ProgressBar)findViewById(2131373668));
    this.fM = ((Button)findViewById(2131364687));
    this.fM.setOnClickListener(new adaz(this));
    this.el = ((RelativeLayout)findViewById(2131365396));
    this.Ba = findViewById(2131373453);
    this.Bb = findViewById(2131363695);
    this.Bc = findViewById(2131371120);
    this.jD = ((RelativeLayout)findViewById(2131371119));
    this.yg.setVisibility(8);
  }
  
  public void a(adhf.a parama, ArLBSActivity paramArLBSActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSPOIDialog", 2, "bindView");
    }
    this.jdField_a_of_type_Adhf$a = parama;
    this.bKO = true;
    this.u.setVisibility(8);
    Object localObject;
    if (!TextUtils.isEmpty(paramArLBSActivity.buh))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(140.0F, this.context.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(170.0F, this.context.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.context.getResources().getDrawable(2130851770);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.context.getResources().getDrawable(2130851770);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.buh, (URLDrawable.URLDrawableOptions)localObject);
      this.aW.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.logoUrl))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = wja.dp2px(31.0F, this.context.getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.context.getResources().getDrawable(2130851770);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.context.getResources().getDrawable(2130851770);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.logoUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.aV.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(paramArLBSActivity.bug))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.context.getResources().getDrawable(2130851770);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.context.getResources().getDrawable(2130851770);
      localObject = URLDrawable.getDrawable(paramArLBSActivity.bug, (URLDrawable.URLDrawableOptions)localObject);
      this.jC.setBackgroundDrawable((Drawable)localObject);
    }
    this.Qy.setText(paramArLBSActivity.activityName);
    if (!TextUtils.isEmpty(paramArLBSActivity.bui)) {
      this.QA.setText(paramArLBSActivity.bui);
    }
    this.Qz.setText(acfp.m(2131702859));
    a(parama);
  }
  
  public void cPD()
  {
    super.show();
    int i = getWindow().getAttributes().width;
    int j = getWindow().getAttributes().height;
    int k = (i - wja.dp2px(320.0F, this.context.getResources())) / 2;
    int m = (j - wja.dp2px(420.0F, this.context.getResources())) / 2;
    this.x = (i / 2);
    this.y = (j / 2);
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, this.x - k, 0, this.y - m);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(1.5F));
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.el.startAnimation(localAnimationSet);
  }
  
  public void close()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - wja.dp2px(320.0F, this.context.getResources())) / 2;
    i = (i - wja.dp2px(420.0F, this.context.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.x - j, 0, this.y - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.el.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new adbb(this));
  }
  
  public void dismiss()
  {
    if (!this.activity.isFinishing()) {
      super.dismiss();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.getParent() != null))
    {
      if (this.Bd != null) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.removeView(this.Bd);
      }
      this.jD.removeView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsMapView.onPause();
    }
  }
  
  public void show()
  {
    if (!this.activity.isFinishing()) {
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aday
 * JD-Core Version:    0.7.0.1
 */