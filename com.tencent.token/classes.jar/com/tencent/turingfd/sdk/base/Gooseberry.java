package com.tencent.turingfd.sdk.base;

public enum Gooseberry
{
  public final int value;
  
  static
  {
    Lj = new Gooseberry("DEVICE_ID", 1, 1);
    Mj = new Gooseberry("IMEI", 2, 2);
    ANDROID_ID = new Gooseberry("ANDROID_ID", 3, 3);
    Nj = new Gooseberry("CID", 4, 4);
    Oj = new Gooseberry("SERIAL_ID", 5, 5);
    MAC = new Gooseberry("MAC", 6, 6);
    Pj = new Gooseberry("KERNEL_VERSION", 7, 7);
    FINGERPRINT = new Gooseberry("FINGERPRINT", 8, 8);
    Qj = new Gooseberry("SYS_DF", 9, 9);
    STORAGE = new Gooseberry("STORAGE", 10, 10);
    SENSORS = new Gooseberry("SENSORS", 11, 11);
    CPU_ABI = new Gooseberry("CPU_ABI", 12, 12);
    Rj = new Gooseberry("BATTERY", 13, 13);
    DISPLAY = new Gooseberry("DISPLAY", 14, 14);
    Sj = new Gooseberry("DEFAULT_RINGTONE", 15, 15);
    Tj = new Gooseberry("FONTS", 16, 16);
    Uj = new Gooseberry("PKG_LIST", 17, 17);
    Vj = new Gooseberry("FILES1", 18, 18);
    Wj = new Gooseberry("FILES2", 19, 19);
    ROOT = new Gooseberry("ROOT", 20, 20);
    Xj = new Gooseberry("EMULATOR", 21, 21);
    Yj = new Gooseberry("DUAL_APP", 22, 22);
    BRAND = new Gooseberry("BRAND", 23, 23);
    MODEL = new Gooseberry("MODEL", 24, 24);
    Zj = new Gooseberry("SYSTEM_VER", 25, 25);
    _j = new Gooseberry("UUID", 26, 26);
    ak = new Gooseberry("INODE", 27, 27);
    bk = new Gooseberry("TICKET_ID", 28, 28);
    ck = new Gooseberry("TURINGMM_UNIQUEID", 29, 29);
    dk = new Gooseberry("QQPIM_VID", 30, 30);
    ek = new Gooseberry("QQPIM_GUID", 31, 31);
    fk = new Gooseberry("IMSI", 32, 32);
    gk = new Gooseberry("API_LEVEL", 33, 33);
    hk = new Gooseberry("DEBUG_INFO", 34, 34);
    ik = new Gooseberry("BOOT_TIME", 35, 35);
    jk = new Gooseberry("PHYSICAL_DISPLAY", 36, 36);
    kk = new Gooseberry("API_AVAILABILITY", 37, 37);
    lk = new Gooseberry("WIFI_CONFIGS", 38, 38);
    mk = new Gooseberry("FRAMEWORK_RES", 39, 39);
    nk = new Gooseberry("PKG_LIST_HASH", 40, 40);
    pk = new Gooseberry("OAID", 41, 41);
    MANUFACTURER = new Gooseberry("MANUFACTURER", 42, 42);
    qk = new Gooseberry("PKG_LIST_2", 43, 43);
    lf = new Gooseberry("INJECT", 44, 100);
    rk = new Gooseberry("HOOK_FRAMEWORK", 45, 101);
    sk = new Gooseberry("SIMULATOR_LOCATION", 46, 102);
    tk = new Gooseberry("USB_TYPE", 47, 103);
    uk = new Gooseberry("CHARGE_STATE", 48, 104);
    Af = new Gooseberry("BATTERY_LEVEL", 49, 105);
    vk = new Gooseberry("RISK_PROCESS", 50, 106);
    wk = new Gooseberry("PKG_SIGMD5", 51, 107);
    xk = new Gooseberry("EMULATOR_RAW", 52, 108);
    yk = new Gooseberry("LOCAL_NETWORK_MACS", 53, 109);
    zk = new Gooseberry("DEVICE_SPHERICAL", 54, 110);
    Ak = new Gooseberry("DEVICE_ORIENTATION", 55, 111);
    Bk = new Gooseberry("TRACE_IP", 56, 112);
    Ck = new Gooseberry("VPN", 57, 113);
    PROXY = new Gooseberry("PROXY", 58, 114);
    Dk = new Gooseberry("DISABLE_FEATURE_ID", 59, 200);
    Ek = new Gooseberry("IOS_IDFA", 60, 1001);
    Fk = new Gooseberry("IOS_IDFV", 61, 1002);
    Gk = new Gooseberry("IOS_BOOT_TIMESTAMP", 62, 1003);
    Hk = new Gooseberry("IOS_CURRENT_TIMESTAMP", 63, 1004);
    Ik = new Gooseberry("IOS_FREE_SPACE", 64, 1005);
    Jk = new Gooseberry("IOS_TOTAL_SPACE", 65, 1006);
    Kk = new Gooseberry("IOS_TOTAL_MEMORY", 66, 1007);
    Lk = new Gooseberry("IOS_SCREEN_BRIGHTNESS", 67, 1008);
    Mk = new Gooseberry("IOS_WIFI_IP_ADDRESS", 68, 1009);
    Nk = new Gooseberry("IOS_CELLULAR_WIFI_IP_ADDRESS", 69, 1010);
    Ok = new Gooseberry("IOS_VPN_IP_ADDRESS", 70, 1011);
    Pk = new Gooseberry("IOS_MAC_ADDRESS", 71, 1012);
    Qk = new Gooseberry("IOS_NETWORK_TYPE", 72, 1013);
    Rk = new Gooseberry("IOS_ROUNTER_SSID", 73, 1014);
    Sk = new Gooseberry("IOS_ROUNTER_BSSID", 74, 1015);
    Tk = new Gooseberry("IOS_PROXY_TYPE", 75, 1016);
    Uk = new Gooseberry("IOS_PROXY_URL", 76, 1017);
    Vk = new Gooseberry("IOS_DNS", 77, 1018);
    Wk = new Gooseberry("IOS_JAILBROKEN", 78, 1019);
    Xk = new Gooseberry("IOS_IPHONE_MODEL", 79, 1020);
    Yk = new Gooseberry("IOS_SYSTEM_VERSION", 80, 1021);
    Zk = new Gooseberry("IOS_DEVICE_NAME", 81, 1022);
    _k = new Gooseberry("IOS_CARRIER", 82, 1023);
    al = new Gooseberry("IOS_COUNTRY_ISO", 83, 1024);
    bl = new Gooseberry("IOS_MCC", 84, 1025);
    cl = new Gooseberry("IOS_MNC", 85, 1026);
    dl = new Gooseberry("IOS_BUNDLE_ID", 86, 1027);
    el = new Gooseberry("IOS_LANGUAGES", 87, 1028);
    fl = new Gooseberry("IOS_TIMESTAMP_APP_INSTALLED", 88, 1029);
    gl = new Gooseberry("IOS_TIMESTAMP_LIST_FOR_ALBUM", 89, 1030);
    hl = new Gooseberry("IOS_AVAILABLE_SENSORS", 90, 1031);
    il = new Gooseberry("IOS_RING_VOLUME", 91, 1032);
    Gooseberry localGooseberry = TIMESTAMP;
    localGooseberry = Lj;
    localGooseberry = Mj;
    localGooseberry = ANDROID_ID;
    localGooseberry = Nj;
    localGooseberry = Oj;
    localGooseberry = MAC;
    localGooseberry = Pj;
    localGooseberry = FINGERPRINT;
    localGooseberry = Qj;
    localGooseberry = STORAGE;
    localGooseberry = SENSORS;
    localGooseberry = CPU_ABI;
    localGooseberry = Rj;
    localGooseberry = DISPLAY;
    localGooseberry = Sj;
    localGooseberry = Tj;
    localGooseberry = Uj;
    localGooseberry = Vj;
    localGooseberry = Wj;
    localGooseberry = ROOT;
    localGooseberry = Xj;
    localGooseberry = Yj;
    localGooseberry = BRAND;
    localGooseberry = MODEL;
    localGooseberry = Zj;
    localGooseberry = _j;
    localGooseberry = ak;
    localGooseberry = bk;
    localGooseberry = ck;
    localGooseberry = dk;
    localGooseberry = ek;
    localGooseberry = fk;
    localGooseberry = gk;
    localGooseberry = hk;
    localGooseberry = ik;
    localGooseberry = jk;
    localGooseberry = kk;
    localGooseberry = lk;
    localGooseberry = mk;
    localGooseberry = nk;
    localGooseberry = pk;
    localGooseberry = MANUFACTURER;
    localGooseberry = qk;
    localGooseberry = lf;
    localGooseberry = rk;
    localGooseberry = sk;
    localGooseberry = tk;
    localGooseberry = uk;
    localGooseberry = Af;
    localGooseberry = vk;
    localGooseberry = wk;
    localGooseberry = xk;
    localGooseberry = yk;
    localGooseberry = zk;
    localGooseberry = Ak;
    localGooseberry = Bk;
    localGooseberry = Ck;
    localGooseberry = PROXY;
    localGooseberry = Dk;
    localGooseberry = Ek;
    localGooseberry = Fk;
    localGooseberry = Gk;
    localGooseberry = Hk;
    localGooseberry = Ik;
    localGooseberry = Jk;
    localGooseberry = Kk;
    localGooseberry = Lk;
    localGooseberry = Mk;
    localGooseberry = Nk;
    localGooseberry = Ok;
    localGooseberry = Pk;
    localGooseberry = Qk;
    localGooseberry = Rk;
    localGooseberry = Sk;
    localGooseberry = Tk;
    localGooseberry = Uk;
    localGooseberry = Vk;
    localGooseberry = Wk;
    localGooseberry = Xk;
    localGooseberry = Yk;
    localGooseberry = Zk;
    localGooseberry = _k;
    localGooseberry = al;
    localGooseberry = bl;
    localGooseberry = cl;
    localGooseberry = dl;
    localGooseberry = el;
    localGooseberry = fl;
    localGooseberry = gl;
    localGooseberry = hl;
    localGooseberry = il;
  }
  
  public Gooseberry(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(name());
    localStringBuilder.append(":");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Gooseberry
 * JD-Core Version:    0.7.0.1
 */