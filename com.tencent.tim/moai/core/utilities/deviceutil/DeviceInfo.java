package moai.core.utilities.deviceutil;

public class DeviceInfo {
	public String BRAND;
	public String TYPE;
	public String sdkIntVersion;
	public String TIME;
	public String FINGERPRINT;
	public String USER;
	public String DEVICE;
	public String MODEL;
	public String SERIAL;
//	public String PHONE_NUMBER;
	public String DISPLAY; // rom版本
	public String PRODUCT;
	public String BOARD;
	public String BOOTLOADER;
	public String HARDWARE;
	public String RADIO;
	public String TAGS;
	public String ID;
	public String MANUFACTURER;
	public String IMEI;
	public String CPU_ABI;
	public String CPU_ABI2;
	public String IS_DEBUGGABLE;
	public String releaseVersion;
	public String userAgent;
	public String HOST;
	public String DEVICE_ID; //TelephonyManager的getDeviceId接口的返回
	public String APP_DEVICE_ID; //根据自己APP算法计算得出的DeviceId

	@Override
	public String toString() {
		return "DeviceInfo{" +
				"BRAND='" + BRAND + '\'' +
				", TYPE='" + TYPE + '\'' +
				", sdkIntVersion='" + sdkIntVersion + '\'' +
				", TIME='" + TIME + '\'' +
				", FINGERPRINT='" + FINGERPRINT + '\'' +
				", USER='" + USER + '\'' +
				", DEVICE='" + DEVICE + '\'' +
				", MODEL='" + MODEL + '\'' +
				", SERIAL='" + SERIAL + '\'' +
//				", PHONE_NUMBER='" + PHONE_NUMBER + '\'' +
				", DISPLAY='" + DISPLAY + '\'' +
				", PRODUCT='" + PRODUCT + '\'' +
				", BOARD='" + BOARD + '\'' +
				", BOOTLOADER='" + BOOTLOADER + '\'' +
				", HARDWARE='" + HARDWARE + '\'' +
				", RADIO='" + RADIO + '\'' +
				", TAGS='" + TAGS + '\'' +
				", ID='" + ID + '\'' +
				", MANUFACTURER='" + MANUFACTURER + '\'' +
				", IMEI='" + IMEI + '\'' +
				", CPU_ABI='" + CPU_ABI + '\'' +
				", CPU_ABI2='" + CPU_ABI2 + '\'' +
				", IS_DEBUGGABLE='" + IS_DEBUGGABLE + '\'' +
				", releaseVersion='" + releaseVersion + '\'' +
				", userAgent='" + userAgent + '\'' +
				", DEVICE_ID='" + DEVICE_ID + '\'' +
				", APP_DEVICE_ID='" + APP_DEVICE_ID + '\'' +
				", HOST='" + HOST + '\'' +
				'}';
	}
}
