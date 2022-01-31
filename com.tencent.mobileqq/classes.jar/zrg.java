import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import cooperation.comic.VipComicReportUtils;
import java.util.Iterator;
import java.util.List;

public class zrg
  extends MessageObserver
{
  public zrg(QQComicStep paramQQComicStep) {}
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = StructMsgFactory.a(((MessageRecord)paramList.next()).msgData);
        if ((localObject instanceof StructMsgForImageShare))
        {
          localObject = (StructMsgForImageShare)localObject;
          if ((((StructMsgForImageShare)localObject).mMsgActionData != null) && (((StructMsgForImageShare)localObject).mMsgActionData.startsWith("comic_plugin.apk")))
          {
            String[] arrayOfString = ((StructMsgForImageShare)localObject).mMsgActionData.substring(((StructMsgForImageShare)localObject).mMsgActionData.indexOf("|") + 1).split("\\|");
            if (arrayOfString.length >= 8) {
              VipComicReportUtils.a(QQComicStep.a(this.a).a, "3009", "1", "30014", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], AIOGallerySceneWithBusiness.a(((StructMsgForImageShare)localObject).mMsgActionData) });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrg
 * JD-Core Version:    0.7.0.1
 */