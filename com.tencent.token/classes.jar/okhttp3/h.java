package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class h
{
  public static final h A;
  public static final h B;
  public static final h C;
  public static final h D;
  public static final h E;
  public static final h F;
  public static final h G;
  public static final h H;
  public static final h I;
  public static final h J;
  public static final h K;
  public static final h L;
  public static final h M;
  public static final h N;
  public static final h O;
  public static final h P;
  public static final h Q;
  public static final h R;
  public static final h S;
  public static final h T;
  public static final h U;
  public static final h V;
  public static final h W;
  public static final h X;
  public static final h Y;
  public static final h Z;
  static final Comparator<String> a = new Comparator()
  {
    public int a(String paramAnonymousString1, String paramAnonymousString2)
    {
      int i = 4;
      int j = Math.min(paramAnonymousString1.length(), paramAnonymousString2.length());
      if (i < j)
      {
        int k = paramAnonymousString1.charAt(i);
        int m = paramAnonymousString2.charAt(i);
        if (k != m) {
          if (k >= m) {}
        }
      }
      do
      {
        return -1;
        return 1;
        i += 1;
        break;
        i = paramAnonymousString1.length();
        j = paramAnonymousString2.length();
        if (i == j) {
          break label85;
        }
      } while (i < j);
      return 1;
      label85:
      return 0;
    }
  };
  public static final h aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
  public static final h aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
  public static final h aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
  public static final h aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
  public static final h aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
  public static final h aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
  public static final h aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
  public static final h aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
  public static final h aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
  public static final h aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
  public static final h aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
  public static final h aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
  public static final h aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
  public static final h aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
  public static final h aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
  public static final h aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
  public static final h aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
  public static final h aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
  public static final h aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
  public static final h aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
  public static final h aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
  public static final h aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
  public static final h aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
  public static final h aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
  public static final h aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
  public static final h aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
  public static final h aa;
  public static final h ab;
  public static final h ac;
  public static final h ad;
  public static final h ae;
  public static final h af;
  public static final h ag;
  public static final h ah;
  public static final h ai;
  public static final h aj;
  public static final h ak;
  public static final h al;
  public static final h am;
  public static final h an;
  public static final h ao;
  public static final h ap;
  public static final h aq;
  public static final h ar;
  public static final h as;
  public static final h at;
  public static final h au;
  public static final h av;
  public static final h aw;
  public static final h ax;
  public static final h ay;
  public static final h az;
  public static final h b;
  public static final h ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
  public static final h bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
  public static final h bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
  public static final h bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
  public static final h be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
  public static final h bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
  public static final h bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
  public static final h bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
  public static final h bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
  public static final h bj = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
  private static final Map<String, h> bl = new TreeMap(a);
  public static final h c;
  public static final h d;
  public static final h e;
  public static final h f;
  public static final h g;
  public static final h h;
  public static final h i;
  public static final h j;
  public static final h k;
  public static final h l;
  public static final h m;
  public static final h n;
  public static final h o;
  public static final h p;
  public static final h q;
  public static final h r;
  public static final h s;
  public static final h t;
  public static final h u;
  public static final h v;
  public static final h w;
  public static final h x;
  public static final h y;
  public static final h z;
  final String bk;
  
  static
  {
    b = a("SSL_RSA_WITH_NULL_MD5", 1);
    c = a("SSL_RSA_WITH_NULL_SHA", 2);
    d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    e = a("SSL_RSA_WITH_RC4_128_MD5", 4);
    f = a("SSL_RSA_WITH_RC4_128_SHA", 5);
    g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    M = a("TLS_RSA_WITH_NULL_SHA256", 59);
    N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    ap = a("TLS_FALLBACK_SCSV", 22016);
    aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
  }
  
  private h(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.bk = paramString;
  }
  
  static List<h> a(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(a(paramVarArgs[i1]));
      i1 += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public static h a(String paramString)
  {
    try
    {
      h localh2 = (h)bl.get(paramString);
      h localh1 = localh2;
      if (localh2 == null)
      {
        localh1 = new h(paramString);
        bl.put(paramString, localh1);
      }
      return localh1;
    }
    finally {}
  }
  
  private static h a(String paramString, int paramInt)
  {
    return a(paramString);
  }
  
  public String toString()
  {
    return this.bk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.h
 * JD-Core Version:    0.7.0.1
 */