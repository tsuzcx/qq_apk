import android.widget.ImageView;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.a;
import com.tencent.qphone.base.util.QLog;

public class ufp
  implements ArkAppView.a
{
  public ufp(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void bCR() {}
  
  public void loadSucc()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "arkview loadSucc: " + ArkFullScreenAppActivity.a(this.this$0));
    }
    Object localObject;
    boolean bool;
    if (ArkFullScreenAppActivity.a(this.this$0) != null)
    {
      localObject = ArkFullScreenAppActivity.a(this.this$0).e;
      if (localObject != null)
      {
        if ((!((wyw)localObject).checkShare()) || (!ArkFullScreenAppActivity.a(this.this$0).cUs)) {
          break label135;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("ArkFullScreenAppActivity", 2, "supportShare: " + bool);
        }
        localObject = this.this$0.rightViewImg;
        if (!bool) {
          break label140;
        }
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      return;
      label135:
      bool = false;
      break;
      label140:
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufp
 * JD-Core Version:    0.7.0.1
 */