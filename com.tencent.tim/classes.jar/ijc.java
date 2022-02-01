import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ijc
{
  private static ijc jdField_a_of_type_Ijc;
  imf jdField_a_of_type_Imf = null;
  BroadcastReceiver mBroadcastReceiver = new ijd(this);
  int mVersion = 0;
  
  public ijc(Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("AVConfigManager", 1, "构造", new Throwable("打印调用栈"));
    }
  }
  
  public static ijc a(Context paramContext)
  {
    if (jdField_a_of_type_Ijc == null) {}
    try
    {
      if (jdField_a_of_type_Ijc == null)
      {
        jdField_a_of_type_Ijc = new ijc(paramContext);
        jdField_a_of_type_Ijc.onCreate(paramContext);
      }
      return jdField_a_of_type_Ijc;
    }
    finally {}
  }
  
  public static imf a(Context paramContext)
  {
    return a(paramContext).b(paramContext);
  }
  
  public static void onDestroy(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_Ijc != null)
      {
        jdField_a_of_type_Ijc.bp(paramContext);
        jdField_a_of_type_Ijc = null;
      }
      return;
    }
    finally {}
  }
  
  imf b(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_Imf == null)
      {
        String str = ConfigInfo.getSharpConfigPayloadFromFile(paramContext);
        this.mVersion = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
        this.jdField_a_of_type_Imf = new imf(str);
        QLog.w("AVConfigManager", 1, "getParser, Version[" + this.mVersion + "], data[\n" + str + "\n]");
      }
      paramContext = this.jdField_a_of_type_Imf;
      return paramContext;
    }
    finally {}
  }
  
  void bp(Context paramContext)
  {
    if (this.mBroadcastReceiver != null)
    {
      paramContext.unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
  }
  
  public void bq(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_Imf == null) {
        return;
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      if ((this.mVersion != i) || (this.jdField_a_of_type_Imf.isEmpty()))
      {
        QLog.w("AVConfigManager", 1, "reload, Version[" + this.mVersion + "->" + i + "]");
        this.jdField_a_of_type_Imf = null;
        this.mVersion = 0;
      }
      return;
    }
    finally {}
  }
  
  public void onCreate(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    localIntentFilter.addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    paramContext.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijc
 * JD-Core Version:    0.7.0.1
 */