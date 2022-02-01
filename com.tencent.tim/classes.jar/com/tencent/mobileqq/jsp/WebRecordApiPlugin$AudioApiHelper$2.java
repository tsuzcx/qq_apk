package com.tencent.mobileqq.jsp;

import aqfe;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class WebRecordApiPlugin$AudioApiHelper$2
  implements Runnable
{
  WebRecordApiPlugin$AudioApiHelper$2(WebRecordApiPlugin.a parama, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(this.bOX);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localObject1.length)
          {
            Object localObject2 = localObject1[i].getName();
            String str = this.bOX + (String)localObject2;
            localObject2 = localObject2.split("\\.")[0];
            Object localObject3 = new SimpleDateFormat("yyyyMMddHHmmssSS");
            try
            {
              localObject2 = ((SimpleDateFormat)localObject3).parse((String)localObject2);
              localObject3 = Calendar.getInstance();
              ((Calendar)localObject3).set(11, 0);
              ((Calendar)localObject3).set(13, 0);
              ((Calendar)localObject3).set(12, 0);
              ((Calendar)localObject3).set(14, 0);
              if (((Date)localObject2).before(((Calendar)localObject3).getTime()))
              {
                localObject1[i].delete();
                aqfe.remove(this.b.i, str);
              }
              i += 1;
            }
            catch (ParseException localParseException)
            {
              for (;;)
              {
                localParseException.printStackTrace();
              }
            }
          }
        }
      }
      long l = System.currentTimeMillis();
      localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
      aqfe.J(this.b.i, "LAST_DELETE_TIME", (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper.2
 * JD-Core Version:    0.7.0.1
 */