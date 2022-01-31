import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class zet
  extends WebViewPlugin
{
  private android.content.ClipboardManager jdField_a_of_type_AndroidContentClipboardManager;
  private android.text.ClipboardManager jdField_a_of_type_AndroidTextClipboardManager;
  private bdjy jdField_a_of_type_Bdjy;
  bhuf jdField_a_of_type_Bhuf = null;
  String jdField_a_of_type_JavaLangString = null;
  
  public zet()
  {
    this.mPluginNameSpace = "mail";
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.setType(paramString2);
    paramString1.putExtra("phone", this.jdField_a_of_type_JavaLangString);
    this.mRuntime.a().startActivity(paramString1);
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.a();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.CALL_PHONE") != 0) {
          ((AppActivity)localActivity).requestPermissions(new zev(this), 1, new String[] { "android.permission.CALL_PHONE" });
        }
      }
      else {
        return;
      }
      c();
      return;
    }
    c();
  }
  
  private void c()
  {
    azqs.b(null, "CliOper", "", "", "0X8004B43", "0X8004B43", 0, 0, "", "", "", "");
    this.mRuntime.a().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] { this.jdField_a_of_type_JavaLangString }))));
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Dial %s success", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.a();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.SEND_SMS") != 0) {
          ((AppActivity)localActivity).requestPermissions(new zew(this), 1, new String[] { "android.permission.SEND_SMS" });
        }
      }
      else {
        return;
      }
      e();
      return;
    }
    e();
  }
  
  private void e()
  {
    azqs.b(null, "CliOper", "", "", "0X8004B44", "0X8004B44", 0, 0, "", "", "", "");
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + this.jdField_a_of_type_JavaLangString));
    this.mRuntime.a().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Send SMS to %s success", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.a();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          ((AppActivity)localActivity).requestPermissions(new zex(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        }
      }
      else {
        return;
      }
      g();
      return;
    }
    g();
  }
  
  private void g()
  {
    Activity localActivity = this.mRuntime.a();
    if (this.jdField_a_of_type_Bdjy == null)
    {
      bdpi localbdpi = new bdpi();
      localbdpi.a(1, localActivity.getString(2131700018));
      localbdpi.a(2, localActivity.getString(2131700019));
      localbdpi.a(String.format(localActivity.getString(2131700017), new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Bdjy = bdgm.a(localActivity, localbdpi, new zey(this));
      if (this.jdField_a_of_type_Bdjy != null) {}
    }
    else
    {
      this.jdField_a_of_type_Bdjy.setTitle(String.format(localActivity.getString(2131700017), new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_Bdjy.show();
  }
  
  @TargetApi(11)
  private void h()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.jdField_a_of_type_AndroidTextClipboardManager == null) {
        this.jdField_a_of_type_AndroidTextClipboardManager = ((android.text.ClipboardManager)this.mRuntime.a().getSystemService("clipboard"));
      }
      this.jdField_a_of_type_AndroidTextClipboardManager.setText(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMailJsPlugin", 2, String.format("Copy %s success", new Object[] { this.jdField_a_of_type_JavaLangString }));
      }
      return;
      if (this.jdField_a_of_type_AndroidContentClipboardManager == null) {
        this.jdField_a_of_type_AndroidContentClipboardManager = ((android.content.ClipboardManager)this.mRuntime.a().getSystemService("clipboard"));
      }
      ClipData localClipData = ClipData.newPlainText("qqMailTel", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentClipboardManager.setPrimaryClip(localClipData);
    }
  }
  
  private void i()
  {
    azqs.b(null, "CliOper", "", "", "0X8004B45", "0X8004B45", 0, 0, "", "", "", "");
    a("android.intent.action.INSERT", "vnd.android.cursor.dir/contact");
  }
  
  private void j()
  {
    azqs.b(null, "CliOper", "", "", "0X8004B46", "0X8004B46", 0, 0, "", "", "", "");
    a("android.intent.action.INSERT_OR_EDIT", "vnd.android.cursor.item/person");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_Bhuf = bhuf.a(this.mRuntime.a());
      this.jdField_a_of_type_Bhuf.c(String.format("%s%s", new Object[] { this.mRuntime.a().getString(2131691700), this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Bhuf.b(2131700020);
      this.jdField_a_of_type_Bhuf.b(2131700017);
      this.jdField_a_of_type_Bhuf.b(2131691361);
      this.jdField_a_of_type_Bhuf.c(2131690648);
      this.jdField_a_of_type_Bhuf.a(new zeu(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.show();
      return;
      this.jdField_a_of_type_Bhuf.a(0, String.format("%s%s", new Object[] { this.mRuntime.a().getString(2131691700), this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.e("PubAccountMailJsPlugin", 2, "handleJsRequest url: " + paramString1 + "pkgName:" + paramString2 + "method:" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("mail"))) {
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountMailJsPlugin", 2, "pkgName is null");
      }
    }
    do
    {
      do
      {
        return false;
        if (!TextUtils.isEmpty(paramString3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("PubAccountMailJsPlugin", 2, "method is null");
      return false;
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PubAccountMailJsPlugin", 2, "args is empty");
    return false;
    paramJsBridgeListener = paramVarArgs[0];
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Params phone is %s", new Object[] { paramJsBridgeListener }));
    }
    if (!TextUtils.isEmpty(paramJsBridgeListener))
    {
      if (!paramString3.equals("showMenu")) {
        break label274;
      }
      if (((this.jdField_a_of_type_Bhuf == null) || (!this.jdField_a_of_type_Bhuf.isShowing())) && ((this.jdField_a_of_type_Bdjy == null) || (!this.jdField_a_of_type_Bdjy.isShowing())))
      {
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
        a();
      }
    }
    for (;;)
    {
      return bool;
      if (QLog.isColorLevel())
      {
        QLog.d("PubAccountMailJsPlugin", 2, "mSheet or mDialog is showing, so ignore request");
        bool = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("PubAccountMailJsPlugin", 2, "Phone is empty");
        }
      }
      label274:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zet
 * JD-Core Version:    0.7.0.1
 */