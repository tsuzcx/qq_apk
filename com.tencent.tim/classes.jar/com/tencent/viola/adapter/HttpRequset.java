package com.tencent.viola.adapter;

import java.util.Map;

public class HttpRequset
{
  public static final String DEFAULT_CONTENT_TYPE = "application/json,text/*,*/*";
  public static final int DEFAULT_TIMEOUT_MS = 10000;
  public String body;
  public String method;
  public Map<String, String> paramMap;
  public int timeoutMs = 10000;
  public String type;
  public String url;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.adapter.HttpRequset
 * JD-Core Version:    0.7.0.1
 */