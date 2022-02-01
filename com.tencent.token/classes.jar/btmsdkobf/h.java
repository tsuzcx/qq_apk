package btmsdkobf;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class h
{
  private Context mContext;
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt != 4) {
      switch (paramInt)
      {
      default: 
        paramString = null;
        break;
      case 2: 
        paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(paramString)));
        break;
      case 1: 
        paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_".concat(String.valueOf(paramString)));
        break;
      case 0: 
        paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        break;
      }
    } else {
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
    }
    Cursor localCursor = this.mContext.getContentResolver().query(paramString, null, null, null, null);
    paramString = localObject2;
    if (localCursor != null)
    {
      paramString = localObject1;
      if (localCursor.moveToNext()) {
        paramString = localCursor.getString(localCursor.getColumnIndex("value"));
      }
      localCursor.close();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.h
 * JD-Core Version:    0.7.0.1
 */