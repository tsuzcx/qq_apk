import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkElement;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter.1;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zkx
  extends zkv
{
  public Set<Long> by = new HashSet();
  private SimpleDateFormat e = new SimpleDateFormat("M月d日");
  private acff f;
  private ArrayList<C2CLinkElement> mData = new ArrayList();
  public Object mLock = new Object();
  protected List<zmc> uk = new ArrayList();
  
  public zkx(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramaurf, paramSessionInfo, paramQQAppInterface);
    this.f = ((acff)paramQQAppInterface.getManager(51));
  }
  
  public C2CLinkElement a(int paramInt)
  {
    Object localObject = ((zmc)getItem(paramInt)).messageRecord;
    try
    {
      localObject = aoyb.deserialize(((MessageRecord)localObject).msgData);
      if (localObject != null)
      {
        localObject = (C2CLinkElement)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("C2CLinkMessageResultAdapter", 2, new Object[] { "getLinkElement, e:", localException.toString() });
      return null;
    }
    return null;
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    paramString = this.mData.iterator();
    while (paramString.hasNext())
    {
      C2CLinkElement localC2CLinkElement = (C2CLinkElement)paramString.next();
      MessageForText localMessageForText = anbi.a(this.app, this.app.getCurrentUin(), localC2CLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localC2CLinkElement.description());
      localMessageForText.msgData = aoyb.d(localC2CLinkElement);
      localMessageForText.senderuin = localC2CLinkElement.sendUin;
      localMessageForText.issend = localC2CLinkElement.isSend;
      paramSessionInfo.mSearchData1.add(localMessageForText);
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
        QLog.d("C2CLinkMessageResultAdapter", 2, i);
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
    QLog.e("C2CLinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.uy.addAll(paramList);
  }
  
  public void ac(List<zmc> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CLinkMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
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
      paramView = View.inflate(this.mContext, 2131559535, null);
      locala = new zkv.a();
      locala.c = ((ColorNickTextView)paramView.findViewById(2131379873));
      locala.KQ = ((TextView)paramView.findViewById(2131365745));
      locala.icon = ((ImageView)paramView.findViewById(2131368698));
      paramView.setTag(locala);
    }
    for (;;)
    {
      localObject = localzmc.messageRecord;
      try
      {
        localObject = aoyb.deserialize(((MessageRecord)localObject).msgData);
        if (localObject == null) {
          break;
        }
        localObject = (C2CLinkElement)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CharSequence localCharSequence;
          continue;
          localObject = null;
        }
      }
      if (localObject != null)
      {
        localCharSequence = localzmc.a(((C2CLinkElement)localObject).title, -11353092);
        locala.c.setText(localCharSequence);
        locala.KQ.setText(localzmc.a(((C2CLinkElement)localObject).timeSecond, -11353092));
        zje.j(locala.icon, ((C2CLinkElement)localObject).iconUrl);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (zkv.a)paramView.getTag();
    }
  }
  
  public void j(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new C2CLinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void setData(List<Object> paramList)
  {
    this.mData.clear();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      localObject = C2CLinkElement.parseFrom(this.app, localObject, this.f, this.e, i);
      if (localObject != null) {
        this.mData.add(localObject);
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkx
 * JD-Core Version:    0.7.0.1
 */