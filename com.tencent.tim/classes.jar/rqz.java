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

public class rqz
{
  private static final double[][] b;
  private static final int[] er;
  private static final int[] es;
  private static final int[] et;
  private static final double[] i;
  private long Cr;
  private long Cs;
  private rra a = new rra();
  private boolean aJp;
  private double bq = 150.0D;
  private double br = 200.0D;
  private int buc = 1;
  private int bud;
  private int bue;
  private int buf;
  private int bug;
  private int buh;
  private int bui;
  private ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
  private double[][] c;
  private double[] h;
  
  static
  {
    if (!rqz.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      er = new int[] { 0, 48000, 44100, 37800, 32000, 22050, 48000, 44100 };
      es = new int[] { 1, 16, 20, 16, 16, 15, 16, 15 };
      et = new int[] { 8, 18, 27, 8, 8, 8, 10, 9 };
      b = new double[][] { { -1.0D }, { -2.87207293510437D, 5.041323184967041D, -6.244299411773682D, 5.848398685455322D, -3.706754207611084D, 1.049511909484863D, 1.183023691177368D, -2.112679243087769D, 1.90945315361023D, -0.9991308450698853D, 0.1709080636501312D, 0.3261560201644898D, -0.3912764489650726D, 0.2687646150588989D, -0.0976761057972908D, 0.02347384579479694D }, { -2.677319765090942D, 4.830892562866211D, -6.570110321044922D, 7.457201480865479D, -6.726327419281006D, 4.848165035247803D, -2.041208982467651D, -0.7006359100341797D, 2.95375657081604D, -4.080038547515869D, 4.184521675109863D, -3.331181287765503D, 2.117992639541626D, -0.879302978515625D, 0.03175914660096169D, 0.423827886581421D, -0.478821039199829D, 0.3549081385135651D, -0.1749683916568756D, 0.060908168554306D }, { -1.633599281311035D, 2.261549234390259D, -2.407702922821045D, 2.634171724319458D, -2.144036293029785D, 1.815325856208801D, -1.08162248134613D, 0.7030265331268311D, -0.1599199324846268D, -0.04154951870441437D, 0.2941657602787018D, -0.2518316805362701D, 0.2776647806167603D, -0.1578540354967117D, 0.1016589403152466D, -0.01683389209210873D }, { -0.8290129899978638D, 0.989226579666138D, -0.5982571244239807D, 1.002880930900574D, -0.5993821620941162D, 0.7950245141983032D, -0.4272331595420837D, 0.544925272464752D, -0.3079260587692261D, 0.3687179982662201D, -0.187920480966568D, 0.2261127084493637D, -0.1057334169745445D, 0.1143549084663391D, -0.038800679147244D, 0.0408421978354454D }, { -0.06522997468709946D, 0.5498126149177551D, 0.4027854800224304D, 0.3178376853466034D, 0.2820179760456085D, 0.1698519438505173D, 0.1543336361646652D, 0.1250714063644409D, 0.08903945237398148D, 0.06441012024879456D, 0.04714600369334221D, 0.03280523791909218D, 0.02849519439041615D, 0.01169500593096018D, 0.01183183863759041D }, { -2.392577409744263D, 3.435029745101929D, -3.185370922088623D, 1.811727166175842D, 0.2012477070093155D, -1.475990772247315D, 1.721090435981751D, -0.9774670004844666D, 0.1379013806581497D, 0.3818590342998505D, -0.2742124199867249D, -0.06658421456813812D, 0.3522330224514008D, -0.376723438501358D, 0.2396427690982819D, -0.06867482513189316D }, { -2.083391666412354D, 3.041845083236694D, -3.204789876937866D, 2.757192611694336D, -1.497863054275513D, 0.3427594602108002D, 0.7173374891281128D, -1.073705792427063D, 1.022581577301025D, -0.5664999485015869D, 0.2096869200468063D, 0.06537853181362152D, -0.1032243818044663D, 0.06744202226400375D, 0.00495197344571352D } };
      i = new double[] { 0.7D, 0.9D, 0.18D };
      return;
    }
  }
  
  public rqz() {}
  
