package com.tencent.token;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class cr
{
  final String a;
  final CharSequence b;
  final CharSequence[] c;
  final boolean d;
  final Bundle e;
  final Set<String> f;
  
  static RemoteInput[] a(cr[] paramArrayOfcr)
  {
    if (paramArrayOfcr == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfcr.length];
    int i = 0;
    while (i < paramArrayOfcr.length)
    {
      cr localcr = paramArrayOfcr[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localcr.a).setLabel(localcr.b).setChoices(localcr.c).setAllowFreeFormInput(localcr.d).addExtras(localcr.e).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cr
 * JD-Core Version:    0.7.0.1
 */