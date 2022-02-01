import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.CmShowRscUpdateHandler.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.BspatchUtil;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdReq;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class abis
  implements BusinessObserver
{
  private static abis a;
  private static int cpf = 180;
  private final SparseArray<WeakReference<abis.b>> bV = new SparseArray();
  private WeakReference<AppInterface> mAppRef;
  private final SharedPreferences mSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("cmshow_rsc_update_sp", 4);
  private List<abis.a> wf;
  
  private abis()
  {
    int i = this.mSharedPreferences.getInt("json_content_update_interval", 0);
    if (i >= 10) {
      cpf = i;
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "RscContentUpdateHandler sJsonContentUpdateInterval:" + cpf);
  }
  
  private void Hm(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.bV.get(paramInt);
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((abis.b)localWeakReference.get()).a(false, null);
      this.bV.remove(paramInt);
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckFailed requestId:" + paramInt);
  }
  
  private void O(int paramInt, List<abis.a> paramList)
  {
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource checkResults:" + paramList.size());
      }
      if (paramList.isEmpty()) {}
      for (;;)
      {
        return;
        Object localObject = (AppInterface)this.mAppRef.get();
        if (localObject != null)
        {
          localObject = (aqva)((AppInterface)localObject).getManager(47);
          if ((localObject != null) && (((aqva)localObject).a(3) != null))
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              abis.a locala = (abis.a)paramList.next();
              if (locala != null)
              {
                localObject = new File(locala.qU());
                ((File)localObject).getParentFile().mkdirs();
                if (((File)localObject).exists()) {
                  ((File)localObject).delete();
                }
                String str1 = locala.qZ();
                if ((locala.bDi) && (!new File(str1).exists()))
                {
                  locala.bDi = false;
                  QLog.e("rscContent_CmShowRscUpdateHandler", 1, "updateResource old version File no exist :" + str1);
                }
                if (locala.bDi)
                {
                  if (locala.cK != null)
                  {
                    String str2 = locala.qY();
                    if (aqhq.writeFile(locala.cK, str2))
                    {
                      if (BspatchUtil.D(str1, str2, ((File)localObject).getAbsolutePath()))
                      {
                        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "BspatchUtil.patch success path:" + ((File)localObject).getAbsolutePath());
                        try
                        {
                          str1 = arwv.encodeFileHexStr(((File)localObject).getAbsolutePath());
                          if (QLog.isColorLevel()) {
                            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " updateResource onDone dstMd5:" + str1 + " result.mMd5:" + locala.mMd5);
                          }
                          if (!a(locala, str1)) {
                            break label632;
                          }
                          if (a(locala))
                          {
                            jqp.b((File)localObject, ((File)localObject).getParent() + File.separator);
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile ok file dstpath:" + ((File)localObject).getAbsolutePath());
                            }
                            a(locala.cpj, locala);
                          }
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            ((File)localObject).delete();
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localException.getMessage());
                            }
                            Hm(paramInt);
                            break;
                            boolean bool = aqhq.copyFile(((File)localObject).getAbsolutePath(), localException.qX() + localException.bgw);
                            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
                          }
                        }
                        catch (OutOfMemoryError localOutOfMemoryError)
                        {
                          ((File)localObject).delete();
                        }
                        if (QLog.isColorLevel())
                        {
                          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localOutOfMemoryError.getMessage());
                          continue;
                          label632:
                          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
                          b(localOutOfMemoryError);
                        }
                      }
                      else
                      {
                        QLog.e("rscContent_CmShowRscUpdateHandler", 1, "BspatchUtil.patch failed path:" + ((File)localObject).getAbsolutePath());
                        b(localOutOfMemoryError);
                      }
                    }
                    else {
                      b(localOutOfMemoryError);
                    }
                  }
                  else
                  {
                    a(localOutOfMemoryError);
                  }
                }
                else {
                  b(localOutOfMemoryError);
                }
              }
            }
          }
        }
      }
    }
    a(paramInt, null);
  }
  
  public static abis a()
  {
    try
    {
      if (a == null) {
        a = new abis();
      }
      abis localabis = a;
      return localabis;
    }
    finally {}
  }
  
  private void a(int paramInt, abis.a parama)
  {
    if (parama == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess result" + parama);
    }
    if ((parama.cpg == 100) && (parama.mItemId == 1L))
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        break label299;
      }
      if ("all_room3D".equals(parama.mName)) {
        abip.a().cCh();
      }
    }
    else
    {
      label81:
      a(parama, parama.mVersion);
      if (parama.bDj)
      {
        if (parama.cpi <= 0) {
          break label430;
        }
        if (cpf == parama.cpi) {
          break label392;
        }
        cpf = parama.cpi;
        this.mSharedPreferences.edit().putInt("json_content_update_interval", parama.cpi).commit();
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess interval != result.mCheckServerInterval:" + parama.cpi);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (this.wf != null)
        {
          this.wf.remove(parama);
          if (this.wf.isEmpty())
          {
            this.mSharedPreferences.edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess save lastCheckContentUpdateTS");
          }
        }
        Object localObject = (WeakReference)this.bV.get(paramInt);
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break;
        }
        ((abis.b)((WeakReference)localObject).get()).a(true, parama);
        this.bV.remove(paramInt);
        return;
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "check update from QQ process");
        break label81;
        label299:
        if (!abmt.aY(BaseApplicationImpl.getContext())) {
          break label81;
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
        ((Intent)localObject).putExtra("action_apollo_cmshow_content_update", true);
        ((Intent)localObject).putExtra("key_content_update_zip_name", "all_room3D");
        ((Intent)localObject).setPackage(BaseApplicationImpl.getContext().getPackageName());
        try
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "send sendBroadcast contentUpdate");
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
        }
        catch (Throwable localThrowable)
        {
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, localThrowable, new Object[0]);
        }
      }
      break label81;
      label392:
      if (QLog.isColorLevel())
      {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess interval == result.mCheckServerInterval:" + parama.cpi);
        continue;
        label430:
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess result.mCheckServerInterval <= 0" + parama.cpi);
      }
    }
  }
  
  private void a(int paramInt, CmShowContentUpdate.STContUpdRsp paramSTContUpdRsp, boolean paramBoolean)
  {
    if (paramSTContUpdRsp != null) {
      ThreadManager.post(new CmShowRscUpdateHandler.2(this, paramSTContUpdRsp, paramBoolean, paramInt), 5, null, false);
    }
  }
  
  private void a(abis.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result:" + parama);
    }
    if (parama == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.mAppRef.get();
        } while (localObject == null);
        localObject = (aqva)((AppInterface)localObject).getManager(47);
      } while (localObject == null);
      localObject = ((aqva)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(parama.bgv))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result.mDownloadPatchFileUrl is empty result:" + parama);
      return;
    }
    File localFile = new File(parama.qY());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    aquz localaquz = new aquz(parama.bgv, localFile);
    localaquz.cWy = true;
    localaquz.cWw = true;
    localaquz.cxX = "apollo_res";
    localaquz.retryCount = 1;
    localaquz.cWz = true;
    localaquz.cWA = true;
    localaquz.key = (parama.bgu + "_" + parama.mName);
    ((aqvc)localObject).a(localaquz, new abit(this, localFile, parama), null);
  }
  
  private static boolean a(abis.a parama)
  {
    if (parama == null) {}
    while ((TextUtils.isEmpty(parama.bgw)) || (!parama.bgw.endsWith(".zip"))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(abis.a parama, String paramString)
  {
    if (parama == null) {}
    do
    {
      return false;
      if (TextUtils.isEmpty(parama.mMd5)) {
        return true;
      }
    } while ((paramString == null) || (!paramString.equalsIgnoreCase(parama.mMd5)));
    return true;
  }
  
  private void b(abis.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result:" + parama);
    }
    if ((this.mAppRef == null) || (parama == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.mAppRef.get();
        } while (localObject == null);
        localObject = (aqva)((AppInterface)localObject).getManager(47);
      } while (localObject == null);
      localObject = ((aqva)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(parama.bgu))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result.mDownloadFileUrl is empty result:" + parama);
      return;
    }
    File localFile = new File(parama.qU());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    aquz localaquz = new aquz(parama.bgu, localFile);
    localaquz.cWy = true;
    localaquz.cWw = true;
    localaquz.cxX = "apollo_res";
    localaquz.retryCount = 1;
    localaquz.cWz = true;
    localaquz.cWA = true;
    localaquz.key = (parama.bgu + "_" + parama.mName);
    ((aqvc)localObject).a(localaquz, new abiu(this, localFile, parama), null);
  }
  
  public int a(int paramInt, long paramLong, String paramString)
  {
    return this.mSharedPreferences.getInt(paramInt + "_" + paramLong + "_" + paramString, 0);
  }
  
  public void a(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.mSharedPreferences.edit().putInt(paramInt1 + "_" + paramLong + "_" + paramString, paramInt2).commit();
  }
  
  public void a(int paramInt, abis.b paramb)
  {
    synchronized (this.bV)
    {
      this.bV.put(paramInt, new WeakReference(paramb));
      return;
    }
  }
  
  public void a(abis.a parama, int paramInt)
  {
    if (parama != null)
    {
      this.mSharedPreferences.edit().putInt(parama.qW(), paramInt).commit();
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "saveContentVersion version:" + paramInt);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate forceCheck:" + paramBoolean);
    if (paramAppInterface == null) {}
    do
    {
      return;
      if (!abis.a.a(100, 1L, "all_room3D", "all_room3D.json"))
      {
        a(100, 1L, "all_room3D", 0);
        paramBoolean = true;
      }
      if (!paramBoolean)
      {
        long l = this.mSharedPreferences.getLong("last_json_content_update_ts", 0L);
        if (System.currentTimeMillis() - l < cpf * 1000)
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate in sJsonContentUpdateInterval:" + cpf);
          return;
        }
      }
      this.mAppRef = new WeakReference(paramAppInterface);
      Object localObject1 = new CmShowContentUpdate.STContUpdReq();
      ((CmShowContentUpdate.STContUpdReq)localObject1).app_id.set(1);
      Object localObject2 = new ArrayList();
      Object localObject3 = new CmShowContentUpdate.STContInfo();
      ((CmShowContentUpdate.STContInfo)localObject3).biz_id.set(100);
      ((CmShowContentUpdate.STContInfo)localObject3).item_id.set(1L);
      ((CmShowContentUpdate.STContInfo)localObject3).name.set(ByteStringMicro.copyFromUtf8("all_room3D"));
      ((CmShowContentUpdate.STContInfo)localObject3).ver.set(a(100, 1L, "all_room3D"));
      ((List)localObject2).add(localObject3);
      ((CmShowContentUpdate.STContUpdReq)localObject1).cont_list.set((List)localObject2);
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("3.4.4");
        localObject2 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
        ((WebSSOAgent.UniSsoServerReq)localObject2).pbReqData.set(ByteStringMicro.copyFrom(((CmShowContentUpdate.STContUpdReq)localObject1).toByteArray()));
        localObject1 = new NewIntent(BaseApplicationImpl.getContext(), ailu.class);
        ((NewIntent)localObject1).putExtra("extra_cmd", "cmshowar_content_update.check");
        ((NewIntent)localObject1).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
        ((NewIntent)localObject1).putExtra("extra_callbackid", String.valueOf(paramInt));
        ((NewIntent)localObject1).setObserver(this);
        paramAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("rscContent_CmShowRscUpdateHandler", 2, "OpenPandora failed ", paramAppInterface);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("extra_result_code");
      Object localObject = paramBundle.getString("extra_cmd");
      str = paramBundle.getString("extra_callbackid");
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "isSuccess:" + paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "svrRet:" + paramInt + " cmd:" + (String)localObject + " requestIdStr:" + str);
      }
      if (!paramBoolean) {
        break label281;
      }
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom(arrayOfByte);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "retCode:" + l + " isSuccess:" + paramBoolean + " cmd:" + (String)localObject);
        }
        if ("cmshowar_content_update.check".equals(localObject)) {
          if (l == 0L)
          {
            localObject = new CmShowContentUpdate.STContUpdRsp();
            ((CmShowContentUpdate.STContUpdRsp)localObject).mergeFrom(paramBundle.pbRsqData.get().toByteArray());
            a(ApolloUtil.ck(str), (CmShowContentUpdate.STContUpdRsp)localObject, true);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("rscContent_CmShowRscUpdateHandler", 1, paramBundle, new Object[0]);
        return;
      }
    }
    Hm(ApolloUtil.ck(str));
    return;
    label281:
    Hm(ApolloUtil.ck(str));
  }
  
  public static class a
  {
    public long NA;
    public boolean bDi;
    public boolean bDj;
    public String bgu;
    public String bgv;
    public String bgw;
    public String bgx;
    public byte[] cK;
    public int cpg;
    public int cph;
    public int cpi;
    public int cpj;
    public int cpk;
    public long mItemId;
    public String mMd5;
    public String mName;
    public int mVersion;
    
    public static String a(String paramString1, long paramLong, int paramInt, String paramString2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return "";
      }
      if (paramString1.endsWith("/")) {
        return paramString1 + paramLong + "/" + paramInt + "/" + paramString2;
      }
      return paramString1 + "/" + paramLong + "/" + paramInt + "/" + paramString2;
    }
    
    public static boolean a(int paramInt, long paramLong, String paramString1, String paramString2)
    {
      if (100 == paramInt) {
        return new File(abxi.bin + paramInt + "_" + paramLong + "_" + paramString1 + File.separator + paramString2).exists();
      }
      return false;
    }
    
    public String qU()
    {
      if (100 == this.cpg) {
        return qX() + this.mVersion + ".zip";
      }
      return "";
    }
    
    public String qW()
    {
      return this.cpg + "_" + this.mItemId + "_" + this.mName;
    }
    
    public String qX()
    {
      if (100 == this.cpg) {
        return abxi.bin + qW() + File.separator;
      }
      return "";
    }
    
    public String qY()
    {
      if (100 == this.cpg) {
        return qX() + this.mVersion + "_patch.zip";
      }
      return "";
    }
    
    public String qZ()
    {
      if (100 == this.cpg) {
        return qX() + this.cph + ".zip";
      }
      return "";
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("ContentUpdateCheckResult{");
      localStringBuffer.append("mBuzId=").append(this.cpg);
      localStringBuffer.append(", mItemId=").append(this.mItemId);
      localStringBuffer.append(", mName='").append(this.mName).append('\'');
      localStringBuffer.append(", mVersion=").append(this.mVersion);
      localStringBuffer.append(", mOldVersion=").append(this.cph);
      localStringBuffer.append(", mDownloadFileUrl='").append(this.bgu).append('\'');
      localStringBuffer.append(", mIsPatch=").append(this.bDi);
      localStringBuffer.append(", mPatchData=");
      if (this.cK == null) {
        localStringBuffer.append("null");
      }
      for (;;)
      {
        localStringBuffer.append(", mPatchSize=").append(this.NA);
        localStringBuffer.append(", mDownloadPatchFileUrl='").append(this.bgv).append('\'');
        localStringBuffer.append(", mMd5='").append(this.mMd5).append('\'');
        localStringBuffer.append(", mDownloadFileName='").append(this.bgw).append('\'');
        localStringBuffer.append(", mDownloadPatchFileName='").append(this.bgx).append('\'');
        localStringBuffer.append(", mFlagWriteIntervalTs=").append(this.bDj);
        localStringBuffer.append(", mCheckServerInterval=").append(this.cpi);
        localStringBuffer.append(", mCheckRequestId=").append(this.cpj);
        localStringBuffer.append(", mDomainId=").append(this.cpk);
        localStringBuffer.append('}');
        return localStringBuffer.toString();
        localStringBuffer.append("mPatchData:").append(this.cK);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, abis.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abis
 * JD-Core Version:    0.7.0.1
 */