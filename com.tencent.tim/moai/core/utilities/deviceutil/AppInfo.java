package moai.core.utilities.deviceutil;

public class AppInfo {
	public String appName = "";
	public String packageName = "";
	public String versionName = "";
	public int versionCode = 0;

	@Override
	public String toString() {
		return new StringBuilder().append("appname:").append(appName).append(",packagename:").append(packageName).append(",versionname:").append(versionName).append(",versioncode:")
				.append(versionCode).toString();
	}
}