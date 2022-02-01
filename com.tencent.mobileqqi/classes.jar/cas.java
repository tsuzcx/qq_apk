import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity.PicInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.MyGridView;

public class cas
  extends TransProcessorHandler
{
  public cas(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (!localFileMsg.e.contains(AppConstants.aW)) {}
    label305:
    for (;;)
    {
      return;
      int i = 1;
      if (i < this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount())
      {
        localObject = ((ChatBackgroundSettingActivity.PicInfo)this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i).getTag()).c;
        if (!localFileMsg.k.equals(localObject)) {}
      }
      for (Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);; localObject = null)
      {
        if (localObject == null) {
          break label305;
        }
        View localView = ((View)localObject).findViewById(2131231328);
        ProgressBar localProgressBar = (ProgressBar)((View)localObject).findViewById(2131231329);
        localObject = (ImageView)((View)localObject).findViewById(2131231327);
        switch (paramMessage.what)
        {
        case 2005: 
        default: 
          return;
        case 2001: 
          ((ImageView)localObject).setVisibility(8);
          localView.setVisibility(0);
          localProgressBar.setMax(100);
          localProgressBar.setProgress(0);
          return;
          i += 1;
          break;
        case 2002: 
          ((ImageView)localObject).setVisibility(8);
          localView.setVisibility(0);
          float f = localProgressBar.getMax();
          localProgressBar.setProgress((int)((float)localFileMsg.d / (float)localFileMsg.a * f));
          return;
        case 2003: 
          ((ImageView)localObject).setVisibility(8);
          localView.setVisibility(8);
          return;
        case 2004: 
          ((ImageView)localObject).setVisibility(0);
          localView.setVisibility(8);
          return;
        case 2006: 
          Toast.makeText(this.a.jdField_a_of_type_AndroidAppActivity, this.a.getBaseContext().getString(2131561475), 0).show();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cas
 * JD-Core Version:    0.7.0.1
 */