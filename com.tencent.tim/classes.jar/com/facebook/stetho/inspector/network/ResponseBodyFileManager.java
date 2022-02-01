package com.facebook.stetho.inspector.network;

import android.content.Context;
import android.util.Base64OutputStream;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResponseBodyFileManager
{
  private static final String FILENAME_PREFIX = "network-response-body-";
  private static final int PRETTY_PRINT_TIMEOUT_SEC = 10;
  private static final String TAG = "ResponseBodyFileManager";
  private final Context mContext;
  private final Map<String, AsyncPrettyPrinter> mRequestIdMap = Collections.synchronizedMap(new HashMap());
  
  public ResponseBodyFileManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static String getFilename(String paramString)
  {
    return "network-response-body-" + paramString;
  }
  
  private String prettyPrintContentWithTimeOut(AsyncPrettyPrinter paramAsyncPrettyPrinter, InputStream paramInputStream)
    throws IOException
  {
    paramAsyncPrettyPrinter = new AsyncPrettyPrintingCallable(paramInputStream, paramAsyncPrettyPrinter);
    Object localObject = AsyncPrettyPrinterExecutorHolder.getExecutorService();
    if (localObject == null) {
      return null;
    }
    paramAsyncPrettyPrinter = ((ExecutorService)localObject).submit(paramAsyncPrettyPrinter);
    try
    {
      localObject = (String)Util.getUninterruptibly(paramAsyncPrettyPrinter, 10L, TimeUnit.SECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      paramAsyncPrettyPrinter.cancel(true);
      return "Time out after 10 seconds of attempting to pretty print\n" + Util.readAsUTF8(paramInputStream);
    }
    catch (ExecutionException paramAsyncPrettyPrinter)
    {
      paramAsyncPrettyPrinter = paramAsyncPrettyPrinter.getCause();
      ExceptionUtil.propagateIfInstanceOf(paramAsyncPrettyPrinter, IOException.class);
      throw ExceptionUtil.propagate(paramAsyncPrettyPrinter);
    }
  }
  
  public void associateAsyncPrettyPrinterWithId(String paramString, AsyncPrettyPrinter paramAsyncPrettyPrinter)
  {
    if (this.mRequestIdMap.put(paramString, paramAsyncPrettyPrinter) != null) {
      throw new IllegalArgumentException("cannot associate different pretty printers with the same request id: " + paramString);
    }
  }
  
  public void cleanupFiles()
  {
    File[] arrayOfFile = this.mContext.getFilesDir().listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if ((localFile.getName().startsWith("network-response-body-")) && (!localFile.delete())) {
        LogRedirector.w("ResponseBodyFileManager", "Failed to delete " + localFile.getAbsolutePath());
      }
      i += 1;
    }
    LogRedirector.i("ResponseBodyFileManager", "Cleaned up temporary network files.");
  }
  
  public OutputStream openResponseBodyFile(String paramString, boolean paramBoolean)
    throws IOException
  {
    paramString = this.mContext.openFileOutput(getFilename(paramString), 0);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString.write(i);
      if (!paramBoolean) {
        break;
      }
      return new Base64OutputStream(paramString, 0);
    }
    return paramString;
  }
  
  public ResponseBodyData readFile(String paramString)
    throws IOException
  {
    FileInputStream localFileInputStream = this.mContext.openFileInput(getFilename(paramString));
    int i;
    try
    {
      i = localFileInputStream.read();
      if (i == -1) {
        throw new EOFException("Failed to read base64Encode byte");
      }
    }
    finally
    {
      localFileInputStream.close();
    }
    ResponseBodyData localResponseBodyData = new ResponseBodyData();
    boolean bool;
    if (i != 0)
    {
      bool = true;
      localResponseBodyData.base64Encoded = bool;
      paramString = (AsyncPrettyPrinter)this.mRequestIdMap.get(paramString);
      if (paramString == null) {
        break label106;
      }
    }
    label106:
    for (localResponseBodyData.data = prettyPrintContentWithTimeOut(paramString, localFileInputStream);; localResponseBodyData.data = Util.readAsUTF8(localFileInputStream))
    {
      localFileInputStream.close();
      return localResponseBodyData;
      bool = false;
      break;
    }
  }
  
  class AsyncPrettyPrintingCallable
    implements Callable<String>
  {
    private final AsyncPrettyPrinter mAsyncPrettyPrinter;
    private final InputStream mInputStream;
    
    public AsyncPrettyPrintingCallable(InputStream paramInputStream, AsyncPrettyPrinter paramAsyncPrettyPrinter)
    {
      this.mInputStream = paramInputStream;
      this.mAsyncPrettyPrinter = paramAsyncPrettyPrinter;
    }
    
    private String prettyPrintContent(InputStream paramInputStream, AsyncPrettyPrinter paramAsyncPrettyPrinter)
      throws IOException
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      PrintWriter localPrintWriter = new PrintWriter(localByteArrayOutputStream);
      paramAsyncPrettyPrinter.printTo(localPrintWriter, paramInputStream);
      localPrintWriter.flush();
      return localByteArrayOutputStream.toString("UTF-8");
    }
    
    public String call()
      throws IOException
    {
      return prettyPrintContent(this.mInputStream, this.mAsyncPrettyPrinter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.ResponseBodyFileManager
 * JD-Core Version:    0.7.0.1
 */