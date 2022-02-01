package com.tencent.qqmail.schema;

import android.content.Context;

public abstract class SchemaBase
{
  public static final String ANIMATION_TYPE = "animationType";
  public static final String URL_QQMAIL_PREFIX = "qqmail://";
  protected Context context;
  protected String func;
  protected String params;
  protected String schema;
  
  public SchemaBase(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.schema = paramString;
    paramContext = paramString.replace("qqmail://", "").split("\\?");
    if (paramContext.length > 0) {
      this.func = paramContext[0];
    }
    if (paramContext.length > 1) {
      this.params = paramContext[1];
    }
  }
  
  public abstract boolean doAction(int paramInt);
  
  public abstract void parseParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaBase
 * JD-Core Version:    0.7.0.1
 */