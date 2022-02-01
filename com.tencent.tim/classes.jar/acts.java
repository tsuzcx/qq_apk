import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class acts
  extends acuk
{
  public acts(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acg();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("FTSSearchOpenMixWebAction", 1, "doAction error: " + localException.getMessage());
      Ge("FTSSearchOpenMixWebAction");
    }
    return false;
  }
  
  public boolean acg()
  {
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    if (this.attrs.containsKey("url")) {
      this.attrs.remove("url");
    }
    Object localObject = this.attrs.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    if (this.attrs.containsKey("weburl")) {}
    for (localObject = Uri.decode((String)this.attrs.get("weburl")); (((String)localObject).startsWith("https://sou.qq.com/")) || (((String)localObject).startsWith("https://sou.html5.qq.com/")); localObject = "")
    {
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
      this.context.startActivity(localIntent);
      if (((this.context instanceof Activity)) && (!"1".equals(this.attrs.get("openanimtype")))) {
        ((Activity)this.context).overridePendingTransition(0, 0);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acts
 * JD-Core Version:    0.7.0.1
 */