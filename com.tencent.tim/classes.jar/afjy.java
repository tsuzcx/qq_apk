import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.a;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.1;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.2;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.3;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.4;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class afjy
{
  private static afjy jdField_a_of_type_Afjy;
  private Vector<afjy.a> C = new Vector();
  private CopyOnWriteArrayList<Client.b> P = new CopyOnWriteArrayList();
  EmojiIPCAlarmer jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer = null;
  private Client jdField_b_of_type_ComTencentMobileqqEmosmClient = new Client();
  private EmojiIPCAlarmer.a jdField_b_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$a = new afjz(this);
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private int seq;
  
  public static afjy a()
  {
    if (jdField_a_of_type_Afjy == null) {}
    try
    {
      if (jdField_a_of_type_Afjy == null) {
        jdField_a_of_type_Afjy = new afjy();
      }
      return jdField_a_of_type_Afjy;
    }
    finally {}
  }
  
  private void cZQ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.P.iterator();
    while (localIterator.hasNext()) {
      ((Client.b)localIterator.next()).onBindedToClient();
    }
  }
  
  private void cZR()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.P.iterator();
    while (localIterator.hasNext()) {
      ((Client.b)localIterator.next()).onDisconnectWithService();
    }
  }
  
  private void cZS()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "alarm init");
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer = new EmojiIPCAlarmer(this.jdField_b_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$a);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.init();
    }
  }
  
  private void cu(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchPushMsg suc");
    }
    Iterator localIterator = this.P.iterator();
    while (localIterator.hasNext()) {
      ((Client.b)localIterator.next()).onPushMsg(paramBundle);
    }
  }
  
  private boolean lT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("ipc_apollo_changerole")) && (!paramString.equals("ipc_apollo_preview")) && (!paramString.equals("ipc_apollo_check_avatar_res")) && (!paramString.equals("ipc_apollo_preview_audio_action")) && (!paramString.equals("ipc_apollo_preview_action")) && (!paramString.equals("IPC_APOLLO_DOWNLOAD_GAME")) && (!paramString.equals("ipc_apollo_downloadImageOnFrame")) && (!paramString.equals("ipc_cmd_apollo_exec_script")) && (!paramString.equals("ipc_apollo_get_playmate_msg"))) {
      return false;
    }
    return true;
  }
  
  public afjy.a a(int paramInt)
  {
    synchronized (this.C)
    {
      Iterator localIterator = this.C.iterator();
      while (localIterator.hasNext())
      {
        afjy.a locala = (afjy.a)localIterator.next();
        if (locala.seq == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "remove req queue seq:" + paramInt);
          }
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.af(locala.gq);
          this.C.remove(locala);
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "after remove req queue size:" + this.C.size());
          }
          return locala;
        }
      }
      return null;
    }
  }
  
  public afjy.a a(Bundle paramBundle)
  {
    synchronized (this.C)
    {
      int i = this.seq;
      this.seq = (i + 1);
      paramBundle = new afjy.a(i, paramBundle);
      cZS();
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "add to req queue seq: " + paramBundle.seq);
      }
      paramBundle.gq = this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.c(paramBundle.seq, 30000L);
      this.C.add(paramBundle);
      return paramBundle;
    }
  }
  
  public Client a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqEmosmClient;
  }
  
  void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle != null) {
      paramBundle.putInt("failcode", paramInt);
    }
  }
  
  public void a(Client.b paramb)
  {
    if (paramb == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "RegisterObserver key:" + paramb.key);
      }
    } while (this.P.contains(paramb));
    this.P.add(paramb);
  }
  
  public boolean ajq()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmosmClient != null) {
      return this.jdField_b_of_type_ComTencentMobileqqEmosmClient.isClientBinded();
    }
    return false;
  }
  
  public void b(Client.b paramb)
  {
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "unRegisterObserver key:" + paramb.key);
      }
      if (this.P.contains(paramb)) {
        this.P.remove(paramb);
      }
    }
  }
  
  public void cq(Bundle paramBundle)
  {
    if (paramBundle == null) {
      QLog.e("Q.emoji.web.EmoWebIPCOperator", 1, "error:reqbundle is null.");
    }
    do
    {
      do
      {
        return;
        localObject = a(paramBundle);
      } while ((localObject == null) || ((this.jdField_b_of_type_ComTencentMobileqqEmosmClient != null) && (this.jdField_b_of_type_ComTencentMobileqqEmosmClient.onReqToServer(((afjy.a)localObject).aK))));
      paramBundle = a(paramBundle.getInt("seq"));
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.seq);
      }
    } while (paramBundle == null);
    Object localObject = new Bundle();
    a((Bundle)localObject, 1002);
    paramBundle.aK.putBundle("response", (Bundle)localObject);
    runOnUiThread(new WebIPCOperator.1(this, paramBundle));
  }
  
  public void cr(Bundle paramBundle)
  {
    if ((paramBundle != null) && ((this.jdField_b_of_type_ComTencentMobileqqEmosmClient == null) || (!this.jdField_b_of_type_ComTencentMobileqqEmosmClient.onReqToServer(paramBundle))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.seq);
      }
      Bundle localBundle = new Bundle();
      a(localBundle, 1002);
      paramBundle.putBundle("response", localBundle);
      runOnUiThread(new WebIPCOperator.2(this, paramBundle));
    }
  }
  
  public void cre()
  {
    cZQ();
  }
  
  public void cs(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("seq");
      localObject = a(i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp seq:" + i);
      }
      if (localObject == null) {
        break label75;
      }
      a(paramBundle, 1000);
      runOnUiThread(new WebIPCOperator.3(this, paramBundle));
    }
    label75:
    do
    {
      return;
      localObject = paramBundle.getString("cmd");
    } while ((localObject == null) || ((!lT((String)localObject)) && (!((String)localObject).equals("startDownloadEmoji")) && (!((String)localObject).equals("stopdownload")) && (!((String)localObject).equals("openEquipmentLock")) && (!((String)localObject).equals("card_setSummaryCard")) && (!((String)localObject).equals("card_getVipInfo")) && (!((String)localObject).equals("closeWeb")) && (!((String)localObject).equals("setMobileResult")) && (!((String)localObject).equals("setWaitingResponse")) && (!((String)localObject).equals("openEmojiMall")) && (!((String)localObject).equals("openProfileCard")) && (!((String)localObject).equals("close_version")) && (!((String)localObject).equals("openEmojiDetail")) && (!((String)localObject).equals("openFontSetting")) && (!((String)localObject).equals("startDownloadColorRing")) && (!((String)localObject).equals("stopDownloadColorRing")) && (!((String)localObject).equals("funcall_download")) && (!((String)localObject).equals("funcall_set")) && (!((String)localObject).equals("getA2")) && (!((String)localObject).equals("openDevLock")) && (!((String)localObject).equals("queryDevLockStatus")) && (!((String)localObject).equals("ipc_funnypic_add")) && (!((String)localObject).equals("ipc_video_isinstalled")) && (!((String)localObject).equals("ipc_video_install_plugin")) && (!((String)localObject).equals("gamecenter_delaydownload")) && (!((String)localObject).equals("emojiStickerRecall")) && (!((String)localObject).equals("ipc_cmd_get_team_work_url"))));
    a(paramBundle, 1000);
    runOnUiThread(new WebIPCOperator.4(this, paramBundle));
  }
  
  public void ct(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("cmd");
    int i = paramBundle.getInt("failcode");
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp suc: " + (String)localObject + ", retCode: " + i);
    }
    localObject = this.P.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Client.b)((Iterator)localObject).next()).onResponse(paramBundle);
    }
  }
  
  public void onDisconnectWithService()
  {
    cZR();
  }
  
  public void onPushMsgFromServer(Bundle paramBundle)
  {
    cu(paramBundle);
  }
  
  void runOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.mHandler.post(paramRunnable);
    }
  }
  
  public static class a
  {
    public Bundle aK;
    Runnable gq;
    int seq;
    
    public a(int paramInt, Bundle paramBundle)
    {
      this.seq = paramInt;
      paramBundle.putInt("seq", paramInt);
      this.aK = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjy
 * JD-Core Version:    0.7.0.1
 */