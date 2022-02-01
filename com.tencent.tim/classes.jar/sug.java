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
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class sug
  extends WebViewPlugin
{
  ausj N = null;
  private android.content.ClipboardManager jdField_a_of_type_AndroidContentClipboardManager;
  private android.text.ClipboardManager jdField_a_of_type_AndroidTextClipboardManager;
  private aqjt jdField_a_of_type_Aqjt;
  String aGB = null;
  
  public sug()
  {
    this.mPluginNameSpace = "mail";
  }
  
  private void bAS()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.getActivity();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.CALL_PHONE") != 0) {
          ((AppActivity)localActivity).requestPermissions(new sui(this), 1, new String[] { "android.permission.CALL_PHONE" });
        }
      }
      else {
        return;
      }
      bAT();
      return;
    }
    bAT();
  }
  
  private void bAT()
  {
    anot.a(null, "CliOper", "", "", "0X8004B43", "0X8004B43", 0, 0, "", "", "", "");
    this.mRuntime.getActivity().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] { this.aGB }))));
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Dial %s success", new Object[] { this.aGB }));
    }
  }
  
  private void bAU()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.getActivity();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.SEND_SMS") != 0) {
          ((AppActivity)localActivity).requestPermissions(new suj(this), 1, new String[] { "android.permission.SEND_SMS" });
        }
      }
      else {
        return;
      }
      bAV();
      return;
    }
    bAV();
  }
  
  private void bAV()
  {
    anot.a(null, "CliOper", "", "", "0X8004B44", "0X8004B44", 0, 0, "", "", "", "");
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + this.aGB));
    this.mRuntime.getActivity().startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMailJsPlugin", 2, String.format("Send SMS to %s success", new Object[] { this.aGB }));
    }
  }
  
  private void bAW()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.getActivity();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          ((AppActivity)localActivity).requestPermissions(new suk(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        }
      }
      else {
        return;
      }
      bAX();
      return;
    }
    bAX();
  }
  
  private void bAX()
  {
    Activity localActivity = this.mRuntime.getActivity();
    if (this.jdField_a_of_type_Aqjt == null)
    {
      aqoa localaqoa = new aqoa();
      localaqoa.dV(1, localActivity.getString(2131701878));
      localaqoa.dV(2, localActivity.getString(2131701879));
      localaqoa.UY(String.format(localActivity.getString(2131701877), new Object[] { this.aGB }));
      this.jdField_a_of_type_Aqjt = aqha.a(localActivity, localaqoa, new sul(this));
      if (this.jdField_a_of_type_Aqjt != null) {}
    }
    else
    {
      this.jdField_a_of_type_Aqjt.setTitle(String.format(localActivity.getString(2131701877), new Object[] { this.aGB }));
    }
    this.jdField_a_of_type_Aqjt.show();
  }
  
  private void bAY()
  {
    anot.a(null, "CliOper", "", "", "0X8004B45", "0X8004B45", 0, 0, "", "", "", "");
    cV("android.intent.action.INSERT", "vnd.android.cursor.dir/contact");
  }
  
  private void bAZ()
  {
    anot.a(null, "CliOper", "", "", "0X8004B46", "0X8004B46", 0, 0, "", "", "", "");
    cV("android.intent.action.INSERT_OR_EDIT", "vnd.android.cursor.item/person");
  }
  
  private void cV(String paramString1, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.setType(paramString2);
    paramString1.putExtra("phone", this.aGB);
    this.mRuntime.getActivity().startActivity(paramString1);
  }
  
  @TargetApi(11)
  private void copy()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.jdField_a_of_type_AndroidTextClipboardManager == null) {
        this.jdField_a_of_type_AndroidTextClipboardManager = ((android.text.ClipboardManager)this.mRuntime.getActivity().getSystemService("clipboard"));
      }
      this.jdField_a_of_type_AndroidTextClipboardManager.setText(this.aGB);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMailJsPlugin", 2, String.format("Copy %s success", new Object[] { this.aGB }));
      }
      return;
      if (this.jdField_a_of_type_AndroidContentClipboardManager == null) {
        this.jdField_a_of_type_AndroidContentClipboardManager = ((android.content.ClipboardManager)this.mRuntime.getActivity().getSystemService("clipboard"));
      }
      ClipData localClipData = ClipData.newPlainText("qqMailTel", this.aGB);
      android.content.ClipboardManager localClipboardManager = this.jdField_a_of_type_AndroidContentClipboardManager;
      alkw.a(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
    }
  }
  
  public void bAR()
  {
    if (this.N == null)
    {
      this.N = ausj.b(this.mRuntime.getActivity());
      this.N.addButton(String.format("%s%s", new Object[] { this.mRuntime.getActivity().getString(2131692643), this.aGB }));
      this.N.addButton(2131701880);
      this.N.addButton(2131701877);
      this.N.addButton(2131692330);
      this.N.addCancelButton(2131721058);
      this.N.a(new suh(this));
    }
    for (;;)
    {
      this.N.show();
      return;
      this.N.updateButton(0, String.format("%s%s", new Object[] { this.mRuntime.getActivity().getString(2131692643), this.aGB }));
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
      if (((this.N == null) || (!this.N.isShowing())) && ((this.jdField_a_of_type_Aqjt == null) || (!this.jdField_a_of_type_Aqjt.isShowing())))
      {
        this.aGB = paramJsBridgeListener;
        bAR();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sug
 * JD-Core Version:    0.7.0.1
 */