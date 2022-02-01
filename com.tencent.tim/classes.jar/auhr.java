import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.mvp.cloudfile.CloudSendRecvPresenter.3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class auhr
  extends augv
  implements View.OnClickListener, ateh.a, auhk.f
{
  private atgd jdField_a_of_type_Atgd = new auht(this);
  private atij jdField_a_of_type_Atij = new auhs(this);
  public auhk.g a;
  private boolean atv;
  private atix b = new atix(this.app);
  private byte[] cA;
  private boolean isComplete;
  private List<atiu> list = new ArrayList();
  private Map<String, FileManagerEntity> pD = new ConcurrentHashMap();
  private int type = -1;
  
  public auhr(QQAppInterface paramQQAppInterface, auhk.g paramg, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramQQAppInterface, paramg);
    this.cA = paramArrayOfByte;
    this.jdField_a_of_type_Auhk$g = paramg;
    this.type = paramInt;
    this.jdField_a_of_type_Atij.type = paramInt;
  }
  
  private void euW()
  {
    if ((!isComplete()) && (this.list.size() < 10) && ((this.jdField_a_of_type_Auhk$g instanceof CloudFileSendRecvActivity)) && (((CloudFileSendRecvActivity)this.jdField_a_of_type_Auhk$g).Oo() == 0))
    {
      if (this.list.size() > 0) {
        this.b.a(this.type, this.cA, W(), 2, 14);
      }
    }
    else {
      return;
    }
    this.b.a(this.type, this.cA, W(), 1, 14);
  }
  
  public void VN(boolean paramBoolean)
  {
    atix localatix = new atix(this.app);
    if (paramBoolean)
    {
      localatix.a(this.type, this.cA, null, 1, 14);
      return;
    }
    localatix.a(this.type, this.cA, W(), 2, 14);
  }
  
  public Object W()
  {
    if (!this.list.isEmpty()) {
      return this.list.get(this.list.size() - 1);
    }
    return null;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_Auhk$g != null) && ((this.jdField_a_of_type_Auhk$g instanceof CloudFileSendRecvActivity))) {
      ((CloudFileSendRecvActivity)this.jdField_a_of_type_Auhk$g).b(paramFileManagerEntity, paramBoolean, paramString);
    }
  }
  
  public void bF(Object paramObject)
  {
    ((ateh)this.app.getBusinessHandler(180)).bF(paramObject);
  }
  
  public void euX()
  {
    this.b.a(this.type, this.cA, null, -1, 14);
    this.atv = false;
  }
  
  public List<atiu> hk()
  {
    return this.list;
  }
  
  public void initData()
  {
    this.b.a(this.type, this.cA, null, 0, 14);
    this.atv = true;
  }
  
  public boolean isComplete()
  {
    return this.isComplete;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (atjv.a)paramView.getTag();
    Object localObject1 = ((atjv.a)localObject2).a;
    FileManagerEntity localFileManagerEntity = null;
    if ((((atjv.a)localObject2).a instanceof FileManagerEntity)) {
      localFileManagerEntity = (FileManagerEntity)localObject1;
    }
    if (localFileManagerEntity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SendRecvPresenter", 2, " onClickEvent");
      }
      Intent localIntent;
      switch (paramView.getId())
      {
      default: 
        if (((this.jdField_a_of_type_Auhk$g instanceof CloudFileSendRecvActivity)) && (((atiu)localObject1).getCloudFileType() == 0))
        {
          if (localFileManagerEntity.nSessionId == 0L) {
            localFileManagerEntity.nSessionId = audx.d().longValue();
          }
          this.app.a().v(localFileManagerEntity);
          localObject1 = new ForwardFileInfo();
          ((ForwardFileInfo)localObject1).Oj(9);
          ((ForwardFileInfo)localObject1).setType(10001);
          ((ForwardFileInfo)localObject1).setFileName(localFileManagerEntity.fileName);
          ((ForwardFileInfo)localObject1).setFileSize(localFileManagerEntity.fileSize);
          ((ForwardFileInfo)localObject1).bg(localFileManagerEntity.pDirKey);
          ((ForwardFileInfo)localObject1).bf(localFileManagerEntity.cloudId);
          ((ForwardFileInfo)localObject1).p(localFileManagerEntity.nSessionId);
          localObject2 = (CloudFileSendRecvActivity)this.jdField_a_of_type_Auhk$g;
          localIntent = new Intent((Context)localObject2, FileBrowserActivity.class);
          localIntent.putExtra("fileinfo", (Parcelable)localObject1);
          Object localObject3 = athu.a(this.app, this.list);
          if ((audx.fM(((ForwardFileInfo)localObject1).getFileName()) == 0) && (localObject3 != null))
          {
            ((ForwardFileInfo)localObject1).setType(10014);
            localIntent.putStringArrayListExtra("local_tim_cloud_sessionid_list", (ArrayList)localObject3);
          }
          localObject3 = (atgc)this.app.getManager(373);
          if (audx.fM(((ForwardFileInfo)localObject1).getFileName()) == 2) {
            ((atgc)localObject3).y(localFileManagerEntity);
          }
          if (((atgc)localObject3).hh().size() > 0) {
            ((CloudFileSendRecvActivity)localObject2).startActivityForResult(localIntent, 10);
          }
        }
        break;
      case 2131364708: 
        ((ateh)this.app.getBusinessHandler(180)).d(localFileManagerEntity, 3);
        continue;
        ((CloudFileSendRecvActivity)localObject2).startActivityForResult(localIntent, 102);
      }
    }
  }
  
  public void onCreate()
  {
    this.app.addObserver(this.jdField_a_of_type_Atgd);
    this.app.addObserver(this.jdField_a_of_type_Atij);
    ((ateh)this.app.getBusinessHandler(180)).a(this);
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    this.app.removeObserver(this.jdField_a_of_type_Atij);
    ((ateh)this.app.getBusinessHandler(180)).a(null);
    this.jdField_a_of_type_Auhk$g = null;
  }
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new CloudSendRecvPresenter.3(this, paramString));
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
    if (this.jdField_a_of_type_Atij != null) {
      this.jdField_a_of_type_Atij.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhr
 * JD-Core Version:    0.7.0.1
 */