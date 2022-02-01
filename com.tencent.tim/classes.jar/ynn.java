import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.a;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.Iterator;
import java.util.List;

public class ynn
  implements ReadInJoySearchTipsContainer.a
{
  public ynn(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void of(String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      Iterator localIterator = this.this$0.sQ.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ChannelInfo)localIterator.next();
      } while (!paramString.equals(((ChannelInfo)localObject).mChannelName));
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      if (paramString != null)
      {
        if (!TextUtils.isEmpty(paramString.mJumpUrl))
        {
          localObject = new Intent(this.this$0, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_operation_bar", true);
          ((Intent)localObject).putExtra("url", paramString.mJumpUrl);
          this.this$0.startActivity((Intent)localObject);
        }
      }
      else {
        return;
      }
      kgw.a(this.this$0, paramString.mChannelID, paramString.mChannelName, paramString.mChannelType, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynn
 * JD-Core Version:    0.7.0.1
 */