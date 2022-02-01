import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import java.util.ArrayList;

public class vws
  implements Handler.Callback
{
  public vws(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return true;
          paramMessage = (Intent)paramMessage.obj;
          this.this$0.bLa = paramMessage.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
          if ((55 == paramMessage.getIntExtra(aqfx.REQUEST_CODE, -1)) && (paramMessage.getExtras().containsKey("PhotoConst.PHOTO_PATHS")))
          {
            ArrayList localArrayList = paramMessage.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
            if ((localArrayList != null) && (localArrayList.size() > 0))
            {
              this.this$0.e(BaseApplicationImpl.getApplication(), localArrayList);
              return true;
            }
          }
        } while (!paramMessage.getBooleanExtra("IS_FROM_PREVIEW_ACTIVITY", false));
        paramMessage = paramMessage.getStringArrayListExtra("key_photo_preview");
      } while (paramMessage == null);
      this.this$0.e(BaseApplicationImpl.getApplication(), paramMessage);
      return true;
    case 2: 
      this.this$0.f(null);
      return true;
    }
    this.this$0.aP();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vws
 * JD-Core Version:    0.7.0.1
 */