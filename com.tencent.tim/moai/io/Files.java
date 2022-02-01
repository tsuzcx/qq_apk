package moai.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.util.Log;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;


/**
 * 文件系统操作类
 */
public final class Files {
	public static final String STORAGE_ROOT = "/storage";

	public final static String CACHE_URL = Environment
			.getExternalStorageDirectory() + "/tencent/weread/cache";

	private Files() {
	}

	/**
	 * 获取外部缓存目录
	 * 如 /sdcard/Android/data/{packageName}/cache/
	 * @param context
	 * @return null 获取失败
	 */
	@TargetApi(8)
	public static File getExternalCacheDir(Context context) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO && context.getExternalCacheDir() != null) {
			// android 2.2 以上，
			return context.getExternalCacheDir();
		}
		// Before Froyo we need to construct the external cache dir ourselves
		String packagePath = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName();
		File packageDir = new File(packagePath);
		if (!mkdirs(packageDir)) {
			return null;
		}

		String cachePath = packagePath + "/cache/";
		File cacheDir = new File(cachePath);
		if (!mkdirs(cacheDir)) {
			return null;
		}

		return cacheDir;
	}

	/**
	 * 文件是否存在
	 * @param path
	 * @return
	 */
	public static boolean isFileExist(String path) {
		if (path == null || path.equals("")) {
			return false;
		}
		File file = new File(path);
		return file.exists();
	}

	public static boolean isFileExist(File file) {
		return  (file != null && file.exists()) ? true : false;
	}

	/**
	 * 文件是否是目录
	 * @param path
	 * @return
	 */
	public static boolean isFileDir(String path) {
		if (path == null || path.equals("")) {
			return false;
		}
		File file = new File(path);
		return file.isDirectory();
	}

	/**
	 * 创建目录，支持多级创建
	 * @param dir
	 * @return true成功，false失败
	 */
	public static synchronized boolean mkdirs(File dir) {
		if (!(dir.exists() && dir.isDirectory())) {
			if (!dir.mkdirs()) {
				//创建不成功
				return false;
			}
		}
		return true;
	}


	/**
	 * 递归删除文件夹里面的所有文件
	 *
	 * @param path
	 *            String 文件夹路径
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] files = file.list();
		if (files == null) return;
		File temp;
		for (String aFile : files) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + aFile);
			} else {
				temp = new File(path + File.separator + aFile);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + aFile);// 先删除文件夹里面的文件
				delFolder(path + "/" + aFile);// 再删除空文件夹
			}
		}
	}

	/**
	 * 删除文件 这里逻辑稍作修改，如果文件不存在，也视为删除成功
	 * @param path
	 * @return
	 */
	public static boolean delFile(String path) {
		if (path == null || "".equals(path)) {
			return false;
		}
		File file = new File(path);
		if (!file.exists()) {
			return true;
		} else {
			return file.delete();
		}
	}

	public static void delFile(ArrayList<String> filePaths) {
		if (filePaths == null || filePaths.size() == 0) {
			return;
		}

		for (String filePath : filePaths) {
			delFile(filePath);
		}
	}

	public static void delFile(File[] fileList) {
		if (fileList == null || fileList.length == 0) {
			return;
		}

		for (File file : fileList) {
			delFile(file.getAbsolutePath());
		}
	}

	/**
	 * 删除整个文件夹。<br \>会先删除文件夹里面的所有文件！
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		delAllFile(folderPath); // 删除完里面所有内容
		java.io.File myFilePath = new java.io.File(folderPath);
		myFilePath.delete(); // 删除空文件夹
	}


	/**
	 * sd卡附件的命名规则<br>
	 * 在att_dir目录，如果有重名，则尝试name(1),name(2)...直到没有重名为止，返回该名字
	 * @param name
	 * @return
	 */
	public static String renameAndAutoSequence(String att_dir, String name) {
		att_dir = att_dir.replaceFirst("/*$","/");
		if (name == null || name.equals("")) {
			return "";
		}

		String[] strings = name.split("\\.");
		if (strings != null && strings.length > 0) {
			String realname = strings[0];
			String suffix = strings[strings.length - 1];
			if (strings.length > 2) {
				for (int i = 1; i < strings.length - 1; i++) {
					realname = realname + "." + strings[i];
				}
			}
			int i = 1;
			String tname = name;
			while (true) {
				if (new File(att_dir + tname).exists()) {
					tname = realname + "(" + i + ")" + "." + suffix;
					i++;
				}else{
					break;
				}
			}
			return tname;
		} else {
			return name;
		}
	}

	/**
	 * 去掉文件后缀<br>
	 * 不论文件名中包含多少 . ,仅仅取第一个
	 * {@see #rename(String, String)}
	 * @param fileName
	 * @return 如果fileName为null，则返回null
	 */
	public static String trimFileNameSufix(String fileName) {
		if (fileName == null) {
			return null;
		}
		String filename = "";
		if (!fileName.equals("")) {
			int i = fileName.lastIndexOf('.');
			if (i > 0) {
				filename = fileName.substring(0, i);
			}
		}
		return filename;
	}

	/**
	 * 重命名文件
	 * @param absolutePath 要改名文件绝对路径
	 * @param dstName 要改动的名称
	 * @return
	 */
	public static File renameFile(String srcFilePath, String destFilePath) {
		File result = null;
		try {
			File srcFile = new File(srcFilePath);
			result = new File(destFilePath);
			srcFile.renameTo(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 读文件内容
	/**
	 * 读整个小文件到内存中
	 * @param filePath
	 * @return null，读文件失败
	 */
	public static byte[] readFile(String filePath) {
		InputStream is = null;
		byte[] bytes = null;
		try {
			// MARK 如果文件多大，这方法不能使用
			is = new FileInputStream(filePath);
			byte[] buf = new byte[1024 * 4];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			while ((len = is.read(buf)) > 0) {
				baos.write(buf, 0, len);
			}
			bytes = baos.toByteArray();
		} catch (IOException e) {
			// 不处理
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return bytes;
	}

	public static List<String> readFileByLine(String filePath) {
		FileReader is = null;
		ArrayList<String> fileContent = new ArrayList<>();
		try {
			// MARK 如果文件多大，这方法不能使用
			is = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(is);
			String line = "";
			while ((line = reader.readLine()) != null) {
				fileContent.add(line);
			}
		} catch (Exception e) {
			// 不处理
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return fileContent;
	}

	public static String readFileByLine(String filePath, boolean splitLine) {
		FileReader is = null;
		StringBuilder builder = new StringBuilder();
		try {
			// MARK 如果文件多大，这方法不能使用
			is = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(is);
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				if (splitLine) {
					builder.append("\r\n");
				}
			}
		} catch (Exception e) {
			// 不处理
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return builder.toString();
	}

	public static String readFileList(Iterable<File> fileList) {
		// 压缩
		StringBuilder stringBuilder = new StringBuilder();
		for (File file : fileList) {
			if (isFileExist(file)) {
				stringBuilder.append(readFileByLine(file.getAbsolutePath(), true));
			}
		}
		return stringBuilder.toString();
	}

	public static String readFileByLine(String filePath, String seplineToken) {
		FileReader is = null;
		StringBuilder builder = new StringBuilder();
		try {
			// MARK 如果文件多大，这方法不能使用
			is = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(is);
			String line = "";
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				if (!Strings.isNullOrEmpty(seplineToken)) {
					builder.append(seplineToken);
				}
			}
		} catch (Exception e) {
			// 不处理
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return builder.toString();
	}

	/**
	 * buffer的数据写入文件
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static void writeFile(String path, Buffer out, boolean append) throws IOException {
		FileOutputStream indexFileOutputStream = new FileOutputStream(path, append);
		BufferedSink index = Okio.buffer(Okio.sink(new BufferedOutputStream(indexFileOutputStream)));
		index.writeAll(out);
		index.close();
	}

	/**
	 * buffer的数据写入文件
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static void writeFile(String path, Buffer out) throws IOException {
		FileOutputStream indexFileOutputStream = new FileOutputStream(path, false);
		BufferedSink index = Okio.buffer(Okio.sink(new BufferedOutputStream(indexFileOutputStream)));
		index.writeAll(out);
		index.close();
	}

	/**
	 * 写入小文件
	 * @param data
	 * @param saveFile
	 */
	public static boolean writeFile(byte[] data, int length, String saveFile) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(saveFile);
			os.write(data, 0, length);
		} catch (Exception e) {
			// 不处理
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return false;
	}

	public static boolean compressBitmapToFile(Bitmap bitmap, Bitmap.CompressFormat format,
											   int quality, String saveFile) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(saveFile);
			bitmap.compress(format, quality, os);
		} catch (Exception e) {
			// 不处理
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return false;
	}

	public static boolean appendFile(byte[] data, int length, String saveFile) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(saveFile, true);
			os.write(data, 0, length);
		} catch (Exception e) {
			// 不处理
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return false;
	}

	/**
	 * 续写文件
	 * 这个函数为经过严谨测试，是从normalattachment拆出来的，先使用
	 * @param str
	 * @param file
	 * @return startPosition，写入失败；startPosition + readLen，写入成功
	 */
	public static long writePartialFile(byte[] data, int readLen, String saveFile, long startPosition) {
		try {
			RandomAccessFile randomAccessFile =
					new RandomAccessFile(saveFile, "rwd");
			randomAccessFile.seek(startPosition);
			randomAccessFile.write(data, 0, readLen);
			randomAccessFile.close();
			return startPosition + readLen;
		} catch (Exception e) {
			return startPosition;
		}
	}


	/**
	 * 清空给定文件内容
	 * @param filePath
	 * @throws IOException
	 */
	public static void clearFileContent(String filePath) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(filePath, false);
		} catch (FileNotFoundException e) {
			// 不处理
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// 不处理
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 如果正常truncate到toSize大小或者文件本身小于toSize，则返回true。如果truncate失败，返回false<br>
	 * 函数完成之后，文件名不变，内容被从文件头开始truncate，保留文件尾
	 * @param file
	 * @param toSize
	 * @return
	 */
	public static boolean truncateFileToSize(File file, long toSize) {
		if (file == null) {
			return false;
		}
        String toFileName = file.getAbsolutePath() + "." + new Date().getTime();
		BufferedOutputStream outputFile;
		FileInputStream fis;
		try {
			File tmpFile = new File(toFileName);
			boolean renameSuccess = file.renameTo(tmpFile);
			if (!renameSuccess) {
				return false;
			}
			fis = new FileInputStream(tmpFile);
            try {
                long skips = fis.skip(Math.max(0, tmpFile.length() - toSize));
                if (skips > 0) {
                    byte[] buf = new byte[8 * 1024];
                    Arrays.fill(buf, (byte) 0);
                    outputFile = new BufferedOutputStream(new FileOutputStream(file, false));
                    int size = 0;
                    try {
                        while ((size = fis.read(buf)) > 0) {
                            outputFile.write(buf, 0, size);
                        }
                        outputFile.write('\n');
                        outputFile.flush();
                    } finally {
                        outputFile.close();
                    }
                    tmpFile.delete();
                }
            } finally {
                fis.close();
            }
        } catch (IOException e) {
			Log.e("truncate", "trim file err:" + e.toString());
			return false;
		}
		return true;
	}

	public final static int FILE_COPY_ERROR_NORMAL = -1;         	// 拷贝文件失败
	public final static int FILE_COPY_ERROR_NOPERMISSION = -2;      // 拷贝文件没有权限
	public final static int FILE_COPY_SUCCESS = 0;     				// 拷贝文件成功

	/**
	 * 将文件拷贝到目标文件<br>
	 * 如果目标文件已经存在则覆盖<br>
	 *
	 * @param source
	 * @param dest
	 * @return 0 正常，－1 普通错误 －2 文件权限错误
	 */
	public static int copyFile(File source, File dest) {
		if (source == null || dest == null) {
			return FILE_COPY_ERROR_NORMAL;
		}
		if (source.getAbsolutePath().equals(dest.getAbsoluteFile())) {
			return FILE_COPY_SUCCESS;
		}
		// TODO 优化，改为FileChannel
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(new FileInputStream(source));
			bos = new BufferedOutputStream(new FileOutputStream(dest, false));

			byte[] buf = new byte[1024];
			int readLen = -1;
			while ((readLen = bis.read(buf)) != -1) {
				bos.write(buf, 0, readLen);
			}
		} catch (IOException e) {
			String errmsg = e.getMessage();
			if (errmsg.contains("Permission denied") || errmsg.contains("EROFS")) {
				// 目录没有读写权限
				return FILE_COPY_ERROR_NOPERMISSION;
			} else {
				return FILE_COPY_ERROR_NORMAL;
			}
		} catch (Exception e) {
			return FILE_COPY_ERROR_NORMAL;
		}
		finally {
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					// 不处理
				}
			if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					// 不处理
				}
		}

		return FILE_COPY_SUCCESS;
	}



	/**
	 * 获取一个目录下全部文件的大小。<br \>
	 * 如果目录不存在或者是给定的path参数不是目录，那么返回0
	 * @param path
	 * @return
	 */
	public static long getDirectorySize(String path){
		if (path == null || "".equals(path)){
			return 0;
		}
		File file = new File(path);

		if (!file.isDirectory()){
			return 0;
		}
		long size = 0;

		File[] subFile = file.listFiles();
		if (subFile != null) {
			for (int i = 0; i < subFile.length; i++){
				if (subFile[i] != null) {
					if (subFile[i].isDirectory()){
						size = size + getDirectorySize(subFile[i].getAbsolutePath());
					}else{
						size = size + getFileSize(subFile[i].getAbsolutePath());
					}
				}
			}
		}

		return size;
	}

	/**
	 * 获取指定文件的文件大小<br \>Returns 0 if the file does not exist.
	 * @param path
	 * @return
	 */
	public static long getFileSize(String path) {
		if (path == null || "".equals(path)) {
			return 0;
		}
		File file = new File(path);
		if (file.isDirectory()) {
			return 0;
		}
		return file.length();
	}

	/**
	 * 消除epub书籍路径的描述头，比如ad://、storage//等
	 */
	public static String stripAnchorPath(String filePath) {
		String clearPath = filePath;
		if (filePath.contains(STORAGE_ROOT)) {
			int start = filePath.indexOf(STORAGE_ROOT);
			clearPath = filePath.substring(start);
		}
		return clearPath;
	}

	/**
	 * 获取文件的后缀名。如果不存在后缀，则返回空字符串
	 * @param fileName
	 * @return ""，如果获取不了
	 */
	public static String getSuffix(String fileName) {
		if (fileName == null) {
			return "";
		}
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	public static final String FILE_TYPE_EXE = "exe";
	public static final String FILE_TYPE_MIDI = "midi";
	public static final String FILE_TYPE_RAR = "rar";
	public static final String FILE_TYPE_ZIP = "zip";
	public static final String FILE_TYPE_JPG = "jpg";
	public static final String FILE_TYPE_JPEG = "jpeg";
	public static final String FILE_TYPE_GIF = "gif";
	public static final String FILE_TYPE_BMP = "bmp";
	public static final String FILE_TYPE_PNG = "png";
	public static final String FILE_TYPE_ICO = "ico";
	public static final String FILE_TYPE_UNKNOWN = "unknown";

	private static final String[] IMG_SUFFIX = {
			FILE_TYPE_PNG,
			FILE_TYPE_GIF,
			FILE_TYPE_JPG,
			FILE_TYPE_JPEG,
			FILE_TYPE_BMP,
			FILE_TYPE_ICO };

	/**
	 * 用文件内容来判断文件类型
	 * @param path
	 * @return
	 */
	public static String getFileTypeWithContent(String path) {
		String fileType = "";
		FileInputStream inputStream = null;
		try {
			// 从SDCARD下读取一个文件
			inputStream = new FileInputStream(path);
			byte[] buffer = new byte[2];
			// 文件类型代码
			String filecode = "";
			// 通过读取出来的前两个字节来判断文件类型
			if (inputStream.read(buffer) != -1) {
				for (int i = 0; i < buffer.length; i++) {
					// 获取每个字节与0xFF进行与运算来获取高位，这个读取出来的数据不是出现负数
					// 并转换成字符串
					filecode += Integer.toString(buffer[i] & 0xFF);
				}
				// 把字符串再转换成Integer进行类型判断
				switch (Integer.parseInt(filecode)) {
					case 7790:
						fileType = FILE_TYPE_EXE;
						break;
					case 7784:
						fileType = FILE_TYPE_MIDI;
						break;
					case 8297:
						fileType = FILE_TYPE_RAR;
						break;
					case 8075:
						fileType = FILE_TYPE_ZIP;
						break;
					case 255216:
						fileType = FILE_TYPE_JPG;
						break;
					case 7173:
						fileType = FILE_TYPE_GIF;
						break;
					case 6677:
						fileType = FILE_TYPE_BMP;
						break;
					case 13780:
						fileType = FILE_TYPE_PNG;
						break;
					default:
						fileType = FILE_TYPE_UNKNOWN; // "unknown type: "+filecode;
				}
			}
		} catch (FileNotFoundException e) {
			// 不处理
			e.printStackTrace();
		} catch (IOException e) {
			// 不处理
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// 不处理
				}
			}
		}
		return fileType;
	}

	/**
	 * 判断文件是否是图片
	 * @param fileSufix
	 * @return
	 */
	public static boolean IsImageSufix(String fileSufix) {
		fileSufix = fileSufix.toLowerCase();
		for (int i = 0; i < IMG_SUFFIX.length; i++) {
			if (IMG_SUFFIX[i].equals(fileSufix)) {
				return true;
			}
		}

		return false;
	}

	public static synchronized boolean tryMkdirs(File dir) {
		if (!(dir.exists() && dir.isDirectory())) {
			Log.v("mkdirs", dir.getAbsolutePath());
			if (!dir.mkdirs()) {
				//创建不成功
				return false;
			}
		}
		return true;
	}

    /**
	 * 获取文件后缀<br>
	 * 不论文件名是什么，仅取最后一个 . 后面的字符串
	 * @param fileName
	 * @return
	 */
	public static String getFileNameSufix(String fileName) {
		if (fileName == null) {
			return "";
		}
		return getSuffix(fileName);
	}

	/**
	 * 获取文件全名 <br>
	 * @param filePath
	 * @return
	 */
	public static String getName(String filePath) {
		if (filePath == null) {
			return "";
		}
		return filePath.substring(filePath.lastIndexOf(File.separator) + 1);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public static List<String> lsof() {
		FluentIterable<File> files = com.google.common.io.Files.
				fileTreeTraverser()
				.breadthFirstTraversal(new File("/proc/self/fd"))
				.filter(new Predicate<File>() {
					public boolean apply(File input) {
						return input != null;
					}
				});
		List<String> ofs = new ArrayList<>(files.size());
		for (File file : files) {
			try {
				ofs.add(Os.readlink(file.toString()));
			} catch (Exception ignored) {

			}
		}
		return ofs;
	}

	/**
	 * The Windows separator character.
	 */
	private static final char WINDOWS_SEPARATOR = '\\';

	/**
	 * Determines whether the specified file is a Symbolic Link rather than an actual file.
	 * <p>
	 * Will not return true if there is a Symbolic Link anywhere in the path,
	 * only if the specific file is.
	 * <p>
	 * <b>Note:</b> the current implementation always returns {@code false} if the system
	 * is detected as Windows using File.separatorChar == '\\'
	 *
	 * @param file the file to check
	 * @return true if the file is a Symbolic Link
	 * @throws IOException if an IO error occurs while checking the file
	 * @since 2.0
	 */
	public static boolean isSymlink(File file) throws IOException {
		if (file == null) {
			throw new NullPointerException("File must not be null");
		}
		if (File.separatorChar == WINDOWS_SEPARATOR) {
			return false;
		}
		File fileInCanonicalDir;
		if (file.getParent() == null) {
			fileInCanonicalDir = file;
		} else {
			File canonicalDir = file.getParentFile().getCanonicalFile();
			fileInCanonicalDir = new File(canonicalDir, file.getName());
		}

		return !fileInCanonicalDir.getCanonicalFile().equals(fileInCanonicalDir.getAbsoluteFile());
	}

	/**
	 * Deletes a directory recursively.
	 *
	 * @param directory  directory to delete
	 * @throws IOException in case deletion is unsuccessful
	 */
	public static void deleteDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			return;
		}

		if (!isSymlink(directory)) {
			cleanDirectory(directory);
		}

		if (!directory.delete()) {
			String message =
					"Unable to delete directory " + directory + ".";
			throw new IOException(message);
		}
	}

	/**
	 * Deletes a file, never throwing an exception. If file is a directory, delete it and all sub-directories.
	 * <p>
	 * The difference between File.delete() and this method are:
	 * <ul>
	 * <li>A directory to be deleted does not have to be empty.</li>
	 * <li>No exceptions are thrown when a file or directory cannot be deleted.</li>
	 * </ul>
	 *
	 * @param file  file or directory to delete, can be {@code null}
	 * @return {@code true} if the file or directory was deleted, otherwise
	 * {@code false}
	 *
	 * @since 1.4
	 */
	public static boolean deleteQuietly(File file) {
		if (file == null) {
			return false;
		}
		try {
			if (file.isDirectory()) {
				cleanDirectory(file);
			}
		} catch (Exception ignored) {
		}

		try {
			return file.delete();
		} catch (Exception ignored) {
			return false;
		}
	}
	/**
	 * Cleans a directory without deleting it.
	 *
	 * @param directory directory to clean
	 * @throws IOException in case cleaning is unsuccessful
	 */
	public static void cleanDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			String message = directory + " does not exist";
			throw new IllegalArgumentException(message);
		}

		if (!directory.isDirectory()) {
			String message = directory + " is not a directory";
			throw new IllegalArgumentException(message);
		}

		File[] files = directory.listFiles();
		if (files == null) {  // null if security restricted
			throw new IOException("Failed to list contents of " + directory);
		}

		IOException exception = null;
		for (File file : files) {
			try {
				forceDelete(file);
			} catch (IOException ioe) {
				exception = ioe;
			}
		}

		if (null != exception) {
			throw exception;
		}
	}

	/**
	 * Deletes a file. If file is a directory, delete it and all sub-directories.
	 * <p>
	 * The difference between File.delete() and this method are:
	 * <ul>
	 * <li>A directory to be deleted does not have to be empty.</li>
	 * <li>You get exceptions when a file or directory cannot be deleted.
	 *      (java.io.File methods returns a boolean)</li>
	 * </ul>
	 *
	 * @param file  file or directory to delete, must not be {@code null}
	 * @throws NullPointerException if the directory is {@code null}
	 * @throws FileNotFoundException if the file was not found
	 * @throws IOException in case deletion is unsuccessful
	 */
	public static void forceDelete(File file) throws IOException {
		if (file.isDirectory()) {
			deleteDirectory(file);
		} else {
			boolean filePresent = file.exists();
			if (!file.delete()) {
				if (!filePresent){
					throw new FileNotFoundException("File does not exist: " + file);
				}
				String message =
						"Unable to delete file: " + file;
				throw new IOException(message);
			}
		}
	}
}
