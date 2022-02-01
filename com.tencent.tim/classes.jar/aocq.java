import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.2;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aocq
  implements Manager
{
  private List<MessageRecord> GS = new ArrayList();
  private aocs jdField_a_of_type_Aocs;
  private aocw jdField_a_of_type_Aocw;
  private long aoT;
  public long aoU = 0L;
  private String docUrl = "https://docs.qq.com/scenario/createpad.html?";
  private QQAppInterface mApp;
  
  public aocq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aocw = new aocw(paramQQAppInterface);
  }
  
  private boolean V(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    int i = this.jdField_a_of_type_Aocw.getLocalCount();
    int j = aeus.a().getMaxCount();
    boolean bool1;
    if (j == 0)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("AIOMessageSpreadManager", 1, "config is max: 0, return");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        return bool1;
        if (i <= j) {
          break;
        }
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i("AIOMessageSpreadManager", 1, "file count over[" + i + "], return");
      return false;
      if (!(paramChatMessage instanceof MessageForText)) {
        break;
      }
      bool2 = aeus.a().aic();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("AIOMessageSpreadManager", 1, " is Text Switch On:" + bool2);
    return bool2;
    return true;
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2, String paramString3, aeur.b paramb)
  {
    if ((!this.jdField_a_of_type_Aocw.azv()) && (QLog.isColorLevel()))
    {
      QLog.i("AIOMessageSpreadManager", 1, "last insert time less");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + paramString1 + " link:" + paramString2);
    }
    this.jdField_a_of_type_Aocw.aa(paramChatMessage);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new AIOMessageSpreadManager.2(this, paramChatMessage, paramString1, paramb, paramString2, paramString3), 1000L);
  }
  
  private boolean a(char paramChar1, char paramChar2)
  {
    return (d(paramChar1)) && (e(paramChar2));
  }
  
  private List<String> aR(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramString.length();
      int i = 0;
      while (i < j) {
        if (i + 1 < j)
        {
          if (a(paramString.charAt(i), paramString.charAt(i + 1)))
          {
            localArrayList.add(new String(new char[] { paramString.charAt(i), paramString.charAt(i + 1) }));
            i += 2;
          }
          else
          {
            localArrayList.add(String.valueOf(paramString.charAt(i)));
            i += 1;
          }
        }
        else
        {
          localArrayList.add(String.valueOf(paramString.charAt(i)));
          i += 1;
        }
      }
    }
  }
  
  private float c(String paramString1, String paramString2)
  {
    Object localObject3 = aR(paramString1);
    Object localObject2 = aR(paramString2);
    Object localObject1 = new LinkedHashSet();
    paramString1 = new ArrayList();
    paramString2 = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject3 = ((List)localObject3).iterator();
    Object localObject4;
    label148:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (paramString2.containsKey(localObject4))
      {
        Float localFloat = (Float)paramString2.get(localObject4);
        localFloat.floatValue();
        paramString2.put(localObject4, localFloat);
      }
      for (;;)
      {
        if (!((LinkedHashSet)localObject1).add(localObject4)) {
          break label148;
        }
        paramString1.add(localObject4);
        break;
        paramString2.put(localObject4, Float.valueOf(1.0F));
      }
    }
    localObject2 = ((List)localObject2).iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localLinkedHashMap.containsKey(localObject3))
      {
        localObject4 = (Float)localLinkedHashMap.get(localObject3);
        ((Float)localObject4).floatValue();
        localLinkedHashMap.put(localObject3, localObject4);
      }
      for (;;)
      {
        if (!((LinkedHashSet)localObject1).add(localObject3)) {
          break label254;
        }
        paramString1.add(localObject3);
        break;
        localLinkedHashMap.put(localObject3, Float.valueOf(1.0F));
      }
    }
    localObject1 = new ArrayList();
    localObject2 = new ArrayList();
    int i = 0;
    if (i < paramString1.size())
    {
      localObject3 = (String)paramString1.get(i);
      if (paramString2.containsKey(localObject3))
      {
        ((List)localObject1).add(Float.valueOf(((Float)paramString2.get(localObject3)).floatValue()));
        label333:
        if (!localLinkedHashMap.containsKey(localObject3)) {
          break label391;
        }
        ((List)localObject2).add(Float.valueOf(((Float)localLinkedHashMap.get(localObject3)).floatValue()));
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject1).add(Float.valueOf(0.0F));
        break label333;
        label391:
        ((List)localObject2).add(Float.valueOf(0.0F));
      }
    }
    if (((List)localObject1).size() != ((List)localObject2).size()) {
      return 0.0F;
    }
    if (((List)localObject1).size() == 0) {
      return 0.0F;
    }
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    i = 0;
    while (i < ((List)localObject1).size())
    {
      float f4 = ((Float)((List)localObject1).get(i)).floatValue();
      f3 += ((Float)((List)localObject2).get(i)).floatValue() * f4;
      f4 = ((Float)((List)localObject1).get(i)).floatValue();
      f2 += ((Float)((List)localObject1).get(i)).floatValue() * f4;
      f4 = ((Float)((List)localObject2).get(i)).floatValue();
      f1 += ((Float)((List)localObject2).get(i)).floatValue() * f4;
      i += 1;
    }
    return f3 / ((float)Math.pow(f2, 0.5D) * (float)Math.pow(f1, 0.5D));
  }
  
  static boolean d(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar < 56320);
  }
  
  static boolean e(char paramChar)
  {
    return (paramChar >= 56320) && (paramChar < 57344);
  }
  
  public void Z(ChatMessage paramChatMessage)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("AIOMessageSpreadManager", 4, "ready to post to SubThread Process， msgUid[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      if (paramChatMessage.msgUid == 0L) {
        ahav.ti();
      }
    }
    if ((this.aoT == paramChatMessage.uniseq) && ((paramChatMessage instanceof MessageForText))) {
      return;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      this.aoT = paramChatMessage.uniseq;
    }
    ThreadManager.executeOnSubThread(new AIOMessageSpreadManager.1(this, paramChatMessage));
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, SessionInfo paramSessionInfo)
  {
    Object localObject1 = paramChatMessage.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    Object localObject3;
    Object localObject2;
    do
    {
      try
      {
        l = Long.parseLong((String)localObject1);
        localObject1 = this.mApp.b().b(paramChatMessage.frienduin, paramChatMessage.istroop, l);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOMessageSpreadManager", 1, "garyTips not find fileMsg");
          }
          return;
        }
      }
      catch (Exception localException1)
      {
        long l;
        for (;;)
        {
          QLog.e("AIOMessageSpreadManager", 1, localException1.toString());
          l = 0L;
        }
        localObject3 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_type");
        if (((String)localObject3).equalsIgnoreCase("keyword")) {
          anot.a(this.mApp, "dc00898", "", "", "0X8009078", "0X8009078", 0, 0, "", "", "", "");
        }
        while ((localException1 instanceof MessageForFile))
        {
          paramChatMessage = this.mApp.a().c(l, paramChatMessage.frienduin, paramChatMessage.istroop);
          if (paramChatMessage == null)
          {
            QLog.e("AIOMessageSpreadManager", 1, "query Entity is nyll!!!, uniseq[" + l + "]");
            return;
            if (((String)localObject3).equalsIgnoreCase("precent")) {
              anot.a(this.mApp, "dc00898", "", "", "0X800907B", "0X800907B", 0, 0, "", "", "", "");
            } else if (((String)localObject3).equalsIgnoreCase("text_keyword")) {
              anot.a(this.mApp, "dc00898", "", "", "0X8009072", "0X800907B", 0, 0, "", "", "", "");
            }
          }
          else
          {
            aoag.a(paramChatMessage, paramContext, this.mApp, 2);
            return;
          }
        }
      }
      if ((localException1 instanceof MessageForTroopFile))
      {
        paramChatMessage = (MessageForTroopFile)localException1;
        localObject2 = apsv.a(this.mApp, paramChatMessage);
        localObject3 = new TeamWorkFileImportInfo();
        ((TeamWorkFileImportInfo)localObject3).filePath = ((apcy)localObject2).LocalFile;
        ((TeamWorkFileImportInfo)localObject3).fileName = ((apcy)localObject2).FileName;
        ((TeamWorkFileImportInfo)localObject3).dNS = ahav.getFileType(((apcy)localObject2).FileName);
        ((TeamWorkFileImportInfo)localObject3).isFromAIO = true;
        ((TeamWorkFileImportInfo)localObject3).dNQ = 1;
        ((TeamWorkFileImportInfo)localObject3).fileSize = paramChatMessage.fileSize;
        ((TeamWorkFileImportInfo)localObject3).cjE = ((apcy)localObject2).FilePath;
        ((TeamWorkFileImportInfo)localObject3).dNP = ((apcy)localObject2).BusId;
        ((TeamWorkFileImportInfo)localObject3).troopUin = paramSessionInfo.troopUin;
        ((TeamWorkFileImportInfo)localObject3).peerUin = paramSessionInfo.aTl;
        if (((apcy)localObject2).Status != 12) {
          ((TeamWorkFileImportInfo)localObject3).cKX = true;
        }
        ((TeamWorkFileImportInfo)localObject3).peerType = 1;
        aoag.a((TeamWorkFileImportInfo)localObject3, paramContext, this.mApp, ((TeamWorkFileImportInfo)localObject3).dNQ);
        return;
      }
      if (!(localObject2 instanceof MessageForText)) {
        break;
      }
      localObject2 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_id");
      localObject3 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_type");
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_keyword");
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Bundle localBundle = new Bundle();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    try
    {
      if (Integer.parseInt((String)localObject3) == 0) {}
      for (localTeamWorkFileImportInfo.nFileType = 3;; localTeamWorkFileImportInfo.nFileType = 6)
      {
        localBundle.putString("url", this.docUrl + "type=" + (String)localObject3 + "&template_id=" + (String)localObject2 + "&title=" + paramChatMessage);
        localBundle.putBoolean("doc_from_aio", true);
        localTeamWorkFileImportInfo.isFromAIO = true;
        localTeamWorkFileImportInfo.dNQ = 1;
        localTeamWorkFileImportInfo.peerType = paramSessionInfo.cZ;
        localTeamWorkFileImportInfo.peerUin = paramSessionInfo.aTl;
        localTeamWorkFileImportInfo.troopUin = paramSessionInfo.troopUin;
        localTeamWorkFileImportInfo.cLa = true;
        localBundle.putParcelable("key_team_work_file_import_info", localTeamWorkFileImportInfo);
        localBundle.putString("tdsourcetag", "s_qq_aio_grey");
        TeamWorkDocEditBrowserActivity.a(paramContext, localBundle, false);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("AIOMessageSpreadManager", 2, localException2.getMessage());
      }
    }
    QLog.e("AIOMessageSpreadManager", 1, "unknow msg type!");
  }
  
  public void aE(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("AIOMessageSpreadManager", 1, ahav.ti());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "send file:" + paramMessageRecord.msgUid);
    }
    ThreadManager.getUIHandler().postDelayed(new AIOMessageSpreadManager.3(this), 1000L);
    try
    {
      this.GS.add(paramMessageRecord);
      this.aoU = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.aoU + "],lstCache size[" + this.GS.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public void aF(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("tim_aio_gary_uniseq");
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + str + "],targetId[" + paramMessageRecord.msgUid + "], hashCode:" + paramMessageRecord.hashCode());
    }
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      long l = Long.parseLong(str);
      this.mApp.b().d(paramMessageRecord.frienduin, paramMessageRecord.istroop, l, true);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      QLog.e("AIOMessageSpreadManager", 1, paramMessageRecord.toString());
    }
  }
  
  public void b(aeur paramaeur)
  {
    this.jdField_a_of_type_Aocw.c(paramaeur);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocq
 * JD-Core Version:    0.7.0.1
 */