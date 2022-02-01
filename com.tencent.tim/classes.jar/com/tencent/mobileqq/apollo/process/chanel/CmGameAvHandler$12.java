package com.tencent.mobileqq.apollo.process.chanel;

import abmt;
import abnq;
import abns;
import abpc;
import abvy;
import android.text.TextUtils;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import org.json.JSONArray;

public class CmGameAvHandler$12
  implements Runnable
{
  public CmGameAvHandler$12(abnq paramabnq, JSONArray paramJSONArray) {}
  
  public void run()
  {
    if (this.G.length() <= 0)
    {
      abnq.a(this.this$0).clear();
      abvy.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new abns(this));
    }
    for (;;)
    {
      return;
      abnq.a(this.this$0).clear();
      String[] arrayOfString = new String[this.G.length()];
      String str3 = abmt.getAppInterface().getCurrentAccountUin();
      int i = 0;
      while (i < this.G.length())
      {
        try
        {
          abpc localabpc = abmt.a(abnq.a(this.this$0));
          if (localabpc != null)
          {
            String str2 = localabpc.iD(this.G.get(i).toString());
            String str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = localabpc.iB(this.G.get(i).toString());
            }
            arrayOfString[i] = str1;
            abnq.a(this.this$0).add(str1);
            abnq.a(this.this$0, arrayOfString, str3);
          }
        }
        catch (Exception localException)
        {
          label175:
          break label175;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.12
 * JD-Core Version:    0.7.0.1
 */