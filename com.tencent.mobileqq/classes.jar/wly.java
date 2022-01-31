import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class wly
  implements Runnable
{
  public wly(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    if (!EmoticonGroupStoreFragment.c(this.a).isEmpty())
    {
      ArrayList localArrayList = new ArrayList(EmoticonGroupStoreFragment.c(this.a));
      Map localMap = EmoticonGroupStoreFragment.a(this.a).a(localArrayList);
      if (localMap != null) {
        EmoticonGroupStoreFragment.a(this.a).a(localMap, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wly
 * JD-Core Version:    0.7.0.1
 */