package com.tencent.mobileqq.activity;

import acfp;
import agmx;
import ahao;
import ahav;
import ahbj;
import ahgq;
import aklr;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aqcl;
import aqha;
import aqju;
import aqnm;
import auru;
import avfp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.a;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.a;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sxy;
import uon;
import uoo;
import uop;
import uoq;
import uor;
import uou;
import xto;
import xuf;

public class ChatHistoryImageView
  extends uou
  implements DialogInterface.OnCancelListener, Handler.Callback, AIOImageProviderService.a, INetEventHandler, AbsListView.e, AdapterView.c, GestureSelectGridView.b
{
  public Dialog G;
  public DownloadAndSaveTask a;
  public a a;
  public AIOImageProviderService a;
  public AIOPhotoListAdapter a;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  xto jdField_a_of_type_Xto;
  boolean aTT = false;
  boolean aTU;
  boolean aTV = false;
  boolean aUb;
  boolean aUc = false;
  boolean aUd = false;
  auru b;
  private int bFu;
  public ArrayList<xuf> dQ = new ArrayList();
  Activity mActivity;
  QQAppInterface mApp;
  int mCurType;
  boolean mDestroy = false;
  aqju mDialog;
  View mEmptyView;
  String mFriendUin;
  GestureSelectGridView mGridView;
  int mImageWidth;
  boolean mIsPause = false;
  int mMaxIndex = -2147483648;
  int mMinIndex = 2147483647;
  View mSubView;
  
  public boolean Pl()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.Pl();
    }
    return false;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[onImageDownload] id=" + paramLong + ",subId=" + paramInt1);
    }
    xto localxto = this.jdField_a_of_type_Xto;
    if (paramInt3 == 1)
    {
      paramInt1 = localxto.a(paramLong, paramInt1, paramInt2, ???, true);
      if (paramInt2 != 2) {
        break label227;
      }
      if (paramInt1 >= 0)
      {
        ??? = this.jdField_a_of_type_Xto.j(paramInt1);
        if (xuf.class.isInstance(???)) {
          break label103;
        }
      }
    }
    label103:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ??? = "I:E";
            break;
            ??? = (xuf)???;
            ???.progress = 0;
            ???.isDownloading = false;
            paramInt2 = this.mGridView.getFirstVisiblePosition();
            paramInt3 = this.mGridView.getChildCount();
            if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.r(paramInt1, this.mGridView.getChildAt(paramInt1 - paramInt2));
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a == null));
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a.notifyAll();
            return;
          }
          if (paramInt2 != 1) {
            break label292;
          }
          paramInt2 = this.mGridView.getFirstVisiblePosition();
          paramInt3 = this.mGridView.getChildCount();
        } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
        ??? = this.mGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.r(paramInt1, ???);
        return;
      } while (paramInt2 != 16);
      paramInt2 = this.mGridView.getFirstVisiblePosition();
      paramInt3 = this.mGridView.getChildCount();
    } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
    label227:
    ??? = this.mGridView.getChildAt(paramInt1 - paramInt2);
    label292:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.r(paramInt1, ???);
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = ((Activity)paramContext);
    this.aUb = paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.b = new auru(this);
    this.mSubView = LayoutInflater.from(paramContext).inflate(2131561040, null);
    this.mGridView = ((GestureSelectGridView)this.mSubView.findViewById(2131368142));
    this.mGridView.setSelectMode(false);
    int i = this.mActivity.getResources().getDimensionPixelSize(2131297813);
    int j = this.mActivity.getResources().getDimensionPixelSize(2131297814);
    int k = this.mActivity.getResources().getDimensionPixelSize(2131297815);
    this.mImageWidth = ((aqnm.getScreenWidth() - i * 2 - j * 3) / 4);
    this.mGridView.setGravity(3);
    this.mGridView.setScrollBarStyle(0);
    this.mGridView.setNumColumns(4);
    this.mGridView.setColumnWidth(this.mImageWidth);
    this.mGridView.setHorizontalSpacing(j);
    this.mGridView.setVerticalSpacing(k);
    this.mGridView.setPadding(i, this.mGridView.getPaddingTop(), i, this.mGridView.getPaddingBottom());
    this.mEmptyView = this.mSubView.findViewById(2131366437);
    if (AppSetting.enableTalkBack) {
      this.mEmptyView.setContentDescription(this.mActivity.getString(2131693652));
    }
    this.mCurType = paramIntent.getIntExtra("uintype", -1);
    this.mFriendUin = paramIntent.getStringExtra("uin");
    bKl();
    this.mGridView.setOnScrollListener(this);
    this.mGridView.setOnIndexChangedListener(this);
    aqcl.Q(this.mGridView, false);
  }
  
  void a(AIORichMediaData paramAIORichMediaData, boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    if (i < this.jdField_a_of_type_Xto.wu())
    {
      Object localObject = this.jdField_a_of_type_Xto.j(i);
      if (!xuf.class.isInstance(localObject)) {}
      do
      {
        i += 1;
        break;
        localObject = (xuf)localObject;
      } while ((((xuf)localObject).e.id != paramAIORichMediaData.id) || (((xuf)localObject).e.subId != paramAIORichMediaData.subId));
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[setSelectionTo] index=" + i + ", fist=" + this.mGridView.getFirstVisiblePosition() + ", last=" + this.mGridView.getLastVisiblePosition());
        }
        if ((i < this.mGridView.getFirstVisiblePosition()) || (i > this.mGridView.getLastVisiblePosition())) {}
      }
      else
      {
        return;
      }
      if (paramBoolean)
      {
        this.mGridView.setSelection(i);
        return;
      }
      i -= 12;
      if (i < 0) {
        i = k;
      }
      for (;;)
      {
        this.mGridView.setSelection(i);
        return;
      }
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.b.post(new ChatHistoryImageView.2(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  boolean a(View paramView, sxy paramsxy)
  {
    Object localObject = (AIOPhotoListAdapter.a)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.a)localObject).tO;
      localObject = ((AIOPhotoListAdapter.a)localObject).mSelectedIconView;
      switch (paramsxy.uG())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130846610);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130846607);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  boolean a(xuf paramxuf, boolean paramBoolean)
  {
    int i = paramxuf.uG();
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramxuf.e.id);
      if (!paramBoolean) {
        break;
      }
    } while (((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.Pm())) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a.Pm())) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a.a(paramxuf))));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a != null) && (localChatMessage != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a.e(localChatMessage);
    }
    paramxuf.setSelected(1);
    this.dQ.add(paramxuf);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramxuf);
      if (localChatMessage != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.e(localChatMessage);
      }
    }
    for (;;)
    {
      return true;
      paramxuf.setSelected(2);
      this.dQ.remove(paramxuf);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramxuf);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.h(localChatMessage);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a.b(paramxuf);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a.h(localChatMessage);
        }
      }
    }
  }
  
  public View aI()
  {
    aqcl.Q(this.mGridView, false);
    return this.mSubView;
  }
  
  public void af(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE") instanceof AIORichMediaData))) {
      a((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"), true);
    }
    if (!agmx.alL()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    }
  }
  
  public void bBS()
  {
    if (this.dQ.isEmpty()) {}
    label254:
    do
    {
      Object localObject1;
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      localObject1 = (xuf)this.dQ.get(0);
                      if ((AIOImageData.class.isInstance(((xuf)localObject1).e)) || (AIOFilePicData.class.isInstance(((xuf)localObject1).e)))
                      {
                        bKm();
                        return;
                      }
                      if (!AIOShortVideoData.class.isInstance(((xuf)localObject1).e)) {
                        break;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.getForwardData(((xuf)localObject1).e.id, ((xuf)localObject1).e.subId, this.mCurType);
                    } while (localObject1 == null);
                    ahgq.P(this.mActivity, (Intent)localObject1);
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.bKc();
                  return;
                } while (!AIOFileVideoData.class.isInstance(((xuf)localObject1).e));
                localObject2 = (AIOFileVideoData)((xuf)localObject1).e;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIOFileVideoData)localObject2).id);
                if (!(localObject2 instanceof MessageForFile)) {
                  break label254;
                }
                if (!ahav.a(this.mApp, (MessageForFile)localObject2).sendCloudUnsuccessful()) {
                  break;
                }
                ahao.JD(acfp.m(2131703641));
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.bKc();
              return;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.getForwardData(((xuf)localObject1).e.id, ((xuf)localObject1).e.subId, this.mCurType);
            } while (localObject1 == null);
            ahgq.P(this.mActivity, (Intent)localObject1);
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.bKc();
          return;
        } while (!(localObject2 instanceof MessageForTroopFile));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.getForwardData(((xuf)localObject1).e.id, ((xuf)localObject1).e.subId, this.mCurType);
      } while (localObject1 == null);
      ahgq.P(this.mActivity, (Intent)localObject1);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.bKc();
  }
  
  public boolean bC()
  {
    return this.aTT;
  }
  
  public void bJW()
  {
    this.aUd = true;
  }
  
  public void bJX()
  {
    this.aUd = false;
  }
  
  public void bJY()
  {
    if (!this.aTT)
    {
      this.aTT = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.aTT = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      this.mGridView.setSelectMode(true);
    }
  }
  
  public void bJZ()
  {
    if (this.aTT)
    {
      this.aTT = false;
      Iterator localIterator = this.dQ.iterator();
      while (localIterator.hasNext()) {
        ((sxy)localIterator.next()).setSelected(2);
      }
      this.dQ.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.aTT = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      this.mGridView.setSelectMode(false);
    }
  }
  
  public void bKl()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService = AIOImageProviderService.a(this.mApp.getCurrentUin(), this.mFriendUin, this.mCurType, null, this.aUb);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this);
    this.jdField_a_of_type_Xto = new xto(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter = new AIOPhotoListAdapter(this.mActivity, this.mImageWidth, this.jdField_a_of_type_Xto, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.mGridView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.setCurType(this.mCurType);
    this.mGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter);
    this.mGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.ay(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.Dy(2);
    AIOImageProviderService localAIOImageProviderService = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService;
    if (this.aUb) {}
    for (int i = 2;; i = 0)
    {
      localAIOImageProviderService.loadMedias(i);
      return;
    }
  }
  
  public void bKm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    Iterator localIterator = this.dQ.iterator();
    int i = 0;
    xuf localxuf;
    if (localIterator.hasNext())
    {
      localxuf = (xuf)localIterator.next();
      if (AIOImageData.class.isInstance(localxuf.e)) {
        if (localxuf.e.istroop == 1)
        {
          if ((localxuf.e.c(4) != null) || (localxuf.e.c(2) != null) || (localxuf.e.c(1) != null)) {
            break label239;
          }
          i += 1;
        }
      }
    }
    label239:
    for (;;)
    {
      break;
      if (localxuf.e.c(2) == null)
      {
        i += 1;
        continue;
        if ((AIOFilePicData.class.isInstance(localxuf.e)) && (localxuf.e.c(20) == null) && (localxuf.e.c(18) == null) && (localxuf.e.c(16) == null))
        {
          i += 1;
          continue;
          if (i == 0)
          {
            bKn();
            return;
          }
          if (i != this.dQ.size())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryImageView", 2, "[forwardAllImage] hasForwardImg = false");
            }
            bb(3, acfp.m(2131703607));
            return;
          }
          ahao.JD(acfp.m(2131703637));
          return;
        }
      }
    }
  }
  
  public void bKn()
  {
    if ((this.dQ != null) && (this.dQ.get(0) != null))
    {
      localObject1 = (xuf)this.dQ.get(0);
      if (AIOImageData.class.isInstance(((xuf)localObject1).e))
      {
        localObject2 = (AIOImageData)((xuf)localObject1).e;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).cH(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).cH(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.dQ.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.dQ.size() + acfp.m(2131703672));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.dQ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localxuf = (xuf)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localxuf.e))
          {
            if (localxuf.e.istroop == 1)
            {
              if (localxuf.e.c(4) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVY);
              } else if (localxuf.e.c(2) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVX);
              } else if (localxuf.e.c(1) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVW);
              }
            }
            else {
              ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVX);
            }
          }
          else if (AIOFilePicData.class.isInstance(localxuf.e)) {
            if (localxuf.e.c(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVY);
            } else if (localxuf.e.c(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVX);
            } else if (localxuf.e.c(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVW);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ahgq.f(this.mActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      xuf localxuf;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((xuf)localObject1).e));
      Object localObject2 = (AIOFilePicData)((xuf)localObject1).e;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).cH(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).cH(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.dQ.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.dQ.size() + acfp.m(2131703656));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.dQ.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localxuf = (xuf)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localxuf.e)) {
          ((ArrayList)localObject2).add(((AIOImageData)localxuf.e).aVX);
        } else if (AIOFilePicData.class.isInstance(localxuf.e)) {
          if (localxuf.e.c(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVY);
          } else if (localxuf.e.c(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVX);
          } else if (localxuf.e.c(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localxuf.e).aVW);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ahgq.f(this.mActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  void bb(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[showDialog] type = " + paramInt);
    }
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {
      this.mDialog.dismiss();
    }
    this.mDialog = aqha.a(this.mActivity, 230);
    uon localuon = new uon(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mDialog.setMessage(paramString);
      try
      {
        this.mDialog.show();
        return;
      }
      catch (Exception paramString) {}
      this.mDialog.setNegativeButton(2131720227, localuon);
      continue;
      this.mDialog.setNegativeButton(2131721058, localuon);
      this.mDialog.setPositiveButton(2131720034, new uoo(this));
      continue;
      this.mDialog.setNegativeButton(2131721058, localuon);
      this.mDialog.setPositiveButton(2131720034, new uop(this));
      continue;
      this.mDialog.setCancelable(false);
      this.mDialog.setNegativeButton(2131721058, new uoq(this));
      this.mDialog.setPositiveButton(2131720034, new uor(this));
    }
  }
  
  public List<ChatMessage> cG()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.dQ.iterator();
    while (localIterator.hasNext())
    {
      xuf localxuf = (xuf)localIterator.next();
      ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.b(localxuf.e.id, localxuf.e.subId);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      this.jdField_a_of_type_Xto.h(localxuf);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_Xto.getCount() == 0) {
      this.mEmptyView.setVisibility(0);
    }
    return localArrayList;
  }
  
  public void cg()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.destory();
    if (this.aUc) {
      AppNetConnInfo.unregisterNetEventHandler(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a = null;
    this.mDestroy = true;
  }
  
  void eY(int paramInt1, int paramInt2)
  {
    if (this.G == null)
    {
      this.G = new ReportDialog(this.mActivity, 2131756467);
      this.G.setCancelable(true);
      this.G.setContentView(2131559761);
      this.G.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.G.findViewById(2131373180);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.G.isShowing()) {}
      try
      {
        this.G.show();
        return;
      }
      catch (Exception localException) {}
      str = localTextView.getResources().getText(2131690169) + str;
      continue;
      str = localTextView.getResources().getText(2131690167) + str;
    }
  }
  
  public void expandAll()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.expandAll();
    }
  }
  
  public void fG(long paramLong)
  {
    if ((this.mDestroy) || (this.b == null))
    {
      QLog.i("ChatHistoryImageView", 2, "onRevokeMsg, seq:" + paramLong + ", mDestroy:" + this.mDestroy);
      return;
    }
    this.b.post(new ChatHistoryImageView.1(this, paramLong));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 100: 
    case 101: 
      do
      {
        return bool;
        eY(paramMessage.arg1, paramMessage.arg2);
        return true;
      } while (this.G == null);
      this.G.dismiss();
      this.G = null;
      return true;
    }
    if ((this.G != null) && (this.G.isShowing())) {
      this.G.cancel();
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131693651, 0).show();
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.b.removeMessages(102);
    this.G = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.mRunning = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Xto.j(paramInt);
    if (!xuf.class.isInstance(paramAdapterView)) {}
    label80:
    label84:
    do
    {
      for (;;)
      {
        return;
        paramAdapterView = (xuf)paramAdapterView;
        if (!this.aTT) {
          break;
        }
        if (paramAdapterView.uG() == 1)
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label80;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          if ((!a(paramAdapterView, bool)) || (a(paramView, paramAdapterView))) {
            break label84;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
          return;
          paramInt = 0;
          break;
        }
      }
      this.jdField_a_of_type_Xto.Dx(paramInt);
      this.jdField_a_of_type_Xto.Du(this.mGridView.getFirstVisiblePosition());
      this.jdField_a_of_type_Xto.Dv(this.mGridView.getLastVisiblePosition());
      if (AIOShortVideoData.class.isInstance(paramAdapterView.e))
      {
        paramView = (AIOShortVideoData)paramAdapterView.e;
        if ((paramView.mBusiType != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.id) == null) || (!this.mApp.bF())) {
          break;
        }
        QQToast.a(BaseApplication.getContext(), 0, 2131720263, 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if (!AIOFileVideoData.class.isInstance(paramAdapterView.e)) {
        break label610;
      }
      paramView = (AIOFileVideoData)paramAdapterView.e;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.id);
      if (!(paramView instanceof MessageForFile)) {
        break;
      }
      paramView = ahav.a(this.mApp, (MessageForFile)paramView);
    } while (paramView == null);
    label329:
    label357:
    Object localObject;
    if (ahbj.fileExistsAndNotEmpty(paramView.getFilePath()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PauseDebug", 1, "file existed! isLocalFile:" + paramView.nSessionId);
      }
      if ((paramAdapterView.e instanceof AIOFileVideoData)) {
        ((AIOFileVideoData)paramAdapterView.e).mFilePath = paramView.getFilePath();
      }
      ShortVideoUtils.d(this.mApp.getCurrentAccountUin(), this.mFriendUin, String.valueOf(0), this.mCurType, "3", "3");
      paramView = new Bundle();
      localObject = q();
      if (localObject != null) {
        paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
      }
      if (this.mCurType != 3000) {
        break label656;
      }
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.mFriendUin);
      paramView.putInt("forward_source_uin_type", this.mCurType);
      paramView.putBoolean("extra.OCR", aklr.ae(this.mApp.getCurrentAccountUin(), 7));
      if (this.mCurType == 1)
      {
        localObject = ((TroopManager)this.mApp.getManager(52)).c(this.mFriendUin);
        if (localObject != null) {
          paramView.putString("extra.GROUP_UIN", ((TroopInfo)localObject).troopuin);
        }
      }
      paramView.putBoolean("extra.ENTER_NEW_GALLERY", true);
      avfp.a(this.mActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, paramAdapterView.e, 2, 3);
      if ((paramAdapterView.e == null) || (!(paramAdapterView.e instanceof AIOShortVideoData))) {
        break;
      }
      ShortVideoUtils.d(this.mApp.getCurrentAccountUin(), this.mFriendUin, String.valueOf(((AIOShortVideoData)paramAdapterView.e).bqB * 1000), this.mCurType, "2", "3");
      return;
      if (!paramView.sendCloudUnsuccessful()) {
        break label329;
      }
      ahao.JD(acfp.m(2131703639));
      return;
      label610:
      if (!AIOLightVideoData.class.isInstance(paramAdapterView.e)) {
        break label357;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "lightvideo could not be opened in chathistory");
      }
      QQToast.a(BaseApplication.getContext(), acfp.m(2131703679), 0).show();
      return;
      label656:
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if ((AppNetConnInfo.isMobileConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.mRunning) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.isDownloading) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.aaY))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onNetChangeEvent] show dialog");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.wt(true);
      bb(4, this.mActivity.getString(2131693650));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.mGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_Xto.wu();
      int j = this.jdField_a_of_type_Xto.wv();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.bFu != j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.bFu);
        }
        this.bFu = j;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.ay(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.loadMedias(0);
      }
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool2 = false;
    if (!this.aTT) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Xto.wu() <= paramInt);
      localObject = this.jdField_a_of_type_Xto.j(paramInt);
    } while (!xuf.class.isInstance(localObject));
    Object localObject = (xuf)localObject;
    if (((xuf)localObject).uG() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aTV = bool1;
      bool1 = bool2;
      if (!this.aTV) {
        bool1 = true;
      }
      if (a((xuf)localObject, bool1))
      {
        this.mGridView.invalidateViews();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
      this.aTU = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryImageView", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!this.aTT) {}
    while (!this.aTU) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.mMinIndex > paramInt2)
      {
        this.mMinIndex = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label176;
        }
        localObject = this.jdField_a_of_type_Xto.j(paramInt1);
        if (xuf.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.mMaxIndex < paramInt2) {
        this.mMaxIndex = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (xuf)localObject;
    if (!this.aTV) {}
    for (boolean bool = true;; bool = false)
    {
      a((xuf)localObject, bool);
      break;
    }
    label176:
    paramInt1 = j + 1;
    if (paramInt1 <= this.mMaxIndex)
    {
      localObject = this.jdField_a_of_type_Xto.j(paramInt1);
      if (!xuf.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((xuf)localObject, this.aTV);
      }
    }
    paramInt1 = this.mMinIndex;
    if (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_Xto.j(paramInt1);
      if (!xuf.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((xuf)localObject, this.aTV);
      }
    }
    this.mGridView.invalidateViews();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
  }
  
  public void onSelectEnd()
  {
    if (!this.aTT) {}
    while (!this.aTU) {
      return;
    }
    this.aTU = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectEnd");
    }
    this.aTV = false;
    this.mMaxIndex = -2147483648;
    this.mMinIndex = 2147483647;
  }
  
  public Rect q()
  {
    int i = this.mGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_Xto.wt();
    View localView = this.mGridView.getChildAt(j - i);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i = localView.getWidth();
      j = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i > 0) && (j > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  public void ws(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.zB(paramBoolean);
    }
  }
  
  public class DownloadAndSaveTask
    implements Runnable
  {
    xuf a;
    boolean aUe;
    volatile boolean aUf = false;
    public boolean aaY;
    final Object bL = new Object();
    ArrayList<xuf> infoList;
    volatile boolean isDownloading = false;
    volatile boolean mRunning = true;
    volatile int zN = 0;
    
    public DownloadAndSaveTask(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.infoList = new ArrayList(paramBoolean1);
      this.aUe = paramBoolean2;
      boolean bool;
      this.aaY = bool;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 52	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:aUe	Z
      //   4: ifeq +353 -> 357
      //   7: aload_0
      //   8: iconst_1
      //   9: putfield 37	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:isDownloading	Z
      //   12: aload_0
      //   13: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   16: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   19: bipush 102
      //   21: aload_0
      //   22: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   25: invokevirtual 68	java/util/ArrayList:size	()I
      //   28: i2l
      //   29: ldc2_w 69
      //   32: lmul
      //   33: invokevirtual 76	auru:sendEmptyMessageDelayed	(IJ)Z
      //   36: pop
      //   37: iconst_0
      //   38: istore_1
      //   39: iload_1
      //   40: aload_0
      //   41: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   44: invokevirtual 68	java/util/ArrayList:size	()I
      //   47: if_icmpge +293 -> 340
      //   50: aload_0
      //   51: getfield 35	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:mRunning	Z
      //   54: ifne +17 -> 71
      //   57: aload_0
      //   58: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   61: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   64: bipush 101
      //   66: invokevirtual 80	auru:sendEmptyMessage	(I)Z
      //   69: pop
      //   70: return
      //   71: aload_0
      //   72: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   75: iload_1
      //   76: invokevirtual 84	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   79: checkcast 86	xuf
      //   82: astore 9
      //   84: ldc 88
      //   86: aload 9
      //   88: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   91: invokevirtual 98	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   94: ifeq +167 -> 261
      //   97: aload 9
      //   99: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   102: checkcast 88	com/tencent/mobileqq/activity/aio/photo/AIOImageData
      //   105: astore 10
      //   107: aload 10
      //   109: getfield 102	com/tencent/mobileqq/activity/aio/photo/AIOImageData:aVX	Ljava/lang/String;
      //   112: astore 11
      //   114: ldc 104
      //   116: aload 11
      //   118: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   121: ifne +84 -> 205
      //   124: new 111	java/io/File
      //   127: dup
      //   128: aload 11
      //   130: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
      //   133: invokevirtual 118	java/io/File:exists	()Z
      //   136: ifne +69 -> 205
      //   139: aload_0
      //   140: aload 9
      //   142: putfield 120	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:a	Lxuf;
      //   145: aload 9
      //   147: iconst_1
      //   148: putfield 121	xuf:isDownloading	Z
      //   151: aload_0
      //   152: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   155: getfield 124	com/tencent/mobileqq/activity/ChatHistoryImageView:a	Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;
      //   158: aload 10
      //   160: getfield 128	com/tencent/mobileqq/activity/aio/photo/AIOImageData:id	J
      //   163: aload 10
      //   165: getfield 131	com/tencent/mobileqq/activity/aio/photo/AIOImageData:subId	I
      //   168: iconst_2
      //   169: invokevirtual 137	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:downloadMedia	(JII)V
      //   172: aload_0
      //   173: getfield 120	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:a	Lxuf;
      //   176: astore 9
      //   178: aload 9
      //   180: monitorenter
      //   181: aload_0
      //   182: getfield 120	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:a	Lxuf;
      //   185: getfield 121	xuf:isDownloading	Z
      //   188: istore 6
      //   190: iload 6
      //   192: ifeq +10 -> 202
      //   195: aload_0
      //   196: getfield 120	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:a	Lxuf;
      //   199: invokevirtual 140	java/lang/Object:wait	()V
      //   202: aload 9
      //   204: monitorexit
      //   205: aload_0
      //   206: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:bL	Ljava/lang/Object;
      //   209: astore 9
      //   211: aload 9
      //   213: monitorenter
      //   214: aload_0
      //   215: getfield 39	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:aUf	Z
      //   218: istore 6
      //   220: iload 6
      //   222: ifeq +36 -> 258
      //   225: aload_0
      //   226: getfield 43	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:bL	Ljava/lang/Object;
      //   229: invokevirtual 140	java/lang/Object:wait	()V
      //   232: goto -18 -> 214
      //   235: astore 10
      //   237: goto -23 -> 214
      //   240: astore 10
      //   242: aload 10
      //   244: invokevirtual 143	java/lang/InterruptedException:printStackTrace	()V
      //   247: goto -45 -> 202
      //   250: astore 10
      //   252: aload 9
      //   254: monitorexit
      //   255: aload 10
      //   257: athrow
      //   258: aload 9
      //   260: monitorexit
      //   261: aload_0
      //   262: aload_0
      //   263: getfield 41	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:zN	I
      //   266: iconst_1
      //   267: iadd
      //   268: putfield 41	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:zN	I
      //   271: aload_0
      //   272: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   275: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   278: bipush 100
      //   280: invokevirtual 147	auru:obtainMessage	(I)Landroid/os/Message;
      //   283: astore 9
      //   285: aload 9
      //   287: iconst_1
      //   288: putfield 152	android/os/Message:arg1	I
      //   291: aload 9
      //   293: iload_1
      //   294: iconst_1
      //   295: iadd
      //   296: bipush 100
      //   298: imul
      //   299: aload_0
      //   300: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   303: invokevirtual 68	java/util/ArrayList:size	()I
      //   306: idiv
      //   307: iconst_2
      //   308: idiv
      //   309: putfield 155	android/os/Message:arg2	I
      //   312: aload_0
      //   313: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   316: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   319: aload 9
      //   321: invokevirtual 159	auru:sendMessage	(Landroid/os/Message;)Z
      //   324: pop
      //   325: iload_1
      //   326: iconst_1
      //   327: iadd
      //   328: istore_1
      //   329: goto -290 -> 39
      //   332: astore 10
      //   334: aload 9
      //   336: monitorexit
      //   337: aload 10
      //   339: athrow
      //   340: aload_0
      //   341: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   344: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   347: bipush 102
      //   349: invokevirtual 163	auru:removeMessages	(I)V
      //   352: aload_0
      //   353: iconst_0
      //   354: putfield 37	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:isDownloading	Z
      //   357: aload_0
      //   358: getfield 35	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:mRunning	Z
      //   361: ifne +17 -> 378
      //   364: aload_0
      //   365: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   368: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   371: bipush 101
      //   373: invokevirtual 80	auru:sendEmptyMessage	(I)Z
      //   376: pop
      //   377: return
      //   378: new 111	java/io/File
      //   381: dup
      //   382: getstatic 168	acbn:oM	Ljava/lang/String;
      //   385: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
      //   388: astore 12
      //   390: aload 12
      //   392: invokevirtual 118	java/io/File:exists	()Z
      //   395: ifne +9 -> 404
      //   398: aload 12
      //   400: invokevirtual 171	java/io/File:mkdirs	()Z
      //   403: pop
      //   404: iconst_0
      //   405: istore_1
      //   406: iconst_0
      //   407: istore 4
      //   409: iconst_0
      //   410: istore_3
      //   411: iload_3
      //   412: aload_0
      //   413: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   416: invokevirtual 68	java/util/ArrayList:size	()I
      //   419: if_icmpge +654 -> 1073
      //   422: aload_0
      //   423: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   426: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   429: bipush 100
      //   431: invokevirtual 147	auru:obtainMessage	(I)Landroid/os/Message;
      //   434: astore 9
      //   436: aload 9
      //   438: iconst_2
      //   439: putfield 152	android/os/Message:arg1	I
      //   442: aload_0
      //   443: getfield 52	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:aUe	Z
      //   446: ifeq +64 -> 510
      //   449: aload 9
      //   451: aload_0
      //   452: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   455: invokevirtual 68	java/util/ArrayList:size	()I
      //   458: iload_3
      //   459: iadd
      //   460: bipush 100
      //   462: imul
      //   463: aload_0
      //   464: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   467: invokevirtual 68	java/util/ArrayList:size	()I
      //   470: idiv
      //   471: iconst_2
      //   472: idiv
      //   473: putfield 155	android/os/Message:arg2	I
      //   476: aload_0
      //   477: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   480: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   483: aload 9
      //   485: invokevirtual 159	auru:sendMessage	(Landroid/os/Message;)Z
      //   488: pop
      //   489: aload_0
      //   490: getfield 35	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:mRunning	Z
      //   493: ifne +37 -> 530
      //   496: aload_0
      //   497: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   500: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   503: bipush 101
      //   505: invokevirtual 80	auru:sendEmptyMessage	(I)Z
      //   508: pop
      //   509: return
      //   510: aload 9
      //   512: iload_3
      //   513: bipush 100
      //   515: imul
      //   516: aload_0
      //   517: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   520: invokevirtual 68	java/util/ArrayList:size	()I
      //   523: idiv
      //   524: putfield 155	android/os/Message:arg2	I
      //   527: goto -51 -> 476
      //   530: aload_0
      //   531: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   534: iload_3
      //   535: invokevirtual 84	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   538: checkcast 86	xuf
      //   541: astore 10
      //   543: aconst_null
      //   544: astore 9
      //   546: ldc 88
      //   548: aload 10
      //   550: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   553: invokevirtual 98	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   556: ifeq +132 -> 688
      //   559: aload 10
      //   561: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   564: checkcast 88	com/tencent/mobileqq/activity/aio/photo/AIOImageData
      //   567: iconst_2
      //   568: invokevirtual 175	com/tencent/mobileqq/activity/aio/photo/AIOImageData:c	(I)Ljava/io/File;
      //   571: astore 9
      //   573: aload 9
      //   575: ifnonnull +42 -> 617
      //   578: iload 4
      //   580: istore_2
      //   581: iload_1
      //   582: istore 5
      //   584: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   587: ifeq +17 -> 604
      //   590: ldc 182
      //   592: iconst_2
      //   593: ldc 184
      //   595: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   598: iload_1
      //   599: istore 5
      //   601: iload 4
      //   603: istore_2
      //   604: iload_3
      //   605: iconst_1
      //   606: iadd
      //   607: istore_3
      //   608: iload_2
      //   609: istore 4
      //   611: iload 5
      //   613: istore_1
      //   614: goto -203 -> 411
      //   617: iload 4
      //   619: istore_2
      //   620: iload_1
      //   621: istore 5
      //   623: aload 9
      //   625: ifnull -21 -> 604
      //   628: invokestatic 193	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
      //   631: invokestatic 199	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
      //   634: lstore 7
      //   636: aload 9
      //   638: invokevirtual 203	java/io/File:length	()J
      //   641: lload 7
      //   643: lcmp
      //   644: ifle +142 -> 786
      //   647: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   650: ifeq +11 -> 661
      //   653: ldc 182
      //   655: iconst_2
      //   656: ldc 205
      //   658: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   661: ldc 209
      //   663: invokestatic 215	acfp:m	(I)Ljava/lang/String;
      //   666: invokestatic 220	ahao:JD	(Ljava/lang/String;)V
      //   669: aload_0
      //   670: iconst_0
      //   671: putfield 35	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:mRunning	Z
      //   674: aload_0
      //   675: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   678: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   681: bipush 101
      //   683: invokevirtual 80	auru:sendEmptyMessage	(I)Z
      //   686: pop
      //   687: return
      //   688: ldc 222
      //   690: aload 10
      //   692: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   695: invokevirtual 98	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   698: ifeq -81 -> 617
      //   701: aload 10
      //   703: getfield 92	xuf:e	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
      //   706: checkcast 222	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
      //   709: astore 11
      //   711: aload 11
      //   713: bipush 20
      //   715: invokevirtual 223	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:c	(I)Ljava/io/File;
      //   718: astore 10
      //   720: aload 10
      //   722: astore 9
      //   724: aload 10
      //   726: ifnonnull -109 -> 617
      //   729: aload 11
      //   731: bipush 18
      //   733: invokevirtual 223	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:c	(I)Ljava/io/File;
      //   736: astore 10
      //   738: aload 10
      //   740: astore 9
      //   742: aload 10
      //   744: ifnonnull -127 -> 617
      //   747: aload 11
      //   749: bipush 16
      //   751: invokevirtual 223	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:c	(I)Ljava/io/File;
      //   754: astore 9
      //   756: aload 9
      //   758: ifnonnull +480 -> 1238
      //   761: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   764: ifeq +11 -> 775
      //   767: ldc 182
      //   769: iconst_2
      //   770: ldc 225
      //   772: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   775: iload_1
      //   776: iconst_1
      //   777: iadd
      //   778: istore 5
      //   780: iload 4
      //   782: istore_2
      //   783: goto -179 -> 604
      //   786: new 111	java/io/File
      //   789: dup
      //   790: aload 12
      //   792: new 227	java/lang/StringBuilder
      //   795: dup
      //   796: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   799: aload 9
      //   801: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
      //   804: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   807: ldc 238
      //   809: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   812: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   815: invokespecial 244	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   818: astore 11
      //   820: aload 11
      //   822: astore 10
      //   824: aload 11
      //   826: invokevirtual 118	java/io/File:exists	()Z
      //   829: ifeq +71 -> 900
      //   832: new 111	java/io/File
      //   835: dup
      //   836: aload 12
      //   838: new 227	java/lang/StringBuilder
      //   841: dup
      //   842: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   845: aload 9
      //   847: invokevirtual 232	java/io/File:getName	()Ljava/lang/String;
      //   850: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   853: ldc 246
      //   855: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   858: invokestatic 251	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
      //   861: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   864: ldc 238
      //   866: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   869: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   872: invokespecial 244	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   875: astore 11
      //   877: aload 11
      //   879: astore 10
      //   881: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   884: ifeq +16 -> 900
      //   887: ldc 182
      //   889: iconst_2
      //   890: ldc_w 256
      //   893: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   896: aload 11
      //   898: astore 10
      //   900: aload 10
      //   902: invokevirtual 118	java/io/File:exists	()Z
      //   905: istore 6
      //   907: iload 6
      //   909: ifne +98 -> 1007
      //   912: aload 9
      //   914: aload 10
      //   916: invokestatic 262	dx:copyFile	(Ljava/io/File;Ljava/io/File;)Z
      //   919: ifne +88 -> 1007
      //   922: invokestatic 265	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
      //   925: ldc_w 267
      //   928: invokevirtual 271	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   931: ifne +46 -> 977
      //   934: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   937: ifeq +12 -> 949
      //   940: ldc 182
      //   942: iconst_2
      //   943: ldc_w 273
      //   946: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   949: ldc_w 274
      //   952: invokestatic 215	acfp:m	(I)Ljava/lang/String;
      //   955: invokestatic 220	ahao:JD	(Ljava/lang/String;)V
      //   958: aload_0
      //   959: iconst_0
      //   960: putfield 35	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:mRunning	Z
      //   963: aload_0
      //   964: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   967: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   970: bipush 101
      //   972: invokevirtual 80	auru:sendEmptyMessage	(I)Z
      //   975: pop
      //   976: return
      //   977: iload 4
      //   979: istore_2
      //   980: iload_1
      //   981: istore 5
      //   983: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   986: ifeq -382 -> 604
      //   989: ldc 182
      //   991: iconst_2
      //   992: ldc_w 276
      //   995: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   998: iload 4
      //   1000: istore_2
      //   1001: iload_1
      //   1002: istore 5
      //   1004: goto -400 -> 604
      //   1007: iload 4
      //   1009: iconst_1
      //   1010: iadd
      //   1011: istore 4
      //   1013: aload_0
      //   1014: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   1017: getfield 280	com/tencent/mobileqq/activity/ChatHistoryImageView:mActivity	Landroid/app/Activity;
      //   1020: aload 10
      //   1022: invokevirtual 283	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1025: invokestatic 289	aqhu:cn	(Landroid/content/Context;Ljava/lang/String;)V
      //   1028: iload 4
      //   1030: istore_2
      //   1031: iload_1
      //   1032: istore 5
      //   1034: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1037: ifeq -433 -> 604
      //   1040: ldc 182
      //   1042: iconst_2
      //   1043: iconst_2
      //   1044: anewarray 4	java/lang/Object
      //   1047: dup
      //   1048: iconst_0
      //   1049: ldc_w 291
      //   1052: aastore
      //   1053: dup
      //   1054: iconst_1
      //   1055: iload 6
      //   1057: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1060: aastore
      //   1061: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   1064: iload 4
      //   1066: istore_2
      //   1067: iload_1
      //   1068: istore 5
      //   1070: goto -466 -> 604
      //   1073: iload 4
      //   1075: aload_0
      //   1076: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   1079: invokevirtual 68	java/util/ArrayList:size	()I
      //   1082: iload_1
      //   1083: isub
      //   1084: if_icmpne +60 -> 1144
      //   1087: new 227	java/lang/StringBuilder
      //   1090: dup
      //   1091: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   1094: aload_0
      //   1095: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   1098: getfield 280	com/tencent/mobileqq/activity/ChatHistoryImageView:mActivity	Landroid/app/Activity;
      //   1101: invokevirtual 306	android/app/Activity:getResources	()Landroid/content/res/Resources;
      //   1104: ldc_w 307
      //   1107: invokevirtual 312	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   1110: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1113: getstatic 168	acbn:oM	Ljava/lang/String;
      //   1116: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1119: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1122: invokestatic 315	ahao:JE	(Ljava/lang/String;)V
      //   1125: aload_0
      //   1126: iconst_0
      //   1127: putfield 35	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:mRunning	Z
      //   1130: aload_0
      //   1131: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   1134: getfield 64	com/tencent/mobileqq/activity/ChatHistoryImageView:b	Lauru;
      //   1137: bipush 101
      //   1139: invokevirtual 80	auru:sendEmptyMessage	(I)Z
      //   1142: pop
      //   1143: return
      //   1144: iload 4
      //   1146: ifle +80 -> 1226
      //   1149: new 227	java/lang/StringBuilder
      //   1152: dup
      //   1153: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   1156: getstatic 321	java/util/Locale:CHINA	Ljava/util/Locale;
      //   1159: aload_0
      //   1160: getfield 30	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:this$0	Lcom/tencent/mobileqq/activity/ChatHistoryImageView;
      //   1163: getfield 280	com/tencent/mobileqq/activity/ChatHistoryImageView:mActivity	Landroid/app/Activity;
      //   1166: invokevirtual 306	android/app/Activity:getResources	()Landroid/content/res/Resources;
      //   1169: ldc_w 322
      //   1172: invokevirtual 312	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   1175: iconst_2
      //   1176: anewarray 4	java/lang/Object
      //   1179: dup
      //   1180: iconst_0
      //   1181: iload 4
      //   1183: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1186: aastore
      //   1187: dup
      //   1188: iconst_1
      //   1189: aload_0
      //   1190: getfield 50	com/tencent/mobileqq/activity/ChatHistoryImageView$DownloadAndSaveTask:infoList	Ljava/util/ArrayList;
      //   1193: invokevirtual 68	java/util/ArrayList:size	()I
      //   1196: iload_1
      //   1197: isub
      //   1198: iload 4
      //   1200: isub
      //   1201: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1204: aastore
      //   1205: invokestatic 331	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1208: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1211: getstatic 168	acbn:oM	Ljava/lang/String;
      //   1214: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1217: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1220: invokestatic 315	ahao:JE	(Ljava/lang/String;)V
      //   1223: goto -98 -> 1125
      //   1226: ldc_w 332
      //   1229: invokestatic 215	acfp:m	(I)Ljava/lang/String;
      //   1232: invokestatic 220	ahao:JD	(Ljava/lang/String;)V
      //   1235: goto -110 -> 1125
      //   1238: goto -621 -> 617
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1241	0	this	DownloadAndSaveTask
      //   38	1160	1	i	int
      //   580	487	2	j	int
      //   410	198	3	k	int
      //   407	794	4	m	int
      //   582	487	5	n	int
      //   188	868	6	bool	boolean
      //   634	8	7	l	long
      //   105	59	10	localAIOImageData	AIOImageData
      //   235	1	10	localInterruptedException1	java.lang.InterruptedException
      //   240	3	10	localInterruptedException2	java.lang.InterruptedException
      //   250	6	10	localObject2	Object
      //   332	6	10	localObject3	Object
      //   541	480	10	localObject4	Object
      //   112	785	11	localObject5	Object
      //   388	449	12	localFile	java.io.File
      // Exception table:
      //   from	to	target	type
      //   225	232	235	java/lang/InterruptedException
      //   195	202	240	java/lang/InterruptedException
      //   181	190	250	finally
      //   195	202	250	finally
      //   202	205	250	finally
      //   242	247	250	finally
      //   252	255	250	finally
      //   214	220	332	finally
      //   225	232	332	finally
      //   258	261	332	finally
      //   334	337	332	finally
    }
    
    public void wt(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[setDownloadState] " + paramBoolean);
      }
      synchronized (this.bL)
      {
        this.aUf = paramBoolean;
        if (!this.aUf)
        {
          this.bL.notifyAll();
          ChatHistoryImageView.this.b.sendEmptyMessageDelayed(102, (this.infoList.size() - this.zN) * 60000L);
          return;
        }
        ChatHistoryImageView.this.b.removeMessages(102);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Pm();
    
    public abstract boolean a(xuf paramxuf);
    
    public abstract void b(xuf paramxuf);
    
    public abstract void bKo();
    
    public abstract void e(ChatMessage paramChatMessage);
    
    public abstract void h(ChatMessage paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView
 * JD-Core Version:    0.7.0.1
 */