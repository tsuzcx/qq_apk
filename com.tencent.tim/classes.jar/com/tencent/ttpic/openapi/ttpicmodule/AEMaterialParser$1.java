package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class AEMaterialParser$1
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEMaterialParser.1
 * JD-Core Version:    0.7.0.1
 */