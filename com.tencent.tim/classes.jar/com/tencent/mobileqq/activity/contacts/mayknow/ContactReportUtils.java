package com.tencent.mobileqq.activity.contacts.mayknow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactReportUtils
{
  private static ReportExposeInterval a = new ReportExposeInterval();
  
  public static void a(a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "setReportExposeIntervalConfig: " + parama);
    }
    if (parama != null)
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq.ReportExposeInterval_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("ReportExposeInterval_enable", parama.isEnable);
        ((SharedPreferences.Editor)localObject).putLong("ReportExposeInterval_interval", parama.interval);
        ((SharedPreferences.Editor)localObject).apply();
        a.Bk(parama.isEnable);
        a.gz(parama.interval);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "reportRecommendList: op_via = " + paramInt + ", " + paramArrayList);
    }
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    Object localObject = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!TextUtils.isEmpty(str)) {
        ((StringBuilder)localObject).append(str).append(",");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    paramArrayList = (ArrayList<String>)localObject;
    if (((String)localObject).length() > 0)
    {
      paramArrayList = (ArrayList<String>)localObject;
      if (((String)localObject).endsWith(",")) {
        paramArrayList = ((String)localObject).substring(0, ((String)localObject).length() - 1);
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("exp_uin", paramArrayList);
      if (paramString1 == null)
      {
        paramArrayList = "";
        if (paramString2 != null) {
          break label261;
        }
        paramString1 = "";
        anot.a(paramQQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_update", paramInt, 0, paramArrayList, paramString1, ((JSONObject)localObject).toString(), "");
      }
    }
    catch (JSONException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("ContactReportUtils", 2, "reportRecommendList error: " + paramArrayList.getMessage());
          continue;
          paramArrayList = paramString1;
          continue;
          label261:
          paramString1 = paramString2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString)
  {
    a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList == null) || (paramArrayList3 == null) || (paramArrayList1.isEmpty()) || (paramArrayList1.size() != paramArrayList2.size()) || (paramArrayList1.size() != paramArrayList.size()) || (paramArrayList1.size() != paramArrayList3.size())) {
      return;
    }
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder3 = new StringBuilder();
      StringBuilder localStringBuilder4 = new StringBuilder();
      int i = 0;
      for (;;)
      {
        if (i < paramArrayList1.size())
        {
          if (i > 0)
          {
            localStringBuilder1.append(",");
            localStringBuilder2.append(",");
            localStringBuilder3.append(",");
            localStringBuilder4.append(",");
          }
          localStringBuilder1.append((String)paramArrayList1.get(i));
          localStringBuilder2.append((String)paramArrayList2.get(i));
          localStringBuilder3.append(paramArrayList.get(i));
          if ((paramArrayList3.get(i) == null) || (((byte[])paramArrayList3.get(i)).length <= 0)) {}
        }
        try
        {
          localStringBuilder4.append(new String((byte[])paramArrayList3.get(i)));
          label245:
          i += 1;
          continue;
          paramArrayList1 = new JSONObject();
          try
          {
            paramArrayList1.put("exp_uin", localStringBuilder1.toString());
            paramArrayList1.put("exp_reason", localStringBuilder2.toString());
            paramArrayList1.put("exp_position", localStringBuilder3.toString());
            paramArrayList1.put("algh_id", localStringBuilder4.toString());
            if (paramBoolean)
            {
              anot.c(paramQQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_exp", paramInt1, 0, String.valueOf(paramInt2), paramString, paramArrayList1.toString(), "");
              return;
            }
          }
          catch (JSONException paramArrayList2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ContactReportUtils", 2, "reportRecommend error: " + paramArrayList2.getMessage());
              }
            }
            anot.a(paramQQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_exp", paramInt1, 0, String.valueOf(paramInt2), paramString, paramArrayList1.toString(), "");
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          break label245;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramArrayOfByte, paramInt4, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, int paramInt4, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("exp_reason", paramString3);
        localJSONObject.put("exp_position", paramInt3);
        String str = "";
        paramString3 = str;
        if (paramArrayOfByte != null)
        {
          paramInt3 = paramArrayOfByte.length;
          paramString3 = str;
          if (paramInt3 <= 0) {}
        }
      }
      catch (JSONException paramString3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("", 2, "reportRecommend error: " + paramString3.getMessage());
        continue;
        paramString3 = paramString4;
        continue;
      }
      try
      {
        paramString3 = new String(paramArrayOfByte);
        localJSONObject.put("algh_id", paramString3);
        if (paramString4 == null)
        {
          paramString3 = "";
          anot.a(paramQQAppInterface, "dc00898", "", paramString1, "frd_recom", paramString2, paramInt1, paramInt2, String.valueOf(paramInt4), paramString3, localJSONObject.toString(), "");
          return;
        }
      }
      catch (Throwable paramString3)
      {
        paramString3 = "";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, String paramString5)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("exp_reason", paramString3);
        localJSONObject.put("exp_position", paramInt3);
        String str = "";
        paramString3 = str;
        if (paramArrayOfByte != null)
        {
          paramInt3 = paramArrayOfByte.length;
          paramString3 = str;
          if (paramInt3 <= 0) {}
        }
      }
      catch (JSONException paramString3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("", 2, "reportRecommend error: " + paramString3.getMessage());
        continue;
        paramString3 = paramString5;
        continue;
      }
      try
      {
        paramString3 = new String(paramArrayOfByte);
        localJSONObject.put("algh_id", paramString3);
        localJSONObject.put("item_tag", paramString4);
        if (paramString5 == null)
        {
          paramString3 = "";
          anot.a(paramQQAppInterface, "dc00898", "", paramString1, "frd_recom", paramString2, paramInt1, paramInt2, String.valueOf(paramInt4), paramString3, localJSONObject.toString(), "");
          return;
        }
      }
      catch (Throwable paramString3)
      {
        paramString3 = "";
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList)
  {
    a(paramQQAppInterface, paramInt, paramArrayList, String.valueOf(23), "3");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "reportRecommendExposeInterval");
    }
    if (a.UW())
    {
      if (a.eA() > 0L)
      {
        a.c(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString);
        a.start(false);
        return;
      }
      a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString, true);
      return;
    }
    a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString, false);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    anot.a(paramQQAppInterface, "dc00898", "", "", "frd_recom", paramString, 0, paramInt1, String.valueOf(paramInt2), "", "", "");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    anot.a(paramQQAppInterface, "dc00898", "", paramString1, "frd_recom", paramString2, 0, 0, "", "", "", "");
  }
  
  public static void cnC()
  {
    if ((a.UW()) && (a.eA() > 0L) && (a.eB() > 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        a.start(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactReportUtils", 2, "flushReportRecommendExposeInterval " + bool);
      }
      return;
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    anot.a(paramQQAppInterface, "dc00898", "", "", "frd_recom", paramString, 0, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static String w(List<MayKnowRecommend.MayKnowRecommendLabel> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append(((MayKnowRecommend.MayKnowRecommendLabel)paramList.get(i)).bytes_name);
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static class ReportExposeInterval
    implements Runnable
  {
    private Handler cb;
    private List<a> ja;
    private volatile long mInterval;
    private volatile boolean mIsOpen;
    private volatile boolean mIsStarted;
    private final Object mLock = new Object();
    private WeakReference<QQAppInterface> n;
    
    ReportExposeInterval()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      this.mIsOpen = false;
      this.mInterval = 0L;
      this.ja = new LinkedList();
      this.cb = new Handler(ThreadManagerV2.getSubThreadLooper());
      bn(localQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("ContactReportUtils", 2, "create ReportExposeInterval, enable = " + this.mIsOpen + ", interval = " + this.mInterval);
      }
    }
    
    private void a(a parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactReportUtils", 2, "really do delay report, mApp = " + this.n);
      }
      if (this.n == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.n.get();
      } while (localQQAppInterface == null);
      ContactReportUtils.a(localQQAppInterface, parama.ccx, parama.rt, parama.ru, parama.rv, parama.rw, parama.displayType, parama.aZS, true);
    }
    
    private void bn(QQAppInterface arg1)
    {
      if (??? != null)
      {
        this.n = new WeakReference(???);
        ??? = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq.ReportExposeInterval_" + ???.getCurrentAccountUin(), 0);
        ContactReportUtils.a locala = new ContactReportUtils.a();
        this.mIsOpen = ???.getBoolean("ReportExposeInterval_enable", locala.isEnable);
        this.mInterval = ???.getLong("ReportExposeInterval_interval", locala.interval);
        synchronized (this.mLock)
        {
          this.ja.clear();
          return;
        }
      }
    }
    
    public void Bk(boolean paramBoolean)
    {
      this.mIsOpen = paramBoolean;
      stop();
    }
    
    public boolean UW()
    {
      return this.mIsOpen;
    }
    
    public void c(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> arg3, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactReportUtils", 2, "reportExpose delay, app = " + paramQQAppInterface);
      }
      if (paramQQAppInterface == null) {
        return;
      }
      QQAppInterface localQQAppInterface = null;
      if (this.n != null) {
        localQQAppInterface = (QQAppInterface)this.n.get();
      }
      if (localQQAppInterface != paramQQAppInterface) {
        bn(paramQQAppInterface);
      }
      paramQQAppInterface = new a();
      paramQQAppInterface.ccx = paramInt1;
      paramQQAppInterface.rt = ???;
      paramQQAppInterface.ru = paramArrayList2;
      paramQQAppInterface.rv = paramArrayList;
      paramQQAppInterface.rw = paramArrayList3;
      paramQQAppInterface.displayType = paramInt2;
      paramQQAppInterface.aZS = paramString;
      synchronized (this.mLock)
      {
        this.ja.add(paramQQAppInterface);
        return;
      }
    }
    
    public long eA()
    {
      return this.mInterval;
    }
    
    public long eB()
    {
      synchronized (this.mLock)
      {
        long l = this.ja.size();
        return l;
      }
    }
    
    public void gz(long paramLong)
    {
      this.mInterval = paramLong;
      if (this.mInterval <= 0L)
      {
        this.mInterval = 0L;
        stop();
      }
    }
    
    public void run()
    {
      if (this.mInterval > 0L)
      {
        ArrayList localArrayList = new ArrayList();
        synchronized (this.mLock)
        {
          localArrayList.addAll(this.ja);
          this.ja.clear();
          if (localArrayList.isEmpty()) {
            break label106;
          }
          ??? = localArrayList.iterator();
          if (((Iterator)???).hasNext()) {
            a((a)((Iterator)???).next());
          }
        }
        this.cb.postDelayed(this, this.mInterval);
      }
      return;
      label106:
      if (QLog.isColorLevel()) {
        QLog.d("ContactReportUtils", 2, "last report size is 0, stop delay report");
      }
      stop();
    }
    
    public void start(boolean paramBoolean)
    {
      try
      {
        if ((!this.mIsStarted) || (paramBoolean))
        {
          this.cb.removeCallbacks(this);
          this.cb.post(this);
          this.mIsStarted = true;
        }
        return;
      }
      finally {}
    }
    
    public void stop()
    {
      try
      {
        this.cb.removeCallbacks(this);
        this.mIsStarted = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    static class a
    {
      String aZS;
      int ccx;
      int displayType;
      ArrayList<String> rt;
      ArrayList<String> ru;
      ArrayList<Integer> rv;
      ArrayList<byte[]> rw;
    }
  }
  
  public static class a
  {
    public long interval = 300000L;
    public boolean isEnable = false;
    
    public String toString()
    {
      return "{isEnable=" + this.isEnable + ",interval=" + this.interval + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils
 * JD-Core Version:    0.7.0.1
 */