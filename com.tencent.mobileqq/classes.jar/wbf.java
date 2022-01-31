import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Random;

public class wbf
{
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final double[][] jdField_a_of_type_Array2dOfDouble;
  private static final double[] jdField_b_of_type_ArrayOfDouble;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int[] jdField_c_of_type_ArrayOfInt;
  private double jdField_a_of_type_Double = 150.0D;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private ByteOrder jdField_a_of_type_JavaNioByteOrder = ByteOrder.LITTLE_ENDIAN;
  private wbg jdField_a_of_type_Wbg = new wbg();
  private double[] jdField_a_of_type_ArrayOfDouble;
  private double jdField_b_of_type_Double = 200.0D;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private double[][] jdField_b_of_type_Array2dOfDouble;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  private int g;
  
  static
  {
    if (!wbf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_ArrayOfInt = new int[] { 0, 48000, 44100, 37800, 32000, 22050, 48000, 44100 };
      jdField_b_of_type_ArrayOfInt = new int[] { 1, 16, 20, 16, 16, 15, 16, 15 };
      jdField_c_of_type_ArrayOfInt = new int[] { 8, 18, 27, 8, 8, 8, 10, 9 };
      double[] arrayOfDouble1 = { -1.0D };
      double[] arrayOfDouble2 = { -2.87207293510437D, 5.041323184967041D, -6.244299411773682D, 5.848398685455322D, -3.706754207611084D, 1.049511909484863D, 1.183023691177368D, -2.112679243087769D, 1.90945315361023D, -0.9991308450698853D, 0.1709080636501312D, 0.3261560201644898D, -0.3912764489650726D, 0.2687646150588989D, -0.0976761057972908D, 0.02347384579479694D };
      double[] arrayOfDouble3 = { -1.633599281311035D, 2.261549234390259D, -2.407702922821045D, 2.634171724319458D, -2.144036293029785D, 1.815325856208801D, -1.08162248134613D, 0.7030265331268311D, -0.1599199324846268D, -0.04154951870441437D, 0.2941657602787018D, -0.2518316805362701D, 0.2776647806167603D, -0.1578540354967117D, 0.1016589403152466D, -0.01683389209210873D };
      double[] arrayOfDouble4 = { -0.8290129899978638D, 0.989226579666138D, -0.5982571244239807D, 1.002880930900574D, -0.5993821620941162D, 0.7950245141983032D, -0.4272331595420837D, 0.544925272464752D, -0.3079260587692261D, 0.3687179982662201D, -0.187920480966568D, 0.2261127084493637D, -0.1057334169745445D, 0.1143549084663391D, -0.038800679147244D, 0.0408421978354454D };
      double[] arrayOfDouble5 = { -0.06522997468709946D, 0.5498126149177551D, 0.4027854800224304D, 0.3178376853466034D, 0.2820179760456085D, 0.1698519438505173D, 0.1543336361646652D, 0.1250714063644409D, 0.08903945237398148D, 0.06441012024879456D, 0.04714600369334221D, 0.03280523791909218D, 0.02849519439041615D, 0.01169500593096018D, 0.01183183863759041D };
      double[] arrayOfDouble6 = { -2.392577409744263D, 3.435029745101929D, -3.185370922088623D, 1.811727166175842D, 0.2012477070093155D, -1.475990772247315D, 1.721090435981751D, -0.9774670004844666D, 0.1379013806581497D, 0.3818590342998505D, -0.2742124199867249D, -0.06658421456813812D, 0.3522330224514008D, -0.376723438501358D, 0.2396427690982819D, -0.06867482513189316D };
      jdField_a_of_type_Array2dOfDouble = new double[][] { arrayOfDouble1, arrayOfDouble2, { -2.677319765090942D, 4.830892562866211D, -6.570110321044922D, 7.457201480865479D, -6.726327419281006D, 4.848165035247803D, -2.041208982467651D, -0.7006359100341797D, 2.95375657081604D, -4.080038547515869D, 4.184521675109863D, -3.331181287765503D, 2.117992639541626D, -0.879302978515625D, 0.03175914660096169D, 0.423827886581421D, -0.478821039199829D, 0.3549081385135651D, -0.1749683916568756D, 0.060908168554306D }, arrayOfDouble3, arrayOfDouble4, arrayOfDouble5, arrayOfDouble6, { -2.083391666412354D, 3.041845083236694D, -3.204789876937866D, 2.757192611694336D, -1.497863054275513D, 0.3427594602108002D, 0.7173374891281128D, -1.073705792427063D, 1.022581577301025D, -0.5664999485015869D, 0.2096869200468063D, 0.06537853181362152D, -0.1032243818044663D, 0.06744202226400375D, 0.00495197344571352D } };
      jdField_b_of_type_ArrayOfDouble = new double[] { 0.7D, 0.9D, 0.18D };
      return;
    }
  }
  
  public wbf() {}
  
