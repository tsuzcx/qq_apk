import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class anrx
{
  public static AbsStructMsg a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size(); i <= 0; i = 0) {
      return null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.setFlag(1);
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 19;
    localStructMsgForGeneralShare.mMsgBrief = acfp.m(2131715036);
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "mqqapi://qzone/to_publish_queue";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (i == 1)
    {
      localanqv1 = anrd.a(2);
      localanqv1.a(new ansr((String)paramArrayList.get(0)));
      localanqv1.a(new StructMsgItemTitle(""));
      localanqv1.a(new anux(acfp.m(2131715026)));
      paramArrayList = anrd.a(0);
      paramArrayList.a(new anuv(0));
      localStructMsgForGeneralShare.addItem(localanqv1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      return localStructMsgForGeneralShare;
    }
    anqv localanqv1 = anrd.a(3);
    if (i == 2)
    {
      localanqv1.a(new ansr((String)paramArrayList.get(0)));
      localanqv1.a(new ansr((String)paramArrayList.get(1)));
    }
    for (;;)
    {
      paramArrayList = anrd.a(0);
      paramArrayList.a(new anuv(0));
      anqv localanqv2 = anrd.a(0);
      localanqv2.a(new anux(acfp.m(2131715017)));
      localStructMsgForGeneralShare.addItem(localanqv1);
      localStructMsgForGeneralShare.addItem(paramArrayList);
      localStructMsgForGeneralShare.addItem(localanqv2);
      break;
      localanqv1.a(new ansr((String)paramArrayList.get(0)));
      localanqv1.a(new ansr((String)paramArrayList.get(1)));
      localanqv1.a(new ansr((String)paramArrayList.get(2)));
    }
  }
  
  public static boolean aX(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msgtype != -2011)) {}
    do
    {
      return false;
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
    } while ((paramMessageRecord == null) || (paramMessageRecord.mMsgServiceID != 19));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrx
 * JD-Core Version:    0.7.0.1
 */