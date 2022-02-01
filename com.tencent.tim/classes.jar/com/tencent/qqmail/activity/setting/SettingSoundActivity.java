package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingSoundActivity
  extends BaseActivityEx
{
  private static final String ARG_SOUND_IDDEX = "arg_sound_id";
  private static final int ID_DEFAULT = 0;
  private static final int SOUND_INDEX_KEY_MAN = 1;
  private static final int SOUND_INDEX_NEW_MAIL = 0;
  private static final String TAG = "SettingSoundActivity";
  private boolean mNewMail;
  private String mNotificationSoundFile;
  private QMBaseView mSettingView;
  @Nullable
  private List<String> mSoundList;
  private final boolean mUseOwnSound;
  private MediaPlayer mediaPlayer;
  private QMRadioGroup.OnCheckedChangeListener onCheckedChangeListener;
  
  public SettingSoundActivity()
  {
    if ((QMPushManager.isMiPushWorking()) && (AccountManager.shareInstance().getAccountList().hasQQMailAccounts())) {}
    for (boolean bool = true;; bool = false)
    {
      this.mUseOwnSound = bool;
      this.onCheckedChangeListener = new SettingSoundActivity.1(this);
      return;
    }
  }
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingSoundActivity.class);
    localIntent.putExtra("arg_sound_id", paramInt);
    return localIntent;
  }
  
  private void initMainTable()
  {
    int j = 0;
    QMRadioGroup localQMRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(localQMRadioGroup);
    localQMRadioGroup.addItem(0, 2131720011);
    String str1;
    int i;
    label94:
    int k;
    if (this.mNewMail)
    {
      str1 = QMSettingManager.sharedInstance().getSoundTypeNewMailString();
      str1 = str1.split("\\.")[0];
      i = j;
      if (this.mSoundList == null) {
        break label166;
      }
      i = j;
      if (this.mSoundList.size() <= 0) {
        break label166;
      }
      Iterator localIterator = this.mSoundList.iterator();
      j = 1;
      i = 0;
      if (!localIterator.hasNext()) {
        break label166;
      }
      String str2 = ((String)localIterator.next()).split("\\.")[0];
      k = j + 1;
      localQMRadioGroup.addItem(j, str2);
      if (!str2.equals(str1)) {
        break label187;
      }
      i = k - 1;
    }
    label166:
    label187:
    for (;;)
    {
      j = k;
      break label94;
      str1 = QMSettingManager.sharedInstance().getSoundTypeKeyManString();
      break;
      localQMRadioGroup.setOnCheckedChangeListener(this.onCheckedChangeListener);
      localQMRadioGroup.commit();
      localQMRadioGroup.setSelectedItem(i);
      return;
    }
  }
  
  private void initSoundList()
  {
    if (this.mUseOwnSound) {
      this.mSoundList = QMPushManager.OWN_SOUND_LIST;
    }
    for (;;)
    {
      return;
      File[] arrayOfFile = new File("/system/media/audio/notifications").listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        this.mSoundList = new ArrayList();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          this.mSoundList.add(localFile.getName());
          i += 1;
        }
      }
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.mNewMail) {}
    for (int i = 2131719893;; i = 2131719884)
    {
      localQMTopBar.setTitle(i);
      localQMTopBar.setButtonLeftBack();
      return;
    }
  }
  
  private void refreshDescription(int paramInt)
  {
    boolean bool = false;
    if (this.mediaPlayer != null) {
      this.mediaPlayer.stop();
    }
    if (paramInt == 0)
    {
      this.mediaPlayer = MediaPlayer.create(this, RingtoneManager.getDefaultUri(2));
      localObject1 = "default";
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject2 = new AudioAttributes.Builder().setUsage(6).setContentType(4).build();
        this.mediaPlayer.setAudioAttributes((AudioAttributes)localObject2);
      }
      this.mediaPlayer.setLooping(false);
      this.mediaPlayer.start();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        QMLog.log(5, "SettingSoundActivity", "play system ringtone failed", localException);
      }
    }
    this.mNotificationSoundFile = ((String)localObject1);
    return;
    if (this.mSoundList != null) {
      bool = true;
    }
    ValidateHelper.assertInDebug("sound list empty", bool);
    localObject2 = (String)this.mSoundList.get(paramInt - 1);
    if (this.mUseOwnSound) {}
    for (Object localObject1 = "android.resource://com.tencent.androidqqmail/raw/" + ((String)localObject2).toLowerCase();; localObject1 = "/system/media/audio/notifications/" + (String)localObject2)
    {
      this.mediaPlayer = MediaPlayer.create(this, Uri.parse((String)localObject1));
      localObject1 = localObject2;
      break;
    }
  }
  
  public void initDataSource()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("arg_sound_id", 0) == 0) {
      bool = true;
    }
    this.mNewMail = bool;
    initSoundList();
  }
  
  public void initDom()
  {
    initTopBar();
    initMainTable();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackground()
  {
    if (this.mNotificationSoundFile != null) {
      if ((!this.mUseOwnSound) || ("default".equals(this.mNotificationSoundFile))) {
        break label82;
      }
    }
    label82:
    for (String str = "mipush_" + this.mNotificationSoundFile.toLowerCase(); this.mNewMail; str = this.mNotificationSoundFile)
    {
      QMSettingManager.sharedInstance().setSoundTypeNewMail(this.mNotificationSoundFile, this.mUseOwnSound);
      QMPrivateProtocolManager.sharedInstance().setNotifyNewMailSound(str);
      return;
    }
    QMSettingManager.sharedInstance().setSoundTypeKeyMan(this.mNotificationSoundFile, this.mUseOwnSound);
    QMPrivateProtocolManager.sharedInstance().setPushVipSound(str);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSoundActivity
 * JD-Core Version:    0.7.0.1
 */