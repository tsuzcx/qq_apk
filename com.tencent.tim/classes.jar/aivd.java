import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.location.window.LocationFloatWindowManager.5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.manager.Manager;

public class aivd
  implements Manager
{
  private aivj jdField_a_of_type_Aivj;
  private final aivl jdField_a_of_type_Aivl;
  QQAppInterface app;
  aiuz b;
  private FloatMapWidget c;
  public boolean clT;
  
  public aivd(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Aivj = new aivj(paramQQAppInterface);
    this.jdField_a_of_type_Aivl = new aivl(paramQQAppInterface);
    this.b = new aiuz(paramQQAppInterface);
  }
  
  public static aivd a(QQAppInterface paramQQAppInterface)
  {
    return (aivd)paramQQAppInterface.getManager(143);
  }
  
  private void a(BaseActivity paramBaseActivity, LocationRoom.b paramb)
  {
    aiut localaiut = new aiut();
    localaiut.setContentText(paramBaseActivity.getString(2131720289));
    localaiut.LX(paramBaseActivity.getString(2131721059));
    localaiut.LY(paramBaseActivity.getString(2131692256));
    localaiut.I(new aivg(this, paramBaseActivity, paramb));
    localaiut.J(new aivh(this));
    localaiut.setBackKeyListener(new aivi(this, localaiut));
    localaiut.show();
  }
  
  private boolean b(BaseActivity paramBaseActivity, LocationRoom.b paramb)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setFloatingCenterX(300).setFloatingCenterY(-680).build();
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    int i = localFloatingScreenManager.enterLocationFloatingScreen(BaseApplicationImpl.context, this.c, localFloatingScreenParams);
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      airk.s(paramBaseActivity);
      return false;
    }
    localFloatingScreenManager.setWindowClickListener(1, new aive(this, paramBaseActivity, paramb));
    return true;
  }
  
  private void duO()
  {
    UiSettings localUiSettings = this.c.getMap().getUiSettings();
    localUiSettings.setScaleViewEnabled(false);
    localUiSettings.setLogoScale(0.2F);
    this.c.onResume();
  }
  
  private void h(LocationRoom.b paramb)
  {
    Object localObject = TencentLocationManager.getInstance(BaseApplicationImpl.context).getLastKnownLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((TencentLocation)localObject).getLatitude(), ((TencentLocation)localObject).getLongitude());; localObject = null)
    {
      localObject = CameraPosition.fromLatLngZoom((LatLng)localObject, 15.0F);
      this.c = ((FloatMapWidget)LayoutInflater.from(BaseApplicationImpl.context).inflate(2131559468, null).findViewById(2131370855));
      this.b.a(paramb, (CameraPosition)localObject, this.c, null);
      return;
    }
  }
  
  @UiThread
  public void Ql(int paramInt)
  {
    LocationFloatWindowManager.5 local5 = new LocationFloatWindowManager.5(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local5);
  }
  
  public void Qm(int paramInt)
  {
    try
    {
      FloatingScreenManager.getInstance().quitFloatingScreen(1);
      a().duP();
      if (this.c != null)
      {
        this.c.onPause();
        this.c.onStop();
        if ((this.c.getMap() != null) && (!this.c.getMap().isDestroyed())) {
          this.c.onDestroy();
        }
        this.c = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocationFloatWindowManager", 1, "quitFloat: failed. ", localException);
      }
    }
    this.b.destroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "quitFloat: invoked. ", " fromType: ", Integer.valueOf(paramInt) });
    }
  }
  
  @NonNull
  public aivj a()
  {
    return this.jdField_a_of_type_Aivj;
  }
  
  @NonNull
  public aivl a()
  {
    return this.jdField_a_of_type_Aivl;
  }
  
  public boolean a(BaseActivity paramBaseActivity, LocationRoom.b paramb)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(BaseApplicationImpl.context, 2131696272, 0).show();
    }
    do
    {
      return false;
      h(paramb);
      duO();
    } while (!b(paramBaseActivity, paramb));
    a().i(paramb);
    aiqs.a(this.app).dj(paramb.getSessionType(), paramb.xc());
    aiur.duG();
    int i = aiur.a(this.app, paramb);
    if (i != 0) {
      anot.a(null, "CliOper", "", "", "0X800A974", "0X800A974", i, 0, "0", "0", "0", "");
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Aivj.destroy();
    this.jdField_a_of_type_Aivl.destroy();
    this.b.destroy();
    Ql(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivd
 * JD-Core Version:    0.7.0.1
 */