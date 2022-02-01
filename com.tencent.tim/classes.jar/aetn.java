import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aetn
{
  private boolean bWk;
  private boolean bWl;
  
  public static aetn a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aetn localaetn = new aetn();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfaeic.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfaeic[i].content);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfaeic = new HashMap();
      i = 0;
      if (i < localArrayList.size())
      {
        Object localObject = (String)localArrayList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs |type: 294,content: " + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((String)localObject).split("=");
          if (localObject.length == 2)
          {
            if (!TextUtils.isEmpty(localObject[1])) {
              localObject[1] = localObject[1].trim();
            }
            paramArrayOfaeic.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localaetn.bWk = "1".equals(paramArrayOfaeic.get("enable_tencent_docs_assistant"));
      localaetn.bWl = "1".equals(paramArrayOfaeic.get("preload_tool_process"));
      paramArrayOfaeic = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfaeic instanceof QQAppInterface))
      {
        paramArrayOfaeic = (QQAppInterface)paramArrayOfaeic;
        aobw.W(paramArrayOfaeic, localaetn.bWl);
        aobw.V(paramArrayOfaeic, localaetn.bWk);
      }
    }
    for (;;)
    {
      return localaetn;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs|type: 294,content_list is empty ");
      }
    }
  }
  
  public boolean ahP()
  {
    return this.bWk;
  }
  
  public boolean ahQ()
  {
    return this.bWl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetn
 * JD-Core Version:    0.7.0.1
 */