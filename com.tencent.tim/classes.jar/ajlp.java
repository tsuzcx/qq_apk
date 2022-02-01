import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ajlp
{
  public agzj a;
  public angi a;
  public CopyOnWriteArrayList<ajlt> ak = new CopyOnWriteArrayList();
  public akxq c;
  public int fileType;
  
  public static ajlp a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    ajlp localajlp = new ajlp();
    localajlp.jdField_a_of_type_Agzj = new agzj(paramQQAppInterface, paramChatMessage);
    return localajlp;
  }
  
  public static ajlp a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    ajlp localajlp = new ajlp();
    localajlp.jdField_a_of_type_Angi = anfr.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localajlp.fileType = 2;
    return localajlp;
  }
  
  public static ajlp a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    ajlp localajlp = new ajlp();
    akxq localakxq = akxj.a(i, 1);
    localakxq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localajlp.c = localakxq;
    localajlp.fileType = 1;
    return localajlp;
  }
  
  public static List<ajlp> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, xeh paramxeh, ajlt paramajlt)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramxeh == null)) {
      return null;
    }
    paramxeh = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (xeh.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramajlt);
      paramxeh.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!ykm.d((MessageForPic)paramList)))
      {
        paramList = a((MessageForPic)paramList);
        continue;
        if ((paramList instanceof MessageForShortVideo))
        {
          paramList = a(paramQQAppInterface, (MessageForShortVideo)paramList);
          continue;
          if ((paramList instanceof MessageForShortVideo))
          {
            paramList = b(paramQQAppInterface, (MessageForShortVideo)paramList);
            continue;
            if ((paramList instanceof MessageForFile))
            {
              paramList = a(paramQQAppInterface, paramList);
              paramList.fileType = 4;
              continue;
              if ((paramList instanceof MessageForFile))
              {
                paramList = a(paramQQAppInterface, paramList);
                paramList.fileType = 5;
                continue;
                if ((paramList instanceof MessageForTroopFile))
                {
                  paramList = a(paramQQAppInterface, paramList);
                  paramList.fileType = 6;
                  continue;
                  if ((paramList instanceof MessageForTroopFile))
                  {
                    paramList = a(paramQQAppInterface, paramList);
                    paramList.fileType = 7;
                    continue;
                    return paramxeh;
                  }
                }
              }
            }
          }
        }
      }
      paramList = null;
    }
  }
  
  public static ajlp b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    ajlp localajlp = new ajlp();
    localajlp.jdField_a_of_type_Angi = anfr.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localajlp.fileType = 3;
    return localajlp;
  }
  
  public void a(ajlt paramajlt)
  {
    if ((paramajlt != null) && (!this.ak.contains(paramajlt))) {
      this.ak.add(paramajlt);
    }
  }
  
  public void b(ajlt paramajlt)
  {
    if ((paramajlt != null) && (this.ak.contains(paramajlt))) {}
    try
    {
      this.ak.remove(paramajlt);
      return;
    }
    catch (Exception paramajlt)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramajlt.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlp
 * JD-Core Version:    0.7.0.1
 */