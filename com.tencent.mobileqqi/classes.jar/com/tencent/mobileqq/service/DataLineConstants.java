package com.tencent.mobileqq.service;

import android.os.Environment;
import java.io.File;

public class DataLineConstants
{
  public static final String A = "CMD_PARAM_CONTROLCMD_OPERATETYPE";
  public static final String B = "CMD_PARAM_CONTROLCMD_LREQSEQ";
  public static final String C = "CMD_PARAM_CONTROLCMD_LCODE";
  public static final String D = "CMD_PARAM_CONTROLCMD_VMSG";
  public static final String E = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_NAME";
  public static final String F = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_INDEX";
  public static final String G = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_MD5";
  public static final String H = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_KEY";
  public static final String I = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_SVRIP";
  public static final String J = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_SVRPORT";
  public static final String K = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_ORIGINFILEMD5";
  public static final String L = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_FILELEN";
  public static final String M = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_SESSIONID";
  public static final String N = "CMD_PARAM_UPLOADCOMPLETE_FILEINFO_ORIGINFILETYPE";
  public static final String O = "CMD_PARAM_UPLOADCOMPLETE_LTOUIN";
  public static final String P = "CMD_PARAM_UPLOADCOMPLETE_FILETYPE";
  public static final String Q = "CMD_PARAM_DELETE_LFROMUIN";
  public static final String R = "CMD_PARAM_DELETE_LTOUIN";
  public static final String S = "CMD_PARAM_DELETE_CTYPE";
  public static final String T = "CMD_PARAM_DELETE_FILEPATH";
  public static final String U = "CMD_PARAM_DOWNLOAD_LFROMUIN";
  public static final String V = "CMD_PARAM_DOWNLOAD_LTOUIN";
  public static final String W = "CMD_PARAM_DOWNLOAD_CTYPE";
  public static final String X = "CMD_PARAM_DOWNLOAD_FILEPATH";
  public static final String Y = "CMD_PARAM_UPLOAD_FROM_UIN";
  public static final String Z = "CMD_PARAM_UPLOAD_TO_UIN";
  public static final int a = 100;
  public static final String a = "dataline_forward_type";
  public static final String aa = "CMD_PARAM_UPLOAD_TYPE";
  public static final String ab = "CMD_PARAM_UPLOAD_FILE_SIZE";
  public static final String ac = "CMD_PARAM_UPLOAD_FILE_MD5";
  public static final String ad = "CMD_PARAM_UPLOAD_FILE_NAME";
  public static final String ae = "CMD_PARAM_UPLOAD_VER";
  public static final String af = "CMD_PARAM_UPLOAD_DATA";
  public static final String ag = "CMD_PARAM_UPLOAD_SVR_IP";
  public static final String ah = "CMD_PARAM_UPLOAD_SVR_PORT";
  public static final String ai = "CMD_PARAM_UPLOAD_ENCRYP_BUF";
  public static final String aj = "CMD_PARAM_UPLOAD_TOKEN_KEY";
  public static final String ak = "CMD_PARAM_UPLOAD_SESSIONID";
  public static final String al = "CMD_PARAM_UPLOAD_ORGFILE_MD5";
  public static final String am = "CMD_PARAM_UPLOAD_ORGFILE_TYPE";
  public static final int b = 101;
  public static final String b = "dataline_forward_path";
  public static final int c = 102;
  public static final String c = "dataline_forward_text";
  public static final String d = "dataline_forward_pathlist";
  public static final String e = "TransService.FileUploadReq";
  public static final String f = "TransService.FileDownloadReq";
  public static final String g = "TransService.FileDeleteReq";
  public static String h = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static String i = "Tencent" + File.separator + "MobileQQ" + File.separator + "DataLine" + File.separator;
  public static String j = h + File.separator + i;
  public static String k = j + File.separator + "FileCache/";
  public static final String l = "CMD_PARAM_SENDTEXT_TEXT";
  public static final String m = "CMD_PARAM_SENDTEXT_TOUIN";
  public static final String n = "CMD_PARAM_SENDTEXT_SESSIONID";
  public static final String o = "CMD_PARAM_SENDTEXT_SIZE";
  public static final String p = "CMD_PARAM_SENDTEXT_INDEX";
  public static final String q = "CMD_PARAM_WIFIPHOTO_CMD";
  public static final String r = "CMD_PARAM_WIFIPHOTO_TYPE";
  public static final String s = "CMD_PARAM_WIFIPHOTO_SUBTYPE";
  public static final String t = "CMD_PARAM_WIFIPHOTO_IP";
  public static final String u = "CMD_PARAM_WIFIPHOTO_PORT";
  public static final String v = "CMD_PARAM_WIFIPHOTO_TIME";
  public static final String w = "CMD_PARAM_WIFIPHOTO_TOKENKEY";
  public static final String x = "CMD_PARAM_WIFIPHOTO_MSGID";
  public static final String y = "CMD_PARAM_CONTROLCMD_TOUIN";
  public static final String z = "CMD_PARAM_CONTROLCMD_SESSIONID";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.DataLineConstants
 * JD-Core Version:    0.7.0.1
 */