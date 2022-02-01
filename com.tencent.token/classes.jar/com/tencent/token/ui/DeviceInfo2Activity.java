package com.tencent.token.ui;

import android.app.Activity;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.avo;
import com.tencent.token.yd;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;

public class DeviceInfo2Activity
  extends BaseActivity
  implements View.OnClickListener
{
  public static String formatSize(long paramLong)
  {
    Object localObject1;
    if (paramLong >= 1024L)
    {
      localObject1 = "KB";
      long l = paramLong / 1024L;
      paramLong = l;
      if (l >= 1024L)
      {
        localObject1 = "MB";
        l /= 1024L;
        paramLong = l;
        if (l >= 1024L)
        {
          localObject2 = "GB";
          l /= 1024L;
          localObject1 = localObject2;
          paramLong = l;
          if (l < 512L) {
            if (l >= 400L)
            {
              paramLong = 512L;
              localObject1 = localObject2;
            }
            else if (l >= 200L)
            {
              paramLong = 256L;
              localObject1 = localObject2;
            }
            else if (l >= 100L)
            {
              paramLong = 128L;
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = localObject2;
              paramLong = l;
              if (l >= 55L)
              {
                paramLong = 64L;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = new StringBuilder(Long.toString(paramLong));
    int i = ((StringBuilder)localObject2).length() - 3;
    while (i > 0)
    {
      ((StringBuilder)localObject2).insert(i, ',');
      i -= 3;
    }
    if (localObject1 != null) {
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String getBuildPropFiel(String paramString)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      paramString = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static String getManufacturerRomVersion()
  {
    label279:
    label281:
    String str1;
    for (;;)
    {
      try
      {
        Object localObject = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = ((String)localObject).toLowerCase(Locale.ENGLISH);
        if (((String)localObject).contains("huawei"))
        {
          localObject = getBuildPropFiel("hw_sc.build.platform.version");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            return localObject;
          }
          return getBuildPropFiel("ro.build.version.emui");
        }
        if (((String)localObject).contains("xiaomi")) {
          return getBuildPropFiel("ro.miui.ui.version.name");
        }
        if (((String)localObject).contains("gionee"))
        {
          localObject = getBuildPropFiel("ro.gn.extvernumber");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label279;
          }
          return getBuildPropFiel("ro.build.display.id");
        }
        if (((String)localObject).contains("vivo"))
        {
          localObject = getBuildPropFiel("ro.vivo.os.name");
          String str2 = getBuildPropFiel("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_");
            localStringBuilder.append(str2);
            return localStringBuilder.toString();
          }
          return getBuildPropFiel("ro.vivo.os.build.display.id");
        }
        if (((String)localObject).contains("meizu")) {
          return getBuildPropFiel("ro.build.display.id");
        }
        if (((String)localObject).contains("lenovo"))
        {
          localObject = getBuildPropFiel("ro.lenovo.lvp.version");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label281;
          }
          localObject = ((String)localObject).split("_");
          if ((localObject == null) || (localObject.length <= 0)) {
            break label281;
          }
          localObject = localObject[0];
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          return getBuildPropFiel("ro.build.version.incremental");
        }
        if (((String)localObject).contains("letv")) {
          return getBuildPropFiel("ro.letv.eui");
        }
        if (((String)localObject).contains("oppo"))
        {
          localObject = getBuildPropFiel("ro.build.version.opporom");
          return localObject;
        }
      }
      catch (Exception localException)
      {
        avo.d(localException);
      }
      return null;
      return localException;
      str1 = null;
    }
    return str1;
  }
  
  public static String getSystemVersion()
  {
    String str2 = getManufacturerRomVersion();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getBuildPropFiel("ro.build.version.release");
    }
    return str1;
  }
  
  public static String getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    int i = Build.VERSION.SDK_INT;
    long l2 = 0L;
    long l1;
    if (i >= 18) {
      l1 = localStatFs.getBlockSizeLong();
    } else {
      l1 = 0L;
    }
    if (Build.VERSION.SDK_INT >= 18) {
      l2 = localStatFs.getBlockCountLong();
    }
    return formatSize(l2 * l1);
  }
  
  public static void setInfo(Activity paramActivity, boolean paramBoolean)
  {
    setText(paramActivity, 2131165839, yd.a, paramBoolean);
    setText(paramActivity, 2131166092, Build.MANUFACTURER, paramBoolean);
    setText(paramActivity, 2131166093, getSystemVersion(), paramBoolean);
    setText(paramActivity, 2131165990, getTotalInternalMemorySize(), paramBoolean);
  }
  
  static void setText(Activity paramActivity, int paramInt, final String paramString, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramActivity.findViewById(paramInt);
    localTextView.setText(paramString);
    if (paramBoolean) {
      ((View)localTextView.getParent()).setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          paramAnonymousView = (ClipboardManager)this.a.getSystemService("clipboard");
          if (paramAnonymousView != null)
          {
            paramAnonymousView.setText(paramString);
            Toast.makeText(this.a, "信息已复制", 0).show();
            return true;
          }
          return false;
        }
      });
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296319);
    setInfo(this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DeviceInfo2Activity
 * JD-Core Version:    0.7.0.1
 */