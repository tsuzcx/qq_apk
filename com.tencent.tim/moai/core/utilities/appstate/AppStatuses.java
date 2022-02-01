package moai.core.utilities.appstate;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import moai.core.watcher.Watchers;

import java.util.List;

import moai.log.MLog;
import moai.log.MLogManager;

/**
 * app状态工具类
 * @author masonqwli
 *
 */
public class AppStatuses {

	private static final String TAG = "AppStatuses";
	private static final MLog logger = MLogManager.getLogger("moailog");
	
	private static boolean bIsAppOnBackground = true;

    private static boolean bIsNetworkConnected;

    private static ActivityLifecycleCallbacks sLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        private int mActiveCount = 0;
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) { }

        @Override
        public void onActivityStarted(Activity activity) {
            ++mActiveCount;
            if (mActiveCount == 1) {
                didGotoForeground();
                Log.d(TAG, "didGotoForeground, activity:" + activity.getClass().getSimpleName());
            }
        }

        @Override
        public void onActivityResumed(Activity activity) {}

        @Override
        public void onActivityPaused(Activity activity) {}

        @Override
        public void onActivityStopped(Activity activity) {
            --mActiveCount;
            if (mActiveCount == 0) {
                didGotoBackground(activity);
                Log.d(TAG, "did goto background, activity:" + activity.getClass().getSimpleName());
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) { }

        @Override
        public void onActivityDestroyed(Activity activity) { }
    };

    public static void registerActivityLifecycleCalbacks(Application application) {
        application.registerActivityLifecycleCallbacks(sLifecycleCallbacks);
    }

    public static void unRegisterAcitivityLifecycleCallbacks(Application application) {
        application.unregisterActivityLifecycleCallbacks(sLifecycleCallbacks);
    }

    /**
     * 监控网络状态，提供一个快速查询网络状态的接口。
     * @param connected
     */
    public static void setNetworkConnected(boolean connected) {
        bIsNetworkConnected = connected;
    }

    /**
     * 网络是否连接。
     * @return
     */
    public static boolean isNetworkConnected() {
        return bIsNetworkConnected;
    }
	
	/**
	 * 判断app是否在前台<br>
	 * 可能需要配合{@link AppStatuses#isScreenLocked}函数使用
	 * @param context
	 * @return
	 */
    @Deprecated
	public static boolean isApplicationActive(Context context) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		
		List<RunningTaskInfo> listInfo = am.getRunningTasks(1);
		if (listInfo != null && listInfo.size() >= 1) {
			String packet = listInfo.get(0).topActivity.getPackageName();
			String appPacket = context.getApplicationInfo().packageName;
			return packet.equals(appPacket);
		} else {
			return false;
		}
	}
	
	/**
	 * 自己记录app是在前台还是后台的信息。如果是从后台切换到前台，那么要mobile sync  <br>
	 * 如果返回true，说明app是从后台切换到了前台
	 * @return
	 */
	public static boolean isAppOnBackGround() {
		return bIsAppOnBackground;
	}
	
	/**
	 * 记录app
	 * @param isAppActive
	 */
	private static void setAppStatus(boolean isAppActive) {
		bIsAppOnBackground = !isAppActive;
		//记录日志
		logger.d(TAG, "setAppStatus:" + isAppActive);
	}

    /**
     * app来到前台的时候，记录app的状态并发送切到前台的通知
     */
    public static boolean didGotoForeground() {
        //标记App状态为活跃状态
        setAppStatus(true);

        Watchers.of(GotoForegroundWatcher.class).onGotoForeground();
        return true;
    }

	/**
	 * 判断手机是否锁屏
	 * @return
	 */
	public final static boolean isScreenLocked(Context context) {
		KeyguardManager keyGuardMgr = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
		
		if (keyGuardMgr.inKeyguardRestrictedInputMode()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取app主进程信息
	 * @return
	 */
	public static RunningAppProcessInfo getMainProcessInfo(Context context) {
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		String packageName = context.getPackageName();
		
		List<RunningAppProcessInfo> appProcesses = activityManager
				.getRunningAppProcesses();
		if (appProcesses == null) {
			return null;
		}
		for (RunningAppProcessInfo appProcess : appProcesses) {
			// The name of the process that this object is associated with.
			if (appProcess.processName.equals(packageName)) {
				return appProcess;
			}
		}
		return null;
	}
	
	/**
	 * 判断app是否在前台
	 * @return
	 */
    @Deprecated
	public static boolean isAppOnForeground(Context context) {
		if (AppStatuses.isScreenLocked(context)) {
			return false;
		}

		RunningAppProcessInfo mainProcessInfo = getMainProcessInfo(context);
		if(mainProcessInfo != null && mainProcessInfo.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
			return true;
		}
		
		return false;
	}

    /**
     * App 退到后台
     * @param ctx
     */
    public static void didGotoBackground(Context ctx) {
        setAppStatus(false);

        Watchers.of(GotoBackgroundWatcher.class).onGotoBackground();
    }
}
