import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.webview.UrlSecurityCheckManager.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.aio.video.aio_video.ReqGetUinByOpenId;
import tencent.im.PasswdUrlReport.ReqBody;
import tencent.im.PasswdUrlReport.UploadReqItem;
import tencent.im.oidb.oidb_0xbcb.CheckUrlReq;
import tencent.im.oidb.oidb_0xbcb.ReqBody;

public class aqym
  implements Manager
{
  ArrayList<String> Dg = new ArrayList(64);
  private aqym.b a = new aqyn(this);
  QQAppInterface app;
  boolean cWZ = false;
  boolean cXa = false;
  String cyD;
  String cyE;
  int edI = -1;
  boolean mDestroyed = false;
  Handler mHandler = new Handler(Looper.getMainLooper());
  LruCache<String, aqym.a> w = new LruCache(64);
  
  public aqym(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (jnx.mQ() != 0) {
      bool = true;
    }
    this.cWZ = bool;
    QLog.i("UrlCheckLog", 1, "aio pre check enable=" + this.cWZ);
  }
  
  private void VO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("urlSecMgr", 2, "apply async check " + jqo.filterKeyForLog(paramString, new String[0]));
    }
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      String str;
      do
      {
        return;
        str = paramString;
        if (paramString.length() > 10240) {
          str = paramString.substring(0, 10240);
        }
        paramString = (aqym.a)this.w.get(str);
      } while ((paramString != null) && (paramString.aue > NetConnInfoCenter.getServerTimeMillis()));
      this.Dg.add(str);
      i = this.Dg.size();
    } while (i <= 40);
    this.Dg.subList(0, i - 20).clear();
  }
  
  private void a(Collection<String> paramCollection, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt3, aqym.b paramb)
  {
    oidb_0xbcb.ReqBody localReqBody = new oidb_0xbcb.ReqBody();
    localReqBody.check_url_req.setHasFlag(true);
    if (paramCollection.size() > 20)
    {
      QLog.e("urlSecMgr", 1, "urls size > 20");
      return;
    }
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      i += str.length();
      if (i > 10240)
      {
        QLog.e("urlSecMgr", 1, "url to large");
        return;
      }
      localReqBody.check_url_req.url.add(str);
    }
    if (paramInt1 != -1)
    {
      localReqBody.check_url_req.msg_type.set(paramInt1);
      localReqBody.check_url_req.msg_from.set(paramInt2);
      if (TextUtils.isEmpty(paramString1)) {}
    }
    try
    {
      long l = Long.parseLong(paramString1);
      localReqBody.check_url_req.send_uin.set(l);
      label168:
      if (!TextUtils.isEmpty(paramString2)) {}
      try
      {
        l = Long.parseLong(paramString2);
        localReqBody.check_url_req.msg_chatid.set(l);
        label196:
        localReqBody.check_url_req.qq_pf_to.set(paramString3);
        paramString1 = localReqBody.check_url_req.req_type;
        if (paramInt3 == 2) {
          paramCollection = "aio";
        }
        for (;;)
        {
          paramString1.set(paramCollection);
          if (!TextUtils.isEmpty(paramString4)) {
            localReqBody.check_url_req.original_url.set(paramString4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("urlSecMgr", 2, new Object[] { "send 0xbcb_0 url count=", String.valueOf(localReqBody.check_url_req.url.size()), " originUrl:", paramString4 });
          }
          jnm.a(this.app, new aqyq(this, paramb, paramInt3), localReqBody.toByteArray(), "OidbSvc.0xbcb_0", 3019, 0, null, paramLong);
          return;
          if (paramInt3 == 1) {
            paramCollection = "webview";
          } else {
            paramCollection = "";
          }
        }
      }
      catch (NumberFormatException paramCollection)
      {
        break label196;
      }
    }
    catch (NumberFormatException paramCollection)
    {
      break label168;
    }
  }
  
  private void b(ListView paramListView, wki paramwki)
  {
    long l = System.currentTimeMillis();
    this.Dg.clear();
    int i = paramListView.getFirstVisiblePosition();
    int j = paramListView.getLastVisiblePosition();
    int k = paramListView.getHeaderViewsCount();
    i = Math.max(0, i - k);
    j = Math.min(j - k, paramwki.getCount() - 1);
    if (i <= j)
    {
      paramListView = (ChatMessage)paramwki.getItem(i);
      if (!paramListView.isSend())
      {
        if (!(paramListView instanceof MessageForStructing)) {
          break label113;
        }
        paramListView = ((MessageForStructing)paramListView).structingMsg;
        if (wgv.d(paramListView)) {
          VO(paramListView.mMsgUrl);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label113:
        if ((paramListView instanceof MessageForText))
        {
          paramListView = (MessageForText)paramListView;
          if (paramListView.msg != null)
          {
            paramListView = wgv.ho(paramListView.msg);
            if (paramListView != null) {
              VO(paramListView);
            }
          }
        }
      }
    }
    egx();
    if (QLog.isColorLevel()) {
      QLog.d("urlSecMgr", 2, "pre check cost=" + (System.currentTimeMillis() - l));
    }
  }
  
  private void egx()
  {
    if (this.cXa) {}
    while (this.Dg.size() <= 0) {
      return;
    }
    this.cXa = true;
    HashSet localHashSet = new HashSet(20);
    int j = this.Dg.size() - 1;
    int i = 0;
    String str;
    if ((j >= 0) && (localHashSet.size() < 20))
    {
      str = (String)this.Dg.get(j);
      if (localHashSet.contains(str)) {
        this.Dg.remove(j);
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      i += str.length();
      if (i > 10240)
      {
        a(localHashSet, this.edI, 0, "", this.cyE, this.cyD, "", 0L, 2, this.a);
        return;
      }
      this.Dg.remove(j);
      localHashSet.add(str);
      if (QLog.isColorLevel()) {
        QLog.i("UrlCheckLog", 2, "pre check url=" + jqo.filterKeyForLog(str, new String[0]));
      }
    }
  }
  
  public void a(ListView paramListView, wki paramwki)
  {
    if (!this.cWZ) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      this.mHandler.removeCallbacksAndMessages(null);
      this.Dg.clear();
      paramListView = new WeakReference(paramListView);
      paramwki = new WeakReference(paramwki);
      this.mHandler.postDelayed(new UrlSecurityCheckManager.2(this, paramListView, paramwki), 500L);
    } while (!QLog.isColorLevel());
    QLog.d("urlSecMgr", 2, "new pre check task cost=" + (System.currentTimeMillis() - l));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, aqym.b paramb)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString1;
    if (paramString1.length() > 10240) {
      str = paramString1.substring(0, 10240);
    }
    paramString1 = (aqym.a)this.w.get(str);
    if ((paramString1 != null) && (paramString1.aue > NetConnInfoCenter.getServerTimeMillis()) && (paramString1.edJ == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("UrlCheckLog", 2, "cache hit");
      }
      paramString2 = new Bundle();
      paramString2.putInt("result", paramString1.edJ);
      paramString2.putInt("jumpResult", paramString1.edK);
      paramString2.putString("jumpUrl", paramString1.jumpUrl);
      paramString2.putInt("level", paramString1.level);
      paramString2.putInt("subLevel", paramString1.edL);
      paramString2.putInt("umrType", paramString1.edM);
      paramString2.putInt("retFrom", paramString1.edN);
      paramString2.putLong("operationBit", paramString1.auf);
      paramb.onResult(paramString2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UrlCheckLog", 2, "no cache");
    }
    a(Collections.singletonList(str), paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5, 10000L, 1, paramb);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, aqym.b paramb)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString1);
      long l = Long.parseLong(paramString3);
      paramString1 = new aio_video.ReqGetUinByOpenId();
      paramString1.app_id.set(i);
      paramString1.open_id.set(ByteStringMicro.copyFromUtf8(paramString2));
      paramString1.group_id.set(l);
      jnm.a(this.app, new aqyp(this, paramb), paramString1.toByteArray(), "QQAIOMediaSvc.get_uin_by_openid", null, false);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("urlSecMgr", 2, paramString1.toString());
    }
  }
  
  public void dz(Bundle paramBundle)
  {
    int i = paramBundle.getInt("uploadType", 1);
    String str1 = paramBundle.getString("originUrl");
    String str2 = paramBundle.getString("url");
    String str3 = paramBundle.getString("screenshot");
    String str4 = paramBundle.getString("title");
    String str5 = paramBundle.getString("uin");
    paramBundle.getString("inputText");
    ArrayList localArrayList1 = paramBundle.getStringArrayList("text_features");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("js_func_features");
    int j = paramBundle.getInt("passwdShow", -1);
    paramBundle.getInt("passwdInput", -1);
    int k = paramBundle.getInt("hasVirtualKB", -1);
    paramBundle = new PasswdUrlReport.ReqBody();
    paramBundle.upload_type.set(i);
    PasswdUrlReport.UploadReqItem localUploadReqItem = new PasswdUrlReport.UploadReqItem();
    if (!TextUtils.isEmpty(str1)) {
      localUploadReqItem.origin_url.set(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localUploadReqItem.url.set(str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localUploadReqItem.screenshot.set(str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      localUploadReqItem.title.set(str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      localUploadReqItem.uin.set(ByteStringMicro.copyFromUtf8(str5));
    }
    if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
      localUploadReqItem.text_features.set(localArrayList1);
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
      localUploadReqItem.js_func_features.set(localArrayList2);
    }
    if (k != -1) {
      localUploadReqItem.passwd_input.set(k);
    }
    if (j != -1) {
      localUploadReqItem.passwd_show.set(j);
    }
    paramBundle.upload_req_item.set(localUploadReqItem);
    if (QLog.isColorLevel()) {
      QLog.d("urlSecMgr", 2, new Object[] { "reportAntiPasswd  originUrl:", str1 });
    }
    jnm.a(this.app, new aqyo(this), paramBundle.toByteArray(), "PasswdUrlReport.report", 0, 0, null, 10000L);
  }
  
  public void eb(int paramInt, String paramString)
  {
    if (!this.cWZ) {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
    switch (paramInt)
    {
    default: 
      this.cyD = "";
      this.edI = -1;
      this.cyE = "";
      return;
    case 0: 
      this.cyD = "mqq.c2c";
      this.edI = 0;
      this.cyE = paramString;
      return;
    case 1: 
      this.cyD = "mqq.group";
      this.edI = 2;
      this.cyE = paramString;
      return;
    }
    this.cyD = "mqq.discussion";
    this.edI = 3;
    this.cyE = paramString;
  }
  
  public void onDestroy()
  {
    this.mDestroyed = true;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void onScroll()
  {
    if (!this.cWZ) {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  static class a
  {
    long aue;
    long auf;
    int edJ;
    int edK;
    int edL;
    int edM;
    int edN;
    String jumpUrl;
    int level;
  }
  
  public static abstract interface b
  {
    public abstract void onResult(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqym
 * JD-Core Version:    0.7.0.1
 */