import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class afim
  implements Handler.Callback, Manager
{
  private afil a;
  private final Handler cM;
  private EntityManager g;
  private final Map<String, VipComicFavorEmoStructMsgInfo> kh;
  private QQAppInterface mApp;
  
  public afim(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.g = paramQQAppInterface.a().createEntityManager();
    this.a = ((afil)paramQQAppInterface.getBusinessHandler(80));
    this.kh = new ConcurrentHashMap();
    this.cM = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.cM.sendEmptyMessage(91000);
  }
  
  private void b(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    if ((paramVipComicFavorEmoStructMsgInfo != null) && (this.g != null) && (this.g.isOpen()) && (!TextUtils.isEmpty(paramVipComicFavorEmoStructMsgInfo.picMd5)))
    {
      if (paramVipComicFavorEmoStructMsgInfo.getStatus() != 1000) {
        paramVipComicFavorEmoStructMsgInfo.setStatus(1000);
      }
      paramVipComicFavorEmoStructMsgInfo.picMd5 = paramVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase();
      this.g.persistOrReplace(paramVipComicFavorEmoStructMsgInfo);
    }
  }
  
  private void km(List<VipComicFavorEmoStructMsgInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = this.cM.obtainMessage(91002);
      ((Message)localObject).obj = paramList;
      this.cM.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (VipComicFavorEmoStructMsgInfo)paramList.next();
        if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject).picMd5)) {
          this.kh.put(((VipComicFavorEmoStructMsgInfo)localObject).picMd5.toUpperCase(), localObject);
        }
      }
    }
  }
  
  public List<VipComicFavorEmoStructMsgInfo> X(int paramInt)
  {
    Object localObject = al();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)((Iterator)localObject).next();
        if (localVipComicFavorEmoStructMsgInfo.status == paramInt) {
          localArrayList.add(localVipComicFavorEmoStructMsgInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public VipComicFavorEmoStructMsgInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (VipComicFavorEmoStructMsgInfo)this.kh.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public void a(Context paramContext, List<CustomEmotionData> paramList, Map<String, VipComicFavorEmoStructMsgInfo> paramMap, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.isEmpty()) || (paramMap == null) || (paramMap.isEmpty())) {
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      }
    }
    label169:
    label333:
    do
    {
      EntityManager localEntityManager;
      do
      {
        return;
        localEntityManager = this.mApp.a().createEntityManager();
        if (!aqiw.isNetworkAvailable(paramContext)) {
          break label588;
        }
        paramContext = ((aqva)this.mApp.getManager(47)).a(1);
        if (paramContext != null) {
          break;
        }
      } while (paramIPicDownloadListener == null);
      paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
      AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
      afhu localafhu = (afhu)this.mApp.getManager(149);
      int i = 0;
      CustomEmotionData localCustomEmotionData;
      Object localObject;
      if (i < paramList.size())
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        localObject = (VipComicFavorEmoStructMsgInfo)paramMap.get(localCustomEmotionData.md5);
        if (!TextUtils.isEmpty(localCustomEmotionData.url)) {
          break label295;
        }
        localArrayList2.add(localCustomEmotionData);
        localafhu.a(localCustomEmotionData);
        localEntityManager.remove((Entity)localObject);
        localAtomicInteger1.decrementAndGet();
        if (paramIPicDownloadListener != null) {
          paramIPicDownloadListener.onFileDone(localCustomEmotionData, false);
        }
      }
      for (;;)
      {
        if ((localAtomicInteger1.get() == 0) && (paramIPicDownloadListener != null)) {
          paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
        }
        for (;;)
        {
          i += 1;
          break label169;
          break;
          if (paramContext.a(localCustomEmotionData.url) == null) {
            break label333;
          }
          localafhu.a(localCustomEmotionData);
          localEntityManager.remove((Entity)localObject);
          localAtomicInteger1.decrementAndGet();
        }
        File localFile = new File(getFilePath(localCustomEmotionData.md5));
        if (localFile.exists())
        {
          localAtomicInteger1.decrementAndGet();
          localCustomEmotionData.emoPath = localFile.getAbsolutePath();
          if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
            localCustomEmotionData.RomaingType = "isUpdate";
          }
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
          {
            localObject = SecUtil.getFileMd5(localCustomEmotionData.emoPath);
            if (!localCustomEmotionData.md5.equals(localObject)) {
              QLog.i("VipComicMqqManager", 2, "init = " + localCustomEmotionData.md5 + " , compute = " + (String)localObject);
            }
          }
          localafhu.b(localCustomEmotionData);
          localArrayList1.add(localCustomEmotionData);
          if (paramIPicDownloadListener != null) {
            paramIPicDownloadListener.onFileDone(localCustomEmotionData, true);
          }
        }
        else
        {
          aquz localaquz = new aquz(localCustomEmotionData.url, localFile);
          localaquz.cWy = true;
          localaquz.cxX = "comic_emoticon";
          localaquz.retryCount = 3;
          paramContext.a(localaquz, new afin(this, localFile, localCustomEmotionData, localafhu, localArrayList1, paramIPicDownloadListener, localArrayList2, localEntityManager, (VipComicFavorEmoStructMsgInfo)localObject, localAtomicInteger2, localAtomicInteger1), null);
        }
      }
    } while (paramIPicDownloadListener == null);
    label295:
    label588:
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
  
  public void a(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    Message localMessage = this.cM.obtainMessage(91001);
    localMessage.obj = paramVipComicFavorEmoStructMsgInfo;
    this.cM.sendMessage(localMessage);
    this.kh.put(paramVipComicFavorEmoStructMsgInfo.picMd5, paramVipComicFavorEmoStructMsgInfo);
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData)
  {
    return (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)) && (a(paramCustomEmotionData.md5) != null);
  }
  
  public Map<String, VipComicFavorEmoStructMsgInfo> al()
  {
    HashMap localHashMap = null;
    if (!this.kh.isEmpty())
    {
      localHashMap = new HashMap();
      localHashMap.putAll(this.kh);
    }
    return localHashMap;
  }
  
  public void ao(List<VipComicFavorEmoStructMsgInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramBoolean) {
        km(paramList);
      }
      if (this.a != null)
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)localIterator.next();
          MqqComicPb.ComicFavorEmotIcons localComicFavorEmotIcons = new MqqComicPb.ComicFavorEmotIcons();
          localComicFavorEmotIcons.md5.set(localVipComicFavorEmoStructMsgInfo.picMd5);
          localComicFavorEmotIcons.info.set(localVipComicFavorEmoStructMsgInfo.actionData);
          localArrayList.add(localComicFavorEmotIcons);
        }
        this.a.kk(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "setMyComicEmoticon,isNeedSaveDb =" + paramBoolean + " , favorEmoStructMsgInfoList = " + paramList);
        }
      }
    }
  }
  
  public List<CustomEmotionData> bb(List<CustomEmotionData> paramList)
  {
    Object localObject = (afhu)this.mApp.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "Call getEmoticonDataList from getEmoticonList.");
    }
    localObject = ((afhu)localObject).ez();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return new ArrayList();
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
      if ((!"needDel".equals(localCustomEmotionData.RomaingType)) && (paramList != null)) {
        paramList.add(localCustomEmotionData);
      }
    }
    return localObject;
  }
  
  public void cZP()
  {
    List localList = X(1);
    ao(localList, false);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "uploadInitComicEmoStructMsgInfo , comicFavorEmoStructMsgInfoList = " + localList);
    }
  }
  
  public String getFilePath(String paramString)
  {
    String str = aczs.jH(this.mApp.getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramString)) {
      return acbn.bmd + str + "-" + paramString.toUpperCase() + ".jpg";
    }
    return acbn.bmd + str + "-" + paramString + ".jpg";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    String[] arrayOfString = null;
    Object localObject = null;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 91000: 
      if ((this.g == null) || (!this.g.isOpen())) {
        break;
      }
    }
    try
    {
      paramMessage = this.g.query(VipComicFavorEmoStructMsgInfo.class, true, null, null, null, null, null, null);
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipComicFavorEmoStructMsgInfo)paramMessage.next();
          if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject).picMd5)) {
            this.kh.put(((VipComicFavorEmoStructMsgInfo)localObject).picMd5.toUpperCase(), localObject);
          }
        }
      }
      return true;
      if ((paramMessage.obj instanceof VipComicFavorEmoStructMsgInfo)) {
        b((VipComicFavorEmoStructMsgInfo)paramMessage.obj);
      }
      return true;
      try
      {
        paramMessage = (List)paramMessage.obj;
        if ((this.g == null) || (!this.g.isOpen()) || (paramMessage == null) || (paramMessage.size() <= 0)) {}
      }
      catch (Exception paramMessage)
      {
        try
        {
          this.g.getTransaction().begin();
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext()) {
            b((VipComicFavorEmoStructMsgInfo)paramMessage.next());
          }
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          for (;;)
          {
            return true;
            paramMessage = paramMessage;
            paramMessage = null;
            break;
            this.g.getTransaction().commit();
            this.g.getTransaction().end();
          }
        }
        finally
        {
          this.g.getTransaction().end();
        }
      }
      try
      {
        paramMessage = (List)paramMessage.obj;
        if ((this.g != null) && (this.g.isOpen()) && (paramMessage != null) && (paramMessage.size() > 0)) {}
        try
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("status", Integer.valueOf(2));
          arrayOfString = new String[paramMessage.size()];
          StringBuilder localStringBuilder = new StringBuilder(" ( ");
          while (i < paramMessage.size())
          {
            localStringBuilder.append(" ? ");
            if (i != paramMessage.size() - 1) {
              localStringBuilder.append(",");
            }
            arrayOfString[i] = SecurityUtile.encode(((String)paramMessage.get(i)).toUpperCase());
            i += 1;
          }
          localStringBuilder.append(" ) ");
          paramMessage = "picMd5 in " + localStringBuilder.toString();
          this.g.update(VipComicFavorEmoStructMsgInfo.class.getSimpleName(), (ContentValues)localObject, paramMessage, arrayOfString);
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        return true;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramMessage = arrayOfString;
        }
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage = (Message)localObject;
      }
    }
  }
  
  public void kn(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Map localMap = al();
      if ((localMap != null) && (localMap.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = ((String)localIterator.next()).toUpperCase();
          if (localMap.get(str) != null) {
            localArrayList.add(str);
          }
        }
      }
      if ((this.a != null) && (localArrayList.size() > 0))
      {
        this.a.kl(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "delComicStructMsgInfo , delList = " + paramList);
        }
      }
    }
  }
  
  public void ko(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = this.cM.obtainMessage(91003);
      ((Message)localObject).obj = paramList;
      this.cM.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        ((VipComicFavorEmoStructMsgInfo)this.kh.get(((String)localObject).toUpperCase())).status = 2;
      }
    }
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    this.a = null;
    if (this.g != null) {
      this.g.close();
    }
    this.kh.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afim
 * JD-Core Version:    0.7.0.1
 */