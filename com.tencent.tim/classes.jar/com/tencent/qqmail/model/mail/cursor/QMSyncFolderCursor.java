package com.tencent.qqmail.model.mail.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import java.util.Date;

public class QMSyncFolderCursor
  extends QMMailListCursor
{
  private Cursor cursor;
  private int folderId;
  private int limit = -1;
  protected boolean remoteIdOnly = false;
  
  public QMSyncFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper);
  }
  
  public QMSyncFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt, boolean paramBoolean)
  {
    this(paramQMMailSQLiteHelper, paramInt, paramBoolean, -1);
  }
  
  public QMSyncFolderCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramQMMailSQLiteHelper);
    this.folderId = paramInt1;
    this.remoteIdOnly = paramBoolean;
    this.limit = paramInt2;
    this.cursor = queryRawCursor();
  }
  
  public void close()
  {
    if ((this.cursor != null) && (!this.cursor.isClosed())) {
      this.cursor.close();
    }
  }
  
  public Cursor getCursor()
  {
    return this.cursor;
  }
  
  public Mail getItem(Cursor paramCursor, int[] paramArrayOfInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramArrayOfInt = new Mail();
    paramArrayOfInt.setStatus(new MailStatus());
    paramArrayOfInt.setInformation(new MailInformation());
    if (paramBoolean)
    {
      if (!this.remoteIdOnly) {
        break label316;
      }
      paramArrayOfInt.getInformation().setId(paramCursor.getLong(0));
      paramArrayOfInt.getInformation().setFolderId(paramCursor.getInt(1));
      paramArrayOfInt.getInformation().setRemoteId(paramCursor.getString(2));
      paramArrayOfInt.getInformation().setAbstractContent(paramCursor.getString(3));
      int i = paramCursor.getInt(4);
      localMailStatus = paramArrayOfInt.getStatus();
      if ((i & 0x800) == 0L) {
        break label286;
      }
      paramBoolean = true;
      localMailStatus.setAdConv(paramBoolean);
      localMailStatus = paramArrayOfInt.getStatus();
      if ((i & 0x2000) == 0L) {
        break label291;
      }
      paramBoolean = true;
      label158:
      localMailStatus.setSubscribeConv(paramBoolean);
      localMailStatus = paramArrayOfInt.getStatus();
      if ((i & 0x4000) == 0L) {
        break label296;
      }
      paramBoolean = true;
      label184:
      localMailStatus.setHybirdList(paramBoolean);
      localMailStatus = paramArrayOfInt.getStatus();
      if ((i & 0x200000) == 0L) {
        break label301;
      }
      paramBoolean = true;
      label210:
      localMailStatus.setHasAttach(paramBoolean);
      localMailStatus = paramArrayOfInt.getStatus();
      if ((i & 0x200) == 0L) {
        break label306;
      }
      paramBoolean = true;
      label236:
      localMailStatus.setAdMail(paramBoolean);
      localMailStatus = paramArrayOfInt.getStatus();
      if ((i & 0x1000) == 0L) {
        break label311;
      }
    }
    label286:
    label291:
    label296:
    label301:
    label306:
    label311:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      localMailStatus.setSubscribeMail(paramBoolean);
      paramArrayOfInt.getInformation().setSize(paramCursor.getLong(5));
      return paramArrayOfInt;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label158;
      paramBoolean = false;
      break label184;
      paramBoolean = false;
      break label210;
      paramBoolean = false;
      break label236;
    }
    label316:
    paramArrayOfInt.getInformation().setId(paramCursor.getLong(0));
    paramArrayOfInt.getInformation().setRemoteId(paramCursor.getString(1));
    paramArrayOfInt.getInformation().setUtc(new Date(paramCursor.getLong(2)));
    paramArrayOfInt.getInformation().setConvCount(paramCursor.getInt(3));
    QMMailSQLite.fillMailInfoTagList(paramArrayOfInt.getInformation(), paramCursor.getString(4));
    MailStatus localMailStatus = paramArrayOfInt.getStatus();
    if (paramCursor.getInt(5) != 0)
    {
      paramBoolean = true;
      localMailStatus.setUnread(paramBoolean);
      localMailStatus = paramArrayOfInt.getStatus();
      if (paramCursor.getInt(6) == 0) {
        break label488;
      }
    }
    label488:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localMailStatus.setStarred(paramBoolean);
      QMMailSQLite.fillMailStatusAttr(paramArrayOfInt.getStatus(), paramCursor.getLong(7));
      QMMailSQLite.fillMailStatusConvType(paramCursor.getInt(9), paramArrayOfInt.getStatus(), paramCursor.getInt(8));
      return paramArrayOfInt;
      paramBoolean = false;
      break;
    }
  }
  
  public void loadMore() {}
  
  public boolean queryCanLoadMore()
  {
    return false;
  }
  
  public boolean queryCanPopIn()
  {
    return false;
  }
  
  public boolean queryCanUpdate()
  {
    return false;
  }
  
  public Cursor queryRawCursor()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.mail.getSyncFolderCursor(localSQLiteDatabase, this.folderId, this.remoteIdOnly, this.limit);
  }
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSyncFolderCursor
 * JD-Core Version:    0.7.0.1
 */