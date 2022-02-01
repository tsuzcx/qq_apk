import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.MagicFaceViewBinder;
import java.util.List;

public class fom
  implements Runnable
{
  public fom(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    int i;
    Object localObject;
    if (EmoticonMainPanel.a(this.a) != null)
    {
      i = 0;
      int j = EmoticonMainPanel.a(this.a).size();
      if (i >= j) {
        break label107;
      }
      localObject = (EmoticonViewBinder)EmoticonMainPanel.a(this.a).get(i);
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
      this.a.post(new fon(this, i, (MagicFaceViewBinder)localObject));
      return;
      label107:
      localObject = null;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fom
 * JD-Core Version:    0.7.0.1
 */