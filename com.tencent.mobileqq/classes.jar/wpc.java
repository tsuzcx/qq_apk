import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class wpc
  implements Runnable
{
  public wpc(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void run()
  {
    Object localObject = (EmoticonFromGroupDBManager)EmoticonGroupStoreFragment.a(this.a).getManager(258);
    if (localObject != null) {
      ((EmoticonFromGroupDBManager)localObject).b();
    }
    localObject = new CopyOnWriteArrayList(EmoticonGroupStoreFragment.a(this.a).a());
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = ((List)localObject).size();
      if (i < 50)
      {
        EmoticonGroupStoreFragment.a(this.a, (List)localObject);
        EmoticonGroupStoreFragment.b(this.a, EmoticonGroupStoreFragment.c(this.a));
        EmoticonGroupStoreFragment.a(this.a);
        EmoticonGroupStoreFragment.b(this.a);
      }
      for (;;)
      {
        if (EmoticonGroupStoreFragment.b(this.a) != null) {
          EmoticonGroupStoreFragment.c(this.a);
        }
        return;
        EmoticonGroupStoreFragment.a(this.a, ((List)localObject).subList(0, 50));
        int j = EmoticonGroupStoreFragment.c(this.a).size();
        EmoticonGroupStoreFragment.b(this.a, EmoticonGroupStoreFragment.c(this.a));
        EmoticonGroupStoreFragment.b(this.a);
        EmoticonGroupStoreFragment.a(this.a, ((List)localObject).subList(50, i));
        EmoticonGroupStoreFragment.a(this.a);
        EmoticonGroupStoreFragment.b(this.a, EmoticonGroupStoreFragment.c(this.a).subList(j, EmoticonGroupStoreFragment.c(this.a).size()));
        EmoticonGroupStoreFragment.b(this.a);
      }
    }
    EmoticonGroupStoreFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpc
 * JD-Core Version:    0.7.0.1
 */