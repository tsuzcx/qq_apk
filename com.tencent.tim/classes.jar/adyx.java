import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.a;

public class adyx
  extends acfd
{
  public adyx(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      String str = aqgv.c(this.this$0.app, paramString, false);
      int i = 0;
      while (i < this.this$0.iw.getChildCount())
      {
        Object localObject = this.this$0.iw.getChildAt(i);
        if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof BusinessCardEditActivity.a)) && (paramString.equals(((BusinessCardEditActivity.a)((View)localObject).getTag()).uin)))
        {
          localObject = (TextView)((View)localObject).findViewById(2131372369);
          if (localObject != null) {
            ((TextView)localObject).setText(str);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyx
 * JD-Core Version:    0.7.0.1
 */