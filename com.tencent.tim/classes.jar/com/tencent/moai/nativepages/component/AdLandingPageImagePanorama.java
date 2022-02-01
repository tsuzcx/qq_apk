package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPanoramaImageInfo;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.moai.nativepages.view.LockedHorizonScrollView;

public class AdLandingPageImagePanorama
  extends AdLandingPageBaseComp
  implements SensorEventListener
{
  private static final String TAG = "AdLandingPageImagePanorama";
  private final float MAX_DEGREE = 10.0F;
  private final int SENSOR_DELAY = 1;
  private Sensor accelerometer;
  private LockedHorizonScrollView hScrollView;
  private ImageView imageView;
  private long lastLogTime = -1L;
  private float[] mGeomagnetic;
  private float[] mGravity;
  private SensorManager mSensorManager;
  private Sensor magnetometer;
  private ProgressBar progressBar;
  private int scrollWidth;
  
  public AdLandingPageImagePanorama(Context paramContext, AdLandingPageComponentPanoramaImageInfo paramAdLandingPageComponentPanoramaImageInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentPanoramaImageInfo, paramViewGroup);
  }
  
  public View createView()
  {
    View localView = this.contentView;
    Context localContext1 = this.context;
    Context localContext2 = this.context;
    this.mSensorManager = ((SensorManager)localContext1.getSystemService("sensor"));
    this.accelerometer = this.mSensorManager.getDefaultSensor(1);
    this.magnetometer = this.mSensorManager.getDefaultSensor(2);
    this.hScrollView = ((LockedHorizonScrollView)localView.findViewById(2131362046));
    this.imageView = ((ImageView)localView.findViewById(2131362047));
    this.progressBar = ((ProgressBar)localView.findViewById(2131373700));
    this.progressBar.setVisibility(8);
    return localView;
  }
  
  protected void fillItem()
  {
    Object localObject = (WindowManager)this.context.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject).getDefaultDisplay().getHeight();
    this.hScrollView.setLayoutParams(new RelativeLayout.LayoutParams(i, j));
    this.imageView.setLayoutParams(new RelativeLayout.LayoutParams(i, j));
    this.contentView.setLayoutParams(new LinearLayout.LayoutParams(i, j));
    this.contentView.setPadding(this.contentView.getPaddingLeft(), (int)getInfo().paddingTop, this.contentView.getPaddingRight(), (int)getInfo().paddingBottom);
    localObject = getInfo().imgUrl;
    Bitmap localBitmap = AdLandingPagesDownloadResourceHelper.getCachedImg((String)localObject);
    if (localBitmap != null)
    {
      setImage(localBitmap);
      return;
    }
    startLoading();
    AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages((String)localObject, new AdLandingPageImagePanorama.1(this));
  }
  
  public AdLandingPageComponentPanoramaImageInfo getInfo()
  {
    return (AdLandingPageComponentPanoramaImageInfo)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563095;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    if (paramSensorEvent.sensor.getType() == 1) {
      this.mGravity = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.mGeomagnetic = paramSensorEvent.values;
    }
    float f1;
    if ((this.mGravity != null) && (this.mGeomagnetic != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.mGravity, this.mGeomagnetic))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.scrollWidth != 0)
        {
          f1 = f3;
          if (f3 > 10.0F) {
            f1 = 10.0F;
          }
          if (f1 >= -10.0F) {
            break label218;
          }
          f1 = f2;
        }
      }
    }
    label218:
    for (;;)
    {
      f1 = f1 * this.scrollWidth / 10.0F;
      Log.i("AdLandingPageImagePanorama", "hScrollView.scrollBy = " + (int)f1);
      this.hScrollView.scrollBy((int)f1, 0);
      if ((System.currentTimeMillis() - this.lastLogTime > 2000L) && ((int)f1 > 10))
      {
        DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Panorama_Image_Srcoll_Count", 1L);
        this.lastLogTime = System.currentTimeMillis();
      }
      return;
    }
  }
  
  public void registerListener()
  {
    this.mSensorManager.registerListener(this, this.accelerometer, 1);
    this.mSensorManager.registerListener(this, this.magnetometer, 1);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    WindowManager localWindowManager = (WindowManager)this.context.getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    this.progressBar.setVisibility(8);
    this.imageView.setImageBitmap(paramBitmap);
    this.imageView.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * j / paramBitmap.getHeight(), j));
    this.imageView.post(new AdLandingPageImagePanorama.2(this, i));
    if (paramBitmap.getHeight() != 0) {
      this.contentView.setLayoutParams(new LinearLayout.LayoutParams(paramBitmap.getWidth() * j / paramBitmap.getHeight(), j));
    }
  }
  
  public void startLoading()
  {
    this.progressBar.setVisibility(0);
  }
  
  public void stopLoading()
  {
    this.progressBar.setVisibility(8);
  }
  
  public void unregisterListener()
  {
    this.mSensorManager.unregisterListener(this);
  }
  
  public void viewWillAppear()
  {
    super.viewWillAppear();
    registerListener();
    if (this.appearFlag) {
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Panorama_Image_Show_Count", 1L);
    }
    this.appearFlag = false;
  }
  
  public void viewWillDisappear()
  {
    super.viewWillDisappear();
    unregisterListener();
    if (!this.appearFlag)
    {
      long l = getStayTime();
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Panorama_Image_Show_Time", l);
    }
    this.appearFlag = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageImagePanorama
 * JD-Core Version:    0.7.0.1
 */