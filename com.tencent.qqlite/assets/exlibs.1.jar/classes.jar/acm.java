import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.MyGridView;
import java.util.ArrayList;
import java.util.HashMap;

public class acm
  extends TransProcessorHandler
{
  public acm(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (!localFileMsg.jdField_e_of_type_JavaLangString.contains(AppConstants.bb)) {}
    label484:
    for (;;)
    {
      return;
      ChatBackgroundInfo localChatBackgroundInfo = new ChatBackgroundInfo();
      int i = 1;
      Object localObject;
      if (i < this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount())
      {
        localObject = ((ChatBackgroundInfo)this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i).getTag()).url;
        if (localFileMsg.k.equals(localObject))
        {
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);
          localChatBackgroundInfo = (ChatBackgroundInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label484;
        }
        View localView = ((View)localObject).findViewById(2131296799);
        ProgressBar localProgressBar = (ProgressBar)((View)localObject).findViewById(2131296800);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131296797);
        switch (paramMessage.what)
        {
        case 2005: 
        default: 
          return;
        case 2001: 
          localImageView.setVisibility(8);
          localView.setVisibility(0);
          localView.setContentDescription(((View)localObject).getResources().getString(2131364379, new Object[] { Integer.valueOf(i + 1) }));
          localProgressBar.setMax(100);
          localProgressBar.setProgress(0);
          this.a.jdField_a_of_type_JavaUtilHashMap.put(localChatBackgroundInfo.id, Long.valueOf(System.currentTimeMillis()));
          return;
          i += 1;
          break;
        case 2002: 
          localImageView.setVisibility(8);
          localView.setVisibility(0);
          float f = localProgressBar.getMax();
          localProgressBar.setProgress((int)((float)localFileMsg.jdField_e_of_type_Long / (float)localFileMsg.a * f));
          return;
        case 2003: 
          localImageView.setVisibility(8);
          localView.setVisibility(8);
          ((View)localObject).findViewById(2131296795).setContentDescription(((View)localObject).getResources().getString(2131364377, new Object[] { Integer.valueOf(i + 1) }));
          this.a.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.a(localChatBackgroundInfo);
          this.a.b.put(localChatBackgroundInfo.id, Long.valueOf(System.currentTimeMillis()));
          this.a.a(0, localChatBackgroundInfo);
          return;
        case 2004: 
          localImageView.setVisibility(0);
          localView.setVisibility(8);
          this.a.a(1, localChatBackgroundInfo);
          return;
        case 2006: 
          this.a.a(1, localChatBackgroundInfo);
          Toast.makeText(this.a.jdField_a_of_type_AndroidAppActivity, this.a.getBaseContext().getString(2131363511), 0).show();
          return;
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     acm
 * JD-Core Version:    0.7.0.1
 */