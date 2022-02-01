import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import org.json.JSONException;
import org.json.JSONObject;

public class ajpt
{
  private static String bSa;
  private static int[] lV;
  
  public static void MH(String paramString)
  {
    try
    {
      bSa = new JSONObject(paramString).optString("icon");
      return;
    }
    catch (JSONException paramString) {}
  }
  
  /* Error */
  public static void MI(String paramString)
  {
    // Byte code:
    //   0: new 14	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 17	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc 31
    //   10: invokevirtual 35	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +47 -> 62
    //   18: aload_0
    //   19: invokevirtual 41	org/json/JSONArray:length	()I
    //   22: newarray int
    //   24: putstatic 43	ajpt:lV	[I
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: aload_0
    //   31: invokevirtual 41	org/json/JSONArray:length	()I
    //   34: if_icmpge +28 -> 62
    //   37: aload_0
    //   38: iload_1
    //   39: invokevirtual 46	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 52	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   47: istore_2
    //   48: getstatic 43	ajpt:lV	[I
    //   51: iload_1
    //   52: iload_2
    //   53: iastore
    //   54: iload_1
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: goto -29 -> 29
    //   61: astore_0
    //   62: return
    //   63: astore_3
    //   64: goto -10 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramString	String
    //   28	30	1	i	int
    //   47	6	2	j	int
    //   42	2	3	str	String
    //   63	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	61	org/json/JSONException
    //   18	27	61	org/json/JSONException
    //   29	43	61	org/json/JSONException
    //   43	54	61	org/json/JSONException
    //   43	54	63	java/lang/Exception
  }
  
  public static int a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof ansy))
      {
        paramMessageForStructing = (ansy)paramMessageForStructing;
        if (paramMessageForStructing.mBundle.size() > 0)
        {
          paramMessageForStructing = paramMessageForStructing.mBundle.getString("fCount");
          if (!TextUtils.isEmpty(paramMessageForStructing)) {
            return Integer.valueOf(paramMessageForStructing).intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public static boolean aL(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof ChatMessage)) {
      return false;
    }
    paramMessageRecord = (ChatMessage)paramMessageRecord;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && ((paramMessageRecord.structingMsg instanceof AbsShareMsg)) && (paramMessageRecord.structingMsg.mMsgServiceID == 52))
      {
        paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
        if ((paramMessageRecord.getItemCount() <= 0) || (!(paramMessageRecord.getItemByIndex(0) instanceof ansy))) {}
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int[] c(Context paramContext)
  {
    if (lV != null) {
      return lV;
    }
    paramContext = aqmj.bt(paramContext);
    if (paramContext != null) {
      MI(paramContext);
    }
    return lV;
  }
  
  public static String h(MessageForStructing paramMessageForStructing)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof ansy))
      {
        Object localObject = (ansy)paramMessageForStructing;
        if (((ansy)localObject).mBundle.size() > 0)
        {
          paramMessageForStructing = ((ansy)localObject).mBundle.getString("sNick");
          String str = ((ansy)localObject).mBundle.getString("rNick");
          localObject = ((ansy)localObject).mBundle.getString("cMean");
          localStringBuilder.append(paramMessageForStructing).append("送给").append(str).append((String)localObject);
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpt
 * JD-Core Version:    0.7.0.1
 */