  public wbf(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, boolean paramBoolean)
  {
    double[] arrayOfDouble = new double[1];
    arrayOfDouble[0] = 0.0D;
    if ((paramInt7 < 0) || (paramInt7 > 4)) {
      throw new IllegalArgumentException("unrecognized dither type : " + paramInt7);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!this.jdField_b_of_type_Boolean) {
      System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
    }
    if ((paramInt3 != 1) && (paramInt3 != 2) && (paramInt3 != 3) && (paramInt3 != 4)) {
      throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
    }
    int i;
    if (paramInt4 == -1) {
      if (paramInt3 != 1)
      {
        i = paramInt3;
        paramInt4 = i;
        if (i == 4) {
          paramInt4 = 3;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 == -1) {}
      for (int j = paramInt1;; j = paramInt2)
      {
        if (paramInt7 == -1) {
          if (paramInt4 < paramInt3) {
            if (paramInt4 == 1) {
              paramInt2 = 4;
            }
          }
        }
        for (;;)
        {
          label213:
          if (!this.jdField_b_of_type_Boolean)
          {
            System.err.printf("frequency : %d -> %d\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
            System.err.printf("attenuation : %gdB\n", new Object[] { Double.valueOf(paramDouble) });
            System.err.printf("bits per sample : %d -> %d\n", new Object[] { Integer.valueOf(paramInt3 * 8), Integer.valueOf(paramInt4 * 8) });
            System.err.printf("nchannels : %d\n", new Object[] { Integer.valueOf(paramInt5) });
            System.err.printf("length : %d bytes, %g secs\n", new Object[] { Integer.valueOf(paramInt6), Double.valueOf(paramInt6 / paramInt3 / paramInt5 / paramInt1) });
            if (paramInt2 == 0)
            {
              System.err.printf("dither type : none\n", new Object[0]);
              System.err.printf("\n", new Object[0]);
            }
          }
          else
          {
            if (paramInt2 != 0)
            {
              i = 0;
              paramInt7 = 0;
              if (paramInt4 == 1)
              {
                i = -128;
                paramInt7 = 127;
              }
              if (paramInt4 == 2)
              {
                i = -32768;
                paramInt7 = 32767;
              }
              if (paramInt4 == 3)
              {
                i = -8388608;
                paramInt7 = 8388607;
              }
              if (paramInt4 == 4)
              {
                i = -2147483648;
                paramInt7 = 2147483647;
              }
              a(j, paramInt5, i, paramInt7, paramInt2, 0, 0.18D);
            }
            if (paramInt1 >= j) {
              break label736;
            }
            arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, paramInt4, paramInt1, j, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
          }
          for (;;)
          {
            label390:
            if (!this.jdField_b_of_type_Boolean) {
              System.err.printf("\n", new Object[0]);
            }
            if (paramInt2 != 0) {
              a(paramInt5);
            }
            if ((arrayOfDouble[0] > 1.0D) && (!this.jdField_b_of_type_Boolean)) {
              System.err.printf("clipping detected : %gdB\n", new Object[] { Double.valueOf(20.0D * Math.log10(arrayOfDouble[0])) });
            }
            return;
            i = 2;
            break;
            paramInt2 = 3;
            break label213;
            paramInt2 = 1;
            break label213;
            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", new Object[] { new String[] { "none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)" }[paramInt2], new String[] { "rectangular", "triangular", "gaussian" }[0], Double.valueOf(0.18D) });
            break label390;
            label736:
            if (paramInt1 > j) {
              arrayOfDouble[0] = b(paramInputStream, paramOutputStream, paramInt5, paramInt3, paramInt4, paramInt1, j, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
            } else {
              arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, paramInt4, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
            }
          }
          paramInt2 = paramInt7;
        }
      }
    }
  }
  
  private double a(double paramDouble)
  {
    if (paramDouble <= 21.0D) {
      return 0.0D;
    }
    if (paramDouble <= 50.0D) {
      return 0.5842000000000001D * Math.pow(paramDouble - 21.0D, 0.4D) + 0.07886D * (paramDouble - 21.0D);
    }
    return 0.1102D * (paramDouble - 8.699999999999999D);
  }
  
  private double a(double paramDouble1, int paramInt, double paramDouble2, double paramDouble3)
  {
    return wbe.a(Math.sqrt(1.0D - 4.0D * paramDouble1 * paramDouble1 / ((paramInt - 1.0D) * (paramInt - 1.0D))) * paramDouble2) / paramDouble3;
  }
  
  private double a(int paramInt, double paramDouble1, double paramDouble2)
  {
    paramDouble2 = 1.0D / paramDouble2;
    return b(paramDouble2 * (6.283185307179586D * paramDouble1 * paramInt)) * (2.0D * paramDouble1 * paramDouble2);
  }
  
  private int a(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      return (int)(paramDouble + 0.5D);
    }
    return (int)(paramDouble - 0.5D);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 == 0) {
        break;
      }
      paramInt1 = paramInt2;
      paramInt2 = i % paramInt2;
    }
    return i;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.g = -1;
  }
  
  private void a(double paramDouble)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (paramDouble == 0.0D) {}
    for (int i = 0;; i = (int)(l * (1.0D - paramDouble) / paramDouble))
    {
      int j = (int)(100.0D * paramDouble);
      if ((j != this.g) || (l != this.jdField_b_of_type_Long))
      {
        System.err.printf(" %3d%% processed", new Object[] { Integer.valueOf(j) });
        this.g = j;
      }
      if (l != this.jdField_b_of_type_Long)
      {
        System.err.printf(", ETA =%4dmsec", new Object[] { Integer.valueOf(i) });
        this.jdField_b_of_type_Long = l;
      }
      System.err.printf("\r", new Object[0]);
      System.err.flush();
      return;
    }
  }
  
  private void a(int paramInt) {}
  
  private double b(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 1.0D;
    }
    return Math.sin(paramDouble) / paramDouble;
  }
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    double[] arrayOfDouble = new double[1];
    arrayOfDouble[0] = 0.0D;
    int i = 0;
    a();
    ByteBuffer localByteBuffer = null;
    if (paramBoolean) {
      localByteBuffer = ByteBuffer.allocate(8);
    }
    Object localObject = ByteBuffer.allocate(4);
    int j = 0;
    double d2;
    for (;;)
    {
      if (j < paramInt4 * paramInt1)
      {
        d1 = 0.0D;
        switch (paramInt2)
        {
        }
      }
      while (paramInputStream.available() == 0)
      {
        a(1.0D);
        return arrayOfDouble[0];
        ((ByteBuffer)localObject).position(0);
        ((ByteBuffer)localObject).limit(1);
        localObject = new byte[((ByteBuffer)localObject).limit()];
        paramInputStream.read((byte[])localObject);
        localObject = ByteBuffer.wrap((byte[])localObject);
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).limit());
        ((ByteBuffer)localObject).flip();
        d1 = 0.0078740157480315D * (((ByteBuffer)localObject).get(0) - 128);
        continue;
        ((ByteBuffer)localObject).position(0);
        ((ByteBuffer)localObject).limit(2);
        localObject = new byte[((ByteBuffer)localObject).limit()];
        paramInputStream.read((byte[])localObject);
        localObject = ByteBuffer.wrap((byte[])localObject);
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).limit());
        ((ByteBuffer)localObject).flip();
        d1 = ((ByteBuffer)localObject).order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().get(0) * 3.051850947599719E-005D;
        continue;
        ((ByteBuffer)localObject).position(0);
        ((ByteBuffer)localObject).limit(3);
        localObject = new byte[((ByteBuffer)localObject).limit()];
        paramInputStream.read((byte[])localObject);
        localObject = ByteBuffer.wrap((byte[])localObject);
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).limit());
        ((ByteBuffer)localObject).flip();
        d1 = 1.192093037616377E-007D * ((((ByteBuffer)localObject).get(0) & 0xFF) << 0 | (((ByteBuffer)localObject).get(1) & 0xFF) << 8 | (((ByteBuffer)localObject).get(2) & 0xFF) << 16);
        continue;
        ((ByteBuffer)localObject).position(0);
        ((ByteBuffer)localObject).limit(4);
        localObject = new byte[((ByteBuffer)localObject).limit()];
        paramInputStream.read((byte[])localObject);
        localObject = ByteBuffer.wrap((byte[])localObject);
        ((ByteBuffer)localObject).position(((ByteBuffer)localObject).limit());
        ((ByteBuffer)localObject).flip();
        d1 = ((ByteBuffer)localObject).order(this.jdField_a_of_type_JavaNioByteOrder).asIntBuffer().get(0) * 4.656612875245797E-010D;
      }
      d2 = d1 * paramDouble;
      if (paramBoolean) {
        break;
      }
      switch (paramInt3)
      {
      default: 
        k = i + 1;
        i = k;
        if (k == paramInt1) {
          i = 0;
        }
        j += 1;
        if ((0x3FFFF & j) == 0) {
          a(j / (paramInt4 * paramInt1));
        }
        break;
      }
    }
    double d1 = 127.0D * d2;
    if (paramInt5 != 0) {}
    for (int k = a(d1, arrayOfDouble, paramInt5, i);; k = a(d1))
    {
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).limit(1);
      ((ByteBuffer)localObject).put(0, (byte)(k + 128));
      ((ByteBuffer)localObject).flip();
      a(paramOutputStream, (ByteBuffer)localObject);
      break;
    }
    d1 = 32767.0D * d2;
    if (paramInt5 != 0) {}
    for (k = a(d1, arrayOfDouble, paramInt5, i);; k = a(d1))
    {
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).limit(2);
      ((ByteBuffer)localObject).asShortBuffer().put(0, (short)k);
      ((ByteBuffer)localObject).flip();
      a(paramOutputStream, (ByteBuffer)localObject);
      break;
    }
    d1 = 8388607.0D * d2;
    if (paramInt5 != 0) {}
    for (k = a(d1, arrayOfDouble, paramInt5, i);; k = a(d1))
    {
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).limit(3);
      ((ByteBuffer)localObject).put(0, (byte)(k & 0xFF));
      k >>= 8;
      ((ByteBuffer)localObject).put(1, (byte)(k & 0xFF));
      ((ByteBuffer)localObject).put(2, (byte)(k >> 8 & 0xFF));
      ((ByteBuffer)localObject).flip();
      a(paramOutputStream, (ByteBuffer)localObject);
      break;
    }
    if (d2 > 0.0D)
    {
      d1 = d2;
      label824:
      if (arrayOfDouble[0] >= d1) {
        break label879;
      }
    }
    for (;;)
    {
      arrayOfDouble[0] = d1;
      localByteBuffer.position(0);
      localByteBuffer.putDouble(d2);
      localByteBuffer.flip();
      a(paramOutputStream, localByteBuffer);
      break;
      d1 = -d2;
      break label824;
      label879:
      d1 = arrayOfDouble[0];
    }
  }
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    double[] arrayOfDouble1 = new double[1];
    arrayOfDouble1[0] = 0.0D;
    int i5 = 0;
    int i1 = this.jdField_a_of_type_Int;
    double d4 = this.jdField_a_of_type_Double;
    int i13 = a(paramInt4, paramInt5);
    int i14 = paramInt4 / i13 * paramInt5;
    int n;
    double d5;
    double d3;
    if (i14 / paramInt5 == 1)
    {
      n = 1;
      d5 = (paramInt5 * n / 2 - paramInt4 / 2) * 2 / 2.0D;
      d2 = paramInt4 / 2;
      d3 = (paramInt5 * n / 2 - paramInt4 / 2) / 2.0D;
      if (d4 > 21.0D) {
        break label360;
      }
    }
    int i15;
    int i16;
    int[] arrayOfInt1;
    label360:
    for (double d1 = 0.9222D;; d1 = (d4 - 7.95D) / 14.359999999999999D)
    {
      i = (int)(d1 * (i14 / d5) + 1.0D);
      j = i;
      if (i % 2 == 0) {
        j = i + 1;
      }
      d1 = a(d4);
      d4 = wbe.a(d1);
      i15 = i14 / paramInt4;
      i16 = j / i15 + 1;
      arrayOfInt1 = new int[i15 * n];
      i = 0;
      while (i < i15 * n)
      {
        arrayOfInt1[i] = (i14 / paramInt4 - i14 / (paramInt5 * n) * i % (i14 / paramInt4));
        if (arrayOfInt1[i] == i14 / paramInt4) {
          arrayOfInt1[i] = 0;
        }
        i += 1;
      }
      if (i14 / paramInt5 % 2 == 0)
      {
        n = 2;
        break;
      }
      if (i14 / paramInt5 % 3 == 0)
      {
        n = 3;
        break;
      }
      throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(i14 / paramInt5) }));
    }
    int[] arrayOfInt2 = new int[i15 * n];
    int i = 0;
    if (i < i15 * n)
    {
      if (arrayOfInt1[i] < i14 / (paramInt5 * n)) {}
      for (k = paramInt1;; k = 0)
      {
        arrayOfInt2[i] = k;
        if (arrayOfInt1[i] == i14 / paramInt4) {
          arrayOfInt1[i] = 0;
        }
        i += 1;
        break;
      }
    }
    double[][] arrayOfDouble2 = (double[][])Array.newInstance(Double.TYPE, new int[] { i15, i16 });
    i = -(j / 2);
    while (i <= j / 2)
    {
      arrayOfDouble2[((j / 2 + i) % i15)][((j / 2 + i) / i15)] = (a(i, j, d1, d4) * a(i, d2 + d3, i14) * i14 / paramInt4);
      i += 1;
    }
    double d2 = this.jdField_a_of_type_Double;
    if (d2 <= 21.0D)
    {
      d1 = 0.9222D;
      i2 = paramInt5 * n;
      i = 1;
    }
    for (;;)
    {
      m = i1 * i;
      k = m;
      if (m % 2 == 0) {
        k = m - 1;
      }
      d4 = i2 * d1 / (k - 1);
      d3 = paramInt4 / 2;
      if (d4 < this.jdField_b_of_type_Double)
      {
        d1 = a(d2);
        d2 = wbe.a(d1);
        i = 1;
        while (i < k) {
          i *= 2;
        }
        d1 = (d2 - 7.95D) / 14.359999999999999D;
        break;
      }
      i *= 2;
    }
    int i17 = i * 2;
    double[] arrayOfDouble3 = new double[i17];
    i = -(k / 2);
    while (i <= k / 2)
    {
      arrayOfDouble3[(k / 2 + i)] = (a(i, k, d1, d2) * a(i, d3, i2) / i17 * 2.0D);
      i += 1;
    }
    int[] arrayOfInt3 = new int[(int)(2.0D + Math.sqrt(i17))];
    arrayOfInt3[0] = 0;
    double[] arrayOfDouble4 = new double[i17 / 2];
    this.jdField_a_of_type_Wbg.a(i17, 1, arrayOfDouble3, arrayOfInt3, arrayOfDouble4);
    a();
    int i11 = i17 / 2;
    int m = i11 / n;
    double[][] arrayOfDouble5 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, m + 1 });
    double[][] arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, i17 });
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate((i11 + i16 + 2) * paramInt1 * paramInt2);
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate((i11 / n + 1) * paramInt1 * paramInt3);
    double[] arrayOfDouble7 = new double[(i11 + i16 + 2) * paramInt1];
    double[] arrayOfDouble8 = new double[(i11 / n + 1) * paramInt1];
    m = j / 2 / (i14 / paramInt4);
    int j = (int)(k / 2.0D / (i2 / paramInt5));
    int i4 = 0;
    i1 = 1;
    int i7 = m + 1;
    int i2 = 0;
    m = 0;
    int k = 0;
    int i8 = 0;
    int i3 = 0;
    int i6 = paramInt6;
    paramInt6 = i;
    i = i1;
    i1 = i3;
    int i9 = (int)(Math.ceil(i11 * paramInt4 / (paramInt5 * n)) + 1.0D + i16 - i7);
    if (i9 + i4 > i6) {}
    label2181:
    label3846:
    for (i3 = i6 - i4;; i3 = i9)
    {
      localByteBuffer1.position(0);
      localByteBuffer1.limit(i3 * (paramInt2 * paramInt1));
      byte[] arrayOfByte = new byte[localByteBuffer1.limit()];
      int i10 = paramInputStream.read(arrayOfByte);
      i3 = i10;
      if (i10 < 0) {
        i3 = 0;
      }
      if (i3 < localByteBuffer1.limit()) {
        i6 = i4 + i3 / paramInt2 * paramInt1;
      }
      localByteBuffer1.limit(i3);
      localByteBuffer1 = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer1.position(i3);
      localByteBuffer1.flip();
      i10 = i3 / (paramInt2 * paramInt1);
      switch (paramInt2)
      {
      }
      while (paramInt6 < paramInt1 * i9)
      {
        arrayOfDouble7[(paramInt1 * i7 + paramInt6)] = 0.0D;
        paramInt6 += 1;
        continue;
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i10 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i7 + i3)] = (0.0078740157480315D * (localByteBuffer1.get(i3) - 128.0D));
          i3 += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i10 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i7 + i3)] = (3.051850947599719E-005D * localByteBuffer1.order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().get(i3));
          i3 += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i10 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i7 + i3)] = (1.192093037616377E-007D * (localByteBuffer1.get(i3 * 3) << 0 | localByteBuffer1.get(i3 * 3 + 1) << 8 | localByteBuffer1.get(i3 * 3 + 2) << 16));
          i3 += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i10 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i7 + i3)] = (4.656612875245797E-010D * localByteBuffer1.order(this.jdField_a_of_type_JavaNioByteOrder).asIntBuffer().get(i3));
          i3 += 1;
        }
      }
      int i18 = i7 + i9;
      int i12 = i10 + i4;
      int i19;
      if (i12 >= i6)
      {
        i7 = 1;
        i19 = ((i8 - 1) * paramInt4 + i14) / i14;
        i9 = 0;
        i4 = k;
        i3 = m;
      }
      for (;;)
      {
        if (i9 >= paramInt1) {
          break label2586;
        }
        int i20 = i15 * n;
        i3 = i19 * paramInt1 + i9;
        switch (i16)
        {
        case 8: 
        default: 
          i4 = 0;
          i2 = k;
        }
        for (;;)
        {
          paramInt6 = i2;
          if (i4 >= i11) {
            break label2181;
          }
          d1 = 0.0D;
          int i21 = arrayOfInt1[i2];
          paramInt6 = 0;
          i10 = i3;
          for (;;)
          {
            if (paramInt6 < i16)
            {
              d1 += arrayOfDouble2[i21][paramInt6] * arrayOfDouble7[i10];
              i10 += paramInt1;
              paramInt6 += 1;
              continue;
              i7 = 0;
              break;
              paramInt6 = 0;
              i2 = k;
              i4 = i3;
              i3 = paramInt6;
              for (;;)
              {
                paramInt6 = i2;
                if (i3 >= i11) {
                  break;
                }
                paramInt6 = arrayOfInt1[i2];
                arrayOfDouble6[i9][i3] = (arrayOfDouble2[paramInt6][0] * arrayOfDouble7[(paramInt1 * 0 + i4)] + arrayOfDouble2[paramInt6][1] * arrayOfDouble7[(paramInt1 * 1 + i4)] + arrayOfDouble2[paramInt6][2] * arrayOfDouble7[(paramInt1 * 2 + i4)] + arrayOfDouble2[paramInt6][3] * arrayOfDouble7[(paramInt1 * 3 + i4)] + arrayOfDouble2[paramInt6][4] * arrayOfDouble7[(paramInt1 * 4 + i4)] + arrayOfDouble2[paramInt6][5] * arrayOfDouble7[(paramInt1 * 5 + i4)] + arrayOfDouble2[paramInt6][6] * arrayOfDouble7[(paramInt1 * 6 + i4)]);
                i4 += arrayOfInt2[i2];
                paramInt6 = i2 + 1;
                i2 = paramInt6;
                if (paramInt6 == i20) {
                  i2 = 0;
                }
                i3 += 1;
              }
              paramInt6 = 0;
              i2 = k;
              i4 = i3;
              i3 = paramInt6;
              for (;;)
              {
                paramInt6 = i2;
                if (i3 >= i11) {
                  break;
                }
                paramInt6 = arrayOfInt1[i2];
                arrayOfDouble6[i9][i3] = (arrayOfDouble2[paramInt6][0] * arrayOfDouble7[(paramInt1 * 0 + i4)] + arrayOfDouble2[paramInt6][1] * arrayOfDouble7[(paramInt1 * 1 + i4)] + arrayOfDouble2[paramInt6][2] * arrayOfDouble7[(paramInt1 * 2 + i4)] + arrayOfDouble2[paramInt6][3] * arrayOfDouble7[(paramInt1 * 3 + i4)] + arrayOfDouble2[paramInt6][4] * arrayOfDouble7[(paramInt1 * 4 + i4)] + arrayOfDouble2[paramInt6][5] * arrayOfDouble7[(paramInt1 * 5 + i4)] + arrayOfDouble2[paramInt6][6] * arrayOfDouble7[(paramInt1 * 6 + i4)] + arrayOfDouble2[paramInt6][7] * arrayOfDouble7[(paramInt1 * 7 + i4)] + arrayOfDouble2[paramInt6][8] * arrayOfDouble7[(paramInt1 * 8 + i4)]);
                i4 += arrayOfInt2[i2];
                paramInt6 = i2 + 1;
                i2 = paramInt6;
                if (paramInt6 == i20) {
                  i2 = 0;
                }
                i3 += 1;
              }
            }
          }
          arrayOfDouble6[i9][i4] = d1;
          i3 += arrayOfInt2[i2];
          paramInt6 = i2 + 1;
          i2 = paramInt6;
          if (paramInt6 == i20) {
            i2 = 0;
          }
          i4 += 1;
        }
        i2 = i11;
        while (i2 < i17)
        {
          arrayOfDouble6[i9][i2] = 0L;
          i2 += 1;
        }
        this.jdField_a_of_type_Wbg.a(i17, 1, arrayOfDouble6[i9], arrayOfInt3, arrayOfDouble4);
        arrayOfDouble6[i9][0] = (arrayOfDouble3[0] * arrayOfDouble6[i9][0]);
        arrayOfDouble6[i9][1] = (arrayOfDouble3[1] * arrayOfDouble6[i9][1]);
        i2 = 1;
        while (i2 < i17 / 2)
        {
          d1 = arrayOfDouble3[(i2 * 2)];
          d2 = arrayOfDouble6[i9][(i2 * 2)];
          d3 = arrayOfDouble3[(i2 * 2 + 1)];
          d4 = arrayOfDouble6[i9][(i2 * 2 + 1)];
          d5 = arrayOfDouble3[(i2 * 2 + 1)];
          double d6 = arrayOfDouble6[i9][(i2 * 2)];
          double d7 = arrayOfDouble3[(i2 * 2)];
          double d8 = arrayOfDouble6[i9][(i2 * 2 + 1)];
          arrayOfDouble6[i9][(i2 * 2)] = (d1 * d2 - d3 * d4);
          arrayOfDouble6[i9][(i2 * 2 + 1)] = (d5 * d6 + d7 * d8);
          i2 += 1;
        }
        this.jdField_a_of_type_Wbg.a(i17, -1, arrayOfDouble6[i9], arrayOfInt3, arrayOfDouble4);
        i3 = 0;
        i2 = m;
        while (i2 < i11)
        {
          arrayOfDouble8[(i3 * paramInt1 + i9)] = (arrayOfDouble5[i9][i3] + arrayOfDouble6[i9][i2]);
          i2 += n;
          i3 += 1;
        }
        i10 = 0;
        i4 = i2;
        while (i4 < i17)
        {
          arrayOfDouble5[i9][i10] = arrayOfDouble6[i9][i4];
          i4 += n;
          i10 += 1;
        }
        i10 = i9 + 1;
        i9 = i3;
        i3 = i2 - i11;
        i2 = paramInt6;
        paramInt6 = i4;
        i4 = i2;
        i2 = i9;
        i9 = i10;
      }
      label2586:
      i10 = i8 + paramInt4 / i13 * i11 / n;
      localByteBuffer2.clear();
      if (paramBoolean)
      {
        k = 0;
        paramInt6 = k;
        if (k < i2 * paramInt1)
        {
          if (arrayOfDouble8[k] > 0.0D)
          {
            d1 = arrayOfDouble8[k];
            label2646:
            if (arrayOfDouble1[0] >= d1) {
              break label2698;
            }
          }
          for (;;)
          {
            arrayOfDouble1[0] = d1;
            localByteBuffer2.asDoubleBuffer().put(k, arrayOfDouble8[k]);
            k += 1;
            break;
            d1 = -arrayOfDouble8[k];
            break label2646;
            label2698:
            d1 = arrayOfDouble1[0];
          }
        }
      }
      else
      {
        switch (paramInt3)
        {
        }
      }
      label3213:
      label3480:
      label4012:
      for (;;)
      {
        if (i == 0) {
          if (i7 != 0) {
            if (i12 * paramInt5 / paramInt4 + 2.0D > i1 + i2)
            {
              localByteBuffer2.position(0);
              localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
              a(paramOutputStream, localByteBuffer2);
              i1 += i2;
              m = j;
              k = i;
              j = i1;
              i = m;
            }
          }
        }
        for (;;)
        {
          m = (i10 - 1) / (i14 / paramInt4);
          if ((jdField_a_of_type_Boolean) || (i18 >= m)) {
            break label3907;
          }
          throw new AssertionError();
          d2 = paramDouble * 127.0D;
          i8 = 0;
          paramInt6 = 0;
          if (paramInt6 < i2 * paramInt1)
          {
            if (paramInt7 != 0) {
              m = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble1, paramInt7, i8);
            }
            label2993:
            do
            {
              localByteBuffer2.put(paramInt6, (byte)(m + 128));
              m = i8 + 1;
              k = m;
              if (m == paramInt1) {
                k = 0;
              }
              paramInt6 += 1;
              i8 = k;
              break;
              m = a(arrayOfDouble8[paramInt6] * d2);
              k = m;
              if (m < -128)
              {
                d1 = m / -128.0D;
                if (arrayOfDouble1[0] >= d1) {
                  break label3046;
                }
                arrayOfDouble1[0] = d1;
                k = -128;
              }
              m = k;
            } while (127 >= k);
            d1 = k / 127.0D;
            if (arrayOfDouble1[0] < d1) {}
            for (;;)
            {
              arrayOfDouble1[0] = d1;
              m = 127;
              break;
              label3046:
              d1 = arrayOfDouble1[0];
              break label2993;
              d1 = arrayOfDouble1[0];
            }
          }
          break;
          d2 = paramDouble * 32767.0D;
          i8 = 0;
          paramInt6 = 0;
          if (paramInt6 < i2 * paramInt1)
          {
            if (paramInt7 != 0) {
              m = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble1, paramInt7, i8);
            }
            do
            {
              localByteBuffer2.order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().put(paramInt6, (short)m);
              m = i8 + 1;
              k = m;
              if (m == paramInt1) {
                k = 0;
              }
              paramInt6 += 1;
              i8 = k;
              break;
              m = a(arrayOfDouble8[paramInt6] * d2);
              k = m;
              if (m < -32768)
              {
                d1 = m / -32768.0D;
                if (arrayOfDouble1[0] >= d1) {
                  break label3269;
                }
                arrayOfDouble1[0] = d1;
                k = -32768;
              }
              m = k;
            } while (32767 >= k);
            d1 = k / 32767.0D;
            if (arrayOfDouble1[0] < d1) {}
            for (;;)
            {
              arrayOfDouble1[0] = d1;
              m = 32767;
              break;
              label3269:
              d1 = arrayOfDouble1[0];
              break label3213;
              d1 = arrayOfDouble1[0];
            }
          }
          break;
          d2 = paramDouble * 8388607.0D;
          i8 = 0;
          paramInt6 = 0;
          if (paramInt6 >= i2 * paramInt1) {
            break label4012;
          }
          if (paramInt7 != 0) {
            m = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble1, paramInt7, i8);
          }
          do
          {
            localByteBuffer2.put(paramInt6 * 3, (byte)(m & 0xFF));
            k = m >> 8;
            localByteBuffer2.put(paramInt6 * 3 + 1, (byte)(k & 0xFF));
            localByteBuffer2.put(paramInt6 * 3 + 2, (byte)(k >> 8 & 0xFF));
            m = i8 + 1;
            k = m;
            if (m == paramInt1) {
              k = 0;
            }
            paramInt6 += 1;
            i8 = k;
            break;
            m = a(arrayOfDouble8[paramInt6] * d2);
            k = m;
            if (m < -8388608)
            {
              d1 = m / -8388608.0D;
              if (arrayOfDouble1[0] >= d1) {
                break label3536;
              }
              arrayOfDouble1[0] = d1;
              k = -8388608;
            }
            m = k;
          } while (8388607 >= k);
          d1 = k / 8388607.0D;
          if (arrayOfDouble1[0] < d1) {}
          for (;;)
          {
            arrayOfDouble1[0] = d1;
            m = 8388607;
            break;
            label3536:
            d1 = arrayOfDouble1[0];
            break label3480;
            d1 = arrayOfDouble1[0];
          }
          localByteBuffer2.position(0);
          paramInt1 = (int)(paramInt3 * paramInt1 * (Math.floor(i12 * paramInt5 / paramInt4) + 2.0D - i1));
          if (paramInt1 > 0)
          {
            localByteBuffer2.limit(paramInt1);
            a(paramOutputStream, localByteBuffer2);
          }
          for (;;)
          {
            a(1.0D);
            return arrayOfDouble1[0];
            localByteBuffer2.position(0);
            localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
            a(paramOutputStream, localByteBuffer2);
            m = i1 + i2;
            k = i;
            i = j;
            j = m;
            break;
            if (i2 < j)
            {
              m = j - i2;
              j = i1;
              k = i;
              i = m;
              break;
            }
            if (i7 == 0) {
              break label3846;
            }
            if (i12 * paramInt5 / paramInt4 + 2.0D > i1 + i2 - j)
            {
              localByteBuffer2.position(paramInt3 * paramInt1 * j);
              localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
              a(paramOutputStream, localByteBuffer2);
              m = i1 + (i2 - j);
              k = i;
              i = j;
              j = m;
              break;
            }
            localByteBuffer2.position(paramInt3 * paramInt1 * j);
            localByteBuffer2.limit((int)(paramInt3 * paramInt1 * (Math.floor(i12 * paramInt5 / paramInt4) + 2.0D - i1)));
            a(paramOutputStream, localByteBuffer2);
          }
          localByteBuffer2.position(paramInt3 * paramInt1 * j);
          localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
          a(paramOutputStream, localByteBuffer2);
          k = i1 + (i2 - j);
          i = j;
          m = 0;
          j = k;
          k = m;
        }
        label3907:
        System.arraycopy(arrayOfDouble7, paramInt1 * m, arrayOfDouble7, 0, (i18 - m) * paramInt1);
        i8 = i14 / paramInt4;
        if ((i5 & 0x7) == 7) {
          a(i12 / i6);
        }
        i1 = j;
        i9 = k;
        i5 += 1;
        j = i12;
        k = i4;
        i7 = i18 - m;
        i8 = i10 - m * i8;
        m = i3;
        i4 = j;
        j = i;
        i = i9;
        break;
      }
    }
  }
  
  public int a(double paramDouble, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      arrayOfDouble = this.jdField_a_of_type_ArrayOfDouble;
      paramInt1 = this.f;
      this.f = (paramInt1 + 1);
      d1 = arrayOfDouble[(paramInt1 & 0xFFFF)] + paramDouble;
      paramDouble = d1;
      if (d1 < this.d)
      {
        paramDouble = d1 / this.d;
        if (paramArrayOfDouble[0] < paramDouble)
        {
          paramArrayOfDouble[0] = paramDouble;
          paramDouble = this.d;
        }
      }
      else
      {
        d1 = paramDouble;
        if (paramDouble > this.e)
        {
          paramDouble /= this.e;
          if (paramArrayOfDouble[0] >= paramDouble) {
            break label134;
          }
        }
      }
      for (;;)
      {
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.e;
        return a(d1);
        paramDouble = paramArrayOfDouble[0];
        break;
        label134:
        paramDouble = paramArrayOfDouble[0];
      }
    }
    double d1 = 0.0D;
    paramInt1 = 0;
    while (paramInt1 < this.jdField_c_of_type_Int)
    {
      d1 += jdField_a_of_type_Array2dOfDouble[this.jdField_b_of_type_Int][paramInt1] * this.jdField_b_of_type_Array2dOfDouble[paramInt2][paramInt1];
      paramInt1 += 1;
    }
    double d2 = d1 + paramDouble;
    double[] arrayOfDouble = this.jdField_a_of_type_ArrayOfDouble;
    paramInt1 = this.f;
    this.f = (paramInt1 + 1);
    paramDouble = d2 + arrayOfDouble[(paramInt1 & 0xFFFF)];
    paramInt1 = this.jdField_c_of_type_Int - 2;
    while (paramInt1 >= 0)
    {
      this.jdField_b_of_type_Array2dOfDouble[paramInt2][(paramInt1 + 1)] = this.jdField_b_of_type_Array2dOfDouble[paramInt2][paramInt1];
      paramInt1 -= 1;
    }
    if (paramDouble < this.d)
    {
      paramDouble /= this.d;
      if (paramArrayOfDouble[0] < paramDouble)
      {
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.d;
        this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = (d1 - d2);
        if (this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] > 1.0D) {
          this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = 4607182418800017408L;
        }
        paramDouble = d1;
        if (this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] < -1.0D)
        {
          this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = -4616189618054758400L;
          paramDouble = d1;
        }
      }
    }
    for (;;)
    {
      return (int)paramDouble;
      paramDouble = paramArrayOfDouble[0];
      break;
      if (paramDouble > this.e)
      {
        paramDouble /= this.e;
        if (paramArrayOfDouble[0] < paramDouble) {}
        for (;;)
        {
          paramArrayOfDouble[0] = paramDouble;
          d1 = this.e;
          this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = (d1 - d2);
          if (this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] > 1.0D) {
            this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = 4607182418800017408L;
          }
          paramDouble = d1;
          if (this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] >= -1.0D) {
            break;
          }
          this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = -4616189618054758400L;
          paramDouble = d1;
          break;
          paramDouble = paramArrayOfDouble[0];
        }
      }
      paramDouble = a(paramDouble);
      this.jdField_b_of_type_Array2dOfDouble[paramInt2][0] = (paramDouble - d2);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble)
  {
    int[] arrayOfInt = new int[97];
    int i = 1;
    for (;;)
    {
      if ((i >= 6) || (paramInt1 == jdField_a_of_type_ArrayOfInt[i]))
      {
        if (((paramInt5 == 3) || (paramInt5 == 4)) && (i == 6)) {
          System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", new Object[] { Integer.valueOf(paramInt1) });
        }
        if (paramInt5 != 2)
        {
          paramInt1 = i;
          if (i != 6) {}
        }
        else
        {
          paramInt1 = 0;
        }
        i = paramInt1;
        if (paramInt5 == 4) {
          if (paramInt1 != 1)
          {
            i = paramInt1;
            if (paramInt1 != 2) {}
          }
          else
          {
            i = paramInt1 + 5;
          }
        }
        this.jdField_b_of_type_Int = i;
        this.jdField_b_of_type_Array2dOfDouble = new double[paramInt2][];
        this.jdField_c_of_type_Int = jdField_b_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          this.jdField_b_of_type_Array2dOfDouble[paramInt1] = new double[this.jdField_c_of_type_Int];
          paramInt1 += 1;
        }
      }
      i += 1;
    }
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_ArrayOfDouble = new double[65536];
    Random localRandom = new Random(System.currentTimeMillis());
    paramInt1 = 0;
    while (paramInt1 < 97)
    {
      arrayOfInt[paramInt1] = localRandom.nextInt();
      paramInt1 += 1;
    }
    switch (paramInt6)
    {
    default: 
      this.f = 0;
      if ((paramInt5 == 0) || (paramInt5 == 1)) {
        return 1;
      }
      break;
    case 0: 
      paramInt1 = 0;
      while (paramInt1 < 65536)
      {
        paramInt2 = localRandom.nextInt() % 97;
        paramInt3 = arrayOfInt[paramInt2];
        arrayOfInt[paramInt2] = localRandom.nextInt();
        this.jdField_a_of_type_ArrayOfDouble[paramInt1] = ((paramInt3 / 2147483647.0D - 0.5D) * paramDouble);
        paramInt1 += 1;
      }
    case 1: 
      paramInt1 = 0;
      while (paramInt1 < 65536)
      {
        paramInt3 = localRandom.nextInt() % 97;
        paramInt2 = arrayOfInt[paramInt3];
        arrayOfInt[paramInt3] = localRandom.nextInt();
        paramInt3 = localRandom.nextInt() % 97;
        paramInt4 = arrayOfInt[paramInt3];
        arrayOfInt[paramInt3] = localRandom.nextInt();
        this.jdField_a_of_type_ArrayOfDouble[paramInt1] = ((paramInt2 / 2147483647.0D - paramInt4 / 2147483647.0D) * paramDouble);
        paramInt1 += 1;
      }
    case 2: 
      paramInt1 = 0;
      double d1 = 0.0D;
      double d2 = 0.0D;
      paramInt2 = 0;
      label428:
      if (paramInt2 < 65536)
      {
        if (paramInt1 != 0) {
          break label561;
        }
        paramInt1 = 1;
        paramInt3 = localRandom.nextInt() % 97;
        d2 = arrayOfInt[paramInt3] / 2147483647.0D;
        arrayOfInt[paramInt3] = localRandom.nextInt();
        d1 = d2;
        if (d2 == 1.0D) {
          d1 = 0.0D;
        }
        d1 = Math.sqrt(Math.log(1.0D - d1) * -2.0D);
        paramInt3 = localRandom.nextInt() % 97;
        d2 = arrayOfInt[paramInt3] / 2147483647.0D;
        arrayOfInt[paramInt3] = localRandom.nextInt();
        d2 = 6.283185307179586D * d2;
        this.jdField_a_of_type_ArrayOfDouble[paramInt2] = (paramDouble * d1 * Math.cos(d2));
      }
      for (;;)
      {
        paramInt2 += 1;
        break label428;
        break;
        label561:
        paramInt1 = 0;
        this.jdField_a_of_type_ArrayOfDouble[paramInt2] = (paramDouble * d1 * Math.sin(d2));
      }
    }
    return jdField_c_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
  }
  
  protected void a(OutputStream paramOutputStream, ByteBuffer paramByteBuffer)
  {
    try
    {
      paramOutputStream.write(a(paramByteBuffer));
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  protected byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.limit() - paramByteBuffer.position()];
    paramByteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public double b(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    double[] arrayOfDouble2 = new double[1];
    arrayOfDouble2[0] = 0.0D;
    int i1 = this.jdField_a_of_type_Int;
    double d2 = this.jdField_a_of_type_Double;
    int n = a(paramInt4, paramInt5);
    int m;
    int i17;
    double d1;
    if (paramInt5 / n == 1)
    {
      m = 1;
      i17 = paramInt4 * m;
      if (d2 > 21.0D) {
        break label264;
      }
      d1 = 0.9222D;
      label65:
      i = 1;
    }
    int j;
    int k;
    double d4;
    double d3;
    for (;;)
    {
      j = i1 * i;
      k = j;
      if (j % 2 == 0) {
        k = j - 1;
      }
      d4 = i17 * d1 / (k - 1);
      d3 = (paramInt5 - d4) / 2.0D;
      if (d4 < this.jdField_b_of_type_Double)
      {
        d1 = a(d2);
        d2 = wbe.a(d1);
        i = 1;
        while (i < k) {
          i *= 2;
        }
        if (paramInt5 / n % 2 == 0)
        {
          m = 2;
          break;
        }
        if (paramInt5 / n % 3 == 0)
        {
          m = 3;
          break;
        }
        throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt5 / n) }));
        label264:
        d1 = (d2 - 7.95D) / 14.359999999999999D;
        break label65;
      }
      i *= 2;
    }
    int i18 = i * 2;
    double[] arrayOfDouble3 = new double[i18];
    int i = -(k / 2);
    while (i <= k / 2)
    {
      arrayOfDouble3[(i + k / 2)] = (a(i, k, d1, d2) * a(i, d3, i17) * i17 / paramInt4 / i18 * 2.0D);
      i += 1;
    }
    int[] arrayOfInt3 = new int[(int)(2.0D + Math.sqrt(i18))];
    arrayOfInt3[0] = 0;
    double[] arrayOfDouble4 = new double[i18 / 2];
    this.jdField_a_of_type_Wbg.a(i18, 1, arrayOfDouble3, arrayOfInt3, arrayOfDouble4);
    double[][] arrayOfDouble1;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int i5;
    int i6;
    int i7;
    if (m == 1)
    {
      j = paramInt4 / n;
      n = paramInt4 / paramInt5;
      arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 1, 1 });
      arrayOfDouble1[0][0] = 4607182418800017408L;
      arrayOfInt1 = new int[] { n };
      arrayOfInt2 = new int[] { 0 };
      i5 = 1;
      i6 = 1;
      i7 = j * paramInt5;
      j = 1;
    }
    for (;;)
    {
      a();
      int i8 = i18 / 2;
      double[][] arrayOfDouble5 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, i18 });
      double[][] arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, i6 + 1 + i8 });
      ByteBuffer localByteBuffer1 = ByteBuffer.allocate((i8 / m + m + 1) * paramInt1 * paramInt2);
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate((int)((i8 * paramInt5 / paramInt4 + 1.0D) * (paramInt3 * paramInt1)));
      double[] arrayOfDouble7 = new double[(i8 / m + m + 1) * paramInt1];
      double[] arrayOfDouble8 = new double[(int)(paramInt1 * (i8 * paramInt5 / paramInt4 + 1.0D))];
      int i3 = 0;
      int i12 = 0;
      n = 1;
      d1 = k / 2.0D / (i17 / paramInt5);
      j = (int)(j / 2.0D / (i7 / paramInt5) + d1);
      k = 0;
      int i2 = 0;
      int i4 = 0;
      int i9 = 0;
      i1 = i;
      i = j;
      int i11 = 0;
      int i10 = paramInt6;
      j = n;
      n = k;
      k = i3;
      paramInt6 = i1;
      i1 = i4;
      i4 = i11;
      i3 = (i8 - 0 - 1) / m + 1;
      i11 = i3;
      if (i3 + i4 > i10) {
        i11 = i10 - i4;
      }
      localByteBuffer1.position(0);
      localByteBuffer1.limit(paramInt2 * paramInt1 * i11);
      Object localObject = new byte[localByteBuffer1.limit()];
      int i13 = paramInputStream.read((byte[])localObject);
      i3 = i13;
      if (i13 < 0) {
        i3 = 0;
      }
      if (i3 < localByteBuffer1.limit()) {
        i10 = i4 + i3 / paramInt2 * paramInt1;
      }
      localByteBuffer1.limit(i3);
      localByteBuffer1 = ByteBuffer.wrap((byte[])localObject);
      localByteBuffer1.position(i3);
      localByteBuffer1.flip();
      i13 = i3 / (paramInt2 * paramInt1);
      switch (paramInt2)
      {
      }
      double d5;
      while (paramInt6 < paramInt1 * i11)
      {
        arrayOfDouble7[paramInt6] = 0.0D;
        paramInt6 += 1;
        continue;
        d4 = this.jdField_a_of_type_Double;
        i7 = paramInt4 / n * paramInt5;
        d5 = (i17 / 2 - paramInt4 / 2) * 2 / 2.0D;
        d2 = paramInt4 / 2;
        d3 = (i17 / 2 - paramInt4 / 2) / 2.0D;
        if (d4 <= 21.0D) {}
        for (d1 = 0.9222D;; d1 = (d4 - 7.95D) / 14.359999999999999D)
        {
          j = (int)(d1 * (i7 / d5) + 1.0D);
          i = j;
          if (j % 2 == 0) {
            i = j + 1;
          }
          d1 = a(d4);
          d4 = wbe.a(d1);
          i5 = i7 / i17;
          i6 = i / i5 + 1;
          arrayOfInt2 = new int[i5];
          j = 0;
          while (j < i5)
          {
            arrayOfInt2[j] = (i7 / i17 - i7 / paramInt5 * j % (i7 / i17));
            if (arrayOfInt2[j] == i7 / i17) {
              arrayOfInt2[j] = 0;
            }
            j += 1;
          }
        }
        arrayOfInt1 = new int[i5];
        j = 0;
        if (j < i5)
        {
          arrayOfInt1[j] = ((i7 / paramInt5 - arrayOfInt2[j]) / (i7 / i17) + 1);
          if (j + 1 == i5) {}
          for (n = 0;; n = j + 1)
          {
            if (arrayOfInt2[n] == 0) {
              arrayOfInt1[j] -= 1;
            }
            j += 1;
            break;
          }
        }
        arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { i5, i6 });
        j = -(i / 2);
        while (j <= i / 2)
        {
          arrayOfDouble1[((i / 2 + j) % i5)][((i / 2 + j) / i5)] = (a(j, i, d1, d4) * a(j, d2 + d3, i7) * i7 / i17);
          j += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i13 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i3)] = (0.0078740157480315D * ((localByteBuffer1.get(i3) & 0xFF) - 128));
          i3 += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i13 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i3)] = (3.051850947599719E-005D * localByteBuffer1.order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().get(i3));
          i3 += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i13 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i3)] = (1.192093037616377E-007D * ((localByteBuffer1.get(i3 * 3) & 0xFF) << 0 | (localByteBuffer1.get(i3 * 3 + 1) & 0xFF) << 8 | (localByteBuffer1.get(i3 * 3 + 2) & 0xFF) << 16));
          i3 += 1;
        }
        i3 = 0;
        for (;;)
        {
          paramInt6 = i3;
          if (i3 >= i13 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i3)] = (4.656612875245797E-010D * localByteBuffer1.order(this.jdField_a_of_type_JavaNioByteOrder).getInt(i3));
          i3 += 1;
        }
      }
      int i16 = i4 + i13;
      if ((paramInputStream.available() < 0) || (i16 >= i10))
      {
        i11 = 1;
        i13 = 0;
      }
      for (i3 = k;; i3 = i4)
      {
        if (i13 >= paramInt1) {
          break label2416;
        }
        int i14 = 0;
        paramInt6 = 0;
        for (;;)
        {
          if (paramInt6 >= i8) {
            break label1773;
          }
          if ((!jdField_a_of_type_Boolean) && (i14 >= (i8 - 0 - 1) / m + 1))
          {
            throw new AssertionError();
            i11 = 0;
            break;
          }
          arrayOfDouble5[i13][paramInt6] = arrayOfDouble7[(i14 * paramInt1 + i13)];
          i2 = paramInt6 + 1;
          while (i2 < paramInt6 + m)
          {
            arrayOfDouble5[i13][i2] = 0L;
            i2 += 1;
          }
          paramInt6 += m;
          i14 += 1;
        }
        label1773:
        if ((!jdField_a_of_type_Boolean) && (i14 != (i8 - 0 - 1) / m + 1)) {
          throw new AssertionError();
        }
        paramInt6 = i8;
        while (paramInt6 < i18)
        {
          arrayOfDouble5[i13][paramInt6] = 0L;
          paramInt6 += 1;
        }
        this.jdField_a_of_type_Wbg.a(i18, 1, arrayOfDouble5[i13], arrayOfInt3, arrayOfDouble4);
        arrayOfDouble5[i13][0] = (arrayOfDouble3[0] * arrayOfDouble5[i13][0]);
        arrayOfDouble5[i13][1] = (arrayOfDouble3[1] * arrayOfDouble5[i13][1]);
        paramInt6 = 1;
        while (paramInt6 < i8)
        {
          d1 = arrayOfDouble3[(paramInt6 * 2)];
          d2 = arrayOfDouble5[i13][(paramInt6 * 2)];
          d3 = arrayOfDouble3[(paramInt6 * 2 + 1)];
          d4 = arrayOfDouble5[i13][(paramInt6 * 2 + 1)];
          d5 = arrayOfDouble3[(paramInt6 * 2 + 1)];
          double d6 = arrayOfDouble5[i13][(paramInt6 * 2)];
          double d7 = arrayOfDouble3[(paramInt6 * 2)];
          double d8 = arrayOfDouble5[i13][(paramInt6 * 2 + 1)];
          arrayOfDouble5[i13][(paramInt6 * 2)] = (d1 * d2 - d3 * d4);
          arrayOfDouble5[i13][(paramInt6 * 2 + 1)] = (d5 * d6 + d7 * d8);
          paramInt6 += 1;
        }
        this.jdField_a_of_type_Wbg.a(i18, -1, arrayOfDouble5[i13], arrayOfInt3, arrayOfDouble4);
        paramInt6 = 0;
        while (paramInt6 < i8)
        {
          localObject = arrayOfDouble6[i13];
          i2 = i6 + 1 + paramInt6;
          localObject[i2] += arrayOfDouble5[i13][paramInt6];
          paramInt6 += 1;
        }
        i3 = i12 / (i7 / i17);
        i2 = i3;
        if (i12 % (i7 / i17) != 0) {
          i2 = i3 + 1;
        }
        i3 = arrayOfDouble6[0].length;
        i2 = i3 * i13 + i2;
        int i15 = 0;
        i4 = k;
        i3 = paramInt6;
        paramInt6 = i15;
        while (i2 - arrayOfDouble6[0].length * i13 < i8 + 1)
        {
          int i20 = arrayOfInt2[i4];
          int i19 = arrayOfInt1[i4];
          i4 += 1;
          i3 = i4;
          if (i4 == i5) {
            i3 = 0;
          }
          if ((!jdField_a_of_type_Boolean) && ((i2 - arrayOfDouble6[0].length * i13) * (i7 / i17) - (i7 / paramInt5 * paramInt6 + i12) != i20)) {
            throw new AssertionError();
          }
          i4 = 0;
          d1 = 0.0D;
          i15 = i2;
          while (i4 < i6)
          {
            d1 += arrayOfDouble1[i20][i4] * arrayOfDouble6[(i15 / arrayOfDouble6[0].length)][(i15 % arrayOfDouble6[0].length)];
            i15 += 1;
            i4 += 1;
          }
          arrayOfDouble8[(paramInt6 * paramInt1 + 0 + i13)] = d1;
          paramInt6 += 1;
          i15 = i4;
          i2 = i19 + i2;
          i4 = i3;
          i3 = i15;
        }
        i13 += 1;
        i2 = paramInt6;
        i1 += i14;
        paramInt6 = i3;
      }
      label2416:
      i13 = i12 + i7 / paramInt5 * i2;
      localByteBuffer2.clear();
      if (paramBoolean)
      {
        k = 0;
        paramInt6 = k;
        if (k < i2 * paramInt1)
        {
          if (arrayOfDouble8[k] > 0.0D)
          {
            d1 = arrayOfDouble8[k];
            label2473:
            if (arrayOfDouble2[0] >= d1) {
              break label2525;
            }
          }
          for (;;)
          {
            arrayOfDouble2[0] = d1;
            localByteBuffer2.asDoubleBuffer().put(k, arrayOfDouble8[k]);
            k += 1;
            break;
            d1 = -arrayOfDouble8[k];
            break label2473;
            label2525:
            d1 = arrayOfDouble2[0];
          }
        }
      }
      else
      {
        switch (paramInt3)
        {
        }
      }
      label3338:
      label3858:
      for (;;)
      {
        if (j == 0) {
          if (i11 != 0) {
            if (i16 * paramInt5 / paramInt4 + 2.0D > n + i2)
            {
              localByteBuffer2.position(0);
              localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
              a(paramOutputStream, localByteBuffer2);
              n += i2;
              k = j;
              j = n;
            }
          }
        }
        for (;;)
        {
          i4 = (i13 - 1) / (i7 / i17);
          n = i4;
          if (i4 > i8) {
            n = i8;
          }
          i4 = 0;
          while (i4 < paramInt1)
          {
            System.arraycopy(arrayOfDouble6[i4], n, arrayOfDouble6[i4], 0, i6 + 1 + i8 - n);
            i4 += 1;
          }
          d2 = paramDouble * 127.0D;
          i12 = 0;
          paramInt6 = 0;
          if (paramInt6 < i2 * paramInt1)
          {
            if (paramInt7 != 0) {
              i4 = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble2, paramInt7, i12);
            }
            label2851:
            do
            {
              localByteBuffer2.put(paramInt6, (byte)(i4 + 128));
              i4 = i12 + 1;
              k = i4;
              if (i4 == paramInt1) {
                k = 0;
              }
              paramInt6 += 1;
              i12 = k;
              break;
              i4 = a(arrayOfDouble8[paramInt6] * d2);
              k = i4;
              if (i4 < -128)
              {
                d1 = i4 / -128.0D;
                if (arrayOfDouble2[0] >= d1) {
                  break label2904;
                }
                arrayOfDouble2[0] = d1;
                k = -128;
              }
              i4 = k;
            } while (127 >= k);
            d1 = k / 127.0D;
            if (arrayOfDouble2[0] < d1) {}
            for (;;)
            {
              arrayOfDouble2[0] = d1;
              i4 = 127;
              break;
              label2904:
              d1 = arrayOfDouble2[0];
              break label2851;
              d1 = arrayOfDouble2[0];
            }
          }
          break;
          d2 = paramDouble * 32767.0D;
          i12 = 0;
          paramInt6 = 0;
          if (paramInt6 < i2 * paramInt1)
          {
            if (paramInt7 != 0) {
              i4 = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble2, paramInt7, i12);
            }
            label3071:
            do
            {
              localByteBuffer2.order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().put(paramInt6, (short)i4);
              i4 = i12 + 1;
              k = i4;
              if (i4 == paramInt1) {
                k = 0;
              }
              paramInt6 += 1;
              i12 = k;
              break;
              i4 = a(arrayOfDouble8[paramInt6] * d2);
              k = i4;
              if (i4 < -32768)
              {
                d1 = i4 / -32768.0D;
                if (arrayOfDouble2[0] >= d1) {
                  break label3127;
                }
                arrayOfDouble2[0] = d1;
                k = -32768;
              }
              i4 = k;
            } while (32767 >= k);
            d1 = k / 32767.0D;
            if (arrayOfDouble2[0] < d1) {}
            for (;;)
            {
              arrayOfDouble2[0] = d1;
              i4 = 32767;
              break;
              label3127:
              d1 = arrayOfDouble2[0];
              break label3071;
              d1 = arrayOfDouble2[0];
            }
          }
          break;
          d2 = paramDouble * 8388607.0D;
          i12 = 0;
          paramInt6 = 0;
          if (paramInt6 >= i2 * paramInt1) {
            break label3858;
          }
          if (paramInt7 != 0) {
            i4 = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble2, paramInt7, i12);
          }
          do
          {
            localByteBuffer2.put(paramInt6 * 3, (byte)(i4 & 0xFF));
            k = i4 >> 8;
            localByteBuffer2.put(paramInt6 * 3 + 1, (byte)(k & 0xFF));
            localByteBuffer2.put(paramInt6 * 3 + 2, (byte)(k >> 8 & 0xFF));
            i4 = i12 + 1;
            k = i4;
            if (i4 == paramInt1) {
              k = 0;
            }
            paramInt6 += 1;
            i12 = k;
            break;
            i4 = a(arrayOfDouble8[paramInt6] * d2);
            k = i4;
            if (i4 < -8388608)
            {
              d1 = i4 / -8388608.0D;
              if (arrayOfDouble2[0] >= d1) {
                break label3394;
              }
              arrayOfDouble2[0] = d1;
              k = -8388608;
            }
            i4 = k;
          } while (8388607 >= k);
          d1 = k / 8388607.0D;
          if (arrayOfDouble2[0] < d1) {}
          for (;;)
          {
            arrayOfDouble2[0] = d1;
            i4 = 8388607;
            break;
            label3394:
            d1 = arrayOfDouble2[0];
            break label3338;
            d1 = arrayOfDouble2[0];
          }
          localByteBuffer2.position(0);
          paramInt1 = (int)(paramInt3 * paramInt1 * (Math.floor(i16 * paramInt5 / paramInt4) + 2.0D - n));
          if (paramInt1 > 0)
          {
            localByteBuffer2.limit(paramInt1);
            a(paramOutputStream, localByteBuffer2);
          }
          for (;;)
          {
            a(1.0D);
            return arrayOfDouble2[0];
            localByteBuffer2.position(0);
            localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
            a(paramOutputStream, localByteBuffer2);
            n += i2;
            k = j;
            j = n;
            break;
            if (i2 < i)
            {
              i -= i2;
              k = j;
              j = n;
              break;
            }
            if (i11 == 0) {
              break label3703;
            }
            if (i16 * paramInt5 / paramInt4 + 2.0D > n + i2 - i)
            {
              localByteBuffer2.position(paramInt3 * paramInt1 * i);
              localByteBuffer2.limit(paramInt3 * paramInt1 * (i2 - i));
              a(paramOutputStream, localByteBuffer2);
              n = i2 - i + n;
              k = j;
              j = n;
              break;
            }
            localByteBuffer2.position(paramInt3 * paramInt1 * i);
            localByteBuffer2.limit((int)(paramInt3 * paramInt1 * (Math.floor(i16 * paramInt5 / paramInt4) + 2.0D + n + i2 - i)));
            a(paramOutputStream, localByteBuffer2);
          }
          label3703:
          localByteBuffer2.position(paramInt3 * paramInt1 * i);
          localByteBuffer2.limit(paramInt3 * paramInt1 * i2);
          a(paramOutputStream, localByteBuffer2);
          k = 0;
          j = i2 - i + n;
        }
        i12 = i7 / i17;
        i4 = 0;
        while (i4 < paramInt1)
        {
          System.arraycopy(arrayOfDouble5[i4], i8, arrayOfDouble6[i4], i6 + 1, i8);
          i4 += 1;
        }
        if ((i9 & 0x7) == 7) {
          a(i16 / i10);
        }
        i11 = k;
        i9 += 1;
        k = i3;
        i4 = i16;
        i12 = i13 - n * i12;
        n = j;
        j = i11;
        break;
      }
      n = j;
      j = i;
      i = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wbf
 * JD-Core Version:    0.7.0.1
 */