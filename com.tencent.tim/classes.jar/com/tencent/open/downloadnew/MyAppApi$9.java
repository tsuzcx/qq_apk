package com.tencent.open.downloadnew;

import android.content.Context;
import arzk;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.ArrayList;

public class MyAppApi$9
  implements Runnable
{
  public MyAppApi$9(arzk paramarzk, Context paramContext, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void run()
  {
    TMAssistantCallYYB_V2.getInstance().startBatchOperation(this.val$context, this.DD, this.elq, this.cCm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.9
 * JD-Core Version:    0.7.0.1
 */