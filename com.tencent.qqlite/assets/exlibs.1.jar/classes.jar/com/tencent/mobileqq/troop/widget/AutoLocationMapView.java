package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.tencentmap.mapsdk.map.MapView;
import eqy;
import eqz;

public class AutoLocationMapView
  extends MapView
{
  static final int jdField_a_of_type_Int = 1;
  public Handler a;
  public AutoLocationMapView.AutoLocationCallback a;
  eqz jdField_a_of_type_Eqz = new eqz(this, 1, 1, 1, 8);
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new eqy(this);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new eqy(this);
  }
  
  public void a(String paramString, AutoLocationMapView.AutoLocationCallback paramAutoLocationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView$AutoLocationCallback = paramAutoLocationCallback;
    if (SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", paramString)) {
      SOSOMapLBSApi.getInstance().requestLocationUpdate(getContext().getApplicationContext(), this.jdField_a_of_type_Eqz);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */