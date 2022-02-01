package com.tencent.qqmail.utilities.httpdns;

public final class QMHttpDnsHelper
{
  private static final long DEFAULT_BGPIP_INTERVAL = 86400L;
  private static final long DEFAULT_TTL = 86400L;
  private static final long IP_TEST_INTERVAL = 600000L;
  private static final String KEY_BGPIP_INTERVAL = "bgpip_interval";
  private static final String KEY_TEST_IP_LAST_TIME = "test_ip_last_time";
  private static final String KEY_TTL = "ttl";
  private static final String SP_NAME = "httpdns_info";
  private static final String[] SUPPORT_HOST_SUFFIX = { "i.mail.qq.com", "i.exmail.qq.com", "oss.mail.qq.com", "qumas.mail.qq.com", "rescdn.qqmail.com", "rescdn.mail.qq.com", "res.mail.qq.com", "ex.qq.com", "mm.tencent.com", "ftn.mail.qq.com", "ftn.exmail.qq.com", "sz.btfs.ftn.qq.com", "sz.ctfs.ftn.qq.com", "xg.ctfs.ftn.qq.com", "gp.mail.qq.com", "umasocksproxy.mail.qq.com", "wtlogin1.qq.com", "wtlogin.qq.com", "log.wtlogin.qq.com", "appmsg.mail.qq.com", "eventlog.beacon.qq.com", "strategy.beacon.qq.com", "oth.eve.mdt.qq.com", "oth.str.mdt.qq.com", "monitor.uu.qq.com" };
  private static final String TAG = "QMHttpDnsHelper";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.httpdns.QMHttpDnsHelper
 * JD-Core Version:    0.7.0.1
 */