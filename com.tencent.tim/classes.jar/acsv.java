import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.util.Xml;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;

public class acsv
  extends ReportDialog
{
  public static String FILE_PATH;
  private static long Rt;
  public static long Ru;
  @Deprecated
  public static long Rv;
  public static String TAG = "PushOpenNotify";
  public static Intent Y;
  public static boolean bKg = true;
  public static boolean bKh = true;
  public static boolean bKi;
  public static boolean bKj;
  public static String bqK;
  public static String bqL;
  public static String bqM;
  public static String bqN;
  @Deprecated
  public static String bqO = acfp.m(2131708528);
  public static String bqP = acfp.m(2131708522);
  public static String bqQ = acfp.m(2131708525);
  public static String bqR;
  public static int cAj;
  public static int cAk;
  public static int cAl;
  public static int cAm = 3;
  public static int cAn = 7;
  public static int cAo = 3;
  public static int cAp = 30;
  private boolean bKf;
  private Context mContext;
  public ImageView ye;
  
  static
  {
    Rt = -1L;
    Ru = 86400000L;
    FILE_PATH = acbn.SDCARD_PATH + "MsgPushNotify" + File.separator;
    bqK = FILE_PATH + "msgnotify_pic" + File.separator;
    bqL = "msgnotify_pic.zip";
    bqM = "msgnotify_pic_%d.jpg";
    cAj = 25;
    bqN = "https://sqimg.qq.com/qq_product_operations/banner/msgnotify_pic.zip";
  }
  
  @TargetApi(14)
  public acsv(Context paramContext)
  {
    super(paramContext, 2131756467);
    super.getWindow().setWindowAnimations(2131755320);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.mContext = paramContext;
  }
  
  public static void cA(QQAppInterface paramQQAppInterface)
  {
    if ((!bKj) || (!paramQQAppInterface.getCurrentUin().equals(bqR)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, "initPushOpeNotifyConfig");
      }
      bKj = true;
      bqR = paramQQAppInterface.getCurrentUin();
      e(paramQQAppInterface, null, true);
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).getString(paramQQAppInterface.getCurrentUin() + "_" + "push_open_notify_xml", null);
    }
    if (paramString == null)
    {
      Y = aqin.d(paramQQAppInterface.getApp());
      return;
    }
    Object localObject;
    label145:
    label233:
    label895:
    do
    {
      for (;;)
      {
        try
        {
          localObject = new ByteArrayInputStream(paramString.getBytes("utf-8"));
          paramString = Xml.newPullParser();
          paramString.setInput((InputStream)localObject, "utf-8");
          int i = paramString.getEventType();
          if (i == 1) {
            break label1202;
          }
          if (paramString.getEventType() == 2)
          {
            localObject = paramString.getName();
            if (((String)localObject).equals("switch")) {
              bKg = paramString.nextText().equals("true");
            }
          }
          else
          {
            i = paramString.next();
            continue;
          }
          if (!((String)localObject).equals("frequency")) {
            break label233;
          }
          Rv = Long.valueOf(paramString.nextText()).longValue();
          if (Rv >= 0L) {
            continue;
          }
          Rv = 0L;
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramQQAppInterface) {}
        QLog.i("PushOpenNotify", 2, "handlePushOpenNotifyConfig, exception: " + paramQQAppInterface.getStackTrace());
        return;
        if (((String)localObject).equals("wording"))
        {
          bqO = paramString.nextText();
        }
        else if (((String)localObject).equals("title"))
        {
          bqP = paramString.nextText();
        }
        else if (((String)localObject).equals("content"))
        {
          bqQ = paramString.nextText();
        }
        else if (((String)localObject).equals("frequency_OneTime"))
        {
          cAl = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_OneMax"))
        {
          cAm = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_TwoTime"))
        {
          cAn = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_TwoMax"))
        {
          cAo = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("frequency_ThreeTime"))
        {
          cAp = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("maxOSVersion"))
        {
          cAk = Integer.valueOf(paramString.nextText()).intValue();
        }
        else if (((String)localObject).equals("defaultSwitch"))
        {
          bKh = paramString.nextText().equals("true");
        }
        else
        {
          if ((!((String)localObject).equals("rom")) || (!paramString.getAttributeValue(null, "name").equals(ROMUtil.getRomName())) || (!paramString.getAttributeValue(null, "sdk").equals(Build.VERSION.SDK_INT + ""))) {
            break label897;
          }
          Y = null;
          for (;;)
          {
            if (paramString.next() == 3) {
              break label895;
            }
            if (paramString.getEventType() == 2)
            {
              if (Y == null) {
                Y = new Intent();
              }
              localObject = paramString.getName();
              if (((String)localObject).equals("action"))
              {
                Y.setAction(paramString.nextText());
              }
              else if (((String)localObject).equals("data"))
              {
                localObject = Uri.parse(paramString.nextText());
                Y.setData((Uri)localObject);
              }
              else if (((String)localObject).equals("type"))
              {
                Y.setType(paramString.nextText());
              }
              else if (((String)localObject).equals("package"))
              {
                Y.setPackage(paramString.nextText());
              }
              else if (((String)localObject).equals("component"))
              {
                localObject = paramString.nextText().split(";");
                localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
                Y.setComponent((ComponentName)localObject);
              }
              else if (((String)localObject).equals("category"))
              {
                Y.addCategory(paramString.nextText());
              }
              else
              {
                if (((String)localObject).equals("blackList"))
                {
                  bKi = true;
                  Y = null;
                  break;
                }
                if (((String)localObject).equals("app_uid"))
                {
                  Y.putExtra("app_uid", Process.myUid());
                  paramString.nextText();
                }
                else
                {
                  Y.putExtra((String)localObject, paramString.nextText());
                }
              }
            }
          }
        }
      }
    } while ((!((String)localObject).equals("device")) || (!paramString.getAttributeValue(null, "id").equals(aqgz.getDeviceModel())));
    label897:
    Y = null;
    for (;;)
    {
      if (paramString.next() != 3)
      {
        if (paramString.getEventType() != 2) {
          continue;
        }
        if (Y == null) {
          Y = new Intent();
        }
        localObject = paramString.getName();
        if (((String)localObject).equals("action"))
        {
          Y.setAction(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("data"))
        {
          localObject = Uri.parse(paramString.nextText());
          Y.setData((Uri)localObject);
          continue;
        }
        if (((String)localObject).equals("type"))
        {
          Y.setType(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("package"))
        {
          Y.setPackage(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("component"))
        {
          localObject = paramString.nextText().split(";");
          localObject = new ComponentName(localObject[0].trim(), localObject[1].trim());
          Y.setComponent((ComponentName)localObject);
          continue;
        }
        if (((String)localObject).equals("category"))
        {
          Y.addCategory(paramString.nextText());
          continue;
        }
        if (((String)localObject).equals("blackList"))
        {
          bKi = true;
          Y = null;
        }
      }
      else
      {
        if (Y == null) {
          break label145;
        }
        label1202:
        if (QLog.isColorLevel()) {
          QLog.d("PushOpenNotify", 2, new Object[] { "handlePushOpenNotifyConfig, switch:", Boolean.valueOf(bKg), ", frequency:", Integer.valueOf(cAl), " ", Integer.valueOf(cAm), " ", Integer.valueOf(cAn), " ", Integer.valueOf(cAo), " ", Integer.valueOf(cAp), ", intent:", Y });
        }
        if ((!bKh) || (bKi) || (Y != null)) {
          break;
        }
        Y = aqin.d(paramQQAppInterface.getApp());
        return;
      }
      if (((String)localObject).equals("app_uid"))
      {
        Y.putExtra("app_uid", Process.myUid());
        paramString.nextText();
      }
      else
      {
        Y.putExtra((String)localObject, paramString.nextText());
      }
    }
  }
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559159);
    this.ye = ((ImageView)findViewById(2131365856));
    paramBundle = (TextView)findViewById(2131365867);
    TextView localTextView = (TextView)findViewById(2131365835);
    Button localButton = (Button)findViewById(2131365832);
    ImageView localImageView = (ImageView)findViewById(2131364687);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(String.format(bqK + bqM, new Object[] { Integer.valueOf(0) }));
      this.ye.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), localBitmap));
      paramBundle.setText(bqP);
      localTextView.setText(bqQ);
      localButton.setText(acfp.m(2131708523));
      localButton.setOnClickListener(new acsw(this));
      localImageView.setOnClickListener(new acsx(this));
      localImageView.setOnTouchListener(new acsy(this, localImageView));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        getOwnerActivity().finish();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!this.bKf) {
      ThreadManager.post(new MsgNotifyPushDialog.4(this), 10, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsv
 * JD-Core Version:    0.7.0.1
 */