import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class atmj
  extends atdt
{
  public atmj(QQAppInterface paramQQAppInterface, Context paramContext, augx paramaugx)
  {
    super(paramQQAppInterface, paramContext, 6, paramaugx);
  }
  
  private List<Object> bs(List<? extends Object> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localArrayList.add(new atkr(((WeiYunFileInfo)paramList.get(0)).mtime));
      localArrayList.add(c((WeiYunFileInfo)paramList.get(0)));
      i = 1;
    }
    for (;;)
    {
      if (i < paramList.size())
      {
        if ((paramList.get(i) instanceof WeiYunFileInfo))
        {
          WeiYunFileInfo localWeiYunFileInfo1 = (WeiYunFileInfo)paramList.get(i);
          WeiYunFileInfo localWeiYunFileInfo2 = (WeiYunFileInfo)paramList.get(i - 1);
          FileManagerEntity localFileManagerEntity = c(localWeiYunFileInfo1);
          try
          {
            if (auqb.cr(localWeiYunFileInfo1.mtime).equals(auqb.cr(localWeiYunFileInfo2.mtime)))
            {
              localArrayList.add(localFileManagerEntity);
            }
            else
            {
              localArrayList.add(new atkr(localWeiYunFileInfo1.mtime));
              localArrayList.add(localFileManagerEntity);
            }
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
          }
        }
      }
      else {
        return localArrayList;
      }
      i += 1;
    }
  }
  
  private FileManagerEntity c(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity2 = this.app.a().f(paramWeiYunFileInfo.bIk);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null)
    {
      localFileManagerEntity2 = this.app.a().c(paramWeiYunFileInfo.bIk);
      localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = audx.b(paramWeiYunFileInfo);
      }
    }
    return localFileManagerEntity1;
  }
  
  public void mx(List<? extends Object> paramList)
  {
    super.mx(bs(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmj
 * JD-Core Version:    0.7.0.1
 */