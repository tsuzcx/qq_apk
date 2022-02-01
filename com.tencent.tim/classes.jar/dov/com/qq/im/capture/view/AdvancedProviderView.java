package dov.com.qq.im.capture.view;

import aaqh;
import alwy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import aqnc;
import axpa;
import axwh;
import axwi;
import axwj;
import axwk;
import axwl;
import ayzr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMBeautyItem;
import java.util.List;
import mqq.app.AppRuntime;

public class AdvancedProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private float DV = 1.0F;
  private ImageView IE;
  private ImageView IF;
  private ImageView IG;
  private TextView ahA;
  private TextView ahB;
  private Animation bd;
  private int eEm = 500;
  private final int eEn = 300;
  private ImageView gH;
  
  public AdvancedProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static int QU()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_settings", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "beauty_level_" + str + "_CAMERA_ID_" + aaqh.cix;
    if (aaqh.cix == 2) {}
    for (;;)
    {
      i = localSharedPreferences.getInt(str, i);
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "getBeautyFeature BeautyLevel=" + i + ", key:" + str);
      }
      return i;
      i = 55;
    }
  }
  
  public static int QV()
  {
    int j = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sharp_face_settings", 0);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = axpa.cVC;
    int i;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2)))
    {
      i = 1;
      if (i == 0) {
        break label163;
      }
      str1 = "sharp_face_level_" + str1 + "_CAMERA_ID_" + aaqh.cix;
      if (aaqh.cix != 2) {
        break label157;
      }
      i = j;
    }
    for (;;)
    {
      i = localSharedPreferences.getInt(str1, i);
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "getSharpFaceFeature SharpFaceLevel = " + i + ", filterId = " + str2 + ", key:" + str1);
      }
      return i;
      i = 0;
      break;
      label157:
      i = 40;
      continue;
      label163:
      str1 = "sharp_face_level_" + str1 + "filterId" + str2;
      i = 50;
    }
  }
  
  private Animation a(QIMProviderContainerView paramQIMProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new aqnc(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new axwl(this, paramQIMProviderContainerView, paramView));
  }
  
  protected int QW()
  {
    return 2131561095;
  }
  
  public void adD(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_settings", 0).edit();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "beauty_level_" + str + "_CAMERA_ID_" + aaqh.cix;
    localEditor.putInt(str, paramInt);
    localEditor.apply();
    if (QLog.isColorLevel()) {
      QLog.d("AdvancedProviderView", 2, "saveBeautyFeature BeautyLevel=" + paramInt + ", key: " + str);
    }
  }
  
  public void adE(int paramInt)
  {
    int i = 0;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("sharp_face_settings", 0).edit();
    String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = axpa.cVC;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2))) {
      i = 1;
    }
    String str1 = "sharp_face_level_" + str3 + "filterId" + str2;
    if (i != 0) {
      str1 = "sharp_face_level_" + str3 + "_CAMERA_ID_" + aaqh.cix;
    }
    for (;;)
    {
      localEditor.putInt(str1, paramInt);
      localEditor.apply();
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "saveSharpFaceFeature SharpFaceLevel = " + paramInt + ", filterId = " + str2 + ", key:" + str1);
      }
      return;
    }
  }
  
  public void dKI()
  {
    eHZ();
    Object localObject1 = ayzr.a().ic();
    View localView;
    Object localObject2;
    if (this.mContentView != null)
    {
      localView = this.mContentView.findViewById(2131378230);
      if (((List)localObject1).size() <= 0) {
        break label293;
      }
      if (((List)localObject1).size() > 1)
      {
        localObject2 = (QIMBeautyItem)((List)localObject1).get(1);
        if (this.gH != null)
        {
          if (!((QIMBeautyItem)localObject2).isDovItem()) {
            break label267;
          }
          this.gH.setImageResource(2130846843);
        }
        if ((this.ahB != null) && (!TextUtils.isEmpty(((QIMBeautyItem)localObject2).name))) {
          this.ahB.setText(((QIMBeautyItem)localObject2).name);
        }
        if ((this.IG == null) || (TextUtils.isEmpty(((QIMBeautyItem)localObject2).iconUrl))) {}
      }
    }
    label154:
    label293:
    try
    {
      localObject2 = URLDrawable.getDrawable(((QIMBeautyItem)localObject2).iconUrl);
      if (((URLDrawable)localObject2).getStatus() == 2) {
        ((URLDrawable)localObject2).restartDownload();
      }
      this.IG.setImageDrawable((Drawable)localObject2);
    }
    catch (Exception localException2)
    {
      label233:
      break label154;
    }
    localObject1 = (QIMBeautyItem)((List)localObject1).get(0);
    if (this.IE != null)
    {
      if (!((QIMBeautyItem)localObject1).isDovItem()) {
        break label280;
      }
      this.IE.setImageResource(2130846843);
    }
    for (;;)
    {
      if ((this.IF != null) && (!TextUtils.isEmpty(((QIMBeautyItem)localObject1).iconUrl))) {}
      try
      {
        localObject2 = URLDrawable.getDrawable(((QIMBeautyItem)localObject1).iconUrl);
        if (((URLDrawable)localObject2).getStatus() == 2) {
          ((URLDrawable)localObject2).restartDownload();
        }
        this.IF.setImageDrawable((Drawable)localObject2);
      }
      catch (Exception localException1)
      {
        break label233;
      }
      if ((this.ahA != null) && (!TextUtils.isEmpty(((QIMBeautyItem)localObject1).name))) {
        this.ahA.setText(((QIMBeautyItem)localObject1).name);
      }
      localView.setVisibility(0);
      return;
      label267:
      this.gH.setImageResource(2130846856);
      break;
      label280:
      this.IE.setImageResource(2130846856);
    }
    localView.setVisibility(8);
  }
  
  public void eHZ()
  {
    if (this.mContentView != null)
    {
      SeekBar localSeekBar = (SeekBar)this.mContentView.findViewById(2131378234);
      TextView localTextView = (TextView)this.mContentView.findViewById(2131378233);
      int i = QV();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
      if (this.c != null)
      {
        this.c.aew(i);
        localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
      }
      localSeekBar = (SeekBar)this.mContentView.findViewById(2131363380);
      localTextView = (TextView)this.mContentView.findViewById(2131363373);
      i = QU();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + i / 10.0F);
      if (this.c != null) {
        this.c.aev(i);
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  @TargetApi(11)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561095, this, false);
    }
    paramBundle = this.mContentView.findViewById(2131363372);
    if (!alwy.auM()) {
      paramBundle.setVisibility(8);
    }
    View localView1 = this.mContentView.findViewById(2131378232);
    SeekBar localSeekBar = (SeekBar)this.mContentView.findViewById(2131363380);
    if (Build.VERSION.SDK_INT >= 21) {
      localSeekBar.setSplitTrack(false);
    }
    TextView localTextView = (TextView)this.mContentView.findViewById(2131363373);
    int i = QU();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + i / 10.0F);
    QIMProviderContainerView localQIMProviderContainerView = (QIMProviderContainerView)((Activity)getContext()).findViewById(2131373718);
    View localView2 = ((Activity)getContext()).findViewById(2131367347);
    localSeekBar.setOnSeekBarChangeListener(new axwh(this, localTextView, localView2, paramBundle, localQIMProviderContainerView, localView1));
    localSeekBar = (SeekBar)this.mContentView.findViewById(2131378234);
    if (Build.VERSION.SDK_INT >= 21) {
      localSeekBar.setSplitTrack(false);
    }
    localTextView = (TextView)this.mContentView.findViewById(2131378233);
    i = QV();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
    localSeekBar.setOnSeekBarChangeListener(new axwi(this, localTextView, localView2, localView1, localQIMProviderContainerView, paramBundle));
    this.mContentView.findViewById(2131382192).setOnClickListener(new axwj(this));
    this.mContentView.findViewById(2131382193).setOnClickListener(new axwk(this));
    this.IF = ((ImageView)this.mContentView.findViewById(2131382194));
    this.IE = ((ImageView)this.mContentView.findViewById(2131382201));
    this.ahA = ((TextView)this.mContentView.findViewById(2131382196));
    this.IG = ((ImageView)this.mContentView.findViewById(2131382195));
    this.gH = ((ImageView)this.mContentView.findViewById(2131382202));
    this.ahB = ((TextView)this.mContentView.findViewById(2131382197));
    this.mContentView.setOnClickListener(this);
    addContentView(this.mContentView);
  }
  
  public void onResume()
  {
    if (this.mContentView == null) {}
    int i;
    do
    {
      return;
      SeekBar localSeekBar = (SeekBar)this.mContentView.findViewById(2131363380);
      TextView localTextView = (TextView)this.mContentView.findViewById(2131363373);
      i = QU();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + i / 10.0F);
    } while (this.c == null);
    this.c.aev(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.AdvancedProviderView
 * JD-Core Version:    0.7.0.1
 */