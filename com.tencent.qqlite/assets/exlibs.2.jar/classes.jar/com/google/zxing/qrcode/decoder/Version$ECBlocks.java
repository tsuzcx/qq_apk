package com.google.zxing.qrcode.decoder;

public final class Version$ECBlocks
{
  private final int jdField_a_of_type_Int;
  private final Version.ECB[] jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB;
  
  Version$ECBlocks(int paramInt, Version.ECB... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Version.ECB[] a()
  {
    return this.jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB;
  }
  
  public int b()
  {
    int i = 0;
    Version.ECB[] arrayOfECB = this.jdField_a_of_type_ArrayOfComGoogleZxingQrcodeDecoderVersion$ECB;
    int k = arrayOfECB.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfECB[i].a();
      i += 1;
    }
    return j;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Version.ECBlocks
 * JD-Core Version:    0.7.0.1
 */