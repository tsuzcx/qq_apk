import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import java.util.ArrayList;

class ayra
  extends BroadcastReceiver
{
  ayra(ayqy paramayqy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "mQQHeadBroadcastReceiver onReceive.");
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      int i;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramIntent != null) && (paramIntent.size() > 0))
      {
        ram.d("Q.qqstory.record.StoryFaceDrawableFactory", "mQQHeadBroadcastReceiver uinList.size()=%d headPathList.size()=%d.", Integer.valueOf(paramContext.size()), Integer.valueOf(paramIntent.size()));
        i = 0;
      }
      while (i < paramContext.size())
      {
        String str = (String)paramContext.get(i);
        if (this.this$0.Cj.contains(str))
        {
          this.this$0.Cj.remove(str);
          this.this$0.q.put(str, paramIntent.get(i));
          this.this$0.jW(str, (String)paramIntent.get(i));
        }
        i += 1;
        continue;
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "mQQHeadBroadcastReceiver uinList.size()=0 | headPathList.size()=0.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayra
 * JD-Core Version:    0.7.0.1
 */