import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import cooperation.vip.manager.GdtGeneralManager.2;
import cooperation.vip.manager.GdtGeneralManager.3;
import cooperation.vip.manager.GdtGeneralManager.5;
import cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg;
import cooperation.vip.pb.vac_adv_get.VacAdvRsp;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class awmc
{
  private static final awau<awmc, Void> sSingleton = new awmd();
  public HashSet<String> bT = new HashSet();
  public HashMap<Long, qq_ad_get.QQAdGetRsp.AdInfo> bx = new HashMap();
  private qq_ad_get.QQAdGet.DeviceInfo c;
  public WeakReference<awmc.a> callback;
  
  public static awmc a()
  {
    return (awmc)sSingleton.get(null);
  }
  
  public void a(int paramInt, vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    switch (paramInt)
    {
    default: 
      QZLog.e("GdtGeneralManager", "onGdtInfoResponse erro businessType =" + paramInt);
      return;
    }
    a(paramVacAdvRsp);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, awmc.a parama)
  {
    this.callback = new WeakReference(parama);
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new GdtGeneralManager.2(this, paramLong, paramInt1, paramInt2, paramString));
  }
  
  public void a(awlr paramawlr)
  {
    if (paramawlr == null) {
      return;
    }
    if (this.c == null)
    {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new GdtGeneralManager.3(this, paramawlr));
      return;
    }
    awme.a(paramawlr, this.c);
    QZLog.i("GdtGeneralManager", " @getGdtInfo sendAdvInfoExposeOrClickReport");
  }
  
  public void a(vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    if (paramVacAdvRsp == null) {
      return;
    }
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      paramVacAdvRsp = paramVacAdvRsp.vac_adv_msgs.get();
      if ((paramVacAdvRsp == null) || (paramVacAdvRsp.size() <= 0)) {
        break label206;
      }
      paramVacAdvRsp = paramVacAdvRsp.iterator();
      while (paramVacAdvRsp.hasNext())
      {
        vac_adv_get.VacAdvMetaMsg localVacAdvMetaMsg = (vac_adv_get.VacAdvMetaMsg)paramVacAdvRsp.next();
        localArrayList.add(AlumBasicData.a(localVacAdvMetaMsg));
        if ((localVacAdvMetaMsg != null) && (localVacAdvMetaMsg.adv_rsp != null) && (localVacAdvMetaMsg.adv_rsp.report_info != null) && (localVacAdvMetaMsg.adv_rsp.report_info.trace_info != null)) {
          this.bx.put(Long.valueOf(localVacAdvMetaMsg.adv_rsp.report_info.trace_info.aid.get()), localVacAdvMetaMsg.adv_rsp);
        }
      }
      if (this.callback == null) {
        break label198;
      }
    }
    catch (Exception paramVacAdvRsp)
    {
      QZLog.e("GdtGeneralManager", "handleAlumFloatViewData erro");
      return;
    }
    if (this.callback.get() != null)
    {
      ((awmc.a)this.callback.get()).d((AlumBasicData)localArrayList.get(0));
      QZLog.i("GdtGeneralManager", " @getGdtInfo handleAlumFloatViewData success");
      return;
    }
    label198:
    QZLog.i("GdtGeneralManager", " @getGdtInfo handleAlumFloatViewData alumBasicDataList is null");
    return;
    label206:
    QZLog.i("GdtGeneralManager", " @getGdtInfo handleAlumFloatViewData advMetaMsg is null");
  }
  
  public byte[] aM()
  {
    vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
    try
    {
      if (this.c != null) {
        localVacFeedsAdvMetaReq.device_info.set(this.c);
      }
      return localVacFeedsAdvMetaReq.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("GdtGeneralManager", 2, new Object[] { localException.toString() });
      }
    }
  }
  
  public void abW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.bT.add(paramString);
  }
  
  public qq_ad_get.QQAdGet.DeviceInfo b()
  {
    for (;;)
    {
      try
      {
        localObject = new tlm.a();
        ((tlm.a)localObject).aJy = "1018ec";
        localObject = tlm.a(BaseApplicationImpl.getApplication(), (tlm.a)localObject);
        if (localObject == null) {
          continue;
        }
        localObject = ((tlm.b)localObject).b;
        this.c = ((qq_ad_get.QQAdGet.DeviceInfo)localObject);
        if ((QZLog.isColorLevel()) && (this.c != null) && (!TextUtils.isEmpty(this.c.taid_ticket.get()))) {
          QZLog.i("GdtGeneralManager", "@gdttaid  is not null");
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QZLog.e("GdtGeneralManager", 2, new Object[] { localException.toString() });
        continue;
      }
      return this.c;
      localObject = null;
    }
  }
  
  public void c(URL paramURL)
  {
    if (paramURL == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramURL = (HttpURLConnection)paramURL.openConnection();
        paramURL.setRequestMethod("POST");
        paramURL.setConnectTimeout(10000);
        paramURL.setReadTimeout(10000);
        paramURL.setUseCaches(false);
        paramURL.connect();
        int i = paramURL.getResponseCode();
        if (i != 200) {
          break label124;
        }
        bool = true;
        if (!QZLog.isColorLevel()) {
          break;
        }
        QZLog.i("GdtGeneralManager", "@getGdtInfo exporsure rspCode " + i + "， request gdt" + bool);
        return;
      }
      catch (Exception paramURL) {}
      if (!QZLog.isColorLevel()) {
        break;
      }
      QZLog.w("GdtGeneralManager", 2, new Object[] { paramURL.toString() });
      return;
      label124:
      boolean bool = false;
    }
  }
  
  public void eEr()
  {
    ThreadManager.executeOnSubThread(new GdtGeneralManager.5(this));
  }
  
  public HashSet<String> k()
  {
    return this.bT;
  }
  
  public static abstract interface a
  {
    public abstract void d(AlumBasicData paramAlumBasicData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmc
 * JD-Core Version:    0.7.0.1
 */