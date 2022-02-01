import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.b;
import com.tencent.widget.Gallery;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class xtj
  extends xsk
  implements DragView.b
{
  TextView Kp;
  TextView Kq;
  boolean bjb = false;
  private Set<Integer> br;
  private ProgressDialog jdField_d_of_type_AndroidAppProgressDialog;
  private xuf jdField_d_of_type_Xuf;
  Button dZ;
  Button ea;
  Button eb;
  Button ec;
  View xc;
  private TextView yw;
  
  public xtj(Activity paramActivity, sxm paramsxm, xuh paramxuh, String paramString)
  {
    super(paramActivity, paramsxm, paramxuh, paramString);
  }
  
  public static int a(String[] paramArrayOfString)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfString != null)
    {
      i = j;
      if (paramArrayOfString.length >= 8)
      {
        j = 1;
        if (paramArrayOfString[7].equals("link")) {}
        do
        {
          return 3;
          i = j;
          if (paramArrayOfString.length < 9) {
            break;
          }
          i = j;
          if (!paramArrayOfString[7].equals("scrawl_link")) {
            break;
          }
          paramArrayOfString = paramArrayOfString[8];
          i = j;
          if (TextUtils.isEmpty(paramArrayOfString)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageData", 2, "name = " + paramArrayOfString + " , name.length = " + paramArrayOfString.length());
          }
          i = j;
          if (paramArrayOfString.startsWith("upload")) {
            break;
          }
        } while (paramArrayOfString.trim().length() <= 32);
        i = j;
      }
    }
    return i;
  }
  
  public static String a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      if (!hQ(paramStructMsgForImageShare.mMsgActionData)) {
        break label70;
      }
      if ((TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)) || (paramStructMsgForImageShare.mMsg_A_ActionData.indexOf("|") <= 0)) {
        break label65;
      }
      localObject1 = "comic_plugin.apk|" + paramStructMsgForImageShare.mMsg_A_ActionData;
    }
    label65:
    label70:
    do
    {
      return localObject1;
      return paramStructMsgForImageShare.mMsgActionData;
      localObject1 = localObject2;
    } while (!hR(paramStructMsgForImageShare.mMsgActionData));
    return paramStructMsgForImageShare.mMsgActionData;
  }
  
  private void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject;
    if (paramAIOImageData.EP == 2)
    {
      localObject = j(paramStructMsgForImageShare.mMsgActionData);
      if ((localObject != null) && (localObject.length > 2))
      {
        paramAIOImageData = "";
        paramStructMsgForImageShare = Uri.parse(localObject[1]);
      }
    }
    try
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare.getQueryParameter("article_id");
      paramAIOImageData = paramStructMsgForImageShare;
    }
    catch (Exception paramStructMsgForImageShare)
    {
      for (;;)
      {
        paramStructMsgForImageShare.printStackTrace();
      }
    }
    paramStructMsgForImageShare = paramAIOImageData;
    if (paramAIOImageData == null) {
      paramStructMsgForImageShare = "";
    }
    paramAIOImageData = "";
    if (localObject.length > 3)
    {
      localObject = localObject[3];
      if (localObject != null)
      {
        paramAIOImageData = (AIOImageData)localObject;
        if (((String)localObject).equals("1")) {}
      }
      else
      {
        paramAIOImageData = "";
      }
    }
    kbp.a(null, "", "0X8007131", "0X8007131", 0, 0, paramStructMsgForImageShare, paramAIOImageData, "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, boolean paramBoolean1, boolean paramBoolean2)
  {
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ);
    String[] arrayOfString = j(localStructMsgForImageShare.mMsgActionData);
    if ((arrayOfString != null) && (arrayOfString.length > 2))
    {
      Object localObject = arrayOfString[2];
      paramAIOImageData = (AIOImageData)localObject;
      if (localObject != null)
      {
        paramAIOImageData = (AIOImageData)localObject;
        if (((String)localObject).length() > 17) {
          paramAIOImageData = ((String)localObject).substring(0, 16) + "...";
        }
      }
      this.dZ.setText(paramAIOImageData);
      this.dZ.setVisibility(0);
      if (paramBoolean1)
      {
        paramAIOImageData = "";
        localObject = Uri.parse(arrayOfString[1]);
      }
      try
      {
        localObject = ((Uri)localObject).getQueryParameter("article_id");
        paramAIOImageData = (AIOImageData)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          localException.printStackTrace();
        }
      }
      localObject = paramAIOImageData;
      if (paramAIOImageData == null) {
        localObject = "";
      }
      paramAIOImageData = "";
      if (arrayOfString.length > 3)
      {
        str = arrayOfString[3];
        if (str != null)
        {
          paramAIOImageData = str;
          if (str.equals("1")) {}
        }
        else
        {
          paramAIOImageData = "";
        }
      }
      kbp.a(null, "", "0X8007153", "0X8007153", 0, 0, (String)localObject, paramAIOImageData, "", "");
      kbp.d("0X8007153", "", (String)localObject, paramAIOImageData, "", "");
    }
    for (;;)
    {
      this.ea.setVisibility(8);
      if (this.Kp != null)
      {
        this.Kp.setText(acfp.m(2131702202));
        if ((arrayOfString != null) && (arrayOfString.length > 3))
        {
          paramAIOImageData = arrayOfString[3];
          if ((paramAIOImageData != null) && (paramAIOImageData.equals("1"))) {
            this.Kp.setText(acfp.m(2131702236));
          }
        }
      }
      this.xc.invalidate();
      this.dZ.setTag(localStructMsgForImageShare);
      this.ea.setTag(localStructMsgForImageShare);
      this.eb.setTag(localStructMsgForImageShare);
      if (paramBoolean2)
      {
        this.k.setVisibility(4);
        this.xc.setVisibility(0);
      }
      return;
      this.dZ.setVisibility(8);
    }
  }
  
  private void a(xuf paramxuf, AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ);
    String[] arrayOfString = a(localStructMsgForImageShare);
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    paramAIOImageData = localObject2;
    if (arrayOfString != null)
    {
      localObject1 = localObject3;
      paramAIOImageData = localObject2;
      if (arrayOfString.length >= 8)
      {
        paramAIOImageData = arrayOfString[1];
        localObject1 = arrayOfString[3] + acfp.m(2131702223) + arrayOfString[5] + acfp.m(2131702238);
        if ((paramAIOImageData == null) || (paramAIOImageData.length() < 7)) {
          break label408;
        }
        paramAIOImageData = paramAIOImageData.substring(0, 6) + "...";
      }
    }
    label388:
    label408:
    for (;;)
    {
      if (!this.br.contains(Integer.valueOf(paramxuf.hashCode())))
      {
        avdb.a(null, this.aWf, this.mContext, "3008", "1", "30004", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], hA(localStructMsgForImageShare.mMsgActionData) });
        this.br.add(Integer.valueOf(paramxuf.hashCode()));
      }
      if (TextUtils.isEmpty(paramAIOImageData))
      {
        this.dZ.setVisibility(8);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label388;
        }
        this.ea.setVisibility(8);
      }
      for (;;)
      {
        if (this.Kp != null) {
          this.Kp.setText(acfp.m(2131702198));
        }
        if ((arrayOfString != null) && (arrayOfString.length >= 8) && (this.Kp != null)) {
          this.Kp.setVisibility(0);
        }
        this.xc.invalidate();
        this.dZ.setTag(localStructMsgForImageShare);
        this.ea.setTag(localStructMsgForImageShare);
        this.eb.setTag(localStructMsgForImageShare);
        if (paramBoolean)
        {
          this.k.setVisibility(4);
          this.xc.setVisibility(0);
        }
        return;
        this.dZ.setText(paramAIOImageData);
        this.dZ.setVisibility(0);
        break;
        this.ea.setText((CharSequence)localObject1);
        this.ea.setVisibility(0);
      }
    }
  }
  
  private void a(boolean paramBoolean, String[] paramArrayOfString, StructMsgForImageShare paramStructMsgForImageShare, File paramFile)
  {
    if (paramBoolean)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramArrayOfString[7].equals("scrawl_link"))
      {
        localObject1 = localObject2;
        if (paramArrayOfString.length > 8) {
          localObject1 = paramArrayOfString[8];
        }
      }
      String str2 = paramArrayOfString[3] + acfp.m(2131702206) + paramArrayOfString[5] + acfp.m(2131702218);
      String str1 = "ADTAG=comic.plugin.read&id=" + paramArrayOfString[0] + "&name=" + URLEncoder.encode(paramArrayOfString[1]) + "&sectionID=" + paramArrayOfString[2] + "&sectionName=" + URLEncoder.encode(paramArrayOfString[3]) + "&pageID=" + paramArrayOfString[4] + "&page=" + paramArrayOfString[5] + "&type=" + paramArrayOfString[6];
      localObject2 = str1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str1 + "&scrawl_link=" + URLEncoder.encode((String)localObject1);
      }
      localObject1 = VipComicJumpActivity.c("comicReadShare", "5123", null, null, "354", null, (String)localObject2);
      new aviz(6).a("nLinkType", 0).b("sTitle", paramArrayOfString[1]).b("sUrl", (String)localObject1).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramStructMsgForImageShare.mSourceName).b("sBrief", str2).b("sPath", paramFile.getAbsolutePath()).b("sResUrl", paramStructMsgForImageShare.mSourceUrl).a("lCategory", 1L).b(this.mContext, this.aWf);
      avjg.a(null, 6, 2);
      if (paramArrayOfString.length < 8) {
        break label453;
      }
      if (!paramArrayOfString[7].equals("link")) {
        break label426;
      }
      paramStructMsgForImageShare = paramArrayOfString[4];
    }
    for (;;)
    {
      avdb.a(null, this.aWf, this.mContext, "100008", "2", "40058", paramArrayOfString[0], new String[] { "2", "", paramStructMsgForImageShare });
      return;
      label426:
      if ((paramArrayOfString[7].equals("scrawl_link")) && (paramArrayOfString.length >= 9)) {
        paramStructMsgForImageShare = paramArrayOfString[8];
      } else {
        label453:
        paramStructMsgForImageShare = "";
      }
    }
  }
  
  private void a(String[] paramArrayOfString, StructMsgForImageShare paramStructMsgForImageShare)
  {
    String str = paramArrayOfString[1];
    Object localObject = paramArrayOfString[2];
    localObject = paramStructMsgForImageShare.getFirstImageElement();
    if (localObject != null)
    {
      if (((ansu)localObject).d == null) {
        ((ansu)localObject).d = paramStructMsgForImageShare;
      }
      AIOImageData localAIOImageData = xtm.a(((ansu)localObject).a());
      localObject = localAIOImageData.c(4);
      paramStructMsgForImageShare = (StructMsgForImageShare)localObject;
      if (localObject == null) {
        paramStructMsgForImageShare = localAIOImageData.c(2);
      }
      if (paramStructMsgForImageShare != null) {
        paramStructMsgForImageShare.getAbsolutePath();
      }
    }
    aviz.a(str).c(this.aWf).b(this.mContext, this.aWf);
    avjg.a(null, 6, 2);
    paramStructMsgForImageShare = "";
    localObject = Uri.parse(paramArrayOfString[1]);
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
      paramStructMsgForImageShare = (StructMsgForImageShare)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject = paramStructMsgForImageShare;
    if (paramStructMsgForImageShare == null) {
      localObject = "";
    }
    paramStructMsgForImageShare = "";
    if (paramArrayOfString.length > 3)
    {
      paramArrayOfString = paramArrayOfString[3];
      if (paramArrayOfString != null)
      {
        paramStructMsgForImageShare = paramArrayOfString;
        if (paramArrayOfString.equals("1")) {}
      }
      else
      {
        paramStructMsgForImageShare = "";
      }
    }
    kbp.a(null, "", "0X8007132", "0X8007132", 0, 0, (String)localObject, paramStructMsgForImageShare, "", "");
  }
  
  public static final String[] a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    int j = 1;
    String[] arrayOfString;
    if ((paramStructMsgForImageShare.mMsgActionData != null) && (paramStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
    {
      arrayOfString = paramStructMsgForImageShare.mMsgActionData.substring(paramStructMsgForImageShare.mMsgActionData.indexOf("|") + 1).split("\\|");
      if ((arrayOfString.length < 8) || ((!arrayOfString[7].equals("link")) && (!arrayOfString[7].equals("scrawl_link")))) {
        break label144;
      }
    }
    label144:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)))
      {
        paramStructMsgForImageShare = paramStructMsgForImageShare.mMsg_A_ActionData.split("\\|");
        if ((paramStructMsgForImageShare.length >= 8) && (paramStructMsgForImageShare[7].equals("link"))) {
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          return paramStructMsgForImageShare;
          i = 0;
        }
        else
        {
          return null;
          paramStructMsgForImageShare = arrayOfString;
        }
      }
    }
  }
  
  private void bc(Context paramContext, String paramString)
  {
    try
    {
      if (this.jdField_d_of_type_AndroidAppProgressDialog != null) {
        btB();
      }
      for (;;)
      {
        this.yw.setText(paramString);
        if (this.jdField_d_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_d_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_d_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131756467);
        this.jdField_d_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_d_of_type_AndroidAppProgressDialog.getWindow().setDimAmount(0.0F);
        this.jdField_d_of_type_AndroidAppProgressDialog.show();
        this.jdField_d_of_type_AndroidAppProgressDialog.setContentView(2131559761);
        this.yw = ((TextView)this.jdField_d_of_type_AndroidAppProgressDialog.findViewById(2131373180));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog error " + paramContext.getMessage());
      }
    }
  }
  
  private void btB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_d_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_d_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_d_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c(StructMsgForImageShare paramStructMsgForImageShare)
  {
    paramStructMsgForImageShare = j(paramStructMsgForImageShare.mMsgActionData);
    if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length > 2))
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare[1];
      Intent localIntent = new Intent(this.mContext, PublicAccountBrowser.class);
      localIntent.putExtra("uin", this.aWf);
      localIntent.putExtra("url", paramStructMsgForImageShare);
      this.mContext.startActivity(localIntent);
    }
  }
  
  private void e(AIOImageData paramAIOImageData)
  {
    paramAIOImageData = (StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ);
    c(paramAIOImageData);
    Object localObject2 = j(paramAIOImageData.mMsgActionData);
    if ((localObject2 != null) && (localObject2.length > 2))
    {
      paramAIOImageData = "";
      localObject1 = Uri.parse(localObject2[1]);
    }
    try
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
      paramAIOImageData = (AIOImageData)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    Object localObject1 = paramAIOImageData;
    if (paramAIOImageData == null) {
      localObject1 = "";
    }
    paramAIOImageData = "";
    if (localObject2.length > 3)
    {
      localObject2 = localObject2[3];
      if (localObject2 != null)
      {
        paramAIOImageData = (AIOImageData)localObject2;
        if (((String)localObject2).equals("1")) {}
      }
      else
      {
        paramAIOImageData = "";
      }
    }
    kbp.a(null, "", "0X8007130", "0X8007130", 0, 0, (String)localObject1, paramAIOImageData, "", "");
  }
  
  public static String f(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof StructMsgForImageShare))) {
        return a((StructMsgForImageShare)paramChatMessage.structingMsg);
      }
    }
    return null;
  }
  
  public static String hA(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (hQ(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8)
      {
        if (!paramString[7].equals("link")) {
          break label58;
        }
        str1 = paramString[4];
      }
    }
    label58:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (!paramString[7].equals("scrawl_link"));
      str1 = str2;
    } while (paramString.length < 9);
    return paramString[8];
  }
  
  public static String hB(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (hQ(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8) {
        if (!paramString[7].equals("link"))
        {
          str1 = str2;
          if (!paramString[7].equals("scrawl_link")) {}
        }
        else
        {
          str1 = paramString[0];
        }
      }
    }
    return str1;
  }
  
  public static boolean hQ(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("comic_plugin.apk"));
  }
  
  public static boolean hR(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("ScreenShotShare"));
  }
  
  public static String[] i(String paramString)
  {
    if (hQ(paramString)) {
      return paramString.substring(paramString.indexOf("|") + 1).split("\\|");
    }
    return null;
  }
  
  public static String[] j(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.split("\\|");
    }
    return null;
  }
  
  boolean SI()
  {
    Object localObject = this.jdField_b_of_type_Xto.d();
    if ((localObject != null) && (AIOImageData.class.isInstance(((xuf)localObject).e)))
    {
      localObject = (AIOImageData)((xuf)localObject).e;
      if ((((AIOImageData)localObject).EP != 1) && (((AIOImageData)localObject).EP != 2)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.k.setVisibility(4);
        this.xc.setVisibility(0);
      }
      for (;;)
      {
        if (this.jdField_b_of_type_Xto.c() != null)
        {
          localObject = this.jdField_b_of_type_Xto.c().e;
          if ((localObject != null) && ((localObject instanceof AIOShortVideoData)) && (((AIOShortVideoData)localObject).specialVideoType == 2) && (this.ec != null)) {
            this.ec.setVisibility(0);
          }
        }
        this.bjb = true;
        return true;
        this.xc.setVisibility(4);
        this.k.setVisibility(0);
      }
    }
  }
  
  boolean SJ()
  {
    this.k.setVisibility(4);
    this.xc.setVisibility(4);
    if (this.ec != null) {
      this.ec.setVisibility(4);
    }
    return true;
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    Object localObject2 = "";
    paramStructMsgForImageShare = a(paramStructMsgForImageShare);
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      localObject1 = localObject2;
      if (paramStructMsgForImageShare.length > 0) {
        localObject1 = paramStructMsgForImageShare[0];
      }
    }
    localObject2 = new Intent(this.mContext, JumpActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "13");
      localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
      localJSONObject.put("leftViewText", acfp.m(2131702217));
      localJSONObject.put("maintab", "index");
      ((Intent)localObject2).setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
      this.mContext.startActivity((Intent)localObject2);
      if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length >= 8))
      {
        if (paramStructMsgForImageShare[7].equals("link"))
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[4];
          if (!"5".equals(paramString)) {
            break label251;
          }
          avdb.a(null, this.aWf, this.mContext, "100008", "2", "40057", localObject1, new String[] { "", "", paramStructMsgForImageShare });
        }
        label251:
        while (!"6".equals(paramString))
        {
          return;
          if ((!paramStructMsgForImageShare[7].equals("scrawl_link")) || (paramStructMsgForImageShare.length < 9)) {
            break label308;
          }
          paramStructMsgForImageShare = paramStructMsgForImageShare[8];
          break;
        }
        avdb.a(null, this.aWf, this.mContext, "100008", "2", "40058", localObject1, new String[] { "4", "", paramStructMsgForImageShare });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        label308:
        paramStructMsgForImageShare = "";
      }
    }
  }
  
  protected void a(xuf paramxuf, Activity paramActivity, int paramInt)
  {
    int i = 4;
    AIOImageData localAIOImageData;
    File localFile;
    if ((this.bWR == 1) || (this.bWR == 2) || (this.bWR == 3) || (this.bWR == 5) || (this.bWR == 6))
    {
      if (!AIOImageData.class.isInstance(paramxuf.e)) {
        return;
      }
      localAIOImageData = (AIOImageData)paramxuf.e;
      localFile = localAIOImageData.c(4);
      if (localFile != null) {
        break label328;
      }
      localFile = localAIOImageData.c(2);
    }
    label328:
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.cH(1));
      paramxuf = paramxuf.e;
      if (paramInt != 0) {}
      for (;;)
      {
        localBundle.putString("forward_urldrawable_big_url", paramxuf.cH(i));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("forward_filepath", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
          localBundle.putBoolean("key_help_forward_pic", true);
          localBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
          paramxuf = new Intent();
          paramxuf.putExtras(localBundle);
          ahgq.f(paramActivity, paramxuf, 19005);
          return;
        }
        catch (NullPointerException paramxuf) {}
        i = 2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramxuf);
      return;
      super.a(paramxuf, paramActivity, paramInt);
      return;
    }
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!anki.axK()) {
      return false;
    }
    if (this.jdField_b_of_type_Xto.c() != null)
    {
      Object localObject = this.jdField_b_of_type_Xto.c().e;
      if ((localObject instanceof AIOShortVideoData))
      {
        AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localObject;
        if (localAIOShortVideoData.specialVideoType == 2)
        {
          if (this.ec != null) {
            return true;
          }
          if (localAIOShortVideoData.istroop == 0) {
            localObject = acfp.m(2131702209);
          }
          for (;;)
          {
            this.ec = new Button(paramActivity);
            this.ec.setText((CharSequence)localObject);
            this.ec.setTextColor(-1);
            this.ec.setTextSize(18.0F);
            int i = (int)(aqnm.getScreenWidth() * 0.42D);
            paramActivity = new RelativeLayout.LayoutParams(i, i * 114 / 314);
            paramActivity.addRule(14);
            paramActivity.addRule(12);
            paramActivity.bottomMargin = 56;
            paramViewGroup.addView(this.ec, paramActivity);
            this.ec.setOnClickListener(new xtl(this, localAIOShortVideoData));
            return true;
            if (1 == localAIOShortVideoData.istroop)
            {
              localObject = acfp.m(2131702196);
            }
            else
            {
              if (3000 != localAIOShortVideoData.istroop) {
                break;
              }
              localObject = acfp.m(2131702225);
            }
          }
          return false;
        }
      }
    }
    return false;
  }
  
  boolean a(ausj paramausj, AIOImageData paramAIOImageData)
  {
    if ((paramausj == null) || (paramAIOImageData == null)) {}
    do
    {
      return false;
      if (paramAIOImageData.EP == 1)
      {
        paramausj.addButton(2131694752);
        paramausj.addButton(2131694750);
        paramausj.addButton(2131694748);
        paramausj.addButton(2131694747);
        return true;
      }
    } while (paramAIOImageData.EP != 2);
    paramausj.addButton(2131694750);
    paramausj.addButton(2131694752);
    paramausj.addButton(2131694744);
    Object localObject = j(((StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ)).mMsgActionData);
    if ((localObject != null) && (localObject.length > 2))
    {
      paramausj = "";
      paramAIOImageData = Uri.parse(localObject[1]);
    }
    try
    {
      paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
      paramausj = paramAIOImageData;
    }
    catch (Exception paramAIOImageData)
    {
      for (;;)
      {
        paramAIOImageData.printStackTrace();
      }
    }
    paramAIOImageData = paramausj;
    if (paramausj == null) {
      paramAIOImageData = "";
    }
    paramausj = "";
    if (localObject.length > 3)
    {
      localObject = localObject[3];
      if (localObject != null)
      {
        paramausj = (ausj)localObject;
        if (((String)localObject).equals("1")) {}
      }
      else
      {
        paramausj = "";
      }
    }
    kbp.a(null, "", "0X8007154", "0X8007154", 0, 0, paramAIOImageData, paramausj, "", "");
    return true;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    boolean bool2 = true;
    if ((paramString == null) || (paramAIOImageData == null) || (paramFile == null)) {}
    label188:
    do
    {
      do
      {
        do
        {
          return false;
          if (!paramString.equals(this.mContext.getResources().getString(2131694752))) {
            break;
          }
        } while ((paramAIOImageData.EP != 1) && (paramAIOImageData.EP != 2));
        paramString = (StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ);
        b(paramString);
        a(paramAIOImageData, paramString);
        return true;
        if (!paramString.equals(this.mContext.getResources().getString(2131694750))) {
          break;
        }
        if (paramAIOImageData.EP == 1)
        {
          paramString = (StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ);
          paramAIOImageData = a(paramString);
          if ((paramAIOImageData != null) && (paramAIOImageData.length >= 8))
          {
            bool1 = bool2;
            if (!paramAIOImageData[7].equals("link")) {
              if (!paramAIOImageData[7].equals("scrawl_link")) {
                break label188;
              }
            }
          }
          for (boolean bool1 = bool2;; bool1 = false)
          {
            a(bool1, paramAIOImageData, paramString, paramFile);
            return bool1;
          }
        }
      } while (paramAIOImageData.EP != 2);
      paramString = (StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ);
      paramAIOImageData = j(paramString.mMsgActionData);
    } while ((paramAIOImageData == null) || (paramAIOImageData.length <= 2));
    a(paramAIOImageData, paramString);
    for (;;)
    {
      return true;
      if (paramString.equals(this.mContext.getResources().getString(2131694748)))
      {
        if (paramAIOImageData.EP != 1) {
          break;
        }
        b((StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ), "6");
        return true;
      }
      if (paramString.equals(this.mContext.getResources().getString(2131694747)))
      {
        if (paramAIOImageData.EP != 1) {
          break;
        }
        a((StructMsgForImageShare)anre.a((byte[])paramAIOImageData.bQ), "6");
        return true;
      }
      if ((!paramString.equals(this.mContext.getResources().getString(2131694744))) || (paramAIOImageData.EP != 2)) {
        break;
      }
      e(paramAIOImageData);
    }
  }
  
  public xuf b()
  {
    return this.jdField_d_of_type_Xuf;
  }
  
  protected void b(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    Object localObject2;
    Object localObject1;
    URLDrawable localURLDrawable;
    label66:
    do
    {
      return;
      localObject2 = paramStructMsgForImageShare.getFirstImageElement();
      if (localObject2 == null) {
        break label369;
      }
      if (((ansu)localObject2).d == null) {
        ((ansu)localObject2).d = paramStructMsgForImageShare;
      }
      localObject1 = ((ansu)localObject2).a();
      localURLDrawable = ForwardUtils.a(this.mContext, (MessageForPic)localObject1);
      if (!new File(((MessageForPic)localObject1).path).exists()) {
        break;
      }
      ((ansu)localObject2).cij = ((MessageForPic)localObject1).path;
      if (!TextUtils.isEmpty(((ansu)localObject2).cij)) {
        break label173;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
    return;
    String str = localURLDrawable.getURL().toString();
    if (aoiz.hasFile(str))
    {
      localObject1 = aoiz.getFile(str);
      if (localObject1 == null) {
        break label419;
      }
      localObject1 = ((File)localObject1).getAbsolutePath();
    }
    for (;;)
    {
      ((ansu)localObject2).cij = ((String)localObject1);
      break label66;
      localObject1 = aoop.a((akxw)localObject1, 65537);
      if (localObject1 != null)
      {
        localObject1 = aoiz.getFile(((URL)localObject1).toString());
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          continue;
          label173:
          if (!aoiz.hasFile(localURLDrawable.getURL().toString())) {
            localURLDrawable.startDownload();
          }
          localObject1 = new Bundle();
          if ((paramStructMsgForImageShare.source_puin != null) && (!"".equals(paramStructMsgForImageShare.source_puin))) {
            ((Bundle)localObject1).putString("source_puin", paramStructMsgForImageShare.source_puin);
          }
          ((Bundle)localObject1).putInt("forward_type", -3);
          paramStructMsgForImageShare.mCommentText = null;
          ((Bundle)localObject1).putInt("structmsg_service_id", paramStructMsgForImageShare.mMsgServiceID);
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramStructMsgForImageShare.getBytes());
          localObject2 = new Intent();
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          ahgq.f(this.mContext, (Intent)localObject2, 0);
          localObject1 = a(paramStructMsgForImageShare);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break;
          }
          if (localObject1.length >= 8) {
            if (localObject1[7].equals("link")) {
              paramStructMsgForImageShare = localObject1[4];
            }
          }
          for (;;)
          {
            avdb.a(null, this.aWf, this.mContext, "100008", "2", "40058", localObject1[0], new String[] { "1", "", paramStructMsgForImageShare });
            return;
            label369:
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
            return;
            if ((localObject1[7].equals("scrawl_link")) && (localObject1.length >= 9)) {
              paramStructMsgForImageShare = localObject1[8];
            } else {
              paramStructMsgForImageShare = "";
            }
          }
        }
      }
      label419:
      localObject1 = null;
    }
  }
  
  protected void b(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {}
    for (;;)
    {
      return;
      paramStructMsgForImageShare = new Intent(this.mContext, JumpActivity.class);
      JSONObject localJSONObject = new JSONObject();
      String str = VipComicJumpActivity.c("comicDetailComic", null, null, "1", "354", null, "ADTAG=comic.plugin.fav&pos=aio&id=" + arrayOfString[0]);
      try
      {
        localJSONObject.put("from", "13");
        localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicTabBrowserActivity");
        localJSONObject.put("url", URLEncoder.encode(str));
        localJSONObject.put("leftViewText", acfp.m(2131702216));
        paramStructMsgForImageShare.setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
        this.mContext.startActivity(paramStructMsgForImageShare);
        if (arrayOfString.length >= 8)
        {
          if (arrayOfString[7].equals("link")) {}
          for (paramStructMsgForImageShare = arrayOfString[4]; "5".equals(paramString); paramStructMsgForImageShare = arrayOfString[8])
          {
            avdb.a(null, this.aWf, this.mContext, "100008", "2", "40055", arrayOfString[0], new String[] { "", "", paramStructMsgForImageShare });
            return;
            if ((!arrayOfString[7].equals("scrawl_link")) || (arrayOfString.length < 9)) {
              break label334;
            }
          }
          if (!"6".equals(paramString)) {
            continue;
          }
          avdb.a(null, this.aWf, this.mContext, "100008", "2", "40058", arrayOfString[0], new String[] { "3", "", paramStructMsgForImageShare });
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label334:
          paramStructMsgForImageShare = "";
        }
      }
    }
  }
  
  boolean b(xuf paramxuf)
  {
    if (paramxuf == null) {
      return false;
    }
    if ((this.jdField_d_of_type_Xuf != null) && (this.jdField_d_of_type_Xuf.e.id == paramxuf.e.id) && (this.jdField_d_of_type_Xuf.e.subId == paramxuf.e.subId)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      this.jdField_d_of_type_Xuf = paramxuf;
      boolean bool2;
      AIOImageData localAIOImageData;
      if ((this.k.getVisibility() != 4) || (this.xc.getVisibility() != 4))
      {
        bool2 = true;
        if (AIOImageData.class.isInstance(paramxuf.e))
        {
          localAIOImageData = (AIOImageData)paramxuf.e;
          if (localAIOImageData.EP != 1) {
            break label160;
          }
          a(paramxuf, localAIOImageData, bool2);
        }
        label123:
        if ((!a(this.mContext, this.mRoot)) || (!this.bjb)) {
          break label229;
        }
        this.ec.setVisibility(0);
      }
      for (;;)
      {
        return true;
        bool2 = false;
        break;
        label160:
        if (localAIOImageData.EP == 2)
        {
          a(localAIOImageData, bool1, bool2);
          break label123;
        }
        if (localAIOImageData.EP == 5)
        {
          ahtr.a(this.Kq, this.mContext, localAIOImageData, this);
          break label123;
        }
        if (!bool2) {
          break label123;
        }
        this.xc.setVisibility(4);
        this.k.setVisibility(0);
        break label123;
        label229:
        if (this.ec != null) {
          this.ec.setVisibility(4);
        }
      }
    }
  }
  
  protected void c(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {
      return;
    }
    int i = 1;
    paramString = new JSONObject();
    paramStructMsgForImageShare = new JSONObject();
    try
    {
      paramStructMsgForImageShare.put("comicID", arrayOfString[0]);
      paramStructMsgForImageShare.put("comicSectionID", arrayOfString[2]);
      paramStructMsgForImageShare.put("comicPageID", arrayOfString[4]);
      paramStructMsgForImageShare.put("type", arrayOfString[6]);
      paramString.put("jumpto", "com.qqcomic.activity.reader.VipComicPortraitReadingActivity");
      paramString.put("comic", paramStructMsgForImageShare);
      paramString.put("from", "13");
      if (i != 0)
      {
        paramStructMsgForImageShare = new Intent(this.mContext, VipComicJumpActivity.class);
        paramStructMsgForImageShare.putExtra("options", paramString.toString());
        this.mContext.startActivity(paramStructMsgForImageShare);
        paramString = "";
        if (arrayOfString.length < 8) {
          break label381;
        }
        paramStructMsgForImageShare = arrayOfString[4];
        if (!arrayOfString[7].equals("link")) {
          break label347;
        }
        paramString = arrayOfString[4];
        avdb.a(null, this.aWf, this.mContext, "100008", "2", "40056", arrayOfString[0], new String[] { "", paramStructMsgForImageShare, paramString });
      }
    }
    catch (Exception paramStructMsgForImageShare)
    {
      for (;;)
      {
        i = 0;
        continue;
        paramString = "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html?_wv=5123&_bid=354&_cfrom=13&action=read&actionType=keepread&id=" + arrayOfString[0] + "&name=" + URLEncoder.encode(arrayOfString[1]) + "&sectionID=" + arrayOfString[2] + "&pageID=" + arrayOfString[4] + "&pageOffset=0&type=" + arrayOfString[6];
        paramStructMsgForImageShare = new Intent(this.mContext, QQBrowserActivity.class);
        paramStructMsgForImageShare.putExtra("url", paramString);
        continue;
        label347:
        paramString = paramStructMsgForImageShare;
        if (arrayOfString[7].equals("scrawl_link"))
        {
          paramString = paramStructMsgForImageShare;
          if (arrayOfString.length >= 9)
          {
            paramString = arrayOfString[8];
            continue;
          }
        }
        label381:
        paramStructMsgForImageShare = paramString;
        paramString = "";
      }
    }
  }
  
  public void exitAnimation()
  {
    if (this.jdField_a_of_type_ComTencentWidgetDragView.mFinishAnimation)
    {
      this.jdField_a_of_type_Sxz.a().onExitAnimationEnd();
      return;
    }
    super.exitAnimation();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 19002)
    {
      if (paramInt2 == -1) {
        this.mContext.setResult(-1, paramIntent);
      }
      this.mContext.finish();
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 19000) {
            break;
          }
        } while (paramInt2 != -1);
        return;
        if (paramInt1 != 19005) {
          break;
        }
      } while (paramInt2 != -1);
      return;
    } while (paramInt1 == 103);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    this.bgView.setAlpha(paramFloat);
    if (paramFloat < 0.8F)
    {
      this.jdField_a_of_type_Xsk$b.biZ = true;
      updateUI();
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
    if ((Build.VERSION.SDK_INT >= 21) && (!aafz.isEMUI3_1()))
    {
      this.mContext.getWindow().clearFlags(67108864);
      this.mContext.getWindow().addFlags(-2147483648);
      this.mContext.getWindow().setStatusBarColor(0);
      this.mContext.getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    paramViewGroup = (RelativeLayout)getRootView();
    this.xc = LayoutInflater.from(this.mContext).inflate(2131563318, null);
    this.xc.setClickable(true);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 72.0F, this.mContext.getResources().getDisplayMetrics()));
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    paramViewGroup.addView(this.xc, (ViewGroup.LayoutParams)localObject);
    this.dZ = ((Button)this.xc.findViewById(2131382008));
    this.dZ.setVisibility(8);
    this.ea = ((Button)this.xc.findViewById(2131382009));
    this.ea.setVisibility(8);
    this.eb = ((Button)this.xc.findViewById(2131382006));
    this.Kp = ((TextView)this.xc.findViewById(2131382010));
    this.br = new HashSet();
    localObject = new xtk(this);
    this.dZ.setOnClickListener((View.OnClickListener)localObject);
    this.ea.setOnClickListener((View.OnClickListener)localObject);
    this.eb.setOnClickListener((View.OnClickListener)localObject);
    this.xc.setVisibility(4);
    this.Kq = ahtr.a(this.mContext, paramViewGroup);
    this.Kq.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.mRoot.findViewById(2131366139));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_b_of_type_Xto.f.getThumbRect());
  }
  
  public void onGestureFinish()
  {
    String str;
    if ((this.jdField_b_of_type_Xto.f.e instanceof AIOImageData)) {
      str = "0X8009AB2";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        anot.a(null, "dc00898", "", "", str, str, this.bWR, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Sxz.a() == null)
      {
        this.mContext.finish();
        return;
        if ((this.jdField_b_of_type_Xto.f.e instanceof AIOShortVideoData)) {
          str = "0X8009AB3";
        }
      }
      else
      {
        this.jdField_a_of_type_Sxz.bBV();
        return;
      }
      str = null;
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if (this.jdField_a_of_type_Sxz.a() != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_b_of_type_Xto.f.thubmRect);
    }
    while ((this.jdField_b_of_type_Xto.f.e instanceof AIOShortVideoData))
    {
      this.jdField_b_of_type_ComTencentWidgetGallery.enableScaleGesture(false);
      this.jdField_b_of_type_ComTencentWidgetGallery.enableDoubleTap(false);
      return;
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_b_of_type_Xto.f.bn);
    }
    this.jdField_b_of_type_ComTencentWidgetGallery.enableScaleGesture(true);
    this.jdField_b_of_type_ComTencentWidgetGallery.enableDoubleTap(true);
  }
  
  public void onResetPosition()
  {
    if (this.bWR == 4) {
      return;
    }
    this.jdField_a_of_type_Xsk$b.biZ = false;
    updateUI();
  }
  
  public void onResume()
  {
    super.onResume();
    btB();
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentWidgetDragView.init();
    this.bgView.setAlpha(1.0F);
    this.jdField_a_of_type_Xsk$b = new xsk.b(this);
  }
  
  protected void updateUI()
  {
    super.updateUI();
    if ((this.jdField_a_of_type_Xsk$b.scrolling) || (this.jdField_a_of_type_Xsk$b.biY) || (this.jdField_a_of_type_Xsk$b.biZ) || (this.jdField_a_of_type_Xsk$b.bja))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
      }
      this.Kq.setVisibility(4);
    }
    while ((this.jdField_b_of_type_Xto == null) || (this.jdField_b_of_type_Xto.c() == null) || (!(this.jdField_b_of_type_Xto.c().e instanceof AIOImageData)) || (((AIOImageData)this.jdField_b_of_type_Xto.c().e).EP != 5)) {
      return;
    }
    this.Kq.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtj
 * JD-Core Version:    0.7.0.1
 */