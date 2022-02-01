package com.facebook.stetho.inspector;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.EmptyResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONException;
import org.json.JSONObject;

@ThreadSafe
public class MethodDispatcher
{
  private final Iterable<ChromeDevtoolsDomain> mDomainHandlers;
  @GuardedBy("this")
  private Map<String, MethodDispatchHelper> mMethods;
  private final ObjectMapper mObjectMapper;
  
  public MethodDispatcher(ObjectMapper paramObjectMapper, Iterable<ChromeDevtoolsDomain> paramIterable)
  {
    this.mObjectMapper = paramObjectMapper;
    this.mDomainHandlers = paramIterable;
  }
  
  private static Map<String, MethodDispatchHelper> buildDispatchTable(ObjectMapper paramObjectMapper, Iterable<ChromeDevtoolsDomain> paramIterable)
  {
    Util.throwIfNull(paramObjectMapper);
    HashMap localHashMap = new HashMap();
    paramIterable = ((Iterable)Util.throwIfNull(paramIterable)).iterator();
    while (paramIterable.hasNext())
    {
      ChromeDevtoolsDomain localChromeDevtoolsDomain = (ChromeDevtoolsDomain)paramIterable.next();
      Object localObject = localChromeDevtoolsDomain.getClass();
      String str = ((Class)localObject).getSimpleName();
      localObject = ((Class)localObject).getDeclaredMethods();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = localObject[i];
        if (isDevtoolsMethod(localMethod))
        {
          MethodDispatchHelper localMethodDispatchHelper = new MethodDispatchHelper(paramObjectMapper, localChromeDevtoolsDomain, localMethod);
          localHashMap.put(str + "." + localMethod.getName(), localMethodDispatchHelper);
        }
        i += 1;
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private MethodDispatchHelper findMethodDispatcher(String paramString)
  {
    try
    {
      if (this.mMethods == null) {
        this.mMethods = buildDispatchTable(this.mObjectMapper, this.mDomainHandlers);
      }
      paramString = (MethodDispatchHelper)this.mMethods.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  private static boolean isDevtoolsMethod(Method paramMethod)
    throws IllegalArgumentException
  {
    if (!paramMethod.isAnnotationPresent(ChromeDevtoolsMethod.class)) {
      return false;
    }
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    String str = paramMethod.getDeclaringClass().getSimpleName() + "." + paramMethod.getName();
    if (arrayOfClass.length == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Util.throwIfNot(bool, "%s: expected 2 args, got %s", new Object[] { str, Integer.valueOf(arrayOfClass.length) });
      Util.throwIfNot(arrayOfClass[0].equals(JsonRpcPeer.class), "%s: expected 1st arg of JsonRpcPeer, got %s", new Object[] { str, arrayOfClass[0].getName() });
      Util.throwIfNot(arrayOfClass[1].equals(JSONObject.class), "%s: expected 2nd arg of JSONObject, got %s", new Object[] { str, arrayOfClass[1].getName() });
      paramMethod = paramMethod.getReturnType();
      if (!paramMethod.equals(Void.TYPE)) {
        Util.throwIfNot(JsonRpcResult.class.isAssignableFrom(paramMethod), "%s: expected JsonRpcResult return type, got %s", new Object[] { str, paramMethod.getName() });
      }
      return true;
    }
  }
  
  public JSONObject dispatch(JsonRpcPeer paramJsonRpcPeer, String paramString, @Nullable JSONObject paramJSONObject)
    throws JsonRpcException
  {
    MethodDispatchHelper localMethodDispatchHelper = findMethodDispatcher(paramString);
    if (localMethodDispatchHelper == null) {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.METHOD_NOT_FOUND, "Not implemented: " + paramString, null));
    }
    try
    {
      paramJsonRpcPeer = localMethodDispatchHelper.invoke(paramJsonRpcPeer, paramJSONObject);
      return paramJsonRpcPeer;
    }
    catch (InvocationTargetException paramJsonRpcPeer)
    {
      paramJsonRpcPeer = paramJsonRpcPeer.getCause();
      ExceptionUtil.propagateIfInstanceOf(paramJsonRpcPeer, JsonRpcException.class);
      throw ExceptionUtil.propagate(paramJsonRpcPeer);
    }
    catch (IllegalAccessException paramJsonRpcPeer)
    {
      throw new RuntimeException(paramJsonRpcPeer);
    }
    catch (JSONException paramJsonRpcPeer)
    {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, paramJsonRpcPeer.toString(), null));
    }
  }
  
  static class MethodDispatchHelper
  {
    private final ChromeDevtoolsDomain mInstance;
    private final Method mMethod;
    private final ObjectMapper mObjectMapper;
    
    public MethodDispatchHelper(ObjectMapper paramObjectMapper, ChromeDevtoolsDomain paramChromeDevtoolsDomain, Method paramMethod)
    {
      this.mObjectMapper = paramObjectMapper;
      this.mInstance = paramChromeDevtoolsDomain;
      this.mMethod = paramMethod;
    }
    
    public JSONObject invoke(JsonRpcPeer paramJsonRpcPeer, @Nullable JSONObject paramJSONObject)
      throws InvocationTargetException, IllegalAccessException, JSONException, JsonRpcException
    {
      paramJsonRpcPeer = this.mMethod.invoke(this.mInstance, new Object[] { paramJsonRpcPeer, paramJSONObject });
      if ((paramJsonRpcPeer == null) || ((paramJsonRpcPeer instanceof EmptyResult))) {
        return new JSONObject();
      }
      paramJsonRpcPeer = (JsonRpcResult)paramJsonRpcPeer;
      return (JSONObject)this.mObjectMapper.convertValue(paramJsonRpcPeer, JSONObject.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.MethodDispatcher
 * JD-Core Version:    0.7.0.1
 */