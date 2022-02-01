import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.widget.ExtendButton;
import java.lang.ref.WeakReference;

public class arig
  extends ReportDialog
{
  private TextView mMsgTextView;
  
  public arig(Context paramContext, Intent paramIntent)
  {
    super(paramContext, 2131756470);
    String str2 = paramIntent.getStringExtra("qzone_plugin_activity_name");
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131562692, null);
    Object localObject2 = getWindow();
    ((Window)localObject2).setWindowAnimations(2131756465);
    ((Window)localObject2).setContentView((View)localObject1);
    Object localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -1;
    ((WindowManager.LayoutParams)localObject3).gravity = 48;
    ((WindowManager.LayoutParams)localObject3).y = ((WindowManager.LayoutParams)localObject3).y;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    setCanceledOnTouchOutside(false);
    this.mMsgTextView = ((TextView)((View)localObject1).findViewById(2131371994));
    localObject2 = paramIntent.getStringExtra("leftViewText");
    if (localObject2 == null) {
      localObject2 = paramContext.getString(2131691039);
    }
    for (;;)
    {
      if ("com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity".equals(str2))
      {
        localObject3 = ((ViewStub)((View)localObject1).findViewById(2131379130)).inflate();
        localObject1 = paramIntent.getStringExtra("key_left_tab_title");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label917;
        }
        localObject1 = paramContext.getString(2131717641);
      }
      label917:
      for (;;)
      {
        paramIntent = paramIntent.getStringExtra("key_rihgt_tab_title");
        if (TextUtils.isEmpty(paramIntent)) {}
        for (paramContext = paramContext.getString(2131717722);; paramContext = paramIntent)
        {
          paramIntent = (ExtendButton)((View)localObject3).findViewById(2131363803);
          Object localObject4 = (ExtendButton)((View)localObject3).findViewById(2131363804);
          paramIntent.setText((CharSequence)localObject1);
          ((ExtendButton)localObject4).setText(paramContext);
          ((ExtendButton)localObject4).setSelected(false);
          paramIntent.setSelected(true);
          paramContext = (Context)localObject3;
          ((TextView)paramContext.findViewById(2131369579)).setText((CharSequence)localObject2);
          ((ProgressBar)((ViewStub)paramContext.findViewById(2131369642)).inflate()).setVisibility(0);
          return;
          localObject4 = ((ViewStub)((View)localObject1).findViewById(2131365062)).inflate();
          TextView localTextView = (TextView)((ViewStub)((View)localObject4).findViewById(2131369627)).inflate();
          String str1 = "";
          long l;
          if ("com.qzone.homepage.ui.activity.QZoneUserHomeActivity".equals(str2))
          {
            l = paramIntent.getLongExtra("qqid", 0L);
            paramContext = paramIntent.getStringExtra("qzone_uin");
            if (String.valueOf(Long.valueOf(l)).equals(paramContext))
            {
              localObject1 = acfp.m(2131713287);
              localObject3 = localObject2;
            }
          }
          for (;;)
          {
            localTextView.setText((CharSequence)localObject1);
            paramContext = (Context)localObject4;
            localObject2 = localObject3;
            break;
            localObject1 = "";
            localObject3 = localObject2;
            continue;
            if ("com.qzone.feed.ui.activity.QZoneFriendFeedActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131717869);
              localObject3 = paramContext.getString(2131717792);
            }
            else if ("com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131717766);
              localObject3 = localObject2;
            }
            else if ("com.qzone.cover.ui.activity.QZoneCoverStoreActivity".equals(str2))
            {
              localObject1 = paramContext.getString(2131717767);
              localObject3 = localObject2;
            }
            else if ("com.qzone.detail.ui.activity.QzoneDetailActivity".equals(str2))
            {
              localObject1 = str1;
              localObject3 = localObject2;
              if (paramIntent.getBooleanExtra("qzone.sourceFrom", false))
              {
                localObject3 = paramContext.getString(2131701671);
                localObject1 = str1;
              }
            }
            else if ("com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity".equals(str2))
            {
              str1 = paramContext.getString(2131718249);
              int i = paramIntent.getIntExtra("QZoneUploadPhotoActivity.key_state_type_src", -1);
              paramIntent = paramIntent.getAction();
              localObject1 = str1;
              localObject3 = localObject2;
              if (!TextUtils.isEmpty(paramIntent))
              {
                if (paramIntent.equals("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN")) {
                  i = 5;
                }
                for (;;)
                {
                  switch (i)
                  {
                  case 9: 
                  case 10: 
                  default: 
                    localObject1 = str1;
                    localObject3 = localObject2;
                    break;
                  case 3: 
                  case 4: 
                  case 5: 
                  case 6: 
                  case 7: 
                  case 8: 
                  case 11: 
                    localObject1 = paramContext.getString(2131718161);
                    localObject3 = localObject2;
                    break;
                    if (paramIntent.equals("com.tencent.intent.QZONE_QUOTE_FROM_AIO")) {
                      i = 11;
                    }
                    break;
                  }
                }
              }
            }
            else if ("com.qzone.lbsv2.ui.QZoneMoodSelectLocation".equals(str2))
            {
              localObject1 = paramContext.getString(2131718188);
              localObject3 = localObject2;
            }
            else if ("com.qzone.setting.QZoneSettingManager".equals(str2))
            {
              localObject1 = paramContext.getString(2131718197);
              localObject3 = localObject2;
            }
            else if ("com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity".equals(str2))
            {
              l = paramIntent.getLongExtra("key_album_face_uin", 0L);
              paramContext = paramIntent.getStringExtra("key_alubm_name");
              paramIntent = paramIntent.getStringExtra("key_album_face_nickname");
              if ((Long.valueOf(l).longValue() != 0L) && (!TextUtils.isEmpty(paramIntent)))
              {
                localObject1 = paramIntent + acfp.m(2131713286);
                localObject3 = localObject2;
              }
              else
              {
                localObject1 = paramContext;
                localObject3 = localObject2;
                if (paramContext == null)
                {
                  localObject1 = "";
                  localObject3 = localObject2;
                }
              }
            }
            else if ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(str2))
            {
              localObject1 = paramIntent.getStringExtra("key_title");
              localObject3 = localObject2;
            }
            else if ("com.qzone.publish.ui.activity.QZonePublishQueueAcitvity".equals(str2))
            {
              localObject1 = paramContext.getString(2131718113);
              localObject3 = localObject2;
            }
            else
            {
              localObject1 = str1;
              localObject3 = localObject2;
              if ("com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity".equals(str2))
              {
                localObject1 = paramContext.getString(2131718002);
                localObject3 = localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setMessage(String paramString)
  {
    this.mMsgTextView.setText(paramString);
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramOnDismissListener == null) {
      super.setOnDismissListener(paramOnDismissListener);
    }
    super.setOnDismissListener(new arig.a(paramOnDismissListener));
  }
  
  static class a
    implements DialogInterface.OnDismissListener
  {
    private WeakReference<DialogInterface.OnDismissListener> iI;
    
    public a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.iI = new WeakReference(paramOnDismissListener);
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if (this.iI == null) {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneProgressDialog", 2, "CustomDismissListener mDismissLis, lis is null");
        }
      }
      do
      {
        return;
        DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.iI.get();
        if (localOnDismissListener != null)
        {
          localOnDismissListener.onDismiss(paramDialogInterface);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QzoneProgressDialog", 2, "CustomDismissListener, lis is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arig
 * JD-Core Version:    0.7.0.1
 */