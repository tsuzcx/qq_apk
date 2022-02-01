import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class vqn
{
  public static void a(aneo paramaneo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneEntryReporterInLeba", 2, "Leba isTableModel:" + paramBoolean2);
    }
    int i3;
    int i2;
    label53:
    Object localObject1;
    int i;
    int j;
    int n;
    int m;
    int k;
    Object localObject2;
    label126:
    avsd localavsd1;
    label138:
    avsd localavsd2;
    if (paramaneo != null)
    {
      i3 = paramaneo.jn(1);
      if (paramaneo == null) {
        break label685;
      }
      i2 = paramaneo.jn(2);
      localObject1 = "";
      i = 0;
      j = 0;
      int i5 = 0;
      int i4 = 0;
      int i6 = 0;
      int i1 = 0;
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i3 > 0) {
        break label1008;
      }
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i2 > 0) {
        break label1008;
      }
      if (paramaneo == null) {
        break label691;
      }
      localObject2 = paramaneo.b(6);
      if (paramaneo == null) {
        break label697;
      }
      localavsd1 = paramaneo.b(61);
      if (paramaneo == null) {
        break label703;
      }
      localavsd2 = paramaneo.b(3);
      label149:
      k = i1;
      i = j;
      paramaneo = (aneo)localObject1;
      if (localObject2 != null)
      {
        k = i1;
        i = j;
        paramaneo = (aneo)localObject1;
        if (((avsd)localObject2).ES != null)
        {
          k = i1;
          i = j;
          paramaneo = (aneo)localObject1;
          if (((avsd)localObject2).ES.size() > 0)
          {
            k = i1;
            i = j;
            paramaneo = (aneo)localObject1;
            if (((QZoneCountUserInfo)((avsd)localObject2).ES.get(0)).uin > 0L)
            {
              k = i1;
              i = j;
              paramaneo = (aneo)localObject1;
              if (((avsd)localObject2).uCount > 0L)
              {
                k = i1;
                i = j;
                paramaneo = (aneo)localObject1;
                if (!TextUtils.isEmpty(((avsd)localObject2).strShowMsg))
                {
                  paramaneo = ((avsd)localObject2).strShowMsg;
                  k = 1;
                  i = 1;
                }
              }
            }
          }
        }
      }
      i1 = k;
      j = i4;
      localObject1 = paramaneo;
      if (k == 0)
      {
        i1 = k;
        j = i4;
        localObject1 = paramaneo;
        if (localavsd1 != null)
        {
          i1 = k;
          j = i4;
          localObject1 = paramaneo;
          if (localavsd1.ES != null)
          {
            i1 = k;
            j = i4;
            localObject1 = paramaneo;
            if (localavsd1.ES.size() > 0)
            {
              i1 = k;
              j = i4;
              localObject1 = paramaneo;
              if (((QZoneCountUserInfo)localavsd1.ES.get(0)).uin > 0L)
              {
                i1 = k;
                j = i4;
                localObject1 = paramaneo;
                if (localavsd1.uCount > 0L)
                {
                  i1 = k;
                  j = i4;
                  localObject1 = paramaneo;
                  if (!TextUtils.isEmpty(localavsd1.strShowMsg))
                  {
                    localObject1 = localavsd1.strShowMsg;
                    i1 = 1;
                    j = 1;
                  }
                }
              }
            }
          }
        }
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (i1 != 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localavsd2 == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localavsd2.ES == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localavsd2.ES.size() <= 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (((QZoneCountUserInfo)localavsd2.ES.get(0)).uin <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localavsd2.uCount <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localavsd2.strShowMsg)) {
        break label1008;
      }
      paramaneo = localavsd2.strShowMsg;
      n = 1;
      m = 1;
      k = i;
      i = n;
    }
    for (;;)
    {
      if (i == 0) {
        if (i3 <= 0) {
          if (i2 <= 0) {
            if (paramBoolean1)
            {
              i = 1;
              label658:
              if (!paramBoolean2) {
                break label714;
              }
              paramaneo = "1";
              label665:
              LpReportInfo_pf00064.report(637, 13, i, paramaneo, "0", null);
            }
          }
        }
      }
      label685:
      label691:
      label697:
      label703:
      label714:
      label733:
      label762:
      do
      {
        return;
        i3 = 0;
        break;
        i2 = 0;
        break label53;
        localObject2 = null;
        break label126;
        localavsd1 = null;
        break label138;
        localavsd2 = null;
        break label149;
        i = 2;
        break label658;
        paramaneo = "2";
        break label665;
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label762;
          }
          paramaneo = "1";
          if (i2 <= 1) {
            break label768;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, paramaneo, (String)localObject1, null);
          return;
          i = 2;
          break;
          paramaneo = "2";
          break label733;
        }
        if (i2 <= 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label812;
            }
          }
          for (paramaneo = "1";; paramaneo = "2")
          {
            LpReportInfo_pf00064.report(637, 12, i, paramaneo, "0", null);
            return;
            i = 2;
            break;
          }
        }
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label860;
          }
          paramaneo = "1";
          if (i2 <= 1) {
            break label866;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, paramaneo, (String)localObject1, null);
          return;
          i = 2;
          break;
          paramaneo = "2";
          break label831;
        }
        if (m != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label911;
            }
          }
          for (localObject1 = "1";; localObject1 = "2")
          {
            LpReportInfo_pf00064.report(637, 15, i, (String)localObject1, null, paramaneo);
            return;
            i = 2;
            break;
          }
        }
        if (k != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label956;
            }
          }
          for (localObject1 = "1";; localObject1 = "2")
          {
            LpReportInfo_pf00064.report(637, 17, i, (String)localObject1, null, paramaneo);
            return;
            i = 2;
            break;
          }
        }
      } while (j == 0);
      label768:
      label812:
      label831:
      label860:
      label866:
      if (paramBoolean1)
      {
        i = 1;
        if (!paramBoolean2) {
          break label1001;
        }
      }
      label911:
      label956:
      label1001:
      for (localObject1 = "1";; localObject1 = "2")
      {
        LpReportInfo_pf00064.report(637, 16, i, (String)localObject1, null, paramaneo);
        return;
        i = 2;
        break;
      }
      label1008:
      i = n;
      j = m;
      m = 0;
      paramaneo = (aneo)localObject2;
    }
  }
  
  public static void aN(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    QZoneClickReport.a locala = new QZoneClickReport.a();
    locala.actionType = "637";
    locala.cMI = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), locala, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */