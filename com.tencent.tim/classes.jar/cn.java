import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.List;

public class cn
  extends co
{
  public boolean a(List<FileInfo> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramString != null))
    {
      ((acde)paramQQAppInterface.getBusinessHandler(8)).a((ArrayList)paramList, "printer", paramString.getBytes(), Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     cn
 * JD-Core Version:    0.7.0.1
 */