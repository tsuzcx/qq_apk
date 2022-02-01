import android.app.Activity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aguc
  extends agts
{
  private long aac = -1L;
  private long aad = -1L;
  private szg c;
  
  public aguc(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceFileModel<FileAssistant>", 1, "FileBrowserModel init: type = device");
    }
    V(paramList, paramInt);
  }
  
  private boolean amu()
  {
    Object localObject = this.jdField_c_of_type_Agsd.b();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
      return false;
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      return false;
    }
    localObject = this.mAppInterface.b().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    if (localObject == null) {
      return false;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    szv localszv = ((szy)this.mAppInterface.getBusinessHandler(49)).a();
    if ((((MessageForDeviceSingleStruct)localObject).nMediaSessionID > 0L) && (localszv.a((MessageForDeviceSingleStruct)localObject)))
    {
      this.aac = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      return true;
    }
    return false;
  }
  
  private void djx()
  {
    Object localObject = this.jdField_c_of_type_Agsd.b();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath()));
      localObject = this.mAppInterface.b().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    } while (localObject == null);
    localObject = (MessageForDeviceSingleStruct)localObject;
    this.aac = ((szy)this.mAppInterface.getBusinessHandler(49)).a().a((MessageForDeviceSingleStruct)localObject);
  }
  
  private void djy()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      return;
      localObject = this.mAppInterface.b().a(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.msgSeq);
    } while (localObject == null);
    Object localObject = (MessageForDeviceSingleStruct)localObject;
    ((szy)this.mAppInterface.getBusinessHandler(49)).a().b((MessageForDeviceSingleStruct)localObject);
    localFileManagerEntity.status = 3;
    this.aac = -1L;
  }
  
  public agss a()
  {
    if (this.a == null) {
      this.a = new ague(this);
    }
    return this.a;
  }
  
  public agsu a()
  {
    return new agug(this);
  }
  
  public agsv a()
  {
    return null;
  }
  
  public int bE()
  {
    int i = getFileType();
    int j = super.bE();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    case 1: 
    default: 
      return 1;
    case 0: 
      return 6;
    }
    return 2;
  }
  
  public int bG()
  {
    if (ahav.mI(getFilePath())) {
      return 3;
    }
    return super.bG();
  }
  
  public int bK()
  {
    return 2;
  }
  
  public int bL()
  {
    if (ahav.mI(getFilePath())) {
      return 2;
    }
    if (amu()) {
      return 4;
    }
    return 3;
  }
  
  public boolean cn()
  {
    return aqiw.isWifiConnected(this.mContext);
  }
  
  protected void ix()
  {
    if (this.jdField_c_of_type_Szg != null) {
      return;
    }
    this.jdField_c_of_type_Szg = new agud(this);
    this.mAppInterface.addObserver(this.jdField_c_of_type_Szg);
  }
  
  protected void removeObserver()
  {
    if (this.jdField_c_of_type_Szg != null)
    {
      this.mAppInterface.removeObserver(this.jdField_c_of_type_Szg);
      this.jdField_c_of_type_Szg = null;
    }
  }
  
  public List<aguk.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BG != null)
    {
      Iterator localIterator = this.BG.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new agsy((agsd)localIterator.next()));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguc
 * JD-Core Version:    0.7.0.1
 */