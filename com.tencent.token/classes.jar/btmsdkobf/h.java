package btmsdkobf;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class h
{
  private Context mContext;
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = null;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramString = null;
    }
    for (;;)
    {
      Cursor localCursor = this.mContext.getContentResolver().query(paramString, null, null, null, null);
      if (localCursor == null) {
        break;
      }
      paramString = localObject;
      if (localCursor.moveToNext()) {
        paramString = localCursor.getString(localCursor.getColumnIndex("value"));
      }
      localCursor.close();
      return paramString;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
      continue;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + paramString);
      continue;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + paramString);
      continue;
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
    }
    Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.h
 * JD-Core Version:    0.7.0.1
 */