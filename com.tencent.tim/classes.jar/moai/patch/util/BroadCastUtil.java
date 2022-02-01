package moai.patch.util;

import android.content.Context;
import android.content.Intent;

public class BroadCastUtil
{
  static final String MOAI_PATCH_INTENT_FILTER = "moai.patch.action";
  
  public static void send(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("moai.patch.action");
    localIntent.putExtra(paramString, true);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.util.BroadCastUtil
 * JD-Core Version:    0.7.0.1
 */