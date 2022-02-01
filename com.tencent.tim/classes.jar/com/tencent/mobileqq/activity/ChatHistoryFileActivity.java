package com.tencent.mobileqq.activity;

import acfp;
import afrq;
import aghq;
import aghw;
import agkf;
import agkh;
import agmx;
import agzy;
import ahal;
import ahao;
import ahau;
import ahav;
import ahgq;
import ajlm;
import ajlp;
import ajlu;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aobw;
import aqha;
import aqhq;
import aqiw;
import aqju;
import armm;
import aurf;
import ausj;
import auss;
import awou;
import awpd;
import awpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import unt;
import unu;
import unv;
import unx;
import uny;
import unz;
import uoa;
import uob;
import uoc;
import uod;
import uoe;
import uof;
import uog;
import uos;
import uou;
import wja;
import xsi;
import xsi.a;
import xtm;
import xuf;
import ymn;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, xsi.a
{
  aqju D;
  private aqju E;
  private Dialog G;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  unt jdField_a_of_type_Unt;
  uog jdField_a_of_type_Uog;
  uos jdField_a_of_type_Uos;
  public uou a;
  private ymn jdField_a_of_type_Ymn;
  String aLX;
  FrameLayout aR;
  public boolean aTX = false;
  private boolean aTY;
  private aghq b;
  private int bms;
  LinearLayout fT;
  public RelativeLayout mRoot;
  String mUin;
  int mUinType;
  ImageView pD;
  ImageView pE;
  ImageView pF;
  ImageView pG;
  public List<FileManagerEntity> pw;
  public List<ChatMessage> qp;
  public List<xuf> qq;
  public List<TencentDocData> qr;
  List<afrq> qs;
  List<ChatMessage> qt;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_Uou = null;
  }
  
  private uou a(int paramInt)
  {
    this.bms = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_Uog == null)
      {
        this.jdField_a_of_type_Uog = new uog();
        this.jdField_a_of_type_Uog.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_Uog.At(paramInt);
      return this.jdField_a_of_type_Uog;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    case 2: 
      if (this.jdField_a_of_type_Uos == null)
      {
        this.jdField_a_of_type_Uos = new uos();
        this.jdField_a_of_type_Uos.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_Uos;
    }
    if (this.jdField_a_of_type_Unt == null)
    {
      this.jdField_a_of_type_Unt = new unt();
      this.jdField_a_of_type_Unt.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_Unt;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, b paramb)
  {
    if ((this.E != null) && (this.E.isShowing())) {
      this.E.dismiss();
    }
    aqju localaqju = new aqju(this, 2131756467);
    localaqju.setContentView(2131559151);
    this.E = localaqju;
    this.E.setTitle(paramString1);
    this.E.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131721058);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691970);
    }
    this.E.setNegativeButton(paramString1, new uoe(this, paramb));
    this.E.setPositiveButton(paramString2, new uof(this, paramb));
    this.E.setCancelable(true);
    this.E.setCanceledOnTouchOutside(false);
    this.E.show();
  }
  
  private void bKb()
  {
    this.pD = ((ImageView)findViewById(2131367523));
    this.pE = ((ImageView)findViewById(2131366061));
    this.pF = ((ImageView)findViewById(2131377646));
    this.pG = ((ImageView)findViewById(2131365670));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839731);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839732);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839731);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.pF.setImageDrawable(localStateListDrawable);
    this.pD.setOnClickListener(this);
    this.pE.setOnClickListener(this);
    this.pF.setOnClickListener(this);
    this.pG.setOnClickListener(this);
    this.pD.setEnabled(true);
    this.pE.setEnabled(true);
    this.pF.setEnabled(true);
    this.pG.setEnabled(true);
  }
  
  private void fF(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      awpd.b(this.app, this, getTitleBarHeight(), paramList, this.uiHandler);
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      awpd.a(this.app, this, getTitleBarHeight(), paramList, this.uiHandler);
    }
  }
  
  private void v(List<xuf> paramList, List<afrq> paramList1)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a != null))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localIterator = paramList.iterator();
      }
    }
    label429:
    for (;;)
    {
      ChatMessage localChatMessage;
      if (localIterator.hasNext())
      {
        paramList = (xuf)localIterator.next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(paramList.e.id);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = ajlp.a((MessageForPic)localChatMessage);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label429;
        }
        localArrayList.add(paramList);
        break;
        if ((localChatMessage instanceof MessageForShortVideo))
        {
          paramList = (MessageForShortVideo)localChatMessage;
          if (paramList.busiType == 0) {
            paramList = ajlp.b(this.app, paramList);
          } else {
            paramList = ajlp.a(this.app, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.e))
            {
              paramList = ajlp.a(this.app, localChatMessage);
              paramList.fileType = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.e))
            {
              paramList = ajlp.a(this.app, localChatMessage);
              paramList.fileType = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.e))
            {
              paramList = ajlp.a(this.app, localChatMessage);
              paramList.fileType = 6;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.e))
            {
              paramList = ajlp.a(this.app, localChatMessage);
              paramList.fileType = 7;
              continue;
              if ((paramList1 != null) && (!paramList1.isEmpty()))
              {
                paramList = paramList1.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (afrq)paramList.next();
                  if ((paramList1.h instanceof MessageForPic)) {
                    localArrayList.add(ajlp.a((MessageForPic)paramList1.h));
                  }
                }
              }
              paramList = new ajlm(this);
              paramList1 = (ajlu)this.app.getManager(324);
              paramList1.a(new unv(this, paramList, paramList1, localArrayList));
              paramList1.at(localArrayList, true);
              paramList1.d(localArrayList, 1, 5);
              return;
            }
          }
          paramList = null;
        }
      }
    }
  }
  
  public boolean Pm()
  {
    boolean bool = false;
    if (this.qp != null) {}
    for (int j = this.qp.size() + 0;; j = 0)
    {
      int i = j;
      if (this.pw != null) {
        i = j + this.pw.size();
      }
      j = i;
      if (this.qq != null) {
        j = i + this.qq.size();
      }
      i = j;
      if (this.qr != null) {
        i = j + this.qr.size();
      }
      j = i;
      if (this.qs != null) {
        j = i + this.qs.size();
      }
      if (j >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFIleActivity", 2, "isOverLimit");
        }
        ahao.OS(2131693685);
      }
      return bool;
    }
  }
  
  public void a(afrq paramafrq)
  {
    if (this.qs == null) {
      this.qs = new ArrayList();
    }
    this.qs.add(paramafrq);
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (this.qr == null) {
      this.qr = new ArrayList();
    }
    this.qr.add(paramTencentDocData);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.pw == null) {
      this.pw = new ArrayList();
    }
    this.pw.add(paramFileManagerEntity);
  }
  
  public void a(xuf paramxuf)
  {
    if (this.qq == null) {
      this.qq = new ArrayList();
    }
    this.qq.add(paramxuf);
  }
  
  public boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<xuf> paramList2, List<TencentDocData> paramList3)
  {
    int n = 0;
    int i1 = 0;
    boolean bool2;
    int k;
    int m;
    if (aobw.d(paramList3))
    {
      bool2 = true;
      k = 0;
      m = 0;
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label2160;
      }
      m = 1;
      k = 0 + paramList1.size();
    }
    label187:
    label234:
    label2160:
    for (int i3 = 1;; i3 = 0)
    {
      int i = m;
      int j = k;
      if (bool2)
      {
        i = m + 1;
        j = k + paramList3.size();
      }
      int i4;
      if ((paramList != null) && (paramList.size() > 0))
      {
        k = paramList.size();
        i4 = 1;
        j += k;
        i += 1;
      }
      for (;;)
      {
        Object localObject1;
        boolean bool1;
        if ((this.qs != null) && (!this.qs.isEmpty())) {
          if (paramInt == 1)
          {
            localObject1 = this.qs.iterator();
            while (((Iterator)localObject1).hasNext()) {
              if ((((afrq)((Iterator)localObject1).next()).h instanceof MessageForMarketFace))
              {
                bool1 = true;
                k = j + this.qs.size();
                i += 1;
              }
            }
          }
        }
        for (;;)
        {
          int i2;
          if (paramList2 != null)
          {
            localObject1 = paramList2.iterator();
            j = i;
            i = 0;
            m = 0;
            n = 0;
            if (((Iterator)localObject1).hasNext())
            {
              int i5 = xtm.a(((xuf)((Iterator)localObject1).next()).e);
              if ((n == 0) && (i5 == 1))
              {
                n = 1;
                j += 1;
                i2 = j;
                i1 = m;
                if (m == 0)
                {
                  i2 = j;
                  i1 = m;
                  if (i5 == 2)
                  {
                    i1 = 1;
                    i2 = j + 1;
                  }
                }
                if ((i == 0) && (i5 == 3))
                {
                  i = i2 + 1;
                  j = 1;
                  if ((paramInt != 1) && (i >= 2))
                  {
                    m = i1;
                    i1 = paramList2.size();
                    i1 += k;
                    k = j;
                    j = i1;
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (j == 0)
            {
              ahao.OU(2131693682);
              return false;
              bool2 = false;
              break;
              bool1 = true;
              break label187;
              m = j;
              j = i;
              i = m;
              m = i1;
              break label234;
            }
            switch (paramInt)
            {
            default: 
              return true;
            case 0: 
              if (!aqiw.isNetSupport(BaseApplication.getContext()))
              {
                QQToast.a(this, 2131696348, 1).show(getResources().getDimensionPixelSize(2131299627));
                return false;
              }
              if (i > 1)
              {
                showTipsDialog(getString(2131693676));
                return false;
              }
              if (k != 0)
              {
                showTipsDialog(getString(2131693656));
                return false;
              }
              if ((m != 0) && (paramList2.size() > 1))
              {
                showTipsDialog(getString(2131693678));
                return false;
              }
              if (paramList1 != null)
              {
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  ahao.OS(2131693695);
                  return false;
                }
                localObject1 = paramList1.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                } while (!agzy.a((FileManagerEntity)((Iterator)localObject1).next()).bd(false));
              }
              break;
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                ahal.a(this, 2131693826, 2131693832, new uoa(this, paramList1));
              }
              while ((paramList2 != null) && (paramList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.bBS();
                return false;
                ahav.b(paramList1, this);
              }
              paramList1 = new ArrayList();
              if (paramList != null) {
                paramList1.addAll(paramList);
              }
              if (bool2)
              {
                paramList1.addAll(aobw.b(paramList3, this.mUin, null));
                ahau.JH("0X8009AA1");
              }
              if ((paramList1 != null) && (paramList1.size() == 1))
              {
                paramList2 = (MessageForStructing)paramList1.get(0);
                if (paramList2.structingMsg != null)
                {
                  paramList = new Bundle();
                  if ((paramList2.structingMsg.source_puin != null) && (!"".equals(paramList2.structingMsg.source_puin))) {
                    paramList.putString("source_puin", paramList2.structingMsg.source_puin);
                  }
                  paramList.putInt("forward_type", -3);
                  paramList2.structingMsg.mCommentText = null;
                  paramList.putInt("structmsg_service_id", paramList2.structingMsg.mMsgServiceID);
                  paramList.putByteArray("stuctmsg_bytes", paramList2.structingMsg.getBytes());
                  paramList.putLong("structmsg_uniseq", paramList2.uniseq);
                  paramList.putInt("accostType", paramList2.structingMsg.sourceAccoutType);
                  paramList.putBoolean("forwardDirect", true);
                  paramList2 = new Intent();
                  paramList2.putExtras(paramList);
                  paramList2.putExtra("forwardDirect", true);
                  ahgq.f(this, paramList2, 3);
                }
              }
              if (((paramList1 == null) || (paramList1.size() <= 1)) && (!bool1)) {
                break;
              }
              paramList = new ArrayList();
              if (paramList1 != null) {
                paramList.addAll(paramList1);
              }
              if (bool1)
              {
                paramList1 = this.qs.iterator();
                while (paramList1.hasNext()) {
                  paramList.add((ChatMessage)((afrq)paramList1.next()).h);
                }
              }
              this.aTY = bool1;
              this.jdField_a_of_type_Ymn.gG(paramList);
              break;
              if (((n != 0) || (m != 0)) && (i3 != 0))
              {
                showTipsDialog(getString(2131693674));
                return false;
              }
              if ((i4 != 0) || (bool2) || (bool1))
              {
                showTipsDialog(getString(2131693675));
                return false;
              }
              if (!CheckPermission.isHasStoragePermission(this))
              {
                CheckPermission.requestStorePermission(this, null);
                return false;
              }
              long l;
              if (paramList1 != null)
              {
                l = 0L;
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  ahao.OS(2131693694);
                  return false;
                }
                paramList = paramList1.iterator();
                if (paramList.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList.next();
                  if (!agzy.a(paramList3).bd(true)) {
                    break label2087;
                  }
                  l = paramList3.fileSize + l;
                }
              }
              for (;;)
              {
                break label1165;
                paramList = this.app.a();
                if ((ahav.amK()) && (l > agmx.fJ())) {
                  ahav.b(false, this, new uob(this, paramList1, paramList));
                }
                while (((paramList2 != null) && (paramList2.size() > 0)) || ((!bool1) && (this.qs != null) && (!this.qs.isEmpty())))
                {
                  v(paramList2, this.qs);
                  return false;
                  paramList1 = paramList1.iterator();
                  while (paramList1.hasNext())
                  {
                    paramList3 = (FileManagerEntity)paramList1.next();
                    if (!paramList3.sendCloudUnsuccessful()) {
                      paramList.l(paramList3);
                    }
                  }
                }
                if (((paramList2 != null) && (this.qt != null)) || ((paramList != null) && (paramList.size() > 0)) || ((paramList1 != null) && (paramList1.size() > 0))) {
                  showProgressDialog();
                }
                if ((paramList2 != null) && (this.qt != null)) {
                  fF(this.qt);
                }
                if (paramList != null)
                {
                  fF(paramList);
                  break;
                }
                if ((paramList1 == null) || (paramList1.size() <= 0)) {
                  break;
                }
                paramList = (FileManagerEntity)paramList1.get(0);
                paramList = this.app.a();
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  ahao.OS(2131693696);
                  return false;
                }
                paramList2 = paramList1.iterator();
                do
                {
                  if (!paramList2.hasNext()) {
                    break;
                  }
                } while (!agzy.a((FileManagerEntity)paramList2.next()).bd(false));
                for (paramInt = 1;; paramInt = 0)
                {
                  if (paramInt != 0)
                  {
                    if (!armm.a(this, 5, new uoc(this, paramList1, paramList))) {
                      break;
                    }
                    ahal.a(this, 2131693826, 2131693830, new uod(this, paramList1, paramList));
                    break;
                  }
                  paramList1 = paramList1.iterator();
                  paramInt = 0;
                  while (paramList1.hasNext())
                  {
                    paramList2 = (FileManagerEntity)paramList1.next();
                    if (!paramList2.sendCloudUnsuccessful()) {
                      if (aqhq.fileExistsAndNotEmpty(paramList2.getFilePath()))
                      {
                        paramList.a(paramList2.getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
                        paramInt = 1;
                      }
                      else
                      {
                        paramInt = 1;
                        paramList.a(paramList2, String.valueOf(paramList2.peerUin));
                      }
                    }
                  }
                  if (paramInt != 0)
                  {
                    ahao.JG(getString(2131694101));
                    break;
                  }
                  ahao.OS(2131693696);
                  if (this.uiHandler == null) {
                    break;
                  }
                  this.uiHandler.sendEmptyMessage(102);
                  break;
                  localObject1 = new ArrayList();
                  Iterator localIterator;
                  Object localObject2;
                  if ((paramList1 != null) && (paramList1.size() > 0))
                  {
                    localIterator = paramList1.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (FileManagerEntity)localIterator.next();
                      localObject2 = this.app.b().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
                      if (localObject2 != null) {
                        ((List)localObject1).add((ChatMessage)localObject2);
                      }
                    }
                  }
                  if ((paramList2 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
                  {
                    paramList2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.cG();
                    localIterator = paramList2.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (ChatMessage)localIterator.next();
                      if (((ChatMessage)localObject2).msgtype == -2005)
                      {
                        localObject2 = this.app.a().a(((ChatMessage)localObject2).uniseq, ((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop);
                        if (localObject2 != null) {
                          this.app.a().ca(((FileManagerEntity)localObject2).nSessionId);
                        }
                      }
                    }
                    ((List)localObject1).addAll(paramList2);
                  }
                  if ((paramList != null) && (paramList.size() > 0)) {
                    ((List)localObject1).addAll(paramList);
                  }
                  if ((this.qs != null) && (!this.qs.isEmpty()))
                  {
                    paramList = this.qs.iterator();
                    while (paramList.hasNext()) {
                      ((List)localObject1).add((ChatMessage)((afrq)paramList.next()).h);
                    }
                  }
                  if (((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool2)) || ((((List)localObject1).size() <= 0) && (!aobw.d(paramList1)) && (!bool2))) {
                    break;
                  }
                  ThreadManager.post(new ChatHistoryFileActivity.7(this, (List)localObject1, paramList1, bool2, paramList3), 8, null, true);
                  break;
                }
              }
            }
            j = i;
            i = i2;
            break label338;
            break label282;
            i1 = i;
            i = j;
            j = i1;
            break label353;
            j = k;
            m = 0;
            k = i1;
          }
          bool1 = false;
          break label187;
          bool1 = false;
          k = j;
        }
        i4 = 0;
      }
    }
  }
  
  public boolean a(TencentDocData paramTencentDocData)
  {
    return (this.qr != null) && (this.qr.contains(paramTencentDocData));
  }
  
  public void b(afrq paramafrq)
  {
    if (this.qs == null) {
      return;
    }
    this.qs.remove(paramafrq);
  }
  
  public void b(TencentDocData paramTencentDocData)
  {
    if (this.qr == null) {
      return;
    }
    this.qr.remove(paramTencentDocData);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.pw == null) {
      return;
    }
    this.pw.remove(paramFileManagerEntity);
  }
  
  public void b(xuf paramxuf)
  {
    if (this.qq == null) {
      return;
    }
    this.qq.remove(paramxuf);
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.pw == null) {
      return false;
    }
    return this.pw.contains(paramFileManagerEntity);
  }
  
  public void bKc()
  {
    boolean bool;
    if (!this.aTX)
    {
      bool = true;
      this.aTX = bool;
      if (!this.aTX) {
        break label57;
      }
      this.fT.setVisibility(0);
      this.aR.setVisibility(0);
      this.jdField_a_of_type_Uou.bJY();
      setRightButton(2131721058, this);
    }
    label57:
    do
    {
      return;
      bool = false;
      break;
      this.fT.setVisibility(8);
      this.aR.setVisibility(8);
      this.jdField_a_of_type_Uou.bJZ();
      setRightButton(2131690235, this);
      this.qr = null;
      this.qq = null;
      this.qp = null;
      this.pw = null;
      this.qt = null;
    } while ((this.qs == null) || (this.qs.isEmpty()));
    Iterator localIterator = this.qs.iterator();
    while (localIterator.hasNext()) {
      ((afrq)localIterator.next()).isSelected = false;
    }
    this.qs.clear();
  }
  
  public boolean c(ChatMessage paramChatMessage)
  {
    if (this.qp == null) {
      return false;
    }
    return this.qp.contains(paramChatMessage);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (paramInt1 == 1) {
        bKc();
      }
      return;
      Intent localIntent = new Intent(this, SendPhotoActivity.class);
      paramIntent = new Bundle(paramIntent.getExtras());
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
      }
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = wja.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      paramIntent.putBoolean("send_in_background", false);
      localIntent.putExtras(paramIntent);
      startActivity(localIntent);
      continue;
      bKc();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.af(paramIntent);
        continue;
        if (!this.aTY) {
          this.jdField_a_of_type_Ymn.cy(paramIntent);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent();
    this.mUin = ((Intent)localObject).getStringExtra("uin");
    this.mUinType = ((Intent)localObject).getIntExtra("uintype", 0);
    this.aLX = ((Intent)localObject).getStringExtra("uinname");
    setContentView(2131558891);
    setTitle(2131691407);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131721059);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131379165);
      paramBundle.a(0, acfp.m(2131703661));
      paramBundle.a(1, acfp.m(2131703681));
      paramBundle.a(2, acfp.m(2131703671));
      paramBundle.a(3, acfp.m(2131703609));
      paramBundle.a(4, acfp.m(2131703680));
      this.fT = ((LinearLayout)findViewById(2131377957));
      this.fT.setVisibility(8);
      this.aR = ((FrameLayout)findViewById(2131379985));
      this.fT.setVisibility(8);
      this.aR.setVisibility(8);
      setRightButton(2131690235, this);
      bKb();
      this.mRoot = ((RelativeLayout)findViewById(2131371085));
      paramBundle.setOnTabChangeListener(new unu(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.jdField_a_of_type_Ymn = new ymn(this, 3);
        this.jdField_a_of_type_Ymn.onCreate();
        xsi.a().a(this);
        if (this.b == null) {
          this.b = new a(null);
        }
        this.app.a().addObserver(this.b);
        return true;
        setLeftViewName((Intent)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("ChatHistoryFIleActivity", 1, "extra KEY_INITIAL_TAB " + (String)localObject + " is not number");
          int i = 0;
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Ymn.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.cg();
    }
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.cg();
    }
    if (this.b != null) {
      this.app.a().deleteObserver(this.b);
    }
    xsi.a().b(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.aTX))
    {
      bKc();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Uou != null) {
      this.jdField_a_of_type_Uou.bJX();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Uou != null)
    {
      this.jdField_a_of_type_Uou.At(this.bms);
      this.jdField_a_of_type_Uou.bJW();
    }
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    if (this.qt == null) {
      this.qt = new ArrayList();
    }
    this.qt.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addweiyunselected, size: " + this.qt.size());
    }
  }
  
  public void f(ChatMessage paramChatMessage)
  {
    if (this.qp == null) {
      this.qp = new ArrayList();
    }
    this.qp.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addselect, size: " + this.qp.size());
    }
  }
  
  public void fG(long paramLong)
  {
    if (this.jdField_a_of_type_Uou != null) {
      this.jdField_a_of_type_Uou.fG(paramLong);
    }
  }
  
  public void g(ChatMessage paramChatMessage)
  {
    if (this.qp == null) {}
    do
    {
      return;
      this.qp.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeselect, size: " + this.qp.size());
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public void h(ChatMessage paramChatMessage)
  {
    if (this.qt == null) {}
    do
    {
      return;
      this.qt.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeweiyunselect, size: " + this.qt.size());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Uos != null) {
          this.jdField_a_of_type_Uos.fG(this.qp);
        }
        if (this.jdField_a_of_type_Unt != null) {
          this.jdField_a_of_type_Unt.refreshData();
        }
        bKc();
        a(this.bms);
        return true;
      } while (this.G == null);
      this.G.dismiss();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      awpl.b(this.app, this, getTitleBarHeight());
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      i = paramMessage.arg1;
    } while (!awou.nP(i));
    if (awou.nS(i))
    {
      getString(2131696684);
      paramMessage = "";
      if (awou.nQ(i))
      {
        getString(2131696684);
        paramMessage = getString(2131693270);
      }
      for (;;)
      {
        unx localunx = new unx(this);
        a(getString(2131700888), paramMessage, null, null, localunx);
        return true;
        if (awou.nR(i))
        {
          getString(2131696684);
          paramMessage = getString(2131693268);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.app.getApp(), paramMessage, 1).show(getTitleBarHeight());
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2130772414);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bKc();
      if (this.aTX)
      {
        anot.a(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
        continue;
        if (a(0, this.qp, this.pw, this.qq, this.qr)) {
          bKc();
        }
        anot.a(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
        continue;
        if (a(1, this.qp, this.pw, this.qq, this.qr)) {
          bKc();
        }
        anot.a(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
        continue;
        if (a(2, this.qp, this.pw, this.qq, this.qr)) {
          bKc();
        }
        anot.a(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
        continue;
        anot.a(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
        if (this.qp != null) {
          j = 0 + this.qp.size();
        }
        int i = j;
        if (this.pw != null) {
          i = j + this.pw.size();
        }
        j = i;
        if (this.qq != null) {
          j = i + this.qq.size();
        }
        i = j;
        if (this.qr != null) {
          i = j + this.qr.size();
        }
        j = i;
        if (this.qs != null) {
          j = i + this.qs.size();
        }
        if (j == 0)
        {
          ahao.OU(2131693682);
        }
        else
        {
          ausj localausj = (ausj)auss.a(this, null);
          localausj.setMainTitle(2131698325);
          localausj.addButton(getString(2131693518), 3);
          localausj.addCancelButton(2131721058);
          localausj.a(new unz(this, localausj));
          localausj.show();
        }
      }
    }
  }
  
  void showProgressDialog()
  {
    if (this.G == null)
    {
      this.G = new ReportDialog(getActivity(), 2131756467);
      this.G.setCanceledOnTouchOutside(false);
      this.G.setContentView(2131559761);
    }
    TextView localTextView = (TextView)this.G.findViewById(2131373180);
    localTextView.setText(localTextView.getResources().getString(2131690167));
    if (!this.G.isShowing()) {}
    try
    {
      this.G.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void showTipsDialog(String paramString)
  {
    if (this.D == null)
    {
      this.D = aqha.a(this, 230);
      this.D.setNegativeButton(2131720227, new uny(this));
    }
    if (!this.D.isShowing()) {
      this.D.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.D.show();
        return;
      }
      catch (Throwable paramString) {}
      this.D.dismiss();
    }
  }
  
  class a
    extends aghq
  {
    private a() {}
    
    public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryFIleActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
      }
      paramString1 = ChatHistoryFileActivity.this.app.a().b(paramLong2);
      if ((paramString1 != null) && (paramString1.nOpType == 6) && (awou.nP(paramInt2)) && (ChatHistoryFileActivity.this.uiHandler != null)) {
        ChatHistoryFileActivity.this.uiHandler.sendEmptyMessage(102);
      }
    }
    
    public void b(long paramLong, String paramString1, int paramInt, String paramString2)
    {
      if ((awou.nP(paramInt)) && (ChatHistoryFileActivity.this.uiHandler != null)) {
        ChatHistoryFileActivity.this.uiHandler.sendEmptyMessage(102);
      }
    }
    
    public void e(int paramInt, long paramLong, String paramString)
    {
      if ((awou.nP(paramInt)) && (ChatHistoryFileActivity.this.uiHandler != null)) {
        ChatHistoryFileActivity.this.uiHandler.sendEmptyMessage(102);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean ah(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */