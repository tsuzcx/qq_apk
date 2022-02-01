package com.tencent.mobileqq.app;

import acbn;
import acff;
import aclu;
import acxw;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import anot;
import aopo;
import aqhq;
import aqmj;
import aqqr;
import aqqr.a;
import aqqs;
import aqqs.a;
import aqva;
import aqvc;
import aurf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.mobileqq.richstatus.RichStatus.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wkh;
import ysf;

public class SignatureManager
  implements Handler.Callback, Manager
{
  private static aqqs jdField_a_of_type_Aqqs;
  public static aqqr.a[] a;
  public static boolean bJq;
  public static final String bpr = acbn.SDCARD_PATH + ".signatureTemplate/";
  public static int cyc = 1;
  public static ConcurrentHashMap<Integer, aqqs> ek;
  private static Lock h;
  public static final String hv = acbn.bmQ + "sign_tpl.json";
  public static final String hw = acbn.bmQ;
  public static final String hx = hw + "/temp";
  public static int mRunningTaskNum;
  public static ConcurrentLinkedQueue<Runnable> z = new ConcurrentLinkedQueue();
  private ConcurrentHashMap<String, RichStatus> J;
  Handler N = null;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aclu(this);
  private aqvc jdField_a_of_type_Aqvc;
  public aqqs b;
  AtomicInteger be = new AtomicInteger(-1);
  private aopo ctrl;
  public QQAppInterface mApp;
  MqqHandler mUIHandler;
  public int oT = -1;
  public int oU = -1;
  
  static
  {
    ek = new ConcurrentHashMap();
    h = new ReentrantLock();
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aqvc = ((aqva)paramQQAppInterface.getManager(47)).a(1);
    this.N = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mUIHandler = new aurf(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.ctrl = ((aopo)this.mApp.getManager(193));
  }
  
  public static void FH(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      mRunningTaskNum -= 1;
      if ((mRunningTaskNum < cyc) && (!z.isEmpty()))
      {
        ThreadManagerV2.excute((Runnable)z.poll(), 32, null, true);
        mRunningTaskNum += 1;
      }
      return;
    }
    finally {}
  }
  
  public static int a(String paramString, ListAdapter paramListAdapter)
  {
    int i = 0;
    while (i < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i);
      if (((localObject instanceof RichStatus)) && (((RichStatus)localObject).feedsId.equals(paramString))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static String a(RichStatus paramRichStatus)
  {
    int k = 0;
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("ver", "1.0");
        localJSONObject1.put("time", String.valueOf(paramRichStatus.time));
        if ((paramRichStatus.actionText != null) && (paramRichStatus.actionText.trim().length() > 0))
        {
          localJSONObject1.put("aid", String.valueOf(paramRichStatus.actionId));
          localJSONObject1.put("actiontext", paramRichStatus.actionText);
        }
        if ((paramRichStatus.dataText != null) && (paramRichStatus.dataText.trim().length() > 0))
        {
          localJSONObject1.put("did", String.valueOf(paramRichStatus.dataId));
          localJSONObject1.put("datatext", paramRichStatus.dataText);
        }
        localJSONObject1.put("loctextpos", String.valueOf(paramRichStatus.locationPosition));
        JSONArray localJSONArray;
        Object localObject;
        if ((paramRichStatus.plainText != null) && (paramRichStatus.plainText.size() > 0))
        {
          j = paramRichStatus.plainText.size();
          localJSONArray = new JSONArray();
          i = 0;
          if (i < j)
          {
            localObject = (String)paramRichStatus.plainText.get(i);
            if (localObject == null) {
              break label766;
            }
            localJSONArray.put(localObject);
            break label766;
          }
          if (localJSONArray.length() > 0) {
            localJSONObject1.put("plaintext", localJSONArray);
          }
        }
        if (paramRichStatus.topics.size() > 0) {
          localJSONObject1.put("topics", paramRichStatus.topicToJson());
        }
        if (paramRichStatus.topicsPos.size() > 0) {
          localJSONObject1.put("topicsPos", paramRichStatus.topicPosToJson());
        }
        if ((paramRichStatus.locationText != null) && (paramRichStatus.locationText.trim().length() > 0)) {
          localJSONObject1.put("loctext", paramRichStatus.locationText);
        }
        if (!TextUtils.isEmpty(paramRichStatus.feedsId)) {
          localJSONObject1.put("feedid", paramRichStatus.feedsId);
        }
        localJSONObject1.put("tplid", paramRichStatus.tplId);
        if ((paramRichStatus.sigZanInfo == null) || (paramRichStatus.sigZanInfo.get(Integer.valueOf(255)) == null)) {
          break label759;
        }
        j = ((RichStatus.a)paramRichStatus.sigZanInfo.get(Integer.valueOf(255))).count;
        i = ((RichStatus.a)paramRichStatus.sigZanInfo.get(Integer.valueOf(255))).zanFlag;
        localJSONObject1.put("count", j);
        localJSONObject1.put("zanfalg", i);
        if ((paramRichStatus.mStickerInfos != null) && (paramRichStatus.mStickerInfos.size() > 0))
        {
          localJSONArray = new JSONArray();
          i = k;
          if (i < paramRichStatus.mStickerInfos.size())
          {
            localObject = (RichStatus.StickerInfo)paramRichStatus.mStickerInfos.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("id", ((RichStatus.StickerInfo)localObject).id);
            localJSONObject2.put("posX", ((RichStatus.StickerInfo)localObject).posX);
            localJSONObject2.put("posY", ((RichStatus.StickerInfo)localObject).posY);
            localJSONObject2.put("width", ((RichStatus.StickerInfo)localObject).width);
            localJSONObject2.put("height", ((RichStatus.StickerInfo)localObject).height);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
          localJSONObject1.put("sticker", localJSONArray);
        }
        localJSONObject1.put("fontId", paramRichStatus.fontId);
        localJSONObject1.put("fontType", paramRichStatus.fontType);
        if (localJSONObject1.length() <= 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded sign is empty,rs.actionText is:" + paramRichStatus.actionText + ",rs.dataText is:" + paramRichStatus.dataText + ",rs.plainText is:" + paramRichStatus.plainText + ",rs.locationText is:" + paramRichStatus.locationText);
          }
          return null;
        }
      }
      catch (JSONException paramRichStatus)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "insertSignMsgIfNeeded failed,error msg is:" + paramRichStatus.getMessage(), paramRichStatus);
        }
        return null;
      }
      return localJSONObject1.toString();
      label759:
      int i = 0;
      int j = 0;
      continue;
      label766:
      i += 1;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus)
  {
    if (!ek.containsKey(Integer.valueOf(paramRichStatus.tplId)))
    {
      paramQQAppInterface = aqqr.a(paramQQAppInterface, paramRichStatus.tplId);
      if (paramQQAppInterface != null) {
        ek.put(Integer.valueOf(paramRichStatus.tplId), paramQQAppInterface);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus, ExtensionInfo paramExtensionInfo, String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    wkh localwkh = (wkh)paramQQAppInterface.getManager(282);
    BeancurdMsg localBeancurdMsg = new BeancurdMsg();
    localBeancurdMsg.frienduin = paramString2;
    localBeancurdMsg.busiid = 1;
    localBeancurdMsg.isNeedDelHistory = true;
    localBeancurdMsg.ispush = true;
    localBeancurdMsg.startTime = NetConnInfoCenter.getServerTime();
    localBeancurdMsg.validTime = 2592000L;
    localBeancurdMsg.buffer = paramString1;
    localwkh.a(localBeancurdMsg);
    aqmj.u(paramQQAppInterface.getCurrentUin(), paramString2, l);
    if (paramExtensionInfo != null)
    {
      paramExtensionInfo.isAdded2C2C = true;
      ((acff)paramQQAppInterface.getManager(51)).a(paramExtensionInfo);
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(paramRichStatus.tplId), "", "", "");
  }
  
  public static boolean a(aqqs paramaqqs)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(paramaqqs.a[0].cwj)) || (!TextUtils.isEmpty(paramaqqs.a[1].cwj)) || (!TextUtils.isEmpty(paramaqqs.a[2].cwj)) || (!TextUtils.isEmpty(paramaqqs.a[3].cwj)) || (!TextUtils.isEmpty(paramaqqs.a[4].cwj))) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, RichStatus paramRichStatus, String paramString)
  {
    boolean bool = false;
    if ((paramRichStatus.isEmpty()) || (TextUtils.isEmpty(paramRichStatus.feedsId)))
    {
      paramRichStatus = paramQQAppInterface.b().b(paramString, 0, new int[] { -1034 });
      if (paramRichStatus != null)
      {
        paramRichStatus = paramRichStatus.iterator();
        while (paramRichStatus.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramRichStatus.next();
          paramQQAppInterface.b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
      ((wkh)paramQQAppInterface.getManager(282)).Q(paramString, 0, 1);
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "insertSignMsgIfNeeded delete signature");
      }
      aqmj.u(paramQQAppInterface.getCurrentUin(), paramString, 0L);
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (((ysf)paramQQAppInterface.getManager(34)).ih(paramString)) {
      return false;
    }
    if (paramQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      return true;
    }
    paramQQAppInterface = new SignatureManager.2(paramRichStatus, paramString);
    z.add(paramQQAppInterface);
    FH(false);
    return true;
  }
  
  private static boolean a(RichStatus paramRichStatus)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = paramRichStatus.time;
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "insertSignMsgIfNeeded serverTime = " + l1 + " richTime = " + paramRichStatus.time);
    }
    return l1 - l2 >= 604800L;
  }
  
  public static boolean existDynamicSource(String paramString)
  {
    paramString = aqqr.cb(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (aqhq.ag(paramString).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public static boolean ks(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (SharpPUtil.isSharpPFile(new File(paramString))) {
        return true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Signature", 2, paramString + " is not a picture");
    return false;
  }
  
  private static boolean z(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    if (paramQQAppInterface.a().a().a(paramString, 0) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "insertSignMsgIfNeeded fail ResentUser = null ");
      }
      bool = true;
    }
    return bool;
  }
  
  public void aC(String paramString)
  {
    if (this.J != null)
    {
      if (paramString != null) {
        this.J.remove(paramString);
      }
    }
    else {
      return;
    }
    this.J.clear();
    this.J = null;
  }
  
  public RichStatus b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.J == null) {}
    try
    {
      if (this.J == null) {
        this.J = new ConcurrentHashMap();
      }
      Object localObject = ((acff)this.mApp.getManager(51)).a(this.mApp.getAccount());
      if (localObject != null)
      {
        localObject = ((ExtensionInfo)localObject).getRichStatus();
        if (localObject != null) {
          this.J.put(((RichStatus)localObject).feedsId, localObject);
        }
      }
      return (RichStatus)this.J.get(paramString);
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    return true;
  }
  
  public void jh(List<RichStatus> paramList)
  {
    if (paramList != null) {
      try
      {
        if (this.J == null) {
          this.J = new ConcurrentHashMap();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)paramList.next();
          if (!TextUtils.isEmpty(localRichStatus.feedsId)) {
            this.J.put(localRichStatus.feedsId, localRichStatus);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy()
  {
    if (this.N != null) {
      this.N.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ArrayOfAqqr$a = null;
    jdField_a_of_type_Aqqs = null;
    aC(null);
    if (this.jdField_a_of_type_Aqvc != null) {
      this.jdField_a_of_type_Aqvc.onDestroy();
    }
    z.clear();
  }
  
  public static class SigCommentInfo
    implements Serializable, Comparable<SigCommentInfo>
  {
    public String feedsid;
    public RichStatus rs;
    public long time;
    public int type;
    public long uin;
    
    public int compareTo(SigCommentInfo paramSigCommentInfo)
    {
      return (int)(paramSigCommentInfo.time - this.time);
    }
  }
  
  public static class SigComments
    implements Serializable
  {
    public boolean isOver;
    public List<SignatureManager.SigCommentInfo> mlist;
  }
  
  public static class TopicInfo
    implements Serializable
  {
    public int friendNum;
    public int topicId;
    public String topicStr;
    public int totalNum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */