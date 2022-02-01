/**
 * 
 */
package moai.core.utilities.string;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import moai.log.MLog;
import moai.log.MLogManager;


/**
 * @author wenwilliam
 * 
 */
public class StringExtention {
	private static final MLog logger = MLogManager.getLogger("moailog");
	
	private static final String TAG = StringExtention.class.getSimpleName();
	public static final String UTF_8 = "UTF-8";
	
	public static final String MESSAGE_DIGEST_TYPE_MD5 = "MD5";
	public static final String MESSAGE_DIGEST_TYPE_SHA1 = "SHA-1";

	// add by jackie for base64
	// Base64.encodeToString() 这个接口有bug,不推荐使用
	private static final char[] base64EncodeChars = new char[] { 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
			'3', '4', '5', '6', '7', '8', '9', '+', '/' };

	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59,
			60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1,
			-1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
			38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,
			-1, -1 };

	/**
	 * 判断是否base64
	 * @param str
	 * @return
	 */
	public static boolean isBase64String(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (!(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'
					|| c >= '0' && c <= '9' || c == '+' || c == '/' || c == '=')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 将字节数组编码为字符串
	 * 
	 * @param data
	 */
	public static String base64Encode(byte[] data, int length) {
		StringBuilder sb = new StringBuilder();
		// int len = data.length;
		int len = length;
		int i = 0;
		int b1, b2, b3;

		while (i < len) {
			b1 = data[i++] & 0xff;
			if (i == len) {
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
				sb.append("==");
				break;
			}
			b2 = data[i++] & 0xff;
			if (i == len) {
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[(b1 & 0x03) << 4
						| (b2 & 0xf0) >>> 4]);
				sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
				sb.append("=");
				break;
			}
			b3 = data[i++] & 0xff;
			sb.append(base64EncodeChars[b1 >>> 2]);
			sb.append(base64EncodeChars[(b1 & 0x03) << 4
					| (b2 & 0xf0) >>> 4]);
			sb.append(base64EncodeChars[(b2 & 0x0f) << 2
					| (b3 & 0xc0) >>> 6]);
			sb.append(base64EncodeChars[b3 & 0x3f]);
		}
		return sb.toString();
	}

	/**
	 * 将base64字符串解码为字节数组
	 * 
	 * @param str
	 */
	public static byte[] decode(String str) {
		byte[] data = str.getBytes();
		int len = data.length;
		ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
		int i = 0;
		int b1, b2, b3, b4;

		while (i < len) {

			/* b1 */
			do {
				b1 = base64DecodeChars[data[i++]];
			} while (i < len && b1 == -1);
			if (b1 == -1) {
				break;
			}

			/* b2 */
			do {
				b2 = base64DecodeChars[data[i++]];
			} while (i < len && b2 == -1);
			if (b2 == -1) {
				break;
			}
			buf.write(b1 << 2 | (b2 & 0x30) >>> 4);

			/* b3 */
			do {
				b3 = data[i++];
				if (b3 == 61) {
					return buf.toByteArray();
				}
				b3 = base64DecodeChars[b3];
			} while (i < len && b3 == -1);
			if (b3 == -1) {
				break;
			}
			buf.write((b2 & 0x0f) << 4 | (b3 & 0x3c) >>> 2);

			/* b4 */
			do {
				b4 = data[i++];
				if (b4 == 61) {
					return buf.toByteArray();
				}
				b4 = base64DecodeChars[b4];
			} while (i < len && b4 == -1);
			if (b4 == -1) {
				break;
			}
			buf.write((b3 & 0x03) << 6 | b4);
		}
		return buf.toByteArray();
	}
	
	/**
	 * 获取文件的md5
	 * @param file
	 * @return
	 */
	public static String fileMD5(File file) {
		if (file == null) {
			logger.d(TAG, "getFileMD5. file is null.");
			return null;
		}
		if (!file.isFile()) {
			logger.e(TAG, "getFileMD5. not file:" + file.getAbsolutePath());
			return null;
		}
		
		String md5 = "";
		if (file.exists()) {
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				InputStream in = new BufferedInputStream(new FileInputStream(
						file));
				byte[] cache = new byte[1024];
				int len;
				try {
					while ((len = in.read(cache)) != -1) {
						messageDigest.update(cache, 0, len);
					}
				} finally {
					in.close();
				}
				byte[] data = messageDigest.digest();
				md5 = toHexString(data);
			} catch (Exception e) {
				logger.e(TAG, "fileMD5. get md5 err:" + e.toString());
				return "";
			}
		}
		return md5;
	}
	
	private static String toHexString(byte[] data) {
		StringBuilder digestStr = new StringBuilder();
		String stmp = "";
		for (int i = 0; i < data.length; i++) {
			stmp = Integer.toHexString(data[i] & 0XFF);
			if (stmp.length() == 1) {
				digestStr.append("0" + stmp);
			} else {
				digestStr.append(stmp);
			}
		}
		return digestStr.toString();
	}

	/**
	 * MD5加密<br>
	 * 1 / 注意，这个函数是得到md5之后做了一次hex！不要再跳坑
	 * 2 / 这个函数得到的md5不足32位，如果需要使用32位md5值，请使用 MD5With32Charactor()函数
	 * @param input
	 * @return
	 */
	private static String MD5(String input) {
		if (null == input)
			return null;
		String md5 = null;
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
	
	public static byte[] MD5(byte[] bytes) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(bytes, 0, bytes.length);
			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
			logger.i(TAG, "MD5 with bytes err:" + e.toString());
			return null;
		}
	}
	
	public static String MD5With16Charactor(String plainText) {
		String md5 = MD5With32Charactor(plainText).substring(0, 16);
		return md5;
	}
	
	/**
	 * MD5加密<br>返回值全部大写<br>
	 * 如果不足32位，则最后补0
	 * 
	 * @param plainText
	 * @return
	 */
	public static String MD5With32Charactor(String plainText) {
		if (plainText == null) {
			return null;
		}
		String str = MD5(plainText);
		str = str.toUpperCase(Locale.getDefault());
		while (str.length() < 32) {
			str = "0" + str;
		}
		return str;
	}

	public static String quickReplace(String src, HashMap<String, String> replacements, String separator) {
		// 不通用
		if (src == null || src.length() == 0 || replacements == null || replacements.size() == 0 || separator == null || separator.length() == 0) {
			return src;
		}

	    StringBuilder result = new StringBuilder(src.length());
	    int searchStart = 0;
	    do {
	        int matchStart = src.indexOf(separator, searchStart);
	        if (matchStart == -1) {
	            break;
	        }
	        int matchReturn = src.indexOf('\n', matchStart + 1);
	        int matchEnd = src.indexOf(separator, matchStart + 1);
	        if (matchReturn < matchEnd) {
	        	result.append(src, searchStart, matchReturn);
	        	searchStart = matchReturn + 1;
	        	continue;
	        }
	        if (matchEnd == -1) {
	        	break;
	        }
	        String key = src.substring(matchStart + 1, matchEnd);
	        String value = replacements.get(key);
	        if (value != null) {
	        	 result.append(src, searchStart, matchStart);
	        	 result.append(value);
	        } else {
	        	result.append(src, searchStart, matchEnd + 1);
	        }
	        searchStart = matchEnd + 1;
	    } while (searchStart < src.length());
	    if (searchStart < src.length()) {
	    	result.append(src, searchStart, src.length());
	    }
		return result.toString();
	}

	/**
	 * <pre>
	 * 提取map中的kv，将源字符串中的$k$用v替换
	 * 替换结果为： $k$  ->  v
	 * </pre>
	 * @param orgString
	 * @param dict
	 * @return
	 */
	public static String replaceWithDictionary(String orgString,
			HashMap<String, String> dict) {
		Iterator<Map.Entry<String,String>> iter = dict.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String,String> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue();
			orgString = orgString.replace("$" + key + "$", val);
		}
		return orgString;
	}

	/**
	 * join不同对象，用flag分隔
	 * @param objs
	 * @param flag
	 * @return
	 */
	public static String join(Object[] objs, String flag) {
		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0, len = objs.length; i < len; i++) {
			strBuilder.append(String.valueOf(objs[i]));
			if (i < len - 1)
				strBuilder.append(flag);
		}

		return strBuilder.toString();
	}
	
	/**
	 * join不同对象，用glue分隔
	 * @param oAry
	 * @param glue
	 * @return
	 */
	public static String join(List<?> oAry,String glue){
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0, len = oAry.size() ; i < len; i++){
			strBuilder.append(String.valueOf(oAry.get(i)));
			if(i < len - 1){
				strBuilder.append(glue);
			}
		}
		return strBuilder.toString();
	}
	
	/**
	 * 将org中的$template$用value替换
	 * @param org
	 * @param template
	 * @param value
	 * @return
	 */
	public static String replaceWithURIValue(String org, String template,
			String value) {
		if (null == value)
			value = "";
		return replace(org, template,value);
	}
	
	/**
	 * 将org中的$template$用encodeURI(value)替换
	 * @param org
	 * @param template
	 * @param value
	 * @return
	 */
	public static String replaceWithEncodeURIValue(String org, String template,
			String value) {
		if (null == value)
			value = "";
		return replace(org, template, encodeURI(value));
	}

	/**
	 * 将org中的$template$用value替换
	 * @param org
	 * @param key
	 * @param value
	 * @return
	 */
	public static String replace(String org, String key, String value) {
		return replaceTemplateWithSeparator(org, key, "$", value);
	}

	public static String[] encodeURIArray(String[] org){
		if (org == null)
			return null;
		String[] ret = new String[org.length];
		if (org.length > 0) {
			for(int i = 0; i < org.length; i ++ ){
				ret[i] = encodeURI(org[i]);
			}
		}
		return ret;
	}
	
	/**
	 * 去掉key=value中value的&，+符号
	 * 
	 * @param org
	 * @return
	 */
	public static String encodeURI(String org) {
		if (org == null)
			return null;
		String ret = new String(org);
		try {
			ret = StringExtention.urlEncode(ret);
			ret = ret.replaceAll("&", "%26");
			ret = ret.replaceAll("\\{", "%7B");
			ret = ret.replaceAll("\\}", "%7D");
			//
			return ret;
		} catch (Exception e) {
			return org;
		}
	}

	/**
	 * decodeURI
	 * @param org
	 * @return
	 */
	public static String decodeURI(String org) {
		if (org == null)
			return null;
		String ret = new String(org);
		try {
			ret = StringExtention.urlDecode(ret);
			ret = ret.replaceAll("%26", "&");
			return ret;
		} catch (Exception e) {
			return org;
		}
	}
	
	/**
	 * 将org中的separator + key + separator，用value替换
	 * @param org
	 * @param key
	 * @param separator
	 * @param value
	 * @return
	 */
	public static String replaceTemplateWithSeparator(String org, String key,
			String separator, String value) {
		if (value == null) {
			value = "";
		}
		return org.replace(separator + key + separator, value);
	}



	/**
	 * 把paramstring 解析成 keyvalue 对
	 * @param paramsString
	 * @param seperator
	 * @return
	 */
	public static List<NameValuePair> parseParams(String paramsString,
			String seperator) {
		return parseParams(paramsString, seperator, false);
	}

	/**
	 * <pre>
	 * 把paramstring 解析成 keyvalue 对
	 * isDecode 是否要decode uri
	 * 因为传进来的有encode过,multipart 不用encode
	 * </pre>
	 * @param paramsString
	 * @param seperator
	 * @param isDecode 是否需要decode uri
	 * @return
	 */
	public static List<NameValuePair> parseParams(String paramsString,
			String seperator, boolean isDecode) {

		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		if (paramsString == null || paramsString.equals(""))
			return paramList;

		if (null == seperator || seperator.equals(""))
			return paramList;

		String[] keyValues = paramsString.split(seperator);
		for (int i = 0; i < keyValues.length; i++) {
			String keyValue = keyValues[i];
			if (null != keyValue && !keyValue.equals("")) {
				int pos = keyValue.indexOf('=');
				if (pos > 0) {
					String key = keyValue.substring(0, pos);
					String value = "";
					if (pos + 1 < keyValue.length()) {
						value = keyValue.substring(pos + 1, keyValue.length());
					}
					if (isDecode)
						value = decodeURI(value);
					paramList.add(new BasicNameValuePair(key, value));
				}
			}
		}
		return paramList;
	}

	/**
	 * 把paramstring 解析成 keyvalue 对
	 * @param paramsString
	 * @param isDecode
	 * @return
	 */
	public static List<NameValuePair> parseParams(String paramsString,
			boolean isDecode) {
		return parseParams(paramsString, "&", isDecode);
	}

	/**
	 * 将params中的kv对连接成a=b&c=d的形式
	 * @param params
	 * @return
	 */
	public static String paramsString(List<NameValuePair> params) {
		if (params == null)
			return "";
		String paramsString = null;
		NameValuePair keyValue = null;
		for (int i = 0; i < params.size(); ++i) {
			keyValue = params.get(i);
			if (paramsString == null) {
				paramsString = keyValue.getName() + '=' + keyValue.getValue();
			} else {
				paramsString += '&' + keyValue.getName() + '='
						+ keyValue.getValue();
			}
		}
		return paramsString == null ? "" : paramsString;
	}

	/**
	 * <pre>
	 * 将params中的kv对连接成a=b&c=d的形式
	 * value
	 * </pre>
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String urlEncodeParams(List<NameValuePair> params)
			throws UnsupportedEncodingException {
		String paramString = null;
		NameValuePair keyValue = null;
		String key = "", value = "";
		for (int i = 0; i < params.size(); ++i) {
			keyValue = params.get(i);
			key = keyValue.getName();
			value = keyValue.getValue();
			if (null != value) {
				value = StringExtention.urlEncode(value);
			}
			if (paramString == null) {
				paramString = key + '=' + value;
			} else {
				paramString += '&' + key + '=' + value;
			}
		}
		return paramString;
	}

	/**
	 * url encode
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String urlEncode(String str)
			throws UnsupportedEncodingException {
		if (str != null) {
			str = URLEncoder.encode(str, "utf-8");
			// 保留= @ ,号--jasen
			str = str.replaceAll("%3D", "=");
			str = str.replaceAll("%40", "@");
			str = str.replaceAll("%2C", ",");
		}
		return str;
	}

	/**
	 * url decode。使用utf8编码
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String urlDecode(String str)
			throws UnsupportedEncodingException {
		if (str != null) {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception ex) {

            }
		}
		return str;
	}
	
	/**
	 * 将str中的separator + template + separator，用value替换
	 * @param str
	 * @param template
	 * @param separator
	 * @param value
	 * @return
	 */
	public static String replaceAllWithSeparator(String str, String template,
			String separator, String value) {
		if (str.indexOf(separator + template + separator) > -1) {
			return str.replaceAll(separator + template + separator, value);
		}

		return str;
	}

	/**
	 * encode index字符串
	 * @param org
	 * @return
	 */
	public static String indexEncode(String org) {
		return replaceAllWithSeparator(org, "_", "", "%5F");
	}

	/**
	 * decode index字符串
	 * @param str
	 * @return
	 */
	public static String indexDecode(String str) {
		return StringExtention.replaceAllWithSeparator(str, "%5F", "", "_");
	}

	/**
	 * 编码String为html字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String htmlEncode(String str) {
		return StringEscapeUtils.escapeHtml4(str);
	}

	/**
	 * 解码html字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String htmlDecode(String str) {
		return StringEscapeUtils.unescapeHtml4(str);
	}
	
	/**
	 * 将text转换为html字符串
	 * @param text
	 * @return
	 */
