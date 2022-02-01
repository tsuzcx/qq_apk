package com.tencent.token;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class cl
{
  private static final Object a = new Object();
  private static Field b;
  private static boolean c;
  private static final Object d = new Object();
  
  public static Bundle a(Notification.Builder paramBuilder, cj.a parama)
  {
    paramBuilder.addAction(parama.e, parama.f, parama.g);
    paramBuilder = new Bundle(parama.a);
    if (parama.b != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", a(parama.b));
    }
    if (parama.c != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(parama.c));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", parama.d);
    return paramBuilder;
  }
  
  public static Bundle a(Notification paramNotification)
  {
    synchronized (a)
    {
      if (c) {
        return null;
      }
      try
      {
        if (b == null)
        {
          localObject1 = Notification.class.getDeclaredField("extras");
          if (!Bundle.class.isAssignableFrom(((Field)localObject1).getType()))
          {
            c = true;
            return null;
          }
          ((Field)localObject1).setAccessible(true);
          b = (Field)localObject1;
        }
        Bundle localBundle = (Bundle)b.get(paramNotification);
        Object localObject1 = localBundle;
        if (localBundle == null)
        {
          localObject1 = new Bundle();
          b.set(paramNotification, localObject1);
        }
        return localObject1;
      }
      catch (IllegalAccessException|NoSuchFieldException paramNotification)
      {
        label96:
        break label96;
      }
      c = true;
      return null;
    }
  }
  
  public static SparseArray<Bundle> a(List<Bundle> paramList)
  {
    int j = paramList.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private static Bundle[] a(cn[] paramArrayOfcn)
  {
    if (paramArrayOfcn == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfcn.length];
    int i = 0;
    while (i < paramArrayOfcn.length)
    {
      Object localObject1 = paramArrayOfcn[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((cn)localObject1).a);
      localBundle.putCharSequence("label", ((cn)localObject1).b);
      localBundle.putCharSequenceArray("choices", ((cn)localObject1).c);
      localBundle.putBoolean("allowFreeFormInput", ((cn)localObject1).d);
      localBundle.putBundle("extras", ((cn)localObject1).e);
      Object localObject2 = ((cn)localObject1).f;
      if ((localObject2 != null) && (!((Set)localObject2).isEmpty()))
      {
        localObject1 = new ArrayList(((Set)localObject2).size());
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
        }
        localBundle.putStringArrayList("allowedDataTypes", (ArrayList)localObject1);
      }
      arrayOfBundle[i] = localBundle;
      i += 1;
    }
    return arrayOfBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cl
 * JD-Core Version:    0.7.0.1
 */