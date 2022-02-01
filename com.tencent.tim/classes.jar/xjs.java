import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.QLog;

public class xjs
  implements ajdq<Void>
{
  public xjs(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.b paramb, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void b(Void paramVoid)
  {
    this.a.image.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    MarketFaceItemBuilder.a(this.this$0, this.a.c, -1, this.c.mMarkFaceMessage.copywritingContent);
    xkl.cdP();
    long l = this.a.mMessage.uniseq;
    this.a.tag = this.a.mMessage.uniseq;
    if (this.a.c == null)
    {
      this.a.image.setImageResource(2130838097);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.a.c != null) && (this.a.c.e != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.a.c.e.epId + ":view time = " + (l - this.val$startTime));
      }
      return;
    }
    this.a.image.setContentDescription(acfp.m(2131708049) + this.a.c.e.name);
    if (2 == this.a.c.e.jobType)
    {
      aixk localaixk = (aixk)this.this$0.app.getManager(83);
      boolean bool = false;
      if (this.a.pos == this.a.count - 1) {
        bool = localaixk.ck(this.a.mMessage.uniseq);
      }
      paramVoid = "";
      if (this.c.mMarkFaceMessage != null) {
        if ((this.c.mMarkFaceMessage.mobileparam != null) && (this.c.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramVoid = new String(this.c.mMarkFaceMessage.mobileparam);
          label359:
          localaixk.a(paramVoid, this.a, l, bool, true, new xjt(this));
          this.a.sM.setVisibility(8);
          this.a.sL.setVisibility(8);
          this.a.a.setVisibility(8);
          this.a.te.setVisibility(8);
          this.a.b.setVisibility(8);
          this.a.sS.setVisibility(8);
          this.a.tf.setVisibility(8);
          MarketFaceItemBuilder.b(this.this$0, this.a);
        }
      }
    }
    for (;;)
    {
      if (((2 == this.a.c.e.jobType) || (4 == this.a.c.e.jobType)) && (this.a.a != null))
      {
        this.a.a.setVisibility(8);
        this.a.a.stopAnim();
      }
      if (!this.this$0.bgY) {
        break;
      }
      MarketFaceItemBuilder.d(this.this$0, this.a);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      break label359;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      break label359;
      if (4 == this.a.c.e.jobType)
      {
        if (!this.b.isSend()) {
          anot.a(this.this$0.app, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.a.c.e.epId, "", "", "");
        }
        MarketFaceItemBuilder.a(this.this$0, this.b, this.a);
        MarketFaceItemBuilder.c(this.this$0, this.a);
      }
      else
      {
        MarketFaceItemBuilder.a(this.this$0, this.b, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjs
 * JD-Core Version:    0.7.0.1
 */