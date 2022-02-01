import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.a;
import java.io.File;
import java.net.URI;
import java.util.Comparator;

public class pqd
{
  private boolean aBf;
  
  private void q(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return;
    }
    paramString1 = Uri.parse(paramString1.toURI().toString());
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramString1, paramString2);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public class a
    implements Comparator<QQStoryCmdHandler.a>
  {
    private a() {}
    
    public int a(QQStoryCmdHandler.a parama1, QQStoryCmdHandler.a parama2)
    {
      return parama2.bjN - parama1.bjN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqd
 * JD-Core Version:    0.7.0.1
 */