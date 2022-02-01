package com.tencent.qqmail.activity.setting.tableactivity.onclick;

import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OnClickAnnotationUtil
{
  public static SparseArray<Method> getMethodsWithOnClickAnnotation(Class<?> paramClass, boolean paramBoolean)
  {
    SparseArray localSparseArray = new SparseArray();
    paramClass = new ArrayList(Arrays.asList(paramClass.getDeclaredMethods())).iterator();
    while (paramClass.hasNext())
    {
      Method localMethod = (Method)paramClass.next();
      if (localMethod.isAnnotationPresent(OnClick.class))
      {
        OnClick localOnClick = (OnClick)localMethod.getAnnotation(OnClick.class);
        if (localOnClick != null)
        {
          if (!localMethod.isAccessible()) {
            localMethod.setAccessible(true);
          }
          if ((!paramBoolean) || (localOnClick.canCallFromSchema())) {
            localSparseArray.put(localOnClick.value(), localMethod);
          }
        }
      }
    }
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.onclick.OnClickAnnotationUtil
 * JD-Core Version:    0.7.0.1
 */