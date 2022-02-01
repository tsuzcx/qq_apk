package com.tencent.mobileqq.microapp.out.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqgz;
import com.tencent.common.app.AppInterface;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.microapp.R.dimen;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.R.string;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.NewIntent;

public class MapActivity
  extends BaseActivity
  implements DialogInterface.OnDismissListener, View.OnClickListener, QQMapView.a
{
  TencentMap a;
  QQMapView b;
  ImageView c;
  ImageView d;
  RelativeLayout e;
  View f;
  Button g;
  TextView h;
  TextView i;
  int j;
  com.tencent.mobileqq.microapp.out.c k;
  LatLng l;
  LatLng m;
  String n;
  AppInterface o;
  XListView p;
  f q;
  TextView r;
  com.tencent.mobileqq.microapp.widget.d s;
  com.tencent.mobileqq.microapp.out.a t = new c(this);
  boolean u;
  protected AbsListView.e v = new e(this);
  private int w;
  private int x;
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MapActivity", 4, "getPoiList lat=" + paramInt1 + ",lon=" + paramInt2 + ",page=" + this.q.g + ",isSearching=" + this.u + ",hasMore=" + this.q.h);
    }
    if ((this.u) || (!this.q.h)) {
      return;
    }
    this.u = true;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.location");
    LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
    localLocationReq.lat.set(paramInt1);
    localLocationReq.lng.set(paramInt2);
    localLocationReq.coordinate.set(0);
    localLocationReq.keyword.set("");
    localLocationReq.page.set(this.q.g);
    localLocationReq.count.set(10);
    localLocationReq.requireMyLbs.set(0);
    String str = aqgz.getIMEI();
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localLocationReq.imei.set((String)localObject);
    localToServiceMsg.putWupBuffer(localLocationReq.toByteArray());
    localToServiceMsg.addAttribute("is_pb_packet", Boolean.valueOf(true));
    localObject = new NewIntent(this.o.getApplication(), com.tencent.mobileqq.microapp.out.b.class);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
    ((NewIntent)localObject).setObserver(this.t);
    this.o.startServlet((NewIntent)localObject);
  }
  
  private void a(List paramList, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshPoiList poiList size=");
      if (paramList == null) {
        break label71;
      }
    }
    label71:
    for (int i1 = paramList.size();; i1 = 0)
    {
      QLog.d("MapActivity", 2, i1 + ",next=" + paramInt);
      runOnUiThread(new d(this, paramList, paramInt));
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    SosoInterface.a(new b(this, 0, true, true, 5000L, true, false, "Qwallet", paramBoolean));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    super.doOnCreate(paramBundle);
    paramBundle = LayoutInflater.from(this).inflate(R.layout.j, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.setContentView(paramBundle);
    this.o = getAppInterface();
    this.s = new com.tencent.mobileqq.microapp.widget.d(this);
    this.k = new com.tencent.mobileqq.microapp.out.c(this);
    Intent localIntent = getIntent();
    this.j = localIntent.getIntExtra("key_type", 0);
    findViewById(R.id.af);
    this.h = ((TextView)findViewById(R.id.ad));
    this.i = ((TextView)findViewById(R.id.ae));
    this.b = ((QQMapView)findViewById(R.id.ak));
    this.b.setContentDescription(getString(R.string.b));
    this.b.getUiSettings().setLogoPosition(0);
    this.b.getUiSettings().setScaleControlsEnabled(false);
    this.b.setObserver(this);
    this.a = this.b.getMap();
    this.c = ((ImageView)findViewById(R.id.ax));
    this.d = ((ImageView)findViewById(R.id.au));
    this.e = ((RelativeLayout)findViewById(R.id.aw));
    this.f = findViewById(R.id.bc);
    this.g = ((Button)findViewById(R.id.bb));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.c.setVisibility(0);
    this.c.setOnClickListener(this);
    this.s.setOnDismissListener(this);
    try
    {
      paramBundle = BitmapFactory.decodeResource(getResources(), R.drawable.s);
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        Object localObject2;
        label345:
        int i1;
        paramBundle = null;
      }
    }
    try
    {
      localObject2 = BitmapFactory.decodeResource(getResources(), R.drawable.f);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label345;
    }
    i1 = localIntent.getIntExtra("scale", 18);
    this.a.setZoom(i1);
    if (this.j == 1)
    {
      this.h.setText("位置信息");
      this.f.setVisibility(0);
      this.m = new LatLng(localIntent.getDoubleExtra("latitude", 0.0D), localIntent.getDoubleExtra("longitude", 0.0D));
      this.a.setCenter(this.m);
      paramBundle = new BitmapDescriptor(paramBundle);
      localObject1 = new MarkerOptions();
      ((MarkerOptions)localObject1).position(this.m);
      ((MarkerOptions)localObject1).icon(paramBundle);
      this.a.addMarker((MarkerOptions)localObject1);
      this.n = localIntent.getStringExtra("name");
      paramBundle = localIntent.getStringExtra("address");
      localObject1 = (TextView)this.f.findViewById(R.id.b);
      localObject2 = (TextView)this.f.findViewById(R.id.o);
      ((TextView)localObject1).setText(this.n);
      ((TextView)localObject2).setText(paramBundle);
      a(false);
    }
    while (this.j != 2) {
      return true;
    }
    this.r = ((TextView)findViewById(R.id.aq));
    this.q = new f(this);
    this.p = ((XListView)findViewById(R.id.bd));
    this.p.setAdapter(this.q);
    this.p.setOnScrollListener(this.v);
    this.p.setOnItemClickListener(new a(this));
    this.h.setText("选取位置");
    this.i.setVisibility(0);
    this.i.setText("确定");
    this.e.setVisibility(0);
    this.d.setVisibility(0);
    if (localObject1 != null)
    {
      this.d.setImageBitmap((Bitmap)localObject1);
      this.d.setPadding(0, 0, 0, ((Bitmap)localObject1).getHeight());
    }
    a(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.t = null;
    this.s.setOnDismissListener(null);
    if (this.s.isShowing()) {
      this.s.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ad) {
      finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == R.id.ax)
      {
        a(true);
      }
      else if (paramView.getId() == R.id.bb)
      {
        this.k.a(this.l, this.m, null, this.n);
      }
      else if (paramView.getId() == R.id.ae)
      {
        LBSShare.POI localPOI = this.q.a(this.q.f);
        if (localPOI == null)
        {
          QQToast.a(this, 0, "你还未选取位置！", 1).show(getResources().getDimensionPixelSize(R.dimen.b));
        }
        else
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("name", localPOI.name.get());
          localIntent.putExtra("address", localPOI.addr.get());
          localIntent.putExtra("latitude", localPOI.lat.get());
          localIntent.putExtra("longitude", localPOI.lng.get());
          setResult(-1, localIntent);
          finish();
        }
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (((com.tencent.mobileqq.microapp.widget.d)paramDialogInterface).b())
    {
      finish();
      return;
    }
    if (this.j == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    if (this.j == 2)
    {
      this.q.a();
      this.w = paramGeoPoint.getLatitudeE6();
      this.x = paramGeoPoint.getLongitudeE6();
      a(this.w, this.x);
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.MapActivity
 * JD-Core Version:    0.7.0.1
 */