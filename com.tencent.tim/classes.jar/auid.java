import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.teamwork.PadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class auid
  extends aulm
{
  auid(auib paramauib) {}
  
  public void aa(boolean paramBoolean, List<PadInfo> paramList)
  {
    super.aa(paramBoolean, paramList);
    if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PadInfo localPadInfo = (PadInfo)paramList.next();
        Object localObject = localPadInfo.domainId + "$" + localPadInfo.padId;
        localObject = (FileManagerEntity)auib.a(this.b).remove(localObject);
        if ((localObject != null) && (athu.a((FileManagerEntity)localObject, localPadInfo)))
        {
          atgi.a().updateOnlineInfo(((FileManagerEntity)localObject).cloudFile.onlineFileExt);
          ((ateh)auib.b(this.b).getBusinessHandler(180)).a(auib.a(this.b), 1, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auid
 * JD-Core Version:    0.7.0.1
 */