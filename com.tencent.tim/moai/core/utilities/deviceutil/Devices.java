package moai.core.utilities.deviceutil;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;

import moai.log.MLog;
import moai.log.MLogManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * 设备相关的工具类
 *
 * @author masonqwli
 */
public class Devices {
    public static String TAG = "Devices";
    private static final MLog logger = MLogManager.getLogger("moailog");

    /**
     * 读取手机屏幕高度。<br \>
     * 单位是像素<br>
     * 如果传入的act为null，则返回 -1
     */
    public static int getScreenHeight(Context context) {
        if (context == null) {
            return -1;
        }
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.heightPixels;
    }

    /**
     * 读取手机屏幕宽度<br>
     * 单位是像素<br>
     * 如果传入的act为null，则返回 -1
     */
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return -1;
        }
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.widthPixels;
    }

    /**
     * 读取手机屏幕的宽、高
     */
    public static int[] getScreenWidthHeight(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }

    public static String getReadableResolution(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.widthPixels + "*" + metrics.heightPixels;
    }

    public static float getScreenScale(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.scaledDensity;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager winMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        winMgr.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
    public static String getWifiIp(Context context) {
        WifiManager wifimanger = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiinfo = wifimanger.getConnectionInfo();
        return intToIp(wifiinfo.getIpAddress());
    }

    public static String intToIp(int i) {
        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + (i >> 24 & 0xFF);
    }

    public static String GetHostIp() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> ipAddr = intf.getInetAddresses(); ipAddr
                        .hasMoreElements(); ) {
                    InetAddress inetAddress = ipAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        sb.append(inetAddress.getHostAddress() + "####");
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            logger.d(TAG, "GetHostIp err:" + e.toString());
        }
        return "";
    }

    public static String getInnerMemSpaceLog(Context context) {
        return getAvailMemory(context) + "," + getTotalMemory();
    }

    private static String getTotalMemory() {
        String meminfo = "/proc/meminfo";// 系统内存信息文件
        String firstLine;
        String[] arrayOfString;
        long initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader(meminfo);
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 256);
            try {
                firstLine = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小
                if (firstLine != null) {
                    arrayOfString = firstLine.split("\\s+");
                    for (String num : arrayOfString) {
                        Log.i(firstLine, num + "/t");
                    }
                    initial_memory = Integer.valueOf(arrayOfString[1]);
                }
            } finally {
                localBufferedReader.close();
            }
        } catch (IOException e) {
            logger.d(TAG, "getTotalMemory err:" + e.toString());
            return "";
        }
        return "total:" + 1.0 * initial_memory / 1024 + "MB";
    }

    private static String getAvailMemory(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        MemoryInfo mi = new MemoryInfo();
        am.getMemoryInfo(mi);
        return new StringBuilder().append("free:").append(1.0 * mi.availMem / 1024 / 1024).append("MB").toString();
    }

    private static String getSDAvailableSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return "free:" + blockSize * availableBlocks * 1.0 / 1024 / 1024 + "MB";
    }

    private static String getSDTotalSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getBlockCount();
        return "total:" + blockSize * availableBlocks * 1.0 / 1024 / 1024 + "MB";
    }

    public static String getSDcardSpaceLog() {
        return new StringBuilder().append(getSDAvailableSize()).append(",").append(getSDTotalSize()).toString();
    }

    public static boolean isPhoneRoot() {
        return !((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists()));
    }

    public static List<String> getRunningAppProcesses(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        List<String> list = new ArrayList<String>();
        for (RunningAppProcessInfo appProcess : appProcesses) {
            list.add(appProcess.processName);
        }
        return list;
    }

    public static List<AppInfo> getInstalledApps(Context context) {
        ArrayList<AppInfo> appList = new ArrayList<AppInfo>();
        PackageManager mgr = context.getPackageManager();
        List<PackageInfo> packages = mgr.getInstalledPackages(0);
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(mgr).toString();
            tmpInfo.packageName = packageInfo.packageName;
            tmpInfo.versionName = packageInfo.versionName;
            tmpInfo.versionCode = packageInfo.versionCode;
            appList.add(tmpInfo);
        }
        return appList;
    }

    public static boolean[] isScreenReaderActive(Context context) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        boolean isAccessibilityEnabled = am.isEnabled();
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            boolean isExploreByTouchEnabled = am.isTouchExplorationEnabled(); // 14level才有的接口
            boolean[] status = new boolean[2];
            status[0] = isAccessibilityEnabled;
            status[1] = isExploreByTouchEnabled;
            return status;
        } else {
            return new boolean[]{false, false};
        }
    }

    private static DeviceInfo info;
    private static final String separator = "";

    public static String getDeviceescription(Context context) {
        DeviceInfo deviceInfo = getDeviceInfos(context);

        return deviceInfo.MANUFACTURER + separator +
                deviceInfo.DEVICE + separator +
                deviceInfo.MODEL + separator;
    }

    /**
     * 读取设备信息
     * 依次用ANDROID_ID,Serizal Number,Mac Address 代替IMEI,并且去除了PHONE_NUMBER信息，这样就不需要申请READ_PHONE_STATE权限了。
     *
     * @return
     */
    public static DeviceInfo getDeviceInfos(Context context) {
        if (info != null) {
            return info;
        }

        HashMap<String, String> infos = new HashMap<String, String>();
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                String key = field.getName();
                if (key != null) {
                    String value = field.get(null).toString();
                    if (value == null) {
                        value = "";
                    }
                    infos.put(key, value);
                }
            } catch (Exception e) {
                logger.e(TAG, "read device info err : " + e.toString());
                e.printStackTrace();
            }
        }
        DeviceInfo deviceInfo = new DeviceInfo();

        deviceInfo.ID = infos.get("ID");
        deviceInfo.BOARD = infos.get("BOARD");
        deviceInfo.BOOTLOADER = infos.get("BOOTLOADER");
        deviceInfo.BRAND = infos.get("BRAND");
        deviceInfo.CPU_ABI = infos.get("CPU_ABI");
        deviceInfo.CPU_ABI2 = infos.get("CPU_ABI2");
        deviceInfo.DEVICE = infos.get("DEVICE");
        deviceInfo.DISPLAY = infos.get("DISPLAY");
        deviceInfo.FINGERPRINT = infos.get("FINGERPRINT");
        deviceInfo.HARDWARE = infos.get("HARDWARE");
        deviceInfo.IS_DEBUGGABLE = infos.get("IS_DEBUGGABLE");
        deviceInfo.MANUFACTURER = infos.get("MANUFACTURER");
        deviceInfo.MODEL = infos.get("MODEL");
        deviceInfo.PRODUCT = infos.get("PRODUCT");
        deviceInfo.RADIO = infos.get("RADIO");
        deviceInfo.sdkIntVersion = String.valueOf(Build.VERSION.SDK_INT);
        deviceInfo.SERIAL = infos.get("SERIAL");
        deviceInfo.TAGS = infos.get("TAGS");
        deviceInfo.TIME = infos.get("TIME");
        deviceInfo.TYPE = infos.get("TYPE");
        deviceInfo.USER = infos.get("USER");
        deviceInfo.HOST = infos.get("HOST");
        deviceInfo.releaseVersion = Build.VERSION.RELEASE == null ? "" : Build.VERSION.RELEASE;

        deviceInfo.userAgent = System.getProperty("http.agent");

