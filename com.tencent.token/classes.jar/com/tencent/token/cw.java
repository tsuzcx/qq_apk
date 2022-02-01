package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class cw
{
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, a parama)
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = a(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, parama);
    if (paramContext == null)
    {
      if (parama != null) {
        return paramContext;
      }
      paramContext = new StringBuilder("Font resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(" could not be retrieved.");
      throw new Resources.NotFoundException(paramContext.toString());
    }
    return paramContext;
  }
  
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, a parama)
  {
    if (paramTypedValue.string != null)
    {
      paramTypedValue = paramTypedValue.string.toString();
      if (!paramTypedValue.startsWith("res/"))
      {
        if (parama != null) {
          parama.a(-3, null);
        }
        return null;
      }
      Typeface localTypeface = da.a(paramResources, paramInt1, paramInt2);
      if (localTypeface != null)
      {
        if (parama != null) {
          parama.a(localTypeface, null);
        }
        return localTypeface;
      }
    }
    try
    {
      if (paramTypedValue.toLowerCase().endsWith(".xml"))
      {
        paramTypedValue = cv.a(paramResources.getXml(paramInt1), paramResources);
        if (paramTypedValue == null)
        {
          if (parama == null) {
            break label242;
          }
          parama.a(-3, null);
          return null;
        }
        return da.a(paramContext, paramTypedValue, paramResources, paramInt1, paramInt2, parama);
      }
      paramContext = da.a(paramContext, paramResources, paramInt1, paramTypedValue, paramInt2);
      if (parama != null)
      {
        if (paramContext != null)
        {
          parama.a(paramContext, null);
          return paramContext;
        }
        parama.a(-3, null);
      }
      return paramContext;
    }
    catch (XmlPullParserException|IOException paramContext)
    {
      label162:
      break label162;
    }
    if (parama != null) {
      parama.a(-3, null);
    }
    return null;
    paramContext = new StringBuilder("Resource \"");
    paramContext.append(paramResources.getResourceName(paramInt1));
    paramContext.append("\" (");
    paramContext.append(Integer.toHexString(paramInt1));
    paramContext.append(") is not a Font: ");
    paramContext.append(paramTypedValue);
    throw new Resources.NotFoundException(paramContext.toString());
    label242:
    return null;
  }
  
  public static abstract class a
  {
    public final void a(final int paramInt, Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      localHandler.post(new Runnable()
      {
        public final void run() {}
      });
    }
    
    public abstract void a(Typeface paramTypeface);
    
    public final void a(final Typeface paramTypeface, Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      localHandler.post(new Runnable()
      {
        public final void run()
        {
          cw.a.this.a(paramTypeface);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cw
 * JD-Core Version:    0.7.0.1
 */