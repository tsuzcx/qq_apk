package com.tencent.qqmail;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.activity.compose.ComposeFeedbackActivity;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.compose.LocalDraftUtils;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import moai.oss.KvHelper;

public class CrashComposeCheck
{
  public static final String TAG = "CrashComposeCheck";
  
  public static Intent checkCrashComposeMail(Context paramContext)
  {
    if (LoginManager.shareInstance().canAutoLogin().booleanValue())
    {
      ComposeMailUI localComposeMailUI = LocalDraftUtils.readLocalDraft();
      if (localComposeMailUI != null)
      {
        if (localComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE)
        {
          QMLog.log(4, "CrashComposeCheck", "Launch from Protection for Compose-Note");
          KvHelper.composeCrashProtectForComposeNote(new double[0]);
          paramContext = new Intent(paramContext, ComposeNoteActivity.class);
        }
        int i;
        for (;;)
        {
          paramContext.putExtra("autologin", true);
          i = SharedPreferenceUtil.getCrashCountOfCompose() + 1;
          QMLog.log(4, "CrashComposeCheck", "Launch from Protection for " + i + " time");
          if (i < 3) {
            break;
          }
          SharedPreferenceUtil.setCrashCountOfCompose(0);
          return null;
          if (localComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK)
          {
            QMLog.log(4, "CrashComposeCheck", "Launch from Protection for Compose-Feedback");
            KvHelper.composeCrashProtectForFeedback(new double[0]);
            paramContext = new Intent(paramContext, ComposeFeedbackActivity.class);
          }
          else
          {
            QMLog.log(4, "CrashComposeCheck", "Launch from Protection for Compose-Mail");
            KvHelper.composeCrashProtectForComposeMail(new double[0]);
            paramContext = ComposeMailActivity.createIntentForCrashGuard(paramContext);
          }
        }
        SharedPreferenceUtil.setCrashCountOfCompose(i);
        return paramContext;
      }
    }
    SharedPreferenceUtil.setCrashCountOfCompose(0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.CrashComposeCheck
 * JD-Core Version:    0.7.0.1
 */