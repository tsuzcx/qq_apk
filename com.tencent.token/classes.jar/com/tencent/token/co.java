package com.tencent.token;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class co
{
  final String a;
  final CharSequence b;
  final CharSequence[] c;
  final boolean d;
  final Bundle e;
  final Set<String> f;
  
  static RemoteInput[] a(co[] paramArrayOfco)
  {
    if (paramArrayOfco == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfco.length];
    int i = 0;
    while (i < paramArrayOfco.length)
    {
      co localco = paramArrayOfco[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localco.a).setLabel(localco.b).setChoices(localco.c).setAllowFreeFormInput(localco.d).addExtras(localco.e).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.co
 * JD-Core Version:    0.7.0.1
 */