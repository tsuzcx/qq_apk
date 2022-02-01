import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class alak
{
  private alaj a;
  
  public alak(alaj paramalaj)
  {
    this.a = paramalaj;
  }
  
  public void NA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverReporter", 2, "reportConfigCover");
    }
    if (this.a == null) {}
    for (;;)
    {
      return;
      int i = alan.k(this.a.getApp().getApp(), this.a.getApp().getCurrentAccountUin());
      Object localObject2 = this.a.a(null, null, PrecoverConfig.class);
      HashMap localHashMap = new HashMap();
      localHashMap.put("config_version", String.valueOf(i));
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        localHashMap.put("id_all", localObject1);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          PrecoverConfig localPrecoverConfig = (PrecoverConfig)((Iterator)localObject1).next();
          localHashMap.put("id_" + localPrecoverConfig.businessId, "1");
        }
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.a.getApp().getCurrentAccountUin(), "precover_config_cover", paramBoolean, 0L, 0L, localHashMap, "", false);
      anot.a(this.a.getApp(), "CliOper", "", "", "0X8007133 ", "0X8007133 ", 0, 0, String.valueOf(i), "", "id_all", "");
      if (localObject2 != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PrecoverConfig)((Iterator)localObject1).next();
          anot.a(this.a.getApp(), "CliOper", "", "", "0X8007133 ", "0X8007133 ", 0, 0, String.valueOf(i), "", "id_" + ((PrecoverConfig)localObject2).businessId, "");
        }
      }
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (paramPrecoverResource == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverReporter", 2, "reportDownloadResult, res == null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverReporter", 2, new Object[] { "reportDownloadResult, res=", paramPrecoverResource, ", errCode=", Integer.valueOf(paramInt), ", errDesc=", paramString1, ", keyReason=", paramString2, ", size=", Long.valueOf(paramLong) });
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("url", alan.mD(paramPrecoverResource.url));
    localHashMap.put("md5", paramPrecoverResource.md5);
    localHashMap.put("err_desc", paramString1);
    localHashMap.put("business_id", "id_" + paramPrecoverResource.businessId);
    localHashMap.put("netresp_param_reason", paramString2);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        localHashMap.put("file_size", String.format("%.3f", new Object[] { Float.valueOf((float)paramLong * 1.0F / 1048576.0F) }));
      }
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.a.getApp().getCurrentAccountUin(), "precover_download_result", bool, 0L, paramLong, localHashMap, "", false);
      return;
    }
  }
  
  public void dEH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverReporter", 2, "reportResourceCover");
    }
    if (this.a == null) {}
    Object localObject3;
    do
    {
      return;
      localObject3 = this.a.T();
    } while ((localObject3 == null) || (((HashMap)localObject3).size() == 0));
    Object localObject2 = new HashSet();
    Object localObject4 = (String[])((HashMap)localObject3).keySet().toArray(new String[((HashMap)localObject3).keySet().size()]);
    int i = 0;
    Object localObject5;
    label120:
    Object localObject6;
    boolean bool1;
    if (i < localObject4.length)
    {
      localObject1 = localObject4[i];
      localObject5 = (List)((HashMap)localObject3).get(localObject1);
      if (localObject5 == null) {
        ((HashSet)localObject2).add(localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject5 = ((List)localObject5).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (PrecoverResource)((Iterator)localObject5).next();
          bool1 = alan.aK(((PrecoverResource)localObject6).businessId, ((PrecoverResource)localObject6).md5);
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverReporter", 2, new Object[] { "reportResourceCover: exist=", Boolean.valueOf(bool1), ", res=", localObject6 });
          }
          if (bool1) {
            break label120;
          }
          ((HashSet)localObject2).add(localObject1);
        }
      }
    }
    int j;
    if (((HashSet)localObject2).size() == 0)
    {
      bool1 = true;
      j = alan.k(this.a.getApp().getApp(), this.a.getApp().getCurrentAccountUin());
      localObject5 = new HashMap();
      ((HashMap)localObject5).put("config_version", String.valueOf(j));
      if (!bool1) {
        break label372;
      }
      localObject1 = "1";
      label289:
      ((HashMap)localObject5).put("id_all", localObject1);
      i = 0;
      label301:
      if (i >= localObject4.length) {
        break label386;
      }
      localObject1 = localObject4[i];
      localObject6 = "id_" + (String)localObject1;
      if (!((HashSet)localObject2).contains(localObject1)) {
        break label379;
      }
    }
    label372:
    label379:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      ((HashMap)localObject5).put(localObject6, localObject1);
      i += 1;
      break label301;
      bool1 = false;
      break;
      localObject1 = "0";
      break label289;
    }
    label386:
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.a.getApp().getCurrentAccountUin(), "precover_res_cover", bool1, 0L, 0L, (HashMap)localObject5, "", false);
    localObject4 = this.a.getApp();
    if (bool1)
    {
      localObject1 = "1";
      anot.a((QQAppInterface)localObject4, "CliOper", "", "", "0X8007134", "0X8007134", 0, 0, String.valueOf(j), (String)localObject1, "id_all", "");
      localObject3 = ((HashMap)localObject3).keySet().iterator();
      label474:
      if (!((Iterator)localObject3).hasNext()) {
        break label583;
      }
      localObject4 = (String)((Iterator)localObject3).next();
      localObject5 = this.a.getApp();
      if (!((HashSet)localObject2).contains(localObject4)) {
        break label576;
      }
    }
    label576:
    for (localObject1 = "0";; localObject1 = "1")
    {
      anot.a((QQAppInterface)localObject5, "CliOper", "", "", "0X8007134", "0X8007134", 0, 0, String.valueOf(j), (String)localObject1, "id_" + (String)localObject4, "");
      break label474;
      localObject1 = "0";
      break;
    }
    for (;;)
    {
      try
      {
        label583:
        localObject1 = (afem)this.a.getApp().getManager(77);
        if (localObject1 == null) {
          break;
        }
        localObject1 = (affd)((afem)localObject1).a("qq.android.early.precover");
        if (localObject1 == null) {
          break;
        }
        bool1 = ((affd)localObject1).ajb();
        boolean bool2 = ((affd)localObject1).ajc();
        localObject2 = new HashMap();
        if (!bool1) {
          break label772;
        }
        localObject1 = "1";
        ((HashMap)localObject2).put("storage_exist", localObject1);
        if (!bool2) {
          break label791;
        }
        localObject1 = "1";
        ((HashMap)localObject2).put("backup_exist", localObject1);
        if ((!bool1) || (!bool2)) {
          break label779;
        }
        localObject1 = "1";
        ((HashMap)localObject2).put("all_exist", localObject1);
        localObject1 = anpc.a(BaseApplicationImpl.getContext());
        localObject3 = this.a.getApp().getCurrentAccountUin();
        if ((!bool1) || (!bool2)) {
          break label786;
        }
        bool1 = true;
        ((anpc)localObject1).collectPerformance((String)localObject3, "precover_handler", bool1, 0L, 0L, (HashMap)localObject2, "", false);
        return;
      }
      catch (Throwable localThrowable) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      localThrowable.printStackTrace();
      return;
      label772:
      String str = "0";
      continue;
      label779:
      str = "0";
      continue;
      label786:
      bool1 = false;
      continue;
      label791:
      str = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alak
 * JD-Core Version:    0.7.0.1
 */