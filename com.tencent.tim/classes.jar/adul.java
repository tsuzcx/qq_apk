import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;

class adul
  extends BroadcastReceiver
{
  adul(aduk paramaduk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())) || (paramIntent.getIntExtra("faceType", -1) != this.g.cnW)) {}
    ArrayList localArrayList;
    do
    {
      return;
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      localArrayList = paramIntent.getStringArrayListExtra("headPathList");
    } while ((paramContext == null) || (localArrayList == null));
    int j = paramContext.size();
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "onReceive, uinListSize:" + j + " reqSize:" + this.g.aZ.size());
    }
    paramIntent = new ArrayList(this.g.aZ.size());
    int i = 0;
    while (i < j)
    {
      String str = (String)paramContext.get(i);
      if (this.g.aZ.contains(str))
      {
        this.g.aZ.remove(str);
        paramIntent.add(str);
      }
      this.g.q.put(str, localArrayList.get(i));
      i += 1;
    }
    paramContext = Message.obtain();
    paramContext.obj = paramIntent;
    paramContext.what = 1001;
    this.g.by.sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adul
 * JD-Core Version:    0.7.0.1
 */