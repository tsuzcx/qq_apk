import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.MapWidget.a;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.HashMap;

public class aiuz
  implements aqdf.a
{
  private aiqs jdField_a_of_type_Aiqs;
  private aqdf.a jdField_a_of_type_Aqdf$a;
  private aqdf jdField_a_of_type_Aqdf;
  private LocationRoom.b jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b;
  private aiqr.a jdField_b_of_type_Aiqr$a = new aiva(this);
  private MapWidget.a jdField_b_of_type_ComTencentMobileqqLocationUiMapWidget$a;
  private FloatMapWidget jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private HashMap<String, aiuz.a> eA = new HashMap(10);
  private INetInfoHandler f;
  
  public aiuz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aiqs = aiqs.a(paramQQAppInterface);
  }
  
  private void duM()
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    duN();
    this.jdField_a_of_type_Aqdf = new aqdf((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Aqdf.a(this);
  }
  
  private void duN()
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationUiMapWidget$a = new aivc(this);
    this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_b_of_type_ComTencentMobileqqLocationUiMapWidget$a);
  }
  
  private void dut()
  {
    this.f = new aivb(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.f);
  }
  
  private void duu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onBadNetSituation: invoked. ", " TAG: ", "LocationShareController" });
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      aivd localaivd = aivd.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b.equals(localaivd.a().b())))
      {
        airk.t(localBaseActivity);
        localaivd.clT = true;
      }
    }
  }
  
  public Bitmap E(String paramString)
  {
    Object localObject2 = (aiuz.a)this.eA.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((aiuz.a)localObject2).lastUpdateTime < 4000L) && (((aiuz.a)localObject2).fs != null)) {
        return ((aiuz.a)localObject2).fs;
      }
      localObject1 = localObject2;
      if (l - ((aiuz.a)localObject2).abT < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new aiuz.a(null);
      this.eA.put(paramString, localObject1);
    }
    ((aiuz.a)localObject1).abT = l;
    localObject2 = this.jdField_a_of_type_Aqdf.b(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((aiuz.a)localObject1).lastUpdateTime = l;
      ((aiuz.a)localObject1).fs = ((Bitmap)localObject2);
    }
  }
  
  public void a(LocationRoom.b paramb, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b = paramb;
    this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Aiqs.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$b), paramCameraPosition, aqcx.dip2px(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    duM();
    dut();
    this.jdField_a_of_type_Aiqs.b(this.jdField_b_of_type_Aiqr$a);
    if (auvj.isNightMode()) {}
  }
  
  public void destroy()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.f);
      this.f = null;
      if (this.jdField_a_of_type_Aqdf != null) {
        this.jdField_a_of_type_Aqdf.destory();
      }
      this.jdField_b_of_type_ComTencentMobileqqLocationUiMapWidget$a = null;
      this.jdField_a_of_type_Aiqs.a(this.jdField_b_of_type_Aiqr$a);
      this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = null;
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
    Bitmap localBitmap = aqhu.r(paramBitmap, 16, 16);
    aiuz.a locala = (aiuz.a)this.eA.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = locala;
    if (locala == null)
    {
      paramBitmap = new aiuz.a(null);
      this.eA.put(paramString, paramBitmap);
    }
    paramBitmap.lastUpdateTime = l;
    paramBitmap.fs = localBitmap;
    this.jdField_b_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.u(paramString, localBitmap);
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
 * Qualified Name:     aiuz
 * JD-Core Version:    0.7.0.1
 */