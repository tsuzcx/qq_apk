import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.PeopleAroundBaseActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class cza
  extends Handler
{
  private WeakReference a;
  
  public cza(PeopleAroundBaseActivity paramPeopleAroundBaseActivity)
  {
    this.a = new WeakReference(paramPeopleAroundBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PeopleAroundBaseActivity localPeopleAroundBaseActivity = (PeopleAroundBaseActivity)this.a.get();
    if (localPeopleAroundBaseActivity == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      PeopleAroundBaseActivity.a(localPeopleAroundBaseActivity);
      localPeopleAroundBaseActivity.jdField_a_of_type_ComTencentWidgetXListView.B();
      if (paramMessage.arg1 == 1) {
        localPeopleAroundBaseActivity.a(1, 2131562097);
      }
    } while (!localPeopleAroundBaseActivity.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.b);
    localPeopleAroundBaseActivity.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.b = false;
    localPeopleAroundBaseActivity.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cza
 * JD-Core Version:    0.7.0.1
 */