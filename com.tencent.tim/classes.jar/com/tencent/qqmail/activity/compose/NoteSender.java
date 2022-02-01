package com.tencent.qqmail.activity.compose;

import android.text.TextUtils;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class NoteSender
{
  private String TAG = "NoteSender";
  private ComposeMailUI mMail;
  private QMComposeNote mNote;
  private String mNoteCatId;
  private String mNoteCatName;
  private long mOriginalMailId;
  private String sViewFrom;
  
  public NoteSender(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.mOriginalMailId = paramLong;
    this.mNoteCatId = paramString1;
    this.mNoteCatName = paramString2;
    this.sViewFrom = paramString3;
  }
  
  private void createNewNote(ComposeMailUI paramComposeMailUI)
  {
    QMComposeNote localQMComposeNote = QMComposeNote.NoteWithMailUI(paramComposeMailUI);
    if ("folder".equals(this.sViewFrom))
    {
      ComposeMailUI localComposeMailUI = new ComposeMailUI();
      localQMComposeNote.information.noteId = localComposeMailUI.getComposeId();
    }
    localQMComposeNote.status.status = 1;
    generateAbsAndSubject(localQMComposeNote);
    localQMComposeNote.read = true;
    localQMComposeNote.information.attachType = fixAttachType(localQMComposeNote);
    if ((localQMComposeNote.information.noteId == null) || (localQMComposeNote.information.noteId.equals(""))) {
      localQMComposeNote.information.noteId = paramComposeMailUI.getComposeId();
    }
    localQMComposeNote.information.category = new QMNNoteCategory(this.mNoteCatId, this.mNoteCatName);
    paramComposeMailUI = NoteManager.getSharedInstance().getThumbUrl(localQMComposeNote.content);
    localQMComposeNote.information.audio = NoteManager.getSharedInstance().isAudio(localQMComposeNote.content);
    if ((paramComposeMailUI != null) && (paramComposeMailUI.length() > 0)) {}
    for (localQMComposeNote.information.thumbURL = paramComposeMailUI;; localQMComposeNote.information.thumbURL = "")
    {
      QMLog.log(4, this.TAG, "thumb new" + localQMComposeNote.information.thumbURL);
      NoteManager.getSharedInstance().saveUnsendNote(localQMComposeNote);
      QMNotification.postNotification("NOTE_LIST_UPDATE", null);
      paramComposeMailUI = new HashMap();
      paramComposeMailUI.put("noteId", localQMComposeNote.composeKey);
      QMNotification.postNotification("NOTE_DATACHANGE", paramComposeMailUI);
      QMLog.log(4, this.TAG, "savedone");
      QMNotification.postNotification("save_mail_as_note_done", "" + this.mOriginalMailId);
      compressNoteAttachAndSave(localQMComposeNote);
      return;
    }
  }
  
  private String fixAttachType(QMComposeNote paramQMComposeNote)
  {
    if (paramQMComposeNote.attachList != null) {
      return null;
    }
    if ((paramQMComposeNote.addAttachInfoList == null) || (paramQMComposeNote.addAttachInfoList.size() == 0)) {
      return null;
    }
    paramQMComposeNote = (AttachInfo)paramQMComposeNote.addAttachInfoList.get(0);
    if (paramQMComposeNote != null)
    {
      if (paramQMComposeNote.getFileType() == AttachType.IMAGE) {
        return "0";
      }
      if (paramQMComposeNote.getFileType() == AttachType.VIDEO) {
        return "1";
      }
      if (paramQMComposeNote.getFileType() == AttachType.AUDIO) {
        return "2";
      }
      return "3";
    }
    return null;
  }
  
  private void generateAbsAndSubject(QMComposeNote paramQMComposeNote)
  {
    paramQMComposeNote.information.abs = html2Text(paramQMComposeNote.content);
    String str;
    if (TextUtils.isEmpty(paramQMComposeNote.information.subject))
    {
      str = html2Text(paramQMComposeNote.content);
      if (str == null) {
        paramQMComposeNote.information.subject = "";
      }
    }
    else
    {
      return;
    }
    paramQMComposeNote.information.subject = str.substring(0, Math.min(120, str.length()));
  }
  
  private String html2Text(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return StringExtention.htmlDecode(paramString.replaceAll("</?[a-zA-z]+.*?>", "").replaceAll("&nbsp;", " ")).replaceAll("<br\\s*/?>", "\n");
  }
  
  private void loadDefaultCatalog(Subscriber<? super Void> paramSubscriber)
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new NoteSender.3(this));
    localMailManagerDelegate.setOnComplete(new NoteSender.4(this, paramSubscriber));
    NoteManager.sharedInstance().getCatalogList(localMailManagerDelegate);
  }
  
  private void postNotificationToReadNoteController(QMNNote paramQMNNote)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("note", paramQMNNote);
    QMNotification.postNotification("NOTE_EDITSAVE", localHashMap);
  }
  
  private void reEditNote(ComposeMailUI paramComposeMailUI, QMComposeNote paramQMComposeNote)
  {
    paramQMComposeNote.modifyWithMailUI(paramComposeMailUI);
    paramComposeMailUI = new int[2];
    ComposeMailUI tmp10_9 = paramComposeMailUI;
    tmp10_9[0] = 0;
    ComposeMailUI tmp14_10 = tmp10_9;
    tmp14_10[1] = 6;
    tmp14_10;
    int j = paramComposeMailUI.length;
    int i = 0;
    if (i < j)
    {
      int k = paramComposeMailUI[i];
      if (paramQMComposeNote.status.status == k) {
        paramQMComposeNote.status.status = 2;
      }
    }
    else
    {
      paramQMComposeNote.information.category = new QMNNoteCategory(this.mNoteCatId, this.mNoteCatName);
      paramQMComposeNote.read = true;
      paramQMComposeNote.information.attachType = fixAttachType(paramQMComposeNote);
      generateAbsAndSubject(paramQMComposeNote);
      paramComposeMailUI = NoteManager.getSharedInstance().getThumbUrl(paramQMComposeNote.content);
      paramQMComposeNote.information.audio = NoteManager.getSharedInstance().isAudio(paramQMComposeNote.content);
      if ((paramComposeMailUI == null) || (paramComposeMailUI.length() <= 0)) {
        break label465;
      }
    }
    label465:
    for (paramQMComposeNote.information.thumbURL = paramComposeMailUI;; paramQMComposeNote.information.thumbURL = "")
    {
      paramComposeMailUI = paramQMComposeNote.information.noteId;
      String str = NoteManager.getSharedInstance().getIdMapping(paramComposeMailUI);
      QMLog.log(4, this.TAG, "thumb modify:" + paramQMComposeNote.information.thumbURL + " local : " + paramComposeMailUI + " cache:" + str);
      if ((str != null) && (str.contains("___")))
      {
        paramComposeMailUI = str.split("___")[0];
        QMLog.log(4, this.TAG, "replace local id " + paramQMComposeNote.information.noteId + " newid:" + paramComposeMailUI);
        paramQMComposeNote.information.noteId = paramComposeMailUI;
        paramQMComposeNote.status.status = 2;
      }
      refreshSequence(paramQMComposeNote);
      QMLog.log(4, this.TAG, "id: " + paramQMComposeNote.information.noteId + " seq :" + paramQMComposeNote.status.sequence);
      NoteManager.getSharedInstance().saveUnsendNote(paramQMComposeNote);
      paramComposeMailUI = new HashMap();
      paramComposeMailUI.put("noteId", paramQMComposeNote.composeKey);
      QMNotification.postNotification("NOTE_DATACHANGE", paramComposeMailUI);
      postNotificationToReadNoteController(paramQMComposeNote);
      if (this.mOriginalMailId != 0L) {
        QMNotification.postNotification("save_mail_as_note_done", "" + this.mOriginalMailId);
      }
      QMNotification.postNotification("NOTE_LIST_UPDATE", null);
      QMLog.log(4, this.TAG, "savedone");
      compressNoteAttachAndSave(paramQMComposeNote);
      return;
      i += 1;
      break;
    }
  }
  
  private void refreshSequence(QMComposeNote paramQMComposeNote)
  {
    double d = NoteManager.getSharedInstance().getSeq(paramQMComposeNote.information.noteId);
    if (d > 10000.0D) {
      paramQMComposeNote.status.sequence = d;
    }
  }
  
  public void buildCatData(Subscriber<? super Void> paramSubscriber)
  {
    this.mNoteCatName = NoteManager.sharedInstance().findCategoryNameByCid(this.mNoteCatId);
    if ((StringUtils.isEmpty(this.mNoteCatId)) || (StringUtils.isEmpty(this.mNoteCatName)))
    {
      this.mNoteCatId = NoteStorage.getDefaultCatId();
      this.mNoteCatName = NoteManager.sharedInstance().findCategoryNameByCid(this.mNoteCatId);
      if ((StringUtils.isEmpty(this.mNoteCatId)) || (StringUtils.isEmpty(this.mNoteCatName)))
      {
        this.mNoteCatId = "1";
        this.mNoteCatName = "未分类";
        loadDefaultCatalog(paramSubscriber);
        return;
      }
    }
    paramSubscriber.onNext(null);
  }
  
  public void buildData()
  {
    Observable.create(new NoteSender.2(this)).doOnNext(new NoteSender.1(this)).subscribeOn(Schedulers.computation()).subscribe();
  }
  
  public void buildDataWithPredefinedHtmlAndTitle(String paramString1, String paramString2)
  {
    this.mMail = new ComposeMailUI();
    this.mMail.setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE);
    this.mMail.setCurrentTime(System.currentTimeMillis());
    String str = this.mMail.createComposeCache();
    if (((str == null) || (str.equals("")) || (FileUtil.isFileExist(str))) || (!StringUtils.isEmpty(paramString1))) {
      this.mMail.getContent().setBody(paramString1);
    }
    if (!StringUtils.isEmpty(paramString2)) {
      this.mMail.getInformation().setSubject(paramString2);
    }
    sendNoteInBackground(this.mMail, null);
  }
  
  public void buildNoteData()
  {
    this.mMail = SendMailHelper.getComposeMail(this.mOriginalMailId, ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY, true);
    if (this.mMail != null)
    {
      this.mMail.noteStatus = 1;
      this.mNote = QMComposeNote.NoteWithMailUI(this.mMail);
      String str = this.mMail.getContent().getOrigin();
      int i = str.length();
      this.mMail.getContent().setBody(str);
      this.mNote.content = str;
      this.mNote.contentLength = Integer.valueOf(i);
      this.mNote.information.noteId = this.mMail.getComposeId();
    }
  }
  
  public void compressNoteAttachAndSave(QMComposeNote paramQMComposeNote)
  {
    paramQMComposeNote.imageScale = QMSettingManager.sharedInstance().getNoteImgCompressRatio();
    refreshSequence(paramQMComposeNote);
    QMLog.log(4, this.TAG, paramQMComposeNote.information.noteId + " : " + paramQMComposeNote.status.sequence);
    NoteSender.5 local5 = new NoteSender.5(this, paramQMComposeNote);
    paramQMComposeNote.downloadAllCids(this.mOriginalMailId, local5);
  }
  
  public void sendNoteInBackground(ComposeMailUI paramComposeMailUI, QMComposeNote paramQMComposeNote)
  {
    if (paramComposeMailUI == null) {
      QMLog.log(6, this.TAG, "mail should not be mail");
    }
    if (paramQMComposeNote != null)
    {
      QMLog.log(4, this.TAG, "reEditNote");
      reEditNote(paramComposeMailUI, paramQMComposeNote);
      return;
    }
    QMLog.log(4, this.TAG, "createNewNote");
    createNewNote(paramComposeMailUI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.NoteSender
 * JD-Core Version:    0.7.0.1
 */