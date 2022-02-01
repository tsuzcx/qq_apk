import android.text.TextUtils;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mvp.cloudfile.TopLevelFileListPresenter.1.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aujb
  extends atgd
{
  aujb(auja paramauja) {}
  
  public void a(boolean paramBoolean, CloudUserInfo paramCloudUserInfo)
  {
    super.a(paramBoolean, paramCloudUserInfo);
    if ((auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
      auja.a(this.b).wE(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    int i = 0;
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if ((auja.a(this.b, paramArrayOfByte)) && (paramBoolean1))
    {
      paramInt1 = i;
      if (paramList != null)
      {
        paramInt1 = i;
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          paramInt1 = 0;
          if (paramList.hasNext())
          {
            paramArrayOfByte = (BatchResult)paramList.next();
            if (paramArrayOfByte.cloudId != null)
            {
              paramArrayOfByte = new String(paramArrayOfByte.cloudId);
              label105:
              if (auja.b(this.b).remove(paramArrayOfByte) == null) {
                break label137;
              }
            }
            label137:
            for (paramInt2 = 1;; paramInt2 = 0)
            {
              paramInt1 = paramInt2 | paramInt1;
              break;
              paramArrayOfByte = null;
              break label105;
            }
          }
        }
      }
      if (paramInt1 != 0)
      {
        auja.a(this.b);
        if ((auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
          auja.a(this.b).f(paramBoolean1, 4, this.b.isComplete());
        }
        auja.b(this.b);
      }
    }
  }
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<atiu> paramList, boolean paramBoolean2, String paramString, int paramInt2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramBoolean2, paramString, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("TopLevelFileListPresenter", 2, "onGetFileList entrance dirKey:" + Arrays.toString(paramArrayOfByte) + " version:" + auja.a(this.b) + " currentVersion:" + paramString + " operationType:" + paramInt1 + " isSuccess:" + paramBoolean1);
    }
    if (auja.a(this.b, paramArrayOfByte))
    {
      if ((paramBoolean1) && (auja.a(this.b) != null) && (auja.a(this.b).Pp()))
      {
        if ((auja.a(this.b) == null) || (!auja.a(this.b).equals(paramString)) || (paramInt1 == 2) || (paramInt1 == 1))
        {
          boolean bool = auja.a(this.b, paramArrayOfByte, paramList, paramInt1);
          if (QLog.isColorLevel()) {
            QLog.d("TopLevelFileListPresenter", 2, "onGetFileList dirKey:" + Arrays.toString(paramArrayOfByte) + " version:" + auja.a(this.b) + " currentVersion:" + paramString + " operationType:" + paramInt1 + " updateLastFile:" + bool);
          }
          label322:
          label348:
          Object localObject;
          long l;
          if (bool)
          {
            paramArrayOfByte = this.b;
            if (!paramBoolean2)
            {
              paramBoolean2 = true;
              auja.a(paramArrayOfByte, paramBoolean2);
              if ((paramList == null) || (paramList.isEmpty())) {
                break label508;
              }
              auja.a(this.b, paramList.get(paramList.size() - 1));
            }
          }
          else
          {
            paramArrayOfByte = (ateh)auja.a(this.b).getBusinessHandler(180);
            paramList = paramList.iterator();
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
              localObject = (atiu)paramList.next();
            } while (((atiu)localObject).getCloudFileType() != 1);
            localObject = (atin)localObject;
            l = ((atin)localObject).getModifyTime();
            if (QLog.isColorLevel()) {
              QLog.d("TopLevelFileListPresenter", 2, "getFileGridData firstLevelDirCallback name:" + ((atin)localObject).name + " getTotalCount:" + ((atin)localObject).getTotalCount() + " getModifyTime:" + l);
            }
            if (paramInt1 != 0) {
              break label547;
            }
            if (((atin)localObject).getTotalCount() == 0) {
              break label520;
            }
            paramArrayOfByte.a(((atin)localObject).Y(), 0, null);
          }
          for (;;)
          {
            auja.a(this.b).put(((atin)localObject).EP(), Long.valueOf(l));
            break label348;
            paramBoolean2 = false;
            break;
            label508:
            auja.a(this.b, null);
            break label322;
            label520:
            auja.a(this.b, 6, ((atin)localObject).Y(), new ArrayList(), paramInt1, -1, null);
            continue;
            label547:
            Long localLong = (Long)auja.a(this.b).get(((atin)localObject).EP());
            if (QLog.isColorLevel()) {
              QLog.d("TopLevelFileListPresenter", 2, "onGetFileList lastModifyTime:" + localLong + " modifyTime:" + l);
            }
            if ((localLong == null) || (localLong.longValue() != l)) {
              paramArrayOfByte.a(((atin)localObject).Y(), 8, null);
            }
          }
        }
        auja.a(this.b, paramString);
      }
      if ((auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
        auja.a(this.b).f(paramBoolean1, 7, this.b.isComplete());
      }
    }
    label831:
    do
    {
      do
      {
        return;
        if (!auja.b(this.b, paramArrayOfByte)) {
          break;
        }
        if (paramBoolean1) {
          auja.a(this.b, 6, paramArrayOfByte, paramList, paramInt1, paramInt2, paramString);
        }
      } while ((auja.a(this.b) == null) || (!auja.a(this.b).Pp()));
      if (Arrays.equals(((atgc)auja.b(this.b).getManager(373)).aF(), paramArrayOfByte))
      {
        paramArrayOfByte = auja.a(this.b);
        if (paramBoolean2) {
          break label831;
        }
      }
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        paramArrayOfByte.g(paramBoolean1, paramInt1, paramBoolean2);
        auja.a(this.b).f(paramBoolean1, paramInt1, this.b.isComplete());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TopLevelFileListPresenter", 2, "onGetFileList other dirKey:" + Arrays.toString(paramArrayOfByte));
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramLong, paramFileManagerEntity, paramInt, paramString);
    if ((auja.b(this.b, paramArrayOfByte)) && (paramBoolean)) {
      ((ateh)auja.c(this.b).getBusinessHandler(180)).a(paramArrayOfByte, 8, null);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, atin paramatin, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramatin, paramString);
    if (auja.a(this.b, paramArrayOfByte))
    {
      auja.a(this.b, paramArrayOfByte, Arrays.asList(new atiu[] { paramatin }), 2);
      if ((auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
        auja.a(this.b).f(paramBoolean, 3, this.b.isComplete());
      }
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, List<BatchRequest> paramList, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    int i = 0;
    super.a(paramBoolean, paramArrayOfByte1, paramList, paramArrayOfByte2, paramInt, paramString);
    if (((auja.a(this.b, paramArrayOfByte1)) || (auja.a(this.b, paramArrayOfByte2))) && (paramBoolean))
    {
      if (!auja.a(this.b, paramArrayOfByte1)) {
        break label251;
      }
      paramInt = i;
      if (paramList != null)
      {
        paramInt = i;
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          paramInt = 0;
          if (paramList.hasNext())
          {
            paramArrayOfByte1 = (BatchRequest)paramList.next();
            if (paramArrayOfByte1.cloudId != null)
            {
              paramArrayOfByte1 = new String(paramArrayOfByte1.cloudId);
              label123:
              if (auja.b(this.b).remove(paramArrayOfByte1) == null) {
                break label157;
              }
            }
            label157:
            for (i = 1;; i = 0)
            {
              paramInt = i | paramInt;
              break;
              paramArrayOfByte1 = null;
              break label123;
            }
          }
        }
      }
      if (paramInt != 0)
      {
        auja.a(this.b);
        if ((auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
          auja.a(this.b).f(paramBoolean, 3, this.b.isComplete());
        }
        auja.b(this.b);
        ((ateh)auja.e(this.b).getBusinessHandler(180)).N(8, null);
      }
    }
    return;
    label251:
    ((ateh)auja.f(this.b).getBusinessHandler(180)).N(8, null);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    if ((auja.a(this.b, paramArrayOfByte1)) && (paramBoolean))
    {
      paramInt = 0;
      while (paramInt < auja.a(this.b).size())
      {
        if (Arrays.equals(((atio)auja.a(this.b).get(paramInt)).Y(), paramArrayOfByte2)) {
          ((atio)auja.a(this.b).get(paramInt)).name = paramString1;
        }
        paramInt += 1;
      }
      if ((auja.a(this.b) != null) && (auja.a(this.b).Pp()))
      {
        auja.a(this.b).showSuccessToast(BaseApplicationImpl.getContext().getString(2131691689));
        auja.a(this.b).f(paramBoolean, 5, this.b.isComplete());
      }
    }
    do
    {
      return;
      if ((!paramBoolean) && (TextUtils.isEmpty(paramString2)) && (auja.a(this.b) != null) && (auja.a(this.b).Pp()))
      {
        auja.a(this.b).qw(BaseApplicationImpl.getContext().getString(2131691688));
        return;
      }
    } while ((paramBoolean) || (TextUtils.isEmpty(paramString2)) || (auja.a(this.b) == null) || (!auja.a(this.b).Pp()));
    auja.a(this.b).qw(paramString2);
  }
  
  public void g(boolean paramBoolean, int paramInt, List<Object> paramList)
  {
    if (paramBoolean)
    {
      if ((paramInt == 1) || (paramInt == 0) || (paramInt == 8))
      {
        this.b.KY.clear();
        ArrayList localArrayList1 = new ArrayList();
        if (paramList != null)
        {
          paramInt = 0;
          if (paramInt < paramList.size())
          {
            Object localObject = (FileManagerEntity)paramList.get(paramInt);
            localArrayList1.add(localObject);
            if (((FileManagerEntity)localObject).getCloudFileType() == 3)
            {
              ArrayList localArrayList2 = new ArrayList();
              localObject = ((FileManagerEntity)localObject).combinePhotoList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
                localArrayList2.add(localFileManagerEntity);
                this.b.KY.add(localFileManagerEntity);
              }
              ThreadManager.post(new TopLevelFileListPresenter.1.1(this, localArrayList2), 8, null, true);
            }
            for (;;)
            {
              paramInt += 1;
              break;
              this.b.KY.add(localObject);
            }
          }
        }
        auja.c(this.b);
        paramList = (atgc)auja.d(this.b).getManager(373);
        if (paramList != null) {
          paramList.nE(localArrayList1);
        }
      }
      if ((auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
        auja.a(this.b).f(paramBoolean, 3, this.b.isComplete());
      }
    }
  }
  
  public void m(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super.m(paramBoolean1, paramInt, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("TopLevelFileListPresenter", 2, "onGetFileGridData isSuccess:" + paramBoolean1 + " operationType:" + paramInt + " hasMore:" + paramBoolean2);
    }
    if ((!paramBoolean1) && (auja.a(this.b) != null) && (auja.a(this.b).Pp())) {
      auja.a(this.b).f(paramBoolean1, 7, this.b.isComplete());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujb
 * JD-Core Version:    0.7.0.1
 */