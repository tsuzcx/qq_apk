import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class rty
  implements ausj.a
{
  public rty(QRCardActivity paramQRCardActivity, boolean[] paramArrayOfBoolean, String paramString1, Context paramContext, String paramString2) {}
  
  @SuppressLint({"NewApi"})
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.acX) {}
    Object localObject;
    do
    {
      return;
      this.this$0.acX = true;
      if (this.l[0] == 1)
      {
        switch (paramInt)
        {
        }
        for (;;)
        {
          this.this$0.mActionSheet.dismiss();
          return;
          paramView = this.this$0.app.getAccount();
          localObject = (String)this.this$0.a.fF.get(this.this$0.aCk);
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = "https://w.mail.qq.com/cgi-bin/login?target=mobileqqwrite&fwd=mq&fun=from3g&uin=" + paramView + "&to=" + (String)localObject;
            String str = ((String)localObject).toLowerCase();
            if (str.startsWith("www.")) {
              paramView = "https://" + (String)localObject;
            }
            for (;;)
            {
              localObject = new Intent(this.this$0, QQBrowserDelegationActivity.class);
              ((Intent)localObject).putExtra("url", paramView);
              ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
              ((Intent)localObject).putExtra("injectrecommend", false);
              this.this$0.startActivity((Intent)localObject);
              break;
              if (str.startsWith("https:"))
              {
                paramView = "https" + ((String)localObject).substring(5);
              }
              else
              {
                paramView = (View)localObject;
                if (str.startsWith("http:")) {
                  paramView = "http" + ((String)localObject).substring(4);
                }
              }
            }
            paramView = (String)this.this$0.a.fF.get(this.this$0.aCk);
            localObject = Uri.parse("mailto:" + paramView);
            if (this.this$0.getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", (Uri)localObject), 65536).size() > 0)
            {
              localObject = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject).setData(Uri.parse("mailto:" + paramView));
              this.this$0.startActivity((Intent)localObject);
            }
            else
            {
              localObject = new Intent("android.intent.action.SEND");
              ((Intent)localObject).putExtra("android.intent.extra.EMAIL", paramView);
              ((Intent)localObject).putExtra("android.intent.extra.TEXT", "The email body text");
              ((Intent)localObject).setType("text/plain");
              try
              {
                this.this$0.startActivity(Intent.createChooser((Intent)localObject, "Choose Email Client"));
              }
              catch (ActivityNotFoundException paramView) {}
              if (QLog.isColorLevel()) {
                QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_SEND do not exist");
              }
            }
          }
        }
      }
      if (this.l[1] == 1)
      {
        switch (paramInt)
        {
        }
        for (;;)
        {
          this.this$0.mActionSheet.dismiss();
          return;
          if (this.aCo.contains("-")) {
            this.aCo.replaceAll("-", "");
          }
          if (this.aCo.contains(" ")) {
            this.aCo.replaceAll(" ", "");
          }
          paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.aCo));
          try
          {
            this.val$context.startActivity(paramView);
          }
          catch (ActivityNotFoundException paramView) {}
          if (QLog.isColorLevel()) {
            QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
          }
        }
      }
      if (this.l[2] == 1)
      {
        paramView = new HashMap();
        if (!this.this$0.a.fC.isEmpty()) {
          paramView.putAll(this.this$0.a.fC);
        }
        if (!this.this$0.a.fF.isEmpty()) {
          paramView.putAll(this.this$0.a.fF);
        }
        if (this.this$0.a.fE != null) {
          paramView.putAll(this.this$0.a.fE);
        }
        if (!this.this$0.a.fD.isEmpty()) {
          paramView.putAll(this.this$0.a.fD);
        }
        switch (paramInt)
        {
        }
        for (;;)
        {
          this.this$0.mActionSheet.dismiss();
          return;
          localObject = new Intent("android.intent.action.INSERT");
          ((Intent)localObject).setType("vnd.android.cursor.dir/person");
          ((Intent)localObject).setType("vnd.android.cursor.dir/contact");
          ((Intent)localObject).setType("vnd.android.cursor.dir/raw_contact");
          this.this$0.a((Intent)localObject, paramView);
          continue;
          localObject = new Intent("android.intent.action.INSERT_OR_EDIT");
          ((Intent)localObject).setType("vnd.android.cursor.item/person");
          ((Intent)localObject).setType("vnd.android.cursor.item/contact");
          ((Intent)localObject).setType("vnd.android.cursor.item/raw_contact");
          this.this$0.a((Intent)localObject, paramView);
        }
      }
    } while (this.l[3] != 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.this$0.mActionSheet.dismiss();
      return;
      if (this.aCp.contains("-")) {
        this.aCp.replaceAll("-", "");
      }
      if (this.aCp.contains(" ")) {
        this.aCp.replaceAll(" ", "");
      }
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.aCp));
      try
      {
        this.val$context.startActivity(paramView);
      }
      catch (ActivityNotFoundException paramView) {}
      if (QLog.isColorLevel())
      {
        QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_DIAL do not exist");
        continue;
        if (!TextUtils.isEmpty(this.aCp)) {
          if (Build.VERSION.SDK_INT < 11)
          {
            ((android.text.ClipboardManager)this.this$0.getSystemService("clipboard")).setText(this.aCp);
          }
          else
          {
            paramView = (android.content.ClipboardManager)this.this$0.getSystemService("clipboard");
            localObject = this.aCp;
            alkw.a(paramView, (CharSequence)localObject);
            paramView.setText((CharSequence)localObject);
            continue;
            AddFriendActivity.a(this.val$context, false, this.aCp, true);
            continue;
            AddFriendActivity.a(this.val$context, true, this.aCp, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rty
 * JD-Core Version:    0.7.0.1
 */