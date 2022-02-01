package com.tencent.ttpic.util;

import com.tencent.ttpic.logic.watermark.FFTData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AudioUtil
{
  private static final String TAG = AudioUtil.class.getSimpleName();
  
  public static int byteArrayToInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder()).getInt();
  }
  
  public static short byteArrayToShort(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder()).getShort();
  }
  
  public static void fft(Complex[] paramArrayOfComplex, int paramInt)
  {
    Complex localComplex1 = new Complex();
    new Complex();
    int k = paramInt / 2;
    int j = 1;
    int i = paramInt;
    for (;;)
    {
      i /= 2;
      if (i <= 1) {
        break;
      }
      j += 1;
    }
    int m = 1;
    Complex localComplex2;
    int n;
    for (i = k; m <= paramInt - 2; i = n + i)
    {
      if (m < i)
      {
        localComplex2 = paramArrayOfComplex[i];
        paramArrayOfComplex[i] = paramArrayOfComplex[m];
        paramArrayOfComplex[m] = localComplex2;
      }
      n = i;
      i = k;
      while (n >= i)
      {
        n -= i;
        i /= 2;
      }
      m += 1;
    }
    k = 1;
    while (k <= j)
    {
      n = (int)Math.pow(2.0D, k);
      int i1 = n / 2;
      i = 0;
      while (i < i1)
      {
        double d = 6.283185307179586D / n;
        localComplex1.real = Math.cos(i * d);
        localComplex1.image = (Math.sin(d * i) * -1.0D);
        m = i;
        while (m < paramInt)
        {
          int i2 = m + i1;
          localComplex2 = paramArrayOfComplex[i2].cc(localComplex1);
          paramArrayOfComplex[i2] = paramArrayOfComplex[m].cut(localComplex2);
          paramArrayOfComplex[m] = paramArrayOfComplex[m].sum(localComplex2);
          m += n;
        }
        i += 1;
      }
      k += 1;
    }
  }
  
  public static int getPcmDB16Bit(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = pcm16BitToShort(paramArrayOfByte, paramInt);
    return getPcmDBFromShortBuffer(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int getPcmDB8Bit(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = pcm8BitTo16Bit(paramArrayOfByte, paramInt);
    return getPcmDBFromShortBuffer(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int getPcmDBFromShortBuffer(short[] paramArrayOfShort, int paramInt)
  {
    int j = 0;
    int i = 0;
    double d = 0.0D;
    while (i < paramInt)
    {
      d += Math.abs(paramArrayOfShort[i]);
      i += 1;
    }
    d /= paramInt;
    paramInt = j;
    if (d > 0.0D) {
      paramInt = (int)(20.0D * Math.log10(d));
    }
    return paramInt;
  }
  
  public static void getPcmFFTFromShortBuffer(short[] paramArrayOfShort, int paramInt, FFTData paramFFTData)
  {
    if ((paramInt > FFTData.BUFFER_SIZE) || (paramInt == 0)) {}
    for (;;)
    {
      return;
      int i = up2int(paramInt);
      Complex[] arrayOfComplex = new Complex[i];
      paramInt = 0;
      while (paramInt < i)
      {
        arrayOfComplex[paramInt] = new Complex(Short.valueOf(paramArrayOfShort[paramInt]).doubleValue());
        paramInt += 1;
      }
      fft(arrayOfComplex, i);
      paramFFTData.mFFTSum = 0;
      paramFFTData.mFFTSize = (i / 2);
      i = Math.min(i, paramFFTData.mFFTBuffer.length);
      paramInt = 0;
      while (paramInt < i)
      {
        paramFFTData.mFFTBuffer[paramInt] = arrayOfComplex[paramInt].getIntValue();
        paramFFTData.mFFTSum += paramFFTData.mFFTBuffer[paramInt];
        paramInt += 1;
      }
      paramFFTData.mFFTSum /= 2;
      paramInt = i;
      while (paramInt < paramFFTData.mFFTBuffer.length)
      {
        paramFFTData.mFFTBuffer[paramInt] = 0;
        paramInt += 1;
      }
    }
  }
  
  public static short[] pcm16BitToShort(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt / 2];
    byte[] arrayOfByte = new byte[2];
    int i = 0;
    while (i < paramInt / 2)
    {
      arrayOfByte[0] = paramArrayOfByte[(i * 2)];
      arrayOfByte[1] = paramArrayOfByte[(i * 2 + 1)];
      arrayOfShort[i] = byteArrayToShort(arrayOfByte);
      i += 1;
    }
    return arrayOfShort;
  }
  
  private static short[] pcm8BitTo16Bit(byte[] paramArrayOfByte, int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[i] - 128 << 8));
      i += 1;
    }
    return arrayOfShort;
  }
  
  private static int up2int(int paramInt)
  {
    int i = 1;
    while (i <= paramInt) {
      i <<= 1;
    }
    return i >> 1;
  }
  
  static class Complex
  {
    public double image;
    public double real;
    
    public Complex()
    {
      this.real = 0.0D;
      this.image = 0.0D;
    }
    
    public Complex(double paramDouble)
    {
      this.real = paramDouble;
      this.image = 0.0D;
    }
    
    public Complex(double paramDouble1, double paramDouble2)
    {
      this.real = paramDouble1;
      this.image = paramDouble2;
    }
    
    public Complex(int paramInt1, int paramInt2)
    {
      this.real = Integer.valueOf(paramInt1).floatValue();
      this.image = Integer.valueOf(paramInt2).floatValue();
    }
    
    public Complex cc(Complex paramComplex)
    {
      Complex localComplex = new Complex();
      localComplex.real = (this.real * paramComplex.real - this.image * paramComplex.image);
      localComplex.image = (this.real * paramComplex.image + this.image * paramComplex.real);
      return localComplex;
    }
    
    public Complex cut(Complex paramComplex)
    {
      Complex localComplex = new Complex();
      this.real -= paramComplex.real;
      this.image -= paramComplex.image;
      return localComplex;
    }
    
    public int getIntValue()
    {
      return (int)Math.round(Math.sqrt(this.real * this.real - this.image * this.image));
    }
    
    public Complex sum(Complex paramComplex)
    {
      Complex localComplex = new Complex();
      this.real += paramComplex.real;
      this.image += paramComplex.image;
      return localComplex;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtil
 * JD-Core Version:    0.7.0.1
 */