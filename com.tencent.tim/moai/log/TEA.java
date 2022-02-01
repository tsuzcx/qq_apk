package moai.log;

import android.util.Log;

/**
 * <pre>
 * TEA加密算法
 * 特点，后面填补0
 * 提供：
 * 1. 16轮的加密
 * 2. 32轮的加密
 * 
 * </pre>
 */
// 放在moai-log模块是有问题，但又不能放在core，等以后出encrypt模块再处理
/*public*/ final class TEA {
	private static int byte2int(byte[] in, int inOffset) {
		return (0xFF & in[0 + inOffset]) << 24
				| (0xFF & in[1 + inOffset]) << 16
				| (0xFF & in[2 + inOffset]) << 8 | (0xFF & in[3 + inOffset]);
	}

	private static void int2byte(int v, byte[] out, int outOffset) {
		out[3 + outOffset] = (byte) (v >>> 0 & 0xFF);
		out[2 + outOffset] = (byte) (v >>> 8 & 0xFF);
		out[1 + outOffset] = (byte) (v >>> 16 & 0xFF);
		out[0 + outOffset] = (byte) (v >>> 24 & 0xFF);
	}

	/**
	 * 16轮加密，128bit作为key，明文64bit倍数
	 * 
	 * @param in
	 * @param inOffset
	 * @param key
	 * @param out
	 * @param outOffset
	 */
	private static void encrypt16(byte[] in, int inOffset, int[] key,
			byte[] out, int outOffset) {
		if (in.length < inOffset + 8) {
			throw new IndexOutOfBoundsException("len: " + in.length + ", offset: " + inOffset); 
		}
		if (key.length != 4) {
			throw new IllegalArgumentException("key error: " + key.length);
		}
		int y = byte2int(in, inOffset);
		int z = byte2int(in, inOffset + 32 / 8);
		final int delta = 0x9e3779b9;
		final int a = key[0];
		final int b = key[1];
		final int c = key[2];
		final int d = key[3];
		int sum = 0;
		for (int i = 0; i < 16; i++) {
			sum += delta;
			y += ((z << 4) + a) ^ (z + sum) ^ ((z >>> 5) + b);
			z += ((y << 4) + c) ^ (y + sum) ^ ((y >>> 5) + d);
		}
		int2byte(y, out, outOffset);
		int2byte(z, out, outOffset + 32 / 8);
	}

	private static void decrypt16(byte[] in, int inOffset, int[] key,
			byte[] out, int outOffset) {
		if (in.length < inOffset + 8) {
			throw new IndexOutOfBoundsException("len: " + in.length + ", offset: " + inOffset); 
		}
		if (key.length != 4) {
			throw new IllegalArgumentException("key error: " + key.length);
		}

		int y = byte2int(in, inOffset);
		int z = byte2int(in, inOffset + 32 / 8);
		final int delta = 0x9e3779b9;
		final int a = key[0];
		final int b = key[1];
		final int c = key[2];
		final int d = key[3];
		int sum = delta << 4;
		for (int i = 0; i < 16; i++) {
			z -= ((y << 4) + c) ^ (y + sum) ^ ((y >>> 5) + d);
			y -= ((z << 4) + a) ^ (z + sum) ^ ((z >>> 5) + b);
			sum -= delta;
		}
		int2byte(y, out, outOffset);
		int2byte(z, out, outOffset + 32 / 8);
	}

	private static int[] genKey(byte[] key) {
		final int a = byte2int(key, 32 * 0 / 8);
		final int b = byte2int(key, 32 * 1 / 8);
		final int c = byte2int(key, 32 * 2 / 8);
		final int d = byte2int(key, 32 * 3 / 8);
		return new int[] { a, b, c, d };
	}

	/**
	 * 
	 * @param in
	 * @param inLen
	 * @param key
	 * @param out
	 *            如果null或out不够空间，就重新创建，否则重用，需要用{{@link #encrypt16Len(byte[])}
	 *            来获取有效长度
	 *            技巧，如果in.length是8倍数，out.length==in.length，就可把加密后结果返回in
	 * 
	 * @return out的引用
	 */
	public static byte[] encrypt16(byte[] in, final int inOffset, final int inLen, byte[] key, byte[] out, final int outOffset) {
		// 假设in的数据从0开始，到inLen结束
		// out的数据从0开始
		if (in == null || in.length == 0) {
			return new byte[0];
		}
		if (in.length < inOffset + inLen) {
			throw new IndexOutOfBoundsException("len: " + in.length + ", offset: " + inOffset + ", inLen: " + inLen);
		}
		final int[] keyContent = genKey(key);

		final int inLen8 = inLen / 8;
		final int inRestLen = inLen % 8;
		final int outLen = (inLen8 + (inRestLen > 0 ? 1 : 0)) * 8;
		if (out == null || out.length < outLen) {
			out = new byte[outLen];
		}

		// in.length 8x, out.length 8x
		// in.length 8x+n 补(8-n)个零，out.length 8(x+1)
		// 所以数据不能以0结尾
//		if (in[inLen - 1] == 0) {
		// 外面补起8x，会以0结尾；真实数据不会0结尾
//			throw new IllegalArgumentException("not support");
//		}
		int inIndex = inOffset;
		int outIndex = outOffset;
		for (; inIndex < inOffset + inLen8 * 8; inIndex += 64 / 8, outIndex += 64 / 8) {
			encrypt16(in, inIndex, keyContent, out, outIndex);
		}
		// 补零
		if (inRestLen > 0) {
			byte[] rest = new byte[8];// { 0 }
			System.arraycopy(in, inIndex, rest, 0, inRestLen);
			encrypt16(rest, 0, keyContent, out, outIndex);
			outIndex += 32 / 8;
		}
		return out;
	}
	
//	public static byte[] encrypt16(byte[] in, byte[] key, byte[] out) {
//		return encrypt16(in, in.length, key, out);
//	}

	/**
	 * TEA加密后，结果的长度
	 * 
	 * @param in
	 * @return
	 */
	public static int encrypt16Len(byte[] in, int inOffset, int inLen) {
		if (in == null || in.length == 0) {
			return 0;
		}
		if (in.length < inOffset + inLen) {
			throw new IndexOutOfBoundsException("len: " + in.length + ", offset: " + inOffset + ", inLen: " + inLen);
		}
		// 内容与长度分开，为了不想新建类
		final int inLen8 = inLen / 8;
		final int inRestLen = inLen % 8;
		final int outLen = (inLen8 + (inRestLen > 0 ? 1 : 0)) * 8;
		return outLen;
	}

	/**
	 * 方便函数 {@link #encrypt16(byte[], byte[], byte[])}
	 * 
	 * @param in
	 * @param key
	 * @param out
	 * @return
	 */
	public static byte[] encrypt16(String in, byte[] key, byte[] out) {
		byte[] inBytes = in.getBytes();
		return encrypt16(inBytes, 0, inBytes.length, key, out, 0);
	}

	/**
	 * 方便函数 {@link #encrypt16Len(byte[])}
	 * 
	 * @param in
	 * @return
	 */
	public static int encrypt16Len(String in) {
		byte[] bytes = in.getBytes();
		return encrypt16Len(bytes, 0, bytes.length);
	}

	// ?使用struct

	/**
	 * @param in
	 * @param key
	 * @param out
	 *            不支持重用
	 * @return
	 */
	public static byte[] decrypt16(byte[] in, byte[] key, byte[] out) {
		if (in.length % 8 != 0) {
			throw new IllegalArgumentException("in error: " + in.length);
		}
		if (in.length == 0) {
			return new byte[0];
		}

		final int[] keyContent = genKey(key);
		// 末尾为0的，认为是补零，去掉，明文的长度，需要先解密最后64bit才获得
		byte[] rest = new byte[8];
		decrypt16(in, in.length - 8, keyContent, rest, 0);
		int restLen = rest.length;
		while (restLen > 0 && rest[restLen - 1] == 0) {
			--restLen;
		}
		if (restLen == 0 && rest[0] == 0) {
			// 实际数据，不能以0结尾
			throw new IllegalStateException("encrypt error");
		}
		// TODO out如何重用？类封装
		out = new byte[in.length - 8 + restLen];
		int inOffset = 0;
		int outOffset = 0;
		for (; inOffset < in.length - 8; inOffset += 8, outOffset += 8) {
			decrypt16(in, inOffset, keyContent, out, outOffset);
		}
		System.arraycopy(rest, 0, out, outOffset, restLen);
		outOffset += restLen;
		return out;
	}

	// public static int decrypt16Len(byte[] in) {
	// return 0;
	// }

}
