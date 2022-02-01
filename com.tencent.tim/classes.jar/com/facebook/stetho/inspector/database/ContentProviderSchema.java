package com.facebook.stetho.inspector.database;

import android.net.Uri;

public class ContentProviderSchema
{
  private final String[] mProjection;
  private final String mTableName;
  private final Uri mUri;
  
  private ContentProviderSchema(Builder paramBuilder)
  {
    this.mTableName = Builder.access$000(paramBuilder).mTableName;
    this.mUri = Builder.access$000(paramBuilder).mUri;
    this.mProjection = Builder.access$000(paramBuilder).mProjection;
  }
  
  public String[] getProjection()
  {
    return this.mProjection;
  }
  
  public String getTableName()
  {
    return this.mTableName;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public static class Builder
  {
    private ContentProviderSchema.Table mTable;
    
    public ContentProviderSchema build()
    {
      return new ContentProviderSchema(this, null);
    }
    
    public Builder table(ContentProviderSchema.Table paramTable)
    {
      this.mTable = paramTable;
      return this;
    }
  }
  
  public static class Table
  {
    private String[] mProjection;
    private String mTableName;
    private Uri mUri;
    
    private Table(Builder paramBuilder)
    {
      this.mUri = paramBuilder.mUri;
      this.mProjection = paramBuilder.mProjection;
      this.mTableName = paramBuilder.mTableName;
      if (this.mTableName == null) {
        this.mTableName = this.mUri.getLastPathSegment();
      }
    }
    
    public static class Builder
    {
      private String[] mProjection;
      private String mTableName;
      private Uri mUri;
      
      public ContentProviderSchema.Table build()
      {
        return new ContentProviderSchema.Table(this, null);
      }
      
      public Builder name(String paramString)
      {
        this.mTableName = paramString;
        return this;
      }
      
      public Builder projection(String[] paramArrayOfString)
      {
        this.mProjection = paramArrayOfString;
        return this;
      }
      
      public Builder uri(Uri paramUri)
      {
        this.mUri = paramUri;
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.ContentProviderSchema
 * JD-Core Version:    0.7.0.1
 */