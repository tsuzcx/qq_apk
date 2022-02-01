import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class aevx
{
  private static String bCr = aevw.CALLER_IS_SYNCADAPTER;
  private long WS;
  private boolean bWJ;
  private ContentValues c;
  private int cPw;
  private QQAppInterface mApp;
  private List<ContentProviderOperation> zf;
  
  private aevx(QQAppInterface paramQQAppInterface, List<ContentProviderOperation> paramList)
  {
    this.zf = paramList;
    this.mApp = paramQQAppInterface;
    this.c = new ContentValues();
  }
  
  private aevx(QQAppInterface paramQQAppInterface, List<ContentProviderOperation> paramList, long paramLong)
  {
    this(paramQQAppInterface, paramList);
    this.WS = paramLong;
    this.bWJ = false;
  }
  
  private aevx(QQAppInterface paramQQAppInterface, List<ContentProviderOperation> paramList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(paramQQAppInterface, paramList);
    this.bWJ = true;
    this.cPw = paramList.size();
    paramQQAppInterface = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build()).withValue("aggregation_mode", Integer.valueOf(0)).withValue("account_type", "com.tencent.mobileqq.account").withValue("account_name", paramString1).withValue("sourceid", paramString2).withValue("sync1", paramString3).withValue("sync2", paramString4).withValue("sync3", Integer.valueOf(paramInt1));
    this.zf.add(paramQQAppInterface.build());
  }
  
  public static aevx a(QQAppInterface paramQQAppInterface, List<ContentProviderOperation> paramList, long paramLong)
  {
    return new aevx(paramQQAppInterface, paramList, paramLong);
  }
  
  public static aevx a(QQAppInterface paramQQAppInterface, List<ContentProviderOperation> paramList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    return new aevx(paramQQAppInterface, paramList, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
  }
  
  private static ContentProviderOperation.Builder a()
  {
    return ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", bCr).build()).withYieldAllowed(true);
  }
  
  private static ContentProviderOperation.Builder a(Uri paramUri)
  {
    return ContentProviderOperation.newUpdate(paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", bCr).build()).withYieldAllowed(true);
  }
  
  private void cXv()
  {
    if (!this.bWJ) {
      this.c.put("raw_contact_id", Long.valueOf(this.WS));
    }
    ContentProviderOperation.Builder localBuilder = a();
    localBuilder.withValues(this.c);
    if (this.bWJ) {
      localBuilder.withValueBackReference("raw_contact_id", this.cPw);
    }
    this.zf.add(localBuilder.build());
  }
  
  private void e(Uri paramUri)
  {
    paramUri = a(paramUri);
    paramUri.withValues(this.c);
    this.zf.add(paramUri.build());
  }
  
  public aevx a(String paramString)
  {
    this.c.clear();
    this.c.put("mimetype", "vnd.android.cursor.item/name");
    this.c.put("data1", paramString);
    cXv();
    return this;
  }
  
  public aevx a(String paramString, Uri paramUri)
  {
    this.c.clear();
    this.c.put("data1", paramString);
    e(paramUri);
    return this;
  }
  
  public aevx b(String paramString)
  {
    this.c.clear();
    this.c.put("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile");
    this.c.put("data1", paramString);
    this.c.put("data2", "QQ");
    this.c.put("data3", acfp.m(2131704420));
    cXv();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aevx
 * JD-Core Version:    0.7.0.1
 */