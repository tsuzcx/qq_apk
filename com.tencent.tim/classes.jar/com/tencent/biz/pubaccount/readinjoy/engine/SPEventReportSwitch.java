package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import awit;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import kxm;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReportConditionParam;

public class SPEventReportSwitch
{
  private static int aNL = -1;
  private static int aNM = -2;
  private static int aNN = -1;
  private static int aNO = -2;
  private static int aNP = -1;
  private static int aNQ = -2;
  private static int aNR = -1;
  private static int aNS = -2;
  private static int aNT = -1;
  private static int aNU = 30;
  private static int aNV = -1;
  private static int aNW = 30;
  private static int aNX = -1;
  private static int aNY;
  private static SparseArray<Boolean> ab = new SparseArray();
  private static HashMap<Integer, SPEventReportCondition> dG;
  private static long tU = -1L;
  
  public static boolean BM()
  {
    boolean bool = true;
    if (aNX == -1)
    {
      SharedPreferences localSharedPreferences = awit.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (aNX = aNY; aNX == 1; aNX = localSharedPreferences.getInt("kd_user_idle_report", aNY)) {
        return true;
      }
      return false;
    }
    if (aNX == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickGapInSeconds");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_gap_in_seconds", i);
      awit.a(paramAppRuntime, true);
      aNM = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_count_limit", i);
      awit.a(paramAppRuntime, true);
      aNN = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void c(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_push_algo_id", i);
      awit.a(paramAppRuntime, true);
      aNP = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void cf(List<oidb_cmd0x80a.ReportConditionParam> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (dG == null) {
      dG = new HashMap();
    }
    for (int i = 1;; i = 0)
    {
      int k = 0;
      label25:
      label174:
      int j;
      label129:
      label257:
      int m;
      if (k < paramList.size())
      {
        oidb_cmd0x80a.ReportConditionParam localReportConditionParam = (oidb_cmd0x80a.ReportConditionParam)paramList.get(k);
        if (!localReportConditionParam.uint32_event_id.has()) {
          break label397;
        }
        SPEventReportCondition localSPEventReportCondition = (SPEventReportCondition)dG.get(Integer.valueOf(localReportConditionParam.uint32_event_id.get()));
        if (localSPEventReportCondition != null) {
          break label394;
        }
        localSPEventReportCondition = new SPEventReportCondition();
        SPEventReportCondition.access$102(localSPEventReportCondition, new ArrayList());
        dG.put(Integer.valueOf(localReportConditionParam.uint32_event_id.get()), localSPEventReportCondition);
        i = 1;
        boolean bool;
        if ((localReportConditionParam.uint32_report_next_time.has()) && (localReportConditionParam.uint32_report_next_time.get() != 0)) {
          bool = true;
        }
        for (;;)
        {
          if (bool != localSPEventReportCondition.needReportNextTime)
          {
            SPEventReportCondition.access$002(localSPEventReportCondition, bool);
            i = 1;
            j = i;
            if (localReportConditionParam.report_time_seg.has())
            {
              List localList = localReportConditionParam.report_time_seg.get();
              TreeSet localTreeSet = new TreeSet();
              j = 0;
              for (;;)
              {
                if (j < localList.size())
                {
                  localTreeSet.add(Integer.valueOf(((Long)localList.get(j)).intValue()));
                  j += 1;
                  continue;
                  bool = false;
                  break;
                }
              }
              j = 0;
              if (j >= localSPEventReportCondition.timeSeq.size()) {
                break label385;
              }
              if (!((TreeSet)localSPEventReportCondition.timeSeq.get(j)).equals(localTreeSet)) {
                break;
              }
              m = 1;
              label292:
              j = i;
              if (m == 0)
              {
                localSPEventReportCondition.timeSeq.add(localTreeSet);
                j = 1;
              }
            }
            QLog.d("ReadinjoySPEventReport", 2, "update eventID : " + localReportConditionParam.uint32_event_id.get() + ", condition : " + localSPEventReportCondition);
            i = j;
          }
        }
      }
      label385:
      label394:
      label397:
      for (;;)
      {
        k += 1;
        break label25;
        j += 1;
        break label257;
        if (i == 0) {
          break;
        }
        kxm.b("idle_high_frequency_report_condition", dG, true);
        return;
        m = 0;
        break label292;
        break label174;
        break label129;
      }
    }
  }
  
  public static void d(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_tab_click_forbid_report_time_in_seconds", i);
      awit.a(paramAppRuntime, true);
      aNR = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static boolean dB(int paramInt)
  {
    boolean bool2 = false;
    if (dC(paramInt)) {
      return true;
    }
    if ((dG == null) || (dG.isEmpty())) {
      return false;
    }
    SPEventReportCondition localSPEventReportCondition = (SPEventReportCondition)dG.get(Integer.valueOf(paramInt));
    boolean bool1 = bool2;
    if (localSPEventReportCondition != null) {
      if (!localSPEventReportCondition.needReportNextTime)
      {
        bool1 = bool2;
        if (localSPEventReportCondition.timeSeq == null) {}
      }
      else
      {
        if (!localSPEventReportCondition.needReportNextTime) {
          break label265;
        }
      }
    }
    label259:
    label265:
    for (bool1 = true;; bool1 = false)
    {
      int i = Calendar.getInstance().get(11) * 3600 + Calendar.getInstance().get(12) * 60 + Calendar.getInstance().get(13);
      if ((localSPEventReportCondition.timeSeq != null) && (!localSPEventReportCondition.timeSeq.isEmpty()))
      {
        paramInt = 0;
        while (paramInt < localSPEventReportCondition.timeSeq.size())
        {
          TreeSet localTreeSet = (TreeSet)localSPEventReportCondition.timeSeq.get(paramInt);
          Object localObject = (Integer)localTreeSet.floor(Integer.valueOf(i));
          if (localObject == null) {
            break label259;
          }
          Integer localInteger;
          do
          {
            localTreeSet.remove(localObject);
            localInteger = (Integer)localTreeSet.floor(Integer.valueOf(i));
            localObject = localInteger;
          } while (localInteger != null);
          if (localTreeSet.size() == 1)
          {
            localTreeSet.clear();
            localSPEventReportCondition.timeSeq.remove(localTreeSet);
          }
          bool1 = true;
          paramInt += 1;
        }
      }
      for (;;)
      {
        if (bool1) {
          kxm.b("idle_high_frequency_report_condition", dG, true);
        }
        return bool1;
        break;
      }
    }
  }
  
  /* Error */
  private static boolean dC(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 69	com/tencent/biz/pubaccount/readinjoy/engine/SPEventReportSwitch:ab	Landroid/util/SparseArray;
    //   6: iload_0
    //   7: invokevirtual 301	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 303	java/lang/Boolean
    //   13: ifnonnull +21 -> 34
    //   16: getstatic 69	com/tencent/biz/pubaccount/readinjoy/engine/SPEventReportSwitch:ab	Landroid/util/SparseArray;
    //   19: iload_0
    //   20: iconst_1
    //   21: invokestatic 306	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: invokevirtual 309	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   27: iconst_1
    //   28: istore_1
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_1
    //   36: goto -7 -> 29
    //   39: astore_2
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramInt	int
    //   28	8	1	bool	boolean
    //   39	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	27	39	finally
  }
  
  public static void e(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_fore_ground_gap_in_seconds", i);
      awit.a(paramAppRuntime, true);
      aNT = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void f(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_screen_switch_in_seconds", i);
      awit.a(paramAppRuntime, true);
      aNV = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static void g(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("SPEventReportSwitch", 1, "failed to update sp updateTabClickCountLimit");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kd_user_idle_report", i);
      awit.a(paramAppRuntime, true);
      aNX = i;
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public static int ou()
  {
    if (aNP == -1)
    {
      SharedPreferences localSharedPreferences = awit.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (aNP = aNQ;; aNP = localSharedPreferences.getInt("kd_tab_click_push_algo_id", aNQ)) {
        return aNP;
      }
    }
    return aNP;
  }
  
  public static int ov()
  {
    if (aNT == -1)
    {
      SharedPreferences localSharedPreferences = awit.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (aNT = aNU;; aNT = localSharedPreferences.getInt("kd_fore_ground_gap_in_seconds", aNU)) {
        return aNT;
      }
    }
    return aNT;
  }
  
  public static int ow()
  {
    if (aNV == -1)
    {
      SharedPreferences localSharedPreferences = awit.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {}
      for (aNV = aNW;; aNV = localSharedPreferences.getInt("kd_screen_switch_in_seconds", aNW)) {
        return aNV;
      }
    }
    return aNV;
  }
  
  public static void qK(int paramInt)
  {
    if (paramInt == ou()) {
      tU = System.currentTimeMillis();
    }
  }
  
  public static class SPEventReportCondition
    implements Serializable
  {
    private boolean needReportNextTime;
    private ArrayList<TreeSet<Integer>> timeSeq;
    
    public String toString()
    {
      return "SPEventReportCondition{needReportNextTime=" + this.needReportNextTime + ", timeSeq=" + this.timeSeq + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch
 * JD-Core Version:    0.7.0.1
 */