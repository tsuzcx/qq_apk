package com.tencent.token;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class cn
{
  final String a;
  final CharSequence b;
  final CharSequence[] c;
  final boolean d;
  final Bundle e;
  final Set<String> f;
  
  static RemoteInput[] a(cn[] paramArrayOfcn)
  {
    if (paramArrayOfcn == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfcn.length];
    int i = 0;
    while (i < paramArrayOfcn.length)
    {
      cn localcn = paramArrayOfcn[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localcn.a).setLabel(localcn.b).setChoices(localcn.c).setAllowFreeFormInput(localcn.d).addExtras(localcn.e).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cn
 * JD-Core Version:    0.7.0.1
 */