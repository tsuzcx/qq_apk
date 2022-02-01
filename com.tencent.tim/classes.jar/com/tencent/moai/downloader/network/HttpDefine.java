package com.tencent.moai.downloader.network;

import com.squareup.okhttp.MediaType;

public class HttpDefine
{
  public static final String ACCEPT_RANGES = "Accept-Ranges";
  public static final String BOUNDARY = "---------7d4a6d158c9";
  public static final String CONTENT_DISPOSITION = "Content-Disposition";
  public static final String CONTENT_ENCODING = "Content-Encoding";
  public static final String CONTENT_LENGTH = "Content-Length";
  public static final MediaType CONTENT_TYPE_MULTIPART = MediaType.parse("multipart/form-data; boundary=---------7d4a6d158c9");
  public static final MediaType CONTENT_TYPE_POST = MediaType.parse("application/x-www-form-urlencoded");
  public static final String DATA_DISPOSITION = "Content-Disposition: form-data; name=\"";
  public static final String DATA_END = "-----------7d4a6d158c9--\r\n";
  public static final String DATA_START = "-----------7d4a6d158c9\r\n";
  public static final String HEADER_CONNECTION = "Connection";
  public static final String METHOD_GET = "GET";
  public static final String METHOD_POST = "POST";
  public static final String RANGE = "range";
  public static final String RANGE_BEGIN = "bytes=0-";
  public static final String SEPARATE = "\r\n";
  public static final String USER_AGENT = "User-Agent";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpDefine
 * JD-Core Version:    0.7.0.1
 */