package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.model.DocumentData.Justification;
import java.io.IOException;

public class DocumentDataParser
  implements ValueParser<DocumentData>
{
  public static final DocumentDataParser INSTANCE = new DocumentDataParser();
  
  public DocumentData parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    String str2 = null;
    String str1 = null;
    double d4 = 0.0D;
    DocumentData.Justification localJustification = DocumentData.Justification.CENTER;
    int m = 0;
    double d3 = 0.0D;
    double d2 = 0.0D;
    int k = 0;
    int j = 0;
    double d1 = 0.0D;
    boolean bool = true;
    paramJsonReader.beginObject();
    label38:
    while (paramJsonReader.hasNext())
    {
      String str3 = paramJsonReader.nextName();
      int i = -1;
      switch (str3.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label38;
          if (str3.equals("t"))
          {
            i = 0;
            continue;
            if (str3.equals("f"))
            {
              i = 1;
              continue;
              if (str3.equals("s"))
              {
                i = 2;
                continue;
                if (str3.equals("j"))
                {
                  i = 3;
                  continue;
                  if (str3.equals("tr"))
                  {
                    i = 4;
                    continue;
                    if (str3.equals("lh"))
                    {
                      i = 5;
                      continue;
                      if (str3.equals("ls"))
                      {
                        i = 6;
                        continue;
                        if (str3.equals("fc"))
                        {
                          i = 7;
                          continue;
                          if (str3.equals("sc"))
                          {
                            i = 8;
                            continue;
                            if (str3.equals("sw"))
                            {
                              i = 9;
                              continue;
                              if (str3.equals("of")) {
                                i = 10;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      str2 = paramJsonReader.nextString();
      continue;
      str1 = paramJsonReader.nextString();
      continue;
      d4 = paramJsonReader.nextDouble();
      continue;
      i = paramJsonReader.nextInt();
      if ((i > DocumentData.Justification.CENTER.ordinal()) || (i < 0))
      {
        localJustification = DocumentData.Justification.CENTER;
      }
      else
      {
        localJustification = DocumentData.Justification.values()[i];
        continue;
        m = paramJsonReader.nextInt();
        continue;
        d3 = paramJsonReader.nextDouble();
        continue;
        d2 = paramJsonReader.nextDouble();
        continue;
        k = JsonUtils.jsonToColor(paramJsonReader);
        continue;
        j = JsonUtils.jsonToColor(paramJsonReader);
        continue;
        d1 = paramJsonReader.nextDouble();
        continue;
        bool = paramJsonReader.nextBoolean();
      }
    }
    paramJsonReader.endObject();
    return new DocumentData(str2, str1, d4, localJustification, m, d3, d2, k, j, d1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.DocumentDataParser
 * JD-Core Version:    0.7.0.1
 */