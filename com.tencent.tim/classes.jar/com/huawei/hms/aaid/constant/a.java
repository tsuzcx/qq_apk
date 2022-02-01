package com.huawei.hms.aaid.constant;

import android.util.SparseArray;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

public enum a
{
  private static final SparseArray<a> S;
  private int T;
  private int U;
  private String V;
  
  static
  {
    int i1 = 0;
    a = new a("SUCCESS", 0, 0, 0, "success");
    b = new a("ERROR_NO_TOKEN", 1, 800000000, 907122030, "token missing");
    c = new a("ERROR_NO_TOKENSIGN", 2, 800000001, 907122032, "token invalid");
    d = new a("ERROR_NO_NETWORK", 3, 800000002, 907122031, "no network");
    e = new a("ERROR_SERVICE_NOT_AVAILABLE", 4, 800000003, 907122046, "service not available");
    f = new a("ERROR_PUSH_SERVER", 5, 800000004, 907122047, "push server error");
    g = new a("ERROR_UNKNOWN", 6, 800000005, 907122045, "unknown error");
    h = new a("ERROR_NO_RIGHT", 7, 800100000, 907122036, "no right");
    i = new a("ERROR_NO_CONNECTION_ID", 8, 800100001, 907122037, "get token error");
    j = new a("ERROR_LENGTH", 9, 800100002, 907122037, "get token error");
    k = new a("ERROR_NO_DEVICE_ID_TYPE", 10, 800100003, 907122037, "get token error");
    l = new a("ERROR_PUSH_ARGUMENTS_INVALID", 11, 807135000, 907135000, "arguments invalid");
    m = new a("ERROR_PUSH_INTERNAL_ERROR", 12, 807135001, 907135001, "internal error");
    n = new a("ERROR_PUSH_NAMING_INVALID", 13, 807135002, 907135002, "naming invalid");
    o = new a("ERROR_PUSH_CLIENT_API_INVALID", 14, 807135003, 907135003, "client api invalid");
    p = new a("ERROR_PUSH_EXECUTE_TIMEOUT", 15, 807135004, 907135004, "execute timeout");
    q = new a("ERROR_PUSH_NOT_IN_SERVICE", 16, 807135005, 907135005, "not int service");
    r = new a("ERROR_SPUSH_ESSION_INVALID", 17, 807135006, 907135006, "session invalid");
    s = new a("ERROR_ARGUMENTS_INVALID", 18, 907135000, 907135000, "arguments invalid");
    t = new a("ERROR_INTERNAL_ERROR", 19, 907135001, 907135001, "internal error");
    u = new a("ERROR_NAMING_INVALID", 20, 907135002, 907135002, "naming invalid");
    v = new a("ERROR_CLIENT_API_INVALID", 21, 907135003, 907135003, "client api invalid");
    w = new a("ERROR_EXECUTE_TIMEOUT", 22, 907135004, 907135004, "execute timeout");
    x = new a("ERROR_NOT_IN_SERVICE", 23, 907135005, 907135005, "not int service");
    y = new a("ERROR_SESSION_INVALID", 24, 907135006, 907135006, "session invalid");
    z = new a("ERROR_API_NOT_SPECIFIED", 25, 1002, 1002, "API not specified");
    A = new a("ERROR_GET_SCOPE_ERROR", 26, 907135700, 907135700, "get scope error");
    B = new a("ERROR_SCOPE_LIST_EMPTY", 27, 907135701, 907135701, "scope list empty");
    C = new a("ERROR_CERT_FINGERPRINT_EMPTY", 28, 907135702, 907135702, "certificate fingerprint empty");
    D = new a("ERROR_PERMISSION_LIST_EMPTY", 29, 907135703, 907135703, "permission list empty");
    E = new a("ERROR_AUTH_INFO_NOT_EXIST", 30, 6002, 6002, "auth info not exist");
    F = new a("ERROR_CERT_FINGERPRINT_ERROR", 31, 6003, 6003, "certificate fingerprint error");
    G = new a("ERROR_PERMISSION_NOT_EXIST", 32, 6004, 6004, "permission not exist");
    H = new a("ERROR_PERMISSION_NOT_AUTHORIZED", 33, 6005, 6005, "permission not authorized");
    I = new a("ERROR_PERMISSION_EXPIRED", 34, 6006, 6006, "permission expired");
    J = new a("ERROR_HMS_CLIENT_API", 35, 907122048, 907122048, "HMS client api invalid");
    K = new a("ERROR_MAIN_THREAD", 36, 907122050, 907122050, "operation in MAIN thread prohibited");
    L = new a("ERROR_NO_NETWORK_OLD", 37, 907122005, 907122031, "no network");
    M = new a("ERROR_NO_RIGHT_OLD", 38, 907122011, 907122036, "no right");
    N = new a("ERROR_NO_CONNECTION_ID_OLD", 39, 907122012, 907122037, "get token error");
    O = new a("ERROR_LENGTH_OLD", 40, 907122013, 907122037, "get token error");
    P = new a("ERROR_NO_DEVICE_ID_TYPE_OLD", 41, 907122014, 907122037, "get token error");
    Q = new a("ERROR_PUSH_SERVER_OLD", 42, 907122017, 907122047, "push server error");
    R = new a("ERROR_NO_TOKEN_OLD", 43, 907122019, 907122030, "token missing");
    W = new a[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R };
    S = new SparseArray();
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      S.put(locala.T, locala);
      i1 += 1;
    }
  }
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.T = paramInt1;
    this.U = paramInt2;
    this.V = paramString;
  }
  
  public static a a(int paramInt)
  {
    return (a)S.get(paramInt, g);
  }
  
  public static ApiException a(a parama)
  {
    return new ApiException(new Status(parama.a(), parama.b()));
  }
  
  public int a()
  {
    return this.U;
  }
  
  public String b()
  {
    return this.V;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.constant.a
 * JD-Core Version:    0.7.0.1
 */