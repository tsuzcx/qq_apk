package com.tencent.mm.sdk.plugin;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class BaseProfile
  extends IAutoDBItem
{
  public static final String COL_ALIAS = "alias";
  public static final String COL_AVATAR = "avatar";
  public static final String COL_BINDEMAIL = "bindemail";
  public static final String COL_BINDMOBILE = "bindmobile";
  public static final String COL_BINDQQ = "bindqq";
  public static final String COL_CITY = "city";
  public static final String COL_NICKNAME = "nickname";
  public static final String COL_PROVINCE = "province";
  public static final String COL_SIGNATURE = "signature";
  public static final String COL_USERNAME = "username";
  public static final String COL_WEIBO = "weibo";
  public static final String[] INDEX_CREATE = new String[0];
  public static final String TABLE_NAME = "Profile";
  public String field_alias;
  public String field_avatar;
  public String field_bindemail;
  public String field_bindmobile;
  public long field_bindqq;
  public String field_city;
  public String field_nickname;
  public String field_province;
  public String field_signature;
  public String field_username;
  public String field_weibo;
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[11];
    paramClass.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "username";
    paramClass.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[1] = "bindqq";
    paramClass.colsMap.put("bindqq", "LONG");
    localStringBuilder.append(" bindqq LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "bindmobile";
    paramClass.colsMap.put("bindmobile", "TEXT");
    localStringBuilder.append(" bindmobile TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "bindemail";
    paramClass.colsMap.put("bindemail", "TEXT");
    localStringBuilder.append(" bindemail TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "alias";
    paramClass.colsMap.put("alias", "TEXT");
    localStringBuilder.append(" alias TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "nickname";
    paramClass.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "signature";
    paramClass.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "province";
    paramClass.colsMap.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "city";
    paramClass.colsMap.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "weibo";
    paramClass.colsMap.put("weibo", "TEXT");
    localStringBuilder.append(" weibo TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "avatar";
    paramClass.colsMap.put("avatar", "TEXT");
    localStringBuilder.append(" avatar TEXT");
    paramClass.columns[11] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    return paramClass;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex("username");
    if (i >= 0) {
      this.field_username = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("bindqq");
    if (i >= 0) {
      this.field_bindqq = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("bindmobile");
    if (i >= 0) {
      this.field_bindmobile = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("bindemail");
    if (i >= 0) {
      this.field_bindemail = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("alias");
    if (i >= 0) {
      this.field_alias = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("nickname");
    if (i >= 0) {
      this.field_nickname = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("signature");
    if (i >= 0) {
      this.field_signature = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("province");
    if (i >= 0) {
      this.field_province = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("city");
    if (i >= 0) {
      this.field_city = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("weibo");
    if (i >= 0) {
      this.field_weibo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("avatar");
    if (i >= 0) {
      this.field_avatar = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("rowid");
    if (i >= 0) {
      this.systemRowid = paramCursor.getLong(i);
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("username", this.field_username);
    localContentValues.put("bindqq", Long.valueOf(this.field_bindqq));
    localContentValues.put("bindmobile", this.field_bindmobile);
    localContentValues.put("bindemail", this.field_bindemail);
    localContentValues.put("alias", this.field_alias);
    localContentValues.put("nickname", this.field_nickname);
    localContentValues.put("signature", this.field_signature);
    localContentValues.put("province", this.field_province);
    localContentValues.put("city", this.field_city);
    localContentValues.put("weibo", this.field_weibo);
    localContentValues.put("avatar", this.field_avatar);
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.BaseProfile
 * JD-Core Version:    0.7.0.1
 */