//        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        deviceInfo.IMEI = getFakeIMEI(context);
//        deviceInfo.PHONE_NUMBER = tm.getLine1Number();
        deviceInfo.DEVICE_ID = getFakeIMEI(context);
        deviceInfo.APP_DEVICE_ID = generateDeviceId(deviceInfo);

        info = deviceInfo;
        return info;
    }


    /**
     * 依次用ANDROID_ID,Serizal Number,Mac Address 代替IEMI，这样就不需要申请READ_PHONE_STATE权限了。
     * 6.0以下仍然获取IMEI,需要申请READ_PHONE_STATE权限。
     * 6.0及以上有可能会使用mac地址代替IMEI,所以需要申请ACCESS_WIFI_STATE权限。
     * @param context
     * @return
     */
    public static String getFakeIMEI(Context context) {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M ){
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return tm.getDeviceId();
        }
        String id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        if (id == null || "9774d56d682e549c".equals(id)) {
            id = android.os.Build.SERIAL;
            if (!legal(id)) {
                id = getWifiMacAddress();
            }
            if (!legal(id)) {
                id = "0";
            }
        }
        return id;
    }

    private static boolean legal(String id) {
        if (id == null || id.equals("") || id.contains("*")) {
            return false;
        }
        char firstChar = id.charAt(0);
        for (int i = 1; i < id.length(); i++) {
            if (id.charAt(i) != firstChar) {
                return true;
            }
        }
        return false;
    }

    private static String getWifiMacAddress() {
        try {
            String interfaceName = "wlan0";
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (!intf.getName().equalsIgnoreCase(interfaceName)) {
                    continue;
                }

                byte[] mac = intf.getHardwareAddress();
                if (mac == null) {
                    return "";
                }

                StringBuilder buf = new StringBuilder();
                for (byte aMac : mac) {
                    buf.append(String.format("%02X", aMac));
                }
                if (buf.length() > 0) {
                    buf.deleteCharAt(buf.length() - 1);
                }
                return buf.toString();
            }
        } catch (Exception ex) {
            // ignore
        }
        return "";
    }


    /**
     * 生成device id。
     * @param deviceInfo 注意，这里的deviceInfo的{@link DeviceInfo#APP_DEVICE_ID}可能没初始化。
     * @return
     */
    public static String generateDeviceId(DeviceInfo deviceInfo) {
        String deviceId = deviceInfo.DEVICE_ID;
        String board = deviceInfo.BOARD;
        String brand = deviceInfo.BRAND;
        String cpu_abi = deviceInfo.CPU_ABI;
        String device = deviceInfo.DEVICE;
        String display = deviceInfo.DISPLAY;
        String host = deviceInfo.HOST;
        String id = deviceInfo.ID;
        String manufacturer = deviceInfo.MANUFACTURER;
        String model = deviceInfo.MODEL;
        String product = deviceInfo.PRODUCT;
        String type = deviceInfo.TYPE;
        String user = deviceInfo.USER;
        String tags = deviceInfo.TAGS;


        if (deviceId == null) {
            deviceId = "111111111111111";
        }
        model = model.toLowerCase();

        boolean allNumber = true;
        for (int i = 0; i < deviceId.length(); i++) {
            if (deviceId.charAt(i) < '0' || deviceId.charAt(i) > '9') {
                allNumber = false;
                break;
            }
        }

        int DEVICE_ID_LEN = 15;
        if (deviceId.length() < DEVICE_ID_LEN) {
            for (int i = 0; i < DEVICE_ID_LEN - deviceId.length(); i++) {
                deviceId += "0";
            }
        }
        StringBuilder sb = new StringBuilder();

        if (allNumber && model.indexOf("sdk") < 0 && !deviceId.equals("000000000000000")) {
            sb.append(35)
                    .append(board.length() % 10)
                    .append(brand.length() % 10)
                    .append(cpu_abi.length() % 10)
                    .append(device.length() % 10)
                    .append(display.length() % 10)
                    .append(host.length() % 10)
                    .append(deviceId)
                    .append(id.length() % 10)
                    .append(manufacturer.length() % 10)
                    .append(model.length() % 10)
                    .append(product.length() % 10)
                    .append(tags.length() % 10)
                    .append(type.length() % 10)
                    .append(user.length() % 10);
        } else {
            StringBuilder tmp = new StringBuilder();
            String str = tmp.append(board.length() % 10)
                    .append(brand.length() % 10)
                    .append(cpu_abi.length() % 10)
                    .append(device.length() % 10)
                    .append(display.length() % 10)
                    .append(host.length() % 10)
                    .append(id.length() % 10)
                    .append(manufacturer.length() % 10)
                    .append(model.length() % 10)
                    .append(product.length() % 10)
                    .append(tags.length() % 10)
                    .append(type.length() % 10)
                    .append(user.length() % 10).toString();
            sb.append(35).append(str).append(str);
        }
        String result = sb.toString();
        logger.d(TAG, "generate result:" + result + "," + deviceInfo.toString());

        return result;
    }

    /**
     * take screen shot of activity passed in and save
     */
    public static boolean takeScreenShot(Context activity, String savePath) {
        if (activity == null) {
            return false;
        }
        try {
            View rootView = ((Activity) activity).getWindow().getDecorView().getRootView();
            rootView.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            rootView.setDrawingCacheEnabled(false);
            File imageFile = new File(savePath);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 50;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (Throwable e) {
            logger.d(TAG, "takeScreenShot fail:" + e.toString());
            return false;
        }
    }

    /**
     * take screen shot of activity passed in
     */
    public static Bitmap takeScreenShot(Context activity) {
        if (activity == null) {
            return null;
        }
        try {
            View rootView = ((Activity) activity).getWindow().getDecorView().getRootView();
            rootView.buildDrawingCache();
            int viewWidth = rootView.getWidth();
            int viewHeight = rootView.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(viewWidth, viewHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            rootView.draw(canvas);
            rootView.destroyDrawingCache();
            return bitmap;
        } catch (Throwable e) {
            logger.d(TAG, "takeScreenShot fail:" + e.toString());
            return null;
        }
    }

    public static float getDensity(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.density;
    }

    /**
     * 判断是否为的EInk墨水屏。
     * @return
     */
    public static boolean isEInk() {
        //此处仅判断厂商为Onyx,以后再扩展
        return android.os.Build.MANUFACTURER.contains("Onyx");
    }

    public static String getBuildProperty(String name, String defaultValue) {
        String result = "";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            Properties mProperties = new Properties();
            mProperties.load(fileInputStream);
            result = mProperties.getProperty(name, defaultValue);
            if (result == null) {
                result = "";
            }
        } catch (IOException ignored) {
            return defaultValue;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException ignored) {
            }
        }
        return result;
    }

    public static String getBrand() {
        if (getBuildProperty("ro.qrom.build.brand", "").equalsIgnoreCase("tos")) {
            return "tos";
        } else {
            return getBuildProperty("ro.product.brand", "null").trim();
        }
    }
}
