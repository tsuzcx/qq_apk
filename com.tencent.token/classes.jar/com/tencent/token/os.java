package com.tencent.token;

import android.os.Bundle;

public final class os
  implements ot.b
{
  int a = 10485760;
  public byte[] b = null;
  public String c = null;
  
  public final int a()
  {
    return 6;
  }
  
  public final void a(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxfileobject_fileData", this.b);
    paramBundle.putString("_wxfileobject_filePath", this.c);
  }
  
  public final void b(Bundle paramBundle)
  {
    this.b = paramBundle.getByteArray("_wxfileobject_fileData");
    this.c = paramBundle.getString("_wxfileobject_filePath");
  }
  
  public final boolean b()
  {
    Object localObject = this.b;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.c;
      if (localObject == null) {
        break label76;
      }
      if (((String)localObject).length() == 0) {
        return false;
      }
    }
    localObject = this.b;
    if ((localObject != null) && (localObject.length > this.a)) {
      return false;
    }
    localObject = this.c;
    return (localObject == null) || (pg.b((String)localObject) <= this.a);
    label76:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.os
 * JD-Core Version:    0.7.0.1
 */