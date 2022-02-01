import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aahw
  implements View.OnClickListener
{
  aahw(aahb paramaahb, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (aahb.a(this.this$0) != null)
    {
      localObject = aahb.a(this.this$0).obtainMessage(1134028);
      aahb.a(this.this$0).sendMessage((Message)localObject);
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("bookid", this.LV);
    ((Intent)localObject).putExtra("chapterid", this.bde);
    ((Intent)localObject).putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(aahb.a(this.this$0), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    aahb.a(this.this$0).startActivity(localIntent);
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahw
 * JD-Core Version:    0.7.0.1
 */