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
    Object localObject1 = null;
    if (paramInt != 4) {
      switch (paramInt)
      {
      default: 
        paramString = null;
        break;
      case 2: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("content://com.vivo.vms.IdProvider/IdentifierId/AAID_");
        ((StringBuilder)localObject2).append(paramString);
        paramString = Uri.parse(((StringBuilder)localObject2).toString());
        break;
      case 1: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("content://com.vivo.vms.IdProvider/IdentifierId/VAID_");
        ((StringBuilder)localObject2).append(paramString);
        paramString = Uri.parse(((StringBuilder)localObject2).toString());
        break;
      case 0: 
        paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        break;
      }
    } else {
      paramString = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
    }
    Object localObject2 = this.mContext.getContentResolver().query(paramString, null, null, null, null);
    if (localObject2 != null)
    {
      paramString = localObject1;
      if (((Cursor)localObject2).moveToNext()) {
        paramString = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("value"));
      }
      ((Cursor)localObject2).close();
      return paramString;
    }
    Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.h
 * JD-Core Version:    0.7.0.1
 */