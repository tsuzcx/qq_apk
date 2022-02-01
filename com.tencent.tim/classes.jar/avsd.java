import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class avsd
{
  public ArrayList<QZoneCountUserInfo> ES;
  public String cNl;
  public String cNm = "";
  public String cNn;
  public long cTime;
  public boolean doA;
  public int eym;
  public int eyn;
  public boolean hasShow;
  public int iControl;
  public int iShowLevel;
  public String iconUrl;
  public String schema = "";
  public String strShowMsg;
  public String trace_info;
  public long uCount;
  
  public avsd()
  {
    this(0, 0, new ArrayList(), "", "");
  }
  
  public avsd(int paramInt1, int paramInt2, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, String paramString2)
  {
    this.uCount = paramInt1;
    this.iControl = paramInt2;
    this.ES = paramArrayList;
    this.cNl = paramString1;
    this.eym = 0;
    this.trace_info = paramString2;
  }
  
  public avsd(avsd paramavsd)
  {
    this.uCount = paramavsd.uCount;
    this.iControl = paramavsd.iControl;
    this.ES = new ArrayList();
    if (paramavsd.ES != null) {
      this.ES.addAll(paramavsd.ES);
    }
    this.cNl = paramavsd.cNl;
    this.eym = 0;
    this.cNm = paramavsd.cNm;
    this.schema = paramavsd.schema;
    this.trace_info = paramavsd.trace_info;
    this.iconUrl = paramavsd.iconUrl;
    this.eyn = paramavsd.eyn;
    this.strShowMsg = paramavsd.strShowMsg;
    this.cNn = paramavsd.cNn;
    this.cTime = paramavsd.cTime;
    this.iShowLevel = paramavsd.iShowLevel;
    this.hasShow = paramavsd.hasShow;
  }
  
  public static HashMap<Integer, avsd> a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (paramCursor.moveToNext())
    {
      avsd localavsd = new avsd();
      int j = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      localavsd.iControl = paramCursor.getInt(paramCursor.getColumnIndex("icontrol"));
      localavsd.cNl = paramCursor.getString(paramCursor.getColumnIndex("friendMsg"));
      localavsd.uCount = paramCursor.getInt(paramCursor.getColumnIndex("ucount"));
      localavsd.trace_info = paramCursor.getString(paramCursor.getColumnIndex("trace_info"));
      localavsd.eym = paramCursor.getInt(paramCursor.getColumnIndex("friendsNum"));
      localavsd.ES = new ArrayList();
      Object localObject1 = paramCursor.getBlob(paramCursor.getColumnIndex("frienduins"));
      Parcel localParcel;
      if ((localObject1 != null) && (localObject1.length != 0)) {
        localParcel = Parcel.obtain();
      }
      try
      {
        localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
        localParcel.setDataPosition(0);
        localObject1 = localParcel.readParcelableArray(QZoneCountUserInfo.class.getClassLoader());
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            localavsd.ES.add((QZoneCountUserInfo)localObject2);
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label295:
          localThrowable.printStackTrace();
          localParcel.recycle();
        }
      }
      finally
      {
        localParcel.recycle();
      }
      if (paramCursor.getInt(paramCursor.getColumnIndex("existDL")) == 1)
      {
        bool = true;
        localavsd.doA = bool;
        localavsd.cNm = paramCursor.getString(paramCursor.getColumnIndex("pushMsg"));
        localavsd.schema = paramCursor.getString(paramCursor.getColumnIndex("schema"));
        localavsd.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        localavsd.cNn = paramCursor.getString(paramCursor.getColumnIndex("reportValue"));
        localavsd.strShowMsg = paramCursor.getString(paramCursor.getColumnIndex("showMsg"));
        localavsd.eyn = paramCursor.getInt(paramCursor.getColumnIndex("countID"));
        localavsd.cTime = paramCursor.getLong(paramCursor.getColumnIndex("cTime"));
        localavsd.iShowLevel = paramCursor.getInt(paramCursor.getColumnIndex("iShowLevel"));
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasShow")) != 1) {
          break label526;
        }
      }
      label526:
      for (boolean bool = true;; bool = false)
      {
        localavsd.hasShow = bool;
        localHashMap.put(Integer.valueOf(j), localavsd);
        break;
        bool = false;
        break label295;
      }
    }
    return localHashMap;
  }
  
  public boolean a(avsd paramavsd)
  {
    if (paramavsd == null) {}
    while (((this.trace_info != null) && (!this.trace_info.equals(paramavsd.trace_info))) || ((paramavsd.trace_info != null) && (!paramavsd.trace_info.equals(this.trace_info))) || ((this.cNm != null) && (!this.cNm.equals(paramavsd.cNm))) || ((this.cNm == null) && (paramavsd.cNm != null)) || ((this.schema != null) && (!this.schema.equals(paramavsd.schema))) || ((this.schema == null) && (paramavsd.schema != null)) || (this.eyn != paramavsd.eyn) || (!String.valueOf(this.iconUrl).equals(String.valueOf(paramavsd.iconUrl))) || (!String.valueOf(this.strShowMsg).equals(String.valueOf(paramavsd.strShowMsg))) || (!String.valueOf(this.cNn).equals(String.valueOf(this.cNn))) || (this.cTime != paramavsd.cTime) || (this.uCount != paramavsd.uCount) || (!this.ES.equals(paramavsd.ES))) {
      return false;
    }
    return true;
  }
  
  public ContentValues b()
  {
    int j = 1;
    ContentValues localContentValues = new ContentValues(9);
    localContentValues.put("icontrol", Integer.valueOf(this.iControl));
    localContentValues.put("ucount", Long.valueOf(this.uCount));
    localContentValues.put("friendsNum", Integer.valueOf(this.eym));
    Parcel localParcel = Parcel.obtain();
    Object localObject = null;
    if (this.ES != null)
    {
      localObject = new QZoneCountUserInfo[this.ES.size()];
      localParcel.writeParcelableArray((Parcelable[])this.ES.toArray((Object[])localObject), 0);
      localObject = localParcel.marshall();
    }
    localParcel.recycle();
    localContentValues.put("frienduins", (byte[])localObject);
    localContentValues.put("friendMsg", this.cNl);
    localContentValues.put("trace_info", this.trace_info);
    if (this.doA)
    {
      i = 1;
      localContentValues.put("existDL", Integer.valueOf(i));
      localContentValues.put("pushMsg", this.cNm);
      localContentValues.put("schema", this.schema);
      localContentValues.put("iconUrl", this.iconUrl);
      localContentValues.put("showMsg", this.strShowMsg);
      localContentValues.put("reportValue", this.cNn);
      localContentValues.put("cTime", Long.valueOf(this.cTime));
      localContentValues.put("iShowLevel", Integer.valueOf(this.iShowLevel));
      if (!this.hasShow) {
        break label269;
      }
    }
    label269:
    for (int i = j;; i = 0)
    {
      localContentValues.put("hasShow", Integer.valueOf(i));
      return localContentValues;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsd
 * JD-Core Version:    0.7.0.1
 */