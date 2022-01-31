import android.os.AsyncTask;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.List;

public class bo
  extends AsyncTask
{
  public bo(LiteActivity paramLiteActivity, ArrayList paramArrayList) {}
  
  private DataLineMsgRecord a(DataLineHandler paramDataLineHandler, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramDataLineHandler = paramEFILETYPE;
    if (paramEFILETYPE == DataLineHandler.EFILETYPE.FILE_TYPE_FILE) {
      switch (FileManagerUtil.a(paramString))
      {
      default: 
        paramDataLineHandler = DataLineHandler.EFILETYPE.FILE_TYPE_FILE;
      }
    }
    for (;;)
    {
      paramEFILETYPE = new DataLineMsgRecord();
      paramEFILETYPE.msgtype = DataLineHandler.a(paramDataLineHandler);
      paramEFILETYPE.sessionid = 0L;
      paramEFILETYPE.path = paramString;
      paramEFILETYPE.thumbPath = null;
      paramEFILETYPE.groupId = paramInt1;
      paramEFILETYPE.groupSize = paramInt2;
      paramEFILETYPE.groupIndex = paramInt3;
      return paramEFILETYPE;
      paramDataLineHandler = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;
      continue;
      paramDataLineHandler = DataLineHandler.EFILETYPE.FILE_TYPE_AUDIO;
      continue;
      paramDataLineHandler = DataLineHandler.EFILETYPE.FILE_TYPE_VIDEO;
    }
  }
  
  private void a(List paramList, DataLineHandler.EFILETYPE paramEFILETYPE)
  {
    if (paramList == null) {}
    DataLineHandler localDataLineHandler;
    int j;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a(8);
      j = paramList.size();
      if (j > 5) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject = a(localDataLineHandler, (String)paramList.get(i), paramEFILETYPE, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label117:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((j > 5) && (j < 50))
    {
      localObject = new ArrayList();
      int k = localDataLineHandler.a();
      i = 0;
      if (i < j)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramEFILETYPE, k, j, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramEFILETYPE, k)) {
          break label398;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label395:
    label398:
    for (;;)
    {
      i += 1;
      break label117;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      j = localDataLineHandler.a();
      i = 0;
      label254:
      if (i < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramEFILETYPE, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramEFILETYPE, j)) {
          break label395;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label254;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
  
  protected String a(DataLineHandler.EFILETYPE... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    a(this.jdField_a_of_type_JavaUtilArrayList, paramVarArgs);
    return null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bo
 * JD-Core Version:    0.7.0.1
 */