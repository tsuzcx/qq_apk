import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.MagicFaceViewBinder;
import java.util.List;

public class dev
  implements Runnable
{
  public dev(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    int i;
    Object localObject;
    if (this.a.c != null)
    {
      i = 0;
      int j = this.a.c.size();
      if (i >= j) {
        break label107;
      }
      localObject = (EmoticonViewBinder)this.a.c.get(i);
      if ((localObject == null) || (!(localObject instanceof MagicFaceViewBinder))) {
        break label73;
      }
      localObject = (MagicFaceViewBinder)localObject;
    }
    for (;;)
    {
      if ((i == -1) || (localObject == null))
      {
        return;
        label73:
        i += 1;
        break;
      }
      if (localObject != null) {
        ((MagicFaceViewBinder)localObject).c();
      }
      this.a.post(new dew(this, i, (MagicFaceViewBinder)localObject));
      return;
      label107:
      localObject = null;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dev
 * JD-Core Version:    0.7.0.1
 */