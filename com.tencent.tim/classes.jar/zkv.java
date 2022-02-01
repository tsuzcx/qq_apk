import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zkv
  extends BaseAdapter
{
  private static final String TAG = zmd.class.getSimpleName();
  public ChatHistorySearchData a;
  public QQAppInterface app;
  public aurf b;
  public String ban;
  protected Context mContext;
  public boolean mEnded = true;
  public Object mLock = new Object();
  public SessionInfo mSessionInfo;
  protected List<zmc> uy = new ArrayList();
  
  public zkv(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.b = paramaurf;
    this.mSessionInfo = paramSessionInfo;
    this.app = paramQQAppInterface;
  }
  
  public void N(List<zmc> paramList, int paramInt)
  {
    if (paramInt == 1) {
      this.uy = paramList;
    }
    while (paramInt != 2) {
      return;
    }
    this.uy.addAll(paramList);
  }
  
  public boolean Q(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msg == null) || (paramMessageRecord.msg.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "isValidData, empty item");
      }
    }
    String str;
    do
    {
      return false;
      str = aqgv.a(this.app, this.mSessionInfo, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
      paramMessageRecord = zmc.f(paramMessageRecord.msg).toLowerCase(Locale.US);
    } while ((!str.contains(zmc.keyword)) && (!paramMessageRecord.contains(zmc.keyword)));
    return true;
  }
  
  public boolean Vu()
  {
    return this.mEnded;
  }
  
  protected ChatHistorySearchData a(ChatHistorySearchData paramChatHistorySearchData, ArrayList<zmc> paramArrayList)
  {
    if (paramChatHistorySearchData == null)
    {
      paramArrayList = paramChatHistorySearchData;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "chatHistorySearchData == null");
        paramArrayList = paramChatHistorySearchData;
      }
    }
    do
    {
      do
      {
        return paramArrayList;
        if (paramChatHistorySearchData.mSearchData1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "chatHistorySearchData.mSearchData1 == null");
          }
          paramChatHistorySearchData.offset = 0;
          return paramChatHistorySearchData;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "chatHistorySearchData.offset = " + paramChatHistorySearchData.offset);
        }
        int i = paramChatHistorySearchData.offset;
        while (i < paramChatHistorySearchData.mSearchData1.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(i);
          paramChatHistorySearchData.offset += 1;
          if (Q(localMessageRecord)) {
            paramArrayList.add(new zmc(this.app, localMessageRecord));
          }
          i += 1;
        }
        if ((paramChatHistorySearchData.mSearchData2 != null) && (!paramChatHistorySearchData.mSearchData2.isEmpty())) {
          break;
        }
        paramArrayList = paramChatHistorySearchData;
      } while (!QLog.isColorLevel());
      QLog.i(TAG, 2, "chatHistorySearchData.mSearchData2 == null or empty");
      return paramChatHistorySearchData;
      paramChatHistorySearchData = this.app.b().a(this.mSessionInfo.aTl, this.mSessionInfo.cZ, paramChatHistorySearchData.mSearchData2);
      paramArrayList = paramChatHistorySearchData;
    } while (paramChatHistorySearchData == null);
    paramChatHistorySearchData.offset = 0;
    return paramChatHistorySearchData;
  }
  
  public ChatHistorySearchData b(ChatHistorySearchData paramChatHistorySearchData, ArrayList<zmc> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < 20)
      {
        if (paramChatHistorySearchData == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "chatHistorySearchData == null");
          }
          return paramChatHistorySearchData;
        }
        if (paramChatHistorySearchData.mSearchData1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "chatHistorySearchData.mSearchData1 == null");
          }
          paramChatHistorySearchData.offset = 0;
          return paramChatHistorySearchData;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "chatHistorySearchData.offset = " + paramChatHistorySearchData.offset);
        }
        int k = paramChatHistorySearchData.offset;
        while (k < paramChatHistorySearchData.mSearchData1.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(k);
          paramChatHistorySearchData.offset += 1;
          int j = i;
          if (Q(localMessageRecord))
          {
            paramArrayList.add(new zmc(this.app, localMessageRecord));
            i += 1;
            j = i;
            if (i == 20)
            {
              if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getMessageRecords, one page, offset = " + paramChatHistorySearchData.offset);
              }
              return paramChatHistorySearchData;
            }
          }
          k += 1;
          i = j;
        }
        if ((paramChatHistorySearchData.mSearchData2 == null) || (paramChatHistorySearchData.mSearchData2.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "chatHistorySearchData.mSearchData2 == null or empty");
          }
          return paramChatHistorySearchData;
        }
        paramChatHistorySearchData = this.app.b().a(this.mSessionInfo.aTl, this.mSessionInfo.cZ, paramChatHistorySearchData.mSearchData2);
        if (paramChatHistorySearchData != null) {
          paramChatHistorySearchData.offset = 0;
        }
      }
      else
      {
        return paramChatHistorySearchData;
      }
    }
  }
  
  public int getCount()
  {
    return this.uy.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.uy.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public String getKeyword()
  {
    return this.ban;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void j(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "loadMessageResult, keyword = " + paramString + ", loadType = " + paramInt);
    }
    if (paramString == null) {}
    do
    {
      return;
      if (paramInt != 2) {
        break;
      }
    } while ((this.mEnded) || (!paramString.equalsIgnoreCase(this.ban)));
    for (;;)
    {
      ThreadManager.post(new BaseMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
      return;
      this.ban = paramString;
      zmc.setKeyword(paramString);
      this.mEnded = false;
    }
  }
  
  public void zx(String paramString)
  {
    this.ban = paramString;
    zmc.setKeyword(paramString);
  }
  
  public static class a
  {
    public TextView KQ;
    public ColorNickTextView c;
    public ImageView icon;
    public TextView time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkv
 * JD-Core Version:    0.7.0.1
 */