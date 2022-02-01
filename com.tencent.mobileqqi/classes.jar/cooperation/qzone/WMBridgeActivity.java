package cooperation.qzone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import icf;
import java.io.File;
import java.math.BigDecimal;

public class WMBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, PluginManagerHelper.OnPluginManagerLoadedListener
{
  private static final int jdField_a_of_type_Int = 400;
  private static final String jdField_a_of_type_JavaLangString = "WaterMarkCamera.apk";
  private static final int jdField_b_of_type_Int = 1000;
  private static String jdField_b_of_type_JavaLangString;
  private static final int jdField_c_of_type_Int = 1001;
  private static final String jdField_c_of_type_JavaLangString;
  private static final int d = 1002;
  private static final int e = 1003;
  private static final int f = 1004;
  private static final int g = 90;
  private static final int h = 99;
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  
  static
  {
    b = "http://dldir1.qq.com/invc/zebra/imgs/watermarkIntro.jpg";
    c = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "zebrasdk" + File.separator;
  }
  
  private String a(int paramInt)
  {
    Object localObject = "20秒";
    float f1;
    if (paramInt != 0)
    {
      f1 = (float)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L) / paramInt * (100 - paramInt);
      if (f1 > 60.0F) {
        localObject = "1分钟";
      }
    }
    else
    {
      return localObject;
    }
    localObject = new BigDecimal(f1).setScale(1, 4);
    return localObject + "秒";
  }
  
  private void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [finishAndResult] begin!");
    }
    setResult(paramInt, this.jdField_a_of_type_AndroidContentIntent);
    finish();
  }
  
  private void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [initUI] start!");
    }
    setTitle("水印相机");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131234858));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234857));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234859));
    if (new File(c + "watermark.jpg").exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [initUI] intro pic exists!");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1004).sendToTarget();
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [initUI] end!");
      }
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [initUI] intro pic not exists!");
      }
      d();
    }
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_ERROR!");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1003);
      return;
    case 0: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_NODOWNLOAD!");
      }
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("WaterMarkCamera.apk");
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_DOWNLOADING!");
      }
    case 2: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_DOWNLOADED!");
      }
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1000, i, 0).sendToTarget();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_INSTALLING!");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1002);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_INSTALLED!");
    }
    a(-1);
  }
  
  protected boolean b()
  {
    a(0);
    return super.b();
  }
  
  public void d()
  {
    new Thread(new icf(this)).start();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 99;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_UPDATE_PROGRESS!");
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载(" + i + "%)，大约还需" + a(i));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_INCREMENT!");
      }
      int j = this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress();
      if (j < 99) {}
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载(" + i + "%)，大约还需" + a(i));
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        break;
        i = j + 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_QUERY!");
      }
      if (!isFinishing())
      {
        a("WaterMarkCamera.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("WaterMarkCamera.apk"));
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_ERROR!");
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败");
        Toast.makeText(this, "网络无连接，请检查你的网络连接", 0).show();
        continue;
        paramMessage = null;
        try
        {
          Bitmap localBitmap = BitmapFactory.decodeFile(c + "watermark.jpg");
          localObject = localBitmap;
          paramMessage = localBitmap;
          if (QLog.isDevelopLevel())
          {
            paramMessage = localBitmap;
            QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] decode image success!");
            localObject = localBitmap;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject = paramMessage;
            if (QLog.isDevelopLevel())
            {
              QLog.e("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] decode image failed!");
              localObject = paramMessage;
            }
          }
          paramMessage = new File(c + "watermark.jpg");
          if ((paramMessage == null) || (!paramMessage.exists())) {
            break label449;
          }
          paramMessage.delete();
        }
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (QLog.isDevelopLevel()) {
            QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] show image success!");
          }
        }
        else
        {
          label449:
          if (QLog.isDevelopLevel()) {
            QLog.e("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] show image failed!");
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131361815);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    PluginManagerHelper.getPluginInterface(this, this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    setContentView(2130904075);
    e();
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [onCreate] SUPPORT_NETWORKING = false 直接安装本地包!");
    }
    a(-1);
    if (!NetworkUtil.f(getApplicationContext())) {
      Toast.makeText(this, "网络无连接，请检查你的网络连接", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.WMBridgeActivity
 * JD-Core Version:    0.7.0.1
 */