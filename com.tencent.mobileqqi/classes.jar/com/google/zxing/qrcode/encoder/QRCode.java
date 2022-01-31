package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode
{
  public static final int a = 8;
  private ErrorCorrectionLevel jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  private Mode jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode;
  private Version jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion;
  private ByteMatrix jdField_a_of_type_ComGoogleZxingQrcodeEncoderByteMatrix;
  private int b = -1;
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public ErrorCorrectionLevel a()
  {
    return this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  }
  
  public Mode a()
  {
    return this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode;
  }
  
  public Version a()
  {
    return this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion;
  }
  
  public ByteMatrix a()
  {
    return this.jdField_a_of_type_ComGoogleZxingQrcodeEncoderByteMatrix;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel = paramErrorCorrectionLevel;
  }
  
  public void a(Mode paramMode)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode = paramMode;
  }
  
  public void a(Version paramVersion)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion = paramVersion;
  }
  
  public void a(ByteMatrix paramByteMatrix)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeEncoderByteMatrix = paramByteMatrix;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderMode);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.b);
    if (this.jdField_a_of_type_ComGoogleZxingQrcodeEncoderByteMatrix == null) {
      localStringBuilder.append("\n matrix: null\n");
    }
    for (;;)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.jdField_a_of_type_ComGoogleZxingQrcodeEncoderByteMatrix.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.QRCode
 * JD-Core Version:    0.7.0.1
 */