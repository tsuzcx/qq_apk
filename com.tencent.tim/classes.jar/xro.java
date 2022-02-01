import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.h;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class xro
{
  public static boolean bih = true;
  public static final int[] hB = { 2, 2131700636, 2130838293, 2131374781, 0 };
  public static final int[] hC = { 2, 2131700636, 2130838291, 2131374781, 0 };
  public static final int[] hD = { 2, 2131700636, 2130845727, 2131374780, 0 };
  public static final int[] hE = { 3, 2131700617, 2130838207, 2131374752, 2130838147, 2130850880, 2130850881 };
  public static final int[] hF = { 3, 2131700617, 2130838211, 2131374753, 0 };
  public static final int[] hG = { 3, 2131700617, 2130838209, 2131374753, 0 };
  public static final int[] hH = { 3, 2131700617, 2130845718, 2131374752, 0 };
  public static final int[] hI = { 3, 2131700617, 2130838207, 2131374752, 2130838147, 2130850880, 2130850881 };
  public static final int[] hJ = { 3, 2131700617, 2130838211, 2131374753, 0 };
  public static final int[] hK = { 3, 2131700617, 2130838209, 2131374753, 0 };
  public static final int[] hL = { 4, 2131700627, 2130838255, 2131374770, 2130838150, 2130850909, 2130850910 };
  public static final int[] hM = { 4, 2131700627, 2130838260, 2131374771, 0 };
  public static final int[] hN = { 4, 2131700627, 2130838257, 2131374771, 0 };
  public static final int[] hO = { 4, 2131700627, 2130845723, 2131374770, 0 };
  public static final int[] hP = { 4, 2131700627, 2130838255, 2131374770, 2130838150, 2130850909, 2130850910 };
  public static final int[] hQ = { 4, 2131700627, 2130838260, 2131374771, 0 };
  public static final int[] hR = { 4, 2131700627, 2130838257, 2131374771, 0 };
  public static final int[] hS = { 5, 2131700613, 2130838201, 2131374746, 0, 2130850860, 2130850861 };
  public static final int[] hT = { 5, 2131700613, 2130838205, 2131374747, 0 };
  public static final int[] hU = { 5, 2131700613, 2130838203, 2131374747, 0 };
  public static final int[] hV = { 6, 2131700637, 2130838296, 2131374783, 0, 2130850958, 2130850959 };
  public static final int[] hW = { 8, 2131700632, 2130838271, 2131374775, 2130838152, 2130850929, 2130850930 };
  public static final int[] hX = { 8, 2131700632, 2130838284, 2131374776, 0 };
  public static final int[] hz = { 2, 2131700636, 2130838289, 2131374780, 2130838153, 2130850952, 2130850953 };
  public static final int[] ia = { 8, 2131700632, 2130845725, 2131374775, 0 };
  public static final int[] ib = { 9, 2131700635, 2130838288, 2131374779, 0 };
  public static final int[] ic = { 9, 2131700635, 2130845717, 2131374779, 0 };
  public static final int[] id = { 10, 2131700622, 2130838224, 2131374762, 0, 2130850890, 2130850891 };
  public static final int[] ie = { 10, 2131700622, 2130845720, 2131374762, 0 };
  public static final int[] jdField_if = { 12, 2131700614, 2130838299, 2131374749, 0 };
  public static final int[] ig = { 13, 2131700615, 2130838296, 2131374750, 0 };
  public static final int[] ih = { 14, 2131700624, 2130838219, 2131374767, 0 };
  public static final int[] ii = { 14, 2131700624, 2130845719, 2131374767, 0 };
  public static final int[] ij = { 19, 2131700626, 2130838267, 2131374769, 0 };
  public static final int[] ik = { 19, 2131700626, 2130845724, 2131374769, 0 };
  public static final int[] il = { 16, 2131700620, 2130838216, 2131374759, 0 };
  public static final int[] im = { 17, 2131700629, 2130838264, 2131374773, 0 };
  public static int[] in = { 23, 2131700631, 2130838287, 2131374778, 0, 2130850935, 2130850936 };
  public static final int[] io = { 26, 2131700643, 2130838287, 2131374793, 0 };
  public static final int[] ip = { 24, 2131700623, 2130838225, 2131374763, 2130838149, 2130838251, 2130838253 };
  public static final int[] iq = { 24, 2131700623, 2130845717, 2131374763, 0 };
  public static final int[] ir = { 31, 2131700630, 2130838268, 2131374774, 0 };
  public static final int[] is = { 32, 2131700621, 2130838223, 2131374761, 0 };
  public static final int[] it = { 24, 2131700623, 2130838227, 2131374764, 0 };
  public static final int[] iu = { 24, 2131700623, 2130838226, 2131374764, 0 };
  public static final int[] iv = { 29, 2131696723, 2130850855, 2131374745, 0 };
  public static final int[] iw = { 29, 2131696723, 2130845716, 2131374745, 0 };
  public static final int[] ix = { 21, 2131690695, 2130838489, 2131374744, 0 };
  public static final int[] iy = { 21, 2131690695, 2130845714, 2131374744, 0 };
  public static final int[] iz = { 21, 2131690695, 2130838536, 2131374748, 0 };
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramBaseChatPie.mContext, 2131561200, null);
    Intent localIntent;
    if (!paramBoolean)
    {
      localIntent = paramIntent;
      if (paramIntent != null) {}
    }
    else
    {
      localIntent = new Intent();
    }
    String str = paramQQAppInterface.getAccount();
    Object localObject = ((acff)paramQQAppInterface.getManager(51)).e(str);
    paramIntent = "";
    if (localObject != null) {
      paramIntent = ((Friends)localObject).name;
    }
    localObject = paramQQAppInterface.getCustomFaceFilePath(1, str, 0);
    boolean bool = paramQQAppInterface.kp(paramBaseChatPie.sessionInfo.aTl);
    localIntent.putExtra("key_my_uin", str);
    localIntent.putExtra("key_my_nick", paramIntent);
    localIntent.putExtra("key_my_head_dir", (String)localObject);
    localIntent.putExtra("key_new_lbs_client", bool);
    localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramBaseChatPie.getCurType() == 9500) || (paramBaseChatPie.getCurType() == 9501)) {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramBaseChatPie.sessionInfo.cZ == 1) && (((HotChatManager)paramQQAppInterface.getManager(60)).kj(paramBaseChatPie.sessionInfo.aTl))) {
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", wmj.a(paramBaseChatPie.sessionInfo));
    if (paramBoolean)
    {
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("key_disable_edit_btn", true);
      localIntent.putExtra("key_disable_send_btn", true);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      localIntent.putExtra("custom_photopreview_sendbtn_report", true);
      localIntent.putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005978");
      localIntent.putExtra("custom_photopreview_sendbtn_album_reportReverse2", "1");
      paramIntent = (acms)paramQQAppInterface.getBusinessHandler(20);
      if ((!TextUtils.isEmpty(paramBaseChatPie.sessionInfo.aTl)) && (paramBaseChatPie.sessionInfo.cZ == 1))
      {
        paramIntent.bM(paramBaseChatPie.sessionInfo.aTl, true);
        localIntent.putExtra("showFlashPic", false);
      }
    }
    localPhotoListPanel.a(paramQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.sessionInfo, localIntent);
    paramQQAppInterface = new int[2];
    paramBaseChatPie.cL.getLocationInWindow(paramQQAppInterface);
    paramQQAppInterface[0] += paramBaseChatPie.cL.getWidth();
    paramQQAppInterface[1] -= paramLinearLayout.getHeight() + paramPanelIconLinearLayout.getHeight();
    localPhotoListPanel.setOnSwipeUpAndDragListener(new PhotoListPanel.h(paramBaseChatPie.mActivity, paramBaseChatPie.cL, paramQQAppInterface, paramBaseChatPie.getTitleBarHeight(), null, localPhotoListPanel));
    return localPhotoListPanel;
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto start");
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_presend_cancel_type", 1021);
    RichmediaService.dl((Bundle)localObject1);
    Object localObject2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = new Intent(paramActivity, SendPhotoActivity.class);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052));
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
    ((Intent)localObject2).putExtra("PhotoConst.VIDEO_INFOS", paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
    ((Intent)localObject2).putExtra("uin", paramSessionInfo.aTl);
    ((Intent)localObject2).putExtra("uintype", paramSessionInfo.cZ);
    ((Intent)localObject2).putExtra("troop_uin", paramSessionInfo.troopUin);
    ((Intent)localObject2).putExtra("key_confess_topicid", paramSessionInfo.topicId);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", i);
    ((Intent)localObject2).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject2).putExtra("entrance", paramSessionInfo.entrance);
    ((Intent)localObject2).putExtra("video_sync_to_story", paramIntent.getBooleanExtra("video_sync_to_story", false));
    if (((ArrayList)localObject1).size() == 1) {
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject1);
    }
    ((Intent)localObject2).addFlags(603979776);
    ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
    ((Intent)localObject2).putExtra("session_info", paramSessionInfo);
    String str1 = paramIntent.getStringExtra("widgetinfo");
    String str2 = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str1)) {
      ((Intent)localObject2).putExtra("widgetinfo", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      ((Intent)localObject2).putExtra("key_camera_material_name", str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto selectedPhotoList = " + ((ArrayList)localObject1).toString());
    }
    if (paramActivity.getIntent().getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007) == 1040)
    {
      if (paramSessionInfo.cZ != 0) {
        break label507;
      }
      anot.a(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramIntent.removeExtra("PhotoConst.CURRENT_QUALITY_TYPE");
      paramIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      paramActivity.startActivity((Intent)localObject2);
      return;
      label507:
      if (paramSessionInfo.cZ == 3000)
      {
        anot.a(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        anot.a(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.cZ == 1)
      {
        anot.a(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        anot.a(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
    wmj.a(paramQQAppInterface, paramFragmentActivity);
    paramFragmentActivity.setCanLock(false);
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString, int paramInt2)
  {
    altq localaltq = (altq)paramQQAppInterface.getManager(36);
    paramString = localaltq.a(paramInt1, paramString);
    if (paramString != null)
    {
      if (paramString.iNewFlag.get() == 1) {
        localaltq.d(paramString, "");
      }
    }
    else {
      return;
    }
    int i;
    label77:
    int j;
    label88:
    boolean bool;
    if ((paramSessionInfo.cZ == 0) || (ChatActivityUtils.q(paramQQAppInterface, paramSessionInfo.aTl)))
    {
      paramInt1 = 1;
      if (paramSessionInfo.cZ != 3000) {
        break label150;
      }
      i = 1;
      if (paramSessionInfo.cZ != 1) {
        break label156;
      }
      j = 1;
      bool = ChatActivityUtils.fY(paramSessionInfo.cZ);
      if (paramInt1 == 0) {
        break label162;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A46A", "0X800A46A", paramInt2, paramString.iNewFlag.get(), String.valueOf(paramInt1), "", "", "");
      return;
      paramInt1 = 0;
      break;
      label150:
      i = 0;
      break label77;
      label156:
      j = 0;
      break label88;
      label162:
      if (i != 0) {
        paramInt1 = 2;
      } else if (j != 0) {
        paramInt1 = 3;
      } else if (bool) {
        paramInt1 = 4;
      } else {
        paramInt1 = 5;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    if (((asgx)paramQQAppInterface.getManager(165)).sM(paramSessionInfo.aTl)) {
      anot.a(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.aTl, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((asgx)paramQQAppInterface.getManager(165)).sM(paramSessionInfo.aTl)) {
      anot.a(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.aTl, paramString1, paramString2, 0, 0, paramInt1 + "", paramInt2 + "", "", "");
    }
  }
  
  public static void aW(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "aio_pia");
        if ("0".equals(paramQQAppInterface)) {
          break label98;
        }
        bool = true;
        bih = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIO_Panel", 2, "getAIOPanelConfig = " + paramQQAppInterface + " isShowQwalletHbEntry = " + bih);
        return;
      }
      catch (Throwable paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOPanelUtiles", 2, paramQQAppInterface, new Object[0]);
      return;
      label98:
      boolean bool = false;
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 3000) {
        paramInt = 2;
      } else if (paramInt == 1) {
        paramInt = 3;
      } else if ((paramInt == 6000) || (paramInt == 6001) || (paramInt == 6002) || (paramInt == 1008) || (paramInt == 9500)) {
        paramInt = 5;
      } else {
        paramInt = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xro
 * JD-Core Version:    0.7.0.1
 */