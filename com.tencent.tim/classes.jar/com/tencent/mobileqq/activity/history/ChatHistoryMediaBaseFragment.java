package com.tencent.mobileqq.activity.history;

import aghq;
import agkf;
import agkh;
import ahao;
import ahav;
import ajlm;
import ajlp;
import ajlu;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqiw;
import aqju;
import aurf;
import ausj;
import auss;
import awou;
import awpd;
import awpl;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.b;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.a;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import xsi;
import xsi.a;
import xtm;
import xuf;
import zer;
import zgi;
import zgj;
import zgk;
import zgm;
import zgn;
import zgo;

public class ChatHistoryMediaBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, ChatHistoryImageView.a, xsi.a
{
  aqju D;
  protected aqju E;
  private Dialog G;
  public ChatHistoryImageView a;
  private aghq b;
  private Button eD;
  List<ChatMessage> qt;
  public ArrayList<xuf> rA;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private View yE;
  
  private boolean Vo()
  {
    return ((getActivity() instanceof ChatHistoryActivity)) && (((ChatHistoryActivity)getActivity()).bqW);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.b paramb)
  {
    if ((this.E != null) && (this.E.isShowing())) {
      this.E.dismiss();
    }
    aqju localaqju = new aqju(getActivity(), 2131756467);
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
    this.E.setNegativeButton(paramString1, new zgn(this, paramb));
    this.E.setPositiveButton(paramString2, new zgo(this, paramb));
    this.E.setCancelable(true);
    this.E.setCanceledOnTouchOutside(false);
    this.E.show();
  }
  
  private void fF(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      awpd.b(this.mApp, getActivity(), getTitleBarHeight(), paramList, this.uiHandler);
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      awpd.a(this.mApp, getActivity(), getTitleBarHeight(), paramList, this.uiHandler);
    }
  }
  
  private void hi(List<xuf> paramList)
  {
    ArrayList localArrayList;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService != null))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localObject = paramList.iterator();
      }
    }
    label361:
    for (;;)
    {
      ChatMessage localChatMessage;
      if (((Iterator)localObject).hasNext())
      {
        paramList = (xuf)((Iterator)localObject).next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramList.e.id);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = ajlp.a((MessageForPic)localChatMessage);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label361;
        }
        localArrayList.add(paramList);
        break;
        if ((localChatMessage instanceof MessageForShortVideo))
        {
          paramList = (MessageForShortVideo)localChatMessage;
          if (paramList.busiType == 0) {
            paramList = ajlp.b(this.mApp, paramList);
          } else {
            paramList = ajlp.a(this.mApp, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.e))
            {
              paramList = ajlp.a(this.mApp, localChatMessage);
              paramList.fileType = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.e))
            {
              paramList = ajlp.a(this.mApp, localChatMessage);
              paramList.fileType = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            int i = ahav.getFileType(((MessageForTroopFile)localChatMessage).fileName);
            if (i == 0)
            {
              paramList = ajlp.a(this.mApp, localChatMessage);
              paramList.fileType = 6;
              continue;
            }
            if (i == 2)
            {
              paramList = ajlp.a(this.mApp, localChatMessage);
              paramList.fileType = 7;
              continue;
              paramList = new ajlm(getActivity());
              localObject = (ajlu)this.mApp.getManager(324);
              ((ajlu)localObject).a(new zgk(this, paramList, (ajlu)localObject, localArrayList));
              ((ajlu)localObject).at(localArrayList, true);
              ((ajlu)localObject).d(localArrayList, 1, 5);
              return;
            }
          }
          paramList = null;
        }
      }
    }
  }
  
  void BA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cpn();
      cpj();
      return;
    }
    cpo();
  }
  
  public boolean Pm()
  {
    boolean bool = false;
    if (this.rA != null) {}
    for (int i = this.rA.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryMediaBaseFragment", 2, "isOverLimit");
        }
        ahao.OS(2131693685);
      }
      return bool;
    }
  }
  
  public boolean a(xuf paramxuf)
  {
    if (this.rA == null) {
      this.rA = new ArrayList();
    }
    if (Vo())
    {
      int i = xtm.a(paramxuf.e);
      if ((i == 2) || (i == 3))
      {
        showTipsDialog(getString(2131693703));
        return false;
      }
      if (AIOImageData.class.isInstance(paramxuf.e))
      {
        AIOImageData localAIOImageData = (AIOImageData)paramxuf.e;
        if ((localAIOImageData.uuid == null) || (localAIOImageData.uuid.length() == 0))
        {
          showTipsDialog(getString(2131693702));
          return false;
        }
      }
    }
    this.rA.add(paramxuf);
    return true;
  }
  
  public void b(xuf paramxuf)
  {
    if (this.rA == null) {
      return;
    }
    this.rA.remove(paramxuf);
  }
  
  public void bKo()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "onMediaLoaded, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_Zer.BB(false);
      return;
    }
    this.jdField_a_of_type_Zer.BB(true);
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  protected void coK()
  {
    if (!CheckPermission.isHasStoragePermission(this.mActivity))
    {
      CheckPermission.requestStorePermission(this.mActivity, null);
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131696348, 1).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if ((this.rA != null) && (this.rA.size() > 0))
    {
      hi(this.rA);
      cpi();
      return;
    }
    ahao.OU(2131693682);
  }
  
  protected void coL()
  {
    if ((this.qt != null) && (this.qt.size() > 0))
    {
      showProgressDialog();
      fF(this.qt);
      cpm();
      return;
    }
    ahao.OU(2131693682);
  }
  
  protected void coM()
  {
    int i = 0;
    int j;
    int k;
    int m;
    if (this.rA != null)
    {
      Iterator localIterator = this.rA.iterator();
      j = 0;
      i = 0;
      k = 0;
      int n = 0;
      while (localIterator.hasNext())
      {
        int i2 = xtm.a(((xuf)localIterator.next()).e);
        if ((n != 0) || (i2 != 1)) {
          break label264;
        }
        j += 1;
        n = 1;
        m = j;
        int i1 = k;
        if (k == 0)
        {
          m = j;
          i1 = k;
          if (i2 == 2)
          {
            m = j + 1;
            i1 = 1;
          }
        }
        if ((i != 0) || (i2 != 3)) {
          break label261;
        }
        m += 1;
        i = 1;
        label121:
        j = m;
        k = i1;
      }
      n = 0 + this.rA.size();
      m = k;
      k = i;
      i = n;
    }
    for (;;)
    {
      if (i == 0)
      {
        ahao.OU(2131693682);
        return;
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(getActivity(), 2131696348, 1).show(getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if (j > 1)
      {
        showTipsDialog(getString(2131693676));
        return;
      }
      if (k != 0)
      {
        showTipsDialog(getString(2131693656));
        return;
      }
      if ((m != 0) && (this.rA.size() > 1))
      {
        showTipsDialog(getString(2131693678));
        return;
      }
      cpl();
      return;
      label261:
      break label121;
      label264:
      break;
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  protected void coN()
  {
    int i = 0;
    if (this.rA != null) {
      i = 0 + this.rA.size();
    }
    if (i == 0)
    {
      ahao.OU(2131693682);
      return;
    }
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.setMainTitle(2131698325);
    localausj.addButton(getActivity().getString(2131693518), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new zgi(this, localausj));
    localausj.show();
  }
  
  void cpg() {}
  
  void cpi() {}
  
  void cpj() {}
  
  protected void cpl() {}
  
  void cpm() {}
  
  protected void cpn()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.bJY();
    }
    if (this.eD != null) {
      this.eD.setEnabled(true);
    }
  }
  
  public void cpo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.bJZ();
    }
    if (this.rA != null)
    {
      this.rA.clear();
      this.rA = null;
    }
    if (this.qt != null)
    {
      this.qt.clear();
      this.qt = null;
    }
    if (this.eD != null) {
      this.eD.setEnabled(false);
    }
    coI();
  }
  
  void dj(ArrayList<xuf> paramArrayList) {}
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    xsi.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.cg();
    }
    if (this.b != null) {
      this.mApp.a().deleteObserver(this.b);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.bJX();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService == null) || (!AIOImageProviderService.gU.containsValue(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.bKl();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.bJW();
    }
    cpo();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "doOnResume, mImageView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Zer != null) {
        this.jdField_a_of_type_Zer.BB(false);
      }
    }
    while (this.jdField_a_of_type_Zer == null) {
      return;
    }
    this.jdField_a_of_type_Zer.BB(true);
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
  
  public void fG(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.fG(paramLong);
    }
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
      return true;
      cpo();
      cpg();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      cpo();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      awpl.b(this.mApp, getActivity(), getTitleBarHeight());
      cpo();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      cpo();
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
        zgm localzgm = new zgm(this);
        a(getString(2131700888), paramMessage, null, null, localzgm);
        return true;
        if (awou.nR(i))
        {
          getString(2131696684);
          paramMessage = getString(2131693268);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.mApp.getApp(), paramMessage, 1).show(getTitleBarHeight());
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.rA != null) && (this.rA.size() != 0)) {
        break;
      }
      ahao.OU(2131693682);
    }
    ArrayList localArrayList = (ArrayList)this.rA.clone();
    Iterator localIterator = localArrayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = xtm.a(((xuf)localIterator.next()).e);
    } while ((i != 2) && (i != 3));
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        showTipsDialog(getString(2131693703));
      }
      for (;;)
      {
        getActivity().finish();
        break;
        dj(localArrayList);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    xsi.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
      if (this.mApp != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getActivity().getIntent(), this.mApp, getActivity());
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.ws(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a = this;
    }
    if ((Vo()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.aI() instanceof RelativeLayout)))
    {
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.aI();
      this.yE = paramLayoutInflater.inflate(2131558890, null);
      this.eD = ((Button)this.yE.findViewById(2131381345));
      this.eD.setOnClickListener(this);
      this.eD.setEnabled(false);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -2);
      paramLayoutInflater.addRule(12, -1);
      paramLayoutInflater.addRule(14, -1);
      paramViewGroup.addView(this.yE, paramLayoutInflater);
    }
    for (paramLayoutInflater = paramViewGroup;; paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.aI())
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (this.mApp != null)
      {
        if (this.b == null) {
          this.b = new a(null);
        }
        this.mApp.a().addObserver(this.b);
      }
    }
  }
  
  public void pH(boolean paramBoolean)
  {
    super.pH(paramBoolean);
    if ((this.mk) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.Pl())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.expandAll();
    }
  }
  
  public void showProgressDialog()
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
      this.D = aqha.a(getActivity(), 230);
      this.D.setNegativeButton(2131720227, new zgj(this));
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
  
  public int ww()
  {
    if ((this.rA == null) || (this.rA.isEmpty())) {
      return 0;
    }
    AIORichMediaData localAIORichMediaData = ((xuf)this.rA.get(0)).e;
    if ((AIOImageData.class.isInstance(localAIORichMediaData)) || (AIOFilePicData.class.isInstance(localAIORichMediaData))) {
      return 1;
    }
    if (AIOShortVideoData.class.isInstance(localAIORichMediaData)) {
      return 2;
    }
    return 0;
  }
  
  protected int yg()
  {
    return 1602;
  }
  
  class a
    extends aghq
  {
    private a() {}
    
    public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
      }
      paramString1 = ChatHistoryMediaBaseFragment.this.mApp.a().b(paramLong2);
      if ((paramString1 != null) && (paramString1.nOpType == 6) && (awou.nP(paramInt2)) && (ChatHistoryMediaBaseFragment.this.uiHandler != null)) {
        ChatHistoryMediaBaseFragment.this.uiHandler.sendEmptyMessage(102);
      }
    }
    
    public void b(long paramLong, String paramString1, int paramInt, String paramString2)
    {
      if ((awou.nP(paramInt)) && (ChatHistoryMediaBaseFragment.this.uiHandler != null)) {
        ChatHistoryMediaBaseFragment.this.uiHandler.sendEmptyMessage(102);
      }
    }
    
    public void e(int paramInt, long paramLong, String paramString)
    {
      if ((awou.nP(paramInt)) && (ChatHistoryMediaBaseFragment.this.uiHandler != null)) {
        ChatHistoryMediaBaseFragment.this.uiHandler.sendEmptyMessage(102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment
 * JD-Core Version:    0.7.0.1
 */