import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class axom
{
  public static Bundle a(@NonNull axoo paramaxoo)
  {
    Bundle localBundle = new Bundle();
    if (paramaxoo.a != null)
    {
      ayjn localayjn = (ayjn)paramaxoo.a.a.a(ayjn.TAG);
      ayjl localayjl = (ayjl)paramaxoo.a.a.a("DynamicFaceLayer");
      ayjw localayjw = (ayjw)paramaxoo.a.a.a(ayjw.TAG);
      localBundle.putBundle(ayjn.TAG, localayjn.G());
      localBundle.putBundle("DynamicFaceLayer", localayjl.G());
      if (localayjw != null) {
        localBundle.putBundle(ayjw.TAG, localayjw.G());
      }
      a(paramaxoo, localBundle);
      localBundle.putBundle("container", paramaxoo.b.D());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(axoo paramaxoo, Bundle paramBundle)
  {
    Object localObject = paramaxoo.a.a();
    aykb.b localb = ((aykb)localObject).a();
    if (localb == null)
    {
      localObject = paramaxoo.a.b();
      paramaxoo = ((aykb)localObject).a();
      if (paramaxoo == null) {
        break label83;
      }
      paramaxoo.type = 1001;
    }
    label83:
    for (;;)
    {
      if (paramaxoo != null)
      {
        ((axpx)axov.a(15)).aq(paramaxoo.bitmap);
        paramBundle.putBundle("VoteLayer", ((aykb)localObject).G());
      }
      return;
      localb.type = 1000;
      paramaxoo = localb;
    }
  }
  
  public static Bundle e(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axom
 * JD-Core Version:    0.7.0.1
 */