import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.IWeiYunImageEvent;

public class dkd
  implements QfileCloudFileTabView.IWeiYunImageEvent
{
  public dkd(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public View.OnClickListener a(TextView paramTextView)
  {
    this.a.jdField_c_of_type_AndroidWidgetTextView = paramTextView;
    return new dke(this);
  }
  
  public boolean a()
  {
    return this.a.d;
  }
  
  public boolean b()
  {
    return this.a.jdField_c_of_type_Boolean;
  }
  
  public boolean c()
  {
    return QfileCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkd
 * JD-Core Version:    0.7.0.1
 */