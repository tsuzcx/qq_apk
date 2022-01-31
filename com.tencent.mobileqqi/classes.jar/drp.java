import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.adapter.SubAccountMessageAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class drp
  extends FriendListObserver
{
  public drp(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (SubAccountMessageActivity.a(this.a) != null) && (SubAccountMessageActivity.a(this.a).subuin != null) && (paramString != null) && (SubAccountMessageActivity.a(this.a).subuin.equals(paramString)))
    {
      paramString = ContactUtils.b(this.a.b, paramString, false);
      if ((!TextUtils.isEmpty(paramString)) && ((TextUtils.isEmpty(SubAccountMessageActivity.a(this.a).subname)) || (!paramString.equals(SubAccountMessageActivity.a(this.a).subname))))
      {
        SubAccountMessageActivity.a(this.a).subname = paramString;
        if (SubAccountMessageActivity.a(this.a) != null) {
          SubAccountMessageActivity.a(this.a).setText(paramString);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (SubAccountMessageActivity.a(this.a) != null)
      {
        int i = 0;
        while (i < SubAccountMessageActivity.a(this.a).getChildCount())
        {
          View localView = SubAccountMessageActivity.a(this.a).getChildAt(i);
          SubAccountMessageActivity.a(this.a).a(paramString, localView);
          i += 1;
        }
      }
    } while ((SubAccountMessageActivity.a(this.a) == null) || (SubAccountMessageActivity.a(this.a).subuin == null) || (!SubAccountMessageActivity.a(this.a).subuin.equals(paramString)));
    paramString = this.a.b.b(paramString);
    SubAccountMessageActivity.a(this.a).setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drp
 * JD-Core Version:    0.7.0.1
 */