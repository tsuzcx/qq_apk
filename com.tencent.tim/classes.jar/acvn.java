import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class acvn
  extends acuk
{
  public acvn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.source + "  serverName:" + this.cti + "  hostName:" + this.ctj);
    }
    Object localObject1;
    if (this.ctj.equals("index"))
    {
      localObject1 = new Intent(this.context, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.context.startActivity((Intent)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (!this.ctj.equals("detail")) {
                break;
              }
            } while (TextUtils.isEmpty(this.source));
            localObject1 = arug.Dj() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = arug.Dp() + File.separator + "qapp_center_detail.htm")
            {
              localObject2 = new Intent(this.context, QZoneAppListActivity.class);
              localObject3 = new Bundle();
              localObject4 = Uri.parse(this.source).getQueryParameter("param");
              ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
              ((Bundle)localObject3).putString("APP_PARAMS", "&" + (String)localObject4);
              ((Bundle)localObject3).putInt("goto_type", 2);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
              this.context.startActivity((Intent)localObject2);
              return true;
            }
            if (!this.ctj.equals("webview")) {
              break;
            }
          } while (TextUtils.isEmpty(this.source));
          localObject1 = new Intent(this.context, QZoneAppListActivity.class);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.source).getQueryParameter("url"));
          ((Bundle)localObject2).putInt("goto_type", 3);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          this.context.startActivity((Intent)localObject1);
          return true;
        } while ((!this.ctj.equals("local")) || (TextUtils.isEmpty(this.source)));
        localObject2 = Uri.parse(this.source);
        localObject1 = ((Uri)localObject2).getQueryParameter("title");
        localObject3 = arug.getFileUrl(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(arug.Dj())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
    Object localObject3 = localObject3[1];
    Object localObject4 = new Intent(this.context, QZoneAppListActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("APP_URL", (String)localObject2);
    Object localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((ArrayList)localObject2).add(localObject1);
    }
    localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      localBundle.putString("APP_PARAMS", (String)localObject3);
    }
    localBundle.putInt("goto_type", 4);
    ((Intent)localObject4).putExtras(localBundle);
    this.context.startActivity((Intent)localObject4);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acB();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QappCenterJumpAction", 1, "doAction error: " + localException.getMessage());
      Ge("QappCenterJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvn
 * JD-Core Version:    0.7.0.1
 */