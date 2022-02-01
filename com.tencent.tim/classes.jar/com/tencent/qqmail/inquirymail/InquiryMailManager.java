package com.tencent.qqmail.inquirymail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;

public class InquiryMailManager
{
  private static final String TAG = "InquiryMailManager";
  private static volatile InquiryMailManager _instance;
  private InquiryMailCGIManager cgiManager;
  private QMMailSQLiteHelper sqliteHelper;
  
  private InquiryMailManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.cgiManager = new InquiryMailCGIManager(paramQMMailSQLiteHelper);
  }
  
  public static InquiryMailManager sharedInstance()
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new InquiryMailManager(QMMailManager.sharedInstance().getSqliteHelper());
      }
      return _instance;
    }
    finally {}
  }
  
  public void addWhiteList(int paramInt, String paramString)
  {
    this.cgiManager.addWhiteList(paramInt, paramString);
  }
  
  public void deleteAccountInquiryMail(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.sqliteHelper.inquiryMail.deleteInquiryMail(paramSQLiteDatabase, paramInt);
  }
  
  public InquiryMailListCursor getInquiryMailListCursor(int paramInt)
  {
    return new InquiryMailListCursor(this.sqliteHelper, this, paramInt);
  }
  
  public void initLoadInquiryMailList(int paramInt)
  {
    this.cgiManager.loadInquiryMailList(paramInt, 0, 0L);
  }
  
  public void loadInquiryMailList(int paramInt)
  {
    int i = QMSettingManager.sharedInstance().getInquiryMailAccountPage(paramInt);
    long l = QMSettingManager.sharedInstance().getInquiryMailAccountEdgeTime(paramInt);
    this.cgiManager.loadInquiryMailList(paramInt, i, l);
  }
  
  public void moveInquiryMailToTrash(String[] paramArrayOfString, boolean paramBoolean)
  {
    this.sqliteHelper.inquiryMail.moveInquiryMailToTrash(this.sqliteHelper.getWritableDatabase(), paramArrayOfString, paramBoolean);
  }
  
  public void removeBlackList(int paramInt, String paramString)
  {
    this.cgiManager.removeBlackList(paramInt, paramString);
  }
  
  public void retrieveMail(int paramInt, InquiryMail paramInquiryMail)
  {
    this.cgiManager.retrieveMail(paramInt, paramInquiryMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailManager
 * JD-Core Version:    0.7.0.1
 */