  public rqz(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, boolean paramBoolean)
    throws IOException
  {
    double[] arrayOfDouble = new double[1];
    arrayOfDouble[0] = 0.0D;
    if ((paramInt7 < 0) || (paramInt7 > 4)) {
      throw new IllegalArgumentException("unrecognized dither type : " + paramInt7);
    }
    this.aJp = paramBoolean;
    if (!this.aJp) {
      System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
    }
    if ((paramInt3 != 1) && (paramInt3 != 2) && (paramInt3 != 3) && (paramInt3 != 4)) {
      throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
    }
    int j;
    if (paramInt4 == -1) {
      if (paramInt3 != 1)
      {
        j = paramInt3;
        paramInt4 = j;
        if (j == 4) {
          paramInt4 = 3;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 == -1) {}
      for (int k = paramInt1;; k = paramInt2)
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
          if (!this.aJp)
          {
            System.err.printf("frequency : %d -> %d\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(k) });
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
              j = 0;
              paramInt7 = 0;
              if (paramInt4 == 1)
              {
                j = -128;
                paramInt7 = 127;
              }
              if (paramInt4 == 2)
              {
                j = -32768;
                paramInt7 = 32767;
              }
              if (paramInt4 == 3)
              {
                j = -8388608;
                paramInt7 = 8388607;
              }
              if (paramInt4 == 4)
              {
                j = -2147483648;
                paramInt7 = 2147483647;
              }
              a(k, paramInt5, j, paramInt7, paramInt2, 0, 0.18D);
            }
            if (paramInt1 >= k) {
              break label736;
            }
            arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, paramInt4, paramInt1, k, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
          }
          for (;;)
          {
            label390:
            if (!this.aJp) {
              System.err.printf("\n", new Object[0]);
            }
            if (paramInt2 != 0) {
              xQ(paramInt5);
            }
            if ((arrayOfDouble[0] > 1.0D) && (!this.aJp)) {
              System.err.printf("clipping detected : %gdB\n", new Object[] { Double.valueOf(20.0D * Math.log10(arrayOfDouble[0])) });
            }
            return;
            j = 2;
            break;
            paramInt2 = 3;
            break label213;
            paramInt2 = 1;
            break label213;
            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", new Object[] { new String[] { "none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)" }[paramInt2], new String[] { "rectangular", "triangular", "gaussian" }[0], Double.valueOf(0.18D) });
            break label390;
            label736:
            if (paramInt1 > k) {
              arrayOfDouble[0] = b(paramInputStream, paramOutputStream, paramInt5, paramInt3, paramInt4, paramInt1, k, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
            } else {
              arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, paramInt4, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
            }
          }
          paramInt2 = paramInt7;
        }
      }
    }
  }
  
  private double a(double paramDouble1, int paramInt, double paramDouble2, double paramDouble3)
  {
    return rqy.value(Math.sqrt(1.0D - 4.0D * paramDouble1 * paramDouble1 / ((paramInt - 1.0D) * (paramInt - 1.0D))) * paramDouble2) / paramDouble3;
  }
  
  private double a(int paramInt, double paramDouble1, double paramDouble2)
  {
    paramDouble2 = 1.0D / paramDouble2;
    return h(paramDouble2 * (6.283185307179586D * paramDouble1 * paramInt)) * (2.0D * paramDouble1 * paramDouble2);
  }
  
  private int a(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      return (int)(paramDouble + 0.5D);
    }
    return (int)(paramDouble - 0.5D);
  }
  
  private void bvU()
  {
    this.Cr = System.currentTimeMillis();
    this.Cs = 0L;
    this.bui = -1;
  }
  
  private double g(double paramDouble)
  {
    if (paramDouble <= 21.0D) {
      return 0.0D;
    }
    if (paramDouble <= 50.0D) {
      return 0.5842000000000001D * Math.pow(paramDouble - 21.0D, 0.4D) + 0.07886D * (paramDouble - 21.0D);
    }
    return 0.1102D * (paramDouble - 8.699999999999999D);
  }
  
  private int gcd(int paramInt1, int paramInt2)
  {
    int j;
    for (;;)
    {
      j = paramInt1;
      if (paramInt2 == 0) {
        break;
      }
      paramInt1 = paramInt2;
      paramInt2 = j % paramInt2;
    }
    return j;
  }
  
  private double h(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 1.0D;
    }
    return Math.sin(paramDouble) / paramDouble;
  }
  
  private void v(double paramDouble)
  {
    if (this.aJp) {
      return;
    }
    long l = System.currentTimeMillis() - this.Cr;
    if (paramDouble == 0.0D) {}
    for (int j = 0;; j = (int)(l * (1.0D - paramDouble) / paramDouble))
    {
      int k = (int)(100.0D * paramDouble);
      if ((k != this.bui) || (l != this.Cs))
      {
        System.err.printf(" %3d%% processed", new Object[] { Integer.valueOf(k) });
        this.bui = k;
      }
      if (l != this.Cs)
      {
        System.err.printf(", ETA =%4dmsec", new Object[] { Integer.valueOf(j) });
        this.Cs = l;
      }
      System.err.printf("\r", new Object[0]);
      System.err.flush();
      return;
    }
  }
  
  private void xQ(int paramInt) {}
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4, boolean paramBoolean, int paramInt5)
    throws IOException
  {
    double[] arrayOfDouble = new double[1];
    arrayOfDouble[0] = 0.0D;
    int j = 0;
    bvU();
    ByteBuffer localByteBuffer = null;
    if (paramBoolean) {
      localByteBuffer = ByteBuffer.allocate(8);
    }
    Object localObject = ByteBuffer.allocate(4);
    int k = 0;
    double d2;
    for (;;)
    {
      if (k < paramInt4 * paramInt1)
      {
        d1 = 0.0D;
        switch (paramInt2)
        {
        }
      }
      while (paramInputStream.available() == 0)
      {
        v(1.0D);
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
        d1 = ((ByteBuffer)localObject).order(this.byteOrder).asShortBuffer().get(0) * 3.051850947599719E-005D;
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
        d1 = ((ByteBuffer)localObject).order(this.byteOrder).asIntBuffer().get(0) * 4.656612875245797E-010D;
      }
      d2 = d1 * paramDouble;
      if (paramBoolean) {
        break;
      }
      switch (paramInt3)
      {
      default: 
        m = j + 1;
        j = m;
        if (m == paramInt1) {
          j = 0;
        }
        k += 1;
        if ((0x3FFFF & k) == 0) {
          v(k / (paramInt4 * paramInt1));
        }
        break;
      }
    }
    double d1 = 127.0D * d2;
    if (paramInt5 != 0) {}
    for (int m = a(d1, arrayOfDouble, paramInt5, j);; m = a(d1))
    {
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).limit(1);
      ((ByteBuffer)localObject).put(0, (byte)(m + 128));
      ((ByteBuffer)localObject).flip();
      b(paramOutputStream, (ByteBuffer)localObject);
      break;
    }
    d1 = 32767.0D * d2;
    if (paramInt5 != 0) {}
    for (m = a(d1, arrayOfDouble, paramInt5, j);; m = a(d1))
    {
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).limit(2);
      ((ByteBuffer)localObject).asShortBuffer().put(0, (short)m);
      ((ByteBuffer)localObject).flip();
      b(paramOutputStream, (ByteBuffer)localObject);
      break;
    }
    d1 = 8388607.0D * d2;
    if (paramInt5 != 0) {}
    for (m = a(d1, arrayOfDouble, paramInt5, j);; m = a(d1))
    {
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).limit(3);
      ((ByteBuffer)localObject).put(0, (byte)(m & 0xFF));
      m >>= 8;
      ((ByteBuffer)localObject).put(1, (byte)(m & 0xFF));
      ((ByteBuffer)localObject).put(2, (byte)(m >> 8 & 0xFF));
      ((ByteBuffer)localObject).flip();
      b(paramOutputStream, (ByteBuffer)localObject);
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
      b(paramOutputStream, localByteBuffer);
      break;
      d1 = -d2;
      break label824;
      label879:
      d1 = arrayOfDouble[0];
    }
  }
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
    throws IOException
  {
    double[] arrayOfDouble1 = new double[1];
    arrayOfDouble1[0] = 0.0D;
    int i2 = this.buc;
    double d4 = this.bq;
    int i14 = gcd(paramInt4, paramInt5);
    int i15 = paramInt4 / i14 * paramInt5;
    int i1;
    double d5;
    double d3;
    if (i15 / paramInt5 == 1)
    {
      i1 = 1;
      d5 = (paramInt5 * i1 / 2 - paramInt4 / 2) * 2 / 2.0D;
      d2 = paramInt4 / 2;
      d3 = (paramInt5 * i1 / 2 - paramInt4 / 2) / 2.0D;
      if (d4 > 21.0D) {
        break label357;
      }
    }
    int i16;
    int i17;
    int[] arrayOfInt1;
    label357:
    for (double d1 = 0.9222D;; d1 = (d4 - 7.95D) / 14.359999999999999D)
    {
      j = (int)(d1 * (i15 / d5) + 1.0D);
      k = j;
      if (j % 2 == 0) {
        k = j + 1;
      }
      d1 = g(d4);
      d4 = rqy.value(d1);
      i16 = i15 / paramInt4;
      i17 = k / i16 + 1;
      arrayOfInt1 = new int[i16 * i1];
      j = 0;
      while (j < i16 * i1)
      {
        arrayOfInt1[j] = (i15 / paramInt4 - i15 / (paramInt5 * i1) * j % (i15 / paramInt4));
        if (arrayOfInt1[j] == i15 / paramInt4) {
          arrayOfInt1[j] = 0;
        }
        j += 1;
      }
      if (i15 / paramInt5 % 2 == 0)
      {
        i1 = 2;
        break;
      }
      if (i15 / paramInt5 % 3 == 0)
      {
        i1 = 3;
        break;
      }
      throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(i15 / paramInt5) }));
    }
    int[] arrayOfInt2 = new int[i16 * i1];
    int j = 0;
    if (j < i16 * i1)
    {
      if (arrayOfInt1[j] < i15 / (paramInt5 * i1)) {}
      for (m = paramInt1;; m = 0)
      {
        arrayOfInt2[j] = m;
        if (arrayOfInt1[j] == i15 / paramInt4) {
          arrayOfInt1[j] = 0;
        }
        j += 1;
        break;
      }
    }
    double[][] arrayOfDouble2 = (double[][])Array.newInstance(Double.TYPE, new int[] { i16, i17 });
    j = -(k / 2);
    while (j <= k / 2)
    {
      arrayOfDouble2[((k / 2 + j) % i16)][((k / 2 + j) / i16)] = (a(j, k, d1, d4) * a(j, d2 + d3, i15) * i15 / paramInt4);
      j += 1;
    }
    double d2 = this.bq;
    if (d2 <= 21.0D)
    {
      d1 = 0.9222D;
      i4 = paramInt5 * i1;
      j = 1;
    }
    for (;;)
    {
      n = i2 * j;
      m = n;
      if (n % 2 == 0) {
        m = n - 1;
      }
      d4 = i4 * d1 / (m - 1);
      d3 = paramInt4 / 2;
      if (d4 < this.br)
      {
        d1 = g(d2);
        d2 = rqy.value(d1);
        j = 1;
        while (j < m) {
          j *= 2;
        }
        d1 = (d2 - 7.95D) / 14.359999999999999D;
        break;
      }
      j *= 2;
    }
    int i18 = j * 2;
    double[] arrayOfDouble3 = new double[i18];
    j = -(m / 2);
    while (j <= m / 2)
    {
      arrayOfDouble3[(m / 2 + j)] = (a(j, m, d1, d2) * a(j, d3, i4) / i18 * 2.0D);
      j += 1;
    }
    int[] arrayOfInt3 = new int[(int)(2.0D + Math.sqrt(i18))];
    arrayOfInt3[0] = 0;
    double[] arrayOfDouble4 = new double[i18 / 2];
    this.a.rdft(i18, 1, arrayOfDouble3, arrayOfInt3, arrayOfDouble4);
    bvU();
    int i12 = i18 / 2;
    int i3 = 0;
    int n = i12 / i1;
    double[][] arrayOfDouble5 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, n + 1 });
    double[][] arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, i18 });
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate((i12 + i17 + 2) * paramInt1 * paramInt2);
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate((i12 / i1 + 1) * paramInt1 * paramInt3);
    double[] arrayOfDouble7 = new double[(i12 + i17 + 2) * paramInt1];
    double[] arrayOfDouble8 = new double[(i12 / i1 + 1) * paramInt1];
    int i8 = k / 2 / (i15 / paramInt4) + 1;
    int k = (int)(m / 2.0D / (i4 / paramInt5));
    int i5 = 0;
    int m = j;
    int i6 = 0;
    j = k;
    n = 0;
    int i4 = 0;
    i2 = 0;
    k = 1;
    int i9 = 0;
    int i7 = paramInt6;
    paramInt6 = m;
    m = i4;
    int i10 = (int)(Math.ceil(i12 * paramInt4 / (paramInt5 * i1)) + 1.0D + i17 - i8);
    if (i10 + i5 > i7) {}
    for (i4 = i7 - i5;; i4 = i10)
    {
      localByteBuffer1.position(0);
      localByteBuffer1.limit(i4 * (paramInt2 * paramInt1));
      byte[] arrayOfByte = new byte[localByteBuffer1.limit()];
      int i11 = paramInputStream.read(arrayOfByte);
      i4 = i11;
      if (i11 < 0) {
        i4 = 0;
      }
      if (i4 < localByteBuffer1.limit()) {
        i7 = i5 + i4 / paramInt2 * paramInt1;
      }
      localByteBuffer1.limit(i4);
      localByteBuffer1 = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer1.position(i4);
      localByteBuffer1.flip();
      i11 = i4 / (paramInt2 * paramInt1);
      switch (paramInt2)
      {
      }
      while (paramInt6 < paramInt1 * i10)
      {
        arrayOfDouble7[(paramInt1 * i8 + paramInt6)] = 0.0D;
        paramInt6 += 1;
        continue;
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i11 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i8 + i4)] = (0.0078740157480315D * (localByteBuffer1.get(i4) - 128.0D));
          i4 += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i11 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i8 + i4)] = (3.051850947599719E-005D * localByteBuffer1.order(this.byteOrder).asShortBuffer().get(i4));
          i4 += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i11 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i8 + i4)] = (1.192093037616377E-007D * (localByteBuffer1.get(i4 * 3) << 0 | localByteBuffer1.get(i4 * 3 + 1) << 8 | localByteBuffer1.get(i4 * 3 + 2) << 16));
          i4 += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i11 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * i8 + i4)] = (4.656612875245797E-010D * localByteBuffer1.order(this.byteOrder).asIntBuffer().get(i4));
          i4 += 1;
        }
      }
      int i19 = i8 + i10;
      int i13 = i5 + i11;
      int i20;
      if (i13 >= i7)
      {
        i8 = 1;
        i20 = ((i9 - 1) * paramInt4 + i15) / i15;
        i10 = 0;
        i4 = m;
        i5 = n;
      }
      for (;;)
      {
        if (i10 >= paramInt1) {
          break label2586;
        }
        int i21 = i16 * i1;
        i4 = i20 * paramInt1 + i10;
        switch (i17)
        {
        case 8: 
        default: 
          i5 = 0;
          i3 = m;
        }
        for (;;)
        {
          paramInt6 = i3;
          if (i5 >= i12) {
            break label2181;
          }
          d1 = 0.0D;
          int i22 = arrayOfInt1[i3];
          paramInt6 = 0;
          i11 = i4;
          for (;;)
          {
            if (paramInt6 < i17)
            {
              d1 += arrayOfDouble2[i22][paramInt6] * arrayOfDouble7[i11];
              i11 += paramInt1;
              paramInt6 += 1;
              continue;
              i8 = 0;
              break;
              paramInt6 = 0;
              i3 = m;
              i5 = i4;
              i4 = paramInt6;
              for (;;)
              {
                paramInt6 = i3;
                if (i4 >= i12) {
                  break;
                }
                paramInt6 = arrayOfInt1[i3];
                arrayOfDouble6[i10][i4] = (arrayOfDouble2[paramInt6][0] * arrayOfDouble7[(paramInt1 * 0 + i5)] + arrayOfDouble2[paramInt6][1] * arrayOfDouble7[(paramInt1 * 1 + i5)] + arrayOfDouble2[paramInt6][2] * arrayOfDouble7[(paramInt1 * 2 + i5)] + arrayOfDouble2[paramInt6][3] * arrayOfDouble7[(paramInt1 * 3 + i5)] + arrayOfDouble2[paramInt6][4] * arrayOfDouble7[(paramInt1 * 4 + i5)] + arrayOfDouble2[paramInt6][5] * arrayOfDouble7[(paramInt1 * 5 + i5)] + arrayOfDouble2[paramInt6][6] * arrayOfDouble7[(paramInt1 * 6 + i5)]);
                i5 += arrayOfInt2[i3];
                paramInt6 = i3 + 1;
                i3 = paramInt6;
                if (paramInt6 == i21) {
                  i3 = 0;
                }
                i4 += 1;
              }
              paramInt6 = 0;
              i3 = m;
              i5 = i4;
              i4 = paramInt6;
              for (;;)
              {
                paramInt6 = i3;
                if (i4 >= i12) {
                  break;
                }
                paramInt6 = arrayOfInt1[i3];
                arrayOfDouble6[i10][i4] = (arrayOfDouble2[paramInt6][0] * arrayOfDouble7[(paramInt1 * 0 + i5)] + arrayOfDouble2[paramInt6][1] * arrayOfDouble7[(paramInt1 * 1 + i5)] + arrayOfDouble2[paramInt6][2] * arrayOfDouble7[(paramInt1 * 2 + i5)] + arrayOfDouble2[paramInt6][3] * arrayOfDouble7[(paramInt1 * 3 + i5)] + arrayOfDouble2[paramInt6][4] * arrayOfDouble7[(paramInt1 * 4 + i5)] + arrayOfDouble2[paramInt6][5] * arrayOfDouble7[(paramInt1 * 5 + i5)] + arrayOfDouble2[paramInt6][6] * arrayOfDouble7[(paramInt1 * 6 + i5)] + arrayOfDouble2[paramInt6][7] * arrayOfDouble7[(paramInt1 * 7 + i5)] + arrayOfDouble2[paramInt6][8] * arrayOfDouble7[(paramInt1 * 8 + i5)]);
                i5 += arrayOfInt2[i3];
                paramInt6 = i3 + 1;
                i3 = paramInt6;
                if (paramInt6 == i21) {
                  i3 = 0;
                }
                i4 += 1;
              }
            }
          }
          arrayOfDouble6[i10][i5] = d1;
          i4 += arrayOfInt2[i3];
          paramInt6 = i3 + 1;
          i3 = paramInt6;
          if (paramInt6 == i21) {
            i3 = 0;
          }
          i5 += 1;
        }
        label2181:
        i3 = i12;
        while (i3 < i18)
        {
          arrayOfDouble6[i10][i3] = 0L;
          i3 += 1;
        }
        this.a.rdft(i18, 1, arrayOfDouble6[i10], arrayOfInt3, arrayOfDouble4);
        arrayOfDouble6[i10][0] = (arrayOfDouble3[0] * arrayOfDouble6[i10][0]);
        arrayOfDouble6[i10][1] = (arrayOfDouble3[1] * arrayOfDouble6[i10][1]);
        i3 = 1;
        while (i3 < i18 / 2)
        {
          d1 = arrayOfDouble3[(i3 * 2)];
          d2 = arrayOfDouble6[i10][(i3 * 2)];
          d3 = arrayOfDouble3[(i3 * 2 + 1)];
          d4 = arrayOfDouble6[i10][(i3 * 2 + 1)];
          d5 = arrayOfDouble3[(i3 * 2 + 1)];
          double d6 = arrayOfDouble6[i10][(i3 * 2)];
          double d7 = arrayOfDouble3[(i3 * 2)];
          double d8 = arrayOfDouble6[i10][(i3 * 2 + 1)];
          arrayOfDouble6[i10][(i3 * 2)] = (d1 * d2 - d3 * d4);
          arrayOfDouble6[i10][(i3 * 2 + 1)] = (d5 * d6 + d7 * d8);
          i3 += 1;
        }
        this.a.rdft(i18, -1, arrayOfDouble6[i10], arrayOfInt3, arrayOfDouble4);
        i4 = 0;
        i3 = n;
        while (i3 < i12)
        {
          arrayOfDouble8[(i4 * paramInt1 + i10)] = (arrayOfDouble5[i10][i4] + arrayOfDouble6[i10][i3]);
          i3 += i1;
          i4 += 1;
        }
        i11 = 0;
        i5 = i3;
        while (i5 < i18)
        {
          arrayOfDouble5[i10][i11] = arrayOfDouble6[i10][i5];
          i5 += i1;
          i11 += 1;
        }
        i11 = i10 + 1;
        i10 = i4;
        i3 -= i12;
        i4 = paramInt6;
        paramInt6 = i5;
        i5 = i3;
        i3 = i10;
        i10 = i11;
      }
      label2586:
      i10 = i9 + paramInt4 / i14 * i12 / i1;
      localByteBuffer2.clear();
      if (paramBoolean)
      {
        m = 0;
        paramInt6 = m;
        if (m < i3 * paramInt1)
        {
          if (arrayOfDouble8[m] > 0.0D)
          {
            d1 = arrayOfDouble8[m];
            label2646:
            if (arrayOfDouble1[0] >= d1) {
              break label2698;
            }
          }
          for (;;)
          {
            arrayOfDouble1[0] = d1;
            localByteBuffer2.asDoubleBuffer().put(m, arrayOfDouble8[m]);
            m += 1;
            break;
            d1 = -arrayOfDouble8[m];
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
      label3972:
      for (;;)
      {
        if (k == 0) {
          if (i8 != 0) {
            if (i13 * paramInt5 / paramInt4 + 2.0D > i2 + i3)
            {
              localByteBuffer2.position(0);
              localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
              b(paramOutputStream, localByteBuffer2);
              n = i2 + i3;
              m = j;
              j = n;
            }
          }
        }
        for (;;)
        {
          n = (i10 - 1) / (i15 / paramInt4);
          if (($assertionsDisabled) || (i19 >= n)) {
            break label3879;
          }
          throw new AssertionError();
          d2 = paramDouble * 127.0D;
          i9 = 0;
          paramInt6 = 0;
          if (paramInt6 < i3 * paramInt1)
          {
            if (paramInt7 != 0) {
              n = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble1, paramInt7, i9);
            }
            label2985:
            do
            {
              localByteBuffer2.put(paramInt6, (byte)(n + 128));
              n = i9 + 1;
              m = n;
              if (n == paramInt1) {
                m = 0;
              }
              paramInt6 += 1;
              i9 = m;
              break;
              n = a(arrayOfDouble8[paramInt6] * d2);
              m = n;
              if (n < -128)
              {
                d1 = n / -128.0D;
                if (arrayOfDouble1[0] >= d1) {
                  break label3038;
                }
                arrayOfDouble1[0] = d1;
                m = -128;
              }
              n = m;
            } while (127 >= m);
            d1 = m / 127.0D;
            if (arrayOfDouble1[0] < d1) {}
            for (;;)
            {
              arrayOfDouble1[0] = d1;
              n = 127;
              break;
              label3038:
              d1 = arrayOfDouble1[0];
              break label2985;
              d1 = arrayOfDouble1[0];
            }
          }
          break;
          d2 = paramDouble * 32767.0D;
          i9 = 0;
          paramInt6 = 0;
          if (paramInt6 < i3 * paramInt1)
          {
            if (paramInt7 != 0) {
              n = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble1, paramInt7, i9);
            }
            label3205:
            do
            {
              localByteBuffer2.order(this.byteOrder).asShortBuffer().put(paramInt6, (short)n);
              n = i9 + 1;
              m = n;
              if (n == paramInt1) {
                m = 0;
              }
              paramInt6 += 1;
              i9 = m;
              break;
              n = a(arrayOfDouble8[paramInt6] * d2);
              m = n;
              if (n < -32768)
              {
                d1 = n / -32768.0D;
                if (arrayOfDouble1[0] >= d1) {
                  break label3261;
                }
                arrayOfDouble1[0] = d1;
                m = -32768;
              }
              n = m;
            } while (32767 >= m);
            d1 = m / 32767.0D;
            if (arrayOfDouble1[0] < d1) {}
            for (;;)
            {
              arrayOfDouble1[0] = d1;
              n = 32767;
              break;
              label3261:
              d1 = arrayOfDouble1[0];
              break label3205;
              d1 = arrayOfDouble1[0];
            }
          }
          break;
          d2 = paramDouble * 8388607.0D;
          i9 = 0;
          paramInt6 = 0;
          if (paramInt6 >= i3 * paramInt1) {
            break label3972;
          }
          if (paramInt7 != 0) {
            n = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble1, paramInt7, i9);
          }
          label3472:
          do
          {
            localByteBuffer2.put(paramInt6 * 3, (byte)(n & 0xFF));
            m = n >> 8;
            localByteBuffer2.put(paramInt6 * 3 + 1, (byte)(m & 0xFF));
            localByteBuffer2.put(paramInt6 * 3 + 2, (byte)(m >> 8 & 0xFF));
            n = i9 + 1;
            m = n;
            if (n == paramInt1) {
              m = 0;
            }
            paramInt6 += 1;
            i9 = m;
            break;
            n = a(arrayOfDouble8[paramInt6] * d2);
            m = n;
            if (n < -8388608)
            {
              d1 = n / -8388608.0D;
              if (arrayOfDouble1[0] >= d1) {
                break label3528;
              }
              arrayOfDouble1[0] = d1;
              m = -8388608;
            }
            n = m;
          } while (8388607 >= m);
          d1 = m / 8388607.0D;
          if (arrayOfDouble1[0] < d1) {}
          for (;;)
          {
            arrayOfDouble1[0] = d1;
            n = 8388607;
            break;
            label3528:
            d1 = arrayOfDouble1[0];
            break label3472;
            d1 = arrayOfDouble1[0];
          }
          localByteBuffer2.position(0);
          paramInt1 = (int)(paramInt3 * paramInt1 * (Math.floor(i13 * paramInt5 / paramInt4) + 2.0D - i2));
          if (paramInt1 > 0)
          {
            localByteBuffer2.limit(paramInt1);
            b(paramOutputStream, localByteBuffer2);
          }
          for (;;)
          {
            v(1.0D);
            return arrayOfDouble1[0];
            localByteBuffer2.position(0);
            localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
            b(paramOutputStream, localByteBuffer2);
            n = i2 + i3;
            m = j;
            j = n;
            break;
            if (i3 < j)
            {
              m = j - i3;
              j = i2;
              break;
            }
            if (i8 == 0) {
              break label3822;
            }
            if (i13 * paramInt5 / paramInt4 + 2.0D > i2 + i3 - j)
            {
              localByteBuffer2.position(paramInt3 * paramInt1 * j);
              localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
              b(paramOutputStream, localByteBuffer2);
              n = i3 - j + i2;
              m = j;
              j = n;
              break;
            }
            localByteBuffer2.position(paramInt3 * paramInt1 * j);
            localByteBuffer2.limit((int)(paramInt3 * paramInt1 * (Math.floor(i13 * paramInt5 / paramInt4) + 2.0D - i2)));
            b(paramOutputStream, localByteBuffer2);
          }
          label3822:
          localByteBuffer2.position(paramInt3 * paramInt1 * j);
          localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
          b(paramOutputStream, localByteBuffer2);
          n = i3 - j + i2;
          k = 0;
          m = j;
          j = n;
        }
        label3879:
        System.arraycopy(arrayOfDouble7, paramInt1 * n, arrayOfDouble7, 0, (i19 - n) * paramInt1);
        i8 = i19 - n;
        i9 = i10 - n * (i15 / paramInt4);
        if ((i6 & 0x7) == 7) {
          v(i13 / i7);
        }
        i10 = m;
        i6 += 1;
        n = i5;
        m = i4;
        i5 = i13;
        i2 = j;
        j = i10;
        break;
      }
    }
  }
  
  public int a(double paramDouble, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      arrayOfDouble = this.h;
      paramInt1 = this.buh;
      this.buh = (paramInt1 + 1);
      d1 = arrayOfDouble[(paramInt1 & 0xFFFF)] + paramDouble;
      paramDouble = d1;
      if (d1 < this.buf)
      {
        paramDouble = d1 / this.buf;
        if (paramArrayOfDouble[0] < paramDouble)
        {
          paramArrayOfDouble[0] = paramDouble;
          paramDouble = this.buf;
        }
      }
      else
      {
        d1 = paramDouble;
        if (paramDouble > this.bug)
        {
          paramDouble /= this.bug;
          if (paramArrayOfDouble[0] >= paramDouble) {
            break label134;
          }
        }
      }
      for (;;)
      {
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.bug;
        return a(d1);
        paramDouble = paramArrayOfDouble[0];
        break;
        label134:
        paramDouble = paramArrayOfDouble[0];
      }
    }
    double d1 = 0.0D;
    paramInt1 = 0;
    while (paramInt1 < this.bue)
    {
      d1 += b[this.bud][paramInt1] * this.c[paramInt2][paramInt1];
      paramInt1 += 1;
    }
    double d2 = d1 + paramDouble;
    double[] arrayOfDouble = this.h;
    paramInt1 = this.buh;
    this.buh = (paramInt1 + 1);
    paramDouble = d2 + arrayOfDouble[(paramInt1 & 0xFFFF)];
    paramInt1 = this.bue - 2;
    while (paramInt1 >= 0)
    {
      this.c[paramInt2][(paramInt1 + 1)] = this.c[paramInt2][paramInt1];
      paramInt1 -= 1;
    }
    if (paramDouble < this.buf)
    {
      paramDouble /= this.buf;
      if (paramArrayOfDouble[0] < paramDouble)
      {
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.buf;
        this.c[paramInt2][0] = (d1 - d2);
        if (this.c[paramInt2][0] > 1.0D) {
          this.c[paramInt2][0] = 4607182418800017408L;
        }
        paramDouble = d1;
        if (this.c[paramInt2][0] < -1.0D)
        {
          this.c[paramInt2][0] = -4616189618054758400L;
          paramDouble = d1;
        }
      }
    }
    for (;;)
    {
      return (int)paramDouble;
      paramDouble = paramArrayOfDouble[0];
      break;
      if (paramDouble > this.bug)
      {
        paramDouble /= this.bug;
        if (paramArrayOfDouble[0] < paramDouble) {}
        for (;;)
        {
          paramArrayOfDouble[0] = paramDouble;
          d1 = this.bug;
          this.c[paramInt2][0] = (d1 - d2);
          if (this.c[paramInt2][0] > 1.0D) {
            this.c[paramInt2][0] = 4607182418800017408L;
          }
          paramDouble = d1;
          if (this.c[paramInt2][0] >= -1.0D) {
            break;
          }
          this.c[paramInt2][0] = -4616189618054758400L;
          paramDouble = d1;
          break;
          paramDouble = paramArrayOfDouble[0];
        }
      }
      paramDouble = a(paramDouble);
      this.c[paramInt2][0] = (paramDouble - d2);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble)
  {
    int[] arrayOfInt = new int[97];
    int j = 1;
    for (;;)
    {
      if ((j >= 6) || (paramInt1 == er[j]))
      {
        if (((paramInt5 == 3) || (paramInt5 == 4)) && (j == 6)) {
          System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", new Object[] { Integer.valueOf(paramInt1) });
        }
        if (paramInt5 != 2)
        {
          paramInt1 = j;
          if (j != 6) {}
        }
        else
        {
          paramInt1 = 0;
        }
        j = paramInt1;
        if (paramInt5 == 4) {
          if (paramInt1 != 1)
          {
            j = paramInt1;
            if (paramInt1 != 2) {}
          }
          else
          {
            j = paramInt1 + 5;
          }
        }
        this.bud = j;
        this.c = new double[paramInt2][];
        this.bue = es[this.bud];
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          this.c[paramInt1] = new double[this.bue];
          paramInt1 += 1;
        }
      }
      j += 1;
    }
    this.buf = paramInt3;
    this.bug = paramInt4;
    this.h = new double[65536];
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
      this.buh = 0;
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
        this.h[paramInt1] = ((paramInt3 / 2147483647.0D - 0.5D) * paramDouble);
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
        this.h[paramInt1] = ((paramInt2 / 2147483647.0D - paramInt4 / 2147483647.0D) * paramDouble);
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
        this.h[paramInt2] = (paramDouble * d1 * Math.cos(d2));
      }
      for (;;)
      {
        paramInt2 += 1;
        break label428;
        break;
        label561:
        paramInt1 = 0;
        this.h[paramInt2] = (paramDouble * d1 * Math.sin(d2));
      }
    }
    return et[this.bud];
  }
  
  public double b(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
    throws IOException
  {
    double[] arrayOfDouble2 = new double[1];
    arrayOfDouble2[0] = 0.0D;
    int i2 = this.buc;
    double d2 = this.bq;
    int i1 = gcd(paramInt4, paramInt5);
    int n;
    int i18;
    double d1;
    if (paramInt5 / i1 == 1)
    {
      n = 1;
      i18 = paramInt4 * n;
      if (d2 > 21.0D) {
        break label264;
      }
      d1 = 0.9222D;
      label65:
      j = 1;
    }
    int k;
    int m;
    double d4;
    double d3;
    for (;;)
    {
      k = i2 * j;
      m = k;
      if (k % 2 == 0) {
        m = k - 1;
      }
      d4 = i18 * d1 / (m - 1);
      d3 = (paramInt5 - d4) / 2.0D;
      if (d4 < this.br)
      {
        d1 = g(d2);
        d2 = rqy.value(d1);
        j = 1;
        while (j < m) {
          j *= 2;
        }
        if (paramInt5 / i1 % 2 == 0)
        {
          n = 2;
          break;
        }
        if (paramInt5 / i1 % 3 == 0)
        {
          n = 3;
          break;
        }
        throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt5 / i1) }));
        label264:
        d1 = (d2 - 7.95D) / 14.359999999999999D;
        break label65;
      }
      j *= 2;
    }
    int i19 = j * 2;
    double[] arrayOfDouble3 = new double[i19];
    int j = -(m / 2);
    while (j <= m / 2)
    {
      arrayOfDouble3[(j + m / 2)] = (a(j, m, d1, d2) * a(j, d3, i18) * i18 / paramInt4 / i19 * 2.0D);
      j += 1;
    }
    int[] arrayOfInt3 = new int[(int)(2.0D + Math.sqrt(i19))];
    arrayOfInt3[0] = 0;
    double[] arrayOfDouble4 = new double[i19 / 2];
    this.a.rdft(i19, 1, arrayOfDouble3, arrayOfInt3, arrayOfDouble4);
    double[][] arrayOfDouble1;
    int[] arrayOfInt2;
    int i6;
    int i7;
    int i8;
    int[] arrayOfInt1;
    if (n == 1)
    {
      k = paramInt4 / i1;
      i1 = paramInt4 / paramInt5;
      arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 1, 1 });
      arrayOfDouble1[0][0] = 4607182418800017408L;
      arrayOfInt2 = new int[] { 0 };
      i6 = 1;
      i7 = 1;
      i8 = k * paramInt5;
      k = 1;
      arrayOfInt1 = new int[] { i1 };
    }
    for (;;)
    {
      bvU();
      int i9 = i19 / 2;
      double[][] arrayOfDouble5 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, i19 });
      double[][] arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, i7 + 1 + i9 });
      ByteBuffer localByteBuffer1 = ByteBuffer.allocate((i9 / n + n + 1) * paramInt1 * paramInt2);
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate((int)((i9 * paramInt5 / paramInt4 + 1.0D) * (paramInt3 * paramInt1)));
      double[] arrayOfDouble7 = new double[(i9 / n + n + 1) * paramInt1];
      double[] arrayOfDouble8 = new double[(int)(paramInt1 * (i9 * paramInt5 / paramInt4 + 1.0D))];
      d1 = m / 2.0D / (i18 / paramInt5);
      k = (int)(k / 2.0D / (i8 / paramInt5) + d1);
      int i5 = 0;
      i1 = 0;
      int i12 = 1;
      int i3 = 0;
      int i10 = 0;
      int i13 = 0;
      m = j;
      i2 = 0;
      int i4 = 0;
      int i11 = paramInt6;
      j = k;
      k = i12;
      paramInt6 = m;
      m = i4;
      i4 = (i9 - 0 - 1) / n + 1;
      i12 = i4;
      if (i4 + i5 > i11) {
        i12 = i11 - i5;
      }
      localByteBuffer1.position(0);
      localByteBuffer1.limit(paramInt2 * paramInt1 * i12);
      Object localObject = new byte[localByteBuffer1.limit()];
      int i14 = paramInputStream.read((byte[])localObject);
      i4 = i14;
      if (i14 < 0) {
        i4 = 0;
      }
      if (i4 < localByteBuffer1.limit()) {
        i11 = i5 + i4 / paramInt2 * paramInt1;
      }
      localByteBuffer1.limit(i4);
      localByteBuffer1 = ByteBuffer.wrap((byte[])localObject);
      localByteBuffer1.position(i4);
      localByteBuffer1.flip();
      i14 = i4 / (paramInt2 * paramInt1);
      switch (paramInt2)
      {
      }
      double d5;
      while (paramInt6 < paramInt1 * i12)
      {
        arrayOfDouble7[paramInt6] = 0.0D;
        paramInt6 += 1;
        continue;
        d4 = this.bq;
        i8 = paramInt4 / i1 * paramInt5;
        d5 = (i18 / 2 - paramInt4 / 2) * 2 / 2.0D;
        d2 = paramInt4 / 2;
        d3 = (i18 / 2 - paramInt4 / 2) / 2.0D;
        if (d4 <= 21.0D) {}
        for (d1 = 0.9222D;; d1 = (d4 - 7.95D) / 14.359999999999999D)
        {
          k = (int)(d1 * (i8 / d5) + 1.0D);
          j = k;
          if (k % 2 == 0) {
            j = k + 1;
          }
          d1 = g(d4);
          d4 = rqy.value(d1);
          i6 = i8 / i18;
          i7 = j / i6 + 1;
          arrayOfInt2 = new int[i6];
          k = 0;
          while (k < i6)
          {
            arrayOfInt2[k] = (i8 / i18 - i8 / paramInt5 * k % (i8 / i18));
            if (arrayOfInt2[k] == i8 / i18) {
              arrayOfInt2[k] = 0;
            }
            k += 1;
          }
        }
        arrayOfInt1 = new int[i6];
        k = 0;
        if (k < i6)
        {
          arrayOfInt1[k] = ((i8 / paramInt5 - arrayOfInt2[k]) / (i8 / i18) + 1);
          if (k + 1 == i6) {}
          for (i1 = 0;; i1 = k + 1)
          {
            if (arrayOfInt2[i1] == 0) {
              arrayOfInt1[k] -= 1;
            }
            k += 1;
            break;
          }
        }
        arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { i6, i7 });
        k = -(j / 2);
        while (k <= j / 2)
        {
          arrayOfDouble1[((j / 2 + k) % i6)][((j / 2 + k) / i6)] = (a(k, j, d1, d4) * a(k, d2 + d3, i8) * i8 / i18);
          k += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i14 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i4)] = (0.0078740157480315D * ((localByteBuffer1.get(i4) & 0xFF) - 128));
          i4 += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i14 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i4)] = (3.051850947599719E-005D * localByteBuffer1.order(this.byteOrder).asShortBuffer().get(i4));
          i4 += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i14 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i4)] = (1.192093037616377E-007D * ((localByteBuffer1.get(i4 * 3) & 0xFF) << 0 | (localByteBuffer1.get(i4 * 3 + 1) & 0xFF) << 8 | (localByteBuffer1.get(i4 * 3 + 2) & 0xFF) << 16));
          i4 += 1;
        }
        i4 = 0;
        for (;;)
        {
          paramInt6 = i4;
          if (i4 >= i14 * paramInt1) {
            break;
          }
          arrayOfDouble7[(paramInt1 * 0 + i4)] = (4.656612875245797E-010D * localByteBuffer1.order(this.byteOrder).getInt(i4));
          i4 += 1;
        }
      }
      int i17 = i5 + i14;
      if ((paramInputStream.available() < 0) || (i17 >= i11))
      {
        i12 = 1;
        i5 = i3;
        i4 = m;
        i14 = 0;
        i3 = i2;
        i2 = i5;
      }
      for (;;)
      {
        if (i14 >= paramInt1) {
          break label2388;
        }
        int i15 = 0;
        paramInt6 = 0;
        for (;;)
        {
          if (paramInt6 >= i9) {
            break label1773;
          }
          if ((!$assertionsDisabled) && (i15 >= (i9 - 0 - 1) / n + 1))
          {
            throw new AssertionError();
            i12 = 0;
            break;
          }
          arrayOfDouble5[i14][paramInt6] = arrayOfDouble7[(i15 * paramInt1 + i14)];
          i3 = paramInt6 + 1;
          while (i3 < paramInt6 + n)
          {
            arrayOfDouble5[i14][i3] = 0L;
            i3 += 1;
          }
          paramInt6 += n;
          i15 += 1;
        }
        label1773:
        assert (i15 == (i9 - 0 - 1) / n + 1);
        paramInt6 = i9;
        while (paramInt6 < i19)
        {
          arrayOfDouble5[i14][paramInt6] = 0L;
          paramInt6 += 1;
        }
        this.a.rdft(i19, 1, arrayOfDouble5[i14], arrayOfInt3, arrayOfDouble4);
        arrayOfDouble5[i14][0] = (arrayOfDouble3[0] * arrayOfDouble5[i14][0]);
        arrayOfDouble5[i14][1] = (arrayOfDouble3[1] * arrayOfDouble5[i14][1]);
        paramInt6 = 1;
        while (paramInt6 < i9)
        {
          d1 = arrayOfDouble3[(paramInt6 * 2)];
          d2 = arrayOfDouble5[i14][(paramInt6 * 2)];
          d3 = arrayOfDouble3[(paramInt6 * 2 + 1)];
          d4 = arrayOfDouble5[i14][(paramInt6 * 2 + 1)];
          d5 = arrayOfDouble3[(paramInt6 * 2 + 1)];
          double d6 = arrayOfDouble5[i14][(paramInt6 * 2)];
          double d7 = arrayOfDouble3[(paramInt6 * 2)];
          double d8 = arrayOfDouble5[i14][(paramInt6 * 2 + 1)];
          arrayOfDouble5[i14][(paramInt6 * 2)] = (d1 * d2 - d3 * d4);
          arrayOfDouble5[i14][(paramInt6 * 2 + 1)] = (d5 * d6 + d7 * d8);
          paramInt6 += 1;
        }
        this.a.rdft(i19, -1, arrayOfDouble5[i14], arrayOfInt3, arrayOfDouble4);
        i5 = 0;
        while (i5 < i9)
        {
          localObject = arrayOfDouble6[i14];
          paramInt6 = i7 + 1 + i5;
          localObject[paramInt6] += arrayOfDouble5[i14][i5];
          i5 += 1;
        }
        i3 = i13 / (i8 / i18);
        paramInt6 = i3;
        if (i13 % (i8 / i18) != 0) {
          paramInt6 = i3 + 1;
        }
        i3 = arrayOfDouble6[0].length * i14 + paramInt6;
        paramInt6 = 0;
        i4 = m;
        while (i3 - arrayOfDouble6[0].length * i14 < i9 + 1)
        {
          int i21 = arrayOfInt2[i4];
          int i20 = arrayOfInt1[i4];
          i5 = i4 + 1;
          i4 = i5;
          if (i5 == i6) {
            i4 = 0;
          }
          assert ((i3 - arrayOfDouble6[0].length * i14) * (i8 / i18) - (i8 / paramInt5 * paramInt6 + i13) == i21);
          i5 = 0;
          d1 = 0.0D;
          int i16 = i3;
          while (i5 < i7)
          {
            d1 += arrayOfDouble1[i21][i5] * arrayOfDouble6[(i16 / arrayOfDouble6[0].length)][(i16 % arrayOfDouble6[0].length)];
            i16 += 1;
            i5 += 1;
          }
          arrayOfDouble8[(paramInt6 * paramInt1 + 0 + i14)] = d1;
          paramInt6 += 1;
          i3 = i20 + i3;
        }
        i2 += i15;
        i3 = paramInt6;
        i14 += 1;
        paramInt6 = i5;
      }
      label2388:
      i14 = i13 + i8 / paramInt5 * i3;
      localByteBuffer2.clear();
      if (paramBoolean)
      {
        m = 0;
        paramInt6 = m;
        if (m < i3 * paramInt1)
        {
          if (arrayOfDouble8[m] > 0.0D)
          {
            d1 = arrayOfDouble8[m];
            label2445:
            if (arrayOfDouble2[0] >= d1) {
              break label2497;
            }
          }
          for (;;)
          {
            arrayOfDouble2[0] = d1;
            localByteBuffer2.asDoubleBuffer().put(m, arrayOfDouble8[m]);
            m += 1;
            break;
            d1 = -arrayOfDouble8[m];
            break label2445;
            label2497:
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
      label3846:
      for (;;)
      {
        if (k == 0) {
          if (i12 != 0) {
            if (i17 * paramInt5 / paramInt4 + 2.0D > i1 + i3)
            {
              localByteBuffer2.position(0);
              localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
              b(paramOutputStream, localByteBuffer2);
              i1 += i3;
              m = j;
              j = i1;
            }
          }
        }
        for (;;)
        {
          i5 = (i14 - 1) / (i8 / i18);
          i1 = i5;
          if (i5 > i9) {
            i1 = i9;
          }
          i5 = 0;
          while (i5 < paramInt1)
          {
            System.arraycopy(arrayOfDouble6[i5], i1, arrayOfDouble6[i5], 0, i7 + 1 + i9 - i1);
            i5 += 1;
          }
          d2 = paramDouble * 127.0D;
          i13 = 0;
          paramInt6 = 0;
          if (paramInt6 < i3 * paramInt1)
          {
            if (paramInt7 != 0) {
              i5 = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble2, paramInt7, i13);
            }
            label2823:
            do
            {
              localByteBuffer2.put(paramInt6, (byte)(i5 + 128));
              i5 = i13 + 1;
              m = i5;
              if (i5 == paramInt1) {
                m = 0;
              }
              paramInt6 += 1;
              i13 = m;
              break;
              i5 = a(arrayOfDouble8[paramInt6] * d2);
              m = i5;
              if (i5 < -128)
              {
                d1 = i5 / -128.0D;
                if (arrayOfDouble2[0] >= d1) {
                  break label2876;
                }
                arrayOfDouble2[0] = d1;
                m = -128;
              }
              i5 = m;
            } while (127 >= m);
            d1 = m / 127.0D;
            if (arrayOfDouble2[0] < d1) {}
            for (;;)
            {
              arrayOfDouble2[0] = d1;
              i5 = 127;
              break;
              label2876:
              d1 = arrayOfDouble2[0];
              break label2823;
              d1 = arrayOfDouble2[0];
            }
          }
          break;
          d2 = paramDouble * 32767.0D;
          i13 = 0;
          paramInt6 = 0;
          if (paramInt6 < i3 * paramInt1)
          {
            if (paramInt7 != 0) {
              i5 = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble2, paramInt7, i13);
            }
            label3043:
            do
            {
              localByteBuffer2.order(this.byteOrder).asShortBuffer().put(paramInt6, (short)i5);
              i5 = i13 + 1;
              m = i5;
              if (i5 == paramInt1) {
                m = 0;
              }
              paramInt6 += 1;
              i13 = m;
              break;
              i5 = a(arrayOfDouble8[paramInt6] * d2);
              m = i5;
              if (i5 < -32768)
              {
                d1 = i5 / -32768.0D;
                if (arrayOfDouble2[0] >= d1) {
                  break label3099;
                }
                arrayOfDouble2[0] = d1;
                m = -32768;
              }
              i5 = m;
            } while (32767 >= m);
            d1 = m / 32767.0D;
            if (arrayOfDouble2[0] < d1) {}
            for (;;)
            {
              arrayOfDouble2[0] = d1;
              i5 = 32767;
              break;
              label3099:
              d1 = arrayOfDouble2[0];
              break label3043;
              d1 = arrayOfDouble2[0];
            }
          }
          break;
          d2 = paramDouble * 8388607.0D;
          i13 = 0;
          paramInt6 = 0;
          if (paramInt6 >= i3 * paramInt1) {
            break label3846;
          }
          if (paramInt7 != 0) {
            i5 = a(arrayOfDouble8[paramInt6] * d2, arrayOfDouble2, paramInt7, i13);
          }
          label3310:
          do
          {
            localByteBuffer2.put(paramInt6 * 3, (byte)(i5 & 0xFF));
            m = i5 >> 8;
            localByteBuffer2.put(paramInt6 * 3 + 1, (byte)(m & 0xFF));
            localByteBuffer2.put(paramInt6 * 3 + 2, (byte)(m >> 8 & 0xFF));
            i5 = i13 + 1;
            m = i5;
            if (i5 == paramInt1) {
              m = 0;
            }
            paramInt6 += 1;
            i13 = m;
            break;
            i5 = a(arrayOfDouble8[paramInt6] * d2);
            m = i5;
            if (i5 < -8388608)
            {
              d1 = i5 / -8388608.0D;
              if (arrayOfDouble2[0] >= d1) {
                break label3366;
              }
              arrayOfDouble2[0] = d1;
              m = -8388608;
            }
            i5 = m;
          } while (8388607 >= m);
          d1 = m / 8388607.0D;
          if (arrayOfDouble2[0] < d1) {}
          for (;;)
          {
            arrayOfDouble2[0] = d1;
            i5 = 8388607;
            break;
            label3366:
            d1 = arrayOfDouble2[0];
            break label3310;
            d1 = arrayOfDouble2[0];
          }
          localByteBuffer2.position(0);
          paramInt1 = (int)(paramInt3 * paramInt1 * (Math.floor(i17 * paramInt5 / paramInt4) + 2.0D - i1));
          if (paramInt1 > 0)
          {
            localByteBuffer2.limit(paramInt1);
            b(paramOutputStream, localByteBuffer2);
          }
          for (;;)
          {
            v(1.0D);
            return arrayOfDouble2[0];
            localByteBuffer2.position(0);
            localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
            b(paramOutputStream, localByteBuffer2);
            i1 += i3;
            m = j;
            j = i1;
            break;
            if (i3 < j)
            {
              m = j - i3;
              j = i1;
              break;
            }
            if (i12 == 0) {
              break label3671;
            }
            if (i17 * paramInt5 / paramInt4 + 2.0D > i1 + i3 - j)
            {
              localByteBuffer2.position(paramInt3 * paramInt1 * j);
              localByteBuffer2.limit(paramInt3 * paramInt1 * (i3 - j));
              b(paramOutputStream, localByteBuffer2);
              i1 = i3 - j + i1;
              m = j;
              j = i1;
              break;
            }
            localByteBuffer2.position(paramInt3 * paramInt1 * j);
            localByteBuffer2.limit((int)(paramInt3 * paramInt1 * (Math.floor(i17 * paramInt5 / paramInt4) + 2.0D + i1 + i3 - j)));
            b(paramOutputStream, localByteBuffer2);
          }
          label3671:
          localByteBuffer2.position(paramInt3 * paramInt1 * j);
          localByteBuffer2.limit(paramInt3 * paramInt1 * i3);
          b(paramOutputStream, localByteBuffer2);
          i1 = i3 - j + i1;
          k = 0;
          m = j;
          j = i1;
        }
        i13 = i8 / i18;
        i5 = 0;
        while (i5 < paramInt1)
        {
          System.arraycopy(arrayOfDouble5[i5], i9, arrayOfDouble6[i5], i7 + 1, i9);
          i5 += 1;
        }
        if ((i10 & 0x7) == 7) {
          v(i17 / i11);
        }
        i12 = m;
        i10 += 1;
        m = i4;
        i5 = i17;
        i4 = i3;
        i13 = i14 - i1 * i13;
        i3 = i2;
        i2 = i4;
        i1 = j;
        j = i12;
        break;
      }
      i1 = k;
      k = j;
      j = i1;
    }
  }
  
  protected void b(OutputStream paramOutputStream, ByteBuffer paramByteBuffer)
  {
    try
    {
      paramOutputStream.write(b(paramByteBuffer));
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  protected byte[] b(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.limit() - paramByteBuffer.position()];
    paramByteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqz
 * JD-Core Version:    0.7.0.1
 */