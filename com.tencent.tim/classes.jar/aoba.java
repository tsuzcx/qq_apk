import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class aoba
  extends aoau
{
  public aoba(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    Object localObject3;
    String str2;
    Object localObject1;
    Object localObject2;
    if ((this.e != null) && (paramQQAppInterface != null) && (this.a != null))
    {
      localObject3 = aoag.a(this.e);
      str2 = this.e.WeiYunFileId;
      localObject1 = "";
      if (this.e.peerType != 6000)
      {
        localObject2 = localObject3;
        if (this.e.peerType != 6003) {}
      }
      else
      {
        localObject2 = "";
        localObject1 = localObject3;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label291;
      }
    }
    for (;;)
    {
      long l2 = 0L;
      int i;
      long l1;
      long l3;
      if (this.e.peerType == 1)
      {
        i = 3;
        l1 = Long.valueOf(this.e.peerUin).longValue();
        l2 = 0L;
        l3 = 0L;
      }
      for (;;)
      {
        label122:
        paramQQAppInterface = new JSONObject();
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            paramQQAppInterface.put("fileid", localObject1);
            paramQQAppInterface.put("filename", this.e.fileName);
            paramQQAppInterface.put("filesize", this.e.fileSize);
            paramQQAppInterface.put("filetype", i);
            paramQQAppInterface.put("businesstype", this.e.dNP);
            paramQQAppInterface.put("groupuin", l1);
            paramQQAppInterface.put("senderuin", l3);
            paramQQAppInterface.put("discussuin", l2);
            if (!this.e.bSend) {
              continue;
            }
            paramQQAppInterface.put("ownertype", 1);
          }
          catch (JSONException localJSONException)
          {
            label291:
            QLog.e("TeamWorkFileImportJobForFile2Form", 2, "put fileid exception: " + localJSONException.toString());
            continue;
            if (this.e.dNR != 0) {
              continue;
            }
            this.a.k(this.e);
            this.a.b(paramQQAppInterface, this.e);
            return;
            this.a.a(paramQQAppInterface, this.e);
            return;
          }
          this.e.cKX = true;
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (this.e.dNR != 0)) {
            continue;
          }
          this.a.k(this.e);
          this.a.c(paramQQAppInterface, this.e);
          return;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label596;
          }
          if (TextUtils.isEmpty(str2))
          {
            localObject1 = this.e.filePath;
            localObject3 = new File((String)localObject1);
            if ((localObject3 == null) || (!((File)localObject3).exists())) {
              break label596;
            }
            localObject1 = aobk.dU((String)localObject1);
            break;
          }
          localObject1 = str2;
          break;
          if (this.e.peerType == 3000)
          {
            i = 2;
            l2 = Long.valueOf(this.e.peerUin).longValue();
            l3 = 0L;
            l1 = 0L;
            break label122;
          }
          i = 1;
          localObject3 = paramQQAppInterface.b().b(this.e.peerUin, this.e.peerType, this.e.msgUniseq);
          l1 = l2;
          if (localObject3 != null)
          {
            l1 = l2;
            if ((localObject3 instanceof MessageForFile)) {
              l1 = Long.valueOf(((MessageRecord)localObject3).senderuin).longValue();
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label585;
          }
          l3 = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
          l2 = 0L;
          l1 = 0L;
          break label122;
          localObject1 = localObject2;
          continue;
          paramQQAppInterface.put("ownertype", 2);
        }
        label585:
        l2 = 0L;
        l3 = l1;
        l1 = 0L;
      }
      label596:
      String str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoba
 * JD-Core Version:    0.7.0.1
 */