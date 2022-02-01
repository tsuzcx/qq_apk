import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xrd
  implements View.OnClickListener
{
  xrd(xrc paramxrc) {}
  
  public void onClick(View paramView)
  {
    if (!xrc.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (imm.isSupportSharpAudio())
      {
        Object localObject = (wko.a)wja.a(paramView);
        if (localObject != null)
        {
          localObject = (MessageForVideo)((wko.a)localObject).mMessage;
          xrc.a(this.a.app, this.a.mContext, (MessageForVideo)localObject, this.a.sessionInfo);
          if (((MessageForVideo)localObject).istroop == 1044) {
            anot.a(this.a.app, "dc00898", "", "", "0X800AD93", "0X800AD93", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrd
 * JD-Core Version:    0.7.0.1
 */