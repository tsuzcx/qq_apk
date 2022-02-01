package com.tencent.mobileqq.mini.share;

import aajx;
import afei;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import aqdf.a;
import aqiw;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class MiniShareQuicklySendPanelAdapter
  extends BaseAdapter
  implements View.OnClickListener, aqdf.a
{
  private static final String TAG = "MiniShareQuicklySendPanelAdapter";
  private Activity activity;
  private SendPanelViewHolder curShareViewHolder;
  private long decodeFaceStartTime;
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private QQAppInterface mApp;
  protected aajx mFaceDecoder;
  private XListView mListView;
  private Bundle mShareDataBundle;
  private ArrayList<SendPanelData> sendPanelDataList;
  
  public MiniShareQuicklySendPanelAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, Bundle paramBundle)
  {
    this.activity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.mListView = paramXListView;
    this.mShareDataBundle = paramBundle;
    this.sendPanelDataList = new ArrayList();
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
  }
  
  public static Drawable getIconDrawable(String paramString, int paramInt1, int paramInt2)
  {
    afei localafei = new afei(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localafei, localafei);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniShareQuicklySendPanelAdapter", 2, "getIconDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localafei;
  }
  
  private void updateItem(SendPanelViewHolder paramSendPanelViewHolder, SendPanelData paramSendPanelData, Drawable paramDrawable)
  {
    if ((paramSendPanelViewHolder == null) || (paramSendPanelData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramSendPanelData.baseData.ng();
      if ((!(paramSendPanelData.baseData instanceof RecentCallItem)) || (!((RecentCallItem)paramSendPanelData.baseData).WD())) {
        break label79;
      }
      i = 3002;
    }
    label79:
    for (;;)
    {
      localDrawable = this.mFaceDecoder.a(i, paramSendPanelData.baseData.qx());
      bindData(paramSendPanelViewHolder, localDrawable);
      return;
    }
  }
  
  private SendPanelData updateStatus(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.sendPanelDataList != null) && (this.sendPanelDataList.size() > 0))
    {
      Iterator localIterator = this.sendPanelDataList.iterator();
      while (localIterator.hasNext())
      {
        SendPanelData localSendPanelData = (SendPanelData)localIterator.next();
        if ((!TextUtils.isEmpty(localSendPanelData.baseData.qx())) && (paramString.equals(localSendPanelData.baseData.qx())))
        {
          localSendPanelData.operateStatus = paramInt;
          return localSendPanelData;
        }
      }
    }
    return null;
  }
  
  private void updateStatusView(SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder == null) || (paramSendPanelViewHolder.itemInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "updateStatusView fail");
      }
      return;
    }
    QLog.d("MiniShareQuicklySendPanelAdapter", 2, "updateStatusView");
    paramSendPanelViewHolder.operateView.setStatus(paramSendPanelViewHolder.itemInfo.operateStatus);
  }
  
  public void bindData(SendPanelViewHolder paramSendPanelViewHolder, Drawable paramDrawable)
  {
    boolean bool = true;
    if ((paramSendPanelViewHolder == null) || (paramSendPanelViewHolder.itemInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    SendPanelData localSendPanelData = paramSendPanelViewHolder.itemInfo;
    RecentDynamicAvatarView localRecentDynamicAvatarView = null;
    if (paramDrawable == null)
    {
      paramDrawable = localRecentDynamicAvatarView;
      if (this.mFaceDecoder != null) {
        paramDrawable = this.mFaceDecoder.a(localSendPanelData.baseData);
      }
      if (!needDynamic(localSendPanelData.baseData)) {
        break label260;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "bindview user:" + localSendPanelData.baseData.qx());
      }
      int j = ((Integer)aajx.a(this.mApp, localSendPanelData.baseData.ng(), localSendPanelData.baseData.qx()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      localRecentDynamicAvatarView = paramSendPanelViewHolder.iconView;
      QQAppInterface localQQAppInterface = this.mApp;
      String str = localSendPanelData.baseData.qx();
      if (this.mApp.a.Bd() != 1) {
        break label254;
      }
      label197:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      paramSendPanelViewHolder.nameText.setText(localSendPanelData.baseData.getTitleName());
      paramSendPanelViewHolder.operateView.setTag(paramSendPanelViewHolder);
      paramSendPanelViewHolder.operateView.setOnClickListener(this);
      updateStatusView(paramSendPanelViewHolder);
      return;
      break;
      label254:
      bool = false;
      break label197;
      label260:
      paramSendPanelViewHolder.iconView.setImageDrawable(paramDrawable);
    }
  }
  
  public int getCount()
  {
    if (this.sendPanelDataList != null) {
      return this.sendPanelDataList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.sendPanelDataList != null) {
      return (SendPanelData)this.sendPanelDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.sendPanelDataList != null) && (paramInt < this.sendPanelDataList.size())) {
      try
      {
        long l = Long.parseLong(((SendPanelData)this.sendPanelDataList.get(paramInt)).baseData.qx());
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniShareQuicklySendPanelAdapter", 2, "getItemId exception = " + localException.getMessage());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SendPanelData localSendPanelData = (SendPanelData)getItem(paramInt);
    SendPanelViewHolder localSendPanelViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.activity).inflate(2131563082, null);
      localSendPanelViewHolder = new SendPanelViewHolder();
      localSendPanelViewHolder.iconView = ((RecentDynamicAvatarView)paramView.findViewById(2131368698));
      localSendPanelViewHolder.nameText = ((TextView)paramView.findViewById(2131372190));
      localSendPanelViewHolder.operateView = ((QuickSendProgressView)paramView.findViewById(2131372706));
      localSendPanelViewHolder.itemInfo = localSendPanelData;
      bindData(localSendPanelViewHolder, null);
      paramView.setTag(localSendPanelViewHolder);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localSendPanelViewHolder = (SendPanelViewHolder)paramView.getTag();
      localSendPanelViewHolder.itemInfo = localSendPanelData;
      bindData(localSendPanelViewHolder, null);
    }
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.ng();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public void notifyShareCancel()
  {
    if (this.curShareViewHolder != null)
    {
      SendPanelData localSendPanelData = updateStatus(this.curShareViewHolder.itemInfo.baseData.qx(), 0);
      if (localSendPanelData != null)
      {
        this.curShareViewHolder.itemInfo = localSendPanelData;
        updateStatusView(this.curShareViewHolder);
      }
      this.curShareViewHolder = null;
    }
  }
  
  public void notifyShareSuc()
  {
    if (this.curShareViewHolder != null)
    {
      SendPanelData localSendPanelData = updateStatus(this.curShareViewHolder.itemInfo.baseData.qx(), 3);
      if (localSendPanelData != null)
      {
        this.curShareViewHolder.itemInfo = localSendPanelData;
        updateStatusView(this.curShareViewHolder);
      }
      this.curShareViewHolder = null;
    }
  }
  
  public void onClick(View paramView)
  {
    SendPanelViewHolder localSendPanelViewHolder;
    if ((paramView.getTag() instanceof SendPanelViewHolder))
    {
      localSendPanelViewHolder = (SendPanelViewHolder)paramView.getTag();
      if (localSendPanelViewHolder.itemInfo != null) {
        break label48;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onClick operateStatus = " + localSendPanelViewHolder.itemInfo.operateStatus);
      }
      switch (localSendPanelViewHolder.itemInfo.operateStatus)
      {
      case 1: 
      case 3: 
      default: 
        break;
      case 0: 
        if (!aqiw.isNetworkAvailable(this.activity))
        {
          QQToast.a(this.activity, this.activity.getString(2131720470), 0).show();
        }
        else
        {
          SendPanelData localSendPanelData = updateStatus(localSendPanelViewHolder.itemInfo.baseData.qx(), 1);
          if (localSendPanelData != null)
          {
            localSendPanelViewHolder.itemInfo = localSendPanelData;
            updateStatusView(localSendPanelViewHolder);
            if (this.curShareViewHolder == null) {
              this.curShareViewHolder = localSendPanelViewHolder;
            }
          }
          MiniProgramShareUtils.shareToChatDirectly(this.activity, this.mShareDataBundle, localSendPanelViewHolder.itemInfo.baseData.ng(), String.valueOf(localSendPanelViewHolder.itemInfo.baseData.qx()), localSendPanelViewHolder.itemInfo.baseData.getTitleName(), 678, false);
        }
        break;
      case 2: 
        if (!aqiw.isNetworkAvailable(this.activity)) {
          QQToast.a(this.activity, this.activity.getString(2131720470), 0).show();
        }
        break;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.faceCache.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.decodeFaceStartTime > 0L) && (l - this.decodeFaceStartTime > 300L))
          {
            paramInt2 = 1;
            if ((paramInt1 > 0) && (paramInt2 == 0)) {
              continue;
            }
            synchronized (this.faceCache)
            {
              if (this.faceCache.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError ???)
        {
          for (;;)
          {
            System.gc();
            ???.printStackTrace();
            QLog.i("MiniShareQuicklySendPanelAdapter", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
    if (paramInt1 == 0) {}
    boolean bool;
    SendPanelData localSendPanelData;
    for (this.decodeFaceStartTime = 0L;; this.decodeFaceStartTime = l)
    {
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      bool = false;
      if (paramInt1 >= paramInt2) {
        break label404;
      }
      paramBitmap = (SendPanelViewHolder)this.mListView.getChildAt(paramInt1).getTag();
      if ((paramBitmap == null) || (paramBitmap.itemInfo == null)) {
        break label392;
      }
      i = paramBitmap.itemInfo.position;
      localSendPanelData = (SendPanelData)this.sendPanelDataList.get(i);
      if (localSendPanelData != null) {
        break;
      }
      break label466;
    }
    int i = localSendPanelData.baseData.ng();
    i = ((Integer)aajx.a(this.mApp, i, localSendPanelData.baseData.qx()).first).intValue();
    if (i != -2147483648)
    {
      Object localObject = i + ":" + localSendPanelData.baseData.qx();
      localObject = (Bitmap)this.faceCache.get(localObject);
      if (localObject != null)
      {
        updateItem(paramBitmap, localSendPanelData, new BitmapDrawable(this.activity.getResources(), (Bitmap)localObject));
        bool = true;
        break label473;
        label392:
        QLog.e("MiniShareQuicklySendPanelAdapter", 1, "onDecodeTaskCompleted holder is null?!");
        break label466;
        label404:
        if (QLog.isDevelopLevel()) {
          QLog.i("MiniShareQuicklySendPanelAdapter", 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + bool);
        }
        this.faceCache.clear();
        return;
      }
    }
    label466:
    label473:
    for (;;)
    {
      paramInt1 += 1;
      break;
    }
  }
  
  public void onDestroy()
  {
    if (this.mFaceDecoder != null) {
      this.mFaceDecoder.onDestory();
    }
  }
  
  public void onUpdate(int paramInt, SendPanelData paramSendPanelData)
  {
    if ((paramInt < 0) || (this.sendPanelDataList == null) || (paramInt > this.sendPanelDataList.size()) || (paramSendPanelData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.sendPanelDataList.set(paramInt, paramSendPanelData);
  }
  
  public void setData(ArrayList<SendPanelData> paramArrayList)
  {
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniShareQuicklySendPanelAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.sendPanelDataList == null) || (!paramArrayList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniShareQuicklySendPanelAdapter", 2, "setData do not need refresh");
    return;
    this.sendPanelDataList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public static class SendPanelData
  {
    public RecentBaseData baseData;
    public int operateStatus;
    public int position;
    
    public SendPanelData(RecentBaseData paramRecentBaseData)
    {
      this.baseData = paramRecentBaseData;
    }
  }
  
  public class SendPanelViewHolder
  {
    public RecentDynamicAvatarView iconView;
    public MiniShareQuicklySendPanelAdapter.SendPanelData itemInfo;
    public TextView nameText;
    public QuickSendProgressView operateView;
    
    public SendPanelViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelAdapter
 * JD-Core Version:    0.7.0.1
 */