import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.a;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.1;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.2;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.4;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.TDFileQIPCModule.1;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;
import eipc.EIPCResult;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.oidb.cmd0x857.TroopTips0x857.TroopFormGrayTipsInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class aobw
{
  private static String TAG = "TeamWorkUtils";
  public static long aoS;
  public static String cjR = ".doc|.docx|.xls|.xlsx|";
  public static String cjS;
  public static String cjT;
  public static String cjU;
  public static final String cjV;
  public static final String cjW = acfp.m(2131715199);
  private static volatile int cyv = -2147483648;
  public static final SparseArray<Pair<Integer, String>> du;
  public static final SparseArray<Pair<Integer, String>> dv;
  private static long lastClickTime;
  public static final HashMap<String, String> nK;
  public static final Map<Integer, String> ns;
  public static final Map<String, Integer> nt;
  public static final String sV;
  public static final String sW;
  
  static
  {
    aoS = 101458937L;
    cjS = "https://docs.qq.com/desktop/m/index.html?_wv=2";
    cjT = "docs.qq.com/desktop/m";
    cjU = "https://docs.qq.com/desktop/favicon.ico";
    ns = new HashMap();
    ns.put(Integer.valueOf(9), "s_qq_mini_importing");
    ns.put(Integer.valueOf(12), "s_qq_url_2_doc");
    nK = new HashMap();
    nK.put("s_qq_aiomsg", "docs_miniapp_config_aio_msg");
    nK.put("s_qq_myfile", "docs_miniapp_config_my_file");
    nK.put("s_qq_myfile_yindao", "docs_miniapp_config_my_file");
    nK.put("s_qq_myfile_banner", "docs_miniapp_config_my_file");
    nK.put("s_qq_myfile_menu_create", "docs_miniapp_config_templatelist");
    nK.put("s_qq_grpfile", "docs_miniapp_config_troop_file");
    nK.put("s_qq_aio_grey", "docs_miniapp_config_gray_bar");
    nK.put("s_qq_aio_edit", "docs_miniapp_config_aio_edit");
    nK.put("s_qq_file_edit", "docs_miniapp_config_bottom_edit");
    nK.put("s_QQ_file_share_edit", "docs_miniapp_config_menu_edit");
    nK.put("s_qq_file_preview", "docs_miniapp_config_online_preview");
    nK.put("s_qq_ocr_save", "docs_miniapp_config_ocr_save");
    nK.put("s_qq_url_2_doc", "docs_miniapp_config_url_2_doc");
    nK.put("s_qq_mini_importing", "s_qq_mini_importing");
    nK.put("s_qq_aio_ark_h5", "docs_miniapp_config_aio_ark_h5");
    nt = new HashMap();
    du = new SparseArray();
    dv = new SparseArray();
    nt.put("docx", Integer.valueOf(1));
    nt.put("sheet", Integer.valueOf(2));
    nt.put("form", Integer.valueOf(3));
    nt.put("slide", Integer.valueOf(4));
    nt.put("pdf", Integer.valueOf(5));
    du.put(1, new Pair(Integer.valueOf(2130850714), "static://DefaultTeamWorkMiniShareDoc"));
    du.put(2, new Pair(Integer.valueOf(2130850722), "static://DefaultTeamWorkMiniShareSheet"));
    du.put(3, new Pair(Integer.valueOf(2130850717), "static://DefaultTeamWorkMiniShareForm"));
    du.put(4, new Pair(Integer.valueOf(2130850724), "static://DefaultTeamWorkMiniShareSlide"));
    du.put(5, new Pair(Integer.valueOf(2130850719), "static://DefaultTeamWorkMiniSharePdf"));
    dv.put(1, new Pair(Integer.valueOf(2130850713), "static://DefaultTeamWorkH5ShareDoc"));
    dv.put(2, new Pair(Integer.valueOf(2130850721), "static://DefaultTeamWorkH5ShareSheet"));
    dv.put(3, new Pair(Integer.valueOf(2130850716), "static://DefaultTeamWorkH5ShareForm"));
    dv.put(4, new Pair(Integer.valueOf(2130850723), "static://DefaultTeamWorkH5ShareSlide"));
    dv.put(5, new Pair(Integer.valueOf(2130850718), "static://DefaultTeamWorkH5SharePdf"));
    cjV = acfp.m(2131715143);
    sV = acfp.m(2131715173);
    sW = acfp.m(2131715158);
  }
  
  public static Bitmap J(String paramString)
  {
    Object localObject2 = null;
    try
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.e(TAG, 2, "getTeamWorkForWXMiniProShareBitMap mMiniProgramImageUrl = " + paramString);
      }
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = localObject2;
        if (pQ(paramString)) {
          localObject1 = K(paramString);
        }
      }
      return localObject1;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public static Bitmap K(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      if (Build.VERSION.SDK_INT > 19) {}
      for (localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;; localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444)
      {
        paramString = Base64.decode(paramString.split(",")[1], 0);
        return BitmapFactory.decodeByteArray(paramString, 0, paramString.length, localOptions);
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d(TAG, 2, "Texture: cannot decode base64: " + com.tencent.qphone.base.util.QLog.getStackTraceString(paramString));
      }
    }
  }
  
  public static void RJ(String paramString)
  {
    hC(paramString, null);
  }
  
  public static void V(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aqmj.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "tencent_docs_config_enable_assistant", paramBoolean);
    paramQQAppInterface = (aobh)paramQQAppInterface.getBusinessHandler(122);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.cLc = paramBoolean;
    }
  }
  
  public static void W(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aqmj.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "tencent_docs_config_preload_tool_process", paramBoolean);
    paramQQAppInterface = (aobh)paramQQAppInterface.getBusinessHandler(122);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.aeg = paramBoolean;
    }
  }
  
  private static Bitmap a(SparseArray<Pair<Integer, String>> paramSparseArray, int paramInt1, String paramString, int paramInt2)
  {
    int i = paramInt1;
    String str = paramString;
    if (paramSparseArray != null)
    {
      paramSparseArray = (Pair)paramSparseArray.get(paramInt2);
      i = paramInt1;
      str = paramString;
      if (paramSparseArray != null)
      {
        str = (String)paramSparseArray.second;
        i = ((Integer)paramSparseArray.first).intValue();
      }
    }
    if (BaseApplicationImpl.sImageCache != null) {}
    for (paramSparseArray = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; paramSparseArray = null)
    {
      paramString = paramSparseArray;
      if (paramSparseArray == null)
      {
        paramSparseArray = aqcu.f(BaseApplicationImpl.getApplication().getResources(), i);
        paramString = paramSparseArray;
        if (paramSparseArray != null)
        {
          paramString = paramSparseArray;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(str, paramSparseArray);
            paramString = paramSparseArray;
          }
        }
      }
      return paramString;
    }
  }
  
  public static DocsGrayTipsInfo a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.qphone.base.util.QLog.d(TAG + aoaf.cjv, 2, " gray tips jason null");
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        localDocsGrayTipsInfo = new DocsGrayTipsInfo();
        try
        {
          localDocsGrayTipsInfo.uin = paramString2;
          localDocsGrayTipsInfo.url = paramString3;
          paramString2 = new JSONObject(paramString1);
          if (paramString2.has("type")) {
            localDocsGrayTipsInfo.type = paramString2.getString("type");
          }
          if (paramString2.has("optType")) {
            localDocsGrayTipsInfo.ciL = paramString2.getString("optType");
          }
          if (paramString2.has("authTips")) {
            localDocsGrayTipsInfo.ciM = paramString2.getString("authTips");
          }
          if (paramString2.has("highlightText")) {
            localDocsGrayTipsInfo.highlightText = paramString2.getString("highlightText");
          }
          if (paramString2.has("setpolicy")) {
            localDocsGrayTipsInfo.ciO = paramString2.getString("setpolicy");
          }
          if (paramString2.has("setflag")) {
            localDocsGrayTipsInfo.ciN = paramString2.getString("setflag");
          }
          if (paramString2.has("setonly")) {
            localDocsGrayTipsInfo.ciP = paramString2.getString("setonly");
          }
          if (paramString2.has("sucResult")) {
            localDocsGrayTipsInfo.ciQ = paramString2.getString("sucResult");
          }
          if (paramString2.has("failResult")) {
            localDocsGrayTipsInfo.ciR = paramString2.getString("failResult");
          }
          if (paramString2.has("netFailResult")) {
            localDocsGrayTipsInfo.ciS = paramString2.getString("netFailResult");
          }
          if (paramString2.has("policy")) {
            localDocsGrayTipsInfo.ciT = paramString2.getString("policy");
          }
          if (paramString2.has("privilege")) {
            localDocsGrayTipsInfo.ciU = paramString2.getString("privilege");
          }
          if (paramString2.has("member_number")) {
            localDocsGrayTipsInfo.ciV = paramString2.getString("member_number");
          }
          if (paramString2.has("exp_remain_time")) {
            localDocsGrayTipsInfo.ciW = paramString2.getString("exp_remain_time");
          }
          if (paramString2.has("exp_set_time")) {
            localDocsGrayTipsInfo.ciX = paramString2.getString("exp_set_time");
          }
          if (paramString2.has("bNeedSetTime")) {
            localDocsGrayTipsInfo.ciY = paramString2.getString("bNeedSetTime");
          }
          if (paramString2.has("tiptype")) {
            localDocsGrayTipsInfo.ciZ = paramString2.getString("tiptype");
          }
          paramString1 = localDocsGrayTipsInfo;
          if (paramString2.has("tipurl"))
          {
            localDocsGrayTipsInfo.cja = paramString2.getString("tipurl");
            return localDocsGrayTipsInfo;
          }
        }
        catch (Exception paramString1) {}
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          DocsGrayTipsInfo localDocsGrayTipsInfo = null;
        }
      }
    }
    com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, " paseDocsGrayTipsInfoFromJson e =" + paramString1.toString());
    return localDocsGrayTipsInfo;
  }
  
  public static TeamWorkFileImportInfo a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    Object localObject;
    if (paramFileManagerEntity == null) {
      localObject = null;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return localObject;
        localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        localTeamWorkFileImportInfo.isUserClick = false;
        localTeamWorkFileImportInfo.fileName = paramFileManagerEntity.fileName;
        localTeamWorkFileImportInfo.fileSize = paramFileManagerEntity.fileSize;
        localTeamWorkFileImportInfo.filePath = paramFileManagerEntity.getFilePath();
        localTeamWorkFileImportInfo.nFileType = paramFileManagerEntity.nFileType;
        localTeamWorkFileImportInfo.isFromAIO = paramBoolean;
        localTeamWorkFileImportInfo.WeiYunFileId = paramFileManagerEntity.WeiYunFileId;
        localTeamWorkFileImportInfo.Uuid = paramFileManagerEntity.Uuid;
        localTeamWorkFileImportInfo.bSend = paramFileManagerEntity.bSend;
        localObject = localTeamWorkFileImportInfo;
      } while (TextUtils.isEmpty(paramFileManagerEntity.peerUin));
      localTeamWorkFileImportInfo.peerType = paramFileManagerEntity.peerType;
      localTeamWorkFileImportInfo.peerUin = paramFileManagerEntity.peerUin;
      localTeamWorkFileImportInfo.troopUin = String.valueOf(paramFileManagerEntity.TroopUin);
      localTeamWorkFileImportInfo.dNP = paramFileManagerEntity.busId;
      localTeamWorkFileImportInfo.cjE = paramFileManagerEntity.strTroopFilePath;
      localTeamWorkFileImportInfo.msgUniseq = paramFileManagerEntity.uniseq;
      localObject = localTeamWorkFileImportInfo;
    } while (paramFileManagerEntity.status == 16);
    localTeamWorkFileImportInfo.cKX = true;
    return localTeamWorkFileImportInfo;
  }
  
  public static online_docs.DocId a(long paramLong, String paramString)
  {
    online_docs.DocId localDocId = new online_docs.DocId();
    localDocId.pad_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDocId.domain_id.set(paramLong);
    return localDocId;
  }
  
  public static void a(Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.bombData == null))
    {
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "forwardRecentFileRecord. tencentDoc data is null");
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      Object localObject = new JSONObject(new String(paramFileManagerEntity.bombData));
      paramFileManagerEntity = new Bundle();
      paramFileManagerEntity.putInt("forward_type", -3);
      paramFileManagerEntity.putInt("structmsg_service_id", ((JSONObject)localObject).getInt("structmsg_service_id"));
      paramFileManagerEntity.putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject).getString("stuctmsg_bytes"), 0));
      paramFileManagerEntity.putLong("structmsg_uniseq", ((JSONObject)localObject).getLong("structmsg_uniseq"));
      paramFileManagerEntity.putInt("accostType", ((JSONObject)localObject).getInt("accostType"));
      paramFileManagerEntity.putBoolean("forwardDirect", true);
      localObject = new Intent();
      ((Intent)localObject).putExtra("forward_type", -3);
      ((Intent)localObject).putExtras(paramFileManagerEntity);
      localIntent.putExtra("forwardDirect", true);
      ahgq.f(paramActivity, (Intent)localObject, 103);
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(TextView paramTextView, View.OnClickListener paramOnClickListener)
  {
    if (paramTextView == null) {
      return;
    }
    Object localObject2 = aeti.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new aeth();
    }
    localObject2 = ((aeth)localObject1).getTips();
    String str = ((aeth)localObject1).tM();
    if (TextUtils.isEmpty(str))
    {
      paramTextView.setText((CharSequence)localObject2);
      return;
    }
    int k = ((String)localObject2).indexOf(str);
    if (k < 0)
    {
      paramTextView.setText(((aeth)localObject1).getTips());
      return;
    }
    int j = str.length() + k;
    int i = j;
    if (j > ((String)localObject2).length()) {
      i = ((String)localObject2).length();
    }
    j = Color.parseColor("#4D94FF");
    int m = Color.parseColor("#804D94FF");
    localObject1 = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { m, j });
    localObject2 = new SpannableString((CharSequence)localObject2);
    ((SpannableString)localObject2).setSpan(new DatingCommentTextView.a(paramOnClickListener, (ColorStateList)localObject1), k, i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject2);
    paramTextView.setFocusable(false);
    paramTextView.setClickable(false);
    paramTextView.setLongClickable(false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    int i = 2;
    String str1 = "";
    String str2 = String.valueOf(paramLong1);
    if (paramInt == 1)
    {
      str1 = "https://docs.qq.com/mall/m/index/doc?padtype=0&_wv=2&_wwv=512&group_code=" + str2 + "&group_type=" + paramLong2 + "&create_from=" + paramString;
      if (paramInt != 1) {
        break label276;
      }
      i = 1;
    }
    for (;;)
    {
      label72:
      str1 = bE(str1, "s_tim_grpfile");
      paramString = new Bundle();
      paramString.putString("url", str1);
      paramString.putString("title", paramActivity.getString(2131720937));
      paramString.putInt("key_team_work_edit_type", i);
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(String.valueOf(paramLong1));
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopname))) {
        paramString.putString("troop_name", paramQQAppInterface.troopname);
      }
      for (;;)
      {
        TeamWorkDocEditBrowserActivity.a(paramActivity, paramString, true);
        return;
        if (paramInt == 2)
        {
          str1 = "https://docs.qq.com/mall/m/index/sheet?padtype=1&_wv=2&_wwv=512&group_code=" + str2 + "&group_type=" + paramLong2 + "&create_from=" + paramString;
          break;
        }
        if (paramInt != 3) {
          break;
        }
        str1 = "https://docs.qq.com/mall/m/index/form/collect?padtype=2&_wv=2&_wwv=512&group_code=" + str2 + "&group_type=" + paramLong2 + "&create_from=" + paramString;
        break;
        label276:
        if (paramInt == 2) {
          break label72;
        }
        if (paramInt != 3) {
          break label323;
        }
        i = 3;
        break label72;
        paramString.putString("troop_name", "" + paramLong1);
      }
      label323:
      i = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    String str = ahbr.a(paramQQAppInterface, paramLong1, paramLong3);
    if (!TextUtils.isEmpty(str))
    {
      QQToast.a(paramActivity, str, 0).show();
      return;
    }
    a(paramQQAppInterface, paramActivity, paramInt, paramString, paramLong1, paramLong2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, TencentDocData paramTencentDocData, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject1 = aeue.a();
    if (localObject1 != null) {}
    for (boolean bool = ((aeud)localObject1).lJ(paramTeamWorkFileImportInfo.fileName);; bool = false)
    {
      int i;
      Intent localIntent;
      if (((paramTeamWorkFileImportInfo.peerType == 1) || (paramTeamWorkFileImportInfo.peerType == 0) || (paramTeamWorkFileImportInfo.peerType == 3000)) && (TextUtils.isEmpty(paramTeamWorkFileImportInfo.WeiYunFileId)))
      {
        i = 1;
        localIntent = new Intent();
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("k_forward_show_direct_share_tips", true);
        localIntent.putExtra("forward_type", 1001);
        localIntent.putExtra("req_type", 95);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("image_url_remote", paramTencentDocData.docIcon);
        Object localObject2 = new StringBuilder().append(paramQQAppInterface.getCurrentNickname()).append(acfp.m(2131715172));
        if (!bool) {
          break label618;
        }
        localObject1 = acfp.m(2131715163);
        label174:
        localObject2 = (String)localObject1 + "《" + paramTencentDocData.title + "》";
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 45) {
            localObject1 = ((String)localObject2).substring(0, 45) + "…";
          }
        }
        localIntent.putExtra("title", (String)localObject1);
        localObject1 = paramTencentDocData.summary;
        if ((localObject1 == null) || (((String)localObject1).length() <= 60)) {
          break label675;
        }
        localObject1 = ((String)localObject1).substring(0, 60) + "…";
      }
      label647:
      label658:
      label668:
      label675:
      for (;;)
      {
        localIntent.putExtra("desc", (String)localObject1);
        localIntent.putExtra("detail_url", paramTencentDocData.docUrl);
        localIntent.putExtra("struct_share_key_content_action", "web");
        localIntent.putExtra("struct_share_key_source_action", "web");
        localIntent.putExtra("struct_share_key_source_icon", cjU);
        localIntent.putExtra("app_name", paramActivity.getString(2131720970));
        localIntent.putExtra("source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2097154");
        localIntent.putExtra("forward _key_nojump", true);
        paramTencentDocData = anre.a(localIntent.getExtras());
        if (paramTencentDocData != null)
        {
          localIntent.putExtra("stuctmsg_bytes", paramTencentDocData.getBytes());
          if (i != 0)
          {
            localIntent.putExtra("uintype", paramTeamWorkFileImportInfo.peerType);
            localIntent.putExtra("uin", paramTeamWorkFileImportInfo.peerUin);
            localIntent.putExtra("troop_uin", paramTeamWorkFileImportInfo.peerUin);
            localIntent.putExtra("uinname", aqgv.d(paramQQAppInterface, paramTeamWorkFileImportInfo.peerUin, paramTeamWorkFileImportInfo.peerType));
          }
          paramQQAppInterface = new StringBuilder(acfp.m(2131715136));
          if ((paramTeamWorkFileImportInfo.peerType != 1) && (paramTeamWorkFileImportInfo.peerType != 3000)) {
            break label629;
          }
          paramQQAppInterface.append("群成员");
          label547:
          if (!bool) {
            break label647;
          }
          paramQQAppInterface.append("一起编辑文档：");
          label560:
          localIntent.putExtra("key_send_tips", paramQQAppInterface.toString());
          if (i != 0) {
            break label658;
          }
          aodb.aN(null, "0X800A5A1");
          label585:
          if (i == 0) {
            break label668;
          }
        }
        for (paramQQAppInterface = DirectForwardActivity.class;; paramQQAppInterface = ForwardRecentActivity.class)
        {
          localIntent.setClass(paramActivity, paramQQAppInterface);
          paramActivity.startActivityForResult(localIntent, 2864);
          return;
          i = 0;
          break;
          label618:
          localObject1 = acfp.m(2131715176);
          break label174;
          label629:
          if (paramTeamWorkFileImportInfo.peerType != 0) {
            break label547;
          }
          paramQQAppInterface.append("好友");
          break label547;
          paramQQAppInterface.append("一起查看文档：");
          break label560;
          aodb.aN(null, "0X800A5A2");
          break label585;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, long paramLong, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    String str2 = "";
    String str1 = "";
    int k;
    int j;
    if (paramGroupPadTemplateInfo != null)
    {
      k = paramGroupPadTemplateInfo.docOrSheetType;
      j = paramGroupPadTemplateInfo.templateID;
      str2 = String.valueOf(paramGroupPadTemplateInfo.groupCode);
    }
    for (paramGroupPadTemplateInfo = paramGroupPadTemplateInfo.templateUrl;; paramGroupPadTemplateInfo = str1)
    {
      int i;
      if (!TextUtils.isEmpty(paramGroupPadTemplateInfo))
      {
        str1 = "https:" + paramGroupPadTemplateInfo;
        if (aurr.isValidUrl(str1)) {
          break label522;
        }
        i = 1;
      }
      for (;;)
      {
        paramGroupPadTemplateInfo = str1;
        if (i != 0)
        {
          if (k == 1)
          {
            paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=doc&tid=%s&pdid=null", new Object[] { Integer.valueOf(j) });
            paramGroupPadTemplateInfo = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + paramGroupPadTemplateInfo + "&group_code=" + str2;
          }
        }
        else
        {
          label170:
          if ((TextUtils.isEmpty(paramString)) || (paramLong == -1L) || (TextUtils.isEmpty(paramGroupPadTemplateInfo))) {
            break label516;
          }
          if (!paramGroupPadTemplateInfo.contains("?")) {
            break label427;
          }
          paramString = paramGroupPadTemplateInfo + "&group_type=" + paramLong + "&create_from=" + paramString;
        }
        for (;;)
        {
          label240:
          if (k == 1) {
            i = 1;
          }
          for (;;)
          {
            label249:
            paramGroupPadTemplateInfo = new Bundle();
            paramGroupPadTemplateInfo.putString("tdsourcetag", "s_qq_grpfile");
            paramGroupPadTemplateInfo.putString("url", paramString);
            paramGroupPadTemplateInfo.putInt("key_team_work_edit_type", i);
            paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(str2);
            if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopname))) {
              paramGroupPadTemplateInfo.putString("troop_name", paramQQAppInterface.troopname);
            }
            for (;;)
            {
              TeamWorkDocEditBrowserActivity.a(paramActivity, paramGroupPadTemplateInfo, true);
              return;
              str1 = "";
              i = 1;
              break;
              paramGroupPadTemplateInfo = str1;
              if (k != 2) {
                break label170;
              }
              paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=sheet&tid=%s&pdid=null", new Object[] { Integer.valueOf(j) });
              paramGroupPadTemplateInfo = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + paramGroupPadTemplateInfo + "&group_code=" + str2;
              break label170;
              label427:
              paramString = paramGroupPadTemplateInfo + "?group_type=" + paramLong + "&create_from=" + paramString;
              break label240;
              if (k != 2) {
                break label510;
              }
              i = 2;
              break label249;
              paramGroupPadTemplateInfo.putString("troop_name", "" + str2);
            }
            label510:
            i = 1;
          }
          label516:
          paramString = paramGroupPadTemplateInfo;
        }
        label522:
        i = 0;
      }
      j = 0;
      k = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    paramTeamWorkFileImportInfo.dNQ = 7;
    aoag.a(paramQQAppInterface, paramContext, paramString, paramTeamWorkFileImportInfo, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramQQAppInterface.getApp().getString(2131720940).equals(str))
      {
        paramContext = paramQQAppInterface.b().a(localDocsGrayTipsInfo.uin, 0, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.xg != null)) {
            paramArrayOfObject.tipParam.xg.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      for (;;)
      {
        com.tencent.qphone.base.util.QLog.i(aoaf.cjv, 2, " onGetUserAuth  isSuccess = " + paramBoolean + " tips =" + str);
        return;
        QQToast.a(paramContext, str, 0).show();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(aoaf.cjv, 2, " onGetUserAuth  exception = " + paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("type", nX(paramFileManagerEntity.Uuid));
      localIntent.putExtra("miniprogram_image_url", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("key_flag_from_plugin", false);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_type", 95);
      localIntent.putExtra("detail_url", paramFileManagerEntity.Uuid);
      localIntent.putExtra("image_url_remote", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("req_share_id", aoS);
      localIntent.putExtra("source_url", cjS);
      localIntent.putExtra("app_name", acfp.m(2131715181));
      localIntent.putExtra("struct_share_key_source_icon", cjU);
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("pubUin", "");
      localIntent.putExtra("struct_uin", "");
      localObject2 = paramFileManagerEntity.fileName;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 45) {
          localObject1 = ((String)localObject2).substring(0, 45) + "…";
        }
      }
      String str = acfp.m(2131715204);
      localIntent.putExtra("title", (String)localObject1);
      localObject2 = str;
      if (str != null)
      {
        localObject2 = str;
        if (str.length() > 60) {
          localObject2 = str.substring(0, 60) + "…";
        }
      }
      localIntent.putExtra("desc", (String)localObject2);
      localIntent.putExtra("forward_thumb", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("struct_share_key_content_action", "web");
      localIntent.putExtra("req_share_id", -1L);
      localIntent.putExtra("brief_key", BaseApplicationImpl.sApplication.getString(2131698632, new Object[] { localObject1 }));
      localIntent.putExtra("to_uin", paramString);
      localIntent.putExtra("uin_type", paramInt);
      localObject2 = localIntent.getExtras();
      paramFileManagerEntity = anre.a((Bundle)localObject2);
      paramInt = ((Bundle)localObject2).getInt("uin_type");
      paramString = ((Bundle)localObject2).getString("to_uin");
      localObject1 = ((Bundle)localObject2).getString("docs_gray_tips_info_json");
      localObject2 = ((Bundle)localObject2).getString("detail_url");
    } while (paramFileManagerEntity == null);
    paramFileManagerEntity.mExtraData = "aioPlusPanelTencentDoc";
    aqmf.a(paramQQAppInterface, paramString, paramInt, paramFileManagerEntity, null, (String)localObject1, (String)localObject2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    DocsGrayTipsInfo localDocsGrayTipsInfo = a(paramString2, paramString1, paramString3);
    if (localDocsGrayTipsInfo != null)
    {
      com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, "addTeamWorkGrayTips. docsGrayTipsInfo = " + localDocsGrayTipsInfo.toString());
      int i;
      label258:
      ahwa localahwa;
      if ((!TextUtils.isEmpty(localDocsGrayTipsInfo.type)) && (Integer.valueOf(localDocsGrayTipsInfo.type).intValue() == 1))
      {
        if (paramInt == 1)
        {
          i = aeuq.a().CB();
          com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, "addTeamWorkGrayTips. groupFlag = " + i);
          if (i == 0) {}
          int j;
          do
          {
            return;
            i = aqmj.bv(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()) + 1;
            j = aeuq.a().CA();
            com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, "addTeamWorkGrayTips. groupShowedCount = " + i + ", groupShowCount = " + j);
          } while (i > j);
          aqmj.aG(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
        }
      }
      else
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
        if (paramInt != 1) {
          break label631;
        }
        localahwa = new ahwa(paramString1, paramQQAppInterface.getCurrentAccountUin(), localDocsGrayTipsInfo.ciM, 1, -5020, 3276802, paramLong2);
        localMessageForUniteGrayTip.shmsgseq = (1L + paramLong1);
        label308:
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 33);
        localBundle.putString("textColor", "#1e6fff");
        localBundle.putString("key_action_DATA", paramString2 + "@#@" + String.valueOf(localMessageForUniteGrayTip.uniseq));
        localBundle.putString("key_a_action_DATA", paramString3);
        localBundle.putString("troop_mem_uin", paramString1);
        paramString1 = localDocsGrayTipsInfo.ab();
        localahwa.addHightlightItem(paramString1[0], paramString1[1], localBundle);
        localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localahwa);
        ahwb.a(paramQQAppInterface, localMessageForUniteGrayTip);
        if (!"1".equals(localDocsGrayTipsInfo.ciL)) {
          break label667;
        }
        if (paramInt != 1) {
          break label662;
        }
        paramInt = 1;
        label452:
        anot.a(null, "CliOper", "", "", "0X80095F2", "0X80095F2", paramInt, 0, "", "", "", "");
      }
      label662:
      label667:
      for (;;)
      {
        label485:
        if (localDocsGrayTipsInfo.ciZ.equals(aoaf.cjx))
        {
          anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009C78", "0X8009C78", 0, 0, "", "", "", "");
          return;
          if (aeuq.a().getFlag() == 0) {
            break;
          }
          i = aqmj.bu(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()) + 1;
          if (i > aeuq.a().Cr()) {
            break;
          }
          aqmj.aF(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
          com.tencent.qphone.base.util.QLog.d(TAG + aoaf.cjv, 2, "yunying gray tip showed count = " + i);
          break label258;
          label631:
          localahwa = new ahwa(paramString1, paramQQAppInterface.getCurrentAccountUin(), localDocsGrayTipsInfo.ciM, 0, -5020, 3276802, paramLong2);
          break label308;
          paramInt = 0;
          break label452;
          if ("2".equals(localDocsGrayTipsInfo.ciL)) {
            if (paramInt != 1) {
              break label724;
            }
          }
        }
      }
      label724:
      for (paramInt = 1;; paramInt = 0)
      {
        anot.a(null, "CliOper", "", "", "0X80095F1", "0X80095F1", paramInt, 0, "", "", "", "");
        break label485;
        break;
      }
    }
    com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, "addTeamWorkGrayTips. docsGrayTipsInfo is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopTips0x857.TroopFormGrayTipsInfo paramTroopFormGrayTipsInfo, String paramString)
  {
    if (paramTroopFormGrayTipsInfo != null)
    {
      com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, "troopFormLog insertTroopFormGrayTips troop = " + paramTroopFormGrayTipsInfo.toString());
      String str1 = paramQQAppInterface.getApp().getString(2131721353);
      String str2 = paramTroopFormGrayTipsInfo.bytes_opt_bytes_url.get().toStringUtf8();
      String str3 = paramTroopFormGrayTipsInfo.uint64_writer_uin.get() + "";
      String str4 = paramTroopFormGrayTipsInfo.uint64_creator_uin.get() + "";
      String str5 = paramTroopFormGrayTipsInfo.bytes_rich_content.get().toStringUtf8();
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips url = " + str2);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips writerUin = " + str3);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creatorUin = " + str4);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips context = " + str5);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creator_nick = " + paramTroopFormGrayTipsInfo.bytes_creator_nick.get().toStringUtf8());
      paramTroopFormGrayTipsInfo = paramQQAppInterface.getCurrentUin();
      if ((TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(paramTroopFormGrayTipsInfo)) || ((!paramTroopFormGrayTipsInfo.equals(str3)) && (!paramTroopFormGrayTipsInfo.equals(str4)))) {}
      int i;
      do
      {
        do
        {
          return;
          paramTroopFormGrayTipsInfo = g(paramQQAppInterface, str5, paramString);
          com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips tips = " + paramTroopFormGrayTipsInfo);
          com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips troopUin = " + paramString);
        } while (TextUtils.isEmpty(paramTroopFormGrayTipsInfo));
        i = paramTroopFormGrayTipsInfo.indexOf(str1);
      } while (i == -1);
      new Thread(new TeamWorkUtils.1(paramString, paramTroopFormGrayTipsInfo, paramQQAppInterface, str2, i, str1)).start();
      return;
    }
    com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, "troopFormLog insertTroopFormGrayTips Info is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x119.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, "troopFormLog insertTroopFormGrayTips c2c = " + paramMsgBody.toString());
      String str1 = paramQQAppInterface.getApp().getString(2131721353);
      String str2 = paramMsgBody.bytes_opt_bytes_url.get().toStringUtf8();
      String str3 = paramMsgBody.uint64_writer_uin.get() + "";
      String str4 = paramMsgBody.uint64_creator_uin.get() + "";
      String str5 = paramMsgBody.bytes_rich_content.get().toStringUtf8();
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips url = " + str2);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips writerUin = " + str3);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creatorUin = " + str4);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips context = " + str5);
      com.tencent.qphone.base.util.QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creator_nick = " + paramMsgBody.bytes_creator_nick.get().toStringUtf8());
      paramMsgBody = paramQQAppInterface.getCurrentUin();
      if ((TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(paramMsgBody)) || ((!paramMsgBody.equals(str3)) && (!paramMsgBody.equals(str4)))) {}
      int i;
      do
      {
        do
        {
          return;
          str5 = g(paramQQAppInterface, str5, "");
        } while (TextUtils.isEmpty(str5));
        i = str5.indexOf(str1);
      } while (i == -1);
      new Thread(new TeamWorkUtils.2(paramMsgBody, str3, str4, paramQQAppInterface, str5, str2, i, str1)).start();
      return;
    }
    com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, "troopFormLog insertTroopFormGrayTipsInfo is null.");
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, String paramString2)
  {
    if ((paramTeamWorkFileImportInfo == null) || (!paramTeamWorkFileImportInfo.azu())) {}
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str1 = paramTeamWorkFileImportInfo.traceId;
    String str2 = nR(paramTeamWorkFileImportInfo.fileName);
    long l = paramTeamWorkFileImportInfo.fileSize;
    if ((paramString1 != null) && (paramString1.contains("m_readonly"))) {}
    for (boolean bool = true;; bool = false)
    {
      aodb.b(null, str1, paramString2, str2, String.valueOf(bool), String.valueOf(l));
      return;
    }
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = aobh.f(paramString, paramQQAppInterface.getCurrentAccountUin());
        if (paramString.getInt("retcode") == 0)
        {
          paramString = (String)((JSONObject)paramString.get("doc_meta")).get("title");
          if (!paramFileManagerEntity.fileName.equals(paramString))
          {
            paramFileManagerEntity.fileName = paramString;
            paramQQAppInterface.a().u(paramFileManagerEntity);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      paramQQAppInterface.getCurrentAccountUin();
      str1 = aetk.a().tN();
      if (str1 != null) {
        break label352;
      }
      str1 = "https://docs.qq.com/desktop/m/send.html";
    }
    catch (Exception paramQQAppInterface)
    {
      label352:
      for (;;)
      {
        Intent localIntent;
        String str1;
        String str2;
        long l;
        paramQQAppInterface.printStackTrace();
        continue;
        paramQQAppInterface = "group_aio";
        continue;
        paramQQAppInterface = "";
      }
    }
    str2 = URLEncoder.encode(paramString2, "UTF-8");
    l = -1L;
    if (paramInt == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.b(paramString1);
        if (paramQQAppInterface != null)
        {
          l = paramQQAppInterface.dwGroupClassExt;
          paramQQAppInterface = "group_aio";
          paramString2 = str1 + "?toUin=" + paramString1 + "&uinType=" + String.valueOf(paramInt) + "&remarkName=" + str2;
          if (str1.contains("?")) {
            paramString2 = str1 + "&toUin=" + paramString1 + "&uinType=" + String.valueOf(paramInt) + "&remarkName=" + str2;
          }
          str1 = paramString2;
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            str1 = paramString2 + "&create_from=" + paramQQAppInterface;
          }
          paramQQAppInterface = str1;
          if (l != -1L) {
            paramQQAppInterface = str1 + "&group_type=" + l;
          }
          localIntent.putExtra("url", paramQQAppInterface);
          localIntent.putExtra("toUin", paramString1);
          localIntent.putExtra("uinType", paramInt);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
          paramActivity.startActivity(localIntent);
          return true;
        }
      }
    }
  }
  
  public static boolean a(String paramString, Context paramContext, int paramInt, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d(TAG, 2, "TencentDoc clickWeb url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramFileManagerEntity != null) && (paramQQAppInterface != null)) {
        ThreadManager.postImmediately(new TeamWorkUtils.4(paramString, paramQQAppInterface, paramFileManagerEntity), null, true);
      }
      paramString = paramString.trim();
    } while (!pN(paramString));
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putString("url", paramString);
    paramFileManagerEntity.putString("tdsourcetag", "s_qq_aiomsg");
    paramFileManagerEntity.putInt("tdsourcetab", paramInt);
    TeamWorkDocEditBrowserActivity.a(paramContext, paramFileManagerEntity, false);
    return true;
  }
  
  public static boolean a(Map<String, Long> paramMap, String paramString1, String paramString2, long paramLong)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    do
    {
      return false;
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = new File(paramString1);
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
      paramString1 = nR(str);
    } while ((TextUtils.isEmpty(paramString1)) || (!paramMap.containsKey(paramString1)));
    if (((Long)paramMap.get(paramString1)).longValue() > paramLong) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean ag(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      paramContext.startActivity(localIntent.putExtra("url", paramString));
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static List<ChatMessage> b(List<TencentDocData> paramList, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (d(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TencentDocData)paramList.next();
        MessageForStructing localMessageForStructing = new MessageForStructing();
        localMessageForStructing.structingMsg = new StructMsgForGeneralShare();
        localMessageForStructing.senderuin = String.valueOf(((TencentDocData)localObject).sendUin);
        localMessageForStructing.selfuin = paramString1;
        localMessageForStructing.frienduin = paramString2;
        localMessageForStructing.issend = 1;
        localMessageForStructing.msgtype = -2011;
        localMessageForStructing.time = ((TencentDocData)localObject).aioTime;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgAction = ((TencentDocData)localObject).action;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAction = ((TencentDocData)localObject).sourceAction;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgServiceID = ((TencentDocData)localObject).serviceId;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover = ((TencentDocData)localObject).docIcon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary = ((TencentDocData)localObject).summary;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle = ((TencentDocData)localObject).getTitle();
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceIcon = ((TencentDocData)localObject).icon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceName = ((TencentDocData)localObject).sourceName;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgBrief = ((TencentDocData)localObject).getBriefDes(BaseApplication.getContext());
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceUrl = ((TencentDocData)localObject).url;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAppid = ((TencentDocData)localObject).appid;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgUrl = ((TencentDocData)localObject).docUrl;
        localObject = new antd();
        ((anqv)localObject).Vs(0);
        ansr localansr = new ansr(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover);
        localansr.mPicWidth = ansr.dMr;
        ((anqv)localObject).a(localansr);
        ((anqv)localObject).a(new StructMsgItemTitle(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle));
        ((anqv)localObject).a(new anux(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary));
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mStructMsgItemLists.add(localObject);
        localArrayList.add(localMessageForStructing);
      }
    }
    return localArrayList;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      com.tencent.qphone.base.util.QLog.i(aoaf.cjv, 2, " onSetUserAuth  isSuccess = " + paramBoolean);
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramContext = paramQQAppInterface.b().a(localDocsGrayTipsInfo.uin, 0, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.xg != null)) {
            paramArrayOfObject.tipParam.xg.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      else
      {
        QQToast.a(paramContext, str, 0).show();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(aoaf.cjv, 1, " onSetUserAuth  exception  = " + paramQQAppInterface.toString());
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      if (TextUtils.isEmpty(aetq.a().tV())) {}
      for (paramQQAppInterface = "https://docs.qq.com/desktop/m/index.html?_from=1";; paramQQAppInterface = aetq.a().tV())
      {
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
        paramActivity.startActivity(localIntent.putExtra("url", paramQQAppInterface));
        break;
      }
      return true;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static String bC(String paramString1, String paramString2)
  {
    String str1 = "";
    try
    {
      String str2 = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str1;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = "?edited_url=" + str2;
        if (paramString1.contains("?")) {
          paramString2 = "&edited_url=" + str2;
        }
        paramString2 = paramString1 + paramString2;
      }
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      com.tencent.qphone.base.util.QLog.e(TAG, 1, paramString1.getLocalizedMessage(), paramString1);
    }
    return "";
  }
  
  public static String bD(String paramString1, String paramString2)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString1))
    {
      str = "?tdsourcetag=" + paramString2;
      if (paramString1.contains("?")) {
        str = "&tdsourcetag=" + paramString2;
      }
      str = paramString1 + str;
      aodb.b(null, aodb.oa(paramString1), "0X8009EA0", paramString2, aodb.ob(paramString1), "");
      aodb.aX(TAG, "tdsourcetag", paramString2);
    }
    return str;
  }
  
  public static String bE(String paramString1, String paramString2)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString1))
    {
      str = "?from_page=" + paramString2;
      if (paramString1.contains("?")) {
        str = "&from_page=" + paramString2;
      }
      str = paramString1 + str;
    }
    return str;
  }
  
  public static String bG(long paramLong)
  {
    try
    {
      String str = nV(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong)));
      if (str.equals(sV)) {
        return sV + " " + new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong));
      }
      if (str.equals(sW)) {
        return sW + " " + new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong));
      }
      str = new SimpleDateFormat("MM-dd HH:mm").format(Long.valueOf(paramLong));
      return str;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return "";
  }
  
  public static boolean bK(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aobh)paramQQAppInterface.getBusinessHandler(122);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.cLc;
    }
    return false;
  }
  
  public static boolean bL(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aobh)paramQQAppInterface.getBusinessHandler(122);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.aeg;
    }
    return false;
  }
  
  public static QIPCModule c()
  {
    return new aobw.b();
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "groupid=" + paramString + "&groupname=" + aqgv.a(paramQQAppInterface, paramString, false) + "&uinType=" + paramInt;
    }
    while (paramInt != 0) {
      return str;
    }
    return "groupid=" + paramString + "&groupname=" + aqgv.D(paramQQAppInterface, paramString) + "&uinType=" + paramInt;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramQQAppInterface.getApp().getString(2131720940).equals(str))
      {
        paramContext = paramQQAppInterface.b().a(localDocsGrayTipsInfo.uin, 1, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.xg != null)) {
            paramArrayOfObject.tipParam.xg.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      for (;;)
      {
        com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, " onGetGroupAuth  isSuccess = " + paramBoolean + " tips =" + str);
        return;
        QQToast.a(paramContext, str, 0).show();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, " onGetGroupAuth  exception = " + paramQQAppInterface.toString());
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      com.tencent.qphone.base.util.QLog.i(TAG + aoaf.cjv, 1, " onSetGroupAuth  isSuccess = " + paramBoolean);
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramContext = paramQQAppInterface.b().a(localDocsGrayTipsInfo.uin, 1, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.xg != null)) {
            paramArrayOfObject.tipParam.xg.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      else
      {
        QQToast.a(paramContext, str, 0).show();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, " onSetGroupAuth  exception  = " + paramQQAppInterface.toString());
    }
  }
  
  public static boolean d(Collection paramCollection)
  {
    return (paramCollection != null) && (!paramCollection.isEmpty());
  }
  
  public static void e(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle.setClassLoader(aobw.class.getClassLoader());
    } while (!(paramBundle.getParcelable("key_team_work_file_import_info") instanceof TeamWorkFileImportInfo));
    a((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info"), paramBundle.getString("url"), paramString);
  }
  
  public static String ft(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    Object localObject = "";
    paramInt -= 1;
    int i;
    String str;
    do
    {
      i = paramInt;
      if (((String)localObject).length() > 0) {
        i = paramInt - 1;
      }
      str = (char)(i % 26 + 65) + (String)localObject;
      i = (i - i % 26) / 26;
      localObject = str;
      paramInt = i;
    } while (i > 0);
    return str;
  }
  
  private static String g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int i = 0;
    com.tencent.qphone.base.util.QLog.e(TAG + aoaf.cjv, 1, "troopFormLog getTroopFormGrayContent =." + paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString1);
    int j = 0;
    while (localMatcher.find())
    {
      int k = localMatcher.start();
      int m = localMatcher.end();
      Object localObject1 = paramString1.substring(k + 1, m);
      Object localObject2 = paramString1.substring(j, k);
      m += 1;
      localSpannableStringBuilder.append((CharSequence)localObject2);
      k = i;
      label310:
      String str1;
      for (;;)
      {
        String str2;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          k = i;
          if (!((JSONObject)localObject1).has("uin")) {
            break label324;
          }
          k = i;
          str2 = ((JSONObject)localObject1).getString("uin");
          k = i;
          String str3 = paramQQAppInterface.getCurrentAccountUin();
          k = i;
          if (TextUtils.isEmpty(paramString2)) {
            break label310;
          }
          k = i;
          localObject1 = aqgv.p(paramQQAppInterface, paramString2, str2);
          j = i;
          localObject2 = localObject1;
          k = i;
          if (!TextUtils.isEmpty(str3))
          {
            j = i;
            localObject2 = localObject1;
            k = i;
            if (str3.equals(str2))
            {
              j = i;
              localObject2 = localObject1;
              if (i == 0)
              {
                k = i;
                localObject2 = cjV;
                j = 1;
              }
            }
          }
          k = j;
          localSpannableStringBuilder.append((CharSequence)localObject2);
          i = j;
          j = m;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = k;
          j = m;
        }
        break;
        k = i;
        str1 = aqgv.D(paramQQAppInterface, str2);
      }
      label324:
      j = m;
      k = i;
      if (str1.has("text"))
      {
        j = m;
        k = i;
        if (str1.has("isLink"))
        {
          j = m;
          k = i;
          if (str1.getString("isLink").equals("1"))
          {
            k = i;
            str1 = str1.getString("text");
            j = m;
            k = i;
            if (!TextUtils.isEmpty(str1))
            {
              k = i;
              localSpannableStringBuilder.append(str1);
              j = m;
            }
          }
        }
      }
    }
    if (j != paramString1.length()) {
      localSpannableStringBuilder.append(paramString1.subSequence(j, paramString1.length()));
    }
    return localSpannableStringBuilder.toString();
  }
  
  public static boolean g(String paramString1, String paramString2, long paramLong)
  {
    aetv localaetv = aetw.a();
    if (localaetv != null)
    {
      boolean bool2 = a(localaetv.jZ, paramString1, paramString2, paramLong);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = localaetv.lI(paramString2);
      }
      return bool1;
    }
    return false;
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean h(String paramString, Context paramContext)
  {
    return a(paramString, paramContext, -1, null, null);
  }
  
  public static boolean h(String paramString1, String paramString2, long paramLong)
  {
    return a(aeue.a().jZ, paramString1, paramString2, paramLong);
  }
  
  public static void hC(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        String str = localQQAppInterface.getCurrentAccountUin();
        JSONObject localJSONObject = aobh.f(paramString1, str);
        if (localJSONObject.getInt("retcode") == 0)
        {
          TencentDocData localTencentDocData = new TencentDocData();
          TencentDocData.obtainFromJsonObject(localJSONObject, null, localTencentDocData);
          localTencentDocData.docUrl = paramString1;
          localTencentDocData.sendUin = Long.parseLong(str);
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = str;
          }
          localTencentDocData.aioTime = (System.currentTimeMillis() / 1000L);
          paramString2 = new ArrayList();
          paramString2.add(localTencentDocData);
          paramString1 = b(paramString2, str, paramString1).iterator();
          while (paramString1.hasNext()) {
            j((ChatMessage)paramString1.next(), localQQAppInterface);
          }
          if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {}
        }
      }
      catch (JSONException paramString1) {}
    }
    com.tencent.qphone.base.util.QLog.e(TAG, 2, paramString1, new Object[0]);
  }
  
  public static void i(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramMessageRecord instanceof MessageForStructing)) {
                  break;
                }
                paramMessageRecord = (MessageForStructing)paramMessageRecord;
              } while ((paramMessageRecord.structingMsg == null) || (TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgUrl)) || (!agmy.mt(paramMessageRecord.structingMsg.mMsgUrl)));
              try
              {
                if ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare))
                {
                  StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
                  localObject2 = aobh.f(localStructMsgForGeneralShare.mMsgUrl, paramMessageRecord.selfuin);
                  if (((JSONObject)localObject2).getInt("retcode") == 0) {
                    localStructMsgForGeneralShare.mContentTitle = ((String)((JSONObject)((JSONObject)localObject2).get("doc_meta")).get("title"));
                  }
                }
                return;
              }
              catch (JSONException localJSONException)
              {
                if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
                  com.tencent.qphone.base.util.QLog.e(aoaf.cjv, 2, localJSONException.getMessage());
                }
                return;
              }
              finally
              {
                j(paramMessageRecord, paramQQAppInterface);
              }
              if (!(paramMessageRecord instanceof MessageForArkApp)) {
                break;
              }
              paramMessageRecord = (MessageForArkApp)paramMessageRecord;
              paramQQAppInterface = paramMessageRecord.ark_app_message.metaList;
            } while (TextUtils.isEmpty(paramQQAppInterface));
            try
            {
              paramQQAppInterface = new JSONObject(new JSONObject(paramQQAppInterface).getString(paramMessageRecord.ark_app_message.appView));
              String str = paramQQAppInterface.optString("appid");
              localObject2 = paramQQAppInterface.optString("qqdocurl");
              if ((TextUtils.isEmpty(str)) || (!str.equals(String.valueOf(aoS)))) {
                break;
              }
              hC(paramQQAppInterface.getString("jumpUrl").replace("\\", ""), paramMessageRecord.frienduin);
              return;
            }
            catch (JSONException paramMessageRecord) {}
          } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
          com.tencent.qphone.base.util.QLog.e(aoaf.cjv, 2, paramMessageRecord.getMessage());
          return;
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (!agmy.mt((String)localObject2)));
        hC((String)localObject2, paramMessageRecord.frienduin);
        return;
      } while (!(paramMessageRecord instanceof MessageForText));
      paramMessageRecord = (MessageForText)paramMessageRecord;
    } while (!agmy.mt(paramMessageRecord.msg));
    hC(paramMessageRecord.msg, paramMessageRecord.frienduin);
  }
  
  public static boolean i(String paramString1, String paramString2, long paramLong)
  {
    return a(aeum.a().ag(), paramString1, paramString2, paramLong);
  }
  
  /* Error */
  public static boolean iD(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 217	aobw:cyv	I
    //   6: iload_0
    //   7: if_icmpne +14 -> 21
    //   10: iconst_1
    //   11: istore_1
    //   12: iload_0
    //   13: putstatic 217	aobw:cyv	I
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -11 -> 12
    //   26: astore_2
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramInt	int
    //   11	12	1	bool	boolean
    //   26	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	10	26	finally
    //   12	16	26	finally
  }
  
  private static void j(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    MessageForStructing localMessageForStructing;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl))) {}
    }
    else
    {
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d(aoaf.cjv, 2, "tencentdoc also need insert into fm db");
    }
    msg_comm.Msg localMsg = new msg_comm.Msg();
    Object localObject1 = new msg_comm.MsgHead();
    localMsg.msg_head.set((MessageMicro)localObject1);
    ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_uid.set(localMessageForStructing.longMsgId);
    ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_time.set((int)localMessageForStructing.time);
    if ((localMessageForStructing.senderuin != null) && (localMessageForStructing.frienduin != null) && (localMessageForStructing.selfuin != null))
    {
      if (!localMessageForStructing.senderuin.equals(localMessageForStructing.frienduin)) {
        break label636;
      }
      ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
      ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.selfuin));
    }
    for (;;)
    {
      if (localMessageForStructing.istroop == 1)
      {
        localObject1 = new msg_comm.C2CTmpMsgHead();
        ((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.set((MessageMicro)localObject1);
        ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.set(1);
        ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).group_code.set(Integer.parseInt(localMessageForStructing.frienduin));
      }
      ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_seq.set((short)(int)localMessageForStructing.msgseq);
      localObject1 = new im_msg_body.NotOnlineFile();
      ((im_msg_body.NotOnlineFile)localObject1).uint32_file_type.set(0);
      ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(localMessageForStructing.structingMsg.mMsgUrl));
      ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(0L);
      ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(1);
      Object localObject2;
      JSONObject localJSONObject;
      if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
      {
        localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
        if (TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentCover)) {
          ((StructMsgForGeneralShare)localObject2).mContentCover = nW(((StructMsgForGeneralShare)localObject2).mMsgUrl);
        }
        if (!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentTitle)) {
          ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentTitle));
        }
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("structmsg_service_id", ((StructMsgForGeneralShare)localObject2).mMsgServiceID);
        localJSONObject.put("stuctmsg_bytes", Base64.encodeToString(((StructMsgForGeneralShare)localObject2).getBytes(), 0));
        localJSONObject.put("structmsg_uniseq", paramMessageRecord.uniseq);
        localJSONObject.put("accostType", ((StructMsgForGeneralShare)localObject2).sourceAccoutType);
        ((im_msg_body.NotOnlineFile)localObject1).bytes_note.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentCover));
        ((im_msg_body.NotOnlineFile)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localJSONObject.toString().getBytes()));
        paramMessageRecord = new ArrayList(paramQQAppInterface.a().eV()).iterator();
        while (paramMessageRecord.hasNext())
        {
          localObject2 = (FileManagerEntity)paramMessageRecord.next();
          if ((((FileManagerEntity)localObject2).Uuid != null) && (((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(localMessageForStructing.structingMsg.mMsgUrl)))
          {
            ((FileManagerEntity)localObject2).srvTime = (localMessageForStructing.time * 1000L);
            ((FileManagerEntity)localObject2).bDelInFM = false;
            paramQQAppInterface.a().u((FileManagerEntity)localObject2);
            return;
            label636:
            ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
            ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.frienduin));
          }
        }
      }
      catch (JSONException paramMessageRecord)
      {
        for (;;)
        {
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.e(aoaf.cjv, 2, paramMessageRecord.getMessage());
          }
        }
        paramQQAppInterface.a().a(paramQQAppInterface.a(), new ArrayList(), localMsg, (im_msg_body.NotOnlineFile)localObject1, localMessageForStructing.frienduin, false, false, localMessageForStructing.vipBubbleID, localMessageForStructing.vipBubbleDiyTextId, null);
      }
    }
  }
  
  public static boolean j(String paramString1, String paramString2, long paramLong)
  {
    return a(aetq.a().ag(), paramString1, paramString2, paramLong);
  }
  
  public static boolean l(Context paramContext, String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.d(TAG, 1, "troopFormLog openTroopFormMiniApp =" + paramString1);
    try
    {
      LaunchParam localLaunchParam = new LaunchParam();
      localLaunchParam.scene = 0;
      localLaunchParam.miniAppId = "1108961705";
      localLaunchParam.entryPath = "pages/detail/detail";
      StringBuilder localStringBuilder;
      if (!TextUtils.isEmpty(paramString1))
      {
        localStringBuilder = new StringBuilder().append(localLaunchParam.entryPath).append("?url=").append(URLEncoder.encode(paramString1, "utf-8"));
        if (!TextUtils.isEmpty(paramString2)) {
          break label247;
        }
      }
      label247:
      for (paramString2 = "";; paramString2 = "&" + paramString2)
      {
        localLaunchParam.entryPath = paramString2;
        localLaunchParam.navigateExtData = ("url=" + paramString1);
        MiniAppLauncher.launchMiniAppById(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.navigateExtData, localLaunchParam.envVersion, localLaunchParam.reportData, localLaunchParam.scene);
        if (!com.tencent.TMG.utils.QLog.isColorLevel()) {
          break;
        }
        com.tencent.TMG.utils.QLog.i(TAG, 0, "openTroopFormMiniApp:open :scene = " + localLaunchParam.scene + "miniAppId = " + localLaunchParam.miniAppId + "entryPath = " + localLaunchParam.entryPath + "navigateExtData = " + localLaunchParam.navigateExtData);
        break;
      }
      return true;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.e(TAG, 0, "openTroopFormMiniApp " + paramContext.getMessage());
      }
      return false;
    }
  }
  
  public static String nR(String paramString)
  {
    paramString = ahbj.getExtension(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.toLowerCase().replace(".", "");
  }
  
  public static String nS(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString))
    {
      str = "?m_readonly=1";
      if (paramString.contains("?")) {
        str = "&m_readonly=1";
      }
      str = paramString + str;
    }
    return str;
  }
  
  public static String nT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.split("\\?");
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    return arrayOfString[0];
  }
  
  public static String nU(String paramString)
  {
    paramString = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return "";
  }
  
  public static String nV(String paramString)
    throws ParseException
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    Object localObject2 = nU(paramString);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    localObject2 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
    localObject1 = ((SimpleDateFormat)localObject1).parse(str);
    if (((Date)localObject1).getTime() - ((Date)localObject2).getTime() == 0L) {
      return sV;
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject2).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject2).getTime() <= 86400000L)) {
      return sW;
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject2).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject2).getTime() <= 604800000L)) {
      return cjW;
    }
    localObject1 = paramString.substring(0, 4);
    paramString = paramString.substring(5, 7);
    return (String)localObject1 + acfp.m(2131715190) + paramString + acfp.m(2131715156);
  }
  
  public static String nW(String paramString)
  {
    if (agmy.mu(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fd11abde219141a6f97e79c7fde6b71f.png";
    }
    if (agmy.mv(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/f15795a2b4c9a5f7668f10eb78d27499.png";
    }
    if (agmy.mx(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/ed532c207b5439a6c29ce241ad7decb7.png";
    }
    if (agmy.mw(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fcbfa8f749abb54bf66b48e93c82b295.png";
    }
    if (agmy.my(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/90226039f41abf0e1f42e46a5350e364.png";
    }
    return "";
  }
  
  public static String nX(String paramString)
  {
    if (agmy.mu(paramString)) {
      return String.valueOf(1);
    }
    if (agmy.mv(paramString)) {
      return String.valueOf(2);
    }
    if (agmy.mx(paramString)) {
      return String.valueOf(3);
    }
    if (agmy.mw(paramString)) {
      return String.valueOf(4);
    }
    return "";
  }
  
  public static Bitmap o(int paramInt)
  {
    return a(du, 2130850714, "static://DefaultTeamWorkMiniShareDoc", paramInt);
  }
  
  public static Bitmap p(int paramInt)
  {
    return a(dv, 2130850713, "static://DefaultTeamWorkH5ShareDoc", paramInt);
  }
  
  public static void p(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    String str = "";
    if (localTroopManager != null) {}
    for (paramString2 = localTroopManager.b(paramString2);; paramString2 = null)
    {
      if (paramString2 != null) {
        str = "" + paramString2.dwGroupClassExt;
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", str, "");
      return;
    }
  }
  
  public static boolean pN(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com"))
      {
        bool1 = bool3;
        if (!paramString.contains("docx.qq.com")) {
          break label100;
        }
      }
    }
    try
    {
      paramString = new URL(paramString).getPath();
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
      {
        bool3 = paramString.equals("/login.html");
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = false;
      }
      label100:
      return bool1;
    }
    catch (Exception paramString)
    {
      com.tencent.qphone.base.util.QLog.e("docHome", 1, " detect docHome error: " + paramString.toString());
    }
    return true;
  }
  
  public static boolean pO(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com/form"))
      {
        bool1 = bool3;
        if (!paramString.contains("docx.qq.com/form")) {
          break label100;
        }
      }
    }
    try
    {
      paramString = new URL(paramString).getPath();
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
      {
        bool3 = paramString.equals("/login.html");
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = false;
      }
      label100:
      return bool1;
    }
    catch (Exception paramString)
    {
      com.tencent.qphone.base.util.QLog.e("docHome", 1, " detect docHome error: " + paramString.toString());
    }
    return true;
  }
  
  public static boolean pP(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!paramString.contains("docs.qq.com/doc/")) && (!paramString.contains("docs.qq.com/sheet/")) && (!paramString.contains("docs.qq.com/form/fill/")))
      {
        bool1 = bool2;
        if (!paramString.contains("docs.qq.com/form/edit/")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean pQ(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,")) || (paramString.startsWith("data:image/gif;base64,"));
  }
  
  public static void q(Activity paramActivity, String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      if (TextUtils.isEmpty(aetq.a().tV())) {}
      String str2;
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = aetq.a().tV())
      {
        str2 = bD(str1, paramString);
        localIntent.putExtra("tdsourcetag", paramString);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        str1 = paramString;
        if (TextUtils.equals(paramString, "s_qq_history_tab")) {
          str1 = "s_qq_myfile";
        }
        if (TeamWorkDocEditBrowserActivity.g(paramActivity, str2, str1)) {
          return;
        }
        if (paramInt >= 0) {
          break;
        }
        paramActivity.startActivity(localIntent.putExtra("url", str2));
        return;
      }
      paramActivity.startActivityForResult(localIntent.putExtra("url", str2), paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      com.tencent.qphone.base.util.QLog.i(TAG, 1, paramActivity.toString());
    }
  }
  
  public static boolean qH()
  {
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l - lastClickTime >= 1000L) {
      bool = false;
    }
    lastClickTime = l;
    return bool;
  }
  
  public static void s(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("tdsourcetype");
    } while (TextUtils.isEmpty(paramIntent));
    if (paramIntent.contains("1")) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "s_qq_history_tab", paramIntent.substring(0, paramIntent.length() - 1));
      return;
    }
  }
  
  public static boolean v(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1 != null)
        {
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
    }
    paramString1 = ahbj.getExtension(str);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (paramString3.indexOf(paramString1.toLowerCase()) >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static class a
  {
    public static a a;
    private ConcurrentLinkedQueue<MessageRecord> L = new ConcurrentLinkedQueue();
    private WeakReference<QQAppInterface> hX;
    
    private a(QQAppInterface paramQQAppInterface)
    {
      this.hX = new WeakReference(paramQQAppInterface);
    }
    
    public static a a(QQAppInterface paramQQAppInterface)
    {
      if (a == null) {}
      try
      {
        if (a == null) {
          a = new a(paramQQAppInterface);
        }
        return a;
      }
      finally {}
    }
    
    public void aD(MessageRecord paramMessageRecord)
    {
      if (paramMessageRecord == null) {}
      label190:
      do
      {
        do
        {
          for (;;)
          {
            return;
            Object localObject1;
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              localObject1 = (MessageForStructing)paramMessageRecord;
              if ((((MessageForStructing)localObject1).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgUrl)) && (agmy.mt(((MessageForStructing)localObject1).structingMsg.mMsgUrl))) {
                this.L.add(paramMessageRecord);
              }
            }
            else
            {
              if (!(paramMessageRecord instanceof MessageForArkApp)) {
                break label190;
              }
              localObject1 = (MessageForArkApp)paramMessageRecord;
              Object localObject2 = ((MessageForArkApp)localObject1).ark_app_message.metaList;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                try
                {
                  localObject2 = new JSONObject(new JSONObject((String)localObject2).getString(((MessageForArkApp)localObject1).ark_app_message.appView));
                  localObject1 = ((JSONObject)localObject2).optString("appid");
                  localObject2 = ((JSONObject)localObject2).optString("qqdocurl");
                  if (((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(String.valueOf(aobw.aoS)))) || ((!TextUtils.isEmpty((CharSequence)localObject2)) && (agmy.mt((String)localObject2))))
                  {
                    this.L.add(paramMessageRecord);
                    return;
                  }
                }
                catch (JSONException paramMessageRecord) {}
              }
            }
          }
        } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
        com.tencent.qphone.base.util.QLog.e(aoaf.cjv, 2, paramMessageRecord.getMessage());
        return;
      } while ((!(paramMessageRecord instanceof MessageForText)) || (!agmy.mt(((MessageForText)paramMessageRecord).msg)));
      this.L.add(paramMessageRecord);
    }
    
    public void schedule()
    {
      if (this.L.size() <= 0) {}
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.hX.get();
      } while ((localQQAppInterface == null) || (localQQAppInterface.a.Bd() != 1));
      ThreadManager.postImmediately(new TeamWorkUtils.ProcessTDFileScheduler.1(this, localQQAppInterface), null, true);
    }
  }
  
  public static class b
    extends QIPCModule
  {
    public b()
    {
      super();
    }
    
    public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
    {
      arwt.d(aobw.TAG, "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
      if (paramString.equals("Action_url_2_fmdb")) {
        ThreadManager.postImmediately(new TeamWorkUtils.TDFileQIPCModule.1(this, paramBundle.getString("url")), null, true);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aobw
 * JD-Core Version:    0.7.0.1
 */