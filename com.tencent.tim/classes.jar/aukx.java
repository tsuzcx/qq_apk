import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkFileImportHandler.1;
import com.tencent.tim.teamwork.TeamWorkFileImportHandler.3;
import com.tencent.tim.teamwork.TeamWorkFileImportHandler.4;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class aukx
  extends accg
  implements Handler.Callback
{
  private ConcurrentLinkedQueue<aukz> K;
  private volatile boolean cKV;
  private volatile boolean cKW;
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> iu;
  private ConcurrentHashMap<String, String> iv;
  private Handler mUIHandler;
  
  private String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    String str = "";
    if (paramTeamWorkFileImportInfo.peerType == 1) {
      str = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;
    }
    do
    {
      return str;
      if ((paramTeamWorkFileImportInfo.peerType == 3000) || ((paramTeamWorkFileImportInfo.peerType == 0) && (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.peerUin)))) {
        return paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq;
      }
    } while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath));
    return paramTeamWorkFileImportInfo.filePath;
  }
  
  private void dUf()
  {
    if (this.cKV) {
      return;
    }
    this.cKV = true;
    if (this.K != null) {
      while (!this.K.isEmpty())
      {
        aukz localaukz = (aukz)this.K.poll();
        if (localaukz != null) {
          localaukz.ei(this.app);
        }
      }
    }
    this.cKV = false;
  }
  
  public void QH(boolean paramBoolean)
  {
    this.cKW = paramBoolean;
  }
  
  String a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = null;
    Message localMessage = null;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = localMessage;
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = localMessage;
        int i = ((JSONObject)localObject2).getInt("ret");
        paramString = "";
        localObject1 = localMessage;
        if (((JSONObject)localObject2).has("msg"))
        {
          localObject1 = localMessage;
          paramString = ((JSONObject)localObject2).getString("msg");
        }
        if (i == 0)
        {
          localObject1 = localMessage;
          paramString = ((JSONObject)localObject2).getString("url");
          localObject1 = paramString;
          localObject2 = paramString;
          if (this.mUIHandler != null)
          {
            localObject1 = paramString;
            localObject2 = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              localObject1 = paramString;
              localObject2 = paramString;
              if (this.app != null)
              {
                localObject1 = paramString;
                localObject2 = new Bundle();
                localObject1 = paramString;
                ((Bundle)localObject2).putString("url", paramString);
                localObject1 = paramString;
                ((Bundle)localObject2).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
                localObject1 = paramString;
                localMessage = this.mUIHandler.obtainMessage(8001);
                localObject1 = paramString;
                localMessage.setData((Bundle)localObject2);
                localObject1 = paramString;
                this.mUIHandler.sendMessage(localMessage);
                localObject1 = paramString;
                a(paramTeamWorkFileImportInfo, paramString);
                return paramString;
              }
            }
          }
        }
        else
        {
          localObject1 = localMessage;
          QLog.e("TeamWorkFileImportHandler", 1, "--- parseCheckResult server ret: " + i + ",error: " + paramString);
          return null;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("TeamWorkFileImportHandler", 1, " --- parseCheckResult JSONException: " + paramString.toString());
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramString == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    paramTeamWorkFileImportInfo = a(paramTeamWorkFileImportInfo);
    this.iv.put(paramTeamWorkFileImportInfo, paramString);
  }
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.executeOnNetWorkThread(new TeamWorkFileImportHandler.4(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    boolean bool;
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iu.containsKey(paramTeamWorkFileImportInfo.filePath))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramTeamWorkFileImportInfo.peerType == 1) {}
      for (paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;; paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq)
      {
        if (!this.iu.containsKey(paramTeamWorkFileImportInfo)) {
          break label121;
        }
        bool = true;
        break;
      }
      label121:
      bool = false;
    }
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iu.containsKey(paramTeamWorkFileImportInfo.filePath))) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      if (paramTeamWorkFileImportInfo.peerType == 1) {}
      for (paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;; paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq)
      {
        paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)this.iu.get(paramTeamWorkFileImportInfo);
        if (paramTeamWorkFileImportInfo == null) {
          break label131;
        }
        paramTeamWorkFileImportInfo.cKZ = paramBoolean;
        paramBoolean = true;
        break;
      }
      label131:
      paramBoolean = false;
    }
  }
  
  public boolean a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      localObject1 = paramString.getString("ret");
      localObject2 = paramString.getString("error");
      if ((localObject1 != null) && (((String)localObject1).equals("0")))
      {
        paramString = paramString.getString("url");
        bool1 = bool2;
        if (this.mUIHandler == null) {
          break label188;
        }
        boolean bool4 = TextUtils.isEmpty(paramString);
        bool1 = bool2;
        if (bool4) {
          break label188;
        }
      }
    }
    catch (JSONException paramString)
    {
      Object localObject1;
      Object localObject2;
      label188:
      bool1 = bool3;
    }
    try
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("url", paramString);
      ((Bundle)localObject1).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
      localObject2 = this.mUIHandler.obtainMessage(8001);
      ((Message)localObject2).setData((Bundle)localObject1);
      this.mUIHandler.sendMessage((Message)localObject2);
      a(paramTeamWorkFileImportInfo, paramString);
      return true;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        bool1 = true;
      }
    }
    QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + (String)localObject1 + ",error: " + (String)localObject2);
    bool1 = bool2;
    for (;;)
    {
      return bool1;
      QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResult JSONException: " + paramString.toString());
    }
  }
  
  public String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return null;
    }
    String str = "";
    if (paramTeamWorkFileImportInfo.peerType == 1) {
      str = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;
    }
    for (;;)
    {
      return (String)this.iv.get(str);
      if ((paramTeamWorkFileImportInfo.peerType == 3000) || (paramTeamWorkFileImportInfo.peerType == 0)) {
        str = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq + "_" + paramTeamWorkFileImportInfo.nSessionId;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) {
        str = paramTeamWorkFileImportInfo.filePath;
      }
    }
  }
  
  public boolean b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.app == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    String str = jqc.K(paramString, this.app.getCurrentAccountUin());
    paramString = null;
    if (str != null) {
      paramString = a(str, paramTeamWorkFileImportInfo);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramTeamWorkFileImportInfo, paramString);
      return true;
    }
    return false;
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.K != null) && (paramTeamWorkFileImportInfo != null))
    {
      anot.a(this.app, "CliOper", "", "", "0X8008FB5", "0X8008FB5", 0, 0, "", "", "", "");
      if (paramTeamWorkFileImportInfo.dNQ != 5) {
        break label71;
      }
      this.K.add(new aukv(paramTeamWorkFileImportInfo, this.app));
    }
    for (;;)
    {
      dUf();
      return;
      label71:
      if (paramTeamWorkFileImportInfo.peerType == 1) {
        this.K.add(new aule(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.peerType == 3000) {
        this.K.add(new aulc(paramTeamWorkFileImportInfo, this.app));
      } else {
        this.K.add(new aula(paramTeamWorkFileImportInfo, this.app));
      }
    }
  }
  
  public boolean c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      int n = localJSONObject.getInt("ret");
      if (localJSONObject.has("msg")) {
        localJSONObject.getString("msg");
      }
      String str2 = localJSONObject.getString("error");
      Object localObject1;
      Object localObject2;
      int i;
      label528:
      int j;
      label547:
      int k;
      switch (n)
      {
      case 0: 
        paramTeamWorkFileImportInfo.retCode = n;
        paramTeamWorkFileImportInfo.cjF = str2;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
        break label1291;
        paramString = localJSONObject.getString("url");
        if ((this.mUIHandler != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject1 = this.app;
          if (localObject1 != null) {
            try
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("url", paramString);
              ((Bundle)localObject1).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
              localObject2 = this.mUIHandler.obtainMessage(8001);
              ((Message)localObject2).setData((Bundle)localObject1);
              this.mUIHandler.sendMessage((Message)localObject2);
              a(paramTeamWorkFileImportInfo, paramString);
              return true;
            }
            catch (Exception paramString)
            {
              return true;
            }
          }
        }
        break;
      case 115: 
        localObject1 = "";
        localObject2 = "";
        String str1 = "";
        paramString = (String)localObject1;
        if (localJSONObject.has("filePath"))
        {
          paramString = (String)localObject1;
          if (!TextUtils.isEmpty(localJSONObject.getString("filePath"))) {
            paramString = localJSONObject.getString("filePath");
          }
        }
        localObject1 = localObject2;
        if (localJSONObject.has("md5"))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(localJSONObject.getString("md5"))) {
            localObject1 = localJSONObject.getString("md5");
          }
        }
        localObject2 = str1;
        if (localJSONObject.has("fileName"))
        {
          localObject2 = str1;
          if (!TextUtils.isEmpty(localJSONObject.getString("fileName"))) {
            localObject2 = localJSONObject.getString("fileName");
          }
        }
        str1 = paramTeamWorkFileImportInfo.folderId;
        paramTeamWorkFileImportInfo.redirectUrl = String.format(auko.cjC, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject1, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), URLEncoder.encode(paramString, "UTF-8"), "import" });
        paramTeamWorkFileImportInfo.retCode = n;
        paramTeamWorkFileImportInfo.cjF = str2;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
        return false;
      case 116: 
        paramString = new JSONObject(str2);
        if (paramString.has("startRow"))
        {
          i = paramString.getInt("startRow");
          if (!paramString.has("endRow")) {
            break label1298;
          }
          j = paramString.getInt("endRow");
          if (!paramString.has("startCol")) {
            break label1304;
          }
          k = paramString.getInt("startCol");
          label566:
          if (!paramString.has("endCol")) {
            break label1310;
          }
        }
        break;
      }
      label925:
      label1310:
      for (int m = paramString.getInt("endCol");; m = 0)
      {
        paramString = ault.ft(k);
        localObject1 = ault.ft(m);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720912));
        if ((i != 0) && (k != 0)) {
          if (i == j)
          {
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
            ((StringBuilder)localObject2).append("1");
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720914), new Object[] { String.valueOf(i) }));
            if (k != m) {
              break label925;
            }
            ((StringBuilder)localObject2).append("\n");
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
            ((StringBuilder)localObject2).append("2");
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720913), new Object[] { paramString }));
          }
        }
        for (;;)
        {
          paramTeamWorkFileImportInfo.retCode = n;
          paramTeamWorkFileImportInfo.cjF = ((StringBuilder)localObject2).toString();
          QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.cjF);
          return false;
          ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
          ((StringBuilder)localObject2).append("1");
          ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720911), new Object[] { String.valueOf(i), String.valueOf(j) }));
          break;
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
          ((StringBuilder)localObject2).append("2");
          ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720910), new Object[] { paramString, localObject1 }));
          continue;
          if ((i != 0) && (k == 0))
          {
            if (i == j)
            {
              ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
              ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720914), new Object[] { String.valueOf(i) }));
            }
            else
            {
              ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
              ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720911), new Object[] { String.valueOf(i), String.valueOf(j) }));
            }
          }
          else if ((i == 0) && (k != 0)) {
            if (k == m)
            {
              ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
              ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720913), new Object[] { paramString }));
            }
            else
            {
              ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131720908));
              ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131720910), new Object[] { paramString, localObject1 }));
            }
          }
        }
        break;
        return false;
        i = 0;
        break label528;
        j = 0;
        break label547;
        k = 0;
        break label566;
      }
      label1291:
      label1298:
      label1304:
      return false;
    }
    catch (Exception paramString) {}
  }
  
  public void d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (!paramTeamWorkFileImportInfo.cKX) {
        break label97;
      }
      if (paramTeamWorkFileImportInfo.peerType != 1) {
        break label58;
      }
      this.iu.put(paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE, paramTeamWorkFileImportInfo);
    }
    label58:
    label97:
    while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath))
    {
      return;
      this.iu.put(paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq, paramTeamWorkFileImportInfo);
      return;
    }
    this.iu.put(paramTeamWorkFileImportInfo.filePath, paramTeamWorkFileImportInfo);
  }
  
  public void e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.filePath)) && (this.iu.containsKey(paramTeamWorkFileImportInfo.filePath))) {
        paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.filePath;
      }
      while (!TextUtils.isEmpty(paramTeamWorkFileImportInfo))
      {
        this.iu.remove(paramTeamWorkFileImportInfo);
        return;
        if (paramTeamWorkFileImportInfo.peerType == 1) {
          paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.cjE;
        } else {
          paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.peerUin + "_" + paramTeamWorkFileImportInfo.msgUniseq;
        }
      }
    }
  }
  
  public void f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.mUIHandler != null)
    {
      Message localMessage = this.mUIHandler.obtainMessage(8002);
      localMessage.obj = paramTeamWorkFileImportInfo;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void g(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.executeOnNetWorkThread(new TeamWorkFileImportHandler.1(this, paramTeamWorkFileImportInfo));
  }
  
  public void h(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.executeOnNetWorkThread(new TeamWorkFileImportHandler.3(this, paramTeamWorkFileImportInfo));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      Object localObject = paramMessage.getData();
      paramMessage = (TeamWorkFileImportInfo)((Bundle)localObject).getParcelable("fileInfo");
      localObject = ((Bundle)localObject).getString("url");
      e(paramMessage);
      notifyUI(1, true, new Object[] { localObject, paramMessage });
      anot.a(this.app, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("teamConvert", 2, "convert finish time [" + System.currentTimeMillis() / 1000L + "]");
      }
      if (this.cKW)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131720919), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
        continue;
        paramMessage = (TeamWorkFileImportInfo)paramMessage.obj;
        e(paramMessage);
        notifyUI(2, true, paramMessage);
        if (this.cKW)
        {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720916), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
          continue;
          QQToast.a(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131720923), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
        }
      }
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aulg.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukx
 * JD-Core Version:    0.7.0.1
 */