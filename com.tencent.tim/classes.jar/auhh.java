import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudDir;
import com.tencent.cloudfile.CloudFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.mvp.cloudfile.CloudFileAndFolderOperationPresenter.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auhh
  extends augz
{
  private atgd a;
  
  public auhh(QQAppInterface paramQQAppInterface, Context paramContext, auhk.d paramd)
  {
    super(paramQQAppInterface, paramContext, paramd);
    this.jdField_a_of_type_Atgd = new auhj(this);
  }
  
  private static com.tencent.cloudfile.FileInfo a(com.tencent.mobileqq.filemanager.data.FileInfo paramFileInfo)
  {
    com.tencent.cloudfile.FileInfo localFileInfo = new com.tencent.cloudfile.FileInfo();
    if ((paramFileInfo.getPath().endsWith(".apk")) && (!paramFileInfo.getName().contains(".apk"))) {}
    for (localFileInfo.fileName = (paramFileInfo.getName() + ".apk");; localFileInfo.fileName = paramFileInfo.getName())
    {
      localFileInfo.localPath = paramFileInfo.getPath();
      localFileInfo.fileSrcType = ahav.getFileType(localFileInfo.localPath);
      localFileInfo.fileSize = paramFileInfo.getSize();
      if ((ahbj.isFileExists(localFileInfo.localPath)) && (localFileInfo.fileSrcType == 0))
      {
        paramFileInfo = new BitmapFactory.Options();
        paramFileInfo.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(localFileInfo.localPath, paramFileInfo);
        localFileInfo.width = paramFileInfo.outWidth;
        localFileInfo.height = paramFileInfo.outHeight;
      }
      return localFileInfo;
    }
  }
  
  private void ae(List<CloudBase> paramList, int paramInt)
  {
    ((ateh)this.app.getBusinessHandler(180)).g(paramList, paramInt, true);
  }
  
  public void a(byte[] paramArrayOfByte1, com.tencent.mobileqq.filemanager.data.FileInfo paramFileInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((!aqiw.isNetworkAvailable(this.context)) && (this.jdField_a_of_type_Auhk$d != null)) {
      this.jdField_a_of_type_Auhk$d.qw(BaseApplicationImpl.getContext().getString(2131693404));
    }
    while ((paramFileInfo == null) || (paramFileInfo.Y() == null)) {
      return;
    }
    ((ateh)this.app.getBusinessHandler(180)).a(paramArrayOfByte1, paramFileInfo.Y(), paramArrayOfByte2, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, List<com.tencent.mobileqq.filemanager.data.FileInfo> paramList, int paramInt)
  {
    int j = 0;
    atgc localatgc;
    long l;
    int i;
    if ((paramArrayOfByte != null) && (paramList != null))
    {
      localatgc = (atgc)this.app.getManager(373);
      Iterator localIterator = paramList.iterator();
      l = 0L;
      i = 1;
      if (localIterator.hasNext())
      {
        com.tencent.mobileqq.filemanager.data.FileInfo localFileInfo = (com.tencent.mobileqq.filemanager.data.FileInfo)localIterator.next();
        l += localFileInfo.getSize();
        if (localFileInfo.getSize() <= localatgc.iu()) {
          break label202;
        }
        i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
        QQToast.a(this.context, 0, "选择的文件大于" + athu.c((float)localatgc.iu()) + "，添加失败", 0).show(i);
        i = 0;
      }
    }
    label202:
    for (;;)
    {
      break;
      if (l > localatgc.getTotalSpace() - localatgc.it())
      {
        athu.c(this.app, this.context, 2);
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          a(paramArrayOfByte, paramList, paramInt, null);
        }
        return;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, List<com.tencent.mobileqq.filemanager.data.FileInfo> paramList, int paramInt, auhk.h paramh)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!aqiw.isNetworkAvailable(this.context)) && (this.jdField_a_of_type_Auhk$d != null)) {
      this.jdField_a_of_type_Auhk$d.qw(BaseApplicationImpl.getContext().getString(2131693404));
    }
    do
    {
      return;
      if (ahav.amK())
      {
        ahal.a(this.context, 2131693826, 2131693829, new auhi(this, paramList, localArrayList, paramh, paramArrayOfByte));
        return;
      }
    } while (paramList == null);
    ThreadManager.post(new CloudFileAndFolderOperationPresenter.2(this, paramList, localArrayList, paramh, paramArrayOfByte), 8, null, true);
  }
  
  public void a(byte[] paramArrayOfByte1, List<com.tencent.mobileqq.filemanager.data.FileInfo> paramList, byte[] paramArrayOfByte2)
  {
    if ((!aqiw.isNetworkAvailable(this.context)) && (this.jdField_a_of_type_Auhk$d != null))
    {
      this.jdField_a_of_type_Auhk$d.qw(BaseApplicationImpl.getContext().getString(2131693404));
      return;
    }
    paramArrayOfByte1 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        com.tencent.mobileqq.filemanager.data.FileInfo localFileInfo = (com.tencent.mobileqq.filemanager.data.FileInfo)paramList.next();
        BatchRequest localBatchRequest = new BatchRequest();
        localBatchRequest.pDirKey = localFileInfo.X();
        localBatchRequest.cloudId = localFileInfo.Y();
        if (localFileInfo.isDirectory()) {}
        for (int i = 1;; i = 2)
        {
          localBatchRequest.modelType = i;
          localBatchRequest.fileName = localFileInfo.getName();
          paramArrayOfByte1.add(localBatchRequest);
          break;
        }
      }
    }
    ((ateh)this.app.getBusinessHandler(180)).a(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void al(Object... paramVarArgs)
  {
    this.jdField_a_of_type_Auhk$d.a(this.context, paramVarArgs);
  }
  
  public void bG(Object paramObject)
  {
    this.jdField_a_of_type_Auhk$d.e(this.context, paramObject);
  }
  
  public void bH(Object paramObject)
  {
    this.jdField_a_of_type_Auhk$d.d(this.context, paramObject);
    if ((paramObject instanceof atin)) {
      anpc.report("tim_mine_tab_file_click_rename_folder");
    }
    while (!(paramObject instanceof FileManagerEntity)) {
      return;
    }
    anpc.report("tim_mine_tab_file_click_rename_file");
  }
  
  public void k(Object paramObject, String paramString)
  {
    if ((!aqiw.isNetworkAvailable(this.context)) && (this.jdField_a_of_type_Auhk$d != null))
    {
      this.jdField_a_of_type_Auhk$d.qw(BaseApplicationImpl.getContext().getString(2131693404));
      return;
    }
    if ((paramObject instanceof FileManagerEntity))
    {
      ((ateh)this.app.getBusinessHandler(180)).b(((FileManagerEntity)paramObject).cloudFile.pLogicDirKey, ((FileManagerEntity)paramObject).cloudFile.cloudId, paramString);
      return;
    }
    atgc localatgc = (atgc)this.app.getManager(373);
    if ((paramString.equals(this.context.getString(2131691582))) || (paramString.equals(this.context.getString(2131691584))) || ((localatgc.EN() != null) && (paramString.equals(localatgc.EN()))) || ((localatgc.EO() != null) && (paramString.equals(localatgc.EO()))) || ((paramString.equals(this.context.getString(2131691589))) && (this.jdField_a_of_type_Auhk$d.Pp())))
    {
      this.jdField_a_of_type_Auhk$d.qw(BaseApplicationImpl.getContext().getString(2131691574));
      return;
    }
    ((ateh)this.app.getBusinessHandler(180)).a(((atin)paramObject).a.pLogicDirKey, ((atin)paramObject).a.cloudId, paramString);
  }
  
  public void nS(List<Object> paramList)
  {
    this.jdField_a_of_type_Auhk$d.i(this.context, paramList);
    anpc.report("tim_mine_tab_file_click_send_file");
    if ((paramList != null) && (paramList.get(0) != null) && ((paramList.get(0) instanceof FileManagerEntity)))
    {
      paramList = (FileManagerEntity)paramList.get(0);
      if ((paramList.pDirKey == null) || (!((atgc)this.app.getManager(373)).w(paramList.pDirKey))) {}
    }
  }
  
  public void nT(List<Object> paramList)
  {
    this.jdField_a_of_type_Auhk$d.h(this.context, paramList);
  }
  
  public void o(int paramInt, Object... paramVarArgs)
  {
    if ((!aqiw.isNetworkAvailable(this.context)) && (this.jdField_a_of_type_Auhk$d != null)) {
      this.jdField_a_of_type_Auhk$d.qw(BaseApplicationImpl.getContext().getString(2131693404));
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (paramVarArgs == null);
      localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramVarArgs[i];
        if ((!(localObject1 instanceof FileManagerEntity)) && (!(localObject1 instanceof atin))) {
          throw new IllegalArgumentException("file can either be instance of FileManagerEntity or FileDirEntity");
        }
        if ((localObject1 instanceof FileManagerEntity))
        {
          CloudFile localCloudFile = ((FileManagerEntity)localObject1).cloudFile;
          localObject1 = localCloudFile;
          if ((localCloudFile instanceof CloudFile))
          {
            Object localObject2 = (CloudFile)localCloudFile;
            localObject1 = localCloudFile;
            if (((CloudFile)localObject2).bIsClusterFile)
            {
              localObject1 = localCloudFile;
              if (((CloudFile)localObject2).clusterFileList != null)
              {
                localObject2 = ((CloudFile)localObject2).clusterFileList.iterator();
                for (;;)
                {
                  localObject1 = localCloudFile;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localArrayList.add((CloudFile)((Iterator)localObject2).next());
                }
              }
            }
          }
        }
        else
        {
          localObject1 = ((atin)localObject1).a;
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      ae(localArrayList, paramInt);
    } while ((localArrayList.get(0) == null) || (((CloudBase)localArrayList.get(0)).pLogicDirKey == null) || (!((atgc)this.app.getManager(373)).w(((CloudBase)localArrayList.get(0)).pLogicDirKey)));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.app.addObserver(this.jdField_a_of_type_Atgd);
  }
  
  protected void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhh
 * JD-Core Version:    0.7.0.1
 */