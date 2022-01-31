import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyPeopleListFrame;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class axd
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public axd(NearbyPeopleListFrame paramNearbyPeopleListFrame1, NearbyPeopleListFrame paramNearbyPeopleListFrame2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyPeopleListFrame2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NearbyPeopleListFrame localNearbyPeopleListFrame = (NearbyPeopleListFrame)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localNearbyPeopleListFrame == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        NearbyPeopleListFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleListFrame);
        localNearbyPeopleListFrame.a.B();
      }
    } while (paramMessage.arg1 != 1);
    NearbyPeopleListFrame.a(localNearbyPeopleListFrame, 1, 2131363366);
    return;
    NearbyPeopleListFrame.b(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleListFrame);
    localNearbyPeopleListFrame.a.B();
    NearbyPeopleListFrame.a(localNearbyPeopleListFrame, 1, localNearbyPeopleListFrame.a(2131363527));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axd
 * JD-Core Version:    0.7.0.1
 */