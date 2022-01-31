import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDialog;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.util.DisplayUtil;
import mqq.app.AppRuntime;

class xbq
  implements PreloadManager.OnGetPathListener
{
  xbq(xbp paramxbp) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDialog.isShowing()) {}
    for (;;)
    {
      return;
      if (paramInt == 0) {
        try
        {
          paramPathResult = GoldMsgDialog.a(BitmapFactory.decodeFile(paramPathResult.filePath), DisplayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDialog.getContext(), 5.0F), true);
          if (paramPathResult != null)
          {
            this.a.jdField_a_of_type_MqqAppAppRuntime.runOnUiThread(new xbr(this, paramPathResult));
            return;
          }
        }
        catch (OutOfMemoryError paramPathResult)
        {
          paramPathResult.printStackTrace();
          return;
        }
        catch (Exception paramPathResult)
        {
          paramPathResult.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbq
 * JD-Core Version:    0.7.0.1
 */