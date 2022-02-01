import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.1;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zjj
  extends zkv
{
  public Set<Long> by = new HashSet();
  private SimpleDateFormat e = new SimpleDateFormat("M月d日");
  public Object mLock = new Object();
  public List<zmc> uk = new ArrayList();
  private List<TroopLinkElement> ul;
  
  public zjj(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramaurf, paramSessionInfo, paramQQAppInterface);
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    Iterator localIterator = this.ul.iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      MessageForText localMessageForText = anbi.a(this.app, this.app.getCurrentUin(), localTroopLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localTroopLinkElement.description());
      localMessageForText.msgData = aoyb.d(localTroopLinkElement);
      localMessageForText.shmsgseq = Long.parseLong(localTroopLinkElement.msgSeq);
      if (localMessageForText.msg.contains(paramString)) {
        paramSessionInfo.mSearchData1.add(localMessageForText);
      }
    }
    paramSessionInfo.mSearchData2 = new ArrayList();
    return paramSessionInfo;
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
        QLog.d("LinkMessageResultAdapter", 2, i);
      }
    }
    else
    {
      if ((paramInt1 != 1) || (paramInt2 != 0)) {
        break label98;
      }
      this.uy = paramList;
    }
    label98:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        if ((paramInt1 == 2) && (paramInt2 == 0))
        {
          this.uy.addAll(paramList);
          return;
        }
      } while ((paramInt1 != 4) || (paramList == null) || (paramList.size() == 0) || (paramInt2 != 1));
      if ((this.uy.size() <= 0) || (paramList.size() <= 0)) {
        break label237;
      }
      localObject = (zmc)paramList.get(0);
      zmc localzmc = (zmc)this.uy.get(this.uy.size() - 1);
      if (((zmc)localObject).messageRecord.time <= localzmc.messageRecord.time) {
        break label237;
      }
    } while (!QLog.isColorLevel());
    QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.uy.addAll(paramList);
  }
  
  public void a(List<zmc> paramList, String paramString, long paramLong)
  {
    this.uk.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new LinkMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void ac(List<zmc> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.uy.clear();
    this.uy.addAll(paramList);
  }
  
  public void clearData()
  {
    this.uy.clear();
    notifyDataSetChanged();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zmc localzmc = (zmc)getItem(paramInt);
    zkv.a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131559540, null);
      locala = new zkv.a();
      locala.c = ((ColorNickTextView)paramView.findViewById(2131379873));
      locala.KQ = ((TextView)paramView.findViewById(2131365745));
      locala.icon = ((ImageView)paramView.findViewById(2131368698));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject1 = localzmc.messageRecord;
      TroopLinkElement localTroopLinkElement = new TroopLinkElement();
      try
      {
        localObject1 = aoyb.deserialize(((MessageRecord)localObject1).msgData);
        if (localObject1 == null) {
          break label331;
        }
        localTroopLinkElement = (TroopLinkElement)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          continue;
          localException.icon.setImageDrawable(this.mContext.getResources().getDrawable(2130851466));
        }
      }
      localObject2 = localTroopLinkElement.nickname;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localTroopLinkElement.uin;
      }
      localObject2 = localzmc.a(localTroopLinkElement.title, -11353092);
      locala.c.setText((CharSequence)localObject2);
      localObject2 = new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L);
      localObject2 = this.e.format((Date)localObject2);
      localObject1 = String.format(acfp.m(2131707751), new Object[] { localObject2, localObject1 });
      locala.KQ.setText(localzmc.a((String)localObject1, -11353092));
      if (TextUtils.isEmpty(localTroopLinkElement.iconUrl)) {
        break;
      }
      zje.j(locala.icon, localTroopLinkElement.iconUrl);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (zkv.a)paramView.getTag();
    }
  }
  
  public void hj(List<TroopLinkElement> paramList)
  {
    this.ul = paramList;
  }
  
  public void j(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new LinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjj
 * JD-Core Version:    0.7.0.1
 */