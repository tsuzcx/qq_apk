import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.QIMUserIcon;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class vqh
  implements Runnable
{
  public vqh(QIMUserManager paramQIMUserManager, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QIMUserManager.QIMUserIcon localQIMUserIcon = (QIMUserManager.QIMUserIcon)localIterator.next();
      if ((this.b != null) && (this.b.size() > localQIMUserIcon.jdField_a_of_type_Int))
      {
        int i;
        if (((int[])this.b.get(localQIMUserIcon.jdField_a_of_type_Int)).length >= 7)
        {
          i = 5;
          label73:
          if (((int[])this.b.get(localQIMUserIcon.jdField_a_of_type_Int)).length < 7) {
            break label251;
          }
        }
        label251:
        for (int j = 6;; j = 5)
        {
          StateListDrawable localStateListDrawable = new StateListDrawable();
          Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localQIMUserIcon.jdField_a_of_type_Int))[j]);
          localStateListDrawable.addState(new int[] { 16842913, 16842910 }, localDrawable);
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localQIMUserIcon.jdField_a_of_type_Int))[j]);
          localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable);
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localQIMUserIcon.jdField_a_of_type_Int))[i]);
          localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
          localQIMUserIcon.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
          break;
          i = 4;
          break label73;
        }
      }
    }
    if (this.b != null) {
      this.b.clear();
    }
    ThreadManager.getUIHandler().post(new vqi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqh
 * JD-Core Version:    0.7.0.1
 */