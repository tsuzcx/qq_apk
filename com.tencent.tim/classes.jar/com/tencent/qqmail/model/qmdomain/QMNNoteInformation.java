package com.tencent.qqmail.model.qmdomain;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.UnsupportedEncodingException;

public class QMNNoteInformation
  extends QMDomain
{
  public String abs = "";
  public String attachType = null;
  public String audio = "0";
  public QMNNoteCategory category = new QMNNoteCategory();
  public String noteId = "";
  public String subject = "";
  public String thumbURL = null;
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    String str = (String)paramJSONObject.get("id");
    bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(this.noteId))
      {
        this.noteId = str;
        bool1 = true;
      }
    }
    str = (String)paramJSONObject.get("cid");
    bool2 = bool1;
    if (str != null)
    {
      bool2 = bool1;
      if (!str.equals(this.category.getCatalogId()))
      {
        this.category.setCatalogId(str);
        bool2 = true;
      }
    }
    str = (String)paramJSONObject.get("cnm");
    boolean bool3 = bool2;
    if (str != null)
    {
      bool3 = bool2;
      if (!str.equals(this.category.getCatalogName()))
      {
        this.category.setCatalogName(str);
        bool3 = true;
      }
    }
    str = (String)paramJSONObject.get("subj");
    bool1 = bool3;
    if (str != null)
    {
      bool1 = bool3;
      if (str.equals(this.subject)) {}
    }
    try
    {
      this.subject = StringExtention.urlDecode(str);
      bool1 = true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QMLog.log(6, "QMNoteInformation", "parseWithDictionary err:" + localUnsupportedEncodingException.toString());
        bool1 = true;
      }
    }
    str = (String)paramJSONObject.get("abs");
    bool2 = bool1;
    if (str != null)
    {
      bool2 = bool1;
      if (!str.equals(this.abs))
      {
        this.abs = str;
        bool2 = true;
      }
    }
    str = (String)paramJSONObject.get("picsrc");
    bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(this.thumbURL))
      {
        this.thumbURL = str;
        Log.d("nick", "picsrc:" + this.thumbURL);
        bool1 = true;
      }
    }
    str = (String)paramJSONObject.get("attType");
    bool2 = bool1;
    if (str != null)
    {
      bool2 = bool1;
      if (!str.equals(this.attachType))
      {
        this.attachType = str;
        bool2 = true;
      }
    }
    paramJSONObject = (String)paramJSONObject.get("audio");
    bool1 = bool2;
    if (paramJSONObject != null)
    {
      bool1 = bool2;
      if (!paramJSONObject.equals(this.audio))
      {
        this.audio = paramJSONObject;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"QMNNoteInformation\"");
    if (this.noteId != null) {
      localStringBuilder.append(",\"id\":\"").append(this.noteId).append("\"");
    }
    if (this.subject != null) {}
    try
    {
      localStringBuilder.append(",\"subj\":\"").append(StringExtention.urlEncode(this.subject)).append("\"");
      if (this.abs != null) {
        localStringBuilder.append(",\"abs\":\"").append(this.abs.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"")).append("\"");
      }
      if (this.thumbURL != null) {
        localStringBuilder.append(",\"picsrc\":\"").append(this.thumbURL).append("\"");
      }
      if (this.attachType != null) {
        localStringBuilder.append(",\"attType\":\"").append(this.attachType).append("\"");
      }
      if (this.audio != null) {
        localStringBuilder.append(",\"audio\":\"").append(this.audio).append("\"");
      }
      if (this.category.getCatalogId() != null) {
        localStringBuilder.append(",\"cid\":\"").append(this.category.getCatalogId()).append("\"");
      }
      if (this.category.getCatalogName() != null) {
        localStringBuilder.append(",\"cnm\":\"").append(this.category.getCatalogName()).append("\"");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QMLog.log(6, "QMNoteInformatioin", "toString err:" + localUnsupportedEncodingException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMNNoteInformation
 * JD-Core Version:    0.7.0.1
 */