//	public static String textToHtml(String text) {
//		return htmlEncode(text).replaceAll("\n", "<br>");
//	}
	
	public static final String BR = "<br\\s*/?>";
	public static final String PLAIN_NEWLINE = "\n";
	public static final String HTML_NEWLINE = "<br/>";
	public static final String CONTENT_PLAIN_NEWLINE = "\n\n";
	public static final String CONTENT_HTML_NEWLINE = "<br/><br/>";
	public static final String PLAIN_EMPTYSPACE = " ";
	public static final String HTML_EMPTYSPACE = "&nbsp;";
	public static final String EMPTYSPACE = " ";
	
	/**
	 * 将text转换为html字符串
	 * @param text
	 * @return
	 */
	public static String textToHtml(String str) {
		String retStr = htmlEncode(str);
		retStr = retStr.replace(PLAIN_NEWLINE, HTML_NEWLINE);
		retStr = retStr.replace(PLAIN_EMPTYSPACE, HTML_EMPTYSPACE);
		return retStr;
	}


	/**
	 * 忽略大小写的replaceall
	 * @param source
	 * @param oldstring
	 * @param newstring
	 * @return
	 */
	public static String replaceAllIgnoreCase(String source, String oldstring,
			String newstring) {
		Pattern p = Pattern.compile(oldstring, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(source);
		String ret = m.replaceAll(newstring);
		return ret;
	}
	
	/**
	 * 十六进制的decode \x22 \x3c这种
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String hexDecode(String str)
			throws UnsupportedEncodingException {
		if (str != null) {
			str = str.replaceAll("\\\\x", "%");
		}
		return str;
	}
	
	/**
	 * 将字符串强转为Long。如果转换出错，则返回0L
	 * @param snum
	 * @return
	 */
	public static Long toLong(String snum){
		Long num = (long) 0;
		if (snum != null && !snum.equals("")){
			try{
				num = Long.parseLong(snum);
			}catch (NumberFormatException e) {
				logger.d(TAG, "parse long error. snum is : " + snum);
			}
		}
		return num;
	}
	
	/**
	 * map中key对应的value是否为null或者空
	 * @param map
	 * @param key
	 * @return
	 */
	public static boolean strictEmpty(HashMap<?,String> map,Object key){
		if(map.get(key) == null || map.get(key).length() == 0){
			return true;
		}
		return false;
	}
	
	//PASS
	/**
	 * <pre>
	 * map是否层次包含keySeqs中的所有key
	 * 执行过程：
	 * 如果map包含第i个key，那么将第i个元素取出，转化为map，继续第i+1个key的查找
	 * 当keySeqs中的所有key都这样层次包含的时候，返回true。否则false
	 * </pre>
	 * @param map
	 * @param keySeqs
	 * @return
	 */
	public static boolean containInheritKey(Map<?,?> map,String[] keySeqs){
		try{
			int size = keySeqs.length;
			for(int s = 0 ; s < size ; s++){
				String k = keySeqs[s];
				Object newMap = map.get(k);
				if(newMap == null){
					return false;
				}
				if(s != size - 1){
					map  = (Map<?,?>)newMap;
				}
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}

//	public static Object getInheritKey(HashMap<?,?> map, String[] keys){
//		try{
//			int size = keys.length;
//			Object newMap = null;
//			for(int s = 0 ; s < size ; s++){
//				String k = keys[s];
//				newMap = map.get(k);
//				if(newMap == null){
//					return null;
//				}
//				if(s != size - 1){
//					map  = (HashMap<?,?>)newMap;
//				}
//			}
//			return newMap;
//		}catch(Exception e){
//			return null;
//		}
//	}
	
	/**
	 * 判断该字符串是否数字
	 * @param String
	 * @return true while the string is num, or returns false
	 */
	public static boolean isNum(final CharSequence cs){
		if (cs == null || cs.length() == 0 ) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <pre>
	 * 对字符串切断
	 * </pre>
	 * @param str
	 * @param maxSize
	 * @return 切割后的字符串。当传入的maxSize长度大于字符串的长度的时候，返回原始字符串
	 */
	public static String clipString(String str, int maxSize) {
		if (str == null) {
			return str;
		}
		return str.substring(0, Math.min(str.length(), maxSize));
	}

	/**
	 * 测试text是否包含中文
	 * @param text
	 * @return
	 */
	public static boolean containChinese(String text) {
		return text.getBytes().length != text.length();
	}

	/**
	 * 将size转换为human readable的格式
	 * @param size
	 * @return
	 */
	public static String getHumanReadable(long size) {
		String strSize = "";
		DecimalFormat df = new DecimalFormat("0.00");
	
		if (size >= 1048576) {
			strSize = df.format(size / 1048576.0) + "M";
		} else if (size >= 1024) {
			strSize = df.format(size / 1024.0) + "K";
		} else {
			strSize = df.format(size / 1.0) + "B";
		}
	
		return strSize;
	}

	/**
	 * 把 G M K B 等转成 long
	 * @param size
	 * @return
	 */
	public static long sizeStrToLong(String size) {
		if (size == null || "".equals(size)) return 0;
		String result = "";
		int mutil = 1;
		for (int i = 0; i < size.length(); i++) {
			char t = size.charAt(i);
	
			if (t == 'B') {
				mutil = 1;
				break;
			} else if (t == 'K') {
				mutil = 1024;
				break;
			} else if (t == 'M') {
				mutil = 1024 * 1024;
				break;
			} else if (t == 'G') {
				mutil = 1024 * 1024 * 1024;
				break;
			} else if (Character.isDigit(t) || t == '.') {
				result += t;
			} else {
				break;
			}
		}
		return (long) (Float.parseFloat(result) * mutil);
	}
	
	/**
	 * 将文件大小转换为human readable的格式
	 * 
	 * @param size
	 */
	public static String getHumanReadableSizeString(long size) {
	
		String string = "0K";
		if (size >= 1073741824.0) {
			string = String.format(Locale.getDefault(), "%.2fG", size / 1073741824.0);
		} else if (size >= 1048576.0) {
			string = String.format(Locale.getDefault(), "%.2fM", size / 1048576.0);
		} else if (size >= 1024.0) {
			string = String.format(Locale.getDefault(), "%.2fK", size / 1024.0);
		} else if (size <= 1) {
			string = "0K";
		} else {
			string = String.format(Locale.getDefault(), "%.2fB", size / 1.0);
		}
		return string;
	
	}

	/**
	 * 
	 * 根据输入类别，计算文件md5或sha
	 * 
	 * @param file
	 * @param fileSize
	 * @param type
	 *            "MD5" 或者 "SHA-1"
	 * 
	 * @return
	 */
	public static String calculateDigest(File file, String type) {
		FileInputStream fis = null;
		byte[] buffer = new byte[1024 * 8];
	
		try {
			int len = 0;
			fis = new FileInputStream(file);
			MessageDigest digest = MessageDigest.getInstance(type);
			while ((len = fis.read(buffer)) > 0) {
				digest.update(buffer, 0, len);
			}
			String str = new BigInteger(1, digest.digest()).toString(16).toUpperCase(Locale.getDefault());
			while (str.length() < 32) {
				str = "0" + str;
			}
			return str;
	
		} catch (Exception e) {
			// 区分NoSuchAlgorithmException和NoSuchAlgorithmException
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// 不妨碍
			}
		}
		return null;
	}

	public static String filterRegxpllega(String str) {
		//return str.replaceAll("\\$", "\\\\$0").replace("(", "\\(").replace(")", "\\)").replace("?", "\\?").replace("{", "\\{").replace("}", "\\}");
		return str.replaceAll("[{}\\[\\]()+\\$\\?*]", "\\\\$0");
	}

	/**
	 * 替换url中的非法字符
	 * @param url
	 * @return
	 */
	public static String replaceIllegalUrl(String url) {
		String string = url.replace("%", "%25");
		string = string.replace("#", "%23");
		string = string.replace("\\", "%27");
		string = string.replace("\\?", "%3f");
		return string;
	}
	
	
	
	public static String replaceBackIllegalUrl(String url) {
		String string = url.replace("%23", "#");
		string = string.replace("%27", "\\");
		string = string.replace("%3f", "\\?");
		string = string.replace("%25", "%");
		return string;
	}

	/**
	 * A hashing method that changes a string (like a URL) into a hash suitable
	 * for using as a disk filename.
	 * 
	 * @param key
	 * @return
	 */
	public static String hashKeyForDisk(String key) {
		String cacheKey;
		try {
			final MessageDigest mDigest = MessageDigest.getInstance("MD5");
			mDigest.update(key.getBytes());
			cacheKey = StringExtention.bytesToHexString(mDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			cacheKey = String.valueOf(key.hashCode());
		}
		return cacheKey;
	}

	private static String bytesToHexString(byte[] bytes) {
		// http://stackoverflow.com/questions/332079
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 * 从html里剔除接口
	 */
	public static String removeHtmlLableByName(final String htmlContent, String lable, String keyword) {
		
		int ref = 0, labBeginPos = 0, labEndPos = 0;
		String content = htmlContent;
		labEndPos = content.indexOf(keyword);
		
		String beginLable = "<" + lable;
		String closeLable = "</" + lable;
		
		if (labEndPos < 0) {
			// 没有找到标签，直接返回
			return htmlContent;
		}
		
		labBeginPos = content.substring(0, labEndPos).lastIndexOf(beginLable);
		
		ref += 1;
		while (labEndPos >= 0 && ref > 0) {
			int begPos = content.indexOf(beginLable, labEndPos);
			int endPos = content.indexOf(closeLable, labEndPos);
			
			// 已经到结尾，结束循环
			if (endPos < 0) {
				break;
			}
			
			if (begPos > 0 && begPos < endPos) {
				ref += 1;
				labEndPos = begPos + beginLable.length();
			} else {
				ref -= 1;
				labEndPos = endPos + closeLable.length() + 1;
			}
		}
		
		if (labBeginPos >= 0 && labEndPos >= 0 && labEndPos >= labBeginPos) {
			content = content.replace(content.substring(labBeginPos, labEndPos), " ");
		}
		
		return content;
	}

	private static final String emailRegex = "([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)";
	public static boolean isEmail(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		
		if (!Pattern.matches(emailRegex, str)) {
			return false;
		}
		return true;
	}
	

	
	
	
	/**
	 * 正则解析url的host
	 */
	public static String parseUrlHost(final String url) {
		String regex = "[http|https]+://([\\w-]+\\.)+[\\w-]+(/[\\w- /]*/)?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		return m.find() ? m.group(0) : "";
	}
	
	/**
	 * 获取url参数
	 */
	public static String parseUrlParam(final String url) {
		String param = "";
		String host = parseUrlHost(url);
		if (url.indexOf(host) != -1) {
			param = url.substring(host.length());
		}
		return param;
	}
	
	/**
	 * 高效拼接字符串
	 */
	public static String appendString(String first, String second) {
		StringBuilder builder = new StringBuilder();
		builder.append(first);
		builder.append(second);
		return builder.toString();
	}
	
	/**
	 * 移除url中某个参数及值
	 */
	public static String removeTokenFromUrl(final String url, final String token) {
		String regex = "(\\?|&+)(.+?)=([^&]*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(url);
		while (m.find()) {
			String param = m.group(0).substring(1);
			if (param.contains(token)) {
				return url.replace(param, "");
			}
		}
		return url;
	}
	
	/**
	 * 字符串是否为空
	 */
	public static boolean isNullOrEmpty(final CharSequence source) {
		return source == null || source.length() == 0;
	}
	
	/**
	 * 拷贝到剪贴板
	 * @param context
	 * @param s
	 */
	@SuppressWarnings("deprecation")
	public static void copyToClipboard(Context context, String s) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
	        ClipData clip = ClipData.newPlainText("", s);
	        clipboard.setPrimaryClip(clip);
		} else {
			android.text.ClipboardManager clipboard = (android.text.ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
			clipboard.setText(s);
		}
	}
	
	// 以下代码放到json那里
	
	/**
	 * <pre>
	 * 解析字符串并返回装有kv的map。
	 * 字符串格式为a=b&c=d
	 * </pre>
	 * 
	 * @param str 源串
	 * @return 装有kv的map
	 */
	
//	public static JSONObject getKeyValueDict(String str) {
//		JSONObject dict = new JSONObject();
//		String[] aKeyValues = str.split("&");
//		for (int i = 0; i < aKeyValues.length; i++) {
//			String[] keyValue = aKeyValues[i].split("=");
//			if (keyValue.length == 2) {
//				dict.put(keyValue[0], keyValue[1]);
//			}
//		}
//		return dict;
//	}
	
	/**
	 * 插入json时候，要当作合法的string literal的值，这里是转移方法
	 * @param originalLiterla
	 * @return
	 */
//	public static String safeStringLiteral(String originalLiterla){
//		if(StringUtils.isEmpty(originalLiterla)){
//			return "";
//		}
//		return  originalLiterla.replace("\"", "\\\"");
//	}
	public static String replaceObjcharater(String string) {
		return string
				//不用过滤换行
				//.replace('\n', (char) 32)
				.replace((char) 160, (char) 32).replace((char) 65532, (char) 32).trim();
	}

	/**
	 * <p>从apache.commons.lang3.StringUtils 中复制过来的代码.</p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 *
	 * @param cs  the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * <p>Compares two CharSequences, returning {@code true} if they represent
	 * equal sequences of characters.</p>
	 *
	 * <p>{@code null}s are handled without exceptions. Two {@code null}
	 * references are considered to be equal. The comparison is case sensitive.</p>
	 *
	 * <pre>
	 * StringUtils.equals(null, null)   = true
	 * StringUtils.equals(null, "abc")  = false
	 * StringUtils.equals("abc", null)  = false
	 * StringUtils.equals("abc", "abc") = true
	 * StringUtils.equals("abc", "ABC") = false
	 * </pre>
	 *
	 * @see Object#equals(Object)
	 * @param cs1  the first CharSequence, may be {@code null}
	 * @param cs2  the second CharSequence, may be {@code null}
	 * @return {@code true} if the CharSequences are equal (case-sensitive), or both {@code null}
	 * @since 3.0 Changed signature from equals(String, String) to equals(CharSequence, CharSequence)
	 */
	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		if (cs1 == cs2) {
			return true;
		}
		if (cs1 == null || cs2 == null) {
			return false;
		}
		if (cs1 instanceof String && cs2 instanceof String) {
			return cs1.equals(cs2);
		}
		return regionMatches(cs1, false, 0, cs2, 0, Math.max(cs1.length(), cs2.length()));
	}
	/**
	 * Green implementation of regionMatches.
	 *
	 * @param cs the {@code CharSequence} to be processed
	 * @param ignoreCase whether or not to be case insensitive
	 * @param thisStart the index to start on the {@code cs} CharSequence
	 * @param substring the {@code CharSequence} to be looked for
	 * @param start the index to start on the {@code substring} CharSequence
	 * @param length character length of the region
	 * @return whether the region matched
	 */
	static boolean regionMatches(final CharSequence cs, final boolean ignoreCase, final int thisStart,
								 final CharSequence substring, final int start, final int length)    {
		if (cs instanceof String && substring instanceof String) {
			return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
		}
		int index1 = thisStart;
		int index2 = start;
		int tmpLen = length;

		while (tmpLen-- > 0) {
			final char c1 = cs.charAt(index1++);
			final char c2 = substring.charAt(index2++);

			if (c1 == c2) {
				continue;
			}

			if (!ignoreCase) {
				return false;
			}

			// The same check as in String.regionMatches():
			if (Character.toUpperCase(c1) != Character.toUpperCase(c2)
					&& Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
				return false;
			}
		}
		return true;
	}


}