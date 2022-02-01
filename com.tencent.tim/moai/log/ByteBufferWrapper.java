package moai.log;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/**
 * <pre>
 * 封装ByteBuffer，自动结尾功能
 * 接口与StringBuilder完全一致，便于替换
 * </pre>
 */
class ByteBufferWrapper {
	/**
	 * buffer数据从0开始
	 */
	private final ByteBuffer buffer;
	private boolean notFull = true;
	private int position = 0;
	
	public ByteBufferWrapper(int capacity) {
		buffer = ByteBuffer.allocate(capacity);
	}
	

	
	public ByteBufferWrapper append(String cs) {
		if (notFull) {
			if (cs == null) {
				cs = "null";
			}
			for (int i = 0, len = cs.length(); i < len; i++) {
				append(cs.charAt(i));
			}
		}
		return this;
	}
	
	public ByteBufferWrapper append(long v) {
		if (notFull) {
			append(Long.toString(v));
		}
		return this;
	}
	
	public ByteBufferWrapper append(int v) {
		if (notFull) {
			append(Integer.toString(v));
		}
		return this;
	}
	
	public ByteBufferWrapper append(ByteBufferWrapper bb) {
		if (notFull) {
			try {
				buffer.put(bb.buffer.array(), 0, bb.length());
			} catch (BufferOverflowException e) {
				notFull = false;
			}
		}
		return this;
	}
	
	public ByteBufferWrapper append(char v) {
		// 所有的append都走到这里处理
		if (notFull) {
			try {
				if (v < 128) {
					// 大多数都是ASCII
					buffer.put((byte)v);
				} else {
					buffer.put(Character.toString(v).getBytes());
				}
			} catch (BufferOverflowException e) {
				notFull = false;
			}
		}
		return this;
	}
	
	public void clear() {
		buffer.clear();
		position = 0;
		notFull = true;
	}
	
	public int capacity() {
		return buffer.capacity();
	}
	
	public int position() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int length() {
		return buffer.position();
	}
	
	public void setLength(int len) {
		buffer.position(len);
	}
	
	public ByteBuffer toBuffer() {
		return buffer;
	}
	
	@Override
	public String toString() {
		return new String(buffer.array(), 0, length());
	}
	
	public ByteBufferWrapper flip() {
		buffer.flip();
		return this;
	}
}
