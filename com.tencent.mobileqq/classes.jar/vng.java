import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.QIMUserIcon;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.util.ArrayList;
import java.util.Iterator;

class vng
  implements Runnable
{
  vng(vnf paramvnf) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      QIMUserManager.QIMUserIcon localQIMUserIcon = (QIMUserManager.QIMUserIcon)localIterator.next();
      if (localQIMUserIcon.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView != null) {
        localQIMUserIcon.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setImageDrawable(localQIMUserIcon.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      localQIMUserIcon.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = null;
      localQIMUserIcon.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vng
 * JD-Core Version:    0.7.0.1
 */