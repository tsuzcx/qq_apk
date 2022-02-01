import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class aobs
{
  private aobe b;
  private AbsStructMsg f;
  private MessageForStructing l;
  private QQAppInterface mApp;
  
  public aobs(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    ix();
    this.mApp.addObserver(this.b);
  }
  
  private AbsStructMsg a(Context paramContext, String paramString)
  {
    String str3 = ahav.getFileName(paramString);
    String str1 = ahbj.getExtension(paramString);
    if (aobw.cjR.indexOf(str1) < 0)
    {
      QLog.e("TeamWorkSender", 1, paramString + " is not docs support file");
      return null;
    }
    if (".doc|.docx".contains(str1)) {
      paramString = acfp.m(2131715188);
    }
    for (str1 = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";; str1 = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png")
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.setClass(paramContext, ForwardRecentActivity.class);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("req_type", 95);
      localIntent.putExtra("image_url_remote", str1);
      localIntent.putExtra("pubUin", "");
      localIntent.putExtra("struct_uin", "");
      String str2 = str3;
      if (str3 != null)
      {
        str2 = str3;
        if (str3.length() > 45) {
          str2 = str3.substring(0, 45) + "…";
        }
      }
      localIntent.putExtra("title", str2);
      str3 = paramString;
      if (paramString != null)
      {
        str3 = paramString;
        if (paramString.length() > 60) {
          str3 = paramString.substring(0, 60) + "…";
        }
      }
      localIntent.putExtra("desc", str3);
      localIntent.putExtra("forward_thumb", str1);
      localIntent.putExtra("struct_share_key_content_action", "web");
      localIntent.putExtra("req_share_id", -1L);
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
      localIntent.putExtra("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
      localIntent.putExtra("app_name", acfp.m(2131715207));
      localIntent.putExtra("brief_key", paramContext.getString(2131698632, new Object[] { str2 }));
      return anre.a(localIntent.getExtras());
      paramString = acfp.m(2131715184);
    }
  }
  
  private TeamWorkFileImportInfo a(MessageRecord paramMessageRecord)
  {
    try
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.fileName = paramMessageRecord.getExtInfoFromExtStr("fileName");
      QLog.i("TeamWorkSender", 1, "dmytest");
      localTeamWorkFileImportInfo.filePath = paramMessageRecord.getExtInfoFromExtStr("filePath");
      localTeamWorkFileImportInfo.peerUin = paramMessageRecord.getExtInfoFromExtStr("peerUin");
      localTeamWorkFileImportInfo.cjE = paramMessageRecord.getExtInfoFromExtStr("troopFilePath");
      localTeamWorkFileImportInfo.troopUin = paramMessageRecord.getExtInfoFromExtStr("troopUin");
      localTeamWorkFileImportInfo.dNQ = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("entranceFrom"));
      localTeamWorkFileImportInfo.dNS = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("fileImportType"));
      localTeamWorkFileImportInfo.fileSize = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("fileSize"));
      localTeamWorkFileImportInfo.isFromAIO = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isFromAIO"));
      localTeamWorkFileImportInfo.cLa = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isMessageConvert"));
      localTeamWorkFileImportInfo.cKX = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isNeedDownLoadUrl"));
      localTeamWorkFileImportInfo.cKZ = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isOpenTeamWork"));
      localTeamWorkFileImportInfo.isUserClick = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isUserClick"));
      localTeamWorkFileImportInfo.msgUniseq = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("msgUniseq"));
      localTeamWorkFileImportInfo.nFileType = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("nFileType"));
      localTeamWorkFileImportInfo.nSessionId = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("nSessionId"));
      localTeamWorkFileImportInfo.peerType = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("peerType"));
      localTeamWorkFileImportInfo.dNP = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troopFileBusId"));
      localTeamWorkFileImportInfo.aoR = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("structUniseq"));
      return localTeamWorkFileImportInfo;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("TeamWorkSender", 1, "parse mr info is error");
    }
    return null;
  }
  
  private TeamWorkFileImportInfo a(FileManagerEntity paramFileManagerEntity)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.filePath = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.fileName = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.nFileType = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.isFromAIO = false;
    localTeamWorkFileImportInfo.dNQ = 4;
    localTeamWorkFileImportInfo.fileSize = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.peerType = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.peerUin = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.troopUin = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.dNP = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.cjE = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.msgUniseq = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.cKX = true;
    }
    return localTeamWorkFileImportInfo;
  }
  
  private TeamWorkFileImportInfo a(String paramString)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.filePath = paramString;
    localTeamWorkFileImportInfo.fileName = ahav.getFileName(paramString);
    localTeamWorkFileImportInfo.nFileType = ahav.getFileType(paramString);
    localTeamWorkFileImportInfo.isFromAIO = false;
    localTeamWorkFileImportInfo.dNQ = 4;
    localTeamWorkFileImportInfo.fileSize = ahav.getFileSizes(paramString);
    localTeamWorkFileImportInfo.cKX = false;
    return localTeamWorkFileImportInfo;
  }
  
  private void a(MessageRecord paramMessageRecord, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    paramMessageRecord.saveExtInfoToExtStr("fileName", paramTeamWorkFileImportInfo.fileName);
    paramMessageRecord.saveExtInfoToExtStr("filePath", paramTeamWorkFileImportInfo.filePath);
    paramMessageRecord.saveExtInfoToExtStr("peerUin", paramTeamWorkFileImportInfo.peerUin);
    if (paramTeamWorkFileImportInfo.cjE != null) {}
    for (String str = paramTeamWorkFileImportInfo.cjE;; str = "")
    {
      paramMessageRecord.saveExtInfoToExtStr("troopFilePath", str);
      paramMessageRecord.saveExtInfoToExtStr("troopUin", paramTeamWorkFileImportInfo.troopUin);
      paramMessageRecord.saveExtInfoToExtStr("entranceFrom", String.valueOf(paramTeamWorkFileImportInfo.dNQ));
      paramMessageRecord.saveExtInfoToExtStr("fileImportType", String.valueOf(paramTeamWorkFileImportInfo.dNS));
      paramMessageRecord.saveExtInfoToExtStr("fileSize", String.valueOf(paramTeamWorkFileImportInfo.fileSize));
      paramMessageRecord.saveExtInfoToExtStr("isFromAIO", String.valueOf(paramTeamWorkFileImportInfo.isFromAIO));
      paramMessageRecord.saveExtInfoToExtStr("isMessageConvert", String.valueOf(paramTeamWorkFileImportInfo.cLa));
      paramMessageRecord.saveExtInfoToExtStr("isNeedDownLoadUrl", String.valueOf(paramTeamWorkFileImportInfo.cKX));
      paramMessageRecord.saveExtInfoToExtStr("isOpenTeamWork", String.valueOf(paramTeamWorkFileImportInfo.cKZ));
      paramMessageRecord.saveExtInfoToExtStr("isUserClick", String.valueOf(paramTeamWorkFileImportInfo.isUserClick));
      paramMessageRecord.saveExtInfoToExtStr("msgUniseq", String.valueOf(paramTeamWorkFileImportInfo.msgUniseq));
      paramMessageRecord.saveExtInfoToExtStr("nFileType", String.valueOf(paramTeamWorkFileImportInfo.nFileType));
      paramMessageRecord.saveExtInfoToExtStr("nSessionId", String.valueOf(paramTeamWorkFileImportInfo.nSessionId));
      paramMessageRecord.saveExtInfoToExtStr("peerType", String.valueOf(paramTeamWorkFileImportInfo.peerType));
      paramMessageRecord.saveExtInfoToExtStr("troopFileBusId", String.valueOf(paramTeamWorkFileImportInfo.dNP));
      paramMessageRecord.saveExtInfoToExtStr("structUniseq", String.valueOf(paramTeamWorkFileImportInfo.aoR));
      paramMessageRecord.saveExtInfoToExtStr("strSendUin", paramTeamWorkFileImportInfo.bxe);
      paramMessageRecord.saveExtInfoToExtStr("import_file_message_flag", "import_file_message_flag_value");
      return;
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, int paramInt)
  {
    String str2 = this.mApp.getCurrentAccountUin();
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l1 = i;
    QQAppInterface localQQAppInterface = this.mApp;
    if (TextUtils.isEmpty(paramString)) {}
    for (String str1 = str2;; str1 = paramString)
    {
      this.l = anbi.a(localQQAppInterface, str2, paramString, str1, paramInt, l1, paramAbsStructMsg);
      paramTeamWorkFileImportInfo.aoR = this.l.uniseq;
      a(this.l, paramTeamWorkFileImportInfo);
      this.l.issend = 1;
      this.l.extraflag = 32772;
      paramAbsStructMsg.addFlag(1);
      paramAbsStructMsg.addFlag(2);
      this.mApp.a().f(this.l, 0);
      this.mApp.b().b(this.l, str2);
      paramAbsStructMsg = (aoar)this.mApp.getBusinessHandler(120);
      if (!TextUtils.isEmpty(paramAbsStructMsg.c(paramTeamWorkFileImportInfo))) {
        paramAbsStructMsg.c(paramTeamWorkFileImportInfo);
      }
      if (!paramAbsStructMsg.e(paramTeamWorkFileImportInfo))
      {
        paramAbsStructMsg.j(paramTeamWorkFileImportInfo);
        QLog.i("TeamWorkSender", 1, "start import file:" + this.l.uniseq);
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkSender", 1, "start Import File: " + paramTeamWorkFileImportInfo.fileName);
        }
      }
      return;
    }
  }
  
  private String fs(int paramInt)
  {
    acfp.m(2131715186);
    switch (paramInt)
    {
    case -109: 
    case -105: 
    case -104: 
    default: 
      return acfp.m(2131715162);
    case -102: 
    case -101: 
    case -100: 
      return acfp.m(2131715152);
    case -103: 
      return acfp.m(2131715182);
    case -116: 
    case -106: 
      return acfp.m(2131715180);
    case -107: 
      return acfp.m(2131715144);
    case -108: 
      return acfp.m(2131715196);
    case -110: 
      return acfp.m(2131715183);
    case -111: 
      return acfp.m(2131715165);
    case -115: 
    case -113: 
    case -112: 
      return acfp.m(2131715149);
    }
    return acfp.m(2131715205);
  }
  
  private void ix()
  {
    this.b = new aobt(this);
  }
  
  public boolean a(MessageForStructing paramMessageForStructing, SessionInfo paramSessionInfo)
  {
    this.f = paramMessageForStructing.structingMsg;
    this.l = paramMessageForStructing;
    paramSessionInfo = a(paramMessageForStructing);
    if (paramSessionInfo == null) {
      return false;
    }
    if (paramSessionInfo.aoR == 0L) {
      paramSessionInfo.aoR = this.f.uniseq;
    }
    aoar localaoar = (aoar)this.mApp.getBusinessHandler(120);
    if (!TextUtils.isEmpty(localaoar.c(paramSessionInfo))) {
      localaoar.c(paramSessionInfo);
    }
    if (!localaoar.e(paramSessionInfo)) {
      localaoar.j(paramSessionInfo);
    }
    QLog.i("TeamWorkSender", 1, "structsg resend:" + paramMessageForStructing.uniseq);
    return true;
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    this.f = a(BaseActivity.sTopActivity, paramFileManagerEntity.fileName);
    paramFileManagerEntity = a(paramFileManagerEntity);
    if (this.f != null)
    {
      a(this.f, paramFileManagerEntity, paramString2, paramInt);
      ahau.JH("0X800942C");
    }
  }
  
  public void u(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = ahav.getFileName(paramString1);
    this.f = a(BaseActivity.sTopActivity, paramString2);
    paramString1 = a(paramString1);
    paramString1.peerType = paramInt;
    paramString1.peerUin = paramString3;
    if (this.f != null)
    {
      a(this.f, paramString1, paramString3, paramInt);
      ahau.JH("0X800942C");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobs
 * JD-Core Version:    0.7.0.1
 */