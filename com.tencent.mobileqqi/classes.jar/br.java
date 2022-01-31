import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.List;

public class br
  extends AsyncTask
{
  private br(LiteActivity paramLiteActivity) {}
  
  private DataLineMsgRecord a(DataLineHandler paramDataLineHandler, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDataLineHandler = new DataLineMsgRecord();
    paramDataLineHandler.thumbPath = null;
    paramDataLineHandler.path = paramString;
    paramDataLineHandler.msgtype = -2000;
    paramDataLineHandler.sessionid = 0L;
    paramDataLineHandler.groupId = paramInt2;
    paramDataLineHandler.groupSize = paramInt3;
    paramDataLineHandler.groupIndex = paramInt4;
    return paramDataLineHandler;
  }
  
  private void a(List paramList, boolean paramBoolean, int paramInt)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.b.a(8);
    for (;;)
    {
      int j = paramList.size();
      if (j <= 5)
      {
        i = 0;
        while (i < j)
        {
          localDataLineHandler.a(a(localDataLineHandler, (String)paramList.get(i), paramBoolean, paramInt, 0, 0, 0), false);
          i += 1;
        }
      }
      if ((j > 5) && (j < 50))
      {
        localArrayList = new ArrayList();
        int k = localDataLineHandler.a();
        i = 0;
        while (i < j)
        {
          localArrayList.add(a(localDataLineHandler, (String)paramList.get(i), paramBoolean, paramInt, k, j, i));
          i += 1;
        }
        DataLineReportUtil.n(this.a.b);
        localDataLineHandler.a(localArrayList, false);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      j = localDataLineHandler.a();
      int i = 0;
      while (i < 50)
      {
        localArrayList.add(a(localDataLineHandler, (String)paramList.get(i), paramBoolean, paramInt, j, 50, i));
        i += 1;
      }
      DataLineReportUtil.n(this.a.b);
      localDataLineHandler.a(localArrayList, false);
      i = 0;
      while (i < 50)
      {
        paramList.remove(0);
        i += 1;
      }
    }
  }
  
  protected String a(Intent... paramVarArgs)
  {
    boolean bool = true;
    ArrayList localArrayList = paramVarArgs[0].getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int i = paramVarArgs[0].getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    if (i == 1) {}
    while (localArrayList == null)
    {
      return null;
      bool = false;
    }
    a(localArrayList, bool, i);
    return null;
  }
  
  protected void a(String paramString)
  {
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     br
 * JD-Core Version:    0.7.0.1
 */