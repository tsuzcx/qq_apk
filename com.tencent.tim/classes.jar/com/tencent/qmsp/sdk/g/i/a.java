package com.tencent.qmsp.sdk.g.i;

import alld;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qmsp.sdk.base.c;

public class a
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = null;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          paramString = null;
        }
      }
    }
    Cursor localCursor;
    for (;;)
    {
      localCursor = alld.query(this.a.getContentResolver(), paramString, null, null, null, null);
      if (localCursor != null) {
        break;
      }
      c.b("return cursor is null,return");
      return null;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + paramString);
      continue;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + paramString);
      continue;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    }
    paramString = localObject;
    if (localCursor.moveToNext()) {
      paramString = localCursor.getString(localCursor.getColumnIndex("value"));
    }
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.i.a
 * JD-Core Version:    0.7.0.1
 */