import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class vka
  implements Runnable
{
  vka(vjz paramvjz, int paramInt) {}
  
  public void run()
  {
    Object localObject = (ArrayList)this.jdField_a_of_type_Vjz.a.a.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).restartDownload();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vka
 * JD-Core Version:    0.7.0.1
 */