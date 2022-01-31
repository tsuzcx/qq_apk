import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyPeopleListFrame;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class axa
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public axa(NearbyPeopleListFrame paramNearbyPeopleListFrame1, NearbyPeopleListFrame paramNearbyPeopleListFrame2)
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
    NearbyPeopleListFrame.a(localNearbyPeopleListFrame, 1, 2131363353);
    return;
    NearbyPeopleListFrame.b(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleListFrame);
    localNearbyPeopleListFrame.a.B();
    NearbyPeopleListFrame.a(localNearbyPeopleListFrame, 1, localNearbyPeopleListFrame.a(2131363515));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axa
 * JD-Core Version:    0.7.0.1
 */