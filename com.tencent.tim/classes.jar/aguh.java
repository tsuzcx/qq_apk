import android.app.Activity;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.QbSdk;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aguh
  extends agts
  implements Handler.Callback
{
  private aoak a;
  public long aae;
  public long downloadStartTime;
  private FileManagerEntity entity;
  private int interval = 1000;
  private MqqHandler mUIHandler;
  private int timeoutInterval = 60000;
  
  public aguh(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    V(paramList, paramInt);
    this.entity = this.c.b();
    this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void E(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.downloadStartTime = System.currentTimeMillis();
    this.mUIHandler.removeMessages(8001);
    this.mUIHandler.removeMessages(8002);
    this.mUIHandler.post(new DocsExportFileModel.2(this));
    ((aoam)this.mAppInterface.getBusinessHandler(142)).P(paramString1, paramString2, paramString3, paramString4);
  }
  
  private void fM(String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((localQQAppInterface != null) && (paramString2 != null) && (this.entity != null)) {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", aoal.fr(this.entity.nFileType), paramString2);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = acfp.m(2131705187);
    }
    QQToast.a(this.mContext, 1, paramString2, 0).show();
    cqt();
    this.mContext.finish();
  }
  
  public agss a()
  {
    if (this.jdField_a_of_type_Agss == null) {
      this.jdField_a_of_type_Agss = new aguj(this);
    }
    return this.jdField_a_of_type_Agss;
  }
  
  public agsv a()
  {
    return null;
  }
  
  public void a(aguk.d paramd)
  {
    super.a(paramd);
    if ((this.ba != null) && (this.ba.containsKey("isSuccess")))
    {
      boolean bool = this.ba.getBoolean("isSuccess");
      paramd = this.ba.getString("docUrl");
      if (!bool) {
        break label90;
      }
      E(this.ba.getString("url"), this.ba.getString("fileName"), paramd, this.ba.getString("cookie"));
    }
    for (;;)
    {
      this.ba.remove("isSuccess");
      return;
      label90:
      fM(acfp.m(2131715171), paramd);
    }
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    int i;
    do
    {
      FileManagerEntity localFileManagerEntity;
      String str;
      boolean bool;
      do
      {
        return;
        localFileManagerEntity = this.c.b();
        str = getFilePath();
        bool = ahbj.fileExistsAndNotEmpty(str);
      } while (((localFileManagerEntity == null) && (TextUtils.isEmpty(str))) || (bF() == 16) || ((!bool) && (localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile)));
      i = paramActionSheetItem.action;
      if (i == 2)
      {
        agqm.a(this.e, localFileManagerEntity, this.mContext);
        anot.a(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
        return;
      }
      if (i == 27)
      {
        agqm.a(this.e, str);
        anot.a(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
        return;
      }
      if (i == 6)
      {
        agqm.b(this.e, localFileManagerEntity);
        anot.a(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.mContext, getFilePath());
    ahav.F(this.mContext, getFilePath());
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.c.b();
    String str = getFilePath();
    boolean bool1 = ahbj.fileExistsAndNotEmpty(str);
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return null;
    }
    if (bF() == 16) {
      return null;
    }
    if ((!bool1) && (localObject3 != null) && (((FileManagerEntity)localObject3).isZipInnerFile)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1;
    if (bool1)
    {
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ahav.a(new FileInfo(str));
        Object localObject4 = ahbr.a(2, null);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localArrayList1.add(localObject1);
        if ((localObject3 == null) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunFileId)) || (TextUtils.isEmpty(((FileManagerEntity)localObject3).WeiYunDirKey))) {
          break label590;
        }
        i = 1;
        if (i == 0)
        {
          if (!bool1) {
            break label595;
          }
          localObject1 = ahbr.a(27, null);
          localArrayList1.add(localObject1);
        }
        localObject1 = WXShareHelper.a();
        if ((bool1) && (((WXShareHelper)localObject1).isWXinstalled()) && (((WXShareHelper)localObject1).aGT())) {
          localArrayList1.add(ahbr.a(9, agqm.b(this.mContext, str)));
        }
        if (bool1) {
          localArrayList1.add(ahbr.a(64, agqm.a(this.mContext, str)));
        }
        if (ahav.q((FileManagerEntity)localObject3)) {
          localArrayList2.add(ahbr.a(6, null));
        }
        boolean bool2 = aetq.a().ahU();
        long l = ahav.d(this.mAppInterface, this.entity.fileName);
        localObject4 = aeuc.a().ud();
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject1 = aobw.cjR;
        }
        if ((bool2) && (localObject3 != null) && (aobw.v(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          localObject1 = ahbr.a(119, agqm.a((FileManagerEntity)localObject3, this.mContext));
          anot.a(this.mAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList2.add(localObject1);
        }
        if (agyj.c((FileManagerEntity)localObject3, bool1))
        {
          localArrayList2.add(ahbr.a(122, agqm.a(this.mContext, (FileManagerEntity)localObject3, str)));
          localArrayList2.add(ahbr.a(123, agqm.b(this.mContext, (FileManagerEntity)localObject3, str)));
        }
        if (bool1)
        {
          if (((acde)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(8)).b.B(getFileName())) {
            localArrayList2.add(ahbr.a(121, agqm.b(this.e, getFilePath())));
          }
          if (QbSdk.isInDefaultBrowser(this.mContext, str)) {
            localArrayList2.add(ahbr.a(132, null));
          }
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = ahbr.a(2, null);
      continue;
      label590:
      int i = 0;
      continue;
      label595:
      if (bG() == 1) {
        localObject2 = ahbr.a(27, null);
      }
    }
  }
  
  public int bE()
  {
    return 10;
  }
  
  public int bL()
  {
    int i = super.bL();
    if (bI() == 10) {
      i = 6;
    }
    return i;
  }
  
  public boolean cn()
  {
    return true;
  }
  
  public void cqt()
  {
    super.cqt();
  }
  
  public void djr()
  {
    super.djr();
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (bG() == 1)
    {
      if (bH() == 3000) {
        this.mAppInterface.a().a(new agjx(this.mAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.mAppInterface.a().a(new aglj(this.mAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((this.entity != null) && (this.entity.fProgress <= 45.0F))
      {
        if (this.jdField_a_of_type_Aguk$d != null)
        {
          paramMessage = this.entity;
          paramMessage.fProgress += 5.0F;
          this.jdField_a_of_type_Aguk$d.aO(this.entity.fProgress);
        }
        this.mUIHandler.sendEmptyMessageDelayed(8001, this.interval);
      }
      else
      {
        this.mUIHandler.removeMessages(8001);
        continue;
        fM(acfp.m(2131705190), "");
      }
    }
  }
  
  protected void ix()
  {
    if (this.jdField_a_of_type_Aoak != null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_Aoak = new agui(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while ((localQQAppInterface == null) || (this.jdField_a_of_type_Aoak == null));
    localQQAppInterface.addObserver(this.jdField_a_of_type_Aoak);
  }
  
  protected void removeObserver()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((this.jdField_a_of_type_Aoak != null) && (localQQAppInterface != null)) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Aoak);
    }
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeMessages(8001);
      this.mUIHandler.removeMessages(8002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguh
 * JD-Core Version:    0.7.0.1
 */