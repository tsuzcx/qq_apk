import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class agyy
  implements agyr<apbr>
{
  private QQAppInterface mApp;
  private Activity mContext;
  private long mTroopUin;
  
  public agyy(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramActivity;
    this.mTroopUin = paramLong;
  }
  
  private void f(List<apbr> paramList, agyx paramagyx)
  {
    if (paramList == null) {
      QLog.w("TroopFileMultiOperate", 1, "fileList == null");
    }
    label314:
    label315:
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        paramagyx = (apbr)paramList.next();
        Object localObject = new apcy();
        ((apcy)localObject).FileName = paramagyx.str_file_name;
        ((apcy)localObject).LocalFile = paramagyx.LocalFile;
        ((apcy)localObject).ProgressTotal = paramagyx.uint64_file_size;
        ((apcy)localObject).ProgressValue = paramagyx.ProgressValue;
        ((apcy)localObject).Id = paramagyx.Id;
        ((apcy)localObject).TroopUin = this.mTroopUin;
        ((apcy)localObject).BusId = paramagyx.dTg;
        ((apcy)localObject).FilePath = paramagyx.mFileId;
        ((apcy)localObject).sha1 = paramagyx.coa;
        ((apcy)localObject).ThumbnailFile_Small = paramagyx.ThumbnailFile_Small;
        ((apcy)localObject).ThumbnailFile_Large = paramagyx.ThumbnailFile_Large;
        ((apcy)localObject).coc = paramagyx.coc;
        ((apcy)localObject).Status = paramagyx.Status;
        apsf.a(this.mApp, this.mTroopUin).d(((apcy)localObject).Id);
        localObject = ahav.a((apcy)localObject);
        if (paramagyx.aqT != 0L) {
          ((FileManagerEntity)localObject).selfUin = ("" + paramagyx.aqT);
        }
        if (paramagyx.dTh != 0) {
          ((FileManagerEntity)localObject).lastTime = paramagyx.dTh;
        }
        ((FileManagerEntity)localObject).bSend = this.mApp.getAccount().equals(((FileManagerEntity)localObject).selfUin);
        if (new aviz(3).a(this.mApp, this.mContext, (FileManagerEntity)localObject, null, false)) {
          break label314;
        }
        i = 1;
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label315;
        }
        ahav.JI(this.mContext.getString(2131700298));
        return;
      }
    }
  }
  
  private void g(List<apbr> paramList, agyx paramagyx)
  {
    if (apsv.a(this.mApp, this.mContext, this.mTroopUin) == 0) {}
    do
    {
      return;
      paramagyx = apsf.a(this.mApp, this.mTroopUin);
    } while (paramagyx == null);
    boolean bool1 = apsv.n(this.mApp, this.mTroopUin);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      apbr localapbr = (apbr)paramList.next();
      boolean bool2 = this.mApp.getCurrentAccountUin().equals(localapbr.AW());
      if ((!localapbr.a(this.mApp, this.mTroopUin, true)) || ((!bool2) && (!bool1))) {
        break label159;
      }
      paramagyx.g(localapbr);
      i = 1;
    }
    label159:
    for (;;)
    {
      break;
      if (bool1)
      {
        ahao.OT(2131693647);
        return;
      }
      if (i != 0)
      {
        ahao.OT(2131693649);
        return;
      }
      ahao.OU(2131693648);
      return;
    }
  }
  
  private void h(List<apbr> paramList, agyx paramagyx)
  {
    if (!aqiw.isNetSupport(this.mContext)) {
      QQToast.a(this.mContext, 2131696348, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    do
    {
      do
      {
        return;
        Iterator localIterator = paramList.iterator();
        for (long l = 0L; localIterator.hasNext(); l = ((apbr)localIterator.next()).uint64_file_size + l) {}
        TroopFileTransferManager.a(this.mApp, this.mTroopUin);
        if ((!ahav.amK()) || (l <= 3145728L)) {
          break;
        }
      } while (!armm.a(this.mContext, 1, new agyz(this, paramList, paramagyx)));
      paramList = new agza(this, paramList, paramagyx);
      paramagyx = this.mContext.getString(2131699605);
      aqha.a(this.mContext, 230, this.mContext.getString(2131699824), paramagyx, 2131721058, 2131699542, paramList, paramList).show();
      return;
      kO(paramList);
    } while (paramagyx == null);
    paramagyx.gg(1, 0);
  }
  
  private void kO(List<apbr> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apbr localapbr = (apbr)paramList.next();
      apcy localapcy = apsv.a(this.mApp, this.mTroopUin, localapbr.Id.toString(), localapbr.mFileId, localapbr.str_file_name, localapbr.uint64_file_size, localapbr.dTg);
      if ((localapcy != null) && (localapcy.Id != null) && ((localapcy.Status == 10) || (localapcy.Status == 9))) {
        localTroopFileTransferManager.c(localapcy.Id);
      } else {
        localTroopFileTransferManager.a(localapbr.mFileId, localapbr.str_file_name, localapbr.uint64_file_size, localapbr.dTg);
      }
    }
  }
  
  private void kP(List<apbr> paramList)
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(this.mContext, 2131696348, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (apbr)localIterator.next();
      localObject = ahbr.a(this.mApp, this.mTroopUin, (apbr)localObject);
      if (localObject == null) {
        break label149;
      }
      bool = ahbr.a(false, ((apcy)localObject).ProgressTotal, ((apcy)localObject).FilePath);
    }
    label149:
    for (;;)
    {
      break;
      if (bool)
      {
        ahal.a(this.mContext, 2131693826, 2131693832, new agzb(this, paramList));
        return;
      }
      ahbr.a(this.mApp, paramList, this.mContext, this.mTroopUin);
      return;
    }
  }
  
  private void kQ(List<apbr> paramList)
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(this.mContext, 2131696348, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    label47:
    if (localIterator.hasNext())
    {
      Object localObject = (apbr)localIterator.next();
      localObject = ahbr.a(this.mApp, this.mTroopUin, (apbr)localObject);
      if (localObject == null) {
        break label178;
      }
      bool = ahbr.a(false, ((apcy)localObject).ProgressTotal, ((apcy)localObject).FilePath);
    }
    label178:
    for (;;)
    {
      break label47;
      if (bool)
      {
        if (!armm.a(this.mContext, 5, new agzc(this, paramList))) {
          break;
        }
        ahal.a(this.mContext, 2131693826, 2131693830, new agzd(this, paramList));
        return;
      }
      ahao.JG(this.mContext.getString(2131694101));
      apsv.a(this.mApp, this.mTroopUin, paramList);
      return;
    }
  }
  
  public void a(List<apbr> paramList, int paramInt, agyx paramagyx)
  {
    QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. operateType[" + paramInt + "]");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. file list is null");
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      h(paramList, paramagyx);
      return;
    case 2: 
      kP(paramList);
      return;
    case 4: 
      kQ(paramList);
      return;
    case 3: 
      g(paramList, paramagyx);
      return;
    }
    f(paramList, paramagyx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyy
 * JD-Core Version:    0.7.0.1
 */