package com.tencent.thumbplayer.log;

import android.text.TextUtils;
import androidx.annotation.NonNull;

public class TPLoggerContext
{
  public static final String DEFAULT_TAG = "TPLogger";
  public static final String PREFIX_THUMB_PLAYER = "ThumbPlayer";
  private String classId = "";
  private String model = "";
  private String prefix = "";
  private String tag = "TPLogger";
  private String taskId = "";
  
  public TPLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this(paramTPLoggerContext.prefix, paramTPLoggerContext.classId, paramTPLoggerContext.taskId, paramTPLoggerContext.model);
  }
  
  public TPLoggerContext(TPLoggerContext paramTPLoggerContext, @NonNull String paramString)
  {
    update(paramTPLoggerContext, paramString);
  }
  
  public TPLoggerContext(@NonNull String paramString)
  {
    this(paramString, "", "", "");
  }
  
  public TPLoggerContext(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4)
  {
    this.prefix = paramString1;
    this.classId = paramString2;
    this.taskId = paramString3;
    this.model = paramString4;
    buildTag();
  }
  
  private void buildTag()
  {
    this.tag = this.prefix;
    if (!TextUtils.isEmpty(this.classId)) {
      this.tag = (this.tag + "_C" + this.classId);
    }
    if (!TextUtils.isEmpty(this.taskId)) {
      this.tag = (this.tag + "_T" + this.taskId);
    }
    if (!TextUtils.isEmpty(this.model)) {
      this.tag = (this.tag + "_" + this.model);
    }
  }
  
  public String getClassId()
  {
    return this.classId;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public String getTaskId()
  {
    return this.taskId;
  }
  
  public void setTaskId(String paramString)
  {
    this.taskId = paramString;
    buildTag();
  }
  
  public String toString()
  {
    return "TPLoggerContext{prefix='" + this.prefix + '\'' + ", classId='" + this.classId + '\'' + ", taskId='" + this.taskId + '\'' + ", model='" + this.model + '\'' + ", tag='" + this.tag + '\'' + '}';
  }
  
  public void update(TPLoggerContext paramTPLoggerContext, @NonNull String paramString)
  {
    if (paramTPLoggerContext != null)
    {
      this.prefix = paramTPLoggerContext.prefix;
      this.classId = paramTPLoggerContext.classId;
    }
    for (this.taskId = paramTPLoggerContext.taskId;; this.taskId = "")
    {
      this.model = paramString;
      buildTag();
      return;
      this.prefix = "";
      this.classId = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.log.TPLoggerContext
 * JD-Core Version:    0.7.0.1
 */