package com.tencent.token;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class df
{
  final String a;
  final CharSequence b;
  final CharSequence[] c;
  final boolean d;
  final Bundle e;
  final Set<String> f;
  
  static RemoteInput[] a(df[] paramArrayOfdf)
  {
    if (paramArrayOfdf == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfdf.length];
    int i = 0;
    while (i < paramArrayOfdf.length)
    {
      df localdf = paramArrayOfdf[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localdf.a).setLabel(localdf.b).setChoices(localdf.c).setAllowFreeFormInput(localdf.d).addExtras(localdf.e).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.df
 * JD-Core Version:    0.7.0.1
 */