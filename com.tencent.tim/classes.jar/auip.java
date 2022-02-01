import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class auip
  extends augy
{
  private boolean diV;
  
  public auip(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.b paramb)
  {
    super(paramInt, paramQQAppInterface, paramContext, paramb);
  }
  
  public void b(auio paramauio)
  {
    if ((this.a != null) && ((this.a instanceof atdx))) {
      ((atdx)this.a).a(paramauio);
    }
  }
  
  public void euV()
  {
    String str4 = this.a.getInputValue();
    Object localObject1;
    if (this.epo == 2)
    {
      localObject1 = this.context.getString(2131720955);
      if (this.epo != 2) {
        break label271;
      }
    }
    for (;;)
    {
      Object localObject3;
      int i;
      try
      {
        localObject3 = String.format("docs.qq.com/ep/pad/newpad?title=%s", new Object[] { URLEncoder.encode(str4, "UTF-8") });
        if (str4.equals(localObject1)) {
          break label497;
        }
        i = 1;
        localObject1 = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("url", "https://" + this.app.getCurrentAccountUin() + "." + (String)localObject1);
        ((Bundle)localObject3).putString("tdsourcetag", "s_tim_cloud_new");
        this.bundle.putInt("key_team_work_edit_type", i);
        ((Bundle)localObject3).putAll(this.bundle);
        TeamWorkDocEditBrowserActivity.a(this.context, (Bundle)localObject3, true);
        localObject1 = (aulh)this.app.getBusinessHandler(178);
        if (localObject1 != null) {
          ((aulh)localObject1).evv();
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("createCloudFile", 1, "doctype: " + 1 + ", createCloudFile exp: " + localException1.toString());
        return;
      }
      if (this.epo == 3)
      {
        localObject1 = this.context.getString(2131720961);
        break;
      }
      if (this.epo == 8)
      {
        localObject1 = this.context.getString(2131720957);
        break;
      }
      localObject1 = this.context.getString(2131720959);
      break;
      label271:
      if (this.epo == 3)
      {
        try
        {
          String str1 = String.format("docs.qq.com/ep/pad/newsheet?title=%s", new Object[] { URLEncoder.encode(str4, "UTF-8") });
          i = 2;
        }
        catch (Exception localException2)
        {
          QLog.e("createCloudFile", 1, "doctype: " + 2 + ", createCloudFile exp: " + localException2.toString());
          return;
        }
      }
      else if (this.epo == 8)
      {
        try
        {
          String str2 = String.format("docs.qq.com/ep/pad/newform?title=%s", new Object[] { URLEncoder.encode(str4, "UTF-8") });
          i = 3;
        }
        catch (Exception localException3)
        {
          QLog.e("createCloudFile", 1, "doctype: " + 3 + ", createCloudFile exp: " + localException3.toString());
          return;
        }
      }
      else if (this.epo == 9)
      {
        i = 4;
        try
        {
          String str3 = String.format("docs.qq.com/ep/pad/newslides?title=%s", new Object[] { URLEncoder.encode(str4, "UTF-8") });
        }
        catch (Exception localException4)
        {
          QLog.e("createCloudFile", 1, "doctype: " + 4 + ", createCloudFile exp: " + localException4.toString());
          return;
        }
      }
      else
      {
        i = -1;
        Object localObject2 = "";
        continue;
        label497:
        i = 1;
        localObject2 = localObject3;
      }
    }
  }
  
  public void setBundle(Bundle paramBundle)
  {
    super.setBundle(paramBundle);
    this.diV = paramBundle.getBoolean("selectMode");
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auip
 * JD-Core Version:    0.7.0.1
 */