import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class actm
  extends acuk
{
  public actm(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent();
        Object localObject2 = this.source.split("\\?");
        if (localObject2.length < 2) {
          break label324;
        }
        localIntent.putExtra("extra_key_url_append", localObject2[1]);
        if (localObject2[1] == null) {
          break label324;
        }
        if (localObject2[1].contains("tab=game_center"))
        {
          i = 0;
          j = 1;
          if (QLog.isColorLevel()) {
            QLog.d("CMShowAction", 2, new Object[] { "apollo_store url:", localObject1 });
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = abxi.bju;
          }
          if (j != 0)
          {
            ApolloUtil.dF(this.context);
            if (this.app == null) {
              break;
            }
            localObject1 = (abhh)this.app.getManager(153);
            VipUtils.a(this.app, "cmshow", "Apollo", "action_clk", ((abhh)localObject1).cd(this.app.getCurrentUin()), 0, new String[] { "0" });
            break;
          }
        }
        else
        {
          if (localObject2[1].contains("tab=other_url&url="))
          {
            localObject1 = URLDecoder.decode(localObject2[1].substring(localObject2[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
            i = 1;
            j = 0;
            continue;
          }
          localObject1 = new HashMap();
          qdy.g(localObject2[1], (HashMap)localObject1);
          localObject1 = abhh.s((String)((HashMap)localObject1).get("tab"), true);
          i = 0;
          j = 0;
          continue;
        }
        if (i != 0)
        {
          ApolloUtil.bp(this.context, (String)localObject2);
          continue;
        }
        ApolloUtil.a(this.context, localIntent, null, (String)localObject2, null);
      }
      catch (Exception localException)
      {
        Ge("CMShowAction");
        QLog.e("CMShowAction", 1, "doAction error: " + localException.getMessage());
        return false;
      }
      continue;
      label324:
      int i = 0;
      int j = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actm
 * JD-Core Version:    0.7.0.1
 */