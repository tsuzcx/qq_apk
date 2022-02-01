import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.UinSearcher.1.3;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class amkt
  extends acnl
{
  amkt(amks paramamks) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (amks.a(this.a) != null)
      {
        amks.a(this.a).dismiss();
        amks.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(amks.a(this.a), paramArrayOfLong)) || (!paramString1.equals(amks.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + amks.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString2)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString2, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131721537, 0).show();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ampw> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!TextUtils.equals(paramString2, amks.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + amks.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + amks.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label768:
    label806:
    label837:
    label1228:
    label1233:
    label1239:
    label1258:
    label1266:
    label1401:
    do
    {
      return;
      paramString3 = (Context)amks.a(this.a).get();
      paramList1 = (QQAppInterface)amks.b(this.a).get();
      try
      {
        if (amks.a(this.a) != null)
        {
          amks.a(this.a).dismiss();
          amks.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + amks.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + amks.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(amks.a(this.a), paramArrayOfLong)) || (!paramString1.equals(amks.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + amks.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new amow[1];
        paramString4 = new amow[1];
        amks.a(this.a, 4);
        ausj localausj = ausj.b(paramString3);
        amku localamku = new amku(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, localausj);
        amkv localamkv = new amkv(this, paramList1);
        paramString2 = (acff)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localausj.setMainTitle(String.format(paramString3.getString(2131696503), new Object[] { amks.a(this.a) }));
          localausj.bk(2131692330, 1, 2131362369);
          localausj.bk(2131693407, 1, 2131362370);
          localausj.bk(2131692643, 1, 2131362368);
          localausj.bk(2131689837, 1, 2131362366);
          if ((!amks.a(this.a).isSend()) && (!amks.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.isFriend(amks.a(this.a).senderuin))) {
            localausj.bk(2131689848, 1, 2131362367);
          }
          localausj.addCancelButton(2131721058);
          localausj.a(localamku);
          localausj.a(localamkv);
          localausj.show();
          anot.a(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", amks.c(paramList1, amks.b(this.a), amks.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = amkl.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (ampv)paramArrayOfByte.next();
          if ((paramList instanceof amow)) {
            if (((amow)paramList).IW() == 1001) {
              paramArrayOfLong[0] = ((amow)paramList);
            } else if (((amow)paramList).IW() == 1002) {
              paramString4[0] = ((amow)paramList);
            }
          }
        }
        int i;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder().append("search result: person is null=");
          if (paramArrayOfLong[0] == null)
          {
            paramBoolean1 = true;
            paramArrayOfByte = paramArrayOfByte.append(paramBoolean1).append(", troop is null=");
            if (paramString4[0] != null) {
              break label1228;
            }
            paramBoolean1 = true;
            QLog.d("UinSearcher", 2, paramBoolean1);
          }
        }
        else
        {
          paramArrayOfByte = this.a;
          if (paramArrayOfLong[0] != null) {
            break label1239;
          }
          if (paramString4[0] != null) {
            break label1233;
          }
          i = 4;
          amks.a(paramArrayOfByte, i);
          i = 2131696503;
          if (paramString4[0] == null) {
            break label1266;
          }
          if (paramArrayOfLong[0] != null) {
            break label1258;
          }
          i = 2131721462;
          localausj.setMainTitle(String.format(paramString3.getString(i), new Object[] { paramString1 }));
          localausj.bk(2131692330, 1, 2131362369);
          localausj.bk(2131693407, 1, 2131362370);
          localausj.bk(2131692643, 1, 2131362368);
          localausj.bk(2131689837, 1, 2131362366);
          if ((!amks.a(this.a).isSend()) && (!amks.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.isFriend(amks.a(this.a).senderuin))) {
            localausj.bk(2131689848, 1, 2131362367);
          }
          paramList = (aesy.a)aeif.a().o(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.isFriend(paramString1)) {
              break label1296;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].name)) || (!paramList.ahM())) {
              break label1281;
            }
            localausj.a(paramString3.getString(2131689787) + "\n" + paramArrayOfLong[0].name, 65537, 2131362365);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1416;
            }
            if ((TextUtils.isEmpty(paramString4[0].name)) || (!paramList.ahM())) {
              break label1401;
            }
            localausj.a(paramString3.getString(2131695146) + "\n" + paramString4[0].name, 65537, 2131362371);
          }
        }
        for (;;)
        {
          localausj.addCancelButton(2131721058);
          localausj.a(localamku);
          localausj.a(localamkv);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1503;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localausj, paramArrayOfLong, paramString4, paramList, paramList1));
            return;
          }
          catch (RuntimeException paramString1)
          {
            QLog.e("UinSearcher", 1, paramString1, new Object[0]);
            return;
          }
          paramBoolean1 = false;
          break;
          paramBoolean1 = false;
          break label768;
          i = 2;
          break label806;
          if (paramString4[0] == null)
          {
            i = 1;
            break label806;
          }
          i = 3;
          break label806;
          i = 2131696502;
          break label837;
          if (paramArrayOfLong[0] == null) {
            break label837;
          }
          i = 2131696502;
          break label837;
          localausj.bk(2131689787, 1, 2131362365);
          break label1059;
          paramString2 = null;
          if (paramList.ahM())
          {
            paramArrayOfByte = aqgv.b(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].name;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localausj.a(paramString3.getString(2131696653) + "\n" + paramString2, 65537, 2131362372);
            break label1059;
          }
          localausj.bk(2131696653, 1, 2131362372);
          break label1059;
          localausj.bk(2131695146, 1, 2131362371);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].name)) && (paramList.ahM())) {
            localausj.a(paramString3.getString(2131696682) + "\n" + paramString4[0].name, 65537, 2131362373);
          } else {
            localausj.bk(2131696682, 1, 2131362373);
          }
        }
      }
    } while (amks.a(this.a) == null);
    label1059:
    label1503:
    amks.a(this.a).dismiss();
    label1281:
    label1296:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkt
 * JD-Core Version:    0.7.0.1
 */