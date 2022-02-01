import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ahhm
  extends ahgq
{
  protected static String msg;
  ahwp a;
  protected long aaD;
  protected ForwardFileInfo b;
  protected String bKB = "";
  protected String bKC = "";
  ArrayList<ForwardFileInfo> wU = new ArrayList();
  
  public ahhm(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void F(String paramString)
  {
    aqju localaqju = new aqju(this.mActivity, 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.setTitle(this.mAppContext.getString(2131721103));
    localaqju.setMessage(paramString);
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    localaqju.setNegativeButton(this.mAppContext.getString(2131691039), new ahhn(this));
    if (!this.mActivity.isFinishing()) {
      localaqju.show();
    }
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(paramContext, paramUri);
  }
  
  public static boolean mN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("/data/data/com.tencent.mobileqq/")) {
      return false;
    }
    return true;
  }
  
  private String v(String paramString, long paramLong)
  {
    Object localObject;
    if (paramLong < 1024L) {
      localObject = paramLong + " bytes";
    }
    for (;;)
    {
      return this.mAppContext.getString(2131693680) + paramString + "\n" + this.mAppContext.getString(2131693698) + (String)localObject;
      if (paramLong < 1048576L)
      {
        localObject = paramLong / 1024L + " KB";
      }
      else
      {
        localObject = new DecimalFormat("##0.00");
        localObject = ((DecimalFormat)localObject).format(paramLong / 1048576.0D) + " MB";
      }
    }
  }
  
  protected String B()
  {
    if (msg == null) {
      return this.mAppContext.getString(2131720159);
    }
    return msg;
  }
  
  protected void Kd(String paramString) {}
  
  protected boolean a(Uri paramUri)
  {
    String str = f(paramUri);
    if (TextUtils.isEmpty(str))
    {
      if (this.a != null)
      {
        paramUri = this.a;
        msg = ahwp.msg;
      }
      F(B());
      return false;
    }
    File localFile = new File(str);
    long l = localFile.length();
    boolean bool1;
    boolean bool2;
    if (this.a != null)
    {
      bool1 = this.a.aS;
      if (this.a == null) {
        break label141;
      }
      bool2 = this.a.waiting;
    }
    for (;;)
    {
      if ((!bool1) && (!bool2) && (l == 0L))
      {
        if (paramUri.toString().contains("mms/part"))
        {
          F(this.mAppContext.getString(2131693684));
          return false;
          bool1 = false;
          break;
          label141:
          bool2 = false;
          continue;
        }
        F(this.mAppContext.getString(2131693659));
        return false;
      }
    }
    if ((true == this.bf.getBoolean("forward_from_jump")) && (true == this.bf.getBoolean("isFromShare")) && (mN(str)))
    {
      paramUri = new aqju(this.mActivity, 2131756467);
      paramUri.setContentView(2131559151);
      paramUri.setTitle(this.mAppContext.getString(2131721103));
      paramUri.setMessage(this.mAppContext.getString(2131693661));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.mAppContext.getString(2131691039), new ahho(this));
      paramUri.show();
      return false;
    }
    paramUri = localFile.getName();
    boolean bool3 = localFile.canRead();
    if ((!bool1) && (!bool2) && (!bool3))
    {
      this.bKu = this.bf.getString("android.intent.extra.TEXT");
      this.bf.putInt("forward_type", -1);
      return false;
    }
    this.bf.putString("forward_filepath", str);
    Kd(str);
    this.bKu = v(paramUri, l);
    this.bKC = paramUri;
    this.bKB = str;
    this.aaD = l;
    return true;
  }
  
  protected void aG(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(paramString2));
      Object localObject = new FileInfo(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramString1);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", paramString2);
      ((Intent)localObject).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", paramString3);
      awjb.a().a(this.mActivity, this.app, this.app.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  public boolean anj()
  {
    super.anj();
    msg = null;
    Uri localUri = this.mIntent.getData();
    if ((localUri != null) && (TextUtils.isEmpty(this.bf.getString("forward_filepath")))) {
      a(localUri);
    }
    this.b = ((ForwardFileInfo)this.mIntent.getParcelableExtra("fileinfo"));
    this.wU = this.mIntent.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  protected boolean anl()
  {
    Intent localIntent;
    boolean bool;
    if (this.bf.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.mActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", kaw.a(this.bf.getString("uin"), this.app));
      if (this.mIntent.getBooleanExtra("sendMultiple", false))
      {
        this.bf.putString("leftBackText", acfp.m(2131706462));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.bf);
        bool = aa(localIntent);
        if (!this.cgS) {
          break label181;
        }
        this.mActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.bf);
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
      return false;
      localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      break;
      label181:
      if (!bool) {
        ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
      }
    }
  }
  
  protected void dns()
  {
    super.dns();
    this.e.adjustMessageBottomMargin(17.0F);
    this.e.setMessageTextColor(2131165857);
    this.e.setMessageTextSize(14.0F);
  }
  
  protected String f(Uri paramUri)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileBaseOption", 2, "uri= " + paramUri);
    }
    if (this.a == null) {
      this.a = new ahwp(this.mActivity, true, new ahhp(this));
    }
    return this.a.f(paramUri);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 102)
    {
      str = this.bf.getString("uin");
      if (!((DeviceFileHandler)this.app.getBusinessHandler(50)).bq(Long.parseLong(str)))
      {
        QQToast.a(this.mActivity, acfp.m(2131706456), 2000).show();
        this.mActivity.finish();
      }
    }
    else
    {
      return;
    }
    Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).getPath());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      xya.c(this.app, str, localArrayList, paramIntent);
    }
    this.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhm
 * JD-Core Version:    0.7.0.1
 */