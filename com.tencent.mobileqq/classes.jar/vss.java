import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class vss
  extends ReportDialog
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString;
  
  public vss(Context paramContext, String paramString)
  {
    super(paramContext, 2131755403);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131560453, null);
    Object localObject = getWindow();
    ((Window)localObject).setContentView(paramBundle);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = (TextView)paramBundle.findViewById(2131371603);
      if (localObject != null) {
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_AndroidViewView = paramBundle;
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vss
 * JD-Core Version:    0.7.0.1
 */