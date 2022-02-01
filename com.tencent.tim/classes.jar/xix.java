import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.a;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.a;

public class xix
  implements MessageProgressView.a
{
  public xix(LightVideoItemBuilder paramLightVideoItemBuilder, LightVideoItemBuilder.a parama) {}
  
  public void rs(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.mMessage.frienduin + this.a.mMessage.uniseq))) {
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xix
 * JD-Core Version:    0.7.0.1
 */