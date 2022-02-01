import android.content.ContentValues;
import android.os.Parcel;

public class arxe
  extends aryh
{
  public static final aryh.a<arxe> a = new arxf();
  public long awJ;
  public String cCO;
  public long cacheTime;
  public String etag;
  public String response;
  public String urlKey;
  
  protected arxe(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    this.urlKey = paramString1;
    this.etag = paramString2;
    this.awJ = paramLong1;
    this.cacheTime = paramLong2;
    this.response = paramString3;
  }
  
  arxe(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.urlKey = arwv.encodeHexStr(paramString1);
    this.etag = paramString2;
    this.awJ = paramLong;
    this.cacheTime = System.currentTimeMillis();
    this.response = paramString3;
    this.cCO = paramString4;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    paramContentValues.put("urlKey", this.urlKey);
    paramContentValues.put("ETag", this.etag);
    paramContentValues.put("lastModify", Long.valueOf(this.awJ));
    paramContentValues.put("cacheTime", Long.valueOf(this.cacheTime));
    Parcel localParcel = Parcel.obtain();
    localParcel.writeString(this.response);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("response", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxe
 * JD-Core Version:    0.7.0.1
 */