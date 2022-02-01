import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter.1;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class zlg
  extends zkv
{
  public Set<Long> by = new HashSet();
  public List<zmc> uk = new ArrayList();
  
  public zlg(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramaurf, paramSessionInfo, paramQQAppInterface);
  }
  
  void U(String paramString, long paramLong)
  {
    this.uk.clear();
    this.by.clear();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.getSubThreadHandler().post(new C2CMessageResultAdapter.2(this, paramString, paramLong));
  }
  
  public void a(List<zmc> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("setMessageItems loadType: ").append(paramInt1).append(", searchMode: ").append(paramInt2).append(", cloudGetCompleted: ").append(paramBoolean).append(", messageItems size: ");
      if (paramList == null)
      {
        i = 0;
        QLog.d("C2CMessageResultAdapter", 2, i);
      }
    }
    else
    {
      if ((paramInt1 != 1) || (paramInt2 != 0)) {
        break label103;
      }
      hn(paramList);
      this.uy = paramList;
    }
    label103:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        if ((paramInt1 == 2) && (paramInt2 == 0))
        {
          hn(paramList);
          this.uy.addAll(paramList);
          return;
        }
      } while ((paramInt1 != 4) || (paramList == null) || (paramList.size() == 0) || (paramInt2 != 1));
      ad(paramList, paramBoolean);
      if ((this.uy.size() <= 0) || (paramList.size() <= 0)) {
        break label253;
      }
      localObject = (zmc)paramList.get(0);
      zmc localzmc = (zmc)this.uy.get(this.uy.size() - 1);
      if (((zmc)localObject).messageRecord.time <= localzmc.messageRecord.time) {
        break label253;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label253:
    hn(paramList);
    this.uy.addAll(paramList);
  }
  
  void a(List<zmc> paramList, String paramString, long paramLong)
  {
    this.uk.clear();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new C2CMessageResultAdapter.1(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void ac(List<zmc> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.uy.clear();
    ad(paramList, paramBoolean);
    hn(paramList);
    this.uy.addAll(paramList);
  }
  
  void ad(List<zmc> paramList, boolean paramBoolean)
  {
    int k = 1;
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems localSize: " + this.uk.size() + ", cloudSize:" + paramList.size() + ", cloudCompleted:" + paramBoolean);
    }
    if ((this.uk.size() == 0) || ((paramList.size() == 0) && (!paramBoolean))) {}
    do
    {
      return;
      localObject = new ArrayList();
      if (!paramBoolean) {
        break label512;
      }
      if (!this.uy.isEmpty()) {
        break;
      }
      paramList.addAll(this.uk);
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems completed and adapter is empty add all local");
        i = k;
      }
      if (((List)localObject).size() > 0)
      {
        this.uk.removeAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems removed validItem size: " + ((List)localObject).size());
        }
      }
    } while (i == 0);
    Object localObject = new HashSet();
    int i = m;
    label225:
    if (i < paramList.size())
    {
      long l1 = ((zmc)paramList.get(i)).messageRecord.shmsgseq;
      if (((Set)localObject).contains(Long.valueOf(l1)))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break label225;
        l1 = ((zmc)this.uy.get(this.uy.size() - 1)).messageRecord.time;
        int j = 0;
        i = 0;
        while (j < this.uk.size())
        {
          if (((zmc)this.uk.get(j)).messageRecord.time < l1)
          {
            ((List)localObject).add(this.uk.get(j));
            i = 1;
          }
          j += 1;
        }
        paramList.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems completed  merge local size: " + ((List)localObject).size());
        }
        j = i;
        if (paramList.size() < 20)
        {
          paramList.addAll(this.uk);
          i = k;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems add all local local size: " + this.uk.size());
          i = k;
          break;
          if (this.uy.isEmpty())
          {
            l1 = ((zmc)paramList.get(paramList.size() - 1)).messageRecord.time;
            j = 0;
            i = 0;
            while (j < this.uk.size())
            {
              if (((zmc)this.uk.get(j)).messageRecord.time >= l1)
              {
                ((List)localObject).add(this.uk.get(j));
                i = 1;
              }
              j += 1;
            }
            paramList.addAll((Collection)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems uncompleted first screem merger local size: " + ((List)localObject).size());
            }
            break;
          }
          l1 = ((zmc)this.uy.get(this.uy.size() - 1)).messageRecord.time;
          long l2 = ((zmc)paramList.get(paramList.size() - 1)).messageRecord.time;
          j = 0;
          for (i = 0; j < this.uk.size(); i = k)
          {
            long l3 = ((zmc)this.uk.get(j)).messageRecord.time;
            k = i;
            if (l2 <= l3)
            {
              k = i;
              if (l3 < l1)
              {
                ((List)localObject).add(this.uk.get(j));
                k = 1;
              }
            }
            j += 1;
          }
          paramList.addAll((Collection)localObject);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems uncompleted load more merger local size: " + ((List)localObject).size());
            j = i;
          }
        }
        i = j;
        break;
        ((Set)localObject).add(Long.valueOf(l1));
      }
    }
    label512:
    hm(paramList);
  }
  
  public void clearData()
  {
    this.uy.clear();
    notifyDataSetChanged();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zmc localzmc = (zmc)getItem(paramInt);
    View localView;
    MessageRecord localMessageRecord;
    String str;
    Object localObject;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2131559542, null);
      paramView = new zkv.a();
      paramView.c = ((ColorNickTextView)localView.findViewById(2131379402));
      paramView.KQ = ((TextView)localView.findViewById(2131379404));
      paramView.icon = ((ImageView)localView.findViewById(2131368698));
      paramView.time = ((TextView)localView.findViewById(2131370129));
      localView.setTag(paramView);
      localMessageRecord = localzmc.messageRecord;
      str = aqgv.a(this.app, this.mSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramView.KQ.setText(localzmc.a(localMessageRecord.msg, -11353092));
      if (!localMessageRecord.isSend()) {
        break label290;
      }
      localObject = this.app.getCurrentAccountUin();
      label163:
      if (!jof.a(localMessageRecord)) {
        break label302;
      }
      localObject = jof.a(localMessageRecord);
      paramView.c.setText(this.mContext.getResources().getString(2131699453) + ((jof.a)localObject).TG);
      paramView.icon.setBackgroundDrawable(URLDrawable.getDrawable(jof.aV(((jof.a)localObject).aCv)));
    }
    for (;;)
    {
      paramView.time.setText(localzmc.be(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (zkv.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label290:
      localObject = this.mSessionInfo.aTl;
      break label163;
      label302:
      paramView.c.setText(localzmc.a(str, -11353092));
      paramView.icon.setBackgroundDrawable(aqdj.a(this.app, 1, (String)localObject));
    }
  }
  
  void hm(List<zmc> paramList)
  {
    long l = SystemClock.uptimeMillis();
    if (paramList.size() > 0) {
      Collections.sort(paramList, new zlh(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "resortRecords cost time: " + (SystemClock.uptimeMillis() - l));
    }
  }
  
  public void hn(List<?> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = (achs)this.app.getManager(92);
    Calendar localCalendar = ((achs)localObject).d();
    if (localCalendar != null) {
      l = ((Long)((achs)localObject).a(localCalendar).second).longValue();
    }
    int i = 0;
    int j = paramList.size();
    label72:
    if (i < j)
    {
      localObject = paramList.get(i);
      if (!(localObject instanceof zmc)) {
        break label153;
      }
      localObject = ((zmc)localObject).messageRecord;
    }
    for (;;)
    {
      label104:
      int k;
      if ((localObject != null) && (((MessageRecord)localObject).time > l))
      {
        paramList.remove(i);
        k = j - 1;
        j = i - 1;
        i = k;
      }
      for (;;)
      {
        k = j + 1;
        j = i;
        i = k;
        break label72;
        break;
        label153:
        if (!(localObject instanceof MessageRecord)) {
          break label182;
        }
        localObject = (MessageRecord)localObject;
        break label104;
        k = i;
        i = j;
        j = k;
      }
      label182:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlg
 * JD-Core Version:    0.7.0.1
 */