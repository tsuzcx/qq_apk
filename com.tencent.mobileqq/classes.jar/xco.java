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

public class xco
  extends WebViewPlugin
{
  private android.content.ClipboardManager jdField_a_of_type_AndroidContentClipboardManager;
  private android.text.ClipboardManager jdField_a_of_type_AndroidTextClipboardManager;
  private bafa jdField_a_of_type_Bafa;
  begr jdField_a_of_type_Begr = null;
  String jdField_a_of_type_JavaLangString = null;
  
  public xco()
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
          ((AppActivity)localActivity).requestPermissions(new xcq(this), 1, new String[] { "android.permission.CALL_PHONE" });
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
    awqx.b(null, "CliOper", "", "", "0X8004B43", "0X8004B43", 0, 0, "", "", "", "");
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
          ((AppActivity)localActivity).requestPermissions(new xcr(this), 1, new String[] { "android.permission.SEND_SMS" });
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
    awqx.b(null, "CliOper", "", "", "0X8004B44", "0X8004B44", 0, 0, "", "", "", "");
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
          ((AppActivity)localActivity).requestPermissions(new xcs(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
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
    if (this.jdField_a_of_type_Bafa == null)
    {
      bakh localbakh = new bakh();
      localbakh.a(1, localActivity.getString(2131633839));
      localbakh.a(2, localActivity.getString(2131633840));
      localbakh.a(String.format(localActivity.getString(2131633838), new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Bafa = babr.a(localActivity, localbakh, new xct(this));
      if (this.jdField_a_of_type_Bafa != null) {}
    }
    else
    {
      this.jdField_a_of_type_Bafa.setTitle(String.format(localActivity.getString(2131633838), new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_Bafa.show();
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
    awqx.b(null, "CliOper", "", "", "0X8004B45", "0X8004B45", 0, 0, "", "", "", "");
    a("android.intent.action.INSERT", "vnd.android.cursor.dir/contact");
  }
  
  private void j()
  {
    awqx.b(null, "CliOper", "", "", "0X8004B46", "0X8004B46", 0, 0, "", "", "", "");
    a("android.intent.action.INSERT_OR_EDIT", "vnd.android.cursor.item/person");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = begr.a(this.mRuntime.a());
      this.jdField_a_of_type_Begr.c(String.format("%s%s", new Object[] { this.mRuntime.a().getString(2131626068), this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Begr.b(2131633841);
      this.jdField_a_of_type_Begr.b(2131633838);
      this.jdField_a_of_type_Begr.b(2131625731);
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.a(new xcp(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.show();
      return;
      this.jdField_a_of_type_Begr.a(0, String.format("%s%s", new Object[] { this.mRuntime.a().getString(2131626068), this.jdField_a_of_type_JavaLangString }));
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
      if (((this.jdField_a_of_type_Begr == null) || (!this.jdField_a_of_type_Begr.isShowing())) && ((this.jdField_a_of_type_Bafa == null) || (!this.jdField_a_of_type_Bafa.isShowing())))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xco
 * JD-Core Version:    0.7.0.1
 */