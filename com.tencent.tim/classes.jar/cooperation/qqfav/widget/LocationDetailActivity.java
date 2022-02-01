package cooperation.qqfav.widget;

import acbn;
import aeay;
import aebf;
import ahgq;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aofk;
import avja;
import avjg;
import avjj;
import avkd;
import avkd.b;
import avkf;
import avkg;
import avkh;
import avki;
import avkj;
import avkk;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public class LocationDetailActivity
  extends PoiMapActivity
{
  public ImageView Hw;
  private FadeIconImageView a;
  public TextView agg;
  public long bS = -1L;
  public avkd c;
  public String cLt;
  public String cLu;
  public boolean dC;
  private boolean dw;
  public String lat;
  private aeay mColorNoteController;
  public String name;
  
  private Intent b()
  {
    if ((this.lat != null) && (this.cLt != null))
    {
      Intent localIntent = j();
      localIntent.putExtra("forward_type", -2).putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", this.aOX).putExtra("forward_location_string", this.aOX).putExtra("forward_thumb", acbn.bmW + this.lat + "_" + this.cLt + ".png").putExtra("isFromFavorites", true).putExtra("title", this.aOW).putExtra("summary", this.aOX);
      return localIntent;
    }
    return null;
  }
  
  private int bp()
  {
    if ((this.mColorNoteController != null) && (this.mColorNoteController.isColorNoteExist())) {}
    for (int i = 256;; i = 128) {
      return i | 0x50;
    }
  }
  
  @TargetApi(11)
  private void eAy()
  {
    if (this.agg == null) {
      return;
    }
    if (TextUtils.isEmpty(this.cLu))
    {
      this.agg.setVisibility(8);
      return;
    }
    this.agg.setVisibility(0);
    if (VersionUtils.isHoneycomb()) {
      this.agg.setAlpha(0.9F);
    }
    this.agg.setText(new aofk(this.cLu, 3, 22));
  }
  
  private void gE()
  {
    this.mColorNoteController = new aeay(this, true, false, true, true, 0);
    this.mColorNoteController.setServiceInfo(a(false));
    this.mColorNoteController.attachToActivity(this);
    this.mColorNoteController.a(new avkj(this));
    this.mColorNoteController.setOnColorNoteCurdListener(new avkk(this));
    boolean bool = bN();
    if (!bool) {
      this.mColorNoteController.cVy();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.mColorNoteController.cVz();
    }
  }
  
  private void gv()
  {
    avja.a(this, "", this.bS, 0L);
  }
  
  public void WE(boolean paramBoolean)
  {
    Object localObject = b(this);
    Intent localIntent = new Intent(c(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.bS);
    localIntent.putExtra("note", this.cLu);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    if (paramBoolean) {}
    for (int i = 13322;; i = 13321)
    {
      avja.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  public aebf a(boolean paramBoolean)
  {
    return new avkf(this, Long.valueOf(this.bS));
  }
  
  public void aC()
  {
    Bundle localBundle = super.getIntent().getExtras();
    this.name = localBundle.getString("loc");
    this.lat = localBundle.getString("lat");
    this.cLt = localBundle.getString("lon");
    this.bS = localBundle.getLong("favId");
    TextView localTextView1 = (TextView)findViewById(2131369579);
    localTextView1.setText(2131693453);
    localTextView1.setOnClickListener(new avkg(this));
    ((TextView)super.findViewById(2131369627)).setText(2131695470);
    TextView localTextView2 = (TextView)super.findViewById(2131369612);
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      this.c = new avkh(this, this, new a(this), bp(), 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.Hw = ((ImageView)super.findViewById(2131369594));
      this.Hw.setVisibility(0);
      this.Hw.setImageResource(2130840663);
      this.Hw.setContentDescription(super.getString(2131695992));
      this.Hw.setOnClickListener(this.c);
      this.a = ((FadeIconImageView)findViewById(2131369598));
      if (!avjj.in()) {
        if (this.a != null)
        {
          this.a.setVisibility(0);
          this.dw = true;
        }
      }
    }
    for (;;)
    {
      localTextView2.setTag(localTextView2.getText());
      return;
      if (this.a != null)
      {
        this.a.setVisibility(8);
        continue;
        localTextView1.setText(2131690700);
        localTextView2.setText(2131721078);
        localTextView2.setOnClickListener(new avki(this));
      }
    }
  }
  
  protected boolean bN()
  {
    return true;
  }
  
  protected boolean bO()
  {
    this.dC = true;
    if ((this.mColorNoteController != null) && (!this.mColorNoteController.isColorNoteExist()))
    {
      if (this.mColorNoteController.canAddColorNote())
      {
        this.mColorNoteController.insertColorNote();
        return true;
      }
      this.mColorNoteController.onCannotAdd();
      return false;
    }
    this.dC = false;
    return false;
  }
  
  public void finish()
  {
    if ((this.mColorNoteController != null) && (this.bS != -1L) && (this.bS != 0L)) {
      this.mColorNoteController.addHistoryNote();
    }
    super.finish();
  }
  
  protected void hV()
  {
    if ((this.mColorNoteController != null) && (this.mColorNoteController.isColorNoteExist())) {
      this.mColorNoteController.deleteColorNote();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        break label51;
      }
    }
    for (;;)
    {
      if ((this.Hw != null) && (13322 != paramInt1) && (103 != paramInt1)) {
        this.Hw.setOnClickListener(null);
      }
      return;
      label51:
      if (13321 == paramInt1)
      {
        super.finish();
      }
      else if ((13322 == paramInt1) && (paramIntent != null))
      {
        this.cLu = paramIntent.getStringExtra("note");
        eAy();
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    if (this.Hw != null) {
      this.Hw.setOnClickListener(null);
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.findViewById(2131377783);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if (!super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f = super.getResources().getDisplayMetrics().density;
      this.agg = new TextView(paramBundle.getContext());
      this.agg.setId(2131372482);
      this.agg.setBackgroundResource(2130839639);
      this.agg.setMaxLines(3);
      int i = (int)(15.0F * f);
      this.agg.setPadding(i, i, i, i);
      this.agg.setTextColor(super.getResources().getColor(2131167304));
      this.agg.setTextSize(14.0F);
      this.agg.setIncludeFontPadding(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ((int)(f * 50.0F) + ImmersiveUtils.getStatusBarHeight(this));
      localLayoutParams.gravity = 48;
      paramBundle.addView(this.agg, localLayoutParams);
    }
    this.cLu = super.getIntent().getStringExtra("note");
    this.aZH = true;
    if (this.tV != null) {
      this.tV.setVisibility(8);
    }
    eAy();
    if (this.bS != -1L)
    {
      getIntent().putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      gE();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onResume();
    }
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  public static class a
    extends avkd.b
  {
    private WeakReference<LocationDetailActivity> mActivity;
    
    public a(LocationDetailActivity paramLocationDetailActivity)
    {
      this.mActivity = new WeakReference(paramLocationDetailActivity);
    }
    
    public int bs()
    {
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {
        return 0;
      }
      return LocationDetailActivity.a(localLocationDetailActivity);
    }
    
    public void gu()
    {
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {
        return;
      }
      localLocationDetailActivity.WE(true);
      avjg.a(null, "User_Modify", 7, 0, localLocationDetailActivity.getIntent().getIntExtra("category", 1));
    }
    
    public void gv()
    {
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {
        return;
      }
      LocationDetailActivity.a(localLocationDetailActivity);
    }
    
    public void gw()
    {
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {}
      while (!localLocationDetailActivity.bO()) {
        return;
      }
      localLocationDetailActivity.finish();
    }
    
    public void gx()
    {
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {
        return;
      }
      localLocationDetailActivity.hV();
    }
    
    public void hJ()
    {
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {
        return;
      }
      Intent localIntent = LocationDetailActivity.a(localLocationDetailActivity);
      if (localIntent != null)
      {
        ahgq.f(localLocationDetailActivity, localIntent, 103);
        return;
      }
      QQToast.a(localLocationDetailActivity, 2131693428, 1, 2000).show(5);
    }
    
    public void m(Bundle paramBundle)
    {
      super.m(paramBundle);
      LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.mActivity.get();
      if (localLocationDetailActivity == null) {
        return;
      }
      Intent localIntent = LocationDetailActivity.a(localLocationDetailActivity);
      if (localIntent != null)
      {
        localIntent.putExtras(paramBundle);
        ahgq.f(localLocationDetailActivity, localIntent, 103);
        return;
      }
      QQToast.a(localLocationDetailActivity, 2131693428, 1, 2000).show(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */