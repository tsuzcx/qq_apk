package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.utilities.QMMath;
import java.util.Comparator;
import java.util.HashMap;

class PickSenderViewControl$6
  implements Comparator<AliasItem>
{
  PickSenderViewControl$6(PickSenderViewControl paramPickSenderViewControl) {}
  
  private int calculateAddWeight(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 1)) {
      return 2147483647;
    }
    Integer localInteger = (Integer)PickSenderViewControl.access$800().get(paramArrayOfString[1].toLowerCase());
    if (localInteger == null) {
      return Math.abs(QMMath.hashInt(paramArrayOfString[1].toLowerCase())) + PickSenderViewControl.access$800().size();
    }
    return localInteger.intValue();
  }
  
  private final String[] domainSplit(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.indexOf("@");
    if ((i <= 0) || (i >= paramString.length())) {
      return new String[] { paramString };
    }
    return new String[] { paramString.substring(0, i), paramString.substring(i) };
  }
  
  public int compare(AliasItem paramAliasItem1, AliasItem paramAliasItem2)
  {
    int j = 1;
    paramAliasItem1 = domainSplit(paramAliasItem1.getAlias());
    paramAliasItem2 = domainSplit(paramAliasItem2.getAlias());
    int i;
    if ((paramAliasItem1 == null) || (paramAliasItem1.length <= 1)) {
      i = -1;
    }
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramAliasItem2 == null);
        i = j;
      } while (paramAliasItem2.length <= 1);
      k = calculateAddWeight(paramAliasItem1);
      m = calculateAddWeight(paramAliasItem2);
      if (k == m) {
        return paramAliasItem1[0].compareTo(paramAliasItem2[0]);
      }
      i = j;
    } while (k > m);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickSenderViewControl.6
 * JD-Core Version:    0.7.0.1
 */