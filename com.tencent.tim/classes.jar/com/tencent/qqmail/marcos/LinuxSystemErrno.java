package com.tencent.qqmail.marcos;

import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LinuxSystemErrno
{
  public static final int E2BIG = 7;
  @ErrorCodeString
  public static final String E2BIG_STR = "E2BIG";
  public static final int EACCES = 13;
  @ErrorCodeString
  public static final String EACCES_STR = "EACCES";
  public static final int EADDRINUSE = 48;
  @ErrorCodeString
  public static final String EADDRINUSE_STR = "EADDRINUSE";
  public static final int EADDRNOTAVAIL = 49;
  @ErrorCodeString
  public static final String EADDRNOTAVAIL_STR = "EADDRNOTAVAIL";
  public static final int EAFNOSUPPORT = 47;
  @ErrorCodeString
  public static final String EAFNOSUPPORT_STR = "EAFNOSUPPORT";
  public static final int EAGAIN = 35;
  @ErrorCodeString
  public static final String EAGAIN_STR = "EAGAIN";
  public static final int EALREADY = 37;
  @ErrorCodeString
  public static final String EALREADY_STR = "EALREADY";
  public static final int EAUTH = 80;
  @ErrorCodeString
  public static final String EAUTH_STR = "EAUTH";
  public static final int EBADARCH = 86;
  @ErrorCodeString
  public static final String EBADARCH_STR = "EBADARCH";
  public static final int EBADEXEC = 85;
  @ErrorCodeString
  public static final String EBADEXEC_STR = "EBADEXEC";
  public static final int EBADF = 9;
  @ErrorCodeString
  public static final String EBADF_STR = "EBADF";
  public static final int EBADMACHO = 88;
  @ErrorCodeString
  public static final String EBADMACHO_STR = "EBADMACHO";
  public static final int EBADMSG = 94;
  @ErrorCodeString
  public static final String EBADMSG_STR = "EBADMSG";
  public static final int EBADRPC = 72;
  @ErrorCodeString
  public static final String EBADRPC_STR = "EBADRPC";
  public static final int EBUSY = 16;
  @ErrorCodeString
  public static final String EBUSY_STR = "EBUSY";
  public static final int ECANCELED = 89;
  @ErrorCodeString
  public static final String ECANCELED_STR = "ECANCELED";
  public static final int ECHILD = 10;
  @ErrorCodeString
  public static final String ECHILD_STR = "ECHILD";
  public static final int ECONNABORTED = 53;
  @ErrorCodeString
  public static final String ECONNABORTED_STR = "ECONNABORTED";
  public static final int ECONNREFUSED = 61;
  @ErrorCodeString
  public static final String ECONNREFUSED_STR = "ECONNREFUSED";
  public static final int ECONNRESET = 54;
  @ErrorCodeString
  public static final String ECONNRESET_STR = "ECONNRESET";
  public static final int EDEADLK = 11;
  @ErrorCodeString
  public static final String EDEADLK_STR = "EDEADLK";
  public static final int EDESTADDRREQ = 39;
  @ErrorCodeString
  public static final String EDESTADDRREQ_STR = "EDESTADDRREQ";
  public static final int EDEVERR = 83;
  @ErrorCodeString
  public static final String EDEVERR_STR = "EDEVERR";
  public static final int EDOM = 33;
  @ErrorCodeString
  public static final String EDOM_STR = "EDOM";
  public static final int EDQUOT = 69;
  @ErrorCodeString
  public static final String EDQUOT_STR = "EDQUOT";
  public static final int EEXIST = 17;
  @ErrorCodeString
  public static final String EEXIST_STR = "EEXIST";
  public static final int EFAULT = 14;
  @ErrorCodeString
  public static final String EFAULT_STR = "EFAULT";
  public static final int EFBIG = 27;
  @ErrorCodeString
  public static final String EFBIG_STR = "EFBIG";
  public static final int EFTYPE = 79;
  @ErrorCodeString
  public static final String EFTYPE_STR = "EFTYPE";
  public static final int EHOSTDOWN = 64;
  @ErrorCodeString
  public static final String EHOSTDOWN_STR = "EHOSTDOWN";
  public static final int EHOSTUNREACH = 65;
  @ErrorCodeString
  public static final String EHOSTUNREACH_STR = "EHOSTUNREACH";
  public static final int EIDRM = 90;
  @ErrorCodeString
  public static final String EIDRM_STR = "EIDRM";
  public static final int EILSEQ = 92;
  @ErrorCodeString
  public static final String EILSEQ_STR = "EILSEQ";
  public static final int EINPROGRESS = 36;
  @ErrorCodeString
  public static final String EINPROGRESS_STR = "EINPROGRESS";
  public static final int EINTR = 4;
  @ErrorCodeString
  public static final String EINTR_STR = "EINTR";
  public static final int EINVAL = 22;
  @ErrorCodeString
  public static final String EINVAL_STR = "EINVAL";
  public static final int EIO = 5;
  @ErrorCodeString
  public static final String EIO_STR = "EIO";
  public static final int EISCONN = 56;
  @ErrorCodeString
  public static final String EISCONN_STR = "EISCONN";
  public static final int EISDIR = 21;
  @ErrorCodeString
  public static final String EISDIR_STR = "EISDIR";
  public static final int ELAST = 106;
  @ErrorCodeString
  public static final String ELAST_STR = "ELAST";
  public static final int ELOOP = 62;
  @ErrorCodeString
  public static final String ELOOP_STR = "ELOOP";
  public static final int EMFILE = 24;
  @ErrorCodeString
  public static final String EMFILE_STR = "EMFILE";
  public static final int EMLINK = 31;
  @ErrorCodeString
  public static final String EMLINK_STR = "EMLINK";
  public static final int EMSGSIZE = 40;
  @ErrorCodeString
  public static final String EMSGSIZE_STR = "EMSGSIZE";
  public static final int EMULTIHOP = 95;
  @ErrorCodeString
  public static final String EMULTIHOP_STR = "EMULTIHOP";
  public static final int ENAMETOOLONG = 63;
  @ErrorCodeString
  public static final String ENAMETOOLONG_STR = "ENAMETOOLONG";
  public static final int ENEEDAUTH = 81;
  @ErrorCodeString
  public static final String ENEEDAUTH_STR = "ENEEDAUTH";
  public static final int ENETDOWN = 50;
  @ErrorCodeString
  public static final String ENETDOWN_STR = "ENETDOWN";
  public static final int ENETRESET = 52;
  @ErrorCodeString
  public static final String ENETRESET_STR = "ENETRESET";
  public static final int ENETUNREACH = 51;
  @ErrorCodeString
  public static final String ENETUNREACH_STR = "ENETUNREACH";
  public static final int ENFILE = 23;
  @ErrorCodeString
  public static final String ENFILE_STR = "ENFILE";
  public static final int ENOATTR = 93;
  @ErrorCodeString
  public static final String ENOATTR_STR = "ENOATTR";
  public static final int ENOBUFS = 55;
  @ErrorCodeString
  public static final String ENOBUFS_STR = "ENOBUFS";
  public static final int ENODATA = 96;
  @ErrorCodeString
  public static final String ENODATA_STR = "ENODATA";
  public static final int ENODEV = 19;
  @ErrorCodeString
  public static final String ENODEV_STR = "ENODEV";
  public static final int ENOENT = 2;
  @ErrorCodeString
  public static final String ENOENT_STR = "ENOENT";
  public static final int ENOEXEC = 8;
  @ErrorCodeString
  public static final String ENOEXEC_STR = "ENOEXEC";
  public static final int ENOLCK = 77;
  @ErrorCodeString
  public static final String ENOLCK_STR = "ENOLCK";
  public static final int ENOLINK = 97;
  @ErrorCodeString
  public static final String ENOLINK_STR = "ENOLINK";
  public static final int ENOMEM = 12;
  @ErrorCodeString
  public static final String ENOMEM_STR = "ENOMEM";
  public static final int ENOMSG = 91;
  @ErrorCodeString
  public static final String ENOMSG_STR = "ENOMSG";
  public static final int ENOPOLICY = 103;
  @ErrorCodeString
  public static final String ENOPOLICY_STR = "ENOPOLICY";
  public static final int ENOPROTOOPT = 42;
  @ErrorCodeString
  public static final String ENOPROTOOPT_STR = "ENOPROTOOPT";
  public static final int ENOSPC = 28;
  @ErrorCodeString
  public static final String ENOSPC_STR = "ENOSPC";
  public static final int ENOSR = 98;
  @ErrorCodeString
  public static final String ENOSR_STR = "ENOSR";
  public static final int ENOSTR = 99;
  @ErrorCodeString
  public static final String ENOSTR_STR = "ENOSTR";
  public static final int ENOSYS = 78;
  @ErrorCodeString
  public static final String ENOSYS_STR = "ENOSYS";
  public static final int ENOTBLK = 15;
  @ErrorCodeString
  public static final String ENOTBLK_STR = "ENOTBLK";
  public static final int ENOTCONN = 57;
  @ErrorCodeString
  public static final String ENOTCONN_STR = "ENOTCONN";
  public static final int ENOTDIR = 20;
  @ErrorCodeString
  public static final String ENOTDIR_STR = "ENOTDIR";
  public static final int ENOTEMPTY = 66;
  @ErrorCodeString
  public static final String ENOTEMPTY_STR = "ENOTEMPTY";
  public static final int ENOTRECOVERABLE = 104;
  @ErrorCodeString
  public static final String ENOTRECOVERABLE_STR = "ENOTRECOVERABLE";
  public static final int ENOTSOCK = 38;
  @ErrorCodeString
  public static final String ENOTSOCK_STR = "ENOTSOCK";
  public static final int ENOTTY = 25;
  @ErrorCodeString
  public static final String ENOTTY_STR = "ENOTTY";
  public static final int ENXIO = 6;
  @ErrorCodeString
  public static final String ENXIO_STR = "ENXIO";
  public static final int EOVERFLOW = 84;
  @ErrorCodeString
  public static final String EOVERFLOW_STR = "EOVERFLOW";
  public static final int EOWNERDEAD = 105;
  @ErrorCodeString
  public static final String EOWNERDEAD_STR = "EOWNERDEAD";
  public static final int EPERM = 1;
  @ErrorCodeString
  public static final String EPERM_STR = "EPERM";
  public static final int EPFNOSUPPORT = 46;
  @ErrorCodeString
  public static final String EPFNOSUPPORT_STR = "EPFNOSUPPORT";
  public static final int EPIPE = 32;
  @ErrorCodeString
  public static final String EPIPE_STR = "EPIPE";
  public static final int EPROCLIM = 67;
  @ErrorCodeString
  public static final String EPROCLIM_STR = "EPROCLIM";
  public static final int EPROCUNAVAIL = 76;
  @ErrorCodeString
  public static final String EPROCUNAVAIL_STR = "EPROCUNAVAIL";
  public static final int EPROGMISMATCH = 75;
  @ErrorCodeString
  public static final String EPROGMISMATCH_STR = "EPROGMISMATCH";
  public static final int EPROGUNAVAIL = 74;
  @ErrorCodeString
  public static final String EPROGUNAVAIL_STR = "EPROGUNAVAIL";
  public static final int EPROTO = 100;
  public static final int EPROTONOSUPPORT = 43;
  @ErrorCodeString
  public static final String EPROTONOSUPPORT_STR = "EPROTONOSUPPORT";
  public static final int EPROTOTYPE = 41;
  @ErrorCodeString
  public static final String EPROTOTYPE_STR = "EPROTOTYPE";
  @ErrorCodeString
  public static final String EPROTO_STR = "EPROTO";
  public static final int EPWROFF = 82;
  @ErrorCodeString
  public static final String EPWROFF_STR = "EPWROFF";
  public static final int EQFULL = 106;
  @ErrorCodeString
  public static final String EQFULL_STR = "EQFULL";
  public static final int ERANGE = 34;
  @ErrorCodeString
  public static final String ERANGE_STR = "ERANGE";
  public static final int EREMOTE = 71;
  @ErrorCodeString
  public static final String EREMOTE_STR = "EREMOTE";
  public static final int EROFS = 30;
  @ErrorCodeString
  public static final String EROFS_STR = "EROFS";
  public static final int ERPCMISMATCH = 73;
  @ErrorCodeString
  public static final String ERPCMISMATCH_STR = "ERPCMISMATCH";
  public static final int ESHLIBVERS = 87;
  @ErrorCodeString
  public static final String ESHLIBVERS_STR = "ESHLIBVERS";
  public static final int ESHUTDOWN = 58;
  @ErrorCodeString
  public static final String ESHUTDOWN_STR = "ESHUTDOWN";
  public static final int ESOCKTNOSUPPORT = 44;
  @ErrorCodeString
  public static final String ESOCKTNOSUPPORT_STR = "ESOCKTNOSUPPORT";
  public static final int ESPIPE = 29;
  @ErrorCodeString
  public static final String ESPIPE_STR = "ESPIPE";
  public static final int ESRCH = 3;
  @ErrorCodeString
  public static final String ESRCH_STR = "ESRCH";
  public static final int ESTALE = 70;
  @ErrorCodeString
  public static final String ESTALE_STR = "ESTALE";
  public static final int ETIME = 101;
  public static final int ETIMEDOUT = 60;
  @ErrorCodeString
  public static final String ETIMEDOUT_STR = "ETIMEDOUT";
  @ErrorCodeString
  public static final String ETIME_STR = "ETIME";
  public static final int ETOOMANYREFS = 59;
  @ErrorCodeString
  public static final String ETOOMANYREFS_STR = "ETOOMANYREFS";
  public static final int ETXTBSY = 26;
  @ErrorCodeString
  public static final String ETXTBSY_STR = "ETXTBSY";
  public static final int EUSERS = 68;
  @ErrorCodeString
  public static final String EUSERS_STR = "EUSERS";
  public static final int EWOULDBLOCK = 35;
  @ErrorCodeString
  public static final String EWOULDBLOCK_STR = "EWOULDBLOCK";
  public static final int EXDEV = 18;
  @ErrorCodeString
  public static final String EXDEV_STR = "EXDEV";
  private static String TAG = "LinuxSystemErrno";
  private static HashMap<String, Integer> map = new HashMap();
  
  static
  {
    Field[] arrayOfField = LinuxSystemErrno.class.getDeclaredFields();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfField.length)
      {
        arrayOfField[i].setAccessible(true);
        Object localObject = arrayOfField[i].getAnnotations();
        try
        {
          if (localObject.length >= 1)
          {
            localObject = String.valueOf(arrayOfField[i].get(null));
            int j = LinuxSystemErrno.class.getDeclaredField((String)localObject).getInt(null);
            map.put(localObject, Integer.valueOf(j));
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.log(6, TAG, "getErrnoFromErrmsg err:" + localException.toString());
          }
        }
      }
    }
  }
  
  public static final int getErrnoFromErrmsg(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return -1;
    }
    if (map == null) {
      return -1;
    }
    Iterator localIterator = map.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.contains(str)) {
        return ((Integer)map.get(str)).intValue();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.marcos.LinuxSystemErrno
 * JD-Core Version:    0.7.0.1
 */