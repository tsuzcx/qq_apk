package moai.log;

import android.util.Log;


/**
 * 提供：TEA加密
 */
public class TEAFileHandler extends FileHandlerDelegate {
	private final byte[] key;

	public TEAFileHandler(FileHandler fileHandler, byte[] key) {
		super(fileHandler);
		if (key == null || key.length != 16) {
			throw new IllegalArgumentException("key error: "
					+ (key != null ? key.length : null));
		}
		this.key = key;
	}

	@Override
	protected boolean onWriteToBuf(LogData rawLogData, ByteBufferWrapper buffer) {
		super.onWriteToBuf(rawLogData, buffer);
		// 使用TEA的技巧，补起8倍数
		int pos = buffer.position();
		int len = buffer.length() - pos;
		// Log.i("TEAFileHandler", "onWriteToBuf:" + pos + "," + len + ", tid:" + Thread.currentThread().getName());
		if (len > 0) {
			int finLen = (len / 8 + (len % 8 == 0 ? 0 : 1)) * 8;
			if (pos + finLen >= MAX_BUF_SIZE) {
				appendDebugLog(String.format("errtea:pos:%d:len:%d:msg:%d:th:%b", pos, len, (rawLogData.msg == null ? 0 : rawLogData.msg.length()), rawLogData.throwable != null));
				while (pos + finLen >= MAX_BUF_SIZE) {
					finLen = finLen - 8;
				}
			}
			
			for (int i = len; i < finLen; i++) {
				buffer.toBuffer().array()[i + pos] = 0; // 这里有个前提是sb.capacity是8的倍数
			}
			
			TEA.encrypt16(buffer.toBuffer().array(), pos,
					finLen, key, buffer.toBuffer()
					.array(), pos);
			buffer.setLength(pos + finLen);
		}
		return true;
	}
}
