import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tim.mail.MailPluginAttachDownloader.4;
import com.tencent.tim.mail.MailPluginAttachDownloader.5;
import com.tencent.tim.mail.MailPluginAttachDownloader.6;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class auge
{
  private TextView Oo;
  private ateh jdField_a_of_type_Ateh;
  private atsn jdField_a_of_type_Atsn = new augl(this);
  private Dialog aG;
  private TextView afr;
  private ArrayList<Pair<FileManagerEntity, auge.a>> bS = new ArrayList();
  private String cIs;
  private CloudFileCallbackCenter e = new augk(this);
  private int erw;
  private boolean isCancel;
  private Pair<FileManagerEntity, auge.a> m;
  private QQAppInterface mApp;
  private Activity mContext;
  private int mIndex;
  private ProgressBar mProgressBar;
  
  public auge(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramActivity;
  }
  
  private void cancelDownload()
  {
    this.isCancel = true;
    this.cIs = null;
    this.erw = 0;
    if ((this.m != null) && (this.m.first != null) && (this.m.second != null))
    {
      if (((auge.a)this.m.second).type != 1) {
        break label78;
      }
      this.jdField_a_of_type_Ateh.d((FileManagerEntity)this.m.first, 3);
    }
    label78:
    while (((auge.a)this.m.second).type != 2) {
      return;
    }
    this.mApp.a().bZ(((FileManagerEntity)this.m.first).nSessionId);
  }
  
  private void dhz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "downloadNext isCancel=" + this.isCancel);
    }
    if (this.isCancel) {
      return;
    }
    this.mIndex += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "downloadNext mIndex=" + this.mIndex);
    }
    if (this.mIndex < this.bS.size())
    {
      kT(this.mIndex, 0);
      Pair localPair = (Pair)this.bS.get(this.mIndex);
      if (localPair != null)
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localPair.first;
        auge.a locala = (auge.a)localPair.second;
        if ((localFileManagerEntity != null) && (locala != null) && (TextUtils.isEmpty(locala.filePath)))
        {
          if (locala.type == 1)
          {
            this.jdField_a_of_type_Ateh.bF(localFileManagerEntity);
            this.m = localPair;
            return;
          }
          if (locala.type == 2)
          {
            this.mApp.a().jk(localFileManagerEntity.nSessionId);
            this.m = localPair;
            return;
          }
          dhz();
          return;
        }
        dhz();
        return;
      }
      dhz();
      return;
    }
    if (this.erw > 0)
    {
      euP();
      return;
    }
    euQ();
  }
  
  private boolean jdMethod_do(long paramLong)
  {
    return (this.m != null) && (this.m.first != null) && (paramLong == ((FileManagerEntity)this.m.first).nSessionId);
  }
  
  private void euO()
  {
    Iterator localIterator = atiz.el().iterator();
    Object localObject1;
    Object localObject3;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (FileManagerEntity)localIterator.next();
        if (localObject1 != null) {
          if (aueh.isFileExists(((FileManagerEntity)localObject1).strFilePath))
          {
            localObject3 = ((FileManagerEntity)localObject1).strFilePath;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = new auge.a(1, (String)localObject1);
      this.bS.add(new Pair(localObject2, localObject1));
      break;
      if (((atgc)this.mApp.getManager(373)).w(((FileManagerEntity)localObject1).pDirKey))
      {
        localObject2 = this.mApp.a().a(((FileManagerEntity)localObject1).cloudId);
        if (localObject2 != null)
        {
          if (aueh.isFileExists(((FileManagerEntity)localObject2).strFilePath))
          {
            localObject1 = ((FileManagerEntity)localObject2).strFilePath;
            continue;
          }
          ((FileManagerEntity)localObject2).cloudType = 9;
          localObject1 = null;
          continue;
          localObject3 = atwb.dd().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (WeiYunFileInfo)((Iterator)localObject3).next();
            if (localObject2 != null)
            {
              localObject1 = this.mApp.a().c(((WeiYunFileInfo)localObject2).bIk);
              if (localObject1 != null) {
                break label337;
              }
              localObject1 = audx.b((WeiYunFileInfo)localObject2);
            }
          }
          label337:
          for (;;)
          {
            if (aueh.isFileExists(((FileManagerEntity)localObject1).strFilePath)) {}
            for (localObject2 = ((FileManagerEntity)localObject1).strFilePath;; localObject2 = null)
            {
              ((FileManagerEntity)localObject1).nOpType = 5;
              localObject2 = new auge.a(2, (String)localObject2);
              this.bS.add(new Pair(localObject1, localObject2));
              break;
              this.Oo.setText("共" + this.bS.size() + "个");
              if ((this.aG != null) && (!this.aG.isShowing())) {
                this.aG.show();
              }
              this.mIndex = -1;
              dhz();
              return;
            }
          }
        }
      }
      localObject2 = localObject1;
      localObject1 = null;
    }
  }
  
  private void euP()
  {
    this.mContext.runOnUiThread(new MailPluginAttachDownloader.4(this));
  }
  
  private void euQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "doSendToMail size = " + this.bS.size());
    }
    if (this.e != null)
    {
      atgi.c(this.e);
      this.e = null;
    }
    if (this.jdField_a_of_type_Atsn != null)
    {
      this.mApp.a().deleteObserver(this.jdField_a_of_type_Atsn);
      this.jdField_a_of_type_Atsn = null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = atwb.ep().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (FileInfo)localIterator.next();
      if ((localObject != null) && (aueh.isFileExists(((FileInfo)localObject).getPath()))) {
        localArrayList.add(((FileInfo)localObject).getPath());
      }
    }
    localIterator = agmz.D().iterator();
    while (localIterator.hasNext())
    {
      localObject = (FileInfo)localIterator.next();
      if ((localObject != null) && (aueh.isFileExists(((FileInfo)localObject).getPath()))) {
        localArrayList.add(((FileInfo)localObject).getPath());
      }
    }
    localIterator = agmz.db().iterator();
    while (localIterator.hasNext())
    {
      localObject = (FileManagerEntity)localIterator.next();
      if (aueh.isFileExists(((FileManagerEntity)localObject).strFilePath)) {
        localArrayList.add(((FileManagerEntity)localObject).strFilePath);
      }
    }
    localIterator = this.bS.iterator();
    while (localIterator.hasNext())
    {
      localObject = (Pair)localIterator.next();
      if (localObject != null)
      {
        localObject = (auge.a)((Pair)localObject).second;
        if ((localObject != null) && (!TextUtils.isEmpty(((auge.a)localObject).filePath))) {
          localArrayList.add(((auge.a)localObject).filePath);
        }
      }
    }
    atiz.clearSelected();
    atwb.clearSelected();
    agmz.clearSelected();
    this.mContext.runOnUiThread(new MailPluginAttachDownloader.5(this, localArrayList));
  }
  
  private void kT(int paramInt1, int paramInt2)
  {
    this.mContext.runOnUiThread(new MailPluginAttachDownloader.6(this, paramInt1, paramInt2));
  }
  
  private boolean x(byte[] paramArrayOfByte)
  {
    if ((this.m != null) && (this.m.first != null))
    {
      CloudFile localCloudFile = ((FileManagerEntity)this.m.first).cloudFile;
      if (localCloudFile != null) {
        return Arrays.equals(localCloudFile.cloudId, paramArrayOfByte);
      }
      if (((FileManagerEntity)this.m.first).cloudId != null) {
        return Arrays.equals(((FileManagerEntity)this.m.first).cloudId, paramArrayOfByte);
      }
    }
    return false;
  }
  
  public void euN()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this.mContext, 1, 2131696270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (atiz.ek().size() + atiz.en().size() > 0) {
      QQToast.a(this.mContext, 1, 2131719432, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    this.isCancel = false;
    this.jdField_a_of_type_Ateh = ((ateh)this.mApp.getBusinessHandler(180));
    atgi.a().a(this.e);
    this.mApp.a().addObserver(this.jdField_a_of_type_Atsn);
    this.aG = new ReportDialog(this.mContext, 2131756467);
    this.aG.setContentView(2131559514);
    this.afr = ((TextView)this.aG.findViewById(2131370392));
    this.Oo = ((TextView)this.aG.findViewById(2131377333));
    this.mProgressBar = ((ProgressBar)this.aG.findViewById(2131373700));
    this.aG.findViewById(2131364222).setOnClickListener(new augf(this));
    Iterator localIterator;
    long l;
    Object localObject;
    if (AppNetConnInfo.isMobileConn())
    {
      localIterator = atiz.el().iterator();
      l = 0L;
      if (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if (localObject == null) {
          break label398;
        }
        l = ((FileManagerEntity)localObject).fileSize + l;
      }
    }
    label398:
    for (;;)
    {
      break;
      localIterator = atwb.dd().iterator();
      while (localIterator.hasNext())
      {
        localObject = (WeiYunFileInfo)localIterator.next();
        if (localObject != null) {
          l += ((WeiYunFileInfo)localObject).nFileSize;
        }
      }
      if (l > 1024000L)
      {
        aqha.a(this.mContext, 230, this.mContext.getString(2131693826), this.mContext.getString(2131719433), 2131721058, 2131691970, new augg(this), new augh(this)).show();
        return;
      }
      euO();
      return;
      euO();
      return;
    }
  }
  
  public class a
  {
    String filePath;
    int type;
    
    public a(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.filePath = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auge
 * JD-Core Version:    0.7.0.1
 */