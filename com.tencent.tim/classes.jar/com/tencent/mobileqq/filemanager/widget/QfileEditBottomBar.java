package com.tencent.mobileqq.filemanager.widget;

import acfp;
import aghw;
import agkf;
import agkj;
import agmx;
import agmz;
import agys;
import ahal;
import ahao;
import ahav;
import ahbj;
import ahbk;
import ahdh;
import ahdi;
import ahdj;
import ahdk;
import ahdl;
import ahdm;
import ahdn;
import ahgq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anot;
import anre;
import aobw;
import aqha;
import aqiw;
import aqju;
import armm;
import ausj;
import auss;
import aviz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import ymn;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  final String TAG = "QfileEditBottomBar";
  private agys jdField_a_of_type_Agys;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private QQAppInterface app;
  int bms = -1;
  public ahbk c;
  private BaseFileAssistantActivity c;
  SparseArray<Integer> cC = new SparseArray();
  private Context context;
  ImageView fg;
  ImageView lW;
  ImageView vm;
  ImageView vq;
  ImageView zP;
  
  public QfileEditBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561000, this, true);
    this.context = paramContext;
    initUI();
  }
  
  private long a(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = agmz.D().iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      FileManagerEntity localFileManagerEntity = ahav.a(localFileInfo);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.setType(10000);
      localForwardFileInfo.Oj(localFileManagerEntity.getCloudType());
      localForwardFileInfo.p(localFileManagerEntity.nSessionId);
      localForwardFileInfo.setFileName(localFileManagerEntity.fileName);
      localForwardFileInfo.jB(localFileManagerEntity.uniseq);
      localForwardFileInfo.setFileId(localFileManagerEntity.WeiYunFileId);
      localForwardFileInfo.setFileSize(localFileManagerEntity.fileSize);
      localForwardFileInfo.setLocalPath(localFileManagerEntity.getFilePath());
      localForwardFileInfo.setUuid(localFileManagerEntity.Uuid);
      if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath)) {
        localForwardFileInfo.aA(localFileManagerEntity.strLargeThumPath);
      }
      for (;;)
      {
        paramArrayList1.add(Uri.parse(localFileInfo.getPath()));
        long l2 = localForwardFileInfo.getFileSize();
        paramArrayList.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
          localForwardFileInfo.aA(localFileManagerEntity.strMiddleThumPath);
        } else {
          localForwardFileInfo.aA(localFileManagerEntity.strThumbPath);
        }
      }
    }
    return l1;
  }
  
  private long b(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = agmz.db().iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!localFileManagerEntity.sendCloudUnsuccessful()) && (localFileManagerEntity.nFileType != 13))
      {
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.setType(10001);
        localForwardFileInfo.Oj(localFileManagerEntity.getCloudType());
        localForwardFileInfo.p(localFileManagerEntity.nSessionId);
        localForwardFileInfo.setFileName(localFileManagerEntity.fileName);
        localForwardFileInfo.jB(localFileManagerEntity.uniseq);
        localForwardFileInfo.setFileId(localFileManagerEntity.WeiYunFileId);
        localForwardFileInfo.setFileSize(localFileManagerEntity.fileSize);
        localForwardFileInfo.setLocalPath(localFileManagerEntity.getFilePath());
        localForwardFileInfo.setUuid(localFileManagerEntity.Uuid);
        if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath))
        {
          localForwardFileInfo.aA(localFileManagerEntity.strLargeThumPath);
          label170:
          if ((localFileManagerEntity.getCloudType() != 3) || (localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() <= 0)) {
            break label270;
          }
          paramArrayList1.add(Uri.parse(localFileManagerEntity.getFilePath()));
        }
        for (;;)
        {
          long l2 = localForwardFileInfo.getFileSize();
          paramArrayList.add(localForwardFileInfo);
          l1 = l2 + l1;
          break;
          if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath))
          {
            localForwardFileInfo.aA(localFileManagerEntity.strMiddleThumPath);
            break label170;
          }
          localForwardFileInfo.aA(localFileManagerEntity.strThumbPath);
          break label170;
          label270:
          paramArrayList1.add(Uri.parse(""));
        }
      }
    }
    return l1;
  }
  
  private long c(ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    Iterator localIterator = agmz.dd().iterator();
    long l = 0L;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      localObject2 = this.app.a().f(localWeiYunFileInfo.bIk);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.app.a().c(localWeiYunFileInfo.bIk);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ahav.b(localWeiYunFileInfo);
        }
      }
      localObject2 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject2).setType(10003);
      ((ForwardFileInfo)localObject2).Oj(((FileManagerEntity)localObject1).getCloudType());
      ((ForwardFileInfo)localObject2).p(((FileManagerEntity)localObject1).nSessionId);
      ((ForwardFileInfo)localObject2).setFileName(((FileManagerEntity)localObject1).fileName);
      ((ForwardFileInfo)localObject2).jB(((FileManagerEntity)localObject1).uniseq);
      ((ForwardFileInfo)localObject2).setFileId(((FileManagerEntity)localObject1).WeiYunFileId);
      ((ForwardFileInfo)localObject2).setFileSize(((FileManagerEntity)localObject1).fileSize);
      ((ForwardFileInfo)localObject2).setLocalPath(((FileManagerEntity)localObject1).getFilePath());
      ((ForwardFileInfo)localObject2).setUuid(((FileManagerEntity)localObject1).Uuid);
      l += ((ForwardFileInfo)localObject2).getFileSize();
      paramArrayList.add(localObject2);
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strLargeThumPath))
      {
        ((ForwardFileInfo)localObject2).aA(((FileManagerEntity)localObject1).strLargeThumPath);
        label226:
        localObject1 = this.app.a().f(localWeiYunFileInfo.bIk);
        if (localObject1 != null) {
          break label357;
        }
        localObject1 = this.app.a().c(localWeiYunFileInfo.bIk);
      }
    }
    label357:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0))
      {
        paramArrayList1.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
        break;
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strMiddleThumPath))
        {
          ((ForwardFileInfo)localObject2).aA(((FileManagerEntity)localObject1).strMiddleThumPath);
          break label226;
        }
        ((ForwardFileInfo)localObject2).aA(((FileManagerEntity)localObject1).strThumbPath);
        break label226;
      }
      paramArrayList1.add(Uri.parse(""));
      break;
      return l;
    }
  }
  
  private void dmG()
  {
    ArrayList localArrayList = this.app.a().cZ();
    if (this.jdField_c_of_type_Ahbk != null) {
      this.jdField_c_of_type_Ahbk.dfL();
    }
    agmz.clearSelected();
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IP(false);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.ei(localArrayList);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.deN();
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.refreshUI();
    if (localArrayList.size() > 0) {
      ahao.JG(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131694101));
    }
  }
  
  private void dmI()
  {
    Object localObject4 = new Bundle();
    Object localObject2 = new Intent();
    Object localObject3 = new ArrayList();
    Object localObject5 = agmz.D();
    ArrayList localArrayList1 = agmz.db();
    ArrayList localArrayList2 = agmz.dd();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = new ArrayList();
    int j;
    int i;
    if (aobw.d(localArrayList1))
    {
      Iterator localIterator2 = localArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator2.next();
        if (localFileManagerEntity.nFileType == 13) {
          ((List)localObject1).add(localFileManagerEntity);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        j = 1;
        if (!aobw.d((Collection)localObject5)) {
          break label198;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i == 0) || (j == 0)) {
          break label272;
        }
        aqha.a(this.context, 230).setMessage(this.context.getString(2131693677)).setNegativeButton(2131720227, new ahdn(this)).show();
        return;
        j = 0;
        break;
        label198:
        if (aobw.d(localArrayList2)) {
          i = 1;
        } else if (localArrayList1.size() - ((List)localObject1).size() > 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    if (aobw.d((Collection)localObject5)) {
      i = 1;
    }
    for (;;)
    {
      j = 0;
      break;
      if (aobw.d(localArrayList2)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label272:
    if (i != 0) {
      if ((localObject5 == null) || (((Set)localObject5).size() <= 0)) {
        break label1064;
      }
    }
    label1064:
    for (long l1 = a((ArrayList)localObject3, localArrayList3) + 0L;; l1 = 0L)
    {
      long l2 = l1;
      if (localArrayList1 != null)
      {
        l2 = l1;
        if (localArrayList1.size() > 0) {
          l2 = l1 + b((ArrayList)localObject3, localArrayList3);
        }
      }
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        ((Intent)localObject2).putExtra("k_dataline", false);
      }
      for (l1 = l2 + c((ArrayList)localObject3, localArrayList3);; l1 = l2)
      {
        ((Bundle)localObject4).putInt("forward_type", 0);
        ((Bundle)localObject4).putParcelableArrayList("fileinfo_array", (ArrayList)localObject3);
        ((Bundle)localObject4).putBoolean("not_forward", true);
        ((Intent)localObject2).putExtra("sendMultiple", true);
        ((Bundle)localObject4).putParcelableArrayList("android.intent.extra.STREAM", localArrayList3);
        ((Intent)localObject2).putExtras((Bundle)localObject4);
        ((Intent)localObject2).putExtra("foward_editbar", true);
        ((Intent)localObject2).putExtra("forward_type", 0);
        localObject1 = acfp.m(2131711044);
        if (((ArrayList)localObject3).size() == 1) {
          localObject1 = acfp.m(2131711046) + ahav.kY(((ForwardFileInfo)((ArrayList)localObject3).get(0)).getFileName()) + acfp.m(2131711043) + ahbj.g(((ForwardFileInfo)((ArrayList)localObject3).get(0)).getFileSize()) + "。";
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("forward_text", (String)localObject1);
          ((Intent)localObject2).putExtra("k_favorites", false);
          ahgq.f(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject2, 103);
          return;
          if (((ArrayList)localObject3).size() > 1) {
            localObject1 = acfp.m(2131711047) + ahav.kY(((ForwardFileInfo)((ArrayList)localObject3).get(0)).getFileName()) + acfp.m(2131711048) + ((ArrayList)localObject3).size() + acfp.m(2131711049) + ahbj.g(l1) + "。";
          }
        }
        if (j == 0) {
          break;
        }
        anot.a(this.app, "dc00898", "", "", "0X800A082", "0X800A082", 0, 0, "", "", "", "");
        if ((localObject1 != null) && (((List)localObject1).size() == 1))
        {
          localObject1 = (FileManagerEntity)((List)localObject1).get(0);
          try
          {
            localObject3 = new JSONObject(new String(((FileManagerEntity)localObject1).bombData));
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("forward_type", -3);
            ((Bundle)localObject1).putInt("structmsg_service_id", ((JSONObject)localObject3).getInt("structmsg_service_id"));
            ((Bundle)localObject1).putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject3).getString("stuctmsg_bytes"), 0));
            ((Bundle)localObject1).putLong("structmsg_uniseq", ((JSONObject)localObject3).getLong("structmsg_uniseq"));
            ((Bundle)localObject1).putInt("accostType", ((JSONObject)localObject3).getInt("accostType"));
            ((Bundle)localObject1).putBoolean("forwardDirect", true);
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("forward_type", -3);
            ((Intent)localObject3).putExtras((Bundle)localObject1);
            ((Intent)localObject2).putExtra("forwardDirect", true);
            ahgq.f(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (Intent)localObject3, 103);
            return;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            return;
          }
        }
        localObject2 = new ArrayList(localJSONException1.size());
        Iterator localIterator1 = localJSONException1.iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (FileManagerEntity)localIterator1.next();
          try
          {
            localObject4 = new JSONObject(new String(((FileManagerEntity)localObject3).bombData));
            localObject5 = new MessageForStructing();
            ((MessageForStructing)localObject5).structingMsg = anre.a(Base64.decode(((JSONObject)localObject4).getString("stuctmsg_bytes"), 0));
            ((MessageForStructing)localObject5).senderuin = String.valueOf(((FileManagerEntity)localObject3).peerUin);
            ((MessageForStructing)localObject5).issend = 1;
            ((MessageForStructing)localObject5).msgtype = -2011;
            ((List)localObject2).add(localObject5);
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
        }
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a().gG((List)localObject2);
        return;
      }
    }
  }
  
  private void initUI()
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.context);
    this.app = ((QQAppInterface)this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.vm = ((ImageView)findViewById(2131366196));
    this.fg = ((ImageView)findViewById(2131366195));
    this.zP = ((ImageView)findViewById(2131366203));
    this.lW = ((ImageView)findViewById(2131366197));
    this.vq = ((ImageView)findViewById(2131366194));
    this.vm.setOnClickListener(this);
    this.fg.setOnClickListener(this);
    this.zP.setOnClickListener(this);
    this.lW.setOnClickListener(this);
    this.vq.setOnClickListener(this);
  }
  
  @TargetApi(19)
  protected void aH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131381443));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
  }
  
  public void cg()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
    }
  }
  
  public void dmH()
  {
    Object localObject = agmz.db().iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((FileManagerEntity)((Iterator)localObject).next()).fileSize <= 104857600L);
    for (int i = 1;; i = 0)
    {
      localObject = agmz.D().iterator();
      do
      {
        m = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((FileInfo)((Iterator)localObject).next()).getSize() <= 104857600L);
      int m = 1;
      localObject = agmz.db().iterator();
      int n = 0;
      int k = 0;
      int j = 0;
      i = 0;
      FileManagerEntity localFileManagerEntity;
      while (((Iterator)localObject).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if (localFileManagerEntity.sendCloudUnsuccessful())
        {
          n += 1;
        }
        else
        {
          if ((localFileManagerEntity.getCloudType() != 3) && (localFileManagerEntity.getCloudType() != 5)) {
            break label440;
          }
          if (j == 0) {
            break label419;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i + "] WeiYun [" + ahav.d(localFileManagerEntity) + "]");
          }
        }
      }
      label216:
      label227:
      label238:
      label249:
      boolean bool;
      label262:
      label275:
      label295:
      label315:
      label334:
      int i1;
      if (agmz.fN() == i)
      {
        i = 1;
        if (agmz.fN() != j) {
          break label625;
        }
        j = 1;
        if (agmz.fN() != k) {
          break label630;
        }
        k = 1;
        if (agmz.fN() != n) {
          break label635;
        }
        n = 1;
        localObject = this.fg;
        if (i != 0) {
          break label641;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.zP;
        if (j != 0) {
          break label647;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.lW;
        if (k != 0) {
          break label653;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        if ((j != 0) || (m != 0)) {
          break label659;
        }
        bool = true;
        this.vm.setEnabled(bool);
        if (n != 0)
        {
          this.fg.setEnabled(false);
          this.zP.setEnabled(false);
          this.lW.setEnabled(false);
          this.vm.setEnabled(false);
        }
        if (agmz.fN() <= 0L) {
          break label665;
        }
        this.vq.setEnabled(true);
        label396:
        if (agmz.alM())
        {
          this.fg.setEnabled(false);
          this.zP.setEnabled(false);
        }
        return;
        label419:
        i1 = k;
        k = i + 1;
        i = i1;
      }
      for (;;)
      {
        i1 = k;
        k = i;
        i = i1;
        break;
        label440:
        if (localFileManagerEntity.getCloudType() == 2)
        {
          if (i != 0)
          {
            if (!QLog.isDevelopLevel()) {
              break label216;
            }
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + ahav.d(localFileManagerEntity) + "]");
            break label216;
          }
          j += 1;
          i1 = i;
          i = k;
          k = i1;
          continue;
        }
        if ((localFileManagerEntity.getCloudType() == 6) && (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
        {
          if ((i != 0) || (j != 0))
          {
            if (!QLog.isDevelopLevel()) {
              break label216;
            }
            QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + ahav.d(localFileManagerEntity) + "]");
            break label216;
          }
          i1 = k + 1;
          k = i;
          i = i1;
          continue;
          i = 0;
          break label227;
          label625:
          j = 0;
          break label238;
          label630:
          k = 0;
          break label249;
          label635:
          n = 0;
          break label262;
          label641:
          bool = false;
          break label275;
          label647:
          bool = false;
          break label295;
          label653:
          bool = false;
          break label315;
          label659:
          bool = false;
          break label334;
          label665:
          this.vq.setEnabled(false);
          break label396;
        }
        i1 = i;
        i = k;
        k = i1;
      }
    }
  }
  
  void gO(View paramView)
  {
    new ArrayList();
    int i = 0;
    if (this.bms == 1) {
      i = 1;
    }
    paramView = (ausj)auss.a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.addButton(2131693803, 3);
    if (this.bms != 3)
    {
      if (i == 0) {
        break label87;
      }
      paramView.setMainTitle(acfp.m(2131711045));
    }
    for (;;)
    {
      paramView.addCancelButton(2131721058);
      paramView.a(new ahdh(this, paramView));
      paramView.show();
      return;
      label87:
      paramView.setMainTitle(acfp.m(2131711050));
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    int i;
    label112:
    FileManagerEntity localFileManagerEntity;
    switch (paramView.getId())
    {
    case 2131366198: 
    case 2131366199: 
    case 2131366200: 
    case 2131366201: 
    case 2131366202: 
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131366196: 
      if (this.jdField_a_of_type_Agys == null) {
        this.jdField_a_of_type_Agys = new agys(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      }
      localObject2 = agmz.db();
      localObject1 = agmz.D();
      localObject2 = ((ArrayList)localObject2).iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
        if (localFileManagerEntity.nFileType == 13)
        {
          String str = this.app.getCurrentUin();
          if (!aviz.a(localFileManagerEntity.Uuid).c(str).b(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, str)) {
            i = 1;
          }
        }
      }
      break;
    }
    for (;;)
    {
      break label112;
      if (!aviz.a().a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileManagerEntity, null, true))
      {
        i = 1;
        continue;
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((FileInfo)((Iterator)localObject1).next()).getPath();
          if ((ahbj.fileExistsAndNotEmpty((String)localObject2)) && (!aviz.a().b(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (String)localObject2))) {
            i = 1;
          }
        }
        if (i != 0) {
          ahav.JI(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131700298));
        }
        for (;;)
        {
          agmz.clearSelected();
          this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IP(false);
          this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.refreshUI();
          break;
          ahao.JE(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131720628));
        }
        if (QLog.isColorLevel()) {
          QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + agmz.dd().size() + "], offline[" + agmz.dc().size() + "], recent[" + agmz.db().size() + "], localfile[" + agmz.D().size() + "]");
        }
        if (!aqiw.isNetSupport(this.context))
        {
          ahav.JI(this.context.getString(2131694663));
          break;
        }
        if (agmz.fQ() > agmx.fJ())
        {
          ahav.b(false, this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new ahdi(this));
          break;
        }
        this.app.a().el(this.context);
        if (this.jdField_c_of_type_Ahbk != null) {
          this.jdField_c_of_type_Ahbk.dfK();
        }
        agmz.clearSelected();
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.deN();
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IP(false);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.refreshUI();
        break;
        if (!aqiw.isNetSupport(this.context))
        {
          ahav.JI(this.context.getString(2131694663));
          break;
        }
        if (ahav.a(false, agmz.db()))
        {
          if (!armm.a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new ahdj(this))) {
            break;
          }
          ahal.a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131693826, 2131693830, new ahdk(this));
          break;
        }
        if ((agmz.fO() > agmx.fJ()) && (ahav.amK()))
        {
          if (!armm.a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 5, new ahdl(this))) {
            break;
          }
          ahal.a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131693826, 2131693830, new ahdm(this));
          break;
        }
        dmG();
        break;
        if (!aqiw.isNetSupport(this.context))
        {
          ahav.JI(this.context.getString(2131694663));
          break;
        }
        dmI();
        if (this.jdField_c_of_type_Ahbk != null) {
          this.jdField_c_of_type_Ahbk.dfM();
        }
        agmz.clearSelected();
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.deN();
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.IP(false);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.refreshUI();
        break;
        gO(paramView);
        if (this.jdField_c_of_type_Ahbk == null) {
          break;
        }
        this.jdField_c_of_type_Ahbk.dfN();
        break;
      }
    }
  }
  
  public void setClickListener(ahbk paramahbk)
  {
    this.jdField_c_of_type_Ahbk = paramahbk;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int j = 0;
    ImageView localImageView = this.vm;
    if (paramBoolean3)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = this.fg;
      if (!paramBoolean1) {
        break label117;
      }
      i = 0;
      label36:
      localImageView.setVisibility(i);
      localImageView = this.zP;
      if (!paramBoolean2) {
        break label124;
      }
      i = 0;
      label56:
      localImageView.setVisibility(i);
      localImageView = this.lW;
      if (!paramBoolean3) {
        break label131;
      }
      i = 0;
      label76:
      localImageView.setVisibility(i);
      localImageView = this.vq;
      if (!paramBoolean4) {
        break label138;
      }
    }
    label131:
    label138:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      aH();
      return;
      i = 8;
      break;
      label117:
      i = 8;
      break label36;
      label124:
      i = 8;
      break label56;
      i = 8;
      break label76;
    }
  }
  
  public void setTabType(int paramInt)
  {
    this.bms = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */