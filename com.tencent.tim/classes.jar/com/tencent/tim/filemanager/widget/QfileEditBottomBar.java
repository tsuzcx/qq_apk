package com.tencent.tim.filemanager.widget;

import ahal;
import ahgq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aqiw;
import atso;
import attf;
import attk;
import atvz;
import atwb;
import auds;
import audx;
import aueh;
import auei;
import aufc;
import aufd;
import aufe;
import auff;
import ausj;
import auss;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  ImageView Hc;
  View KM;
  final String TAG = "QfileEditBottomBar";
  private QQAppInterface app;
  int bms = -1;
  public auei c;
  private BaseFileAssistantActivity c;
  SparseArray<Integer> cC = new SparseArray();
  private Context context;
  ImageView fg;
  ImageView lW;
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
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131563196, this, true);
    this.context = paramContext;
    initUI();
  }
  
  private void dmG()
  {
    ArrayList localArrayList = this.app.a().cZ();
    if (this.jdField_c_of_type_Auei != null) {
      this.jdField_c_of_type_Auei.dfL();
    }
    atwb.clearSelected();
    this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.IP(false);
    this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.ei(localArrayList);
    this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.deN();
    this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.refreshUI();
    FileManagerEntity localFileManagerEntity;
    if (localArrayList.size() > 0)
    {
      localFileManagerEntity = (FileManagerEntity)localArrayList.get(0);
      if (localArrayList.size() > 1) {
        auds.JG(audx.kY(localFileManagerEntity.fileName) + "等" + localArrayList.size() + "个文件" + this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getString(2131694101));
      }
    }
    else
    {
      return;
    }
    auds.JG(audx.kY(localFileManagerEntity.fileName) + this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getString(2131694101));
  }
  
  private void dmI()
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    long l2 = 0L;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = atwb.ep();
    Object localObject2 = atwb.db();
    Object localObject1 = atwb.dd();
    ArrayList localArrayList2 = new ArrayList();
    long l1 = l2;
    Object localObject4;
    if (localObject3 != null)
    {
      l1 = l2;
      if (((List)localObject3).size() > 0)
      {
        localObject3 = ((List)localObject3).iterator();
        for (l1 = 0L; ((Iterator)localObject3).hasNext(); l1 = l2 + l1)
        {
          localObject4 = (FileInfo)((Iterator)localObject3).next();
          FileManagerEntity localFileManagerEntity = audx.a((FileInfo)localObject4);
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
          localArrayList2.add(Uri.parse(((FileInfo)localObject4).getPath()));
          l2 = localForwardFileInfo.getFileSize();
          localArrayList1.add(localForwardFileInfo);
        }
      }
    }
    l2 = l1;
    if (localObject2 != null)
    {
      l2 = l1;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          if (!((FileManagerEntity)localObject3).sendCloudUnsuccessful())
          {
            localObject4 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject4).setType(10001);
            ((ForwardFileInfo)localObject4).Oj(((FileManagerEntity)localObject3).getCloudType());
            ((ForwardFileInfo)localObject4).p(((FileManagerEntity)localObject3).nSessionId);
            ((ForwardFileInfo)localObject4).setFileName(((FileManagerEntity)localObject3).fileName);
            ((ForwardFileInfo)localObject4).jB(((FileManagerEntity)localObject3).uniseq);
            ((ForwardFileInfo)localObject4).setFileId(((FileManagerEntity)localObject3).WeiYunFileId);
            ((ForwardFileInfo)localObject4).setFileSize(((FileManagerEntity)localObject3).fileSize);
            ((ForwardFileInfo)localObject4).setLocalPath(((FileManagerEntity)localObject3).getFilePath());
            ((ForwardFileInfo)localObject4).setUuid(((FileManagerEntity)localObject3).Uuid);
            if ((((FileManagerEntity)localObject3).getCloudType() == 3) && (((FileManagerEntity)localObject3).getFilePath() != null) && (((FileManagerEntity)localObject3).getFilePath().length() > 0)) {
              localArrayList2.add(Uri.parse(((FileManagerEntity)localObject3).getFilePath()));
            }
            for (;;)
            {
              l2 = ((ForwardFileInfo)localObject4).getFileSize();
              localArrayList1.add(localObject4);
              l1 = l2 + l1;
              break;
              localArrayList2.add(Uri.parse(""));
            }
          }
        }
        l2 = l1;
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localIntent.putExtra("k_dataline", false);
      localObject2 = ((List)localObject1).iterator();
      l1 = l2;
      l2 = l1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeiYunFileInfo)((Iterator)localObject2).next();
        localObject1 = audx.b((WeiYunFileInfo)localObject3);
        localObject4 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject4).setType(10003);
        ((ForwardFileInfo)localObject4).Oj(((FileManagerEntity)localObject1).getCloudType());
        ((ForwardFileInfo)localObject4).p(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject4).setFileName(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject4).jB(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject4).setFileId(((FileManagerEntity)localObject1).WeiYunFileId);
        ((ForwardFileInfo)localObject4).setFileSize(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject4).setLocalPath(((FileManagerEntity)localObject1).getFilePath());
        ((ForwardFileInfo)localObject4).setUuid(((FileManagerEntity)localObject1).Uuid);
        l1 += ((ForwardFileInfo)localObject4).getFileSize();
        localArrayList1.add(localObject4);
        localObject1 = this.app.a().f(((WeiYunFileInfo)localObject3).bIk);
        if (localObject1 != null) {
          break label1023;
        }
        localObject1 = this.app.a().c(((WeiYunFileInfo)localObject3).bIk);
      }
    }
    label1023:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).getFilePath() != null) && (((FileManagerEntity)localObject1).getFilePath().length() > 0))
      {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject1).getFilePath()));
        break;
      }
      localArrayList2.add(Uri.parse(""));
      break;
      localBundle.putInt("forward_type", 0);
      localBundle.putParcelableArrayList("fileinfo_array", localArrayList1);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtra("sendMultiple", true);
      localBundle.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("foward_editbar", true);
      localIntent.putExtra("forward_type", 0);
      localObject1 = "转发文件";
      if (localArrayList1.size() == 1) {
        localObject1 = "已选择" + audx.kY(((ForwardFileInfo)localArrayList1.get(0)).getFileName()) + "，大小" + aueh.g(((ForwardFileInfo)localArrayList1.get(0)).getFileSize()) + "。";
      }
      for (;;)
      {
        localIntent.putExtra("forward_text", (String)localObject1);
        localIntent.putExtra("k_favorites", false);
        ahgq.f(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity, localIntent, 103);
        return;
        if (localArrayList1.size() > 1) {
          localObject1 = "已选择" + audx.kY(((ForwardFileInfo)localArrayList1.get(0)).getFileName()) + "等" + localArrayList1.size() + "个文件，大小" + aueh.g(l2) + "。";
        }
      }
    }
  }
  
  private void initUI()
  {
    this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)this.context);
    this.app = ((QQAppInterface)this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
    this.KM = findViewById(2131366191);
    this.Hc = ((ImageView)findViewById(2131366200));
    this.zP = ((ImageView)findViewById(2131366203));
    this.fg = ((ImageView)findViewById(2131366195));
    this.lW = ((ImageView)findViewById(2131366197));
    this.vq = ((ImageView)findViewById(2131366194));
    this.Hc.setOnClickListener(this);
    this.zP.setOnClickListener(this);
    this.fg.setOnClickListener(this);
    this.lW.setOnClickListener(this);
    this.vq.setOnClickListener(this);
  }
  
  public void dmH()
  {
    long l = atwb.fN();
    Object localObject = this.Hc;
    if (l > 0L) {}
    int m;
    int k;
    int j;
    int i;
    FileManagerEntity localFileManagerEntity;
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localObject).setEnabled(bool);
      localObject = atwb.db().iterator();
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label164;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          break;
        }
        m += 1;
      }
    }
    label164:
    label175:
    label186:
    label197:
    label210:
    label223:
    label243:
    int n;
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5))
    {
      if (j != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + i + "] WeiYun [" + audx.d(localFileManagerEntity) + "]");
        }
        if (atwb.fN() != i) {
          break label517;
        }
        i = 1;
        if (atwb.fN() != j) {
          break label522;
        }
        j = 1;
        if (atwb.fN() != k) {
          break label527;
        }
        k = 1;
        if (atwb.fN() != m) {
          break label532;
        }
        m = 1;
        localObject = this.fg;
        if (i != 0) {
          break label538;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.zP;
        if (j != 0) {
          break label544;
        }
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
        localObject = this.lW;
        if (k != 0) {
          break label550;
        }
        bool = true;
        label263:
        ((ImageView)localObject).setEnabled(bool);
        if (m != 0)
        {
          this.fg.setEnabled(false);
          this.zP.setEnabled(false);
          this.lW.setEnabled(false);
        }
        if (atwb.fN() <= 0L) {
          break label556;
        }
        this.vq.setEnabled(true);
        return;
      }
      n = k;
      k = i + 1;
      i = n;
    }
    for (;;)
    {
      n = k;
      k = i;
      i = n;
      break;
      if (localFileManagerEntity.getCloudType() == 2)
      {
        if (i != 0)
        {
          if (!QLog.isDevelopLevel()) {
            break label164;
          }
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + audx.d(localFileManagerEntity) + "]");
          break label164;
        }
        j += 1;
        n = i;
        i = k;
        k = n;
        continue;
      }
      if ((localFileManagerEntity.getCloudType() == 6) && (!aueh.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
      {
        if ((i != 0) || (j != 0))
        {
          if (!QLog.isDevelopLevel()) {
            break label164;
          }
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + audx.d(localFileManagerEntity) + "]");
          break label164;
        }
        n = k + 1;
        k = i;
        i = n;
        continue;
        label517:
        i = 0;
        break label175;
        label522:
        j = 0;
        break label186;
        label527:
        k = 0;
        break label197;
        label532:
        m = 0;
        break label210;
        label538:
        bool = false;
        break label223;
        label544:
        bool = false;
        break label243;
        label550:
        bool = false;
        break label263;
        label556:
        this.vq.setEnabled(false);
        return;
      }
      n = i;
      i = k;
      k = n;
    }
  }
  
  void gO(View paramView)
  {
    int i = 0;
    if (this.bms == 1) {
      i = 1;
    }
    paramView = (ausj)auss.a(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity, null);
    paramView.addButton(2131693803, 3);
    if (this.bms != 3)
    {
      if (i == 0) {
        break label86;
      }
      paramView.setMainTitle(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getResources().getString(2131693812));
    }
    for (;;)
    {
      paramView.addCancelButton(2131721058);
      paramView.a(new aufc(this, paramView));
      paramView.show();
      return;
      label86:
      paramView.setMainTitle(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getResources().getString(2131693811));
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      audx.a(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity);
      if (this.jdField_c_of_type_Auei != null)
      {
        this.jdField_c_of_type_Auei.eut();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + atwb.dd().size() + "], offline[" + atwb.dc().size() + "], recent[" + atwb.db().size() + "], localfile[" + atwb.ep().size() + "]");
        }
        if (!aqiw.isNetSupport(this.context))
        {
          audx.JI(this.context.getString(2131694663));
        }
        else if ((atwb.fQ() > atvz.fJ()) && (audx.amK()))
        {
          ahal.a(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity, 2131693826, 2131693828, new aufd(this));
        }
        else
        {
          this.app.a().euw();
          if (this.jdField_c_of_type_Auei != null) {
            this.jdField_c_of_type_Auei.dfK();
          }
          atwb.clearSelected();
          this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.deN();
          this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.IP(false);
          this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.refreshUI();
          continue;
          if (!aqiw.isNetSupport(this.context))
          {
            audx.JI(this.context.getString(2131694663));
          }
          else if (audx.a(false, atwb.db()))
          {
            ahal.a(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity, 2131693826, 2131693830, new aufe(this));
          }
          else if ((atwb.fO() > atvz.fJ()) && (audx.amK()))
          {
            ahal.a(this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity, 2131693826, 2131693830, new auff(this));
          }
          else
          {
            dmG();
            continue;
            if (!aqiw.isNetSupport(this.context))
            {
              audx.JI(this.context.getString(2131694663));
            }
            else
            {
              dmI();
              if (this.jdField_c_of_type_Auei != null) {
                this.jdField_c_of_type_Auei.dfM();
              }
              atwb.clearSelected();
              this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.deN();
              this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.IP(false);
              this.jdField_c_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.refreshUI();
              continue;
              gO(paramView);
              if (this.jdField_c_of_type_Auei != null) {
                this.jdField_c_of_type_Auei.dfN();
              }
            }
          }
        }
      }
    }
  }
  
  public void setClickListener(auei paramauei)
  {
    this.jdField_c_of_type_Auei = paramauei;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    int j = 0;
    ImageView localImageView = this.Hc;
    if (paramBoolean1)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = this.zP;
      if (!paramBoolean3) {
        break label114;
      }
      i = 0;
      label36:
      localImageView.setVisibility(i);
      localImageView = this.fg;
      if (!paramBoolean2) {
        break label121;
      }
      i = 0;
      label56:
      localImageView.setVisibility(i);
      localImageView = this.lW;
      if (!paramBoolean4) {
        break label128;
      }
      i = 0;
      label77:
      localImageView.setVisibility(i);
      localImageView = this.vq;
      if (!paramBoolean5) {
        break label135;
      }
    }
    label128:
    label135:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
      i = 8;
      break;
      label114:
      i = 8;
      break label36;
      label121:
      i = 8;
      break label56;
      i = 8;
      break label77;
    }
  }
  
  public void setTabType(int paramInt)
  {
    this.bms = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */