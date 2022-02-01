import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;

public class unr
  implements ajdq<afpu>
{
  public unr(ChatHistory.a parama, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void b(afpu paramafpu)
  {
    Object localObject;
    int i;
    if (paramafpu != null)
    {
      this.pC.setTag(paramafpu);
      String str2 = afnu.bEC.replace("[epId]", paramafpu.e.epId);
      String str1 = "";
      localObject = str1;
      if (this.a.mobileparam != null)
      {
        localObject = str1;
        if (this.a.mobileparam.length > 0) {
          localObject = new String(this.a.mobileparam);
        }
      }
      i = aixo.dr((String)localObject);
      if ((!aqhq.fileExists(str2)) || (i != 1)) {
        break label194;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramafpu.ajH())
      {
        this.pC.setVisibility(0);
        localObject = this.jdField_b_of_type_ComTencentMobileqqActivityChatHistory$a.this$0.getResources().getDrawable(2130848001);
        this.pC.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.val$imageView.setMinimumHeight((int)(this.jdField_b_of_type_ComTencentMobileqqActivityChatHistory$a.this$0.mDensity * 100.0F));
        this.val$imageView.setMinimumWidth((int)(this.jdField_b_of_type_ComTencentMobileqqActivityChatHistory$a.this$0.mDensity * 100.0F));
        this.jdField_b_of_type_ComTencentMobileqqActivityChatHistory$a.a(this.val$imageView, i, paramafpu, this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord);
        return;
        label194:
        if (paramafpu.ajI())
        {
          i = 2;
          break;
        }
        if (!paramafpu.ajJ()) {
          break label258;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.pC.setVisibility(0);
          localObject = this.jdField_b_of_type_ComTencentMobileqqActivityChatHistory$a.this$0.getResources().getDrawable(2130838098);
          this.pC.setImageDrawable((Drawable)localObject);
        }
      }
      label258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unr
 * JD-Core Version:    0.7.0.1
 */