package com.tencent.tim.filemanager.widget;

import aasq;
import ahal;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apsd;
import apsv;
import aqha;
import aqju;
import arhz;
import atgi;
import atqs;
import atvz;
import atwb;
import audx;
import aueh;
import auei;
import aufj;
import aufk;
import aufm;
import aufn;
import aufo;
import aufq;
import auft;
import aukp;
import avhc;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.FMLocalFileActivity;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SendBottomBar
  extends RelativeLayout
{
  private TextView SB;
  private TextView Tj;
  private TextView Tk;
  private TextView Tl;
  private QQAppInterface app;
  private atqs b;
  private BaseFileAssistantActivity c;
  private boolean cgq;
  public Context context;
  private auei d;
  private View.OnClickListener fc = new aufk(this);
  private View.OnClickListener fe = new aufj(this);
  private View.OnClickListener fg = new aufq(this);
  public aqju m = null;
  private CheckBox mCheckBox;
  public arhz z;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    ge(paramContext);
    initUI();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ge(paramContext);
    initUI();
  }
  
  private void Kl(boolean paramBoolean)
  {
    int i = apsv.aH(this.context);
    if (i == 0)
    {
      apsd.ck(this.context, this.context.getString(2131699827));
      dmE();
      return;
    }
    if ((1 == i) && (atwb.fO() > 3145728L))
    {
      aufm localaufm = new aufm(this);
      aqha.a(this.context, 230, this.context.getString(2131699824), this.context.getString(2131699611), 2131721058, 2131700020, localaufm, localaufm).show();
      return;
    }
    dmE();
  }
  
  private void bfC()
  {
    this.c.setResult(-1, null);
    this.c.finish();
  }
  
  public static aasq c(String paramString)
  {
    if (paramString == null) {}
    while (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramString)), null, localOptions);
      label54:
      return new aasq(localOptions.outWidth, localOptions.outHeight);
    }
    catch (Exception paramString)
    {
      break label54;
    }
  }
  
  private void dkp()
  {
    boolean bool = false;
    Object localObject2 = this.c.uV();
    ArrayList localArrayList = atwb.ep();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((ArrayList)localObject1).add(((com.tencent.mobileqq.filemanager.data.FileInfo)localArrayList.get(i)).getPath());
      i += 1;
    }
    atwb.clearSelected();
    i = this.c.DZ();
    if (222 == i)
    {
      this.c.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
      this.c.setResult(-1, this.c.getIntent());
    }
    for (;;)
    {
      this.c.finish();
      return;
      if ((333 == i) || (666 == i))
      {
        this.c.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
        this.c.setResult(i, this.c.getIntent());
      }
      else if ((444 == i) || (555 == i))
      {
        localObject2 = this.c.getIntent();
        if (444 == i) {
          bool = true;
        }
        ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
        ((Intent)localObject2).putExtra("string_filepaths", (Serializable)localObject1);
        this.c.setResult(i, this.c.getIntent());
      }
      else if ((777 == i) || (888 == i))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("string_filepaths", (ArrayList)localObject1);
        this.app.a();
        avhc.c(this.c, 16, (Bundle)localObject2);
      }
      else
      {
        this.app.a().g((String)localObject2, (List)localObject1);
        localObject1 = this.c.getIntent();
        ((Intent)localObject1).putExtra("_UIN_", (String)localObject2);
        ((Intent)localObject1).putExtra("_SEND_QLINK_FILE_", true);
        this.c.setResult(-1, this.c.getIntent());
      }
    }
  }
  
  private void dmK()
  {
    am(2131696921);
    new Handler().postDelayed(new SendBottomBar.9(this), 100L);
  }
  
  private void dmQ()
  {
    int i = this.c.DZ();
    boolean bool = this.c.akJ();
    if ((1 == i) && (!bool))
    {
      ahal.a(this.c, 2131700519, 2131700518, new aufn(this));
      return;
    }
    dkp();
  }
  
  private void euM()
  {
    Object localObject3 = atwb.ep();
    Object localObject2 = atwb.db();
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    String str;
    if ((this.context != null) && ((this.context instanceof FMActivity)))
    {
      localObject1 = (FMActivity)this.context;
      str = ((FMActivity)this.context).bGn;
    }
    for (;;)
    {
      com.tencent.cloudfile.FileInfo localFileInfo = new com.tencent.cloudfile.FileInfo();
      int i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ArrayList)localObject3).size() > 0)
        {
          localObject3 = ((ArrayList)localObject3).iterator();
          i = 0;
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (com.tencent.mobileqq.filemanager.data.FileInfo)((Iterator)localObject3).next();
              localFileInfo.localPath = ((com.tencent.mobileqq.filemanager.data.FileInfo)localObject4).getPath();
              localFileInfo.fileName = ((com.tencent.mobileqq.filemanager.data.FileInfo)localObject4).getName();
              localFileInfo.fileSize = ((com.tencent.mobileqq.filemanager.data.FileInfo)localObject4).getSize();
              localObject4 = c(((com.tencent.mobileqq.filemanager.data.FileInfo)localObject4).getPath());
              if ((((aasq)localObject4).getWidth() > 0) && (((aasq)localObject4).getHeight() > 0))
              {
                localFileInfo.width = ((aasq)localObject4).getWidth();
                localFileInfo.height = ((aasq)localObject4).getHeight();
              }
              i = 1;
              localArrayList.add(Long.valueOf(atgi.a().a("", str.getBytes(), localFileInfo).uploadFile.taskId));
              continue;
              if ((this.context != null) && ((this.context instanceof FMLocalFileActivity)))
              {
                localObject1 = (FMLocalFileActivity)this.context;
                str = ((FMLocalFileActivity)this.context).bGn;
                break;
              }
              if ((this.context == null) || (!(this.context instanceof LocalFileBrowserActivity))) {
                break label477;
              }
              localObject1 = (LocalFileBrowserActivity)this.context;
              str = ((LocalFileBrowserActivity)this.context).bGn;
              break;
            }
          }
        }
      }
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (i == 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          localFileInfo.localPath = ((FileManagerEntity)localObject3).strFilePath;
          localFileInfo.fileName = ((FileManagerEntity)localObject3).fileName;
          localFileInfo.fileSize = ((FileManagerEntity)localObject3).fileSize;
          if ((((FileManagerEntity)localObject3).imgHeight > 0) && (((FileManagerEntity)localObject3).imgWidth > 0))
          {
            localFileInfo.width = ((FileManagerEntity)localObject3).imgWidth;
            localFileInfo.height = ((FileManagerEntity)localObject3).imgHeight;
          }
          localArrayList.add(Long.valueOf(atgi.a().a("", str.getBytes(), localFileInfo).uploadFile.taskId));
        }
      }
      atgi.a().startUploadFile(localArrayList);
      if (localObject1 != null) {
        ((Activity)localObject1).finish();
      }
      atwb.clearSelected();
      return;
      label477:
      localObject1 = null;
      str = "";
    }
  }
  
  public void VJ(boolean paramBoolean)
  {
    int i = 1;
    int j = this.c.DW();
    if (j == 1) {}
    while (j == 5)
    {
      dmE();
      return;
      i = 0;
    }
    if (i != 0)
    {
      Kl(paramBoolean);
      return;
    }
    euL();
  }
  
  void am(int paramInt)
  {
    if (this.z != null) {
      btB();
    }
    for (;;)
    {
      if (!this.z.isShowing()) {
        this.z.show();
      }
      return;
      this.z = new arhz(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299627));
      this.z.setCancelable(false);
      this.z.setMessage("请稍候...");
      this.z.show();
    }
  }
  
  public void btB()
  {
    try
    {
      if ((this.z != null) && (this.z.isShowing())) {
        this.z.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void dmE()
  {
    am(2131696937);
    new Handler().postDelayed(new SendBottomBar.6(this), 100L);
  }
  
  public void dmH()
  {
    boolean bool2 = true;
    int i = this.c.DW();
    String str = this.c.uX();
    long l1 = atwb.fN();
    long l2 = atwb.fP();
    Object localObject = str;
    if (str == null)
    {
      if (this.c.DX() == 9) {
        localObject = this.context.getResources().getString(2131719431) + "(" + l1 + ")";
      }
    }
    else
    {
      str = this.context.getString(2131693579) + aueh.g(l2);
      if (this.mCheckBox.getVisibility() != 0) {
        break label454;
      }
      l1 = atwb.fN();
      this.SB.setEnabled(true);
      this.Tl.setVisibility(0);
      if (l1 <= 99L) {
        break label387;
      }
      localObject = "删除(99+)";
    }
    for (;;)
    {
      this.SB.setText((CharSequence)localObject);
      this.Tl.setText(str);
      return;
      if (i == 5)
      {
        localObject = this.context.getResources().getString(2131700007) + this.context.getString(2131693788) + l1 + this.context.getString(2131693789);
        break;
      }
      if (i == 6001)
      {
        localObject = this.context.getResources().getString(2131693511) + this.context.getString(2131693788) + l1 + this.context.getString(2131693789);
        break;
      }
      localObject = this.context.getString(2131693581) + this.context.getString(2131693788) + l1 + this.context.getString(2131693789);
      break;
      label387:
      if (l1 == 0L)
      {
        localObject = "删除";
        this.Tl.setVisibility(8);
        this.SB.setEnabled(false);
      }
      else
      {
        localObject = "删除(" + String.valueOf(l1) + ")";
      }
    }
    label454:
    boolean bool1;
    switch (this.c.DX())
    {
    default: 
      i = this.Tj.getVisibility();
      if ((i == 4) || (i == 8))
      {
        this.Tl.setVisibility(0);
        this.Tk.setVisibility(8);
        this.Tl.setText(str);
        if (audx.c() == null) {
          break label699;
        }
        bool1 = true;
        label533:
        this.SB.setText((CharSequence)localObject);
        if (1 == this.c.DX()) {
          this.SB.setText("确定");
        }
        localObject = this.SB;
        if (l1 <= 0L) {
          break label704;
        }
      }
      break;
    }
    for (;;)
    {
      ((TextView)localObject).setEnabled(bool2);
      this.Tj.setEnabled(bool1);
      return;
      i = this.Tj.getVisibility();
      if ((i == 4) || (i == 8))
      {
        this.Tl.setVisibility(0);
        this.Tk.setVisibility(8);
        this.Tl.setText(2131700498);
        break;
      }
      this.Tk.setVisibility(0);
      this.Tl.setVisibility(8);
      this.Tk.setText(2131700498);
      break;
      this.Tk.setVisibility(0);
      this.Tl.setVisibility(8);
      this.Tk.setText(str);
      break;
      label699:
      bool1 = false;
      break label533;
      label704:
      bool2 = false;
    }
  }
  
  public void dmR()
  {
    Object localObject1 = null;
    ArrayList localArrayList = atwb.ep();
    Object localObject2 = atwb.db();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      if (localArrayList.iterator().hasNext())
      {
        localObject1 = (com.tencent.mobileqq.filemanager.data.FileInfo)localArrayList.iterator().next();
        localTeamWorkFileImportInfo.filePath = ((com.tencent.mobileqq.filemanager.data.FileInfo)localObject1).getPath();
        localTeamWorkFileImportInfo.fileName = ((com.tencent.mobileqq.filemanager.data.FileInfo)localObject1).getName();
        localTeamWorkFileImportInfo.nFileType = audx.fM(((com.tencent.mobileqq.filemanager.data.FileInfo)localObject1).getName());
        localTeamWorkFileImportInfo.dNQ = 5;
        localTeamWorkFileImportInfo.fileSize = ((com.tencent.mobileqq.filemanager.data.FileInfo)localObject1).getSize();
        if ((this.context == null) || (!(this.context instanceof FMActivity))) {
          break label318;
        }
        localObject1 = (FMActivity)this.context;
        localTeamWorkFileImportInfo.folderId = ((FMActivity)this.context).bGn;
      }
    }
    label139:
    for (int i = 1;; i = 0)
    {
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (i == 0))
      {
        localObject2 = (FileManagerEntity)((ArrayList)localObject2).get(0);
        localTeamWorkFileImportInfo.filePath = ((FileManagerEntity)localObject2).strFilePath;
        localTeamWorkFileImportInfo.fileName = ((FileManagerEntity)localObject2).fileName;
        localTeamWorkFileImportInfo.nFileType = ((FileManagerEntity)localObject2).nFileType;
        localTeamWorkFileImportInfo.fileSize = ((FileManagerEntity)localObject2).fileSize;
        localTeamWorkFileImportInfo.dNQ = 5;
        localTeamWorkFileImportInfo.peerUin = ((FileManagerEntity)localObject2).peerUin;
        localTeamWorkFileImportInfo.msgUniseq = ((FileManagerEntity)localObject2).uniseq;
        localTeamWorkFileImportInfo.peerType = ((FileManagerEntity)localObject2).peerType;
        localTeamWorkFileImportInfo.nSessionId = ((FileManagerEntity)localObject2).nSessionId;
        localTeamWorkFileImportInfo.cKX = true;
        if ((this.context != null) && ((this.context instanceof FMActivity)))
        {
          localObject1 = (FMActivity)this.context;
          localTeamWorkFileImportInfo.folderId = ((FMActivity)this.context).bGn;
        }
      }
      for (;;)
      {
        aukp.a(localTeamWorkFileImportInfo, this.context, this.app, 0);
        if (localObject1 != null) {
          ((Activity)localObject1).finish();
        }
        return;
        localObject1 = null;
        break;
        label318:
        if ((this.context != null) && ((this.context instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.context;
          localTeamWorkFileImportInfo.folderId = ((FMLocalFileActivity)this.context).bGn;
          break label139;
        }
        if ((this.context == null) || (!(this.context instanceof LocalFileBrowserActivity))) {
          break label489;
        }
        localObject1 = (LocalFileBrowserActivity)this.context;
        localTeamWorkFileImportInfo.folderId = ((LocalFileBrowserActivity)this.context).bGn;
        break label139;
        if ((this.context != null) && ((this.context instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.context;
          localTeamWorkFileImportInfo.folderId = ((FMLocalFileActivity)this.context).bGn;
        }
        else if ((this.context != null) && ((this.context instanceof LocalFileBrowserActivity)))
        {
          localObject1 = (LocalFileBrowserActivity)this.context;
          localTeamWorkFileImportInfo.folderId = ((LocalFileBrowserActivity)this.context).bGn;
        }
      }
      label489:
      localObject1 = null;
      break label139;
    }
  }
  
  public void euL()
  {
    if ((audx.amK()) && (atwb.fO() > atvz.fJ()))
    {
      ahal.a(this.context, 2131693826, 2131693832, new aufo(this));
      return;
    }
    dmE();
  }
  
  protected void ge(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561027, this, true);
    this.context = paramContext;
  }
  
  protected void initUI()
  {
    this.c = ((BaseFileAssistantActivity)this.context);
    this.Tk = ((TextView)findViewById(2131373569));
    this.Tl = ((TextView)findViewById(2131372449));
    this.SB = ((TextView)findViewById(2131377979));
    this.SB.setOnClickListener(this.fc);
    this.mCheckBox = ((CheckBox)findViewById(2131364571));
    this.Tj = ((TextView)findViewById(2131373566));
    this.Tj.setOnClickListener(this.fe);
    if (1 == this.c.DX()) {
      this.SB.setText(this.context.getResources().getString(2131691970));
    }
    for (;;)
    {
      this.app = ((QQAppInterface)this.c.getAppRuntime());
      return;
      if (9 == this.c.DX()) {
        this.SB.setText(this.context.getResources().getString(2131719431));
      }
    }
  }
  
  public void setCheckAll(boolean paramBoolean)
  {
    if (this.mCheckBox != null)
    {
      this.mCheckBox.setChecked(paramBoolean);
      if (paramBoolean) {
        this.mCheckBox.setText("取消选择");
      }
    }
    else
    {
      return;
    }
    this.mCheckBox.setText("批量选择");
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    if (this.mCheckBox != null) {
      this.mCheckBox.setEnabled(paramBoolean);
    }
  }
  
  public void setClickListener(auei paramauei)
  {
    this.d = paramauei;
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.Tj;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      dmH();
      return;
    }
  }
  
  public void setSelectEvent(atqs paramatqs)
  {
    this.b = paramatqs;
  }
  
  public void setSelectedAllMode()
  {
    this.mCheckBox.setVisibility(0);
    this.Tj.setVisibility(8);
    this.Tk.setVisibility(8);
    this.mCheckBox.setOnClickListener(new auft(this));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Tl.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(1, this.mCheckBox.getId());
    localLayoutParams.addRule(0, this.SB.getId());
    localLayoutParams.addRule(13);
    this.Tl.setGravity(1);
    this.Tl.setLayoutParams(localLayoutParams);
    this.Tl.setVisibility(0);
    this.SB.setVisibility(0);
    this.SB.setText("删除");
    this.SB.setOnClickListener(this.fg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */