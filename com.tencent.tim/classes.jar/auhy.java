import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class auhy
  extends atgd
{
  auhy(auhw paramauhw) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if (paramBoolean1)
    {
      paramArrayOfByte = paramList.iterator();
      label442:
      label449:
      while (paramArrayOfByte.hasNext())
      {
        paramList = (BatchResult)paramArrayOfByte.next();
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= auhw.c(this.this$0).size()) {
            break label449;
          }
          if (((auhw.c(this.this$0).get(paramInt2) instanceof FileManagerEntity)) && (((FileManagerEntity)auhw.c(this.this$0).get(paramInt2)).combinePhotoList == null))
          {
            paramString = ((FileManagerEntity)auhw.c(this.this$0).get(paramInt2)).cloudFile;
            if ((paramString == null) || (!Arrays.equals(paramString.cloudId, paramList.cloudId)) || (paramInt1 == 0)) {
              break label442;
            }
            auhw.c(this.this$0).remove(paramInt2);
            break;
          }
          if ((auhw.c(this.this$0).get(paramInt2) instanceof atin))
          {
            paramString = ((atin)auhw.c(this.this$0).get(paramInt2)).a;
            if ((paramString == null) || (!Arrays.equals(paramString.cloudId, paramList.cloudId)) || (paramInt1 == 0)) {
              break label442;
            }
            auhw.c(this.this$0).remove(paramInt2);
            break;
          }
          if (((auhw.c(this.this$0).get(paramInt2) instanceof FileManagerEntity)) && (((FileManagerEntity)auhw.c(this.this$0).get(paramInt2)).combinePhotoList != null))
          {
            paramString = ((FileManagerEntity)auhw.c(this.this$0).get(paramInt2)).combinePhotoList;
            if ((paramString != null) && (paramString.size() > 0))
            {
              Iterator localIterator = paramString.iterator();
              while (localIterator.hasNext())
              {
                FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
                if ((localFileManagerEntity != null) && (localFileManagerEntity.cloudFile != null) && (Arrays.equals(localFileManagerEntity.cloudFile.cloudId, paramList.cloudId)) && (paramInt1 != 0))
                {
                  paramString.remove(localFileManagerEntity);
                  if (paramString.size() == 0) {
                    auhw.c(this.this$0).remove(paramInt2);
                  }
                }
              }
            }
          }
          paramInt2 += 1;
        }
      }
      if ((this.this$0.a != null) && (this.this$0.a.Pp())) {
        this.this$0.a.f(paramBoolean1, 4, this.this$0.isComplete());
      }
      auhw.c(this.this$0);
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString)) && (this.this$0.a != null) && (this.this$0.a.Pp()))
      {
        this.this$0.a.qw(BaseApplicationImpl.getContext().getString(2131691575));
        return;
      }
    } while ((this.this$0.a == null) || (!this.this$0.a.Pp()));
    this.this$0.a.qw(paramString);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramLong, paramFileManagerEntity, paramInt, paramString);
    if (QLog.isColorLevel())
    {
      if (paramFileManagerEntity == null) {
        QLog.d("FeedListPresenter", 2, "createFile isSuccess: " + paramBoolean + " fileManagerEntity: null errorCode:" + paramInt + " errorMsg:" + paramString);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label150;
      }
      this.this$0.aaJ(1);
    }
    label150:
    while ((this.this$0.a == null) || (!this.this$0.a.Pp()))
    {
      return;
      QLog.i("FeedListPresenter", 2, "createFile name:" + paramFileManagerEntity.fileName + " size: " + String.valueOf(paramFileManagerEntity.fileSize) + " errorCode:" + paramInt + " errorMsg:" + paramString);
      break;
    }
    if (paramInt == 1029) {}
    for (paramArrayOfByte = BaseApplicationImpl.getContext().getString(2131691572);; paramArrayOfByte = paramString)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.this$0.a.qw(paramArrayOfByte);
        return;
        paramArrayOfByte = BaseApplicationImpl.getContext().getString(2131691571);
      }
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, atin paramatin, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramatin, paramString);
    if (QLog.isColorLevel())
    {
      if (paramArrayOfByte == null) {
        QLog.d("FeedListPresenter", 2, "createFileFolder call back dirKey isSuccess:" + paramBoolean + " dirKey: null");
      }
    }
    else
    {
      if (!paramBoolean) {
        break label148;
      }
      this.this$0.aaJ(1);
      if ((this.this$0.a != null) && (this.this$0.a.Pp())) {
        this.this$0.a.f(paramBoolean, 1, this.this$0.isComplete());
      }
    }
    label148:
    while ((this.this$0.a == null) || (!this.this$0.a.Pp()))
    {
      return;
      QLog.d("FeedListPresenter", 2, "createFileFolder call back dirKey isSuccess:" + paramBoolean + " dirKey: " + Arrays.toString(paramArrayOfByte));
      break;
    }
    if (paramString != null) {}
    for (;;)
    {
      this.this$0.a.qw(paramString);
      return;
      paramString = BaseApplicationImpl.getContext().getString(2131691573);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, List<BatchRequest> paramList, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramList, paramArrayOfByte2, paramInt, paramString);
    if (paramBoolean)
    {
      if ((this.this$0.a != null) && (this.this$0.a.Pp())) {
        this.this$0.a.showSuccessToast(BaseApplicationImpl.getContext().getString(2131691687));
      }
      auhw.c(this.this$0);
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString)) && (this.this$0.a != null) && (this.this$0.a.Pp()))
      {
        this.this$0.a.qw(BaseApplicationImpl.getContext().getString(2131691686));
        return;
      }
    } while ((this.this$0.a == null) || (!this.this$0.a.Pp()));
    this.this$0.a.qw(paramString);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramString);
    if (paramBoolean) {
      if ((this.this$0.a != null) && (this.this$0.a.Pp()))
      {
        this.this$0.a.f(paramBoolean, 1, this.this$0.isComplete());
        this.this$0.a.showSuccessToast(BaseApplicationImpl.getContext().getString(2131691569));
      }
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString)) && (this.this$0.a != null) && (this.this$0.a.Pp()))
      {
        this.this$0.a.qw(BaseApplicationImpl.getContext().getString(2131691568));
        return;
      }
    } while ((this.this$0.a == null) || (!this.this$0.a.Pp()));
    this.this$0.a.qw(paramString);
  }
  
  public void c(boolean paramBoolean1, int paramInt, List<atiu> paramList, boolean paramBoolean2)
  {
    long l;
    Object localObject;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder().append(" onGetPeedList time= ");
      if (l - paramInt == 2L)
      {
        l = auhw.a(this.this$0);
        QLog.d("FeedListPresenter", 2, String.valueOf(l) + "ms isSuccess:" + paramBoolean1 + " operationType: " + paramInt + " hasmore: " + paramBoolean2);
        QLog.d("FeedListPresenter", 2, "getFeedList: isSuccess: " + paramBoolean1 + " operationType: " + paramInt + " hasmore: " + paramBoolean2 + " feedList size" + String.valueOf(paramList.size()));
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label363;
      }
      if (paramInt != 1) {
        break label266;
      }
      localObject = this.this$0.dW.obtainMessage();
      ((Message)localObject).what = 106;
      ((Message)localObject).obj = paramList;
      this.this$0.dW.sendMessage((Message)localObject);
      if (auhw.c(this.this$0) != null)
      {
        paramList = (aulh)auhw.d(this.this$0).getBusinessHandler(122);
        if (paramList != null) {
          paramList.VT(false);
        }
      }
      if (QLog.isColorLevel()) {
        auhw.a(this.this$0, System.currentTimeMillis());
      }
    }
    label266:
    label363:
    while ((this.this$0.a == null) || (!this.this$0.a.Pp()))
    {
      do
      {
        return;
        l = auhw.b(this.this$0);
        break;
        if (paramInt == 0)
        {
          auhw.b(this.this$0, paramBoolean2);
          localObject = this.this$0.dW.obtainMessage();
          ((Message)localObject).what = 102;
          ((Message)localObject).obj = paramList;
          this.this$0.dW.sendMessage((Message)localObject);
          return;
        }
      } while (paramInt != 2);
      localObject = this.this$0.dW.obtainMessage();
      ((Message)localObject).what = 103;
      ((Message)localObject).obj = paramList;
      this.this$0.dW.sendMessage((Message)localObject);
      return;
    }
    this.this$0.a.f(false, auhw.a(this.this$0), this.this$0.isComplete());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhy
 * JD-Core Version:    0.7.0.1
 */