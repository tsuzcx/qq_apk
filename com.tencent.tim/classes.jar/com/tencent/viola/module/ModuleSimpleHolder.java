package com.tencent.viola.module;

import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.MethodInvoker;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModuleSimpleHolder<T extends BaseModule>
  implements IModuleHolder<T>
{
  public static final String TAG = "TypeModuleFactory";
  Class<T> mClazz;
  Map<String, Invoker> mMethodMap;
  
  public ModuleSimpleHolder(Class<T> paramClass)
  {
    this.mClazz = paramClass;
  }
  
  private void generateMethodMap()
  {
    ViolaLogUtils.d("TypeModuleFactory", "extractMethodNames:" + this.mClazz.getSimpleName());
    HashMap localHashMap = new HashMap();
    label213:
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = this.mClazz.getMethods();
        int k = arrayOfMethod.length;
        int i = 0;
        if (i < k)
        {
          Method localMethod = arrayOfMethod[i];
          Object localObject = localMethod.getDeclaredAnnotations();
          int m = localObject.length;
          int j = 0;
          if (j >= m) {
            break label213;
          }
          JSMethod localJSMethod = localObject[j];
          if ((localJSMethod != null) && ((localJSMethod instanceof JSMethod)))
          {
            localJSMethod = (JSMethod)localJSMethod;
            if ("_".equals(localJSMethod.alias()))
            {
              localObject = localMethod.getName();
              localHashMap.put(localObject, new MethodInvoker(localMethod, localJSMethod.uiThread()));
              break label213;
            }
            localObject = localJSMethod.alias();
            continue;
          }
          j += 1;
          continue;
        }
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        ViolaLogUtils.e("TypeModuleFactory", "[ModuleManager] extractMethodNames:" + localThrowable);
        this.mMethodMap = localHashMap;
        return;
      }
    }
  }
  
  public T buildInstance()
    throws IllegalAccessException, InstantiationException
  {
    return (BaseModule)this.mClazz.newInstance();
  }
  
  public Invoker getMethodInvoker(String paramString)
  {
    if (this.mMethodMap == null) {
      generateMethodMap();
    }
    return (Invoker)this.mMethodMap.get(paramString);
  }
  
  public String[] getMethods()
  {
    if (this.mMethodMap == null) {
      generateMethodMap();
    }
    Set localSet = this.mMethodMap.keySet();
    return (String[])localSet.toArray(new String[localSet.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.ModuleSimpleHolder
 * JD-Core Version:    0.7.0.1
 */