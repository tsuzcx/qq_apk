package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.content.MergePaths;
import com.tencent.mobileqq.dinifly.model.content.MergePaths.MergePathsMode;
import java.io.IOException;

class MergePathsParser
{
  static MergePaths parse(JsonReader paramJsonReader)
    throws IOException
  {
    MergePaths.MergePathsMode localMergePathsMode = null;
    boolean bool = false;
    String str1 = null;
    label7:
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      switch (str2.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label7;
          if (str2.equals("nm"))
          {
            i = 0;
            continue;
            if (str2.equals("mm"))
            {
              i = 1;
              continue;
              if (str2.equals("hd")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      str1 = paramJsonReader.nextString();
      continue;
      localMergePathsMode = MergePaths.MergePathsMode.forId(paramJsonReader.nextInt());
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    return new MergePaths(str1, localMergePathsMode, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.MergePathsParser
 * JD-Core Version:    0.7.0.1
 */