package moai.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;

import java.io.File;

/**
 * sd卡工具类。
 *
 * @author masonqwli
 */
public final class Sdcards {
	private Sdcards() {
	}

	private static String TAG = Sdcards.class.getSimpleName();

	/**
	 * 判断SD卡是否存在
	 *
	 * @return true，存在；false，不存在
	 */
	public static boolean hasSdcard() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断sd卡容量是否大于sizeMb
	 *
	 * @param sizeMb
	 * @return
	 */
	public static boolean isAvaiableSpace(int sizeMb) {
		boolean ishasSpace = false;
		if (hasSdcard()) {
			String sdcard = Environment.getExternalStorageDirectory().getPath();
			long availableSpare = getUsableSpace(new File(sdcard));
			// //Log.i("剩余空间", "availableSpare = " + availableSpare);
			if (availableSpare > sizeMb) {
				ishasSpace = true;
			}
		}
		return ishasSpace;
	}


	/**
	 * 手机系统版本是否在4.4以上
	 */
	private static final boolean sdkVersionKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

	/**
	 * 是否为默认存储目录，/Android/data/packagename
	 */
	private static boolean isAppDefaultStorageDirectory(Context context, String dirPath) {
		if (dirPath != null && !dirPath.equals("")) {
			// 必须符合 root/sdcard/Android/data目录，才是默认可写目录
			String tmpDir = dirPath;
			if (dirPath.substring(0, 1).equals("/")) {
				tmpDir = dirPath.substring(1);
			}
			String dir[] = tmpDir.split("/");
			int dirLen = dir.length;
			if (dirLen < 3) {
				return true;
			} else if (3 == dirLen) {
				return dirPath.contains("/Android") ? true : false;
			} else if (4 == dirLen) {
				return dirPath.contains("/Android/data") ? true : false;
			} else {
				return dirPath.contains("/Android/data/" + context.getPackageName()) ? true : false;
			}
		}
		return false;
	}

	/**
	 * 判断是不是默认路径的父级节点
	 */
	private static boolean isAppDefaultStorageDirectoryRoot(String dirPath) {
		if (dirPath != null && !dirPath.equals("")) {
			// 必须符合 root/sdcard/Android/data目录，才是默认可写目录
			String tmpDir = dirPath;
			if (dirPath.substring(0, 1).equals("/")) {
				tmpDir = dirPath.substring(1);
			}
			String dir[] = tmpDir.split("/");
			int dirLen = dir.length;
			if (dirLen < 5) {
				return true;
			}
		}
		return false;
	}

	private static boolean isInnerStorageDirectory(Context context, String dirPath) {
		File file = Environment.getExternalStorageDirectory();
		if (file != null) {
			String inStorageRoot = file.getAbsolutePath();
			StorageManager sm = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
			// 获取sdcard的路径：外置和内置
			try {
				String[] paths = (String[]) sm.getClass().getMethod("getVolumePaths").invoke(sm);
				for (String path : paths) {
					if (dirPath.contains(path)) {
						if (path.equalsIgnoreCase(inStorageRoot)) {
							return true;
						}
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 判断外存储目录是否在 /Android/data/com.tencent.androidqqmail上
	 */
	public static boolean isSdcardDirectoryOnWritablePath(Context context, String dirPath) {
		// 还需要判断不是默认存储卡
		if (Files.isFileDir(dirPath)
				&& !isAppDefaultStorageDirectory(context, dirPath)
				&& sdkVersionKitKat
				&& !isInnerStorageDirectory(context, dirPath)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断当前目录是否可写
	 * /Android/data/com.tencent.androidqqmail目录可写，/Android/data/就不可写
	 */
	public static boolean isCurrentSdcardDirectoryWritable(Context context, String dirPath) {
		// 还需要判断不是默认存储卡
		if (Files.isFileDir(dirPath)
				&& isAppDefaultStorageDirectoryRoot(dirPath)
				&& !isInnerStorageDirectory(context, dirPath)
				&& sdkVersionKitKat) {
			return false;
		}
		return true;
	}

	/**
	 * Check if external storage is built-in or removable.
	 *
	 * @return True if external storage is removable (like an SD card), false
	 * otherwise.
	 */
	@TargetApi(9)
	public static boolean isExternalStorageRemovable() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			return Environment.isExternalStorageRemovable();
		}
		return true;
	}

	/**
	 * Check how much usable space is available at a given path.
	 *
	 * @param path The path to check
	 * @return The space available in bytes
	 */
	@TargetApi(9)
	public static long getUsableSpace(File path) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			return path.getUsableSpace();
		}
		final StatFs stats = new StatFs(path.getPath());
		return (long) stats.getBlockSize() * (long) stats.getAvailableBlocks();
	}

	public static boolean createExternalCacheDirectory() {
		if (!hasSdcard()) {
			return false;
		} else {
			File cacheDir = new File(Files.CACHE_URL);
			if (!cacheDir.exists()) {
				cacheDir.mkdir();
			}
			return true;
		}
	}
}
