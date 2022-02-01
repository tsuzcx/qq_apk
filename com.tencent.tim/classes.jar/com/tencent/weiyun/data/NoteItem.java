package com.tencent.weiyun.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class NoteItem
  extends CNativeObject
{
  public static final int TYPE_ALL = 0;
  public static final int TYPE_ARTICLE = 1;
  public static final int TYPE_COLLECTION = 4;
  public static final int TYPE_HTML_TEXT = 2;
  public static final int TYPE_MAIL = 3;
  public ArticleText articleText;
  public long createTime;
  public HtmlText htmlText;
  public boolean isDeleted = false;
  public String md5;
  public long modifyTime;
  private String noteId;
  public String noteSummary;
  public String noteTitle;
  public int noteType;
  public boolean starFlag;
  public long starTime;
  public String thumbUrl;
  
  private NoteItem()
  {
    super(0L);
  }
  
  private NoteItem(long paramLong)
  {
    super(paramLong);
  }
  
  public static NoteItem newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    NoteItem localNoteItem = new NoteItem(paramLong);
    localNoteItem.noteId = CBundleReader.getString(paramLong, "note_id");
    localNoteItem.noteType = CBundleReader.getInt(paramLong, "note_type", 0);
    localNoteItem.noteTitle = CBundleReader.getString(paramLong, "note_title");
    localNoteItem.noteSummary = CBundleReader.getString(paramLong, "note_summary");
    localNoteItem.createTime = CBundleReader.getLong(paramLong, "create_time", 0L);
    localNoteItem.modifyTime = CBundleReader.getLong(paramLong, "modify_time", 0L);
    localNoteItem.thumbUrl = CBundleReader.getString(paramLong, "thumb_url");
    localNoteItem.md5 = CBundleReader.getHexString(paramLong, "md5").toLowerCase();
    localNoteItem.starTime = CBundleReader.getLong(paramLong, "star_time", 0L);
    localNoteItem.starFlag = CBundleReader.getBoolean(paramLong, "star_flag", false);
    localNoteItem.isDeleted = CBundleReader.getBoolean(paramLong, "is_deleted", false);
    long l = CBundleReader.getLong(paramLong, "article_text", 0L);
    if (l != 0L) {
      localNoteItem.articleText = ArticleText.newInstance(l);
    }
    paramLong = CBundleReader.getLong(paramLong, "html_text", 0L);
    if (paramLong != 0L) {
      localNoteItem.htmlText = HtmlText.newInstance(paramLong);
    }
    localNoteItem.releaseNative();
    return localNoteItem;
  }
  
  public String noteId()
  {
    return this.noteId;
  }
  
  public void releaseNative()
  {
    if (isNative())
    {
      if (this.articleText != null) {
        this.articleText.releaseNative();
      }
      if (this.htmlText != null) {
        this.htmlText.releaseNative();
      }
    }
    super.releaseNative();
  }
  
  public static class ArticleText
    extends CNativeObject
  {
    public NoteItem.HtmlText articleComment;
    public String articleContent;
    public String articlePicsUrl;
    public String articleRawUrl;
    public String articleThumbId;
    public String articleTitle;
    public String articleUrl;
    
    private ArticleText()
    {
      super();
    }
    
    private ArticleText(long paramLong)
    {
      super();
    }
    
    public static ArticleText newInstance(long paramLong)
    {
      if (paramLong == 0L) {
        return null;
      }
      ArticleText localArticleText = new ArticleText(paramLong);
      localArticleText.articleRawUrl = CBundleReader.getString(paramLong, "article_raw_url");
      localArticleText.articleTitle = CBundleReader.getString(paramLong, "article_title");
      localArticleText.articleUrl = CBundleReader.getString(paramLong, "article_url");
      localArticleText.articlePicsUrl = CBundleReader.getString(paramLong, "article_pics_url");
      localArticleText.articleThumbId = CBundleReader.getString(paramLong, "article_thumb_id");
      localArticleText.articleContent = CBundleReader.getString(paramLong, "article_content");
      paramLong = CBundleReader.getLong(paramLong, "article_comment", 0L);
      if (paramLong != 0L) {
        localArticleText.articleComment = NoteItem.HtmlText.newInstance(paramLong);
      }
      localArticleText.releaseNative();
      return localArticleText;
    }
    
    public void releaseNative()
    {
      if ((isNative()) && (this.articleComment != null)) {
        this.articleComment.releaseNative();
      }
      super.releaseNative();
    }
  }
  
  public static class HtmlText
    extends CNativeObject
  {
    public FileItem[] fileList;
    public String htmlContent;
    public String[] picUrlList;
    
    private HtmlText()
    {
      super();
    }
    
    private HtmlText(long paramLong)
    {
      super();
    }
    
    public static HtmlText newInstance(long paramLong)
    {
      if (paramLong == 0L) {
        return null;
      }
      HtmlText localHtmlText = new HtmlText(paramLong);
      localHtmlText.htmlContent = CBundleReader.getString(paramLong, "html_content");
      long[] arrayOfLong = CBundleReader.getLongArray(paramLong, "pic_url_list");
      ArrayList localArrayList;
      int j;
      int i;
      Object localObject;
      if (arrayOfLong != null)
      {
        localArrayList = new ArrayList(arrayOfLong.length);
        j = arrayOfLong.length;
        i = 0;
        while (i < j)
        {
          long l = arrayOfLong[i];
          if (l != 0L)
          {
            localObject = CBundleReader.getString(l, "url");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localArrayList.add(localObject);
            }
          }
          i += 1;
        }
        if (!localArrayList.isEmpty()) {
          localHtmlText.picUrlList = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
        }
      }
      arrayOfLong = CBundleReader.getLongArray(paramLong, "file_list");
      if (arrayOfLong != null)
      {
        localArrayList = new ArrayList(arrayOfLong.length);
        j = arrayOfLong.length;
        i = 0;
        while (i < j)
        {
          paramLong = arrayOfLong[i];
          if (paramLong != 0L)
          {
            localObject = FileItem.newInstance(paramLong);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
          i += 1;
        }
        if (!localArrayList.isEmpty()) {
          localHtmlText.fileList = ((FileItem[])localArrayList.toArray(new FileItem[localArrayList.size()]));
        }
      }
      localHtmlText.releaseNative();
      return localHtmlText;
    }
    
    public void releaseNative()
    {
      if ((isNative()) && (this.fileList != null))
      {
        FileItem[] arrayOfFileItem = this.fileList;
        int j = arrayOfFileItem.length;
        int i = 0;
        while (i < j)
        {
          FileItem localFileItem = arrayOfFileItem[i];
          if (localFileItem != null) {
            localFileItem.releaseNative();
          }
          i += 1;
        }
      }
      super.releaseNative();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.data.NoteItem
 * JD-Core Version:    0.7.0.1
 */