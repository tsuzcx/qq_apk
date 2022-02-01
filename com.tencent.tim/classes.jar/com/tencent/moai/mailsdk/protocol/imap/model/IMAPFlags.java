package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.protocol.model.Flags.Flag;
import java.util.ArrayList;

public class IMAPFlags
  extends Flags
  implements IMAPFetchItem
{
  static final char[] name = { 70, 76, 65, 71, 83 };
  
  public IMAPFlags() {}
  
  public IMAPFlags(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    paramIMAPResponse = paramIMAPResponse.readSimpleList();
    if (paramIMAPResponse != null)
    {
      int i = 0;
      if (i < paramIMAPResponse.size())
      {
        String str = (String)paramIMAPResponse.get(i);
        if ((str.length() >= 2) && (str.charAt(0) == '\\')) {
          switch (Character.toUpperCase(str.charAt(1)))
          {
          default: 
            add(str);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          add(Flags.Flag.SEEN);
          continue;
          add(Flags.Flag.RECENT);
          continue;
          if (str.length() >= 3)
          {
            int j = str.charAt(2);
            if ((j == 101) || (j == 69)) {
              add(Flags.Flag.DELETED);
            } else if ((j == 114) || (j == 82)) {
              add(Flags.Flag.DRAFT);
            }
          }
          else
          {
            add(str);
            continue;
            add(Flags.Flag.ANSWERED);
            continue;
            add(Flags.Flag.FLAGGED);
            continue;
            add(Flags.Flag.USER);
            continue;
            add(str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPFlags
 * JD-Core Version:    0.7.0.1
 */