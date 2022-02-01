package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class QQTemplateParser$1
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser.1
 * JD-Core Version:    0.7.0.1
 */