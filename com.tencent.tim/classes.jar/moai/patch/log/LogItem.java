package moai.patch.log;

public class LogItem
{
  public static final int CPU_ARCH = 7001;
  public static final int CPU_ARCH_EMPTY = 7002;
  public static final int CPU_ARCH_UNKNOWN = 7003;
  public static final int CREATE_NEW_APK_FAIL = 6002;
  public static final int CREATE_NEW_APK_TIME_COST = 6001;
  public static final int DEBUG = 2;
  public static final int DEX_PATCH_FAIL = 3001;
  public static final int DEX_PATCH_OPTIMIZE_END = 3002;
  public static final int DEX_PATCH_OPTIMIZE_FAIL = 3004;
  public static final int DEX_PATCH_OPTIMIZE_INVOKE_METHOD_FAIL = 3003;
  public static final int DEX_PATCH_OPTIMIZE_NO_ODEX = 3005;
  public static final int DEX_PATCH_RE_OPTIMIZE_DEX_FAILED = 3006;
  public static final int DEX_PATCH_TIME_COST = 3000;
  public static final int GENERAL = 0;
  public static final int KEY_PATCHED = 1001;
  public static final int MULTIDEX_ERROR = 9003;
  public static final int MULTIDEX_WARN = 9004;
  public static final int NATIVE_PATCH_ADD_PATH = 5003;
  public static final int NATIVE_PATCH_CPU_ARCH_UNKNOWN = 5001;
  public static final int NATIVE_PATCH_FAIL = 5002;
  public static final int NATIVE_PATCH_ORIGINAL_SO_LIST = 5004;
  public static final int NATIVE_PATCH_TIME_COST = 5000;
  public static final int PATCH_ANDROID_N_DELETE = 1018;
  public static final int PATCH_API_UPGRADE_4 = 1039;
  public static final int PATCH_APP_FIRST_LAUNCH = 2000;
  public static final int PATCH_ATTACH_BASE_CONTEXT_COST = 2026;
  public static final int PATCH_ATTACH_BASE_CONTEXT_END = 2021;
  public static final int PATCH_ATTACH_DEX_FAIL = 2003;
  public static final int PATCH_ATTACH_DEX_NO_DEX_FOUND = 2028;
  public static final int PATCH_ATTACH_NATIVE_FAIL = 2005;
  public static final int PATCH_ATTACH_REAL_CONTEXT = 2006;
  public static final int PATCH_ATTACH_REAL_CONTEXT_COST = 2027;
  public static final int PATCH_ATTACH_REAL_CONTEXT_FAIL = 2008;
  public static final int PATCH_ATTACH_REAL_CONTEXT_SUCCESS = 2007;
  public static final int PATCH_ATTACH_REFLECT_ALL_FAIL = 2033;
  public static final int PATCH_ATTACH_RES_FAIL = 2004;
  public static final int PATCH_AUTH_CERT_MISMATCH = 8004;
  public static final int PATCH_AUTH_ENTRY_NO_CERT = 8000;
  public static final int PATCH_AUTH_FAIL = 1003;
  public static final int PATCH_AUTH_NO_CERT = 8001;
  public static final int PATCH_CHECK_KILL_ALL_OTHER = 1033;
  public static final int PATCH_CLEAN_CACHE_FAIL = 1012;
  public static final int PATCH_CLEAN_FAIL = 1014;
  public static final int PATCH_CLEAN_PATCH = 1013;
  public static final int PATCH_CLEAR_PATCH_FOR_STARTUP_PATCH_FAIL = 1032;
  public static final int PATCH_CMD_INVALID = 1005;
  public static final int PATCH_CMD_REVERT = 1006;
  public static final int PATCH_CRASHED = 1019;
  public static final int PATCH_CRASHED_TOO_MANY = 1020;
  public static final int PATCH_DIR_NO_EXIST = 2002;
  public static final int PATCH_DOWNLOAD_FAIL = 9007;
  public static final int PATCH_DOWNLOAD_SUCCESS = 9006;
  public static final int PATCH_EXTRACT_ALL_DEX_END = 9008;
  public static final int PATCH_EXTRACT_DEX_FAST_MODE_FAILED = 9009;
  public static final int PATCH_FAST_FAIL_HAPPEN = 2029;
  public static final int PATCH_FIRST_ATTACH_BASE_CONTEXT_COST = 2022;
  public static final int PATCH_FIRST_ATTACH_REAL_CONTEXT_COST = 2023;
  public static final int PATCH_KILL_PROCESS_FAIL_INTERRUPT_EXCEPTION = 2019;
  public static final int PATCH_LOAD_APK_CERT_FAIL = 8002;
  public static final int PATCH_LOAD_JAR_CERT_FAIL = 8003;
  public static final int PATCH_LOAD_WEBVIEW_FAIL = 1041;
  public static final int PATCH_LOAD_WEBVIEW_SUCCESS = 1040;
  public static final int PATCH_MAIN_PROCESS_INIT_NOT_FINISH = 2031;
  public static final int PATCH_MERGE_FILE_ENTRY_NOT_FOUND = 1017;
  public static final int PATCH_NATIVE_FAIL = 1008;
  public static final int PATCH_OPTIMIZE_DEX_FAIL = 1009;
  public static final int PATCH_PATCHED = 1011;
  public static final int PATCH_QUICK_LAUNCH = 2024;
  public static final int PATCH_QUICK_LAUNCH_COST_WHEN_OTA = 2034;
  public static final int PATCH_QUICK_LUANCH_FAIL = 2035;
  public static final int PATCH_REBOOT = 2017;
  public static final int PATCH_REPORT_CRASH_FILES = 10004;
  public static final int PATCH_RES_CHECK_FAIL = 1022;
  public static final int PATCH_REVERT_ALL = 1026;
  public static final int PATCH_REVERT_ALL_MAIN_ALIVE_KILL_SELF = 1028;
  public static final int PATCH_REVERT_ALL_MAIN_CLEAR_PATCH = 1029;
  public static final int PATCH_REVERT_ALL_NATIVE_L = 1036;
  public static final int PATCH_REVERT_ALL_NATIVE_M = 1037;
  public static final int PATCH_REVERT_ALL_NOT_MAIN_CLEAR_PATCH = 1030;
  public static final int PATCH_REVERT_CLASSLOADER = 1023;
  public static final int PATCH_REVERT_CLASSLOADER_NOT_INCREMENTAL_CLASSLOADER = 1034;
  public static final int PATCH_REVERT_DELETE = 1015;
  public static final int PATCH_REVERT_NATIVE = 1025;
  public static final int PATCH_REVERT_RESOURCES = 1024;
  public static final int PATCH_REVERT_RESOURCES_ORIGIN_NULL = 1035;
  public static final int PATCH_ROM_FINGERPRINT_CHANGED = 2025;
  public static final int PATCH_SERVICE_HANDLE = 10000;
  public static final int PATCH_SERVICE_HANDLING = 10001;
  public static final int PATCH_SERVICE_MEM_NOT_ENOUGH = 10003;
  public static final int PATCH_SERVICE_NULL_INTENT = 10002;
  public static final int PATCH_SUCCESS = 1010;
  public static final int PATCH_SUCCESS_COST = 1040;
  public static final int PATCH_TASK_FAIL = 1016;
  public static final int PATCH_UNHANDLED_EXCEPTION = 1038;
  public static final int PATCH_ZIP_ENTRY_NAME_INVALID = 1031;
  public static final int PATCH_ZIP_ENTRY_NULL = 1021;
  public static final int PATCH_ZIP_FILE_MISSING = 1007;
  public static final int PATCH_ZIP_PATH_INVALID = 1002;
  public static final int PROCESS_HACK_END = 2001;
  public static final int PROCESS_KILLER = 9005;
  public static final int RES_PATCH_APK_NOT_EXIST = 4003;
  public static final int RES_PATCH_ATTACH_RESOURCES = 4002;
  public static final int RES_PATCH_FAIL = 4001;
  public static final int RES_PATCH_TIME_COST = 4000;
  public static final int TOTAL_PSS = 9001;
  public static final int UNZIP_PATCH_ZIP_FAIL = 1004;
  public static final int VERBOSE = 1;
  public static final int ZIP_UNZIP_FAIL = 9000;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.LogItem
 * JD-Core Version:    0.7.0.1
 */