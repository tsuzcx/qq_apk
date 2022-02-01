package com.tencent.qapmsdk.socket.handler;

import android.text.TextUtils;

public class PathResolver
{
  public static final IPathResolver DEFAULT = new DefaultPathResolver(null);
  private static IPathResolver sPathResolver = DEFAULT;
  
  public static IPathResolver getPathResolver()
  {
    return sPathResolver;
  }
  
  public static void setPathResolver(IPathResolver paramIPathResolver)
  {
    sPathResolver = paramIPathResolver;
  }
  
  static class DefaultPathResolver
    implements IPathResolver
  {
    public String resolve(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramString;
      }
      int i;
      if (paramString.startsWith("/cgi-bin/"))
      {
        i = paramString.indexOf("?");
        if (i != -1) {
          paramString = paramString.substring("/cgi-bin/".length(), i);
        }
      }
      for (;;)
      {
        return paramString;
        paramString = paramString.substring("/cgi-bin/".length());
        continue;
        if (paramString.startsWith("/"))
        {
          i = paramString.indexOf("?");
          if (i != -1) {
            paramString = paramString.substring(1, i);
          } else {
            paramString = paramString.substring(1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.PathResolver
 * JD-Core Version:    0.7.0.1
 */