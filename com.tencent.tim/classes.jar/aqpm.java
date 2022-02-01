import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vas.ColorNickManager.2;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText.a;
import com.tencent.mobileqq.widget.ColorClearableEditText.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class aqpm
  implements Manager
{
  private static aqpm.a a;
  public static final String cuR = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".CorlorNick/");
  public static AtomicBoolean en = new AtomicBoolean(false);
  private Vector<Integer> M = new Vector();
  public aqpm.d a;
  private afko b = new aqpo(this);
  public Handler dK;
  private VasQuickUpdateManager.CallBacker i = new aqpp(this);
  public ConcurrentHashMap<Integer, aqpm.c> jd = new ConcurrentHashMap();
  private QQAppInterface mApp;
  
  static
  {
    jdField_a_of_type_Aqpm$a = new aqpm.a(null);
  }
  
  public aqpm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aqpm$d = new aqpm.d();
  }
  
  public static String D(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject).mergeFrom(paramArrayOfByte);
      if (((Oidb_0x8fc.CommCardNameBuf)localObject).rpt_rich_card_name.has())
      {
        paramArrayOfByte = new StringBuilder();
        localObject = ((Oidb_0x8fc.CommCardNameBuf)localObject).rpt_rich_card_name.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Oidb_0x8fc.RichCardNameElem localRichCardNameElem = (Oidb_0x8fc.RichCardNameElem)((Iterator)localObject).next();
          if (localRichCardNameElem.bytes_ctrl.has()) {
            paramArrayOfByte.append("<").append(localRichCardNameElem.bytes_ctrl.get().toStringUtf8()).append(">");
          } else if (localRichCardNameElem.bytes_text.has()) {
            paramArrayOfByte.append(localRichCardNameElem.bytes_text.get().toStringUtf8());
          }
        }
        paramArrayOfByte = paramArrayOfByte.toString();
        return paramArrayOfByte;
      }
      return null;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  private void XK(int paramInt)
  {
    if (this.M.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "downloadGradientConfig id = " + paramInt + " is downloading");
      }
      return;
    }
    this.M.add(Integer.valueOf(paramInt));
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.mApp.getManager(184);
    localVasQuickUpdateManager.addCallBacker(this.i);
    localVasQuickUpdateManager.downloadItem(27L, "groupnickitem." + paramInt, "ColorNickManager");
  }
  
  public static int a(List<ColorClearableEditText.a> paramList, Paint paramPaint, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramList = paramList.iterator();
    int j = 0;
    if (paramList.hasNext())
    {
      ColorClearableEditText.a locala = (ColorClearableEditText.a)paramList.next();
      switch (locala.type)
      {
      }
      for (;;)
      {
        break;
        int k = (int)Math.ceil(paramPaint.measureText(locala.text));
        paramPaint.getTextBounds(locala.text, 0, locala.text.length(), localRect);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.height());
        j += k;
        continue;
        j += ((aofk.a)locala.a).getDrawable().getBounds().width();
        paramRect.bottom = Math.max(paramRect.bottom, ((aofk.a)locala.a).getDrawable().getBounds().height());
      }
    }
    paramRect.left = 0;
    paramRect.right = j;
    paramRect.top = 0;
    return j;
  }
  
  private aqpm.c a(File paramFile, int paramInt)
  {
    int j = 0;
    paramFile = aqhq.b(paramFile, -1);
    try
    {
      paramFile = new JSONObject(paramFile);
      aqpm.c localc = new aqpm.c();
      paramFile = paramFile.optJSONArray("baseInfo");
      if ((paramFile != null) && (paramFile.length() > 0))
      {
        Object localObject = paramFile.getJSONObject(0);
        localc.type = ((JSONObject)localObject).optInt("type");
        if (localc.type == 5)
        {
          localObject = cuR + paramInt + File.separator + "shaderImg.png";
          paramFile = localc;
          if (!new File((String)localObject).exists()) {
            return paramFile;
          }
          localc.gB = aqhu.d((String)localObject, null);
          return localc;
        }
        localc.orientation = ((JSONObject)localObject).optInt("orientation");
        paramFile = ((JSONObject)localObject).optJSONArray("colors");
        if ((paramFile != null) && (paramFile.length() > 0))
        {
          localc.colors = new int[paramFile.length()];
          paramInt = 0;
          while (paramInt < paramFile.length())
          {
            String str = paramFile.getString(paramInt);
            localc.colors[paramInt] = Color.parseColor(str);
            paramInt += 1;
          }
        }
        if ((localc.type != 1) && (localc.type != 2))
        {
          paramFile = localc;
          if (localc.type != 3) {
            return paramFile;
          }
        }
        localObject = ((JSONObject)localObject).optJSONArray("positions");
        paramFile = localc;
        if (localObject == null) {
          return paramFile;
        }
        paramFile = localc;
        if (((JSONArray)localObject).length() <= 0) {
          return paramFile;
        }
        localc.positions = new float[((JSONArray)localObject).length()];
        paramInt = j;
        for (;;)
        {
          paramFile = localc;
          if (paramInt >= ((JSONArray)localObject).length()) {
            break;
          }
          paramFile = ((JSONArray)localObject).getString(paramInt);
          if (TextUtils.isDigitsOnly(paramFile))
          {
            j = Integer.parseInt(paramFile);
            localc.positions[paramInt] = (j / 100.0F);
          }
          paramInt += 1;
        }
      }
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.e("ColorNick", 1, "loadGradientConfig error: ", paramFile);
      paramFile = null;
    }
  }
  
  public static aqpm a(QQAppInterface paramQQAppInterface)
  {
    return ((aqrc)paramQQAppInterface.getManager(235)).a;
  }
  
  public static CharSequence a(MessageRecord paramMessageRecord, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    Object localObject;
    if ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      localSpannableString = null;
      if (TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label218;
      }
      String str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
        {
          if (paramMsgSummary.strContent.length() <= paramMsgSummary.strPrefix.length() + 2) {
            break label211;
          }
          localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new aofe(paramMsgSummary.strPrefix, 16).k();
      }
      paramMessageRecord = a((String)localObject, paramMessageRecord, 16, 5);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessageRecord);
      paramMsgSummary.strContent = new aofk((CharSequence)localObject, 5, 16);
      return paramMsgSummary.strContent;
      label211:
      localObject = "";
      continue;
      label218:
      localObject = paramMsgSummary.suffix.toString();
    }
  }
  
  public static CharSequence a(String paramString, MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    String str;
    if (paramMessageRecord != null)
    {
      str = paramMessageRecord.getExtInfoFromExtStr(anbb.ccR);
      if (!(paramMessageRecord instanceof MessageForReplyText)) {
        break label71;
      }
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
      if (localMessageForReplyText.mSourceMsgInfo == null) {
        break label71;
      }
      str = appe.k(localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin, str);
    }
    label71:
    for (;;)
    {
      return a(paramString, str, paramInt1, paramMessageRecord, paramInt2);
      return new aofk(paramString, paramInt2, paramInt1, paramMessageRecord);
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    int m = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = MessageForText.getTroopMemberInfoFromExtrJson(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        Object localObject = new ArrayList();
        int j = 0;
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
        int k;
        while (j < paramString2.size())
        {
          localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramString2.get(j);
          if ((localAtTroopMemberInfo.startPos < 0) || (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length()))
          {
            j += 1;
          }
          else
          {
            aqpm.b localb = new aqpm.b(null);
            localb.start = localAtTroopMemberInfo.startPos;
            if (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length()) {}
            for (k = paramString1.length();; k = localAtTroopMemberInfo.textLen + k)
            {
              localb.end = k;
              localb.b = new aofe(paramString1.subSequence(localb.start, localb.end), paramInt1).k();
              ((ArrayList)localObject).add(localb);
              break;
              k = localAtTroopMemberInfo.startPos;
            }
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          paramString2 = (aqpm.b[])((ArrayList)localObject).toArray(new aqpm.b[((ArrayList)localObject).size()]);
          Arrays.sort(paramString2, jdField_a_of_type_Aqpm$a);
          localObject = new SpannableStringBuilder();
          int n = paramString2.length;
          k = 0;
          j = m;
          if (j < n)
          {
            localAtTroopMemberInfo = paramString2[j];
            if (localAtTroopMemberInfo.start >= k) {
              ((SpannableStringBuilder)localObject).append(new aofk(paramString1.subSequence(k, localAtTroopMemberInfo.end), paramInt2, paramInt1, paramMessageRecord));
            }
            for (;;)
            {
              k = localAtTroopMemberInfo.end;
              j += 1;
              break;
              ((SpannableStringBuilder)localObject).append(localAtTroopMemberInfo.b);
            }
          }
          if (k < paramString1.length()) {
            ((SpannableStringBuilder)localObject).append(new aofk(paramString1.subSequence(k, paramString1.length()), paramInt2, paramInt1, paramMessageRecord));
          }
          return localObject;
        }
      }
    }
    return new aofk(paramString1, paramInt2, paramInt1, paramMessageRecord);
  }
  
  public static String a(aqpk.a parama)
  {
    int k = 0;
    char[] arrayOfChar = new char[7];
    arrayOfChar[0] = '<';
    arrayOfChar[1] = '%';
    arrayOfChar[2] = ((char)(parama.value >>> 24 & 0xFF));
    arrayOfChar[3] = ((char)(parama.value >>> 16 & 0xFF));
    arrayOfChar[4] = ((char)(parama.value >>> 8 & 0xFF));
    arrayOfChar[5] = ((char)(parama.value & 0xFF));
    arrayOfChar[6] = '>';
    int j = k;
    switch (parama.type)
    {
    default: 
      j = k;
    }
    while (j < arrayOfChar.length)
    {
      if (arrayOfChar[j] == 0) {
        arrayOfChar[j] = 'Ā';
      }
      j += 1;
      continue;
      if (parama.value == 0) {
        return "";
      }
      arrayOfChar[1] = '&';
      j = k;
    }
    return new String(arrayOfChar);
  }
  
  public static List<ColorClearableEditText.a> a(int paramInt1, String paramString, Paint paramPaint, ColorClearableEditText.b paramb, int paramInt2)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ColorClearableEditText.a((List)localObject, paramb, new aofe(paramString, paramInt2).k());
    int j = (int)Math.ceil(paramPaint.measureText("..."));
    paramString = ((ArrayList)localObject).iterator();
    paramInt2 = 0;
    if (paramString.hasNext())
    {
      paramb = (ColorClearableEditText.a)paramString.next();
      switch (paramb.type)
      {
      }
      for (;;)
      {
        break;
        localObject = anyk.a(paramInt1 - paramInt2, paramb.text, paramPaint);
        int k;
        if (((String)localObject).equals(paramb.text))
        {
          k = (int)Math.ceil(paramPaint.measureText(paramb.text));
          localArrayList.add(paramb);
          paramInt2 += k;
        }
        else
        {
          paramb.text = ((String)localObject);
          localArrayList.add(paramb);
          return localArrayList;
          k = ((aofk.a)paramb.a).getDrawable().getBounds().width();
          if (k > paramInt1 - paramInt2 - j)
          {
            localArrayList.add(new ColorClearableEditText.a(1, paramb.start, paramb.end, "...", null));
            return localArrayList;
          }
          localArrayList.add(paramb);
          paramInt2 += k;
          continue;
          localArrayList.add(paramb);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(afqh paramafqh, QQAppInterface paramQQAppInterface, EditText paramEditText)
  {
    if (paramafqh.e == null)
    {
      aqrm.b("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int j = Integer.parseInt(paramafqh.e.eId);
      int k = Integer.parseInt(paramafqh.e.epId);
      ((ajdg)paramQQAppInterface.getManager(14)).a(String.valueOf(k), new aqpn(k, j, paramEditText));
      return;
    }
    catch (NumberFormatException paramafqh)
    {
      aqrm.b("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, Spannable paramSpannable)
  {
    anlm.ayn();
  }
  
  public static void a(DraftTextInfo paramDraftTextInfo, XEditTextEx paramXEditTextEx, String paramString1, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString2)
  {
    if ((paramDraftTextInfo != null) && (!TextUtils.isEmpty(paramDraftTextInfo.mAtInfoStr)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramDraftTextInfo = MessageForText.getTroopMemberInfoFromExtrJson(paramDraftTextInfo.mAtInfoStr);
      if (paramDraftTextInfo != null)
      {
        paramDraftTextInfo = paramDraftTextInfo.iterator();
        while (paramDraftTextInfo.hasNext())
        {
          MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramDraftTextInfo.next();
          if ((localAtTroopMemberInfo.startPos <= paramXEditTextEx.getEditableText().length()) && (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1 <= paramXEditTextEx.getEditableText().length()))
          {
            SpannableString localSpannableString = appb.a(paramQQAppInterface, paramBaseActivity, paramString2, Long.toString(localAtTroopMemberInfo.uin), paramString1.substring(localAtTroopMemberInfo.startPos + 1, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen), false, paramXEditTextEx, true);
            if (localSpannableString != null) {
              paramXEditTextEx.getEditableText().replace(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1, localSpannableString);
            }
          }
        }
      }
    }
  }
  
  public static String f(ByteStringMicro paramByteStringMicro)
  {
    String str2 = D(paramByteStringMicro.toByteArray());
    String str1 = str2;
    if (str2 == null) {
      str1 = paramByteStringMicro.toStringUtf8();
    }
    return str1;
  }
  
  public static String pP(String paramString)
  {
    return cuR + paramString + File.separator + "xydata.json";
  }
  
  public static String pQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    if (j < paramString.length())
    {
      if (paramString.charAt(j) == '<')
      {
        int k = paramString.indexOf('>', j);
        if (k > 0) {
          j = k;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(paramString.charAt(j));
      }
    }
    return localStringBuilder.toString();
  }
  
  void XJ(int paramInt)
  {
    ThreadManagerV2.excute(new ColorNickManager.2(this, paramInt), 64, null, true);
  }
  
  public Shader a(int paramInt1, List<ColorClearableEditText.a> paramList, float paramFloat1, float paramFloat2, Rect paramRect, Paint paramPaint, int paramInt2, int paramInt3)
  {
    aqpm.c localc = a(paramInt1);
    if (localc != null) {}
    float f1;
    float f2;
    label90:
    label108:
    Object localObject1;
    label177:
    label184:
    label200:
    Object localObject2;
    float f4;
    Object localObject3;
    ColorClearableEditText.a locala;
    switch (localc.type)
    {
    default: 
      return null;
    case 1: 
      if (localc.orientation == 1)
      {
        f1 = paramFloat1;
        if (localc.orientation != 1) {
          break label177;
        }
        f2 = paramFloat2 + paramRect.height() * 0.5F;
        if (localc.orientation != 1) {
          break label184;
        }
        paramFloat1 += paramRect.width();
        if (localc.orientation != 1) {
          break label200;
        }
      }
      for (paramFloat2 += paramRect.height() * 0.5F;; paramFloat2 += paramRect.height())
      {
        return new LinearGradient(f1, f2, paramFloat1, paramFloat2, localc.colors, localc.positions, Shader.TileMode.CLAMP);
        f1 = paramFloat1 + paramRect.width() * 0.5F;
        break;
        f2 = paramFloat2;
        break label90;
        paramFloat1 += paramRect.width() * 0.5F;
        break label108;
      }
    case 2: 
      localObject1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      f4 = paramFloat2 + paramRect.height();
      paramRect = new Paint(paramPaint);
      paramInt1 = 0;
      localObject3 = new Rect();
      paramInt2 = 0;
      while (paramInt2 < paramList.size())
      {
        locala = (ColorClearableEditText.a)paramList.get(paramInt2);
        switch (locala.type)
        {
        default: 
          paramInt2 += 1;
          break;
        case 1: 
          label324:
          if (paramInt1 != 0) {
            break label1053;
          }
          paramPaint.getTextBounds(locala.text, 0, locala.text.length(), (Rect)localObject3);
          paramInt1 = ((Rect)localObject3).height();
        }
      }
    }
    label410:
    label1053:
    for (;;)
    {
      paramInt3 = 0;
      if (paramInt3 < locala.text.length())
      {
        float f5 = paramPaint.measureText(locala.text, paramInt3, paramInt3 + 1);
        if (localc.orientation == 1)
        {
          paramFloat2 = paramFloat1;
          if (localc.orientation != 1) {
            break label559;
          }
          f1 = paramInt1 * 0.5F + f4 - paramInt1;
          label433:
          if (localc.orientation != 1) {
            break label569;
          }
          f2 = paramFloat1 + f5;
          label448:
          if (localc.orientation != 1) {
            break label582;
          }
        }
        label559:
        label569:
        label582:
        for (float f3 = paramInt1 * 0.5F + f4 - paramInt1;; f3 = paramInt1)
        {
          paramRect.setShader(new LinearGradient(paramFloat2, f1, f2, f3, localc.colors, localc.positions, Shader.TileMode.CLAMP));
          paramRect.setStyle(Paint.Style.FILL);
          ((Canvas)localObject2).drawRect(paramFloat1, f4 - paramInt1, paramFloat1 + f5, f4, paramRect);
          paramFloat1 += f5;
          paramInt3 += 1;
          break;
          paramFloat2 = paramFloat1 + 0.5F * f5;
          break label410;
          f1 = f4 - paramInt1;
          break label433;
          f2 = paramFloat1 + 0.5F * f5;
          break label448;
        }
      }
      break label324;
      paramFloat1 += ((aofk.a)locala.a).getDrawable().getBounds().width();
      break label324;
      return new BitmapShader((Bitmap)localObject1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return new RadialGradient(paramRect.width() / 2 + paramFloat1, paramRect.height() / 2 + paramFloat2, paramRect.width() / 2, localc.colors, localc.positions, Shader.TileMode.CLAMP);
      paramRect = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      localObject1 = new Canvas(paramRect);
      localObject2 = new Paint(paramPaint);
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt2 < paramList.size())
      {
        localObject3 = (ColorClearableEditText.a)paramList.get(paramInt2);
        switch (((ColorClearableEditText.a)localObject3).type)
        {
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          int j = 0;
          while (j < ((ColorClearableEditText.a)localObject3).text.length())
          {
            paramFloat2 = paramPaint.measureText(((ColorClearableEditText.a)localObject3).text, j, j + 1);
            ((Paint)localObject2).setColor(localc.colors[(paramInt1 % localc.colors.length)]);
            ((Paint)localObject2).setStyle(Paint.Style.FILL);
            ((Canvas)localObject1).drawRect(paramFloat1, 0.0F, paramFloat1 + paramFloat2, paramInt3, (Paint)localObject2);
            j += 1;
            paramInt1 += 1;
            paramFloat1 += paramFloat2;
          }
          continue;
          paramFloat1 += ((aofk.a)((ColorClearableEditText.a)localObject3).a).getDrawable().getBounds().width();
        }
      }
      return new BitmapShader(paramRect, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      if (localc.gB == null) {
        break;
      }
      paramList = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      localObject1 = new Canvas(paramList);
      paramInt1 = localc.gB.getWidth();
      localObject2 = new Rect();
      localObject3 = new Rect(0, 0, paramInt1, localc.gB.getHeight());
      for (paramFloat1 = 0.0F; paramFloat1 < paramRect.width(); paramFloat1 += paramInt1)
      {
        ((Rect)localObject2).set((int)paramFloat1, 0, (int)(paramInt1 + paramFloat1), paramInt3);
        ((Canvas)localObject1).drawBitmap(localc.gB, (Rect)localObject3, (Rect)localObject2, paramPaint);
      }
      return new BitmapShader(paramList, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }
  }
  
  public aqpm.c a(int paramInt)
  {
    if (this.jd.containsKey(Integer.valueOf(paramInt))) {
      return (aqpm.c)this.jd.get(Integer.valueOf(paramInt));
    }
    XJ(paramInt);
    return null;
  }
  
  public void onDestroy() {}
  
  static class a
    implements Comparator<aqpm.b>
  {
    public int a(aqpm.b paramb1, aqpm.b paramb2)
    {
      int i = 1;
      if (paramb1.start == paramb2.start) {
        if (paramb1.end == paramb2.end) {
          i = 0;
        }
      }
      while (paramb1.start > paramb2.start)
      {
        do
        {
          return i;
        } while (paramb1.end > paramb2.end);
        return -1;
      }
      return -1;
    }
  }
  
  static class b
  {
    SpannableString b;
    int end;
    int start;
  }
  
  public static class c
  {
    public int[] colors;
    public Bitmap gB;
    public int orientation;
    public float[] positions;
    public int type;
  }
  
  public class d
    implements afmk
  {
    private ArrayList<Integer> CS = new ArrayList();
    
    public d() {}
    
    public List<afoo> c(boolean paramBoolean1, boolean paramBoolean2)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new afoo(7, 7, null));
      ajdg localajdg = (ajdg)aqpm.a(aqpm.this).getManager(14);
      Iterator localIterator = this.CS.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        EmoticonPackage localEmoticonPackage = localajdg.b(String.valueOf(i));
        if (localEmoticonPackage != null)
        {
          localArrayList.add(new afoo(10, 7, localEmoticonPackage));
        }
        else
        {
          localEmoticonPackage = new EmoticonPackage();
          localEmoticonPackage.epId = String.valueOf(i);
          localEmoticonPackage.wordingId = -1L;
          localEmoticonPackage.jobType = 4;
          localEmoticonPackage.isMagicFaceDownloading = false;
          localEmoticonPackage.valid = true;
          localEmoticonPackage.status = 0;
          localEmoticonPackage.aio = true;
          localajdg.m(localEmoticonPackage);
          afkd.a().a(aqpm.a(aqpm.this));
          ((afke)aqpm.a(aqpm.this).getManager(43)).a(String.valueOf(i), afke.cRu, null, true, 0);
        }
      }
      return localArrayList;
    }
    
    public void nb(List<Integer> paramList)
    {
      if (paramList != null) {
        this.CS = new ArrayList(paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpm
 * JD-Core Version:    0.7.0.1
 */