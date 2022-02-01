package com.huawei.hms.push.a;

import android.util.SparseArray;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

public enum a
{
  private static final SparseArray<a> ao;
  private int ap;
  private int aq;
  private String ar;
  
  static
  {
    A = new a("ERROR_PUSH_NOT_IN_SERVICE", 26, 807135005, 907135005, "not int service");
    B = new a("ERROR_SPUSH_ESSION_INVALID", 27, 807135006, 907135006, "session invalid");
    C = new a("ERROR_ARGUMENTS_INVALID", 28, 907135000, 907135000, "arguments invalid");
    D = new a("ERROR_INTERNAL_ERROR", 29, 907135001, 907135001, "internal error");
    E = new a("ERROR_NAMING_INVALID", 30, 907135002, 907135002, "naming invalid");
    F = new a("ERROR_CLIENT_API_INVALID", 31, 907135003, 907135003, "client api invalid");
    G = new a("ERROR_EXECUTE_TIMEOUT", 32, 907135004, 907135004, "execute timeout");
    H = new a("ERROR_NOT_IN_SERVICE", 33, 907135005, 907135005, "not int service");
    I = new a("ERROR_SESSION_INVALID", 34, 907135006, 907135006, "session invalid");
    J = new a("ERROR_API_NOT_SPECIFIED", 35, 1002, 1002, "API not specified");
    K = new a("ERROR_GET_SCOPE_ERROR", 36, 907135700, 907135700, "get scope error");
    L = new a("ERROR_SCOPE_LIST_EMPTY", 37, 907135701, 907135701, "scope list empty");
    M = new a("ERROR_CERT_FINGERPRINT_EMPTY", 38, 907135702, 907135702, "certificate fingerprint empty");
    N = new a("ERROR_PERMISSION_LIST_EMPTY", 39, 907135703, 907135703, "permission list empty");
    O = new a("ERROR_AUTH_INFO_NOT_EXIST", 40, 6002, 6002, "auth info not exist");
    P = new a("ERROR_CERT_FINGERPRINT_ERROR", 41, 6003, 6003, "certificate fingerprint error");
    Q = new a("ERROR_PERMISSION_NOT_EXIST", 42, 6004, 6004, "permission not exist");
    R = new a("ERROR_PERMISSION_NOT_AUTHORIZED", 43, 6005, 6005, "permission not authorized");
    S = new a("ERROR_PERMISSION_EXPIRED", 44, 6006, 6006, "permission expired");
    T = new a("ERROR_HMS_CLIENT_API", 45, 907122048, 907122048, "HMS client api invalid");
    U = new a("ERROR_OPERATION_NOT_SUPPORTED", 46, 907122049, 907122049, "operation not supported");
    V = new a("ERROR_NO_RIGHT_SELF_MAPPING", 47, 907122011, 907122036, "no push right");
    W = new a("ERROR_NO_TOKEN_SIGN_SELF_MAPPING", 48, 907122032, 907122032, "token invalid");
    X = new a("ERROR_INVALID_PARAMETERS_SELF_MAPPING", 49, 907122042, 907122042, "parameter invalid");
    Y = new a("ERROR_SIZE_SELF_MAPPING", 50, 907122041, 907122041, "message size error");
    Z = new a("ERROR_PUSH_SERVER_SELF_MAPPING", 51, 907122047, 907122047, "push server error");
    aa = new a("ERROR_HMS_CLIENT_API_SELF_MAPPING", 52, 907122048, 907122048, "push service not connected");
    ab = new a("ERROR_DEVICE_NOT_IN_GROUP_SELF_MAPPING", 53, 907122057, 907122057, "device not in device group");
    ac = new a("ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING", 54, 907122051, 907122051, "device certificate auth fail");
    ad = new a("ERROR_TOPIC_EXCEED_SELF_MAPPING", 55, 907122034, 907122034, "topic exceed");
    ae = new a("ERROR_TOPIC_SEND_SELF_MAPPING", 56, 907122035, 907122035, "topic send error");
    af = new a("ERROR_STORAGE_LOCATION_EMPTY_MAPPING", 57, 907122038, 907122038, "storage location is empty or invalid");
    ag = new a("ERROR_BIND_SERVICE_SELF_MAPPING", 58, 907122052, 907122052, "bind service failed.");
    ah = new a("ERROR_NO_TOKEN_SELF_MAPPING", 59, 907122030, 907122030, "token missing");
    ai = new a("ERROR_AUTO_INITIALIZING", 60, 907122054, 907122054, "push kit initializing, try again later");
    aj = new a("ERROR_RETRY_LATER_SELF_MAPPING", 61, 907122055, 907122055, "System busy, please retry later.");
    ak = new a("ERROR_SEND_SELF_MAPPING", 62, 907122056, 907122056, "send error.");
    al = new a("ERROR_NO_NETWORK_OLD", 63, 907122005, 907122031, "no network");
    am = new a("ERROR_PUSH_SERVER_OLD", 64, 907122017, 907122047, "push server error");
    an = new a("ERROR_NO_TOKEN_OLD", 65, 907122019, 907122030, "token missing");
    as = new a[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an };
    ao = new SparseArray();
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      ao.put(locala.ap, locala);
      i1 += 1;
    }
  }
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.ap = paramInt1;
    this.aq = paramInt2;
    this.ar = paramString;
  }
  
  public static ApiException a(a parama)
  {
    return new ApiException(new Status(parama.b(), parama.c()));
  }
  
  public static a a(int paramInt)
  {
    return (a)ao.get(paramInt, g);
  }
  
  public int a()
  {
    return this.ap;
  }
  
  public int b()
  {
    return this.aq;
  }
  
  public String c()
  {
    return this.ar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.a.a
 * JD-Core Version:    0.7.0.1
 */