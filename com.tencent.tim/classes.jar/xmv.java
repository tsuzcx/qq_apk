import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView.a;

public class xmv
  implements MessageProgressView.a
{
  public xmv(ShortVideoItemBuilder paramShortVideoItemBuilder, ShortVideoItemBuilder.b paramb) {}
  
  public void rs(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.mMessage.frienduin + this.a.mMessage.uniseq))) {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmv
 * JD-Core Version:    0.7.0.1
 */