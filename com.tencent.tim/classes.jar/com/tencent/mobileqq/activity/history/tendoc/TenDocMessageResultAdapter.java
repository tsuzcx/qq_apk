package com.tencent.mobileqq.activity.history.tendoc;

import anbi;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aoyb;
import aurf;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import zje;
import zkv;
import zkv.a;
import zmc;

public class TenDocMessageResultAdapter
  extends zkv
{
  private List<TencentDocItem> mData = new ArrayList();
  private LayoutInflater mInflater;
  private Runnable mRunnable;
  
  public TenDocMessageResultAdapter(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramaurf, paramSessionInfo, paramQQAppInterface);
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  private ChatHistorySearchData a()
  {
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = new ArrayList();
    Iterator localIterator = this.mData.iterator();
    while (localIterator.hasNext())
    {
      TencentDocItem localTencentDocItem = (TencentDocItem)localIterator.next();
      MessageRecord localMessageRecord = localTencentDocItem.mRecord;
      if (localMessageRecord != null)
      {
        MessageForText localMessageForText = anbi.a(this.app, localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, this.mSessionInfo.cZ, (byte)1, (byte)0, (short)0, localTencentDocItem.mSearchWords);
        localMessageForText.msgData = aoyb.d(localTencentDocItem);
        localMessageForText.shmsgseq = localMessageRecord.shmsgseq;
        localMessageForText.msgseq = localMessageRecord.msgseq;
        localMessageForText.time = localMessageRecord.time;
        localMessageForText.senderuin = localMessageRecord.senderuin;
        localChatHistorySearchData.mSearchData1.add(localMessageForText);
      }
    }
    localChatHistorySearchData.mSearchData2 = new ArrayList();
    return localChatHistorySearchData;
  }
  
  public void N(List<zmc> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TenDocMessageResultAdapter", 2, "set MessageItems: " + paramList.size());
    }
    this.uy.clear();
    this.uy.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void clearData()
  {
    this.uy.clear();
    notifyDataSetChanged();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (zmc)getItem(paramInt);
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131559540, paramViewGroup, false);
      paramView = new zkv.a();
      paramView.c = ((ColorNickTextView)localView.findViewById(2131379873));
      paramView.KQ = ((TextView)localView.findViewById(2131365745));
      paramView.icon = ((ImageView)localView.findViewById(2131368698));
      localView.setTag(paramView);
      localObject1 = ((zmc)localObject2).messageRecord;
      QLog.d("TenDocMessageResultAdapter", 4, "get view mr: " + localObject1);
      if (localObject1 != null) {
        break label158;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (zkv.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label158:
      localObject1 = TencentDocItem.decodeFromMsgData(((MessageRecord)localObject1).msgData);
      QLog.d("TenDocMessageResultAdapter", 4, "get view doc item: " + localObject1);
      if (localObject1 != null)
      {
        CharSequence localCharSequence = ((zmc)localObject2).a(((TencentDocItem)localObject1).mTitle, -11353092);
        localObject2 = ((zmc)localObject2).a(((TencentDocItem)localObject1).mDescription, -11353092);
        paramView.c.setText(localCharSequence);
        paramView.KQ.setText((CharSequence)localObject2);
        zje.j(paramView.icon, ((TencentDocItem)localObject1).mIcon);
      }
    }
  }
  
  public void j(long paramLong, String paramString, int paramInt)
  {
    if (this.mRunnable != null) {
      ThreadManager.removeJobFromThreadPool(this.mRunnable, 16);
    }
    this.mRunnable = new LoadRunnable(paramInt, paramString, paramLong);
    ThreadManager.getSubThreadHandler().post(this.mRunnable);
  }
  
  public void setData(List<TencentDocItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mData = paramList;
    notifyDataSetChanged();
  }
  
  class LoadRunnable
    implements Runnable
  {
    private long Lf;
    private String keyword;
    private int loadType;
    private final Object mLock = new Object();
    
    LoadRunnable(int paramInt, String paramString, long paramLong)
    {
      this.loadType = paramInt;
      this.keyword = paramString;
      this.Lf = paramLong;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.i("TenDocMessageResultAdapter", 2, "loadMessageResult, run(), keyword = " + this.keyword + ", loadType = " + this.loadType);
      }
      Object localObject2 = new ArrayList();
      Object localObject4 = TenDocMessageResultAdapter.a(TenDocMessageResultAdapter.this, TenDocMessageResultAdapter.a(TenDocMessageResultAdapter.this), (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("TenDocMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
      synchronized (this.mLock)
      {
        if (TenDocMessageResultAdapter.a(TenDocMessageResultAdapter.this).equals(this.keyword))
        {
          TenDocMessageResultAdapter.a(TenDocMessageResultAdapter.this, true);
          TenDocMessageResultAdapter.a(TenDocMessageResultAdapter.this, (ChatHistorySearchData)localObject4);
          localObject2 = TenDocMessageResultAdapter.a(TenDocMessageResultAdapter.this).obtainMessage(2, localObject2);
          localObject4 = new Bundle();
          ((Bundle)localObject4).putLong("searchSequence", this.Lf);
          ((Bundle)localObject4).putString("searchKeyword", this.keyword);
          ((Message)localObject2).setData((Bundle)localObject4);
          ((Message)localObject2).sendToTarget();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */