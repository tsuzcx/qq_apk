import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xag
  implements View.OnClickListener
{
  xag(xaf paramxaf) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    Object localObject1 = paramView.getTag();
    if (!(localObject1 instanceof xaf.a)) {}
    xaf.a locala;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      locala = (xaf.a)localObject1;
      localObject1 = xaf.a.a(locala);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      Log.i("AutoVideoItemBuilder", "onClick: empty schema");
      label54:
      localObject1 = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a.mContext, (String)localObject1);
      if (localObject1 != null) {
        ((aqhv)localObject1).ace();
      }
      if ((locala.mMessage instanceof MessageForStructing))
      {
        localObject1 = (MessageForStructing)locala.mMessage;
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgSubImageVideo))
        {
          localObject1 = (StructMsgSubImageVideo)((MessageForStructing)localObject1).structingMsg;
          if (((StructMsgSubImageVideo)localObject1).getVideoItem() == null) {
            break label480;
          }
          localObject1 = ((StructMsgSubImageVideo)localObject1).getVideoItem().title;
          label148:
          if (this.a.sessionInfo == null) {
            break label505;
          }
          anot.a(null, "dc00898", "", this.a.sessionInfo.aTl, "auth_aio", "clk_content", 0, 0, "", "", this.a.sessionInfo.aTn, (String)localObject1);
        }
      }
    }
    int i;
    label223:
    label243:
    int k;
    if ((!((String)localObject1).contains("&width=")) && (!((String)localObject1).contains("?width=")))
    {
      i = 1;
      if ((((String)localObject1).contains("&height=")) || (((String)localObject1).contains("?height="))) {
        break label342;
      }
      if ((i == 0) && (j == 0)) {
        break label514;
      }
      k = ((String)localObject1).indexOf("?");
      if (k >= 0) {
        break label347;
      }
      localObject1 = (String)localObject1 + "?width=" + locala.videoWidth + "&height=" + locala.videoHeight;
    }
    label514:
    for (;;)
    {
      label308:
      Log.i("AutoVideoItemBuilder", "onClick: " + (String)localObject1);
      break label54;
      i = 0;
      break label223;
      label342:
      j = 0;
      break label243;
      label347:
      if (k == ((String)localObject1).length() - 1)
      {
        localObject1 = (String)localObject1 + "width=" + locala.videoWidth + "&height=" + locala.videoHeight;
      }
      else
      {
        if (i != 0) {}
        for (Object localObject2 = (String)localObject1 + "&width=" + locala.videoWidth;; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          if (j == 0) {
            break label308;
          }
          localObject1 = (String)localObject2 + "&height=" + locala.videoHeight;
          break label308;
          label480:
          if (((StructMsgSubImageVideo)localObject1).getImageItem() != null)
          {
            localObject1 = ((StructMsgSubImageVideo)localObject1).getImageItem().title;
            break label148;
          }
          localObject1 = null;
          break label148;
          label505:
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xag
 * JD-Core Version:    0.7.0.1
 */