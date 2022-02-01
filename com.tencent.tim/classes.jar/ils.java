import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class ils
{
  public static String NI;
  public static String NJ;
  public static String NK;
  public static String NM;
  public static String NN;
  public static String NO;
  public static String NP;
  public static String NQ;
  public static String NR;
  public static String NS;
  public static String NT;
  public static String NU;
  public static String NV;
  public static String NW;
  public static String NX;
  public static String NY;
  public static String NZ;
  public static String Oa;
  public static String Ob;
  public static String Oc;
  public static String Od;
  public static String Oe;
  public static String Of;
  public static String Og;
  public static String Oh;
  public static String Oi;
  public byte I;
  public byte M;
  public byte N;
  public byte O;
  public byte P;
  public byte Q;
  public byte R;
  public byte S;
  public byte T;
  public byte U;
  public byte V;
  public byte W;
  public byte X;
  public byte Y;
  public byte Z;
  @Deprecated
  imf a = null;
  public byte aa;
  public byte ab;
  public byte ac;
  public byte ad;
  public byte ae;
  public byte af;
  public byte ag;
  public int aoJ;
  public int aoK;
  public int aoL;
  public int aoM;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    NI = "sharp/camera_angle/" + "enable";
    localStringBuilder.setLength(0);
    NJ = "sharp/camera_angle/" + "local/" + "front";
    localStringBuilder.setLength(0);
    NK = "sharp/camera_angle/" + "local/" + "back";
    localStringBuilder.setLength(0);
    NM = "sharp/camera_angle/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    NN = "sharp/camera_angle/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    NO = "sharp/camera_angle/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    NP = "sharp/camera_angle/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    NQ = "sharp/camera_angle/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    NR = "sharp/camera_angle/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    NS = "sharp/camera_angle/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    NT = "sharp/camera_angle/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    NU = "sharp/camera_angle/" + "sensor";
    localStringBuilder.setLength(0);
    NV = "sharp/camera_angle/" + "mini_sdk";
    localStringBuilder.setLength(0);
    NW = "sharp/camera_angle_landscape/" + "enable";
    localStringBuilder.setLength(0);
    NX = "sharp/camera_angle_landscape/" + "local/" + "front";
    localStringBuilder.setLength(0);
    NY = "sharp/camera_angle_landscape/" + "local/" + "back";
    localStringBuilder.setLength(0);
    NZ = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "0";
    localStringBuilder.setLength(0);
    Oa = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "90";
    localStringBuilder.setLength(0);
    Ob = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "180";
    localStringBuilder.setLength(0);
    Oc = "sharp/camera_angle_landscape/" + "remote/" + "front/" + "270";
    localStringBuilder.setLength(0);
    Od = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "0";
    localStringBuilder.setLength(0);
    Oe = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "90";
    localStringBuilder.setLength(0);
    Of = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "180";
    localStringBuilder.setLength(0);
    Og = "sharp/camera_angle_landscape/" + "remote/" + "back/" + "270";
    localStringBuilder.setLength(0);
    Oh = "sharp/camera_angle_landscape/" + "sensor";
    localStringBuilder.setLength(0);
    Oi = "sharp/camera_angle_landscape/" + "mini_sdk";
    localStringBuilder.setLength(0);
  }
  
  private byte b(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -128) || (paramInt > 127)) {
      throw new IllegalArgumentException(paramInt + " out of the range of byte");
    }
    return (byte)paramInt;
  }
  
  public boolean a(imf paramimf)
  {
    return paramimf.getIntValue(NI, this.aoJ) >= 1;
  }
  
  public boolean b(imf paramimf)
  {
    boolean bool2 = false;
    if (a(paramimf)) {}
    for (;;)
    {
      try
      {
        this.aoK = paramimf.getIntValue(NV, this.aoK);
        if (Build.VERSION.SDK_INT < this.aoK) {
          continue;
        }
        this.I = b(paramimf.getIntValue(NJ, this.I));
        this.M = b(paramimf.getIntValue(NK, this.M));
        this.N = b(paramimf.getIntValue(NM, this.N));
        this.O = b(paramimf.getIntValue(NN, this.O));
        this.P = b(paramimf.getIntValue(NO, this.P));
        this.Q = b(paramimf.getIntValue(NP, this.Q));
        this.R = b(paramimf.getIntValue(NQ, this.R));
        this.S = b(paramimf.getIntValue(NR, this.S));
        this.T = b(paramimf.getIntValue(NS, this.T));
        this.U = b(paramimf.getIntValue(NT, this.U));
        this.V = b(paramimf.getIntValue(NU, this.V));
        bool1 = true;
      }
      catch (Exception paramimf)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraConfigParser", 2, "parse camera angle config error, reset data.", paramimf);
        this.I = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.aoK = 0;
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraConfigParser", 2, "value_local_front:" + this.I + ", value_local_back:" + this.M + ", value_remote_front_0:" + this.N + ", value_remote_front_90:" + this.O + ", value_remote_front_180:" + this.P + ", value_remote_front_270:" + this.Q + ", value_remote_back_0:" + this.R + ", value_remote_back_90:" + this.S + ", value_remote_back_180:" + this.T + ", value_remote_back_270:" + this.U + ", value_sensor:" + this.V + ", value_minisdk:" + this.aoK);
      }
      return bool1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "ignore camera angle config: sdk version not in range, miniSdk:" + this.aoK);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraConfigParser", 2, "camera angle config disable, return");
          bool1 = bool2;
        }
      }
    }
  }
  
  public boolean c(imf paramimf)
  {
    return paramimf.getIntValue(NW, this.aoL) >= 1;
  }
  
  public boolean d(imf paramimf)
  {
    boolean bool2 = false;
    if (c(paramimf)) {}
    for (;;)
    {
      try
      {
        this.aoM = paramimf.getIntValue(Oi, this.aoM);
        if (Build.VERSION.SDK_INT < this.aoM) {
          continue;
        }
        this.W = b(paramimf.getIntValue(NX, this.W));
        this.X = b(paramimf.getIntValue(NY, this.X));
        this.Y = b(paramimf.getIntValue(NZ, this.Y));
        this.Z = b(paramimf.getIntValue(Oa, this.Z));
        this.aa = b(paramimf.getIntValue(Ob, this.aa));
        this.ab = b(paramimf.getIntValue(Oc, this.ab));
        this.ac = b(paramimf.getIntValue(Od, this.ac));
        this.ad = b(paramimf.getIntValue(Oe, this.ad));
        this.ae = b(paramimf.getIntValue(Of, this.ae));
        this.af = b(paramimf.getIntValue(Og, this.af));
        this.ag = b(paramimf.getIntValue(Oh, this.ag));
        bool1 = true;
      }
      catch (Exception paramimf)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraConfigParser", 2, "parse camera landscape angle config error, reset data.", paramimf);
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = 0;
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = 0;
        this.aoM = 0;
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraConfigParser", 2, "value_landscape_local_front:" + this.W + ", value_landscape_local_back:" + this.X + ", value_landscape_remote_front_0:" + this.Y + ", value_landscape_remote_front_90:" + this.Z + ", value_landscape_remote_front_180:" + this.aa + ", value_landscape_remote_front_270:" + this.ab + ", value_landscape_remote_back_0:" + this.ac + ", value_landscape_remote_back_90:" + this.ad + ", value_landscape_remote_back_180:" + this.ae + ", value_landscape_remote_back_270:" + this.af + ", value_landscape_sensor:" + this.ag + ", value_landscape_minisdk:" + this.aoM);
      }
      return bool1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("CameraConfigParser", 2, "ignore camera landscape angle config: sdk version not in range, miniSdk:" + this.aoM);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraConfigParser", 2, "camera landscape angle config disable");
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ils
 * JD-Core Version:    0.7.0.1
 */