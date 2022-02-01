package moai.core.utilities;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 角标工具类
 */
public class Badges {


    private static int currCount = 0;
    private volatile static Badges instance;

    /**
     * Double-check 单例
     * @return
     */
    public static Badges getInstance() {
        if (instance == null) {
            synchronized (Badges.class) {
                if (instance == null) {
                    instance = new Badges();
                }
            }
        }
        return instance;
    }

    /**
     * Constructor
     */
    private Badges(){

    }

    /**
     * 角标加1
     * @param context
     * @throws Throwable
     */
    public void setBadgeCountIncrease(Context context) throws Throwable {
        setBadgeCount(context, ++currCount);
    }

    /**
     * 角标减1
     * @param context
     * @throws Throwable
     */
    public void setBadgeCountDecrease(Context context) throws Throwable {
        setBadgeCount(context, --currCount);
    }

    /**
     * 设置Badge
     *
     * 目前支持Launcher: Vivo、Sony、Samsung、HTC、Sony、Huawei(EMUI3.1及以上)
     * @param context context
     * @param count   count
     */
    public void setBadgeCount(Context context, int count) throws Throwable {
        count = Math.max(0, Math.min(count, 99));
        ComponentName componentName = getLaucnerComponent(context);
        currCount = count;
        if(componentName == null){
            setBadgeUsingCommonWay(context, count);
            return;
        }
        if (Build.BRAND.toLowerCase().equalsIgnoreCase("sony")) {
            setBadgeOfSony(componentName, context, count);
        } else if (Build.BRAND.toLowerCase().contains("samsung")) {
            setBadgeOfSumsung(componentName, context, count);
        } else if (Build.BRAND.toLowerCase().contains("htc")) {
            setBadgeOfHTC(componentName, context, count);
        } else if (Build.BRAND.toLowerCase().contains("vivo")) {
            setBadgeOfVivo(componentName, context, count);
        } else if (Build.BRAND.toLowerCase().contains("huawei") ||
                Build.BRAND.toLowerCase().contains("honor")) {
            setBadgeOfHuawei(componentName, context, count);
        } else if (Build.BRAND.toLowerCase().contains("smartisan")) {
            //锤子有自己的桌面，适用特殊方案
            setBadgeOfSmartisan(componentName, context, count);
            //锤子有原生桌面，适用通用方案
            setBadgeUsingCommonWay(context, count);
        } else {
            setBadgeUsingCommonWay(context, count);
        }
    }
    
    

    /**
     * 锤子smartisan
     * @param context
     * @param totalUnreadMsg
     */
    public void setBadgeOfSmartisan(ComponentName componentName, Context context, final int totalUnreadMsg) {
        Intent intent = new Intent("com.smartisanos.launcher.new_message");
        intent.putExtra("extra_packagename", componentName.getPackageName());//package name
        intent.putExtra("extra_componentname", componentName.getClassName());//component name
        intent.putExtra("extra_message_count", totalUnreadMsg);
        context.sendBroadcast(intent);
    }

    /**
     * Vivo
     * @param context
     * @param totalUnreadMsg
     */
    public void setBadgeOfVivo(ComponentName componentName, Context context, final int totalUnreadMsg) {
        Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", componentName.getPackageName());
        intent.putExtra("className", componentName.getClassName());
        intent.putExtra("notificationNum", totalUnreadMsg);
        context.sendBroadcast(intent);
    }

    /**
     * Sony
     *
     * <p>
     * 需添加权限：<uses-permission android:name="com.sonyericsson.home.permission.BROADCAST_BADGE" />
     *
     * @param context context
     * @param count   count
     */
    public void setBadgeOfSony(ComponentName componentName, Context context, int count) {
        boolean isShow = count > 0 ? true : false;
        Intent localIntent = new Intent();
        localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", isShow);//是否显示
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(count));//数字
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());//启动页
        localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());//包名
        context.sendBroadcast(localIntent);
    }

    /**
     * 设置三星的Badge、设置LG的Badge  （LG未侧死）
     *
     * @param context context
     * @param count   count
     */
    public void setBadgeOfSumsung(ComponentName componentName, Context context, int count) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        context.sendBroadcast(intent);
    }

    /**
     * 设置HTC的Badge
     *
     * HTC所需权限 <uses-permission android:name="com.htc.launcher.permission.UPDATE_SHORTCUT" />
     * @param context context
     * @param count   count
     */
    public void setBadgeOfHTC(ComponentName componentName, Context context, int count) {
        Intent intent = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent.putExtra("packagename", componentName.getPackageName());
        intent.putExtra("count", count);
        context.sendBroadcast(intent);

        Intent setNotificationIntent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        setNotificationIntent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        setNotificationIntent.putExtra("com.htc.launcher.extra.COUNT", count);
        context.sendBroadcast(setNotificationIntent);
    }

    /**
     * 设置HUAWEI EMUI-3.1及以上系统角标
     *
     * 所需权限
     * <uses-permission android:name="com.huawei.android.launcher.permission.CHANGE_BADGE"/>
     * <uses-permission android:name="com.huawei.android.launcher.permission.WRITE_SETTINGS" />
     * <uses-permission android:name="com.huawei.android.launcher.permission.READ_SETTINGS" />
     * @param componentName
     * @param context
     * @param count
     */
    public void setBadgeOfHuawei(ComponentName componentName, Context context, int count) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", componentName.getPackageName());// com.test.badge is your package name
            bundle.putString("class", componentName.getClassName()); // com.test. badge.MainActivity is your apk main activity
            bundle.putInt("badgenumber", count);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 当前华为机器是否支持角标
     *
     * @return
     */
    public boolean isSupportedHuaweiBadge(Context context){
        Context LauncherContext = null;
        try {
            LauncherContext = context.createPackageContext("com.huawei.android.launcher", Context.CONTEXT_IGNORE_SECURITY | Context.CONTEXT_INCLUDE_CODE);
            Class<?> c =
                    LauncherContext.getClassLoader().loadClass("com.huawei.android.launcher.LauncherProvider");
            Object obj =c.newInstance();
            Method m = c.getMethod("isSupportChangeBadgeByCallMethod", new Class[]{});
            Boolean isSupport = (Boolean) m.invoke(obj, new Object[]{});
            return isSupport;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置Nova的Badge
     *
     * 未测试
     *
     * @param context context
     * @param count   count
     */
    public void setBadgeOfNova(ComponentName componentName, Context context, int count) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + "/" +
                componentName.getClassName());
        contentValues.put("count", count);
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"),
                contentValues);
    }


    /**
     * 微信通用方案
     * @param context
     * @param count
     */
    public void setBadgeUsingCommonWay(Context context, int count) {
        Bundle extra = new Bundle();
        extra.putStringArrayList("app_shortcut_custom_id", null);
        extra.putInt("app_badge_count", count);
        final Uri CONTENT_URI = Uri.parse("content://" + "com.android.badge" + "/" + "badge");
        context.getContentResolver().call(CONTENT_URI, "setAppBadgeCount", null, extra);
    }

    /**
     * 重置Badge
     *
     * @param context context
     */
    public void resetBadgeCount(Context context) throws Throwable {
        setBadgeCount(context, 0);
    }

    public ComponentName getLaucnerComponent(Context context){
        return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
    }

}
