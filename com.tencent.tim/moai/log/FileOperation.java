package moai.log;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

public interface FileOperation {

	public void flush();
	/**
	 * <pre>
	 * 获取以时间戳作为文件名称的某段时间[begin,end)的文件路径
	 * </pre>
	 * @param begin 如果非null，特定的日期；如果null，最前的，(包括的)
	 * @param end 如果非null，特定的日期；如果null，最后的，(不包括的)
	 * @return 文件的绝对路径
	 */
	public List<String> list(GregorianCalendar begin, GregorianCalendar end);
	

	
	/**
	 * 过滤特定的内容，并打zip包 
	 */
	public void zip(Config config, String outFilePath); // grep and zip
	
	
	static class Config {
		// 开始的时间，如果null，就最前
		private GregorianCalendar begin;
		// 结束的时间，如果null，就最后
		private GregorianCalendar end;
		// 相当于grep -E "${pattern}"
		private Pattern pattern;
		// 相当于grep "patternString"
		private String patternString;
		
		public GregorianCalendar getBegin() {
			return begin;
		}

		public GregorianCalendar getEnd() {
			return end;
		}

		public Pattern getPattern() {
			return pattern;
		}

		public String getPatternString() {
			return patternString;
		}
		
		public static class Builder {
			private final Config config = new Config();
			public static Builder newBuilder() {
				return new Builder();
			}
			public Config build() {
				return config; // 应该config.clone();但一个builder用一次
			}
			
			public Builder setBeginTime(GregorianCalendar begin) {
				config.begin = begin;
				return this;
			}
			public Builder setEndTime(GregorianCalendar end) {
				config.end = end;
				return this;
			}
			public Builder setPattern(Pattern pattern) {
				config.pattern = pattern;
				return this;
			}
			public Builder setPatternString(String str) {
				config.patternString = str;
				return this;
			}
		}
	}
}
