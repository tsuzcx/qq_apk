import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.LocationPickController.3;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aisj
  implements aqdf.a
{
  private ImageView AX;
  private View DO;
  private XListView P;
  private aiqs jdField_a_of_type_Aiqs;
  private aqdf.a jdField_a_of_type_Aqdf$a;
  private aqdf jdField_a_of_type_Aqdf;
  private LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  private aiqr.a jdField_b_of_type_Aiqr$a = new aisk(this);
  private aish jdField_b_of_type_Aish;
  private boolean clL = true;
  private HashMap<String, aisj.a> eA = new HashMap(10);
  private INetInfoHandler f;
  private Runnable gT = new LocationPickController.3(this);
  private LatLng l;
  private BaseActivity mActivity;
  private View mLoadingView;
  private View nq;
  private AbsListView.e q = new aisl(this);
  
  public aisj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aiqs = aiqs.a(paramQQAppInterface);
  }
  
  private void bCV()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.gT);
    this.mLoadingView.setVisibility(8);
    this.nq.setVisibility(8);
    this.P.setVisibility(0);
    this.DO.setEnabled(false);
  }
  
  private void bX(Activity paramActivity)
  {
    EditText localEditText = (EditText)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131366542);
    this.AX.setOnClickListener(new aiso(this, paramActivity, localEditText));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new aisp(this, paramActivity));
    this.jdField_a_of_type_Aqdf = new aqdf(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Aqdf.a(this);
  }
  
  private void duj()
  {
    this.clL = false;
    ThreadManager.getUIHandler().postDelayed(this.gT, 10000L);
  }
  
  private void duk()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.gT);
    this.mLoadingView.setVisibility(8);
    this.nq.setVisibility(0);
    this.P.setVisibility(8);
    this.DO.setEnabled(false);
  }
  
  private void dul()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.gT);
    LocationRoom.Venue localVenue = this.jdField_b_of_type_Aish.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(localVenue.g, true);
    int i = this.jdField_b_of_type_Aish.FX();
    if (i >= 0) {
      this.P.setSelection(i);
    }
    if ((this.clL) && (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.aQZ())) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.hide();
    }
    this.mLoadingView.setVisibility(8);
    this.nq.setVisibility(8);
    this.P.setVisibility(0);
    this.DO.setEnabled(true);
  }
  
  private void onLoading()
  {
    ThreadManager.getUIHandler().postDelayed(this.gT, 10000L);
    this.mLoadingView.setVisibility(0);
    this.nq.setVisibility(8);
    this.P.setVisibility(8);
    this.DO.setEnabled(false);
  }
  
  public Bitmap E(String paramString)
  {
    Object localObject2 = (aisj.a)this.eA.get(paramString);
    long l1 = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l1 - ((aisj.a)localObject2).lastUpdateTime < 4000L) && (((aisj.a)localObject2).fs != null)) {
        return ((aisj.a)localObject2).fs;
      }
      localObject1 = localObject2;
      if (l1 - ((aisj.a)localObject2).abT < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new aisj.a(null);
      this.eA.put(paramString, localObject1);
    }
    ((aisj.a)localObject1).abT = l1;
    localObject2 = this.jdField_a_of_type_Aqdf.b(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((aisj.a)localObject1).lastUpdateTime = l1;
      ((aisj.a)localObject1).fs = ((Bitmap)localObject2);
    }
  }
  
  void Iq(String paramString)
  {
    this.clL = false;
    this.jdField_b_of_type_Aish.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getMap(), this.l, paramString);
  }
  
  public void a(Activity paramActivity, LocationRoom.b paramb, CameraPosition paramCameraPosition, MapWidget paramMapWidget, ImageView paramImageView, View paramView1, PoiSlideBottomPanel paramPoiSlideBottomPanel, XListView paramXListView, View paramView2, View paramView3)
  {
    this.mActivity = ((BaseActivity)paramActivity);
    this.mLoadingView = paramView2;
    this.DO = paramView1;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = paramPoiSlideBottomPanel;
    this.nq = paramView3;
    this.P = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.AX = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = paramb;
    this.jdField_b_of_type_Aish = new aish(paramActivity);
    this.jdField_b_of_type_Aish.a(new aism(this));
    paramXListView.setDividerHeight(0);
    paramXListView.setAdapter(this.jdField_b_of_type_Aish);
    paramXListView.setSelectionAfterHeaderView();
    paramXListView.setOnScrollListener(this.q);
    paramXListView.setOnItemClickListener(new aisn(this, paramPoiSlideBottomPanel));
    ayxa.initLiuHaiProperty(paramActivity);
    if (ayxa.sHasNotch) {}
    for (int i = aqcx.dip2px(paramActivity, 54.0F) + ayxa.sNotchHeight;; i = aqcx.dip2px(paramActivity, 54.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramActivity, this.jdField_a_of_type_Aiqs.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b), paramCameraPosition, i, paramPoiSlideBottomPanel);
      bX(paramActivity);
      this.jdField_a_of_type_Aiqs.b(this.jdField_b_of_type_Aiqr$a);
      if (auvj.isNightMode()) {
        this.AX.setBackgroundResource(2130841354);
      }
      return;
    }
  }
  
  boolean apE()
  {
    return this.jdField_b_of_type_Aish.apE();
  }
  
  LocationRoom.Venue c()
  {
    return this.jdField_b_of_type_Aish.b();
  }
  
  public void dum()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.f);
      this.f = null;
      if (this.jdField_a_of_type_Aqdf != null) {
        this.jdField_a_of_type_Aqdf.destory();
      }
      this.jdField_a_of_type_Aiqs.a(this.jdField_b_of_type_Aiqr$a);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", localException);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = aqhu.r(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    aisj.a locala = (aisj.a)this.eA.get(paramString);
    long l1 = System.currentTimeMillis();
    paramBitmap = locala;
    if (locala == null)
    {
      paramBitmap = new aisj.a(null);
      this.eA.put(paramString, paramBitmap);
    }
    paramBitmap.lastUpdateTime = l1;
    paramBitmap.fs = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.u(paramString, localBitmap);
    if (this.jdField_a_of_type_Aqdf$a != null) {
      this.jdField_a_of_type_Aqdf$a.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
  
  static class a
  {
    long abT;
    Bitmap fs;
    long lastUpdateTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisj
 * JD-Core Version:    0.7.0.1
 */