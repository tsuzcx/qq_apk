import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class acqu
{
  public static int a(MessageRecord paramMessageRecord, int paramInt)
  {
    paramMessageRecord = b(paramMessageRecord);
    int j;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      int i = 0;
      j = i;
      if (!paramMessageRecord.hasNext()) {
        break label62;
      }
      acqu.a locala = (acqu.a)paramMessageRecord.next();
      if (locala.type != paramInt) {
        break label64;
      }
      i = locala.count + i;
    }
    label62:
    label64:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public static List<acqu.a> b(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList;
    String str;
    int j;
    int i;
    if (((paramMessageRecord instanceof MessageForStructing)) && ((((MessageForStructing)paramMessageRecord).structingMsg instanceof AbsShareMsg)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 52))
    {
      paramMessageRecord = (AbsShareMsg)((MessageForStructing)paramMessageRecord).structingMsg;
      localArrayList = new ArrayList();
      Iterator localIterator = paramMessageRecord.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramMessageRecord = (anqu)localIterator.next();
          if (paramMessageRecord != null)
          {
            str = acfp.m(2131706962);
            j = 1;
            if ((paramMessageRecord instanceof ansy))
            {
              i = ((ansy)paramMessageRecord).mBundle.getInt("count");
              j = 1;
              paramMessageRecord = str;
            }
          }
        }
      }
    }
    for (;;)
    {
      localArrayList.add(new acqu.a(paramMessageRecord, j, i));
      break;
      Object localObject = paramMessageRecord.chc;
      if (localObject != null)
      {
        i = j;
        paramMessageRecord = str;
        try
        {
          localObject = new JSONObject((String)localObject);
          i = j;
          paramMessageRecord = str;
          str = ((JSONObject)localObject).getString("giftName");
          i = j;
          paramMessageRecord = str;
          j = ((JSONObject)localObject).getInt("giftType");
          i = j;
          paramMessageRecord = str;
          int k = ((JSONObject)localObject).getInt("giftCount");
          i = k;
          paramMessageRecord = str;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          j = i;
          i = 0;
        }
        continue;
        return localArrayList;
        return null;
      }
      else
      {
        i = 0;
        j = 1;
        paramMessageRecord = localJSONException;
      }
    }
  }
  
  public static class a
  {
    public int count;
    public String name;
    public int type;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.type = paramInt1;
      this.count = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqu
 * JD-Core Version:    0.7.0.1
 */